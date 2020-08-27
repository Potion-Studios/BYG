package voronoiaoc.byg.common.world.feature.features.overworld.trees.redwood;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedRW;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;

public class RedwoodTree3 extends BYGAbstractTreeFeature<NoneFeatureConfiguration> {

    public RedwoodTree3(Codec<NoneFeatureConfiguration> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, WorldGenLevel worldIn, Random rand, BlockPos pos, BoundingBox boundsIn, boolean isSapling) {
        int randTreeHeight = 23 + rand.nextInt(5);
        BlockPos.MutableBlockPos mainmutable = new BlockPos.MutableBlockPos().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.below(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 0, -1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(-1, 0, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 0, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(1, 0, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 0, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 1, -1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(-1, 1, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 1, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(1, 1, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 1, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 2, -1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(-1, 2, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 2, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(1, 2, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 2, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 3, -1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(-1, 3, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 3, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(1, 3, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 3, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 4, -1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(-1, 4, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 4, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(1, 4, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 4, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 5, -1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(-1, 5, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 5, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(1, 5, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 5, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 6, -1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(-1, 6, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 6, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(1, 6, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 6, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 7, -1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(-1, 7, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 7, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(1, 7, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 7, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 8, -1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(-1, 8, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 8, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(1, 8, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 8, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 9, -1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(-1, 9, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 9, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(1, 9, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 9, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 10, -1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(-1, 10, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 10, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(1, 10, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 10, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 11, -1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(-1, 11, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 11, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(1, 11, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 11, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 12, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 12, -1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(-1, 12, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(1, 12, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 12, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 13, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 13, -1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(-1, 13, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(1, 13, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 13, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 14, -1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(-1, 14, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 14, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(1, 14, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 14, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 15, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 16, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 17, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 18, 0), boundsIn);


                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 15, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 15, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 15, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 16, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 16, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 16, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 16, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 17, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 17, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 17, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 17, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 18, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 18, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 18, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 18, 1), boundsIn);


                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 0, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 0, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 0, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 0, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 0, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 0, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 0, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 0, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 1, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 1, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 1, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 1, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 1, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 2, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 2, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 2, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 11, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 11, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 11, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 13, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 13, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 13, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 13, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 13, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 13, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 13, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 13, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 13, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 13, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 13, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 13, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 13, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 13, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 13, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 13, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 14, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 14, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 14, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 14, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 14, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 14, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 14, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 14, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 15, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 15, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 15, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 17, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 17, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 17, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 17, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 17, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 17, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 17, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 17, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 18, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 18, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 18, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 18, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 19, 0), boundsIn);
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.REDWOOD_LOG.defaultBlockState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.REDWOOD_LOG.defaultBlockState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, BYGBlockList.REDWOOD_LEAVES.defaultBlockState(), boundingBox);
        }
    }


    private boolean doesTreeFit(LevelSimulatedRW reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 0;

            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                    if (!canLogPlaceHere(reader, pos.set(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}