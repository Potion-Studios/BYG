package voronoiaoc.byg.common.world.feature.features.overworld.mushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import voronoiaoc.byg.common.world.feature.config.BYGMushroomFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.util.BYGAbstractMushroomFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class BlueGlowshroomHuge extends BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> {

    public BlueGlowshroomHuge(Codec<BYGMushroomFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(ISeedReader worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomFeatureConfig config) {
        BlockState STEM = config.getStemProvider().getBlockState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getBlockState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getBlockState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getBlockState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getBlockState(rand, pos);BlockState STEM = config.getStemProvider().getBlockState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getBlockState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getBlockState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getBlockState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getBlockState(rand, pos);

        int randTreeHeight = 5 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            BlockPos blockpos = pos.down();
            if (!isDesiredGroundwDirtTag(worldIn, blockpos, Blocks.GRASS_BLOCK)) {
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
                this.leafs(worldIn, mainmutable.add(-2, 5, -3));
                this.leafs(worldIn, mainmutable.add(-1, 5, -3));
                this.leafs(worldIn, mainmutable.add(1, 5, -3));
                this.leafs(worldIn, mainmutable.add(2, 5, -3));
                this.leafs(worldIn, mainmutable.add(-3, 5, -2));
                this.leafs(worldIn, mainmutable.add(-2, 5, -2));
                this.leafs(worldIn, mainmutable.add(2, 5, -2));
                this.leafs(worldIn, mainmutable.add(3, 5, -2));
                this.leafs(worldIn, mainmutable.add(-3, 5, -1));
                this.leafs(worldIn, mainmutable.add(3, 5, -1));
                this.leafs(worldIn, mainmutable.add(-3, 5, 1));
                this.leafs(worldIn, mainmutable.add(3, 5, 1));
                this.leafs(worldIn, mainmutable.add(-3, 5, 2));
                this.leafs(worldIn, mainmutable.add(-2, 5, 2));
                this.leafs(worldIn, mainmutable.add(2, 5, 2));
                this.leafs(worldIn, mainmutable.add(3, 5, 2));
                this.leafs(worldIn, mainmutable.add(-2, 5, 3));
                this.leafs(worldIn, mainmutable.add(-1, 5, 3));
                this.leafs(worldIn, mainmutable.add(1, 5, 3));
                this.leafs(worldIn, mainmutable.add(2, 5, 3));
                this.leafs(worldIn, mainmutable.add(0, 6, -3));
                this.leafs(worldIn, mainmutable.add(-1, 6, -2));
                this.leafs(worldIn, mainmutable.add(0, 6, -2));
                this.leafs(worldIn, mainmutable.add(1, 6, -2));
                this.leafs(worldIn, mainmutable.add(-2, 6, -1));
                this.leafs(worldIn, mainmutable.add(-1, 6, -1));
                this.leafs(worldIn, mainmutable.add(0, 6, -1));
                this.leafs(worldIn, mainmutable.add(1, 6, -1));
                this.leafs(worldIn, mainmutable.add(2, 6, -1));
                this.leafs(worldIn, mainmutable.add(-3, 6, 0));
                this.leafs(worldIn, mainmutable.add(-2, 6, 0));
                this.leafs(worldIn, mainmutable.add(-1, 6, 0));
                this.leafs(worldIn, mainmutable.add(0, 6, 0));
                this.leafs(worldIn, mainmutable.add(1, 6, 0));
                this.leafs(worldIn, mainmutable.add(2, 6, 0));
                this.leafs(worldIn, mainmutable.add(-2, 6, 1));
                this.leafs(worldIn, mainmutable.add(-1, 6, 1));
                this.leafs(worldIn, mainmutable.add(0, 6, 1));
                this.leafs(worldIn, mainmutable.add(1, 6, 1));
                this.leafs(worldIn, mainmutable.add(2, 6, 1));
                this.leafs(worldIn, mainmutable.add(-1, 6, 2));
                this.leafs(worldIn, mainmutable.add(0, 6, 2));
                this.leafs(worldIn, mainmutable.add(1, 6, 2));
                this.leafs(worldIn, mainmutable.add(0, 6, 3));
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(ISeedReader reader, BlockPos pos) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlockList.YELLOW_GLOWSHROOM_STEM.getDefaultState());
        }
    }

    //Log Placement
    private void treeBranch(ISeedReader reader, BlockPos pos) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlockList.YELLOW_GLOWSHROOM_STEM.getDefaultState());
        }
    }

    //Leaves Placement
    private void leafs(ISeedReader reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlockList.BLUE_GLOWSHROOM_BLOCK.getDefaultState());
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