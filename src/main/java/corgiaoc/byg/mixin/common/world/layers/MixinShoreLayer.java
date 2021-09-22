package corgiaoc.byg.mixin.common.world.layers;

import corgiaoc.byg.BYG;
import corgiaoc.byg.core.world.BYGBiomes;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.newbiome.context.Context;
import net.minecraft.world.level.newbiome.layer.ShoreLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

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

        Optional<ResourceKey<Biome>> resourceKeyOptional = BYG.biomeRegistryAccess.getResourceKey(BYG.biomeRegistryAccess.byId(c));

        if (resourceKeyOptional.isEmpty()) {
            return;
        }

        ResourceKey<Biome> biomeResourceKey = resourceKeyOptional.get();

        for (int idx : ArrayNESW) {
            if (BYGBiomes.OVERWORLD_EDGES.containsKey(biomeResourceKey)) {
                if (!isEdgeCompatible(idx)) {
                    int id = BYG.biomeRegistryAccess.getId(BYG.biomeRegistryAccess.get(BYGBiomes.OVERWORLD_EDGES.get(biomeResourceKey)));
                    cir.setReturnValue(id);
                    return;
                }
            }

            if (BYGBiomes.OVERWORLD_BEACHES.containsKey(biomeResourceKey)) {
                if (BYG.biomeRegistryAccess.byId(idx).getBiomeCategory() == Biome.BiomeCategory.OCEAN) {
                    int id = BYG.biomeRegistryAccess.getId(BYG.biomeRegistryAccess.get(BYGBiomes.OVERWORLD_BEACHES.get(biomeResourceKey)));
                    cir.setReturnValue(id);
                }
            }
        }
    }

    private static boolean isEdgeCompatible(int idx) {
        Biome biome = BYG.biomeRegistryAccess.byId(idx);
        Optional<ResourceKey<Biome>> resourceKeyOptional = BYG.biomeRegistryAccess.getResourceKey(biome);

        if (resourceKeyOptional.isEmpty()) {
            return false;
        }
        ResourceKey<Biome> idxLocation = resourceKeyOptional.get();

        return BYGBiomes.OVERWORLD_EDGES.containsKey(idxLocation) || biome.getBiomeCategory() == Biome.BiomeCategory.OCEAN;
    }

}