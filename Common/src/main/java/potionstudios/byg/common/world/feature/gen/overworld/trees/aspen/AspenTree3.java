package potionstudios.byg.common.world.feature.gen.overworld.trees.aspen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import potionstudios.byg.common.world.feature.config.BYGTreeConfig;
import potionstudios.byg.common.world.feature.gen.overworld.trees.util.BYGAbstractTreeFeature;

import java.util.Random;
import java.util.Set;

public class AspenTree3 extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public AspenTree3(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }

    public boolean generate(Set<BlockPos> changedBlocks, WorldGenLevel worldIn, Random rand, BlockPos pos, BoundingBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        int minHeight = config.getMinHeight();
        int randTreeHeight = rand.nextInt(config.getMaxPossibleHeight()) + minHeight;
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

                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos1, boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.north().west(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.below().south().east(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.south().east(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.above().south().east(), boundsIn);

                }

                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                        int posX2 = posX1 + 1;
                        int posZ2 = posZ1 + 1;

                        int posX3 = posX1 - 1;
                        int posZ3 = posZ1 - 1;

                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                            placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafWidth, topTrunkHeight + 3, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(pos, config, rand, worldIn, posX3 + posXLeafWidth, topTrunkHeight + 2, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        }

                        //Left Leaves
                        placeLeaves(pos, config, rand, worldIn, posX2 + 1, topTrunkHeight + 2, posZ2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + 2, topTrunkHeight + 2, posZ2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + 1, topTrunkHeight + 1, posZ2, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX2, topTrunkHeight + 2, posZ2 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2, topTrunkHeight + 2, posZ2 + 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2, topTrunkHeight + 3, posZ2 + 2, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX2 - 1, topTrunkHeight + 2, posZ2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 - 2, topTrunkHeight + 2, posZ2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 - 2, topTrunkHeight + 3, posZ2, boundsIn, changedBlocks);


                        placeLeaves(pos, config, rand, worldIn, posX2, topTrunkHeight + 1, posZ2 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2, topTrunkHeight + 3, posZ2 - 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2, topTrunkHeight + 2, posZ2 - 2, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX2 + 1, topTrunkHeight + 3, posZ2 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + 1, topTrunkHeight + 2, posZ2 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + 2, topTrunkHeight + 3, posZ2 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + 1, topTrunkHeight + 2, posZ2 - 2, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX2 - 1, topTrunkHeight + 3, posZ2 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 - 1, topTrunkHeight + 3, posZ2 - 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 - 2, topTrunkHeight + 2, posZ2 - 1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX2 - 1, topTrunkHeight + 3, posZ2 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 - 2, topTrunkHeight + 3, posZ2 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 - 1, topTrunkHeight + 3, posZ2 + 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 - 1, topTrunkHeight + 2, posZ2 + 1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX2 + 1, topTrunkHeight + 3, posZ2 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + 1, topTrunkHeight + 3, posZ2 + 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + 1, topTrunkHeight + 2, posZ2 + 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + 2, topTrunkHeight + 2, posZ2 + 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + 2, topTrunkHeight + 3, posZ2 + 1, boundsIn, changedBlocks);


                        placeLeaves(pos, config, rand, worldIn, posX2, topTrunkHeight + 4, posZ2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2, topTrunkHeight + 5, posZ2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2, topTrunkHeight + 6, posZ2, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX2, topTrunkHeight + 4, posZ2 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 - 1, topTrunkHeight + 4, posZ2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + 1, topTrunkHeight + 4, posZ2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2, topTrunkHeight + 4, posZ2 - 1, boundsIn, changedBlocks);

                        //Right Leaves
                        placeLeaves(pos, config, rand, worldIn, posX3 + 1, topTrunkHeight + 1, posZ3, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 + 2, topTrunkHeight + 1, posZ3, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 + 1, topTrunkHeight, posZ3, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX3, topTrunkHeight, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3, topTrunkHeight, posZ3 + 3, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3, topTrunkHeight, posZ3 + 3, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX3 - 1, topTrunkHeight + 1, posZ3, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 - 2, topTrunkHeight + 1, posZ3, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 - 2, topTrunkHeight + 2, posZ3, boundsIn, changedBlocks);


                        placeLeaves(pos, config, rand, worldIn, posX3, topTrunkHeight, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3, topTrunkHeight + 1, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3, topTrunkHeight + 1, posZ3 - 2, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX3 + 1, topTrunkHeight + 2, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 + 1, topTrunkHeight + 1, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 + 2, topTrunkHeight + 2, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 + 1, topTrunkHeight + 1, posZ3 - 2, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX3 - 1, topTrunkHeight + 2, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 - 1, topTrunkHeight + 2, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 - 2, topTrunkHeight + 1, posZ3 - 1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX3 - 1, topTrunkHeight + 2, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 - 2, topTrunkHeight + 2, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 - 1, topTrunkHeight + 2, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 - 1, topTrunkHeight + 1, posZ3 + 1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX3 + 1, topTrunkHeight + 2, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 + 1, topTrunkHeight + 2, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 + 1, topTrunkHeight + 1, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 + 2, topTrunkHeight + 1, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 + 2, topTrunkHeight + 2, posZ3 + 1, boundsIn, changedBlocks);


                        placeLeaves(pos, config, rand, worldIn, posX3, topTrunkHeight + 3, posZ3, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3, topTrunkHeight + 4, posZ3, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3, topTrunkHeight + 5, posZ3, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX3, topTrunkHeight + 3, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 - 1, topTrunkHeight + 3, posZ3, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 + 1, topTrunkHeight + 3, posZ3, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3, topTrunkHeight + 3, posZ3 - 1, boundsIn, changedBlocks);

                        //Foilage
                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }
}