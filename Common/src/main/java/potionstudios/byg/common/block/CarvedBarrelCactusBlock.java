package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.Random;


public class CarvedBarrelCactusBlock extends AbstractBarrelCactusBlock {

    public CarvedBarrelCactusBlock(Properties $$0) {
        super($$0);
    }

    public static @NotNull VoxelShape makeShape() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.0625, 0, 0.0625, 0.9375, 0.0625, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.0625, 0.0625, 0, 0.9375, 1, 0.0625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.0625, 0.0625, 0.9375, 0.9375, 1, 1), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0.0625, 0.0625, 0.0625, 1, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.9375, 0.0625, 0.0625, 1, 1, 0.9375), BooleanOp.OR);
        return shape;
    }

    @Override
    public VoxelShape getShape(BlockState $$0, BlockGetter $$1, BlockPos $$2, CollisionContext $$3) {
        return makeShape();
    }

    @Override
    public VoxelShape getCollisionShape(BlockState $$0, BlockGetter $$1, BlockPos $$2, CollisionContext $$3) {
        return makeShape();
    }

    @Override
    public VoxelShape getInteractionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return makeShape();
    }

    @Override
    public boolean isValidBonemealTarget(@NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull BlockState blockState, boolean b) {
        return false;
    }

    @Override
    public boolean isBonemealSuccess(@NotNull Level level, @NotNull Random random, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return false;
    }

    @Override
    public void entityInside(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Entity pEntity) {
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, @NotNull Level world, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand handIn, @NotNull BlockHitResult hit) {
        ItemStack item = player.getItemInHand(handIn);
        if (item.is(Items.WATER_BUCKET)) {
            player.setItemInHand(handIn, ItemUtils.createFilledResult(item, player, Items.BUCKET.getDefaultInstance()));
            world.setBlockAndUpdate(pos, BYGBlocks.WATER_BARREL_CACTUS.defaultBlockState());
            world.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1, 1);
            world.neighborChanged(pos, BYGBlocks.WATER_BARREL_CACTUS.get(), pos);
            world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            return InteractionResult.SUCCESS;
        }
        if (item.is(Items.HONEY_BOTTLE)) {
            player.setItemInHand(handIn, ItemUtils.createFilledResult(item, player, Items.GLASS_BOTTLE.getDefaultInstance()));
            world.setBlockAndUpdate(pos, BYGBlocks.HONEY_BARREL_CACTUS.defaultBlockState());
            world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1, 1);
            world.neighborChanged(pos, BYGBlocks.HONEY_BARREL_CACTUS.get(), pos);
            world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public boolean isRandomlyTicking(BlockState $$0) {
        return true;
    }

    @Override
    public void randomTick(BlockState $$0, ServerLevel world, BlockPos $$2, Random $$3) {
        super.randomTick($$0, world, $$2, $$3);
        if (world.getLevel().isRaining()){
            world.setBlockAndUpdate($$2, BYGBlocks.WATER_BARREL_CACTUS.defaultBlockState());
            world.gameEvent(null, GameEvent.FLUID_PLACE, $$2);
        }
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, Random pRandom) {
        BlockPos blockpos = PointedDripstoneBlock.findStalactiteTipAboveCauldron(pLevel, pPos);
        if (blockpos != null) {
            Fluid fluid = PointedDripstoneBlock.getCauldronFillFluidType(pLevel, blockpos);
            if (fluid != Fluids.EMPTY && this.canReceiveStalactiteDrip(fluid)) {
                this.receiveStalactiteDrip(pState, pLevel, pPos, fluid);
            }
        }
    }

    @Override
    protected boolean mayPlaceOn(@NotNull BlockState $$0, BlockGetter $$1, BlockPos $$2) {
        return !$$0.getCollisionShape($$1, $$2).getFaceShape(Direction.UP).isEmpty() || $$0.isFaceSturdy($$1, $$2, Direction.UP);
    }

    @Override
    public boolean canSurvive(BlockState $$0, LevelReader $$1, @NotNull BlockPos $$2) {
        BlockPos $$3 = $$2.below();
        return this.mayPlaceOn($$1.getBlockState($$3), $$1, $$3);
    }

    @Override
    public BlockState updateShape(BlockState $$0, Direction $$1, BlockState $$2, LevelAccessor $$3, BlockPos $$4, BlockPos $$5) {
        if (!$$0.canSurvive($$3, $$4)) {
            return Blocks.AIR.defaultBlockState();
        }
        return super.updateShape($$0, $$1, $$2, $$3, $$4, $$5);
    }

    public boolean canReceiveStalactiteDrip(Fluid $$0) {
        return true;
    }

    protected void receiveStalactiteDrip(BlockState $$0, Level $$1, BlockPos $$2, Fluid $$3) {
        if ($$3 == Fluids.WATER) {
            $$1.setBlockAndUpdate($$2, BYGBlocks.WATER_BARREL_CACTUS.defaultBlockState());
            $$1.levelEvent(1047, $$2, 0);
            $$1.gameEvent(null, GameEvent.FLUID_PLACE, $$2);
        }
    }
}
