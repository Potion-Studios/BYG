package potionstudios.byg.common.world.feature.gen.overworld.trees.palo_verde;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import potionstudios.byg.common.world.feature.config.BYGTreeConfig;
import potionstudios.byg.common.world.feature.gen.overworld.trees.util.BYGAbstractTreeFeature;

import java.util.Random;
import java.util.Set;

public class PaloVerdeTree extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public PaloVerdeTree(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }


    public boolean generate(Set<BlockPos> changedBlocks, WorldGenLevel worldIn, Random rand, BlockPos pos, BoundingBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        int randTreeHeight = rand.nextInt(config.getMaxPossibleHeight()) + config.getMinHeight();
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            if (worldIn.getBlockState(pos.below()).getBlock() != Blocks.GRASS_BLOCK && (worldIn).getBlockState(pos.below()).getBlock() != Blocks.RED_SAND && (worldIn).getBlockState(pos.below()).getBlock() != Blocks.COARSE_DIRT && (worldIn).getBlockState(pos.below()).getBlock() != Blocks.TERRACOTTA) {
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

                    //Sets Logs
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos1, boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.east().north(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.east().north(2), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.east(2).north(3).above(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.east(2).north(3).above(2), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.east(3).north().above(3), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.east(4).north(2).above(3), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.east(3).north(2).above(3), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.east(2).north(4).above(3), boundsIn);
                }


                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                        int posX2 = posX1 + 3;
                        int posZ2 = posZ1 - 3;

                        int posX3 = posX1 + 4;
                        int posZ3 = posZ1 - 2;

                        //Bottom Leaves
                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafWidth, topTrunkHeight + 5, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafWidth - 2, topTrunkHeight + 5, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafWidth - 1, topTrunkHeight + 5, posZ2 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafWidth - 1, topTrunkHeight + 5, posZ2 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX3 + posXLeafWidth, topTrunkHeight + 5, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 + posXLeafWidth - 2, topTrunkHeight + 5, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight + 5, posZ3 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight + 5, posZ3 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        //3x3
                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                            placeLeaves(pos, config, rand, worldIn, posX2 + posXLeafWidth - 1, topTrunkHeight + 6, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);

                            placeLeaves(pos, config, rand, worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight + 6, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        }

                        //2x3
                        if (posXLeafWidth <= 0 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {
                        }

                        //Top Leaves

                        //Bottom Leaves
                        placeLeaves(pos, config, rand, worldIn, posX2 - 1, topTrunkHeight + 6, posZ2 + 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 - 3, topTrunkHeight + 6, posZ2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 + 1, topTrunkHeight + 6, posZ2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX2 - 1, topTrunkHeight + 6, posZ2 - 2, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX3 - 1, topTrunkHeight + 6, posZ3 + 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 - 3, topTrunkHeight + 6, posZ3, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 + 1, topTrunkHeight + 6, posZ3, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX3 - 1, topTrunkHeight + 6, posZ3 - 2, boundsIn, changedBlocks);

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