package potionstudios.byg.util;

import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.common.world.biome.end.BYGEndBiomeSource;
import potionstudios.byg.common.world.biome.nether.BYGNetherBiomeSource;
import potionstudios.byg.network.packet.BYGS2CPacket;

import java.nio.file.Path;
import java.util.List;
import java.util.ServiceLoader;

public interface ModPlatform {

    ModPlatform INSTANCE = Util.make(() -> {
        final var loader = ServiceLoader.load(ModPlatform.class);
        final var it = loader.iterator();
        if (!it.hasNext()) {
            throw new RuntimeException("No Mod Platform was found on the classpath!");
        } else {
            final ModPlatform factory = it.next();
            if (it.hasNext()) {
                throw new RuntimeException("More than one Mod Platform was found on the classpath!");
            }
            return factory;
        }
    });

    Path configPath();

    BYGNetherBiomeSource createNetherBiomeSource(Registry<Biome> biomeRegistry, long seed);

    BYGEndBiomeSource createEndBiomeSource(Registry<Biome> biomeRegistry, long seed);

    boolean isModLoaded(String isLoaded);

    <P extends BYGS2CPacket> void sendToClient(ServerPlayer player, P packet);

    String tagNameSpace();

    String curseForgeURL();

    boolean isClientEnvironment();

    Platform modPlatform();

    boolean hasLoadErrors();

    default <P extends BYGS2CPacket> void sendToAllClients(List<ServerPlayer> players, P packet) {
        for (ServerPlayer player : players) {
            sendToClient(player, packet);
        }
    }

    enum Platform {
        FORGE,
        FABRIC
    }
}
