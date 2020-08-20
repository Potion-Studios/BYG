//package voronoiaoc.byg.common.world.feature.biomefeatures;
//
//import com.google.common.collect.ImmutableMap;
//import net.minecraft.entity.EntityClassification;
//import net.minecraft.entity.EntityType;
//import net.minecraft.util.registry.WorldGenRegistries;
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.biome.MobSpawnInfo;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//
//public class EntitySpawnsCheatSheet {
//
//    public static void addSpawnEntries() {
//        for (Biome biome : WorldGenRegistries.field_243657_i) {
//            if (biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND && biome.getCategory() != Biome.Category.NONE) {
//                addMobSpawnToBiome(biome, EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 100, 100, 100));
//            }
//        }
//    }
//
//
//    public static void addMobSpawnToBiome(Biome biome, EntityClassification classification, MobSpawnInfo.Spawners... spawnInfos) {
//        convertImmutableSpawners(biome);
//        List<MobSpawnInfo.Spawners> spawnersList = new ArrayList<>(biome.func_242433_b().field_242554_e.get(classification));
//        spawnersList.addAll(Arrays.asList(spawnInfos));
//        biome.func_242433_b().field_242554_e.put(classification, spawnersList);
//    }
//
//
//    private static void convertImmutableSpawners(Biome biome) {
//        if (biome.func_242433_b().field_242554_e instanceof ImmutableMap) {
//            biome.func_242433_b().field_242554_e = new HashMap<>(biome.func_242433_b().field_242554_e);
//        }
//    }
//}