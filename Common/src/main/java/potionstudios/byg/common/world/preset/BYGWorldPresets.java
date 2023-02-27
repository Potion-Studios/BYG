package potionstudios.byg.common.world.preset;

import net.minecraft.core.Holder;
import net.minecraft.core.IdMap;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.presets.WorldPreset;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.BYGBiomeTags;
import potionstudios.byg.common.world.biome.BYGDebugBiomeSource;
import potionstudios.byg.reg.RegistrationProvider;
import potionstudios.byg.reg.RegistryObject;

import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.StreamSupport;

public class BYGWorldPresets {
    public static final RegistrationProvider<WorldPreset> PROVIDER = RegistrationProvider.get(BuiltinRegistries.WORLD_PRESET, BYG.MOD_ID);


    public static final RegistryObject<WorldPreset> DEBUG_BIOMES = register("debug_biomes", () -> {
        Registry<DimensionType> dimensionTypes = BuiltinRegistries.DIMENSION_TYPE;
        Registry<Biome> biomes = BuiltinRegistries.BIOME;
        Registry<StructureSet> structureSets = BuiltinRegistries.STRUCTURE_SETS;
        Registry<NoiseGeneratorSettings> noiseSettings = BuiltinRegistries.NOISE_GENERATOR_SETTINGS;
        Registry<NormalNoise.NoiseParameters> noises = BuiltinRegistries.NOISE;


        IdMap<Holder<Biome>> holders = biomes.asHolderIdMap();

        Holder<NoiseGeneratorSettings> overworldNoiseGenSettings = noiseSettings.getOrCreateHolderOrThrow(NoiseGeneratorSettings.OVERWORLD);
        Holder<DimensionType> overworldDimensionType = dimensionTypes.getOrCreateHolderOrThrow(BuiltinDimensionTypes.OVERWORLD);
        LevelStem overworldStem = new LevelStem(overworldDimensionType, new NoiseBasedChunkGenerator(structureSets, noises, new BYGDebugBiomeSource(StreamSupport.stream(holders.spliterator(), false), BYGBiomeTags.IS_OVERWORLD), overworldNoiseGenSettings));

        Holder<DimensionType> netherDimensionType = dimensionTypes.getOrCreateHolderOrThrow(BuiltinDimensionTypes.NETHER);
        Holder<NoiseGeneratorSettings> netherNoiseSettings = noiseSettings.getOrCreateHolderOrThrow(NoiseGeneratorSettings.NETHER);
        LevelStem netherStem = new LevelStem(netherDimensionType, new NoiseBasedChunkGenerator(structureSets, noises, new BYGDebugBiomeSource(StreamSupport.stream(holders.spliterator(), false), BYGBiomeTags.IS_NETHER), netherNoiseSettings));

        Holder<DimensionType> endDimensionType = dimensionTypes.getOrCreateHolderOrThrow(BuiltinDimensionTypes.END);
        Holder<NoiseGeneratorSettings> endNoiseSettings = noiseSettings.getOrCreateHolderOrThrow(NoiseGeneratorSettings.END);
        LevelStem endStem = new LevelStem(endDimensionType, new NoiseBasedChunkGenerator(structureSets, noises, new BYGDebugBiomeSource(StreamSupport.stream(holders.spliterator(), false), BYGBiomeTags.IS_END), endNoiseSettings));

        Map<ResourceKey<LevelStem>, LevelStem> stemMap = Map.of(
                LevelStem.OVERWORLD, overworldStem,
                LevelStem.NETHER, netherStem,
                LevelStem.END, endStem
        );

        return new WorldPreset(stemMap);
    });


    private static RegistryObject<WorldPreset> register(String id, Supplier<WorldPreset> value) {
        return PROVIDER.register(id, value);
    }

    public static void loadClass() {}
}