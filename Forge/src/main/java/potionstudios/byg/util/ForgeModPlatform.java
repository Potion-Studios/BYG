package potionstudios.byg.util;

import com.google.auto.service.AutoService;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoader;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.loading.FMLPaths;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.end.BYGEndBiomeSource;
import potionstudios.byg.common.world.biome.nether.BYGNetherBiomeSource;
import potionstudios.byg.network.ForgeNetworkHandler;
import potionstudios.byg.network.packet.BYGS2CPacket;
import potionstudios.byg.world.biome.BYGForgeEndBiomeSource;
import potionstudios.byg.world.biome.BYGForgeNetherBiomeSource;
import terrablender.api.SurfaceRuleManager;

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
    public BYGNetherBiomeSource createNetherBiomeSource(Registry<Biome> biomeRegistry) {
        return new BYGForgeNetherBiomeSource(biomeRegistry);
    }

    @Override
    public BYGEndBiomeSource createEndBiomeSource(Registry<Biome> biomeRegistry) {
        return new BYGForgeEndBiomeSource(biomeRegistry);
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
    public boolean hasLoadErrors() {
        return !ModLoader.isLoadingStateValid();
    }

    @Override
    public String tagNameSpace() {
        return "forge";
    }

    @Override
    public void addTagsUpdatedListener(TagsUpdatedEvent onTagsUpdated) {
        MinecraftForge.EVENT_BUS.addListener((final net.minecraftforge.event.TagsUpdatedEvent event) -> onTagsUpdated.onTagsUpdated(event.getRegistryAccess()));
    }

    @Override
    public boolean canTreeGrowWithEvent(Level level, RandomSource source, BlockPos pos) {
        return net.minecraftforge.event.ForgeEventFactory.saplingGrowTree(level, source, pos);
    }

    @Override
    public SurfaceRules.RuleSource getTerraBlenderNetherSurfaceRules(SurfaceRules.RuleSource fallBack) {
        return SurfaceRuleManager.getNamespacedRules(SurfaceRuleManager.RuleCategory.NETHER, fallBack);
    }
}
