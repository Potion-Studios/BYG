package voronoiaoc.byg.common.world.feature.features.overworld.trees.taiga.giantspruce;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

//THIS FEATURE MUST BE REGISTERED & ADDED TO A BIOME!
public class GiantBlueSpruceTree extends BYGAbstractTreeFeature<NoFeatureConfig> {
    //Blocks used for the tree.
    private static final BlockState LOG = Blocks.SPRUCE_LOG.getDefaultState();
    private static final BlockState LEAVES = BYGBlockList.BLUE_SPRUCE_LEAVES.getDefaultState();
    private static final BlockState BEENEST = Blocks.BEE_NEST.getDefaultState();

    public GiantBlueSpruceTree(Function<Dynamic<?>, ? extends NoFeatureConfig> configIn) {
        super(configIn);
        setSapling((net.minecraftforge.common.IPlantable) BYGBlockList.BLUE_SPRUCE_SAPLING);
    }


    protected static boolean canTreeReplace(IWorldGenerationBaseReader genBaseReader, BlockPos blockPos) {
        return canTreePlaceHere(
                genBaseReader, blockPos
        );
    }

    public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox boundsIn) {
        //This sets heights for trees. Rand.nextint allows for tree height randomization. The final int value sets the minimum for tree Height.
        int randTreeHeight = rand.nextInt(5) + rand.nextInt(5) + 20;
        //Positions
        int posX = position.getX();
        int posY = position.getY();
        int posZ = position.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < 256) {
            BlockPos blockpos = position.down();
            if (!isSoil(worldIn, blockpos, getSapling())) {
                return false;
            } else if (!this.doesTreeFit(worldIn, position, randTreeHeight)) {
                return false;
            } else {
                this.setGroundBlockAt(worldIn, blockpos.south(), position, Blocks.DIRT.getDefaultState());

                this.setGroundBlockAt(worldIn, blockpos.south().east(), position, Blocks.DIRT.getDefaultState());

                this.setGroundBlockAt(worldIn, blockpos, position, Blocks.DIRT.getDefaultState());
                this.setGroundBlockAt(worldIn, blockpos.east(), position, Blocks.DIRT.getDefaultState());



                Direction direction = Direction.Plane.HORIZONTAL.random(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);//Crashes on 0.
                int posY1 = 2 - rand.nextInt(1);//Crashes on 0.
                int posX1 = posX;
                int posZ1 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;

                for (int groundUpLogRemover = 0; groundUpLogRemover < randTreeHeight; ++groundUpLogRemover) {
                    if (groundUpLogRemover >= randTreeHeight2 && posY1 < 0) { //Unknown
                        posX1 += direction.getXOffset();
                        posZ1 += direction.getZOffset();
                        ++posY1;
                    }
                    //This Int is responsible for the Y coordinate of the trunk BlockPos'.
                    int logplacer = posY + groundUpLogRemover;
                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);

                    if (isAirOrLeaves(worldIn, blockpos1)) {
                        this.treelog(changedBlocks, worldIn, blockpos1, boundsIn);
                        this.treelog(changedBlocks, worldIn, blockpos1.south(), boundsIn);
                        this.treelog(changedBlocks, worldIn, blockpos1.east(), boundsIn);
                        this.treelog(changedBlocks, worldIn, blockpos1.south().east(), boundsIn);

                    }
                }
                int leavePreset = rand.nextInt(1) + 1;
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
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight + tHAdd1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            this.leafs(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            if (leaveChance3 == 2) {
                                this.leafs(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub2, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub2, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            }
                            if (leaveChance2 == 1) {
                                this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub15, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub15, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub15, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub15, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub15, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub15, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub15, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub15, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub16, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub16, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub16, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub16, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            }

                            this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub14, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);


                            this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);

                            this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);

                            if (leaveChance3 < 10) {
                                this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);

                                /*this.leafs(worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + 2  + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 - 2  + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + 2  + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + 3  + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 - 3  + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 + 3  + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub11, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);*/

                            }

                            this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub10, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);

                            if (leaveChance3 < 10) {
                                this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub9, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub9, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub9, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub9, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub9, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub9, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub9, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub9, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            }

                            this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);

                            this.leafs(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub7, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub7, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub7, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub7, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            this.leafs(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub5, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub5, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub5, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub5, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 + 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);

                            this.leafs(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            this.leafs(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub3, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub3, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub3, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub3, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);

                            if (leaveChance1 == 1) {
                                this.leafs(worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);

                                if (leaveChance2 == 1) {
                                    this.leafs(worldIn, posX1 + 4 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 4 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 + 4 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub13, posZ1 - 4 + posZLeafWidthL0, boundsIn, changedBlocks);
                                }
                            } else if (leaveChance1 == 2) {
                                this.leafs(worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 - 1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 + 3 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1 + posXLeafWidth, topTrunkHeight - tHSub12, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);

                            }

                            /*this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + 2  + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 - 2  + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + 2  + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);

                            this.leafs(worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + 2  + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 - 2  + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 3 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + 2  + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 3 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 - 2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + 3  + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 - 3  + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 - 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + 3  + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + 2 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 - 3 + posZLeafWidthL0, boundsIn, changedBlocks);*/


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
        BlockPos.Mutable position = new BlockPos.Mutable();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 8;


            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                    if (!canTreeReplace(reader, position.setPos(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //Log Placement
    private void treelog(Set<BlockPos> setlogblock, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canTreeReplace(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, LOG, boundingBox);
        }

    }

    //Leaves Placement
    private void leafs(IWorldGenerationReader reader, int x, int y, int z, MutableBoundingBox boundingBox, Set<BlockPos> blockPos) {
        BlockPos blockpos = new BlockPos(x, y, z);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, LEAVES, boundingBox);
        }

    }
}