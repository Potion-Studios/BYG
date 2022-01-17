package potionstudios.byg.entry;

import potionstudios.byg.world.biome.BYGBiomeProvider;
import terrablender.api.BiomeProviders;
import terrablender.api.TerraBlenderApi;

public class BYGTerraBlenderEntry implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        BiomeProviders.register(new BYGBiomeProvider(BYGBiomeProvider.LOCATION));
    }
}
