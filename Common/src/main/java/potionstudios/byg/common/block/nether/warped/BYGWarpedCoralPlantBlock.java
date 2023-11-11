package potionstudios.byg.common.block.nether.warped;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseCoralPlantTypeBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.block.BYGBlocks;

public class BYGWarpedCoralPlantBlock extends BaseCoralPlantTypeBlock {
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 15.0D, 14.0D);

    protected BYGWarpedCoralPlantBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false));
    }

    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter reader, @NotNull BlockPos blockPos, @NotNull CollisionContext context) {
        return SHAPE;
    }

    protected boolean isValidGround(BlockState state) {
        return state.getBlock() == BYGBlocks.WARPED_SOUL_SAND.get() || state.getBlock() == BYGBlocks.WARPED_SOUL_SOIL.get();
    }

    @Override
    public boolean canSurvive(@NotNull BlockState state, LevelReader worldIn, BlockPos pos) {
        BlockPos posDown = pos.below();
        return this.isValidGround(worldIn.getBlockState(posDown));
    }
}
