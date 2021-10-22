package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.BYGItems;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.Random;

public class CattailSproutBlock extends BambooSaplingBlock implements SimpleWaterloggedBlock {

    public static final BooleanProperty WATERLOGGED;


    public CattailSproutBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, true));
    }

    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, Random random) {
        CattailPlantBlock cattailplantblock = (CattailPlantBlock)(blockState.is(BYGBlocks.CATTAIL_SPROUT) ? BYGBlocks.CATTAIL : BYGBlocks.CATTAIL);
        if (cattailplantblock.defaultBlockState().canSurvive(serverLevel, blockPos) && serverLevel.isEmptyBlock(blockPos.above())) {
            CattailPlantBlock.placeAt(serverLevel, blockState, blockPos, 2);
        }

    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPos);
        BlockState blockState = this.defaultBlockState().setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
        Level level = blockPlaceContext.getLevel();
        if (level.getBlockState(blockPos.above()) == Blocks.AIR.defaultBlockState()) {
            return blockState;
        }
        else return level.getBlockState(blockPos);
    }

    public boolean canSurvive(@NotNull BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        BlockState blockState2 = levelReader.getBlockState(blockPos.below());
        if (blockState2.is(this)) {
            return true;
        } else {
            if (blockState2.is(BlockTags.DIRT) || blockState2.is(Blocks.SAND) || blockState2.is(Blocks.RED_SAND)) {
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
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }

    public BlockState updateShape(BlockState blockState, @NotNull Direction direction, @NotNull BlockState blockState2, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos blockPos2) {
        if (!blockState.canSurvive(levelAccessor, blockPos)) {
            return Blocks.AIR.defaultBlockState();
        } else {
            if (direction == Direction.UP && blockState2.is(BYGBlocks.CATTAIL)) {
                levelAccessor.setBlock(blockPos, BYGBlocks.CATTAIL.defaultBlockState(), 2);
            }

            return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
        }
    }

    public ItemStack getCloneItemStack(@NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new ItemStack(BYGItems.CATTAIL_SPROUT);
    }

    public void performBonemeal(@NotNull ServerLevel serverLevel, @NotNull Random random, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        CattailPlantBlock cattailplantblock = (CattailPlantBlock)(blockState.is(BYGBlocks.CATTAIL_SPROUT) ? BYGBlocks.CATTAIL : BYGBlocks.CATTAIL);
        if (cattailplantblock.defaultBlockState().canSurvive(serverLevel, blockPos) && serverLevel.isEmptyBlock(blockPos.above())) {
            CattailPlantBlock.placeAt(serverLevel, blockState, blockPos, 2);
        }



    }

    public float getDestroyProgress(@NotNull BlockState blockState, Player player, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return player.getMainHandItem().getItem() instanceof SwordItem ? 1.0F : super.getDestroyProgress(blockState, player, blockGetter, blockPos);
    }

    protected void growCattail(ServerLevel world, BlockPos pos, BlockState state) {
        CattailPlantBlock cattailplantblock = (CattailPlantBlock) (BYGBlocks.CATTAIL);
        if (cattailplantblock.defaultBlockState().canSurvive(world, pos) && world.isEmptyBlock(pos.above())) {
            CattailPlantBlock.placeAt(world, state, pos, 2);
        }



    }
    static {
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
    }
}
