package voronoiaoc.byg.mixin.common;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import voronoiaoc.byg.core.byglists.BYGBlockList;

@Mixin(PlantBlock.class)
public class PlantBlockMixin {
    @Inject(at = @At("RETURN"), method = "canPlantOnTop(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;)Z", cancellable = true)
    private static void isBYGDirt(BlockState floor, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        Block block = floor.getBlock();
        cir.setReturnValue(cir.getReturnValue() || block == BYGBlockList.GLOWCELIUM || block == BYGBlockList.PEAT ||
                block == BYGBlockList.MEADOW_GRASSBLOCK || block == BYGBlockList.OVERGROWN_DACITE || block == BYGBlockList.OVERGROWN_STONE ||
                block == BYGBlockList.PODZOL_DACITE || block == BYGBlockList.OVERGROWN_NETHERRACK || block == BYGBlockList.SYTHIAN_NYLIUM ||
                block == BYGBlockList.IVIS_PHYLIUM);
    }

}
