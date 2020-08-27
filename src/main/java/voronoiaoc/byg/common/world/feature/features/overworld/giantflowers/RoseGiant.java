package voronoiaoc.byg.common.world.feature.features.overworld.giantflowers;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;

public class RoseGiant extends BYGAbstractTreeFeature<NoneFeatureConfiguration> {

    public RoseGiant(Codec<NoneFeatureConfiguration> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, WorldGenLevel worldIn, Random rand, BlockPos pos, BoundingBox boundsIn, boolean isSapling) {
        int randTreeHeight = 23 + rand.nextInt(5);
        BlockPos.MutableBlockPos mainmutable = new BlockPos.MutableBlockPos().set(pos);

        if (pos.getY() + randTreeHeight + 1 < 256) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.below(), Blocks.GRASS_BLOCK)) {
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
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 5, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 6, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 7, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.offset(0, 8, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 0, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 1, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 2, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 3, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 3, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 4, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 5, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 8, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 9, 2), boundsIn);
                this.pollen(changedBlocks, worldIn, mainmutable.offset(0, 9, 0), boundsIn);
                this.pollen(changedBlocks, worldIn, mainmutable.offset(-1, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 11, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 11, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 11, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 11, 3), boundsIn);
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.PLANT_STEM.defaultBlockState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.PLANT_STEM.defaultBlockState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        BlockPos.MutableBlockPos blockpos = new BlockPos.MutableBlockPos().set(pos);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, BYGBlockList.RED_PETAL.defaultBlockState(), boundingBox);
        }
    }

    //Leaves Placement
    private void pollen(Set<BlockPos> blockPos, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        BlockPos.MutableBlockPos blockpos = new BlockPos.MutableBlockPos().set(pos);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, BYGBlockList.POLLEN_BLOCK.defaultBlockState(), boundingBox);
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