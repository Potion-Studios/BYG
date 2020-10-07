package corgiaoc.byg.common.world.dimension.nether;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public enum BYGNetherMasterLayer implements IAreaTransformer0 {
    INSTANCE;

    @Override
    public int apply(INoiseRandom rand, int x, int y) {
        return BYGNetherBiomeCatch.getRandomNetherBiomes(rand);
    }
}
