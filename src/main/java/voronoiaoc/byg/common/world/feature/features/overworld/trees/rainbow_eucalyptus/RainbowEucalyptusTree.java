package voronoiaoc.byg.common.world.feature.features.overworld.trees.rainbow_eucalyptus;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

public class RainbowEucalyptusTree extends BYGAbstractTreeFeature<DefaultFeatureConfig> {
    //BYGBlockRenders used for the tree.
    private static final BlockState LOG = BYGBlockList.RAINBOW_EUCALYPTUS_LOG.getDefaultState();
    private static final BlockState LEAVES = BYGBlockList.RAINBOW_EUCALYPTUS_LEAVES.getDefaultState();
    private static final BlockState BEENEST = Blocks.BEE_NEST.getDefaultState();

    public RainbowEucalyptusTree(Codec<DefaultFeatureConfig> configIn) {
        super(configIn);
        //setSapling((net.minecraftforge.common.IPlantable) BYGBlockList.RAINBOW_EUCALYPTUS_SAPLING);
    }



    public boolean place(Set<BlockPos> changedBlocks, ServerWorldAccess worldIn, Random rand, BlockPos position, BlockBox boundsIn) {

        int randTreeHeight = rand.nextInt(3) + 16;
        //Positions
        int posX = position.getX();
        int posY = position.getY();
        int posZ = position.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < 256) {
            BlockPos blockpos = position.down();
            if (!isDesiredGround(worldIn, blockpos, Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.doesTreeFit(worldIn, position, randTreeHeight)) {
                return false;
            } else {


                Direction direction = Direction.Type.HORIZONTAL.random(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);//Crashes on 0.
                int posY1 = 2 - rand.nextInt(1);//Crashes on 0.
                int posX1 = posX;
                int posZ1 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;
                int topTrunkHeight2 = posY + randTreeHeight + randTreeHeight - 1;


                for (int buildTrunk = 0; buildTrunk < randTreeHeight; ++buildTrunk) {
                    if (buildTrunk >= randTreeHeight2 && posY1 < 0) { //Unknown
                        posX1 += direction.getOffsetX();
                        posZ1 += direction.getOffsetZ();
                        ++posY1;
                    }

                    int logplacer = posY + buildTrunk;
                    int logplacer2 = posY + randTreeHeight;
                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
                    BlockPos blockpos2 = new BlockPos(posX1, logplacer2, posZ1);

                    //Sets Logs
                    this.treelog(changedBlocks, worldIn, blockpos1, boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.down(5).north().west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.down(4).north().west(), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.down(4).north(2).west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.down(3).north(2).west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.down(2).north(2).west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.down().north(2).west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north(2).west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.up().north(2).west(2), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.north().east(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.up().north(2).east(2), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.south().west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.up().south().west(), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.down(5).south().east(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.down(6).south().east(), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.down(5).south(2).east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.down(4).south(2).east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.down(3).south(2).east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.down(2).south(2).east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.down().south(2).east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south(2).east(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.up().south(2).east(2), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.down(12).south().west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.down(11).south().west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.down(10).south(2).west(2), boundsIn);

                }


                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                        int posX2 = posX1 - 1;
                        int posZ2 = posZ1 + 2;

                        int posX3 = posX1 - 1;
                        int posZ3 = posZ1 - 2;

                        int posX4 = posX1 + 2;
                        int posZ4 = posZ1 + 1;

                        int posX5 = posX1 + 3;
                        int posZ5 = posZ1 + 2;

                        int posX6 = posX1 + 3;
                        int posZ6 = posZ1 - 2;

                        int posX7 = posX1 + 1;
                        int posZ7 = posZ1 + 1;


                        this.leafs(worldIn, posX2 + posXLeafWidth - 2, topTrunkHeight - 9, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafWidth, topTrunkHeight - 9, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafWidth - 1, topTrunkHeight - 9, posZ2 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafWidth - 1, topTrunkHeight - 9, posZ2 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX3 + posXLeafWidth - 2, topTrunkHeight - 2, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 + posXLeafWidth, topTrunkHeight - 2, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight - 2, posZ3 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight - 2, posZ3 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX4 + posXLeafWidth - 2, topTrunkHeight - 3, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX4 + posXLeafWidth, topTrunkHeight - 3, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX4 + posXLeafWidth - 1, topTrunkHeight - 3, posZ4 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX4 + posXLeafWidth - 1, topTrunkHeight - 3, posZ4 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX3 + posXLeafWidth - 2, topTrunkHeight + 2, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 + posXLeafWidth, topTrunkHeight + 2, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight + 2, posZ3 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight + 2, posZ3 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX5 + posXLeafWidth - 2, topTrunkHeight + 2, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX5 + posXLeafWidth, topTrunkHeight + 2, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX5 + posXLeafWidth - 1, topTrunkHeight + 2, posZ5 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX5 + posXLeafWidth - 1, topTrunkHeight + 2, posZ5 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX6 + posXLeafWidth - 2, topTrunkHeight + 2, posZ6 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX6 + posXLeafWidth, topTrunkHeight + 2, posZ6 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX6 + posXLeafWidth - 1, topTrunkHeight + 2, posZ6 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX6 + posXLeafWidth - 1, topTrunkHeight + 2, posZ6 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX7 + posXLeafWidth - 2, topTrunkHeight + 2, posZ7 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX7 + posXLeafWidth, topTrunkHeight + 2, posZ7 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX7 + posXLeafWidth - 1, topTrunkHeight + 2, posZ7 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX7 + posXLeafWidth - 1, topTrunkHeight + 2, posZ7 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        //3x3
                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {
                            this.leafs(worldIn, posX2 + posXLeafWidth - 1, topTrunkHeight - 8, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                            this.leafs(worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight - 1, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                            this.leafs(worldIn, posX4 + posXLeafWidth - 1, topTrunkHeight - 2, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                            this.leafs(worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight + 3, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                            this.leafs(worldIn, posX5 + posXLeafWidth - 1, topTrunkHeight + 3, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                            this.leafs(worldIn, posX6 + posXLeafWidth - 1, topTrunkHeight + 3, posZ6 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                            this.leafs(worldIn, posX7 + posXLeafWidth - 1, topTrunkHeight + 3, posZ7 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                        }

                        //2x3
                        if (posXLeafWidth <= 0 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {
                        }

//                        //Top Leaves
                        this.leafs(worldIn, posX2 - 1, topTrunkHeight - 8, posZ2 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 - 3, topTrunkHeight - 8, posZ2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + 1, topTrunkHeight - 8, posZ2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 - 1, topTrunkHeight - 8, posZ2 - 2, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX3 - 1, topTrunkHeight - 1, posZ3 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 - 3, topTrunkHeight - 1, posZ3, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 + 1, topTrunkHeight - 1, posZ3, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 - 1, topTrunkHeight - 1, posZ3 - 2, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX4 - 1, topTrunkHeight - 2, posZ4 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX4 - 3, topTrunkHeight - 2, posZ4, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX4 + 1, topTrunkHeight - 2, posZ4, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX4 - 1, topTrunkHeight - 2, posZ4 - 2, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX3 - 1, topTrunkHeight + 3, posZ3 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 - 3, topTrunkHeight + 3, posZ3, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 + 1, topTrunkHeight + 3, posZ3, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 - 1, topTrunkHeight + 3, posZ3 - 2, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX5 - 1, topTrunkHeight + 3, posZ5 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX5 - 3, topTrunkHeight + 3, posZ5, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX5 + 1, topTrunkHeight + 3, posZ5, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX5 - 1, topTrunkHeight + 3, posZ5 - 2, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX6 - 1, topTrunkHeight + 3, posZ6 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX6 - 3, topTrunkHeight + 3, posZ6, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX6 + 1, topTrunkHeight + 3, posZ6, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX6 - 1, topTrunkHeight + 3, posZ6 - 2, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX7 - 1, topTrunkHeight + 3, posZ7 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX7 - 3, topTrunkHeight + 3, posZ7, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX7 + 1, topTrunkHeight + 3, posZ7, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX7 - 1, topTrunkHeight + 3, posZ7 - 2, boundsIn, changedBlocks);

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
            int distance = 0;

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
    private void treelog(Set<BlockPos> setlogblock, ServerWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        if (canTreePlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, LOG, boundingBox);
        }

    }

    //Leaves Placement
    private void leafs(ServerWorldAccess reader, int x, int y, int z, BlockBox boundingBox, Set<BlockPos> blockPos) {
        BlockPos blockpos = new BlockPos(x, y, z);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, LEAVES, boundingBox);
        }

    }


}