package voronoiaoc.byg.common.world.feature.features.overworld.mushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

public class DeathCapTree1 extends BYGAbstractTreeFeature<NoFeatureConfig> {

    public DeathCapTree1(Codec<NoFeatureConfig> configIn) {
        super(configIn);
    }

    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling) {
        int randTreeHeight = 5 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            BlockPos blockpos = pos.down();
            if (!isDesiredGroundwDirtTag(worldIn, blockpos, BYGBlockList.SYTHIAN_NYLIUM)) {
                return false;
            } else if (!this.doesTreeFit(worldIn, pos, randTreeHeight)) {
                return false;
            } else {
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 0, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 1, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 2, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 3, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 4, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 5, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 5, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 5, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 5, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 5, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 5, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 5, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 5, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 5, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 5, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 5, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 5, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 5, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 5, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 5, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 5, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 5, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 5, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 5, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 5, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 5, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 6, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 6, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 6, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 6, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 6, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 6, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 6, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 6, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 6, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 6, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 6, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 6, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 6, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 6, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 6, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 6, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 6, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 6, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 6, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 6, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 6, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 6, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 6, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 6, 2), boundsIn);
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.WHITE_MUSHROOM_STEM.getDefaultState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.WHITE_MUSHROOM_STEM.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, BYGBlockList.DEATH_CAP_MUSHROOM_BLOCK.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void vines(Set<BlockPos> blockPos, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, BYGBlockList.SOUL_SHROOM_SPORE_END.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void vinesplant(Set<BlockPos> blockPos, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, BYGBlockList.SOUL_SHROOM_SPORE.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void shroomlight(Set<BlockPos> blockPos, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, Blocks.SHROOMLIGHT.getDefaultState(), boundingBox);
        }
    }


    private boolean doesTreeFit(IWorldGenerationBaseReader reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.Mutable pos = new BlockPos.Mutable();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 0;

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
}