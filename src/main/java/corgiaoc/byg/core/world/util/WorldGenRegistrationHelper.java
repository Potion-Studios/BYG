package corgiaoc.byg.core.world.util;

import com.google.common.collect.ImmutableMap;
import corgiaoc.byg.BYG;
import corgiaoc.byg.core.world.*;
import corgiaoc.byg.mixin.access.DimensionStructuresSettingsAccess;
import corgiaoc.byg.mixin.access.StructureAccess;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.StructureSettings;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.DecoratorConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderConfiguration;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("deprecation")
public class WorldGenRegistrationHelper {

    public static <SBC extends SurfaceBuilderConfiguration, SB extends SurfaceBuilder<SBC>> SB createSurfaceBuilder(String id, SB surfaceBuilder) {
        ResourceLocation bygID = new ResourceLocation(BYG.MOD_ID, id);
        if (Registry.SURFACE_BUILDER.keySet().contains(bygID))
            throw new IllegalStateException("Surface Builder ID: \"" + bygID.toString() + "\" already exists in the Surface Builder registry!");

        Registry.register(Registry.SURFACE_BUILDER, bygID, surfaceBuilder);
//        surfaceBuilder.setRegistryName(bygID); //Forge
        BYGSurfaceBuilders.surfaceBuilders.add(surfaceBuilder);
        return surfaceBuilder;
    }

    public static <SC extends SurfaceBuilderConfiguration, CSB extends ConfiguredSurfaceBuilder<SC>> CSB createConfiguredSurfaceBuilder(String id, CSB configuredSurfaceBuilder) {
        ResourceLocation bygID = new ResourceLocation(BYG.MOD_ID, id);
        if (BuiltinRegistries.CONFIGURED_SURFACE_BUILDER.keySet().contains(bygID))
            throw new IllegalStateException("Configured Surface Builder ID: \"" + bygID.toString() + "\" already exists in the Configured Surface Builder registry!");

        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, bygID, configuredSurfaceBuilder);
        return configuredSurfaceBuilder;
    }

    public static <C extends FeatureConfiguration, F extends Feature<C>> F createFeature(String id, F feature) {
        ResourceLocation bygID = new ResourceLocation(BYG.MOD_ID, id);
        if (Registry.FEATURE.keySet().contains(bygID))
            throw new IllegalStateException("Feature ID: \"" + bygID.toString() + "\" already exists in the Features registry!");

        Registry.register(Registry.FEATURE, bygID, feature);
//        feature.setRegistryName(bygID); //Forge
        BYGFeatures.features.add(feature);
        return feature;
    }

    public static <C extends FeatureConfiguration, F extends StructureFeature<C>> F createStructure(String id, F structure, int minChunkDistance, int maxChunkDistance, int seedModifier, GenerationStep.Decoration decorationStage) {
        ResourceLocation bygID = new ResourceLocation(BYG.MOD_ID, id);
        if (Registry.STRUCTURE_FEATURE.keySet().contains(bygID))
            throw new IllegalStateException("Structure Feature ID: \"" + bygID.toString() + "\" already exists in the Structure Features registry!");
        Registry.register(Registry.STRUCTURE_FEATURE, bygID, structure);
//        structure.setRegistryName(bygID);
        BYGStructures.structures.add(structure);
        StructureFeature.STRUCTURES_REGISTRY.put(bygID.toString(), structure);

        StructureAccess.getStructureStep().put(structure, decorationStage);

        DimensionStructuresSettingsAccess.setDefaults(
                ImmutableMap.<StructureFeature<?>, StructureFeatureConfiguration>builder()
                        .putAll(StructureSettings.DEFAULTS)
                        .put(structure, new StructureFeatureConfiguration(minChunkDistance, maxChunkDistance, seedModifier))
                        .build());
        return structure;
    }


    public static <C extends FeatureConfiguration, CSF extends ConfiguredStructureFeature<C, ?>> CSF createConfiguredStructureFeature(String id, CSF configuredStructureFeature) {
        ResourceLocation bygID = new ResourceLocation(BYG.MOD_ID, id);
        if (BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE.keySet().contains(bygID))
            throw new IllegalStateException("Configured Structure Feature ID: \"" + bygID.toString() + "\" already exists in the Configured Structure Features registry!");

        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, bygID, configuredStructureFeature);
        return configuredStructureFeature;
    }


    public static StructurePieceType createStructurePiece(String id, StructurePieceType piece) {
        Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(BYG.MOD_ID, id), piece);
        return piece;
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createConfiguredFeature(String id, CF configuredFeature) {
        ResourceLocation bygID = new ResourceLocation(BYG.MOD_ID, id);
        if (BuiltinRegistries.CONFIGURED_FEATURE.keySet().contains(bygID))
            throw new IllegalStateException("Configured Feature ID: \"" + bygID.toString() + "\" already exists in the Configured Features registry!");

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, bygID, configuredFeature);
        return configuredFeature;
    }

    public static <DC extends DecoratorConfiguration, D extends FeatureDecorator<DC>> D createDecorator(String id, D decorator) {
        ResourceLocation bygID = new ResourceLocation(BYG.MOD_ID, id);
        if (Registry.DECORATOR.keySet().contains(bygID))
            throw new IllegalStateException("Decorator ID: \"" + bygID.toString() + "\" already exists in the Decorator registry!");

        Registry.register(Registry.DECORATOR, bygID, decorator);
//        decorator.setRegistryName(bygID); //Forge
        BYGDecorators.decorators.add(decorator);
        return decorator;
    }

    static Set<Integer> integerList = new HashSet<>();

    public static Biome createBiome(String id, Biome biome, int numericalID) {
        ResourceLocation bygID = new ResourceLocation(BYG.MOD_ID, id);
        if (BuiltinRegistries.BIOME.keySet().contains(bygID))
            throw new IllegalStateException("Biome ID: \"" + bygID.toString() + "\" already exists in the Biome registry!");

        Registry.register(BuiltinRegistries.BIOME, bygID, biome);
//        biome.setRegistryName(bygID); //Forge

        if (integerList.contains(numericalID))
            BYG.LOGGER.warn("Duplicate Biome Numerical ID: " + numericalID + " at byg:" + id);

        BYGBiomes.biomeList.add(new BYGBiomes.PreserveBiomeOrder(biome, numericalID));
        integerList.add(numericalID);
        return biome;
    }
}