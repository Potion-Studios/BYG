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

public class WarpedFungus1 extends BYGAbstractTreeFeature<NoFeatureConfig> {

    public WarpedFungus1(Codec<NoFeatureConfig> configIn) {
        super(configIn);
    }

    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling) {
        int randTreeHeight = 10 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            BlockPos blockpos = pos.down();
            if (!isDesiredGroundwDirtTag(worldIn, blockpos, BYGBlockList.OVERGROWN_CRIMSON_BLACKSTONE)) {
                return false;
            } else if (!this.doesTreeFit(worldIn, pos, randTreeHeight)) {
                return false;
            } else {
                this.treeLog(changedBlocks, worldIn, mainmutable.add(-1, 0, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(-1, 0, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 0, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 0, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(-1, 1, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(-1, 1, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 1, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 1, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(-1, 2, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(-1, 2, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 2, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 2, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(-1, 3, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(-1, 3, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 3, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 3, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(-1, 4, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(-1, 4, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 4, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 4, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(-1, 5, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(-1, 5, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 5, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 5, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(-1, 6, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(-1, 6, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 6, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 6, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(-1, 7, 0), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(-1, 7, 1), boundsIn);
                this.treeLog(changedBlocks, worldIn, mainmutable.add(0, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 5, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 5, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 6, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 6, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 6, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 6, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 6, 1), boundsIn);
                this.shroomlight(changedBlocks, worldIn, mainmutable.add(-6, 7, 1), boundsIn);
                this.shroomlight(changedBlocks, worldIn, mainmutable.add(-6, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 7, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 7, 4), boundsIn);
                this.shroomlight(changedBlocks, worldIn, mainmutable.add(-3, 7, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 7, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 7, 4), boundsIn);
                this.shroomlight(changedBlocks, worldIn, mainmutable.add(-2, 7, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 7, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 7, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 7, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 7, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 7, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 7, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 7, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 7, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 7, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 7, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 7, 5), boundsIn);
                this.shroomlight(changedBlocks, worldIn, mainmutable.add(1, 7, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 7, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 7, 4), boundsIn);
                this.shroomlight(changedBlocks, worldIn, mainmutable.add(2, 7, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 7, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 7, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 7, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 7, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 7, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 7, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 7, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 7, 2), boundsIn);
                this.shroomlight(changedBlocks, worldIn, mainmutable.add(5, 7, -1), boundsIn);
                this.shroomlight(changedBlocks, worldIn, mainmutable.add(5, 7, 0), boundsIn);
                this.shroomlight(changedBlocks, worldIn, mainmutable.add(-6, 8, 1), boundsIn);
                this.shroomlight(changedBlocks, worldIn, mainmutable.add(-6, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 8, 4), boundsIn);
                this.shroomlight(changedBlocks, worldIn, mainmutable.add(-3, 8, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 8, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 8, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 8, 5), boundsIn);
                this.shroomlight(changedBlocks, worldIn, mainmutable.add(-2, 8, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 8, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 8, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 8, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 8, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 8, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 8, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 8, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 8, 5), boundsIn);
                this.shroomlight(changedBlocks, worldIn, mainmutable.add(1, 8, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 8, 5), boundsIn);
                this.shroomlight(changedBlocks, worldIn, mainmutable.add(2, 8, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 8, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 8, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 8, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 8, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 8, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 8, 3), boundsIn);
                this.shroomlight(changedBlocks, worldIn, mainmutable.add(5, 8, -1), boundsIn);
                this.shroomlight(changedBlocks, worldIn, mainmutable.add(5, 8, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 9, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 9, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-5, 9, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 9, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 9, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 9, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-4, 9, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 9, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-3, 9, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 9, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-2, 9, 5), boundsIn);
                this.shroomlight(changedBlocks, worldIn, mainmutable.add(-2, 9, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(-1, 9, 5), boundsIn);
                this.shroomlight(changedBlocks, worldIn, mainmutable.add(-1, 9, 6), boundsIn);
                this.shroomlight(changedBlocks, worldIn, mainmutable.add(0, 9, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 9, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(0, 9, 5), boundsIn);
                this.shroomlight(changedBlocks, worldIn, mainmutable.add(1, 9, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(1, 9, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 9, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(2, 9, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 9, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 9, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 9, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(3, 9, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 9, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 9, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 9, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 9, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 9, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 9, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 9, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.add(4, 9, 4), boundsIn);
                this.shroomlight(changedBlocks, worldIn, mainmutable.add(-2, 10, 5), boundsIn);
                this.shroomlight(changedBlocks, worldIn, mainmutable.add(-1, 10, 6), boundsIn);
                this.shroomlight(changedBlocks, worldIn, mainmutable.add(0, 10, -4), boundsIn);
                this.shroomlight(changedBlocks, worldIn, mainmutable.add(1, 10, -5), boundsIn);
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, Blocks.WARPED_STEM.getDefaultState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, Blocks.WARPED_STEM.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, Blocks.WARPED_WART_BLOCK.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void vinesplant(Set<BlockPos> blockPos, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, Blocks.WEEPING_VINES_PLANT.getDefaultState(), boundingBox);
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