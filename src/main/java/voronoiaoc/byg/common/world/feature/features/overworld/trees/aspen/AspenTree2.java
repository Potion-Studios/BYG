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

import java.util.Random;
import java.util.Set;

public class AspenTree2 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public AspenTree2(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }

    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {
        BlockState LOG = config.getTrunkProvider().getBlockState(rand, pos);
        BlockState LEAVES = config.getLeavesProvider().getBlockState(rand, pos);
        int minHeight = config.getMinHeight();
        Biome biome = worldIn.getBiome(pos);
        if (biome == BYGBiomeList.ASPENFORESTHILLS)
            minHeight = config.getMinHeight() + 5;
        int randTreeHeight = rand.nextInt(4) + minHeight;
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < worldIn.getHeight()) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 14, 5, 5, isSapling)) {
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
                    placeLog(LOG, changedBlocks, worldIn, blockpos1, boundsIn);
                    placeLog(LOG, changedBlocks, worldIn, blockpos2.down(7).north().west(), boundsIn);
                    placeLog(LOG, changedBlocks, worldIn, blockpos2.down(7).west(2), boundsIn);
                    placeLog(LOG, changedBlocks, worldIn, blockpos2.down(6).north().west(3), boundsIn);
                    placeLog(LOG, changedBlocks, worldIn, blockpos2.down(4).south(), boundsIn);
                    placeLog(LOG, changedBlocks, worldIn, blockpos2.down(10).east(), boundsIn);
                }

                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                        int posX2 = posX1 - 3;
                        int posZ2 = posZ1 - 1;

                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {
                            placeLeaves(LEAVES, worldIn, posX2 + posXLeafWidth, topTrunkHeight - 5, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                        }

                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 9, posZ1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 5, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 8, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 10, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 9, posZ1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 6, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 11, posZ1 - 1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 2, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 7, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight - 10, posZ1 + 1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 9, posZ1 + 1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 7, posZ1 - 1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight - 9, posZ1 - 1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 1, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);

                        //Bottom Leaves
                        placeLeaves(LEAVES, worldIn, posX2 + 1, topTrunkHeight - 6, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + 2, topTrunkHeight - 6, posZ2, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight - 6, posZ2 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight - 6, posZ2 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight - 5, posZ2 + 2, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX2 - 1, topTrunkHeight - 6, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 - 2, topTrunkHeight - 6, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 - 2, topTrunkHeight - 5, posZ2, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight - 5, posZ2 - 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight - 6, posZ2 - 2, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX2 + 1, topTrunkHeight - 5, posZ2 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + 1, topTrunkHeight - 6, posZ2 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + 2, topTrunkHeight - 5, posZ2 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + 1, topTrunkHeight - 6, posZ2 - 2, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX2 - 1, topTrunkHeight - 5, posZ2 - 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 - 1, topTrunkHeight - 5, posZ2 - 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 - 2, topTrunkHeight - 6, posZ2 - 1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX2 - 1, topTrunkHeight - 5, posZ2 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 - 2, topTrunkHeight - 5, posZ2 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 - 1, topTrunkHeight - 5, posZ2 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 - 1, topTrunkHeight - 6, posZ2 + 1, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX2 + 1, topTrunkHeight - 5, posZ2 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + 1, topTrunkHeight - 5, posZ2 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + 1, topTrunkHeight - 6, posZ2 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + 2, topTrunkHeight - 6, posZ2 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + 2, topTrunkHeight - 5, posZ2 + 1, boundsIn, changedBlocks);


                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight - 2, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight - 3, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight - 4, posZ2, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight - 4, posZ2 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 - 1, topTrunkHeight - 4, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + 1, topTrunkHeight - 4, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + 1, topTrunkHeight - 3, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2, topTrunkHeight - 4, posZ2 - 1, boundsIn, changedBlocks);
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}