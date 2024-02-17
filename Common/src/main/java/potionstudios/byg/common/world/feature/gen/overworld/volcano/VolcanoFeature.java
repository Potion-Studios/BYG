package potionstudios.byg.common.world.feature.gen.overworld.volcano;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.material.Fluids;
import potionstudios.byg.common.world.feature.config.SimpleBlockProviderConfig;
import potionstudios.byg.common.world.math.noise.fastnoise.lite.FastNoiseLite;

public class VolcanoFeature extends Feature<SimpleBlockProviderConfig> {

    FastNoiseLite spongeNoise = null;

    public VolcanoFeature(Codec<SimpleBlockProviderConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<SimpleBlockProviderConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator generator, RandomSource rand, BlockPos pos, SimpleBlockProviderConfig config) {
        setSeed(world.getSeed());


        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

        double baseRadius = 10;
        double leakage = 0.5;
        int volcanoConeSize = 30;
        int volcanoStartHeight = volcanoConeSize - 5;
        double threshold = 0.4;
        int fluidY = -20 + rand.nextInt(9);

        for (double x = -volcanoConeSize; x <= volcanoConeSize; x++) {
            for (double z = -volcanoConeSize; z <= volcanoConeSize; z++) {

                float spongeNoiseValue = FastNoiseLite.getSpongeNoiseValue(spongeNoise.GetNoise(mutable.getX(), 0, mutable.getZ()));

                for (double y = -volcanoConeSize; y <= -15; y++) {
                    mutable.set(pos).move((int) x, (int) y + volcanoStartHeight, (int) z);

                    double scaledNoise = (spongeNoiseValue / 11) * (-(y * baseRadius) / ((x * x) + (z * z)));
                    if (scaledNoise - leakage >= threshold) {
                        if (y <= fluidY) {
                            while (!world.getBlockState(mutable).canOcclude() && mutable.getY() > world.getMinBuildHeight()) {
                                world.setBlock(mutable, Blocks.LAVA.defaultBlockState(), 2);
                                world.scheduleTick(mutable, Fluids.LAVA, 0);
                                mutable.move(Direction.DOWN);
                            }
                        }
                    } else if (scaledNoise >= threshold) {
                        while (!world.getBlockState(mutable).canOcclude() && mutable.getY() > world.getMinBuildHeight()) {
                            world.setBlock(mutable, config.getBlockProvider().getState(rand, mutable), 2);
                            mutable.move(Direction.DOWN);
                        }
                    }
                }
            }
        }
        return true;
    }


    public void setSeed(long seed) {
        if (spongeNoise == null) {
            spongeNoise = FastNoiseLite.createSpongeNoise((int) seed);
            spongeNoise.SetFrequency(0.2F);
        }
    }
}
