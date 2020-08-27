package voronoiaoc.byg.mixin.common;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import voronoiaoc.byg.core.byglists.BYGBlockList;

@Mixin(BushBlock.class)
public class PlantBlockMixin {
    @Inject(at = @At("RETURN"), method = "mayPlaceOn(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)Z", cancellable = true)
    private void isBYGDirt(BlockState floor, BlockGetter world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        Block block = floor.getBlock();
        if (block == BYGBlockList.GLOWCELIUM || block == BYGBlockList.PEAT ||
                block == BYGBlockList.MEADOW_GRASSBLOCK || block == BYGBlockList.OVERGROWN_DACITE || block == BYGBlockList.OVERGROWN_STONE ||
                block == BYGBlockList.PODZOL_DACITE || block == BYGBlockList.OVERGROWN_NETHERRACK || block == BYGBlockList.SYTHIAN_NYLIUM ||
                block == BYGBlockList.IVIS_PHYLIUM) {
            cir.setReturnValue(true);
        }
    }
}