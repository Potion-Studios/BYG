package potionstudios.byg.common.world.feature.gen.overworld.mushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.config.BYGMushroomConfig;
import potionstudios.byg.common.world.feature.gen.overworld.mushrooms.util.BYGAbstractMushroomFeature;

import java.util.Random;

public class SythianFungusTree3 extends BYGAbstractMushroomFeature<BYGMushroomConfig> {

    public SythianFungusTree3(Codec<BYGMushroomConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(WorldGenLevel worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomConfig config) {
        BlockState STEM = config.getStemProvider().getState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getState(rand, pos);
        int randTreeHeight = 9 + rand.nextInt(5);
        BlockPos.MutableBlockPos mainmutable = new BlockPos.MutableBlockPos().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            if (!isDesiredGroundwDirtTag(config, worldIn, pos.below(), BYGBlocks.SYTHIAN_NYLIUM)) {
                return false;
            } else if (!this.isAnotherMushroomLikeThisNearby(worldIn, pos, randTreeHeight, 0, STEM.getBlock(), MUSHROOM.getBlock(), isMushroom)) {
                return false;
            } else if (!this.doesMushroomHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isMushroom)) {
                return false;
            } else {
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 0, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 1, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 2, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 3, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 4, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 5, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 6, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 7, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 7, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 7, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 8, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 8, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 9, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 1, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 1, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 1, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 1, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 1, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 1, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 1, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 1, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 3, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 3, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 3, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 3, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 3, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 3, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 3, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 3, 1));
                this.hangingSythianRoots(worldIn, mainmutable.set(pos).move(0, 3, 2));
                this.hangingSythianRoots(worldIn, mainmutable.set(pos).move(-1, 4, -2));
                this.hangingSythianRootsPlant(worldIn, mainmutable.set(pos).move(0, 4, 2));
                this.hangingSythianRoots(worldIn, mainmutable.set(pos).move(1, 4, 2));
                this.hangingSythianRootsPlant(worldIn, mainmutable.set(pos).move(-1, 5, -2));
                this.hangingSythianRoots(worldIn, mainmutable.set(pos).move(1, 5, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 5, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 5, 0));
                this.shroomLight(worldIn, mainmutable.set(pos).move(-2, 5, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 5, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 5, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 5, 1));
                this.hangingSythianRootsPlant(worldIn, mainmutable.set(pos).move(0, 5, 2));
                this.hangingSythianRootsPlant(worldIn, mainmutable.set(pos).move(1, 5, 2));
                this.hangingSythianRootsPlant(worldIn, mainmutable.set(pos).move(-1, 6, -2));
                this.hangingSythianRoots(worldIn, mainmutable.set(pos).move(0, 6, -2));
                this.hangingSythianRootsPlant(worldIn, mainmutable.set(pos).move(1, 6, -2));
                this.shroomLight(worldIn, mainmutable.set(pos).move(-1, 6, 1));
                this.shroomLight(worldIn, mainmutable.set(pos).move(0, 6, 1));
                this.shroomLight(worldIn, mainmutable.set(pos).move(-1, 6, 2));
                this.hangingSythianRootsPlant(worldIn, mainmutable.set(pos).move(0, 6, 2));
                this.hangingSythianRootsPlant(worldIn, mainmutable.set(pos).move(1, 6, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 7, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 7, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 7, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 7, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 7, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 7, 2));
                this.shroomLight(worldIn, mainmutable.set(pos).move(0, 8, -2));
                this.shroomLight(worldIn, mainmutable.set(pos).move(1, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 9, -1));
                this.shroomLight(worldIn, mainmutable.set(pos).move(2, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 9, 0));
                this.shroomLight(worldIn, mainmutable.set(pos).move(1, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 10, 1));
            }
        }
        return true;
    }

    private void hangingSythianRoots(WorldGenLevel reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlocks.HANGING_SYTHIAN_ROOTS.defaultBlockState());
        }
    }

    //Leaves Placement
    private void hangingSythianRootsPlant(WorldGenLevel reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlocks.HANGING_SYTHIAN_ROOTS_PLANT.defaultBlockState());
        }
    }

    //Leaves Placement
    private void shroomLight(WorldGenLevel reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, Blocks.SHROOMLIGHT.defaultBlockState());
        }
    }
}