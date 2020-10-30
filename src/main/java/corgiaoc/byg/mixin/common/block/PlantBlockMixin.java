package corgiaoc.byg.mixin.common.block;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlantBlock.class)
public class PlantBlockMixin {
    @Inject(at = @At("RETURN"), method = "canPlantOnTop(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;)Z", cancellable = true)
    private void isBYGDirt(BlockState floor, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        Block block = floor.getBlock();
        if (block == BYGBlocks.GLOWCELIUM || block == BYGBlocks.PEAT ||
                block == BYGBlocks.MEADOW_GRASSBLOCK || block == BYGBlocks.OVERGROWN_DACITE || block == BYGBlocks.OVERGROWN_STONE ||
                block == BYGBlocks.PODZOL_DACITE || block == BYGBlocks.OVERGROWN_NETHERRACK || block == BYGBlocks.SYTHIAN_NYLIUM ||
                block == BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE || block == BYGBlocks.ETHER_PHYLIUM || block == BYGBlocks.ETHER_SOIL || block == BYGBlocks.NIGHTSHADE_PHYLIUM) {
            cir.setReturnValue(true);
        }
    }
}