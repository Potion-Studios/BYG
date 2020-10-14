package corgiaoc.byg.common.world.feature.overworld.mushrooms;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGMushroomFeatureConfig;
import corgiaoc.byg.common.world.feature.overworld.mushrooms.util.BYGAbstractMushroomFeature;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;

import java.util.Random;

public class SythianFungusTree3 extends BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> {

    public SythianFungusTree3(Codec<BYGMushroomFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(ISeedReader worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomFeatureConfig config) {
        BlockState STEM = config.getStemProvider().getBlockState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getBlockState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getBlockState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getBlockState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getBlockState(rand, pos);
        int randTreeHeight = 9 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), BYGBlocks.SYTHIAN_NYLIUM)) {
                return false;
            } else if (!this.isAnotherMushroomLikeThisNearby(worldIn, pos, randTreeHeight, 0, STEM.getBlock(), MUSHROOM.getBlock(), isMushroom)) {
                return false;
            } else if (!this.doesMushroomHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isMushroom)) {
                return false;
            } else {
                placeStem(STEM, worldIn, mainmutable.setPos(pos).move(0, 0, 0));
                placeStem(STEM, worldIn, mainmutable.setPos(pos).move(0, 1, 0));
                placeStem(STEM, worldIn, mainmutable.setPos(pos).move(0, 2, 0));
                placeStem(STEM, worldIn, mainmutable.setPos(pos).move(0, 3, 0));
                placeStem(STEM, worldIn, mainmutable.setPos(pos).move(0, 4, 0));
                placeStem(STEM, worldIn, mainmutable.setPos(pos).move(0, 5, 0));
                placeStem(STEM, worldIn, mainmutable.setPos(pos).move(0, 6, 0));
                placeStem(STEM, worldIn, mainmutable.setPos(pos).move(0, 7, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 7, -1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 7, 1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 8, -1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 8, 1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 9, -1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 1, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 1, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 1, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 1, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 1, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 1, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 1, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 1, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 3, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 3, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 3, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 3, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 3, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 3, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 3, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 3, 1));
                this.hangingSythianRoots(worldIn, mainmutable.setPos(pos).move(0, 3, 2));
                this.hangingSythianRoots(worldIn, mainmutable.setPos(pos).move(-1, 4, -2));
                this.hangingSythianRootsPlant(worldIn, mainmutable.setPos(pos).move(0, 4, 2));
                this.hangingSythianRoots(worldIn, mainmutable.setPos(pos).move(1, 4, 2));
                this.hangingSythianRootsPlant(worldIn, mainmutable.setPos(pos).move(-1, 5, -2));
                this.hangingSythianRoots(worldIn, mainmutable.setPos(pos).move(1, 5, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 5, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 5, 0));
                this.shroomLight(worldIn, mainmutable.setPos(pos).move(-2, 5, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 5, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 5, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 5, 1));
                this.hangingSythianRootsPlant(worldIn, mainmutable.setPos(pos).move(0, 5, 2));
                this.hangingSythianRootsPlant(worldIn, mainmutable.setPos(pos).move(1, 5, 2));
                this.hangingSythianRootsPlant(worldIn, mainmutable.setPos(pos).move(-1, 6, -2));
                this.hangingSythianRoots(worldIn, mainmutable.setPos(pos).move(0, 6, -2));
                this.hangingSythianRootsPlant(worldIn, mainmutable.setPos(pos).move(1, 6, -2));
                this.shroomLight(worldIn, mainmutable.setPos(pos).move(-1, 6, 1));
                this.shroomLight(worldIn, mainmutable.setPos(pos).move(0, 6, 1));
                this.shroomLight(worldIn, mainmutable.setPos(pos).move(-1, 6, 2));
                this.hangingSythianRootsPlant(worldIn, mainmutable.setPos(pos).move(0, 6, 2));
                this.hangingSythianRootsPlant(worldIn, mainmutable.setPos(pos).move(1, 6, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 7, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 7, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 7, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 7, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 7, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 7, 2));
                this.shroomLight(worldIn, mainmutable.setPos(pos).move(0, 8, -2));
                this.shroomLight(worldIn, mainmutable.setPos(pos).move(1, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 9, -1));
                this.shroomLight(worldIn, mainmutable.setPos(pos).move(2, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 9, 0));
                this.shroomLight(worldIn, mainmutable.setPos(pos).move(1, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 10, 1));
            }
        }
        return true;
    }

    private void hangingSythianRoots(ISeedReader reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlocks.HANGING_SYTHIAN_ROOTS.getDefaultState());
        }
    }

    //Leaves Placement
    private void hangingSythianRootsPlant(ISeedReader reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlocks.HANGING_SYTHIAN_ROOTS_PLANT.getDefaultState());
        }
    }

    //Leaves Placement
    private void shroomLight(ISeedReader reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, Blocks.SHROOMLIGHT.getDefaultState());
        }
    }
}