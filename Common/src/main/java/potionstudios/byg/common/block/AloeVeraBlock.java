package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.item.BYGItems;

import java.util.Optional;
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
    public boolean canPlaceLiquid(BlockGetter $$0, BlockPos $$1, BlockState $$2, Fluid $$3) {
        return false;
    }

    @Override
    public boolean placeLiquid(LevelAccessor $$0, BlockPos $$1, BlockState $$2, FluidState $$3) {
        return false;
    }

    protected boolean mayPlaceOn(@NotNull BlockState state) {
        return state.is(BlockTags.SAND) || state.is(BlockTags.DIRT);
    }

    public void growAloeVera(@NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos) {
        serverLevel.setBlock(blockPos.above(), BYGBlocks.BLOOMING_ALOE_VERA.defaultBlockState().setValue(CattailPlantBlock.HALF, DoubleBlockHalf.UPPER), 3);

    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState) {
        return new ItemStack(BYGItems.CATTAIL_SPROUT);
    }

    @Override
    public void performBonemeal(@NotNull ServerLevel serverLevel, @NotNull Random random, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        growAloeVera(serverLevel, blockPos);
    }
}
