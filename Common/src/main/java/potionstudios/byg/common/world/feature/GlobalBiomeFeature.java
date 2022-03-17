package potionstudios.byg.common.world.feature;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import potionstudios.byg.mixin.access.BiomeGenerationSettingsAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GlobalBiomeFeature extends Feature<GlobalBiomeFeature.Config> {
    public GlobalBiomeFeature() {
        super(Config.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<GlobalBiomeFeature.Config> featurePlaceContext) {
        featurePlaceContext.config().features().stream().map(Holder::value).forEach(placedFeature ->
            placedFeature.place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin())
        );
        return false;
    }

    public static void appendGlobalFeatures(BiomeGenerationSettings settings, Registry<PlacedFeature> placedFeatures) {
        List<HolderSet<PlacedFeature>> features = settings.features();
        if (features instanceof ImmutableList<HolderSet<PlacedFeature>> immutableList) {
            ((BiomeGenerationSettingsAccess) settings).byg_setFeatures(new ArrayList<>(immutableList));
        }
        features = settings.features();

        addPlacedFeature(GenerationStep.Decoration.RAW_GENERATION, features, HolderSet.direct(placedFeatures.getHolderOrThrow(BYGPlacedFeatures.GLOBAL_RAW_GENERATION.unwrapKey().orElseThrow())));
        addPlacedFeature(GenerationStep.Decoration.LAKES, features, HolderSet.direct(placedFeatures.getHolderOrThrow(BYGPlacedFeatures.GLOBAL_LAKES.unwrapKey().orElseThrow())));
        addPlacedFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, features, HolderSet.direct(placedFeatures.getHolderOrThrow(BYGPlacedFeatures.GLOBAL_LOCAL_MODIFICATIONS.unwrapKey().orElseThrow())));
        addPlacedFeature(GenerationStep.Decoration.UNDERGROUND_STRUCTURES, features, HolderSet.direct(placedFeatures.getHolderOrThrow(BYGPlacedFeatures.GLOBAL_UNDERGROUND_STRUCTURES.unwrapKey().orElseThrow())));
        addPlacedFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, features, HolderSet.direct(placedFeatures.getHolderOrThrow(BYGPlacedFeatures.GLOBAL_SURFACE_STRUCTURES.unwrapKey().orElseThrow())));
        addPlacedFeature(GenerationStep.Decoration.STRONGHOLDS, features, HolderSet.direct(placedFeatures.getHolderOrThrow(BYGPlacedFeatures.GLOBAL_STRONGHOLDS.unwrapKey().orElseThrow())));
        addPlacedFeature(GenerationStep.Decoration.UNDERGROUND_ORES, features, HolderSet.direct(placedFeatures.getHolderOrThrow(BYGPlacedFeatures.GLOBAL_UNDERGROUND_ORES.unwrapKey().orElseThrow())));
        addPlacedFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, features, HolderSet.direct(placedFeatures.getHolderOrThrow(BYGPlacedFeatures.GLOBAL_UNDERGROUND_DECORATION.unwrapKey().orElseThrow())));
        addPlacedFeature(GenerationStep.Decoration.FLUID_SPRINGS, features, HolderSet.direct(placedFeatures.getHolderOrThrow(BYGPlacedFeatures.GLOBAL_FLUID_SPRINGS.unwrapKey().orElseThrow())));
        addPlacedFeature(GenerationStep.Decoration.VEGETAL_DECORATION, features, HolderSet.direct(placedFeatures.getHolderOrThrow(BYGPlacedFeatures.GLOBAL_VEGETAL_DECORATION.unwrapKey().orElseThrow())));
        addPlacedFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, features, HolderSet.direct(placedFeatures.getHolderOrThrow(BYGPlacedFeatures.GLOBAL_TOP_LAYER_MODIFICATION.unwrapKey().orElseThrow())));
    }

    private static void addPlacedFeature(GenerationStep.Decoration step, List<HolderSet<PlacedFeature>> existing, HolderSet<PlacedFeature> toAppend) {
        int index = step.ordinal();
        if (index < existing.size()) {
            HolderSet<PlacedFeature> holders = existing.remove(index);
            existing.add(index, HolderSet.direct(new ArrayList<>(new ImmutableSet.Builder<Holder<PlacedFeature>>().addAll(holders.unwrap().right().orElseThrow()).addAll(toAppend).build())));
        } else {
            existing.add(index, toAppend);
        }
    }

    public record Config(HolderSet<PlacedFeature> features) implements FeatureConfiguration {
        public static final Codec<Config> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
                PlacedFeature.LIST_CODEC.fieldOf("features_to_place").forGetter(Config::features)
            ).apply(builder, Config::new)
        );
    }
}
