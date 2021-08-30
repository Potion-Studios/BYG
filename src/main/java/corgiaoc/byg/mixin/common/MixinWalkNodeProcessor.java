package corgiaoc.byg.mixin.common;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(WalkNodeEvaluator.class)
public class MixinWalkNodeProcessor {

    @Inject(method = "isBurningBlock", at = @At("HEAD"), cancellable = true)
    private static void byg_isBurningBlock(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (state.getBlock() == BYGBlocks.FROST_MAGMA) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "getBlockPathTypeRaw", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z", ordinal = 0), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
    private static void avoidQuartzCrystals(BlockGetter blockGetter, BlockPos blockPos, CallbackInfoReturnable<BlockPathTypes> cir, BlockState blockstate, Block block, Material material) {
        if (blockstate.is(BYGBlocks.QUARTZ_CRYSTAL)) {
            cir.setReturnValue(BlockPathTypes.DAMAGE_OTHER);
        }
    }
}
