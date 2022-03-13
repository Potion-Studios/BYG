package potionstudios.byg.common.block.nether.warped;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseCoralPlantTypeBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import potionstudios.byg.common.block.BYGBlocks;

public class BYGWarpedCoralPlantBlock extends BaseCoralPlantTypeBlock {
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 15.0D, 14.0D);

    protected BYGWarpedCoralPlantBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false));
    }

    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos blockPos, CollisionContext context) {
        return SHAPE;
    }

    protected boolean isValidGround(BlockState state) {
        return state.getBlock() == BYGBlocks.WARPED_SOUL_SAND || state.getBlock() == BYGBlocks.WARPED_SOUL_SOIL;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        BlockPos posDown = pos.below();
        return this.isValidGround(worldIn.getBlockState(posDown));
    }
}
