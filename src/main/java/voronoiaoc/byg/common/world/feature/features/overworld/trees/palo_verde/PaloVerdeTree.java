package voronoiaoc.byg.common.world.feature.features.overworld.trees.palo_verde;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import voronoiaoc.byg.common.world.feature.featureconfig.BYGTreeFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;

import java.util.Random;
import java.util.Set;

public class PaloVerdeTree extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {

    public PaloVerdeTree(Codec<BYGTreeFeatureConfig> configIn, int beeHiveChance) {
        super(configIn);
    }


    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {

        int randTreeHeight = rand.nextInt(config.getMaxPossibleHeight()) + config.getMinHeight();
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY + randTreeHeight + 1 < worldIn.getHeight()) {
            if (worldIn.getBlockState(pos.down()).getBlock() != Blocks.GRASS_BLOCK && (worldIn).getBlockState(pos.down()).getBlock() != Blocks.RED_SAND && (worldIn).getBlockState(pos.down()).getBlock() != Blocks.COARSE_DIRT&& (worldIn).getBlockState(pos.down()).getBlock() != Blocks.TERRACOTTA) {
                return false;
            } else {


                Direction direction = Direction.Plane.HORIZONTAL.random(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);
                int posY1 = 2 - rand.nextInt(1);
                int posX1 = posX;
                int posZ1 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;
                int topTrunkHeight2 = posY + randTreeHeight + randTreeHeight - 1;


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
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos1, boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east().north(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east().north(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(2).north(3).up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(2).north(3).up(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(3).north().up(3), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(4).north(2).up(3), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(3).north(2).up(3), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(2).north(4).up(3), boundsIn);


                }


                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                        int posX2 = posX1 + 3;
                        int posZ2 = posZ1 - 3;

                        int posX3 = posX1 + 4;
                        int posZ3 = posZ1 - 2;

                        //Bottom Leaves
                        placeLeaves(config, rand, worldIn, posX2 + posXLeafWidth, topTrunkHeight + 5, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX2 + posXLeafWidth - 2, topTrunkHeight + 5, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX2 + posXLeafWidth - 1, topTrunkHeight + 5, posZ2 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX2 + posXLeafWidth - 1, topTrunkHeight + 5, posZ2 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX3 + posXLeafWidth, topTrunkHeight + 5, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + posXLeafWidth - 2, topTrunkHeight + 5, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight + 5, posZ3 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight + 5, posZ3 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        //3x3
                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                            placeLeaves(config, rand, worldIn, posX2 + posXLeafWidth - 1, topTrunkHeight + 6, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);

                            placeLeaves(config, rand, worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight + 6, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        }

                        //2x3
                        if (posXLeafWidth <= 0 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {
                        }

                        //Top Leaves

                        //Bottom Leaves
                        placeLeaves(config, rand, worldIn, posX2 - 1, topTrunkHeight + 6, posZ2 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX2 - 3, topTrunkHeight + 6, posZ2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX2 + 1, topTrunkHeight + 6, posZ2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX2 - 1, topTrunkHeight + 6, posZ2 - 2, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight + 6, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 3, topTrunkHeight + 6, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 + 1, topTrunkHeight + 6, posZ3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX3 - 1, topTrunkHeight + 6, posZ3 - 2, boundsIn, changedBlocks);

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