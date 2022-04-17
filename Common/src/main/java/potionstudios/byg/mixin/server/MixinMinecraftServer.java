package potionstudios.byg.mixin.server;


import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.datafixers.DataFixer;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.WorldStem;
import net.minecraft.server.level.progress.ChunkProgressListener;
import net.minecraft.server.level.progress.ChunkProgressListenerFactory;
import net.minecraft.server.packs.repository.PackRepository;
import net.minecraft.server.players.GameProfileCache;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.minecraft.world.level.storage.LevelStorageSource;
import net.minecraft.world.level.storage.WorldData;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.feature.GlobalBiomeFeature;
import potionstudios.byg.common.world.surfacerules.BYGSurfaceRules;
import potionstudios.byg.common.world.util.BiomeSourceRepairUtils;
import potionstudios.byg.common.world.util.JigsawUtil;
import potionstudios.byg.config.SettingsConfig;
import potionstudios.byg.config.json.OverworldBiomeConfig;
import potionstudios.byg.util.BYGUtil;

import java.net.Proxy;
import java.util.Map;

import static potionstudios.byg.util.AddSurfaceRulesUtil.appendSurfaceRule;

@Mixin(MinecraftServer.class)
public abstract class MixinMinecraftServer {

    @Shadow
    @Final
    private RegistryAccess.Frozen registryHolder;

    @Shadow
    public abstract WorldData getWorldData();

    @Inject(at = @At("RETURN"), method = "<init>")
    private void appendGlobalFeatures(Thread $$0, LevelStorageSource.LevelStorageAccess $$1, PackRepository $$2, WorldStem $$3, Proxy $$4, DataFixer $$5, MinecraftSessionService $$6, GameProfileRepository $$7, GameProfileCache $$8, ChunkProgressListenerFactory $$9, CallbackInfo ci) {
        Registry<Biome> biomeRegistry = this.registryHolder.registryOrThrow(Registry.BIOME_REGISTRY);
        if (SettingsConfig.getConfig().appendBiomePlacedFeatures()) {
            Registry<PlacedFeature> placedFeatureRegistry = this.registryHolder.registryOrThrow(Registry.PLACED_FEATURE_REGISTRY);
            for (Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : biomeRegistry.entrySet()) {
                GlobalBiomeFeature.appendGlobalFeatures(biomeEntry.getValue().getGenerationSettings(), placedFeatureRegistry);
            }
        }
        if (SettingsConfig.getConfig().useBYGWorldGen()) {
            BiomeSourceRepairUtils.repairBiomeSources(biomeRegistry, getWorldData().worldGenSettings());
        }

        if (SettingsConfig.getConfig().customVillagers()) {
            Registry<StructureTemplatePool> templatePoolRegistry = this.registryHolder.registry(Registry.TEMPLATE_POOL_REGISTRY).orElseThrow();
            Registry<StructureProcessorList> processorListRegistry = this.registryHolder.registry(Registry.PROCESSOR_LIST_REGISTRY).orElseThrow();
            JigsawUtil.addBYGBuildingsToPool(templatePoolRegistry, processorListRegistry);
        }
    }

    @Inject(method = "createLevels", at = @At("RETURN"))
    private void hackyAddSurfaceRules(ChunkProgressListener $$0, CallbackInfo ci) {
        if (SettingsConfig.getConfig().useBYGWorldGen()) {
            if (!BYG.MODLOADER_DATA.isModLoaded("terrablender") && OverworldBiomeConfig.getConfig(false).generateOverworld()) { // We add our surface rules through Terrablender's API.
                appendSurfaceRule(this.getWorldData(), LevelStem.OVERWORLD, BYGSurfaceRules.OVERWORLD_SURFACE_RULES);
            }
            appendSurfaceRule(this.getWorldData(), LevelStem.NETHER, BYGSurfaceRules.NETHER_SURFACE_RULES);
            appendSurfaceRule(this.getWorldData(), LevelStem.END, BYGSurfaceRules.END_SURFACE_RULES);
        }
        BYGUtil.useTagReplacements = true;
    }
}
