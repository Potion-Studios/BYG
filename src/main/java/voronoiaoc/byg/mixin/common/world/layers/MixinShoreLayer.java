package voronoiaoc.byg.mixin.common.world.layers;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.ShoreLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import voronoiaoc.byg.common.world.worldtype.BYGBiomeGetter;
import voronoiaoc.byg.common.world.worldtype.ClimateBooleans;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

@SuppressWarnings("deprecation")
@Mixin(ShoreLayer.class)
public abstract class MixinShoreLayer {

    @Inject(at = @At("HEAD"), method = "apply(Lnet/minecraft/world/gen/INoiseRandom;IIIII)I", cancellable = true)
    private void apply(INoiseRandom context, int n, int w, int s, int e, int centre, CallbackInfoReturnable<Integer> cir) {
        final int[] ArrayNESW = {n, w, s, e};
        Biome biome = Registry.BIOME.getByValue(centre);

        for (int idx : ArrayNESW) {
            if (biome == BYGBiomeList.ALPS)
                if (idx != Registry.BIOME.getId(BYGBiomeList.ALPS))
                    cir.setReturnValue(Registry.BIOME.getId(BYGBiomeList.ALPINEFOOTHILLS));

            if (biome == BYGBiomeList.ALPS)
                if (ClimateBooleans.isOcean(idx))
                    cir.setReturnValue(BYGBiomeGetter.SNOWYROCKYBLACKBEACH);

            if (biome == BYGBiomeList.DOVERMOUNTAINS)
                if (ClimateBooleans.isOcean(idx))
                    cir.setReturnValue(BYGBiomeGetter.WHITEBEACH);

            if (biome != null && biome.getCategory() == Biome.Category.SWAMP)
                if (ClimateBooleans.isOcean(idx))
                    cir.setReturnValue(centre);

            if (biome != null && biome.getPrecipitation() == Biome.RainType.SNOW && biome.getCategory() != Biome.Category.OCEAN && biome.getCategory() != Biome.Category.BEACH)
                if (ClimateBooleans.isOcean(idx))
                    cir.setReturnValue(BYGBiomeGetter.SNOWYBLACKBEACH);

            if (biome == BYGBiomeList.GRASSLANDPLATEAU)
                if (ClimateBooleans.isOcean(idx))
                    cir.setReturnValue(BYGBiomeGetter.ROCKYBEACH);

            if (biome == BYGBiomeList.TROPICALISLAND)
                if (ClimateBooleans.isOcean(idx))
                    cir.setReturnValue(BYGBiomeGetter.RAINBOWBEACH);

            if (biome == BYGBiomeList.TROPICALRAINFOREST)
                if (ClimateBooleans.isOcean(idx))
                    cir.setReturnValue(BYGBiomeGetter.RAINBOWBEACH);

            if (biome == BYGBiomeList.TROPICALFUNGALRAINFOREST)
                if (ClimateBooleans.isOcean(idx))
                    cir.setReturnValue(BYGBiomeGetter.RAINBOWBEACH);

            if (biome == BYGBiomeList.GUIANASHIELD)
                if (ClimateBooleans.isOcean(idx))
                    cir.setReturnValue(BYGBiomeGetter.ROCKYBEACH);

            if (biome == BYGBiomeList.SKYRISHIGHLANDS)
                if (ClimateBooleans.isOcean(idx))
                    cir.setReturnValue(BYGBiomeGetter.ROCKYBEACH);

            if (biome == BYGBiomeList.THE_BLACK_FOREST || biome == BYGBiomeList.BLACK_FOREST_CLEARING || biome == BYGBiomeList.BLACK_FOREST_HILLS || biome == BYGBiomeList.FOREST_FAULT)
                if (ClimateBooleans.isOcean(idx))
                    cir.setReturnValue(BYGBiomeGetter.ROCKYBEACH);

        }
    }
}