package corgiaoc.byg.core;

import corgiaoc.byg.common.entity.boat.BYGBoatEntity;
import corgiaoc.byg.common.properties.BYGCreativeTab;
import corgiaoc.byg.common.properties.items.*;
import corgiaoc.byg.common.properties.items.itemtiers.BYGArmorTiers;
import corgiaoc.byg.common.properties.items.itemtiers.BYGItemTiers;
import corgiaoc.byg.common.properties.items.itemtiers.BYGWaterSilkItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.registries.IForgeRegistry;

public class BYGItems {

    //BYG Items
    public static Item SONORAN_CACTUS;

    //BYG LOGO
    public static Item BYG_LOGO;
    public static Item BLUE_BERRY;
    public static Item HOLLY_BERRY;
    public static Item GREEN_APPLE;
    public static Item JOSHUA_FRUIT;
    public static Item COOKED_JOSHUA_FRUIT;
    public static Item MUD_BALL;
    public static Item CRIMSON_BERRIES;

    //FenceItems
    public static Item ASPEN_FENCE;
    public static Item BAOBAB_FENCE;
    public static Item BLUE_ENCHANTED_FENCE;
    public static Item CHERRY_FENCE;
    public static Item CIKA_FENCE;
    public static Item CYPRESS_FENCE;
    public static Item EBONY_FENCE;
    public static Item FIR_FENCE;
    public static Item GREEN_ENCHANTED_FENCE;
    public static Item HOLLY_FENCE;
    public static Item JACARANDA_FENCE;
    public static Item MAHOGANY_FENCE;
    public static Item MANGROVE_FENCE;
    public static Item MAPLE_FENCE;
    public static Item PINE_FENCE;
    public static Item RAINBOW_EUCALYPTUS_FENCE;
    public static Item REDWOOD_FENCE;
    public static Item SKYRIS_FENCE;
    public static Item WILLOW_FENCE;
    public static Item WITCH_HAZEL_FENCE;
    public static Item ZELKOVA_FENCE;
    public static Item SYTHIAN_FENCE;
    public static Item EMBUR_FENCE;
    public static Item PALM_FENCE;
    public static Item LAMENT_FENCE;
    //BoatItem
    public static Item ASPEN_BOAT;
    public static Item BAOBAB_BOAT;
    public static Item BLUE_ENCHANTED_BOAT;
    public static Item CHERRY_BOAT;
    public static Item CIKA_BOAT;
    public static Item CYPRESS_BOAT;
    public static Item EBONY_BOAT;
    public static Item FIR_BOAT;
    public static Item GREEN_ENCHANTED_BOAT;
    public static Item HOLLY_BOAT;
    public static Item JACARANDA_BOAT;
    public static Item MAHOGANY_BOAT;
    public static Item MANGROVE_BOAT;
    public static Item MAPLE_BOAT;
    public static Item PINE_BOAT;
    public static Item RAINBOW_EUCALYPTUS_BOAT;
    public static Item REDWOOD_BOAT;
    public static Item SKYRIS_BOAT;
    public static Item WILLOW_BOAT;
    public static Item WITCH_HAZEL_BOAT;
    public static Item ZELKOVA_BOAT;
    public static Item PALM_BOAT;

    //Trapdoors
    public static Item ASPEN_TRAPDOOR;
    public static Item BAOBAB_TRAPDOOR;
    public static Item BLUE_ENCHANTED_TRAPDOOR;
    public static Item CHERRY_TRAPDOOR;
    public static Item CIKA_TRAPDOOR;
    public static Item CYPRESS_TRAPDOOR;
    public static Item EBONY_TRAPDOOR;
    public static Item FIR_TRAPDOOR;
    public static Item GREEN_ENCHANTED_TRAPDOOR;
    public static Item HOLLY_TRAPDOOR;
    public static Item JACARANDA_TRAPDOOR;
    public static Item MAHOGANY_TRAPDOOR;
    public static Item MANGROVE_TRAPDOOR;
    public static Item MAPLE_TRAPDOOR;
    public static Item PINE_TRAPDOOR;
    public static Item RAINBOW_EUCALYPTUS_TRAPDOOR;
    public static Item REDWOOD_TRAPDOOR;
    public static Item SKYRIS_TRAPDOOR;
    public static Item WILLOW_TRAPDOOR;
    public static Item WITCH_HAZEL_TRAPDOOR;
    public static Item ZELKOVA_TRAPDOOR;
    public static Item SYTHIAN_TRAPDOOR;
    public static Item EMBUR_TRAPDOOR;
    public static Item PALM_TRAPDOOR;
    public static Item LAMENT_TRAPDOOR;

    //Pressure Plate
    public static Item ASPEN_PRESSURE_PLATE;
    public static Item BAOBAB_PRESSURE_PLATE;
    public static Item BLUE_ENCHANTED_PRESSURE_PLATE;
    public static Item CHERRY_PRESSURE_PLATE;
    public static Item CIKA_PRESSURE_PLATE;
    public static Item CYPRESS_PRESSURE_PLATE;
    public static Item EBONY_PRESSURE_PLATE;
    public static Item FIR_PRESSURE_PLATE;
    public static Item GREEN_ENCHANTED_PRESSURE_PLATE;
    public static Item HOLLY_PRESSURE_PLATE;
    public static Item JACARANDA_PRESSURE_PLATE;
    public static Item MAHOGANY_PRESSURE_PLATE;
    public static Item MANGROVE_PRESSURE_PLATE;
    public static Item MAPLE_PRESSURE_PLATE;
    public static Item PINE_PRESSURE_PLATE;
    public static Item RAINBOW_EUCALYPTUS_PRESSURE_PLATE;
    public static Item REDWOOD_PRESSURE_PLATE;
    public static Item SKYRIS_PRESSURE_PLATE;
    public static Item WILLOW_PRESSURE_PLATE;
    public static Item WITCH_HAZEL_PRESSURE_PLATE;
    public static Item ZELKOVA_PRESSURE_PLATE;
    public static Item SYTHIAN_PRESSURE_PLATE;
    public static Item EMBUR_PRESSURE_PLATE;
    public static Item PALM_PRESSURE_PLATE;
    public static Item LAMENT_PRESSURE_PLATE;

    //Buttons
    public static Item ASPEN_BUTTON;
    public static Item BAOBAB_BUTTON;
    public static Item BLUE_ENCHANTED_BUTTON;
    public static Item CHERRY_BUTTON;
    public static Item CIKA_BUTTON;
    public static Item CYPRESS_BUTTON;
    public static Item EBONY_BUTTON;
    public static Item FIR_BUTTON;
    public static Item GREEN_ENCHANTED_BUTTON;
    public static Item HOLLY_BUTTON;
    public static Item JACARANDA_BUTTON;
    public static Item MAHOGANY_BUTTON;
    public static Item MANGROVE_BUTTON;
    public static Item MAPLE_BUTTON;
    public static Item PINE_BUTTON;
    public static Item RAINBOW_EUCALYPTUS_BUTTON;
    public static Item REDWOOD_BUTTON;
    public static Item SKYRIS_BUTTON;
    public static Item WILLOW_BUTTON;
    public static Item WITCH_HAZEL_BUTTON;
    public static Item ZELKOVA_BUTTON;
    public static Item SYTHIAN_BUTTON;
    public static Item EMBUR_BUTTON;
    public static Item PALM_BUTTON;
    public static Item LAMENT_BUTTON;
    
    //Doors
    public static Item ASPEN_DOOR;
    public static Item BAOBAB_DOOR;
    public static Item BLUE_ENCHANTED_DOOR;
    public static Item CHERRY_DOOR;
    public static Item CIKA_DOOR;
    public static Item CYPRESS_DOOR;
    public static Item EBONY_DOOR;
    public static Item FIR_DOOR;
    public static Item GREEN_ENCHANTED_DOOR;
    public static Item HOLLY_DOOR;
    public static Item JACARANDA_DOOR;
    public static Item MAHOGANY_DOOR;
    public static Item MANGROVE_DOOR;
    public static Item MAPLE_DOOR;
    public static Item PINE_DOOR;
    public static Item RAINBOW_EUCALYPTUS_DOOR;
    public static Item REDWOOD_DOOR;
    public static Item SKYRIS_DOOR;
    public static Item WILLOW_DOOR;
    public static Item WITCH_HAZEL_DOOR;
    public static Item ZELKOVA_DOOR;
    public static Item SYTHIAN_DOOR;
    public static Item EMBUR_DOOR;
    public static Item PALM_DOOR;
    public static Item LAMENT_DOOR;

    //Fence Gates
    public static Item ASPEN_FENCE_GATE;
    public static Item BAOBAB_FENCE_GATE;
    public static Item BLUE_ENCHANTED_FENCE_GATE;
    public static Item CHERRY_FENCE_GATE;
    public static Item CIKA_FENCE_GATE;
    public static Item CYPRESS_FENCE_GATE;
    public static Item EBONY_FENCE_GATE;
    public static Item FIR_FENCE_GATE;
    public static Item GREEN_ENCHANTED_FENCE_GATE;
    public static Item HOLLY_FENCE_GATE;
    public static Item JACARANDA_FENCE_GATE;
    public static Item MAHOGANY_FENCE_GATE;
    public static Item MANGROVE_FENCE_GATE;
    public static Item MAPLE_FENCE_GATE;
    public static Item PINE_FENCE_GATE;
    public static Item RAINBOW_EUCALYPTUS_FENCE_GATE;
    public static Item REDWOOD_FENCE_GATE;
    public static Item SKYRIS_FENCE_GATE;
    public static Item WILLOW_FENCE_GATE;
    public static Item WITCH_HAZEL_FENCE_GATE;
    public static Item ZELKOVA_FENCE_GATE;
    public static Item SYTHIAN_FENCE_GATE;
    public static Item EMBUR_FENCE_GATE;
    public static Item PALM_FENCE_GATE;
    public static Item LAMENT_FENCE_GATE;

    //Crafting Tables
    public static Item ASPEN_CRAFTING_TABLE;
    public static Item BAOBAB_CRAFTING_TABLE;
    public static Item BLUE_ENCHANTED_CRAFTING_TABLE;
    public static Item CHERRY_CRAFTING_TABLE;
    public static Item CIKA_CRAFTING_TABLE;
    public static Item CYPRESS_CRAFTING_TABLE;
    public static Item EBONY_CRAFTING_TABLE;
    public static Item FIR_CRAFTING_TABLE;
    public static Item GREEN_ENCHANTED_CRAFTING_TABLE;
    public static Item HOLLY_CRAFTING_TABLE;
    public static Item JACARANDA_CRAFTING_TABLE;
    public static Item MAHOGANY_CRAFTING_TABLE;
    public static Item MANGROVE_CRAFTING_TABLE;
    public static Item MAPLE_CRAFTING_TABLE;
    public static Item PINE_CRAFTING_TABLE;
    public static Item RAINBOW_EUCALYPTUS_CRAFTING_TABLE;
    public static Item REDWOOD_CRAFTING_TABLE;
    public static Item SKYRIS_CRAFTING_TABLE;
    public static Item WILLOW_CRAFTING_TABLE;
    public static Item WITCH_HAZEL_CRAFTING_TABLE;
    public static Item ZELKOVA_CRAFTING_TABLE;
    public static Item SYTHIAN_CRAFTING_TABLE;
    public static Item EMBUR_CRAFTING_TABLE;
    public static Item PALM_CRAFTING_TABLE;
    public static Item LAMENT_CRAFTING_TABLE;

    //Flowers
    public static Item ALPINE_BELLFLOWER;
    public static Item TALL_ALLIUM;
    public static Item ALLIUM_FLOWER_BUSH;
    public static Item PINK_ALLIUM_FLOWER_BUSH;
    public static Item TALL_PINK_ALLIUM;
    public static Item ANGELICA;
    public static Item AZALEA;
    public static Item BEGONIA;
    public static Item BISTORT;
    public static Item BLACK_ROSE;
    public static Item BLUE_SAGE;
    public static Item CALIFORNIA_POPPY;
    public static Item CROCUS;
    public static Item CYAN_ROSE;
    public static Item CYAN_TULIP;
    public static Item DAFFODIL;
    public static Item DELPHINIUM;
    public static Item FAIRY_SLIPPER;
    public static Item FIRECRACKER_FLOWER_BUSH;
    public static Item FOXGLOVE;
    public static Item GOLDEN_SPINED_CACTUS;
    public static Item GREEN_TULIP;
    public static Item GUZMANIA;
    public static Item INCAN_LILY;
    public static Item IRIS;
    public static Item JAPANESE_ORCHID;
    public static Item KOVAN_FLOWER;
    public static Item LAZARUS_BELLFLOWER;
    public static Item LOLIPOP_FLOWER;
    public static Item MAGENTA_TULIP;
    public static Item ORANGE_DAISY;
    public static Item ORSIRIA_ROSE;
    public static Item PEACH_LEATHER_FLOWER;
    public static Item PINK_ALLIUM;
    public static Item PINK_ANEMONE;
    public static Item PINK_DAFFODIL;
    public static Item PINK_ORCHID;
    public static Item PROTEA_FLOWER;
    public static Item PURPLE_ORCHID;
    public static Item PURPLE_SAGE;
    public static Item PURPLE_TULIP;
    public static Item RED_CORNFLOWER;
    public static Item RED_ORCHID;
    public static Item RICHEA;
    public static Item ROSE;
    public static Item SILVER_VASE_FLOWER;
    public static Item SNOWDROPS;
    public static Item TORCH_GINGER;
    public static Item VIOLET_LEATHER_FLOWER;
    public static Item WHITE_ANEMONE;
    public static Item WHITE_SAGE;
    public static Item WINTER_CYCLAMEN;
    public static Item WINTER_ROSE;
    public static Item WINTER_SCILLA;
    public static Item YELLOW_DAFFODIL;
    public static Item YELLOW_TULIP;
    public static Item AMARANTH;
    public static Item CYAN_AMARANTH;
    public static Item ORANGE_AMARANTH;
    public static Item MAGENTA_AMARANTH;
    public static Item PURPLE_AMARANTH;

    //Grass Items
    public static Item MEADOW_GRASSBLOCK;
    public static Item GLOWCELIUM;

    //Dirt Items
    public static Item PEAT;
    public static Item MEADOW_DIRT;
    public static Item MUD_BLOCK;
    public static Item MUD_BRICKS;

    //Sand Items
    public static Item BLUE_SAND;
    public static Item BLACK_SAND;
    public static Item WHITE_SAND;
    public static Item PINK_SAND;
    public static Item PURPLE_SAND;
    public static Item CRACKED_SAND;
    public static Item RED_CRACKED_SAND;

    //Sandstone Items
    public static Item BLUE_SANDSTONE;
    public static Item BLUE_CHISELED_SANDSTONE;
    public static Item BLUE_CUT_SANDSTONE;
    public static Item BLUE_SMOOTH_SANDSTONE;

    public static Item BLACK_SANDSTONE;
    public static Item BLACK_CHISELED_SANDSTONE;
    public static Item BLACK_CUT_SANDSTONE;
    public static Item BLACK_SMOOTH_SANDSTONE;

    public static Item WHITE_SANDSTONE;
    public static Item WHITE_CHISELED_SANDSTONE;
    public static Item WHITE_CUT_SANDSTONE;
    public static Item WHITE_SMOOTH_SANDSTONE;

    public static Item PINK_SANDSTONE;
    public static Item PINK_CHISELED_SANDSTONE;
    public static Item PINK_CUT_SANDSTONE;
    public static Item PINK_SMOOTH_SANDSTONE;

    public static Item PURPLE_SANDSTONE;
    public static Item PURPLE_CHISELED_SANDSTONE;
    public static Item PURPLE_CUT_SANDSTONE;
    public static Item PURPLE_SMOOTH_SANDSTONE;

    //LeaveItems
    public static Item ARAUCARIA_LEAVES;
    public static Item BAOBAB_LEAVES;
    public static Item BLOOMING_WITCH_HAZEL_LEAVES;
    public static Item BLUE_ENCHANTED_LEAVES;
    public static Item BLUE_SPRUCE_LEAVES;
    public static Item BROWN_BIRCH_LEAVES;
    public static Item BROWN_OAK_LEAVES;
    public static Item BROWN_ZELKOVA_LEAVES;
    public static Item CIKA_LEAVES;
    public static Item CYPRESS_LEAVES;
    public static Item EBONY_LEAVES;
    public static Item FIR_LEAVES;
    public static Item FLOWERING_ORCHARD_LEAVES;
    public static Item FLOWERING_PALO_VERDE_LEAVES;
    public static Item ASPEN_LEAVES;
    public static Item GREEN_ENCHANTED_LEAVES;
    public static Item HOLLY_BERRY_LEAVES;
    public static Item HOLLY_LEAVES;
    public static Item JACARANDA_LEAVES;
    public static Item INDIGO_JACARANDA_LEAVES;
    public static Item JOSHUA_LEAVES;
    public static Item RIPE_JOSHUA_LEAVES;
    public static Item MAHOGANY_LEAVES;
    public static Item MANGROVE_LEAVES;
    public static Item MAPLE_LEAVES;
    public static Item ORANGE_BIRCH_LEAVES;
    public static Item ORANGE_OAK_LEAVES;
    public static Item ORANGE_SPRUCE_LEAVES;
    public static Item ORCHARD_LEAVES;
    public static Item PALO_VERDE_LEAVES;
    public static Item PINE_LEAVES;
    public static Item PINK_CHERRY_LEAVES;
    public static Item RAINBOW_EUCALYPTUS_LEAVES;
    public static Item RED_BIRCH_LEAVES;
    public static Item RED_MAPLE_LEAVES;
    public static Item RED_OAK_LEAVES;
    public static Item RED_SPRUCE_LEAVES;
    public static Item REDWOOD_LEAVES;
    public static Item RIPE_ORCHARD_LEAVES;
    public static Item SILVER_MAPLE_LEAVES;
    public static Item SKYRIS_LEAVES_GREEN_APPLE;
    public static Item WHITE_CHERRY_LEAVES;
    public static Item WILLOW_LEAVES;
    public static Item WITCH_HAZEL_LEAVES;
    public static Item YELLOW_BIRCH_LEAVES;
    public static Item YELLOW_SPRUCE_LEAVES;
    public static Item SKYRIS_LEAVES;
    public static Item ZELKOVA_LEAVES;
    public static Item SYTHIAN_WART_BLOCK;
    public static Item PALM_LEAVES;
    public static Item LAMENT_LEAVES;
    public static Item WITHERING_OAK_LEAVES;
    //LogItems
    public static Item ASPEN_LOG;
    public static Item BAOBAB_LOG;
    public static Item BLUE_ENCHANTED_LOG;
    public static Item CHERRY_LOG;
    public static Item CIKA_LOG;
    public static Item CYPRESS_LOG;
    public static Item EBONY_LOG;
    public static Item FIR_LOG;
    public static Item GREEN_ENCHANTED_LOG;
    public static Item HOLLY_LOG;
    public static Item JACARANDA_LOG;
    public static Item MAHOGANY_LOG;
    public static Item MANGROVE_LOG;
    public static Item MAPLE_LOG;
    public static Item PALO_VERDE_LOG;
    public static Item PINE_LOG;
    public static Item RAINBOW_EUCALYPTUS_LOG;
    public static Item REDWOOD_LOG;
    public static Item SKYRIS_LOG;
    public static Item WILLOW_LOG;
    public static Item WITCH_HAZEL_LOG;
    public static Item ZELKOVA_LOG;
    public static Item SYTHIAN_STEM;
    public static Item PALM_LOG;
    public static Item LAMENT_LOG;
    public static Item WITHERING_OAK_LOG;
    //WoodItems
    public static Item ASPEN_WOOD;
    public static Item BAOBAB_WOOD;
    public static Item BLUE_ENCHANTED_WOOD;
    public static Item CHERRY_WOOD;
    public static Item CIKA_WOOD;
    public static Item CYPRESS_WOOD;
    public static Item EBONY_WOOD;
    public static Item FIR_WOOD;
    public static Item GREEN_ENCHANTED_WOOD;
    public static Item HOLLY_WOOD;
    public static Item JACARANDA_WOOD;
    public static Item MAHOGANY_WOOD;
    public static Item MANGROVE_WOOD;
    public static Item MAPLE_WOOD;
    public static Item PALO_VERDE_WOOD;
    public static Item PINE_WOOD;
    public static Item RAINBOW_EUCALYPTUS_WOOD;
    public static Item REDWOOD_WOOD;
    public static Item SKYRIS_WOOD;
    public static Item WILLOW_WOOD;
    public static Item WITCH_HAZEL_WOOD;
    public static Item ZELKOVA_WOOD;
    public static Item SYTHIAN_HYPHAE;
    public static Item EMBUR_HYPHAE;
    public static Item PALM_WOOD;
    public static Item LAMENT_WOOD;
    public static Item WITHERING_OAK_WOOD;
    //StrippedWoodItems
    public static Item STRIPPED_BAOBAB_WOOD;
    public static Item STRIPPED_ASPEN_WOOD;
    public static Item STRIPPED_BLUE_ENCHANTED_WOOD;
    public static Item STRIPPED_CHERRY_WOOD;
    public static Item STRIPPED_CIKA_WOOD;
    public static Item STRIPPED_CYPRESS_WOOD;
    public static Item STRIPPED_EBONY_WOOD;
    public static Item STRIPPED_FIR_WOOD;
    public static Item STRIPPED_GREEN_ENCHANTED_WOOD;
    public static Item STRIPPED_HOLLY_WOOD;
    public static Item STRIPPED_JACARANDA_WOOD;
    public static Item STRIPPED_MAHOGANY_WOOD;
    public static Item STRIPPED_MANGROVE_WOOD;
    public static Item STRIPPED_MAPLE_WOOD;
    public static Item STRIPPED_PALO_VERDE_WOOD;
    public static Item STRIPPED_PINE_WOOD;
    public static Item STRIPPED_RAINBOW_EUCALYPTUS_WOOD;
    public static Item STRIPPED_SKYRIS_WOOD;
    public static Item STRIPPED_WILLOW_WOOD;
    public static Item STRIPPED_REDWOOD_WOOD;
    public static Item STRIPPED_WITCH_HAZEL_WOOD;
    public static Item STRIPPED_ZELKOVA_WOOD;
    public static Item STRIPPED_SYTHIAN_HYPHAE;
    public static Item STRIPPED_EMBUR_HYPHAE;
    public static Item STRIPPED_PALM_WOOD;
    public static Item STRIPPED_LAMENT_WOOD;
    //GlowshroomsItems
    public static Item PURPLE_GLOWSHROOM_BLOCK;
    public static Item BLUE_GLOWSHROOM_BLOCK;
    public static Item RED_GLOWSHROOM_STEM;
    public static Item YELLOW_GLOWSHROOM_STEM;

    //MushroomsItems
    public static Item DEATH_CAP_MUSHROOM_BLOCK;
    public static Item SOUL_SHROOM_BLOCK;
    public static Item PUFF_MUSHROOM_BLOCK;
    public static Item MILKCAP_MUSHROOM_BLOCK;
    public static Item BLEWIT_MUSHROOM_BLOCK;
    public static Item GREEN_MUSHROOM_BLOCK;
    public static Item WHITE_MUSHROOM_STEM;
    public static Item BROWN_MUSHROOM_STEM;
    public static Item SOUL_SHROOM_STEM;


