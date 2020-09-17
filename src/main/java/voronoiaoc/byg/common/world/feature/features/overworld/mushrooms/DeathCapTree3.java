package voronoiaoc.byg.common.world.feature.features.overworld.mushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import voronoiaoc.byg.common.world.feature.config.BYGMushroomFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.util.BYGAbstractMushroomFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;

public class DeathCapTree3 extends BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> {

    public DeathCapTree3(Codec<BYGMushroomFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(ISeedReader worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomFeatureConfig config) {
        BlockState STEM = config.getStemProvider().getBlockState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getBlockState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getBlockState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getBlockState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getBlockState(rand, pos);int randTreeHeight = 13 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            BlockPos blockpos = pos.down();
            if (!isDesiredGroundwDirtTag(worldIn, blockpos, BYGBlockList.SYTHIAN_NYLIUM)) {
                return false;
            } else if (!this.doesTreeFit(worldIn, pos, randTreeHeight)) {
                return false;
            } else {
                placeStem(STEM, worldIn, mainmutable.add(0, 0, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 1, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 2, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 3, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 4, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 5, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 6, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 7, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 8, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 9, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 10, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 11, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 12, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 13, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 14, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 15, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 16, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 17, 0));
                this.treeBranch(worldIn, mainmutable.add(1, 4, 1));
                this.treeBranch(worldIn, mainmutable.add(1, 5, 1));
                this.treeBranch(worldIn, mainmutable.add(2, 5, 2));
                this.treeBranch(worldIn, mainmutable.add(2, 6, 2));
                this.treeBranch(worldIn, mainmutable.add(3, 6, 3));
                this.treeBranch(worldIn, mainmutable.add(-1, 7, 0));
                this.treeBranch(worldIn, mainmutable.add(3, 7, 3));
                this.treeBranch(worldIn, mainmutable.add(3, 7, 4));
                this.treeBranch(worldIn, mainmutable.add(-2, 8, 0));
                this.treeBranch(worldIn, mainmutable.add(1, 8, -1));
                this.treeBranch(worldIn, mainmutable.add(3, 8, 4));
                this.treeBranch(worldIn, mainmutable.add(-3, 9, -1));
                this.treeBranch(worldIn, mainmutable.add(-2, 9, 0));
                this.treeBranch(worldIn, mainmutable.add(1, 9, -1));
                this.treeBranch(worldIn, mainmutable.add(2, 9, -2));
                this.treeBranch(worldIn, mainmutable.add(3, 9, 4));
                this.treeBranch(worldIn, mainmutable.add(-3, 10, -1));
                this.treeBranch(worldIn, mainmutable.add(2, 10, -2));
                this.treeBranch(worldIn, mainmutable.add(3, 10, -3));
                this.treeBranch(worldIn, mainmutable.add(-3, 11, -1));
                this.treeBranch(worldIn, mainmutable.add(3, 11, -3));
                this.treeBranch(worldIn, mainmutable.add(3, 12, -3));
                this.treeBranch(worldIn, mainmutable.add(3, 13, -3));
                this.leafs(worldIn, mainmutable.add(2, 9, 3));
                this.leafs(worldIn, mainmutable.add(2, 9, 4));
                this.leafs(worldIn, mainmutable.add(2, 9, 5));
                this.leafs(worldIn, mainmutable.add(3, 9, 3));
                this.leafs(worldIn, mainmutable.add(3, 9, 5));
                this.leafs(worldIn, mainmutable.add(4, 9, 3));
                this.leafs(worldIn, mainmutable.add(4, 9, 4));
                this.leafs(worldIn, mainmutable.add(4, 9, 5));
                this.leafs(worldIn, mainmutable.add(1, 10, 3));
                this.leafs(worldIn, mainmutable.add(1, 10, 4));
                this.leafs(worldIn, mainmutable.add(1, 10, 5));
                this.leafs(worldIn, mainmutable.add(2, 10, 2));
                this.leafs(worldIn, mainmutable.add(2, 10, 6));
                this.leafs(worldIn, mainmutable.add(3, 10, 2));
                this.leafs(worldIn, mainmutable.add(3, 10, 6));
                this.leafs(worldIn, mainmutable.add(4, 10, 2));
                this.leafs(worldIn, mainmutable.add(4, 10, 6));
                this.leafs(worldIn, mainmutable.add(5, 10, 3));
                this.leafs(worldIn, mainmutable.add(5, 10, 4));
                this.leafs(worldIn, mainmutable.add(5, 10, 5));
                this.leafs(worldIn, mainmutable.add(-4, 11, -2));
                this.leafs(worldIn, mainmutable.add(-4, 11, -1));
                this.leafs(worldIn, mainmutable.add(-4, 11, 0));
                this.leafs(worldIn, mainmutable.add(-3, 11, -2));
                this.leafs(worldIn, mainmutable.add(-3, 11, 0));
                this.leafs(worldIn, mainmutable.add(-2, 11, -2));
                this.leafs(worldIn, mainmutable.add(-2, 11, -1));
                this.leafs(worldIn, mainmutable.add(-2, 11, 0));
                this.leafs(worldIn, mainmutable.add(-5, 12, -2));
                this.leafs(worldIn, mainmutable.add(-5, 12, -1));
                this.leafs(worldIn, mainmutable.add(-5, 12, 0));
                this.leafs(worldIn, mainmutable.add(-4, 12, -3));
                this.leafs(worldIn, mainmutable.add(-4, 12, 1));
                this.leafs(worldIn, mainmutable.add(-3, 12, -3));
                this.leafs(worldIn, mainmutable.add(-3, 12, 1));
                this.leafs(worldIn, mainmutable.add(-2, 12, -3));
                this.leafs(worldIn, mainmutable.add(-2, 12, 1));
                this.leafs(worldIn, mainmutable.add(-1, 12, -2));
                this.leafs(worldIn, mainmutable.add(-1, 12, -1));
                this.leafs(worldIn, mainmutable.add(-1, 12, 0));
                this.leafs(worldIn, mainmutable.add(2, 13, -4));
                this.leafs(worldIn, mainmutable.add(2, 13, -3));
                this.leafs(worldIn, mainmutable.add(2, 13, -2));
                this.leafs(worldIn, mainmutable.add(3, 13, -4));
                this.leafs(worldIn, mainmutable.add(3, 13, -2));
                this.leafs(worldIn, mainmutable.add(4, 13, -4));
                this.leafs(worldIn, mainmutable.add(4, 13, -3));
                this.leafs(worldIn, mainmutable.add(4, 13, -2));
                this.leafs(worldIn, mainmutable.add(1, 14, -4));
                this.leafs(worldIn, mainmutable.add(1, 14, -3));
                this.leafs(worldIn, mainmutable.add(1, 14, -2));
                this.leafs(worldIn, mainmutable.add(2, 14, -5));
                this.leafs(worldIn, mainmutable.add(2, 14, -1));
                this.leafs(worldIn, mainmutable.add(3, 14, -5));
                this.leafs(worldIn, mainmutable.add(3, 14, -1));
                this.leafs(worldIn, mainmutable.add(4, 14, -5));
                this.leafs(worldIn, mainmutable.add(4, 14, -1));
                this.leafs(worldIn, mainmutable.add(5, 14, -4));
                this.leafs(worldIn, mainmutable.add(5, 14, -3));
                this.leafs(worldIn, mainmutable.add(5, 14, -2));
                this.leafs(worldIn, mainmutable.add(-2, 17, -1));
                this.leafs(worldIn, mainmutable.add(-2, 17, 0));
                this.leafs(worldIn, mainmutable.add(-2, 17, 1));
                this.leafs(worldIn, mainmutable.add(-2, 17, 2));
                this.leafs(worldIn, mainmutable.add(-1, 17, -2));
                this.leafs(worldIn, mainmutable.add(-1, 17, -1));
                this.leafs(worldIn, mainmutable.add(-1, 17, 0));
                this.leafs(worldIn, mainmutable.add(-1, 17, 1));
                this.leafs(worldIn, mainmutable.add(-1, 17, 2));
                this.leafs(worldIn, mainmutable.add(0, 17, -2));
                this.leafs(worldIn, mainmutable.add(0, 17, -1));
                this.leafs(worldIn, mainmutable.add(0, 17, 1));
                this.leafs(worldIn, mainmutable.add(0, 17, 2));
                this.leafs(worldIn, mainmutable.add(1, 17, -2));
                this.leafs(worldIn, mainmutable.add(1, 17, -1));
                this.leafs(worldIn, mainmutable.add(1, 17, 0));
                this.leafs(worldIn, mainmutable.add(1, 17, 1));
                this.leafs(worldIn, mainmutable.add(1, 17, 2));
                this.leafs(worldIn, mainmutable.add(2, 17, -1));
                this.leafs(worldIn, mainmutable.add(2, 17, 0));
                this.leafs(worldIn, mainmutable.add(2, 17, 1));
                this.leafs(worldIn, mainmutable.add(-3, 18, -2));
                this.leafs(worldIn, mainmutable.add(-3, 18, -1));
                this.leafs(worldIn, mainmutable.add(-3, 18, 0));
                this.leafs(worldIn, mainmutable.add(-3, 18, 1));
                this.leafs(worldIn, mainmutable.add(-3, 18, 2));
                this.leafs(worldIn, mainmutable.add(-2, 18, -3));
                this.leafs(worldIn, mainmutable.add(-2, 18, -2));
                this.leafs(worldIn, mainmutable.add(-2, 18, 2));
                this.leafs(worldIn, mainmutable.add(-2, 18, 3));
                this.leafs(worldIn, mainmutable.add(-1, 18, -3));
                this.leafs(worldIn, mainmutable.add(-1, 18, 3));
                this.leafs(worldIn, mainmutable.add(0, 18, -3));
                this.leafs(worldIn, mainmutable.add(0, 18, 3));
                this.leafs(worldIn, mainmutable.add(1, 18, -3));
                this.leafs(worldIn, mainmutable.add(1, 18, 3));
                this.leafs(worldIn, mainmutable.add(2, 18, -3));
                this.leafs(worldIn, mainmutable.add(2, 18, -2));
                this.leafs(worldIn, mainmutable.add(2, 18, 2));
                this.leafs(worldIn, mainmutable.add(2, 18, 3));
                this.leafs(worldIn, mainmutable.add(3, 18, -2));
                this.leafs(worldIn, mainmutable.add(3, 18, -1));
                this.leafs(worldIn, mainmutable.add(3, 18, 0));
                this.leafs(worldIn, mainmutable.add(3, 18, 1));
                this.leafs(worldIn, mainmutable.add(3, 18, 2));
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