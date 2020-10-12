package corgiaoc.byg.mixin.common.world.layers;

import corgiaoc.byg.common.world.biome.BYGBiome;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.MixRiverLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;

@Mixin(MixRiverLayer.class)
public abstract class MixinRiverLayer {

    @Inject(at = @At("HEAD"), method = "apply(Lnet/minecraft/world/gen/INoiseRandom;Lnet/minecraft/world/gen/area/IArea;Lnet/minecraft/world/gen/area/IArea;II)I", cancellable = true)
    private void injectBYGRivers(INoiseRandom rand, IArea area1, IArea area2, int x, int z, CallbackInfoReturnable<Integer> cir) {
        int area1Value = area1.getValue(((MixRiverLayer) (Object) this).getOffsetX(x), ((MixRiverLayer) (Object) this).getOffsetZ(z));
        int area2Value = area2.getValue(((MixRiverLayer) (Object) this).getOffsetX(x), ((MixRiverLayer) (Object) this).getOffsetZ(z));

        if (area2Value == WorldGenRegistries.BIOME.getId(WorldGenRegistries.BIOME.getOrThrow(Biomes.RIVER))) {
            Biome biome = getRiverBiomeValue(WorldGenRegistries.BIOME.getByValue(area1Value));
            if (biome != null)
                cir.setReturnValue(WorldGenRegistries.BIOME.getId(biome));
        }
    }
    @Nullable
    private static Biome getRiverBiomeValue(Biome firstLayerBiomeValue) {
        for (BYGBiome bygBiome : BYGBiome.BYG_BIOMES) {
            if (firstLayerBiomeValue == bygBiome.getBiome())
                return bygBiome.getRiver();
        }
        return null;
    }
}