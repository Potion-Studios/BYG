package corgiaoc.byg.mixin.common;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.pathfinding.WalkNodeProcessor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(WalkNodeProcessor.class)
public class MixinWalkNodeProcessor {

    @Inject(method = "isBurningBlock", at = @At("HEAD"), cancellable = true)
    private static void byg_isBurningBlock(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (state.getBlock() == BYGBlocks.FROST_MAGMA) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "getBlockPathTypeRaw", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;is(Lnet/minecraft/block/Block;)Z", ordinal = 0), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
    private static void avoidQuartzCrystals(IBlockReader world, BlockPos pos, CallbackInfoReturnable<PathNodeType> cir, BlockState blockstate, PathNodeType type, Block block, Material material) {
        if (blockstate.is(BYGBlocks.QUARTZ_CRYSTAL)) {
            cir.setReturnValue(PathNodeType.DAMAGE_OTHER);
        }
    }
}
