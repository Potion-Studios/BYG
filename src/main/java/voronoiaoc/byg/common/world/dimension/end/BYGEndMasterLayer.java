package voronoiaoc.byg.common.world.dimension.end;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public enum BYGEndMasterLayer implements IAreaTransformer0 {
    INSTANCE;

    @Override
    public int apply(INoiseRandom context, int x, int y) {
        return pickRandomBiomeID(context);
    }

    public int pickRandomBiomeID(INoiseRandom randomnessSource) {
        return BYGEndBiomeCatch.getRandomEndBiomes(randomnessSource);
    }
}
