package corgiaoc.byg.common.world.feature.features.overworld.giantflowers;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import corgiaoc.byg.common.world.feature.features.config.BYGGiantFlowerFeatureConfig;
import corgiaoc.byg.common.world.feature.features.overworld.giantflowers.util.BYGAbstractGiantFlowerFeature;

import java.util.Random;

public class IrisGiant extends BYGAbstractGiantFlowerFeature<BYGGiantFlowerFeatureConfig> {

    public IrisGiant(Codec<BYGGiantFlowerFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean placeFlower(ISeedReader worldIn, Random rand, BlockPos pos, boolean isFlower, BYGGiantFlowerFeatureConfig config) {
        BlockState STEM = config.getStemProvider().getBlockState(rand, pos);
        BlockState PETAL = config.getPetalProvider().getBlockState(rand, pos);
        BlockState PETAL2 = config.getPetal2Provider().getBlockState(rand, pos);
        BlockState PETAL3 = config.getPetal3Provider().getBlockState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getBlockState(rand, pos);

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherFlowerNearby(worldIn, pos, randTreeHeight, 0, isFlower)) {
                return false;
            } else if (!this.doesFlowerHaveSpaceToGrow(worldIn, pos, randTreeHeight, 13, 5, 5, isFlower)) {
                return false;
            } else {
                placeStem(STEM, worldIn, mainmutable.add(0, 0, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 1, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 2, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 3, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 4, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 5, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 6, 0));
                placeStemBranch(STEM, worldIn, mainmutable.add(0, 1, 1));
                placeStemBranch(STEM, worldIn, mainmutable.add(-1, 2, 0));
                placeStemBranch(STEM, worldIn, mainmutable.add(0, 2, 1));
                placeStemBranch(STEM, worldIn, mainmutable.add(0, 3, -1));
                placeStemBranch(STEM, worldIn, mainmutable.add(-1, 3, 0));
                placeStemBranch(STEM, worldIn, mainmutable.add(0, 3, 2));
                placeStemBranch(STEM, worldIn, mainmutable.add(0, 4, -2));
                placeStemBranch(STEM, worldIn, mainmutable.add(-2, 4, 0));
                placeStemBranch(STEM, worldIn, mainmutable.add(0, 4, 3));
                placePetal(PETAL, worldIn, mainmutable.add(0, 5, -1));
                placePetal(PETAL, worldIn, mainmutable.add(-1, 5, 0));
                placePetal(PETAL, worldIn, mainmutable.add(1, 5, 0));
                placePetal(PETAL, worldIn, mainmutable.add(0, 5, 1));
                placePetal(PETAL, worldIn, mainmutable.add(0, 6, -2));
                placePetal(PETAL, worldIn, mainmutable.add(-1, 6, -1));
                placePetal2(PETAL2, worldIn, mainmutable.add(0, 6, -1));
                placePetal(PETAL, worldIn, mainmutable.add(1, 6, -1));
                placePetal(PETAL, worldIn, mainmutable.add(-2, 6, 0));
                placePetal2(PETAL2, worldIn, mainmutable.add(-1, 6, 0));
                placePetal2(PETAL2, worldIn, mainmutable.add(1, 6, 0));
                placePetal(PETAL, worldIn, mainmutable.add(2, 6, 0));
                placePetal(PETAL, worldIn, mainmutable.add(-1, 6, 1));
                placePetal2(PETAL2, worldIn, mainmutable.add(0, 6, 1));
                placePetal(PETAL, worldIn, mainmutable.add(1, 6, 1));
                placePetal(PETAL, worldIn, mainmutable.add(0, 6, 2));
                placePetal2(PETAL2, worldIn, mainmutable.add(0, 7, -3));
                placePetal(PETAL, worldIn, mainmutable.add(-1, 7, -2));
                placePetal2(PETAL2, worldIn, mainmutable.add(0, 7, -2));
                placePetal(PETAL, worldIn, mainmutable.add(1, 7, -2));
                placePetal(PETAL, worldIn, mainmutable.add(-2, 7, -1));
                placePetal(PETAL, worldIn, mainmutable.add(-1, 7, -1));
                placePetal(PETAL, worldIn, mainmutable.add(1, 7, -1));
                placePetal(PETAL, worldIn, mainmutable.add(2, 7, -1));
                placePetal2(PETAL2, worldIn, mainmutable.add(-3, 7, 0));
                placePetal2(PETAL2, worldIn, mainmutable.add(-2, 7, 0));
                placePetal2(PETAL2, worldIn, mainmutable.add(2, 7, 0));
                placePetal2(PETAL2, worldIn, mainmutable.add(3, 7, 0));
                placePetal(PETAL, worldIn, mainmutable.add(-2, 7, 1));
                placePetal(PETAL, worldIn, mainmutable.add(-1, 7, 1));
                placePetal(PETAL, worldIn, mainmutable.add(1, 7, 1));
                placePetal(PETAL, worldIn, mainmutable.add(2, 7, 1));
                placePetal(PETAL, worldIn, mainmutable.add(-1, 7, 2));
                placePetal2(PETAL2, worldIn, mainmutable.add(0, 7, 2));
                placePetal(PETAL, worldIn, mainmutable.add(1, 7, 2));
                placePetal2(PETAL2, worldIn, mainmutable.add(0, 7, 3));
                placePollen(POLLEN, worldIn, mainmutable.add(0, 7, 0));
                placePollen(POLLEN, worldIn, mainmutable.add(1, 7, 0));
                placePetal(PETAL, worldIn, mainmutable.add(-1, 8, -3));
                placePetal2(PETAL2, worldIn, mainmutable.add(0, 8, -3));
                placePetal(PETAL, worldIn, mainmutable.add(1, 8, -3));
                placePetal(PETAL, worldIn, mainmutable.add(-3, 8, -1));
                placePetal(PETAL, worldIn, mainmutable.add(3, 8, -1));
                placePetal2(PETAL2, worldIn, mainmutable.add(-3, 8, 0));
                placePetal2(PETAL2, worldIn, mainmutable.add(3, 8, 0));
                placePetal(PETAL, worldIn, mainmutable.add(-3, 8, 1));
                placePetal(PETAL, worldIn, mainmutable.add(3, 8, 1));
                placePetal(PETAL, worldIn, mainmutable.add(-1, 8, 3));
                placePetal2(PETAL2, worldIn, mainmutable.add(0, 8, 3));
                placePetal(PETAL, worldIn, mainmutable.add(1, 8, 3));
                placePollen(POLLEN, worldIn, mainmutable.add(0, 8, 0));
                placePetal(PETAL, worldIn, mainmutable.add(-1, 9, -3));
                placePetal(PETAL, worldIn, mainmutable.add(1, 9, -3));
                placePetal(PETAL, worldIn, mainmutable.add(-3, 9, -1));
                placePetal(PETAL, worldIn, mainmutable.add(3, 9, -1));
                placePetal(PETAL, worldIn, mainmutable.add(-3, 9, 1));
                placePetal(PETAL, worldIn, mainmutable.add(3, 9, 1));
                placePetal(PETAL, worldIn, mainmutable.add(-1, 9, 3));
                placePetal(PETAL, worldIn, mainmutable.add(1, 9, 3));
            }
        }
        return true;
    }
}