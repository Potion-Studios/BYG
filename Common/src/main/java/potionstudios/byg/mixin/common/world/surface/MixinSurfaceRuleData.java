package potionstudios.byg.mixin.common.world.surface;

import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.world.level.levelgen.SurfaceRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import potionstudios.byg.common.world.surfacerules.BYGSurfaceRules;

@Mixin(SurfaceRuleData.class)
public class MixinSurfaceRuleData {

    @Inject(method = "end", at = @At("RETURN"), cancellable = true)
    private static void addBYGEndSurfaceRules(CallbackInfoReturnable<SurfaceRules.RuleSource> cir) {
        cir.setReturnValue(SurfaceRules.sequence(BYGSurfaceRules.END_SURFACE_RULES, cir.getReturnValue()));
    }

    @Inject(method = "nether", at = @At("RETURN"), cancellable = true)
    private static void addBYGNetherSurfaceRules(CallbackInfoReturnable<SurfaceRules.RuleSource> cir) {
        cir.setReturnValue(SurfaceRules.sequence(BYGSurfaceRules.NETHER_SURFACE_RULES, cir.getReturnValue()));
    }
}