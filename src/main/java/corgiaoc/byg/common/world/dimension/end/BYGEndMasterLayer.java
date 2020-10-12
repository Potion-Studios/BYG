package corgiaoc.byg.common.world.dimension.end;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public class BYGEndMasterLayer implements IAreaTransformer0 {

    private final Registry<Biome> biomeRegistry;
    public BYGEndMasterLayer(Registry<Biome> biomeRegistry) {
        this.biomeRegistry = biomeRegistry;
    }

    @Override
    public int apply(INoiseRandom rand, int x, int y) {
        return BYGEndBiomeCatch.getRandomEndBiomes(this.biomeRegistry, rand);
    }
}