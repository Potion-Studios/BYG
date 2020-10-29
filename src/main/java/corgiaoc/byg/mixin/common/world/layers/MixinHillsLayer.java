package corgiaoc.byg.mixin.common.world.layers;

import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.util.LayerRandomWeightedListUtil;
import net.minecraft.util.collection.WeightedList;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.layer.AddHillsLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;
import net.minecraft.world.biome.layer.util.LayerSampler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
@Mixin(AddHillsLayer.class)
public abstract class MixinHillsLayer {

    private static final List<Biome> topOceanList = new ArrayList<>();


    @Inject(method = "sample(Lnet/minecraft/world/biome/layer/util/LayerRandomnessSource;Lnet/minecraft/world/biome/layer/util/LayerSampler;Lnet/minecraft/world/biome/layer/util/LayerSampler;II)I",
            at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/biome/layer/util/LayerRandomnessSource;nextInt(I)I"),
            cancellable = true,
            locals = LocalCapture.CAPTURE_FAILHARD)
    private void injectBYGSubBiomes(LayerRandomnessSource rand, LayerSampler area1, LayerSampler area2, int x, int z, CallbackInfoReturnable<Integer> cir, int i, int j, int k) {
        if (rand.nextInt(9) == 0 || k == 0) {
            int l = i;
            Biome biome = BuiltinRegistries.BIOME.get(i);
            if (topOceanList.contains(biome))
                l = BuiltinRegistries.BIOME.getRawId(BYGBiomes.TROPICAL_ISLAND);
            cir.setReturnValue(l);
        }
        if (BYGBiome.BIOME_TO_HILLS_LIST.size() > 0) {
            if (rand.nextInt(3) == 0 || k == 0) {
                int l = i;
                Biome biome = BuiltinRegistries.BIOME.get(i);
                if (biome != null) {
                    if (BYGBiome.BIOME_TO_HILLS_LIST.get(i) != null) {
                        Biome hill = getHillBiomeValue(BYGBiome.BIOME_TO_HILLS_LIST.get(i), rand);
                        if (hill != null) {
                            l = BuiltinRegistries.BIOME.getRawId(hill);
                        }
                    }
                    else //Remove if the object is null.
                        BYGBiome.BIOME_TO_HILLS_LIST.remove(i);
                }
                cir.setReturnValue(l);
            }
        }
    }

    @Nullable
    private static Biome getHillBiomeValue(WeightedList<Biome> biomeHolder, LayerRandomnessSource layerRandom) {
        if (biomeHolder.entries.size() > 0) {
            return LayerRandomWeightedListUtil.getBiome(biomeHolder, layerRandom);
        }
        else {
            return null;
        }
    }


    static {
        topOceanList.add(BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.DEEP_OCEAN));
        topOceanList.add(BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.DEEP_LUKEWARM_OCEAN));
        topOceanList.add(BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.DEEP_WARM_OCEAN));
    }
}
