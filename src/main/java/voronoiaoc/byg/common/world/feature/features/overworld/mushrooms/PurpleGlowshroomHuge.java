package voronoiaoc.byg.common.world.feature.features.overworld.mushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import voronoiaoc.byg.common.world.feature.config.BYGMushroomFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.util.BYGAbstractMushroomFeature;

import java.util.Random;

public class PurpleGlowshroomHuge extends BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> {

    public PurpleGlowshroomHuge(Codec<BYGMushroomFeatureConfig> configIn) {
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
                placeStemBranch(STEM, worldIn, mainmutable.add(1, 4, -1));
                placeStemBranch(STEM, worldIn, mainmutable.add(-1, 4, 1));
                placeStemBranch(STEM, worldIn, mainmutable.add(2, 5, -2));
                placeStemBranch(STEM, worldIn, mainmutable.add(1, 5, -1));
                placeStemBranch(STEM, worldIn, mainmutable.add(-1, 5, 1));
                placeStemBranch(STEM, worldIn, mainmutable.add(2, 6, -2));
                placeStemBranch(STEM, worldIn, mainmutable.add(-1, 6, 1));
                placeStemBranch(STEM, worldIn, mainmutable.add(-2, 6, 2));
                placeStemBranch(STEM, worldIn, mainmutable.add(2, 7, -2));
                placeStemBranch(STEM, worldIn, mainmutable.add(-2, 7, 2));
                placeStemBranch(STEM, worldIn, mainmutable.add(-2, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 7, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 7, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 7, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 7, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 7, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 8, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 8, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 8, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 8, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 9, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 9, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 11, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 12, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 12, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 13, 2));
            }
        }
        return true;
    }
}