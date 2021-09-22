package corgiaoc.byg.mixin.common.world.layers;

import corgiaoc.byg.BYG;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.mixin.access.WeightedRandomListAccess;
import corgiaoc.byg.util.LayerRandomWeightedListUtil;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.newbiome.area.Area;
import net.minecraft.world.level.newbiome.context.Context;
import net.minecraft.world.level.newbiome.layer.RegionHillsLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("deprecation")
@Mixin(RegionHillsLayer.class)
public abstract class MixinHillsLayer {

    @Inject(method = "applyPixel", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/level/newbiome/area/Area;get(II)I", ordinal = 1), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
    private void addIslands(Context rand, Area area, Area area2, int x, int z, CallbackInfoReturnable<Integer> cir, int i, int j) {
        if (rand.nextRandom(2) == 0) {
            int l = i;
            Biome biome = BYG.biomeRegistryAccess.byId(i);
            if (biome.getBiomeCategory() == Biome.BiomeCategory.OCEAN && biome.getDepth() < -1.5) {
                l = BYG.biomeRegistryAccess.getId(BYG.biomeRegistryAccess.getOrThrow(BYGBiomes.TROPICAL_ISLAND));
            }
            cir.setReturnValue(l);
        }
    }

    @SuppressWarnings("ConstantConditions")
    @Inject(method = "applyPixel",
            at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/level/newbiome/context/Context;nextRandom(I)I", ordinal = 0),
            cancellable = true,
            locals = LocalCapture.CAPTURE_FAILHARD)
    private void injectBYGSubBiomes(Context rand, Area area1, Area area2, int x, int z, CallbackInfoReturnable<Integer> cir, int i, int j, int k) {
        int l = i;
        Optional<ResourceKey<Biome>> optionalResourceKey = BYG.biomeRegistryAccess.getResourceKey(BYG.biomeRegistryAccess.byId(i));
        if (optionalResourceKey.isPresent()) {
            ResourceKey<Biome> biomeKey = optionalResourceKey.get();
            if (biomeKey != null) {
                if (BYGBiomes.OVERWORLD_HILLS.containsKey(biomeKey)) {
                    Biome hill = BYG.biomeRegistryAccess.get(getHillBiomeValue(BYGBiomes.OVERWORLD_HILLS.get(biomeKey), rand));
                    if (hill != null) {
                        l = BYG.biomeRegistryAccess.getId(hill);
                    }
                }
            }
            cir.setReturnValue(l);
        }
    }

    @Nullable
    private static ResourceKey<Biome> getHillBiomeValue(WeightedRandomList<WeightedEntry.Wrapper<ResourceKey<Biome>>> biomeHolder, Context layerRandom) {
        if ((((WeightedRandomListAccess<WeightedEntry.Wrapper<ResourceLocation>>) biomeHolder).getItems().size() > 0)) {
            return LayerRandomWeightedListUtil.getBiomeFromID(biomeHolder, layerRandom);
        } else {
            return null;
        }
    }
}
