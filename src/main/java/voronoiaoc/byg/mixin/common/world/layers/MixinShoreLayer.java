package voronoiaoc.byg.mixin.common.world.layers;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.ShoreLayer;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

@Mixin(ShoreLayer.class)
public abstract class MixinShoreLayer {
    private static final ForgeRegistry<Biome> BIOME_REGISTRY = ((ForgeRegistry<Biome>) ForgeRegistries.BIOMES);


    private static final int WARM_OCEAN = BIOME_REGISTRY.getID(BIOME_REGISTRY.getValue(Biomes.WARM_OCEAN.func_240901_a_()));
    private static final int LUKEWARM_OCEAN = BIOME_REGISTRY.getID(BIOME_REGISTRY.getValue(Biomes.LUKEWARM_OCEAN.func_240901_a_()));
    private static final int OCEAN = BIOME_REGISTRY.getID(BIOME_REGISTRY.getValue(Biomes.OCEAN.func_240901_a_()));
    private static final int COLD_OCEAN = BIOME_REGISTRY.getID(BIOME_REGISTRY.getValue(Biomes.COLD_OCEAN.func_240901_a_()));
    private static final int FROZEN_OCEAN = BIOME_REGISTRY.getID(BIOME_REGISTRY.getValue(Biomes.FROZEN_OCEAN.func_240901_a_()));
    private static final int DEEP_WARM_OCEAN = BIOME_REGISTRY.getID(BIOME_REGISTRY.getValue(Biomes.DEEP_WARM_OCEAN.func_240901_a_()));
    private static final int DEEP_LUKEWARM_OCEAN = BIOME_REGISTRY.getID(BIOME_REGISTRY.getValue(Biomes.DEEP_LUKEWARM_OCEAN.func_240901_a_()));
    private static final int DEEP_OCEAN = BIOME_REGISTRY.getID(BIOME_REGISTRY.getValue(Biomes.DEEP_OCEAN.func_240901_a_()));
    private static final int DEEP_COLD_OCEAN = BIOME_REGISTRY.getID(BIOME_REGISTRY.getValue(Biomes.DEEP_COLD_OCEAN.func_240901_a_()));
    private static final int DEEP_FROZEN_OCEAN = BIOME_REGISTRY.getID(BIOME_REGISTRY.getValue(Biomes.DEEP_FROZEN_OCEAN.func_240901_a_()));

    @Inject(at = @At("HEAD"), method = "apply(Lnet/minecraft/world/gen/INoiseRandom;IIIII)I", cancellable = true)
    private void apply(INoiseRandom context, int n, int w, int s, int e, int centre, CallbackInfoReturnable<Integer> cir) {
        final int[] ArrayNESW = {n, w, s, e};
        Biome biome = BIOME_REGISTRY.getValue(centre);

        for (int idx : ArrayNESW) {
            if (biome == BYGBiomeList.ALPS)
                if (idx != BIOME_REGISTRY.getID(BYGBiomeList.ALPS))
                    cir.setReturnValue(BIOME_REGISTRY.getID(BYGBiomeList.ALPINEFOOTHILLS));

            if (biome == BYGBiomeList.ALPS)
                if (isOcean(idx))
                    cir.setReturnValue(BIOME_REGISTRY.getID(BYGBiomeList.SNOWYBLACKBEACH));

            if (biome == BYGBiomeList.DOVERMOUNTAINS)
                if (isOcean(idx))
                    cir.setReturnValue(BIOME_REGISTRY.getID(BYGBiomeList.WHITEBEACH));

            if (biome != null && biome.getCategory() == Biome.Category.SWAMP)
                if (isOcean(idx))
                    cir.setReturnValue(centre);

            if (biome != null && biome.getPrecipitation() == Biome.RainType.SNOW && biome.getCategory() != Biome.Category.OCEAN && biome.getCategory() != Biome.Category.BEACH)
                if (isOcean(idx))
                    cir.setReturnValue(BIOME_REGISTRY.getID(BYGBiomeList.SNOWYBLACKBEACH));

            if (biome == BYGBiomeList.GRASSLANDPLATEAU)
                if (isOcean(idx))
                    cir.setReturnValue(BIOME_REGISTRY.getID(BYGBiomeList.ROCKYBEACH));

//            if (biome == BYGBiomeList.TROPICALISLAND || biome == BYGBiomeList.TROPICAL_ISLAND_MOUNTAINS || biome == BYGBiomeList.TROPICAL_ISLAND_CLEARING)
//                if (isOcean(idx))
//                    cir.setReturnValue(BIOME_REGISTRY.getID(BYGBiomeList.RAINBOWBEACH));

            if (biome == BYGBiomeList.TROPICALRAINFOREST || biome == BYGBiomeList.TROPICALRAINFORESTHILLS)
                if (isOcean(idx))
                    cir.setReturnValue(BIOME_REGISTRY.getID(BYGBiomeList.RAINBOWBEACH));

            if (biome == BYGBiomeList.TROPICALFUNGALRAINFOREST || biome == BYGBiomeList.TROPICALFUNGALRAINFORESTHILLS || biome == BYGBiomeList.FUNGAL_PATCH)
                if (isOcean(idx))
                    cir.setReturnValue(BIOME_REGISTRY.getID(BYGBiomeList.RAINBOWBEACH));

            if (biome == BYGBiomeList.GUIANASHIELD || biome == BYGBiomeList.GUIANA_CLEARING)
                if (isOcean(idx))
                    cir.setReturnValue(BIOME_REGISTRY.getID(BYGBiomeList.ROCKYBEACH));

            if (biome == BYGBiomeList.SKYRISHIGHLANDS)
                if (isOcean(idx))
                    cir.setReturnValue(BIOME_REGISTRY.getID(BYGBiomeList.ROCKYBEACH));

//            if (biome != null && biome.getDepth() > 2.0F)
//                if (isOcean(idx))
//                    cir.setReturnValue(BIOME_REGISTRY.getID(BYGBiomeList.BASALT_BARRERA));


            if (biome == BYGBiomeList.THE_BLACK_FOREST || biome == BYGBiomeList.BLACK_FOREST_CLEARING || biome == BYGBiomeList.BLACK_FOREST_HILLS || biome == BYGBiomeList.FOREST_FAULT)
                if (isOcean(idx))
                    cir.setReturnValue(BIOME_REGISTRY.getID(BYGBiomeList.ROCKYBEACH));
        }
    }

    private static boolean isOcean(int biome) {
        return biome == WARM_OCEAN || biome == LUKEWARM_OCEAN || biome == OCEAN || biome == COLD_OCEAN || biome == FROZEN_OCEAN || biome == DEEP_WARM_OCEAN || biome == DEEP_LUKEWARM_OCEAN || biome == DEEP_OCEAN || biome == DEEP_COLD_OCEAN || biome == DEEP_FROZEN_OCEAN;
    }
}