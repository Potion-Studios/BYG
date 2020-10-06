package corgiaoc.byg.common.world.feature.features.overworld.giantflowers;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import corgiaoc.byg.common.world.feature.featureconfig.BYGGiantFlowerFeatureConfig;
import corgiaoc.byg.common.world.feature.features.overworld.giantflowers.util.BYGAbstractGiantFlowerFeature;

import java.util.Random;

public class DandelionGiant extends BYGAbstractGiantFlowerFeature<BYGGiantFlowerFeatureConfig> {

    public DandelionGiant(Codec<BYGGiantFlowerFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean placeFlower(ISeedReader worldIn, Random rand, BlockPos pos, boolean isFlower, BYGGiantFlowerFeatureConfig config) {
        BlockState STEM = config.getStemProvider().getBlockState(rand, pos);
        BlockState PETAL = config.getPetalProvider().getBlockState(rand, pos);
        BlockState PETAL2 = config.getPetal2Provider().getBlockState(rand, pos);
        BlockState PETAL3 = config.getPetal3Provider().getBlockState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getBlockState(rand, pos);

        int randTreeHeight = 23 + rand.nextInt(5);
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
                placeStem(STEM, worldIn, mainmutable.add(0, 5, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 6, 0));
                placeStemBranch(STEM, worldIn, mainmutable.add(-1, 0, 0));
                placeStemBranch(STEM, worldIn, mainmutable.add(0, 0, 1));
                placeStemBranch(STEM, worldIn, mainmutable.add(-1, 1, 0));
                placeStemBranch(STEM, worldIn, mainmutable.add(0, 3, -1));
                placeStemBranch(STEM, worldIn, mainmutable.add(0, 4, -1));
                placeStemBranch(STEM, worldIn, mainmutable.add(-1, 6, 1));
                placeStemBranch(STEM, worldIn, mainmutable.add(0, 6, 1));
                placeStemBranch(STEM, worldIn, mainmutable.add(-1, 7, 1));
                placePetal2(PETAL2, worldIn, mainmutable.add(-1, 8, -1));
                placePetal2(PETAL2, worldIn, mainmutable.add(-2, 8, 0));
                placePetal2(PETAL2, worldIn, mainmutable.add(-1, 8, 0));
                placePetal2(PETAL2, worldIn, mainmutable.add(0, 8, 0));
                placePetal2(PETAL2, worldIn, mainmutable.add(-3, 8, 1));
                placePetal2(PETAL2, worldIn, mainmutable.add(-2, 8, 1));
                placePetal2(PETAL2, worldIn, mainmutable.add(0, 8, 1));
                placePetal2(PETAL2, worldIn, mainmutable.add(1, 8, 1));
                placePetal2(PETAL2, worldIn, mainmutable.add(-2, 8, 2));
                placePetal2(PETAL2, worldIn, mainmutable.add(-1, 8, 2));
                placePetal2(PETAL2, worldIn, mainmutable.add(0, 8, 2));
                placePetal2(PETAL2, worldIn, mainmutable.add(-1, 8, 3));
                placePollen(POLLEN, worldIn, mainmutable.add(-1, 8, 1));
                placePetal2(PETAL2, worldIn, mainmutable.add(-2, 9, -1));
                placePetal2(PETAL2, worldIn, mainmutable.add(-1, 9, -1));
                placePetal2(PETAL2, worldIn, mainmutable.add(0, 9, -1));
                placePetal2(PETAL2, worldIn, mainmutable.add(-3, 9, 0));
                placePetal2(PETAL2, worldIn, mainmutable.add(-2, 9, 0));
                placePetal2(PETAL2, worldIn, mainmutable.add(0, 9, 0));
                placePetal2(PETAL2, worldIn, mainmutable.add(1, 9, 0));
                placePetal2(PETAL2, worldIn, mainmutable.add(-3, 9, 1));
                placePetal(PETAL, worldIn, mainmutable.add(-1, 9, 1));
                placePetal2(PETAL2, worldIn, mainmutable.add(1, 9, 1));
                placePetal2(PETAL2, worldIn, mainmutable.add(-3, 9, 2));
                placePetal2(PETAL2, worldIn, mainmutable.add(-2, 9, 2));
                placePetal2(PETAL2, worldIn, mainmutable.add(0, 9, 2));
                placePetal2(PETAL2, worldIn, mainmutable.add(1, 9, 2));
                placePetal2(PETAL2, worldIn, mainmutable.add(-2, 9, 3));
                placePetal2(PETAL2, worldIn, mainmutable.add(-1, 9, 3));
                placePetal2(PETAL2, worldIn, mainmutable.add(0, 9, 3));
                placePollen(POLLEN, worldIn, mainmutable.add(-1, 9, 0));
                placePollen(POLLEN, worldIn, mainmutable.add(-2, 9, 1));
                placePollen(POLLEN, worldIn, mainmutable.add(0, 9, 1));
                placePollen(POLLEN, worldIn, mainmutable.add(-1, 9, 2));
                placePetal2(PETAL2, worldIn, mainmutable.add(-2, 10, -2));
                placePetal2(PETAL2, worldIn, mainmutable.add(-1, 10, -2));
                placePetal2(PETAL2, worldIn, mainmutable.add(0, 10, -2));
                placePetal2(PETAL2, worldIn, mainmutable.add(-1, 10, -1));
                placePetal2(PETAL2, worldIn, mainmutable.add(-4, 10, 0));
                placePetal2(PETAL2, worldIn, mainmutable.add(2, 10, 0));
                placePetal2(PETAL2, worldIn, mainmutable.add(-4, 10, 1));
                placePetal2(PETAL2, worldIn, mainmutable.add(-3, 10, 1));
                placePetal2(PETAL2, worldIn, mainmutable.add(1, 10, 1));
                placePetal2(PETAL2, worldIn, mainmutable.add(2, 10, 1));
                placePetal2(PETAL2, worldIn, mainmutable.add(-4, 10, 2));
                placePetal2(PETAL2, worldIn, mainmutable.add(2, 10, 2));
                placePetal2(PETAL2, worldIn, mainmutable.add(-1, 10, 3));
                placePetal2(PETAL2, worldIn, mainmutable.add(-2, 10, 4));
                placePetal2(PETAL2, worldIn, mainmutable.add(-1, 10, 4));
                placePetal2(PETAL2, worldIn, mainmutable.add(0, 10, 4));
            }
        }
        return true;
    }
}