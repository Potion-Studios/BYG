package voronoiaoc.byg.mixin.common.world.layers;

import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.ShoreLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

@Mixin(ShoreLayer.class)
public abstract class MixinShoreLayer {


    private static final int WARM_OCEAN = WorldGenRegistries.BIOME.getId(WorldGenRegistries.BIOME.getOrThrow(Biomes.WARM_OCEAN));
    private static final int LUKEWARM_OCEAN = WorldGenRegistries.BIOME.getId(WorldGenRegistries.BIOME.getOrThrow(Biomes.LUKEWARM_OCEAN));
    private static final int OCEAN = WorldGenRegistries.BIOME.getId(WorldGenRegistries.BIOME.getOrThrow(Biomes.OCEAN));
    private static final int COLD_OCEAN = WorldGenRegistries.BIOME.getId(WorldGenRegistries.BIOME.getOrThrow(Biomes.COLD_OCEAN));
    private static final int FROZEN_OCEAN = WorldGenRegistries.BIOME.getId(WorldGenRegistries.BIOME.getOrThrow(Biomes.FROZEN_OCEAN));
    private static final int DEEP_WARM_OCEAN = WorldGenRegistries.BIOME.getId(WorldGenRegistries.BIOME.getOrThrow(Biomes.DEEP_WARM_OCEAN));
    private static final int DEEP_LUKEWARM_OCEAN = WorldGenRegistries.BIOME.getId(WorldGenRegistries.BIOME.getOrThrow(Biomes.DEEP_LUKEWARM_OCEAN));
    private static final int DEEP_OCEAN = WorldGenRegistries.BIOME.getId(WorldGenRegistries.BIOME.getOrThrow(Biomes.DEEP_OCEAN));
    private static final int DEEP_COLD_OCEAN = WorldGenRegistries.BIOME.getId(WorldGenRegistries.BIOME.getOrThrow(Biomes.DEEP_COLD_OCEAN));
    private static final int DEEP_FROZEN_OCEAN = WorldGenRegistries.BIOME.getId(WorldGenRegistries.BIOME.getOrThrow(Biomes.DEEP_FROZEN_OCEAN));

    @Inject(at = @At("HEAD"), method = "apply(Lnet/minecraft/world/gen/INoiseRandom;IIIII)I", cancellable = true)
    private void apply(INoiseRandom context, int n, int w, int s, int e, int centre, CallbackInfoReturnable<Integer> cir) {
        final int[] ArrayNESW = {n, w, s, e};
        Biome biome = WorldGenRegistries.BIOME.getByValue(centre);

        for (int idx : ArrayNESW) {
            if (biome == BYGBiomeList.ALPS)
                if (idx != WorldGenRegistries.BIOME.getId(BYGBiomeList.ALPS))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomeList.ALPINEFOOTHILLS));

            if (biome == BYGBiomeList.ALPS)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomeList.SNOWYBLACKBEACH));

            if (biome == BYGBiomeList.DOVERMOUNTAINS)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomeList.WHITEBEACH));

            if (biome != null && biome.getCategory() == Biome.Category.SWAMP)
                if (isOcean(idx))
                    cir.setReturnValue(centre);

            if (biome != null && biome.getPrecipitation() == Biome.RainType.SNOW && biome.getCategory() != Biome.Category.OCEAN && biome.getCategory() != Biome.Category.BEACH)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomeList.SNOWYBLACKBEACH));

            if (biome == BYGBiomeList.GRASSLANDPLATEAU)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomeList.ROCKYBEACH));

            if (biome == BYGBiomeList.TROPICALISLAND || biome == BYGBiomeList.TROPICAL_ISLAND_MOUNTAINS || biome == BYGBiomeList.TROPICAL_ISLAND_CLEARING)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomeList.RAINBOWBEACH));

            if (biome == BYGBiomeList.TROPICALRAINFOREST || biome == BYGBiomeList.TROPICALRAINFORESTHILLS)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomeList.RAINBOWBEACH));

            if (biome == BYGBiomeList.TROPICALFUNGALRAINFOREST || biome == BYGBiomeList.TROPICALFUNGALRAINFORESTHILLS || biome == BYGBiomeList.FUNGAL_PATCH)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomeList.RAINBOWBEACH));

            if (biome == BYGBiomeList.GUIANASHIELD || biome == BYGBiomeList.GUIANA_CLEARING)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomeList.ROCKYBEACH));

            if (biome == BYGBiomeList.SKYRISHIGHLANDS)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomeList.ROCKYBEACH));

            if (biome != null && biome.getDepth() > 2.0F)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomeList.BASALT_BARRERA));


            if (biome == BYGBiomeList.THE_BLACK_FOREST || biome == BYGBiomeList.BLACK_FOREST_CLEARING || biome == BYGBiomeList.BLACK_FOREST_HILLS || biome == BYGBiomeList.FOREST_FAULT)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomeList.ROCKYBEACH));
        }
    }

    private static boolean isOcean(int biome) {
        return biome == WARM_OCEAN || biome == LUKEWARM_OCEAN || biome == OCEAN || biome == COLD_OCEAN || biome == FROZEN_OCEAN || biome == DEEP_WARM_OCEAN || biome == DEEP_LUKEWARM_OCEAN || biome == DEEP_OCEAN || biome == DEEP_COLD_OCEAN || biome == DEEP_FROZEN_OCEAN;
    }
}