package voronoiaoc.byg.mixin.common.world.layers;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import voronoiaoc.byg.common.world.dimension.end.BYGEndBiomeProvider;
import voronoiaoc.byg.common.world.dimension.nether.BYGNetherBiomeProvider;
import voronoiaoc.byg.config.BYGWorldConfig;

@Mixin(DimensionType.class)
public class MixinDimensionType {

    @Inject(at = @At("HEAD"), method = "getNetherChunkGenerator(Lnet/minecraft/util/registry/Registry;Lnet/minecraft/util/registry/Registry;J)Lnet/minecraft/world/gen/ChunkGenerator;", cancellable = true)
    private static void netherDimensionBYG(Registry<Biome> registry, Registry<DimensionSettings> dimSettings, long seed, CallbackInfoReturnable<ChunkGenerator> cir) {
        if (BYGWorldConfig.controlNether.get())
            cir.setReturnValue(new NoiseChunkGenerator(new BYGNetherBiomeProvider(registry, seed), seed, () -> dimSettings.getOrThrow(DimensionSettings.field_242736_e)));
    }


    @Inject(at = @At("HEAD"), method = "getEndChunkGenerator(Lnet/minecraft/util/registry/Registry;Lnet/minecraft/util/registry/Registry;J)Lnet/minecraft/world/gen/ChunkGenerator;", cancellable = true)
    private static void endDimensionBYG(Registry<Biome> registry, Registry<DimensionSettings> dimSettings, long seed, CallbackInfoReturnable<ChunkGenerator> cir) {
        if (BYGWorldConfig.controlEnd.get())
            cir.setReturnValue(new NoiseChunkGenerator(new BYGEndBiomeProvider(registry, seed), seed, () -> dimSettings.getOrThrow(DimensionSettings.field_242737_f)));
    }
}