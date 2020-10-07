package corgiaoc.byg.common.world.feature.overworld.trees.bayou;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGTreeFeatureConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.IWorldWriter;

import java.util.Random;
import java.util.Set;


public class BayouTree1 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {
    public static boolean doBlockNotify;

    public BayouTree1(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {

        int randChance = rand.nextInt(2);
        int randTreeHeight = rand.nextInt(6) + 8;
        BlockPos blockPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        BlockPos.Mutable block = new BlockPos.Mutable().setPos(blockPos);
        BlockPos.Mutable mainMutable = new BlockPos.Mutable().setPos(block);

        if (!this.checkArea(worldIn, pos, 5) || worldIn.getBlockState(pos.down()).getBlock() != Blocks.DIRT && worldIn.getBlockState(pos.down()).getBlock() != BYGBlocks.MUD_BLOCK && worldIn.getBlockState(pos.down()).getBlock() != Blocks.GRASS_BLOCK && worldIn.getBlockState(pos.down()).getBlock() != BYGBlocks.GLOWCELIUM) {
            return false;
        } else {
            //Trunk
            for (int i = 3; i <= randTreeHeight; i++) {
                BlockPos.Mutable mutable = new BlockPos.Mutable().setPos(block);
                this.setWillowLog(worldIn, mutable.move(Direction.UP, i));
            }

            for (int baseSize = 0; baseSize < 4; baseSize++) {
                BlockPos.Mutable mutable = new BlockPos.Mutable().setPos(block.up(3));
                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    mutable.setPos(block.up(3).offset(direction, baseSize));
                    if (worldIn.getBlockState(mutable).getBlock() != Blocks.DIRT)
                        this.setWillowLog(worldIn, mutable.move(Direction.DOWN, baseSize));
                }
            }
            this.setWillowLog(worldIn, mainMutable.move(Direction.UP, randTreeHeight - 1).move(Direction.SOUTH).move(Direction.EAST));
            this.setWillowLog(worldIn, mainMutable.move(Direction.DOWN));
            this.setWillowLog(worldIn, mainMutable.move(Direction.UP, 2).move(Direction.EAST));
            mainMutable.setPos(block);
            this.setWillowLog(worldIn, mainMutable.move(Direction.UP, randTreeHeight - 1).move(Direction.WEST));
            this.setWillowLog(worldIn, mainMutable.move(Direction.WEST).move(Direction.UP).move(Direction.NORTH));
            mainMutable.setPos(block);
            this.setWillowLog(worldIn, mainMutable.move(Direction.UP, randTreeHeight - 2).move(Direction.NORTH));
            this.setWillowLog(worldIn, mainMutable.move(Direction.UP).move(Direction.NORTH));
            mainMutable.setPos(block);

            this.setWillowLeaves(worldIn, mainMutable.move(Direction.UP, randTreeHeight));
            for (int placeX = -3; placeX <= 3; placeX++) {
                for (int placeZ = -3; placeZ <= 3; placeZ++) {
                    if (placeX <= 2 && placeX >= -2 && placeZ <= 2 && placeZ >= -2) {
                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 0, placeZ));
                        this.setWillowLeaves(worldIn, mainMutable.add(3, 0, placeZ));
                        this.setWillowLeaves(worldIn, mainMutable.add(-3, 0, placeZ));
                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 0, 3));
                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 0, -3));

                        for (int placeY = -1; placeY >= -(rand.nextInt(4) + 2); placeY--) {
                            this.setWillowLeaves(worldIn, mainMutable.add(4, placeY, placeZ));
                            this.setWillowLeaves(worldIn, mainMutable.add(-4, placeY, placeZ));
                            this.setWillowLeaves(worldIn, mainMutable.add(placeX, placeY, 4));
                            this.setWillowLeaves(worldIn, mainMutable.add(placeX, placeY, -4));
                            this.setWillowLeaves(worldIn, mainMutable.add(3, placeY, 3));
                            this.setWillowLeaves(worldIn, mainMutable.add(-3, placeY, 3));
                            this.setWillowLeaves(worldIn, mainMutable.add(3, placeY, -3));
                            this.setWillowLeaves(worldIn, mainMutable.add(-3, placeY, -3));
                        }
                    }

                    if (placeX <= 1 && placeX >= -1 && placeZ <= 1 && placeZ >= -1) {
                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 1, placeZ));
                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 1, 2));
                        this.setWillowLeaves(worldIn, mainMutable.add(placeX, 1, -2));
                        this.setWillowLeaves(worldIn, mainMutable.add(2, 1, placeZ));
                        this.setWillowLeaves(worldIn, mainMutable.add(-2, 1, placeZ));
//                        if (randChance == 0) {
//                            this.setWillowLeaves(worldIn, mainMutable.add(placeX, 0, 4));
//                            this.setWillowLeaves(worldIn, mainMutable.add(placeX, 0, -4));
//                            this.setWillowLeaves(worldIn, mainMutable.add(4, 0, placeZ));
//                            this.setWillowLeaves(worldIn, mainMutable.add(-4, 0, placeZ));
//                        }
                    }
                }
            }
        }
        return true;
    }

    protected void setWillowLog(IWorldWriter worldIn, BlockPos pos) {
        this.setBlockStateWithoutUpdates(worldIn, pos, BYGBlocks.WILLOW_LOG.getDefaultState());
    }

    protected void setWillowLeaves(IWorldWriter worldIn, BlockPos pos) {
        if ((worldIn instanceof IWorldReader)) {
            if (((IWorldReader) worldIn).getBlockState(pos).getBlock() != BYGBlocks.WILLOW_LOG)
                this.setBlockStateWithoutUpdates(worldIn, pos, BYGBlocks.WILLOW_LEAVES.getDefaultState().with(BlockStateProperties.DISTANCE_1_7, 1));
        }
    }

    public void setBlockStateWithoutUpdates(IWorldWriter worldWriter, BlockPos blockPos, BlockState blockState) {
        worldWriter.setBlockState(blockPos, blockState, 19);
    }

    private boolean checkArea(IWorldReader world, BlockPos pos, int radius) {
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();

        for (int checkX = -radius; checkX <= radius; checkX++) {
            for (int checkZ = -radius; checkZ <= radius; checkZ++) {
                BlockPos checkArea = new BlockPos(posX + checkX, posY, posZ + checkZ);

                if (world.getBlockState(checkArea).getBlock() == BYGBlocks.WILLOW_LOG) return false;

            }
        }
        return true;
    }
}