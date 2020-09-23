package voronoiaoc.byg.mixin.common;

import net.fabricmc.loader.api.FabricLoader;
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
import voronoiaoc.byg.common.world.dimension.nether.BYGNetherBiomeProvider;

@Mixin(DimensionType.class)
public class MixinDimensionType {

    @Inject(at = @At("HEAD"), method = "defaultNetherGenerator(Lnet/minecraft/core/Registry;Lnet/minecraft/core/Registry;J)Lnet/minecraft/world/level/chunk/ChunkGenerator;", cancellable = true)
    private static void yeetTheNether(Registry<Biome> registry, Registry<NoiseGeneratorSettings> chunkGenRegistry, long seed, CallbackInfoReturnable<ChunkGenerator> cir) {
        if (FabricLoader.getInstance().isModLoaded("smolder") || FabricLoader.getInstance().isModLoaded("betternether")) {

        } else {
            cir.setReturnValue(new NoiseBasedChunkGenerator(new BYGNetherBiomeProvider(registry, seed), seed, () -> chunkGenRegistry.getOrThrow(NoiseGeneratorSettings.NETHER)));
        }
    }
//
//
//    @Inject(at = @At("HEAD"), method = "defaultEndGenerator(Lnet/minecraft/core/Registry;Lnet/minecraft/core/Registry;J)Lnet/minecraft/world/level/chunk/ChunkGenerator;", cancellable = true, require = 0)
//    private static void yeetTheEnd(Registry<Biome> registry, Registry<NoiseGeneratorSettings> chunkGenRegistry, long seed, CallbackInfoReturnable<ChunkGenerator> cir) {
//        cir.setReturnValue(new NoiseBasedChunkGenerator(new BYGEndBiomeProvider(registry, seed), seed, () -> chunkGenRegistry.getOrThrow(NoiseGeneratorSettings.END)));
//    }
}
