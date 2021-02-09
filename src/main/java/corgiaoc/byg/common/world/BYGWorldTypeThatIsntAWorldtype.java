//package corgiaoc.byg.common.world;
//
//import com.mojang.serialization.Lifecycle;
//import corgiaoc.byg.common.world.dimension.end.BYGEndBiomeProvider;
//import corgiaoc.byg.common.world.dimension.nether.BYGNetherBiomeProvider;
//import net.minecraft.util.registry.DynamicRegistryManager;
//import net.minecraft.util.registry.Registry;
//import net.minecraft.util.registry.SimpleRegistry;
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.biome.source.VanillaLayeredBiomeSource;
//import net.minecraft.world.dimension.DimensionOptions;
//import net.minecraft.world.dimension.DimensionType;
//import net.minecraft.world.gen.GeneratorOptions;
//import net.minecraft.world.gen.chunk.ChunkGenerator;
//import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
//import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
//import net.minecraftforge.common.world.ForgeWorldType;
//
//public class BYGWorldTypeThatIsntAWorldtype extends ForgeWorldType {
//    public BYGWorldTypeThatIsntAWorldtype() {
//        super(null);
//    }
//
//    @Override
//    public ChunkGenerator createChunkGenerator(Registry<Biome> biomeRegistry, Registry<ChunkGeneratorSettings> dimensionSettingsRegistry, long seed, String generatorSettings) {
//        return new NoiseChunkGenerator(new VanillaLayeredBiomeSource(seed, false, false, biomeRegistry), seed, () -> dimensionSettingsRegistry.getOrThrow(ChunkGeneratorSettings.OVERWORLD));
//    }
//
//    public static SimpleRegistry<DimensionOptions> getDefaultSimpleRegistry(Registry<DimensionType> lookUpRegistryDimensionType, Registry<Biome> registry, Registry<ChunkGeneratorSettings> dimensionSettings, long seed) {
//        SimpleRegistry<DimensionOptions> simpleregistry = new SimpleRegistry<>(Registry.DIMENSION_OPTIONS, Lifecycle.stable());
//        simpleregistry.add(DimensionOptions.OVERWORLD, new DimensionOptions(() -> lookUpRegistryDimensionType.getOrThrow(DimensionType.OVERWORLD_REGISTRY_KEY), new NoiseChunkGenerator(new BYGNetherBiomeProvider(registry, seed), seed, () -> dimensionSettings.getOrThrow(ChunkGeneratorSettings.OVERWORLD))), Lifecycle.stable());
//
//        simpleregistry.add(DimensionOptions.NETHER, new DimensionOptions(() -> lookUpRegistryDimensionType.getOrThrow(DimensionType.THE_NETHER_REGISTRY_KEY), new NoiseChunkGenerator(new BYGNetherBiomeProvider(registry, seed), seed, () -> dimensionSettings.getOrThrow(ChunkGeneratorSettings.NETHER))), Lifecycle.stable());
//
//        simpleregistry.add(DimensionOptions.END, new DimensionOptions(() -> lookUpRegistryDimensionType.getOrThrow(DimensionType.THE_END_REGISTRY_KEY), new NoiseChunkGenerator(new BYGEndBiomeProvider(registry, seed), seed, () -> dimensionSettings.getOrThrow(ChunkGeneratorSettings.END))), Lifecycle.stable());
//
//        return simpleregistry;
//    }
//
//    @Override
//    public GeneratorOptions createSettings(DynamicRegistryManager dynamicRegistries, long seed, boolean generateStructures, boolean generateLoot, String generatorSettings) {
//        return new HideWorldType(seed, generateStructures, generateLoot, getDefaultSimpleRegistry(dynamicRegistries.get(Registry.DIMENSION_TYPE_KEY), dynamicRegistries.get(Registry.BIOME_KEY), dynamicRegistries.get(Registry.NOISE_SETTINGS_WORLDGEN), seed));
//    }
//
//    public static class HideWorldType extends GeneratorOptions {
//
//        public HideWorldType(long seed, boolean generateFeatures, boolean bonusChest, SimpleRegistry<DimensionOptions> dimensionSimpleRegistry) {
//            super(seed, generateFeatures, bonusChest, dimensionSimpleRegistry);
//        }
//
//        @Override
//        public boolean isDebugWorld() {
//            return true;
//        }
//    }
//}
