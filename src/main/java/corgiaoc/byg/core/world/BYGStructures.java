package corgiaoc.byg.core.world;

import corgiaoc.byg.common.world.structure.largefeature.VolcanoPiece;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.world.gen.feature.StructureFeature;

import java.util.ArrayList;
import java.util.List;

public class BYGStructures {
    /*************************Structure Pieces*************************/
    public static final StructurePieceType VOLCANO_PIECE = WorldGenRegistrationHelper.createStructurePiece("volcano1", (structurePieceTypeIn, componentTypeIn) -> new VolcanoPiece(componentTypeIn));
    public static List<StructureFeature<?>> structures = new ArrayList<>();

    /*************************Structures*************************/

//    public static final Structure<NoFeatureConfig> VOLCANO_STRUCTURE = WorldGenRegistrationHelper.createStructure("volcano", new VolcanoStructure(NoFeatureConfig.field_236558_a_), 10, 0, 0,  GenerationStage.Decoration.RAW_GENERATION);
    public static void init() {
    }
}
