package corgiaoc.byg.common.world;

import com.mojang.serialization.Lifecycle;
import corgiaoc.byg.common.world.dimension.end.BYGEndBiomeProvider;
import corgiaoc.byg.common.world.dimension.nether.BYGNetherBiomeProvider;
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
        return new NoiseChunkGenerator(new OverworldBiomeProvider(seed, false, false, biomeRegistry), seed, () -> dimensionSettingsRegistry.getOrThrow(DimensionSettings.field_242734_c));
    }

    public static SimpleRegistry<Dimension> getDefaultSimpleRegistry(Registry<DimensionType> lookUpRegistryDimensionType, Registry<Biome> registry, Registry<DimensionSettings> dimensionSettings, long seed) {
        SimpleRegistry<Dimension> simpleregistry = new SimpleRegistry<>(Registry.DIMENSION_KEY, Lifecycle.stable());
        simpleregistry.register(Dimension.OVERWORLD, new Dimension(() -> lookUpRegistryDimensionType.getOrThrow(DimensionType.OVERWORLD), new NoiseChunkGenerator(new BYGNetherBiomeProvider(registry, seed), seed, () -> dimensionSettings.getOrThrow(DimensionSettings.field_242734_c))), Lifecycle.stable());

        simpleregistry.register(Dimension.THE_NETHER, new Dimension(() -> lookUpRegistryDimensionType.getOrThrow(DimensionType.THE_NETHER), new NoiseChunkGenerator(new BYGNetherBiomeProvider(registry, seed), seed, () -> dimensionSettings.getOrThrow(DimensionSettings.field_242736_e))), Lifecycle.stable());

        simpleregistry.register(Dimension.THE_END, new Dimension(() -> lookUpRegistryDimensionType.getOrThrow(DimensionType.THE_END), new NoiseChunkGenerator(new BYGEndBiomeProvider(registry, seed), seed, () -> dimensionSettings.getOrThrow(DimensionSettings.field_242737_f))), Lifecycle.stable());

        return simpleregistry;
    }

    @Override
    public DimensionGeneratorSettings createSettings(DynamicRegistries dynamicRegistries, long seed, boolean generateStructures, boolean generateLoot, String generatorSettings) {
        return new HideWorldType(seed, generateStructures, generateLoot, getDefaultSimpleRegistry(dynamicRegistries.getRegistry(Registry.DIMENSION_TYPE_KEY), dynamicRegistries.getRegistry(Registry.BIOME_KEY), dynamicRegistries.getRegistry(Registry.NOISE_SETTINGS_KEY), seed));
    }

    public static class HideWorldType extends DimensionGeneratorSettings {

        public HideWorldType(long seed, boolean generateFeatures, boolean bonusChest, SimpleRegistry<Dimension> dimensionSimpleRegistry) {
            super(seed, generateFeatures, bonusChest, dimensionSimpleRegistry);
        }

        @Override
        public boolean func_236227_h_() {
            return true;
        }
    }
}
