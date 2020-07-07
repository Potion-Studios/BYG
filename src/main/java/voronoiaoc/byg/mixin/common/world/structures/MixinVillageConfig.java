package voronoiaoc.byg.mixin.common.world.structures;

import net.minecraft.world.gen.feature.structure.VillagePieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import voronoiaoc.byg.common.world.structure.village.villagepools.*;

@Mixin(VillagePieces.class)
public class MixinVillageConfig {
    @Inject(at = @At("INVOKE"), method = "func_236425_a_", cancellable = true)
    private static void addBYGVillagePools(CallbackInfo ci) {
        BYGAdobeVillagePools.init();
        BYGGrasslandVillagePools.init();
        BYGGuianaVillagePools.init();
        BYGJungleVillagePools.init();
        BYGSkyrisVillagePools.init();
    }
}