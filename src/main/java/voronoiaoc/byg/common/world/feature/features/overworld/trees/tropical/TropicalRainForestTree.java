package voronoiaoc.byg.common.world.feature.features.overworld.trees.tropical;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.VineBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import voronoiaoc.byg.common.world.feature.config.BYGTreeFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;

import java.util.Random;
import java.util.Set;

//THIS FEATURE MUST BE REGISTERED & ADDED TO A BIOME!
public class TropicalRainForestTree extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {
    //BYGBlockRenders used for the tree.
    //private static final BlockState LOG = BYGBlockList.MAHOGANY_LOG.getDefaultState();
    //private static final BlockState LEAVES = BYGBlockList.MAHOGANY_LEAVES.getDefaultState();
    private static final BlockState BEENEST = Blocks.BEE_NEST.getDefaultState();

    public TropicalRainForestTree(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
        //setSapling((net.minecraftforge.common.IPlantable) BYGBlockList.MAHOGANY_SAPLING);
    }

    protected static boolean canTreePlace(IWorldGenerationBaseReader genBaseReader, BlockPos blockPos) {
        return canLogPlaceHere(
                genBaseReader, blockPos
        );
    }

    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {
        BlockState LOG = config.getTrunkProvider().getBlockState(rand, pos);
        BlockState LEAVES = config.getLeavesProvider().getBlockState(rand, pos);
        int randTreeHeight = rand.nextInt(3) + rand.nextInt(3) + 8;
        //Positions
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < 256) {
            BlockPos checkGround = pos.down();
            if (!isDesiredGroundwDirtTag(worldIn, checkGround, Blocks.GRASS_BLOCK)) {
                return false;
            } else {
                //this.setGroundBlockAt(worldIn, checkGround, pos, Blocks.STONE.getDefaultState());


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
                    int logplacer1 = posY + randTreeHeight;
                    int logplacer2 = posY + buildTrunk - rand.nextInt(6);

                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
                    BlockPos blockpos2 = new BlockPos(posX1, logplacer1, posZ1);
                    BlockPos blockpos3 = new BlockPos(posX1, logplacer2, posZ1);

                    placeTrunk(LOG, changedBlocks, worldIn, blockpos1, boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.west(), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.east(), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.north(), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.south(), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.west().up(), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.east().up(), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.north().up(), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.south().up(), boundsIn);
//                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.west(2).up(1), boundsIn);
//                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.east(2).up(1), boundsIn);
//                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.north(2).up(1), boundsIn);
//                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.south(2).up(1), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.west(2).up(2), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.east(2).up(2), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.north(2).up(2), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.south(2).up(2), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.west(2).up(3), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.east(2).up(3), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.north(2).up(3), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.south(2).up(3), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.west(2).up(4), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.east(2).up(4), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.north(2).up(4), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.south(2).up(4), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.west(2).up(5), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.east(2).up(5), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.north(2).up(5), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.south(2).up(5), boundsIn);
                    if (rand.nextInt(4) == 2) {
                        this.tryPlaceVines(worldIn, rand, blockpos3.west(), VineBlock.EAST);
                    } else if (rand.nextInt(2) == 1) {
                        this.tryPlaceVines(worldIn, rand, blockpos3.east(), VineBlock.WEST);
                        this.tryPlaceVines(worldIn, rand, blockpos3.north(), VineBlock.SOUTH);
                    }
                }
                int leavePreset = 1;
                {
                    if (leavePreset == 1) {
                        int leavessquarespos = 1;
                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
                                placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight + 5, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth) - 3, topTrunkHeight + 5, (posZ1 + posZLeafWidthL0), boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth) + 3, topTrunkHeight + 5, (posZ1 + posZLeafWidthL0), boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth), topTrunkHeight + 5, (posZ1 + posZLeafWidthL0) + 3, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth), topTrunkHeight + 5, (posZ1 + posZLeafWidthL0) - 3, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth) - 3, topTrunkHeight + 5, (posZ1 + posZLeafWidthL0) - 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth) + 3, topTrunkHeight + 5, (posZ1 + posZLeafWidthL0) + 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth) - 2, topTrunkHeight + 5, (posZ1 + posZLeafWidthL0) + 3, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth) + 2, topTrunkHeight + 5, (posZ1 + posZLeafWidthL0) - 3, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth) - 3, topTrunkHeight + 5, (posZ1 + posZLeafWidthL0) + 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth) + 3, topTrunkHeight + 5, (posZ1 + posZLeafWidthL0) - 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth) + 2, topTrunkHeight + 5, (posZ1 + posZLeafWidthL0) + 3, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth) - 2, topTrunkHeight + 5, (posZ1 + posZLeafWidthL0) - 3, boundsIn, changedBlocks);


                                placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight + 6, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth) - 2, topTrunkHeight + 6, (posZ1 + posZLeafWidthL0), boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth) + 2, topTrunkHeight + 6, (posZ1 + posZLeafWidthL0), boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth), topTrunkHeight + 6, (posZ1 + posZLeafWidthL0) + 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth), topTrunkHeight + 6, (posZ1 + posZLeafWidthL0) - 2, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth) - 1, topTrunkHeight + 6, (posZ1 + posZLeafWidthL0) - 1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth) + 1, topTrunkHeight + 6, (posZ1 + posZLeafWidthL0) + 1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth) - 1, topTrunkHeight + 6, (posZ1 + posZLeafWidthL0) + 1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth) + 1, topTrunkHeight + 6, (posZ1 + posZLeafWidthL0) - 1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth) - 1, topTrunkHeight + 6, (posZ1 + posZLeafWidthL0) + 1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth) + 1, topTrunkHeight + 6, (posZ1 + posZLeafWidthL0) - 1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth) + 1, topTrunkHeight + 6, (posZ1 + posZLeafWidthL0) + 1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth) - 1, topTrunkHeight + 6, (posZ1 + posZLeafWidthL0) - 1, boundsIn, changedBlocks);


                                placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight + 7, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth) - 1, topTrunkHeight + 7, (posZ1 + posZLeafWidthL0), boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth) + 1, topTrunkHeight + 7, (posZ1 + posZLeafWidthL0), boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth), topTrunkHeight + 7, (posZ1 + posZLeafWidthL0) + 1, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, (posX1 + posXLeafWidth), topTrunkHeight + 7, (posZ1 + posZLeafWidthL0) - 1, boundsIn, changedBlocks);


                                placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight + 8, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);


