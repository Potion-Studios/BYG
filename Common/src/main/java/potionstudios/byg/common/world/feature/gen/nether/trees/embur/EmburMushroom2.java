package potionstudios.byg.common.world.feature.gen.nether.trees.embur;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.end.impariusgrove.TreeBranchBlock;
import potionstudios.byg.common.world.feature.config.BYGMushroomConfig;
import potionstudios.byg.common.world.feature.gen.overworld.mushrooms.util.BYGAbstractMushroomFeature;

import java.util.Random;

public class EmburMushroom2 extends BYGAbstractMushroomFeature<BYGMushroomConfig> {

    public EmburMushroom2(Codec<BYGMushroomConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(WorldGenLevel worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomConfig config) {
        BlockState STEM = config.getStemProvider().getState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getState(rand, pos);
        int randTreeHeight = 4 + rand.nextInt(5);
        BlockPos.MutableBlockPos mainmutable = new BlockPos.MutableBlockPos().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            if (!isDesiredGroundwDirtTag(config, worldIn, pos.below(), BYGBlocks.EMBUR_NYLIUM)) {
                return false;
            } else if (!this.isAnotherMushroomLikeThisNearby(worldIn, pos, randTreeHeight, 0, STEM.getBlock(), MUSHROOM.getBlock(), isMushroom)) {
                return false;
            } else if (!this.doesMushroomHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isMushroom)) {
                return false;
            } else {
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 0, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 1, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 2, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 3, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 3, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 3, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 3, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 4, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 4, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(2, 4, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 5, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 5, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(2, 5, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 6, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 7, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 8, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 9, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 4, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 4, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 4, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 4, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 5, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 5, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 5, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 5, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 5, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 5, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 5, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 5, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 5, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 6, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 6, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 6, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 6, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 6, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 6, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 6, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 6, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 6, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 9, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 10, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 10, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 10, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 10, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 11, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 11, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 11, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 12, 1));
                this.embur_gel_branch(worldIn, mainmutable.set(pos).move(0, 1, 1), Direction.SOUTH);
                this.embur_gel_branch(worldIn, mainmutable.set(pos).move(1, 2, 0), Direction.EAST);
                this.embur_gel_branch(worldIn, mainmutable.set(pos).move(-2, 3, 0), Direction.WEST);
                this.embur_gel_branch(worldIn, mainmutable.set(pos).move(0, 3, 1), Direction.SOUTH);
                this.embur_gel_branch(worldIn, mainmutable.set(pos).move(1, 3, -1), Direction.NORTH);
                this.embur_gel_branch(worldIn, mainmutable.set(pos).move(2, 3, 1), Direction.EAST);
                this.embur_gel_branch(worldIn, mainmutable.set(pos).move(-1, 4, -1), Direction.NORTH);
                this.embur_gel_branch(worldIn, mainmutable.set(pos).move(0, 4, 0), Direction.EAST);
                this.embur_gel_branch(worldIn, mainmutable.set(pos).move(1, 4, 0), Direction.NORTH);
                this.embur_gel_branch(worldIn, mainmutable.set(pos).move(1, 4, 2), Direction.SOUTH);
                this.pollen_block(worldIn, mainmutable.set(pos).move(2, 5, 0));
                this.pollen_block(worldIn, mainmutable.set(pos).move(3, 5, 1));
                this.pollen_block(worldIn, mainmutable.set(pos).move(3, 5, 2));
                this.pollen_block(worldIn, mainmutable.set(pos).move(-1, 9, 2));
                this.pollen_block(worldIn, mainmutable.set(pos).move(-2, 10, 1));
                this.pollen_block(worldIn, mainmutable.set(pos).move(-1, 10, 2));
                this.pollen_block(worldIn, mainmutable.set(pos).move(0, 10, 1));
                this.pollen_block(worldIn, mainmutable.set(pos).move(0, 10, 2));
            }
        }
        return true;
    }

    private void pollen_block(WorldGenLevel reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlocks.POLLEN_BLOCK.defaultBlockState());
        }
    }

    private void embur_gel_branch(WorldGenLevel reader, BlockPos pos, Direction direction) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlocks.EMBUR_GEL_BRANCH.defaultBlockState().setValue(TreeBranchBlock.FACING, direction));
        }
    }
}