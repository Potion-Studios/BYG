package corgiaoc.byg.common.world.dimension.nether;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.type.InitLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;

public class BYGNetherMasterLayer implements InitLayer {
    private final Registry<Biome> biomeRegistry;

    public BYGNetherMasterLayer(Registry<Biome> biomeRegistry) {
        this.biomeRegistry = biomeRegistry;
    }

    @Override
    public int sample(LayerRandomnessSource rand, int x, int y) {
        return getRandomNetherBiomes(this.biomeRegistry, rand);
    }

    public static int getRandomNetherBiomes(Registry<Biome> biomeRegistry, LayerRandomnessSource rand) {
        return biomeRegistry.getRawId(biomeRegistry.getOrEmpty(BYGNetherBiomeProvider.NETHER_BIOMES.get(rand.nextInt(BYGNetherBiomeProvider.NETHER_BIOMES.size()))).orElseThrow(RuntimeException::new));
    }
}
