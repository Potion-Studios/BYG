package corgiaoc.byg.mixin.common.world.layers;

import corgiaoc.byg.core.world.BYGBiomes;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.ShoreLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

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
            if (biome == BYGBiomes.ALPS)
                if (idx != WorldGenRegistries.BIOME.getId(BYGBiomes.ALPS))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.ALPINEFOOTHILLS));

            if (biome == BYGBiomes.ALPS)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.SNOWYBLACKBEACH));

            if (biome == BYGBiomes.DOVERMOUNTAINS)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.WHITEBEACH));

            if (biome != null && biome.getCategory() == Biome.Category.SWAMP)
                if (isOcean(idx))
                    cir.setReturnValue(centre);

            if (biome != null && biome.getPrecipitation() == Biome.RainType.SNOW && biome.getCategory() != Biome.Category.OCEAN && biome.getCategory() != Biome.Category.BEACH)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.SNOWYBLACKBEACH));

            if (biome == BYGBiomes.GRASSLANDPLATEAU)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.ROCKYBEACH));

            if (biome == BYGBiomes.TROPICALISLAND || biome == BYGBiomes.TROPICAL_ISLAND_MOUNTAINS || biome == BYGBiomes.TROPICAL_ISLAND_CLEARING)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.RAINBOWBEACH));

            if (biome == BYGBiomes.TROPICALRAINFOREST || biome == BYGBiomes.TROPICALRAINFORESTHILLS)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.RAINBOWBEACH));

            if (biome == BYGBiomes.TROPICALFUNGALRAINFOREST || biome == BYGBiomes.TROPICALFUNGALRAINFORESTHILLS || biome == BYGBiomes.FUNGAL_PATCH)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.RAINBOWBEACH));

            if (biome == BYGBiomes.GUIANASHIELD || biome == BYGBiomes.GUIANA_CLEARING)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.ROCKYBEACH));

            if (biome == BYGBiomes.SKYRISHIGHLANDS)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.ROCKYBEACH));

            if (biome != null && biome.getDepth() > 2.0F)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.BASALT_BARRERA));


            if (biome == BYGBiomes.THE_BLACK_FOREST || biome == BYGBiomes.BLACK_FOREST_CLEARING || biome == BYGBiomes.BLACK_FOREST_HILLS || biome == BYGBiomes.FOREST_FAULT)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.ROCKYBEACH));
        }
    }

    private static boolean isOcean(int biome) {
        return biome == WARM_OCEAN || biome == LUKEWARM_OCEAN || biome == OCEAN || biome == COLD_OCEAN || biome == FROZEN_OCEAN || biome == DEEP_WARM_OCEAN || biome == DEEP_LUKEWARM_OCEAN || biome == DEEP_OCEAN || biome == DEEP_COLD_OCEAN || biome == DEEP_FROZEN_OCEAN;
    }



}