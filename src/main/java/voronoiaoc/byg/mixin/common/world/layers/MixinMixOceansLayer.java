package voronoiaoc.byg.mixin.common.world.layers;

import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.MixOceansLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(MixOceansLayer.class)
public class MixinMixOceansLayer {

    @Inject(method = "apply(Lnet/minecraft/world/gen/INoiseRandom;Lnet/minecraft/world/gen/area/IArea;Lnet/minecraft/world/gen/area/IArea;II)I",
            at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/gen/area/IArea;getValue(II)I"),
            cancellable = true,
            locals = LocalCapture.CAPTURE_FAILHARD)
     private void injectBYGOceans(INoiseRandom rand, IArea area1, IArea area2, int x, int z, CallbackInfoReturnable<Integer> cir, int i, int j, int k, int l, int i1, int j1, int k1) {
        if (j == WorldGenRegistries.BIOME.getId(WorldGenRegistries.BIOME.getValueForKey(Biomes.OCEAN))) {
            cir.setReturnValue(127);
        }
    }
}
