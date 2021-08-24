package corgiaoc.byg.mixin.common.world.layers;

import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.biome.BYGBiome;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.MixRiverLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings({"deprecation", "ConstantConditions"})
@Mixin(MixRiverLayer.class)
public abstract class MixinRiverLayer {

    @Inject(at = @At("HEAD"), method = "applyPixel", cancellable = true)
    private void injectBYGRivers(INoiseRandom rand, IArea area1, IArea area2, int x, int z, CallbackInfoReturnable<Integer> cir) {
        int area1Value = area1.get(((MixRiverLayer) (Object) this).getParentX(x), ((MixRiverLayer) (Object) this).getParentY(z));
        int area2Value = area2.get(((MixRiverLayer) (Object) this).getParentX(x), ((MixRiverLayer) (Object) this).getParentY(z));

        if (area2Value == WorldGenRegistries.BIOME.getId(WorldGenRegistries.BIOME.getOrThrow(Biomes.RIVER))) {
            ResourceLocation area1Location = BYG.biomeRegistryAccess.getKey(BYG.biomeRegistryAccess.byId(area1Value));

            if (BYGBiome.BIOME_TO_RIVER_LIST.containsKey(area1Location))
                cir.setReturnValue(BYG.biomeRegistryAccess.getId(BYG.biomeRegistryAccess.get(BYGBiome.BIOME_TO_RIVER_LIST.get(area1Location))));
        }
    }
}