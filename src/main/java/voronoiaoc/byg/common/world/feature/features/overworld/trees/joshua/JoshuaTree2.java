package voronoiaoc.byg.common.world.feature.features.overworld.trees.joshua;

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

public class JoshuaTree2 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {
    public JoshuaTree2(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }


    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {

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
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west().up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west().up(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west().up(3), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west().up(3).south(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west().up(3).south(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west().up(4), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west(2).up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west(3).up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west(3).up(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.west(3).up().south(), boundsIn);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north().up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(2).up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(2).up(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(3).up(), boundsIn);

                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east().up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east().up().south(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east().up().south(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east().up(2).south(2), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east(2).up(), boundsIn);
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.east().up(2), boundsIn);
                }


                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {


//                        //Top Leaves
                        placeLeaves(config, rand, worldIn, posX1 - 4, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 3, topTrunkHeight + 2, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 3, topTrunkHeight + 2, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 3, topTrunkHeight + 4, posZ1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 4, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight + 3, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight + 3, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight + 2, posZ1 - 3, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 2, posZ1 - 4, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight + 4, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight + 3, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight + 2, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight + 2, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 3, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight + 4, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight + 2, posZ1 + 3, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight + 6, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight + 5, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight + 5, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight + 5, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight + 4, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 4, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 4, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight + 4, posZ1 + 3, boundsIn, changedBlocks);


                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }
}
