package voronoiaoc.byg.common.world.feature.features.overworld.trees.palo_verde;

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

public class PaloVerdeTree2 extends BYGAbstractTreeFeature<NoFeatureConfig> {
    //BYGBlockRenders used for the tree.
    private static final BlockState LOG = BYGBlockList.PALO_VERDE_LOG.getDefaultState();
    private static final BlockState LEAVES = BYGBlockList.PALO_VERDE_LEAVES.getDefaultState();
    private static final BlockState LEAVES2 = BYGBlockList.FLOWERING_PALO_VERDE_LEAVES.getDefaultState();
    private static final BlockState BEENEST = Blocks.BEE_NEST.getDefaultState();
    Random random = new Random();

    public PaloVerdeTree2(Codec<NoFeatureConfig> configIn, int beeHiveChance) {
        super(configIn);
        //setSapling((net.minecraftforge.common.IPlantable) BYGBlockList.PALO_VERDE_SAPLING);
    }


    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling) {

        int randTreeHeight = rand.nextInt(1) + 1;
        //Positions
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < 256) {
            BlockPos blockpos = pos.down();
            if (worldIn.getBlockState(pos.down()).getBlock() != Blocks.GRASS_BLOCK && (worldIn.getBlockState(pos.down()).getBlock() != Blocks.RED_SAND && worldIn.getBlockState(pos.down()).getBlock() != Blocks.COARSE_DIRT)) {
                return false;
            } else {


                Direction direction = Direction.Plane
.HORIZONTAL.random(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);//Crashes on 0.
                int posY1 = 2 - rand.nextInt(1);//Crashes on 0.
                int posX1 = posX;
                int posZ1 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;
                int topTrunkHeight2 = posY + randTreeHeight + randTreeHeight - 1;


                for (int buildTrunk = 0; buildTrunk < randTreeHeight; ++buildTrunk) {
                    if (buildTrunk >= randTreeHeight2 && posY1 < 0) { //Unknown
                        posX1 += direction.getXOffset();
                        posZ1 += direction.getZOffset();
                        ++posY1;
                    }

                    int logplacer = posY + buildTrunk;
                    int logplacer2 = posY + randTreeHeight;
                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
                    BlockPos blockpos2 = new BlockPos(posX1, logplacer2, posZ1);

                    //Sets Logs
                    this.treelog(changedBlocks, worldIn, blockpos1, boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.east().north(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.east(2).north(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.east(3).north(2).up(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.east(4).north().up(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south().west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south(2).west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south(3).west(2).up(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south(3).west(2).up(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south(3).west(3).up(3), boundsIn);
                }


                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                        int posX2 = posX1 - 2;
                        int posZ2 = posZ1 + 3;

                        int posX3 = posX1 + 4;
                        int posZ3 = posZ1 - 2;

                        //Bottom Leaves
                        this.leafs(worldIn, posX2 + posXLeafWidth, topTrunkHeight + 4, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafWidth - 2, topTrunkHeight + 4, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafWidth - 1, topTrunkHeight + 4, posZ2 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafWidth - 1, topTrunkHeight + 4, posZ2 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX3 + posXLeafWidth, topTrunkHeight + 3, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 + posXLeafWidth - 2, topTrunkHeight + 3, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight + 3, posZ3 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight + 3, posZ3 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        //3x3
                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                            this.leafs(worldIn, posX2 + posXLeafWidth - 1, topTrunkHeight + 5, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);

                            this.leafs(worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight + 4, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        }

                        //2x3
                        if (posXLeafWidth <= 0 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {
                        }

                        //Top Leaves

                        //Bottom Leaves
                        this.leafs(worldIn, posX2 - 1, topTrunkHeight + 5, posZ2 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 - 3, topTrunkHeight + 5, posZ2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + 1, topTrunkHeight + 5, posZ2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 - 1, topTrunkHeight + 5, posZ2 - 2, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX3 - 1, topTrunkHeight + 4, posZ3 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 - 3, topTrunkHeight + 4, posZ3, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 + 1, topTrunkHeight + 4, posZ3, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 - 1, topTrunkHeight + 4, posZ3 - 2, boundsIn, changedBlocks);

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
            this.setFinalBlockState(blockPos, reader, blockpos, this.randomizer(), boundingBox);
        }

    }

    private BlockState randomizer() {
        return (random.nextInt(3) == 0) ? LEAVES2 : LEAVES;
    }
}