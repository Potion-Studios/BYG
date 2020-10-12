package corgiaoc.byg.common.world.feature.overworld.giantflowers;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGGiantFlowerFeatureConfig;
import corgiaoc.byg.common.world.feature.overworld.giantflowers.util.BYGAbstractGiantFlowerFeature;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.IWorldGenerationBaseReader;

import java.util.Random;

public class AngelicaGiant extends BYGAbstractGiantFlowerFeature<BYGGiantFlowerFeatureConfig> {

    public AngelicaGiant(Codec<BYGGiantFlowerFeatureConfig> configIn) {
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
                placeStem(STEM, worldIn, mainmutable.add(0, 7, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 8, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 9, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 10, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 11, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 12, 0));
                placeStemBranch(STEM, worldIn, mainmutable.add(0, 0, -1));
                placeStemBranch(STEM, worldIn, mainmutable.add(-1, 0, 0));
                placeStemBranch(STEM, worldIn, mainmutable.add(1, 0, 0));
                placeStemBranch(STEM, worldIn, mainmutable.add(0, 0, 1));
                placeStemBranch(STEM, worldIn, mainmutable.add(0, 1, -1));
                placeStemBranch(STEM, worldIn, mainmutable.add(-1, 1, 0));
                placeStemBranch(STEM, worldIn, mainmutable.add(1, 1, 0));
                placeStemBranch(STEM, worldIn, mainmutable.add(0, 2, -1));
                placeStemBranch(STEM, worldIn, mainmutable.add(-2, 3, 1));
                placeStemBranch(STEM, worldIn, mainmutable.add(-1, 3, 1));
                placeStemBranch(STEM, worldIn, mainmutable.add(1, 4, -1));
                placeStemBranch(STEM, worldIn, mainmutable.add(2, 4, -1));
                placeStemBranch(STEM, worldIn, mainmutable.add(-3, 4, 2));
                placeStemBranch(STEM, worldIn, mainmutable.add(3, 5, -2));
                placeStemBranch(STEM, worldIn, mainmutable.add(-1, 6, -1));
                placeStemBranch(STEM, worldIn, mainmutable.add(0, 6, 1));
                placeStemBranch(STEM, worldIn, mainmutable.add(-1, 7, -1));
                placeStemBranch(STEM, worldIn, mainmutable.add(0, 7, 2));
                placeStemBranch(STEM, worldIn, mainmutable.add(-1, 8, -2));
                placeStemBranch(STEM, worldIn, mainmutable.add(0, 8, 2));
                placePetal(PETAL, worldIn, mainmutable.add(-1, 7, -2));
                placePetal(PETAL, worldIn, mainmutable.add(-2, 7, -1));
                placePetal(PETAL, worldIn, mainmutable.add(-2, 8, -3));
                placePetal(PETAL, worldIn, mainmutable.add(-1, 8, -3));
                placePetal(PETAL, worldIn, mainmutable.add(0, 8, -3));
                placePetal(PETAL, worldIn, mainmutable.add(-2, 8, -2));
                placePetal(PETAL, worldIn, mainmutable.add(0, 8, -2));
                placePetal(PETAL, worldIn, mainmutable.add(-2, 8, -1));
                placePetal(PETAL, worldIn, mainmutable.add(-1, 8, -1));
                placePetal(PETAL, worldIn, mainmutable.add(-1, 9, -3));
                placePetal(PETAL, worldIn, mainmutable.add(-2, 9, -2));
                placePetal(PETAL, worldIn, mainmutable.add(-1, 9, -2));
                placePetal(PETAL, worldIn, mainmutable.add(0, 9, 1));
                placePetal(PETAL, worldIn, mainmutable.add(-1, 9, 2));
                placePetal(PETAL, worldIn, mainmutable.add(0, 9, 2));
                placePetal(PETAL, worldIn, mainmutable.add(1, 9, 2));
                placePetal(PETAL, worldIn, mainmutable.add(-1, 9, 3));
                placePetal(PETAL, worldIn, mainmutable.add(0, 9, 3));
                placePetal(PETAL, worldIn, mainmutable.add(-1, 10, -2));
                placePetal(PETAL, worldIn, mainmutable.add(0, 10, -1));
                placePetal(PETAL, worldIn, mainmutable.add(0, 10, 1));
                placePetal(PETAL, worldIn, mainmutable.add(0, 10, 2));
                placePetal(PETAL, worldIn, mainmutable.add(0, 11, -2));
                placePetal(PETAL, worldIn, mainmutable.add(0, 11, -1));
                placePetal(PETAL, worldIn, mainmutable.add(-1, 11, 0));
                placePetal(PETAL, worldIn, mainmutable.add(1, 11, 0));
                placePetal(PETAL, worldIn, mainmutable.add(0, 11, 2));
                placePollen(POLLEN, worldIn, mainmutable.add(-1, 11, 1));
                placePollen(POLLEN, worldIn, mainmutable.add(0, 11, 1));
                placePetal(PETAL, worldIn, mainmutable.add(0, 12, -2));
                placePetal(PETAL, worldIn, mainmutable.add(-1, 12, 0));
                placePetal(PETAL, worldIn, mainmutable.add(1, 12, 0));
                placePetal(PETAL, worldIn, mainmutable.add(0, 12, 1));
                placePetal(PETAL, worldIn, mainmutable.add(0, 12, 2));
                placePollen(POLLEN, worldIn, mainmutable.add(0, 12, -1));
                placePetal(PETAL, worldIn, mainmutable.add(0, 13, -1));
                placePetal(PETAL, worldIn, mainmutable.add(-1, 13, 0));
                placePetal(PETAL, worldIn, mainmutable.add(1, 13, 0));
                placePetal(PETAL, worldIn, mainmutable.add(0, 13, 1));
                placePollen(POLLEN, worldIn, mainmutable.add(0, 13, 0));
                placePetal(PETAL, worldIn, mainmutable.add(0, 14, -1));
                placePetal(PETAL, worldIn, mainmutable.add(0, 14, 0));
                placePetal(PETAL, worldIn, mainmutable.add(0, 14, 1));
            }
        }
        return true;
    }


    private boolean doesTreeFit(IWorldGenerationBaseReader reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.Mutable pos = new BlockPos.Mutable();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 0;

            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                    if (!canStemPlaceHere(reader, pos.setPos(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}