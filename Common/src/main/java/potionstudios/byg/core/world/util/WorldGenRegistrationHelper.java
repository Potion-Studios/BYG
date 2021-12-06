package potionstudios.byg.core.world.util;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.StructureSettings;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import potionstudios.byg.BYG;
import potionstudios.byg.mixin.access.DimensionStructuresSettingsAccess;
import potionstudios.byg.mixin.access.StructureAccess;

@SuppressWarnings("deprecation")
public class WorldGenRegistrationHelper {

    public static <C extends FeatureConfiguration, F extends StructureFeature<C>> F createStructure(String id, F structure, int minChunkDistance, int maxChunkDistance, int seedModifier, GenerationStep.Decoration decorationStage) {
        ResourceLocation bygID = new ResourceLocation(BYG.MOD_ID, id);
        if (Registry.STRUCTURE_FEATURE.keySet().contains(bygID))
            throw new IllegalStateException("Structure Feature ID: \"" + bygID.toString() + "\" already exists in the Structure Features registry!");
        Registry.register(Registry.STRUCTURE_FEATURE, bygID, structure);
//        structure.setRegistryName(bygID);
//        BYGStructures.structures.add(structure);
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
}