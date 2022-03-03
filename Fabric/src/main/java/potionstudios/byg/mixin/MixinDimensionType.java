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
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import potionstudios.byg.common.world.biome.end.EndBiomesConfig;
import potionstudios.byg.common.world.biome.nether.NetherBiomesConfig;
import potionstudios.byg.world.biome.BYGFabricEndBiomeSource;
import potionstudios.byg.world.biome.BYGFabricNetherBiomeSource;

@Mixin(DimensionType.class)
public class MixinDimensionType {

    @Inject(method = "defaultDimensions(Lnet/minecraft/core/RegistryAccess;J)Lnet/minecraft/core/Registry;", at = @At("RETURN"), cancellable = true)
    private static void useBYGEndAndNether(RegistryAccess registryAccess, long seed, CallbackInfoReturnable<MappedRegistry<LevelStem>> cir) {
        MappedRegistry<LevelStem> returnValue = cir.getReturnValue();
        MappedRegistry<LevelStem> newRegistry = new MappedRegistry<>(Registry.LEVEL_STEM_REGISTRY, Lifecycle.stable(), null);
        Registry<DimensionType> dimensionTypeRegistry = registryAccess.registryOrThrow(Registry.DIMENSION_TYPE_REGISTRY);
        Registry<NoiseGeneratorSettings> noiseGeneratorSettingsRegistry = registryAccess.registryOrThrow(Registry.NOISE_GENERATOR_SETTINGS_REGISTRY);
        Registry<StructureSet> structureSetRegistry = registryAccess.registryOrThrow(Registry.STRUCTURE_SET_REGISTRY);

        Registry<Biome> biomeRegistry = registryAccess.registryOrThrow(Registry.BIOME_REGISTRY);
        Registry<NormalNoise.NoiseParameters> noiseParameters = registryAccess.registryOrThrow(Registry.NOISE_REGISTRY);

        EndBiomesConfig endConfig = EndBiomesConfig.getConfig(true);


        NetherBiomesConfig netherConfig = NetherBiomesConfig.getConfig(true);

        for (LevelStem levelStem : returnValue) {
            ResourceKey<LevelStem> levelStemResourceKey = returnValue.getResourceKey(levelStem).get();
            if (levelStemResourceKey == LevelStem.NETHER && netherConfig.useBYGNetherBiomeSourceInNewWorlds()) {
                newRegistry.register(levelStemResourceKey, new LevelStem(dimensionTypeRegistry.getHolderOrThrow(DimensionType.NETHER_LOCATION),
                    new NoiseBasedChunkGenerator(structureSetRegistry, noiseParameters,
                        new BYGFabricNetherBiomeSource(biomeRegistry, seed, netherConfig.upperLayer(), netherConfig.middleLayer(), netherConfig.bottomLayer(), netherConfig.layerSize()), seed, noiseGeneratorSettingsRegistry.getHolderOrThrow(NoiseGeneratorSettings.NETHER)
                    )
                ), Lifecycle.stable());
            } else if (levelStemResourceKey == LevelStem.END && endConfig.useBYGEndBiomeSourceInNewWorlds()) {
                newRegistry.register(levelStemResourceKey, new LevelStem(dimensionTypeRegistry.getHolderOrThrow(DimensionType.END_LOCATION),
                    new NoiseBasedChunkGenerator(structureSetRegistry, noiseParameters,
                        new BYGFabricEndBiomeSource(biomeRegistry, seed, endConfig.islandLayers(), endConfig.voidLayers(), endConfig.skyLayers()), seed, noiseGeneratorSettingsRegistry.getHolderOrThrow(NoiseGeneratorSettings.END)
                    )
                ), Lifecycle.stable());

            } else {
                newRegistry.register(levelStemResourceKey, levelStem, Lifecycle.stable());
            }
        }
        cir.setReturnValue(newRegistry);
    }
}
