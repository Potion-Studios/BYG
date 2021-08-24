package corgiaoc.byg.mixin.common.world.layers.ocean;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.MixOceansLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MixOceansLayer.class)
public class MixinMixOceansLayer {


    @Inject(method = "applyPixel", at = @At("RETURN"), cancellable = true)
    private void addOceans(INoiseRandom rand, IArea area, IArea area1, int x, int z, CallbackInfoReturnable<Integer> cir) {
//        final Registry<Biome> biomeRegistry = ServerLifecycleHooks.getCurrentServer().getLevel(World.OVERWORLD).registryAccess().registry(Registry.BIOME_REGISTRY).get();
//
//
//        if (biomeRegistry == null) {
//            return;
//        }
//        double noise = rand.getBiomeNoise().noise(x / 8.0, z / 8.0, 0, 0, 0);
//
//
//
//
//        int returnValue = cir.getReturnValue();
//        switch (returnValue) {
//            case 24: {
//                if (BYGBiomes.TRACKED_OCEANS.containsKey(null)) {
//                    Biome ocean = getBiomeFromWeightedList(BYGBiomes.TRACKED_OCEANS.get(null), rand, biomeRegistry);
//                    if (ocean != null)
//                        cir.setReturnValue(biomeRegistry.getId(ocean));
//                }
//                break;
//            }
//            case 47: { // Deep Warm Ocean
//                if (BYGBiomes.TRACKED_OCEANS.containsKey(MLClimate.DESERT)) {
//                    Biome ocean = getBiomeFromWeightedList(BYGBiomes.TRACKED_OCEANS.get(MLClimate.DESERT), rand, biomeRegistry);
//                    if (ocean != null) {
//                        cir.setReturnValue(biomeRegistry.getId(ocean));
//                    }
//                }
//                break;
//            }
//            case 48: { // Deep Lukewarm Ocean
//                if (BYGBiomes.TRACKED_OCEANS.containsKey(MLClimate.WARM)) {
//
//                    Biome ocean = getBiomeFromWeightedList(BYGBiomes.TRACKED_OCEANS.get(MLClimate.WARM), rand, biomeRegistry);
//                    if (ocean != null) {
//                        cir.setReturnValue(biomeRegistry.getId(ocean));
//                    }
//                }
//                break;
//            }
//            case 49: { // Deep Cold Ocean
//                if (BYGBiomes.TRACKED_OCEANS.containsKey(MLClimate.COOL)) {
//                    Biome ocean = getBiomeFromWeightedList(BYGBiomes.TRACKED_OCEANS.get(MLClimate.COOL), rand, biomeRegistry);
//                    if (ocean != null) {
//                        cir.setReturnValue(biomeRegistry.getId(ocean));
//                    }
//                }
//                break;
//            }
//            case 50: { // Deep Frozen Ocean
//                if (BYGBiomes.TRACKED_OCEANS.containsKey(MLClimate.ICY)) {
//                    Biome ocean = getBiomeFromWeightedList(BYGBiomes.TRACKED_OCEANS.get(MLClimate.ICY), rand, biomeRegistry);
//                    if (ocean != null) {
//                        cir.setReturnValue(biomeRegistry.getId(ocean));
//                    }
//                }
//                break;
//            }
//        }
    }
}
