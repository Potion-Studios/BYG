package potionstudios.byg.entry;

import potionstudios.byg.common.world.biome.BYGOverworldBiomeBuilder;
import potionstudios.byg.world.biome.BYGBiomeProvider;
import terrablender.api.BiomeProviders;
import terrablender.api.TerraBlenderApi;

public class BYGTerraBlenderEntry implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        BYGOverworldBiomeBuilder.DEFAULTS.forEach(biomeProviderData -> {
            BiomeProviders.register(new BYGBiomeProvider(biomeProviderData.overworldWeight(), biomeProviderData.oceans(), biomeProviderData.middleBiomes(), biomeProviderData.middleBiomesVariant(), biomeProviderData.plateauBiomes(), biomeProviderData.plateauBiomesVariant(), biomeProviderData.extremeHills(), biomeProviderData.swapper()));
        });
    }
}
