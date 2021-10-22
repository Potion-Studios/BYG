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
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BambooSaplingBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.Random;

public class CattailSproutBlock extends BambooSaplingBlock {
    public CattailSproutBlock(Properties properties) {
        super(properties);
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
        this.growCattail(serverLevel, blockPos, blockState);
    }

    public float getDestroyProgress(@NotNull BlockState blockState, Player player, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return player.getMainHandItem().getItem() instanceof SwordItem ? 1.0F : super.getDestroyProgress(blockState, player, blockGetter, blockPos);
    }

    protected void growCattail(ServerLevel world, BlockPos pos, BlockState state) {
        CattailPlantBlock cattailplantblock = (CattailPlantBlock) (BYGBlocks.CATTAIL);
        if (cattailplantblock.defaultBlockState().canSurvive(world, pos) && world.isEmptyBlock(pos.above())) {
            CattailPlantBlock.placeAt(world, state, pos, 2);
        }    }
}
