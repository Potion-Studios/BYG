package corgiaoc.byg.common.properties.blocks.nether.wailing;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.SwordItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import javax.annotation.Nullable;

public class HangingBonesBlock extends Block {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 12.0D, 12.0D);

    protected HangingBonesBlock(Settings properties) {
        super(properties);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        if (!fluidState.isEmpty()) {
            return null;
        } else {
            BlockState blockStateUP = ctx.getWorld().getBlockState(ctx.getBlockPos().up());
            if (blockStateUP.getBlock() == Blocks.BONE_BLOCK) {
                Block blockUP = blockStateUP.getBlock();
                if (blockUP == BYGBlocks.HANGING_BONE) {
                    return this.getDefaultState();
                } else if (blockUP == this) {
                    return this.getDefaultState();
                } else {
                    return BYGBlocks.HANGING_BONE.getDefaultState();
                }
            } else {
                return null;
            }
        }
    }


    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.canPlaceAt(worldIn, currentPos)) {
            return Blocks.AIR.getDefaultState();
        } else {
            if (facing == Direction.DOWN && facingState.getBlock() == Blocks.BONE_BLOCK) {
                worldIn.setBlockState(currentPos, Blocks.BONE_BLOCK.getDefaultState(), 2);
            }

            return super.getStateForNeighborUpdate(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }
    }


    public float calcBlockBreakingDelta(BlockState state, PlayerEntity player, BlockView worldIn, BlockPos pos) {
        return player.getMainHandStack().getItem() instanceof SwordItem ? 1.0F : super.calcBlockBreakingDelta(state, player, worldIn, pos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        if (worldIn.isAir(pos.up()))
            return false;
        return worldIn.getBlockState(pos.up()).getBlock() == this || worldIn.getBlockState(pos.up()).getBlock() == Blocks.BONE_BLOCK;

    }
}
