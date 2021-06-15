package corgiaoc.byg.common.world.feature.nether.quartzdesert;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class QuartzSpikeFeature extends Feature<NoFeatureConfig> {
    private static final BlockStateMatcher IS_QUARTZ_SAND = BlockStateMatcher.forBlock(BYGBlocks.QUARTZITE_SAND);
    private final BlockState quartz = Blocks.SMOOTH_QUARTZ.defaultBlockState();


    public QuartzSpikeFeature(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
        if (!IS_QUARTZ_SAND.test(world.getBlockState(pos))) {
            return false;
        }
        for (int y1 = 1; y1 <= 5; ++y1) {
            for (int x1 = 1; x1 <= 3; ++x1) {
                    world.setBlock(pos.offset(x1, y1, 0), this.quartz, 3);
                    world.setBlock(pos.offset(x1, y1, -1), this.quartz, 3);
                    world.setBlock(pos.offset(1, y1, 1), this.quartz, 3);
                    world.setBlock(pos.offset(2, y1, 1), this.quartz, 3);
            }
        }
        for (int y1 = 5; y1 <= 10; ++y1) {
            for (int x1 = 1; x1 <= 2; ++x1) {
                world.setBlock(pos.offset(x1, y1, 0), this.quartz, 3);
                world.setBlock(pos.offset(x1, y1, -1), this.quartz, 3);
                world.setBlock(pos.offset(x1, y1, -2), this.quartz, 3);
                world.setBlock(pos.offset(1, y1, 1), this.quartz, 3);
            }
        }
        for (int y1 = 10; y1 <= 16; ++y1) {
            for (int x1 = 1; x1 <= 2; ++x1) {
                world.setBlock(pos.offset(2, y1, -2), this.quartz, 3);
            }
        }
        return true;
    }
}