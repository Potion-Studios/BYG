package potionstudios.byg.entry;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.SurfaceRules;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.surfacerules.BYGSurfaceRules;
import potionstudios.byg.config.json.OverworldBiomeConfig;
import potionstudios.byg.world.biome.BYGBiomeProvider;
import terrablender.api.BiomeProvider;
import terrablender.api.BiomeProviders;
import terrablender.api.TerraBlenderApi;

import java.util.Optional;

public class BYGTerraBlenderEntry implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        BYG.init(FabricLoader.getInstance().getConfigDir().resolve("byg"), "c");
        BiomeProviders.register(new BiomeProvider(BYG.createLocation("surface_data"), 0) {
            @Override
            public Optional<SurfaceRules.RuleSource> getOverworldSurfaceRules() {
                return Optional.of(BYGSurfaceRules.BYG_SURFACE_RULES);
            }
        });
        OverworldBiomeConfig.getConfig(true).values().forEach(biomeProviderData -> {
            BiomeProviders.register(new BYGBiomeProvider(biomeProviderData.overworldWeight(), biomeProviderData.oceans(), biomeProviderData.middleBiomes(), biomeProviderData.middleBiomesVariant(), biomeProviderData.plateauBiomes(), biomeProviderData.plateauBiomesVariant(), biomeProviderData.extremeHills(), biomeProviderData.swapper()));
        });
    }
}
