package potionstudios.byg.mixin.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.common.block.BYGBlockTags;
import potionstudios.byg.common.block.BYGBlocks;

import static net.minecraft.world.level.block.Block.pushEntitiesUp;

@Mixin(FarmBlock.class)
public class MixinFarmBlock {

    // Is there a better way to do this?
    @Inject(method = "turnToDirt", at = @At("RETURN"))
    private static void byg_turnLushToLushDirt(Entity entity, BlockState state, Level level, BlockPos pos, CallbackInfo ci) {
        if (state.is(BYGBlockTags.LUSH)) {
            level.setBlockAndUpdate(pos, pushEntitiesUp(state, BYGBlocks.LUSH_DIRT.defaultBlockState(), level, pos));
        }
    }
}