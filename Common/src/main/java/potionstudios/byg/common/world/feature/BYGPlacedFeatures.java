package potionstudios.byg.common.world.feature;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import potionstudios.byg.BYG;

public class BYGPlacedFeatures {

//    public static final PlacedFeature




    public static <PF extends PlacedFeature> PF createPlacedFeature(String id, PF placedFeature) {
        ResourceLocation bygID = new ResourceLocation(BYG.MOD_ID, id);
        if (BuiltinRegistries.CONFIGURED_FEATURE.keySet().contains(bygID))
            throw new IllegalStateException("Placed Feature ID: \"" + bygID.toString() + "\" already exists in the Placed Features registry!");

        Registry.register(BuiltinRegistries.PLACED_FEATURE, bygID, placedFeature);
        return placedFeature;
    }
}
