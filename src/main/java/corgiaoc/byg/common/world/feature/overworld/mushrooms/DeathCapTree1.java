package corgiaoc.byg.common.world.feature.overworld.mushrooms;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGMushroomConfig;
import corgiaoc.byg.common.world.feature.overworld.mushrooms.util.BYGAbstractMushroomFeature;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;

import java.util.Random;

public class DeathCapTree1 extends BYGAbstractMushroomFeature<BYGMushroomConfig> {

    public DeathCapTree1(Codec<BYGMushroomConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(ISeedReader worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomConfig config) {
        BlockState STEM = config.getStemProvider().getState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getState(rand, pos);
        int randTreeHeight = 5 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().set(pos);

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
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 5, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 5, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 5, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 5, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 5, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 5, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 5, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 5, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 5, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 5, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 5, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 5, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 5, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 5, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 5, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 6, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 6, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 6, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 6, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 6, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 6, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 6, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 6, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 6, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 6, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 6, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 6, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 6, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 6, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 6, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 6, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 6, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 6, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 6, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 6, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 6, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 6, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 6, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 6, 2));
            }
        }
        return true;
    }
}