package potionstudios.byg.common.world.structure;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.structure.arch.ArchPiece;
import potionstudios.byg.reg.RegistrationProvider;
import potionstudios.byg.reg.RegistryObject;

import java.util.Locale;

public class BYGStructurePieceTypes {
    public static final RegistrationProvider<StructurePieceType> PROVIDER = RegistrationProvider.get(Registry.STRUCTURE_PIECE_REGISTRY, BYG.MOD_ID);
    public static final RegistryObject<StructurePieceType> ARCH_PIECE = setFullContextPieceId(ArchPiece::new, "ArchPiece");

    private static RegistryObject<StructurePieceType> setFullContextPieceId(StructurePieceType type, String id) {
        return PROVIDER.register(id.toLowerCase(Locale.ROOT), () -> type);
    }

    public static void bootStrap() {
    }
}
