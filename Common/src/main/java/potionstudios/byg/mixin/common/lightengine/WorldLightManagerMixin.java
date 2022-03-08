package potionstudios.byg.mixin.common.lightengine;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.lighting.LevelLightEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * This fixes a bug in the Minecraft light-update code that runs after world-generation for
 * {@link net.minecraft.world.level.chunk.ProtoChunk }If a chunk-section contains a light-emitting block, and we clear the
 * entire chunk-section (i.e. as part of meteorite worldgen), the lighting-update will assume that the chunk section
 * exists when it runs through {@link LevelLightEngine#onBlockEmissionIncrease(net.minecraft.core.BlockPos, int)},
 * even though the light-level is now 0 for the block.
 * This mixin will cancel the now useless block-update and prevent the crash from occurring.
 * See: https://github.com/AppliedEnergistics/Applied-Energistics-2/issues/4891
 *
 * Code taken from the following PR in Applied Energistics 2 w/ allowed permission(clarified here aswell): https://github.com/AppliedEnergistics/Applied-Energistics-2/pull/4935
 *
 */
@Mixin(LevelLightEngine.class)
public class WorldLightManagerMixin {
    @Inject(method = "onBlockEmissionIncrease", at = @At("HEAD"), cancellable = true)
    public void onBlockEmissionIncrease(BlockPos blockPos, int lightLevel, CallbackInfo ci) {
        if (lightLevel == 0) {
            ci.cancel();
        }
    }
}