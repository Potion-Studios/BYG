package voronoiaoc.byg.common.world.feature.features.overworld.trees.willow;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import voronoiaoc.byg.common.world.feature.config.BYGTreeFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

import static net.minecraft.util.Direction.*;


public class WillowTree1 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public WillowTree1(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
        //setSapling((net.minecraftforge.common.IPlantable) BYGBlockList.BLUE_SPRUCE_SAPLING);
    }

    protected boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {
        BlockState LOG = config.getTrunkProvider().getBlockState(rand, pos);
        BlockState LEAVES = config.getLeavesProvider().getBlockState(rand, pos);
        int randChance = rand.nextInt(2);
        int randTreeHeight = rand.nextInt(6) + 8;
        BlockPos blockPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        BlockPos.Mutable block = new BlockPos.Mutable().setPos(blockPos);
        BlockPos.Mutable mainMutable = new BlockPos.Mutable().setPos(block);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {
                //Trunk
                for (int i = 3; i <= randTreeHeight; i++) {
                    BlockPos.Mutable mutable = new BlockPos.Mutable().setPos(block);
                    this.setWillowLog(changedBlocks, worldIn, mutable.move(UP, i), boundsIn);
                }

                for (int baseSize = 0; baseSize < 4; baseSize++) {
                    BlockPos.Mutable mutable = new BlockPos.Mutable().setPos(block.up(3));
                    for (Direction direction : Direction.Plane.HORIZONTAL) {
                        mutable.setPos(block.up(3).offset(direction, baseSize));
                        if (worldIn.getBlockState(mutable).getBlock() != Blocks.DIRT)
                            this.setWillowLog(changedBlocks, worldIn, mutable.move(DOWN, baseSize), boundsIn);
                    }
                }
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight - 1).move(SOUTH).move(EAST), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(DOWN), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(UP, 2).move(EAST), boundsIn);
                mainMutable.setPos(block);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight - 1).move(WEST), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(WEST).move(UP).move(NORTH), boundsIn);
                mainMutable.setPos(block);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight - 2).move(NORTH), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(UP).move(NORTH), boundsIn);
                mainMutable.setPos(block);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight - 2).move(NORTH, 2).move(WEST), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(WEST).move(NORTH), boundsIn);
                mainMutable.setPos(block);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight - 2).move(NORTH, 2).move(EAST), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(NORTH), boundsIn);
                mainMutable.setPos(block);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight - 2).move(NORTH).move(EAST, 2), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(EAST), boundsIn);
                mainMutable.setPos(block);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight - 2).move(EAST), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(SOUTH), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(SOUTH), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(EAST).move(SOUTH), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(WEST, 2), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(UP).move(EAST), boundsIn);
                mainMutable.setPos(block);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight - 2).move(WEST), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(WEST), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(WEST).move(UP), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(EAST, 2).move(NORTH).move(DOWN), boundsIn);

                mainMutable.setPos(block);


                this.setWillowLeaves(changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight), boundsIn);
                for (int placeX = -3; placeX <= 3; placeX++) {
                    for (int placeZ = -3; placeZ <= 3; placeZ++) {
                        if (placeX <= 2 && placeX >= -2 && placeZ <= 2 && placeZ >= -2) {
                            this.setWillowLeaves(changedBlocks, worldIn, mainMutable.add(placeX, 0, placeZ), boundsIn);
                            this.setWillowLeaves(changedBlocks, worldIn, mainMutable.add(3, 0, placeZ), boundsIn);
                            this.setWillowLeaves(changedBlocks, worldIn, mainMutable.add(-3, 0, placeZ), boundsIn);
                            this.setWillowLeaves(changedBlocks, worldIn, mainMutable.add(placeX, 0, 3), boundsIn);
                            this.setWillowLeaves(changedBlocks, worldIn, mainMutable.add(placeX, 0, -3), boundsIn);

                            for (int placeY = -1; placeY >= -(rand.nextInt(4) + 2); placeY--) {
                                this.setWillowLeaves(changedBlocks, worldIn, mainMutable.add(4, placeY, placeZ), boundsIn);
                                this.setWillowLeaves(changedBlocks, worldIn, mainMutable.add(-4, placeY, placeZ), boundsIn);
                                this.setWillowLeaves(changedBlocks, worldIn, mainMutable.add(placeX, placeY, 4), boundsIn);
                                this.setWillowLeaves(changedBlocks, worldIn, mainMutable.add(placeX, placeY, -4), boundsIn);
                                this.setWillowLeaves(changedBlocks, worldIn, mainMutable.add(3, placeY, 3), boundsIn);
                                this.setWillowLeaves(changedBlocks, worldIn, mainMutable.add(-3, placeY, 3), boundsIn);
                                this.setWillowLeaves(changedBlocks, worldIn, mainMutable.add(3, placeY, -3), boundsIn);
                                this.setWillowLeaves(changedBlocks, worldIn, mainMutable.add(-3, placeY, -3), boundsIn);
                            }
                        }

                        if (placeX <= 1 && placeX >= -1 && placeZ <= 1 && placeZ >= -1) {
                            this.setWillowLeaves(changedBlocks, worldIn, mainMutable.add(placeX, 1, placeZ), boundsIn);
                            this.setWillowLeaves(changedBlocks, worldIn, mainMutable.add(placeX, 1, 2), boundsIn);
                            this.setWillowLeaves(changedBlocks, worldIn, mainMutable.add(placeX, 1, -2), boundsIn);
                            this.setWillowLeaves(changedBlocks, worldIn, mainMutable.add(2, 1, placeZ), boundsIn);
                            this.setWillowLeaves(changedBlocks, worldIn, mainMutable.add(-2, 1, placeZ), boundsIn);
//                        if (randChance == 0) {
//                            this.setWillowLeaves(changedBlocks, worldIn, mainMutable.add(placeX, 0, 4));
//                            this.setWillowLeaves(changedBlocks, worldIn, mainMutable.add(placeX, 0, -4));
//                            this.setWillowLeaves(changedBlocks, worldIn, mainMutable.add(4, 0, placeZ));
//                            this.setWillowLeaves(changedBlocks, worldIn, mainMutable.add(-4, 0, placeZ));
//                        }
                        }
                    }
                }
            }
        }
        return true;
    }


    private void setWillowLog(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHereWater(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.WILLOW_LOG.getDefaultState(), boundingBox);
        }

    }


    private void setWillowLeaves(Set<BlockPos> blockPos, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        BlockPos.Mutable blockpos = new BlockPos.Mutable().setPos(pos);
        if (isAirOrWater(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, BYGBlockList.WILLOW_LEAVES.getDefaultState(), boundingBox);
        }
    }


    private boolean doesTreeFit(IWorldGenerationBaseReader reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.Mutable pos = new BlockPos.Mutable();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 2;

            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                    if (!canLogPlaceHereWater(reader, pos.setPos(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}