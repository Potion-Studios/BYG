package potionstudios.byg.common.world.preset;

import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
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

import java.util.Map;

public class BYGWorldPresets {

    public static final Map<ResourceKey<WorldPreset>, WorldPresetFactory> WORLD_PRESET_FACTORIES = new Reference2ObjectOpenHashMap<>();


    public static final ResourceKey<WorldPreset> DEBUG_BIOMES = register("debug_biomes", (context) -> {
        HolderGetter<DimensionType> dimensionTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<StructureSet> structureSets = context.lookup(Registries.STRUCTURE_SET);
        HolderGetter<NoiseGeneratorSettings> noiseSettings = context.lookup(Registries.NOISE_SETTINGS);
        HolderGetter<NormalNoise.NoiseParameters> noises = context.lookup(Registries.NOISE);


        Holder<NoiseGeneratorSettings> overworldNoiseGenSettings = noiseSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD);
        Holder<DimensionType> overworldDimensionType = dimensionTypes.getOrThrow(BuiltinDimensionTypes.OVERWORLD);
        LevelStem overworldStem = new LevelStem(overworldDimensionType, new NoiseBasedChunkGenerator(new BYGDebugBiomeSource(biomes, TagKey.create(Registries.BIOME, BYG.createLocation("is_overworld"))), overworldNoiseGenSettings));

        Holder<DimensionType> netherDimensionType = dimensionTypes.getOrThrow(BuiltinDimensionTypes.NETHER);
        Holder<NoiseGeneratorSettings> netherNoiseSettings = noiseSettings.getOrThrow(NoiseGeneratorSettings.NETHER);
        LevelStem netherStem = new LevelStem(netherDimensionType, new NoiseBasedChunkGenerator(new BYGDebugBiomeSource(biomes, TagKey.create(Registries.BIOME, BYG.createLocation("is_nether"))), netherNoiseSettings));

        Holder<DimensionType> endDimensionType = dimensionTypes.getOrThrow(BuiltinDimensionTypes.END);
        Holder<NoiseGeneratorSettings> endNoiseSettings = noiseSettings.getOrThrow(NoiseGeneratorSettings.END);
        LevelStem endStem = new LevelStem(endDimensionType, new NoiseBasedChunkGenerator(new BYGDebugBiomeSource(biomes, TagKey.create(Registries.BIOME, BYG.createLocation("is_end"))), endNoiseSettings));

        Map<ResourceKey<LevelStem>, LevelStem> stemMap = Map.of(
                LevelStem.OVERWORLD, overworldStem,
                LevelStem.NETHER, netherStem,
                LevelStem.END, endStem
        );



        return new WorldPreset(stemMap);
    });


    private static ResourceKey<WorldPreset> register(String id, WorldPresetFactory factory) {
        ResourceKey<WorldPreset> worldPresetResourceKey = ResourceKey.create(Registries.WORLD_PRESET, BYG.createLocation(id));
        WORLD_PRESET_FACTORIES.put(worldPresetResourceKey, factory);

        return worldPresetResourceKey;
    }

    public static void loadClass() {}

    @FunctionalInterface
    public interface WorldPresetFactory {

        WorldPreset generate(BootstapContext<WorldPreset> worldPresetBootstapContext);
    }
}