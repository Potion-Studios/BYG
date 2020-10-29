package corgiaoc.byg.core.world.util;

import corgiaoc.byg.BYG;
import corgiaoc.byg.core.world.BYGBiomes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("deprecation")
public class WorldGenRegistrationHelper {

    public static <SBC extends SurfaceConfig, SB extends SurfaceBuilder<SBC>> SB createSurfaceBuilder(String id, SB surfaceBuilder) {
        Identifier bygID = new Identifier(BYG.MOD_ID, id);
        if (Registry.SURFACE_BUILDER.getIds().contains(bygID))
            BYG.LOGGER.error("Surface Builder ID: \"" + bygID.toString() + "\" already exists in the Surface Builder registry!");

        Registry.register(Registry.SURFACE_BUILDER, bygID, surfaceBuilder);
        return surfaceBuilder;
    }

    public static <SC extends SurfaceConfig, CSB extends ConfiguredSurfaceBuilder<SC>> CSB createConfiguredSurfaceBuilder(String id, CSB configuredSurfaceBuilder) {
        Identifier bygID = new Identifier(BYG.MOD_ID, id);
        if (BuiltinRegistries.CONFIGURED_SURFACE_BUILDER.getIds().contains(bygID))
            BYG.LOGGER.error("Configured Surface Builder ID: \"" + bygID.toString() + "\" already exists in the Configured Surface Builder registry!");

        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, bygID, configuredSurfaceBuilder);
        return configuredSurfaceBuilder;
    }

    public static <C extends FeatureConfig, F extends Feature<C>> F createFeature(String id, F feature) {
        Identifier bygID = new Identifier(BYG.MOD_ID, id);
        if (Registry.FEATURE.getIds().contains(bygID))
            BYG.LOGGER.error("Feature ID: \"" + bygID.toString() + "\" already exists in the Features registry!");

        Registry.register(Registry.FEATURE, bygID, feature);
        return feature;
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createConfiguredFeature(String id, CF configuredFeature) {
        Identifier bygID = new Identifier(BYG.MOD_ID, id);
        if (BuiltinRegistries.CONFIGURED_FEATURE.getIds().contains(bygID))
            BYG.LOGGER.error("Configured Feature ID: \"" + bygID.toString() + "\" already exists in the Configured Features registry!");

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, bygID, configuredFeature);
        return configuredFeature;
    }

    public static <DC extends DecoratorConfig, D extends Decorator<DC>> D createDecorator(String id, D decorator) {
        Identifier bygID = new Identifier(BYG.MOD_ID, id);
        if (Registry.DECORATOR.getIds().contains(bygID))
            BYG.LOGGER.error("Decorator ID: \"" + bygID.toString() + "\" already exists in the Decorator registry!");

        Registry.register(Registry.DECORATOR, bygID, decorator);
        return decorator;
    }

    static Set<Integer> integerList = new HashSet<>();

    public static Biome createBiome(String id, Biome biome, int numericalID) {
        Identifier bygID = new Identifier(BYG.MOD_ID, id);
        if (BuiltinRegistries.BIOME.getIds().contains(bygID))
            BYG.LOGGER.error("Biome ID: \"" + bygID.toString() + "\" already exists in the Biome registry!");

        if (integerList.contains(numericalID))
            BYG.LOGGER.warn("Duplicate Biome Numerical ID: " + numericalID + " at byg:" + id);

        BYGBiomes.biomeList.add(new BYGBiomes.PreserveBiomeOrder(biome, numericalID, id));
        integerList.add(numericalID);
        return biome;
    }
}