package voronoiaoc.byg.common.world.feature.features.overworld.mushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

public class EmburMushroom2 extends BYGAbstractTreeFeature<DefaultFeatureConfig> {

    public EmburMushroom2(Codec<DefaultFeatureConfig> configIn ) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, StructureWorldAccess worldIn, Random rand, BlockPos pos, BlockBox boundsIn) {
        int randTreeHeight = 4 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            BlockPos blockpos = pos.down();
            if (!isDesiredGround(worldIn, blockpos, BYGBlockList.EMBUR_NYLIUM)) {
                return false;
            } else if (!this.doesTreeFit(worldIn, pos, randTreeHeight)) {
                return false;
            } else {
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 0, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 1, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 2, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 3, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 4, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 3, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 4, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 5, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(0, 6, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 6, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(3, 6, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 6, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(1, 7, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 7, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(4, 7, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-1, 7, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(5, 7, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 7, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 8, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(5, 8, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 8, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(2, 9, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(5, 9, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 9, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 9, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(5, 10, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 10, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 10, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(5, 11, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-2, 11, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 11, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-4, 11, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(5, 12, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 12, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 13, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.add(-3, 14, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 3, -2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(0, 3, -2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(1, 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 3, -1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-1, 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 4, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 4, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 4, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 4, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 4, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 4, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 4, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 5, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 5, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 5, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 5, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, -2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(1, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, -1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(3, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, 0), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(1, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 8, 2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-3, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 8, 3), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-3, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-6, 8, 4), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-5, 8, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 8, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 8, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 8, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 8, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 9, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 9, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 9, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 9, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 9, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 10, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 12, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 12, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 12, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 12, -1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(5, 12, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(7, 12, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 12, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(7, 12, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 12, 1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(5, 12, 1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(6, 12, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(7, 12, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 12, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 12, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 12, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 13, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 13, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 13, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 13, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 13, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 13, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 13, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 13, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 13, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 14, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 14, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 14, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 14, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 14, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 14, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(6, 14, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 14, 1), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-2, 14, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 14, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(5, 14, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 14, 2), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-2, 14, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 14, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 14, 3), boundsIn);
                this.leafs2(changedBlocks, worldIn, mainmutable.add(-4, 14, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 14, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 14, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 14, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 14, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 15, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 15, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 15, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 15, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 16, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 16, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 16, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 16, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 16, 3), boundsIn);
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, StructureWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        if (canTreePlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.EMBUR_PEDU.getDefaultState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, StructureWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        if (canTreePlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.EMBUR_PEDU.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, StructureWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, BYGBlockList.EMBUR_GEL_BLOCK.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs2(Set<BlockPos> blockPos, StructureWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, BYGBlockList.POLLEN_BLOCK.getDefaultState(), boundingBox);
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
                    if (!canTreePlaceHere(reader, pos.set(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}