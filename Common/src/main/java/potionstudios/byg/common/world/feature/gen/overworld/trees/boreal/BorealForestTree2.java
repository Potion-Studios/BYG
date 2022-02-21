package potionstudios.byg.common.world.feature.gen.overworld.trees.boreal;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import potionstudios.byg.common.world.feature.config.BYGTreeConfig;
import potionstudios.byg.common.world.feature.gen.overworld.trees.util.BYGAbstractTreeFeature;

import java.util.Random;
import java.util.Set;

public class BorealForestTree2 extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public BorealForestTree2(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }

    public boolean generate(Set<BlockPos> changedBlocks, WorldGenLevel worldIn, Random rand, BlockPos pos, BoundingBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            if (!isDesiredGroundwDirtTag(worldIn, pos.below(), config)) {
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
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos1, boundsIn);
                }

                int leavePreset = rand.nextInt(1) + 1;
                int leaveRandomizer = rand.nextInt(10) + 1;
                int leaveRandomizer2 = rand.nextInt(65) + 1;
                int leaveRandomizer3 = rand.nextInt(4) + 1;
                int leaveRandomizer4 = rand.nextInt(25) + 17;
                int leaveRandomizer5 = rand.nextInt(2) + 1;


                int tHSub7 = 7;
                int tHSub8 = 8;
                int tHSub6 = 6;
                int tHSub4 = 4;
                int tHSub5 = 5;
                int tHSub3 = 3;
                int tHSub2 = 2;
                int tHSub1 = 1;
                {
                    if (leavePreset == 1) {
                        int leavessquarespos = 1;
                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
                                placeLeaves(pos, config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - tHSub8, posZ1, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - tHSub8, posZ1, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - tHSub8, posZ1 - 2, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - tHSub8, posZ1 + 2, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - tHSub8, posZ1 + 2, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - tHSub8, posZ1 - 2, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - tHSub8, posZ1 + 2, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - tHSub8, posZ1 - 2, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - tHSub8, posZ1 - 1, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - tHSub8, posZ1 + 1, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - tHSub8, posZ1 - 1, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - tHSub8, posZ1 + 1, boundsIn, changedBlocks);

                                if (leaveRandomizer <= 4) {
                                    placeLeaves(pos, config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub7, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - tHSub7, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - tHSub7, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - tHSub7, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - tHSub7, posZ1 + 2, boundsIn, changedBlocks);
                                } else if (leaveRandomizer > 5) {
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - tHSub7, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - tHSub7, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - tHSub7, posZ1 - 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - tHSub7, posZ1 + 1, boundsIn, changedBlocks);
                                }
                                placeLeaves(pos, config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - tHSub6, posZ1, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - tHSub6, posZ1, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - tHSub6, posZ1 - 2, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - tHSub6, posZ1 + 2, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - tHSub6, posZ1 + 2, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - tHSub6, posZ1 - 2, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - tHSub6, posZ1 + 2, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - tHSub6, posZ1 - 2, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - tHSub6, posZ1 - 1, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - tHSub6, posZ1 + 1, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - tHSub6, posZ1 - 1, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - tHSub6, posZ1 + 1, boundsIn, changedBlocks);

                                if (leaveRandomizer2 <= 40) {

                                    placeLeaves(pos, config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub5, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - tHSub5, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - tHSub5, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - tHSub5, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - tHSub5, posZ1 + 2, boundsIn, changedBlocks);
                                } else if (leaveRandomizer2 < 60) {
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - tHSub5, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - tHSub5, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - tHSub5, posZ1 - 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - tHSub5, posZ1 + 1, boundsIn, changedBlocks);
                                }
                                placeLeaves(pos, config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - tHSub4, posZ1, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - tHSub4, posZ1, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - tHSub4, posZ1 - 2, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - tHSub4, posZ1 + 2, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - tHSub4, posZ1 + 2, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - tHSub4, posZ1 - 2, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - tHSub4, posZ1 + 2, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - tHSub4, posZ1 - 2, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - tHSub4, posZ1 - 1, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - tHSub4, posZ1 + 1, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - tHSub4, posZ1 - 1, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - tHSub4, posZ1 + 1, boundsIn, changedBlocks);

                                if (leaveRandomizer3 == 1) {
                                    placeLeaves(pos, config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub3, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - tHSub3, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - tHSub3, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - tHSub3, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - tHSub3, posZ1 + 2, boundsIn, changedBlocks);
                                } else if (leaveRandomizer3 == 2) {
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - tHSub2, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - tHSub2, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - tHSub2, posZ1 - 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - tHSub2, posZ1 + 1, boundsIn, changedBlocks);
                                }
                                placeLeaves(pos, config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - tHSub1, posZ1, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - tHSub1, posZ1, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - tHSub1, posZ1 - 2, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - tHSub1, posZ1 + 2, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - tHSub1, posZ1 + 2, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - tHSub1, posZ1 - 2, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - tHSub1, posZ1 + 2, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - tHSub1, posZ1 - 2, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - tHSub1, posZ1 - 1, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - tHSub1, posZ1 + 1, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - tHSub1, posZ1 - 1, boundsIn, changedBlocks);
                                placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - tHSub1, posZ1 + 1, boundsIn, changedBlocks);

                                if (leaveRandomizer4 < 17) {
                                    placeLeaves(pos, config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);
                                } else if (leaveRandomizer4 > 19) {
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                }
                                if (leaveRandomizer5 == 1) {
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                } else if (leaveRandomizer5 == 2) {
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + 2, posZ1 - 1, boundsIn, changedBlocks);
                                    placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + 2, posZ1 + 1, boundsIn, changedBlocks);

                                }
                            }
                        }
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }


}