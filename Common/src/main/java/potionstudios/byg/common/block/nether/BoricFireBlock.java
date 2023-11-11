package potionstudios.byg.common.block.nether;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.block.BYGBlocks;

public class BoricFireBlock extends BaseFireBlock {

    public BoricFireBlock(Properties properties) {
        super(properties, 3.5F);
    }

    public @NotNull BlockState updateShape(@NotNull BlockState stateIn, @NotNull Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor worldIn, @NotNull BlockPos currentPos, @NotNull BlockPos facingPos) {
        return this.canSurvive(stateIn, worldIn, currentPos) ? this.defaultBlockState() : Blocks.AIR.defaultBlockState();
    }

    public boolean canSurvive(@NotNull BlockState state, LevelReader worldIn, BlockPos pos) {
        return shouldLightBoricFire(worldIn.getBlockState(pos.below()).getBlock());
    }

    public static boolean shouldLightBoricFire(Block block) {
        return block == BYGBlocks.BRIMSTONE.get();
    }

    protected boolean canBurn(@NotNull BlockState state) {
        return true;
    }
}
