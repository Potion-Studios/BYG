package voronoiaoc.byg.common.world.feature.features.overworld.mushrooms;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;

public class EmburMushroom2 extends BYGAbstractTreeFeature<NoneFeatureConfiguration> {

    public EmburMushroom2(Codec<NoneFeatureConfiguration> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, WorldGenLevel worldIn, Random rand, BlockPos pos, BoundingBox boundsIn, boolean isSapling) {
        int randTreeHeight = 4 + rand.nextInt(5);
        BlockPos.MutableBlockPos mainmutable = new BlockPos.MutableBlockPos().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            BlockPos blockpos = pos.below();
            if (!isDesiredGround(worldIn, blockpos, BYGBlockList.EMBUR_NYLIUM)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 0, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 1, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 2, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 3, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 4, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 3, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 4, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 5, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 6, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 6, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(3, 6, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 6, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 7, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 7, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(4, 7, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 7, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(5, 7, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 7, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 8, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(5, 8, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 8, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 9, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(5, 9, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 9, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-4, 9, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(5, 10, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 10, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-4, 10, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(5, 11, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 11, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-3, 11, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-4, 11, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(5, 12, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-3, 12, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-3, 13, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-3, 14, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 3, -2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(0, 3, -2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(1, 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 3, -1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(-1, 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 4, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 4, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 4, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 4, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 4, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 4, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 4, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 5, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 5, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 5, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 5, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 8, -2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(1, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 8, -1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(3, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 8, 0), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(1, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-6, 8, 2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(-3, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-6, 8, 3), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(-3, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-6, 8, 4), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(-5, 8, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 8, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, 8, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 8, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 8, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, 9, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 9, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, 9, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 9, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 9, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 12, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 12, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 12, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 12, -1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(5, 12, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(7, 12, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 12, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(7, 12, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 12, 1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(5, 12, 1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(6, 12, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(7, 12, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 12, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 12, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 12, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 13, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 13, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 13, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 13, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 13, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 13, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 13, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 13, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 13, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 14, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 14, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 14, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 14, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 14, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 14, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 14, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, 14, 1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(-2, 14, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 14, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 14, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, 14, 2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(-2, 14, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 14, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, 14, 3), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.offset(-4, 14, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 14, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 14, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 14, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 14, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 15, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 15, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 15, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 16, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 16, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 16, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 16, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 16, 3), boundsIn);
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.EMBUR_PEDU.defaultBlockState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.EMBUR_PEDU.defaultBlockState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, BYGBlockList.EMBUR_GEL_BLOCK.defaultBlockState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs2(Set<BlockPos> blockPos, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, BYGBlockList.POLLEN_BLOCK.defaultBlockState(), boundingBox);
        }
    }


    private boolean doesTreeFit(LevelSimulatedReader reader, BlockPos blockPos, int height) {
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