package voronoiaoc.byg.common.world.feature.features.overworld.trees.enchanted.green;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.Tags;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

//THIS FEATURE MUST BE REGISTERED & ADDED TO A BIOME!
public class GreenEnchantedGroveTree extends BYGAbstractTreeFeature<NoFeatureConfig> {
    //Blocks used for the tree.
    private static final BlockState LOG = BYGBlockList.GREEN_ENCHANTED_LOG.getDefaultState();
    private static final BlockState LEAVES = BYGBlockList.GREEN_ENCHANTED_LEAVES.getDefaultState();
    private static final BlockState LEAVES2 = BYGBlockList.GREEN_ENCHANTED_LEAVES.getDefaultState();
    private static final BlockState BEENEST = Blocks.BEE_NEST.getDefaultState();

    public GreenEnchantedGroveTree(Codec<NoFeatureConfig> configIn) {
        super(configIn);
    }

    protected static boolean canTreeReplace(IWorldGenerationBaseReader genBaseReader, BlockPos blockPos) {
        return canLogPlaceHere(
                genBaseReader, blockPos
        );
    }

    protected static boolean isDirtOrPeatBlock(IWorldGenerationBaseReader worldIn, BlockPos pos) {
        return worldIn.hasBlockState(pos, (state) -> {
            Block block = state.getBlock();
            return block.isIn(Tags.Blocks.DIRT) || block == BYGBlockList.PEAT;
        });
    }

    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling) {
        //This sets heights for trees. Rand.nextint allows for tree height randomization. The final int value sets the minimum for tree Height.
        int randTreeHeight = rand.nextInt(2) + rand.nextInt(2) + 9;
        //Positions
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < worldIn.getHeight()) {
            BlockPos blockpos = pos.down();
            if (!isDirtOrPeatBlock(worldIn, blockpos)) {
                return false;
            } else {
                //Places dirt under logs where/when necessary.

                Direction direction = Direction.Plane
.HORIZONTAL.random(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);//Crashes on 0.
                int posY1 = 2 - rand.nextInt(1);//Crashes on 0.
                int posX1 = posX;
                int posZ1 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;

                //Raising the 'groundUpLogRemover'  will remove all log blocks from the ground up no matter how thick the trunk is based on the value given. 5 would destroy all trunks from 5 up off the ground.
                for (int groundUpLogRemover = 0; groundUpLogRemover < randTreeHeight; ++groundUpLogRemover) {
                    if (groundUpLogRemover >= randTreeHeight2 && posY1 < 0) { //Unknown
                        posX1 += direction.getXOffset();
                        posZ1 += direction.getZOffset();
                        ++posY1;
                    }
                    //This Int is responsible for the Y coordinate of the trunk BlockPos'.
                    int logplacer = posY + groundUpLogRemover;
                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
                    this.treelog(changedBlocks, worldIn, blockpos1, boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos1.up(1), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos1.up(2), boundsIn);


                }
                //This allows a random rotation between 3 differently leave Presets in the same class. Optimizes Performance instead of the loading of several classes.
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

    private boolean doesTreeFit(IWorldGenerationBaseReader reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.Mutable pos = new BlockPos.Mutable();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 2;

            for (int xDistance = -distance; xDistance <= distance; ++xDistance) {
                for (int zDistance = -distance; zDistance <= distance; ++zDistance) {
                    if (!canTreeReplace(reader, pos.setPos(x + xDistance, y + yOffset, z + zDistance))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //Log Placement
    private void treelog(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canTreeReplace(reader, pos)) {
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