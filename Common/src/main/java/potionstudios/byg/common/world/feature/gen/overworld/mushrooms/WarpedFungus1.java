package potionstudios.byg.common.world.feature.gen.overworld.mushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.config.BYGMushroomConfig;
import potionstudios.byg.common.world.feature.gen.overworld.mushrooms.util.BYGAbstractMushroomFeature;

public class WarpedFungus1 extends BYGAbstractMushroomFeature<BYGMushroomConfig> {

    public WarpedFungus1(Codec<BYGMushroomConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(WorldGenLevel worldIn, RandomSource rand, BlockPos pos, boolean isMushroom, BYGMushroomConfig config) {
        BlockState STEM = config.getStemProvider().getState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getState(rand, pos);
        int randTreeHeight = 10 + rand.nextInt(5);
        BlockPos.MutableBlockPos mainmutable = new BlockPos.MutableBlockPos().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            if (!isDesiredGroundwDirtTag(config, worldIn, pos.below(), BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE.get())) {
                return false;
            } else if (!this.isAnotherMushroomLikeThisNearby(worldIn, pos, randTreeHeight, 0, STEM.getBlock(), MUSHROOM.getBlock(), isMushroom)) {
                return false;
            } else if (!this.doesMushroomHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isMushroom)) {
                return false;
            } else {
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 0, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 0, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 0, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 0, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 1, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 1, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 1, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 1, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 2, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 2, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 2, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 2, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 3, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 3, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 3, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 3, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 4, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 4, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 4, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 4, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 5, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 5, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 5, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 5, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 6, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 6, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 6, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 6, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 7, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 7, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 5, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 6, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 6, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 6, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 6, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 6, 1));
                this.shroomLight(worldIn, mainmutable.set(pos).move(-6, 7, 1));
                this.shroomLight(worldIn, mainmutable.set(pos).move(-6, 7, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 7, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 7, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 7, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 7, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 7, 4));
                this.shroomLight(worldIn, mainmutable.set(pos).move(-3, 7, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 7, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 7, 4));
                this.shroomLight(worldIn, mainmutable.set(pos).move(-2, 7, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 7, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 7, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 7, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 7, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 7, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 7, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 7, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 7, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 7, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 7, 5));
                this.shroomLight(worldIn, mainmutable.set(pos).move(1, 7, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 7, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 7, 4));
                this.shroomLight(worldIn, mainmutable.set(pos).move(2, 7, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 7, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 7, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 7, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 7, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 7, 2));
                this.shroomLight(worldIn, mainmutable.set(pos).move(5, 7, -1));
                this.shroomLight(worldIn, mainmutable.set(pos).move(5, 7, 0));
                this.shroomLight(worldIn, mainmutable.set(pos).move(-6, 8, 1));
                this.shroomLight(worldIn, mainmutable.set(pos).move(-6, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 8, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 8, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 8, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 8, 4));
                this.shroomLight(worldIn, mainmutable.set(pos).move(-3, 8, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 8, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 8, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 8, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 8, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 8, 5));
                this.shroomLight(worldIn, mainmutable.set(pos).move(-2, 8, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 8, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 8, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 8, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 8, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 8, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 8, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 8, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 8, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 8, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 8, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 8, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 8, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 8, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 8, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 8, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, 5));
                this.shroomLight(worldIn, mainmutable.set(pos).move(1, 8, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, 5));
                this.shroomLight(worldIn, mainmutable.set(pos).move(2, 8, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 8, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 8, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 8, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 8, 3));
                this.shroomLight(worldIn, mainmutable.set(pos).move(5, 8, -1));
                this.shroomLight(worldIn, mainmutable.set(pos).move(5, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 9, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 9, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 9, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 9, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 9, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 9, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 9, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 9, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 9, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 9, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 9, 5));
                this.shroomLight(worldIn, mainmutable.set(pos).move(-2, 9, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 9, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 9, 5));
                this.shroomLight(worldIn, mainmutable.set(pos).move(-1, 9, 6));
                this.shroomLight(worldIn, mainmutable.set(pos).move(0, 9, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 9, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 9, 5));
                this.shroomLight(worldIn, mainmutable.set(pos).move(1, 9, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 9, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 9, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 9, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 9, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 9, 4));
                this.shroomLight(worldIn, mainmutable.set(pos).move(-2, 10, 5));
                this.shroomLight(worldIn, mainmutable.set(pos).move(-1, 10, 6));
                this.shroomLight(worldIn, mainmutable.set(pos).move(0, 10, -4));
                this.shroomLight(worldIn, mainmutable.set(pos).move(1, 10, -5));
            }
        }
        return true;
    }

    private void shroomLight(WorldGenLevel reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, Blocks.SHROOMLIGHT.defaultBlockState());
        }
    }
}