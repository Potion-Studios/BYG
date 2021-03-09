package corgiaoc.byg.common.world.structure.village.villagepools;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPatternRegistry;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;
import net.minecraft.world.gen.feature.template.ProcessorLists;

public class RuinsVillagePools {
   public static final JigsawPattern codec2 = JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("byg:village/ruins/town_centers"),
           new ResourceLocation("empty"),
           ImmutableList.of(Pair.of(JigsawPiece.func_242851_a("byg:village/ruins/town_centers/ruins_meeting_point_1", ProcessorLists.field_244107_g), 30),
                   Pair.of(JigsawPiece.func_242851_a("byg:village/ruins/town_centers/ruins_meeting_point_2", ProcessorLists.field_244107_g), 30),
                   Pair.of(JigsawPiece.func_242851_a("byg:village/ruins/town_centers/ruins_meeting_point_3", ProcessorLists.field_244107_g), 30),
                   Pair.of(JigsawPiece.func_242851_a("byg:village/ruins/town_centers/ruins_meeting_point_4", ProcessorLists.field_244107_g), 10)), JigsawPattern.PlacementBehaviour.RIGID));

   public static void init() {
   }

   static {
      //Normal
      JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("byg:village/ruins/streets"),
              new ResourceLocation("byg:village/ruins/terminators"),
              ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/streets/ruins_corner_01"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/streets/ruins_corner_02"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/streets/ruins_straight_01"), 4),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/streets/ruins_straight_02"), 4),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/streets/ruins_straight_03"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/streets/ruins_crossroad_01"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/streets/ruins_crossroad_02"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/streets/ruins_crossroad_03"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/streets/ruins_crossroad_04"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/streets/ruins_square_01"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/streets/ruins_square_02"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/streets/ruins_turn_01"), 3)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
      
      JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("byg:village/ruins/houses"),
              new ResourceLocation("byg:village/ruins/terminators"),
              ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/houses/ruins_small_house_1"), 2),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/houses/ruins_small_house_2"), 2),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/houses/ruins_small_house_3"), 2),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/houses/ruins_small_house_4"), 2),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/houses/ruins_small_house_5"), 2),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/houses/ruins_small_house_6"), 1),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/houses/ruins_small_house_7"), 2),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/houses/ruins_small_house_8"), 2),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/houses/ruins_medium_house_1"), 2),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/houses/ruins_medium_house_2"), 2),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/houses/ruins_medium_house_3"), 2),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/houses/ruins_medium_house_4"), 2),
                      Pair.of(JigsawPiece.func_242864_g(), 10)), JigsawPattern.PlacementBehaviour.RIGID));
      
      JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("byg:village/ruins/terminators"),
              new ResourceLocation("empty"),
              ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/terminators/s_terminator_01"), 1),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/terminators/s_terminator_02"), 1)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
      
      JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("byg:village/ruins/decor"),
              new ResourceLocation("empty"),
              ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/ruins_lamp_1"), 10),
                      Pair.of(JigsawPiece.func_242845_a(Features.PATCH_BERRY_DECORATED), 4),
                      Pair.of(JigsawPiece.func_242845_a(Features.PATCH_RED_MUSHROOM), 4),
                      Pair.of(JigsawPiece.func_242864_g(), 6)), JigsawPattern.PlacementBehaviour.RIGID));
      
      JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("byg:village/ruins/villagers"),
              new ResourceLocation("empty"),
              ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/villagers/baby"), 1),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/villagers/baby"), 1),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/ruins/villagers/unemployed"), 10)), JigsawPattern.PlacementBehaviour.RIGID));

//      //Zombie
//      JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("village/desert/zombie/streets"), new ResourceLocation("village/desert/zombie/terminators"), ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/corner_01"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/corner_02"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/straight_01"), 4), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/straight_02"), 4), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/straight_03"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/crossroad_01"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/crossroad_02"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/crossroad_03"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/square_01"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/square_02"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/turn_01"), 3)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
//      JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("village/desert/zombie/houses"), new ResourceLocation("village/desert/zombie/terminators"), ImmutableList.of(Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_small_house_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_small_house_2", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_small_house_3", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_small_house_4", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_small_house_5", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_small_house_6", ProcessorLists.field_244106_f), 1), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_small_house_7", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_small_house_8", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_medium_house_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_medium_house_2", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_butcher_shop_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_tool_smith_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_fletcher_house_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_shepherd_house_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_armorer_1", ProcessorLists.field_244106_f), 1), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_fisher_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_tannery_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_cartographer_house_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_library_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_mason_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_weaponsmith_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_temple_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_temple_2", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_large_farm_1", ProcessorLists.field_244106_f), 7), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_farm_1", ProcessorLists.field_244106_f), 4), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_farm_2", ProcessorLists.field_244106_f), 4), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_animal_pen_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_animal_pen_2", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242864_g(), 5)), JigsawPattern.PlacementBehaviour.RIGID));
//      JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("village/desert/zombie/terminators"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("village/desert/terminators/terminator_01"), 1), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/terminators/terminator_02"), 1)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
//      JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("village/desert/zombie/decor"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.func_242851_a("village/desert/desert_lamp_1", ProcessorLists.field_244106_f), 10), Pair.of(JigsawPiece.func_242845_a(Features.PATCH_CACTUS), 4), Pair.of(JigsawPiece.func_242845_a(Features.PILE_HAY), 4), Pair.of(JigsawPiece.func_242864_g(), 10)), JigsawPattern.PlacementBehaviour.RIGID));
//      JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("village/desert/zombie/villagers"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/villagers/nitwit"), 1), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/villagers/unemployed"), 10)), JigsawPattern.PlacementBehaviour.RIGID));
//      
   }
}
