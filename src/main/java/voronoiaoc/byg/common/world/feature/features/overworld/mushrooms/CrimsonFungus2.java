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

public class CrimsonFungus2 extends BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> {

    public CrimsonFungus2(Codec<BYGMushroomFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(ISeedReader worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomFeatureConfig config) {
        BlockState STEM = config.getStemProvider().getBlockState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getBlockState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getBlockState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getBlockState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getBlockState(rand, pos);int randTreeHeight = 12 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            BlockPos blockpos = pos.down();
            if (!isDesiredGroundwDirtTag(worldIn, blockpos, BYGBlockList.OVERGROWN_CRIMSON_BLACKSTONE)) {
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
                this.vines(worldIn, mainmutable.add(0, 3, 2));
                this.vines(worldIn, mainmutable.add(-2, 4, -2));
                this.vines(worldIn, mainmutable.add(-2, 4, 0));
                this.vines(worldIn, mainmutable.add(-2, 4, 2));
                this.vines(worldIn, mainmutable.add(-1, 4, -2));
                this.vinesplant(worldIn, mainmutable.add(0, 4, 2));
                this.vines(worldIn, mainmutable.add(2, 4, -2));
                this.vines(worldIn, mainmutable.add(2, 4, 1));
                this.vinesplant(worldIn, mainmutable.add(-2, 5, -2));
                this.vinesplant(worldIn, mainmutable.add(-2, 5, 0));
                this.vines(worldIn, mainmutable.add(-2, 5, 1));
                this.vinesplant(worldIn, mainmutable.add(-2, 5, 2));
                this.vinesplant(worldIn, mainmutable.add(-1, 5, -2));
                this.vines(worldIn, mainmutable.add(-1, 5, 2));
                this.vines(worldIn, mainmutable.add(0, 5, -2));
                this.vinesplant(worldIn, mainmutable.add(0, 5, 2));
                this.vines(worldIn, mainmutable.add(1, 5, -2));
                this.vines(worldIn, mainmutable.add(1, 5, 2));
                this.vinesplant(worldIn, mainmutable.add(2, 5, -2));
                this.vines(worldIn, mainmutable.add(2, 5, 0));
                this.vinesplant(worldIn, mainmutable.add(2, 5, 1));
                this.vinesplant(worldIn, mainmutable.add(-2, 6, -2));
                this.vines(worldIn, mainmutable.add(-2, 6, -1));
                this.vinesplant(worldIn, mainmutable.add(-2, 6, 0));
                this.vinesplant(worldIn, mainmutable.add(-2, 6, 1));
                this.vinesplant(worldIn, mainmutable.add(-2, 6, 2));
                this.vinesplant(worldIn, mainmutable.add(-1, 6, -2));
                this.vinesplant(worldIn, mainmutable.add(-1, 6, 2));
                this.vinesplant(worldIn, mainmutable.add(0, 6, -2));
                this.vinesplant(worldIn, mainmutable.add(0, 6, 2));
                this.vinesplant(worldIn, mainmutable.add(1, 6, -2));
                this.vinesplant(worldIn, mainmutable.add(1, 6, 2));
                this.vinesplant(worldIn, mainmutable.add(2, 6, -2));
                this.vinesplant(worldIn, mainmutable.add(2, 6, 0));
                this.vinesplant(worldIn, mainmutable.add(2, 6, 1));
                this.shroomlight(worldIn, mainmutable.add(-4, 7, 1));
                this.shroomlight(worldIn, mainmutable.add(-4, 7, 2));
                this.leafs(worldIn, mainmutable.add(-3, 7, -2));
                this.leafs(worldIn, mainmutable.add(-3, 7, -1));
                this.leafs(worldIn, mainmutable.add(-3, 7, 0));
                this.leafs(worldIn, mainmutable.add(-3, 7, 1));
                this.leafs(worldIn, mainmutable.add(-3, 7, 2));
                this.leafs(worldIn, mainmutable.add(-2, 7, -3));
                this.vinesplant(worldIn, mainmutable.add(-2, 7, -2));
                this.vinesplant(worldIn, mainmutable.add(-2, 7, -1));
                this.vinesplant(worldIn, mainmutable.add(-2, 7, 0));
                this.vinesplant(worldIn, mainmutable.add(-2, 7, 1));
                this.vinesplant(worldIn, mainmutable.add(-2, 7, 2));
                this.leafs(worldIn, mainmutable.add(-2, 7, 3));
                this.shroomlight(worldIn, mainmutable.add(-1, 7, -4));
                this.leafs(worldIn, mainmutable.add(-1, 7, -3));
                this.vinesplant(worldIn, mainmutable.add(-1, 7, -2));
                this.vinesplant(worldIn, mainmutable.add(-1, 7, 2));
                this.leafs(worldIn, mainmutable.add(-1, 7, 3));
                this.shroomlight(worldIn, mainmutable.add(0, 7, -4));
                this.leafs(worldIn, mainmutable.add(0, 7, -3));
                this.vinesplant(worldIn, mainmutable.add(0, 7, -2));
                this.vinesplant(worldIn, mainmutable.add(0, 7, 2));
                this.leafs(worldIn, mainmutable.add(0, 7, 3));
                this.leafs(worldIn, mainmutable.add(1, 7, -3));
                this.vinesplant(worldIn, mainmutable.add(1, 7, -2));
                this.vinesplant(worldIn, mainmutable.add(1, 7, 2));
                this.leafs(worldIn, mainmutable.add(1, 7, 3));
                this.leafs(worldIn, mainmutable.add(2, 7, -3));
                this.vinesplant(worldIn, mainmutable.add(2, 7, -2));
                this.vinesplant(worldIn, mainmutable.add(2, 7, 0));
                this.vinesplant(worldIn, mainmutable.add(2, 7, 1));
                this.leafs(worldIn, mainmutable.add(2, 7, 3));
                this.leafs(worldIn, mainmutable.add(3, 7, -2));
                this.leafs(worldIn, mainmutable.add(3, 7, -1));
                this.leafs(worldIn, mainmutable.add(3, 7, 0));
                this.leafs(worldIn, mainmutable.add(3, 7, 1));
                this.leafs(worldIn, mainmutable.add(3, 7, 2));
                this.shroomlight(worldIn, mainmutable.add(-4, 8, 1));
                this.leafs(worldIn, mainmutable.add(-3, 8, -1));
                this.leafs(worldIn, mainmutable.add(-3, 8, 0));
                this.leafs(worldIn, mainmutable.add(-3, 8, 1));
                this.shroomlight(worldIn, mainmutable.add(-3, 8, 2));
                this.leafs(worldIn, mainmutable.add(-2, 8, -2));
                this.vinesplant(worldIn, mainmutable.add(-2, 8, -1));
                this.vinesplant(worldIn, mainmutable.add(-2, 8, 0));
                this.vinesplant(worldIn, mainmutable.add(-2, 8, 1));
                this.leafs(worldIn, mainmutable.add(-2, 8, 2));
                this.shroomlight(worldIn, mainmutable.add(-1, 8, -4));
                this.leafs(worldIn, mainmutable.add(-1, 8, -3));
                this.vinesplant(worldIn, mainmutable.add(-1, 8, -2));
                this.vinesplant(worldIn, mainmutable.add(-1, 8, 2));
                this.leafs(worldIn, mainmutable.add(-1, 8, 3));
                this.shroomlight(worldIn, mainmutable.add(0, 8, -4));
                this.leafs(worldIn, mainmutable.add(0, 8, -3));
                this.vinesplant(worldIn, mainmutable.add(0, 8, -2));
                this.vinesplant(worldIn, mainmutable.add(0, 8, 2));
                this.leafs(worldIn, mainmutable.add(0, 8, 3));
                this.shroomlight(worldIn, mainmutable.add(0, 8, 4));
                this.leafs(worldIn, mainmutable.add(1, 8, -3));
                this.vinesplant(worldIn, mainmutable.add(1, 8, -2));
                this.vinesplant(worldIn, mainmutable.add(1, 8, 2));
                this.leafs(worldIn, mainmutable.add(1, 8, 3));
                this.shroomlight(worldIn, mainmutable.add(1, 8, 4));
                this.leafs(worldIn, mainmutable.add(2, 8, -2));
                this.vinesplant(worldIn, mainmutable.add(2, 8, 0));
                this.vinesplant(worldIn, mainmutable.add(2, 8, 1));
                this.leafs(worldIn, mainmutable.add(2, 8, 2));
                this.leafs(worldIn, mainmutable.add(3, 8, -1));
                this.leafs(worldIn, mainmutable.add(3, 8, 0));
                this.leafs(worldIn, mainmutable.add(3, 8, 1));
                this.shroomlight(worldIn, mainmutable.add(4, 8, 0));
                this.shroomlight(worldIn, mainmutable.add(4, 8, 1));
                this.leafs(worldIn, mainmutable.add(-3, 9, -1));
                this.leafs(worldIn, mainmutable.add(-3, 9, 0));
                this.leafs(worldIn, mainmutable.add(-3, 9, 1));
                this.leafs(worldIn, mainmutable.add(-2, 9, -2));
                this.vinesplant(worldIn, mainmutable.add(-2, 9, -1));
                this.vinesplant(worldIn, mainmutable.add(-2, 9, 0));
                this.vinesplant(worldIn, mainmutable.add(-2, 9, 1));
                this.leafs(worldIn, mainmutable.add(-2, 9, 2));
                this.leafs(worldIn, mainmutable.add(-1, 9, -3));
                this.vinesplant(worldIn, mainmutable.add(-1, 9, -2));
                this.vinesplant(worldIn, mainmutable.add(-1, 9, 2));
                this.leafs(worldIn, mainmutable.add(-1, 9, 3));
                this.leafs(worldIn, mainmutable.add(0, 9, -3));
                this.vinesplant(worldIn, mainmutable.add(0, 9, -2));
                this.vinesplant(worldIn, mainmutable.add(0, 9, 2));
                this.leafs(worldIn, mainmutable.add(0, 9, 3));
                this.shroomlight(worldIn, mainmutable.add(0, 9, 4));
                this.leafs(worldIn, mainmutable.add(1, 9, -3));
                this.vinesplant(worldIn, mainmutable.add(1, 9, -2));
                this.vinesplant(worldIn, mainmutable.add(1, 9, 2));
                this.leafs(worldIn, mainmutable.add(1, 9, 3));
                this.shroomlight(worldIn, mainmutable.add(1, 9, 4));
                this.leafs(worldIn, mainmutable.add(2, 9, -2));
                this.vinesplant(worldIn, mainmutable.add(2, 9, 0));
                this.vinesplant(worldIn, mainmutable.add(2, 9, 1));
                this.leafs(worldIn, mainmutable.add(2, 9, 2));
                this.leafs(worldIn, mainmutable.add(3, 9, -1));
                this.leafs(worldIn, mainmutable.add(3, 9, 0));
                this.leafs(worldIn, mainmutable.add(3, 9, 1));
                this.shroomlight(worldIn, mainmutable.add(4, 9, 0));
                this.shroomlight(worldIn, mainmutable.add(4, 9, 1));
                this.shroomlight(worldIn, mainmutable.add(-4, 10, 0));
                this.shroomlight(worldIn, mainmutable.add(-3, 10, -1));
                this.leafs(worldIn, mainmutable.add(-3, 10, 0));
                this.leafs(worldIn, mainmutable.add(-2, 10, -2));
                this.leafs(worldIn, mainmutable.add(-2, 10, -1));
                this.leafs(worldIn, mainmutable.add(-2, 10, 0));
                this.leafs(worldIn, mainmutable.add(-2, 10, 1));
                this.leafs(worldIn, mainmutable.add(-2, 10, 2));
                this.leafs(worldIn, mainmutable.add(-1, 10, -2));
                this.leafs(worldIn, mainmutable.add(-1, 10, 2));
                this.leafs(worldIn, mainmutable.add(0, 10, -3));
                this.leafs(worldIn, mainmutable.add(0, 10, -2));
                this.leafs(worldIn, mainmutable.add(0, 10, 2));
                this.leafs(worldIn, mainmutable.add(0, 10, 3));
                this.leafs(worldIn, mainmutable.add(1, 10, -2));
                this.leafs(worldIn, mainmutable.add(1, 10, 2));
                this.leafs(worldIn, mainmutable.add(2, 10, -2));
                this.leafs(worldIn, mainmutable.add(2, 10, -1));
                this.leafs(worldIn, mainmutable.add(2, 10, 0));
                this.leafs(worldIn, mainmutable.add(2, 10, 1));
                this.leafs(worldIn, mainmutable.add(2, 10, 2));
                this.leafs(worldIn, mainmutable.add(3, 10, 0));
                this.shroomlight(worldIn, mainmutable.add(-3, 11, -1));
                this.leafs(worldIn, mainmutable.add(-3, 11, 0));
                this.leafs(worldIn, mainmutable.add(-2, 11, -1));
                this.leafs(worldIn, mainmutable.add(-2, 11, 0));
                this.leafs(worldIn, mainmutable.add(-2, 11, 1));
                this.leafs(worldIn, mainmutable.add(-1, 11, -2));
                this.shroomlight(worldIn, mainmutable.add(-1, 11, 1));
                this.leafs(worldIn, mainmutable.add(-1, 11, 2));
                this.shroomlight(worldIn, mainmutable.add(0, 11, -4));
                this.leafs(worldIn, mainmutable.add(0, 11, -3));
                this.leafs(worldIn, mainmutable.add(0, 11, -2));
                this.shroomlight(worldIn, mainmutable.add(0, 11, -1));
                this.leafs(worldIn, mainmutable.add(0, 11, 2));
                this.leafs(worldIn, mainmutable.add(0, 11, 3));
                this.shroomlight(worldIn, mainmutable.add(1, 11, -3));
                this.leafs(worldIn, mainmutable.add(1, 11, -2));
                this.shroomlight(worldIn, mainmutable.add(1, 11, 1));
                this.leafs(worldIn, mainmutable.add(1, 11, 2));
                this.leafs(worldIn, mainmutable.add(2, 11, -1));
                this.leafs(worldIn, mainmutable.add(2, 11, 0));
                this.leafs(worldIn, mainmutable.add(2, 11, 1));
                this.leafs(worldIn, mainmutable.add(3, 11, 0));
                this.leafs(worldIn, mainmutable.add(-2, 12, -1));
                this.leafs(worldIn, mainmutable.add(-2, 12, 0));
                this.leafs(worldIn, mainmutable.add(-2, 12, 1));
                this.leafs(worldIn, mainmutable.add(-1, 12, -2));
                this.shroomlight(worldIn, mainmutable.add(-1, 12, 0));
                this.shroomlight(worldIn, mainmutable.add(-1, 12, 1));
                this.leafs(worldIn, mainmutable.add(-1, 12, 2));
                this.shroomlight(worldIn, mainmutable.add(0, 12, -3));
                this.leafs(worldIn, mainmutable.add(0, 12, -2));
                this.shroomlight(worldIn, mainmutable.add(0, 12, -1));
                this.leafs(worldIn, mainmutable.add(0, 12, 2));
                this.shroomlight(worldIn, mainmutable.add(1, 12, -3));
                this.leafs(worldIn, mainmutable.add(1, 12, -2));
                this.shroomlight(worldIn, mainmutable.add(1, 12, -1));
                this.shroomlight(worldIn, mainmutable.add(1, 12, 0));
                this.shroomlight(worldIn, mainmutable.add(1, 12, 1));
                this.leafs(worldIn, mainmutable.add(1, 12, 2));
                this.leafs(worldIn, mainmutable.add(2, 12, -1));
                this.leafs(worldIn, mainmutable.add(2, 12, 0));
                this.leafs(worldIn, mainmutable.add(2, 12, 1));
                this.shroomlight(worldIn, mainmutable.add(3, 12, -1));
                this.shroomlight(worldIn, mainmutable.add(3, 12, 0));
                this.leafs(worldIn, mainmutable.add(-2, 13, 0));
                this.leafs(worldIn, mainmutable.add(-1, 13, -1));
                this.leafs(worldIn, mainmutable.add(-1, 13, 0));
                this.leafs(worldIn, mainmutable.add(-1, 13, 1));
                this.shroomlight(worldIn, mainmutable.add(-1, 13, 2));
                this.leafs(worldIn, mainmutable.add(0, 13, -2));
                this.leafs(worldIn, mainmutable.add(0, 13, -1));
                this.leafs(worldIn, mainmutable.add(0, 13, 0));
                this.leafs(worldIn, mainmutable.add(0, 13, 1));
                this.leafs(worldIn, mainmutable.add(0, 13, 2));
                this.shroomlight(worldIn, mainmutable.add(0, 13, 3));
                this.leafs(worldIn, mainmutable.add(1, 13, -1));
                this.leafs(worldIn, mainmutable.add(1, 13, 0));
                this.leafs(worldIn, mainmutable.add(1, 13, 1));
                this.shroomlight(worldIn, mainmutable.add(2, 13, -1));
                this.leafs(worldIn, mainmutable.add(2, 13, 0));
                this.shroomlight(worldIn, mainmutable.add(3, 13, 0));
                this.leafs(worldIn, mainmutable.add(-1, 14, -1));
                this.leafs(worldIn, mainmutable.add(-1, 14, 0));
                this.leafs(worldIn, mainmutable.add(-1, 14, 1));
                this.shroomlight(worldIn, mainmutable.add(-1, 14, 2));
                this.leafs(worldIn, mainmutable.add(0, 14, -1));
                this.leafs(worldIn, mainmutable.add(0, 14, 0));
                this.leafs(worldIn, mainmutable.add(0, 14, 1));
                this.shroomlight(worldIn, mainmutable.add(0, 14, 2));
                this.leafs(worldIn, mainmutable.add(1, 14, -1));
                this.leafs(worldIn, mainmutable.add(1, 14, 0));
                this.leafs(worldIn, mainmutable.add(1, 14, 1));
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, Blocks.CRIMSON_STEM.getDefaultState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, Blocks.CRIMSON_STEM.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, Blocks.NETHER_WART_BLOCK.getDefaultState(), boundingBox);
        }
    }

    //Leaves Placement
    private void vines(Set<BlockPos> blockPos, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(blockPos, reader, pos, Blocks.WEEPING_VINES.getDefaultState(), boundingBox);
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