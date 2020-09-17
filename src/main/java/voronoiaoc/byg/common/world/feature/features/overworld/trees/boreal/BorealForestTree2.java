package voronoiaoc.byg.common.world.feature.features.overworld.trees.boreal;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import voronoiaoc.byg.common.world.feature.config.BYGTreeFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

public class BorealForestTree2 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public BorealForestTree2(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }

    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {
        BlockState LOG = config.getTrunkProvider().getBlockState(rand, pos);
        BlockState LEAVES = config.getLeavesProvider().getBlockState(rand, pos);
        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < worldIn.getHeight()) {
            BlockPos blockpos = pos.down();
            if (!isDesiredGroundwDirtTag(worldIn, blockpos, Blocks.GRASS_BLOCK) || !isDesiredGroundwDirtTag(worldIn, blockpos, BYGBlockList.PEAT)) {
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
                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos1, boundsIn);
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
                                placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - tHSub8, posZ1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - tHSub8, posZ1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - tHSub8, posZ1 - 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - tHSub8, posZ1 + 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - tHSub8, posZ1 + 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - tHSub8, posZ1 - 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - tHSub8, posZ1 + 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - tHSub8, posZ1 - 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - tHSub8, posZ1 - 1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - tHSub8, posZ1 + 1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - tHSub8, posZ1 - 1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - tHSub8, posZ1 + 1, boundsIn, changedBlocks);

                                if (leaveRandomizer <= 4) {
                                    placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub7, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - tHSub7, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - tHSub7, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - tHSub7, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - tHSub7, posZ1 + 2, boundsIn, changedBlocks);
                                } else if (leaveRandomizer > 5) {
                                    placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - tHSub7, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - tHSub7, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - tHSub7, posZ1 - 1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - tHSub7, posZ1 + 1, boundsIn, changedBlocks);
                                }
                                placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - tHSub6, posZ1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - tHSub6, posZ1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - tHSub6, posZ1 - 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - tHSub6, posZ1 + 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - tHSub6, posZ1 + 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - tHSub6, posZ1 - 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - tHSub6, posZ1 + 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - tHSub6, posZ1 - 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - tHSub6, posZ1 - 1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - tHSub6, posZ1 + 1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - tHSub6, posZ1 - 1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - tHSub6, posZ1 + 1, boundsIn, changedBlocks);

                                if (leaveRandomizer2 <= 40) {

                                    placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub5, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - tHSub5, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - tHSub5, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - tHSub5, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - tHSub5, posZ1 + 2, boundsIn, changedBlocks);
                                } else if (leaveRandomizer2 < 60) {
                                    placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - tHSub5, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - tHSub5, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - tHSub5, posZ1 - 1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - tHSub5, posZ1 + 1, boundsIn, changedBlocks);
                                }
                                placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - tHSub4, posZ1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - tHSub4, posZ1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - tHSub4, posZ1 - 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - tHSub4, posZ1 + 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - tHSub4, posZ1 + 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - tHSub4, posZ1 - 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - tHSub4, posZ1 + 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - tHSub4, posZ1 - 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - tHSub4, posZ1 - 1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - tHSub4, posZ1 + 1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - tHSub4, posZ1 - 1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - tHSub4, posZ1 + 1, boundsIn, changedBlocks);

                                if (leaveRandomizer3 == 1) {
                                    placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub3, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - tHSub3, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - tHSub3, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - tHSub3, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - tHSub3, posZ1 + 2, boundsIn, changedBlocks);
                                } else if (leaveRandomizer3 == 2) {
                                    placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - tHSub2, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - tHSub2, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - tHSub2, posZ1 - 1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - tHSub2, posZ1 + 1, boundsIn, changedBlocks);
                                }
                                placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - tHSub1, posZ1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - tHSub1, posZ1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - tHSub1, posZ1 - 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - tHSub1, posZ1 + 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - tHSub1, posZ1 + 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - tHSub1, posZ1 - 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - tHSub1, posZ1 + 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - tHSub1, posZ1 - 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - tHSub1, posZ1 - 1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - tHSub1, posZ1 + 1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - tHSub1, posZ1 - 1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - tHSub1, posZ1 + 1, boundsIn, changedBlocks);

                                if (leaveRandomizer4 < 17) {
                                    placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);
                                } else if (leaveRandomizer4 > 19) {
                                    placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                }
                                if (leaveRandomizer5 == 1) {
                                    placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                } else if (leaveRandomizer5 == 2) {
                                    placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight + 2, posZ1 - 1, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight + 2, posZ1 + 1, boundsIn, changedBlocks);

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