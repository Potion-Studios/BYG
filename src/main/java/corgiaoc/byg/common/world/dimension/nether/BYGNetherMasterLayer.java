package corgiaoc.byg.common.world.dimension.nether;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public class BYGNetherMasterLayer implements IAreaTransformer0 {
    private final Registry<Biome> biomeRegistry;

    public BYGNetherMasterLayer(Registry<Biome> biomeRegistry) {
        this.biomeRegistry = biomeRegistry;
    }

    @Override
    public int apply(INoiseRandom rand, int x, int y) {
        return getRandomNetherBiomes(this.biomeRegistry, rand);
    }

    public static int getRandomNetherBiomes(Registry<Biome> biomeRegistry, INoiseRandom rand) {
        return biomeRegistry.getId(BYGNetherBiomeProvider.NETHER_BIOMES.get(rand.random(BYGNetherBiomeProvider.NETHER_BIOMES.size())));
    }
}
