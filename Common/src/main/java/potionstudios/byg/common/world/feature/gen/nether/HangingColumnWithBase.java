package potionstudios.byg.common.world.feature.gen.nether;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import potionstudios.byg.common.world.feature.config.HangingColumnWithBaseConfig;

import java.util.Random;

public class HangingColumnWithBase extends Feature<HangingColumnWithBaseConfig> {
    private static final Direction[] DIRECTIONS = Direction.values();

    public HangingColumnWithBase(Codec<HangingColumnWithBaseConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<HangingColumnWithBaseConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random rand, BlockPos pos, HangingColumnWithBaseConfig config) {
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

    private void generateBase(LevelAccessor world, Random rand, BlockPos pos, HangingColumnWithBaseConfig config) {
        world.setBlock(pos, config.getBaseBlockProvider().getState(rand, pos), 2);
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        BlockPos.MutableBlockPos mutable2 = new BlockPos.MutableBlockPos();

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

    private void generateVinesInArea(LevelAccessor world, Random rand, BlockPos pos, HangingColumnWithBaseConfig config) {
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

        for (int i = 0; i < 100; ++i) {
            mutable.setWithOffset(pos, rand.nextInt(8) - rand.nextInt(8), rand.nextInt(2) - rand.nextInt(7), rand.nextInt(8) - rand.nextInt(8));
            if (world.isEmptyBlock(mutable)) {
                BlockState blockstate = world.getBlockState(mutable.above());
                if (config.getWhitelist().contains(blockstate.getBlock())) {
                    int length = Mth.nextInt(rand, config.getMinLength(), config.getMaxLength());
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

    public static void generateLength(LevelAccessor world, BlockPos.MutableBlockPos mutable, int length, Random rand, HangingColumnWithBaseConfig config) {
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