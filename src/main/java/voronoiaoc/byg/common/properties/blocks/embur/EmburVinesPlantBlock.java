package voronoiaoc.byg.common.properties.blocks.embur;

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
import voronoiaoc.byg.core.byglists.BYGBlockList;

import javax.annotation.Nullable;
import java.util.Random;

public class EmburVinesPlantBlock extends Block implements Fertilizable {
    public static final IntProperty PROPERTY_STAGE = Properties.STAGE;
    public static final IntProperty PROPERTY_AGE = Properties.AGE_1;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 12.0D, 12.0D);

    protected EmburVinesPlantBlock(AbstractBlock.Settings builder) {
        super(builder);
        this.setDefaultState(this.stateManager.getDefaultState().with(PROPERTY_AGE, 0).with(PROPERTY_STAGE, 0));

    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(PROPERTY_AGE, PROPERTY_STAGE);
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(world, pos);
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
            if (blockStateUP.getBlock() == BYGBlockList.EMBUR_GEL_BLOCK) {
                Block blockUP = blockStateUP.getBlock();
                if (blockUP == BYGBlockList.EMBUR_GEL_VINES) {
                    return this.getDefaultState().with(PROPERTY_AGE, 0);
                } else if (blockUP == this) {
                    int getPropertyAge = blockStateUP.get(PROPERTY_AGE) > 0 ? 1 : 0;
                    return this.getDefaultState().with(PROPERTY_AGE, getPropertyAge);
                } else {
                    return BYGBlockList.EMBUR_GEL_VINES.getDefaultState();
                }
            } else {
                return null;
            }
        }
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random rand) {
        if (rand.nextInt(3) == 0 && world.isAir(pos.down()) && world.getBaseLightLevel(pos.down(), 0) <= 12) {
            this.grow(world, pos);
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction facing, BlockState facingState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        if (!state.canPlaceAt(world, pos)) {
            return Blocks.AIR.getDefaultState();
        } else {
            if (facing == Direction.DOWN && facingState.getBlock() == BYGBlockList.EMBUR_GEL_BLOCK) {
                world.setBlockState(pos, BYGBlockList.EMBUR_GEL_BLOCK.getDefaultState(), 2);
            }
            return super.getStateForNeighborUpdate(state, facing, facingState, world, pos, posFrom);
        }
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return world.getBlockState(pos.down()).isAir();
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if (world.getBlockState(pos.up()).getBlock() == Blocks.AIR)
            return false;
        else
            return world.getBlockState(pos.up()).getBlock() == BYGBlockList.EMBUR_GEL_VINES || world.getBlockState(pos.up()).getBlock() == BYGBlockList.EMBUR_GEL_BLOCK;
    }


    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        this.grow(worldIn, pos);
    }

    protected void grow(World world, BlockPos pos) {
        world.setBlockState(pos.down(), BYGBlockList.EMBUR_GEL_VINES.getDefaultState(), 3);
    }

    @Override
    public float calcBlockBreakingDelta(BlockState state, PlayerEntity player, BlockView world, BlockPos pos) {
        return player.getMainHandStack().getItem() instanceof SwordItem ? 1.0F : super.calcBlockBreakingDelta(state, player, world, pos);
    }
}
