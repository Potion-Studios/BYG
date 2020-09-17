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

public class SkyrisTree2 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public SkyrisTree2(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }


    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {
        BlockState LOG = config.getTrunkProvider().getBlockState(rand, pos);
        BlockState LEAVES = config.getLeavesProvider().getBlockState(rand, pos);
        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        //Positions
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY + randTreeHeight + 1 < worldIn.getHeight()) {

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
                int topTrunkHeight3 = posY + randTreeHeight + randTreeHeight + 8;
                int topTrunkHeight4 = posY + randTreeHeight + randTreeHeight + 10;
                int topTrunkHeight5 = posY + randTreeHeight + randTreeHeight + 11;


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
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos1, boundsIn);

                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.south(2).east().up(), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.south(2).east().up(2), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.south().east(), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.south().east().down(), boundsIn);

                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.south(3).east().up(3).west(), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.south(4).east().up(3).west(), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.south(5).east().up(4), boundsIn);


                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.south().east(2).up(3), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.south().east(2).up(4), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.south().east(2).up(5), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.south().east(3).up(5), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.south(2).east(4).up(6), boundsIn);

                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.up(6), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.east().up(6), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.north().up(7), boundsIn);


                }


                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                        int posX3 = posX1 + 2;
                        int posZ3 = posZ1 + 5;

                        int posX4 = posX1 + 1;
                        int posZ4 = posZ1 - 1;

                        int posX5 = posX1 + 5;
                        int posZ5 = posZ1 + 2;

                        //Top Leaves
                        placeLeaves(LEAVES, worldIn, posX4 + posXLeafWidth - 2, topTrunkHeight4 - 6, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX4 + posXLeafWidth, topTrunkHeight4 - 6, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX4 + posXLeafWidth - 1, topTrunkHeight4 - 6, posZ4 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX4 + posXLeafWidth - 1, topTrunkHeight4 - 6, posZ4 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        //Middle Leaves
                        placeLeaves(LEAVES, worldIn, posX5 + posXLeafWidth - 2, topTrunkHeight5 - 8, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX5 + posXLeafWidth, topTrunkHeight5 - 8, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX5 + posXLeafWidth - 1, topTrunkHeight5 - 8, posZ5 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX5 + posXLeafWidth - 1, topTrunkHeight5 - 8, posZ5 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        //Bottom Leaves
                        placeLeaves(LEAVES, worldIn, posX3 - 1 + posXLeafWidth, topTrunkHeight3 - 7, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3 - 1 + posXLeafWidth, topTrunkHeight3 - 7, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
//                        placeLeaves(LEAVES, worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight3 - 1, posZ3 + posZLeafWidthL0 +1, boundsIn, changedBlocks);
//                        placeLeaves(LEAVES, worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight3 - 1, posZ3 + posZLeafWidthL0 -1, boundsIn, changedBlocks);

                        //3x3
                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                            placeLeaves(LEAVES, worldIn, posX4 + posXLeafWidth - 1, topTrunkHeight4 - 5, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                            placeLeaves(LEAVES, worldIn, posX5 + posXLeafWidth - 1, topTrunkHeight5 - 7, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks); //Middle


                            placeLeaves(LEAVES, worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight3 - 6, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks); //Bottom

                        }

                        //Top Leaves
                        placeLeaves(LEAVES, worldIn, posX4 - 1, topTrunkHeight4 - 5, posZ4 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX4 - 3, topTrunkHeight4 - 5, posZ4, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX4 + 1, topTrunkHeight4 - 5, posZ4, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX4 - 1, topTrunkHeight4 - 5, posZ4 - 2, boundsIn, changedBlocks);

                        //Middle Leaves
                        placeLeaves(LEAVES, worldIn, posX5 - 1, topTrunkHeight5 - 7, posZ5 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX5 - 3, topTrunkHeight5 - 7, posZ5, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX5 + 1, topTrunkHeight5 - 7, posZ5, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX5 - 1, topTrunkHeight5 - 7, posZ5 - 2, boundsIn, changedBlocks);

                        //Bottom Leaves
                        placeLeaves(LEAVES, worldIn, posX3 - 1, topTrunkHeight3 - 6, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3 - 3, topTrunkHeight3 - 6, posZ3, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3 - 1, topTrunkHeight3 - 6, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3 + 1, topTrunkHeight3 - 6, posZ3, boundsIn, changedBlocks);


                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }
}