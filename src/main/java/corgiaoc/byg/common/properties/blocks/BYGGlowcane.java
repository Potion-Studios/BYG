package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class BYGGlowcane extends Block {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_15;
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);

    protected BYGGlowcane(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
    }

    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }


    @Override
    public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
        if (!state.canSurvive(worldIn, pos)) {
            worldIn.destroyBlock(pos, true);
        } else if (worldIn.isEmptyBlock(pos.above())) {
            int i;
            for (i = 1; worldIn.getBlockState(pos.below(i)).getBlock() == this; ++i) {
            }

            if (i < 3) {
                int j = state.getValue(AGE);
                if (j == 15) {
                    worldIn.setBlockAndUpdate(pos.above(), this.defaultBlockState());
                    worldIn.setBlock(pos, state.setValue(AGE, 0), 4);
                } else {
                    worldIn.setBlock(pos, state.setValue(AGE, j + 1), 4);
                }
            }
        }
    }

    /**
     * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
     * returns its solidified counterpart.
     * Note that this method should ideally consider only the specific face passed in.
     */
    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.canSurvive(worldIn, currentPos)) {
            worldIn.getBlockTicks().scheduleTick(currentPos, this, 1);
        }

        return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        if (worldIn.getBlockState(pos.below()).isAir())
            return false;
        return worldIn.getBlockState(pos.below()).getBlock() == BYGBlocks.GLOWCELIUM || worldIn.getBlockState(pos.below()).getBlock() == this;

    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}