    //MushroomPlantItems
    public static Item SOUL_SHROOM_SPORE;
    public static Item SOUL_SHROOM_SPORE_END;
    public static Item SOUL_SHROOM;
    public static Item DEATH_CAP;
    public static Item BLACK_PUFF;
    public static Item WEEPING_MILKCAP;
    public static Item WOOD_BLEWIT;
    public static Item GREEN_MUSHSHROOM;
    public static Item PURPLE_GLOWSHROOM;
    public static Item BLUE_GLOWSHROOM;

    //GemItems
    public static Item PENDORITE_BLOCK;
    public static Item AMETRINE_BLOCK;
    public static Item ANTHRACITE_BLOCK;

    //OreItems
    public static Item PENDORITE_ORE;
    public static Item AMETRINE_ORE;
    public static Item PERVADED_NETHERRACK;
    public static Item ANTHRACITE_ORE;


    //BookshelvesItems
    public static Item ASPEN_BOOKSHELF;
    public static Item BAOBAB_BOOKSHELF;
    public static Item BLUE_ENCHANTED_BOOKSHELF;
    public static Item CHERRY_BOOKSHELF;
    public static Item CIKA_BOOKSHELF;
    public static Item CYPRESS_BOOKSHELF;
    public static Item EBONY_BOOKSHELF;
    public static Item FIR_BOOKSHELF;
    public static Item GREEN_ENCHANTED_BOOKSHELF;
    public static Item HOLLY_BOOKSHELF;
    public static Item JACARANDA_BOOKSHELF;
    public static Item MAHOGANY_BOOKSHELF;
    public static Item MANGROVE_BOOKSHELF;
    public static Item MAPLE_BOOKSHELF;
    public static Item PINE_BOOKSHELF;
    public static Item RAINBOW_EUCALYPTUS_BOOKSHELF;
    public static Item REDWOOD_BOOKSHELF;
    public static Item SKYRIS_BOOKSHELF;
    public static Item WILLOW_BOOKSHELF;
    public static Item WITCH_HAZEL_BOOKSHELF;
    public static Item ZELKOVA_BOOKSHELF;
    public static Item SYTHIAN_BOOKSHELF;
    public static Item EMBUR_BOOKSHELF;
    public static Item PALM_BOOKSHELF;
    public static Item LAMENT_BOOKSHELF;
    //PlankItems
    public static Item ASPEN_PLANKS;
    public static Item BAOBAB_PLANKS;
    public static Item BLUE_ENCHANTED_PLANKS;
    public static Item CHERRY_PLANKS;
    public static Item CIKA_PLANKS;
    public static Item CYPRESS_PLANKS;
    public static Item EBONY_PLANKS;
    public static Item FIR_PLANKS;
    public static Item GREEN_ENCHANTED_PLANKS;
    public static Item HOLLY_PLANKS;
    public static Item JACARANDA_PLANKS;
    public static Item MAHOGANY_PLANKS;
    public static Item MANGROVE_PLANKS;
    public static Item MAPLE_PLANKS;
    public static Item PINE_PLANKS;
    public static Item RAINBOW_EUCALYPTUS_PLANKS;
    public static Item REDWOOD_PLANKS;
    public static Item SKYRIS_PLANKS;
    public static Item WILLOW_PLANKS;
    public static Item WITCH_HAZEL_PLANKS;
    public static Item ZELKOVA_PLANKS;
    public static Item SYTHIAN_PLANKS;
    public static Item EMBUR_PLANKS;
    public static Item PALM_PLANKS;
    public static Item LAMENT_PLANKS;
    //PetalItems
    public static Item WHITE_PETAL;
    public static Item RED_PETAL;
    public static Item YELLOW_PETAL;
    public static Item PURPLE_PETAL;
    public static Item LIGHT_BLUE_PETAL;
    public static Item BLUE_PETAL;
    public static Item PLANT_STEM;
    public static Item POLLEN_BLOCK;
    public static Item POLLEN_DUST;

    //PlantItems
    public static Item CATTAIL;
    public static Item REEDS;
    public static Item REED_THATCH;
    public static Item REED_THATCH_STAIRS;
    public static Item REED_THATCH_CARPET;
    public static Item REED_THATCH_SLAB;
    public static Item HORSEWEED;
    public static Item MINI_CACTUS;
    public static Item PRICKLY_PEAR_CACTUS;
    public static Item WINTER_SUCCULENT;
    public static Item SHORT_GRASS;
    public static Item POISON_IVY;
    public static Item PRAIRIE_GRASS;
    public static Item TALL_PRAIRIE_GRASS;
    public static Item SKYRIS_VINE;
    public static Item WEEPING_ROOTS_PLANT;
    public static Item TINY_LILYPADS;
    public static Item WINTER_GRASS;
    public static Item WATER_SILK;
    public static Item WEEPING_ROOTS;


    public static Item BLACK_ICE;
    public static Item PACKED_BLACK_ICE;
    public static Item FROST_MAGMA;
    public static Item SUBZERO_ASH;
    public static Item SUBZERO_ASH_BLOCK;

    public static Item WEED_GRASS;
    public static Item WILTED_GRASS;
    public static Item SHORT_BEACH_GRASS;
    public static Item BEACH_GRASS;
    public static Item LEAF_PILE;
    public static Item CLOVER_PATCH;
    public static Item FLOWER_PATCH;

    public static Item BRIMSTONE;
    public static Item BRIM_POWDER;
    public static Item YELLOW_NETHER_BRICKS;
    public static Item YELLOW_NETHER_BRICK;
    public static Item BORIC_CAMPFIRE;
    public static Item HANGING_BONE;
    public static Item QUARTZ_CRYSTAL;
    public static Item QUARTZITE_SAND;
    public static Item RAW_QUARTZ_BLOCK;

    public static Item WITHERED_ROSE_BUSH;
    public static Item LAMENT_VINE;
    public static Item LAMENT_VINE_PLANT;
    public static Item LAMENT_SPROUTS;

    public static Item WHALING_VINES;
    public static Item WHALING_GRASS;
    public static Item MAGMATIC_STONE;
    public static Item SCORCHED_BUSH;
    public static Item SCORCHED_GRASS;

    public static Item MYCELIUM_NETHERRACK;
    public static Item OVERGROWN_NETHERRACK;
    public static Item NETHER_BRISTLE;
    public static Item MOSSY_NETHERRACK;

    public static Item OVERGROWN_CRIMSON_BLACKSTONE;
    public static Item TALL_CRIMSON_ROOTS;
    public static Item CRIMSON_BERRY_BUSH;

    public static Item WARPED_CACTUS;
    public static Item WARPED_BUSH;
    public static Item WARPED_CORAL_BLOCK;
    public static Item WARPED_CORAL;
    public static Item WARPED_CORAL_FAN;
    public static Item WARPED_CORAL_WALL_FAN;
    public static Item NYLIUM_SOUL_SAND;
    public static Item NYLIUM_SOUL_SOIL;

    public static Item SYTHIAN_SPROUT;
    public static Item SYTHIAN_ROOTS;
    public static Item SYTHIAN_STALK_BLOCK;
    public static Item SYTHIAN_SCAFFOLDING;
    public static Item SYTHIAN_STALK;
    public static Item SYTHIAN_NYLIUM;
    public static Item SYTHIAN_FUNGUS;
    public static Item HANGING_SYTHIAN_ROOTS;
    public static Item HANGING_SYTHIAN_ROOTS_PLANT;


    public static Item EMBUR_NYLIUM;
    public static Item EMBUR_PEDU;
    public static Item EMBUR_SPROUTS;
    public static Item EMBUR_ROOTS;
    public static Item TALL_EMBUR_ROOTS;
    public static Item EMBUR_WART;
    public static Item EMBUR_GEL_BLOCK;
    public static Item EMBUR_GEL_BALL;
    public static Item EMBUR_GEL_VINES;
    public static Item EMBUR_LILY;

    public static Item BLUE_NETHERRACK;
    public static Item BLUE_NETHERRACK_BRICKS;
    public static Item BLUE_NETHERRACK_BRICK;

    public static Item IVIS_PHYLIUM;
    public static Item IVIS_ROOTS;
    public static Item IVIS_SPROUT;


    //Glowcane Item

    public static Item BLUE_GLOWCANE;
    public static Item RED_GLOWCANE;
    public static Item PINK_GLOWCANE;
    public static Item PURPLE_GLOWCANE;

    public static Item BLUE_GLOWCANE_DUST;
    public static Item RED_GLOWCANE_DUST;
    public static Item PINK_GLOWCANE_DUST;
    public static Item PURPLE_GLOWCANE_DUST;

    //Glowcane Item

    public static Item BLUE_GLOWCANE_BLOCK;
    public static Item RED_GLOWCANE_BLOCK;
    public static Item PINK_GLOWCANE_BLOCK;
    public static Item PURPLE_GLOWCANE_BLOCK;

    //Decorations
    public static Item GLOWSTONE_LAMP;
    public static Item GLOWSTONE_LANTERN;
    public static Item PINK_CHERRY_FOLIAGE;
    public static Item WHITE_CHERRY_FOLIAGE;

    //SaplingItems
    public static Item ARAUCARIA_SAPLING;
    public static Item ASPEN_SAPLING;
    public static Item BAOBAB_SAPLING;
    public static Item BLUE_ENCHANTED_SAPLING;
    public static Item BLUE_SPRUCE_SAPLING;
    public static Item BROWN_BIRCH_SAPLING;
    public static Item BROWN_OAK_SAPLING;
    public static Item BROWN_ZELKOVA_SAPLING;
    public static Item CIKA_SAPLING;
    public static Item CYPRESS_SAPLING;
    public static Item EBONY_SAPLING;
    public static Item FIR_SAPLING;
    public static Item GREEN_ENCHANTED_SAPLING;
    public static Item HOLLY_SAPLING;
    public static Item JACARANDA_SAPLING;
    public static Item INDIGO_JACARANDA_SAPLING;
    public static Item JOSHUA_SAPLING;
    public static Item MAHOGANY_SAPLING;
    public static Item MANGROVE_SAPLING;
    public static Item MAPLE_SAPLING;
    public static Item ORANGE_BIRCH_SAPLING;
    public static Item ORANGE_OAK_SAPLING;
    public static Item ORANGE_SPRUCE_SAPLING;
    public static Item ORCHARD_SAPLING;
    public static Item PALO_VERDE_SAPLING;
    public static Item PINE_SAPLING;
    public static Item PINK_CHERRY_SAPLING;
    public static Item RAINBOW_EUCALYPTUS_SAPLING;
    public static Item RED_BIRCH_SAPLING;
    public static Item RED_MAPLE_SAPLING;
    public static Item RED_OAK_SAPLING;
    public static Item RED_SPRUCE_SAPLING;
    public static Item REDWOOD_SAPLING;
    public static Item SILVER_MAPLE_SAPLING;
    public static Item SKYRIS_SAPLING;
    public static Item WHITE_CHERRY_SAPLING;
    public static Item WILLOW_SAPLING;
    public static Item WITCH_HAZEL_SAPLING;
    public static Item YELLOW_BIRCH_SAPLING;
    public static Item YELLOW_SPRUCE_SAPLING;
    public static Item ZELKOVA_SAPLING;
    public static Item PALM_SAPLING;
    public static Item LAMENT_SAPLING;
    public static Item WITHERING_OAK_SAPLING;
    //SlabItems
    public static Item ASPEN_SLAB;
    public static Item BAOBAB_SLAB;
    public static Item BLUE_ENCHANTED_SLAB;
    public static Item CHERRY_SLAB;
    public static Item CIKA_SLAB;
    public static Item CYPRESS_SLAB;
    public static Item EBONY_SLAB;
    public static Item FIR_SLAB;
    public static Item GREEN_ENCHANTED_SLAB;
    public static Item HOLLY_SLAB;
    public static Item JACARANDA_SLAB;
    public static Item MAHOGANY_SLAB;
    public static Item MANGROVE_SLAB;
    public static Item MAPLE_SLAB;
    public static Item PINE_SLAB;
    public static Item RAINBOW_EUCALYPTUS_SLAB;
    public static Item REDWOOD_SLAB;
    public static Item SKYRIS_SLAB;
    public static Item WILLOW_SLAB;
    public static Item WITCH_HAZEL_SLAB;
    public static Item ZELKOVA_SLAB;
    public static Item SYTHIAN_SLAB;
    public static Item EMBUR_SLAB;
    public static Item PALM_SLAB;
    public static Item LAMENT_SLAB;
    //StairItems
    public static Item ASPEN_STAIRS;
    public static Item BAOBAB_STAIRS;
    public static Item BLUE_ENCHANTED_STAIRS;
    public static Item CHERRY_STAIRS;
    public static Item CIKA_STAIRS;
    public static Item CYPRESS_STAIRS;
    public static Item EBONY_STAIRS;
    public static Item FIR_STAIRS;
    public static Item GREEN_ENCHANTED_STAIRS;
    public static Item HOLLY_STAIRS;
    public static Item JACARANDA_STAIRS;
    public static Item MAHOGANY_STAIRS;
    public static Item MANGROVE_STAIRS;
    public static Item MAPLE_STAIRS;
    public static Item PINE_STAIRS;
    public static Item RAINBOW_EUCALYPTUS_STAIRS;
    public static Item REDWOOD_STAIRS;
    public static Item SKYRIS_STAIRS;
    public static Item WILLOW_STAIRS;
    public static Item WITCH_HAZEL_STAIRS;
    public static Item ZELKOVA_STAIRS;
    public static Item SYTHIAN_STAIRS;
    public static Item EMBUR_STAIRS;
    public static Item PALM_STAIRS;
    public static Item LAMENT_STAIRS;
    //StoneItems
    public static Item DACITE;
    public static Item DACITE_SLAB;
    public static Item DACITE_STAIRS;
    public static Item DACITE_WALL;
    public static Item DACITE_COBBLESTONE;
    public static Item DACITE_COBBLESTONE_SLAB;
    public static Item DACITE_COBBLESTONE_STAIRS;
    public static Item DACITE_COBBLESTONE_WALL;
    public static Item DACITE_PILLAR;
    public static Item DACITE_TILE;
    public static Item DACITE_TILE_SLAB;
    public static Item DACITE_TILE_STAIRS;
    public static Item DACITE_TILE_WALL;
    public static Item DACITE_BRICKS;
    public static Item DACITE_BRICK_SLAB;
    public static Item DACITE_BRICK_STAIRS;
    public static Item DACITE_BRICK_WALL;

    public static Item RED_ROCK;
    public static Item RED_ROCK_SLAB;
    public static Item RED_ROCK_STAIRS;
    public static Item RED_ROCK_WALL;
    public static Item RED_ROCK_BRICKS;
    public static Item RED_ROCK_BRICK_SLAB;
    public static Item RED_ROCK_BRICK_STAIRS;
    public static Item RED_ROCK_BRICK_WALL;
    public static Item CRACKED_RED_ROCK_BRICKS;
    public static Item CRACKED_RED_ROCK_BRICK_SLAB;
    public static Item CRACKED_RED_ROCK_BRICK_STAIRS;
    public static Item CRACKED_RED_ROCK_BRICK_WALL;
    public static Item CHISELED_RED_ROCK_BRICKS;
    public static Item CHISELED_RED_ROCK_BRICK_SLAB;
    public static Item CHISELED_RED_ROCK_BRICK_STAIRS;
    public static Item CHISELED_RED_ROCK_BRICK_WALL;
    public static Item MOSSY_RED_ROCK_BRICKS;
    public static Item MOSSY_RED_ROCK_BRICK_SLAB;
    public static Item MOSSY_RED_ROCK_BRICK_STAIRS;
    public static Item MOSSY_RED_ROCK_BRICK_WALL;

    public static Item SOAPSTONE;
    public static Item SOAPSTONE_SLAB;
    public static Item SOAPSTONE_STAIRS;
    public static Item SOAPSTONE_WALL;
    public static Item POLISHED_SOAPSTONE;
    public static Item POLISHED_SOAPSTONE_SLAB;
    public static Item POLISHED_SOAPSTONE_STAIRS;
    public static Item POLISHED_SOAPSTONE_WALL;
    public static Item SOAPSTONE_PILLAR;
    public static Item SOAPSTONE_TILE;
    public static Item SOAPSTONE_TILE_SLAB;
    public static Item SOAPSTONE_TILE_STAIRS;
    public static Item SOAPSTONE_TILE_WALL;
    public static Item SOAPSTONE_BRICKS;
    public static Item SOAPSTONE_BRICK_SLAB;
    public static Item SOAPSTONE_BRICK_STAIRS;
    public static Item SOAPSTONE_BRICK_WALL;

    public static Item SCORIA_STONE;
    public static Item SCORIA_SLAB;
    public static Item SCORIA_STAIRS;
    public static Item SCORIA_WALL;
    public static Item SCORIA_COBBLESTONE;
    public static Item SCORIA_COBBLESTONE_SLAB;
    public static Item SCORIA_COBBLESTONE_STAIRS;
    public static Item SCORIA_COBBLESTONE_WALL;
    public static Item SCORIA_PILLAR;
    public static Item SCORIA_STONEBRICKS;
    public static Item SCORIA_STONEBRICK_SLAB;
    public static Item SCORIA_STONEBRICK_STAIRS;
    public static Item SCORIA_STONEBRICK_WALL;

    public static Item MOSSY_STONE;
    public static Item MOSSY_STONE_SLAB;
    public static Item MOSSY_STONE_STAIRS;
    public static Item MOSSY_STONE_WALL;
    public static Item ROCKY_STONE;
    public static Item ROCKY_SLAB;
    public static Item ROCKY_STAIRS;
    public static Item ROCKY_WALL;
    public static Item OVERGROWN_STONE;
    public static Item STONE_FARMLAND;
    public static Item OVERGROWN_DACITE;
    public static Item DACITE_FARMLAND;
    public static Item PODZOL_DACITE;

    //StrippedLogItems
    public static Item STRIPPED_BAOBAB_LOG;
    public static Item STRIPPED_ASPEN_LOG;
    public static Item STRIPPED_BLUE_ENCHANTED_LOG;
    public static Item STRIPPED_CHERRY_LOG;
    public static Item STRIPPED_CIKA_LOG;
    public static Item STRIPPED_CYPRESS_LOG;
    public static Item STRIPPED_EBONY_LOG;
    public static Item STRIPPED_FIR_LOG;
    public static Item STRIPPED_GREEN_ENCHANTED_LOG;
    public static Item STRIPPED_HOLLY_LOG;
    public static Item STRIPPED_JACARANDA_LOG;
    public static Item STRIPPED_MAHOGANY_LOG;
    public static Item STRIPPED_MANGROVE_LOG;
    public static Item STRIPPED_MAPLE_LOG;
    public static Item STRIPPED_PALO_VERDE_LOG;
    public static Item STRIPPED_PINE_LOG;
    public static Item STRIPPED_RAINBOW_EUCALYPTUS_LOG;
    public static Item STRIPPED_SKYRIS_LOG;
    public static Item STRIPPED_WILLOW_LOG;
    public static Item STRIPPED_REDWOOD_LOG;
    public static Item STRIPPED_WITCH_HAZEL_LOG;
    public static Item STRIPPED_ZELKOVA_LOG;
    public static Item STRIPPED_SYTHIAN_STEM;
    public static Item STRIPPED_EMBUR_PEDU;
    public static Item STRIPPED_PALM_LOG;
    public static Item STRIPPED_LAMENT_LOG;
    //Gems Items
    public static Item PENDORITE_SCRAPS;
    public static Item AMETRINE_GEMS;
    public static Item ANTHRACITE;
    public static Item CHAIN_PLATING;

    public static Item PENDORITE_SWORD;
    public static Item PENDORITE_AXE;
    public static Item PENDORITE_PICK;
    public static Item PENDORITE_BATTLEAXE;
    public static Item PENDORITE_HOE;
    public static Item PENDORITE_SHOVEL;

    //Armor Items
    public static Item AMETRINE_HELMET;
    public static Item AMETRINE_CHEST;
    public static Item AMETRINE_LEGGINGS;
    public static Item AMETRINE_BOOTS;

    public static Item PENDORITE_HELMET;
    public static Item PENDORITE_CHEST;
    public static Item PENDORITE_LEGGINGS;
    public static Item PENDORITE_BOOTS;

    //Shield Items
    public static Item AMETRINE_SHIELD;
    public static Item PENDORITE_SHIELD;

    //Horse Armor
    public static Item AMETRINE_HORSE_ARMOR;
    public static Item PENDORITE_HORSE_ARMOR;


