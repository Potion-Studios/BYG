package potionstudios.byg.common.world.feature.features;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import potionstudios.byg.common.world.biome.BYGBiomeTags;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.GlobalBiomeFeature;
import potionstudios.byg.common.world.feature.features.overworld.BYGOverworldTreeFeatures;
import potionstudios.byg.common.world.feature.placement.BYGPlacedFeaturesUtil;
import potionstudios.byg.common.world.placement.IsBiomeTagFilter;

import static net.minecraft.data.worldgen.placement.VegetationPlacements.TREE_THRESHOLD;
import static net.minecraft.world.level.levelgen.GenerationStep.Decoration.*;
import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.createConfiguredFeature;
import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.globalGenStagePath;

public class BYGGlobalFeatures {

    public static final Holder<ConfiguredFeature<GlobalBiomeFeature.Config, ?>> GLOBAL_RAW_GENERATION = createConfiguredFeature(globalGenStagePath(RAW_GENERATION),
        BYGFeatures.GLOBAL, new GlobalBiomeFeature.Config(HolderSet.direct())
    );
    public static final Holder<ConfiguredFeature<GlobalBiomeFeature.Config, ?>> GLOBAL_LAKES = createConfiguredFeature(globalGenStagePath(LAKES), BYGFeatures.GLOBAL,
        new GlobalBiomeFeature.Config(HolderSet.direct())
    );
    public static final Holder<ConfiguredFeature<GlobalBiomeFeature.Config, ?>> GLOBAL_LOCAL_MODIFICATIONS = createConfiguredFeature(globalGenStagePath(LOCAL_MODIFICATIONS),
        BYGFeatures.GLOBAL, new GlobalBiomeFeature.Config(HolderSet.direct())
    );
    public static final Holder<ConfiguredFeature<GlobalBiomeFeature.Config, ?>> GLOBAL_UNDERGROUND_STRUCTURES = createConfiguredFeature(globalGenStagePath(UNDERGROUND_STRUCTURES),
        BYGFeatures.GLOBAL, new GlobalBiomeFeature.Config(HolderSet.direct())
    );
    public static final Holder<ConfiguredFeature<GlobalBiomeFeature.Config, ?>> GLOBAL_SURFACE_STRUCTURES = createConfiguredFeature(globalGenStagePath(SURFACE_STRUCTURES),
        BYGFeatures.GLOBAL,
        new GlobalBiomeFeature.Config(HolderSet.direct())
    );
    public static final Holder<ConfiguredFeature<GlobalBiomeFeature.Config, ?>> GLOBAL_STRONGHOLDS = createConfiguredFeature(globalGenStagePath(STRONGHOLDS), BYGFeatures.GLOBAL,
        new GlobalBiomeFeature.Config(HolderSet.direct())
    );
    public static final Holder<ConfiguredFeature<GlobalBiomeFeature.Config, ?>> GLOBAL_UNDERGROUND_ORES = createConfiguredFeature(globalGenStagePath(UNDERGROUND_ORES),
        BYGFeatures.GLOBAL,
        new GlobalBiomeFeature.Config(HolderSet.direct())
    );
    public static final Holder<ConfiguredFeature<GlobalBiomeFeature.Config, ?>> GLOBAL_UNDERGROUND_DECORATION = createConfiguredFeature(globalGenStagePath(UNDERGROUND_DECORATION),
        BYGFeatures.GLOBAL, new GlobalBiomeFeature.Config(HolderSet.direct())
    );
    public static final Holder<ConfiguredFeature<GlobalBiomeFeature.Config, ?>> GLOBAL_FLUID_SPRINGS = createConfiguredFeature(globalGenStagePath(FLUID_SPRINGS),
        BYGFeatures.GLOBAL, new GlobalBiomeFeature.Config(HolderSet.direct())
    );
    public static final Holder<ConfiguredFeature<GlobalBiomeFeature.Config, ?>> GLOBAL_VEGETAL_DECORATION = createConfiguredFeature(globalGenStagePath(VEGETAL_DECORATION),
        BYGFeatures.GLOBAL, new GlobalBiomeFeature.Config(HolderSet.direct(
            BYGPlacedFeaturesUtil.createPlacedFeature(globalFeaturePath("palm_trees"), BYGOverworldTreeFeatures.PALM_TREES,
                PlacementUtils.countExtra(1, 0.2F, 1), InSquarePlacement.spread(), TREE_THRESHOLD,
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, new IsBiomeTagFilter(BYGBiomeTags.HAS_PALM_TREES)
            )
        ))
    );
    public static final Holder<ConfiguredFeature<GlobalBiomeFeature.Config, ?>> GLOBAL_TOP_LAYER_MODIFICATION = createConfiguredFeature(globalGenStagePath(TOP_LAYER_MODIFICATION),
        BYGFeatures.GLOBAL, new GlobalBiomeFeature.Config(HolderSet.direct())
    );

    private static String globalFeaturePath(String path) {
        return "global/placed_feature/" + path;
    }
}
