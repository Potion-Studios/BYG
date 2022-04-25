package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.block.BYGBlocks;

import java.util.Iterator;
import java.util.Random;

public class AbstractBarrelCactusBlock extends Block implements BonemealableBlock {

    public AbstractBarrelCactusBlock(Properties $$0) {
        super($$0);
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState, boolean b) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, Random random, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, Random random, BlockPos blockPos, BlockState blockState) {
        serverLevel.setBlockAndUpdate(blockPos, BYGBlocks.FLOWERING_BARREL_CACTUS.defaultBlockState());
        serverLevel.neighborChanged(blockPos, BYGBlocks.FLOWERING_BARREL_CACTUS, blockPos);
    }

    public InteractionResult use(@NotNull BlockState state, @NotNull Level world, @NotNull BlockPos $$2, @NotNull Player $$3, @NotNull InteractionHand $$4, @NotNull BlockHitResult $$5) {
        ItemStack $$6 = $$3.getItemInHand($$4);
        if ($$6.is(Items.SHEARS)) {
            if (!world.isClientSide) {
                world.playSound(null, $$2, SoundEvents.PUMPKIN_CARVE, SoundSource.BLOCKS, 1.0F, 1.0F);
                world.setBlock($$2, BYGBlocks.CARVED_BARREL_CACTUS.defaultBlockState(), 11);
                $$6.hurtAndBreak(1, $$3, ($$1x) -> {
                    $$1x.broadcastBreakEvent($$4);
                });
                world.gameEvent($$3, GameEvent.SHEAR, $$2);
                $$3.awardStat(Stats.ITEM_USED.get(Items.SHEARS));
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        } else {
            return super.use(state, world, $$2, $$3, $$4, $$5);
        }
    }


    public boolean canSurvive(BlockState $$0, LevelReader $$1, BlockPos $$2) {
        BlockState $$6 = $$1.getBlockState($$2.below());
        return ($$6.is(BlockTags.SAND)) && !$$1.getBlockState($$2.above()).getMaterial().isLiquid();
    }

    public boolean isPathfindable(BlockState $$0, BlockGetter $$1, BlockPos $$2, PathComputationType $$3) {
        return false;
    }

    static {
    }
}
