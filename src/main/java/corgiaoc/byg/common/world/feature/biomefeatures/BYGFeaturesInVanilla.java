package corgiaoc.byg.common.world.feature.biomefeatures;//package voronoiaoc.byg.common.world.feature.biomefeatures;
//

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import corgiaoc.byg.core.byglists.BYGConfiguredFeatures;
import corgiaoc.byg.core.byglists.BYGConfiguredTreeFeatures;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class BYGFeaturesInVanilla {
    public static void addBYGFeaturesToBiomes() {
        for (Biome biome : WorldGenRegistries.BIOME) {
            if (biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND && biome.getCategory() != Biome.Category.NONE) {
                addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.ORE_ROCKY_STONE);
                addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.ORE_SCORIA_STONE);
                addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.ORE_SOAP_STONE);

                if (biome == WorldGenRegistries.BIOME.getValueForKey(Biomes.SOUL_SAND_VALLEY)) {
                    addFeatureToBiome(biome, GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredFeatures.HANGING_SOUL_SHROOM_SPORES);
                }

                if (biome == WorldGenRegistries.BIOME.getValueForKey(Biomes.BEACH)) {
                    addFeatureToBiome(biome, GenerationStage.Decoration.VEGETAL_DECORATION, BYGConfiguredTreeFeatures.RANDOM_PALM_TREE);
                }
            }
        }
    }


    //Use these to add our features to vanilla's biomes.
    public static void addFeatureToBiome(Biome biome, GenerationStage.Decoration feature, ConfiguredFeature<?, ?> configuredFeature) {
        ConvertImmutableFeatures(biome);
        List<List<Supplier<ConfiguredFeature<?, ?>>>> biomeFeatures = biome.getGenerationSettings().features;
        while (biomeFeatures.size() <= feature.ordinal()) {
            biomeFeatures.add(Lists.newArrayList());
        }
        biomeFeatures.get(feature.ordinal()).add(() -> configuredFeature);

    }

    private static void ConvertImmutableFeatures(Biome biome) {
        if (biome.getGenerationSettings().features instanceof ImmutableList) {
            biome.getGenerationSettings().features = biome.getGenerationSettings().features.stream().map(Lists::newArrayList).collect(Collectors.toList());
        }
    }
}
