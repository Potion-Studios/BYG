package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import potionstudios.byg.common.item.BYGItems;

import javax.annotation.Nullable;
import java.util.Random;

public class CattailSproutBlock extends BambooSaplingBlock implements SimpleWaterloggedBlock, BonemealableBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public CattailSproutBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false));
    }

    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, Random random) {
        int i = random.nextInt(5);
        if (i == 4) {
            if (serverLevel.getBlockState(blockPos.above()) == Blocks.AIR.defaultBlockState()) {
                growCatTail(serverLevel, blockPos);
            }
        }
    }

    public FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos());
        if (fluidState.getType() == Fluids.WATER) {
            return super.getStateForPlacement(blockPlaceContext).setValue(WATERLOGGED, true);
        } else return this.defaultBlockState();
    }



    public void growCatTail(ServerLevel serverLevel, BlockPos blockPos) {
        if (serverLevel.getFluidState(blockPos).getType() == Fluids.WATER) {
            serverLevel.setBlock(blockPos, BYGBlocks.CATTAIL.defaultBlockState().setValue(CattailPlantBlock.HALF, DoubleBlockHalf.LOWER).setValue(CattailPlantBlock.WATERLOGGED, true), 3);
        } else {
            serverLevel.setBlock(blockPos, BYGBlocks.CATTAIL.defaultBlockState().setValue(CattailPlantBlock.HALF, DoubleBlockHalf.LOWER).setValue(CattailPlantBlock.WATERLOGGED, false), 3);
        }
        serverLevel.setBlock(blockPos.above(), BYGBlocks.CATTAIL.defaultBlockState().setValue(CattailPlantBlock.HALF, DoubleBlockHalf.UPPER).setValue(CattailPlantBlock.WATERLOGGED, false), 3);

    }

    @Override
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        BlockState state = levelReader.getBlockState(blockPos);
        BlockState blockState2 = levelReader.getBlockState(blockPos.below());

        if (levelReader.getBlockState(blockPos.above(1)) == Blocks.AIR.defaultBlockState() &&
                (blockState2.is(BlockTags.DIRT) || blockState2.is(Blocks.SAND) || blockState2.is(Blocks.RED_SAND)) &&
                state == Blocks.WATER.defaultBlockState()) {
            return true;
        }if (blockState2.is(BlockTags.DIRT) || blockState2.is(Blocks.SAND) || blockState2.is(Blocks.RED_SAND)) {
            BlockPos blockPos2 = blockPos.below();
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                BlockState blockState3 = levelReader.getBlockState(blockPos2.relative(direction));
                FluidState fluidState = levelReader.getFluidState(blockPos2.relative(direction));
                if (fluidState.is(FluidTags.WATER) || blockState3.is(Blocks.FROSTED_ICE)) {
                    return true;
                }
            }
        }
        return false;
        }



    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        if (blockState.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState) {
        return new ItemStack(BYGItems.CATTAIL_SPROUT);
    }

    public void performBonemeal(ServerLevel serverLevel, Random random, BlockPos blockPos, BlockState blockState) {
        growCatTail(serverLevel, blockPos);
    }

    public float getDestroyProgress(BlockState blockState, Player player, BlockGetter blockGetter, BlockPos blockPos) {
        return player.getMainHandItem().getItem() instanceof SwordItem ? 1.0F : super.getDestroyProgress(blockState, player, blockGetter, blockPos);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }
}
