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

public class GreenMushroomHuge extends BYGAbstractMushroomFeature<BYGMushroomConfig> {

    public GreenMushroomHuge(Codec<BYGMushroomConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(WorldGenLevel worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomConfig config) {
        BlockState STEM = config.getStemProvider().getState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getState(rand, pos);
        int randTreeHeight = 6 + rand.nextInt(5);
        BlockPos.MutableBlockPos mainmutable = new BlockPos.MutableBlockPos().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            if (!isDesiredGroundwDirtTag(config, worldIn, pos.below(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherMushroomLikeThisNearby(worldIn, pos, randTreeHeight, 0, BYGBlocks.WHITE_MUSHROOM_STEM, BYGBlocks.GREEN_MUSHROOM_BLOCK, isMushroom)) {
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
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 3, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(2, 4, 2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(2, 5, 2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 6, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(2, 6, 2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 7, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 7, 3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 8, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 8, 3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 9, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 9, 3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 10, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 11, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 12, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(6, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(6, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 8, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(6, 8, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 8, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(6, 8, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 8, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 8, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(6, 8, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 8, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 8, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 8, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 9, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 9, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 9, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 9, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 9, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 9, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 10, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 11, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 11, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 11, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 11, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 11, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 11, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 11, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 11, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 11, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 12, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 12, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 12, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 12, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 12, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 12, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 12, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 12, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 12, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 12, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 12, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 12, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 12, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 12, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 12, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 12, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 13, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 13, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 13, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 13, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 13, 0));
            }
        }
        return true;
    }
}