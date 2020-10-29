package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.Random;

public class BYGGlowcane extends Block {
    public static final IntProperty AGE = Properties.AGE_15;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);

    protected BYGGlowcane(AbstractBlock.Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, Integer.valueOf(0)));
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }


    @Override
    public void scheduledTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
    if (!state.canPlaceAt(worldIn, pos)) {
        worldIn.breakBlock(pos, true);
    } else if (worldIn.isAir(pos.up())) {
        int i;
        for (i = 1; worldIn.getBlockState(pos.down(i)).getBlock() == this; ++i) {
        }

        if (i < 3) {
            int j = state.get(AGE);
                if (j == 15) {
                    worldIn.setBlockState(pos.up(), this.getDefaultState());
                    worldIn.setBlockState(pos, state.with(AGE, 0), 4);
                } else {
                    worldIn.setBlockState(pos, state.with(AGE, j + 1), 4);
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
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.canPlaceAt(worldIn, currentPos)) {
            worldIn.getBlockTickScheduler().schedule(currentPos, this, 1);
        }

        return super.getStateForNeighborUpdate(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        if (worldIn.isAir(pos.down()))
            return false;
        return worldIn.getBlockState(pos.down()).getBlock() == BYGBlocks.GLOWCELIUM || worldIn.getBlockState(pos.down()).getBlock() == this;

    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}