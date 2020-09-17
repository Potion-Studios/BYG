package voronoiaoc.byg.common.world.feature.features.overworld.trees.skyris;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import voronoiaoc.byg.common.world.feature.config.BYGTreeFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;

import java.util.Random;
import java.util.Set;

public class SkyrisTree3 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public SkyrisTree3(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }


    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {
        
        BlockState LEAVES = config.getLeavesProvider().getBlockState(rand, pos);
        int randTreeHeight = rand.nextInt(config.getMaxPossibleHeight()) + config.getMinHeight();
        //Positions
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < 256) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {


                Direction direction = Direction.Plane.HORIZONTAL.random(rand);
                int posY1 = 2 - rand.nextInt(1);
                int posX1 = posX;
                int posZ1 = posZ;
                int topTrunkHeight3 = posY + randTreeHeight + randTreeHeight + 8;
                int topTrunkHeight4 = posY + randTreeHeight + randTreeHeight + 10;
                int topTrunkHeight5 = posY + randTreeHeight + randTreeHeight + 11;


                for (int buildTrunk = 0; buildTrunk < randTreeHeight; ++buildTrunk) {
                    if (buildTrunk >= randTreeHeight && posY1 < 0) {
                        posX1 += direction.getXOffset();
                        posZ1 += direction.getZOffset();
                        ++posY1;
                    }

                    int logplacer = posY + buildTrunk;
                    int logplacer2 = posY + randTreeHeight;
                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
                    BlockPos blockpos2 = new BlockPos(posX1, logplacer2, posZ1);

                    //Sets Logs
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos1, boundsIn);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(2).up(), boundsIn);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(3).up(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(3).up(3), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(3).up(4), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(3).up(5), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(3).up(6), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(4).up(6), boundsIn);


                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(3).up(7).south(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(3).up(8).south(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(3).up(9).south(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(3).up(10).south(2), boundsIn);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south().up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south(2).up(2), boundsIn);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north().west(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north().west().up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north().west().up(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north().west().up(3), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north().west().up(4), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north().west().up(5), boundsIn);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north().west(2).up(6), boundsIn);


                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(2).up(4), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(2).up(5), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(2).up(6), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(2).up(7), boundsIn);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(3).up(7), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(4).up(8), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(5).up(9), boundsIn);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(2).up(8).west(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(2).up(9).west(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(2).up(10).west(3), boundsIn);

                }


                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                        int posZ2 = posZ1 + 2;

                        int posX3 = posX1 + 1;
                        int posZ3 = posZ1 - 5;

                        int posX4 = posX1 + 5;

                        int posX5 = posX1 + 4;

                        int posX6 = posX1 - 1;
                        int posZ6 = posZ1 - 1;

                        int posX7 = posX1 + 4;
                        int posZ7 = posZ1 + 2;

                        int posX8 = posX1 - 2;
                        int posZ8 = posZ1 - 2;

                        //Top Leaves
                        placeLeaves(config, rand, worldIn, posX4 + posXLeafWidth - 2, topTrunkHeight4 - 10, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX4 + posXLeafWidth, topTrunkHeight4 - 10, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX4 + posXLeafWidth - 1, topTrunkHeight4 - 10, posZ1 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX4 + posXLeafWidth - 1, topTrunkHeight4 - 10, posZ1 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

//                        Middle Leaves
                        placeLeaves(config, rand, worldIn, posX5 + posXLeafWidth - 2, topTrunkHeight5 - 15, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX5 + posXLeafWidth, topTrunkHeight5 - 15, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX5 + posXLeafWidth - 1, topTrunkHeight5 - 15, posZ1 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX5 + posXLeafWidth - 1, topTrunkHeight5 - 15, posZ1 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

//                        Bottom Leaves
                        placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth - 2, topTrunkHeight3 - 12, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight3 - 12, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth - 1, topTrunkHeight3 - 12, posZ2 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth - 1, topTrunkHeight3 - 12, posZ2 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX3 - 1 + posXLeafWidth, topTrunkHeight3 - 5, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1 + posXLeafWidth, topTrunkHeight3 - 5, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX6 + posXLeafWidth - 2, topTrunkHeight5 - 11, posZ6 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX6 + posXLeafWidth, topTrunkHeight5 - 11, posZ6 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX6 + posXLeafWidth - 1, topTrunkHeight5 - 11, posZ6 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX6 + posXLeafWidth - 1, topTrunkHeight5 - 11, posZ6 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX7 + posXLeafWidth - 2, topTrunkHeight5 - 7, posZ7 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX7 + posXLeafWidth, topTrunkHeight5 - 7, posZ7 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX7 + posXLeafWidth - 1, topTrunkHeight5 - 7, posZ7 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX7 + posXLeafWidth - 1, topTrunkHeight5 - 7, posZ7 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX8 + posXLeafWidth - 2, topTrunkHeight5 - 7, posZ8 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX8 + posXLeafWidth, topTrunkHeight5 - 7, posZ8 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX8 + posXLeafWidth - 1, topTrunkHeight5 - 7, posZ8 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX8 + posXLeafWidth - 1, topTrunkHeight5 - 7, posZ8 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        //3x3
                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                            placeLeaves(config, rand, worldIn, posX4 + posXLeafWidth - 1, topTrunkHeight4 - 9, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                            placeLeaves(config, rand, worldIn, posX5 + posXLeafWidth - 1, topTrunkHeight5 - 14, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks); //Middle

                            placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth - 1, topTrunkHeight3 - 11, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks); //Bottom

                            placeLeaves(config, rand, worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight3 - 4, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks); //Bottom

                            placeLeaves(config, rand, worldIn, posX6 + posXLeafWidth - 1, topTrunkHeight5 - 10, posZ6 + posZLeafWidthL0, boundsIn, changedBlocks); //Middle

                            placeLeaves(config, rand, worldIn, posX7 + posXLeafWidth - 1, topTrunkHeight5 - 6, posZ7 + posZLeafWidthL0, boundsIn, changedBlocks); //Middle

                            placeLeaves(config, rand, worldIn, posX8 + posXLeafWidth - 1, topTrunkHeight5 - 6, posZ8 + posZLeafWidthL0, boundsIn, changedBlocks); //Middle


                        }

                        //Top Leaves
                        placeLeaves(config, rand, worldIn, posX4 - 1, topTrunkHeight4 - 9, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX4 - 3, topTrunkHeight4 - 9, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX4 + 1, topTrunkHeight4 - 9, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX4 - 1, topTrunkHeight4 - 9, posZ1 - 2, boundsIn, changedBlocks);

                        //Middle Leaves
                        placeLeaves(config, rand, worldIn, posX5 - 1, topTrunkHeight5 - 14, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX5 - 3, topTrunkHeight5 - 14, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX5 + 1, topTrunkHeight5 - 14, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX5 - 1, topTrunkHeight5 - 14, posZ1 - 2, boundsIn, changedBlocks);

                        //Bottom Leaves
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight3 - 11, posZ2 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 3, topTrunkHeight3 - 11, posZ2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight3 - 11, posZ2 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight3 - 11, posZ2, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight3 - 4, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 3, topTrunkHeight3 - 4, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight3 - 4, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight3 - 4, posZ3, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX6 - 1, topTrunkHeight5 - 10, posZ6 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX6 - 3, topTrunkHeight5 - 10, posZ6, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX6 + 1, topTrunkHeight5 - 10, posZ6, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX6 - 1, topTrunkHeight5 - 10, posZ6 - 2, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX7 - 1, topTrunkHeight5 - 6, posZ7 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX7 - 3, topTrunkHeight5 - 6, posZ7, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX7 + 1, topTrunkHeight5 - 6, posZ7, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX7 - 1, topTrunkHeight5 - 6, posZ7 - 2, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX8 - 1, topTrunkHeight5 - 6, posZ8 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX8 - 3, topTrunkHeight5 - 6, posZ8, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX8 + 1, topTrunkHeight5 - 6, posZ8, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX8 - 1, topTrunkHeight5 - 6, posZ8 - 2, boundsIn, changedBlocks);

                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }
}