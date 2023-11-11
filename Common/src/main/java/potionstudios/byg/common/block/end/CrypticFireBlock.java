package potionstudios.byg.common.block.end;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.block.BYGBlocks;

public class CrypticFireBlock extends BaseFireBlock {

    public CrypticFireBlock(Properties properties) {
        super(properties, 3.5F);
    }

    public @NotNull BlockState updateShape(@NotNull BlockState stateIn, @NotNull Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor worldIn, @NotNull BlockPos currentPos, @NotNull BlockPos facingPos) {
        return this.canSurvive(stateIn, worldIn, currentPos) ? this.defaultBlockState() : Blocks.AIR.defaultBlockState();
    }

    public boolean canSurvive(@NotNull BlockState state, LevelReader worldIn, BlockPos pos) {
        return shouldLightCrypticFire(worldIn.getBlockState(pos.below()).getBlock());
    }

    public static boolean shouldLightCrypticFire(Block block) {
        return block == BYGBlocks.CRYPTIC_STONE.get() || block == BYGBlocks.CRYPTIC_MAGMA_BLOCK.get();
    }

    protected boolean canBurn(@NotNull BlockState state) {
        return true;
    }

    public boolean isSignalSource(@NotNull BlockState state) {
        return true;
    }

    public int getSignal(@NotNull BlockState blockState, @NotNull BlockGetter blockAccess, @NotNull BlockPos pos, @NotNull Direction side) {
        return 10;
    }
}
