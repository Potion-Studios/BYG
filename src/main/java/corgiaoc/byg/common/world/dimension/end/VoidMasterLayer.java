package corgiaoc.byg.common.world.dimension.end;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public class VoidMasterLayer implements IAreaTransformer0 {

    private final Registry<Biome> biomeRegistry;
    public VoidMasterLayer(Registry<Biome> biomeRegistry) {
        this.biomeRegistry = biomeRegistry;
    }

    @Override
    public int apply(INoiseRandom rand, int x, int y) {
        return getRandomVoidBiomes(this.biomeRegistry, rand);
    }

    public static int getRandomVoidBiomes(Registry<Biome> biomeRegistry, INoiseRandom rand) {
        return biomeRegistry.getId(BYGEndBiomeProvider.VOID_END_BIOMES.get(rand.random(BYGEndBiomeProvider.VOID_END_BIOMES.size())));
    }
}