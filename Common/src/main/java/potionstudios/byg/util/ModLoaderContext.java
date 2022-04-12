package potionstudios.byg.util;

import net.minecraft.core.Registry;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.end.BYGEndBiomeSource;
import potionstudios.byg.common.world.biome.nether.BYGNetherBiomeSource;
import potionstudios.byg.network.packet.BYGS2CPacket;

import java.nio.file.Path;
import java.util.List;

public interface ModLoaderContext {

    Path configPath();

    BYGNetherBiomeSource createNetherBiomeSource(Registry<Biome> biomeRegistry, long seed);

    BYGEndBiomeSource createEndBiomeSource(Registry<Biome> biomeRegistry, long seed);

    boolean isModLoaded(String isLoaded);

    static ModLoaderContext getInstance() {
        ModLoaderContext data = BYG.MODLOADER_DATA;

        if (data == null) {
            throw new RuntimeException("Accessed ModLoaderContext too early!");
        }

        return data;
    }

    <P extends BYGS2CPacket> void sendToClient(ServerPlayer player, P packet);

    default <P extends BYGS2CPacket> void sendToAllClients(List<ServerPlayer> players, P packet) {
        for (ServerPlayer player : players) {
            sendToClient(player, packet);
        }
    }
}
