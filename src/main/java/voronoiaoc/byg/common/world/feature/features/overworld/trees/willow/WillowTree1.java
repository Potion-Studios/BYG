package voronoiaoc.byg.common.world.feature.features.overworld.trees.willow;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.*;
import net.minecraft.world.level.LevelSimulatedRW;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

import static net.minecraft.core.Direction.*;


public class WillowTree1 extends BYGAbstractTreeFeature<NoneFeatureConfiguration> {

    public WillowTree1(Codec<NoneFeatureConfiguration> configIn) {
        super(configIn);
        //setSapling((net.minecraftforge.common.IPlantable) BYGBlockList.BLUE_SPRUCE_SAPLING);
    }

    protected boolean place(Set<BlockPos> changedBlocks, WorldGenLevel worldIn, Random rand, BlockPos pos, BoundingBox boundsIn, boolean isSapling) {
        int randChance = rand.nextInt(2);
        int randTreeHeight = rand.nextInt(6) + 8;
        BlockPos blockPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        BlockPos.MutableBlockPos block = new BlockPos.MutableBlockPos().set(blockPos);
        BlockPos.MutableBlockPos mainMutable = new BlockPos.MutableBlockPos().set(block);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.below(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {
                //Trunk
                for (int i = 3; i <= randTreeHeight; i++) {
                    BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(block);
                    this.setWillowLog(changedBlocks, worldIn, mutable.move(UP, i), boundsIn);
                }

                for (int baseSize = 0; baseSize < 4; baseSize++) {
                    BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(block.above(3));
                    for (Direction direction : Plane.HORIZONTAL) {
                        mutable.set(block.above(3).relative(direction, baseSize));
                        if (worldIn.getBlockState(mutable).getBlock() != Blocks.DIRT)
                            this.setWillowLog(changedBlocks, worldIn, mutable.move(DOWN, baseSize), boundsIn);
                    }
                }
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight - 1).move(SOUTH).move(EAST), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(DOWN), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(UP, 2).move(EAST), boundsIn);
                mainMutable.set(block);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight - 1).move(WEST), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(WEST).move(UP).move(NORTH), boundsIn);
                mainMutable.set(block);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight - 2).move(NORTH), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(UP).move(NORTH), boundsIn);
                mainMutable.set(block);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight - 2).move(NORTH, 2).move(WEST), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(WEST).move(NORTH), boundsIn);
                mainMutable.set(block);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight - 2).move(NORTH, 2).move(EAST), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(NORTH), boundsIn);
                mainMutable.set(block);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight - 2).move(NORTH).move(EAST, 2), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(EAST), boundsIn);
                mainMutable.set(block);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight - 2).move(EAST), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(SOUTH), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(SOUTH), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(EAST).move(SOUTH), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(WEST, 2), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(UP).move(EAST), boundsIn);
                mainMutable.set(block);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight - 2).move(WEST), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(WEST), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(WEST).move(UP), boundsIn);
                this.setWillowLog(changedBlocks, worldIn, mainMutable.move(EAST, 2).move(NORTH).move(DOWN), boundsIn);

                mainMutable.set(block);


                this.setWillowLeaves(changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight), boundsIn);
                for (int placeX = -3; placeX <= 3; placeX++) {
                    for (int placeZ = -3; placeZ <= 3; placeZ++) {
                        if (placeX <= 2 && placeX >= -2 && placeZ <= 2 && placeZ >= -2) {
                            this.setWillowLeaves(changedBlocks, worldIn, mainMutable.offset(placeX, 0, placeZ), boundsIn);
                            this.setWillowLeaves(changedBlocks, worldIn, mainMutable.offset(3, 0, placeZ), boundsIn);
                            this.setWillowLeaves(changedBlocks, worldIn, mainMutable.offset(-3, 0, placeZ), boundsIn);
                            this.setWillowLeaves(changedBlocks, worldIn, mainMutable.offset(placeX, 0, 3), boundsIn);
                            this.setWillowLeaves(changedBlocks, worldIn, mainMutable.offset(placeX, 0, -3), boundsIn);

                            for (int placeY = -1; placeY >= -(rand.nextInt(4) + 2); placeY--) {
                                this.setWillowLeaves(changedBlocks, worldIn, mainMutable.offset(4, placeY, placeZ), boundsIn);
                                this.setWillowLeaves(changedBlocks, worldIn, mainMutable.offset(-4, placeY, placeZ), boundsIn);
                                this.setWillowLeaves(changedBlocks, worldIn, mainMutable.offset(placeX, placeY, 4), boundsIn);
                                this.setWillowLeaves(changedBlocks, worldIn, mainMutable.offset(placeX, placeY, -4), boundsIn);
                                this.setWillowLeaves(changedBlocks, worldIn, mainMutable.offset(3, placeY, 3), boundsIn);
                                this.setWillowLeaves(changedBlocks, worldIn, mainMutable.offset(-3, placeY, 3), boundsIn);
                                this.setWillowLeaves(changedBlocks, worldIn, mainMutable.offset(3, placeY, -3), boundsIn);
                                this.setWillowLeaves(changedBlocks, worldIn, mainMutable.offset(-3, placeY, -3), boundsIn);
                            }
                        }

                        if (placeX <= 1 && placeX >= -1 && placeZ <= 1 && placeZ >= -1) {
                            this.setWillowLeaves(changedBlocks, worldIn, mainMutable.offset(placeX, 1, placeZ), boundsIn);
                            this.setWillowLeaves(changedBlocks, worldIn, mainMutable.offset(placeX, 1, 2), boundsIn);
                            this.setWillowLeaves(changedBlocks, worldIn, mainMutable.offset(placeX, 1, -2), boundsIn);
                            this.setWillowLeaves(changedBlocks, worldIn, mainMutable.offset(2, 1, placeZ), boundsIn);
                            this.setWillowLeaves(changedBlocks, worldIn, mainMutable.offset(-2, 1, placeZ), boundsIn);
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

    //Log Placement
    private void setWillowLog(Set<BlockPos> setlogblock, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (canLogPlaceHereWater(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.WILLOW_LOG.defaultBlockState(), boundingBox);
        }

    }

    //Leaves Placement
    private void setWillowLeaves(Set<BlockPos> blockPos, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        BlockPos.MutableBlockPos blockpos = new BlockPos.MutableBlockPos().set(pos);
        if (isAirOrWater(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, BYGBlockList.WILLOW_LEAVES.defaultBlockState(), boundingBox);
        }
    }


    private boolean doesTreeFit(LevelSimulatedRW reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 2;

            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                    if (!canLogPlaceHereWater(reader, pos.set(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}