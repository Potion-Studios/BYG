package potionstudios.byg.common.world.feature.gen.overworld.trees.jacaranda;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import potionstudios.byg.common.world.feature.config.BYGTreeConfig;
import potionstudios.byg.common.world.feature.gen.overworld.trees.util.BYGAbstractTreeFeature;

import java.util.Random;
import java.util.Set;

public class JacarandaTree2 extends BYGAbstractTreeFeature<BYGTreeConfig> {
    public JacarandaTree2(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }

    public boolean generate(Set<BlockPos> changedBlocks, WorldGenLevel worldIn, Random rand, BlockPos pos, BoundingBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
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
                    int logplacer4 = posY + randTreeHeight - 2;

                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
                    BlockPos blockpos4 = new BlockPos(posX1, logplacer4, posZ1);

                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos1, boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos4.south(2), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos4.north(2), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos4.east(2), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos4.west(2), boundsIn);

                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos4.west().below(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos4.east().below(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos4.south().below(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos4.north().below(), boundsIn);

                }
                int leavePreset = rand.nextInt(1) + 1;
                {
                    if (leavePreset == 1) {
                        int leavessquarespos = 1;
                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
                                for (int posYLeafHeight = 0; posYLeafHeight <= 3; ++posYLeafHeight) {
                                    placeLeaves(pos, config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight + 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight + 1, posZ1 - 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1 + 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1 - 2, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 1, posZ1 + 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 1, posZ1 + 1, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 + 3, topTrunkHeight - 1, posZ1 + 2, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 1, posZ1 - 3, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - 1, posZ1 - 3, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight, posZ1 - 3, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 - 3, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 1, posZ1 + 3, boundsIn, changedBlocks);


                                    if (posYLeafHeight <= 2) {
                                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + posYLeafHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight + posYLeafHeight - 3, posZ1, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight + posYLeafHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight + posYLeafHeight - 2, posZ1 - 1, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight + posYLeafHeight - 2, posZ1 - 1, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 - 3, topTrunkHeight + posYLeafHeight - 3, posZ1, boundsIn, changedBlocks);

                                        placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight + posYLeafHeight - 2, posZ1 + 3, boundsIn, changedBlocks);

                                        placeLeaves(pos, config, rand, worldIn, posX1 + 4, topTrunkHeight + posYLeafHeight - 3, posZ1, boundsIn, changedBlocks);
                                        //placePetal(LEAVES, worldIn, posX1 + 4, topTrunkHeight + posYLeafHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
//                                        placePetal(LEAVES, worldIn, posX1 + 3, topTrunkHeight + posYLeafHeight - 2, posZ1 - 1, boundsIn, changedBlocks);
                                        //placePetal(LEAVES, worldIn, posX1 + 4, topTrunkHeight + posYLeafHeight + 4, posZ1 - 2, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight + posYLeafHeight - 3, posZ1 - 3, boundsIn, changedBlocks);

                                    }
                                    if (posYLeafHeight <= 1) {
                                        placeLeaves(pos, config, rand, worldIn, posX1 - 3, topTrunkHeight + posYLeafHeight - 1, posZ1 + 1, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight + posYLeafHeight, posZ1, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight + posYLeafHeight, posZ1, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 - 3, topTrunkHeight + posYLeafHeight - 2, posZ1 + 2, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight + posYLeafHeight - 1, posZ1 + 2, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight + posYLeafHeight - 1, posZ1 + 1, boundsIn, changedBlocks);

                                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + posYLeafHeight, posZ1 + 3, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight + posYLeafHeight, posZ1 + 3, boundsIn, changedBlocks);

                                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight + posYLeafHeight - 1, posZ1 + 3, boundsIn, changedBlocks);

                                        placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight + posYLeafHeight - 1, posZ1 + 2, boundsIn, changedBlocks);

                                        placeLeaves(pos, config, rand, worldIn, posX1 + 3, topTrunkHeight + posYLeafHeight - 2, posZ1 + 1, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 + 3, topTrunkHeight + posYLeafHeight - 1, posZ1, boundsIn, changedBlocks);

                                        placeLeaves(pos, config, rand, worldIn, posX1 + 3, topTrunkHeight + posYLeafHeight - 1, posZ1 - 1, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1 + 3, topTrunkHeight + posYLeafHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + posYLeafHeight - 1, posZ1 - 3, boundsIn, changedBlocks);

                                    }
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight + posYLeafHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight + posYLeafHeight - 4, posZ1 - 2, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight + posYLeafHeight - 3, posZ1 + 4, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight + posYLeafHeight - 3, posZ1 + 3, boundsIn, changedBlocks);

                                    placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight + posYLeafHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight + posYLeafHeight - 4, posZ1 - 2, boundsIn, changedBlocks);

                                }
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