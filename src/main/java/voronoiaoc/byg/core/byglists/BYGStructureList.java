package voronoiaoc.byg.core.byglists;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import voronoiaoc.byg.common.world.structure.fortress.skyrishighlands.SkyrisFortressPieces;
import voronoiaoc.byg.common.world.structure.misc.reddesert.RedDesertTemplePiece;
import voronoiaoc.byg.common.world.structure.misc.reddesert.RedDesertTempleStructure;

import java.util.Locale;

public class BYGStructureList {
    public static final Structure<NoFeatureConfig> RED_DESERT_PYRAMID = new RedDesertTempleStructure(NoFeatureConfig::deserialize);
    public static IStructurePieceType REDDESERTTEMPLE_PIECE = RedDesertTemplePiece::new;

    public static IStructurePieceType SKYRISFORTRESS_CORRIDOR = SkyrisFortressPieces.Corridor::new;
    public static IStructurePieceType SKYRISFORTRESS_CORRIDOR2 = SkyrisFortressPieces.Corridor2::new;
    public static IStructurePieceType SKYRISFORTRESS_CORRIDOR3 = SkyrisFortressPieces.Corridor3::new;
    public static IStructurePieceType SKYRISFORTRESS_CORRIDOR4 = SkyrisFortressPieces.Corridor4::new;
    public static IStructurePieceType SKYRISFORTRESS_CORRIDOR5 = SkyrisFortressPieces.Corridor5::new;
    public static IStructurePieceType SKYRISFORTRESS_CROSSING = SkyrisFortressPieces.Crossing::new;
    public static IStructurePieceType SKYRISFORTRESS_CROSSING2 = SkyrisFortressPieces.Crossing2::new;
    public static IStructurePieceType SKYRISFORTRESS_CROSSING3 = SkyrisFortressPieces.Crossing3::new;
    public static IStructurePieceType SKYRISFORTRESS_END = SkyrisFortressPieces.End::new;
    public static IStructurePieceType SKYRISFORTRESS_ENTRANCE = SkyrisFortressPieces.Entrance::new;
    public static IStructurePieceType SKYRISFORTRESS_NETHERSTALK = SkyrisFortressPieces.NetherStalkRoom::new;
    public static IStructurePieceType SKYRISFORTRESS_STRAIGHT = SkyrisFortressPieces.Straight::new;
    public static IStructurePieceType SKYRISFORTRESS_THRONE = SkyrisFortressPieces.Throne::new;
    public static IStructurePieceType SKYRISFORTRESS_STAIRS = SkyrisFortressPieces.Stairs::new;
    public static IStructurePieceType SKYRISFORTRESS_START = SkyrisFortressPieces.Start::new;

    public static void structurePieces() {
        registerPieces(BYGStructureList.REDDESERTTEMPLE_PIECE, "reddeserttemple_piece");

        registerPieces(BYGStructureList.SKYRISFORTRESS_CORRIDOR, "skyrisfortress_corridor");
        registerPieces(BYGStructureList.SKYRISFORTRESS_CORRIDOR2, "skyrisfortress_corridor2");
        registerPieces(BYGStructureList.SKYRISFORTRESS_CORRIDOR3, "skyrisfortress_corridor3");
        registerPieces(BYGStructureList.SKYRISFORTRESS_CORRIDOR4, "skyrisfortress_corridor4");
        registerPieces(BYGStructureList.SKYRISFORTRESS_CORRIDOR5, "skyrisfortress_corridor5");
        registerPieces(BYGStructureList.SKYRISFORTRESS_CROSSING, "skyrisfortress_crossing");
        registerPieces(BYGStructureList.SKYRISFORTRESS_CROSSING2, "skyrisfortress_crossing2");
        registerPieces(BYGStructureList.SKYRISFORTRESS_CROSSING3, "skyrisfortress_crossing3");
        registerPieces(BYGStructureList.SKYRISFORTRESS_END, "skyrisfortress_end");
        registerPieces(BYGStructureList.SKYRISFORTRESS_ENTRANCE, "skyrisfortress_entrance");
        registerPieces(BYGStructureList.SKYRISFORTRESS_NETHERSTALK, "skyrisfortress_netherstalk");
        registerPieces(BYGStructureList.SKYRISFORTRESS_STRAIGHT, "skyrisfortress_straight");
        registerPieces(BYGStructureList.SKYRISFORTRESS_THRONE, "skyrisfortress_throne");
        registerPieces(BYGStructureList.SKYRISFORTRESS_STAIRS, "skyrisfortress_stairs");
        registerPieces(BYGStructureList.SKYRISFORTRESS_START, "skyrisfortress_start");
    }


    public static IStructurePieceType registerPieces(IStructurePieceType pieceType, String key) {
        return Registry.register(Registry.STRUCTURE_PIECE, key.toLowerCase(Locale.ROOT), pieceType);
    }
}
