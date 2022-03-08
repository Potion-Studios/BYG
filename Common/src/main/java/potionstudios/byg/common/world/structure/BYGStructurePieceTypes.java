package potionstudios.byg.common.world.structure;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.structure.arch.ArchPiece;

import java.util.Locale;

public class BYGStructurePieceTypes {
    public static final StructurePieceType ARCH_PIECE = setFullContextPieceId(ArchPiece::new, "ArchPiece");


    private static StructurePieceType setFullContextPieceId(StructurePieceType type, String id) {
        return Registry.register(Registry.STRUCTURE_PIECE, BYG.createLocation(id.toLowerCase(Locale.ROOT)), type);
    }

    private static StructurePieceType setPieceId(StructurePieceType.ContextlessType $$0, String $$1) {
        return setFullContextPieceId($$0, $$1);
    }

    private static StructurePieceType setTemplatePieceId(StructurePieceType.StructureTemplateType $$0, String $$1) {
        return setFullContextPieceId($$0, $$1);
    }

    public static void bootStrap() {
    }

    static {
        BYG.LOGGER.info("BYG Structure Piece Types class loaded.");
    }
}
