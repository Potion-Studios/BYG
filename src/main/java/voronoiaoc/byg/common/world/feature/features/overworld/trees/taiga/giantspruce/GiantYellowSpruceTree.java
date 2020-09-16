package voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.giantspruce;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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
public class GiantYellowSpruceTree extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {
    //BYGBlockRenders used for the tree.
    //private static final BlockState LOG = Blocks.SPRUCE_LOG.getDefaultState();
    //private static final BlockState LEAVES = BYGBlockList.YELLOW_SPRUCE_LEAVES.getDefaultState();
    //private static final BlockState LEAVES2 = BYGBlockList.YELLOW_SPRUCE_LEAVES.getDefaultState();
    private static final BlockState BEEHIVE = Blocks.BEEHIVE.getDefaultState();

    public GiantYellowSpruceTree(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
        //setSapling((net.minecraftforge.common.IPlantable) BYGBlockList.YELLOW_SPRUCE_SAPLING);
    }


    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {
        BlockState LOG = config.getTrunkProvider().getBlockState(rand, pos);
        BlockState LEAVES = config.getLeavesProvider().getBlockState(rand, pos);
        int randTreeHeight = rand.nextInt(5) + rand.nextInt(5) + 20;
        //Positions
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
                //this.setGroundBlockAt(worldIn, blockpos.south(), pos, Blocks.DIRT.getDefaultState());

                //this.setGroundBlockAt(worldIn, blockpos.south().east(), pos, Blocks.DIRT.getDefaultState());


                //this.setGroundBlockAt(worldIn, blockpos.east(), pos, Blocks.DIRT.getDefaultState());


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

                    if (isAir(worldIn, blockpos1)) {
                        placeLog(LOG, changedBlocks, worldIn, blockpos1, boundsIn);
                        placeLog(LOG, changedBlocks, worldIn, blockpos1.south(), boundsIn);
                        placeLog(LOG, changedBlocks, worldIn, blockpos1.east(), boundsIn);
                        placeLog(LOG, changedBlocks, worldIn, blockpos1.south().east(), boundsIn);

                    }
                }
                int leavePreset = rand.nextInt(2) + 1;
                int leaveChance1 = rand.nextInt(2) + 1;
                int leaveChance2 = rand.nextInt(2) + 1;
                int leaveChance3 = rand.nextInt(10) + 1;


                int tHAdd1 = 1;
                int tHSub16 = 16;
                int tHSub15 = 15;
                int tHSub14 = 14;
                int tHSub13 = 13;
                int tHSub12 = 12;
                int tHSub11 = 11;
                int tHSub10 = 10;
                int tHSub9 = 9;
                int tHSub8 = 8;
                int tHSub7 = 7;
                int tHSub6 = 6;
                int tHSub5 = 5;
                int tHSub4 = 4;
                int tHSub3 = 3;
                int tHSub2 = 2;


                if (leavePreset == 1) {
                    for (int posXLeafWidth = 0; posXLeafWidth <= 1; ++posXLeafWidth) {//has to do with leaves
                        for (int posZLeafWidthL0 = 0; posZLeafWidthL0 <= 1; ++posZLeafWidthL0) {
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight + tHAdd1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            placeLeaves(LEAVES, worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            if (leaveChance3 == 2) {
                                placeLeaves(LEAVES, worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub2, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub2, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            }
                            if (leaveChance2 == 1) {
                                placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub15, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub15, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub15, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub15, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub15, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub15, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub15, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub15, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);

                                placeLeaves(LEAVES, worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub16, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub16, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub16, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub16, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            }

                            placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);


                            placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);

                            placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);

                            if (leaveChance3 < 10) {
                                placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);

                                /*placeLeaves(LEAVES, worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + 2  + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 - 2  + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + 2  + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + 3  + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 - 3  + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + 3  + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);*/

                            }

                            placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);

                            if (leaveChance3 < 10) {
                                placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub9, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub9, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub9, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub9, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub9, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub9, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub9, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub9, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            }

                            placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);

                            placeLeaves(LEAVES, worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub7, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub7, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub7, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub7, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            placeLeaves(LEAVES, worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub5, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub5, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub5, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub5, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);

                            placeLeaves(LEAVES, worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            placeLeaves(LEAVES, worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub3, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub3, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub3, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub3, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            if (leaveChance1 == 1) {
                                placeLeaves(LEAVES, worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);

                                if (leaveChance2 == 1) {
                                    placeLeaves(LEAVES, worldIn, posX1 + 4 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1 - 4 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 4 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 4 + posZLeafWidthL0, boundsIn, changedBlocks);
                                }
                            } else if (leaveChance1 == 2) {
                                placeLeaves(LEAVES, worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                                placeLeaves(LEAVES, worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);

                            }

                            /*placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + 2  + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 - 2  + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + 2  + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);

                            placeLeaves(LEAVES, worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + 2  + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 - 2  + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + 2  + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + 3  + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 - 3  + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + 3  + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);*/


                        }
                    }
                } else if (leavePreset == 2) {
                    for (int posXLeafWidth = 0; posXLeafWidth <= 1; ++posXLeafWidth) {//has to do with leaves
                        for (int posZLeafWidthL0 = 0; posZLeafWidthL0 <= 1; ++posZLeafWidthL0) {
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight + tHAdd1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            this.leafs2(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            if (leaveChance3 == 2) {
                                this.leafs2(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub2, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub2, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            }
                            if (leaveChance2 == 1) {
                                this.leafs2(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub15, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub15, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub15, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub15, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub15, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub15, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub15, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub15, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);

                                this.leafs2(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub16, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub16, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub16, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub16, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            }

                            this.leafs2(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);


                            this.leafs2(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);

                            this.leafs2(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);

                            if (leaveChance3 < 10) {
                                this.leafs2(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);

                                /*this.leafs2(worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + 2  + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 - 2  + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + 2  + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + 3  + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 - 3  + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + 3  + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);*/

                            }

                            this.leafs2(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);

                            if (leaveChance3 < 10) {
                                this.leafs2(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub9, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub9, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub9, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub9, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub9, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub9, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub9, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub9, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            }

                            this.leafs2(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);

                            this.leafs2(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub7, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub7, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub7, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub7, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            this.leafs2(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            this.leafs2(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub5, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub5, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub5, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub5, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            this.leafs2(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);

                            this.leafs2(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            this.leafs2(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub3, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub3, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub3, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub3, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            if (leaveChance1 == 1) {
                                this.leafs2(worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);

                                if (leaveChance2 == 1) {
                                    this.leafs2(worldIn, posX1 + 4 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    this.leafs2(worldIn, posX1 - 4 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 4 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 4 + posZLeafWidthL0, boundsIn, changedBlocks);
                                }
                            } else if (leaveChance1 == 2) {
                                this.leafs2(worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);

                            }
                        }
                    }
                }
            }
        }
        return true;
        //}
    }


    private boolean doesTreeFit(IWorldGenerationBaseReader reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.Mutable pos = new BlockPos.Mutable();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 4;

            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                    if (!canLogPlaceHere(reader, pos.setPos(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    private void leafs2(ISeedReader reader, int x, int y, int z, MutableBoundingBox boundingBox, Set<BlockPos> blockPos) {
        BlockPos blockpos = new BlockPos(x, y, z);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, LEAVES2, boundingBox);
        }

    }
}