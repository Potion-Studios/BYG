package voronoiaoc.byg.common.world.feature.features.overworld.trees.aspen;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBiomeList;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class AspenTree extends BYGAbstractTreeFeature<NoFeatureConfig> {
    //Blocks used for the tree.
    private static final BlockState LOG = BYGBlockList.ASPEN_LOG.getDefaultState();
    private static final BlockState LEAVES = BYGBlockList.ASPEN_LEAVES.getDefaultState();
    private static final BlockState BEENEST = Blocks.BEE_NEST.getDefaultState();
    Random random = new Random();

    public AspenTree(Function<Dynamic<?>, ? extends NoFeatureConfig> configIn) {
        super(configIn);
        setSapling((net.minecraftforge.common.IPlantable) BYGBlockList.ASPEN_SAPLING);
    }

    protected static boolean canTreeReplace(IWorldGenerationBaseReader genBaseReader, BlockPos blockPos) {
        return canTreePlaceHere(
                genBaseReader, blockPos
        );
    }

    public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox boundsIn) {
        int minHeight = 8;
        if (worldIn instanceof IWorld) {
            Biome biome = ((IWorld) worldIn).getBiome(position);
            if (biome == BYGBiomeList.ASPENFORESTHILLS || biome == BYGBiomeList.SEASONALTAIGA || biome == BYGBiomeList.SEASONALTAIGAHILLS || biome == BYGBiomeList.SEASONALGIANTTAIGA)
                minHeight = 8;
        }
        int randTreeHeight = rand.nextInt(3) + minHeight;
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


                }
                //This allows a random rotation between 3 differently leave Presets in the same class. Optimizes Performance instead of the loading of several classes.

                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                        int posX2 = posX1 + 1;
                        int posZ2 = posZ1 + 1;

                        //Bottom Leaves
//                        this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight + 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
//                        this.leafs(worldIn, posX1 + posXLeafWidth - 2, topTrunkHeight + 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
//                        this.leafs(worldIn, posX1 + posXLeafWidth - 1, topTrunkHeight + 1, posZ1 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
//                        this.leafs(worldIn, posX1 + posXLeafWidth - 1, topTrunkHeight + 1, posZ1 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        //3x3
                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight + 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                        }

                        //2x3
                        if (posXLeafWidth <= 0 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {
                        }

                        //Bottom Leaves
                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1, topTrunkHeight - 1, posZ1 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 1, posZ1 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 2, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 3, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 1, posZ1 - 2, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 2, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 1, posZ1 - 2, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 2, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 1, posZ1 + 1, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 1, posZ1 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 1, posZ1 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 2, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);


                        this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight + 3, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight + 4, posZ1, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 1, topTrunkHeight + 3, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1 - 1, boundsIn, changedBlocks);
                    }
                }
            }
            return true;
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
            int distance = 2;

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