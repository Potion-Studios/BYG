package voronoiaoc.byg.common.world.feature.features.overworld.trees.aspen;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.biome.Biome;
import voronoiaoc.byg.common.world.feature.config.BYGTreeFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBiomeList;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

public class AspenTree3 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public AspenTree3(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }

    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {
        BlockState LOG = config.getTrunkProvider().getBlockState(rand, pos);
        BlockState LEAVES = config.getLeavesProvider().getBlockState(rand, pos);
        int minHeight = config.getMinHeight();
        Biome biome = worldIn.getBiome(pos);
        if (biome == BYGBiomeList.ASPENFORESTHILLS)
            minHeight = config.getMinHeight() + 5;

        int randTreeHeight = rand.nextInt(config.getMaxPossibleHeight()) + minHeight;
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

                    placeTrunk(LOG, changedBlocks, worldIn, blockpos1, boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.north().west(), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.down().south().east(), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.south().east(), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.up().south().east(), boundsIn);

                }

                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                        int posX2 = posX1 + 1;
                        int posZ2 = posZ1 + 1;

                        int posX3 = posX1 - 1;
                        int posZ3 = posZ1 - 1;

                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                            placeLeaves(LEAVES, worldIn, posX2 + posXLeafWidth, topTrunkHeight + 3, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX3 + posXLeafWidth, topTrunkHeight + 2, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        }

                        //Left Leaves
                        placeLeaves(LEAVES, worldIn, posX2 + 1, topTrunkHeight + 2, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + 2, topTrunkHeight + 2, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + 1, topTrunkHeight + 1, posZ2, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight + 2, posZ2 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight + 2, posZ2 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight + 3, posZ2 + 2, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX2 - 1, topTrunkHeight + 2, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 - 2, topTrunkHeight + 2, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 - 2, topTrunkHeight + 3, posZ2, boundsIn, changedBlocks);


                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight + 1, posZ2 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight + 3, posZ2 - 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight + 2, posZ2 - 2, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX2 + 1, topTrunkHeight + 3, posZ2 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + 1, topTrunkHeight + 2, posZ2 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + 2, topTrunkHeight + 3, posZ2 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + 1, topTrunkHeight + 2, posZ2 - 2, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX2 - 1, topTrunkHeight + 3, posZ2 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 - 1, topTrunkHeight + 3, posZ2 - 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 - 2, topTrunkHeight + 2, posZ2 - 1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX2 - 1, topTrunkHeight + 3, posZ2 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 - 2, topTrunkHeight + 3, posZ2 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 - 1, topTrunkHeight + 3, posZ2 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 - 1, topTrunkHeight + 2, posZ2 + 1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX2 + 1, topTrunkHeight + 3, posZ2 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + 1, topTrunkHeight + 3, posZ2 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + 1, topTrunkHeight + 2, posZ2 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + 2, topTrunkHeight + 2, posZ2 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + 2, topTrunkHeight + 3, posZ2 + 1, boundsIn, changedBlocks);


                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight + 4, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight + 5, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight + 6, posZ2, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight + 4, posZ2 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 - 1, topTrunkHeight + 4, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + 1, topTrunkHeight + 4, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight + 4, posZ2 - 1, boundsIn, changedBlocks);

                        //Right Leaves
                        placeLeaves(LEAVES, worldIn, posX3 + 1, topTrunkHeight + 1, posZ3, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3 + 2, topTrunkHeight + 1, posZ3, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3 + 1, topTrunkHeight, posZ3, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX3, topTrunkHeight, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3, topTrunkHeight, posZ3 + 3, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3, topTrunkHeight, posZ3 + 3, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX3 - 1, topTrunkHeight + 1, posZ3, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3 - 2, topTrunkHeight + 1, posZ3, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3 - 2, topTrunkHeight + 2, posZ3, boundsIn, changedBlocks);


                        placeLeaves(LEAVES, worldIn, posX3, topTrunkHeight, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3, topTrunkHeight + 1, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3, topTrunkHeight + 1, posZ3 - 2, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX3 + 1, topTrunkHeight + 2, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3 + 1, topTrunkHeight + 1, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3 + 2, topTrunkHeight + 2, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3 + 1, topTrunkHeight + 1, posZ3 - 2, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX3 - 1, topTrunkHeight + 2, posZ3 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3 - 1, topTrunkHeight + 2, posZ3 - 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3 - 2, topTrunkHeight + 1, posZ3 - 1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX3 - 1, topTrunkHeight + 2, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3 - 2, topTrunkHeight + 2, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3 - 1, topTrunkHeight + 2, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3 - 1, topTrunkHeight + 1, posZ3 + 1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX3 + 1, topTrunkHeight + 2, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3 + 1, topTrunkHeight + 2, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3 + 1, topTrunkHeight + 1, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3 + 2, topTrunkHeight + 1, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3 + 2, topTrunkHeight + 2, posZ3 + 1, boundsIn, changedBlocks);


                        placeLeaves(LEAVES, worldIn, posX3, topTrunkHeight + 3, posZ3, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3, topTrunkHeight + 4, posZ3, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3, topTrunkHeight + 5, posZ3, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX3, topTrunkHeight + 3, posZ3 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3 - 1, topTrunkHeight + 3, posZ3, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3 + 1, topTrunkHeight + 3, posZ3, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX3, topTrunkHeight + 3, posZ3 - 1, boundsIn, changedBlocks);

                        //Foilage
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }


    private void treelog(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.ASPEN_LOG.getDefaultState(), boundingBox);
        }

    }


    private void leafs(ISeedReader reader, int x, int y, int z, MutableBoundingBox boundingBox, Set<BlockPos> blockPos) {
        BlockPos blockpos = new BlockPos(x, y, z);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, BYGBlockList.ASPEN_LEAVES.getDefaultState(), boundingBox);
        }

    }

}