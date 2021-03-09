package corgiaoc.byg.common.world.structure.village.villagepools;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPatternRegistry;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;
import net.minecraft.world.gen.feature.template.ProcessorLists;

public class AdobeVillagePools {
   public static final JigsawPattern AdobeVillageJigsaw = JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("byg:village/adobe/town_centers"),
           new ResourceLocation("empty"),
           ImmutableList.of(Pair.of(JigsawPiece.func_242851_a("byg:village/adobe/town_centers/adobe_meeting_point_1", ProcessorLists.field_244107_g), 30),
                   Pair.of(JigsawPiece.func_242851_a("byg:village/adobe/town_centers/adobe_meeting_point_2", ProcessorLists.field_244107_g), 35),
                   Pair.of(JigsawPiece.func_242851_a("byg:village/adobe/town_centers/adobe_meeting_point_3", ProcessorLists.field_244107_g), 35)), JigsawPattern.PlacementBehaviour.RIGID));

   public static void init() {
   }

   static {
      //Normal
      JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("byg:village/adobe/streets"),
              new ResourceLocation("byg:village/adobe/terminators"),
              ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/streets/adobe_corner_01"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/streets/adobe_corner_02"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/streets/adobe_straight_01"), 4),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/streets/adobe_straight_02"), 4),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/streets/adobe_straight_03"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/streets/adobe_crossroad_01"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/streets/adobe_crossroad_02"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/streets/adobe_crossroad_03"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/streets/adobe_square_01"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/streets/adobe_square_02"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/streets/adobe_turn_01"), 3)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
      
      JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("byg:village/adobe/houses"),
              new ResourceLocation("byg:village/adobe/terminators"),
              ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/houses/adobe_small_house_1"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/houses/adobe_small_house_2"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/houses/adobe_small_house_3"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/houses/adobe_small_house_4"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/houses/adobe_small_house_5"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/houses/adobe_small_house_6"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/houses/adobe_small_house_7"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/houses/adobe_medium_house_1"), 4),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/houses/adobe_medium_house_2"), 4),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/houses/adobe_medium_house_3"), 4),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/houses/adobe_butcher_shop_1"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/houses/adobe_fletcher_house_1"), 2),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/houses/adobe_shepherd_house_1"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/houses/adobe_armorer_1"), 1),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/houses/adobe_fisher_1"), 2),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/houses/adobe_tannery_1"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/houses/adobe_cartographer_house_1"), 2),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/houses/adobe_library_1"), 2),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/houses/adobe_mason_1"), 2),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/houses/adobe_weaponsmith_1"), 2),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/houses/adobe_temple_1"), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/houses/adobe_temple_2"), 3),
                      Pair.of(JigsawPiece.func_242851_a("byg:village/adobe/houses/adobe_large_farm_1", ProcessorLists.field_244117_q), 4),
                      Pair.of(JigsawPiece.func_242851_a("byg:village/adobe/houses/adobe_farm_1", ProcessorLists.field_244117_q), 3),
                      Pair.of(JigsawPiece.func_242851_a("byg:village/adobe/houses/adobe_farm_2", ProcessorLists.field_244117_q), 3),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/houses/adobe_animal_pen_1"), 2),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/houses/adobe_animal_pen_2"), 2),
                      Pair.of(JigsawPiece.func_242864_g(), 10)), JigsawPattern.PlacementBehaviour.RIGID));
      
      JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("byg:village/adobe/terminators"),
              new ResourceLocation("empty"),
              ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/terminators/s_terminator_01"), 1),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/terminators/s_terminator_02"), 1)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
      
      JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("byg:village/adobe/decor"),
              new ResourceLocation("empty"),
              ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/adobe_lamp_1"), 10),
                      Pair.of(JigsawPiece.func_242845_a(Features.PATCH_CACTUS_DECORATED), 3),
                      Pair.of(JigsawPiece.func_242845_a(Features.PILE_HAY), 2),
                      Pair.of(JigsawPiece.func_242864_g(), 6)), JigsawPattern.PlacementBehaviour.RIGID));
      
      JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("byg:village/adobe/villagers"),
              new ResourceLocation("empty"),
              ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/villagers/baby"), 1),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/villagers/baby"), 1),
                      Pair.of(JigsawPiece.func_242849_a("byg:village/adobe/villagers/unemployed"), 10)), JigsawPattern.PlacementBehaviour.RIGID));

//      //Zombie
//      JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("village/desert/zombie/streets"), new ResourceLocation("village/desert/zombie/terminators"), ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/corner_01"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/corner_02"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/straight_01"), 4), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/straight_02"), 4), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/straight_03"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/crossroad_01"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/crossroad_02"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/crossroad_03"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/square_01"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/square_02"), 3), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/streets/turn_01"), 3)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
//      JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("village/desert/zombie/houses"), new ResourceLocation("village/desert/zombie/terminators"), ImmutableList.of(Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_small_house_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_small_house_2", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_small_house_3", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_small_house_4", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_small_house_5", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_small_house_6", ProcessorLists.field_244106_f), 1), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_small_house_7", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_small_house_8", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_medium_house_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/zombie/houses/desert_medium_house_2", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_butcher_shop_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_tool_smith_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_fletcher_house_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_shepherd_house_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_armorer_1", ProcessorLists.field_244106_f), 1), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_fisher_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_tannery_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_cartographer_house_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_library_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_mason_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_weaponsmith_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_temple_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_temple_2", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_large_farm_1", ProcessorLists.field_244106_f), 7), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_farm_1", ProcessorLists.field_244106_f), 4), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_farm_2", ProcessorLists.field_244106_f), 4), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_animal_pen_1", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242851_a("village/desert/houses/desert_animal_pen_2", ProcessorLists.field_244106_f), 2), Pair.of(JigsawPiece.func_242864_g(), 5)), JigsawPattern.PlacementBehaviour.RIGID));
//      JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("village/desert/zombie/terminators"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("village/desert/terminators/terminator_01"), 1), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/terminators/terminator_02"), 1)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
//      JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("village/desert/zombie/decor"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.func_242851_a("village/desert/desert_lamp_1", ProcessorLists.field_244106_f), 10), Pair.of(JigsawPiece.func_242845_a(Features.PATCH_CACTUS), 4), Pair.of(JigsawPiece.func_242845_a(Features.PILE_HAY), 4), Pair.of(JigsawPiece.func_242864_g(), 10)), JigsawPattern.PlacementBehaviour.RIGID));
//      JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("village/desert/zombie/villagers"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/villagers/nitwit"), 1), Pair.of(JigsawPiece.func_242849_a("village/desert/zombie/villagers/unemployed"), 10)), JigsawPattern.PlacementBehaviour.RIGID));
//      
   }
}
