package potionstudios.byg.network;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import potionstudios.byg.BYG;
import potionstudios.byg.network.packet.BYGS2CPacket;
import potionstudios.byg.network.packet.ConstructBYGPlayerTrackedDataPacket;
import potionstudios.byg.network.packet.DiscoveredBiomesPacket;
import potionstudios.byg.network.packet.SaplingPatternsPacket;

import java.util.List;
import java.util.function.Supplier;

public class ForgeNetworkHandler {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel SIMPLE_CHANNEL = NetworkRegistry.newSimpleChannel(
        new ResourceLocation(BYG.MOD_ID, "network"),
        () -> PROTOCOL_VERSION,
        PROTOCOL_VERSION::equals,
        PROTOCOL_VERSION::equals
    );

    public static void init() {
        BYG.LOGGER.info("Initializing BYG network...");
        SIMPLE_CHANNEL.registerMessage(0, SaplingPatternsPacket.class, SaplingPatternsPacket::write, SaplingPatternsPacket::read, ForgeNetworkHandler::handle);
        SIMPLE_CHANNEL.registerMessage(1, DiscoveredBiomesPacket.class, DiscoveredBiomesPacket::write, DiscoveredBiomesPacket::read, ForgeNetworkHandler::handle);
        SIMPLE_CHANNEL.registerMessage(2, ConstructBYGPlayerTrackedDataPacket.class, ConstructBYGPlayerTrackedDataPacket::write, ConstructBYGPlayerTrackedDataPacket::read, ForgeNetworkHandler::handle);
        BYG.LOGGER.info("Initialized BYG network!");
    }

    public static void sendToPlayer(ServerPlayer playerEntity, Object objectToSend) {
        SIMPLE_CHANNEL.sendTo(objectToSend, playerEntity.connection.getConnection(), NetworkDirection.PLAY_TO_CLIENT);
    }

    public static void sendToAllPlayers(List<ServerPlayer> playerEntities, Object objectToSend) {
        for (ServerPlayer playerEntity : playerEntities) {
            SIMPLE_CHANNEL.sendTo(objectToSend, playerEntity.connection.getConnection(), NetworkDirection.PLAY_TO_CLIENT);
        }
    }

    public static void sendToServer(Object objectToSend) {
        SIMPLE_CHANNEL.sendToServer(objectToSend);
    }

    public static <T extends BYGS2CPacket> void handle(T packet, Supplier<NetworkEvent.Context> ctx) {
        NetworkEvent.Context context = ctx.get();
        if (context.getDirection().getReceptionSide().isClient()) {
            context.enqueueWork(() -> {
                packet.handle(Minecraft.getInstance().level);
            });
            context.setPacketHandled(true);
        }
    }
}