    public static void registerItems(IForgeRegistry<Item> registry) {
        registry.registerAll(
                BYGItems.BYG_LOGO = new Item((new Item.Properties())).setRegistryName("byg_logo"),

                BYGItems.PEAT = new BlockItem(BYGBlocks.PEAT, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PEAT.getRegistryName()),
                BYGItems.MEADOW_GRASSBLOCK = new BlockItem(BYGBlocks.MEADOW_GRASSBLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MEADOW_GRASSBLOCK.getRegistryName()),
                BYGItems.GLOWCELIUM = new BlockItem(BYGBlocks.GLOWCELIUM, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.GLOWCELIUM.getRegistryName()),
                BYGItems.MEADOW_DIRT = new BlockItem(BYGBlocks.MEADOW_DIRT, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MEADOW_DIRT.getRegistryName()),
                BYGItems.MUD_BALL = new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName("mud_ball"),
                BYGItems.MUD_BLOCK = new BlockItem(BYGBlocks.MUD_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MUD_BLOCK.getRegistryName()),
                BYGItems.MUD_BRICKS = new BlockItem(BYGBlocks.MUD_BRICKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MUD_BRICKS.getRegistryName()),

                BYGItems.CHAIN_PLATING = new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName("chain_plating"),

                BYGItems.AMETRINE_GEMS = new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName("ametrine_gems"),
                BYGItems.AMETRINE_ORE = new BlockItem(BYGBlocks.AMETRINE_ORE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.AMETRINE_ORE.getRegistryName()),
                BYGItems.AMETRINE_BLOCK = new BlockItem(BYGBlocks.AMETRINE_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.AMETRINE_BLOCK.getRegistryName()),
                BYGItems.AMETRINE_HELMET = new BYGArmorItem(BYGArmorTiers.AMETRINE, EquipmentSlotType.HEAD, (new Item.Properties()).group(BYGCreativeTab.creativeTab)).setRegistryName("ametrine_helmet"),
                BYGItems.AMETRINE_CHEST = new BYGArmorItem(BYGArmorTiers.AMETRINE, EquipmentSlotType.CHEST, (new Item.Properties()).group(BYGCreativeTab.creativeTab)).setRegistryName("ametrine_chestplate"),
                BYGItems.AMETRINE_LEGGINGS = new BYGArmorItem(BYGArmorTiers.AMETRINE, EquipmentSlotType.LEGS, (new Item.Properties()).group(BYGCreativeTab.creativeTab)).setRegistryName("ametrine_leggings"),
                BYGItems.AMETRINE_BOOTS = new BYGArmorItem(BYGArmorTiers.AMETRINE, EquipmentSlotType.FEET, (new Item.Properties()).group(BYGCreativeTab.creativeTab)).setRegistryName("ametrine_boots"),
                BYGItems.AMETRINE_HORSE_ARMOR = new BYGHorseArmor(15, "ametrine", (new Item.Properties()).maxStackSize(1).group(BYGCreativeTab.creativeTab)).setRegistryName("ametrine_horse_armor"),

                BYGItems.PENDORITE_SCRAPS = new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName("pendorite_scraps"),
                BYGItems.PENDORITE_ORE = new BlockItem(BYGBlocks.PENDORITE_ORE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PENDORITE_ORE.getRegistryName()),
                BYGItems.PENDORITE_BLOCK = new BlockItem(BYGBlocks.PENDORITE_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PENDORITE_BLOCK.getRegistryName()),
                BYGItems.PENDORITE_AXE = new AxeItem(BYGItemTiers.PENDORITE, 6.0F, -3.0F, (new Item.Properties()).group(BYGCreativeTab.creativeTab)).setRegistryName("pendorite_axe"),
                BYGItems.PENDORITE_PICK = new PickaxeItem(BYGItemTiers.PENDORITE, 2, -2.8F, (new Item.Properties()).group(BYGCreativeTab.creativeTab)).setRegistryName("pendorite_pickaxe"),
                BYGItems.PENDORITE_SWORD = new SwordItem(BYGItemTiers.PENDORITE, 4, -2.4F, (new Item.Properties()).group(BYGCreativeTab.creativeTab)).setRegistryName("pendorite_sword"),
                BYGItems.PENDORITE_BATTLEAXE = new AxeItem(BYGItemTiers.PENDORITE, 7.0F, -3.3F, (new Item.Properties()).group(BYGCreativeTab.creativeTab)).setRegistryName("pendorite_battleaxe"),
                BYGItems.PENDORITE_SHOVEL = new ShovelItem(BYGItemTiers.PENDORITE, 2.0F, -3.0F, (new Item.Properties()).group(BYGCreativeTab.creativeTab)).setRegistryName("pendorite_shovel"),
                BYGItems.PENDORITE_HOE = new HoeItem(BYGItemTiers.PENDORITE, 0, 0.0F, (new Item.Properties()).group(BYGCreativeTab.creativeTab)).setRegistryName("pendorite_hoe"),

                BYGItems.PENDORITE_HORSE_ARMOR = new BYGHorseArmor(11, "pendorite", (new Item.Properties()).maxStackSize(1).group(BYGCreativeTab.creativeTab)).setRegistryName("pendorite_horse_armor"),

                BYGItems.DACITE = new BlockItem(BYGBlocks.DACITE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.DACITE.getRegistryName()),
                BYGItems.DACITE_STAIRS = new BlockItem(BYGBlocks.DACITE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.DACITE_STAIRS.getRegistryName()),
                BYGItems.DACITE_SLAB = new BlockItem(BYGBlocks.DACITE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.DACITE_SLAB.getRegistryName()),
                BYGItems.DACITE_WALL = new BlockItem(BYGBlocks.DACITE_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.DACITE_WALL.getRegistryName()),

                BYGItems.DACITE_BRICKS = new BlockItem(BYGBlocks.DACITE_BRICKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.DACITE_BRICKS.getRegistryName()),
                BYGItems.DACITE_BRICK_STAIRS = new BlockItem(BYGBlocks.DACITE_BRICK_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.DACITE_BRICK_STAIRS.getRegistryName()),
                BYGItems.DACITE_BRICK_SLAB = new BlockItem(BYGBlocks.DACITE_BRICK_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.DACITE_BRICK_SLAB.getRegistryName()),
                BYGItems.DACITE_BRICK_WALL = new BlockItem(BYGBlocks.DACITE_BRICK_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.DACITE_BRICK_WALL.getRegistryName()),

                BYGItems.DACITE_COBBLESTONE = new BlockItem(BYGBlocks.DACITE_COBBLESTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.DACITE_COBBLESTONE.getRegistryName()),
                BYGItems.DACITE_COBBLESTONE_STAIRS = new BlockItem(BYGBlocks.DACITE_COBBLESTONE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.DACITE_COBBLESTONE_STAIRS.getRegistryName()),
                BYGItems.DACITE_COBBLESTONE_SLAB = new BlockItem(BYGBlocks.DACITE_COBBLESTONE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.DACITE_COBBLESTONE_SLAB.getRegistryName()),
                BYGItems.DACITE_COBBLESTONE_WALL = new BlockItem(BYGBlocks.DACITE_COBBLESTONE_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.DACITE_COBBLESTONE_WALL.getRegistryName()),

                BYGItems.DACITE_PILLAR = new BlockItem(BYGBlocks.DACITE_PILLAR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.DACITE_PILLAR.getRegistryName()),
                BYGItems.DACITE_TILE = new BlockItem(BYGBlocks.DACITE_TILE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.DACITE_TILE.getRegistryName()),
                BYGItems.DACITE_TILE_STAIRS = new BlockItem(BYGBlocks.DACITE_TILE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.DACITE_TILE_STAIRS.getRegistryName()),
                BYGItems.DACITE_TILE_SLAB = new BlockItem(BYGBlocks.DACITE_TILE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.DACITE_TILE_SLAB.getRegistryName()),
                BYGItems.DACITE_TILE_WALL = new BlockItem(BYGBlocks.DACITE_TILE_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.DACITE_TILE_WALL.getRegistryName()),

                BYGItems.MOSSY_STONE = new BlockItem(BYGBlocks.MOSSY_STONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MOSSY_STONE.getRegistryName()),
                BYGItems.MOSSY_STONE_STAIRS = new BlockItem(BYGBlocks.MOSSY_STONE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MOSSY_STONE_STAIRS.getRegistryName()),
                BYGItems.MOSSY_STONE_SLAB = new BlockItem(BYGBlocks.MOSSY_STONE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MOSSY_STONE_SLAB.getRegistryName()),
                BYGItems.MOSSY_STONE_WALL = new BlockItem(BYGBlocks.MOSSY_STONE_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MOSSY_STONE_WALL.getRegistryName()),

                BYGItems.PODZOL_DACITE = new BlockItem(BYGBlocks.PODZOL_DACITE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PODZOL_DACITE.getRegistryName()),
                BYGItems.OVERGROWN_DACITE = new BlockItem(BYGBlocks.OVERGROWN_DACITE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.OVERGROWN_DACITE.getRegistryName()),
                BYGItems.OVERGROWN_STONE = new BlockItem(BYGBlocks.OVERGROWN_STONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.OVERGROWN_STONE.getRegistryName()),

                BYGItems.RED_ROCK = new BlockItem(BYGBlocks.RED_ROCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RED_ROCK.getRegistryName()),
                BYGItems.RED_ROCK_STAIRS = new BlockItem(BYGBlocks.RED_ROCK_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RED_ROCK_STAIRS.getRegistryName()),
                BYGItems.RED_ROCK_SLAB = new BlockItem(BYGBlocks.RED_ROCK_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RED_ROCK_SLAB.getRegistryName()),
                BYGItems.RED_ROCK_WALL = new BlockItem(BYGBlocks.RED_ROCK_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RED_ROCK_WALL.getRegistryName()),

                BYGItems.RED_ROCK_BRICKS = new BlockItem(BYGBlocks.RED_ROCK_BRICKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RED_ROCK_BRICKS.getRegistryName()),
                BYGItems.RED_ROCK_BRICK_STAIRS = new BlockItem(BYGBlocks.RED_ROCK_BRICK_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RED_ROCK_BRICK_STAIRS.getRegistryName()),
                BYGItems.RED_ROCK_BRICK_SLAB = new BlockItem(BYGBlocks.RED_ROCK_BRICK_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RED_ROCK_BRICK_SLAB.getRegistryName()),
                BYGItems.RED_ROCK_BRICK_WALL = new BlockItem(BYGBlocks.RED_ROCK_BRICK_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RED_ROCK_BRICK_WALL.getRegistryName()),

                BYGItems.MOSSY_RED_ROCK_BRICKS = new BlockItem(BYGBlocks.MOSSY_RED_ROCK_BRICKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MOSSY_RED_ROCK_BRICKS.getRegistryName()),
                BYGItems.MOSSY_RED_ROCK_BRICK_STAIRS = new BlockItem(BYGBlocks.MOSSY_RED_ROCK_BRICK_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MOSSY_RED_ROCK_BRICK_STAIRS.getRegistryName()),
                BYGItems.MOSSY_RED_ROCK_BRICK_SLAB = new BlockItem(BYGBlocks.MOSSY_RED_ROCK_BRICK_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MOSSY_RED_ROCK_BRICK_SLAB.getRegistryName()),
                BYGItems.MOSSY_RED_ROCK_BRICK_WALL = new BlockItem(BYGBlocks.MOSSY_RED_ROCK_BRICK_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MOSSY_RED_ROCK_BRICK_WALL.getRegistryName()),

                BYGItems.CHISELED_RED_ROCK_BRICKS = new BlockItem(BYGBlocks.CHISELED_RED_ROCK_BRICKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CHISELED_RED_ROCK_BRICKS.getRegistryName()),
                BYGItems.CHISELED_RED_ROCK_BRICK_STAIRS = new BlockItem(BYGBlocks.CHISELED_RED_ROCK_BRICK_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CHISELED_RED_ROCK_BRICK_STAIRS.getRegistryName()),
                BYGItems.CHISELED_RED_ROCK_BRICK_SLAB = new BlockItem(BYGBlocks.CHISELED_RED_ROCK_BRICK_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CHISELED_RED_ROCK_BRICK_SLAB.getRegistryName()),
                BYGItems.CHISELED_RED_ROCK_BRICK_WALL = new BlockItem(BYGBlocks.CHISELED_RED_ROCK_BRICK_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CHISELED_RED_ROCK_BRICK_WALL.getRegistryName()),

                BYGItems.CRACKED_RED_ROCK_BRICKS = new BlockItem(BYGBlocks.CRACKED_RED_ROCK_BRICKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CRACKED_RED_ROCK_BRICKS.getRegistryName()),
                BYGItems.CRACKED_RED_ROCK_BRICK_STAIRS = new BlockItem(BYGBlocks.CRACKED_RED_ROCK_BRICK_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CRACKED_RED_ROCK_BRICK_STAIRS.getRegistryName()),
                BYGItems.CRACKED_RED_ROCK_BRICK_SLAB = new BlockItem(BYGBlocks.CRACKED_RED_ROCK_BRICK_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CRACKED_RED_ROCK_BRICK_SLAB.getRegistryName()),
                BYGItems.CRACKED_RED_ROCK_BRICK_WALL = new BlockItem(BYGBlocks.CRACKED_RED_ROCK_BRICK_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CRACKED_RED_ROCK_BRICK_WALL.getRegistryName()),


                BYGItems.ROCKY_STONE = new BlockItem(BYGBlocks.ROCKY_STONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ROCKY_STONE.getRegistryName()),
                BYGItems.ROCKY_STAIRS = new BlockItem(BYGBlocks.ROCKY_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ROCKY_STAIRS.getRegistryName()),
                BYGItems.ROCKY_SLAB = new BlockItem(BYGBlocks.ROCKY_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ROCKY_SLAB.getRegistryName()),
                BYGItems.ROCKY_WALL = new BlockItem(BYGBlocks.ROCKY_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ROCKY_WALL.getRegistryName()),

                BYGItems.SCORIA_STONE = new BlockItem(BYGBlocks.SCORIA_STONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SCORIA_STONE.getRegistryName()),
                BYGItems.SCORIA_STAIRS = new BlockItem(BYGBlocks.SCORIA_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SCORIA_STAIRS.getRegistryName()),
                BYGItems.SCORIA_SLAB = new BlockItem(BYGBlocks.SCORIA_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SCORIA_SLAB.getRegistryName()),
                BYGItems.SCORIA_WALL = new BlockItem(BYGBlocks.SCORIA_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SCORIA_WALL.getRegistryName()),

                BYGItems.SCORIA_COBBLESTONE = new BlockItem(BYGBlocks.SCORIA_COBBLESTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SCORIA_COBBLESTONE.getRegistryName()),
                BYGItems.SCORIA_COBBLESTONE_STAIRS = new BlockItem(BYGBlocks.SCORIA_COBBLESTONE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SCORIA_COBBLESTONE_STAIRS.getRegistryName()),
                BYGItems.SCORIA_COBBLESTONE_SLAB = new BlockItem(BYGBlocks.SCORIA_COBBLESTONE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SCORIA_COBBLESTONE_SLAB.getRegistryName()),
                BYGItems.SCORIA_COBBLESTONE_WALL = new BlockItem(BYGBlocks.SCORIA_COBBLESTONE_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SCORIA_COBBLESTONE_WALL.getRegistryName()),

                BYGItems.SCORIA_PILLAR = new BlockItem(BYGBlocks.SCORIA_PILLAR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SCORIA_PILLAR.getRegistryName()),
                BYGItems.SCORIA_STONEBRICKS = new BlockItem(BYGBlocks.SCORIA_STONEBRICKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SCORIA_STONEBRICKS.getRegistryName()),
                BYGItems.SCORIA_STONEBRICK_STAIRS = new BlockItem(BYGBlocks.SCORIA_STONEBRICK_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SCORIA_STONEBRICK_STAIRS.getRegistryName()),
                BYGItems.SCORIA_STONEBRICK_SLAB = new BlockItem(BYGBlocks.SCORIA_STONEBRICK_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SCORIA_STONEBRICK_SLAB.getRegistryName()),
                BYGItems.SCORIA_STONEBRICK_WALL = new BlockItem(BYGBlocks.SCORIA_STONEBRICK_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SCORIA_STONEBRICK_WALL.getRegistryName()),

                BYGItems.SOAPSTONE = new BlockItem(BYGBlocks.SOAPSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SOAPSTONE.getRegistryName()),
                BYGItems.SOAPSTONE_STAIRS = new BlockItem(BYGBlocks.SOAPSTONE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SOAPSTONE_STAIRS.getRegistryName()),
                BYGItems.SOAPSTONE_SLAB = new BlockItem(BYGBlocks.SOAPSTONE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SOAPSTONE_SLAB.getRegistryName()),
                BYGItems.SOAPSTONE_WALL = new BlockItem(BYGBlocks.SOAPSTONE_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SOAPSTONE_WALL.getRegistryName()),

                BYGItems.POLISHED_SOAPSTONE = new BlockItem(BYGBlocks.POLISHED_SOAPSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.POLISHED_SOAPSTONE.getRegistryName()),
                BYGItems.POLISHED_SOAPSTONE_STAIRS = new BlockItem(BYGBlocks.POLISHED_SOAPSTONE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.POLISHED_SOAPSTONE_STAIRS.getRegistryName()),
                BYGItems.POLISHED_SOAPSTONE_SLAB = new BlockItem(BYGBlocks.POLISHED_SOAPSTONE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.POLISHED_SOAPSTONE_SLAB.getRegistryName()),
                BYGItems.POLISHED_SOAPSTONE_WALL = new BlockItem(BYGBlocks.POLISHED_SOAPSTONE_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.POLISHED_SOAPSTONE_WALL.getRegistryName()),

                BYGItems.SOAPSTONE_BRICKS = new BlockItem(BYGBlocks.SOAPSTONE_BRICKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SOAPSTONE_BRICKS.getRegistryName()),
                BYGItems.SOAPSTONE_BRICK_STAIRS = new BlockItem(BYGBlocks.SOAPSTONE_BRICK_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SOAPSTONE_BRICK_STAIRS.getRegistryName()),
                BYGItems.SOAPSTONE_BRICK_SLAB = new BlockItem(BYGBlocks.SOAPSTONE_BRICK_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SOAPSTONE_BRICK_SLAB.getRegistryName()),
                BYGItems.SOAPSTONE_BRICK_WALL = new BlockItem(BYGBlocks.SOAPSTONE_BRICK_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SOAPSTONE_BRICK_WALL.getRegistryName()),

                BYGItems.SOAPSTONE_PILLAR = new BlockItem(BYGBlocks.SOAPSTONE_PILLAR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SOAPSTONE_PILLAR.getRegistryName()),
                BYGItems.SOAPSTONE_TILE = new BlockItem(BYGBlocks.SOAPSTONE_TILE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SOAPSTONE_TILE.getRegistryName()),
                BYGItems.SOAPSTONE_TILE_STAIRS = new BlockItem(BYGBlocks.SOAPSTONE_TILE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SOAPSTONE_TILE_STAIRS.getRegistryName()),
                BYGItems.SOAPSTONE_TILE_SLAB = new BlockItem(BYGBlocks.SOAPSTONE_TILE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SOAPSTONE_TILE_SLAB.getRegistryName()),
                BYGItems.SOAPSTONE_TILE_WALL = new BlockItem(BYGBlocks.SOAPSTONE_TILE_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SOAPSTONE_TILE_WALL.getRegistryName()),

                BYGItems.BLACK_SAND = new BlockItem(BYGBlocks.BLACK_SAND, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLACK_SAND.getRegistryName()),
                BYGItems.BLACK_SANDSTONE = new BlockItem(BYGBlocks.BLACK_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLACK_SANDSTONE.getRegistryName()),
                BYGItems.BLACK_CHISELED_SANDSTONE = new BlockItem(BYGBlocks.BLACK_CHISELED_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLACK_CHISELED_SANDSTONE.getRegistryName()),
                BYGItems.BLACK_CUT_SANDSTONE = new BlockItem(BYGBlocks.BLACK_CUT_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLACK_CUT_SANDSTONE.getRegistryName()),
                BYGItems.BLACK_SMOOTH_SANDSTONE = new BlockItem(BYGBlocks.BLACK_SMOOTH_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLACK_SMOOTH_SANDSTONE.getRegistryName()),

                BYGItems.WHITE_SAND = new BlockItem(BYGBlocks.WHITE_SAND, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WHITE_SAND.getRegistryName()),
                BYGItems.WHITE_SANDSTONE = new BlockItem(BYGBlocks.WHITE_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WHITE_SANDSTONE.getRegistryName()),
                BYGItems.WHITE_CHISELED_SANDSTONE = new BlockItem(BYGBlocks.WHITE_CHISELED_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WHITE_CHISELED_SANDSTONE.getRegistryName()),
                BYGItems.WHITE_CUT_SANDSTONE = new BlockItem(BYGBlocks.WHITE_CUT_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WHITE_CUT_SANDSTONE.getRegistryName()),
                BYGItems.WHITE_SMOOTH_SANDSTONE = new BlockItem(BYGBlocks.WHITE_SMOOTH_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WHITE_SMOOTH_SANDSTONE.getRegistryName()),

                BYGItems.BLUE_SAND = new BlockItem(BYGBlocks.BLUE_SAND, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_SAND.getRegistryName()),
                BYGItems.BLUE_SANDSTONE = new BlockItem(BYGBlocks.BLUE_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_SANDSTONE.getRegistryName()),
                BYGItems.BLUE_CHISELED_SANDSTONE = new BlockItem(BYGBlocks.BLUE_CHISELED_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_CHISELED_SANDSTONE.getRegistryName()),
                BYGItems.BLUE_CUT_SANDSTONE = new BlockItem(BYGBlocks.BLUE_CUT_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_CUT_SANDSTONE.getRegistryName()),
                BYGItems.BLUE_SMOOTH_SANDSTONE = new BlockItem(BYGBlocks.BLUE_SMOOTH_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_SMOOTH_SANDSTONE.getRegistryName()),

                BYGItems.PURPLE_SAND = new BlockItem(BYGBlocks.PURPLE_SAND, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PURPLE_SAND.getRegistryName()),
                BYGItems.PURPLE_SANDSTONE = new BlockItem(BYGBlocks.PURPLE_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PURPLE_SANDSTONE.getRegistryName()),
                BYGItems.PURPLE_CHISELED_SANDSTONE = new BlockItem(BYGBlocks.PURPLE_CHISELED_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PURPLE_CHISELED_SANDSTONE.getRegistryName()),
                BYGItems.PURPLE_CUT_SANDSTONE = new BlockItem(BYGBlocks.PURPLE_CUT_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PURPLE_CUT_SANDSTONE.getRegistryName()),
                BYGItems.PURPLE_SMOOTH_SANDSTONE = new BlockItem(BYGBlocks.PURPLE_SMOOTH_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PURPLE_SMOOTH_SANDSTONE.getRegistryName()),

                BYGItems.PINK_SAND = new BlockItem(BYGBlocks.PINK_SAND, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINK_SAND.getRegistryName()),
                BYGItems.PINK_SANDSTONE = new BlockItem(BYGBlocks.PINK_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINK_SANDSTONE.getRegistryName()),
                BYGItems.PINK_CHISELED_SANDSTONE = new BlockItem(BYGBlocks.PINK_CHISELED_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINK_CHISELED_SANDSTONE.getRegistryName()),
                BYGItems.PINK_CUT_SANDSTONE = new BlockItem(BYGBlocks.PINK_CUT_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINK_CUT_SANDSTONE.getRegistryName()),
                BYGItems.PINK_SMOOTH_SANDSTONE = new BlockItem(BYGBlocks.PINK_SMOOTH_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINK_SMOOTH_SANDSTONE.getRegistryName()),

                //Aspen Woodtype
                BYGItems.ASPEN_SAPLING = new BlockItem(BYGBlocks.ASPEN_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ASPEN_SAPLING.getRegistryName()),
                BYGItems.ASPEN_LEAVES = new BlockItem(BYGBlocks.ASPEN_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ASPEN_LEAVES.getRegistryName()),
                BYGItems.ASPEN_LOG = new BlockItem(BYGBlocks.ASPEN_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ASPEN_LOG.getRegistryName()),
                BYGItems.ASPEN_WOOD = new BlockItem(BYGBlocks.ASPEN_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ASPEN_WOOD.getRegistryName()),
                BYGItems.STRIPPED_ASPEN_LOG = new BlockItem(BYGBlocks.STRIPPED_ASPEN_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_ASPEN_LOG.getRegistryName()),
                BYGItems.STRIPPED_ASPEN_WOOD = new BlockItem(BYGBlocks.STRIPPED_ASPEN_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_ASPEN_WOOD.getRegistryName()),
                BYGItems.ASPEN_PLANKS = new BlockItem(BYGBlocks.ASPEN_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ASPEN_PLANKS.getRegistryName()),
                BYGItems.ASPEN_BOOKSHELF = new BlockItem(BYGBlocks.ASPEN_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ASPEN_BOOKSHELF.getRegistryName()),
                BYGItems.ASPEN_CRAFTING_TABLE = new BlockItem(BYGBlocks.ASPEN_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ASPEN_CRAFTING_TABLE.getRegistryName()),
                BYGItems.ASPEN_STAIRS = new BlockItem(BYGBlocks.ASPEN_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ASPEN_STAIRS.getRegistryName()),
                BYGItems.ASPEN_SLAB = new BlockItem(BYGBlocks.ASPEN_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ASPEN_SLAB.getRegistryName()),
                BYGItems.ASPEN_FENCE = new BlockItem(BYGBlocks.ASPEN_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ASPEN_FENCE.getRegistryName()),
                BYGItems.ASPEN_FENCE_GATE = new BlockItem(BYGBlocks.ASPEN_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ASPEN_FENCE_GATE.getRegistryName()),
                BYGItems.ASPEN_DOOR = new TallBlockItem(BYGBlocks.ASPEN_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ASPEN_DOOR.getRegistryName()),
                BYGItems.ASPEN_TRAPDOOR = new BlockItem(BYGBlocks.ASPEN_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ASPEN_TRAPDOOR.getRegistryName()),
                BYGItems.ASPEN_PRESSURE_PLATE = new BlockItem(BYGBlocks.ASPEN_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ASPEN_PRESSURE_PLATE.getRegistryName()),
                BYGItems.ASPEN_BUTTON = new BlockItem(BYGBlocks.ASPEN_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ASPEN_BUTTON.getRegistryName()),
                BYGItems.ASPEN_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.ASPEN, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)).setRegistryName("aspen_boat"),

