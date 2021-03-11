package corgiaoc.byg.common.properties.blocks.nether.embur;

import corgiaoc.byg.core.BYGBlocks;
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

import javax.annotation.Nullable;
import java.util.Random;

import net.minecraft.block.AbstractBlock.OffsetType;
import net.minecraft.block.AbstractBlock.Properties;

public class EmburVinesPlantBlock extends Block implements IGrowable {
    public static final IntegerProperty PROPERTY_STAGE = BlockStateProperties.STAGE;
    public static final IntegerProperty PROPERTY_AGE = BlockStateProperties.AGE_1;
    protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 12.0D, 12.0D);

    protected EmburVinesPlantBlock(Properties builder) {
        super(builder);
        this.registerDefaultState(this.stateDefinition.any().setValue(PROPERTY_AGE, 0).setValue(PROPERTY_STAGE, 0));

    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(PROPERTY_AGE, PROPERTY_STAGE);
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Vector3d vec3d = state.getOffset(worldIn, pos);
        return SHAPE.move(vec3d.x, vec3d.y, vec3d.z);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext ctx) {
        FluidState fluidState = ctx.getLevel().getFluidState(ctx.getClickedPos());
        if (!fluidState.isEmpty()) {
            return null;
        } else {
            BlockState blockStateUP = ctx.getLevel().getBlockState(ctx.getClickedPos().above());
            if (blockStateUP.getBlock() == BYGBlocks.EMBUR_GEL_BLOCK) {
                Block blockUP = blockStateUP.getBlock();
                if (blockUP == BYGBlocks.EMBUR_GEL_VINES) {
                    return this.defaultBlockState().setValue(PROPERTY_AGE, 0);
                } else if (blockUP == this) {
                    int getPropertyAge = blockStateUP.getValue(PROPERTY_AGE) > 0 ? 1 : 0;
                    return this.defaultBlockState().setValue(PROPERTY_AGE, getPropertyAge);
                } else {
                    return BYGBlocks.EMBUR_GEL_VINES.defaultBlockState();
                }
            } else {
                return null;
            }
        }
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (rand.nextInt(3) == 0 && worldIn.isEmptyBlock(pos.below()) && worldIn.getRawBrightness(pos.below(), 0) <= 12) {
            this.growBamboo(worldIn, pos);
        }
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.canSurvive(worldIn, currentPos)) {
            return Blocks.AIR.defaultBlockState();
        } else {
            if (facing == Direction.DOWN && facingState.getBlock() == BYGBlocks.EMBUR_GEL_BLOCK) {
                worldIn.setBlock(currentPos, BYGBlocks.EMBUR_GEL_BLOCK.defaultBlockState(), 2);
            }

            return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }
    }

    public boolean isValidBonemealTarget(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return worldIn.getBlockState(pos.below()).isAir();
    }

    public boolean isBonemealSuccess(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    public void performBonemeal(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        this.growBamboo(worldIn, pos);
    }

    protected void growBamboo(World world, BlockPos pos) {
        world.setBlock(pos.below(), BYGBlocks.EMBUR_GEL_VINES.defaultBlockState(), 3);
    }

    public float getDestroyProgress(BlockState state, PlayerEntity player, IBlockReader worldIn, BlockPos pos) {
        return player.getMainHandItem().getItem() instanceof SwordItem ? 1.0F : super.getDestroyProgress(state, player, worldIn, pos);
    }

    @Override
    public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        if (isAir(worldIn.getBlockState(pos.above()), worldIn, pos))
            return false;
        return worldIn.getBlockState(pos.above()).getBlock() == BYGBlocks.EMBUR_GEL_VINES || worldIn.getBlockState(pos.above()).getBlock() == BYGBlocks.EMBUR_GEL_BLOCK;

    }

    @Override
    public boolean isLadder(BlockState state, IWorldReader world, BlockPos pos, net.minecraft.entity.LivingEntity entity) {
        return true;
    }

}
