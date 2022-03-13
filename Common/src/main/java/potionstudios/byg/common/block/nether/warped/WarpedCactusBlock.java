package potionstudios.byg.common.block.nether.warped;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import potionstudios.byg.common.block.BYGBlocks;

import java.util.Random;

public class WarpedCactusBlock extends Block {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_15;
    protected static final VoxelShape COLLISION_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D);
    protected static final VoxelShape OUTLINE_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public WarpedCactusBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
    }

    public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
        if (!worldIn.isLoaded(pos))
            return; // Forge: prevent growing cactus from loading unloaded chunks with block update
        if (!state.canSurvive(worldIn, pos)) {
            worldIn.destroyBlock(pos, true);
        }

    }

    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
        BlockPos blockpos = pos.above();
        if (worldIn.isEmptyBlock(blockpos)) {
            int i;
            for (i = 1; worldIn.getBlockState(pos.below(i)).is(this); ++i) {
            }

            if (i < 3) {
                int j = state.getValue(AGE);
                if (j == 15) {
                    worldIn.setBlockAndUpdate(blockpos, this.defaultBlockState());
                    BlockState blockstate = state.setValue(AGE, Integer.valueOf(0));
                    worldIn.setBlock(pos, blockstate, 4);
                    blockstate.neighborChanged(worldIn, blockpos, this, pos, false);
                } else {
                    worldIn.setBlock(pos, state.setValue(AGE, Integer.valueOf(j + 1)), 4);
                }
            }
        }
    }

    public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return COLLISION_SHAPE;
    }

    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return OUTLINE_SHAPE;
    }

    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.canSurvive(worldIn, currentPos)) {
            worldIn.scheduleTick(currentPos, this, 1);
        }

        return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockState blockstate = worldIn.getBlockState(pos.relative(direction));
            Material material = blockstate.getMaterial();
            if (material.isSolid() || worldIn.getFluidState(pos.relative(direction)).is(FluidTags.LAVA)) {
                return false;
            }
        }

        return worldIn.getBlockState(pos.below()).getBlock() == BYGBlocks.WARPED_SOUL_SOIL || worldIn.getBlockState(pos.below()).getBlock() == BYGBlocks.WARPED_SOUL_SAND || worldIn.getBlockState(pos.below()).getBlock() == BYGBlocks.WARPED_CACTUS && !worldIn.getBlockState(pos.above()).getMaterial().isLiquid();
    }

    public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entityIn) {
        entityIn.hurt(DamageSource.CACTUS, 2.0F);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    public boolean isPathfindable(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type) {
        return false;
    }


}


