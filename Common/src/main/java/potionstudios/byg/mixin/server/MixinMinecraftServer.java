package potionstudios.byg.mixin.server;


import com.mojang.datafixers.DataFixer;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.Services;
import net.minecraft.server.WorldStem;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.progress.ChunkProgressListener;
import net.minecraft.server.level.progress.ChunkProgressListenerFactory;
import net.minecraft.server.packs.repository.PackRepository;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
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
import potionstudios.byg.BYGConstants;
import potionstudios.byg.common.world.feature.GlobalBiomeFeature;
import potionstudios.byg.common.world.surfacerules.BYGSurfaceRules;
import potionstudios.byg.common.world.util.BiomeSourceRepairUtils;
import potionstudios.byg.common.world.util.JigsawUtil;
import potionstudios.byg.config.ConfigVersionTracker;
import potionstudios.byg.config.SettingsConfig;
import potionstudios.byg.config.json.OverworldBiomeConfig;
import potionstudios.byg.server.command.UpdateConfigsCommand;
import potionstudios.byg.util.BYGUtil;
import potionstudios.byg.util.ModPlatform;
import potionstudios.byg.util.ServerKillCountDown;

import java.net.Proxy;
import java.util.Map;
import java.util.function.BooleanSupplier;

import static potionstudios.byg.util.AddSurfaceRulesUtil.appendSurfaceRule;

@Mixin(MinecraftServer.class)
public abstract class MixinMinecraftServer implements ServerKillCountDown {

    @Shadow
    @Final
    private RegistryAccess.Frozen registryHolder;

    @Shadow
    public abstract WorldData getWorldData();

    @Shadow
    public abstract PlayerList getPlayerList();

    private long byg$killTime = -1;
    private boolean byg$killClient = false;

    private int byg$notifyErrorFrequency = 0;


    @Inject(at = @At("RETURN"), method = "<init>")
    private void appendGlobalFeatures(Thread $$0, LevelStorageSource.LevelStorageAccess $$1, PackRepository $$2, WorldStem $$3, Proxy $$4, DataFixer $$5, Services $$6, ChunkProgressListenerFactory $$7, CallbackInfo ci) {
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

        BYG.logConfigErrors();
    }


    @Inject(method = "createLevels", at = @At("RETURN"))
    private void hackyAddSurfaceRules(ChunkProgressListener $$0, CallbackInfo ci) {
        if (SettingsConfig.getConfig().useBYGWorldGen()) {
            boolean terrablenderApplied = ModPlatform.INSTANCE.isModLoaded("terrablender") && this.getWorldData().worldGenSettings().dimensions().getHolderOrThrow(LevelStem.OVERWORLD).value().generator().getBiomeSource() instanceof MultiNoiseBiomeSource;
            if (!terrablenderApplied && OverworldBiomeConfig.getConfig().generateOverworld()) { // We add our surface rules through Terrablender's API.
                appendSurfaceRule(this.getWorldData(), LevelStem.OVERWORLD, BYGSurfaceRules.OVERWORLD_SURFACE_RULES);
            }
            appendSurfaceRule(this.getWorldData(), LevelStem.NETHER, BYGSurfaceRules.NETHER_SURFACE_RULES);
            appendSurfaceRule(this.getWorldData(), LevelStem.END, BYGSurfaceRules.END_SURFACE_RULES);
        }
        BYGUtil.useTagReplacements = true;
    }

    @SuppressWarnings("all")
    @Inject(method = "tickServer", at = @At("RETURN"))
    private void displayDisconnectWarning(BooleanSupplier $$0, CallbackInfo ci) {
        if (byg$killTime > 0) {
            if (byg$killTime % 100 == 0) {
                for (ServerPlayer player : getPlayerList().getPlayers()) {
                    long killTimeInSeconds = byg$killTime / 20;
                    player.displayClientMessage(Component.translatable("byg.serverkill.countdown", killTimeInSeconds).withStyle(byg$killTime < 300 ? ChatFormatting.RED : ChatFormatting.YELLOW), false);
                }
            }
            byg$killTime--;

            if (byg$killTime == 0) {
                UpdateConfigsCommand.backupAndKillGameInstance((MinecraftServer) (Object) this, new ConfigVersionTracker(BYGConstants.CONFIG_VERSION), this.byg$killClient);
            }
        }

        if (byg$notifyErrorFrequency >= 36000) {
            BYG.logConfigErrors();
            byg$notifyErrorFrequency = 0;
        }
        byg$notifyErrorFrequency++;
    }

    @Override
    public void setKillCountdown(long killCountdownInTicks, boolean isClient) {
        this.byg$killTime = killCountdownInTicks;
        this.byg$killClient = isClient;
    }
}
