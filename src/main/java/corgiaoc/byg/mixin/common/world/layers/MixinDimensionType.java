package corgiaoc.byg.mixin.common.world.layers;

import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.dimension.end.BYGEndBiomeSource;
import corgiaoc.byg.common.world.dimension.nether.BYGNetherBiomeSource;
import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DimensionType.class)
public abstract class MixinDimensionType {

    @Inject(at = @At("HEAD"), method = "defaultNetherGenerator", cancellable = true)
    private static void netherDimensionBYG(Registry<Biome> registry, Registry<NoiseGeneratorSettings> dimSettings, long seed, CallbackInfoReturnable<ChunkGenerator> cir) {
        if (BYG.worldConfig().controlNether)
            cir.setReturnValue(new NoiseBasedChunkGenerator(new BYGNetherBiomeSource(registry, seed), seed, () -> dimSettings.getOrThrow(NoiseGeneratorSettings.NETHER)));
    }


    @Inject(at = @At("HEAD"), method = "defaultEndGenerator", cancellable = true)
    private static void endDimensionBYG(Registry<Biome> registry, Registry<NoiseGeneratorSettings> dimSettings, long seed, CallbackInfoReturnable<ChunkGenerator> cir) {
        if (BYG.worldConfig().controlEnd)
            cir.setReturnValue(new NoiseBasedChunkGenerator(new BYGEndBiomeSource(registry, seed), seed, () -> dimSettings.getOrThrow(NoiseGeneratorSettings.END)));
    }
}