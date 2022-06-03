package potionstudios.byg.util;

import com.google.auto.service.AutoService;
import net.minecraft.core.Registry;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.loading.FMLPaths;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.end.BYGEndBiomeSource;
import potionstudios.byg.common.world.biome.nether.BYGNetherBiomeSource;
import potionstudios.byg.network.ForgeNetworkHandler;
import potionstudios.byg.network.packet.BYGS2CPacket;
import potionstudios.byg.world.biome.BYGForgeEndBiomeSource;
import potionstudios.byg.world.biome.BYGForgeNetherBiomeSource;

import java.nio.file.Path;

@AutoService(ModPlatform.class)
public class ForgeModPlatform implements ModPlatform {

    @Override
    public Path configPath() {
        return FMLPaths.CONFIGDIR.get().resolve(BYG.MOD_ID);
    }

    @Override
    public boolean isModLoaded(String isLoaded) {
        return ModList.get().isLoaded(isLoaded);
    }

    @Override
    public <P extends BYGS2CPacket> void sendToClient(ServerPlayer player, P packet) {
        ForgeNetworkHandler.sendToPlayer(player, packet);
    }

    @Override
    public BYGNetherBiomeSource createNetherBiomeSource(Registry<Biome> biomeRegistry, long seed) {
        return new BYGForgeNetherBiomeSource(biomeRegistry, seed);
    }

    @Override
    public BYGEndBiomeSource createEndBiomeSource(Registry<Biome> biomeRegistry, long seed) {
        return new BYGForgeEndBiomeSource(biomeRegistry, seed);
    }

    @Override
    public String curseForgeURL() {
        return "https://www.curseforge.com/minecraft/mc-mods/oh-the-biomes-youll-go";
    }

    @Override
    public boolean isClientEnvironment() {
        return FMLEnvironment.dist == Dist.CLIENT;
    }

    @Override
    public Platform modPlatform() {
        return Platform.FORGE;
    }

    @Override
    public String tagNameSpace() {
        return "forge";
    }
}
