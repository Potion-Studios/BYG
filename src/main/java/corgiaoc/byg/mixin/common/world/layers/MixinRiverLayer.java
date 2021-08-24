package corgiaoc.byg.mixin.common.world.layers;

import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.biome.BYGBiome;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.newbiome.area.Area;
import net.minecraft.world.level.newbiome.context.Context;
import net.minecraft.world.level.newbiome.layer.RiverMixerLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings({"deprecation", "ConstantConditions"})
@Mixin(RiverMixerLayer.class)
public abstract class MixinRiverLayer {

    @Inject(at = @At("HEAD"), method = "applyPixel", cancellable = true)
    private void injectBYGRivers(Context rand, Area area1, Area area2, int x, int z, CallbackInfoReturnable<Integer> cir) {
        int area1Value = area1.get(((RiverMixerLayer) (Object) this).getParentX(x), ((RiverMixerLayer) (Object) this).getParentY(z));
        int area2Value = area2.get(((RiverMixerLayer) (Object) this).getParentX(x), ((RiverMixerLayer) (Object) this).getParentY(z));

        if (area2Value == BuiltinRegistries.BIOME.getId(BuiltinRegistries.BIOME.getOrThrow(Biomes.RIVER))) {
            ResourceLocation area1Location = BYG.biomeRegistryAccess.getKey(BYG.biomeRegistryAccess.byId(area1Value));

            if (BYGBiome.BIOME_TO_RIVER_LIST.containsKey(area1Location))
                cir.setReturnValue(BYG.biomeRegistryAccess.getId(BYG.biomeRegistryAccess.get(BYGBiome.BIOME_TO_RIVER_LIST.get(area1Location))));
        }
    }
}