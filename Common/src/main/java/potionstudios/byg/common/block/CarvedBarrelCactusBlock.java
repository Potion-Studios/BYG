package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
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
    public VoxelShape getInteractionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return makeShape();
    }


    @Override
    public @NotNull InteractionResult use(BlockState state, @NotNull Level world, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand handIn, @NotNull BlockHitResult hit) {
        ItemStack item = player.getItemInHand(handIn);
        if (item.is(Items.WATER_BUCKET)) {
            player.setItemInHand(handIn, ItemUtils.createFilledResult(item, player, Items.BUCKET.getDefaultInstance()));
            world.setBlockAndUpdate(pos, BYGBlocks.WATER_BARREL_CACTUS.defaultBlockState());
            world.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1, 1);
            world.neighborChanged(pos, BYGBlocks.WATER_BARREL_CACTUS, pos);
            world.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            return InteractionResult.SUCCESS;
        }
        if (item.is(Items.HONEY_BOTTLE)) {
            player.setItemInHand(handIn, ItemUtils.createFilledResult(item, player, Items.GLASS_BOTTLE.getDefaultInstance()));
            world.setBlockAndUpdate(pos, BYGBlocks.HONEY_BARREL_CACTUS.defaultBlockState());
            world.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1, 1);
            world.neighborChanged(pos, BYGBlocks.HONEY_BARREL_CACTUS, pos);
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
