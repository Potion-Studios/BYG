//package corgiaoc.byg.mixin.common;
//
//import corgiaoc.byg.BYG;
//import corgiaoc.byg.common.world.dimension.end.BYGEndBiomeProvider;
//import net.minecraft.util.Util;
//import net.minecraft.util.math.MathHelper;
//import net.minecraft.util.registry.Registry;
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.gen.NoiseChunkGenerator;
//import net.minecraft.world.gen.SimplexNoiseGenerator;
//import org.spongepowered.asm.mixin.Final;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Constant;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.ModifyConstant;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//import edu.umd.cs.findbugs.annotations.Nullable;
//import java.util.Objects;
//
//@Mixin(NoiseChunkGenerator.class)
//public abstract class MixinNoiseChunkGenerator {
//
//
//    private static final float[] YES = Util.make(new float[25], (p_236092_0_) -> {
//        for(int i = -2; i <= 2; ++i) {
//            for(int j = -2; j <= 2; ++j) {
//                float f = 10.0F / MathHelper.sqrt((float)(i * i + j * j) + 0.2F);
//                p_236092_0_[i + 2 + (j + 2) * 5] = f;
//            }
//        }
//
//    });
//
//
//    private int noiseX;
//    private int noiseZ;
//
//    @Shadow
//    @Final
//    @Nullable
//    private SimplexNoiseGenerator field_236083_v_;
//
//    @Shadow public abstract int getSeaLevel();
//
//    @Inject(method = "fillNoiseColumn", at = @At("HEAD"))
//    private void getCoords(double[] noiseColumn, int noiseX, int noiseZ, CallbackInfo ci) {
//        this.noiseX = noiseX;
//        this.noiseZ = noiseZ;
//    }
//
//    @ModifyConstant(method = "fillNoiseColumn", constant = @Constant(doubleValue = 1.0))
//    private double yuh2(double arg) {
//        if (this.field_236083_v_ != null) {
//            return modifyHeightVal(true, arg);
//        }
//        return arg;
//    }
//
//    private double modifyHeightVal(boolean isScale, double arg) {
//        double d0;
//        double d1;
//        if (this.field_236083_v_ != null) {
//            float totalDepth = 0.0F;
//            float totalScale = 0.0F;
//            float totalWeight = 0.0F;
//            int seaLevel = this.getSeaLevel();
//            Biome centerBiome = ((NoiseChunkGenerator) (Object) this).getBiomeProvider().getNoiseBiome(noiseX, seaLevel, noiseZ);
//            String biomeKey = Objects.requireNonNull(BYG.DYNAMIC_REGISTRIES_ACCESS.getRegistry(Registry.BIOME_KEY).getKey(centerBiome)).toString();
//            if (BYGEndBiomeProvider.END_VOID_BIOME_IDS.contains(biomeKey) || biomeKey.equals("minecraft:the_end"))
//                return arg;
//
//            float mainHeight = centerBiome.getDepth();
//
//
//            for (int biomeX = -2; biomeX <= 2; ++biomeX) {
//                for (int biomeZ = -2; biomeZ <= 2; ++biomeZ) {
//                    Biome biome = ((NoiseChunkGenerator) (Object) this).getBiomeProvider().getNoiseBiome(noiseX + biomeX, seaLevel, noiseZ + biomeZ);
//                    float rawDepth = biome.getDepth();
//                    float rawScale = biome.getScale();
//
//
//                    float weightFactor = rawDepth > mainHeight ? 0.5F : 1.0F;
//                    float biomeWeight = weightFactor * YES[biomeX + 2 + (biomeZ + 2) * 5] / (rawDepth + 2.0F);
//                    totalDepth += rawDepth * biomeWeight;
//                    totalScale += rawScale * biomeWeight;
//                    totalWeight += biomeWeight;
//                }
//            }
//
//            float rawDepth = totalDepth / totalWeight;
//            float rawScale = totalScale / totalWeight;
//            double biomeDepth = rawDepth * 0.5F - 0.125F;
//            double biomeScale = rawScale * 0.9F + 0.1F;
//            d0 = biomeDepth * 0.265625D;
//            d1 = 96.0D / biomeScale;
//            return isScale ? d0 : d1;
//        }
//
//        return arg;
//    }
//}
