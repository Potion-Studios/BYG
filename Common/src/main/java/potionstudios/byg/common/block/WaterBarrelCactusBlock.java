package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class WaterBarrelCactusBlock extends AbstractBarrelCactusBlock {

    public WaterBarrelCactusBlock(Properties $$0) {
        super($$0);
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, @NotNull Level worldIn, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand handIn, @NotNull BlockHitResult hit) {

        if (player.getItemInHand(handIn).getItem() == Items.BUCKET) {
            return InteractionResult.PASS;
        }

        worldIn.setBlockAndUpdate(pos, BYGBlocks.CARVED_BARREL_CACTUS.defaultBlockState());
        worldIn.neighborChanged(pos, BYGBlocks.CARVED_BARREL_CACTUS, pos);
        worldIn.gameEvent(null, GameEvent.FLUID_PICKUP, pos);
        return InteractionResult.SUCCESS;
    }
}
