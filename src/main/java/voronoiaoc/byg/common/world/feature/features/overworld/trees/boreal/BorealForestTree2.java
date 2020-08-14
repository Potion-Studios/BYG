package voronoiaoc.byg.common.world.feature.features.overworld.trees.boreal;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

//THIS FEATURE MUST BE REGISTERED & ADDED TO A BIOME!
public class BorealForestTree2 extends BYGAbstractTreeFeature<NoFeatureConfig> {
    //BYGBlockRenders used for the tree.
    private static final BlockState LOG = Blocks.SPRUCE_LOG.getDefaultState();
    private static final BlockState LEAVES = Blocks.SPRUCE_LEAVES.getDefaultState();
    private static final BlockState BEENEST = Blocks.BEE_NEST.getDefaultState();

    public BorealForestTree2(Codec<NoFeatureConfig> configIn) {
        super(configIn);
    }

    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling) {

        int randTreeHeight = rand.nextInt(2) + rand.nextInt(2) + 11;
        //Positions
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < worldIn.getHeight()) {
            BlockPos blockpos = pos.down();
            if (!isDesiredGroundwDirtTag(worldIn, blockpos, Blocks.GRASS_BLOCK) || !isDesiredGroundwDirtTag(worldIn, blockpos, BYGBlockList.PEAT)) {
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
                    this.treelog(changedBlocks, worldIn, blockpos1, boundsIn);
                }

                int leavePreset = rand.nextInt(1) + 1;
                int leaveRandomizer = rand.nextInt(10) + 1;
                int leaveRandomizer2 = rand.nextInt(65) + 1;
                int leaveRandomizer3 = rand.nextInt(4) + 1;
                int leaveRandomizer4 = rand.nextInt(25) + 17;
                int leaveRandomizer5 = rand.nextInt(2) + 1;


                int tHSub7 = 7;
                int tHSub8 = 8;
                int tHSub6 = 6;
                int tHSub4 = 4;
                int tHSub5 = 5;
                int tHSub3 = 3;
                int tHSub2 = 2;
                int tHSub1 = 1;
                {
                    if (leavePreset == 1) {
                        int leavessquarespos = 1;
                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub8, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub8, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub8, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - tHSub8, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - tHSub8, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - tHSub8, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - tHSub8, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - tHSub8, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - tHSub8, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub8, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub8, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub8, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub8, posZ1 + 1, boundsIn, changedBlocks);

                                if (leaveRandomizer <= 4) {
                                    this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub7, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub7, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub7, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - tHSub7, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - tHSub7, posZ1 + 2, boundsIn, changedBlocks);
                                } else if (leaveRandomizer > 5) {
                                    this.leafs(worldIn, posX1 + 1, topTrunkHeight - tHSub7, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 1, topTrunkHeight - tHSub7, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - tHSub7, posZ1 - 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - tHSub7, posZ1 + 1, boundsIn, changedBlocks);
                                }
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub6, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub6, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub6, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - tHSub6, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - tHSub6, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - tHSub6, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - tHSub6, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - tHSub6, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - tHSub6, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub6, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub6, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub6, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub6, posZ1 + 1, boundsIn, changedBlocks);

                                if (leaveRandomizer2 <= 40) {

                                    this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub5, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub5, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub5, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - tHSub5, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - tHSub5, posZ1 + 2, boundsIn, changedBlocks);
                                } else if (leaveRandomizer2 < 60) {
                                    this.leafs(worldIn, posX1 + 1, topTrunkHeight - tHSub5, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 1, topTrunkHeight - tHSub5, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - tHSub5, posZ1 - 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - tHSub5, posZ1 + 1, boundsIn, changedBlocks);
                                }
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub4, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub4, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - tHSub4, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - tHSub4, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - tHSub4, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - tHSub4, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - tHSub4, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - tHSub4, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub4, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub4, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub4, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub4, posZ1 + 1, boundsIn, changedBlocks);

                                if (leaveRandomizer3 == 1) {
                                    this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub3, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub3, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub3, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - tHSub3, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - tHSub3, posZ1 + 2, boundsIn, changedBlocks);
                                } else if (leaveRandomizer3 == 2) {
                                    this.leafs(worldIn, posX1 + 1, topTrunkHeight - tHSub2, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 1, topTrunkHeight - tHSub2, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - tHSub2, posZ1 - 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight - tHSub2, posZ1 + 1, boundsIn, changedBlocks);
                                }
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - tHSub1, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - tHSub1, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - tHSub1, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - tHSub1, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - tHSub1, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - tHSub1, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub1, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub1, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub1, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub1, posZ1 + 1, boundsIn, changedBlocks);

                                if (leaveRandomizer4 < 17) {
                                    this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 2, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 2, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);
                                } else if (leaveRandomizer4 > 19) {
                                    this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                }
                                if (leaveRandomizer5 == 1) {
                                    this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                } else if (leaveRandomizer5 == 2) {
                                    this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 - 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1 + 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1 - 1, boundsIn, changedBlocks);
                                    this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1 + 1, boundsIn, changedBlocks);

                                }
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