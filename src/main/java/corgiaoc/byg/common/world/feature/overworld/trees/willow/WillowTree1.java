package corgiaoc.byg.common.world.feature.overworld.trees.willow;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;

import java.util.Random;
import java.util.Set;

import static net.minecraft.util.Direction.*;


public class WillowTree1 extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public WillowTree1(Codec<BYGTreeConfig> configIn) {
        super(configIn);
        //setSapling((net.minecraftforge.common.IPlantable) BYGBlocks.BLUE_SPRUCE_SAPLING);
    }

    protected boolean generate(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        int randTreeHeight = rand.nextInt(config.getMaxPossibleHeight()) + config.getMinHeight();
        BlockPos blockPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        BlockPos.Mutable block = new BlockPos.Mutable().set(blockPos);
        BlockPos.Mutable mainMutable = new BlockPos.Mutable().set(block);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            if (!isDesiredGroundwDirtTag(worldIn, pos.below(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {
                //Trunk
                for (int i = 3; i <= randTreeHeight; i++) {
                    BlockPos.Mutable mutable = new BlockPos.Mutable().set(block);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, mutable.move(UP, i), boundsIn);
                }

                for (int baseSize = 0; baseSize < 4; baseSize++) {
                    BlockPos.Mutable mutable = new BlockPos.Mutable().set(block.above(3));
                    for (Direction direction : Direction.Plane.HORIZONTAL) {
                        mutable.set(block.above(3).relative(direction, baseSize));
                        if (worldIn.getBlockState(mutable).getBlock() != Blocks.DIRT)
                            placeTrunk(pos, config, rand, changedBlocks, worldIn, mutable.move(DOWN, baseSize), boundsIn);
                    }
                }
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight - 1).move(SOUTH).move(EAST), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainMutable.move(DOWN), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainMutable.move(UP, 2).move(EAST), boundsIn);
                mainMutable.set(block);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight - 1).move(WEST), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainMutable.move(WEST).move(UP).move(NORTH), boundsIn);
                mainMutable.set(block);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight - 2).move(NORTH), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainMutable.move(UP).move(NORTH), boundsIn);
                mainMutable.set(block);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight - 2).move(NORTH, 2).move(WEST), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainMutable.move(WEST).move(NORTH), boundsIn);
                mainMutable.set(block);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight - 2).move(NORTH, 2).move(EAST), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainMutable.move(NORTH), boundsIn);
                mainMutable.set(block);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight - 2).move(NORTH).move(EAST, 2), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainMutable.move(EAST), boundsIn);
                mainMutable.set(block);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight - 2).move(EAST), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainMutable.move(SOUTH), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainMutable.move(SOUTH), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainMutable.move(EAST).move(SOUTH), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainMutable.move(WEST, 2), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainMutable.move(UP).move(EAST), boundsIn);
                mainMutable.set(block);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight - 2).move(WEST), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainMutable.move(WEST), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainMutable.move(WEST).move(UP), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainMutable.move(EAST, 2).move(NORTH).move(DOWN), boundsIn);

                mainMutable.set(block);


                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainMutable.move(UP, randTreeHeight), boundsIn);
                for (int placeX = -3; placeX <= 3; placeX++) {
                    for (int placeZ = -3; placeZ <= 3; placeZ++) {
                        if (placeX <= 2 && placeX >= -2 && placeZ <= 2 && placeZ >= -2) {
                            placeLeaves(pos, config, rand, changedBlocks, worldIn, mainMutable.set(pos).move(placeX, 0, placeZ), boundsIn);
                            placeLeaves(pos, config, rand, changedBlocks, worldIn, mainMutable.set(pos).move(3, 0, placeZ), boundsIn);
                            placeLeaves(pos, config, rand, changedBlocks, worldIn, mainMutable.set(pos).move(-3, 0, placeZ), boundsIn);
                            placeLeaves(pos, config, rand, changedBlocks, worldIn, mainMutable.set(pos).move(placeX, 0, 3), boundsIn);
                            placeLeaves(pos, config, rand, changedBlocks, worldIn, mainMutable.set(pos).move(placeX, 0, -3), boundsIn);

                            for (int placeY = randTreeHeight +1; placeY >= -(rand.nextInt(4) + 2); placeY--) {
                                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainMutable.set(pos).move(4, placeY, placeZ), boundsIn);
                                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainMutable.set(pos).move(-4, placeY, placeZ), boundsIn);
                                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainMutable.set(pos).move(placeX, placeY, 4), boundsIn);
                                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainMutable.set(pos).move(placeX, placeY, -4), boundsIn);
                                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainMutable.set(pos).move(3, placeY, 3), boundsIn);
                                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainMutable.set(pos).move(-3, placeY, 3), boundsIn);
                                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainMutable.set(pos).move(3, placeY, -3), boundsIn);
                                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainMutable.set(pos).move(-3, placeY, -3), boundsIn);
                            }
                        }

                        if (placeX <= 1 && placeX >= -1 && placeZ <= 1 && placeZ >= -1) {
                            placeLeaves(pos, config, rand, changedBlocks, worldIn, mainMutable.set(pos).move(placeX, 1, placeZ), boundsIn);
                            placeLeaves(pos, config, rand, changedBlocks, worldIn, mainMutable.set(pos).move(placeX, 1, 2), boundsIn);
                            placeLeaves(pos, config, rand, changedBlocks, worldIn, mainMutable.set(pos).move(placeX, 1, -2), boundsIn);
                            placeLeaves(pos, config, rand, changedBlocks, worldIn, mainMutable.set(pos).move(2, 1, placeZ), boundsIn);
                            placeLeaves(pos, config, rand, changedBlocks, worldIn, mainMutable.set(pos).move(-2, 1, placeZ), boundsIn);
                        }
                    }
                }
            }
        }
        return true;
    }
}