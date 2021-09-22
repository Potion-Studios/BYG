package corgiaoc.byg.mixin.common.world.layers;

import corgiaoc.byg.BYG;
import corgiaoc.byg.core.world.BYGBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.newbiome.area.Area;
import net.minecraft.world.level.newbiome.context.Context;
import net.minecraft.world.level.newbiome.layer.RiverMixerLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Optional;

@SuppressWarnings({"deprecation", "ConstantConditions"})
@Mixin(RiverMixerLayer.class)
public abstract class MixinRiverLayer {

    @Inject(at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/level/newbiome/area/Area;get(II)I", ordinal = 1), method = "applyPixel", cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
    private void injectBYGRivers(Context rand, Area area1, Area area2, int x, int z, CallbackInfoReturnable<Integer> cir, int area1Value, int area2Value) {
        if (area2Value == BYG.biomeRegistryAccess.getId(BYG.biomeRegistryAccess.getOrThrow(Biomes.RIVER))) {
            Optional<ResourceKey<Biome>> optionalResourceKey = BYG.biomeRegistryAccess.getResourceKey(BYG.biomeRegistryAccess.byId(area1Value));
            if (optionalResourceKey.isEmpty()) {
                return;
            }
            ResourceKey<Biome> area1ResourceKey = optionalResourceKey.get();

            if (BYGBiomes.OVERWORLD_RIVERS.containsKey(area1ResourceKey))
                cir.setReturnValue(BYG.biomeRegistryAccess.getId(BYG.biomeRegistryAccess.get(BYGBiomes.OVERWORLD_RIVERS.get(area1ResourceKey))));
        }
    }
}