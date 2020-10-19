package corgiaoc.byg.mixin.common.world.layers;

import corgiaoc.byg.common.world.biome.BYGBiome;
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

import javax.annotation.Nullable;

@SuppressWarnings("deprecation")
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
    private void injectBYGEdges(INoiseRandom rand, int n, int w, int s, int e, int centre, CallbackInfoReturnable<Integer> cir) {
        final int[] ArrayNESW = {n, w, s, e};
        Biome biome = WorldGenRegistries.BIOME.getByValue(centre);

        Biome bygEdgeBiome = getEdgeBiomeValue(rand, n, w, s, e, centre);

        if (bygEdgeBiome != null)
            cir.setReturnValue(WorldGenRegistries.BIOME.getId(bygEdgeBiome));

        for (int idx : ArrayNESW) {
            if (biome == BYGBiomes.ALPS)
                if (idx != WorldGenRegistries.BIOME.getId(BYGBiomes.ALPS))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.ALPINE_FOOTHILLS));

            if (biome == BYGBiomes.ALPS)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.SNOWY_BLACK_BEACH));

            if (biome == BYGBiomes.DOVER_MOUNTAINS)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.WHITE_BEACH));

            if (biome != null && biome.getCategory() == Biome.Category.SWAMP)
                if (isOcean(idx))
                    cir.setReturnValue(centre);

            if (biome != null && biome.getPrecipitation() == Biome.RainType.SNOW && biome.getCategory() != Biome.Category.OCEAN && biome.getCategory() != Biome.Category.BEACH)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.SNOWY_BLACK_BEACH));

            if (biome == BYGBiomes.GRASSLAND_PLATEAU)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.ROCKY_BEACH));

            if (biome == BYGBiomes.TROPICAL_ISLAND || biome == BYGBiomes.TROPICAL_ISLAND_MOUNTAINS || biome == BYGBiomes.TROPICAL_ISLAND_CLEARING)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.RAINBOW_BEACH));

            if (biome == BYGBiomes.TROPICAL_FUNGAL_RAINFOREST || biome == BYGBiomes.TROPICAL_FUNGAL_RAINFOREST_HILLS || biome == BYGBiomes.FUNGAL_PATCH)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.RAINBOW_BEACH));

            if (biome == BYGBiomes.GUIANA_SHIELD || biome == BYGBiomes.GUIANA_CLEARING)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.ROCKY_BEACH));

            if (biome == BYGBiomes.SKYRIS_HIGHLANDS)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.ROCKY_BEACH));

            if (biome != null && biome.getDepth() > 2.0F && biome != BYGBiomes.CANYONS && biome != BYGBiomes.CANYON_EDGE)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.BASALT_BARRERA));

            if (biome == BYGBiomes.THE_BLACK_FOREST || biome == BYGBiomes.BLACK_FOREST_CLEARING || biome == BYGBiomes.BLACK_FOREST_HILLS || biome == BYGBiomes.FOREST_FAULT)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.BIOME.getId(BYGBiomes.ROCKY_BEACH));
        }
    }

    private static boolean isOcean(int biome) {
        return biome == WARM_OCEAN || biome == LUKEWARM_OCEAN || biome == OCEAN || biome == COLD_OCEAN || biome == FROZEN_OCEAN || biome == DEEP_WARM_OCEAN || biome == DEEP_LUKEWARM_OCEAN || biome == DEEP_OCEAN || biome == DEEP_COLD_OCEAN || biome == DEEP_FROZEN_OCEAN;
    }

    @Nullable
    private static Biome getEdgeBiomeValue(INoiseRandom rand, int n, int w, int s, int e, int centre) {
        for (BYGBiome bygBiome : BYGBiome.BYG_BIOMES) {
            if (bygBiome.getBiome() == WorldGenRegistries.BIOME.getByValue(centre))
                return bygBiome.getEdges(rand, WorldGenRegistries.BIOME.getByValue(n), WorldGenRegistries.BIOME.getByValue(w), WorldGenRegistries.BIOME.getByValue(s), WorldGenRegistries.BIOME.getByValue(e));
        }
        return null;
    }
}