package voronoiaoc.byg.common.world.feature.features.overworld.trees.joshua;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBiomeList;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

public class JoshuaTree2 extends BYGAbstractTreeFeature<NoFeatureConfig> {
    //BYGBlockRenders used for the tree.
    private static final BlockState LOG = Blocks.OAK_LOG.getDefaultState();
    private static final BlockState LEAVES = BYGBlockList.JOSHUA_LEAVES.getDefaultState();
    private static final BlockState LEAVES2 = BYGBlockList.RIPE_JOSHUA_LEAVES.getDefaultState();
    private static final BlockState BEENEST = Blocks.BEE_NEST.getDefaultState();
    Random random = new Random();

    public JoshuaTree2(Codec<NoFeatureConfig> configIn) {
        super(configIn);
        //setSapling((net.minecraftforge.common.IPlantable) BYGBlockList.JOSHUA_SAPLING);
    }


    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling) {

        int randTreeHeight = rand.nextInt(3) + 3;
        //Positions
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= this.redRockHeight(worldIn, pos) && posY + randTreeHeight + 1 < 256) {

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
                    this.treelog(changedBlocks, worldIn, blockpos2.west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.west().up(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.west().up(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.west().up(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.west().up(3).south(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.west().up(3).south(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.west().up(4), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.west(2).up(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.west(3).up(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.west(3).up(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.west(3).up().south(), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.north(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north().up(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north(2).up(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north(2).up(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north(3).up(), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.east(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.east().up(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.east().up().south(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.east().up().south(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.east().up(2).south(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.east(2).up(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.east().up(2), boundsIn);
                }


                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {


//                        //Top Leaves
                        this.leafs(worldIn, posX1 - 4, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 3, topTrunkHeight + 2, posZ1 - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 3, topTrunkHeight + 2, posZ1 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 3, topTrunkHeight + 4, posZ1, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight + 4, posZ1 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 1, topTrunkHeight + 3, posZ1 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 1, topTrunkHeight + 3, posZ1 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 1, topTrunkHeight + 2, posZ1 - 3, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1 - 4, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1 + 1, topTrunkHeight + 4, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 2, topTrunkHeight + 3, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 2, topTrunkHeight + 2, posZ1 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 2, topTrunkHeight + 2, posZ1 - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 3, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1 + 1, topTrunkHeight + 4, posZ1 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 1, topTrunkHeight + 2, posZ1 + 3, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1 - 1, topTrunkHeight + 6, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 2, topTrunkHeight + 5, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 1, topTrunkHeight + 5, posZ1 - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 1, topTrunkHeight + 5, posZ1 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 2, topTrunkHeight + 4, posZ1 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight + 4, posZ1 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight + 4, posZ1 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 1, topTrunkHeight + 4, posZ1 + 3, boundsIn, changedBlocks);


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

    public int redRockHeight(ISeedReader worldIn, BlockPos pos) {
        int minYHeight = 1;
        Biome biome = worldIn.getBiome(pos);
        if (biome == BYGBiomeList.REDROCKCANYON)
            minYHeight = 140;
        return minYHeight;
    }

    private BlockState randomizer() {
        return (random.nextInt(5) == 0) ? LEAVES2 : LEAVES;
    }
}
