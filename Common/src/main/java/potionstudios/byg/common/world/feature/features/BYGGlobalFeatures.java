package potionstudios.byg.common.world.feature.features;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.BYGGlobalPlacedFeatures;
import potionstudios.byg.common.world.feature.GlobalBiomeFeature;

import static net.minecraft.world.level.levelgen.GenerationStep.Decoration.*;
import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.createConfiguredFeature;
import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.globalGenStagePath;

public class BYGGlobalFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOBAL_RAW_GENERATION = createConfiguredFeature(globalGenStagePath(RAW_GENERATION),
            BYGFeatures.GLOBAL, () -> new GlobalBiomeFeature.Config(HolderSet.direct())
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOBAL_LAKES = createConfiguredFeature(globalGenStagePath(LAKES), BYGFeatures.GLOBAL,
            () -> new GlobalBiomeFeature.Config(HolderSet.direct())
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOBAL_LOCAL_MODIFICATIONS = createConfiguredFeature(globalGenStagePath(LOCAL_MODIFICATIONS),
            BYGFeatures.GLOBAL, () -> new GlobalBiomeFeature.Config(HolderSet.direct())
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOBAL_UNDERGROUND_STRUCTURES = createConfiguredFeature(globalGenStagePath(UNDERGROUND_STRUCTURES),
            BYGFeatures.GLOBAL, () -> new GlobalBiomeFeature.Config(HolderSet.direct())
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOBAL_SURFACE_STRUCTURES = createConfiguredFeature(globalGenStagePath(SURFACE_STRUCTURES),
            BYGFeatures.GLOBAL,
            () -> new GlobalBiomeFeature.Config(HolderSet.direct())
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOBAL_STRONGHOLDS = createConfiguredFeature(globalGenStagePath(STRONGHOLDS), BYGFeatures.GLOBAL,
            () -> new GlobalBiomeFeature.Config(HolderSet.direct())
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOBAL_UNDERGROUND_ORES = createConfiguredFeature(globalGenStagePath(UNDERGROUND_ORES),
            BYGFeatures.GLOBAL,
            (configuredFeatureBootstapContext) -> {
                HolderGetter<PlacedFeature> lookup = configuredFeatureBootstapContext.lookup(Registries.PLACED_FEATURE);
                return new GlobalBiomeFeature.Config(
                        HolderSet.direct(
                                lookup.getOrThrow(BYGGlobalPlacedFeatures.ORE_SOAPSTONE_UPPER),
                                lookup.getOrThrow(BYGGlobalPlacedFeatures.ORE_SOAPSTONE_LOWER)
                        )
                );
            }
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOBAL_UNDERGROUND_DECORATION = createConfiguredFeature(globalGenStagePath(UNDERGROUND_DECORATION),
            BYGFeatures.GLOBAL, () -> new GlobalBiomeFeature.Config(HolderSet.direct())
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOBAL_FLUID_SPRINGS = createConfiguredFeature(globalGenStagePath(FLUID_SPRINGS),
            BYGFeatures.GLOBAL, () -> new GlobalBiomeFeature.Config(HolderSet.direct())
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOBAL_VEGETAL_DECORATION = createConfiguredFeature(globalGenStagePath(VEGETAL_DECORATION),
            BYGFeatures.GLOBAL, (configuredFeatureBootstapContext) -> {
                HolderGetter<ConfiguredFeature<?, ?>> lookup = configuredFeatureBootstapContext.lookup(Registries.CONFIGURED_FEATURE);
               return new GlobalBiomeFeature.Config(HolderSet.direct(
// TODO: Race Condition?
//                        BYGPlacedFeaturesUtil.createPlacedFeature(globalFeaturePath("palm_trees"), BYGOverworldTreeFeatures.PALM_TREES,
//                                () -> PlacementUtils.countExtra(0, 0.5F, 1), InSquarePlacement::spread, () -> SurfaceWaterDepthFilter.forMaxDepth(0),
//                                () -> PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, () -> new IsBiomeTagFilter(BYGBiomeTags.HAS_PALM_TREES)
//                        )
                ));
            }
    );
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOBAL_TOP_LAYER_MODIFICATION = createConfiguredFeature(globalGenStagePath(TOP_LAYER_MODIFICATION),
            BYGFeatures.GLOBAL, () -> new GlobalBiomeFeature.Config(HolderSet.direct())
    );

    public static void loadClass() {
    }
}
