//package voronoiaoc.byg.mixin.common.world.layers;
//
//import net.minecraft.world.DimensionType;
//import net.minecraft.world.gen.ChunkGenerator;
//import net.minecraft.world.gen.DimensionSettings;
//import net.minecraft.world.gen.NoiseChunkGenerator;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//import voronoiaoc.byg.common.world.dimension.end.BYGEndBiomeProvider;
//import voronoiaoc.byg.common.world.dimension.nether.BYGNetherBiomeProvider;
//
//@Mixin(DimensionType.class)
//public class MixinDimensionType {
//
//    @Inject(at = @At("HEAD"), method = "func_236041_e_", cancellable = true)
//    private static void addBYGNetherBiomes(long seed, CallbackInfoReturnable<ChunkGenerator> cir) {
//        cir.setReturnValue(new NoiseChunkGenerator(new BYGNetherBiomeProvider(seed), seed, DimensionSettings.Preset.field_236124_d_.func_236137_b_()));
//    }
//
//    @Inject(at = @At("HEAD"), method = "func_236041_e_", cancellable = true)
//    private static void addBYGEndBiomes(long seed, CallbackInfoReturnable<ChunkGenerator> cir) {
//        cir.setReturnValue(new NoiseChunkGenerator(new BYGEndBiomeProvider(seed), seed, DimensionSettings.Preset.field_236125_e_.func_236137_b_()));
//    }
//}
