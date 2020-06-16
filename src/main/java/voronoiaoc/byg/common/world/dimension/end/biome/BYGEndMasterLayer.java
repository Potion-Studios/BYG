package voronoiaoc.byg.common.world.dimension.end.biome;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public enum BYGEndMasterLayer implements IAreaTransformer0 {
    INSTANCE;

    @Override
    public int apply(INoiseRandom rand, int genX, int genZ) {
        return BYGEndBiomeCatch.getRandomEndBiomes(rand);
    }
}