                //Baobab Woodtype
                BYGItems.BAOBAB_SAPLING = new BlockItem(BYGBlocks.BAOBAB_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BAOBAB_SAPLING.getRegistryName()),
                BYGItems.BAOBAB_LEAVES = new BlockItem(BYGBlocks.BAOBAB_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BAOBAB_LEAVES.getRegistryName()),
                BYGItems.BAOBAB_LOG = new BlockItem(BYGBlocks.BAOBAB_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BAOBAB_LOG.getRegistryName()),
                BYGItems.BAOBAB_WOOD = new BlockItem(BYGBlocks.BAOBAB_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BAOBAB_WOOD.getRegistryName()),
                BYGItems.STRIPPED_BAOBAB_LOG = new BlockItem(BYGBlocks.STRIPPED_BAOBAB_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_BAOBAB_LOG.getRegistryName()),
                BYGItems.STRIPPED_BAOBAB_WOOD = new BlockItem(BYGBlocks.STRIPPED_BAOBAB_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_BAOBAB_WOOD.getRegistryName()),
                BYGItems.BAOBAB_PLANKS = new BlockItem(BYGBlocks.BAOBAB_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BAOBAB_PLANKS.getRegistryName()),
                BYGItems.BAOBAB_BOOKSHELF = new BlockItem(BYGBlocks.BAOBAB_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BAOBAB_BOOKSHELF.getRegistryName()),
                BYGItems.BAOBAB_CRAFTING_TABLE = new BlockItem(BYGBlocks.BAOBAB_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BAOBAB_CRAFTING_TABLE.getRegistryName()),
                BYGItems.BAOBAB_STAIRS = new BlockItem(BYGBlocks.BAOBAB_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BAOBAB_STAIRS.getRegistryName()),
                BYGItems.BAOBAB_SLAB = new BlockItem(BYGBlocks.BAOBAB_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BAOBAB_SLAB.getRegistryName()),
                BYGItems.BAOBAB_FENCE = new BlockItem(BYGBlocks.BAOBAB_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BAOBAB_FENCE.getRegistryName()),
                BYGItems.BAOBAB_FENCE_GATE = new BlockItem(BYGBlocks.BAOBAB_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BAOBAB_FENCE_GATE.getRegistryName()),
                BYGItems.BAOBAB_DOOR = new TallBlockItem(BYGBlocks.BAOBAB_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BAOBAB_DOOR.getRegistryName()),
                BYGItems.BAOBAB_TRAPDOOR = new BlockItem(BYGBlocks.BAOBAB_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BAOBAB_TRAPDOOR.getRegistryName()),
                BYGItems.BAOBAB_PRESSURE_PLATE = new BlockItem(BYGBlocks.BAOBAB_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BAOBAB_PRESSURE_PLATE.getRegistryName()),
                BYGItems.BAOBAB_BUTTON = new BlockItem(BYGBlocks.BAOBAB_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BAOBAB_BUTTON.getRegistryName()),
                BYGItems.BAOBAB_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.BAOBAB, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)).setRegistryName("baobab_boat"),

                //Blue Enchanted Woodtype
                BYGItems.BLUE_ENCHANTED_SAPLING = new BlockItem(BYGBlocks.BLUE_ENCHANTED_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_ENCHANTED_SAPLING.getRegistryName()),
                BYGItems.BLUE_ENCHANTED_LEAVES = new BlockItem(BYGBlocks.BLUE_ENCHANTED_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_ENCHANTED_LEAVES.getRegistryName()),
                BYGItems.BLUE_ENCHANTED_LOG = new BlockItem(BYGBlocks.BLUE_ENCHANTED_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_ENCHANTED_LOG.getRegistryName()),
                BYGItems.BLUE_ENCHANTED_WOOD = new BlockItem(BYGBlocks.BLUE_ENCHANTED_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_ENCHANTED_WOOD.getRegistryName()),
                BYGItems.STRIPPED_BLUE_ENCHANTED_LOG = new BlockItem(BYGBlocks.STRIPPED_BLUE_ENCHANTED_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_BLUE_ENCHANTED_LOG.getRegistryName()),
                BYGItems.STRIPPED_BLUE_ENCHANTED_WOOD = new BlockItem(BYGBlocks.STRIPPED_BLUE_ENCHANTED_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_BLUE_ENCHANTED_WOOD.getRegistryName()),
                BYGItems.BLUE_ENCHANTED_PLANKS = new BlockItem(BYGBlocks.BLUE_ENCHANTED_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_ENCHANTED_PLANKS.getRegistryName()),
                BYGItems.BLUE_ENCHANTED_BOOKSHELF = new BlockItem(BYGBlocks.BLUE_ENCHANTED_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_ENCHANTED_BOOKSHELF.getRegistryName()),
                BYGItems.BLUE_ENCHANTED_CRAFTING_TABLE = new BlockItem(BYGBlocks.BLUE_ENCHANTED_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_ENCHANTED_CRAFTING_TABLE.getRegistryName()),
                BYGItems.BLUE_ENCHANTED_STAIRS = new BlockItem(BYGBlocks.BLUE_ENCHANTED_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_ENCHANTED_STAIRS.getRegistryName()),
                BYGItems.BLUE_ENCHANTED_SLAB = new BlockItem(BYGBlocks.BLUE_ENCHANTED_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_ENCHANTED_SLAB.getRegistryName()),
                BYGItems.BLUE_ENCHANTED_FENCE = new BlockItem(BYGBlocks.BLUE_ENCHANTED_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_ENCHANTED_FENCE.getRegistryName()),
                BYGItems.BLUE_ENCHANTED_FENCE_GATE = new BlockItem(BYGBlocks.BLUE_ENCHANTED_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_ENCHANTED_FENCE_GATE.getRegistryName()),
                BYGItems.BLUE_ENCHANTED_DOOR = new TallBlockItem(BYGBlocks.BLUE_ENCHANTED_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_ENCHANTED_DOOR.getRegistryName()),
                BYGItems.BLUE_ENCHANTED_TRAPDOOR = new BlockItem(BYGBlocks.BLUE_ENCHANTED_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_ENCHANTED_TRAPDOOR.getRegistryName()),
                BYGItems.BLUE_ENCHANTED_PRESSURE_PLATE = new BlockItem(BYGBlocks.BLUE_ENCHANTED_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_ENCHANTED_PRESSURE_PLATE.getRegistryName()),
                BYGItems.BLUE_ENCHANTED_BUTTON = new BlockItem(BYGBlocks.BLUE_ENCHANTED_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_ENCHANTED_BUTTON.getRegistryName()),
                BYGItems.BLUE_ENCHANTED_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.BLUE_ENCHANTED, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)).setRegistryName("blue_enchanted_boat"),

                //Cherry Woodtype
                BYGItems.PINK_CHERRY_SAPLING = new BlockItem(BYGBlocks.PINK_CHERRY_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINK_CHERRY_SAPLING.getRegistryName()),
                BYGItems.PINK_CHERRY_FOLIAGE = new BlockItem(BYGBlocks.PINK_CHERRY_FOLIAGE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINK_CHERRY_FOLIAGE.getRegistryName()),
                BYGItems.PINK_CHERRY_LEAVES = new BlockItem(BYGBlocks.PINK_CHERRY_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINK_CHERRY_LEAVES.getRegistryName()),
                BYGItems.WHITE_CHERRY_SAPLING = new BlockItem(BYGBlocks.WHITE_CHERRY_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WHITE_CHERRY_SAPLING.getRegistryName()),
                BYGItems.WHITE_CHERRY_FOLIAGE = new BlockItem(BYGBlocks.WHITE_CHERRY_FOLIAGE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WHITE_CHERRY_FOLIAGE.getRegistryName()),
                BYGItems.WHITE_CHERRY_LEAVES = new BlockItem(BYGBlocks.WHITE_CHERRY_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WHITE_CHERRY_LEAVES.getRegistryName()),
                BYGItems.CHERRY_LOG = new BlockItem(BYGBlocks.CHERRY_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CHERRY_LOG.getRegistryName()),
                BYGItems.CHERRY_WOOD = new BlockItem(BYGBlocks.CHERRY_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CHERRY_WOOD.getRegistryName()),
                BYGItems.STRIPPED_CHERRY_LOG = new BlockItem(BYGBlocks.STRIPPED_CHERRY_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_CHERRY_LOG.getRegistryName()),
                BYGItems.STRIPPED_CHERRY_WOOD = new BlockItem(BYGBlocks.STRIPPED_CHERRY_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_CHERRY_WOOD.getRegistryName()),
                BYGItems.CHERRY_PLANKS = new BlockItem(BYGBlocks.CHERRY_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CHERRY_PLANKS.getRegistryName()),
                BYGItems.CHERRY_BOOKSHELF = new BlockItem(BYGBlocks.CHERRY_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CHERRY_BOOKSHELF.getRegistryName()),
                BYGItems.CHERRY_CRAFTING_TABLE = new BlockItem(BYGBlocks.CHERRY_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CHERRY_CRAFTING_TABLE.getRegistryName()),
                BYGItems.CHERRY_STAIRS = new BlockItem(BYGBlocks.CHERRY_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CHERRY_STAIRS.getRegistryName()),
                BYGItems.CHERRY_SLAB = new BlockItem(BYGBlocks.CHERRY_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CHERRY_SLAB.getRegistryName()),
                BYGItems.CHERRY_FENCE = new BlockItem(BYGBlocks.CHERRY_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CHERRY_FENCE.getRegistryName()),
                BYGItems.CHERRY_FENCE_GATE = new BlockItem(BYGBlocks.CHERRY_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CHERRY_FENCE_GATE.getRegistryName()),
                BYGItems.CHERRY_DOOR = new TallBlockItem(BYGBlocks.CHERRY_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CHERRY_DOOR.getRegistryName()),
                BYGItems.CHERRY_TRAPDOOR = new BlockItem(BYGBlocks.CHERRY_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CHERRY_TRAPDOOR.getRegistryName()),
                BYGItems.CHERRY_PRESSURE_PLATE = new BlockItem(BYGBlocks.CHERRY_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CHERRY_PRESSURE_PLATE.getRegistryName()),
                BYGItems.CHERRY_BUTTON = new BlockItem(BYGBlocks.CHERRY_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CHERRY_BUTTON.getRegistryName()),
                BYGItems.CHERRY_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.CHERRY, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)).setRegistryName("cherry_boat"),

                //Cika Woodtype
                BYGItems.CIKA_SAPLING = new BlockItem(BYGBlocks.CIKA_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CIKA_SAPLING.getRegistryName()),
                BYGItems.CIKA_LEAVES = new BlockItem(BYGBlocks.CIKA_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CIKA_LEAVES.getRegistryName()),
                BYGItems.CIKA_LOG = new BlockItem(BYGBlocks.CIKA_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CIKA_LOG.getRegistryName()),
                BYGItems.CIKA_WOOD = new BlockItem(BYGBlocks.CIKA_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CIKA_WOOD.getRegistryName()),
                BYGItems.STRIPPED_CIKA_LOG = new BlockItem(BYGBlocks.STRIPPED_CIKA_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_CIKA_LOG.getRegistryName()),
                BYGItems.STRIPPED_CIKA_WOOD = new BlockItem(BYGBlocks.STRIPPED_CIKA_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_CIKA_WOOD.getRegistryName()),
                BYGItems.CIKA_PLANKS = new BlockItem(BYGBlocks.CIKA_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CIKA_PLANKS.getRegistryName()),
                BYGItems.CIKA_BOOKSHELF = new BlockItem(BYGBlocks.CIKA_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CIKA_BOOKSHELF.getRegistryName()),
                BYGItems.CIKA_CRAFTING_TABLE = new BlockItem(BYGBlocks.CIKA_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CIKA_CRAFTING_TABLE.getRegistryName()),
                BYGItems.CIKA_STAIRS = new BlockItem(BYGBlocks.CIKA_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CIKA_STAIRS.getRegistryName()),
                BYGItems.CIKA_SLAB = new BlockItem(BYGBlocks.CIKA_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CIKA_SLAB.getRegistryName()),
                BYGItems.CIKA_FENCE = new BlockItem(BYGBlocks.CIKA_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CIKA_FENCE.getRegistryName()),
                BYGItems.CIKA_FENCE_GATE = new BlockItem(BYGBlocks.CIKA_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CIKA_FENCE_GATE.getRegistryName()),
                BYGItems.CIKA_DOOR = new TallBlockItem(BYGBlocks.CIKA_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CIKA_DOOR.getRegistryName()),
                BYGItems.CIKA_TRAPDOOR = new BlockItem(BYGBlocks.CIKA_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CIKA_TRAPDOOR.getRegistryName()),
                BYGItems.CIKA_PRESSURE_PLATE = new BlockItem(BYGBlocks.CIKA_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CIKA_PRESSURE_PLATE.getRegistryName()),
                BYGItems.CIKA_BUTTON = new BlockItem(BYGBlocks.CIKA_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CIKA_BUTTON.getRegistryName()),
                BYGItems.CIKA_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.CIKA, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)).setRegistryName("cika_boat"),

                //Cypress Woodtype
                BYGItems.CYPRESS_SAPLING = new BlockItem(BYGBlocks.CYPRESS_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CYPRESS_SAPLING.getRegistryName()),
                BYGItems.CYPRESS_LEAVES = new BlockItem(BYGBlocks.CYPRESS_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CYPRESS_LEAVES.getRegistryName()),
                BYGItems.CYPRESS_LOG = new BlockItem(BYGBlocks.CYPRESS_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CYPRESS_LOG.getRegistryName()),
                BYGItems.CYPRESS_WOOD = new BlockItem(BYGBlocks.CYPRESS_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CYPRESS_WOOD.getRegistryName()),
                BYGItems.STRIPPED_CYPRESS_LOG = new BlockItem(BYGBlocks.STRIPPED_CYPRESS_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_CYPRESS_LOG.getRegistryName()),
                BYGItems.STRIPPED_CYPRESS_WOOD = new BlockItem(BYGBlocks.STRIPPED_CYPRESS_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_CYPRESS_WOOD.getRegistryName()),
                BYGItems.CYPRESS_PLANKS = new BlockItem(BYGBlocks.CYPRESS_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CYPRESS_PLANKS.getRegistryName()),
                BYGItems.CYPRESS_BOOKSHELF = new BlockItem(BYGBlocks.CYPRESS_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CYPRESS_BOOKSHELF.getRegistryName()),
                BYGItems.CYPRESS_CRAFTING_TABLE = new BlockItem(BYGBlocks.CYPRESS_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CYPRESS_CRAFTING_TABLE.getRegistryName()),
                BYGItems.CYPRESS_STAIRS = new BlockItem(BYGBlocks.CYPRESS_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CYPRESS_STAIRS.getRegistryName()),
                BYGItems.CYPRESS_SLAB = new BlockItem(BYGBlocks.CYPRESS_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CYPRESS_SLAB.getRegistryName()),
                BYGItems.CYPRESS_FENCE = new BlockItem(BYGBlocks.CYPRESS_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CYPRESS_FENCE.getRegistryName()),
                BYGItems.CYPRESS_FENCE_GATE = new BlockItem(BYGBlocks.CYPRESS_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CYPRESS_FENCE_GATE.getRegistryName()),
                BYGItems.CYPRESS_DOOR = new TallBlockItem(BYGBlocks.CYPRESS_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CYPRESS_DOOR.getRegistryName()),
                BYGItems.CYPRESS_TRAPDOOR = new BlockItem(BYGBlocks.CYPRESS_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CYPRESS_TRAPDOOR.getRegistryName()),
                BYGItems.CYPRESS_PRESSURE_PLATE = new BlockItem(BYGBlocks.CYPRESS_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CYPRESS_PRESSURE_PLATE.getRegistryName()),
                BYGItems.CYPRESS_BUTTON = new BlockItem(BYGBlocks.CYPRESS_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CYPRESS_BUTTON.getRegistryName()),
                BYGItems.CYPRESS_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.CYPRESS, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)).setRegistryName("cypress_boat"),

                //Ebony Woodtype
                BYGItems.EBONY_SAPLING = new BlockItem(BYGBlocks.EBONY_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EBONY_SAPLING.getRegistryName()),
                BYGItems.EBONY_LEAVES = new BlockItem(BYGBlocks.EBONY_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EBONY_LEAVES.getRegistryName()),
                BYGItems.EBONY_LOG = new BlockItem(BYGBlocks.EBONY_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EBONY_LOG.getRegistryName()),
                BYGItems.EBONY_WOOD = new BlockItem(BYGBlocks.EBONY_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EBONY_WOOD.getRegistryName()),
                BYGItems.STRIPPED_EBONY_LOG = new BlockItem(BYGBlocks.STRIPPED_EBONY_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_EBONY_LOG.getRegistryName()),
                BYGItems.STRIPPED_EBONY_WOOD = new BlockItem(BYGBlocks.STRIPPED_EBONY_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_EBONY_WOOD.getRegistryName()),
                BYGItems.EBONY_PLANKS = new BlockItem(BYGBlocks.EBONY_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EBONY_PLANKS.getRegistryName()),
                BYGItems.EBONY_BOOKSHELF = new BlockItem(BYGBlocks.EBONY_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EBONY_BOOKSHELF.getRegistryName()),
                BYGItems.EBONY_CRAFTING_TABLE = new BlockItem(BYGBlocks.EBONY_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EBONY_CRAFTING_TABLE.getRegistryName()),
                BYGItems.EBONY_STAIRS = new BlockItem(BYGBlocks.EBONY_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EBONY_STAIRS.getRegistryName()),
                BYGItems.EBONY_SLAB = new BlockItem(BYGBlocks.EBONY_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EBONY_SLAB.getRegistryName()),
                BYGItems.EBONY_FENCE = new BlockItem(BYGBlocks.EBONY_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EBONY_FENCE.getRegistryName()),
                BYGItems.EBONY_FENCE_GATE = new BlockItem(BYGBlocks.EBONY_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EBONY_FENCE_GATE.getRegistryName()),
                BYGItems.EBONY_DOOR = new TallBlockItem(BYGBlocks.EBONY_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EBONY_DOOR.getRegistryName()),
                BYGItems.EBONY_TRAPDOOR = new BlockItem(BYGBlocks.EBONY_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EBONY_TRAPDOOR.getRegistryName()),
                BYGItems.EBONY_PRESSURE_PLATE = new BlockItem(BYGBlocks.EBONY_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EBONY_PRESSURE_PLATE.getRegistryName()),
                BYGItems.EBONY_BUTTON = new BlockItem(BYGBlocks.EBONY_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EBONY_BUTTON.getRegistryName()),
                BYGItems.EBONY_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.EBONY, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)).setRegistryName("ebony_boat"),

                //Fir Woodtype
                BYGItems.FIR_SAPLING = new BlockItem(BYGBlocks.FIR_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.FIR_SAPLING.getRegistryName()),
                BYGItems.FIR_LEAVES = new BlockItem(BYGBlocks.FIR_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.FIR_LEAVES.getRegistryName()),
                BYGItems.FIR_LOG = new BlockItem(BYGBlocks.FIR_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.FIR_LOG.getRegistryName()),
                BYGItems.FIR_WOOD = new BlockItem(BYGBlocks.FIR_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.FIR_WOOD.getRegistryName()),
                BYGItems.STRIPPED_FIR_LOG = new BlockItem(BYGBlocks.STRIPPED_FIR_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_FIR_LOG.getRegistryName()),
                BYGItems.STRIPPED_FIR_WOOD = new BlockItem(BYGBlocks.STRIPPED_FIR_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_FIR_WOOD.getRegistryName()),
                BYGItems.FIR_PLANKS = new BlockItem(BYGBlocks.FIR_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.FIR_PLANKS.getRegistryName()),
                BYGItems.FIR_BOOKSHELF = new BlockItem(BYGBlocks.FIR_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.FIR_BOOKSHELF.getRegistryName()),
                BYGItems.FIR_CRAFTING_TABLE = new BlockItem(BYGBlocks.FIR_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.FIR_CRAFTING_TABLE.getRegistryName()),
                BYGItems.FIR_STAIRS = new BlockItem(BYGBlocks.FIR_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.FIR_STAIRS.getRegistryName()),
                BYGItems.FIR_SLAB = new BlockItem(BYGBlocks.FIR_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.FIR_SLAB.getRegistryName()),
                BYGItems.FIR_FENCE = new BlockItem(BYGBlocks.FIR_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.FIR_FENCE.getRegistryName()),
                BYGItems.FIR_FENCE_GATE = new BlockItem(BYGBlocks.FIR_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.FIR_FENCE_GATE.getRegistryName()),
                BYGItems.FIR_DOOR = new TallBlockItem(BYGBlocks.FIR_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.FIR_DOOR.getRegistryName()),
                BYGItems.FIR_TRAPDOOR = new BlockItem(BYGBlocks.FIR_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.FIR_TRAPDOOR.getRegistryName()),
                BYGItems.FIR_PRESSURE_PLATE = new BlockItem(BYGBlocks.FIR_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.FIR_PRESSURE_PLATE.getRegistryName()),
                BYGItems.FIR_BUTTON = new BlockItem(BYGBlocks.FIR_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.FIR_BUTTON.getRegistryName()),
                BYGItems.FIR_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.FIR, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)).setRegistryName("fir_boat"),

                //Green Enchanted Woodtype
                BYGItems.GREEN_ENCHANTED_SAPLING = new BlockItem(BYGBlocks.GREEN_ENCHANTED_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.GREEN_ENCHANTED_SAPLING.getRegistryName()),
                BYGItems.GREEN_ENCHANTED_LEAVES = new BlockItem(BYGBlocks.GREEN_ENCHANTED_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.GREEN_ENCHANTED_LEAVES.getRegistryName()),
                BYGItems.GREEN_ENCHANTED_LOG = new BlockItem(BYGBlocks.GREEN_ENCHANTED_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.GREEN_ENCHANTED_LOG.getRegistryName()),
                BYGItems.GREEN_ENCHANTED_WOOD = new BlockItem(BYGBlocks.GREEN_ENCHANTED_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.GREEN_ENCHANTED_WOOD.getRegistryName()),
                BYGItems.STRIPPED_GREEN_ENCHANTED_LOG = new BlockItem(BYGBlocks.STRIPPED_GREEN_ENCHANTED_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_GREEN_ENCHANTED_LOG.getRegistryName()),
                BYGItems.STRIPPED_GREEN_ENCHANTED_WOOD = new BlockItem(BYGBlocks.STRIPPED_GREEN_ENCHANTED_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_GREEN_ENCHANTED_WOOD.getRegistryName()),
                BYGItems.GREEN_ENCHANTED_PLANKS = new BlockItem(BYGBlocks.GREEN_ENCHANTED_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.GREEN_ENCHANTED_PLANKS.getRegistryName()),
                BYGItems.GREEN_ENCHANTED_BOOKSHELF = new BlockItem(BYGBlocks.GREEN_ENCHANTED_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.GREEN_ENCHANTED_BOOKSHELF.getRegistryName()),
                BYGItems.GREEN_ENCHANTED_CRAFTING_TABLE = new BlockItem(BYGBlocks.GREEN_ENCHANTED_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.GREEN_ENCHANTED_CRAFTING_TABLE.getRegistryName()),
                BYGItems.GREEN_ENCHANTED_STAIRS = new BlockItem(BYGBlocks.GREEN_ENCHANTED_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.GREEN_ENCHANTED_STAIRS.getRegistryName()),
                BYGItems.GREEN_ENCHANTED_SLAB = new BlockItem(BYGBlocks.GREEN_ENCHANTED_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.GREEN_ENCHANTED_SLAB.getRegistryName()),
                BYGItems.GREEN_ENCHANTED_FENCE = new BlockItem(BYGBlocks.GREEN_ENCHANTED_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.GREEN_ENCHANTED_FENCE.getRegistryName()),
                BYGItems.GREEN_ENCHANTED_FENCE_GATE = new BlockItem(BYGBlocks.GREEN_ENCHANTED_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.GREEN_ENCHANTED_FENCE_GATE.getRegistryName()),
                BYGItems.GREEN_ENCHANTED_DOOR = new TallBlockItem(BYGBlocks.GREEN_ENCHANTED_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.GREEN_ENCHANTED_DOOR.getRegistryName()),
                BYGItems.GREEN_ENCHANTED_TRAPDOOR = new BlockItem(BYGBlocks.GREEN_ENCHANTED_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.GREEN_ENCHANTED_TRAPDOOR.getRegistryName()),
                BYGItems.GREEN_ENCHANTED_PRESSURE_PLATE = new BlockItem(BYGBlocks.GREEN_ENCHANTED_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.GREEN_ENCHANTED_PRESSURE_PLATE.getRegistryName()),
                BYGItems.GREEN_ENCHANTED_BUTTON = new BlockItem(BYGBlocks.GREEN_ENCHANTED_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.GREEN_ENCHANTED_BUTTON.getRegistryName()),
                BYGItems.GREEN_ENCHANTED_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.GREEN_ENCHANTED, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)).setRegistryName("green_enchanted_boat"),

                //Holly Woodtype
                BYGItems.HOLLY_BERRY_LEAVES = new BlockItem(BYGBlocks.HOLLY_BERRY_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.HOLLY_BERRY_LEAVES.getRegistryName()),
                BYGItems.HOLLY_BERRY = new Item(new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(2).saturation(0.1f).build())).setRegistryName("holly_berries"),
                BYGItems.HOLLY_SAPLING = new BlockItem(BYGBlocks.HOLLY_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.HOLLY_SAPLING.getRegistryName()),
                BYGItems.HOLLY_LEAVES = new BlockItem(BYGBlocks.HOLLY_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.HOLLY_LEAVES.getRegistryName()),
                BYGItems.HOLLY_LOG = new BlockItem(BYGBlocks.HOLLY_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.HOLLY_LOG.getRegistryName()),
                BYGItems.HOLLY_WOOD = new BlockItem(BYGBlocks.HOLLY_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.HOLLY_WOOD.getRegistryName()),
                BYGItems.STRIPPED_HOLLY_LOG = new BlockItem(BYGBlocks.STRIPPED_HOLLY_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_HOLLY_LOG.getRegistryName()),
                BYGItems.STRIPPED_HOLLY_WOOD = new BlockItem(BYGBlocks.STRIPPED_HOLLY_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_HOLLY_WOOD.getRegistryName()),
                BYGItems.HOLLY_PLANKS = new BlockItem(BYGBlocks.HOLLY_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.HOLLY_PLANKS.getRegistryName()),
                BYGItems.HOLLY_BOOKSHELF = new BlockItem(BYGBlocks.HOLLY_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.HOLLY_BOOKSHELF.getRegistryName()),
                BYGItems.HOLLY_CRAFTING_TABLE = new BlockItem(BYGBlocks.HOLLY_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.HOLLY_CRAFTING_TABLE.getRegistryName()),
                BYGItems.HOLLY_STAIRS = new BlockItem(BYGBlocks.HOLLY_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.HOLLY_STAIRS.getRegistryName()),
                BYGItems.HOLLY_SLAB = new BlockItem(BYGBlocks.HOLLY_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.HOLLY_SLAB.getRegistryName()),
                BYGItems.HOLLY_FENCE = new BlockItem(BYGBlocks.HOLLY_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.HOLLY_FENCE.getRegistryName()),
                BYGItems.HOLLY_FENCE_GATE = new BlockItem(BYGBlocks.HOLLY_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.HOLLY_FENCE_GATE.getRegistryName()),
                BYGItems.HOLLY_DOOR = new TallBlockItem(BYGBlocks.HOLLY_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.HOLLY_DOOR.getRegistryName()),
                BYGItems.HOLLY_TRAPDOOR = new BlockItem(BYGBlocks.HOLLY_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.HOLLY_TRAPDOOR.getRegistryName()),
                BYGItems.HOLLY_PRESSURE_PLATE = new BlockItem(BYGBlocks.HOLLY_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.HOLLY_PRESSURE_PLATE.getRegistryName()),
                BYGItems.HOLLY_BUTTON = new BlockItem(BYGBlocks.HOLLY_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.HOLLY_BUTTON.getRegistryName()),
                BYGItems.HOLLY_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.HOLLY, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)).setRegistryName("holly_boat"),

                //Jacaranda Woodtype
                BYGItems.JACARANDA_SAPLING = new BlockItem(BYGBlocks.JACARANDA_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.JACARANDA_SAPLING.getRegistryName()),
                BYGItems.JACARANDA_LEAVES = new BlockItem(BYGBlocks.JACARANDA_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.JACARANDA_LEAVES.getRegistryName()),
                BYGItems.INDIGO_JACARANDA_SAPLING = new BlockItem(BYGBlocks.INDIGO_JACARANDA_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.INDIGO_JACARANDA_SAPLING.getRegistryName()),
                BYGItems.INDIGO_JACARANDA_LEAVES = new BlockItem(BYGBlocks.INDIGO_JACARANDA_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.INDIGO_JACARANDA_LEAVES.getRegistryName()),
                BYGItems.JACARANDA_LOG = new BlockItem(BYGBlocks.JACARANDA_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.JACARANDA_LOG.getRegistryName()),
                BYGItems.JACARANDA_WOOD = new BlockItem(BYGBlocks.JACARANDA_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.JACARANDA_WOOD.getRegistryName()),
                BYGItems.STRIPPED_JACARANDA_LOG = new BlockItem(BYGBlocks.STRIPPED_JACARANDA_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_JACARANDA_LOG.getRegistryName()),
                BYGItems.STRIPPED_JACARANDA_WOOD = new BlockItem(BYGBlocks.STRIPPED_JACARANDA_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_JACARANDA_WOOD.getRegistryName()),
                BYGItems.JACARANDA_PLANKS = new BlockItem(BYGBlocks.JACARANDA_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.JACARANDA_PLANKS.getRegistryName()),
                BYGItems.JACARANDA_BOOKSHELF = new BlockItem(BYGBlocks.JACARANDA_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.JACARANDA_BOOKSHELF.getRegistryName()),
                BYGItems.JACARANDA_CRAFTING_TABLE = new BlockItem(BYGBlocks.JACARANDA_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.JACARANDA_CRAFTING_TABLE.getRegistryName()),
                BYGItems.JACARANDA_STAIRS = new BlockItem(BYGBlocks.JACARANDA_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.JACARANDA_STAIRS.getRegistryName()),
                BYGItems.JACARANDA_SLAB = new BlockItem(BYGBlocks.JACARANDA_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.JACARANDA_SLAB.getRegistryName()),
                BYGItems.JACARANDA_FENCE = new BlockItem(BYGBlocks.JACARANDA_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.JACARANDA_FENCE.getRegistryName()),
                BYGItems.JACARANDA_FENCE_GATE = new BlockItem(BYGBlocks.JACARANDA_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.JACARANDA_FENCE_GATE.getRegistryName()),
                BYGItems.JACARANDA_DOOR = new TallBlockItem(BYGBlocks.JACARANDA_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.JACARANDA_DOOR.getRegistryName()),
                BYGItems.JACARANDA_TRAPDOOR = new BlockItem(BYGBlocks.JACARANDA_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.JACARANDA_TRAPDOOR.getRegistryName()),
                BYGItems.JACARANDA_PRESSURE_PLATE = new BlockItem(BYGBlocks.JACARANDA_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.JACARANDA_PRESSURE_PLATE.getRegistryName()),
                BYGItems.JACARANDA_BUTTON = new BlockItem(BYGBlocks.JACARANDA_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.JACARANDA_BUTTON.getRegistryName()),
                BYGItems.JACARANDA_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.JACARANDA, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)).setRegistryName("jacaranda_boat"),

                //Lament Woodtype
                BYGItems.LAMENT_SAPLING = new BlockItem(BYGBlocks.LAMENT_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.LAMENT_SAPLING.getRegistryName()),
                BYGItems.LAMENT_LEAVES = new BlockItem(BYGBlocks.LAMENT_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.LAMENT_LEAVES.getRegistryName()),
                BYGItems.LAMENT_VINE = new BlockItem(BYGBlocks.LAMENT_VINE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.LAMENT_VINE.getRegistryName()),
                BYGItems.LAMENT_SPROUTS = new BlockItem(BYGBlocks.LAMENT_SPROUTS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.LAMENT_SPROUTS.getRegistryName()),
                BYGItems.LAMENT_LOG = new BlockItem(BYGBlocks.LAMENT_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.LAMENT_LOG.getRegistryName()),
                BYGItems.LAMENT_WOOD = new BlockItem(BYGBlocks.LAMENT_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.LAMENT_WOOD.getRegistryName()),
                BYGItems.STRIPPED_LAMENT_LOG = new BlockItem(BYGBlocks.STRIPPED_LAMENT_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_LAMENT_LOG.getRegistryName()),
                BYGItems.STRIPPED_LAMENT_WOOD = new BlockItem(BYGBlocks.STRIPPED_LAMENT_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_LAMENT_WOOD.getRegistryName()),
                BYGItems.LAMENT_PLANKS = new BlockItem(BYGBlocks.LAMENT_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.LAMENT_PLANKS.getRegistryName()),
                BYGItems.LAMENT_BOOKSHELF = new BlockItem(BYGBlocks.LAMENT_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.LAMENT_BOOKSHELF.getRegistryName()),
                BYGItems.LAMENT_CRAFTING_TABLE = new BlockItem(BYGBlocks.LAMENT_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.LAMENT_CRAFTING_TABLE.getRegistryName()),
                BYGItems.LAMENT_STAIRS = new BlockItem(BYGBlocks.LAMENT_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.LAMENT_STAIRS.getRegistryName()),
                BYGItems.LAMENT_SLAB = new BlockItem(BYGBlocks.LAMENT_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.LAMENT_SLAB.getRegistryName()),
                BYGItems.LAMENT_FENCE = new BlockItem(BYGBlocks.LAMENT_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.LAMENT_FENCE.getRegistryName()),
                BYGItems.LAMENT_FENCE_GATE = new BlockItem(BYGBlocks.LAMENT_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.LAMENT_FENCE_GATE.getRegistryName()),
                BYGItems.LAMENT_DOOR = new TallBlockItem(BYGBlocks.LAMENT_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.LAMENT_DOOR.getRegistryName()),
                BYGItems.LAMENT_TRAPDOOR = new BlockItem(BYGBlocks.LAMENT_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.LAMENT_TRAPDOOR.getRegistryName()),
                BYGItems.LAMENT_PRESSURE_PLATE = new BlockItem(BYGBlocks.LAMENT_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.LAMENT_PRESSURE_PLATE.getRegistryName()),
                BYGItems.LAMENT_BUTTON = new BlockItem(BYGBlocks.LAMENT_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.LAMENT_BUTTON.getRegistryName()),

                //Mahogany Woodtype
                BYGItems.MAHOGANY_SAPLING = new BlockItem(BYGBlocks.MAHOGANY_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAHOGANY_SAPLING.getRegistryName()),
                BYGItems.MAHOGANY_LEAVES = new BlockItem(BYGBlocks.MAHOGANY_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAHOGANY_LEAVES.getRegistryName()),
                BYGItems.MAHOGANY_LOG = new BlockItem(BYGBlocks.MAHOGANY_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAHOGANY_LOG.getRegistryName()),
                BYGItems.MAHOGANY_WOOD = new BlockItem(BYGBlocks.MAHOGANY_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAHOGANY_WOOD.getRegistryName()),
                BYGItems.STRIPPED_MAHOGANY_LOG = new BlockItem(BYGBlocks.STRIPPED_MAHOGANY_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_MAHOGANY_LOG.getRegistryName()),
                BYGItems.STRIPPED_MAHOGANY_WOOD = new BlockItem(BYGBlocks.STRIPPED_MAHOGANY_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_MAHOGANY_WOOD.getRegistryName()),
                BYGItems.MAHOGANY_PLANKS = new BlockItem(BYGBlocks.MAHOGANY_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAHOGANY_PLANKS.getRegistryName()),
                BYGItems.MAHOGANY_BOOKSHELF = new BlockItem(BYGBlocks.MAHOGANY_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAHOGANY_BOOKSHELF.getRegistryName()),
                BYGItems.MAHOGANY_CRAFTING_TABLE = new BlockItem(BYGBlocks.MAHOGANY_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAHOGANY_CRAFTING_TABLE.getRegistryName()),
                BYGItems.MAHOGANY_STAIRS = new BlockItem(BYGBlocks.MAHOGANY_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAHOGANY_STAIRS.getRegistryName()),
                BYGItems.MAHOGANY_SLAB = new BlockItem(BYGBlocks.MAHOGANY_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAHOGANY_SLAB.getRegistryName()),
                BYGItems.MAHOGANY_FENCE = new BlockItem(BYGBlocks.MAHOGANY_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAHOGANY_FENCE.getRegistryName()),
                BYGItems.MAHOGANY_FENCE_GATE = new BlockItem(BYGBlocks.MAHOGANY_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAHOGANY_FENCE_GATE.getRegistryName()),
                BYGItems.MAHOGANY_DOOR = new TallBlockItem(BYGBlocks.MAHOGANY_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAHOGANY_DOOR.getRegistryName()),
                BYGItems.MAHOGANY_TRAPDOOR = new BlockItem(BYGBlocks.MAHOGANY_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAHOGANY_TRAPDOOR.getRegistryName()),
                BYGItems.MAHOGANY_PRESSURE_PLATE = new BlockItem(BYGBlocks.MAHOGANY_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAHOGANY_PRESSURE_PLATE.getRegistryName()),
                BYGItems.MAHOGANY_BUTTON = new BlockItem(BYGBlocks.MAHOGANY_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAHOGANY_BUTTON.getRegistryName()),
                BYGItems.MAHOGANY_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.MAHOGANY, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)).setRegistryName("mahogany_boat"),

                //Mangrove Woodtype
                BYGItems.MANGROVE_SAPLING = new BlockItem(BYGBlocks.MANGROVE_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MANGROVE_SAPLING.getRegistryName()),
                BYGItems.MANGROVE_LEAVES = new BlockItem(BYGBlocks.MANGROVE_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MANGROVE_LEAVES.getRegistryName()),
                BYGItems.MANGROVE_LOG = new BlockItem(BYGBlocks.MANGROVE_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MANGROVE_LOG.getRegistryName()),
                BYGItems.MANGROVE_WOOD = new BlockItem(BYGBlocks.MANGROVE_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MANGROVE_WOOD.getRegistryName()),
                BYGItems.STRIPPED_MANGROVE_LOG = new BlockItem(BYGBlocks.STRIPPED_MANGROVE_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_MANGROVE_LOG.getRegistryName()),
                BYGItems.STRIPPED_MANGROVE_WOOD = new BlockItem(BYGBlocks.STRIPPED_MANGROVE_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_MANGROVE_WOOD.getRegistryName()),
                BYGItems.MANGROVE_PLANKS = new BlockItem(BYGBlocks.MANGROVE_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MANGROVE_PLANKS.getRegistryName()),
                BYGItems.MANGROVE_BOOKSHELF = new BlockItem(BYGBlocks.MANGROVE_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MANGROVE_BOOKSHELF.getRegistryName()),
                BYGItems.MANGROVE_CRAFTING_TABLE = new BlockItem(BYGBlocks.MANGROVE_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MANGROVE_CRAFTING_TABLE.getRegistryName()),
                BYGItems.MANGROVE_STAIRS = new BlockItem(BYGBlocks.MANGROVE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MANGROVE_STAIRS.getRegistryName()),
                BYGItems.MANGROVE_SLAB = new BlockItem(BYGBlocks.MANGROVE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MANGROVE_SLAB.getRegistryName()),
                BYGItems.MANGROVE_FENCE = new BlockItem(BYGBlocks.MANGROVE_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MANGROVE_FENCE.getRegistryName()),
                BYGItems.MANGROVE_FENCE_GATE = new BlockItem(BYGBlocks.MANGROVE_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MANGROVE_FENCE_GATE.getRegistryName()),
                BYGItems.MANGROVE_DOOR = new TallBlockItem(BYGBlocks.MANGROVE_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MANGROVE_DOOR.getRegistryName()),
                BYGItems.MANGROVE_TRAPDOOR = new BlockItem(BYGBlocks.MANGROVE_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MANGROVE_TRAPDOOR.getRegistryName()),
                BYGItems.MANGROVE_PRESSURE_PLATE = new BlockItem(BYGBlocks.MANGROVE_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MANGROVE_PRESSURE_PLATE.getRegistryName()),
                BYGItems.MANGROVE_BUTTON = new BlockItem(BYGBlocks.MANGROVE_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MANGROVE_BUTTON.getRegistryName()),
                BYGItems.MANGROVE_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.MANGROVE, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)).setRegistryName("mangrove_boat"),

                //Maple Woodtype
                BYGItems.MAPLE_SAPLING = new BlockItem(BYGBlocks.MAPLE_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAPLE_SAPLING.getRegistryName()),
                BYGItems.MAPLE_LEAVES = new BlockItem(BYGBlocks.MAPLE_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAPLE_LEAVES.getRegistryName()),
                BYGItems.RED_MAPLE_SAPLING = new BlockItem(BYGBlocks.RED_MAPLE_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RED_MAPLE_SAPLING.getRegistryName()),
                BYGItems.RED_MAPLE_LEAVES = new BlockItem(BYGBlocks.RED_MAPLE_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RED_MAPLE_LEAVES.getRegistryName()),
                BYGItems.SILVER_MAPLE_SAPLING = new BlockItem(BYGBlocks.SILVER_MAPLE_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SILVER_MAPLE_SAPLING.getRegistryName()),
                BYGItems.SILVER_MAPLE_LEAVES = new BlockItem(BYGBlocks.SILVER_MAPLE_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SILVER_MAPLE_LEAVES.getRegistryName()),
                BYGItems.MAPLE_LOG = new BlockItem(BYGBlocks.MAPLE_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAPLE_LOG.getRegistryName()),
                BYGItems.MAPLE_WOOD = new BlockItem(BYGBlocks.MAPLE_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAPLE_WOOD.getRegistryName()),
                BYGItems.STRIPPED_MAPLE_LOG = new BlockItem(BYGBlocks.STRIPPED_MAPLE_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_MAPLE_LOG.getRegistryName()),
                BYGItems.STRIPPED_MAPLE_WOOD = new BlockItem(BYGBlocks.STRIPPED_MAPLE_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_MAPLE_WOOD.getRegistryName()),
                BYGItems.MAPLE_PLANKS = new BlockItem(BYGBlocks.MAPLE_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAPLE_PLANKS.getRegistryName()),
                BYGItems.MAPLE_BOOKSHELF = new BlockItem(BYGBlocks.MAPLE_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAPLE_BOOKSHELF.getRegistryName()),
                BYGItems.MAPLE_CRAFTING_TABLE = new BlockItem(BYGBlocks.MAPLE_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAPLE_CRAFTING_TABLE.getRegistryName()),
                BYGItems.MAPLE_STAIRS = new BlockItem(BYGBlocks.MAPLE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAPLE_STAIRS.getRegistryName()),
                BYGItems.MAPLE_SLAB = new BlockItem(BYGBlocks.MAPLE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAPLE_SLAB.getRegistryName()),
                BYGItems.MAPLE_FENCE = new BlockItem(BYGBlocks.MAPLE_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAPLE_FENCE.getRegistryName()),
                BYGItems.MAPLE_FENCE_GATE = new BlockItem(BYGBlocks.MAPLE_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAPLE_FENCE_GATE.getRegistryName()),
                BYGItems.MAPLE_DOOR = new TallBlockItem(BYGBlocks.MAPLE_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAPLE_DOOR.getRegistryName()),
                BYGItems.MAPLE_TRAPDOOR = new BlockItem(BYGBlocks.MAPLE_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAPLE_TRAPDOOR.getRegistryName()),
                BYGItems.MAPLE_PRESSURE_PLATE = new BlockItem(BYGBlocks.MAPLE_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAPLE_PRESSURE_PLATE.getRegistryName()),
                BYGItems.MAPLE_BUTTON = new BlockItem(BYGBlocks.MAPLE_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAPLE_BUTTON.getRegistryName()),
                BYGItems.MAPLE_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.MAPLE, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)).setRegistryName("maple_boat"),

                //Palm Woodtype
                BYGItems.PALM_SAPLING = new BlockItem(BYGBlocks.PALM_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PALM_SAPLING.getRegistryName()),
                BYGItems.PALM_LEAVES = new BlockItem(BYGBlocks.PALM_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PALM_LEAVES.getRegistryName()),
                BYGItems.PALM_LOG = new BlockItem(BYGBlocks.PALM_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PALM_LOG.getRegistryName()),
                BYGItems.PALM_WOOD = new BlockItem(BYGBlocks.PALM_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PALM_WOOD.getRegistryName()),
                BYGItems.STRIPPED_PALM_LOG = new BlockItem(BYGBlocks.STRIPPED_PALM_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_PALM_LOG.getRegistryName()),
                BYGItems.STRIPPED_PALM_WOOD = new BlockItem(BYGBlocks.STRIPPED_PALM_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_PALM_WOOD.getRegistryName()),
                BYGItems.PALM_PLANKS = new BlockItem(BYGBlocks.PALM_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PALM_PLANKS.getRegistryName()),
                BYGItems.PALM_BOOKSHELF = new BlockItem(BYGBlocks.PALM_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PALM_BOOKSHELF.getRegistryName()),
                BYGItems.PALM_CRAFTING_TABLE = new BlockItem(BYGBlocks.PALM_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PALM_CRAFTING_TABLE.getRegistryName()),
                BYGItems.PALM_STAIRS = new BlockItem(BYGBlocks.PALM_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PALM_STAIRS.getRegistryName()),
                BYGItems.PALM_SLAB = new BlockItem(BYGBlocks.PALM_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PALM_SLAB.getRegistryName()),
                BYGItems.PALM_FENCE = new BlockItem(BYGBlocks.PALM_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PALM_FENCE.getRegistryName()),
                BYGItems.PALM_FENCE_GATE = new BlockItem(BYGBlocks.PALM_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PALM_FENCE_GATE.getRegistryName()),
                BYGItems.PALM_DOOR = new TallBlockItem(BYGBlocks.PALM_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PALM_DOOR.getRegistryName()),
                BYGItems.PALM_TRAPDOOR = new BlockItem(BYGBlocks.PALM_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PALM_TRAPDOOR.getRegistryName()),
                BYGItems.PALM_PRESSURE_PLATE = new BlockItem(BYGBlocks.PALM_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PALM_PRESSURE_PLATE.getRegistryName()),
                BYGItems.PALM_BUTTON = new BlockItem(BYGBlocks.PALM_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PALM_BUTTON.getRegistryName()),
                BYGItems.PALM_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.PALM, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)).setRegistryName("palm_boat"),

                //Palo Verde Woodtype
                BYGItems.FLOWERING_PALO_VERDE_LEAVES = new BlockItem(BYGBlocks.FLOWERING_PALO_VERDE_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.FLOWERING_PALO_VERDE_LEAVES.getRegistryName()),
                BYGItems.PALO_VERDE_SAPLING = new BlockItem(BYGBlocks.PALO_VERDE_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PALO_VERDE_SAPLING.getRegistryName()),
                BYGItems.PALO_VERDE_LEAVES = new BlockItem(BYGBlocks.PALO_VERDE_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PALO_VERDE_LEAVES.getRegistryName()),
                BYGItems.PALO_VERDE_LOG = new BlockItem(BYGBlocks.PALO_VERDE_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PALO_VERDE_LOG.getRegistryName()),
                BYGItems.PALO_VERDE_WOOD = new BlockItem(BYGBlocks.PALO_VERDE_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PALO_VERDE_WOOD.getRegistryName()),
                BYGItems.STRIPPED_PALO_VERDE_LOG = new BlockItem(BYGBlocks.STRIPPED_PALO_VERDE_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_PALO_VERDE_LOG.getRegistryName()),
                BYGItems.STRIPPED_PALO_VERDE_WOOD = new BlockItem(BYGBlocks.STRIPPED_PALO_VERDE_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_PALO_VERDE_WOOD.getRegistryName()),

                //Pine Woodtype
                BYGItems.PINE_SAPLING = new BlockItem(BYGBlocks.PINE_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINE_SAPLING.getRegistryName()),
                BYGItems.PINE_LEAVES = new BlockItem(BYGBlocks.PINE_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINE_LEAVES.getRegistryName()),
                BYGItems.PINE_LOG = new BlockItem(BYGBlocks.PINE_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINE_LOG.getRegistryName()),
                BYGItems.PINE_WOOD = new BlockItem(BYGBlocks.PINE_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINE_WOOD.getRegistryName()),
                BYGItems.STRIPPED_PINE_LOG = new BlockItem(BYGBlocks.STRIPPED_PINE_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_PINE_LOG.getRegistryName()),
                BYGItems.STRIPPED_PINE_WOOD = new BlockItem(BYGBlocks.STRIPPED_PINE_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_PINE_WOOD.getRegistryName()),
                BYGItems.PINE_PLANKS = new BlockItem(BYGBlocks.PINE_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINE_PLANKS.getRegistryName()),
                BYGItems.PINE_BOOKSHELF = new BlockItem(BYGBlocks.PINE_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINE_BOOKSHELF.getRegistryName()),
                BYGItems.PINE_CRAFTING_TABLE = new BlockItem(BYGBlocks.PINE_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINE_CRAFTING_TABLE.getRegistryName()),
                BYGItems.PINE_STAIRS = new BlockItem(BYGBlocks.PINE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINE_STAIRS.getRegistryName()),
                BYGItems.PINE_SLAB = new BlockItem(BYGBlocks.PINE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINE_SLAB.getRegistryName()),
                BYGItems.PINE_FENCE = new BlockItem(BYGBlocks.PINE_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINE_FENCE.getRegistryName()),
                BYGItems.PINE_FENCE_GATE = new BlockItem(BYGBlocks.PINE_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINE_FENCE_GATE.getRegistryName()),
                BYGItems.PINE_DOOR = new TallBlockItem(BYGBlocks.PINE_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINE_DOOR.getRegistryName()),
                BYGItems.PINE_TRAPDOOR = new BlockItem(BYGBlocks.PINE_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINE_TRAPDOOR.getRegistryName()),
                BYGItems.PINE_PRESSURE_PLATE = new BlockItem(BYGBlocks.PINE_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINE_PRESSURE_PLATE.getRegistryName()),
                BYGItems.PINE_BUTTON = new BlockItem(BYGBlocks.PINE_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINE_BUTTON.getRegistryName()),
                BYGItems.PINE_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.PINE, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)).setRegistryName("pine_boat"),

                //Rainbow Eucalyptus Woodtype
                BYGItems.RAINBOW_EUCALYPTUS_SAPLING = new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RAINBOW_EUCALYPTUS_SAPLING.getRegistryName()),
                BYGItems.RAINBOW_EUCALYPTUS_LEAVES = new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RAINBOW_EUCALYPTUS_LEAVES.getRegistryName()),
                BYGItems.RAINBOW_EUCALYPTUS_LOG = new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RAINBOW_EUCALYPTUS_LOG.getRegistryName()),
                BYGItems.RAINBOW_EUCALYPTUS_WOOD = new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RAINBOW_EUCALYPTUS_WOOD.getRegistryName()),
                BYGItems.STRIPPED_RAINBOW_EUCALYPTUS_LOG = new BlockItem(BYGBlocks.STRIPPED_RAINBOW_EUCALYPTUS_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_RAINBOW_EUCALYPTUS_LOG.getRegistryName()),
                BYGItems.STRIPPED_RAINBOW_EUCALYPTUS_WOOD = new BlockItem(BYGBlocks.STRIPPED_RAINBOW_EUCALYPTUS_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_RAINBOW_EUCALYPTUS_WOOD.getRegistryName()),
                BYGItems.RAINBOW_EUCALYPTUS_PLANKS = new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RAINBOW_EUCALYPTUS_PLANKS.getRegistryName()),
                BYGItems.RAINBOW_EUCALYPTUS_BOOKSHELF = new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RAINBOW_EUCALYPTUS_BOOKSHELF.getRegistryName()),
                BYGItems.RAINBOW_EUCALYPTUS_CRAFTING_TABLE = new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RAINBOW_EUCALYPTUS_CRAFTING_TABLE.getRegistryName()),
                BYGItems.RAINBOW_EUCALYPTUS_STAIRS = new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RAINBOW_EUCALYPTUS_STAIRS.getRegistryName()),
                BYGItems.RAINBOW_EUCALYPTUS_SLAB = new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RAINBOW_EUCALYPTUS_SLAB.getRegistryName()),
                BYGItems.RAINBOW_EUCALYPTUS_FENCE = new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RAINBOW_EUCALYPTUS_FENCE.getRegistryName()),
                BYGItems.RAINBOW_EUCALYPTUS_FENCE_GATE = new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RAINBOW_EUCALYPTUS_FENCE_GATE.getRegistryName()),
                BYGItems.RAINBOW_EUCALYPTUS_DOOR = new TallBlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RAINBOW_EUCALYPTUS_DOOR.getRegistryName()),
                BYGItems.RAINBOW_EUCALYPTUS_TRAPDOOR = new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RAINBOW_EUCALYPTUS_TRAPDOOR.getRegistryName()),
                BYGItems.RAINBOW_EUCALYPTUS_PRESSURE_PLATE = new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RAINBOW_EUCALYPTUS_PRESSURE_PLATE.getRegistryName()),
                BYGItems.RAINBOW_EUCALYPTUS_BUTTON = new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RAINBOW_EUCALYPTUS_BUTTON.getRegistryName()),
                BYGItems.RAINBOW_EUCALYPTUS_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.RAINBOW_EUCALYPTUS, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)).setRegistryName("rainbow_eucalyptus_boat"),

                //Redwood Woodtype
                BYGItems.REDWOOD_SAPLING = new BlockItem(BYGBlocks.REDWOOD_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.REDWOOD_SAPLING.getRegistryName()),
                BYGItems.REDWOOD_LEAVES = new BlockItem(BYGBlocks.REDWOOD_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.REDWOOD_LEAVES.getRegistryName()),
                BYGItems.REDWOOD_LOG = new BlockItem(BYGBlocks.REDWOOD_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.REDWOOD_LOG.getRegistryName()),
                BYGItems.REDWOOD_WOOD = new BlockItem(BYGBlocks.REDWOOD_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.REDWOOD_WOOD.getRegistryName()),
                BYGItems.STRIPPED_REDWOOD_LOG = new BlockItem(BYGBlocks.STRIPPED_REDWOOD_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_REDWOOD_LOG.getRegistryName()),
                BYGItems.STRIPPED_REDWOOD_WOOD = new BlockItem(BYGBlocks.STRIPPED_REDWOOD_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_REDWOOD_WOOD.getRegistryName()),
                BYGItems.REDWOOD_PLANKS = new BlockItem(BYGBlocks.REDWOOD_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.REDWOOD_PLANKS.getRegistryName()),
                BYGItems.REDWOOD_BOOKSHELF = new BlockItem(BYGBlocks.REDWOOD_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.REDWOOD_BOOKSHELF.getRegistryName()),
                BYGItems.REDWOOD_CRAFTING_TABLE = new BlockItem(BYGBlocks.REDWOOD_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.REDWOOD_CRAFTING_TABLE.getRegistryName()),
                BYGItems.REDWOOD_STAIRS = new BlockItem(BYGBlocks.REDWOOD_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.REDWOOD_STAIRS.getRegistryName()),
                BYGItems.REDWOOD_SLAB = new BlockItem(BYGBlocks.REDWOOD_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.REDWOOD_SLAB.getRegistryName()),
                BYGItems.REDWOOD_FENCE = new BlockItem(BYGBlocks.REDWOOD_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.REDWOOD_FENCE.getRegistryName()),
                BYGItems.REDWOOD_FENCE_GATE = new BlockItem(BYGBlocks.REDWOOD_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.REDWOOD_FENCE_GATE.getRegistryName()),
                BYGItems.REDWOOD_DOOR = new TallBlockItem(BYGBlocks.REDWOOD_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.REDWOOD_DOOR.getRegistryName()),
                BYGItems.REDWOOD_TRAPDOOR = new BlockItem(BYGBlocks.REDWOOD_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.REDWOOD_TRAPDOOR.getRegistryName()),
                BYGItems.REDWOOD_PRESSURE_PLATE = new BlockItem(BYGBlocks.REDWOOD_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.REDWOOD_PRESSURE_PLATE.getRegistryName()),
                BYGItems.REDWOOD_BUTTON = new BlockItem(BYGBlocks.REDWOOD_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.REDWOOD_BUTTON.getRegistryName()),
                BYGItems.REDWOOD_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.REDWOOD, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)).setRegistryName("redwood_boat"),

                //Skyris Woodtype
                BYGItems.SKYRIS_LEAVES_GREEN_APPLE = new BlockItem(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.getRegistryName()),
                BYGItems.GREEN_APPLE = new Item(new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(4).saturation(0.35f).build())).setRegistryName("green_apple"),
                BYGItems.SKYRIS_SAPLING = new BlockItem(BYGBlocks.SKYRIS_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SKYRIS_SAPLING.getRegistryName()),
                BYGItems.SKYRIS_VINE = new BlockItem(BYGBlocks.SKYRIS_VINE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SKYRIS_VINE.getRegistryName()),
                BYGItems.SKYRIS_LEAVES = new BlockItem(BYGBlocks.SKYRIS_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SKYRIS_LEAVES.getRegistryName()),
                BYGItems.SKYRIS_LOG = new BlockItem(BYGBlocks.SKYRIS_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SKYRIS_LOG.getRegistryName()),
                BYGItems.SKYRIS_WOOD = new BlockItem(BYGBlocks.SKYRIS_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SKYRIS_WOOD.getRegistryName()),
                BYGItems.STRIPPED_SKYRIS_LOG = new BlockItem(BYGBlocks.STRIPPED_SKYRIS_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_SKYRIS_LOG.getRegistryName()),
                BYGItems.STRIPPED_SKYRIS_WOOD = new BlockItem(BYGBlocks.STRIPPED_SKYRIS_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_SKYRIS_WOOD.getRegistryName()),
                BYGItems.SKYRIS_PLANKS = new BlockItem(BYGBlocks.SKYRIS_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SKYRIS_PLANKS.getRegistryName()),
                BYGItems.SKYRIS_BOOKSHELF = new BlockItem(BYGBlocks.SKYRIS_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SKYRIS_BOOKSHELF.getRegistryName()),
                BYGItems.SKYRIS_CRAFTING_TABLE = new BlockItem(BYGBlocks.SKYRIS_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SKYRIS_CRAFTING_TABLE.getRegistryName()),
                BYGItems.SKYRIS_STAIRS = new BlockItem(BYGBlocks.SKYRIS_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SKYRIS_STAIRS.getRegistryName()),
                BYGItems.SKYRIS_SLAB = new BlockItem(BYGBlocks.SKYRIS_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SKYRIS_SLAB.getRegistryName()),
                BYGItems.SKYRIS_FENCE = new BlockItem(BYGBlocks.SKYRIS_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SKYRIS_FENCE.getRegistryName()),
                BYGItems.SKYRIS_FENCE_GATE = new BlockItem(BYGBlocks.SKYRIS_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SKYRIS_FENCE_GATE.getRegistryName()),
                BYGItems.SKYRIS_DOOR = new TallBlockItem(BYGBlocks.SKYRIS_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SKYRIS_DOOR.getRegistryName()),
                BYGItems.SKYRIS_TRAPDOOR = new BlockItem(BYGBlocks.SKYRIS_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SKYRIS_TRAPDOOR.getRegistryName()),
                BYGItems.SKYRIS_PRESSURE_PLATE = new BlockItem(BYGBlocks.SKYRIS_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SKYRIS_PRESSURE_PLATE.getRegistryName()),
                BYGItems.SKYRIS_BUTTON = new BlockItem(BYGBlocks.SKYRIS_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SKYRIS_BUTTON.getRegistryName()),
                BYGItems.SKYRIS_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.SKYRIS, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)).setRegistryName("skyris_boat"),

                //Willow Woodtype
                BYGItems.WILLOW_SAPLING = new BlockItem(BYGBlocks.WILLOW_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WILLOW_SAPLING.getRegistryName()),
                BYGItems.WILLOW_LEAVES = new BlockItem(BYGBlocks.WILLOW_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WILLOW_LEAVES.getRegistryName()),
                BYGItems.WILLOW_LOG = new BlockItem(BYGBlocks.WILLOW_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WILLOW_LOG.getRegistryName()),
                BYGItems.WILLOW_WOOD = new BlockItem(BYGBlocks.WILLOW_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WILLOW_WOOD.getRegistryName()),
                BYGItems.STRIPPED_WILLOW_LOG = new BlockItem(BYGBlocks.STRIPPED_WILLOW_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_WILLOW_LOG.getRegistryName()),
                BYGItems.STRIPPED_WILLOW_WOOD = new BlockItem(BYGBlocks.STRIPPED_WILLOW_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_WILLOW_WOOD.getRegistryName()),
                BYGItems.WILLOW_PLANKS = new BlockItem(BYGBlocks.WILLOW_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WILLOW_PLANKS.getRegistryName()),
                BYGItems.WILLOW_BOOKSHELF = new BlockItem(BYGBlocks.WILLOW_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WILLOW_BOOKSHELF.getRegistryName()),
                BYGItems.WILLOW_CRAFTING_TABLE = new BlockItem(BYGBlocks.WILLOW_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WILLOW_CRAFTING_TABLE.getRegistryName()),
                BYGItems.WILLOW_STAIRS = new BlockItem(BYGBlocks.WILLOW_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WILLOW_STAIRS.getRegistryName()),
                BYGItems.WILLOW_SLAB = new BlockItem(BYGBlocks.WILLOW_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WILLOW_SLAB.getRegistryName()),
                BYGItems.WILLOW_FENCE = new BlockItem(BYGBlocks.WILLOW_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WILLOW_FENCE.getRegistryName()),
                BYGItems.WILLOW_FENCE_GATE = new BlockItem(BYGBlocks.WILLOW_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WILLOW_FENCE_GATE.getRegistryName()),
                BYGItems.WILLOW_DOOR = new TallBlockItem(BYGBlocks.WILLOW_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WILLOW_DOOR.getRegistryName()),
                BYGItems.WILLOW_TRAPDOOR = new BlockItem(BYGBlocks.WILLOW_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WILLOW_TRAPDOOR.getRegistryName()),
                BYGItems.WILLOW_PRESSURE_PLATE = new BlockItem(BYGBlocks.WILLOW_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WILLOW_PRESSURE_PLATE.getRegistryName()),
                BYGItems.WILLOW_BUTTON = new BlockItem(BYGBlocks.WILLOW_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WILLOW_BUTTON.getRegistryName()),
                BYGItems.WILLOW_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.WILLOW, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)).setRegistryName("willow_boat"),

                //Witch-Hazel Woodtype
                BYGItems.BLOOMING_WITCH_HAZEL_LEAVES = new BlockItem(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.getRegistryName()),
                BYGItems.WITCH_HAZEL_SAPLING = new BlockItem(BYGBlocks.WITCH_HAZEL_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WITCH_HAZEL_SAPLING.getRegistryName()),
                BYGItems.WITCH_HAZEL_LEAVES = new BlockItem(BYGBlocks.WITCH_HAZEL_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WITCH_HAZEL_LEAVES.getRegistryName()),
                BYGItems.WITCH_HAZEL_LOG = new BlockItem(BYGBlocks.WITCH_HAZEL_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WITCH_HAZEL_LOG.getRegistryName()),
                BYGItems.WITCH_HAZEL_WOOD = new BlockItem(BYGBlocks.WITCH_HAZEL_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WITCH_HAZEL_WOOD.getRegistryName()),
                BYGItems.STRIPPED_WITCH_HAZEL_LOG = new BlockItem(BYGBlocks.STRIPPED_WITCH_HAZEL_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_WITCH_HAZEL_LOG.getRegistryName()),
                BYGItems.STRIPPED_WITCH_HAZEL_WOOD = new BlockItem(BYGBlocks.STRIPPED_WITCH_HAZEL_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_WITCH_HAZEL_WOOD.getRegistryName()),
                BYGItems.WITCH_HAZEL_PLANKS = new BlockItem(BYGBlocks.WITCH_HAZEL_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WITCH_HAZEL_PLANKS.getRegistryName()),
                BYGItems.WITCH_HAZEL_BOOKSHELF = new BlockItem(BYGBlocks.WITCH_HAZEL_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WITCH_HAZEL_BOOKSHELF.getRegistryName()),
                BYGItems.WITCH_HAZEL_CRAFTING_TABLE = new BlockItem(BYGBlocks.WITCH_HAZEL_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WITCH_HAZEL_CRAFTING_TABLE.getRegistryName()),
                BYGItems.WITCH_HAZEL_STAIRS = new BlockItem(BYGBlocks.WITCH_HAZEL_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WITCH_HAZEL_STAIRS.getRegistryName()),
                BYGItems.WITCH_HAZEL_SLAB = new BlockItem(BYGBlocks.WITCH_HAZEL_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WITCH_HAZEL_SLAB.getRegistryName()),
                BYGItems.WITCH_HAZEL_FENCE = new BlockItem(BYGBlocks.WITCH_HAZEL_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WITCH_HAZEL_FENCE.getRegistryName()),
                BYGItems.WITCH_HAZEL_FENCE_GATE = new BlockItem(BYGBlocks.WITCH_HAZEL_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WITCH_HAZEL_FENCE_GATE.getRegistryName()),
                BYGItems.WITCH_HAZEL_DOOR = new TallBlockItem(BYGBlocks.WITCH_HAZEL_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WITCH_HAZEL_DOOR.getRegistryName()),
                BYGItems.WITCH_HAZEL_TRAPDOOR = new BlockItem(BYGBlocks.WITCH_HAZEL_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WITCH_HAZEL_TRAPDOOR.getRegistryName()),
                BYGItems.WITCH_HAZEL_PRESSURE_PLATE = new BlockItem(BYGBlocks.WITCH_HAZEL_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WITCH_HAZEL_PRESSURE_PLATE.getRegistryName()),
                BYGItems.WITCH_HAZEL_BUTTON = new BlockItem(BYGBlocks.WITCH_HAZEL_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WITCH_HAZEL_BUTTON.getRegistryName()),
                BYGItems.WITCH_HAZEL_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.WITCH_HAZEL, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)).setRegistryName("witch_hazel_boat"),

                //Zelkova Woodtype
                BYGItems.ZELKOVA_SAPLING = new BlockItem(BYGBlocks.ZELKOVA_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ZELKOVA_SAPLING.getRegistryName()),
                BYGItems.ZELKOVA_LEAVES = new BlockItem(BYGBlocks.ZELKOVA_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ZELKOVA_LEAVES.getRegistryName()),
                BYGItems.ZELKOVA_LOG = new BlockItem(BYGBlocks.ZELKOVA_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ZELKOVA_LOG.getRegistryName()),
                BYGItems.ZELKOVA_WOOD = new BlockItem(BYGBlocks.ZELKOVA_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ZELKOVA_WOOD.getRegistryName()),
                BYGItems.STRIPPED_ZELKOVA_LOG = new BlockItem(BYGBlocks.STRIPPED_ZELKOVA_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_ZELKOVA_LOG.getRegistryName()),
                BYGItems.STRIPPED_ZELKOVA_WOOD = new BlockItem(BYGBlocks.STRIPPED_ZELKOVA_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_ZELKOVA_WOOD.getRegistryName()),
                BYGItems.ZELKOVA_PLANKS = new BlockItem(BYGBlocks.ZELKOVA_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ZELKOVA_PLANKS.getRegistryName()),
                BYGItems.ZELKOVA_BOOKSHELF = new BlockItem(BYGBlocks.ZELKOVA_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ZELKOVA_BOOKSHELF.getRegistryName()),
                BYGItems.ZELKOVA_CRAFTING_TABLE = new BlockItem(BYGBlocks.ZELKOVA_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ZELKOVA_CRAFTING_TABLE.getRegistryName()),
                BYGItems.ZELKOVA_STAIRS = new BlockItem(BYGBlocks.ZELKOVA_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ZELKOVA_STAIRS.getRegistryName()),
                BYGItems.ZELKOVA_SLAB = new BlockItem(BYGBlocks.ZELKOVA_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ZELKOVA_SLAB.getRegistryName()),
                BYGItems.ZELKOVA_FENCE = new BlockItem(BYGBlocks.ZELKOVA_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ZELKOVA_FENCE.getRegistryName()),
                BYGItems.ZELKOVA_FENCE_GATE = new BlockItem(BYGBlocks.ZELKOVA_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ZELKOVA_FENCE_GATE.getRegistryName()),
                BYGItems.ZELKOVA_DOOR = new TallBlockItem(BYGBlocks.ZELKOVA_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ZELKOVA_DOOR.getRegistryName()),
                BYGItems.ZELKOVA_TRAPDOOR = new BlockItem(BYGBlocks.ZELKOVA_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ZELKOVA_TRAPDOOR.getRegistryName()),
                BYGItems.ZELKOVA_PRESSURE_PLATE = new BlockItem(BYGBlocks.ZELKOVA_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ZELKOVA_PRESSURE_PLATE.getRegistryName()),
                BYGItems.ZELKOVA_BUTTON = new BlockItem(BYGBlocks.ZELKOVA_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ZELKOVA_BUTTON.getRegistryName()),
                BYGItems.ZELKOVA_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.ZELKOVA, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)).setRegistryName("zelkova_boat"),

                //Sythian Woodtype
                BYGItems.SYTHIAN_WART_BLOCK = new BlockItem(BYGBlocks.SYTHIAN_WART_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SYTHIAN_WART_BLOCK.getRegistryName()),
                BYGItems.SYTHIAN_FUNGUS = new BlockItem(BYGBlocks.SYTHIAN_FUNGUS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SYTHIAN_FUNGUS.getRegistryName()),
                BYGItems.SYTHIAN_STEM = new BlockItem(BYGBlocks.SYTHIAN_STEM, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SYTHIAN_STEM.getRegistryName()),
                BYGItems.SYTHIAN_HYPHAE = new BlockItem(BYGBlocks.SYTHIAN_HYPHAE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SYTHIAN_HYPHAE.getRegistryName()),
                BYGItems.STRIPPED_SYTHIAN_STEM = new BlockItem(BYGBlocks.STRIPPED_SYTHIAN_STEM, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_SYTHIAN_STEM.getRegistryName()),
                BYGItems.STRIPPED_SYTHIAN_HYPHAE = new BlockItem(BYGBlocks.STRIPPED_SYTHIAN_HYPHAE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_SYTHIAN_HYPHAE.getRegistryName()),
                BYGItems.SYTHIAN_PLANKS = new BlockItem(BYGBlocks.SYTHIAN_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SYTHIAN_PLANKS.getRegistryName()),
                BYGItems.SYTHIAN_BOOKSHELF = new BlockItem(BYGBlocks.SYTHIAN_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SYTHIAN_BOOKSHELF.getRegistryName()),
                BYGItems.SYTHIAN_CRAFTING_TABLE = new BlockItem(BYGBlocks.SYTHIAN_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SYTHIAN_CRAFTING_TABLE.getRegistryName()),
                BYGItems.SYTHIAN_STAIRS = new BlockItem(BYGBlocks.SYTHIAN_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SYTHIAN_STAIRS.getRegistryName()),
                BYGItems.SYTHIAN_SLAB = new BlockItem(BYGBlocks.SYTHIAN_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SYTHIAN_SLAB.getRegistryName()),
                BYGItems.SYTHIAN_FENCE = new BlockItem(BYGBlocks.SYTHIAN_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SYTHIAN_FENCE.getRegistryName()),
                BYGItems.SYTHIAN_FENCE_GATE = new BlockItem(BYGBlocks.SYTHIAN_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SYTHIAN_FENCE_GATE.getRegistryName()),
                BYGItems.SYTHIAN_DOOR = new TallBlockItem(BYGBlocks.SYTHIAN_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SYTHIAN_DOOR.getRegistryName()),
                BYGItems.SYTHIAN_TRAPDOOR = new BlockItem(BYGBlocks.SYTHIAN_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SYTHIAN_TRAPDOOR.getRegistryName()),
                BYGItems.SYTHIAN_PRESSURE_PLATE = new BlockItem(BYGBlocks.SYTHIAN_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SYTHIAN_PRESSURE_PLATE.getRegistryName()),
                BYGItems.SYTHIAN_BUTTON = new BlockItem(BYGBlocks.SYTHIAN_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SYTHIAN_BUTTON.getRegistryName()),

                //Embur Woodtype
                BYGItems.EMBUR_GEL_BALL = new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName("embur_gel_ball"),
                BYGItems.EMBUR_GEL_BLOCK = new BlockItem(BYGBlocks.EMBUR_GEL_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EMBUR_GEL_BLOCK.getRegistryName()),
                BYGItems.EMBUR_GEL_VINES = new BlockItem(BYGBlocks.EMBUR_GEL_VINES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EMBUR_GEL_VINES.getRegistryName()),
                BYGItems.EMBUR_WART = new BlockItem(BYGBlocks.EMBUR_WART, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EMBUR_WART.getRegistryName()),
                BYGItems.EMBUR_PEDU = new BlockItem(BYGBlocks.EMBUR_PEDU, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EMBUR_PEDU.getRegistryName()),
                BYGItems.EMBUR_HYPHAE = new BlockItem(BYGBlocks.EMBUR_HYPHAE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EMBUR_HYPHAE.getRegistryName()),
                BYGItems.STRIPPED_EMBUR_PEDU = new BlockItem(BYGBlocks.STRIPPED_EMBUR_PEDU, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_EMBUR_PEDU.getRegistryName()),
                BYGItems.STRIPPED_EMBUR_HYPHAE = new BlockItem(BYGBlocks.STRIPPED_EMBUR_HYPHAE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.STRIPPED_EMBUR_HYPHAE.getRegistryName()),
                BYGItems.EMBUR_PLANKS = new BlockItem(BYGBlocks.EMBUR_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EMBUR_PLANKS.getRegistryName()),
                BYGItems.EMBUR_BOOKSHELF = new BlockItem(BYGBlocks.EMBUR_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EMBUR_BOOKSHELF.getRegistryName()),
                BYGItems.EMBUR_CRAFTING_TABLE = new BlockItem(BYGBlocks.EMBUR_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EMBUR_CRAFTING_TABLE.getRegistryName()),
                BYGItems.EMBUR_STAIRS = new BlockItem(BYGBlocks.EMBUR_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EMBUR_STAIRS.getRegistryName()),
                BYGItems.EMBUR_SLAB = new BlockItem(BYGBlocks.EMBUR_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EMBUR_SLAB.getRegistryName()),
                BYGItems.EMBUR_FENCE = new BlockItem(BYGBlocks.EMBUR_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EMBUR_FENCE.getRegistryName()),
                BYGItems.EMBUR_FENCE_GATE = new BlockItem(BYGBlocks.EMBUR_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EMBUR_FENCE_GATE.getRegistryName()),
                BYGItems.EMBUR_DOOR = new TallBlockItem(BYGBlocks.EMBUR_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EMBUR_DOOR.getRegistryName()),
                BYGItems.EMBUR_TRAPDOOR = new BlockItem(BYGBlocks.EMBUR_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EMBUR_TRAPDOOR.getRegistryName()),
                BYGItems.EMBUR_PRESSURE_PLATE = new BlockItem(BYGBlocks.EMBUR_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EMBUR_PRESSURE_PLATE.getRegistryName()),
                BYGItems.EMBUR_BUTTON = new BlockItem(BYGBlocks.EMBUR_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EMBUR_BUTTON.getRegistryName()),

                //SaplingItems
                BYGItems.WITHERING_OAK_SAPLING = new BlockItem(BYGBlocks.WITHERING_OAK_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WITHERING_OAK_SAPLING.getRegistryName()),
                BYGItems.WITHERING_OAK_LEAVES = new BlockItem(BYGBlocks.WITHERING_OAK_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WITHERING_OAK_LEAVES.getRegistryName()),
                BYGItems.WITHERING_OAK_LOG = new BlockItem(BYGBlocks.WITHERING_OAK_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WITHERING_OAK_LOG.getRegistryName()),
                BYGItems.WITHERING_OAK_WOOD = new BlockItem(BYGBlocks.WITHERING_OAK_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WITHERING_OAK_WOOD.getRegistryName()),

                BYGItems.ARAUCARIA_SAPLING = new BlockItem(BYGBlocks.ARAUCARIA_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ARAUCARIA_SAPLING.getRegistryName()),
                BYGItems.ARAUCARIA_LEAVES = new BlockItem(BYGBlocks.ARAUCARIA_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ARAUCARIA_LEAVES.getRegistryName()),

                BYGItems.BLUE_SPRUCE_SAPLING = new BlockItem(BYGBlocks.BLUE_SPRUCE_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_SPRUCE_SAPLING.getRegistryName()),
                BYGItems.BLUE_SPRUCE_LEAVES = new BlockItem(BYGBlocks.BLUE_SPRUCE_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_SPRUCE_LEAVES.getRegistryName()),

                BYGItems.BROWN_BIRCH_SAPLING = new BlockItem(BYGBlocks.BROWN_BIRCH_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BROWN_BIRCH_SAPLING.getRegistryName()),
                BYGItems.BROWN_BIRCH_LEAVES = new BlockItem(BYGBlocks.BROWN_BIRCH_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BROWN_BIRCH_LEAVES.getRegistryName()),

                BYGItems.BROWN_OAK_SAPLING = new BlockItem(BYGBlocks.BROWN_OAK_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BROWN_OAK_SAPLING.getRegistryName()),
                BYGItems.BROWN_OAK_LEAVES = new BlockItem(BYGBlocks.BROWN_OAK_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BROWN_OAK_LEAVES.getRegistryName()),

                BYGItems.BROWN_ZELKOVA_SAPLING = new BlockItem(BYGBlocks.BROWN_ZELKOVA_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BROWN_ZELKOVA_SAPLING.getRegistryName()),
                BYGItems.BROWN_ZELKOVA_LEAVES = new BlockItem(BYGBlocks.BROWN_ZELKOVA_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BROWN_ZELKOVA_LEAVES.getRegistryName()),

                BYGItems.JOSHUA_SAPLING = new BlockItem(BYGBlocks.JOSHUA_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.JOSHUA_SAPLING.getRegistryName()),
                BYGItems.JOSHUA_LEAVES = new BlockItem(BYGBlocks.JOSHUA_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.JOSHUA_LEAVES.getRegistryName()),
                BYGItems.RIPE_JOSHUA_LEAVES = new BlockItem(BYGBlocks.RIPE_JOSHUA_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RIPE_JOSHUA_LEAVES.getRegistryName()),
                BYGItems.COOKED_JOSHUA_FRUIT = new Item(new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(5).saturation(0.4f).build())).setRegistryName("cooked_joshua_fruit"),
                BYGItems.JOSHUA_FRUIT = new Item(new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(2).saturation(0.35f).build())).setRegistryName("joshua_fruit"),


                BYGItems.ORANGE_BIRCH_SAPLING = new BlockItem(BYGBlocks.ORANGE_BIRCH_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ORANGE_BIRCH_SAPLING.getRegistryName()),
                BYGItems.ORANGE_BIRCH_LEAVES = new BlockItem(BYGBlocks.ORANGE_BIRCH_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ORANGE_BIRCH_LEAVES.getRegistryName()),

                BYGItems.ORANGE_OAK_SAPLING = new BlockItem(BYGBlocks.ORANGE_OAK_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ORANGE_OAK_SAPLING.getRegistryName()),
                BYGItems.ORANGE_OAK_LEAVES = new BlockItem(BYGBlocks.ORANGE_OAK_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ORANGE_OAK_LEAVES.getRegistryName()),

                BYGItems.ORANGE_SPRUCE_SAPLING = new BlockItem(BYGBlocks.ORANGE_SPRUCE_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ORANGE_SPRUCE_SAPLING.getRegistryName()),
                BYGItems.ORANGE_SPRUCE_LEAVES = new BlockItem(BYGBlocks.ORANGE_SPRUCE_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ORANGE_SPRUCE_LEAVES.getRegistryName()),

                BYGItems.ORCHARD_SAPLING = new BlockItem(BYGBlocks.ORCHARD_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ORCHARD_SAPLING.getRegistryName()),
                BYGItems.RIPE_ORCHARD_LEAVES = new BlockItem(BYGBlocks.RIPE_ORCHARD_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RIPE_ORCHARD_LEAVES.getRegistryName()),
                BYGItems.FLOWERING_ORCHARD_LEAVES = new BlockItem(BYGBlocks.FLOWERING_ORCHARD_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.FLOWERING_ORCHARD_LEAVES.getRegistryName()),
                BYGItems.ORCHARD_LEAVES = new BlockItem(BYGBlocks.ORCHARD_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ORCHARD_LEAVES.getRegistryName()),

                BYGItems.RED_BIRCH_SAPLING = new BlockItem(BYGBlocks.RED_BIRCH_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RED_BIRCH_SAPLING.getRegistryName()),
                BYGItems.RED_BIRCH_LEAVES = new BlockItem(BYGBlocks.RED_BIRCH_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RED_BIRCH_LEAVES.getRegistryName()),

                BYGItems.RED_OAK_SAPLING = new BlockItem(BYGBlocks.RED_OAK_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RED_OAK_SAPLING.getRegistryName()),
                BYGItems.RED_OAK_LEAVES = new BlockItem(BYGBlocks.RED_OAK_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RED_OAK_LEAVES.getRegistryName()),

                BYGItems.RED_SPRUCE_SAPLING = new BlockItem(BYGBlocks.RED_SPRUCE_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RED_SPRUCE_SAPLING.getRegistryName()),
                BYGItems.RED_SPRUCE_LEAVES = new BlockItem(BYGBlocks.RED_SPRUCE_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RED_SPRUCE_LEAVES.getRegistryName()),

                BYGItems.YELLOW_BIRCH_SAPLING = new BlockItem(BYGBlocks.YELLOW_BIRCH_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.YELLOW_BIRCH_SAPLING.getRegistryName()),
                BYGItems.YELLOW_BIRCH_LEAVES = new BlockItem(BYGBlocks.YELLOW_BIRCH_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.YELLOW_BIRCH_LEAVES.getRegistryName()),

                BYGItems.YELLOW_SPRUCE_SAPLING = new BlockItem(BYGBlocks.YELLOW_SPRUCE_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.YELLOW_SPRUCE_SAPLING.getRegistryName()),
                BYGItems.YELLOW_SPRUCE_LEAVES = new BlockItem(BYGBlocks.YELLOW_SPRUCE_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.YELLOW_SPRUCE_LEAVES.getRegistryName()),

                //Glowcane
                BYGItems.BLUE_GLOWCANE_DUST = new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName("blue_glowcane_dust"),
                BYGItems.BLUE_GLOWCANE = new BlockItem(BYGBlocks.BLUE_GLOWCANE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_GLOWCANE.getRegistryName()),
                BYGItems.BLUE_GLOWCANE_BLOCK = new BlockItem(BYGBlocks.BLUE_GLOWCANE_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_GLOWCANE_BLOCK.getRegistryName()),

                BYGItems.PINK_GLOWCANE_DUST = new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName("pink_glowcane_dust"),
                BYGItems.PINK_GLOWCANE = new BlockItem(BYGBlocks.PINK_GLOWCANE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINK_GLOWCANE.getRegistryName()),
                BYGItems.PINK_GLOWCANE_BLOCK = new BlockItem(BYGBlocks.PINK_GLOWCANE_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINK_GLOWCANE_BLOCK.getRegistryName()),

                BYGItems.PURPLE_GLOWCANE_DUST = new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName("purple_glowcane_dust"),
                BYGItems.PURPLE_GLOWCANE = new BlockItem(BYGBlocks.PURPLE_GLOWCANE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PURPLE_GLOWCANE.getRegistryName()),
                BYGItems.PURPLE_GLOWCANE_BLOCK = new BlockItem(BYGBlocks.PURPLE_GLOWCANE_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PURPLE_GLOWCANE_BLOCK.getRegistryName()),

                BYGItems.RED_GLOWCANE_DUST = new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName("red_glowcane_dust"),
                BYGItems.RED_GLOWCANE = new BlockItem(BYGBlocks.RED_GLOWCANE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RED_GLOWCANE.getRegistryName()),
                BYGItems.RED_GLOWCANE_BLOCK = new BlockItem(BYGBlocks.RED_GLOWCANE_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RED_GLOWCANE_BLOCK.getRegistryName()),

                //Glowshroom
                BYGItems.BLUE_GLOWSHROOM = new BlockItem(BYGBlocks.BLUE_GLOWSHROOM, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_GLOWSHROOM.getRegistryName()),
                BYGItems.BLUE_GLOWSHROOM_BLOCK = new BlockItem(BYGBlocks.BLUE_GLOWSHROOM_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_GLOWSHROOM_BLOCK.getRegistryName()),
                BYGItems.PURPLE_GLOWSHROOM = new BlockItem(BYGBlocks.PURPLE_GLOWSHROOM, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PURPLE_GLOWSHROOM.getRegistryName()),
                BYGItems.PURPLE_GLOWSHROOM_BLOCK = new BlockItem(BYGBlocks.PURPLE_GLOWSHROOM_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PURPLE_GLOWSHROOM_BLOCK.getRegistryName()),
                BYGItems.RED_GLOWSHROOM_STEM = new BlockItem(BYGBlocks.RED_GLOWSHROOM_STEM, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RED_GLOWSHROOM_STEM.getRegistryName()),
                BYGItems.YELLOW_GLOWSHROOM_STEM = new BlockItem(BYGBlocks.YELLOW_GLOWSHROOM_STEM, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.YELLOW_GLOWSHROOM_STEM.getRegistryName()),

                //Nether
                BYGItems.OVERGROWN_CRIMSON_BLACKSTONE = new BlockItem(BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE.getRegistryName()),
                BYGItems.TALL_CRIMSON_ROOTS = new BlockItem(BYGBlocks.TALL_CRIMSON_ROOTS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.TALL_CRIMSON_ROOTS.getRegistryName()),
                BYGItems.CRIMSON_BERRIES = new BlockNamedItem(BYGBlocks.CRIMSON_BERRY_BUSH, new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(3).saturation(0.4f).build())).setRegistryName("crimson_berries"),

                BYGItems.WARPED_CACTUS = new BlockItem(BYGBlocks.WARPED_CACTUS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WARPED_CACTUS.getRegistryName()),
                BYGItems.WARPED_BUSH = new BlockItem(BYGBlocks.WARPED_BUSH, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WARPED_BUSH.getRegistryName()),
                BYGItems.WARPED_CORAL_BLOCK = new BlockItem(BYGBlocks.WARPED_CORAL_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WARPED_CORAL_BLOCK.getRegistryName()),
                BYGItems.WARPED_CORAL = new BlockItem(BYGBlocks.WARPED_CORAL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WARPED_CORAL.getRegistryName()),
                BYGItems.WARPED_CORAL_FAN = new BlockItem(BYGBlocks.WARPED_CORAL_FAN, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WARPED_CORAL_FAN.getRegistryName()),
                BYGItems.NYLIUM_SOUL_SAND = new BlockItem(BYGBlocks.NYLIUM_SOUL_SAND, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.NYLIUM_SOUL_SAND.getRegistryName()),
                BYGItems.NYLIUM_SOUL_SOIL = new BlockItem(BYGBlocks.NYLIUM_SOUL_SOIL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.NYLIUM_SOUL_SOIL.getRegistryName()),

                BYGItems.FROST_MAGMA = new BlockItem(BYGBlocks.FROST_MAGMA, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.FROST_MAGMA.getRegistryName()),
                BYGItems.SUBZERO_ASH = new BlockItem(BYGBlocks.SUBZERO_ASH, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SUBZERO_ASH.getRegistryName()),
                BYGItems.SUBZERO_ASH_BLOCK = new BlockItem(BYGBlocks.SUBZERO_ASH_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SUBZERO_ASH_BLOCK.getRegistryName()),

                BYGItems.ANTHRACITE = new AnthraciteItem(new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName("anthracite"),
                BYGItems.ANTHRACITE_BLOCK = new AnthraciteBlockItem(BYGBlocks.ANTHRACITE_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ANTHRACITE_BLOCK.getRegistryName()),
                BYGItems.ANTHRACITE_ORE = new BlockItem(BYGBlocks.ANTHRACITE_ORE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ANTHRACITE_ORE.getRegistryName()),
                BYGItems.BRIMSTONE = new BlockItem(BYGBlocks.BRIMSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BRIMSTONE.getRegistryName()),
                BYGItems.BRIM_POWDER = new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName("brim_powder"),
                BYGItems.BORIC_CAMPFIRE = new BlockItem(BYGBlocks.BORIC_CAMPFIRE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BORIC_CAMPFIRE.getRegistryName()),
                BYGItems.YELLOW_NETHER_BRICKS = new BlockItem(BYGBlocks.YELLOW_NETHER_BRICKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.YELLOW_NETHER_BRICKS.getRegistryName()),
                BYGItems.YELLOW_NETHER_BRICK = new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName("yellow_nether_brick"),
                BYGItems.MAGMATIC_STONE = new BlockItem(BYGBlocks.MAGMATIC_STONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAGMATIC_STONE.getRegistryName()),

                BYGItems.HANGING_BONE = new BlockItem(BYGBlocks.HANGING_BONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.HANGING_BONE.getRegistryName()),
                BYGItems.QUARTZ_CRYSTAL = new BlockItem(BYGBlocks.QUARTZ_CRYSTAL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.QUARTZ_CRYSTAL.getRegistryName()),
                BYGItems.QUARTZITE_SAND = new BlockItem(BYGBlocks.QUARTZITE_SAND, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.QUARTZITE_SAND.getRegistryName()),
                BYGItems.RAW_QUARTZ_BLOCK = new BlockItem(BYGBlocks.RAW_QUARTZ_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RAW_QUARTZ_BLOCK.getRegistryName()),

                BYGItems.WHALING_VINES = new BlockItem(BYGBlocks.WAILING_VINES, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WAILING_VINES.getRegistryName()),
                BYGItems.WHALING_GRASS = new BlockItem(BYGBlocks.WHALING_GRASS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WHALING_GRASS.getRegistryName()),
                BYGItems.SCORCHED_BUSH = new BlockItem(BYGBlocks.SCORCHED_BUSH, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SCORCHED_BUSH.getRegistryName()),
                BYGItems.SCORCHED_GRASS = new BlockItem(BYGBlocks.SCORCHED_GRASS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SCORCHED_GRASS.getRegistryName()),

                BYGItems.SOUL_SHROOM = new BlockItem(BYGBlocks.SOUL_SHROOM, new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(2).saturation(0.6f).effect(new EffectInstance(Effects.WEAKNESS, 200, 0), 1.0F).build())).setRegistryName(BYGBlocks.SOUL_SHROOM.getRegistryName()),
                BYGItems.SOUL_SHROOM_SPORE_END = new BlockItem(BYGBlocks.SOUL_SHROOM_SPORE_END, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SOUL_SHROOM_SPORE_END.getRegistryName()),
                BYGItems.SOUL_SHROOM_STEM = new BlockItem(BYGBlocks.SOUL_SHROOM_STEM, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SOUL_SHROOM_STEM.getRegistryName()),
                BYGItems.SOUL_SHROOM_BLOCK = new BlockItem(BYGBlocks.SOUL_SHROOM_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SOUL_SHROOM_BLOCK.getRegistryName()),
                BYGItems.DEATH_CAP = new BlockItem(BYGBlocks.DEATH_CAP, new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(2).saturation(0.6f).effect(new EffectInstance(Effects.WITHER, 200, 0), 1.0F).build())).setRegistryName(BYGBlocks.DEATH_CAP.getRegistryName()),
                BYGItems.DEATH_CAP_MUSHROOM_BLOCK = new BlockItem(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK.getRegistryName()),

                BYGItems.WEEPING_ROOTS = new BlockItem(BYGBlocks.WEEPING_ROOTS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WEEPING_ROOTS.getRegistryName()),
                BYGItems.NETHER_BRISTLE = new BlockItem(BYGBlocks.NETHER_BRISTLE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.NETHER_BRISTLE.getRegistryName()),
                BYGItems.MYCELIUM_NETHERRACK = new BlockItem(BYGBlocks.MYCELIUM_NETHERRACK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MYCELIUM_NETHERRACK.getRegistryName()),
                BYGItems.OVERGROWN_NETHERRACK = new BlockItem(BYGBlocks.OVERGROWN_NETHERRACK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.OVERGROWN_NETHERRACK.getRegistryName()),
                BYGItems.MOSSY_NETHERRACK = new BlockItem(BYGBlocks.MOSSY_NETHERRACK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MOSSY_NETHERRACK.getRegistryName()),

                BYGItems.PERVADED_NETHERRACK = new BlockItem(BYGBlocks.PERVADED_NETHERRACK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PERVADED_NETHERRACK.getRegistryName()),
                BYGItems.GLOWSTONE_LANTERN = new BlockItem(BYGBlocks.GLOWSTONE_LANTERN, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.GLOWSTONE_LANTERN.getRegistryName()),
                BYGItems.GLOWSTONE_LAMP = new BlockItem(BYGBlocks.GLOWSTONE_LAMP, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.GLOWSTONE_LAMP.getRegistryName()),

                BYGItems.SYTHIAN_NYLIUM = new BlockItem(BYGBlocks.SYTHIAN_NYLIUM, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SYTHIAN_NYLIUM.getRegistryName()),
                BYGItems.SYTHIAN_ROOTS = new BlockItem(BYGBlocks.SYTHIAN_ROOTS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SYTHIAN_ROOTS.getRegistryName()),
                BYGItems.SYTHIAN_SPROUT = new BlockItem(BYGBlocks.SYTHIAN_SPROUT, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SYTHIAN_SPROUT.getRegistryName()),
                BYGItems.SYTHIAN_STALK_BLOCK = new BlockItem(BYGBlocks.SYTHIAN_STALK_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SYTHIAN_STALK_BLOCK.getRegistryName()),
                BYGItems.SYTHIAN_SCAFFOLDING = new ScaffoldingItem(BYGBlocks.SYTHIAN_SCAFFOLDING, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SYTHIAN_SCAFFOLDING.getRegistryName()),
                BYGItems.HANGING_SYTHIAN_ROOTS = new BlockItem(BYGBlocks.HANGING_SYTHIAN_ROOTS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.HANGING_SYTHIAN_ROOTS.getRegistryName()),

                BYGItems.EMBUR_NYLIUM = new BlockItem(BYGBlocks.EMBUR_NYLIUM, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EMBUR_NYLIUM.getRegistryName()),
                BYGItems.EMBUR_SPROUTS = new BlockItem(BYGBlocks.EMBUR_SPROUTS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EMBUR_SPROUTS.getRegistryName()),
                BYGItems.EMBUR_ROOTS = new BlockItem(BYGBlocks.EMBUR_ROOTS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EMBUR_ROOTS.getRegistryName()),
                BYGItems.TALL_EMBUR_ROOTS = new BlockItem(BYGBlocks.TALL_EMBUR_ROOTS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.TALL_EMBUR_ROOTS.getRegistryName()),
                BYGItems.EMBUR_LILY = (new EmburLilyItem(BYGBlocks.EMBUR_LILY, (new Item.Properties()).group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.EMBUR_LILY.getRegistryName())),

                BYGItems.BLUE_NETHERRACK_BRICK = new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName("blue_nether_brick"),
                BYGItems.BLUE_NETHERRACK = new BlockItem(BYGBlocks.BLUE_NETHERRACK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_NETHERRACK.getRegistryName()),
                BYGItems.BLUE_NETHERRACK_BRICKS = new BlockItem(BYGBlocks.BLUE_NETHERRACK_BRICKS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_NETHERRACK_BRICKS.getRegistryName()),


                //End
                BYGItems.IVIS_PHYLIUM = new BlockItem(BYGBlocks.IVIS_PHYLIUM, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.IVIS_PHYLIUM.getRegistryName()),
                BYGItems.IVIS_ROOTS = new BlockItem(BYGBlocks.IVIS_ROOTS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.IVIS_ROOTS.getRegistryName()),
                BYGItems.IVIS_SPROUT = new BlockItem(BYGBlocks.IVIS_SPROUT, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.IVIS_SPROUT.getRegistryName()),

                //Ice
                BYGItems.BLACK_ICE = new BlockItem(BYGBlocks.BLACK_ICE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLACK_ICE.getRegistryName()),
                BYGItems.PACKED_BLACK_ICE = new BlockItem(BYGBlocks.PACKED_BLACK_ICE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PACKED_BLACK_ICE.getRegistryName()),

                //Mushrooms
                BYGItems.GREEN_MUSHSHROOM = new BlockItem(BYGBlocks.GREEN_MUSHROOM, new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(2).saturation(0.6f).build())).setRegistryName(BYGBlocks.GREEN_MUSHROOM.getRegistryName()),
                BYGItems.GREEN_MUSHROOM_BLOCK = new BlockItem(BYGBlocks.GREEN_MUSHROOM_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.GREEN_MUSHROOM_BLOCK.getRegistryName()),
                BYGItems.WEEPING_MILKCAP = new BlockItem(BYGBlocks.WEEPING_MILKCAP, new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(2).saturation(0.6f).build())).setRegistryName(BYGBlocks.WEEPING_MILKCAP.getRegistryName()),
                BYGItems.MILKCAP_MUSHROOM_BLOCK = new BlockItem(BYGBlocks.MILKCAP_MUSHROOM_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MILKCAP_MUSHROOM_BLOCK.getRegistryName()),
                BYGItems.WOOD_BLEWIT = new BlockItem(BYGBlocks.WOOD_BLEWIT, new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(2).saturation(0.6f).build())).setRegistryName(BYGBlocks.WOOD_BLEWIT.getRegistryName()),
                BYGItems.BLEWIT_MUSHROOM_BLOCK = new BlockItem(BYGBlocks.BLEWIT_MUSHROOM_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLEWIT_MUSHROOM_BLOCK.getRegistryName()),
                BYGItems.BLACK_PUFF = new BlockItem(BYGBlocks.BLACK_PUFF, new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(2).saturation(0.6f).build())).setRegistryName(BYGBlocks.BLACK_PUFF.getRegistryName()),
                BYGItems.PUFF_MUSHROOM_BLOCK = new BlockItem(BYGBlocks.PUFF_MUSHROOM_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PUFF_MUSHROOM_BLOCK.getRegistryName()),
                BYGItems.WHITE_MUSHROOM_STEM = new BlockItem(BYGBlocks.WHITE_MUSHROOM_STEM, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WHITE_MUSHROOM_STEM.getRegistryName()),
                BYGItems.BROWN_MUSHROOM_STEM = new BlockItem(BYGBlocks.BROWN_MUSHROOM_STEM, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BROWN_MUSHROOM_STEM.getRegistryName()),


                //Plants
                BYGItems.BLUE_BERRY = new BlockNamedItem(BYGBlocks.BLUEBERRY_BUSH, new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(2).saturation(0.1f).build())).setRegistryName("blueberries"),
                BYGItems.CATTAIL = new BlockItem(BYGBlocks.CATTAIL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CATTAIL.getRegistryName()),
                BYGItems.GOLDEN_SPINED_CACTUS = new BlockItem(BYGBlocks.GOLDEN_SPINED_CACTUS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.GOLDEN_SPINED_CACTUS.getRegistryName()),
                BYGItems.HORSEWEED = new BlockItem(BYGBlocks.HORSEWEED, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.HORSEWEED.getRegistryName()),
                BYGItems.MINI_CACTUS = new BlockItem(BYGBlocks.MINI_CACTUS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MINI_CACTUS.getRegistryName()),
                BYGItems.POISON_IVY = new BlockItem(BYGBlocks.POISON_IVY, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.POISON_IVY.getRegistryName()),
                BYGItems.PRICKLY_PEAR_CACTUS = new BlockItem(BYGBlocks.PRICKLY_PEAR_CACTUS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PRICKLY_PEAR_CACTUS.getRegistryName()),
                BYGItems.PRAIRIE_GRASS = new BlockItem(BYGBlocks.PRAIRIE_GRASS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PRAIRIE_GRASS.getRegistryName()),
                BYGItems.REEDS = new BlockItem(BYGBlocks.REEDS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.REEDS.getRegistryName()),
                BYGItems.REED_THATCH = new BlockItem(BYGBlocks.REED_THATCH, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.REED_THATCH.getRegistryName()),
                BYGItems.REED_THATCH_STAIRS = new BlockItem(BYGBlocks.REED_THATCH_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.REED_THATCH_STAIRS.getRegistryName()),
                BYGItems.REED_THATCH_CARPET = new BlockItem(BYGBlocks.REED_THATCH_CARPET, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.REED_THATCH_CARPET.getRegistryName()),
                BYGItems.REED_THATCH_SLAB = new BlockItem(BYGBlocks.REED_THATCH_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.REED_THATCH_SLAB.getRegistryName()),

                BYGItems.SHORT_GRASS = new BlockItem(BYGBlocks.SHORT_GRASS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SHORT_GRASS.getRegistryName()),
                BYGItems.TALL_PRAIRIE_GRASS = new BlockItem(BYGBlocks.TALL_PRAIRIE_GRASS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.TALL_PRAIRIE_GRASS.getRegistryName()),
                BYGItems.TINY_LILYPADS = (new BYGLilyItem(BYGBlocks.TINY_LILYPADS, (new Item.Properties()).group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.TINY_LILYPADS.getRegistryName())),
                BYGItems.WATER_SILK = (new BYGWaterSilkItem(BYGBlocks.WATER_SILK, (new Item.Properties()).group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WATER_SILK.getRegistryName())),
                BYGItems.WINTER_SUCCULENT = new BlockItem(BYGBlocks.WINTER_SUCCULENT, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WINTER_SUCCULENT.getRegistryName()),


                BYGItems.WINTER_GRASS = new BlockItem(BYGBlocks.WINTER_GRASS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WINTER_GRASS.getRegistryName()),
                BYGItems.WEED_GRASS = new BlockItem(BYGBlocks.WEED_GRASS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WEED_GRASS.getRegistryName()),
                BYGItems.WILTED_GRASS = new BlockItem(BYGBlocks.WILTED_GRASS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WILTED_GRASS.getRegistryName()),
                BYGItems.SHORT_BEACH_GRASS = new BlockItem(BYGBlocks.SHORT_BEACH_GRASS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SHORT_BEACH_GRASS.getRegistryName()),
                BYGItems.BEACH_GRASS = new BlockItem(BYGBlocks.BEACH_GRASS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BEACH_GRASS.getRegistryName()),
                BYGItems.LEAF_PILE = new BlockItem(BYGBlocks.LEAF_PILE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.LEAF_PILE.getRegistryName()),
                BYGItems.CLOVER_PATCH = new BlockItem(BYGBlocks.CLOVER_PATCH, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CLOVER_PATCH.getRegistryName()),
                BYGItems.FLOWER_PATCH = new BlockItem(BYGBlocks.FLOWER_PATCH, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.FLOWER_PATCH.getRegistryName()),


                //Petal Blocks
                BYGItems.WHITE_PETAL = new BlockItem(BYGBlocks.WHITE_PETAL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WHITE_PETAL.getRegistryName()),
                BYGItems.BLUE_PETAL = new BlockItem(BYGBlocks.BLUE_PETAL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_PETAL.getRegistryName()),
                BYGItems.LIGHT_BLUE_PETAL = new BlockItem(BYGBlocks.LIGHT_BLUE_PETAL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.LIGHT_BLUE_PETAL.getRegistryName()),
                BYGItems.PURPLE_PETAL = new BlockItem(BYGBlocks.PURPLE_PETAL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PURPLE_PETAL.getRegistryName()),
                BYGItems.RED_PETAL = new BlockItem(BYGBlocks.RED_PETAL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RED_PETAL.getRegistryName()),
                BYGItems.YELLOW_PETAL = new BlockItem(BYGBlocks.YELLOW_PETAL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.YELLOW_PETAL.getRegistryName()),
                BYGItems.PLANT_STEM = new BlockItem(BYGBlocks.PLANT_STEM, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PLANT_STEM.getRegistryName()),
                BYGItems.POLLEN_BLOCK = new BlockItem(BYGBlocks.POLLEN_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.POLLEN_BLOCK.getRegistryName()),
                BYGItems.POLLEN_DUST = new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName("pollen_dust"),

                //FlowerItems
                BYGItems.ALLIUM_FLOWER_BUSH = new BlockItem(BYGBlocks.ALLIUM_FLOWER_BUSH, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ALLIUM_FLOWER_BUSH.getRegistryName()),
                BYGItems.TALL_ALLIUM = new BlockItem(BYGBlocks.TALL_ALLIUM, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.TALL_ALLIUM.getRegistryName()),
                BYGItems.ALPINE_BELLFLOWER = new BlockItem(BYGBlocks.ALPINE_BELLFLOWER, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ALPINE_BELLFLOWER.getRegistryName()),
                BYGItems.AMARANTH = new BlockItem(BYGBlocks.AMARANTH, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.AMARANTH.getRegistryName()),
                BYGItems.ANGELICA = new BlockItem(BYGBlocks.ANGELICA, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ANGELICA.getRegistryName()),
                BYGItems.AZALEA = new BlockItem(BYGBlocks.AZALEA, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.AZALEA.getRegistryName()),
                BYGItems.BEGONIA = new BlockItem(BYGBlocks.BEGONIA, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BEGONIA.getRegistryName()),
                BYGItems.BISTORT = new BlockItem(BYGBlocks.BISTORT, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BISTORT.getRegistryName()),
                BYGItems.BLACK_ROSE = new BlockItem(BYGBlocks.BLACK_ROSE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLACK_ROSE.getRegistryName()),
                BYGItems.BLUE_SAGE = new BlockItem(BYGBlocks.BLUE_SAGE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.BLUE_SAGE.getRegistryName()),
                BYGItems.CALIFORNIA_POPPY = new BlockItem(BYGBlocks.CALIFORNIA_POPPY, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CALIFORNIA_POPPY.getRegistryName()),
                BYGItems.CROCUS = new BlockItem(BYGBlocks.CROCUS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CROCUS.getRegistryName()),
                BYGItems.CYAN_AMARANTH = new BlockItem(BYGBlocks.CYAN_AMARANTH, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CYAN_AMARANTH.getRegistryName()),
                BYGItems.CYAN_ROSE = new BlockItem(BYGBlocks.CYAN_ROSE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CYAN_ROSE.getRegistryName()),
                BYGItems.CYAN_TULIP = new BlockItem(BYGBlocks.CYAN_TULIP, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.CYAN_TULIP.getRegistryName()),
                BYGItems.DAFFODIL = new BlockItem(BYGBlocks.DAFFODIL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.DAFFODIL.getRegistryName()),
                BYGItems.DELPHINIUM = new BlockItem(BYGBlocks.DELPHINIUM, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.DELPHINIUM.getRegistryName()),
                BYGItems.FAIRY_SLIPPER = new BlockItem(BYGBlocks.FAIRY_SLIPPER, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.FAIRY_SLIPPER.getRegistryName()),
                BYGItems.FIRECRACKER_FLOWER_BUSH = new BlockItem(BYGBlocks.FIRECRACKER_FLOWER_BUSH, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.FIRECRACKER_FLOWER_BUSH.getRegistryName()),
                BYGItems.FOXGLOVE = new BlockItem(BYGBlocks.FOXGLOVE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.FOXGLOVE.getRegistryName()),
                BYGItems.GREEN_TULIP = new BlockItem(BYGBlocks.GREEN_TULIP, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.GREEN_TULIP.getRegistryName()),
                BYGItems.GUZMANIA = new BlockItem(BYGBlocks.GUZMANIA, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.GUZMANIA.getRegistryName()),
                BYGItems.INCAN_LILY = new BlockItem(BYGBlocks.INCAN_LILY, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.INCAN_LILY.getRegistryName()),
                BYGItems.IRIS = new BlockItem(BYGBlocks.IRIS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.IRIS.getRegistryName()),
                BYGItems.JAPANESE_ORCHID = new BlockItem(BYGBlocks.JAPANESE_ORCHID, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.JAPANESE_ORCHID.getRegistryName()),
                BYGItems.KOVAN_FLOWER = new BlockItem(BYGBlocks.KOVAN_FLOWER, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.KOVAN_FLOWER.getRegistryName()),
                BYGItems.LAZARUS_BELLFLOWER = new BlockItem(BYGBlocks.LAZARUS_BELLFLOWER, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.LAZARUS_BELLFLOWER.getRegistryName()),
                BYGItems.LOLIPOP_FLOWER = new BlockItem(BYGBlocks.LOLIPOP_FLOWER, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.LOLIPOP_FLOWER.getRegistryName()),
                BYGItems.MAGENTA_AMARANTH = new BlockItem(BYGBlocks.MAGENTA_AMARANTH, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAGENTA_AMARANTH.getRegistryName()),
                BYGItems.MAGENTA_TULIP = new BlockItem(BYGBlocks.MAGENTA_TULIP, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.MAGENTA_TULIP.getRegistryName()),
                BYGItems.ORANGE_AMARANTH = new BlockItem(BYGBlocks.ORANGE_AMARANTH, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ORANGE_AMARANTH.getRegistryName()),
                BYGItems.ORANGE_DAISY = new BlockItem(BYGBlocks.ORANGE_DAISY, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ORANGE_DAISY.getRegistryName()),
                BYGItems.ORSIRIA_ROSE = new BlockItem(BYGBlocks.ORSIRIA_ROSE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ORSIRIA_ROSE.getRegistryName()),
                BYGItems.PEACH_LEATHER_FLOWER = new BlockItem(BYGBlocks.PEACH_LEATHER_FLOWER, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PEACH_LEATHER_FLOWER.getRegistryName()),
                BYGItems.PINK_ALLIUM = new BlockItem(BYGBlocks.PINK_ALLIUM, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINK_ALLIUM.getRegistryName()),
                BYGItems.PINK_ALLIUM_FLOWER_BUSH = new BlockItem(BYGBlocks.PINK_ALLIUM_FLOWER_BUSH, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINK_ALLIUM_FLOWER_BUSH.getRegistryName()),
                BYGItems.TALL_PINK_ALLIUM = new BlockItem(BYGBlocks.TALL_PINK_ALLIUM, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.TALL_PINK_ALLIUM.getRegistryName()),
                BYGItems.PINK_ANEMONE = new BlockItem(BYGBlocks.PINK_ANEMONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINK_ANEMONE.getRegistryName()),
                BYGItems.PINK_DAFFODIL = new BlockItem(BYGBlocks.PINK_DAFFODIL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINK_DAFFODIL.getRegistryName()),
                BYGItems.PINK_ORCHID = new BlockItem(BYGBlocks.PINK_ORCHID, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PINK_ORCHID.getRegistryName()),
                BYGItems.PROTEA_FLOWER = new BlockItem(BYGBlocks.PROTEA_FLOWER, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PROTEA_FLOWER.getRegistryName()),
                BYGItems.PURPLE_AMARANTH = new BlockItem(BYGBlocks.PURPLE_AMARANTH, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PURPLE_AMARANTH.getRegistryName()),
                BYGItems.PURPLE_ORCHID = new BlockItem(BYGBlocks.PURPLE_ORCHID, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PURPLE_ORCHID.getRegistryName()),
                BYGItems.PURPLE_SAGE = new BlockItem(BYGBlocks.PURPLE_SAGE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PURPLE_SAGE.getRegistryName()),
                BYGItems.PURPLE_TULIP = new BlockItem(BYGBlocks.PURPLE_TULIP, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.PURPLE_TULIP.getRegistryName()),
                BYGItems.RED_CORNFLOWER = new BlockItem(BYGBlocks.RED_CORNFLOWER, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RED_CORNFLOWER.getRegistryName()),
                BYGItems.RED_ORCHID = new BlockItem(BYGBlocks.RED_ORCHID, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RED_ORCHID.getRegistryName()),
                BYGItems.RICHEA = new BlockItem(BYGBlocks.RICHEA, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.RICHEA.getRegistryName()),
                BYGItems.ROSE = new BlockItem(BYGBlocks.ROSE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.ROSE.getRegistryName()),
                BYGItems.SILVER_VASE_FLOWER = new BlockItem(BYGBlocks.SILVER_VASE_FLOWER, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SILVER_VASE_FLOWER.getRegistryName()),
                BYGItems.SNOWDROPS = new BlockItem(BYGBlocks.SNOWDROPS, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.SNOWDROPS.getRegistryName()),
                BYGItems.TORCH_GINGER = new BlockItem(BYGBlocks.TORCH_GINGER, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.TORCH_GINGER.getRegistryName()),
                BYGItems.VIOLET_LEATHER_FLOWER = new BlockItem(BYGBlocks.VIOLET_LEATHER_FLOWER, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.VIOLET_LEATHER_FLOWER.getRegistryName()),
                BYGItems.WHITE_ANEMONE = new BlockItem(BYGBlocks.WHITE_ANEMONE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WHITE_ANEMONE.getRegistryName()),
                BYGItems.WHITE_SAGE = new BlockItem(BYGBlocks.WHITE_SAGE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WHITE_SAGE.getRegistryName()),
                BYGItems.WINTER_CYCLAMEN = new BlockItem(BYGBlocks.WINTER_CYCLAMEN, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WINTER_CYCLAMEN.getRegistryName()),
                BYGItems.WINTER_ROSE = new BlockItem(BYGBlocks.WINTER_ROSE, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WINTER_ROSE.getRegistryName()),
                BYGItems.WINTER_SCILLA = new BlockItem(BYGBlocks.WINTER_SCILLA, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.WINTER_SCILLA.getRegistryName()),
                BYGItems.YELLOW_DAFFODIL = new BlockItem(BYGBlocks.YELLOW_DAFFODIL, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.YELLOW_DAFFODIL.getRegistryName()),
                BYGItems.YELLOW_TULIP = new BlockItem(BYGBlocks.YELLOW_TULIP, new Item.Properties().group(BYGCreativeTab.creativeTab)).setRegistryName(BYGBlocks.YELLOW_TULIP.getRegistryName())
        );
    }
}
