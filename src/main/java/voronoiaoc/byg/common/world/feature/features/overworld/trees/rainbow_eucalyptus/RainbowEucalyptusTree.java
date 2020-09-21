package voronoiaoc.byg.common.world.feature.features.overworld.trees.rainbow_eucalyptus;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import voronoiaoc.byg.common.world.feature.featureconfig.BYGTreeFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;

import java.util.Random;
import java.util.Set;

public class RainbowEucalyptusTree extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public RainbowEucalyptusTree(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }


    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {

        int randTreeHeight = rand.nextInt(config.getMaxPossibleHeight()) + config.getMinHeight();
        //Positions
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < worldIn.getHeight()) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {

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
                    int logplacer2 = posY + randTreeHeight;
                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
                    BlockPos blockpos2 = new BlockPos(posX1, logplacer2, posZ1);

                    //Sets Logs
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos1, boundsIn);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.down(5).north().west(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.down(4).north().west(), boundsIn);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.down(4).north(2).west(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.down(3).north(2).west(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.down(2).north(2).west(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.down().north(2).west(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(2).west(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.up().north(2).west(2), boundsIn);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north().east(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.up().north(2).east(2), boundsIn);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south().west(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.up().south().west(), boundsIn);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.down(5).south().east(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.down(6).south().east(), boundsIn);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.down(5).south(2).east(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.down(4).south(2).east(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.down(3).south(2).east(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.down(2).south(2).east(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.down().south(2).east(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.south(2).east(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.up().south(2).east(2), boundsIn);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.down(12).south().west(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.down(11).south().west(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.down(10).south(2).west(2), boundsIn);

                }


                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                        int posX2 = posX1 - 1;
                        int posZ2 = posZ1 + 2;

                        int posX3 = posX1 - 1;
                        int posZ3 = posZ1 - 2;

                        int posX4 = posX1 + 2;
                        int posZ4 = posZ1 + 1;

                        int posX5 = posX1 + 3;
                        int posZ5 = posZ1 + 2;

                        int posX6 = posX1 + 3;
                        int posZ6 = posZ1 - 2;

                        int posX7 = posX1 + 1;
                        int posZ7 = posZ1 + 1;


                        placeLeaves(config, rand, worldIn, posX2 + posXLeafWidth - 2, topTrunkHeight - 9, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX2 + posXLeafWidth, topTrunkHeight - 9, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX2 + posXLeafWidth - 1, topTrunkHeight - 9, posZ2 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX2 + posXLeafWidth - 1, topTrunkHeight - 9, posZ2 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX3 + posXLeafWidth - 2, topTrunkHeight - 2, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + posXLeafWidth, topTrunkHeight - 2, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight - 2, posZ3 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight - 2, posZ3 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX4 + posXLeafWidth - 2, topTrunkHeight - 3, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX4 + posXLeafWidth, topTrunkHeight - 3, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX4 + posXLeafWidth - 1, topTrunkHeight - 3, posZ4 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX4 + posXLeafWidth - 1, topTrunkHeight - 3, posZ4 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX3 + posXLeafWidth - 2, topTrunkHeight + 2, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + posXLeafWidth, topTrunkHeight + 2, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight + 2, posZ3 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight + 2, posZ3 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX5 + posXLeafWidth - 2, topTrunkHeight + 2, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX5 + posXLeafWidth, topTrunkHeight + 2, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX5 + posXLeafWidth - 1, topTrunkHeight + 2, posZ5 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX5 + posXLeafWidth - 1, topTrunkHeight + 2, posZ5 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX6 + posXLeafWidth - 2, topTrunkHeight + 2, posZ6 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX6 + posXLeafWidth, topTrunkHeight + 2, posZ6 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX6 + posXLeafWidth - 1, topTrunkHeight + 2, posZ6 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX6 + posXLeafWidth - 1, topTrunkHeight + 2, posZ6 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX7 + posXLeafWidth - 2, topTrunkHeight + 2, posZ7 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX7 + posXLeafWidth, topTrunkHeight + 2, posZ7 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX7 + posXLeafWidth - 1, topTrunkHeight + 2, posZ7 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX7 + posXLeafWidth - 1, topTrunkHeight + 2, posZ7 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        //3x3
                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {
                            placeLeaves(config, rand, worldIn, posX2 + posXLeafWidth - 1, topTrunkHeight - 8, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                            placeLeaves(config, rand, worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight - 1, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                            placeLeaves(config, rand, worldIn, posX4 + posXLeafWidth - 1, topTrunkHeight - 2, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                            placeLeaves(config, rand, worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight + 3, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                            placeLeaves(config, rand, worldIn, posX5 + posXLeafWidth - 1, topTrunkHeight + 3, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                            placeLeaves(config, rand, worldIn, posX6 + posXLeafWidth - 1, topTrunkHeight + 3, posZ6 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                            placeLeaves(config, rand, worldIn, posX7 + posXLeafWidth - 1, topTrunkHeight + 3, posZ7 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                        }

                        //2x3
                        if (posXLeafWidth <= 0 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {
                        }

//                        //Top Leaves
                        placeLeaves(config, rand, worldIn, posX2 - 1, topTrunkHeight - 8, posZ2 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX2 - 3, topTrunkHeight - 8, posZ2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX2 + 1, topTrunkHeight - 8, posZ2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX2 - 1, topTrunkHeight - 8, posZ2 - 2, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight - 1, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 3, topTrunkHeight - 1, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight - 1, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight - 1, posZ3 - 2, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX4 - 1, topTrunkHeight - 2, posZ4 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX4 - 3, topTrunkHeight - 2, posZ4, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX4 + 1, topTrunkHeight - 2, posZ4, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX4 - 1, topTrunkHeight - 2, posZ4 - 2, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight + 3, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 3, topTrunkHeight + 3, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight + 3, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight + 3, posZ3 - 2, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX5 - 1, topTrunkHeight + 3, posZ5 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX5 - 3, topTrunkHeight + 3, posZ5, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX5 + 1, topTrunkHeight + 3, posZ5, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX5 - 1, topTrunkHeight + 3, posZ5 - 2, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX6 - 1, topTrunkHeight + 3, posZ6 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX6 - 3, topTrunkHeight + 3, posZ6, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX6 + 1, topTrunkHeight + 3, posZ6, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX6 - 1, topTrunkHeight + 3, posZ6 - 2, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX7 - 1, topTrunkHeight + 3, posZ7 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX7 - 3, topTrunkHeight + 3, posZ7, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX7 + 1, topTrunkHeight + 3, posZ7, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX7 - 1, topTrunkHeight + 3, posZ7 - 2, boundsIn, changedBlocks);

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