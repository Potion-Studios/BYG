package potionstudios.byg.entry;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import potionstudios.byg.BYG;
import potionstudios.byg.config.json.OverworldBiomeConfig;
import potionstudios.byg.util.ModLoaderContext;
import potionstudios.byg.world.biome.BYGRegion;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

import java.nio.file.Path;
import java.util.function.Supplier;

//TODO: Terrablender
public class BYGTerraBlenderEntry implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        BYG.init(FabricLoader.getInstance().getConfigDir().resolve("byg"), "c");

        BYG.MODLOADER_DATA = new ModLoaderContext() {
            @Override
            public Path configPath() {
                return FabricLoader.getInstance().getConfigDir();
            }

            @Override
            public Supplier<SurfaceRules.RuleSource> netherRuleSource() {
                return () -> SurfaceRules.ifTrue(SurfaceRules.isBiome(ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("empty", "empty"))), SurfaceRules.state(Blocks.AIR.defaultBlockState()));
            }
        };
        OverworldBiomeConfig config = OverworldBiomeConfig.getConfig(true);
        if (config.generateOverworld()) {
            config.values().forEach(biomeProviderData -> {
                Regions.register(new BYGRegion(biomeProviderData.overworldWeight(), biomeProviderData.oceans(), biomeProviderData.middleBiomes(), biomeProviderData.middleBiomesVariant(), biomeProviderData.plateauBiomes(), biomeProviderData.plateauBiomesVariant(), biomeProviderData.shatteredBiomes(), biomeProviderData.swapper()));
            });
        } else {
            BYG.LOGGER.info("BYG overworld biomes disabled.");
        }
    }
}
