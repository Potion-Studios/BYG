package potionstudios.byg.common.world.feature.gen.end.trees.bulbis;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.config.BYGMushroomConfig;
import potionstudios.byg.common.world.feature.gen.overworld.mushrooms.util.BYGAbstractMushroomFeature;

import java.util.Random;

public class BulbisBush1 extends BYGAbstractMushroomFeature<BYGMushroomConfig> {

    public BulbisBush1(Codec<BYGMushroomConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(WorldGenLevel worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomConfig config) {
        BlockState STEM = config.getStemProvider().getState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getState(rand, pos);
        int randTreeHeight = 8 + rand.nextInt(5);
        BlockPos.MutableBlockPos mainmutable = new BlockPos.MutableBlockPos().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            if (!isDesiredGroundwEndTags(config, worldIn, pos.below(), BYGBlocks.IVIS_PHYLIUM)) {
                return false;
            } else if (!this.isAnotherMushroomLikeThisNearby(worldIn, pos, randTreeHeight, 0, STEM.getBlock(), MUSHROOM.getBlock(), isMushroom)) {
                return false;
            } else if (!this.doesMushroomHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isMushroom)) {
                return false;
            } else {
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 0, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 0, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 0, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 0, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 0, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 0, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 0, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 0, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 0, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 1, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 1, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 1, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 1, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 1, -1));
                this.shroomlight(worldIn, mainmutable.set(pos).move(0, 1, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 1, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 1, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 1, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 1, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 1, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 1, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 2, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 2, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 2, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 2, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 2, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 2, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 2, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 2, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 2, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 3, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 0, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 0, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 0, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 0, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 0, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 0, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 0, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 0, -1));
            }
        }
        return true;
    }
    private void shroomlight(WorldGenLevel reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlocks.PURPLE_SHROOMLIGHT.defaultBlockState());
        }
    }
}