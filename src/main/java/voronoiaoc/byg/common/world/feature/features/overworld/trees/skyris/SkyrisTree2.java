package voronoiaoc.byg.common.world.feature.features.overworld.trees.skyris;

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

public class SkyrisTree2 extends BYGAbstractTreeFeature<NoFeatureConfig> {
    //Blocks used for the tree.
    private static final BlockState LOG = BYGBlockList.SKYRIS_LOG.getDefaultState();
    private static final BlockState LEAVES = BYGBlockList.SKYRIS_LEAVES.getDefaultState();
    private static final BlockState LEAVES2 = BYGBlockList.SKYRIS_LEAVES_GREEN_APPLE.getDefaultState();
    private static final BlockState BEENEST = Blocks.BEE_NEST.getDefaultState();
    Random random = new Random();

    public SkyrisTree2(Function<Dynamic<?>, ? extends NoFeatureConfig> configIn, boolean doBlockNotifyIn, int beeHiveChance) {
        super(configIn);
        setSapling((net.minecraftforge.common.IPlantable) BYGBlockList.SKYRIS_SAPLING);
    }

    protected static boolean canTreeReplace(IWorldGenerationBaseReader genBaseReader, BlockPos blockPos) {
        return canTreePlaceHere(
                genBaseReader, blockPos
        );
    }

    public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox boundsIn) {
        //This sets heights for trees. Rand.nextint allows for tree height randomization. The final int value sets the minimum for tree Height.
        int randTreeHeight = rand.nextInt(2) + 3;
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
                //Places dirt under logs where/when necessary.
                this.setGroundBlockAt(worldIn, blockpos, position, Blocks.DIRT.getDefaultState());
                Direction direction = Direction.Plane.HORIZONTAL.random(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);//Crashes on 0.
                int posY1 = 2 - rand.nextInt(1);//Crashes on 0.
                int posX1 = posX;
                int posZ1 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;
                int topTrunkHeight2 = posY + randTreeHeight + randTreeHeight - 1;
                int topTrunkHeight3 = posY + randTreeHeight + randTreeHeight + 8;
                int topTrunkHeight4 = posY + randTreeHeight + randTreeHeight + 10;
                int topTrunkHeight5 = posY + randTreeHeight + randTreeHeight + 11;

                //Raising the 'groundUpLogRemover'  will remove all log blocks from the ground up no matter how thick the trunk is based on the value given. 5 would destroy all trunks from 5 up off the ground.
                for (int groundUpLogRemover = 0; groundUpLogRemover < randTreeHeight; ++groundUpLogRemover) {
                    if (groundUpLogRemover >= randTreeHeight2 && posY1 < 0) { //Unknown
                        posX1 += direction.getXOffset();
                        posZ1 += direction.getZOffset();
                        ++posY1;
                    }
                    //This Int is responsible for the Y coordinate of the trunk BlockPos'.
                    int logplacer = posY + groundUpLogRemover;
                    int logplacer2 = posY + randTreeHeight;
                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
                    BlockPos blockpos2 = new BlockPos(posX1, logplacer2, posZ1);

                    //Sets Logs
                    this.treelog(changedBlocks, worldIn, blockpos1, boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.south(2).east().up(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south(2).east().up(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south().east(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south().east().down(), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.south(3).east().up(3).west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south(4).east().up(3).west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south(5).east().up(4), boundsIn);


                    this.treelog(changedBlocks, worldIn, blockpos2.south().east(2).up(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south().east(2).up(4), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south().east(2).up(5), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south().east(3).up(5), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south(2).east(4).up(6), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.up(6), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.east().up(6), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north().up(7), boundsIn);


                }
                //This allows a random rotation between 3 differently leave Presets in the same class. Optimizes Performance instead of the loading of several classes.

                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                        int posX2 = posX1 + 1;
                        int posZ2 = posZ1 + 2;

                        int posX3 = posX1 + 2;
                        int posZ3 = posZ1 + 5;

                        int posX4 = posX1 + 1;
                        int posZ4 = posZ1 - 1;

                        int posX5 = posX1 + 5;
                        int posZ5 = posZ1 + 2;

                        //Top Leaves
                        this.leafs(worldIn, posX4 + posXLeafWidth - 2, topTrunkHeight4 - 6, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX4 + posXLeafWidth, topTrunkHeight4 - 6, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX4 + posXLeafWidth - 1, topTrunkHeight4 - 6, posZ4 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX4 + posXLeafWidth - 1, topTrunkHeight4 - 6, posZ4 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        //Middle Leaves
                        this.leafs(worldIn, posX5 + posXLeafWidth - 2, topTrunkHeight5 - 8, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX5 + posXLeafWidth, topTrunkHeight5 - 8, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX5 + posXLeafWidth - 1, topTrunkHeight5 - 8, posZ5 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX5 + posXLeafWidth - 1, topTrunkHeight5 - 8, posZ5 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        //Bottom Leaves
                        this.leafs(worldIn, posX3 - 1 + posXLeafWidth, topTrunkHeight3 - 7, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 - 1 + posXLeafWidth, topTrunkHeight3 - 7, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
//                        this.leafs(worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight3 - 1, posZ3 + posZLeafWidthL0 +1, boundsIn, changedBlocks);
//                        this.leafs(worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight3 - 1, posZ3 + posZLeafWidthL0 -1, boundsIn, changedBlocks);

                        //3x3
                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                            this.leafs(worldIn, posX4 + posXLeafWidth - 1, topTrunkHeight4 - 5, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                            this.leafs(worldIn, posX5 + posXLeafWidth - 1, topTrunkHeight5 - 7, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks); //Middle


                            this.leafs(worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight3 - 6, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks); //Bottom

                        }

                        //2x3
                        if (posXLeafWidth <= 0 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                        }


                        //Top Leaves
                        this.leafs(worldIn, posX4 - 1, topTrunkHeight4 - 5, posZ4 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX4 - 3, topTrunkHeight4 - 5, posZ4, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX4 + 1, topTrunkHeight4 - 5, posZ4, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX4 - 1, topTrunkHeight4 - 5, posZ4 - 2, boundsIn, changedBlocks);

                        //Middle Leaves
                        this.leafs(worldIn, posX5 - 1, topTrunkHeight5 - 7, posZ5 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX5 - 3, topTrunkHeight5 - 7, posZ5, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX5 + 1, topTrunkHeight5 - 7, posZ5, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX5 - 1, topTrunkHeight5 - 7, posZ5 - 2, boundsIn, changedBlocks);

                        //Bottom Leaves
                        this.leafs(worldIn, posX3 - 1, topTrunkHeight3 - 6, posZ3 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 - 3, topTrunkHeight3 - 6, posZ3, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 - 1, topTrunkHeight3 - 6, posZ3 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 + 1, topTrunkHeight3 - 6, posZ3, boundsIn, changedBlocks);


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
        BlockPos.Mutable position = new BlockPos.Mutable();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 4;

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
            this.setFinalBlockState(blockPos, reader, blockpos, this.randomizer(), boundingBox);
        }

    }

    private BlockState randomizer() {
        return (random.nextInt(25) == 0) ? LEAVES2 : LEAVES;
    }
}