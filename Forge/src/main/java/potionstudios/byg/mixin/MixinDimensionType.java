package potionstudios.byg.mixin;

import com.mojang.serialization.Lifecycle;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import potionstudios.byg.common.world.biome.EndBiomesConfig;
import potionstudios.byg.world.biome.BYGForgeEndBiomeSource;

@Mixin(DimensionType.class)
public class MixinDimensionType {

    @Inject(method = "defaultDimensions(Lnet/minecraft/core/RegistryAccess;J)Lnet/minecraft/core/MappedRegistry;", at = @At("RETURN"), cancellable = true)
    private static void useBYGEnd(RegistryAccess registryAccess, long seed, CallbackInfoReturnable<MappedRegistry<LevelStem>> cir) {
        MappedRegistry<LevelStem> returnValue = cir.getReturnValue();
        MappedRegistry<LevelStem> newRegistry = new MappedRegistry<>(Registry.LEVEL_STEM_REGISTRY, Lifecycle.experimental());
        Registry<DimensionType> dimensionTypeRegistry = registryAccess.registryOrThrow(Registry.DIMENSION_TYPE_REGISTRY);
        Registry<NoiseGeneratorSettings> noiseGeneratorSettingsRegistry = registryAccess.registryOrThrow(Registry.NOISE_GENERATOR_SETTINGS_REGISTRY);
        Registry<Biome> biomeRegistry = registryAccess.registryOrThrow(Registry.BIOME_REGISTRY);
        Registry<NormalNoise.NoiseParameters> noiseParameters = registryAccess.registryOrThrow(Registry.NOISE_REGISTRY);

        EndBiomesConfig config = EndBiomesConfig.getConfig(true);
        if (!config.useBYGEndBiomeSourceInNewWorlds()) {
            return;
        }
        for (LevelStem levelStem : returnValue) {
            ResourceKey<LevelStem> levelStemResourceKey = returnValue.getResourceKey(levelStem).get();
            if (levelStemResourceKey == LevelStem.END) {
                newRegistry.register(levelStemResourceKey, new LevelStem(() -> {
                    return dimensionTypeRegistry.getOrThrow(DimensionType.END_LOCATION);
                }, new NoiseBasedChunkGenerator(noiseParameters, new BYGForgeEndBiomeSource(biomeRegistry, seed, config.islandLayers(), config.voidLayers(), config.skyLayers()), seed, () -> {
                    return noiseGeneratorSettingsRegistry.getOrThrow(NoiseGeneratorSettings.END);
                })), Lifecycle.experimental());

            } else {
                newRegistry.register(levelStemResourceKey, levelStem, Lifecycle.stable());
            }
        }
        cir.setReturnValue(newRegistry);
    }
}