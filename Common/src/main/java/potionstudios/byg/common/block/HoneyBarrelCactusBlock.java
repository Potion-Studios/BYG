package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class HoneyBarrelCactusBlock extends AbstractBarrelCactusBlock {

    public HoneyBarrelCactusBlock(Properties $$0) {
        super($$0);
    }


    public static VoxelShape makeShape() {
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
    public boolean isValidBonemealTarget(@NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull BlockState blockState, boolean b) {
        return false;
    }

    @Override
    public boolean isBonemealSuccess(@NotNull Level level, @NotNull RandomSource random, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return false;
    }

    @Override
    public void entityInside(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Entity pEntity) {
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

    @Override
    public VoxelShape getInteractionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return makeShape();
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, @NotNull Level world, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand handIn, @NotNull BlockHitResult hit) {
        ItemStack item = player.getItemInHand(handIn);
        if (item.is(Items.GLASS_BOTTLE)) {
            player.setItemInHand(handIn, ItemUtils.createFilledResult(item, player, Items.HONEY_BOTTLE.getDefaultInstance()));
            world.setBlockAndUpdate(pos, BYGBlocks.CARVED_BARREL_CACTUS.defaultBlockState());
            world.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1, 1);
            world.neighborChanged(pos, BYGBlocks.CARVED_BARREL_CACTUS.get(), pos);
            world.gameEvent(null, GameEvent.FLUID_PICKUP, pos);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}