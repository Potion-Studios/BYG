package voronoiaoc.byg.common.world.feature.features.overworld.trees.palm;

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

public class PalmTree1 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {
    //private static final BlockState LOG = Blocks.JUNGLE_LOG.getDefaultState();
    //private static final BlockState LEAVES = Blocks.JUNGLE_LEAVES.getDefaultState();
    private static final BlockState BEENEST = Blocks.BEE_NEST.getDefaultState();

    public PalmTree1(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }


    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(3);
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < 256) {

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
                    int logplacer2 = posY + buildTrunk + randTreeHeight;


                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
                    BlockPos blockpos2 = new BlockPos(posX1, logplacer2, posZ1);

                    this.placeTrunk(config, rand, changedBlocks, worldIn, blockpos1, boundsIn);
                    this.placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(), boundsIn);
                    this.placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north().up(), boundsIn);

                    this.placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(2).up(2), boundsIn);
                    this.placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(2).up(3), boundsIn);

                    this.placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(3).up(4), boundsIn);
                    this.placeTrunk(config, rand, changedBlocks, worldIn, blockpos2.north(3).up(5), boundsIn);
                }
                int leavePreset = rand.nextInt(1) + 1;
                {
                    if (leavePreset == 1) {
                        int leavessquarespos = rand.nextInt(1) + 1;
                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                                int posX2 = posX1 + 1;
                                int posZ2 = posZ1 - 3;

                                //Bottom Leaves
//                        this.placeLeaves(worldIn, posX1 + posXLeafWidth, topTrunkHeight + 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
//                        this.placeLeaves(worldIn, posX1 + posXLeafWidth - 2, topTrunkHeight + 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
//                        this.placeLeaves(worldIn, posX1 + posXLeafWidth - 1, topTrunkHeight + 1, posZ1 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
//                        this.placeLeaves(worldIn, posX1 + posXLeafWidth - 1, topTrunkHeight + 1, posZ1 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                                //3x3
                                if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                                    this.placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight + 6, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                                }

                                //2x3
                                if (posXLeafWidth <= 0 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {
                                }

                                //Bottom Leaves
                                this.placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 7, posZ2, boundsIn, changedBlocks);
                                this.placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 7, posZ2 + 1, boundsIn, changedBlocks);
                                this.placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 7, posZ2 - 1, boundsIn, changedBlocks);
                                this.placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight + 7, posZ2, boundsIn, changedBlocks);
                                this.placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight + 7, posZ2, boundsIn, changedBlocks);

                                this.placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 6, posZ2 + 2, boundsIn, changedBlocks);
                                this.placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 6, posZ2 - 2, boundsIn, changedBlocks);
                                this.placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight + 6, posZ2, boundsIn, changedBlocks);
                                this.placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight + 6, posZ2, boundsIn, changedBlocks);

                                this.placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 6, posZ2 + 3, boundsIn, changedBlocks);
                                this.placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 6, posZ2 - 3, boundsIn, changedBlocks);
                                this.placeLeaves(config, rand, worldIn, posX1 - 3, topTrunkHeight + 6, posZ2, boundsIn, changedBlocks);
                                this.placeLeaves(config, rand, worldIn, posX1 + 3, topTrunkHeight + 6, posZ2, boundsIn, changedBlocks);

                                this.placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 5, posZ2 + 3, boundsIn, changedBlocks);
                                this.placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 5, posZ2 - 3, boundsIn, changedBlocks);
                                this.placeLeaves(config, rand, worldIn, posX1 - 3, topTrunkHeight + 5, posZ2, boundsIn, changedBlocks);
                                this.placeLeaves(config, rand, worldIn, posX1 + 3, topTrunkHeight + 5, posZ2, boundsIn, changedBlocks);

                                this.placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 5, posZ2 + 4, boundsIn, changedBlocks);
                                this.placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 5, posZ2 - 4, boundsIn, changedBlocks);
                                this.placeLeaves(config, rand, worldIn, posX1 - 4, topTrunkHeight + 5, posZ2, boundsIn, changedBlocks);
                                this.placeLeaves(config, rand, worldIn, posX1 + 4, topTrunkHeight + 5, posZ2, boundsIn, changedBlocks);


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