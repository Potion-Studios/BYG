package potionstudios.byg.util;

import com.google.auto.service.AutoService;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.end.BYGEndBiomeSource;
import potionstudios.byg.common.world.biome.nether.BYGNetherBiomeSource;
import potionstudios.byg.network.FabricNetworkHandler;
import potionstudios.byg.network.packet.BYGS2CPacket;
import potionstudios.byg.world.biome.BYGFabricEndBiomeSource;
import potionstudios.byg.world.biome.BYGFabricNetherBiomeSource;

import java.nio.file.Path;

@AutoService(ModPlatform.class)
public class FabricModPlatform implements ModPlatform {

    @Override
    public Path configPath() {
        return FabricLoader.getInstance().getConfigDir().resolve(BYG.MOD_ID);
    }

    @Override
    public boolean isModLoaded(String isLoaded) {
        return FabricLoader.getInstance().isModLoaded(isLoaded);
    }

    @Override
    public <P extends BYGS2CPacket> void sendToClient(ServerPlayer player, P packet) {
        FabricNetworkHandler.sendToPlayer(player, packet);
    }

    @Override
    public BYGNetherBiomeSource createNetherBiomeSource(Registry<Biome> biomeRegistry, long seed) {
        return new BYGFabricNetherBiomeSource(biomeRegistry, seed);
    }

    @Override
    public BYGEndBiomeSource createEndBiomeSource(Registry<Biome> biomeRegistry, long seed) {
        return new BYGFabricEndBiomeSource(biomeRegistry, seed);
    }

    @Override
    public String tagNameSpace() {
        return "c";
    }

    @Override
    public boolean isClientEnvironment() {
        return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
    }

    @Override
    public Platform modPlatform() {
        return Platform.FABRIC;
    }

    @Override
    public boolean hasLoadErrors() {
        return false;
    }

    @Override
    public String curseForgeURL() {
        return "https://www.curseforge.com/minecraft/mc-mods/oh-the-biomes-youll-go-fabric/files";
    }
}
