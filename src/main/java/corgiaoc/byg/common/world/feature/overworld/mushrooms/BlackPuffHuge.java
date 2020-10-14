package corgiaoc.byg.common.world.feature.overworld.mushrooms;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGMushroomFeatureConfig;
import corgiaoc.byg.common.world.feature.overworld.mushrooms.util.BYGAbstractMushroomFeature;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;

import java.util.Random;

public class BlackPuffHuge extends BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> {

    public BlackPuffHuge(Codec<BYGMushroomFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(ISeedReader worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomFeatureConfig config) {
        BlockState STEM = config.getStemProvider().getBlockState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getBlockState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getBlockState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getBlockState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getBlockState(rand, pos);
        int randTreeHeight = 2 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherMushroomLikeThisNearby(worldIn, pos, randTreeHeight, 0, STEM.getBlock(), MUSHROOM.getBlock(), isMushroom)) {
                return false;
            } else if (!this.doesMushroomHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isMushroom)) {
                return false;
            } else {
                placeStem(STEM, worldIn, mainmutable.setPos(pos).move(0, 0, 0));
                placeStem(STEM, worldIn, mainmutable.setPos(pos).move(0, 1, 0));
                placeStem(STEM, worldIn, mainmutable.setPos(pos).move(0, 2, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 2, -1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-1, 2, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(1, 2, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 2, 1));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 3, -2));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(-2, 3, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(2, 3, 0));
                placeStemBranch(STEM, worldIn, mainmutable.setPos(pos).move(0, 3, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 3, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 3, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 3, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 3, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 3, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 3, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 3, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 3, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 3, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 4, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 4, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 4, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 4, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 4, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 4, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 4, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 4, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 4, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 5, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 5, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 5, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 5, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 6, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 6, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 6, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 6, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 6, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(-1, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(1, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.setPos(pos).move(0, 9, 0));
            }
        }
        return true;
    }
}