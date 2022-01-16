package potionstudios.byg.common.world.feature;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import potionstudios.byg.BYG;

import java.util.ArrayList;
import java.util.List;

public class BYGPlacedFeatures {

    public static final PlacedFeature ALLIUM_FIELD_FLOWERS = createPlacedFeature("allium_field_flowers", BYGConfiguredFeatures.ALLIUM_FIELD_FLOWERS.placed(VegetationPlacements.worldSurfaceSquaredWithCount(20)));

    public static final PlacedFeature SHORT_GRASS = createPlacedGroundVegetationFeature("short_grass", BYGConfiguredFeatures.SHORT_GRASS_PATCH);
    public static final PlacedFeature BYG_GRASS = createPlacedFeature("grass", BYGConfiguredFeatures.BYG_GRASS_EXTRA.placed(VegetationPlacements.worldSurfaceSquaredWithCount(8)));

    public static PlacedFeature createPlacedGroundVegetationFeature(String id, ConfiguredFeature<?, ?> flowerConfiguredFeature, PlacementModifier... additionalModifiers) {
        List<PlacementModifier> spread = new ArrayList<>(List.of(InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        spread.addAll(List.of(additionalModifiers));
        return createPlacedFeature(id, flowerConfiguredFeature.placed(spread));
    }

    public static <PF extends PlacedFeature> PF createPlacedFeature(String id, PF placedFeature) {
        ResourceLocation bygID = new ResourceLocation(BYG.MOD_ID, id);
        if (BuiltinRegistries.PLACED_FEATURE.keySet().contains(bygID))
            throw new IllegalStateException("Placed Feature ID: \"" + bygID.toString() + "\" already exists in the Placed Features registry!");

        Registry.register(BuiltinRegistries.PLACED_FEATURE, bygID, placedFeature);
        return placedFeature;
    }

    public static void bootStrap(){}
}
