package corgiaoc.byg.core.world.util;

import com.google.common.collect.ImmutableMap;
import corgiaoc.byg.BYG;
import corgiaoc.byg.core.world.*;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.StructureConfig;
import net.minecraft.world.gen.chunk.StructuresConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.*;
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
            throw new IllegalStateException("Surface Builder ID: \"" + bygID.toString() + "\" already exists in the Surface Builder registry!");

        Registry.register(Registry.SURFACE_BUILDER, bygID, surfaceBuilder);
//        surfaceBuilder.setRegistryName(bygID); //Forge
        BYGSurfaceBuilders.surfaceBuilders.add(surfaceBuilder);
        return surfaceBuilder;
    }

    public static <SC extends SurfaceConfig, CSB extends ConfiguredSurfaceBuilder<SC>> CSB createConfiguredSurfaceBuilder(String id, CSB configuredSurfaceBuilder) {
        Identifier bygID = new Identifier(BYG.MOD_ID, id);
        if (BuiltinRegistries.CONFIGURED_SURFACE_BUILDER.getIds().contains(bygID))
            throw new IllegalStateException("Configured Surface Builder ID: \"" + bygID.toString() + "\" already exists in the Configured Surface Builder registry!");

        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, bygID, configuredSurfaceBuilder);
        return configuredSurfaceBuilder;
    }

    public static <C extends FeatureConfig, F extends Feature<C>> F createFeature(String id, F feature) {
        Identifier bygID = new Identifier(BYG.MOD_ID, id);
        if (Registry.FEATURE.getIds().contains(bygID))
            throw new IllegalStateException("Feature ID: \"" + bygID.toString() + "\" already exists in the Features registry!");

        Registry.register(Registry.FEATURE, bygID, feature);
//        feature.setRegistryName(bygID); //Forge
        BYGFeatures.features.add(feature);
        return feature;
    }

    public static <C extends FeatureConfig, F extends StructureFeature<C>> F createStructure(String id, F structure, int minChunkDistance, int maxChunkDistance, int seedModifier, GenerationStep.Feature decorationStage) {
        Identifier bygID = new Identifier(BYG.MOD_ID, id);
        if (Registry.STRUCTURE_FEATURE.getIds().contains(bygID))
            throw new IllegalStateException("Structure Feature ID: \"" + bygID.toString() + "\" already exists in the Structure Features registry!");
        Registry.register(Registry.STRUCTURE_FEATURE, bygID, structure);
//        structure.setRegistryName(bygID);
        BYGStructures.structures.add(structure);
        StructureFeature.STRUCTURES.put(bygID.toString(), structure);

        StructureFeature.STRUCTURE_TO_GENERATION_STEP.put(structure, decorationStage);

        StructuresConfig.DEFAULT_STRUCTURES =
                ImmutableMap.<StructureFeature<?>, StructureConfig>builder()
                        .putAll(StructuresConfig.DEFAULT_STRUCTURES)
                        .put(structure, new StructureConfig(minChunkDistance, maxChunkDistance, seedModifier))
                        .build();
        return structure;
    }


    public static <C extends FeatureConfig, CSF extends ConfiguredStructureFeature<C, ?>> CSF createConfiguredStructureFeature(String id, CSF configuredStructureFeature) {
        Identifier bygID = new Identifier(BYG.MOD_ID, id);
        if (BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE.getIds().contains(bygID))
            throw new IllegalStateException("Configured Structure Feature ID: \"" + bygID.toString() + "\" already exists in the Configured Structure Features registry!");

        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, bygID, configuredStructureFeature);
        return configuredStructureFeature;
    }


    public static StructurePieceType createStructurePiece(String id, StructurePieceType piece) {
        Registry.register(Registry.STRUCTURE_PIECE, new Identifier(BYG.MOD_ID, id), piece);
        return piece;
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createConfiguredFeature(String id, CF configuredFeature) {
        Identifier bygID = new Identifier(BYG.MOD_ID, id);
        if (BuiltinRegistries.CONFIGURED_FEATURE.getIds().contains(bygID))
            throw new IllegalStateException("Configured Feature ID: \"" + bygID.toString() + "\" already exists in the Configured Features registry!");

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, bygID, configuredFeature);
        return configuredFeature;
    }

    public static <DC extends DecoratorConfig, D extends Decorator<DC>> D createDecorator(String id, D decorator) {
        Identifier bygID = new Identifier(BYG.MOD_ID, id);
        if (Registry.DECORATOR.getIds().contains(bygID))
            throw new IllegalStateException("Decorator ID: \"" + bygID.toString() + "\" already exists in the Decorator registry!");

        Registry.register(Registry.DECORATOR, bygID, decorator);
//        decorator.setRegistryName(bygID); //Forge
        BYGDecorators.decorators.add(decorator);
        return decorator;
    }

    static Set<Integer> integerList = new HashSet<>();

    public static Biome createBiome(String id, Biome biome, int numericalID) {
        Identifier bygID = new Identifier(BYG.MOD_ID, id);
        if (BuiltinRegistries.BIOME.getIds().contains(bygID))
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