package corgiaoc.byg.mixin.common.world.layers;

import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.biome.BYGBiome;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.newbiome.context.Context;
import net.minecraft.world.level.newbiome.layer.ShoreLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings({"deprecation", "ConstantConditions"})
@Mixin(ShoreLayer.class)
public abstract class MixinShoreLayer {


    private static final int WARM_OCEAN = BuiltinRegistries.BIOME.getId(BuiltinRegistries.BIOME.getOrThrow(Biomes.WARM_OCEAN));
    private static final int LUKEWARM_OCEAN = BuiltinRegistries.BIOME.getId(BuiltinRegistries.BIOME.getOrThrow(Biomes.LUKEWARM_OCEAN));
    private static final int OCEAN = BuiltinRegistries.BIOME.getId(BuiltinRegistries.BIOME.getOrThrow(Biomes.OCEAN));
    private static final int COLD_OCEAN = BuiltinRegistries.BIOME.getId(BuiltinRegistries.BIOME.getOrThrow(Biomes.COLD_OCEAN));
    private static final int FROZEN_OCEAN = BuiltinRegistries.BIOME.getId(BuiltinRegistries.BIOME.getOrThrow(Biomes.FROZEN_OCEAN));
    private static final int DEEP_WARM_OCEAN = BuiltinRegistries.BIOME.getId(BuiltinRegistries.BIOME.getOrThrow(Biomes.DEEP_WARM_OCEAN));
    private static final int DEEP_LUKEWARM_OCEAN = BuiltinRegistries.BIOME.getId(BuiltinRegistries.BIOME.getOrThrow(Biomes.DEEP_LUKEWARM_OCEAN));
    private static final int DEEP_OCEAN = BuiltinRegistries.BIOME.getId(BuiltinRegistries.BIOME.getOrThrow(Biomes.DEEP_OCEAN));
    private static final int DEEP_COLD_OCEAN = BuiltinRegistries.BIOME.getId(BuiltinRegistries.BIOME.getOrThrow(Biomes.DEEP_COLD_OCEAN));
    private static final int DEEP_FROZEN_OCEAN = BuiltinRegistries.BIOME.getId(BuiltinRegistries.BIOME.getOrThrow(Biomes.DEEP_FROZEN_OCEAN));


    @Inject(at = @At("HEAD"), method = "apply", cancellable = true)
    private void injectBYGEdges(Context rand, int n, int w, int s, int e, int c, CallbackInfoReturnable<Integer> cir) {
        final int[] ArrayNESW = {n, w, s, e};

        ResourceLocation centre = BYG.biomeRegistryAccess.getKey(BYG.biomeRegistryAccess.byId(c));

        for (int idx : ArrayNESW) {
            if (BYGBiome.BIOME_TO_EDGE_LIST.containsKey(centre))
                if (!isEdgeCompatible(idx)) {
                    int id = BYG.biomeRegistryAccess.getId(BYG.biomeRegistryAccess.get(BYGBiome.BIOME_TO_EDGE_LIST.get(centre)));
                    cir.setReturnValue(id);
                    return;
                }

            if (BYGBiome.BIOME_TO_BEACH_LIST.containsKey(centre)) {
                if (isOcean(idx)) {
                    int id = BYG.biomeRegistryAccess.getId(BYG.biomeRegistryAccess.get(BYGBiome.BIOME_TO_BEACH_LIST.get(centre)));
                    cir.setReturnValue(id);
                }
            }
        }
    }

    private static boolean isEdgeCompatible(int idx) {
        ResourceLocation idxLocation = BYG.biomeRegistryAccess.getKey(BYG.biomeRegistryAccess.byId(idx));

        return BYGBiome.BIOME_TO_EDGE_LIST.containsKey(idxLocation) || isOcean(idx);
    }

    private static boolean isOcean(int biome) {
        return biome == WARM_OCEAN || biome == LUKEWARM_OCEAN || biome == OCEAN || biome == COLD_OCEAN || biome == FROZEN_OCEAN || biome == DEEP_WARM_OCEAN || biome == DEEP_LUKEWARM_OCEAN || biome == DEEP_OCEAN || biome == DEEP_COLD_OCEAN || biome == DEEP_FROZEN_OCEAN;
    }
}