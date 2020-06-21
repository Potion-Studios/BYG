package voronoiaoc.byg.common.world.feature.features.overworld.giantflowers;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
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

public class DandelionGiant extends BYGAbstractTreeFeature<NoFeatureConfig> {

    public DandelionGiant(Function<Dynamic<?>, ? extends NoFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn) {
        int randTreeHeight = 23 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable(pos);

        if (pos.getY() >= 1 && pos.getY() + randTreeHeight + 1 < 256) {
            BlockPos blockpos = pos.down();
            if (!isDesiredGround(worldIn, blockpos, Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.doesTreeFit(worldIn, pos, randTreeHeight)) {
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
    private void treeLog(Set<BlockPos> setlogblock, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canTreePlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.PLANT_STEM.getDefaultState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canTreePlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.PLANT_STEM.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        BlockPos.Mutable blockpos = new BlockPos.Mutable(pos);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos,  BYGBlockList.RED_PETAL.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs2(Set<BlockPos> blockPos, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        BlockPos.Mutable blockpos = new BlockPos.Mutable(pos);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos,  BYGBlockList.YELLOW_PETAL.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void pollen(Set<BlockPos> blockPos, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        BlockPos.Mutable blockpos = new BlockPos.Mutable(pos);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos,  BYGBlockList.POLLEN_BLOCK.getDefaultState(), boundingBox);
        }
    }


    private boolean doesTreeFit(IWorldGenerationBaseReader reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.Mutable pos = new BlockPos.Mutable();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 7;

            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                    if (!canTreePlaceHere(reader, pos.setPos(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}