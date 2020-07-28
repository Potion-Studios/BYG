package voronoiaoc.byg.common.world.feature.features.overworld.trees.deciduous;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

//THIS FEATURE MUST BE REGISTERED & ADDED TO A BIOME!
public class BYGShrub extends BYGAbstractTreeFeature<DefaultFeatureConfig> {
    //BYGBlockRenders used for the tree.
    private static final BlockState LOG = Blocks.OAK_LOG.getDefaultState();
    private static final BlockState LEAVES = Blocks.OAK_LEAVES.getDefaultState();
    private static final BlockState LEAVES2 = BYGBlockList.RED_OAK_LEAVES.getDefaultState();
    private static final BlockState LEAVES3 = BYGBlockList.BROWN_OAK_LEAVES.getDefaultState();
    private static final BlockState LEAVES4 = BYGBlockList.ORANGE_OAK_LEAVES.getDefaultState();
    private static final BlockState LEAVES5 = BYGBlockList.YELLOW_BIRCH_LEAVES.getDefaultState();
    private static final BlockState BEENEST = Blocks.BEE_NEST.getDefaultState();

    public BYGShrub(Codec<DefaultFeatureConfig> configIn) {
        super(configIn);
    }


    public boolean place(Set<BlockPos> changedBlocks, StructureWorldAccess worldIn, Random rand, BlockPos position, BlockBox boundsIn) {

        int randTreeHeight = 1;
        //Positions
        int posX = position.getX();
        int posY = position.getY();
        int posZ = position.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < 256) {
            BlockPos blockpos = position.down();
            if (!isDesiredGroundwDirtTag(worldIn, blockpos, Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.doesTreeFit(worldIn, position, randTreeHeight)) {
                return false;
            } else {


//Uncommenting this will allow for a 2x2 dirt patch under the tree.
                /*//this.setGroundBlockAt(worldIn, blockpos.east(), position, Blocks.DIRT.getDefaultState());

                //this.setGroundBlockAt(worldIn, blockpos.south(), position, Blocks.DIRT.getDefaultState());

                //this.setGroundBlockAt(worldIn, blockpos.south().east(), position, Blocks.DIRT.getDefaultState());
*/
                //Uncommenting this will allow for a 3x3 dirt patch under the tree.
                /*//this.setGroundBlockAt(worldIn, blockpos.west(), position, Blocks.DIRT.getDefaultState());

                //this.setGroundBlockAt(worldIn, blockpos.south().west(), position, Blocks.DIRT.getDefaultState());

                //this.setGroundBlockAt(worldIn, blockpos.north(), position, Blocks.DIRT.getDefaultState());

                //this.setGroundBlockAt(worldIn, blockpos.north().east(), position, Blocks.DIRT.getDefaultState());

                //this.setGroundBlockAt(worldIn, blockpos.north().west(), position, Blocks.DIRT.getDefaultState());
*/


                Direction direction = Direction.Type.HORIZONTAL.random(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);//Crashes on 0.
                int posY1 = 2 - rand.nextInt(1);//Crashes on 0.
                int posX1 = posX;
                int posZ1 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;


                for (int buildTrunk = 0; buildTrunk < randTreeHeight; ++buildTrunk) {
                    if (buildTrunk >= randTreeHeight2 && posY1 < 0) { //Unknown
                        posX1 += direction.getOffsetX();
                        posZ1 += direction.getOffsetZ();
                        ++posY1;
                    }

                    int logplacer = posY + buildTrunk;
                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
                    //These BlockPos' allow you to make trunks thicker than 2x2,


                    //Sets Logs
                    if (isAir(worldIn, blockpos1)) {
                        this.treelog(changedBlocks, worldIn, blockpos1, boundsIn);
                    }
                }

                int leavePreset = rand.nextInt(1) + 1;
                {
                    if (leavePreset == 1) {
                        //This randomizer allows you to have randomly generating sized leave widths(X & Z). You can remove the randomizer and set your own value instead.
                        int leavessquarespos = rand.nextInt(1) + 1;
                        //This loads leaves in squares. Manually placing the squares can allow you to load in perfect squares.
                        for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                            for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
                                //int leaveheight = 1;//0 lines it up with top log
                                this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight, posZ1, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 2, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 2, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);

                                //Y+1
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);

                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                                this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
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

    private boolean doesTreeFit(TestableWorld reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.Mutable position = new BlockPos.Mutable();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 2;

            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                    if (!canTreePlaceHere(reader, position.set(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //Log Placement
    private void treelog(Set<BlockPos> setlogblock, StructureWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        if (canTreePlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, LOG, boundingBox);
        }

    }

    //Leaves Placement
    private void leafs(StructureWorldAccess reader, int x, int y, int z, BlockBox boundingBox, Set<BlockPos> blockPos) {
        BlockPos blockpos = new BlockPos(x, y, z);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, LEAVES, boundingBox);
        }

    }
}