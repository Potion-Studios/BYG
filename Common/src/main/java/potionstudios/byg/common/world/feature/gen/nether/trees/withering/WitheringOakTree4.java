package potionstudios.byg.common.world.feature.gen.nether.trees.withering;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.config.BYGMushroomConfig;
import potionstudios.byg.common.world.feature.gen.overworld.mushrooms.util.BYGAbstractMushroomFeature;

import java.util.Random;

public class WitheringOakTree4 extends BYGAbstractMushroomFeature<BYGMushroomConfig> {

    public WitheringOakTree4(Codec<BYGMushroomConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(WorldGenLevel worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomConfig config) {
        BlockState STEM = config.getStemProvider().getState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getState(rand, pos);
        int randTreeHeight = 14 + rand.nextInt(5);
        BlockPos.MutableBlockPos mainmutable = new BlockPos.MutableBlockPos().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            if (!isDesiredGroundwDirtTag(config, worldIn, pos.below(), BYGBlocks.OVERGROWN_NETHERRACK)) {
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
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 0, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 0, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 0, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 0, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 0, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 1, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 1, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 1, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 2, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 2, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 3, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 5, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 6, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 7, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 8, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 9, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 10, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 4, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 4, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 5, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 5, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 5, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 5, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 5, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 6, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 6, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 6, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 6, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 6, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 6, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 6, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 6, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 7, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 7, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 12, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 12, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 12, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 13, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 13, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 13, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 13, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 14, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 14, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 14, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 14, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 15, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 15, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 16, 0));
            }
        }
        return true;
    }
}