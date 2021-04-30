package corgiaoc.byg.core.world;

import corgiaoc.byg.common.world.structure.largefeature.VolcanoPiece;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;

import java.util.ArrayList;
import java.util.List;

public class BYGStructures {
    public static List<Structure<?>> structures = new ArrayList<>();

    /*************************Structure Pieces*************************/
    public static final IStructurePieceType VOLCANO_PIECE = WorldGenRegistrationHelper.createStructurePiece("volcano1", (structurePieceTypeIn, componentTypeIn) -> new VolcanoPiece(componentTypeIn));

    /*************************Structures*************************/

//    public static final Structure<NoFeatureConfig> VOLCANO_STRUCTURE = WorldGenRegistrationHelper.createStructure("volcano", new VolcanoStructure(NoFeatureConfig.CODEC), 10, 0, 0,  GenerationStage.Decoration.RAW_GENERATION);
//    public static final Structure<VillageConfig> BYG_VILLAGE = WorldGenRegistrationHelper.createStructure("byg_village", new VillageStructure(VillageConfig.CODEC), 3, 0, 0,  GenerationStage.Decoration.SURFACE_STRUCTURES);


    public static void init() {
    }
}
