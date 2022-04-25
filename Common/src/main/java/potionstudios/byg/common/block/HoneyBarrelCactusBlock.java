package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import static potionstudios.byg.common.block.CarvedBarrelCactusBlock.makeShape;

public class HoneyBarrelCactusBlock extends AbstractBarrelCactusBlock {

    public HoneyBarrelCactusBlock(Properties $$0) {
        super($$0);
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
        if (item.is(Items.GLASS_BOTTLE)) {
            player.setItemInHand(handIn, ItemUtils.createFilledResult(item, player, Items.HONEY_BOTTLE.getDefaultInstance()));
            world.setBlockAndUpdate(pos, BYGBlocks.CARVED_BARREL_CACTUS.defaultBlockState());
            world.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1, 1);
            world.neighborChanged(pos, BYGBlocks.CARVED_BARREL_CACTUS, pos);
            world.gameEvent(null, GameEvent.FLUID_PICKUP, pos);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}