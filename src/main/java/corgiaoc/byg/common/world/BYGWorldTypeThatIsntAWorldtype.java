package corgiaoc.byg.common.world;

import com.mojang.serialization.Lifecycle;
import corgiaoc.byg.common.world.dimension.end.BYGEndBiomeSource;
import corgiaoc.byg.common.world.dimension.nether.BYGNetherBiomeSource;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.OverworldBiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.settings.DimensionGeneratorSettings;
import net.minecraftforge.common.world.ForgeWorldType;

public class BYGWorldTypeThatIsntAWorldtype extends ForgeWorldType {
    public BYGWorldTypeThatIsntAWorldtype() {
        super(null);
    }

    @Override
    public ChunkGenerator createChunkGenerator(Registry<Biome> biomeRegistry, Registry<DimensionSettings> dimensionSettingsRegistry, long seed, String generatorSettings) {
        return new NoiseChunkGenerator(new OverworldBiomeProvider(seed, false, false, biomeRegistry), seed, () -> dimensionSettingsRegistry.getOrThrow(DimensionSettings.OVERWORLD));
    }

    public static SimpleRegistry<Dimension> getDefaultSimpleRegistry(Registry<DimensionType> lookUpRegistryDimensionType, Registry<Biome> registry, Registry<DimensionSettings> dimensionSettings, long seed) {
        SimpleRegistry<Dimension> simpleregistry = new SimpleRegistry<>(Registry.LEVEL_STEM_REGISTRY, Lifecycle.stable());
        simpleregistry.register(Dimension.OVERWORLD, new Dimension(() -> lookUpRegistryDimensionType.getOrThrow(DimensionType.OVERWORLD_LOCATION), new NoiseChunkGenerator(new BYGNetherBiomeSource(registry, seed), seed, () -> dimensionSettings.getOrThrow(DimensionSettings.OVERWORLD))), Lifecycle.stable());

        simpleregistry.register(Dimension.NETHER, new Dimension(() -> lookUpRegistryDimensionType.getOrThrow(DimensionType.NETHER_LOCATION), new NoiseChunkGenerator(new BYGNetherBiomeSource(registry, seed), seed, () -> dimensionSettings.getOrThrow(DimensionSettings.NETHER))), Lifecycle.stable());

        simpleregistry.register(Dimension.END, new Dimension(() -> lookUpRegistryDimensionType.getOrThrow(DimensionType.END_LOCATION), new NoiseChunkGenerator(new BYGEndBiomeSource(registry, seed), seed, () -> dimensionSettings.getOrThrow(DimensionSettings.END))), Lifecycle.stable());

        return simpleregistry;
    }

    @Override
    public DimensionGeneratorSettings createSettings(DynamicRegistries dynamicRegistries, long seed, boolean generateStructures, boolean generateLoot, String generatorSettings) {
        return new HideWorldType(seed, generateStructures, generateLoot, getDefaultSimpleRegistry(dynamicRegistries.registryOrThrow(Registry.DIMENSION_TYPE_REGISTRY), dynamicRegistries.registryOrThrow(Registry.BIOME_REGISTRY), dynamicRegistries.registryOrThrow(Registry.NOISE_GENERATOR_SETTINGS_REGISTRY), seed));
    }

    public static class HideWorldType extends DimensionGeneratorSettings {

        public HideWorldType(long seed, boolean generateFeatures, boolean bonusChest, SimpleRegistry<Dimension> dimensionSimpleRegistry) {
            super(seed, generateFeatures, bonusChest, dimensionSimpleRegistry);
        }

        @Override
        public boolean isDebug() {
            return true;
        }
    }
}
