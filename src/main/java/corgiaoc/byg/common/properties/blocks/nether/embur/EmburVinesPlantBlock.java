package corgiaoc.byg.common.properties.blocks.nether.embur;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.SwordItem;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import corgiaoc.byg.core.byglists.BYGBlockList;

import javax.annotation.Nullable;
import java.util.Random;

public class EmburVinesPlantBlock extends Block implements IGrowable {
    public static final IntegerProperty PROPERTY_STAGE = BlockStateProperties.STAGE_0_1;
    public static final IntegerProperty PROPERTY_AGE = BlockStateProperties.AGE_0_1;
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 12.0D, 12.0D);

    protected EmburVinesPlantBlock(Properties builder) {
        super(builder);
        this.setDefaultState(this.stateContainer.getBaseState().with(PROPERTY_AGE, 0).with(PROPERTY_STAGE, 0));

    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(PROPERTY_AGE, PROPERTY_STAGE);
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Vector3d vec3d = state.getOffset(worldIn, pos);
        return SHAPE.withOffset(vec3d.x, vec3d.y, vec3d.z);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getPos());
        if (!fluidState.isEmpty()) {
            return null;
        } else {
            BlockState blockStateUP = ctx.getWorld().getBlockState(ctx.getPos().up());
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
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (rand.nextInt(3) == 0 && worldIn.isAirBlock(pos.down()) && worldIn.getLightSubtracted(pos.down(), 0) <= 12) {
            this.func_220087_a(worldIn, pos);
        }
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.isValidPosition(worldIn, currentPos)) {
            return Blocks.AIR.getDefaultState();
        } else {
            if (facing == Direction.DOWN && facingState.getBlock() == BYGBlockList.EMBUR_GEL_BLOCK) {
                worldIn.setBlockState(currentPos, BYGBlockList.EMBUR_GEL_BLOCK.getDefaultState(), 2);
            }

            return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }
    }

    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return worldIn.getBlockState(pos.down()).isAir();
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        this.func_220087_a(worldIn, pos);
    }

    protected void func_220087_a(World world, BlockPos pos) {
        world.setBlockState(pos.down(), BYGBlockList.EMBUR_GEL_VINES.getDefaultState(), 3);
    }

    public float getPlayerRelativeBlockHardness(BlockState state, PlayerEntity player, IBlockReader worldIn, BlockPos pos) {
        return player.getHeldItemMainhand().getItem() instanceof SwordItem ? 1.0F : super.getPlayerRelativeBlockHardness(state, player, worldIn, pos);
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        if (isAir(worldIn.getBlockState(pos.up()), worldIn, pos))
            return false;
        return worldIn.getBlockState(pos.up()).getBlock() == BYGBlockList.EMBUR_GEL_VINES || worldIn.getBlockState(pos.up()).getBlock() == BYGBlockList.EMBUR_GEL_BLOCK;

    }

    @Override
    public boolean isLadder(BlockState state, IWorldReader world, BlockPos pos, net.minecraft.entity.LivingEntity entity) {
        return true;
    }

}
