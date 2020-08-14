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
public class BorealForestTree1 extends BYGAbstractTreeFeature<NoFeatureConfig> {
    //BYGBlockRenders used for the tree.
    private static final BlockState LOG = Blocks.BIRCH_LOG.getDefaultState();
    private static final BlockState LEAVES = BYGBlockList.YELLOW_BIRCH_LEAVES.getDefaultState();
    private static final BlockState LEAVES2 = Blocks.BIRCH_LEAVES.getDefaultState();
    private static final BlockState BEENEST = Blocks.BEE_NEST.getDefaultState();

    public BorealForestTree1(Codec<NoFeatureConfig> configIn) {
        super(configIn);
    }


    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling) {

        int randTreeHeight = rand.nextInt(2) + rand.nextInt(2) + 9;
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
                    this.treelog(changedBlocks, worldIn, blockpos1.up(1), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos1.up(2), boundsIn);


                }

                int leaveColor = rand.nextInt(2) + 1;
                int tHSub5 = 5;
                int tHSub4 = 4;
                int tHSub3 = 3;
                int tHSub2 = 2;
                int tHSub1 = 1;
                {
                    if (leaveColor == 1) {
                        int leavessquarespos = 1;
                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub5, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub5, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub5, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - tHSub5, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - tHSub5, posZ1 + 2, boundsIn, changedBlocks);

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

                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub3, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub3, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub3, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - tHSub3, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - tHSub3, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - tHSub3, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight - tHSub3, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - tHSub3, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight - tHSub3, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub3, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub3, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub3, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub3, posZ1 + 1, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight - tHSub2, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight - tHSub2, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - tHSub2, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight - tHSub2, posZ1 + 2, boundsIn, changedBlocks);


                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight + tHSub1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight + tHSub1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + tHSub1, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + tHSub1, posZ1 + 1, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight + tHSub2, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight + tHSub2, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + tHSub2, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + tHSub2, posZ1 + 1, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1, topTrunkHeight + tHSub3, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + tHSub4, posZ1, boundsIn, changedBlocks);

                            }
                        }
                    } else if (leaveColor == 2) {
                        int leavessquarespos = 1;
                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
                                this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                                this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub5, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 2, topTrunkHeight - tHSub5, posZ1, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 2, topTrunkHeight - tHSub5, posZ1, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1, topTrunkHeight - tHSub5, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1, topTrunkHeight - tHSub5, posZ1 + 2, boundsIn, changedBlocks);

                                this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub4, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 2, topTrunkHeight - tHSub4, posZ1, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 2, topTrunkHeight - tHSub4, posZ1, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1, topTrunkHeight - tHSub4, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1, topTrunkHeight - tHSub4, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 1, topTrunkHeight - tHSub4, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 1, topTrunkHeight - tHSub4, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 1, topTrunkHeight - tHSub4, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 1, topTrunkHeight - tHSub4, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 2, topTrunkHeight - tHSub4, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 2, topTrunkHeight - tHSub4, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 2, topTrunkHeight - tHSub4, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 2, topTrunkHeight - tHSub4, posZ1 + 1, boundsIn, changedBlocks);

                                this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub3, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 2, topTrunkHeight - tHSub3, posZ1, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 2, topTrunkHeight - tHSub3, posZ1, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1, topTrunkHeight - tHSub3, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1, topTrunkHeight - tHSub3, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 1, topTrunkHeight - tHSub3, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 1, topTrunkHeight - tHSub3, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 1, topTrunkHeight - tHSub3, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 1, topTrunkHeight - tHSub3, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 2, topTrunkHeight - tHSub3, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 2, topTrunkHeight - tHSub3, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 2, topTrunkHeight - tHSub3, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 2, topTrunkHeight - tHSub3, posZ1 + 1, boundsIn, changedBlocks);

                                this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 + 2, topTrunkHeight - tHSub2, posZ1, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 2, topTrunkHeight - tHSub2, posZ1, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1, topTrunkHeight - tHSub2, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1, topTrunkHeight - tHSub2, posZ1 + 2, boundsIn, changedBlocks);


                                this.leafs2(worldIn, posX1 + posXLeafWidth, topTrunkHeight - tHSub1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                                this.leafs2(worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);

                                this.leafs2(worldIn, posX1 + 1, topTrunkHeight + tHSub1, posZ1, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 1, topTrunkHeight + tHSub1, posZ1, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1, topTrunkHeight + tHSub1, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1, topTrunkHeight + tHSub1, posZ1 + 1, boundsIn, changedBlocks);

                                this.leafs2(worldIn, posX1 + 1, topTrunkHeight + tHSub2, posZ1, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1 - 1, topTrunkHeight + tHSub2, posZ1, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1, topTrunkHeight + tHSub2, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1, topTrunkHeight + tHSub2, posZ1 + 1, boundsIn, changedBlocks);

                                this.leafs2(worldIn, posX1, topTrunkHeight + tHSub3, posZ1, boundsIn, changedBlocks);
                                this.leafs2(worldIn, posX1, topTrunkHeight + tHSub4, posZ1, boundsIn, changedBlocks);

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

    private void leafs2(ISeedReader reader, int x, int y, int z, MutableBoundingBox boundingBox, Set<BlockPos> blockPos) {
        BlockPos blockpos = new BlockPos(x, y, z);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, LEAVES2, boundingBox);
        }

    }
}