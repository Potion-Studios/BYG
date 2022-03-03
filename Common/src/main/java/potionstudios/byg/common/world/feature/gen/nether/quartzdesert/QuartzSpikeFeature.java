package potionstudios.byg.common.world.feature.gen.nether.quartzdesert;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.material.Material;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.config.QuartzSpikeConfig;
import potionstudios.byg.common.world.math.noise.fastnoise.FastNoise;

import java.util.Random;

public class QuartzSpikeFeature extends Feature<QuartzSpikeConfig> {
    private static final BlockStatePredicate IS_QUARTZ_SAND = BlockStatePredicate.forBlock(BYGBlocks.QUARTZITE_SAND);

    FastNoise noise = null;


    public QuartzSpikeFeature(Codec<QuartzSpikeConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<QuartzSpikeConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random rand, BlockPos pos, QuartzSpikeConfig config) {
        setSeed(world.getSeed());

        if (world.getBlockState(pos.below()).getMaterial() == Material.AIR || world.getBlockState(pos.below()) != BYGBlocks.QUARTZITE_SAND.defaultBlockState() || world.getBlockState(pos.below()).getMaterial() == Material.LAVA || world.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, pos.getX(), pos.getZ()) < 4)
            return false;


        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

        double baseRadius = 1;
        int height = 10;
        int startHeight = height - 3;

        for (double y = -height; y <= -1; y++) {
            for (double x = -height; x <= height; x++) {
                for (double z = -height; z <= height; z++) {
                    mutable.set(pos).move((int) x, (int) y + startHeight, (int) z);
                    double noise = this.noise.GetNoise((float) mutable.getX(), (float) mutable.getZ()) * 12;
                    double scaledNoise = (noise / 11) * (-(y * baseRadius) / ((x * x) + (z * z)));
                    double threshold = 0.5;

                    if (y == -height) {
                        if (scaledNoise >= threshold)
                            if (world.getBlockState(mutable.relative(Direction.DOWN)).getMaterial() == Material.AIR)
                                return false;
                    }

                    if (scaledNoise >= threshold) {
                        if (world.getBlockState(mutable).getMaterial() == Material.AIR) {
                            BlockState blockState = config.getBlockProvider().getState(rand, mutable);
                            world.setBlock(mutable, blockState, 2);
                        }
                    }
                }
            }
        }
        return true;
    }

    public void setSeed(long seed) {
        if (noise == null) {
            noise = new FastNoise((int) seed);
            noise.SetNoiseType(FastNoise.NoiseType.PerlinFractal);
            noise.SetFractalType(FastNoise.FractalType.FBM);
            noise.SetFrequency(0.2F);
        }
    }
}