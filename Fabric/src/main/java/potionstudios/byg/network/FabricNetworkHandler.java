package potionstudios.byg.network;

import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import potionstudios.byg.BYG;
import potionstudios.byg.network.packet.ConstructBYGPlayerTrackedDataPacket;
import potionstudios.byg.network.packet.DiscoveredBiomesPacket;
import potionstudios.byg.network.packet.SaplingPatternsPacket;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class FabricNetworkHandler {

    private static final String PACKET_LOCATION = BYG.MOD_ID;

    private static final Map<Class<?>, BiConsumer<?, FriendlyByteBuf>> ENCODERS = new ConcurrentHashMap<>();
    private static final Map<Class<?>, ResourceLocation> PACKET_IDS = new ConcurrentHashMap<>();

    public static void init() {
        BYG.LOGGER.info("Initializing BYG network...");
        registerMessage("sapling_patterns", SaplingPatternsPacket.class, SaplingPatternsPacket::write, SaplingPatternsPacket::read, SaplingPatternsPacket::handle);
        registerMessage("discovered_biomes", DiscoveredBiomesPacket.class, DiscoveredBiomesPacket::write, DiscoveredBiomesPacket::read, DiscoveredBiomesPacket::handle);
        registerMessage("construct_byg_player_tracked_data", ConstructBYGPlayerTrackedDataPacket.class, ConstructBYGPlayerTrackedDataPacket::write, ConstructBYGPlayerTrackedDataPacket::read, ConstructBYGPlayerTrackedDataPacket::handle);
        BYG.LOGGER.info("Initialized BYG network!");
    }

    private static <T> void registerMessage(String id, Class<T> clazz,
                                            BiConsumer<T, FriendlyByteBuf> encode,
                                            Function<FriendlyByteBuf, T> decode,
                                            BiConsumer<T, Level> handler) {
        ENCODERS.put(clazz, encode);
        PACKET_IDS.put(clazz, new ResourceLocation(PACKET_LOCATION, id));


        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            ClientProxy.registerClientReceiver(id, decode, handler);
        }
    }

    public static <MSG> void sendToPlayer(ServerPlayer player, MSG packet) {
        ResourceLocation packetId = PACKET_IDS.get(packet.getClass());
        @SuppressWarnings("unchecked")
        BiConsumer<MSG, FriendlyByteBuf> encoder = (BiConsumer<MSG, FriendlyByteBuf>) ENCODERS.get(packet.getClass());
        FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
        encoder.accept(packet, buf);
        ServerPlayNetworking.send(player, packetId, buf);
    }

    public static <MSG> void sendToAllPlayers(List<ServerPlayer> players, MSG packet) {
        ResourceLocation packetId = PACKET_IDS.get(packet.getClass());
        @SuppressWarnings("unchecked")
        BiConsumer<MSG, FriendlyByteBuf> encoder = (BiConsumer<MSG, FriendlyByteBuf>) ENCODERS.get(packet.getClass());
        FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
        encoder.accept(packet, buf);

        players.forEach(player -> {
            ServerPlayNetworking.send(player, packetId, buf);
        });
    }

    public static class ClientProxy {

        public static <T> void registerClientReceiver(String id, Function<FriendlyByteBuf, T> decode,
                                                      BiConsumer<T, Level> handler) {
            ClientPlayNetworking.registerGlobalReceiver(new ResourceLocation(PACKET_LOCATION, id), (client, listener, buf, responseSender) -> {
                buf.retain();
                client.execute(() -> {
                    T packet = decode.apply(buf);
                    ClientLevel level = client.level;
                    if (level != null) {
                        try {
                            handler.accept(packet, level);
                        } catch (Throwable throwable) {
                            BYG.LOGGER.error("Packet failed: ", throwable);
                            throw throwable;
                        }
                    }
                    buf.release();
                });
            });
        }
    }
}