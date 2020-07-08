//package voronoiaoc.byg.common.world.structure.misc.reddesert;
//
//import com.mojang.serialization.Codec;
//import net.minecraft.structure.StructureManager;
//import net.minecraft.structure.StructureStart;
//import net.minecraft.util.math.BlockBox;
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.gen.chunk.ChunkGenerator;
//import net.minecraft.world.gen.feature.DefaultFeatureConfig;
////import voronoiaoc.byg.BYG;
//
//public class RedDesertTempleStructure extends //StructureFeature<DefaultFeatureConfig> {
//    public RedDesertTempleStructure(Codec<DefaultFeatureConfig> config) {
//        super(config);
//    }
//
//    @Override
//    public String getName() {
//        return BYG.MODID + ":red_desert_temple";
//    }
//
////    public int getSize() {
////        return 3;
////    }
//
//    public StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory() {
//        return Start::new;
//    }
//
//
////    protected int getSeedModifier() {
////        return 34543;
////    }
//
//    public static class Start extends StructureStart<DefaultFeatureConfig> {
//        public Start(//StructureFeature<DefaultFeatureConfig> structureFeature, int i, int j, BlockBox blockBox, int k, long l) {
//            super(structureFeature, i, j, blockBox, k, l);
//        }
//
//        public void init(ChunkGenerator chunkGenerator, StructureManager structureManager, int i, int j, Biome biome, DefaultFeatureConfig defaultFeatureConfig) {
//            RedDesertTemplePiece desertTempleGenerator = new RedDesertTemplePiece(this.random, i * 16, j * 16);
//            this.children.add(desertTempleGenerator);
//            this.setBoundingBoxFromChildren();
//        }
//    }
//}