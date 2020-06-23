package voronoiaoc.byg.common.properties.blocks;

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

public class HangingVinesPlantBlock extends Block {
    public static final IntProperty PROPERTY_STAGE = Properties.STAGE;
    public static final IntProperty PROPERTY_AGE = Properties.AGE_1;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 12.0D, 12.0D);

    protected HangingVinesPlantBlock(AbstractBlock.Settings builder) {
        super(builder);
        this.setDefaultState(this.getStateManager().getDefaultState().with(PROPERTY_AGE, 0).with(PROPERTY_STAGE, 0));

    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(PROPERTY_AGE, PROPERTY_STAGE);
    }

    public Block.OffsetType getOffsetType() {
        return Block.OffsetType.XZ;
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
            if (blockStateUP.getBlock() == Blocks.NETHERRACK || blockStateUP.getMaterial() == Material.STONE) {
                Block blockUP = blockStateUP.getBlock();
                if (blockUP == BYGBlockList.WEEPING_ROOTS) {
                    return this.getDefaultState().with(PROPERTY_AGE, 0);
                } else if (blockUP == this) {
                    int getPropertyAge = blockStateUP.get(PROPERTY_AGE) > 0 ? 1 : 0;
                    return this.getDefaultState().with(PROPERTY_AGE, getPropertyAge);
                } else {
                    return BYGBlockList.WEEPING_ROOTS.getDefaultState();
                }
            } else {
                return null;
            }
        }
    }


    @Override
    public boolean hasRandomTicks(BlockState state) {
        return super.hasRandomTicks(state);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random rand) {
        if (rand.nextInt(3) == 0 && world.isAir(pos.down()) && world.getBaseLightLevel(pos.down(), 0) <= 12) {
            this.isWeeping(world, pos);
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.canPlaceAt(worldIn, currentPos)) {
            return Blocks.AIR.getDefaultState();
        } else {
            if (facing == Direction.DOWN && facingState.getBlock() == BYGBlockList.WEEPING_ROOTS_PLANT) {
                worldIn.setBlockState(currentPos, BYGBlockList.WEEPING_ROOTS_PLANT.getDefaultState(), 2);
            }

            return super.getStateForNeighborUpdate(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }
    }


    public boolean canGrow(BlockView worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return worldIn.getBlockState(pos.down()).isAir();
    }

    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        this.isWeeping(worldIn, pos);
    }

    protected void isWeeping(World world, BlockPos pos) {
        world.setBlockState(pos.down(), BYGBlockList.WEEPING_ROOTS_PLANT.getDefaultState(), 3);
    }

    @Override
    public float calcBlockBreakingDelta(BlockState state, PlayerEntity player, BlockView world, BlockPos pos) {
        return player.getMainHandStack().getItem() instanceof SwordItem ? 1.0F : super.calcBlockBreakingDelta(state, player, world, pos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        BlockState state1 = worldIn.getBlockState(pos.up());
        if (state1.isAir())
            return false;
        return worldIn.getBlockState(pos.up()).getBlock() == BYGBlockList.WEEPING_ROOTS || worldIn.getBlockState(pos.up()).getBlock() == BYGBlockList.WEEPING_ROOTS_PLANT;
    }


}
