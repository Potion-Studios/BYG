package corgiaoc.byg.mixin.common.world.layers;

import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.dimension.end.BYGEndBiomeProvider;
import corgiaoc.byg.common.world.dimension.nether.BYGNetherBiomeProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DimensionType.class)
public abstract class MixinDimensionType {

    @Inject(at = @At("HEAD"), method = "createNetherGenerator(Lnet/minecraft/util/registry/Registry;Lnet/minecraft/util/registry/Registry;J)Lnet/minecraft/world/gen/chunk/ChunkGenerator;", cancellable = true)
    private static void netherDimensionBYG(Registry<Biome> registry, Registry<ChunkGeneratorSettings> dimSettings, long seed, CallbackInfoReturnable<ChunkGenerator> cir) {
        if (BYG.DIMENSIONS_CONFIG.NetherDimension.ControlNether)
            cir.setReturnValue(new NoiseChunkGenerator(new BYGNetherBiomeProvider(registry, seed), seed, () -> dimSettings.getOrThrow(ChunkGeneratorSettings.NETHER)));
    }


    @Inject(at = @At("HEAD"), method = "createEndGenerator(Lnet/minecraft/util/registry/Registry;Lnet/minecraft/util/registry/Registry;J)Lnet/minecraft/world/gen/chunk/ChunkGenerator;", cancellable = true)
    private static void endDimensionBYG(Registry<Biome> registry, Registry<ChunkGeneratorSettings> dimSettings, long seed, CallbackInfoReturnable<ChunkGenerator> cir) {
        if (BYG.DIMENSIONS_CONFIG.EndDimension.ControlEnd)
            cir.setReturnValue(new NoiseChunkGenerator(new BYGEndBiomeProvider(registry, seed), seed, () -> dimSettings.getOrThrow(ChunkGeneratorSettings.END)));
    }
}