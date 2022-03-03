package potionstudios.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import potionstudios.byg.common.world.feature.placement.BYGPlacedFeaturesUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public record LargeLakeFeatureConfig(int minRadius, int maxRadius, int minDepth, int maxDepth,
                                     BlockStateProvider lakeFloorStateProvider,
                                     BlockStateProvider borderStateProvider, HolderSet<PlacedFeature> lakeSurfaceFeatures, HolderSet<PlacedFeature> lakeEdgeFeatures, List<PlacementModifier> modifiers) implements FeatureConfiguration {

    public static final Codec<LargeLakeFeatureConfig> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
                Codec.INT.fieldOf("minRadius").forGetter(largeLakeFeatureConfig -> largeLakeFeatureConfig.minRadius),
                Codec.INT.fieldOf("maxRadius").forGetter(largeLakeFeatureConfig -> largeLakeFeatureConfig.maxRadius),
                Codec.INT.fieldOf("minDepth").forGetter(largeLakeFeatureConfig -> largeLakeFeatureConfig.minDepth),
                Codec.INT.fieldOf("maxDepth").forGetter(largeLakeFeatureConfig -> largeLakeFeatureConfig.maxDepth),
                BlockStateProvider.CODEC.fieldOf("floorStateProvider").forGetter(largeLakeFeatureConfig -> largeLakeFeatureConfig.lakeFloorStateProvider),
                BlockStateProvider.CODEC.fieldOf("edgeStateProvider").forGetter(largeLakeFeatureConfig -> largeLakeFeatureConfig.borderStateProvider),
                PlacedFeature.LIST_CODEC.fieldOf("surface_features").forGetter(largeLakeFeatureConfig -> largeLakeFeatureConfig.lakeSurfaceFeatures),
                PlacedFeature.LIST_CODEC.fieldOf("edge_features").forGetter(largeLakeFeatureConfig -> largeLakeFeatureConfig.lakeEdgeFeatures),
                PlacementModifier.CODEC.listOf().fieldOf("edgeStateProvider_placement").forGetter(largeLakeFeatureConfig -> largeLakeFeatureConfig.modifiers)
        ).apply(builder, LargeLakeFeatureConfig::new);
    });

    public int getRandomRadius(Random random) {
        return random.nextInt(Math.max(1, this.maxRadius - this.minRadius)) + this.minRadius;
    }

    public int getRandomDepth(Random random) {
        return random.nextInt(Math.max(1, this.maxDepth - this.minDepth)) + this.minRadius;
    }

    public static Holder<PlacedFeature> createDripLeavesPlacedFeature(int rarity, PlacementModifier... modifiers) {
        ArrayList<PlacementModifier> placementModifiers = new ArrayList<>();
        placementModifiers.add(RarityFilter.onAverageOnceEvery(rarity));
        placementModifiers.addAll(List.of(modifiers));
        placementModifiers.addAll(List.of(BlockPredicateFilter.forPredicate(BlockPredicate.anyOf(BlockPredicate.wouldSurvive(Blocks.BIG_DRIPLEAF.defaultBlockState(), BlockPos.ZERO), BlockPredicate.wouldSurvive(Blocks.SMALL_DRIPLEAF.defaultBlockState(), BlockPos.ZERO), BlockPredicate.wouldSurvive(Blocks.SMALL_DRIPLEAF.defaultBlockState(), BlockPos.ZERO)))));
        return BYGPlacedFeaturesUtil.createPlacedFeature(CaveFeatures.DRIPLEAF, placementModifiers);
    }
}
