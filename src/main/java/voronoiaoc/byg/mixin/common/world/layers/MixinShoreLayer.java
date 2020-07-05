package voronoiaoc.byg.mixin.common.world.layers;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.ShoreLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import voronoiaoc.byg.common.world.worldtype.BYGBiomeGetter;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

@SuppressWarnings("deprecation")
@Mixin(ShoreLayer.class)
public abstract class MixinShoreLayer {

    private static final int WARM_OCEAN = Registry.BIOME.getId(Biomes.WARM_OCEAN);
    private static final int LUKEWARM_OCEAN = Registry.BIOME.getId(Biomes.LUKEWARM_OCEAN);
    private static final int OCEAN = Registry.BIOME.getId(Biomes.OCEAN);
    private static final int COLD_OCEAN = Registry.BIOME.getId(Biomes.COLD_OCEAN);
    private static final int FROZEN_OCEAN = Registry.BIOME.getId(Biomes.FROZEN_OCEAN);
    private static final int DEEP_WARM_OCEAN = Registry.BIOME.getId(Biomes.DEEP_WARM_OCEAN);
    private static final int DEEP_LUKEWARM_OCEAN = Registry.BIOME.getId(Biomes.DEEP_LUKEWARM_OCEAN);
    private static final int DEEP_OCEAN = Registry.BIOME.getId(Biomes.DEEP_OCEAN);
    private static final int DEEP_COLD_OCEAN = Registry.BIOME.getId(Biomes.DEEP_COLD_OCEAN);
    private static final int DEEP_FROZEN_OCEAN = Registry.BIOME.getId(Biomes.DEEP_FROZEN_OCEAN);

    @Inject(at = @At("HEAD"), method = "apply(Lnet/minecraft/world/gen/INoiseRandom;IIIII)I", cancellable = true)
    private void apply(INoiseRandom context, int n, int w, int s, int e, int centre, CallbackInfoReturnable<Integer> cir) {
        final int[] ArrayNESW = {n, w, s, e};
        Biome biome = Registry.BIOME.getByValue(centre);

        for (int idx : ArrayNESW) {
            if (biome == BYGBiomeList.ALPS)
                if (idx != Registry.BIOME.getId(BYGBiomeList.ALPS))
                    cir.setReturnValue(Registry.BIOME.getId(BYGBiomeList.ALPINEFOOTHILLS));

            if (biome == BYGBiomeList.ALPS)
                if (isOcean(idx))
                    cir.setReturnValue(BYGBiomeGetter.SNOWYROCKYBLACKBEACH);

            if (biome == BYGBiomeList.DOVERMOUNTAINS)
                if (isOcean(idx))
                    cir.setReturnValue(BYGBiomeGetter.WHITEBEACH);

            if (biome != null && biome.getCategory() == Biome.Category.SWAMP)
                if (isOcean(idx))
                    cir.setReturnValue(centre);

            if (biome != null && biome.getPrecipitation() == Biome.RainType.SNOW && biome.getCategory() != Biome.Category.OCEAN && biome.getCategory() != Biome.Category.BEACH)
                if (isOcean(idx))
                    cir.setReturnValue(BYGBiomeGetter.SNOWYBLACKBEACH);

            if (biome == BYGBiomeList.GRASSLANDPLATEAU)
                if (isOcean(idx))
                    cir.setReturnValue(BYGBiomeGetter.ROCKYBEACH);

            if (biome == BYGBiomeList.TROPICALISLAND)
                if (isOcean(idx))
                    cir.setReturnValue(BYGBiomeGetter.RAINBOWBEACH);

            if (biome == BYGBiomeList.TROPICALRAINFOREST)
                if (isOcean(idx))
                    cir.setReturnValue(BYGBiomeGetter.RAINBOWBEACH);

            if (biome == BYGBiomeList.TROPICALFUNGALRAINFOREST)
                if (isOcean(idx))
                    cir.setReturnValue(BYGBiomeGetter.RAINBOWBEACH);

            if (biome == BYGBiomeList.GUIANASHIELD)
                if (isOcean(idx))
                    cir.setReturnValue(BYGBiomeGetter.ROCKYBEACH);

            if (biome == BYGBiomeList.SKYRISHIGHLANDS)
                if (isOcean(idx))
                    cir.setReturnValue(BYGBiomeGetter.ROCKYBEACH);

            if (biome == BYGBiomeList.THE_BLACK_FOREST || biome == BYGBiomeList.BLACK_FOREST_CLEARING || biome == BYGBiomeList.BLACK_FOREST_HILLS || biome == BYGBiomeList.FOREST_FAULT)
                if (isOcean(idx))
                    cir.setReturnValue(BYGBiomeGetter.ROCKYBEACH);

        }
    }

    private static boolean isOcean(int biome) {
        return biome == WARM_OCEAN || biome == LUKEWARM_OCEAN || biome == OCEAN || biome == COLD_OCEAN || biome == FROZEN_OCEAN || biome == DEEP_WARM_OCEAN || biome == DEEP_LUKEWARM_OCEAN || biome == DEEP_OCEAN || biome == DEEP_COLD_OCEAN || biome == DEEP_FROZEN_OCEAN;
    }
}