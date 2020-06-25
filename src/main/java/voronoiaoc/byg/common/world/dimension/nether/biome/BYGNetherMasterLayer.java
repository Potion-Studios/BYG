package voronoiaoc.byg.common.world.dimension.nether.biome;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public enum BYGNetherMasterLayer implements IAreaTransformer0 {
    INSTANCE;

    @Override
    public int apply(INoiseRandom rand, int genX, int genZ) {
        return BYGNetherBiomeCatch.getRandomNetherBiomes(rand);
    }
}
