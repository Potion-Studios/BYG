package corgiaoc.byg.common.properties.blocks.end.shattereddesert;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.Random;

public class OddityCactusBlock extends Block {
    public static final IntProperty AGE = Properties.AGE_15;
    protected static final VoxelShape COLLISION_SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D);
    protected static final VoxelShape OUTLINE_SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public OddityCactusBlock(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, Integer.valueOf(0)));
    }

    public void scheduledTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (!state.canPlaceAt(worldIn, pos)) {
            worldIn.breakBlock(pos, true);
        }

    }

    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        BlockPos blockpos = pos.up();
        if (worldIn.isAir(blockpos)) {
            int i;
            for (i = 1; worldIn.getBlockState(pos.down(i)).isOf(this); ++i) {
            }

            if (i < 3) {
                int j = state.get(AGE);
                if (j == 15) {
                    worldIn.setBlockState(blockpos, this.getDefaultState());
                    BlockState blockstate = state.with(AGE, Integer.valueOf(0));
                    worldIn.setBlockState(pos, blockstate, 4);
                    blockstate.neighborUpdate(worldIn, blockpos, this, pos, false);
                } else {
                    worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(j + 1)), 4);
                }
            }
        }
    }

    public VoxelShape getCollisionShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        return COLLISION_SHAPE;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        return OUTLINE_SHAPE;
    }

    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.canPlaceAt(worldIn, currentPos)) {
            worldIn.getBlockTickScheduler().schedule(currentPos, this, 1);
        }

        return super.getStateForNeighborUpdate(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        for (Direction direction : Direction.Type.HORIZONTAL) {
            BlockState blockstate = worldIn.getBlockState(pos.offset(direction));
            Material material = blockstate.getMaterial();
            if (material.isSolid() || worldIn.getFluidState(pos.offset(direction)).isIn(FluidTags.LAVA)) {
                return false;
            }
        }

        return worldIn.getBlockState(pos.down()).getBlock() == BYGBlocks.WHITE_SAND || worldIn.getBlockState(pos.down()).getBlock() == BYGBlocks.BLACK_SAND || worldIn.getBlockState(pos.down()).getBlock() == BYGBlocks.ODDITY_CACTUS && !worldIn.getBlockState(pos.up()).getMaterial().isLiquid();
    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.damage(DamageSource.CACTUS, 2.0F);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    public boolean canPathfindThrough(BlockState state, BlockView worldIn, BlockPos pos, NavigationType type) {
        return false;
    }


}