//                                placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight + 9, posZ1, boundsIn, changedBlocks);
//                                placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight + 9, posZ1, boundsIn, changedBlocks);
//                                placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight + 9, posZ1, boundsIn, changedBlocks);
//                                placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight + 9, posZ1 - 1, boundsIn, changedBlocks);
//                                placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight + 9, posZ1 + 1, boundsIn, changedBlocks);
                            }
                        }
                    } else if (leavePreset == 2) {
                        int leavessquarespos = rand.nextInt(1) + 1;
                        for (int posXLeafWidth = (leavessquarespos * -1); posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = (leavessquarespos * -1); posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
                                placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight + 6, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 2, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                            }
                        }
                    } else if (leavePreset == 3) {
                        int leavessquarespos = rand.nextInt(1) + 1;
                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                            }
                        }
                    }
                }
            }

            return true;
            //}
        } else {
            return false;
        }
    }

    private boolean doesTreeFit(IWorldGenerationBaseReader reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.Mutable pos = new BlockPos.Mutable();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 0;

            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                    if (!canTreePlace(reader, pos.setPos(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    private void treelog(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canTreePlace(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, LOG, boundingBox);
        }

    }


    private void leafs(ISeedReader reader, int x, int y, int z, MutableBoundingBox boundingBox, Set<BlockPos> blockPos) {
        BlockPos leafpos = new BlockPos(x, y, z);
        if (isAir(reader, leafpos)) {
            this.setFinalBlockState(blockPos, reader, leafpos, LEAVES, boundingBox);
        }

    }

    private void tryPlaceVines(ISeedReader worldIn, Random random, BlockPos pos, BooleanProperty sideProperty) {
        if (random.nextInt(3) > 0 && isAir(worldIn, pos)) {
            this.func_230367_a_(worldIn, pos, Blocks.VINE.getDefaultState().with(sideProperty, Boolean.valueOf(true)));
        }

    }
}