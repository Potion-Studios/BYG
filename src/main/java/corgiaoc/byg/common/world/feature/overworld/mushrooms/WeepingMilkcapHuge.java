package corgiaoc.byg.common.world.feature.overworld.mushrooms;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGMushroomFeatureConfig;
import corgiaoc.byg.common.world.feature.overworld.mushrooms.util.BYGAbstractMushroomFeature;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;

import java.util.Random;

public class WeepingMilkcapHuge extends BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> {

    public WeepingMilkcapHuge(Codec<BYGMushroomFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(ISeedReader worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomFeatureConfig config) {
        BlockState STEM = config.getStemProvider().getBlockState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getBlockState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getBlockState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getBlockState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getBlockState(rand, pos);
        int randTreeHeight = 7 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), Blocks.GRASS_BLOCK)) {
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
                placeStem(STEM, worldIn, mainmutable.add(0, 5, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 6, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 4, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 4, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 4, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 4, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 5, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 5, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 5, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 5, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 5, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 5, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 5, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-4, 5, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(4, 5, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 5, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 5, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 5, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 5, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 5, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 5, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 5, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 6, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 6, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 6, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 6, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 6, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 6, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 6, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 6, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 6, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 6, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 6, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 6, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 6, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 6, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 6, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 6, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 8, 0));
            }
        }
        return true;
    }
}