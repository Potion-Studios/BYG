package corgiaoc.byg.common.world.feature.features.overworld.trees.tropical;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import corgiaoc.byg.common.world.feature.featureconfig.BYGTreeFeatureConfig;
import corgiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;

import java.util.Random;
import java.util.Set;

public class ShortTropicalRainForestTree extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public ShortTropicalRainForestTree(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }

    protected static boolean canTreePlace(IWorldGenerationBaseReader genBaseReader, BlockPos blockPos) {
        return canLogPlaceHere(
                genBaseReader, blockPos
        );
    }

    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {

        int randTreeHeight = rand.nextInt(2) + rand.nextInt(2) + 3;
        //Positions
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < 256) {
            BlockPos checkGround = pos.down();
            if (!isDesiredGroundwDirtTag(worldIn, checkGround, Blocks.GRASS_BLOCK)) {
                return false;
            } else {
                //this.setGroundBlockAt(worldIn, checkGround, pos, Blocks.STONE.getDefaultState());


                Direction direction = Direction.Plane.HORIZONTAL.random(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);
                int posY1 = 2 - rand.nextInt(1);
                int posX1 = posX;
                int posZ1 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;


                for (int buildTrunk = 0; buildTrunk < randTreeHeight; ++buildTrunk) {
                    if (buildTrunk >= randTreeHeight2 && posY1 < 0) {
                        posX1 += direction.getXOffset();
                        posZ1 += direction.getZOffset();
                        ++posY1;
                    }
                    int logplacer = posY + buildTrunk;
                    int logplacer1 = posY + randTreeHeight;
                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
                    BlockPos blockpos2 = new BlockPos(posX1, logplacer1, posZ1);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos1, boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west().up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east().up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north().up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south().up(), boundsIn);
//                    placeStem(LOG, changedBlocks, worldIn, blockpos2.west(2).up(1), boundsIn);
//                    placeStem(LOG, changedBlocks, worldIn, blockpos2.east(2).up(1), boundsIn);
//                    placeStem(LOG, changedBlocks, worldIn, blockpos2.north(2).up(1), boundsIn);
//                    placeStem(LOG, changedBlocks, worldIn, blockpos2.south(2).up(1), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west(2).up(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(2).up(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(2).up(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south(2).up(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west(2).up(3), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(2).up(3), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(2).up(3), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south(2).up(3), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west(2).up(4), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(2).up(4), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(2).up(4), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south(2).up(4), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west(2).up(5), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(2).up(5), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(2).up(5), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south(2).up(5), boundsIn);
                }
                int leavePreset = 1;
                {
                    if (leavePreset == 1) {
                        int leavessquarespos = 1;
                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
                                placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight + 5, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth) - 3, topTrunkHeight + 5, (posZ1 + posZLeafWidthL0), boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth) + 3, topTrunkHeight + 5, (posZ1 + posZLeafWidthL0), boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth), topTrunkHeight + 5, (posZ1 + posZLeafWidthL0) + 3, boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth), topTrunkHeight + 5, (posZ1 + posZLeafWidthL0) - 3, boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth) - 3, topTrunkHeight + 5, (posZ1 + posZLeafWidthL0) - 2, boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth) + 3, topTrunkHeight + 5, (posZ1 + posZLeafWidthL0) + 2, boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth) - 2, topTrunkHeight + 5, (posZ1 + posZLeafWidthL0) + 3, boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth) + 2, topTrunkHeight + 5, (posZ1 + posZLeafWidthL0) - 3, boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth) - 3, topTrunkHeight + 5, (posZ1 + posZLeafWidthL0) + 2, boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth) + 3, topTrunkHeight + 5, (posZ1 + posZLeafWidthL0) - 2, boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth) + 2, topTrunkHeight + 5, (posZ1 + posZLeafWidthL0) + 3, boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth) - 2, topTrunkHeight + 5, (posZ1 + posZLeafWidthL0) - 3, boundsIn, changedBlocks);


                                placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight + 6, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth) - 2, topTrunkHeight + 6, (posZ1 + posZLeafWidthL0), boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth) + 2, topTrunkHeight + 6, (posZ1 + posZLeafWidthL0), boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth), topTrunkHeight + 6, (posZ1 + posZLeafWidthL0) + 2, boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth), topTrunkHeight + 6, (posZ1 + posZLeafWidthL0) - 2, boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth) - 1, topTrunkHeight + 6, (posZ1 + posZLeafWidthL0) - 1, boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth) + 1, topTrunkHeight + 6, (posZ1 + posZLeafWidthL0) + 1, boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth) - 1, topTrunkHeight + 6, (posZ1 + posZLeafWidthL0) + 1, boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth) + 1, topTrunkHeight + 6, (posZ1 + posZLeafWidthL0) - 1, boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth) - 1, topTrunkHeight + 6, (posZ1 + posZLeafWidthL0) + 1, boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth) + 1, topTrunkHeight + 6, (posZ1 + posZLeafWidthL0) - 1, boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth) + 1, topTrunkHeight + 6, (posZ1 + posZLeafWidthL0) + 1, boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth) - 1, topTrunkHeight + 6, (posZ1 + posZLeafWidthL0) - 1, boundsIn, changedBlocks);


                                placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight + 7, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth) - 1, topTrunkHeight + 7, (posZ1 + posZLeafWidthL0), boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth) + 1, topTrunkHeight + 7, (posZ1 + posZLeafWidthL0), boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth), topTrunkHeight + 7, (posZ1 + posZLeafWidthL0) + 1, boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, (posX1 + posXLeafWidth), topTrunkHeight + 7, (posZ1 + posZLeafWidthL0) - 1, boundsIn, changedBlocks);


                                placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight + 8, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);


//                                placePetal(LEAVES, worldIn, posX1, topTrunkHeight + 9, posZ1, boundsIn, changedBlocks);
//                                placePetal(LEAVES, worldIn, posX1 - 1, topTrunkHeight + 9, posZ1, boundsIn, changedBlocks);
//                                placePetal(LEAVES, worldIn, posX1 + 1, topTrunkHeight + 9, posZ1, boundsIn, changedBlocks);
//                                placePetal(LEAVES, worldIn, posX1, topTrunkHeight + 9, posZ1 - 1, boundsIn, changedBlocks);
//                                placePetal(LEAVES, worldIn, posX1, topTrunkHeight + 9, posZ1 + 1, boundsIn, changedBlocks);
                            }
                        }
                    } else if (leavePreset == 2) {
                        int leavessquarespos = rand.nextInt(1) + 1;
                        for (int posXLeafWidth = (leavessquarespos * -1); posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = (leavessquarespos * -1); posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
                                placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight + 6, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                            }
                        }
                    } else if (leavePreset == 3) {
                        int leavessquarespos = rand.nextInt(1) + 1;
                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                            }
                        }
                    }
                }
            }

            return true;
            //}
        } else {
            return false;
        }
    }
}