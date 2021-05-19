package corgiaoc.byg.mixin.common.world.layers;

import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.dimension.end.BYGEndBiomeSource;
import corgiaoc.byg.common.world.dimension.nether.BYGNetherBiomeSource;
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

@Mixin(DimensionType.class)
public abstract class MixinDimensionType {

    @Inject(at = @At("HEAD"), method = "defaultNetherGenerator", cancellable = true)
    private static void netherDimensionBYG(Registry<Biome> registry, Registry<DimensionSettings> dimSettings, long seed, CallbackInfoReturnable<ChunkGenerator> cir) {
        if (BYG.worldConfig().controlNether)
            cir.setReturnValue(new NoiseChunkGenerator(new BYGNetherBiomeSource(registry, seed), seed, () -> dimSettings.getOrThrow(DimensionSettings.NETHER)));
    }


    @Inject(at = @At("HEAD"), method = "defaultEndGenerator", cancellable = true)
    private static void endDimensionBYG(Registry<Biome> registry, Registry<DimensionSettings> dimSettings, long seed, CallbackInfoReturnable<ChunkGenerator> cir) {
        if (BYG.worldConfig().controlEnd)
            cir.setReturnValue(new NoiseChunkGenerator(new BYGEndBiomeSource(registry, seed), seed, () -> dimSettings.getOrThrow(DimensionSettings.END)));
    }
}