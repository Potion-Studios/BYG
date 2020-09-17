package voronoiaoc.byg.common.world.feature.features.overworld.mushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import voronoiaoc.byg.common.world.feature.config.BYGMushroomFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.util.BYGAbstractMushroomFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class GreenMushroomHuge extends BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> {

    public GreenMushroomHuge(Codec<BYGMushroomFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(ISeedReader worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomFeatureConfig config) {
        BlockState STEM = config.getStemProvider().getBlockState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getBlockState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getBlockState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getBlockState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getBlockState(rand, pos);int randTreeHeight = 6 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherMushroomLikeThisNearby(worldIn, pos, randTreeHeight, 0, BYGBlockList.WHITE_MUSHROOM_STEM, BYGBlockList.GREEN_MUSHROOM_BLOCK, isMushroom)) {
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
                placeStemBranch(STEM,worldIn, mainmutable.add(1, 3, 1));
                placeStemBranch(STEM,worldIn, mainmutable.add(2, 4, 2));
                placeStemBranch(STEM,worldIn, mainmutable.add(2, 5, 2));
                placeStemBranch(STEM,worldIn, mainmutable.add(-1, 6, -1));
                placeStemBranch(STEM,worldIn, mainmutable.add(2, 6, 2));
                placeStemBranch(STEM,worldIn, mainmutable.add(-1, 7, -1));
                placeStemBranch(STEM,worldIn, mainmutable.add(3, 7, 3));
                placeStemBranch(STEM,worldIn, mainmutable.add(-1, 8, -1));
                placeStemBranch(STEM,worldIn, mainmutable.add(3, 8, 3));
                placeStemBranch(STEM,worldIn, mainmutable.add(-1, 9, -1));
                placeStemBranch(STEM,worldIn, mainmutable.add(3, 9, 3));
                placeStemBranch(STEM,worldIn, mainmutable.add(-1, 10, -1));
                placeStemBranch(STEM,worldIn, mainmutable.add(-1, 11, -1));
                placeStemBranch(STEM,worldIn, mainmutable.add(-1, 12, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(4, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(5, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(5, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(6, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(6, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 8, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(6, 8, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 8, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(6, 8, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 8, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 8, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(5, 8, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(6, 8, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 8, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 8, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 8, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(4, 8, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(5, 8, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(4, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(4, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(5, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 9, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(5, 9, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 9, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 9, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(4, 9, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(5, 9, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 9, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 9, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(4, 9, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(4, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 10, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 11, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 11, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 11, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 11, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 11, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-4, 11, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 11, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 11, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 11, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-4, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-4, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-4, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-4, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 12, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 12, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 12, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 12, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 12, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 12, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 12, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 12, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 12, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 12, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 12, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 12, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 12, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 12, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 12, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 12, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 13, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 13, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 13, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 13, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 13, 0));
            }
        }
        return true;
    }
}