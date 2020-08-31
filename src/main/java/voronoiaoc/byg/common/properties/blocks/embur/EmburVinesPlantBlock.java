package voronoiaoc.byg.common.properties.blocks.embur;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import javax.annotation.Nullable;
import java.util.Random;

public class EmburVinesPlantBlock extends Block implements BonemealableBlock {
    public static final IntegerProperty PROPERTY_STAGE = BlockStateProperties.STAGE;
    public static final IntegerProperty PROPERTY_AGE = BlockStateProperties.AGE_1;
    protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 12.0D, 12.0D);

    protected EmburVinesPlantBlock(BlockBehaviour.Properties builder) {
        super(builder);
        this.registerDefaultState(this.stateDefinition.any().setValue(PROPERTY_AGE, 0).setValue(PROPERTY_STAGE, 0));

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(PROPERTY_AGE, PROPERTY_STAGE);
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }


    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 vec3d = state.getOffset(world, pos);
        return SHAPE.move(vec3d.x, vec3d.y, vec3d.z);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        FluidState fluidState = ctx.getLevel().getFluidState(ctx.getClickedPos());
        if (!fluidState.isEmpty()) {
            return null;
        } else {
            BlockState blockStateUP = ctx.getLevel().getBlockState(ctx.getClickedPos().above());
            if (blockStateUP.getBlock() == BYGBlockList.EMBUR_GEL_BLOCK) {
                Block blockUP = blockStateUP.getBlock();
                if (blockUP == BYGBlockList.EMBUR_GEL_VINES) {
                    return this.defaultBlockState().setValue(PROPERTY_AGE, 0);
                } else if (blockUP == this) {
                    int getPropertyAge = blockStateUP.getValue(PROPERTY_AGE) > 0 ? 1 : 0;
                    return this.defaultBlockState().setValue(PROPERTY_AGE, getPropertyAge);
                } else {
                    return BYGBlockList.EMBUR_GEL_VINES.defaultBlockState();
                }
            } else {
                return null;
            }
        }
    }

    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, Random rand) {
        if (rand.nextInt(3) == 0 && world.isEmptyBlock(pos.below()) && world.getRawBrightness(pos.below(), 0) <= 12) {
            this.grow(world, pos);
        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos pos, BlockPos posFrom) {
        if (!state.canSurvive(world, pos)) {
            return Blocks.AIR.defaultBlockState();
        } else {
            if (facing == Direction.DOWN && facingState.getBlock() == BYGBlockList.EMBUR_GEL_BLOCK) {
                world.setBlock(pos, BYGBlockList.EMBUR_GEL_BLOCK.defaultBlockState(), 2);
            }
            return super.updateShape(state, facing, facingState, world, pos, posFrom);
        }
    }

    @Override
    public boolean isBonemealSuccess(Level world, Random random, BlockPos pos, BlockState state) {
        return world.getBlockState(pos.below()).isAir();
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        if (world.getBlockState(pos.above()).getBlock() == Blocks.AIR)
            return false;
        else
            return world.getBlockState(pos.above()).getBlock() == BYGBlockList.EMBUR_GEL_VINES || world.getBlockState(pos.above()).getBlock() == BYGBlockList.EMBUR_GEL_BLOCK;
    }


    @Override
    public boolean isValidBonemealTarget(BlockGetter world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    public void performBonemeal(ServerLevel worldIn, Random rand, BlockPos pos, BlockState state) {
        this.grow(worldIn, pos);
    }

    protected void grow(Level world, BlockPos pos) {
        world.setBlock(pos.below(), BYGBlockList.EMBUR_GEL_VINES.defaultBlockState(), 3);
    }

    @Override
    public float getDestroyProgress(BlockState state, Player player, BlockGetter world, BlockPos pos) {
        return player.getMainHandItem().getItem() instanceof SwordItem ? 1.0F : super.getDestroyProgress(state, player, world, pos);
    }
}
