package corgiaoc.byg.common.world.feature.nether;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.HangingColumnWithBaseConfig;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class HangingColumnWithBase extends Feature<HangingColumnWithBaseConfig> {
    private static final Direction[] DIRECTIONS = Direction.values();

    public HangingColumnWithBase(Codec<HangingColumnWithBaseConfig> codec) {
        super(codec);
    }

    public boolean place(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, HangingColumnWithBaseConfig config) {
        if (!world.isEmptyBlock(pos)) {
            return false;
        } else {
            BlockState blockstate = world.getBlockState(pos.above());
            if (!config.getWhitelist().contains(blockstate.getBlock())) {
                return false;
            } else {
                this.generateBase(world, rand, pos, config);
                this.generateVinesInArea(world, rand, pos, config);
                return true;
            }
        }
    }

    private void generateBase(IWorld world, Random rand, BlockPos pos, HangingColumnWithBaseConfig config) {
        world.setBlock(pos, config.getBaseBlockProvider().getState(rand, pos), 2);
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        BlockPos.Mutable mutable2 = new BlockPos.Mutable();

        for (int i = 0; i < 200; ++i) {
            mutable.setWithOffset(pos, rand.nextInt(6) - rand.nextInt(6), rand.nextInt(2) - rand.nextInt(5), rand.nextInt(6) - rand.nextInt(6));
            if (world.isEmptyBlock(mutable)) {
                int j = 0;

                for (Direction direction : DIRECTIONS) {
                    BlockState blockstate = world.getBlockState(mutable2.setWithOffset(mutable, direction));
                    if (config.getWhitelist().contains(blockstate.getBlock())) {
                        ++j;
                    }

                    if (j > 1) {
                        break;
                    }
                }

                if (j == 1) {
                    world.setBlock(mutable, config.getBaseBlockProvider().getState(rand, mutable), 2);
                }
            }
        }

    }

    private void generateVinesInArea(IWorld world, Random rand, BlockPos pos, HangingColumnWithBaseConfig config) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (int i = 0; i < 100; ++i) {
            mutable.setWithOffset(pos, rand.nextInt(8) - rand.nextInt(8), rand.nextInt(2) - rand.nextInt(7), rand.nextInt(8) - rand.nextInt(8));
            if (world.isEmptyBlock(mutable)) {
                BlockState blockstate = world.getBlockState(mutable.above());
                if (config.getWhitelist().contains(blockstate.getBlock())) {
                    int length = MathHelper.nextInt(rand, config.getMinLength(), config.getMaxLength());
                    if (rand.nextInt(6) == 0) {
                        length *= 2;
                    }

                    if (rand.nextInt(5) == 0) {
                        length = 1;
                    }
                    generateLength(world, mutable, length, rand, config);
                }
            }
        }

    }

    public static void generateLength(IWorld world, BlockPos.Mutable mutable, int length, Random rand, HangingColumnWithBaseConfig config) {
        for (int i = 0; i <= length; ++i) {
            if (world.isEmptyBlock(mutable)) {
                if (i == length || !world.isEmptyBlock(mutable.below())) {
                    world.setBlock(mutable, config.getEndBlockProvider().getState(rand, mutable), 2);
                    break;
                }

                world.setBlock(mutable, config.getBlockProvider().getState(rand, mutable), 2);
            }

            mutable.move(Direction.DOWN);
        }

    }
}