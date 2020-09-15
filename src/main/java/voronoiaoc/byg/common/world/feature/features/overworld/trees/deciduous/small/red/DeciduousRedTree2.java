package voronoiaoc.byg.common.world.feature.features.overworld.trees.deciduous.small.red;

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

public class DeciduousRedTree2 extends BYGAbstractTreeFeature<NoFeatureConfig> {

    public DeciduousRedTree2(Codec<NoFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling) {
        int randTreeHeight = 17 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 7, 5, 5, isSapling)) {
                return false;
            } else {
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 0, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 1, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 2, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 3, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 4, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 5, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 6, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 7, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 8, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 9, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 10, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 11, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 12, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 13, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 14, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 15, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 16, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 17, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 4, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 5, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 5, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 6, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 6, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 6, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 6, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 6, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 6, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 6, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 6, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 6, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 6, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 7, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 7, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 7, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 7, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 9, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 10, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 10, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 10, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 10, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 10, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 11, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 11, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 11, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 11, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 11, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 11, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 11, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 11, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 11, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 12, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 12, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 12, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 12, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 12, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 12, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 12, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 12, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 12, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 12, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 12, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 12, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 12, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 12, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 12, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 12, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 13, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 13, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 13, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 13, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 13, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 13, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 13, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 13, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 13, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 13, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 13, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 13, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 13, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 13, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 13, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 13, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 13, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 13, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 13, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 13, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 14, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 14, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 14, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 14, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 14, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 14, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 14, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 14, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 14, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 14, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 14, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 14, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 15, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 15, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 15, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 15, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 15, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 15, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 16, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 16, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 16, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 16, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 16, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 16, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 16, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 16, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 16, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 16, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 16, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 17, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 17, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 17, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 17, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 17, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 17, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 17, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 17, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 18, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 18, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 18, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 18, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 19, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 19, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 19, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 20, 1), boundsIn);
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, Blocks.DARK_OAK_LOG.getDefaultState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, Blocks.DARK_OAK_LOG.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, BYGBlockList.RED_OAK_LEAVES.getDefaultState(), boundingBox);
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