package voronoiaoc.byg.common.world.worldtype116;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.traits.IC0Transformer;
import voronoiaoc.byg.common.biomes.BYGBiomeWeightSystem;

public class BYGBiomeLayer implements IC0Transformer {
   private static final int BIRCH_FOREST = Registry.BIOME.getId(Biomes.BIRCH_FOREST);
   private static final int DESERT = Registry.BIOME.getId(Biomes.DESERT);
   private static final int MOUNTAINS = Registry.BIOME.getId(Biomes.MOUNTAINS);
   private static final int FOREST = Registry.BIOME.getId(Biomes.FOREST);
   private static final int SNOWY_TUNDRA = Registry.BIOME.getId(Biomes.SNOWY_TUNDRA);
   private static final int JUNGLE = Registry.BIOME.getId(Biomes.JUNGLE);
   private static final int BADLANDS_PLATEAU = Registry.BIOME.getId(Biomes.BADLANDS_PLATEAU);
   private static final int WOODED_BADLANDS_PLATEAU = Registry.BIOME.getId(Biomes.WOODED_BADLANDS_PLATEAU);
   private static final int MUSHROOM_FIELDS = Registry.BIOME.getId(Biomes.MUSHROOM_FIELDS);
   private static final int PLAINS = Registry.BIOME.getId(Biomes.PLAINS);
   private static final int GIANT_TREE_TAIGA = Registry.BIOME.getId(Biomes.GIANT_TREE_TAIGA);
   private static final int DARK_FOREST = Registry.BIOME.getId(Biomes.DARK_FOREST);
   private static final int SAVANNA = Registry.BIOME.getId(Biomes.SAVANNA);
   private static final int SWAMP = Registry.BIOME.getId(Biomes.SWAMP);
   private static final int TAIGA = Registry.BIOME.getId(Biomes.TAIGA);
   private static final int SNOWY_TAIGA = Registry.BIOME.getId(Biomes.SNOWY_TAIGA);
   private static final int[] field_202743_q = new int[]{DESERT, FOREST, MOUNTAINS, SWAMP, PLAINS, TAIGA};
   private static final int[] field_202744_r = new int[]{DESERT, DESERT, DESERT, SAVANNA, SAVANNA, PLAINS};
   private static final int[] field_202745_s = new int[]{FOREST, DARK_FOREST, MOUNTAINS, PLAINS, BIRCH_FOREST, SWAMP};
   private static final int[] field_202746_t = new int[]{FOREST, MOUNTAINS, TAIGA, PLAINS};
   private static final int[] field_202747_u = new int[]{SNOWY_TUNDRA, SNOWY_TUNDRA, SNOWY_TUNDRA, SNOWY_TAIGA};
   private static int[] warmBiomes = field_202744_r;


   public BYGBiomeLayer(boolean p_i232147_1_) {
      if (p_i232147_1_) {
         warmBiomes = field_202743_q;
      }

   }

   @Override
   public int apply(INoiseRandom context, int value) {
      int i = (value & 3840) >> 8;
      value = value & -3841;
      if (!LayerUtil.isOcean(value) && value != MUSHROOM_FIELDS) {
         switch (value) {
            case 1:
               if (i > 0) {
                  return context.random(3) == 0 ? BADLANDS_PLATEAU : WOODED_BADLANDS_PLATEAU;
               }

               return BYGBiomeWeightSystem.HOT.get(context.random(BYGBiomeWeightSystem.HOT.size()));
            case 2:
               if (i > 0) {
                  return JUNGLE;
               }

               return BYGBiomeWeightSystem.WARM.get(context.random(BYGBiomeWeightSystem.WARM.size()));
            case 3:
               if (i > 0) {
                  return GIANT_TREE_TAIGA;
               }

               return BYGBiomeWeightSystem.COOL.get(context.random(BYGBiomeWeightSystem.COOL.size()));
            case 4:
               return BYGBiomeWeightSystem.ICY.get(context.random(BYGBiomeWeightSystem.ICY.size()));
            default:
               return MUSHROOM_FIELDS;
         }
      } else {
         return value;
      }
   }

//   public static void addVanillaBiomes() {
//      for (int yeet : warmBiomes)
//         BYGBiomeWeightSystem.HOT.add(field_202743_q[yeet]);
//      for (int yeet : field_202745_s)
//         BYGBiomeWeightSystem.WARM.add(field_202743_q[yeet]);
//      for (int yeet : field_202746_t)
//         BYGBiomeWeightSystem.COOL.add(field_202743_q[yeet]);
//      for (int yeet : field_202747_u)
//         BYGBiomeWeightSystem.ICY.add(field_202743_q[yeet]);
//   }
}
