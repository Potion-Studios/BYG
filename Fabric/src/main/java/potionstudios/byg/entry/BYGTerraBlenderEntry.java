package potionstudios.byg.entry;

import net.minecraft.resources.ResourceLocation;
import potionstudios.byg.BYG;
import potionstudios.byg.config.BYGBiomeConfig;
import potionstudios.byg.world.biome.BYGBiomeProvider;
import terrablender.api.BiomeProviders;
import terrablender.api.TerraBlenderApi;

public class BYGTerraBlenderEntry implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        BYGBiomeConfig.DEFAULT.biomeProperties().forEach((biomeResourceKey, biomeProperties) -> {
            BiomeProviders.register(new BYGBiomeProvider(biomeResourceKey, biomeProperties, new ResourceLocation(BYG.MOD_ID, biomeResourceKey.location().getPath() + "_provider")));
        });
    }
}
