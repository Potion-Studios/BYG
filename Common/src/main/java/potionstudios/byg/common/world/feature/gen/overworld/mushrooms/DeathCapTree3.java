package potionstudios.byg.common.world.feature.gen.overworld.mushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import potionstudios.byg.common.world.feature.config.BYGMushroomConfig;
import potionstudios.byg.common.world.feature.gen.overworld.mushrooms.util.BYGAbstractMushroomFeature;

import java.util.Random;

public class DeathCapTree3 extends BYGAbstractMushroomFeature<BYGMushroomConfig> {

    public DeathCapTree3(Codec<BYGMushroomConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(WorldGenLevel worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomConfig config) {
        BlockState STEM = config.getStemProvider().getState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getState(rand, pos);
        int randTreeHeight = 13 + rand.nextInt(5);
        BlockPos.MutableBlockPos mainmutable = new BlockPos.MutableBlockPos().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            if (!isDesiredGroundwDirtTag(config, worldIn, pos.below(), Blocks.GRASS_BLOCK)) {
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
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 8, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 9, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 10, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 11, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 12, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 13, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 14, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 15, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 16, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 17, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 4, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 5, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(2, 5, 2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(2, 6, 2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 6, 3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 7, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 7, 3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 7, 4));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-2, 8, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 8, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 8, 4));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-3, 9, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-2, 9, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 9, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(2, 9, -2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 9, 4));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-3, 10, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(2, 10, -2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 10, -3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-3, 11, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 11, -3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 12, -3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 13, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 9, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 9, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 9, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 10, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 10, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 10, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 10, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 12, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 12, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 12, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 12, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 12, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 12, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 12, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 12, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 12, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 12, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 12, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 12, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 13, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 13, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 13, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 13, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 13, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 13, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 13, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 13, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 14, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 14, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 14, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 14, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 14, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 14, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 14, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 14, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 14, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 14, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 14, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 14, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 17, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 17, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 17, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 17, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 17, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 17, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 17, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 17, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 17, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 17, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 17, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 17, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 17, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 17, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 17, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 17, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 17, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 17, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 17, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 17, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 17, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 18, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 18, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 18, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 18, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 18, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 18, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 18, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 18, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 18, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 18, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 18, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 18, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 18, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 18, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 18, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 18, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 18, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 18, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 18, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 18, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 18, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 18, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 18, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 18, 2));
            }
        }
        return true;
    }
}