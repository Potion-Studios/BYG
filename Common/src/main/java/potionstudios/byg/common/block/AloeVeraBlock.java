package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.item.BYGItems;

import java.util.Random;

public class AloeVeraBlock extends CattailSproutBlock implements BonemealableBlock {

    public AloeVeraBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, @NotNull Random random) {
        int i = random.nextInt(5);
        if (i == 4) {
            if (serverLevel.getBlockState(blockPos.above()) == Blocks.AIR.defaultBlockState()) {
                growAloeVera(serverLevel, blockPos);
            }
        }
    }


    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return this.mayPlaceOn(worldIn.getBlockState(blockpos));
    }

    protected boolean mayPlaceOn(BlockState state) {
        return state.is(BlockTags.SAND);
    }


    public void growAloeVera(@NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos) {
        serverLevel.setBlock(blockPos, BYGBlocks.BLOOMING_ALOE_VERA.defaultBlockState().setValue(CattailPlantBlock.HALF, DoubleBlockHalf.LOWER), 3);
        serverLevel.setBlock(blockPos.above(), BYGBlocks.BLOOMING_ALOE_VERA.defaultBlockState().setValue(CattailPlantBlock.HALF, DoubleBlockHalf.UPPER), 3);
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState) {
        return new ItemStack(BYGItems.ALOE_VERA);
    }

    @Override
    public void performBonemeal(@NotNull ServerLevel serverLevel, @NotNull Random random, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        if (serverLevel.getBlockState(blockPos.above()).isAir() && canSurvive(blockState, serverLevel, blockPos)) {
            growAloeVera(serverLevel, blockPos);
        }
    }
}
