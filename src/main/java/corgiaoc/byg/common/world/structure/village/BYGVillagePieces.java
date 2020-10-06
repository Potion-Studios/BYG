//package voronoiaoc.byg.common.world.structure.village;
//
//import net.minecraft.util.Rotation;
//import net.minecraft.util.SharedSeedRandom;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.MutableBoundingBox;
//import net.minecraft.world.gen.ChunkGenerator;
//import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;
//import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
//import net.minecraft.world.gen.feature.structure.IStructurePieceType;
//import net.minecraft.world.gen.feature.structure.StructurePiece;
//import net.minecraft.world.gen.feature.structure.VillageConfig;
//import net.minecraft.world.gen.feature.template.TemplateManager;
//import voronoiaoc.byg.common.world.structure.village.villagepools.*;
//
//import java.util.List;
//
//public class BYGVillagePieces {
//
//    public static void addPieces(ChunkGenerator chunkGen, TemplateManager template, BlockPos blockPos, List<StructurePiece> list, SharedSeedRandom seed, VillageConfig villageConfig) {
//        BYGGuianaVillagePools.init();
//        BYGGrasslandVillagePools.init();
//        BYGJungleVillagePools.init();
//        BYGAdobeVillagePools.init();
//        BYGSkyrisVillagePools.init();
////        JigsawManager.f(villageConfig.startPool, villageConfig.size, BYGVillagePieces.BYGVillage::new, chunkGen, template, blockPos, list, seed);
//    }
//
//    public static class BYGVillage extends AbstractVillagePiece {
//        public BYGVillage(TemplateManager templateManager, JigsawPiece jigsaw, BlockPos blockPos, int p_i50890_4_, Rotation rotation, MutableBoundingBox mutableBoundingBox) {
//            super(IStructurePieceType.NVI, templateManager, jigsaw, blockPos, p_i50890_4_, rotation, mutableBoundingBox);
//        }
//
//    }
//}
