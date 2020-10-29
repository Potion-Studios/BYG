package corgiaoc.byg.common.world.dimension.end;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.type.InitLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;

public class EndMasterLayer implements InitLayer {

    private final Registry<Biome> biomeRegistry;
    public EndMasterLayer(Registry<Biome> biomeRegistry) {
        this.biomeRegistry = biomeRegistry;
    }

    @Override
    public int sample(LayerRandomnessSource rand, int x, int y) {
        return getRandomIslandBiomes(this.biomeRegistry, rand);
    }

    public static int getRandomIslandBiomes(Registry<Biome> biomeRegistry, LayerRandomnessSource rand) {
        return biomeRegistry.getRawId(biomeRegistry.getOrEmpty(BYGEndBiomeProvider.END_BIOMES.get(rand.nextInt(BYGEndBiomeProvider.END_BIOMES.size()))).orElseThrow(RuntimeException::new));
    }
}