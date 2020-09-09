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


    private static final int WARM_OCEAN = WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.func_243576_d(Biomes.WARM_OCEAN));
    private static final int LUKEWARM_OCEAN = WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.func_243576_d(Biomes.LUKEWARM_OCEAN));
    private static final int OCEAN = WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.func_243576_d(Biomes.OCEAN));
    private static final int COLD_OCEAN = WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.func_243576_d(Biomes.COLD_OCEAN));
    private static final int FROZEN_OCEAN = WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.func_243576_d(Biomes.FROZEN_OCEAN));
    private static final int DEEP_WARM_OCEAN = WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.func_243576_d(Biomes.DEEP_WARM_OCEAN));
    private static final int DEEP_LUKEWARM_OCEAN = WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.func_243576_d(Biomes.DEEP_LUKEWARM_OCEAN));
    private static final int DEEP_OCEAN = WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.func_243576_d(Biomes.DEEP_OCEAN));
    private static final int DEEP_COLD_OCEAN = WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.func_243576_d(Biomes.DEEP_COLD_OCEAN));
    private static final int DEEP_FROZEN_OCEAN = WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.func_243576_d(Biomes.DEEP_FROZEN_OCEAN));

    @Inject(at = @At("HEAD"), method = "apply(Lnet/minecraft/world/gen/INoiseRandom;IIIII)I", cancellable = true)
    private void apply(INoiseRandom context, int n, int w, int s, int e, int centre, CallbackInfoReturnable<Integer> cir) {
        final int[] ArrayNESW = {n, w, s, e};
        Biome biome = WorldGenRegistries.field_243657_i.getByValue(centre);

        for (int idx : ArrayNESW) {
            if (biome == BYGBiomeList.ALPS)
                if (idx != WorldGenRegistries.field_243657_i.getId(BYGBiomeList.ALPS))
                    cir.setReturnValue(WorldGenRegistries.field_243657_i.getId(BYGBiomeList.ALPINEFOOTHILLS));

            if (biome == BYGBiomeList.ALPS)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.field_243657_i.getId(BYGBiomeList.SNOWYBLACKBEACH));

            if (biome == BYGBiomeList.DOVERMOUNTAINS)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.field_243657_i.getId(BYGBiomeList.WHITEBEACH));

            if (biome != null && biome.getCategory() == Biome.Category.SWAMP)
                if (isOcean(idx))
                    cir.setReturnValue(centre);

            if (biome != null && biome.getPrecipitation() == Biome.RainType.SNOW && biome.getCategory() != Biome.Category.OCEAN && biome.getCategory() != Biome.Category.BEACH)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.field_243657_i.getId(BYGBiomeList.SNOWYBLACKBEACH));

            if (biome == BYGBiomeList.GRASSLANDPLATEAU)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.field_243657_i.getId(BYGBiomeList.ROCKYBEACH));

            if (biome == BYGBiomeList.TROPICALISLAND)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.field_243657_i.getId(BYGBiomeList.RAINBOWBEACH));

            if (biome == BYGBiomeList.TROPICALRAINFOREST)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.field_243657_i.getId(BYGBiomeList.RAINBOWBEACH));

            if (biome == BYGBiomeList.TROPICALFUNGALRAINFOREST)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.field_243657_i.getId(BYGBiomeList.RAINBOWBEACH));

            if (biome == BYGBiomeList.GUIANASHIELD)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.field_243657_i.getId(BYGBiomeList.ROCKYBEACH));

            if (biome == BYGBiomeList.SKYRISHIGHLANDS)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.field_243657_i.getId(BYGBiomeList.ROCKYBEACH));

            if (biome != null && biome.getDepth() > 2.0F)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.field_243657_i.getId(BYGBiomeList.BASALT_BARRERA));


            if (biome == BYGBiomeList.THE_BLACK_FOREST || biome == BYGBiomeList.BLACK_FOREST_CLEARING || biome == BYGBiomeList.BLACK_FOREST_HILLS || biome == BYGBiomeList.FOREST_FAULT)
                if (isOcean(idx))
                    cir.setReturnValue(WorldGenRegistries.field_243657_i.getId(BYGBiomeList.ROCKYBEACH));
        }
    }

    private static boolean isOcean(int biome) {
        return biome == WARM_OCEAN || biome == LUKEWARM_OCEAN || biome == OCEAN || biome == COLD_OCEAN || biome == FROZEN_OCEAN || biome == DEEP_WARM_OCEAN || biome == DEEP_LUKEWARM_OCEAN || biome == DEEP_OCEAN || biome == DEEP_COLD_OCEAN || biome == DEEP_FROZEN_OCEAN;
    }
}