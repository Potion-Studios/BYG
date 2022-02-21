package potionstudios.byg.common.world.feature.gen.overworld.trees.rainbow_eucalyptus;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import potionstudios.byg.common.world.feature.config.BYGTreeConfig;
import potionstudios.byg.common.world.feature.gen.overworld.trees.util.BYGAbstractTreeFeature;

import java.util.Random;
import java.util.Set;

public class RainbowEucalyptusTree extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public RainbowEucalyptusTree(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }


    public boolean generate(Set<BlockPos> changedBlocks, WorldGenLevel worldIn, Random rand, BlockPos pos, BoundingBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        int randTreeHeight = rand.nextInt(config.getMaxPossibleHeight()) + config.getMinHeight();
        //Positions
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.below(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {

                Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);
                int posY1 = 2 - rand.nextInt(1);
                int posX1 = posX;
                int posZ1 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;

                for (int buildTrunk = 0; buildTrunk < randTreeHeight; ++buildTrunk) {
                    if (buildTrunk >= randTreeHeight2 && posY1 < 0) {
                        posX1 += direction.getStepX();
                        posZ1 += direction.getStepZ();
                        ++posY1;
                    }

                    int logplacer = posY + buildTrunk;
                    int logplacer2 = posY + randTreeHeight;
                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
                    BlockPos blockpos2 = new BlockPos(posX1, logplacer2, posZ1);

                    //Sets Logs
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos1, boundsIn);

                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.below(5).north().west(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.below(4).north().west(), boundsIn);

                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.below(4).north(2).west(2), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.below(3).north(2).west(2), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.below(2).north(2).west(2), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.below().north(2).west(2), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.north(2).west(2), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.above().north(2).west(2), boundsIn);

                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.north().east(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.above().north(2).east(2), boundsIn);

                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.south().west(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.above().south().west(), boundsIn);

                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.below(5).south().east(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.below(6).south().east(), boundsIn);

                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.below(5).south(2).east(2), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.below(4).south(2).east(2), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.below(3).south(2).east(2), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.below(2).south(2).east(2), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.below().south(2).east(2), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.south(2).east(2), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.above().south(2).east(2), boundsIn);

                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.below(12).south().west(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.below(11).south().west(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.below(10).south(2).west(2), boundsIn);

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


                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafWidth - 2, topTrunkHeight - 9, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafWidth, topTrunkHeight - 9, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafWidth - 1, topTrunkHeight - 9, posZ2 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafWidth - 1, topTrunkHeight - 9, posZ2 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX3 + posXLeafWidth - 2, topTrunkHeight - 2, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 + posXLeafWidth, topTrunkHeight - 2, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight - 2, posZ3 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight - 2, posZ3 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX4 + posXLeafWidth - 2, topTrunkHeight - 3, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX4 + posXLeafWidth, topTrunkHeight - 3, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX4 + posXLeafWidth - 1, topTrunkHeight - 3, posZ4 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX4 + posXLeafWidth - 1, topTrunkHeight - 3, posZ4 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX3 + posXLeafWidth - 2, topTrunkHeight + 2, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 + posXLeafWidth, topTrunkHeight + 2, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight + 2, posZ3 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight + 2, posZ3 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX5 + posXLeafWidth - 2, topTrunkHeight + 2, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX5 + posXLeafWidth, topTrunkHeight + 2, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX5 + posXLeafWidth - 1, topTrunkHeight + 2, posZ5 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX5 + posXLeafWidth - 1, topTrunkHeight + 2, posZ5 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX6 + posXLeafWidth - 2, topTrunkHeight + 2, posZ6 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX6 + posXLeafWidth, topTrunkHeight + 2, posZ6 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX6 + posXLeafWidth - 1, topTrunkHeight + 2, posZ6 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX6 + posXLeafWidth - 1, topTrunkHeight + 2, posZ6 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX7 + posXLeafWidth - 2, topTrunkHeight + 2, posZ7 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX7 + posXLeafWidth, topTrunkHeight + 2, posZ7 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX7 + posXLeafWidth - 1, topTrunkHeight + 2, posZ7 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX7 + posXLeafWidth - 1, topTrunkHeight + 2, posZ7 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        //3x3
                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {
                            placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafWidth - 1, topTrunkHeight - 8, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                            placeLeaves(pos, config, rand, worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight - 1, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                            placeLeaves(pos, config, rand, worldIn, posX4 + posXLeafWidth - 1, topTrunkHeight - 2, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                            placeLeaves(pos, config, rand, worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight + 3, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                            placeLeaves(pos, config, rand, worldIn, posX5 + posXLeafWidth - 1, topTrunkHeight + 3, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                            placeLeaves(pos, config, rand, worldIn, posX6 + posXLeafWidth - 1, topTrunkHeight + 3, posZ6 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                            placeLeaves(pos, config, rand, worldIn, posX7 + posXLeafWidth - 1, topTrunkHeight + 3, posZ7 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                        }

                        //2x3
                        if (posXLeafWidth <= 0 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {
                        }

//                        //Top Leaves
                        placeLeaves(pos, config, rand, worldIn, posX2 - 1, topTrunkHeight - 8, posZ2 + 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 - 3, topTrunkHeight - 8, posZ2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + 1, topTrunkHeight - 8, posZ2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 - 1, topTrunkHeight - 8, posZ2 - 2, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX3 - 1, topTrunkHeight - 1, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 - 3, topTrunkHeight - 1, posZ3, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 + 1, topTrunkHeight - 1, posZ3, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 - 1, topTrunkHeight - 1, posZ3 - 2, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX4 - 1, topTrunkHeight - 2, posZ4 + 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX4 - 3, topTrunkHeight - 2, posZ4, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX4 + 1, topTrunkHeight - 2, posZ4, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX4 - 1, topTrunkHeight - 2, posZ4 - 2, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX3 - 1, topTrunkHeight + 3, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 - 3, topTrunkHeight + 3, posZ3, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 + 1, topTrunkHeight + 3, posZ3, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 - 1, topTrunkHeight + 3, posZ3 - 2, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX5 - 1, topTrunkHeight + 3, posZ5 + 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX5 - 3, topTrunkHeight + 3, posZ5, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX5 + 1, topTrunkHeight + 3, posZ5, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX5 - 1, topTrunkHeight + 3, posZ5 - 2, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX6 - 1, topTrunkHeight + 3, posZ6 + 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX6 - 3, topTrunkHeight + 3, posZ6, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX6 + 1, topTrunkHeight + 3, posZ6, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX6 - 1, topTrunkHeight + 3, posZ6 - 2, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX7 - 1, topTrunkHeight + 3, posZ7 + 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX7 - 3, topTrunkHeight + 3, posZ7, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX7 + 1, topTrunkHeight + 3, posZ7, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX7 - 1, topTrunkHeight + 3, posZ7 - 2, boundsIn, changedBlocks);

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