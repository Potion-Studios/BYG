package voronoiaoc.byg.common.world.feature.features.overworld.giantflowers;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

public class DandelionGiant extends BYGAbstractTreeFeature<DefaultFeatureConfig> {

    public DandelionGiant(Codec<DefaultFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, StructureWorldAccess worldIn, Random rand, BlockPos pos, BlockBox boundsIn, boolean isSapling) {
        int randTreeHeight = 23 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().set(pos);

        if (pos.getY() + randTreeHeight + 1 < 256) {

            if (!isDesiredGroundwDirtTag(worldIn, pos, Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 0, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 1, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 2, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 3, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 5, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 6, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 0, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 0, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 3, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 4, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 6, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 6, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 7, 1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-1, 8, -1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-2, 8, 0), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-1, 8, 0), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(0, 8, 0), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-3, 8, 1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-2, 8, 1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(0, 8, 1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(1, 8, 1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-2, 8, 2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-1, 8, 2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(0, 8, 2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-1, 8, 3), boundsIn);
                this.pollen(changedBlocks, worldIn, mainmutable.add(-1, 8, 1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-2, 9, -1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-1, 9, -1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(0, 9, -1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-3, 9, 0), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-2, 9, 0), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(0, 9, 0), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(1, 9, 0), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-3, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, 1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(1, 9, 1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-3, 9, 2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-2, 9, 2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(0, 9, 2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(1, 9, 2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-2, 9, 3), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-1, 9, 3), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(0, 9, 3), boundsIn);
                this.pollen(changedBlocks, worldIn, mainmutable.add(-1, 9, 0), boundsIn);
                this.pollen(changedBlocks, worldIn, mainmutable.add(-2, 9, 1), boundsIn);
                this.pollen(changedBlocks, worldIn, mainmutable.add(0, 9, 1), boundsIn);
                this.pollen(changedBlocks, worldIn, mainmutable.add(-1, 9, 2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-2, 10, -2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-1, 10, -2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(0, 10, -2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-1, 10, -1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-4, 10, 0), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(2, 10, 0), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-4, 10, 1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-3, 10, 1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(1, 10, 1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(2, 10, 1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-4, 10, 2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(2, 10, 2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-1, 10, 3), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-2, 10, 4), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-1, 10, 4), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(0, 10, 4), boundsIn);
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, StructureWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.PLANT_STEM.getDefaultState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, StructureWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.PLANT_STEM.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, StructureWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        BlockPos.Mutable blockpos = new BlockPos.Mutable().set(pos);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, BYGBlockList.RED_PETAL.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs2(Set<BlockPos> blockPos, StructureWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        BlockPos.Mutable blockpos = new BlockPos.Mutable().set(pos);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, BYGBlockList.YELLOW_PETAL.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void pollen(Set<BlockPos> blockPos, StructureWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        BlockPos.Mutable blockpos = new BlockPos.Mutable().set(pos);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, BYGBlockList.POLLEN_BLOCK.getDefaultState(), boundingBox);
        }
    }


    private boolean doesTreeFit(TestableWorld reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.Mutable pos = new BlockPos.Mutable();

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