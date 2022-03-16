package potionstudios.byg.util;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.levelgen.SurfaceRules;
import potionstudios.byg.BYG;
import potionstudios.byg.network.packet.BYGS2CPacket;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Supplier;

public interface ModLoaderContext {

    Path configPath();

    Supplier<SurfaceRules.RuleSource> netherRuleSource();

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
