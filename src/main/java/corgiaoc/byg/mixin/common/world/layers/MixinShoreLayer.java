package corgiaoc.byg.mixin.common.world.layers;

import corgiaoc.byg.common.world.biome.BYGBiome;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.layer.AddEdgeBiomesLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings("deprecation")
@Mixin(AddEdgeBiomesLayer.class)
public abstract class MixinShoreLayer {


    private static final int WARM_OCEAN = BuiltinRegistries.BIOME.getRawId(BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.WARM_OCEAN));
    private static final int LUKEWARM_OCEAN = BuiltinRegistries.BIOME.getRawId(BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.LUKEWARM_OCEAN));
    private static final int OCEAN = BuiltinRegistries.BIOME.getRawId(BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.OCEAN));
    private static final int COLD_OCEAN = BuiltinRegistries.BIOME.getRawId(BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.COLD_OCEAN));
    private static final int FROZEN_OCEAN = BuiltinRegistries.BIOME.getRawId(BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.FROZEN_OCEAN));
    private static final int DEEP_WARM_OCEAN = BuiltinRegistries.BIOME.getRawId(BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.DEEP_WARM_OCEAN));
    private static final int DEEP_LUKEWARM_OCEAN = BuiltinRegistries.BIOME.getRawId(BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.DEEP_LUKEWARM_OCEAN));
    private static final int DEEP_OCEAN = BuiltinRegistries.BIOME.getRawId(BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.DEEP_OCEAN));
    private static final int DEEP_COLD_OCEAN = BuiltinRegistries.BIOME.getRawId(BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.DEEP_COLD_OCEAN));
    private static final int DEEP_FROZEN_OCEAN = BuiltinRegistries.BIOME.getRawId(BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.DEEP_FROZEN_OCEAN));


    @Inject(at = @At("HEAD"), method = "sample(Lnet/minecraft/world/biome/layer/util/LayerRandomnessSource;IIIII)I", cancellable = true)
    private void injectBYGEdges(LayerRandomnessSource rand, int n, int w, int s, int e, int centre, CallbackInfoReturnable<Integer> cir) {
        final int[] ArrayNESW = {n, w, s, e};

        for (int idx : ArrayNESW) {
            if (BYGBiome.BIOME_TO_EDGE_LIST.containsKey(centre))
                if (!isEdgeCompatible(idx))
                    cir.setReturnValue(BuiltinRegistries.BIOME.getRawId(BYGBiome.BIOME_TO_EDGE_LIST.get(centre)));

            if (BYGBiome.BIOME_TO_BEACH_LIST.containsKey(centre)) {
                if (isOcean(idx))
                    cir.setReturnValue(BuiltinRegistries.BIOME.getRawId(BYGBiome.BIOME_TO_BEACH_LIST.get(centre)));
            }
        }
    }

    private static boolean isEdgeCompatible(int idx) {
        return BYGBiome.BIOME_TO_EDGE_LIST.containsKey(idx) || isOcean(idx);
    }

    private static boolean isOcean(int biome) {
        return biome == WARM_OCEAN || biome == LUKEWARM_OCEAN || biome == OCEAN || biome == COLD_OCEAN || biome == FROZEN_OCEAN || biome == DEEP_WARM_OCEAN || biome == DEEP_LUKEWARM_OCEAN || biome == DEEP_OCEAN || biome == DEEP_COLD_OCEAN || biome == DEEP_FROZEN_OCEAN;
    }
}