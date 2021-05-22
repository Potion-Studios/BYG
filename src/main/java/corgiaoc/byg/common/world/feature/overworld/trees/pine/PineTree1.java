package corgiaoc.byg.common.world.feature.overworld.trees.pine;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.biome.Biome;

import java.util.Random;
import java.util.Set;

public class PineTree1 extends BYGAbstractTreeFeature<BYGTreeConfig> {
    //Blocks used for the tree.
    //private static final BlockState LOG = BYGBlocks.PINE_LOG.getDefaultState();
    //private static final BlockState LEAVES = BYGBlocks.PINE_LEAVES.getDefaultState();
    private static final BlockState BEENEST = Blocks.BEE_NEST.defaultBlockState();
    Random random = new Random();

    public PineTree1(Codec<BYGTreeConfig> configIn) {
        super(configIn);
        //setSapling((net.minecraftforge.common.IPlantable) BYGBlocks.PINE_SAPLING);
    }

    public boolean generate(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        Biome biome = worldIn.getBiome(pos);
        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        //Positions
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.below(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {

                //Places dirt under logs where/when necessary.
                Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);
                int posY1 = 2 - rand.nextInt(1);
                int posX1 = posX;
                int posZ1 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;
                int topTrunkHeight2 = posY + randTreeHeight + randTreeHeight - 1;

                //Raising the 'groundUpLogRemover'  will remove all log blocks from the ground up no matter how thick the trunk is based on the value given. 5 would destroy all trunks from 5 up off the ground.
                for (int groundUpLogRemover = 0; groundUpLogRemover < randTreeHeight; ++groundUpLogRemover) {
                    if (groundUpLogRemover >= randTreeHeight2 && posY1 < 0) {
                        posX1 += direction.getStepX();
                        posZ1 += direction.getStepZ();
                        ++posY1;
                    }
                    //This Int is responsible for the Y coordinate of the trunk BlockPos'.
                    int logplacer = posY + groundUpLogRemover;
                    int logplacer2 = posY + randTreeHeight;
                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
                    BlockPos blockpos2 = new BlockPos(posX1, logplacer2, posZ1);

                    //Sets Logs
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos1, boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.north().below(2), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.north().below(7), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.north().below(11), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.south().below(6), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.south().below(10), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.east().below(4), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.east().below(8), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.west().below(3), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.west().below(8), boundsIn);
                }
                //This allows a random rotation between 3 differently leave Presets in the same class. Optimizes Performance instead of the loading of several classes.

                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                        int posX2 = posX1 + 1;
                        int posZ2 = posZ1 + 1;

                        //Bottom Leaves
//                        placePetal(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight + 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
//                        placePetal(LEAVES, worldIn, posX1 + posXLeafWidth - 2, topTrunkHeight + 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
//                        placePetal(LEAVES, worldIn, posX1 + posXLeafWidth - 1, topTrunkHeight + 1, posZ1 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
//                        placePetal(LEAVES, worldIn, posX1 + posXLeafWidth - 1, topTrunkHeight + 1, posZ1 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        //3x3
                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                            placeLeaves(pos, config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 7, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                        }

                        //2x3
                        if (posXLeafWidth <= 0 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                        }

                        //Bottom Leaves
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 1, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 1, posZ1 - 2, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 2, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 5, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 5, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - 5, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 5, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 5, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - 5, posZ1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - 6, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - 6, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 6, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 6, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 6, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 6, posZ1 + 1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight - 7, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight - 7, posZ1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 8, posZ1 + 1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 9, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 9, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 9, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - 9, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 9, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - 9, posZ1 + 1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 10, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - 10, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight - 10, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight - 10, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight - 10, posZ1 - 2, boundsIn, changedBlocks);


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