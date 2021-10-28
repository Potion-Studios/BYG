package corgiaoc.byg.core.world;

import corgiaoc.byg.common.world.structure.largefeature.VolcanoPiece;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.world.level.levelgen.feature.VillageFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;

import java.util.ArrayList;
import java.util.List;

public class BYGStructures {
    public static List<StructureFeature<?>> structures = new ArrayList<>();

    /*************************Structure Pieces*************************/
    public static final StructurePieceType VOLCANO_PIECE = WorldGenRegistrationHelper.createStructurePiece("volcano1", (structurePieceTypeIn, componentTypeIn) -> new VolcanoPiece(componentTypeIn));

    /*************************Structures*************************/

//    public static final Structure<NoFeatureConfig> VOLCANO_STRUCTURE = WorldGenRegistrationHelper.createStructure("volcano", new VolcanoStructure(NoFeatureConfig.CODEC), 10, 0, 0,  GenerationStage.Decoration.RAW_GENERATION);
//    public static final Structure<VillageConfig> BYG_VILLAGE = WorldGenRegistrationHelper.createStructure("byg_village", new VillageStructure(VillageConfig.CODEC), 3, 0, 0,  GenerationStage.Decoration.SURFACE_STRUCTURES);
    public static StructureFeature<JigsawConfiguration> ADOBE_VILLAGE = WorldGenRegistrationHelper.createStructure("adobe_village", new VillageFeature(JigsawConfiguration.CODEC), 32, 8, 247532335, GenerationStep.Decoration.SURFACE_STRUCTURES, true);
    public static StructureFeature<JigsawConfiguration> RUINS_VILLAGE = WorldGenRegistrationHelper.createStructure("ruins_village", new VillageFeature(JigsawConfiguration.CODEC), 32, 8, 98984785, GenerationStep.Decoration.SURFACE_STRUCTURES, true);
    public static StructureFeature<JigsawConfiguration> TROPICAL_VILLAGE = WorldGenRegistrationHelper.createStructure("tropical_village", new VillageFeature(JigsawConfiguration.CODEC), 32, 8, 233315243, GenerationStep.Decoration.SURFACE_STRUCTURES, true);
    public static StructureFeature<JigsawConfiguration> SKYRIS_VILLAGE = WorldGenRegistrationHelper.createStructure("skyris_village", new VillageFeature(JigsawConfiguration.CODEC), 32, 8, 889865932, GenerationStep.Decoration.SURFACE_STRUCTURES, true);

    public static void init() {
    }
}
