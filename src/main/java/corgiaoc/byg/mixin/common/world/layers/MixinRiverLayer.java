package corgiaoc.byg.mixin.common.world.layers;

import corgiaoc.byg.common.world.biome.BYGBiome;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.layer.AddRiversLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;
import net.minecraft.world.biome.layer.util.LayerSampler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings("deprecation")
@Mixin(AddRiversLayer.class)
public abstract class MixinRiverLayer {

    @Inject(at = @At("HEAD"), method = "sample(Lnet/minecraft/world/biome/layer/util/LayerRandomnessSource;Lnet/minecraft/world/biome/layer/util/LayerSampler;Lnet/minecraft/world/biome/layer/util/LayerSampler;II)I", cancellable = true)
    private void injectBYGRivers(LayerRandomnessSource rand, LayerSampler area1, LayerSampler area2, int x, int z, CallbackInfoReturnable<Integer> cir) {
        int area1Value = area1.sample(((AddRiversLayer) (Object) this).transformX(x), ((AddRiversLayer) (Object) this).transformZ(z));
        int area2Value = area2.sample(((AddRiversLayer) (Object) this).transformX(x), ((AddRiversLayer) (Object) this).transformZ(z));

        if (area2Value == BuiltinRegistries.BIOME.getRawId(BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.RIVER))) {
            if (BYGBiome.BIOME_TO_RIVER_LIST.containsKey(area1Value))
                cir.setReturnValue(BuiltinRegistries.BIOME.getRawId(BYGBiome.BIOME_TO_RIVER_LIST.get(area1Value)));
        }
    }
}