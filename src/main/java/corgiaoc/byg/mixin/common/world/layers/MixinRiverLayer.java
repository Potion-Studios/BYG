package corgiaoc.byg.mixin.common.world.layers;

import corgiaoc.byg.core.world.BYGBiomes;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.MixRiverLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MixRiverLayer.class)
public abstract class MixinRiverLayer {

    @Inject(at = @At("HEAD"), method = "apply(Lnet/minecraft/world/gen/INoiseRandom;Lnet/minecraft/world/gen/area/IArea;Lnet/minecraft/world/gen/area/IArea;II)I", cancellable = true)
    private void addModdedRivers(INoiseRandom rand, IArea area1, IArea area2, int x, int z, CallbackInfoReturnable<Integer> cir) {
        int i = area1.getValue(((MixRiverLayer) (Object) this).getOffsetX(x), ((MixRiverLayer) (Object) this).getOffsetZ(z));
        int j = area2.getValue(((MixRiverLayer) (Object) this).getOffsetX(x), ((MixRiverLayer) (Object) this).getOffsetZ(z));

        if (j == WorldGenRegistries.BIOME.getId(WorldGenRegistries.BIOME.getOrThrow(Biomes.RIVER))) {
            if (i == WorldGenRegistries.BIOME.getId(BYGBiomes.CANYONS))
                cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.CANYONS));
            else if (i == WorldGenRegistries.BIOME.getId(BYGBiomes.CANYON_EDGE))
                cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.CANYON_EDGE));
        }
    }
}
