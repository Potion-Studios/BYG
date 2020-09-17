package voronoiaoc.byg.common.world.feature.features.overworld.trees.bluff;

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

public class BluffTree extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public BluffTree(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }

    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {
        BlockState LOG = config.getTrunkProvider().getBlockState(rand, pos);
        BlockState LEAVES = config.getLeavesProvider().getBlockState(rand, pos);
        int randTreeHeight = rand.nextInt(config.getMaxPossibleHeight()) + config.getMinHeight();
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

                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos1, boundsIn);
                }


                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                        //3x3
                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 4, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 6, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 8, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 10, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 12, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 14, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                        }

                        //2x3
                        if (posXLeafWidth <= 0 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                        }

                        //Bottom Leaves
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 1, posZ1 + 1, boundsIn, changedBlocks);
                        //---

                        placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - 2, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - 2, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 2, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 2, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 + 2, boundsIn, changedBlocks);

                        //------
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                        //--

                        placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 4, posZ1 + 2, boundsIn, changedBlocks);

                        //--
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 5, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 5, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 5, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 5, posZ1 + 1, boundsIn, changedBlocks);
                        //---

                        placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - 6, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - 6, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - 6, posZ1 - 1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - 6, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - 6, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - 6, posZ1 - 1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 6, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 6, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 6, posZ1 - 2, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 6, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 6, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 6, posZ1 + 2, boundsIn, changedBlocks);

                        //------
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 7, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 7, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 7, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 7, posZ1 + 1, boundsIn, changedBlocks);
                        //--

                        placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - 8, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - 8, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 8, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 8, posZ1 + 2, boundsIn, changedBlocks);

                        //--
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 9, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 9, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 9, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 9, posZ1 + 1, boundsIn, changedBlocks);
                        //---

                        placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - 10, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - 10, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - 10, posZ1 - 1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - 10, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - 10, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - 10, posZ1 - 1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 10, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 10, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 10, posZ1 - 2, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 10, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 10, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 10, posZ1 + 2, boundsIn, changedBlocks);

                        //------
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 11, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 11, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 11, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 11, posZ1 + 1, boundsIn, changedBlocks);

                        //--

                        placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - 12, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - 12, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 12, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 12, posZ1 + 2, boundsIn, changedBlocks);

                        //--

                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 13, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 13, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 13, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 13, posZ1 + 1, boundsIn, changedBlocks);
                        //---

                        placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - 14, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - 14, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - 14, posZ1 - 1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - 14, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - 14, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 2, topTrunkHeight - 14, posZ1 - 1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 14, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 14, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 14, posZ1 - 2, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 14, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 14, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 14, posZ1 + 2, boundsIn, changedBlocks);

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