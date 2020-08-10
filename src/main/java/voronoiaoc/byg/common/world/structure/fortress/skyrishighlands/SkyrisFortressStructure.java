package voronoiaoc.byg.common.world.structure.fortress.skyrishighlands;//package voronoiaoc.byg.common.world.structure.fortress.skyrishighlands;
//
//import com.google.common.collect.Lists;
//import com.mojang.serialization.Codec;
//import net.minecraft.entity.EntityType;
//import net.minecraft.util.math.BlockBox;
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.gen.ChunkGenerator;
//import net.minecraft.world.gen.feature.DefaultFeatureConfig;
//import net.minecraft.world.gen.feature.structure.FortressStructure;
//import net.minecraft.world.gen.feature.structure.Structure;
//import net.minecraft.world.gen.feature.structure.StructurePiece;
//import net.minecraft.world.gen.feature.structure.StructureStart;
//import net.minecraft.world.gen.feature.template.StructureManager;
//import voronoiaoc.byg.BYG;
//
//import java.util.List;
//
//public class SkyrisFortressStructure extends FortressStructure {
//    private static final List<Biome.SpawnSettings.SpawnEntry> spawnList = Lists.newArrayList(new Biome.SpawnSettings.SpawnEntry(EntityType.PILLAGER, 1, 1, 1), new Biome.SpawnSettings.SpawnEntry(EntityType.WITCH, 5, 4, 4), new Biome.SpawnSettings.SpawnEntry(EntityType.VEX, 8, 5, 5), new Biome.SpawnSettings.SpawnEntry(EntityType.ILLUSIONER, 2, 5, 5), new Biome.SpawnSettings.SpawnEntry(EntityType.EVOKER, 3, 4, 4));
//
//    public SkyrisFortressStructure(Codec<DefaultFeatureConfig> config) {
//        super(config);
//    }
//
//    public Structure.IStartFactory getStartFactory() {
//        return Start::new;
//    }
//
//    public String getStructureName() {
//        return BYG.MOD_ID + ":skyris_fortress";
//    }
//
//    public int getSize() {
//        return 15;
//    }
//
//    public List<Biome.SpawnSettings.SpawnEntry> getSpawnList() {
//        return spawnList;
//    }
//
//    public static class Start extends StructureStart {
//        public Start(Structure<?> structure, int p_i225812_2_, int p_i225812_3_, BlockBox boundingBox, int p_i225812_5_, long seed) {
//            super(structure, p_i225812_2_, p_i225812_3_, boundingBox, p_i225812_5_, seed);
//        }
//
//        public void init(ChunkGenerator<?> generator, StructureManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn) {
//            SkyrisFortressPieces.Start fortresspieces$start = new SkyrisFortressPieces.Start(this.rand, (chunkX << 4) + 2, (chunkZ << 4) + 2);
//            this.components.add(fortresspieces$start);
//            fortresspieces$start.buildComponent(fortresspieces$start, this.components, this.rand);
//            List<StructurePiece> list = fortresspieces$start.pendingChildren;
//
//            while (!list.isEmpty()) {
//                int i = this.rand.nextInt(list.size());
//                StructurePiece structurepiece = list.remove(i);
//                structurepiece.buildComponent(fortresspieces$start, this.components, this.rand);
//            }
//
//            this.recalculateStructureSize();
//            this.func_214626_a(this.rand, 120, 230);
//        }
//    }
//}
