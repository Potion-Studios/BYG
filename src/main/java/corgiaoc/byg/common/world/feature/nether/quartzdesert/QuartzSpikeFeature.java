package corgiaoc.byg.common.world.feature.nether.quartzdesert;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.QuartzSpikeConfig;
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

public class QuartzSpikeFeature extends Feature<QuartzSpikeConfig> {
    private static final BlockStateMatcher IS_QUARTZ_SAND = BlockStateMatcher.forBlock(BYGBlocks.QUARTZITE_SAND);
    private static final BlockStateMatcher IS_AIR = BlockStateMatcher.forBlock(Blocks.AIR);
    private static final BlockStateMatcher IS_CAVE_AIR = BlockStateMatcher.forBlock(Blocks.CAVE_AIR);
    private static final BlockStateMatcher IS_VOID_AIR = BlockStateMatcher.forBlock(Blocks.VOID_AIR);
    private final BlockState quartz = Blocks.SMOOTH_QUARTZ.defaultBlockState();


    public QuartzSpikeFeature(Codec<QuartzSpikeConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, QuartzSpikeConfig config) {

        if (!IS_QUARTZ_SAND.test(world.getBlockState(pos.below()))) {
            return false;
        }

//        if (!IS_AIR.test(world.getBlockState(pos))) {
//            return false;
//        }

//        if (!IS_VOID_AIR.test(world.getBlockState(pos))) {
//            return false;
//        }
//
        if (!IS_CAVE_AIR.test(world.getBlockState(pos))) {
            return false;
        }

        if (!world.getBlockState(pos.above(4)).canOcclude()){
            return false;
        }

        int type = random.nextInt(2);

        if (type == 1) {
            for (int y1 = 1; y1 <= 2; ++y1) {
                world.setBlock(pos.offset(1, y1, -1), this.quartz, 3);
                world.setBlock(pos.offset(0, y1, -1), this.quartz, 3);
                world.setBlock(pos.offset(-1, y1, 0), this.quartz, 3);
                world.setBlock(pos.offset(0, y1, 2), this.quartz, 3);
            }
            for (int y1 = 1; y1 <= 3; ++y1) {
                world.setBlock(pos.offset(2, y1, 0), this.quartz, 3);
                world.setBlock(pos.offset(-1, y1, 1), this.quartz, 3);
                world.setBlock(pos.offset(1, y1, 1), this.quartz, 3);
                world.setBlock(pos.offset(2, y1, 1), this.quartz, 3);
            }
            for (int y1 = 1; y1 <= 5; ++y1) {
                world.setBlock(pos.offset(0, y1, 0), this.quartz, 3);
            }
            for (int y1 = 1; y1 <= 6; ++y1) {
                world.setBlock(pos.offset(1, y1, 0), this.quartz, 3);
            }
            for (int y1 = 1; y1 <= 7; ++y1) {
                world.setBlock(pos.offset(0, y1, 1), this.quartz, 3);
            }
            for (int y1 = 1; y1 <= 9; ++y1) {
                world.setBlock(pos.offset(1, y1, 1), this.quartz, 3);
            }
        }else{
            for (int y1 = 1; y1 <= 2; ++y1) {
                world.setBlock(pos.offset(-1, y1, 1), this.quartz, 3);
                world.setBlock(pos.offset(0, y1, -1), this.quartz, 3);
                world.setBlock(pos.offset(-1, y1, 0), this.quartz, 3);
                world.setBlock(pos.offset(2, y1, 0), this.quartz, 3);
            }
            for (int y1 = 1; y1 <= 3; ++y1) {
                world.setBlock(pos.offset(1, y1, 2), this.quartz, 3);
                world.setBlock(pos.offset(-1, y1, 0), this.quartz, 3);
            }
            for (int y1 = 1; y1 <= 4; ++y1) {
                world.setBlock(pos.offset(0, y1, 2), this.quartz, 3);
                world.setBlock(pos.offset(1, y1, 2), this.quartz, 3);
                world.setBlock(pos.offset(1, y1, 0), this.quartz, 3);
            }
            for (int y1 = 1; y1 <= 6; ++y1) {
                world.setBlock(pos.offset(0, y1, 0), this.quartz, 3);
            }
            for (int y1 = 1; y1 <= 7; ++y1) {
                world.setBlock(pos.offset(1, y1, 1), this.quartz, 3);
            }
            for (int y1 = 1; y1 <= 9; ++y1) {
                world.setBlock(pos.offset(0, y1, 1), this.quartz, 3);
            }
        }
        return true;
    }
}