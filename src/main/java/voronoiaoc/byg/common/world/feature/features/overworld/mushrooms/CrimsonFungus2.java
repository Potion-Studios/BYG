package voronoiaoc.byg.common.world.feature.features.overworld.mushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import voronoiaoc.byg.common.world.feature.config.BYGMushroomFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.util.BYGAbstractMushroomFeature;

import java.util.Random;

public class CrimsonFungus2 extends BYGAbstractMushroomFeature<BYGMushroomFeatureConfig> {

    public CrimsonFungus2(Codec<BYGMushroomFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(ISeedReader worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomFeatureConfig config) {
        BlockState STEM = config.getStemProvider().getBlockState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getBlockState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getBlockState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getBlockState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getBlockState(rand, pos);int randTreeHeight = 12 + rand.nextInt(5);
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
                placeStem(STEM, worldIn, mainmutable.add(0, 8, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 9, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 10, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 11, 0));
                placeStem(STEM, worldIn, mainmutable.add(0, 12, 0));
                this.vines(worldIn, mainmutable.add(0, 3, 2));
                this.vines(worldIn, mainmutable.add(-2, 4, -2));
                this.vines(worldIn, mainmutable.add(-2, 4, 0));
                this.vines(worldIn, mainmutable.add(-2, 4, 2));
                this.vines(worldIn, mainmutable.add(-1, 4, -2));
                this.vinesplant(worldIn, mainmutable.add(0, 4, 2));
                this.vines(worldIn, mainmutable.add(2, 4, -2));
                this.vines(worldIn, mainmutable.add(2, 4, 1));
                this.vinesplant(worldIn, mainmutable.add(-2, 5, -2));
                this.vinesplant(worldIn, mainmutable.add(-2, 5, 0));
                this.vines(worldIn, mainmutable.add(-2, 5, 1));
                this.vinesplant(worldIn, mainmutable.add(-2, 5, 2));
                this.vinesplant(worldIn, mainmutable.add(-1, 5, -2));
                this.vines(worldIn, mainmutable.add(-1, 5, 2));
                this.vines(worldIn, mainmutable.add(0, 5, -2));
                this.vinesplant(worldIn, mainmutable.add(0, 5, 2));
                this.vines(worldIn, mainmutable.add(1, 5, -2));
                this.vines(worldIn, mainmutable.add(1, 5, 2));
                this.vinesplant(worldIn, mainmutable.add(2, 5, -2));
                this.vines(worldIn, mainmutable.add(2, 5, 0));
                this.vinesplant(worldIn, mainmutable.add(2, 5, 1));
                this.vinesplant(worldIn, mainmutable.add(-2, 6, -2));
                this.vines(worldIn, mainmutable.add(-2, 6, -1));
                this.vinesplant(worldIn, mainmutable.add(-2, 6, 0));
                this.vinesplant(worldIn, mainmutable.add(-2, 6, 1));
                this.vinesplant(worldIn, mainmutable.add(-2, 6, 2));
                this.vinesplant(worldIn, mainmutable.add(-1, 6, -2));
                this.vinesplant(worldIn, mainmutable.add(-1, 6, 2));
                this.vinesplant(worldIn, mainmutable.add(0, 6, -2));
                this.vinesplant(worldIn, mainmutable.add(0, 6, 2));
                this.vinesplant(worldIn, mainmutable.add(1, 6, -2));
                this.vinesplant(worldIn, mainmutable.add(1, 6, 2));
                this.vinesplant(worldIn, mainmutable.add(2, 6, -2));
                this.vinesplant(worldIn, mainmutable.add(2, 6, 0));
                this.vinesplant(worldIn, mainmutable.add(2, 6, 1));
                this.shroomlight(worldIn, mainmutable.add(-4, 7, 1));
                this.shroomlight(worldIn, mainmutable.add(-4, 7, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 7, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 7, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 7, -3));
                this.vinesplant(worldIn, mainmutable.add(-2, 7, -2));
                this.vinesplant(worldIn, mainmutable.add(-2, 7, -1));
                this.vinesplant(worldIn, mainmutable.add(-2, 7, 0));
                this.vinesplant(worldIn, mainmutable.add(-2, 7, 1));
                this.vinesplant(worldIn, mainmutable.add(-2, 7, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 7, 3));
                this.shroomlight(worldIn, mainmutable.add(-1, 7, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 7, -3));
                this.vinesplant(worldIn, mainmutable.add(-1, 7, -2));
                this.vinesplant(worldIn, mainmutable.add(-1, 7, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 7, 3));
                this.shroomlight(worldIn, mainmutable.add(0, 7, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 7, -3));
                this.vinesplant(worldIn, mainmutable.add(0, 7, -2));
                this.vinesplant(worldIn, mainmutable.add(0, 7, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 7, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 7, -3));
                this.vinesplant(worldIn, mainmutable.add(1, 7, -2));
                this.vinesplant(worldIn, mainmutable.add(1, 7, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 7, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 7, -3));
                this.vinesplant(worldIn, mainmutable.add(2, 7, -2));
                this.vinesplant(worldIn, mainmutable.add(2, 7, 0));
                this.vinesplant(worldIn, mainmutable.add(2, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 7, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 7, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 7, 2));
                this.shroomlight(worldIn, mainmutable.add(-4, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 8, 1));
                this.shroomlight(worldIn, mainmutable.add(-3, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 8, -2));
                this.vinesplant(worldIn, mainmutable.add(-2, 8, -1));
                this.vinesplant(worldIn, mainmutable.add(-2, 8, 0));
                this.vinesplant(worldIn, mainmutable.add(-2, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 8, 2));
                this.shroomlight(worldIn, mainmutable.add(-1, 8, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 8, -3));
                this.vinesplant(worldIn, mainmutable.add(-1, 8, -2));
                this.vinesplant(worldIn, mainmutable.add(-1, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 8, 3));
                this.shroomlight(worldIn, mainmutable.add(0, 8, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 8, -3));
                this.vinesplant(worldIn, mainmutable.add(0, 8, -2));
                this.vinesplant(worldIn, mainmutable.add(0, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 8, 3));
                this.shroomlight(worldIn, mainmutable.add(0, 8, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 8, -3));
                this.vinesplant(worldIn, mainmutable.add(1, 8, -2));
                this.vinesplant(worldIn, mainmutable.add(1, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 8, 3));
                this.shroomlight(worldIn, mainmutable.add(1, 8, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 8, -2));
                this.vinesplant(worldIn, mainmutable.add(2, 8, 0));
                this.vinesplant(worldIn, mainmutable.add(2, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 8, 1));
                this.shroomlight(worldIn, mainmutable.add(4, 8, 0));
                this.shroomlight(worldIn, mainmutable.add(4, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 9, -2));
                this.vinesplant(worldIn, mainmutable.add(-2, 9, -1));
                this.vinesplant(worldIn, mainmutable.add(-2, 9, 0));
                this.vinesplant(worldIn, mainmutable.add(-2, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 9, -3));
                this.vinesplant(worldIn, mainmutable.add(-1, 9, -2));
                this.vinesplant(worldIn, mainmutable.add(-1, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 9, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 9, -3));
                this.vinesplant(worldIn, mainmutable.add(0, 9, -2));
                this.vinesplant(worldIn, mainmutable.add(0, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 9, 3));
                this.shroomlight(worldIn, mainmutable.add(0, 9, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 9, -3));
                this.vinesplant(worldIn, mainmutable.add(1, 9, -2));
                this.vinesplant(worldIn, mainmutable.add(1, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 9, 3));
                this.shroomlight(worldIn, mainmutable.add(1, 9, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 9, -2));
                this.vinesplant(worldIn, mainmutable.add(2, 9, 0));
                this.vinesplant(worldIn, mainmutable.add(2, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 9, 1));
                this.shroomlight(worldIn, mainmutable.add(4, 9, 0));
                this.shroomlight(worldIn, mainmutable.add(4, 9, 1));
                this.shroomlight(worldIn, mainmutable.add(-4, 10, 0));
                this.shroomlight(worldIn, mainmutable.add(-3, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 10, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 10, 0));
                this.shroomlight(worldIn, mainmutable.add(-3, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-3, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 11, -2));
                this.shroomlight(worldIn, mainmutable.add(-1, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 11, 2));
                this.shroomlight(worldIn, mainmutable.add(0, 11, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 11, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 11, -2));
                this.shroomlight(worldIn, mainmutable.add(0, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 11, 3));
                this.shroomlight(worldIn, mainmutable.add(1, 11, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 11, -2));
                this.shroomlight(worldIn, mainmutable.add(1, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(3, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 12, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 12, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 12, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 12, -2));
                this.shroomlight(worldIn, mainmutable.add(-1, 12, 0));
                this.shroomlight(worldIn, mainmutable.add(-1, 12, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 12, 2));
                this.shroomlight(worldIn, mainmutable.add(0, 12, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 12, -2));
                this.shroomlight(worldIn, mainmutable.add(0, 12, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 12, 2));
                this.shroomlight(worldIn, mainmutable.add(1, 12, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 12, -2));
                this.shroomlight(worldIn, mainmutable.add(1, 12, -1));
                this.shroomlight(worldIn, mainmutable.add(1, 12, 0));
                this.shroomlight(worldIn, mainmutable.add(1, 12, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 12, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 12, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 12, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 12, 1));
                this.shroomlight(worldIn, mainmutable.add(3, 12, -1));
                this.shroomlight(worldIn, mainmutable.add(3, 12, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-2, 13, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 13, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 13, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 13, 1));
                this.shroomlight(worldIn, mainmutable.add(-1, 13, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 13, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 13, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 13, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 13, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 13, 2));
                this.shroomlight(worldIn, mainmutable.add(0, 13, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 13, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 13, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 13, 1));
                this.shroomlight(worldIn, mainmutable.add(2, 13, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(2, 13, 0));
                this.shroomlight(worldIn, mainmutable.add(3, 13, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 14, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 14, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(-1, 14, 1));
                this.shroomlight(worldIn, mainmutable.add(-1, 14, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 14, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 14, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(0, 14, 1));
                this.shroomlight(worldIn, mainmutable.add(0, 14, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 14, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 14, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.add(1, 14, 1));
            }
        }
        return true;
    }

    //Leaves Placement
    private void vines(ISeedReader reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState( reader, pos, Blocks.WEEPING_VINES.getDefaultState());
        }
    }

    //Leaves Placement
    private void vinesplant(ISeedReader reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, Blocks.WEEPING_VINES_PLANT.getDefaultState());
        }
    }

    //Leaves Placement
    private void shroomlight(ISeedReader reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, Blocks.SHROOMLIGHT.getDefaultState());
        }
    }
}