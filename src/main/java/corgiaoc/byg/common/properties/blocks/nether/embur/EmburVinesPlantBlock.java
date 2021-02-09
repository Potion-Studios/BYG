package corgiaoc.byg.common.properties.blocks.nether.embur;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.SwordItem;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import javax.annotation.Nullable;
import java.util.Random;

public class EmburVinesPlantBlock extends Block implements Fertilizable {
    public static final IntProperty PROPERTY_STAGE = Properties.STAGE;
    public static final IntProperty PROPERTY_AGE = Properties.AGE_1;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 12.0D, 12.0D);

    protected EmburVinesPlantBlock(Settings builder) {
        super(builder);
        this.setDefaultState(this.stateManager.getDefaultState().with(PROPERTY_AGE, 0).with(PROPERTY_STAGE, 0));

    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(PROPERTY_AGE, PROPERTY_STAGE);
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(worldIn, pos);
        return SHAPE.offset(vec3d.x, vec3d.y, vec3d.z);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        if (!fluidState.isEmpty()) {
            return null;
        } else {
            BlockState blockStateUP = ctx.getWorld().getBlockState(ctx.getBlockPos().up());
            if (blockStateUP.getBlock() == BYGBlocks.EMBUR_GEL_BLOCK) {
                Block blockUP = blockStateUP.getBlock();
                if (blockUP == BYGBlocks.EMBUR_GEL_VINES) {
                    return this.getDefaultState().with(PROPERTY_AGE, 0);
                } else if (blockUP == this) {
                    int getPropertyAge = blockStateUP.get(PROPERTY_AGE) > 0 ? 1 : 0;
                    return this.getDefaultState().with(PROPERTY_AGE, getPropertyAge);
                } else {
                    return BYGBlocks.EMBUR_GEL_VINES.getDefaultState();
                }
            } else {
                return null;
            }
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (rand.nextInt(3) == 0 && worldIn.isAir(pos.down()) && worldIn.getBaseLightLevel(pos.down(), 0) <= 12) {
            this.growBamboo(worldIn, pos);
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.canPlaceAt(worldIn, currentPos)) {
            return Blocks.AIR.getDefaultState();
        } else {
            if (facing == Direction.DOWN && facingState.getBlock() == BYGBlocks.EMBUR_GEL_BLOCK) {
                worldIn.setBlockState(currentPos, BYGBlocks.EMBUR_GEL_BLOCK.getDefaultState(), 2);
            }

            return super.getStateForNeighborUpdate(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }
    }

    public boolean isFertilizable(BlockView worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return worldIn.getBlockState(pos.down()).isAir();
    }

    public boolean canGrow(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        this.growBamboo(worldIn, pos);
    }

    protected void growBamboo(World world, BlockPos pos) {
        world.setBlockState(pos.down(), BYGBlocks.EMBUR_GEL_VINES.getDefaultState(), 3);
    }

    public float calcBlockBreakingDelta(BlockState state, PlayerEntity player, BlockView worldIn, BlockPos pos) {
        return player.getMainHandStack().getItem() instanceof SwordItem ? 1.0F : super.calcBlockBreakingDelta(state, player, worldIn, pos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        if (worldIn.isAir(pos.up()))
            return false;
        return worldIn.getBlockState(pos.up()).getBlock() == BYGBlocks.EMBUR_GEL_VINES || worldIn.getBlockState(pos.up()).getBlock() == BYGBlocks.EMBUR_GEL_BLOCK;

    }

    public boolean isLadder(BlockState state, WorldView world, BlockPos pos, net.minecraft.entity.LivingEntity entity) {
        return true;
    }

}
