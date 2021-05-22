package corgiaoc.byg.common.world.feature.overworld.trees.zelkova;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;

import java.util.Random;
import java.util.Set;

public class ZelkovaTree1 extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public ZelkovaTree1(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }


    public boolean generate(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeConfig config) {

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
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 20, 5, 5, isSapling)) {
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
                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);

                    //Sets Logs
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos1, boundsIn);


                }


                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                        int posX2 = posX1 + 1;
                        int posZ2 = posZ1 + 1;

                        //Bottom Leaves
//                        placePetal(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight + 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
//                        placePetal(LEAVES, worldIn, posX1 + posXLeafWidth - 2, topTrunkHeight + 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
//                        placePetal(LEAVES, worldIn, posX1 + posXLeafWidth - 1, topTrunkHeight + 1, posZ1 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
//                        placePetal(LEAVES, worldIn, posX1 + posXLeafWidth - 1, topTrunkHeight + 1, posZ1 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        //3x3
                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                            placeLeaves(pos, config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(pos, config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(pos, config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 5, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(pos, config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 8, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                        }

                        //2x3
                        if (posXLeafWidth <= 0 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                        }

                        //Bottom Leaves
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + 3, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + 4, posZ1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);

                        //--
                        placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 1, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 1, posZ1 + 2, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 2, posZ1 + 2, boundsIn, changedBlocks);

                        //---
                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                        //------

                        placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 4, posZ1 + 2, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - 5, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - 5, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 5, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 5, posZ1 + 2, boundsIn, changedBlocks);
                        //-----
                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 6, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - 6, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 6, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 6, posZ1 + 1, boundsIn, changedBlocks);
                        //------
                        placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - 7, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - 7, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 7, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 7, posZ1 + 2, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - 8, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - 8, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 8, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 8, posZ1 + 2, boundsIn, changedBlocks);
                        //-----
                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 9, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - 9, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 9, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 9, posZ1 + 1, boundsIn, changedBlocks);
                        //------

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