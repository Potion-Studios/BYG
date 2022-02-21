package potionstudios.byg.common.world.feature.gen.overworld.giantflowers;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import potionstudios.byg.common.world.feature.config.GiantFlowerConfig;
import potionstudios.byg.common.world.feature.gen.overworld.giantflowers.util.BYGAbstractGiantFlowerFeature;

import java.util.Random;

public class AngelicaGiant extends BYGAbstractGiantFlowerFeature<GiantFlowerConfig> {

    public AngelicaGiant(Codec<GiantFlowerConfig> configIn) {
        super(configIn);
    }

    protected boolean placeFlower(WorldGenLevel worldIn, Random rand, BlockPos pos, boolean isFlower, GiantFlowerConfig config) {
        BlockState STEM = config.getStemProvider().getState(rand, pos);
        BlockState PETAL = config.getPetalProvider().getState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getState(rand, pos);

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.MutableBlockPos mainmutable = new BlockPos.MutableBlockPos().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            if (!isDesiredGroundwDirtTag(worldIn, pos.below(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherFlowerNearby(worldIn, pos, randTreeHeight, 0, isFlower)) {
                return false;
            } else if (!this.doesFlowerHaveSpaceToGrow(worldIn, pos, randTreeHeight, 13, 5, 5, isFlower)) {
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
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 0, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 0, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 0, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 0, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 1, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 1, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 1, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 2, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-2, 3, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 3, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 4, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(2, 4, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-3, 4, 2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 5, -2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 6, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 6, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 7, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 7, 2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 8, -2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 8, 2));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(-1, 7, -2));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(-2, 7, -1));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(-2, 8, -3));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(-1, 8, -3));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(0, 8, -3));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(-2, 8, -2));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(0, 8, -2));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(-2, 8, -1));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(-1, 8, -1));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(-1, 9, -3));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(-2, 9, -2));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(-1, 9, -2));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(0, 9, 1));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(-1, 9, 2));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(0, 9, 2));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(1, 9, 2));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(-1, 9, 3));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(0, 9, 3));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(-1, 10, -2));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(0, 10, -1));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(0, 10, 1));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(0, 10, 2));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(0, 11, -2));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(0, 11, -1));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(-1, 11, 0));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(1, 11, 0));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(0, 11, 2));
                placePollen(POLLEN, worldIn, mainmutable.set(pos).move(-1, 11, 1));
                placePollen(POLLEN, worldIn, mainmutable.set(pos).move(0, 11, 1));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(0, 12, -2));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(-1, 12, 0));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(1, 12, 0));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(0, 12, 1));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(0, 12, 2));
                placePollen(POLLEN, worldIn, mainmutable.set(pos).move(0, 12, -1));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(0, 13, -1));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(-1, 13, 0));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(1, 13, 0));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(0, 13, 1));
                placePollen(POLLEN, worldIn, mainmutable.set(pos).move(0, 13, 0));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(0, 14, -1));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(0, 14, 0));
                placePetal(PETAL, worldIn, mainmutable.set(pos).move(0, 14, 1));
            }
        }
        return true;
    }
}