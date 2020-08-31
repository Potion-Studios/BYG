package voronoiaoc.byg.common.world.feature.features.overworld.trees.bayou;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelWriter;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;


public class BayouTree3 extends Feature<NoneFeatureConfiguration> {
    public static boolean doBlockNotify;

    public BayouTree3(Codec<NoneFeatureConfiguration> config) {
        super(config);
    }

    public boolean place(WorldGenLevel worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoneFeatureConfiguration config) {
        int randChance = rand.nextInt(2);
        int randTreeHeight = rand.nextInt(6) + 5;
        BlockPos blockPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        BlockPos.MutableBlockPos block = new BlockPos.MutableBlockPos().set(blockPos);
        BlockPos.MutableBlockPos mainMutable = new BlockPos.MutableBlockPos().set(block);

        if (!this.checkArea(worldIn, pos, 5) || worldIn.getBlockState(pos.below()).getBlock() != Blocks.DIRT && worldIn.getBlockState(pos.below()).getBlock() != BYGBlockList.MUD_BLOCK && worldIn.getBlockState(pos.below()).getBlock() != Blocks.GRASS_BLOCK) {
            return false;
        } else {
            for (int i = 3; i <= randTreeHeight; i++) {
                BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(block);
                this.setWillowLog(worldIn, mutable.move(Direction.UP, i));
            }

            for (int baseSize = 0; baseSize < 4; baseSize++) {
                BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(block.above(3));
                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    mutable.set(block.above(3).relative(direction, baseSize));
                    if (worldIn.getBlockState(mutable).getBlock() != Blocks.DIRT)
                        this.setWillowLog(worldIn, mutable.move(Direction.DOWN, baseSize));
                }
            }
            this.setWillowLog(worldIn, mainMutable.move(Direction.UP, randTreeHeight - 1).move(Direction.SOUTH).move(Direction.EAST));
            this.setWillowLog(worldIn, mainMutable.move(Direction.DOWN));
            this.setWillowLog(worldIn, mainMutable.move(Direction.UP, 2).move(Direction.EAST));
            mainMutable.set(block);
            this.setWillowLog(worldIn, mainMutable.move(Direction.UP, randTreeHeight - 1).move(Direction.WEST));
            this.setWillowLog(worldIn, mainMutable.move(Direction.WEST).move(Direction.UP).move(Direction.NORTH));
            mainMutable.set(block);
            this.setWillowLog(worldIn, mainMutable.move(Direction.UP, randTreeHeight - 2).move(Direction.NORTH));
            this.setWillowLog(worldIn, mainMutable.move(Direction.UP).move(Direction.NORTH));
            mainMutable.set(block);

//            this.setWillowLeaves(worldIn, mainMutable.move(Direction.UP, randTreeHeight));
//            for (int placeX = -3; placeX <= 3; placeX++) {
//                for (int placeZ = -3; placeZ <= 3; placeZ++) {
//                    if (placeX <= 2 && placeX >= -2 && placeZ <= 2 && placeZ >= -2) {
//                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 0, placeZ));
//                        this.setWillowLeaves(worldIn, mainMutable.add(3, 0, placeZ));
//                        this.setWillowLeaves(worldIn, mainMutable.add(-3, 0, placeZ));
//                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 0, 3));
//                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 0, -3));
//
//                        for (int placeY = -1; placeY >= -(rand.nextInt(4) + 2); placeY--) {
//                            this.setWillowLeaves(worldIn, mainMutable.add(4, placeY, placeZ));
//                            this.setWillowLeaves(worldIn, mainMutable.add(-4, placeY, placeZ));
//                            this.setWillowLeaves(worldIn, mainMutable.add(placeX, placeY, 4));
//                            this.setWillowLeaves(worldIn, mainMutable.add(placeX, placeY, -4));
//                            this.setWillowLeaves(worldIn, mainMutable.add(3, placeY, 3));
//                            this.setWillowLeaves(worldIn, mainMutable.add(-3, placeY, 3));
//                            this.setWillowLeaves(worldIn, mainMutable.add(3, placeY, -3));
//                            this.setWillowLeaves(worldIn, mainMutable.add(-3, placeY, -3));
//                        }
//                    }
//
//                    if (placeX <= 1 && placeX >= -1 && placeZ <= 1 && placeZ >= -1) {
//                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 1, placeZ));
//                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 1, 2));
//                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 1, -2));
//                        this.setWillowLeaves(worldIn, mainMutable.add(2, 1, placeZ));
//                        this.setWillowLeaves(worldIn, mainMutable.add(-2, 1, placeZ));
//                        if (randChance == 0) {
//                            this.setWillowLeaves(worldIn, mainMutable.add(placeX, 0, 4));
//                            this.setWillowLeaves(worldIn, mainMutable.add(placeX, 0, -4));
//                            this.setWillowLeaves(worldIn, mainMutable.add(4, 0, placeZ));
//                            this.setWillowLeaves(worldIn, mainMutable.add(-4, 0, placeZ));
//                        }
//                    }
//                }
//            }
        }
        return true;
    }

    protected void setWillowLog(LevelWriter worldIn, BlockPos pos) {
        this.setBlockStateWithoutUpdates(worldIn, pos, BYGBlockList.WILLOW_LOG.defaultBlockState());
    }

    protected void setWillowLeaves(LevelWriter worldIn, BlockPos pos) {
        if ((worldIn instanceof LevelAccessor)) {
            if (((LevelAccessor) worldIn).getBlockState(pos).getBlock() != BYGBlockList.WILLOW_LOG)
                this.setBlockStateWithoutUpdates(worldIn, pos, BYGBlockList.WILLOW_LEAVES.defaultBlockState().setValue(BlockStateProperties.DISTANCE, Integer.valueOf(1)));
        }
    }

    private void setBlockStateWithoutUpdates(LevelWriter worldWriter, BlockPos blockPos, BlockState blockState) {
        worldWriter.setBlock(blockPos, blockState, 19);
    }

    private boolean checkArea(LevelAccessor world, BlockPos pos, int radius) {
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();

        for (int checkX = -radius; checkX <= radius; checkX++) {
            for (int checkZ = -radius; checkZ <= radius; checkZ++) {
                BlockPos checkArea = new BlockPos(posX + checkX, posY, posZ + checkZ);

                if (world.getBlockState(checkArea).getBlock() == BYGBlockList.WILLOW_LOG) return false;

            }
        }
        return true;
    }
}