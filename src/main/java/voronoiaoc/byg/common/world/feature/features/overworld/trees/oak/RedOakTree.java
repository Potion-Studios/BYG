package voronoiaoc.byg.common.world.feature.features.overworld.trees.oak;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

//THIS FEATURE MUST BE REGISTERED & ADDED TO A BIOME!
public class RedOakTree extends BYGAbstractTreeFeature<NoFeatureConfig> {
    //BYGBlockRenders used for the tree.
    private static final BlockState LOG = Blocks.OAK_LOG.getDefaultState();
    private static final BlockState LEAVES = BYGBlockList.RED_OAK_LEAVES.getDefaultState();
    private static final BlockState BEENEST = Blocks.BEE_NEST.getDefaultState();

    public RedOakTree(Codec<NoFeatureConfig> configIn) {
        super(configIn);
        //setSapling((net.minecraftforge.common.IPlantable) BYGBlockList.RED_OAK_SAPLING);
    }


    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling) {

        int randTreeHeight = rand.nextInt(3) + rand.nextInt(2) + 6;
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


                Direction direction = Direction.Plane
.HORIZONTAL.random(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);//Crashes on 0.
                int posY1 = 2 - rand.nextInt(1);//Crashes on 0.
                int posX1 = posX;
                int posZ1 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;


                for (int buildTrunk = 0; buildTrunk < randTreeHeight; ++buildTrunk) {
                    if (buildTrunk >= randTreeHeight2 && posY1 < 0) { //Unknown
                        posX1 += direction.getXOffset();
                        posZ1 += direction.getZOffset();
                        ++posY1;
                    }

                    int logplacer = posY + buildTrunk;
                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);

                    //Sets Logs
                    if (isAir(worldIn, blockpos1)) {
                        this.treelog(changedBlocks, worldIn, blockpos1, boundsIn);

                    }
                }

                int leavePreset = rand.nextInt(4) + 1;
                {
                    /*if (leavePreset == 1) {
                        //This randomizer allows you to have randomly generating sized leave widths(X & Z). You can remove the randomizer and set your own value instead.
                        int leavessquarespos = 2;
                        //This loads leaves in squares. Manually placing the squares can allow you to load in perfect squares.
                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
                                //int leaveheight = 0;//0 lines it up with top log
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 3, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1-1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight+ 1, posZ1-1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight+ 1, posZ1, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1-1, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);


                                this.leafs(worldIn, posX1 + 2, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight -5 , posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 5, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight -5 , posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight- 5, posZ1-1, boundsIn, changedBlocks);
                            }
                        }
                    } else if (leavePreset == 2) {
                        int leavessquarespos = 2;
                        for (int posXLeafWidth = (leavessquarespos * -1); posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = (leavessquarespos * -1); posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 3, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1-1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight+ 1, posZ1-1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight+ 1, posZ1, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1-1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);

                                //Leave Widener
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);


                            }
                        }
                    }
                    //This is the BYGTree Maker in action. This would be tree leave Preset 3. I'd suggest commenting this out! SHOULD BE USED ONLY ON 1x1 TREE TRUNKS!
                    else if (leavePreset == 3) {
                        int leavessquarespos = 2;
                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 3, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1-1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight+ 1, posZ1-1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight+ 1, posZ1, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1-1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);


                            }
                        }
                    }*/

                    if (leavePreset == 1) {
                        int leavessquarespos = 2;
                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 3, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                            }
                        }
                    } else if (leavePreset == 2) {
                        int leavessquarespos = 2;
                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);


                            }
                        }
                    } else if (leavePreset == 3) {
                        int leavessquarespos = 2;
                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);


                            }
                        }
                    } else if (leavePreset == 4) {
                        int leavessquarespos = 2;
                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 - 1, boundsIn, changedBlocks);
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
            int distance = 1;

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

    //Log Placement
    private void treelog(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, LOG, boundingBox);
        }

    }

    //Leaves Placement
    private void leafs(ISeedReader reader, int x, int y, int z, MutableBoundingBox boundingBox, Set<BlockPos> blockPos) {
        BlockPos blockpos = new BlockPos(x, y, z);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, LEAVES, boundingBox);
        }

    }
}