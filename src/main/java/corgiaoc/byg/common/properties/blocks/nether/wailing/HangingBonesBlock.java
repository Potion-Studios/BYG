package corgiaoc.byg.common.properties.blocks.nether.wailing;

import corgiaoc.byg.core.BYGBlocks;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HangingBonesBlock extends Block {
    protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 12.0D, 12.0D);

    protected HangingBonesBlock(Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        FluidState fluidState = ctx.getLevel().getFluidState(ctx.getClickedPos());
        if (!fluidState.isEmpty()) {
            return null;
        } else {
            BlockState blockStateUP = ctx.getLevel().getBlockState(ctx.getClickedPos().above());
            if (blockStateUP.getBlock() == Blocks.BONE_BLOCK) {
                Block blockUP = blockStateUP.getBlock();
                if (blockUP == BYGBlocks.HANGING_BONE) {
                    return this.defaultBlockState();
                } else if (blockUP == this) {
                    return this.defaultBlockState();
                } else {
                    return BYGBlocks.HANGING_BONE.defaultBlockState();
                }
            } else {
                return null;
            }
        }
    }


    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.canSurvive(worldIn, currentPos)) {
            return Blocks.AIR.defaultBlockState();
        } else {
            if (facing == Direction.DOWN && facingState.getBlock() == Blocks.BONE_BLOCK) {
                worldIn.setBlock(currentPos, Blocks.BONE_BLOCK.defaultBlockState(), 2);
            }

            return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }
    }


    public float getDestroyProgress(BlockState state, Player player, BlockGetter worldIn, BlockPos pos) {
        return player.getMainHandItem().getItem() instanceof SwordItem ? 1.0F : super.getDestroyProgress(state, player, worldIn, pos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        if (worldIn.getBlockState(pos.above()).isAir())
            return false;
        return worldIn.getBlockState(pos.above()).getBlock() == this || worldIn.getBlockState(pos.above()).getBlock() == Blocks.BONE_BLOCK;

    }
}
