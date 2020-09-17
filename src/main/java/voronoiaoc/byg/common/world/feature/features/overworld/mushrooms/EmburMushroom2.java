package voronoiaoc.byg.common.world.feature.features.overworld.mushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.IWorldGenerationReader;
import voronoiaoc.byg.common.world.feature.config.BYGMushroomFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.util.BYGAbstractMushroomFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

public class EmburMushroom2 extends BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> {

    public EmburMushroom2(Codec<BYGMushroomFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(ISeedReader worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomFeatureConfig config) {
        BlockState STEM = config.getStemProvider().getBlockState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getBlockState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getBlockState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getBlockState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getBlockState(rand, pos);int randTreeHeight = 4 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            BlockPos blockpos = pos.down();
            if (!isDesiredGround(worldIn, blockpos, BYGBlockList.EMBUR_NYLIUM)) {
                return false;
            } else if (!this.doesTreeFit(worldIn, pos, randTreeHeight)) {
                return false;
            } else {
                placeStem(STEM, worldIn, mainmutable.add(0, 0, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 1, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 2, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 3, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 4, 0));
                this.treeBranch(worldIn, mainmutable.add(0, 3, -1));
                this.treeBranch(worldIn, mainmutable.add(0, 4, -1));
                this.treeBranch(worldIn, mainmutable.add(0, 5, -1));
                this.treeBranch(worldIn, mainmutable.add(0, 6, -1));
                this.treeBranch(worldIn, mainmutable.add(1, 6, -1));
                this.treeBranch(worldIn, mainmutable.add(3, 6, -1));
                this.treeBranch(worldIn, mainmutable.add(-1, 6, 0));
                this.treeBranch(worldIn, mainmutable.add(1, 7, -1));
                this.treeBranch(worldIn, mainmutable.add(2, 7, -1));
                this.treeBranch(worldIn, mainmutable.add(4, 7, -1));
                this.treeBranch(worldIn, mainmutable.add(-1, 7, 0));
                this.treeBranch(worldIn, mainmutable.add(5, 7, 0));
                this.treeBranch(worldIn, mainmutable.add(-2, 7, 1));
                this.treeBranch(worldIn, mainmutable.add(2, 8, -1));
                this.treeBranch(worldIn, mainmutable.add(5, 8, 0));
                this.treeBranch(worldIn, mainmutable.add(-2, 8, 1));
                this.treeBranch(worldIn, mainmutable.add(2, 9, -1));
                this.treeBranch(worldIn, mainmutable.add(5, 9, 0));
                this.treeBranch(worldIn, mainmutable.add(-2, 9, 1));
                this.treeBranch(worldIn, mainmutable.add(-4, 9, 3));
                this.treeBranch(worldIn, mainmutable.add(5, 10, 0));
                this.treeBranch(worldIn, mainmutable.add(-2, 10, 1));
                this.treeBranch(worldIn, mainmutable.add(-4, 10, 3));
                this.treeBranch(worldIn, mainmutable.add(5, 11, 0));
                this.treeBranch(worldIn, mainmutable.add(-2, 11, 1));
                this.treeBranch(worldIn, mainmutable.add(-3, 11, 2));
                this.treeBranch(worldIn, mainmutable.add(-4, 11, 3));
                this.treeBranch(worldIn, mainmutable.add(5, 12, 0));
                this.treeBranch(worldIn, mainmutable.add(-3, 12, 2));
                this.treeBranch(worldIn, mainmutable.add(-3, 13, 2));
                this.treeBranch(worldIn, mainmutable.add(-3, 14, 2));
                this.leafs(worldIn, mainmutable.add(-1, 3, -3));
                this.leafs(worldIn, mainmutable.add(0, 3, -3));
                this.leafs(worldIn, mainmutable.add(1, 3, -3));
                this.leafs(worldIn, mainmutable.add(-2, 3, -2));
                this.leafs2(worldIn, mainmutable.add(0, 3, -2));
                this.leafs2(worldIn, mainmutable.add(1, 3, -2));
                this.leafs(worldIn, mainmutable.add(2, 3, -2));
                this.leafs(worldIn, mainmutable.add(-2, 3, -1));
                this.leafs2(worldIn, mainmutable.add(-1, 3, -1));
                this.leafs(worldIn, mainmutable.add(2, 3, -1));
                this.leafs(worldIn, mainmutable.add(-2, 3, 0));
                this.leafs(worldIn, mainmutable.add(2, 3, 0));
                this.leafs(worldIn, mainmutable.add(-1, 3, 1));
                this.leafs(worldIn, mainmutable.add(0, 3, 1));
                this.leafs(worldIn, mainmutable.add(1, 3, 1));
                this.leafs(worldIn, mainmutable.add(-1, 4, -2));
                this.leafs(worldIn, mainmutable.add(0, 4, -2));
                this.leafs(worldIn, mainmutable.add(1, 4, -2));
                this.leafs(worldIn, mainmutable.add(-1, 4, -1));
                this.leafs(worldIn, mainmutable.add(1, 4, -1));
                this.leafs(worldIn, mainmutable.add(-1, 4, 0));
                this.leafs(worldIn, mainmutable.add(1, 4, 0));
                this.leafs(worldIn, mainmutable.add(0, 5, -2));
                this.leafs(worldIn, mainmutable.add(-1, 5, -1));
                this.leafs(worldIn, mainmutable.add(1, 5, -1));
                this.leafs(worldIn, mainmutable.add(0, 5, 0));
                this.leafs(worldIn, mainmutable.add(1, 8, -3));
                this.leafs(worldIn, mainmutable.add(2, 8, -3));
                this.leafs(worldIn, mainmutable.add(3, 8, -3));
                this.leafs(worldIn, mainmutable.add(0, 8, -2));
                this.leafs2(worldIn, mainmutable.add(1, 8, -2));
                this.leafs(worldIn, mainmutable.add(4, 8, -2));
                this.leafs(worldIn, mainmutable.add(0, 8, -1));
                this.leafs2(worldIn, mainmutable.add(3, 8, -1));
                this.leafs(worldIn, mainmutable.add(4, 8, -1));
                this.leafs(worldIn, mainmutable.add(0, 8, 0));
                this.leafs2(worldIn, mainmutable.add(1, 8, 0));
                this.leafs(worldIn, mainmutable.add(4, 8, 0));
                this.leafs(worldIn, mainmutable.add(-5, 8, 1));
                this.leafs(worldIn, mainmutable.add(-4, 8, 1));
                this.leafs(worldIn, mainmutable.add(-3, 8, 1));
                this.leafs(worldIn, mainmutable.add(1, 8, 1));
                this.leafs(worldIn, mainmutable.add(2, 8, 1));
                this.leafs(worldIn, mainmutable.add(3, 8, 1));
                this.leafs(worldIn, mainmutable.add(-6, 8, 2));
                this.leafs2(worldIn, mainmutable.add(-3, 8, 2));
                this.leafs(worldIn, mainmutable.add(-2, 8, 2));
                this.leafs(worldIn, mainmutable.add(-6, 8, 3));
                this.leafs2(worldIn, mainmutable.add(-3, 8, 3));
                this.leafs(worldIn, mainmutable.add(-2, 8, 3));
                this.leafs(worldIn, mainmutable.add(-6, 8, 4));
                this.leafs2(worldIn, mainmutable.add(-5, 8, 4));
                this.leafs(worldIn, mainmutable.add(-2, 8, 4));
                this.leafs(worldIn, mainmutable.add(-5, 8, 5));
                this.leafs(worldIn, mainmutable.add(-4, 8, 5));
                this.leafs(worldIn, mainmutable.add(-3, 8, 5));
                this.leafs(worldIn, mainmutable.add(1, 9, -2));
                this.leafs(worldIn, mainmutable.add(2, 9, -2));
                this.leafs(worldIn, mainmutable.add(3, 9, -2));
                this.leafs(worldIn, mainmutable.add(1, 9, -1));
                this.leafs(worldIn, mainmutable.add(3, 9, -1));
                this.leafs(worldIn, mainmutable.add(1, 9, 0));
                this.leafs(worldIn, mainmutable.add(2, 9, 0));
                this.leafs(worldIn, mainmutable.add(3, 9, 0));
                this.leafs(worldIn, mainmutable.add(-5, 9, 2));
                this.leafs(worldIn, mainmutable.add(-4, 9, 2));
                this.leafs(worldIn, mainmutable.add(-3, 9, 2));
                this.leafs(worldIn, mainmutable.add(-5, 9, 3));
                this.leafs(worldIn, mainmutable.add(-3, 9, 3));
                this.leafs(worldIn, mainmutable.add(-5, 9, 4));
                this.leafs(worldIn, mainmutable.add(-4, 9, 4));
                this.leafs(worldIn, mainmutable.add(-3, 9, 4));
                this.leafs(worldIn, mainmutable.add(2, 10, -2));
                this.leafs(worldIn, mainmutable.add(1, 10, -1));
                this.leafs(worldIn, mainmutable.add(2, 10, -1));
                this.leafs(worldIn, mainmutable.add(3, 10, -1));
                this.leafs(worldIn, mainmutable.add(2, 10, 0));
                this.leafs(worldIn, mainmutable.add(-4, 10, 2));
                this.leafs(worldIn, mainmutable.add(-5, 10, 3));
                this.leafs(worldIn, mainmutable.add(-3, 10, 3));
                this.leafs(worldIn, mainmutable.add(-4, 10, 4));
                this.leafs(worldIn, mainmutable.add(4, 12, -2));
                this.leafs(worldIn, mainmutable.add(5, 12, -2));
                this.leafs(worldIn, mainmutable.add(6, 12, -2));
                this.leafs(worldIn, mainmutable.add(3, 12, -1));
                this.leafs2(worldIn, mainmutable.add(5, 12, -1));
                this.leafs(worldIn, mainmutable.add(7, 12, -1));
                this.leafs(worldIn, mainmutable.add(3, 12, 0));
                this.leafs(worldIn, mainmutable.add(7, 12, 0));
                this.leafs(worldIn, mainmutable.add(3, 12, 1));
                this.leafs2(worldIn, mainmutable.add(5, 12, 1));
                this.leafs2(worldIn, mainmutable.add(6, 12, 1));
                this.leafs(worldIn, mainmutable.add(7, 12, 1));
                this.leafs(worldIn, mainmutable.add(4, 12, 2));
                this.leafs(worldIn, mainmutable.add(5, 12, 2));
                this.leafs(worldIn, mainmutable.add(6, 12, 2));
                this.leafs(worldIn, mainmutable.add(4, 13, -1));
                this.leafs(worldIn, mainmutable.add(5, 13, -1));
                this.leafs(worldIn, mainmutable.add(6, 13, -1));
                this.leafs(worldIn, mainmutable.add(4, 13, 0));
                this.leafs(worldIn, mainmutable.add(5, 13, 0));
                this.leafs(worldIn, mainmutable.add(6, 13, 0));
                this.leafs(worldIn, mainmutable.add(4, 13, 1));
                this.leafs(worldIn, mainmutable.add(5, 13, 1));
                this.leafs(worldIn, mainmutable.add(6, 13, 1));
                this.leafs(worldIn, mainmutable.add(5, 14, -1));
                this.leafs(worldIn, mainmutable.add(-4, 14, 0));
                this.leafs(worldIn, mainmutable.add(-3, 14, 0));
                this.leafs(worldIn, mainmutable.add(-2, 14, 0));
                this.leafs(worldIn, mainmutable.add(4, 14, 0));
                this.leafs(worldIn, mainmutable.add(5, 14, 0));
                this.leafs(worldIn, mainmutable.add(6, 14, 0));
                this.leafs(worldIn, mainmutable.add(-5, 14, 1));
                this.leafs2(worldIn, mainmutable.add(-2, 14, 1));
                this.leafs(worldIn, mainmutable.add(-1, 14, 1));
                this.leafs(worldIn, mainmutable.add(5, 14, 1));
                this.leafs(worldIn, mainmutable.add(-5, 14, 2));
                this.leafs2(worldIn, mainmutable.add(-2, 14, 2));
                this.leafs(worldIn, mainmutable.add(-1, 14, 2));
                this.leafs(worldIn, mainmutable.add(-5, 14, 3));
                this.leafs2(worldIn, mainmutable.add(-4, 14, 3));
                this.leafs(worldIn, mainmutable.add(-1, 14, 3));
                this.leafs(worldIn, mainmutable.add(-4, 14, 4));
                this.leafs(worldIn, mainmutable.add(-3, 14, 4));
                this.leafs(worldIn, mainmutable.add(-2, 14, 4));
                this.leafs(worldIn, mainmutable.add(-4, 15, 1));
                this.leafs(worldIn, mainmutable.add(-3, 15, 1));
                this.leafs(worldIn, mainmutable.add(-2, 15, 1));
                this.leafs(worldIn, mainmutable.add(-4, 15, 2));
                this.leafs(worldIn, mainmutable.add(-3, 15, 2));
                this.leafs(worldIn, mainmutable.add(-2, 15, 2));
                this.leafs(worldIn, mainmutable.add(-4, 15, 3));
                this.leafs(worldIn, mainmutable.add(-3, 15, 3));
                this.leafs(worldIn, mainmutable.add(-2, 15, 3));
                this.leafs(worldIn, mainmutable.add(-3, 16, 1));
                this.leafs(worldIn, mainmutable.add(-4, 16, 2));
                this.leafs(worldIn, mainmutable.add(-3, 16, 2));
                this.leafs(worldIn, mainmutable.add(-2, 16, 2));
                this.leafs(worldIn, mainmutable.add(-3, 16, 3));
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.EMBUR_PEDU.getDefaultState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.EMBUR_PEDU.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, BYGBlockList.EMBUR_GEL_BLOCK.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs2(Set<BlockPos> blockPos, IWorldGenerationReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
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