package voronoiaoc.byg.mixin.common.world.layers;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.EndBiomeProvider;
import net.minecraft.world.gen.SimplexNoiseGenerator;
import net.minecraft.world.gen.layer.Layer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import voronoiaoc.byg.common.world.dimension.end.biome.BYGEndLayerProvider;

import static net.minecraft.world.biome.provider.EndBiomeProvider.func_235317_a_;

@Mixin(EndBiomeProvider.class)
public class MixinTheEndBiomeProvider {
    @Final
    @Shadow
    private long field_235315_h_;

    @Final
    @Shadow
    private  SimplexNoiseGenerator generator;

    @Inject(at = @At("RETURN"), method = "getNoiseBiome(III)Lnet/minecraft/world/biome/Biome;", cancellable = true)
    private void endBP(int x, int y, int z, CallbackInfoReturnable<Biome> cir) {
        Layer layer = BYGEndLayerProvider.stackLayers(this.field_235315_h_);
        int i = x >> 2;
        int j = z >> 2;
        if ((long)i * (long)i + (long)j * (long)j <= 4096L) {
            cir.setReturnValue(Biomes.THE_END);
        } else {
            float f = func_235317_a_(this.generator, i * 2 + 1, j * 2 + 1);
            if (f > 40.0F) {
                cir.setReturnValue(Biomes.END_HIGHLANDS);
            } else {
                cir.setReturnValue(layer.func_215738_a(x, z));

            }
        }
    }
}
