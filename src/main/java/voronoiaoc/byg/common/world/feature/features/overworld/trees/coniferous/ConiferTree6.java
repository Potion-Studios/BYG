package voronoiaoc.byg.common.world.feature.features.overworld.trees.coniferous;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

public class ConiferTree6 extends BYGAbstractTreeFeature<NoneFeatureConfiguration> {
    //Blocks used for the tree.
    private static final BlockState LOG = BYGBlockList.FIR_LOG.defaultBlockState();
    private static final BlockState LEAVES = BYGBlockList.FIR_LEAVES.defaultBlockState();
    private static final BlockState BEENEST = Blocks.BEE_NEST.defaultBlockState();

    public ConiferTree6(Codec<NoneFeatureConfiguration> configIn) {
        super(configIn);
        //setSapling((net.minecraftforge.common.IPlantable) BYGBlockList.FIR_SAPLING);

    }

    protected static boolean canTreePlace(LevelSimulatedReader genBaseReader, BlockPos blockPos) {
        return canLogPlaceHere(
                genBaseReader, blockPos
        );
    }

    public boolean place(Set<BlockPos> changedBlocks, WorldGenLevel worldIn, Random rand, BlockPos pos, BoundingBox boundsIn, boolean isSapling) {
        //This sets heights for trees. Rand.nextint allows for tree height randomization. The final int value sets the minimum for tree Height.
        int randTreeHeight = rand.nextInt(3) + rand.nextInt(3) + 11;
        //Positions
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < worldIn.getHeight()) {
            BlockPos checkGround = pos.below();
            if (!isDesiredGroundwDirtTag(worldIn, checkGround, Blocks.GRASS_BLOCK)) {
                return false;
            }else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, 5, 5, isSapling)) {
                return false;
            } else {

                Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);//Crashes on 0.
                int posY2 = 2 - rand.nextInt(1);//Crashes on 0.
                int posX2 = posX;
                int posZ2 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;

                for (int trunkBottom = 0; trunkBottom < randTreeHeight; ++trunkBottom) {
                    if (trunkBottom >= randTreeHeight2 && posY2 < 0) { //Unknown
                        posX2 += direction.getStepX();
                        posZ2 += direction.getStepZ();
                        ++posY2;
                    }
                    int logplacer = posY + trunkBottom;


                    BlockPos trunkPos1 = new BlockPos(posX2, logplacer, posZ2);
                    this.treelog(changedBlocks, worldIn, trunkPos1, boundsIn);

                }
                for (int posXLeafSize = -1; posXLeafSize <= 1; ++posXLeafSize) {
                    for (int posZLeafSize = -1; posZLeafSize <= 1; ++posZLeafSize) {
                        this.leafs(worldIn, posX2, topTrunkHeight + 2, posZ2, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX2, topTrunkHeight + 1, posZ2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + 1, topTrunkHeight + 1, posZ2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 - 1, topTrunkHeight + 1, posZ2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2, topTrunkHeight + 1, posZ2 - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2, topTrunkHeight + 1, posZ2 + 1, boundsIn, changedBlocks);


                        this.leafs(worldIn, posX2 + posXLeafSize, topTrunkHeight - 1, posZ2 + posZLeafSize + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafSize, topTrunkHeight - 1, posZ2 + posZLeafSize - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafSize - 1, topTrunkHeight - 1, posZ2 + posZLeafSize, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafSize + 1, topTrunkHeight - 1, posZ2 + posZLeafSize, boundsIn, changedBlocks);


                        this.leafs(worldIn, posX2 + 1, topTrunkHeight - 2, posZ2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 - 1, topTrunkHeight - 2, posZ2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2, topTrunkHeight - 2, posZ2 - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2, topTrunkHeight - 2, posZ2 + 1, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX2 + posXLeafSize, topTrunkHeight - 3, posZ2 + posZLeafSize + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafSize, topTrunkHeight - 3, posZ2 + posZLeafSize - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafSize - 1, topTrunkHeight - 3, posZ2 + posZLeafSize, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafSize + 1, topTrunkHeight - 3, posZ2 + posZLeafSize, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX2 + 1, topTrunkHeight - 4, posZ2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 - 1, topTrunkHeight - 4, posZ2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2, topTrunkHeight - 4, posZ2 - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2, topTrunkHeight - 4, posZ2 + 1, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX2 + posXLeafSize + 1, topTrunkHeight - 5, posZ2 + posZLeafSize + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafSize - 1, topTrunkHeight - 5, posZ2 + posZLeafSize - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafSize + 1, topTrunkHeight - 5, posZ2 + posZLeafSize - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafSize - 1, topTrunkHeight - 5, posZ2 + posZLeafSize + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + 3, topTrunkHeight - 5, posZ2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 - 3, topTrunkHeight - 5, posZ2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2, topTrunkHeight - 5, posZ2 - 3, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2, topTrunkHeight - 5, posZ2 + 3, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX2 + posXLeafSize, topTrunkHeight - 6, posZ2 + posZLeafSize, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + 2, topTrunkHeight - 6, posZ2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 - 2, topTrunkHeight - 6, posZ2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2, topTrunkHeight - 6, posZ2 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2, topTrunkHeight - 6, posZ2 + 2, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX2 + posXLeafSize, topTrunkHeight - 7, posZ2 + posZLeafSize + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafSize, topTrunkHeight - 7, posZ2 + posZLeafSize - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafSize - 2, topTrunkHeight - 7, posZ2 + posZLeafSize, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafSize + 2, topTrunkHeight - 7, posZ2 + posZLeafSize, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafSize + 1, topTrunkHeight - 7, posZ2 + posZLeafSize + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafSize - 1, topTrunkHeight - 7, posZ2 + posZLeafSize - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafSize + 1, topTrunkHeight - 7, posZ2 + posZLeafSize - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafSize - 1, topTrunkHeight - 7, posZ2 + posZLeafSize + 1, boundsIn, changedBlocks);


                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    //This Method essentially checks whether or not our tree can generate
    private boolean doesTreeFit(LevelSimulatedReader reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 0;

            for (int xDistance = -distance; xDistance <= distance; ++xDistance) {
                for (int zDistance = -distance; zDistance <= distance; ++zDistance) {
                    if (!canTreePlace(reader, pos.set(x + xDistance, y + yOffset, z + zDistance))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //Log Placement
    private void treelog(Set<BlockPos> setlogblock, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (canTreePlace(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, LOG, boundingBox);
        }

    }

    //Leaves Placement
    private void leafs(WorldGenLevel reader, int x, int y, int z, BoundingBox boundingBox, Set<BlockPos> blockPos) {
        BlockPos leafpos = new BlockPos(x, y, z);
        if (isAir(reader, leafpos)) {
            this.setFinalBlockState(blockPos, reader, leafpos, LEAVES, boundingBox);
        }

    }

}