package corgiaoc.byg.common.world.feature.features.overworld.mushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.IWorldGenerationReader;
import corgiaoc.byg.common.world.feature.features.config.BYGMushroomFeatureConfig;
import corgiaoc.byg.common.world.feature.features.overworld.mushrooms.util.BYGAbstractMushroomFeature;
import corgiaoc.byg.core.byglists.BYGBlocks;

import java.util.Random;

public class EmburMushroom2 extends BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> {

    public EmburMushroom2(Codec<BYGMushroomFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(ISeedReader worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomFeatureConfig config) {
        BlockState STEM = config.getStemProvider().getBlockState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getBlockState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getBlockState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getBlockState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getBlockState(rand, pos);
        int randTreeHeight = 4 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), BYGBlocks.EMBUR_NYLIUM)) {
                return false;
            } else if (!this.isAnotherMushroomLikeThisNearby(worldIn, pos, randTreeHeight, 0, STEM.getBlock(), MUSHROOM.getBlock(), isMushroom)) {
                return false;
            } else if (!this.doesMushroomHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isMushroom)) {
                return false;
            } else {
                placeStem(STEM, worldIn, mainmutable.add(0, 0, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 1, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 2, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 3, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 4, 0));
                placeStemBranch(STEM, worldIn, mainmutable.add(0, 3, -1));
                placeStemBranch(STEM, worldIn, mainmutable.add(0, 4, -1));
                placeStemBranch(STEM, worldIn, mainmutable.add(0, 5, -1));
                placeStemBranch(STEM, worldIn, mainmutable.add(0, 6, -1));
                placeStemBranch(STEM, worldIn, mainmutable.add(1, 6, -1));
                placeStemBranch(STEM, worldIn, mainmutable.add(3, 6, -1));
                placeStemBranch(STEM, worldIn, mainmutable.add(-1, 6, 0));
                placeStemBranch(STEM, worldIn, mainmutable.add(1, 7, -1));
                placeStemBranch(STEM, worldIn, mainmutable.add(2, 7, -1));
                placeStemBranch(STEM, worldIn, mainmutable.add(4, 7, -1));
                placeStemBranch(STEM, worldIn, mainmutable.add(-1, 7, 0));
                placeStemBranch(STEM, worldIn, mainmutable.add(5, 7, 0));
                placeStemBranch(STEM, worldIn, mainmutable.add(-2, 7, 1));
                placeStemBranch(STEM, worldIn, mainmutable.add(2, 8, -1));
                placeStemBranch(STEM, worldIn, mainmutable.add(5, 8, 0));
                placeStemBranch(STEM, worldIn, mainmutable.add(-2, 8, 1));
                placeStemBranch(STEM, worldIn, mainmutable.add(2, 9, -1));
                placeStemBranch(STEM, worldIn, mainmutable.add(5, 9, 0));
                placeStemBranch(STEM, worldIn, mainmutable.add(-2, 9, 1));
                placeStemBranch(STEM, worldIn, mainmutable.add(-4, 9, 3));
                placeStemBranch(STEM, worldIn, mainmutable.add(5, 10, 0));
                placeStemBranch(STEM, worldIn, mainmutable.add(-2, 10, 1));
                placeStemBranch(STEM, worldIn, mainmutable.add(-4, 10, 3));
                placeStemBranch(STEM, worldIn, mainmutable.add(5, 11, 0));
                placeStemBranch(STEM, worldIn, mainmutable.add(-2, 11, 1));
                placeStemBranch(STEM, worldIn, mainmutable.add(-3, 11, 2));
                placeStemBranch(STEM, worldIn, mainmutable.add(-4, 11, 3));
                placeStemBranch(STEM, worldIn, mainmutable.add(5, 12, 0));
                placeStemBranch(STEM, worldIn, mainmutable.add(-3, 12, 2));
                placeStemBranch(STEM, worldIn, mainmutable.add(-3, 13, 2));
                placeStemBranch(STEM, worldIn, mainmutable.add(-3, 14, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 3, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 3, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 3, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 3, -2));
                this.shroomLight(worldIn, mainmutable.add(0, 3, -2));
                this.shroomLight(worldIn, mainmutable.add(1, 3, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 3, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 3, -1));
                this.shroomLight(worldIn, mainmutable.add(-1, 3, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 3, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 3, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 3, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 3, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 3, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 3, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 4, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 4, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 4, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 4, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 4, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 4, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 4, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 5, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 5, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 8, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 8, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 8, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 8, -2));
                this.shroomLight(worldIn, mainmutable.add(1, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(4, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 8, -1));
                this.shroomLight(worldIn, mainmutable.add(3, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(4, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 8, 0));
                this.shroomLight(worldIn, mainmutable.add(1, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(4, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-5, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-4, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-6, 8, 2));
                this.shroomLight(worldIn, mainmutable.add(-3, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-6, 8, 3));
                this.shroomLight(worldIn, mainmutable.add(-3, 8, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 8, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-6, 8, 4));
                this.shroomLight(worldIn, mainmutable.add(-5, 8, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 8, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-5, 8, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-4, 8, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 8, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-5, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-4, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-5, 9, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 9, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-5, 9, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-4, 9, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 9, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-4, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-5, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-4, 10, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(4, 12, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(5, 12, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(6, 12, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 12, -1));
                this.shroomLight(worldIn, mainmutable.add(5, 12, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(7, 12, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 12, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(7, 12, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 12, 1));
                this.shroomLight(worldIn, mainmutable.add(5, 12, 1));
                this.shroomLight(worldIn, mainmutable.add(6, 12, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(7, 12, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(4, 12, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(5, 12, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(6, 12, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(4, 13, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(5, 13, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(6, 13, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(4, 13, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(5, 13, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(6, 13, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(4, 13, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(5, 13, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(6, 13, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(5, 14, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-4, 14, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 14, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 14, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(4, 14, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(5, 14, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(6, 14, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-5, 14, 1));
                this.shroomLight(worldIn, mainmutable.add(-2, 14, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 14, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(5, 14, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-5, 14, 2));
                this.shroomLight(worldIn, mainmutable.add(-2, 14, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 14, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-5, 14, 3));
                this.shroomLight(worldIn, mainmutable.add(-4, 14, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 14, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-4, 14, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 14, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 14, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-4, 15, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 15, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 15, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-4, 15, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 15, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 15, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-4, 15, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 15, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 15, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 16, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-4, 16, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 16, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 16, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 16, 3));
            }
        }
        return true;
    }

    //Leaves Placement
    private void shroomLight(IWorldGenerationReader reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, Blocks.SHROOMLIGHT.getDefaultState());
        }
    }
}