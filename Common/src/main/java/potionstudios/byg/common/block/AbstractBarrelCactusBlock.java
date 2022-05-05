package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class AbstractBarrelCactusBlock extends Block implements BonemealableBlock {
    protected static final VoxelShape COLLISION_SHAPE;
    protected static final VoxelShape OUTLINE_SHAPE;

    public AbstractBarrelCactusBlock(Properties $$0) {
        super($$0);
    }

    @Override
    public boolean isValidBonemealTarget(@NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull BlockState blockState, boolean b) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(@NotNull Level level, @NotNull Random random, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return true;
    }

    @Override
    public void entityInside(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Entity pEntity) {
        if (pEntity instanceof LivingEntity && pEntity.getType() != EntityType.FOX && pEntity.getType() != EntityType.BEE) {
            if (!pLevel.isClientSide && (pEntity.xOld != pEntity.getX() || pEntity.zOld != pEntity.getZ())) {
                double d0 = Math.abs(pEntity.getX() - pEntity.xOld);
                double d1 = Math.abs(pEntity.getZ() - pEntity.zOld);
                if (d0 >= (double)0.003F || d1 >= (double)0.003F) {
                    pEntity.hurt(DamageSource.CACTUS, 1.0F);
                }
            }

        }
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, @NotNull Random random, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        serverLevel.setBlockAndUpdate(blockPos, BYGBlocks.FLOWERING_BARREL_CACTUS.defaultBlockState());
        serverLevel.neighborChanged(blockPos, BYGBlocks.FLOWERING_BARREL_CACTUS.get(), blockPos);
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

    protected boolean mayPlaceOn(@NotNull BlockState $$0, BlockGetter $$1, BlockPos $$2) {
        BlockState $$6 = $$1.getBlockState($$2.below());
        return ($$6.is(BlockTags.SAND)) && !$$1.getBlockState($$2.above()).getMaterial().isLiquid();
    }

    public boolean canSurvive(BlockState $$0, LevelReader $$1, @NotNull BlockPos $$2) {
        return this.mayPlaceOn($$1.getBlockState($$2.above()), $$1, $$2);
    }

    public BlockState updateShape(BlockState $$0, Direction $$1, BlockState $$2, LevelAccessor $$3, BlockPos $$4, BlockPos $$5) {
        if (!$$0.canSurvive($$3, $$4)) {
            return Blocks.AIR.defaultBlockState();
        }
        return super.updateShape($$0, $$1, $$2, $$3, $$4, $$5);
    }

    public boolean isPathfindable(@NotNull BlockState $$0, @NotNull BlockGetter $$1, @NotNull BlockPos $$2, @NotNull PathComputationType $$3) {
        return false;
    }

    public VoxelShape getCollisionShape(BlockState $$0, BlockGetter $$1, BlockPos $$2, CollisionContext $$3) {
        return COLLISION_SHAPE;
    }

    public VoxelShape getShape(BlockState $$0, BlockGetter $$1, BlockPos $$2, CollisionContext $$3) {
        return OUTLINE_SHAPE;
    }

    static {
        COLLISION_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D);
        OUTLINE_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
    }
}
