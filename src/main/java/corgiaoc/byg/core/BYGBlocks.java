package corgiaoc.byg.core;

import corgiaoc.byg.BYG;
import corgiaoc.byg.common.properties.BYGBlockProperties;
import corgiaoc.byg.common.properties.blocks.BYGMushroomBlock;
import corgiaoc.byg.common.properties.blocks.BYGSaplingProperties;
import corgiaoc.byg.common.world.feature.features.overworld.mushrooms.util.BYGMushroomToHugeMushroom;
import corgiaoc.byg.common.world.feature.features.overworld.trees.BYGSaplingToTree;
import net.minecraft.block.Block;
import net.minecraftforge.registries.IForgeRegistry;

public class BYGBlocks {

    //Sonoran Cactus
    public static Block SONORAN_CACTUS;

    //FenceBlocks
    public static Block ASPEN_FENCE;
    public static Block BAOBAB_FENCE;
    public static Block BLUE_ENCHANTED_FENCE;
    public static Block CHERRY_FENCE;
    public static Block CIKA_FENCE;
    public static Block CYPRESS_FENCE;
    public static Block EBONY_FENCE;
    public static Block FIR_FENCE;
    public static Block GREEN_ENCHANTED_FENCE;
    public static Block HOLLY_FENCE;
    public static Block JACARANDA_FENCE;
    public static Block MAHOGANY_FENCE;
    public static Block MANGROVE_FENCE;
    public static Block MAPLE_FENCE;
    public static Block PINE_FENCE;
    public static Block RAINBOW_EUCALYPTUS_FENCE;
    public static Block REDWOOD_FENCE;
    public static Block SKYRIS_FENCE;
    public static Block WILLOW_FENCE;
    public static Block WITCH_HAZEL_FENCE;
    public static Block ZELKOVA_FENCE;
    public static Block SYTHIAN_FENCE;
    public static Block EMBUR_FENCE;
    public static Block PALM_FENCE;
    public static Block LAMENT_FENCE;
    //TrapdoorBlocks
    public static Block ASPEN_TRAPDOOR;
    public static Block BAOBAB_TRAPDOOR;
    public static Block BLUE_ENCHANTED_TRAPDOOR;
    public static Block CHERRY_TRAPDOOR;
    public static Block CIKA_TRAPDOOR;
    public static Block CYPRESS_TRAPDOOR;
    public static Block EBONY_TRAPDOOR;
    public static Block FIR_TRAPDOOR;
    public static Block GREEN_ENCHANTED_TRAPDOOR;
    public static Block HOLLY_TRAPDOOR;
    public static Block JACARANDA_TRAPDOOR;
    public static Block MAHOGANY_TRAPDOOR;
    public static Block MANGROVE_TRAPDOOR;
    public static Block MAPLE_TRAPDOOR;
    public static Block PINE_TRAPDOOR;
    public static Block RAINBOW_EUCALYPTUS_TRAPDOOR;
    public static Block REDWOOD_TRAPDOOR;
    public static Block SKYRIS_TRAPDOOR;
    public static Block WILLOW_TRAPDOOR;
    public static Block WITCH_HAZEL_TRAPDOOR;
    public static Block ZELKOVA_TRAPDOOR;
    public static Block SYTHIAN_TRAPDOOR;
    public static Block EMBUR_TRAPDOOR;
    public static Block PALM_TRAPDOOR;
    public static Block LAMENT_TRAPDOOR;

    //PressurePlates
    public static Block ASPEN_PRESSURE_PLATE;
    public static Block BAOBAB_PRESSURE_PLATE;
    public static Block BLUE_ENCHANTED_PRESSURE_PLATE;
    public static Block CHERRY_PRESSURE_PLATE;
    public static Block CIKA_PRESSURE_PLATE;
    public static Block CYPRESS_PRESSURE_PLATE;
    public static Block EBONY_PRESSURE_PLATE;
    public static Block FIR_PRESSURE_PLATE;
    public static Block GREEN_ENCHANTED_PRESSURE_PLATE;
    public static Block HOLLY_PRESSURE_PLATE;
    public static Block JACARANDA_PRESSURE_PLATE;
    public static Block MAHOGANY_PRESSURE_PLATE;
    public static Block MANGROVE_PRESSURE_PLATE;
    public static Block MAPLE_PRESSURE_PLATE;
    public static Block PINE_PRESSURE_PLATE;
    public static Block RAINBOW_EUCALYPTUS_PRESSURE_PLATE;
    public static Block REDWOOD_PRESSURE_PLATE;
    public static Block SKYRIS_PRESSURE_PLATE;
    public static Block WILLOW_PRESSURE_PLATE;
    public static Block WITCH_HAZEL_PRESSURE_PLATE;
    public static Block ZELKOVA_PRESSURE_PLATE;
    public static Block SYTHIAN_PRESSURE_PLATE;
    public static Block EMBUR_PRESSURE_PLATE;
    public static Block PALM_PRESSURE_PLATE;
    public static Block LAMENT_PRESSURE_PLATE;

    //Buttons
    public static Block ASPEN_BUTTON;
    public static Block BAOBAB_BUTTON;
    public static Block BLUE_ENCHANTED_BUTTON;
    public static Block CHERRY_BUTTON;
    public static Block CIKA_BUTTON;
    public static Block CYPRESS_BUTTON;
    public static Block EBONY_BUTTON;
    public static Block FIR_BUTTON;
    public static Block GREEN_ENCHANTED_BUTTON;
    public static Block HOLLY_BUTTON;
    public static Block JACARANDA_BUTTON;
    public static Block MAHOGANY_BUTTON;
    public static Block MANGROVE_BUTTON;
    public static Block MAPLE_BUTTON;
    public static Block PINE_BUTTON;
    public static Block RAINBOW_EUCALYPTUS_BUTTON;
    public static Block REDWOOD_BUTTON;
    public static Block SKYRIS_BUTTON;
    public static Block WILLOW_BUTTON;
    public static Block WITCH_HAZEL_BUTTON;
    public static Block ZELKOVA_BUTTON;
    public static Block SYTHIAN_BUTTON;
    public static Block EMBUR_BUTTON;
    public static Block PALM_BUTTON;
    public static Block LAMENT_BUTTON;

    //DoorBlocks
    public static Block ASPEN_DOOR;
    public static Block BAOBAB_DOOR;
    public static Block BLUE_ENCHANTED_DOOR;
    public static Block CHERRY_DOOR;
    public static Block CIKA_DOOR;
    public static Block CYPRESS_DOOR;
    public static Block EBONY_DOOR;
    public static Block FIR_DOOR;
    public static Block GREEN_ENCHANTED_DOOR;
    public static Block HOLLY_DOOR;
    public static Block JACARANDA_DOOR;
    public static Block MAHOGANY_DOOR;
    public static Block MANGROVE_DOOR;
    public static Block MAPLE_DOOR;
    public static Block PINE_DOOR;
    public static Block RAINBOW_EUCALYPTUS_DOOR;
    public static Block REDWOOD_DOOR;
    public static Block SKYRIS_DOOR;
    public static Block WILLOW_DOOR;
    public static Block WITCH_HAZEL_DOOR;
    public static Block ZELKOVA_DOOR;
    public static Block SYTHIAN_DOOR;
    public static Block EMBUR_DOOR;
    public static Block PALM_DOOR;
    public static Block LAMENT_DOOR;

    //Fence Gates
    public static Block ASPEN_FENCE_GATE;
    public static Block BAOBAB_FENCE_GATE;
    public static Block BLUE_ENCHANTED_FENCE_GATE;
    public static Block CHERRY_FENCE_GATE;
    public static Block CIKA_FENCE_GATE;
    public static Block CYPRESS_FENCE_GATE;
    public static Block EBONY_FENCE_GATE;
    public static Block FIR_FENCE_GATE;
    public static Block GREEN_ENCHANTED_FENCE_GATE;
    public static Block HOLLY_FENCE_GATE;
    public static Block JACARANDA_FENCE_GATE;
    public static Block MAHOGANY_FENCE_GATE;
    public static Block MANGROVE_FENCE_GATE;
    public static Block MAPLE_FENCE_GATE;
    public static Block PINE_FENCE_GATE;
    public static Block RAINBOW_EUCALYPTUS_FENCE_GATE;
    public static Block REDWOOD_FENCE_GATE;
    public static Block SKYRIS_FENCE_GATE;
    public static Block WILLOW_FENCE_GATE;
    public static Block WITCH_HAZEL_FENCE_GATE;
    public static Block ZELKOVA_FENCE_GATE;
    public static Block SYTHIAN_FENCE_GATE;
    public static Block EMBUR_FENCE_GATE;
    public static Block PALM_FENCE_GATE;
    public static Block LAMENT_FENCE_GATE;

    //Crafting Tables
    public static Block ASPEN_CRAFTING_TABLE;
    public static Block BAOBAB_CRAFTING_TABLE;
    public static Block BLUE_ENCHANTED_CRAFTING_TABLE;
    public static Block CHERRY_CRAFTING_TABLE;
    public static Block CIKA_CRAFTING_TABLE;
    public static Block CYPRESS_CRAFTING_TABLE;
    public static Block EBONY_CRAFTING_TABLE;
    public static Block FIR_CRAFTING_TABLE;
    public static Block GREEN_ENCHANTED_CRAFTING_TABLE;
    public static Block HOLLY_CRAFTING_TABLE;
    public static Block JACARANDA_CRAFTING_TABLE;
    public static Block MAHOGANY_CRAFTING_TABLE;
    public static Block MANGROVE_CRAFTING_TABLE;
    public static Block MAPLE_CRAFTING_TABLE;
    public static Block PINE_CRAFTING_TABLE;
    public static Block RAINBOW_EUCALYPTUS_CRAFTING_TABLE;
    public static Block REDWOOD_CRAFTING_TABLE;
    public static Block SKYRIS_CRAFTING_TABLE;
    public static Block WILLOW_CRAFTING_TABLE;
    public static Block WITCH_HAZEL_CRAFTING_TABLE;
    public static Block ZELKOVA_CRAFTING_TABLE;
    public static Block SYTHIAN_CRAFTING_TABLE;
    public static Block EMBUR_CRAFTING_TABLE;
    public static Block PALM_CRAFTING_TABLE;
    public static Block LAMENT_CRAFTING_TABLE;

    //FlowerBlocks
    public static Block ALPINE_BELLFLOWER;
    public static Block TALL_ALLIUM;
    public static Block ALLIUM_FLOWER_BUSH;
    public static Block PINK_ALLIUM_FLOWER_BUSH;
    public static Block TALL_PINK_ALLIUM;
    public static Block ANGELICA;
    public static Block AZALEA;
    public static Block BEGONIA;
    public static Block BISTORT;
    public static Block BLACK_ROSE;
    public static Block BLUE_SAGE;
    public static Block CALIFORNIA_POPPY;
    public static Block CROCUS;
    public static Block CYAN_ROSE;
    public static Block CYAN_TULIP;
    public static Block DAFFODIL;
    public static Block DELPHINIUM;
    public static Block FAIRY_SLIPPER;
    public static Block FIRECRACKER_FLOWER_BUSH;
    public static Block FOXGLOVE;
    public static Block GOLDEN_SPINED_CACTUS;
    public static Block GREEN_TULIP;
    public static Block GUZMANIA;
    public static Block INCAN_LILY;
    public static Block IRIS;
    public static Block JAPANESE_ORCHID;
    public static Block KOVAN_FLOWER;
    public static Block LAZARUS_BELLFLOWER;
    public static Block LOLIPOP_FLOWER;
    public static Block MAGENTA_TULIP;
    public static Block ORANGE_DAISY;
    public static Block ORSIRIA_ROSE;
    public static Block PEACH_LEATHER_FLOWER;
    public static Block PINK_ALLIUM;
    public static Block PINK_ANEMONE;
    public static Block PINK_DAFFODIL;
    public static Block PINK_ORCHID;
    public static Block PROTEA_FLOWER;
    public static Block PURPLE_ORCHID;
    public static Block PURPLE_SAGE;
    public static Block PURPLE_TULIP;
    public static Block RED_CORNFLOWER;
    public static Block RED_ORCHID;
    public static Block RICHEA;
    public static Block ROSE;
    public static Block SILVER_VASE_FLOWER;
    public static Block SNOWDROPS;
    public static Block TORCH_GINGER;
    public static Block VIOLET_LEATHER_FLOWER;
    public static Block WHITE_ANEMONE;
    public static Block WHITE_SAGE;
    public static Block WINTER_CYCLAMEN;
    public static Block WINTER_ROSE;
    public static Block WINTER_SCILLA;
    public static Block YELLOW_DAFFODIL;
    public static Block YELLOW_TULIP;
    public static Block AMARANTH;
    public static Block CYAN_AMARANTH;
    public static Block ORANGE_AMARANTH;
    public static Block MAGENTA_AMARANTH;
    public static Block PURPLE_AMARANTH;

    //Grass Blocks
    public static Block MEADOW_GRASSBLOCK;
    public static Block GLOWCELIUM;

    //Dirt Blocks
    public static Block PEAT;
    public static Block MEADOW_DIRT;
    public static Block MUD_BLOCK;
    public static Block MUD_BRICKS;

    //Sand Blocks
    public static Block BLUE_SAND;
    public static Block BLACK_SAND;
    public static Block WHITE_SAND;
    public static Block PINK_SAND;
    public static Block PURPLE_SAND;
    public static Block CRACKED_SAND;
    public static Block RED_CRACKED_SAND;


    //Sandstone Items
    public static Block BLUE_SANDSTONE;
    public static Block BLUE_CHISELED_SANDSTONE;
    public static Block BLUE_CUT_SANDSTONE;
    public static Block BLUE_SMOOTH_SANDSTONE;

    public static Block BLACK_SANDSTONE;
    public static Block BLACK_CHISELED_SANDSTONE;
    public static Block BLACK_CUT_SANDSTONE;
    public static Block BLACK_SMOOTH_SANDSTONE;

    public static Block WHITE_SANDSTONE;
    public static Block WHITE_CHISELED_SANDSTONE;
    public static Block WHITE_CUT_SANDSTONE;
    public static Block WHITE_SMOOTH_SANDSTONE;

    public static Block PINK_SANDSTONE;
    public static Block PINK_CHISELED_SANDSTONE;
    public static Block PINK_CUT_SANDSTONE;
    public static Block PINK_SMOOTH_SANDSTONE;

    public static Block PURPLE_SANDSTONE;
    public static Block PURPLE_CHISELED_SANDSTONE;
    public static Block PURPLE_CUT_SANDSTONE;
    public static Block PURPLE_SMOOTH_SANDSTONE;


    //LeaveBlocks
    public static Block ARAUCARIA_LEAVES;
    public static Block ASPEN_LEAVES;
    public static Block BAOBAB_LEAVES;
    public static Block BLOOMING_WITCH_HAZEL_LEAVES;
    public static Block BLUE_ENCHANTED_LEAVES;
    public static Block BLUE_SPRUCE_LEAVES;
    public static Block BROWN_BIRCH_LEAVES;
    public static Block BROWN_OAK_LEAVES;
    public static Block BROWN_ZELKOVA_LEAVES;
    public static Block CIKA_LEAVES;
    public static Block CYPRESS_LEAVES;
    public static Block EBONY_LEAVES;
    public static Block FIR_LEAVES;
    public static Block FLOWERING_ORCHARD_LEAVES;
    public static Block FLOWERING_PALO_VERDE_LEAVES;
    public static Block GREEN_ENCHANTED_LEAVES;
    public static Block HOLLY_BERRY_LEAVES;
    public static Block HOLLY_LEAVES;
    public static Block JACARANDA_LEAVES;
    public static Block INDIGO_JACARANDA_LEAVES;
    public static Block JOSHUA_LEAVES;
    public static Block RIPE_JOSHUA_LEAVES;
    public static Block MAHOGANY_LEAVES;
    public static Block MANGROVE_LEAVES;
    public static Block MAPLE_LEAVES;
    public static Block ORANGE_BIRCH_LEAVES;
    public static Block ORANGE_OAK_LEAVES;
    public static Block ORANGE_SPRUCE_LEAVES;
    public static Block ORCHARD_LEAVES;
    public static Block PALO_VERDE_LEAVES;
    public static Block PINE_LEAVES;
    public static Block PINK_CHERRY_LEAVES;
    public static Block RAINBOW_EUCALYPTUS_LEAVES;
    public static Block RED_BIRCH_LEAVES;
    public static Block RED_MAPLE_LEAVES;
    public static Block RED_OAK_LEAVES;
    public static Block RED_SPRUCE_LEAVES;
    public static Block REDWOOD_LEAVES;
    public static Block RIPE_ORCHARD_LEAVES;
    public static Block SILVER_MAPLE_LEAVES;
    public static Block SKYRIS_LEAVES_GREEN_APPLE;
    public static Block SKYRIS_LEAVES;
    public static Block WHITE_CHERRY_LEAVES;
    public static Block WILLOW_LEAVES;
    public static Block WITCH_HAZEL_LEAVES;
    public static Block YELLOW_BIRCH_LEAVES;
    public static Block YELLOW_SPRUCE_LEAVES;
    public static Block ZELKOVA_LEAVES;
    public static Block SYTHIAN_WART_BLOCK;
    public static Block PALM_LEAVES;
    public static Block LAMENT_LEAVES;
    public static Block WITHERING_OAK_LEAVES;

    //LogBlocks
    public static Block ASPEN_LOG;
    public static Block BAOBAB_LOG;
    public static Block BLUE_ENCHANTED_LOG;
    public static Block CHERRY_LOG;
    public static Block CIKA_LOG;
    public static Block CYPRESS_LOG;
    public static Block EBONY_LOG;
    public static Block FIR_LOG;
    public static Block GREEN_ENCHANTED_LOG;
    public static Block HOLLY_LOG;
    public static Block JACARANDA_LOG;
    public static Block MAHOGANY_LOG;
    public static Block MANGROVE_LOG;
    public static Block MAPLE_LOG;
    public static Block PALO_VERDE_LOG;
    public static Block PINE_LOG;
    public static Block RAINBOW_EUCALYPTUS_LOG;
    public static Block REDWOOD_LOG;
    public static Block SKYRIS_LOG;
    public static Block WILLOW_LOG;
    public static Block WITCH_HAZEL_LOG;
    public static Block ZELKOVA_LOG;
    public static Block SYTHIAN_STEM;
    public static Block PALM_LOG;
    public static Block LAMENT_LOG;
    public static Block WITHERING_OAK_LOG;

    //WoodBlocks
    public static Block ASPEN_WOOD;
    public static Block BAOBAB_WOOD;
    public static Block BLUE_ENCHANTED_WOOD;
    public static Block CHERRY_WOOD;
    public static Block CIKA_WOOD;
    public static Block CYPRESS_WOOD;
    public static Block EBONY_WOOD;
    public static Block FIR_WOOD;
    public static Block GREEN_ENCHANTED_WOOD;
    public static Block HOLLY_WOOD;
    public static Block JACARANDA_WOOD;
    public static Block MAHOGANY_WOOD;
    public static Block MANGROVE_WOOD;
    public static Block MAPLE_WOOD;
    public static Block PALO_VERDE_WOOD;
    public static Block PINE_WOOD;
    public static Block RAINBOW_EUCALYPTUS_WOOD;
    public static Block REDWOOD_WOOD;
    public static Block SKYRIS_WOOD;
    public static Block WILLOW_WOOD;
    public static Block WITCH_HAZEL_WOOD;
    public static Block ZELKOVA_WOOD;
    public static Block SYTHIAN_HYPHAE;
    public static Block EMBUR_HYPHAE;
    public static Block PALM_WOOD;
    public static Block LAMENT_WOOD;
    public static Block WITHERING_OAK_WOOD;

    //GlowshroomsBlocks
    public static Block PURPLE_GLOWSHROOM_BLOCK;
    public static Block BLUE_GLOWSHROOM_BLOCK;
    public static Block RED_GLOWSHROOM_STEM;
    public static Block YELLOW_GLOWSHROOM_STEM;

    //MushroomsBlocks
    public static Block DEATH_CAP_MUSHROOM_BLOCK;
    public static Block SOUL_SHROOM_BLOCK;
    public static Block PUFF_MUSHROOM_BLOCK;
    public static Block MILKCAP_MUSHROOM_BLOCK;
    public static Block BLEWIT_MUSHROOM_BLOCK;
    public static Block GREEN_MUSHROOM_BLOCK;
    public static Block WHITE_MUSHROOM_STEM;
    public static Block BROWN_MUSHROOM_STEM;
    public static Block SOUL_SHROOM_STEM;

    //MushroomPlantBlocks
    public static Block SOUL_SHROOM_SPORE;
    public static Block SOUL_SHROOM_SPORE_END;
    public static Block SOUL_SHROOM;
    public static Block DEATH_CAP;
    public static Block BLACK_PUFF;
    public static Block WEEPING_MILKCAP;
    public static Block WOOD_BLEWIT;
    public static Block PURPLE_GLOWSHROOM;
    public static Block BLUE_GLOWSHROOM;
    public static Block GREEN_MUSHROOM;


    //GemBlocks
    public static Block PENDORITE_BLOCK;
    public static Block AMETRINE_BLOCK;
    public static Block ANTHRACITE_BLOCK;

    //OreBlocks
    public static Block PENDORITE_ORE;
    public static Block AMETRINE_ORE;
    public static Block PERVADED_NETHERRACK;
    public static Block ANTHRACITE_ORE;


    //BookshelvesBlocks
    public static Block ASPEN_BOOKSHELF;
    public static Block BAOBAB_BOOKSHELF;
    public static Block BLUE_ENCHANTED_BOOKSHELF;
    public static Block CHERRY_BOOKSHELF;
    public static Block CIKA_BOOKSHELF;
    public static Block CYPRESS_BOOKSHELF;
    public static Block EBONY_BOOKSHELF;
    public static Block FIR_BOOKSHELF;
    public static Block GREEN_ENCHANTED_BOOKSHELF;
    public static Block HOLLY_BOOKSHELF;
    public static Block JACARANDA_BOOKSHELF;
    public static Block MAHOGANY_BOOKSHELF;
    public static Block MANGROVE_BOOKSHELF;
    public static Block MAPLE_BOOKSHELF;
    public static Block PINE_BOOKSHELF;
    public static Block RAINBOW_EUCALYPTUS_BOOKSHELF;
    public static Block REDWOOD_BOOKSHELF;
    public static Block SKYRIS_BOOKSHELF;
    public static Block WILLOW_BOOKSHELF;
    public static Block WITCH_HAZEL_BOOKSHELF;
    public static Block ZELKOVA_BOOKSHELF;
    public static Block SYTHIAN_BOOKSHELF;
    public static Block EMBUR_BOOKSHELF;
    public static Block PALM_BOOKSHELF;
    public static Block LAMENT_BOOKSHELF;
    //PlankBlocks
    public static Block ASPEN_PLANKS;
    public static Block BAOBAB_PLANKS;
    public static Block BLUE_ENCHANTED_PLANKS;
    public static Block CHERRY_PLANKS;
    public static Block CIKA_PLANKS;
    public static Block CYPRESS_PLANKS;
    public static Block EBONY_PLANKS;
    public static Block FIR_PLANKS;
    public static Block GREEN_ENCHANTED_PLANKS;
    public static Block HOLLY_PLANKS;
    public static Block JACARANDA_PLANKS;
    public static Block MAHOGANY_PLANKS;
    public static Block MANGROVE_PLANKS;
    public static Block MAPLE_PLANKS;
    public static Block PINE_PLANKS;
    public static Block RAINBOW_EUCALYPTUS_PLANKS;
    public static Block REDWOOD_PLANKS;
    public static Block SKYRIS_PLANKS;
    public static Block WILLOW_PLANKS;
    public static Block WITCH_HAZEL_PLANKS;
    public static Block ZELKOVA_PLANKS;
    public static Block SYTHIAN_PLANKS;
    public static Block EMBUR_PLANKS;
    public static Block PALM_PLANKS;
    public static Block LAMENT_PLANKS;
    //PetalBlocks
    public static Block WHITE_PETAL;
    public static Block RED_PETAL;
    public static Block YELLOW_PETAL;
    public static Block PURPLE_PETAL;
    public static Block LIGHT_BLUE_PETAL;
    public static Block BLUE_PETAL;
    public static Block PLANT_STEM;
    public static Block POLLEN_BLOCK;

    //PlantBlocks
    public static Block CATTAIL;
    public static Block REEDS;
    public static Block REED_THATCH;
    public static Block REED_THATCH_STAIRS;
    public static Block REED_THATCH_CARPET;
    public static Block REED_THATCH_SLAB;
    public static Block HORSEWEED;
    public static Block MINI_CACTUS;
    public static Block PRICKLY_PEAR_CACTUS;
    public static Block WINTER_SUCCULENT;
    public static Block SHORT_GRASS;
    public static Block TALL_PRAIRIE_GRASS;
    public static Block BLUE_GLOWCANE;
    public static Block RED_GLOWCANE;
    public static Block BLUEBERRY_BUSH;
    public static Block POISON_IVY;
    public static Block PRAIRIE_GRASS;
    public static Block PINK_GLOWCANE;
    public static Block PURPLE_GLOWCANE;
    public static Block SKYRIS_VINE;
    public static Block WEEPING_ROOTS;
    public static Block WEEPING_ROOTS_PLANT;
    public static Block TINY_LILYPADS;
    public static Block WINTER_GRASS;
    public static Block WATER_SILK;

    public static Block BLACK_ICE;
    public static Block PACKED_BLACK_ICE;
    public static Block FROST_MAGMA;
    public static Block SUBZERO_ASH;
    public static Block SUBZERO_ASH_BLOCK;


    public static Block WEED_GRASS;
    public static Block WILTED_GRASS;
    public static Block SHORT_BEACH_GRASS;
    public static Block BEACH_GRASS;
    public static Block LEAF_PILE;
    public static Block CLOVER_PATCH;
    public static Block FLOWER_PATCH;

    public static Block BRIMSTONE;
    public static Block YELLOW_NETHER_BRICKS;
    public static Block BORIC_CAMPFIRE;
    public static Block BORIC_FIRE;
    public static Block HANGING_BONE;
    public static Block QUARTZ_CRYSTAL;
    public static Block QUARTZITE_SAND;
    public static Block RAW_QUARTZ_BLOCK;

    public static Block WITHERED_ROSE_BUSH;
    public static Block LAMENT_VINE;
    public static Block LAMENT_VINE_PLANT;
    public static Block LAMENT_SPROUTS;

    public static Block WAILING_VINES;
    public static Block WHALING_GRASS;
    public static Block MAGMATIC_STONE;
    public static Block SCORCHED_BUSH;
    public static Block SCORCHED_GRASS;

    public static Block MYCELIUM_NETHERRACK;
    public static Block OVERGROWN_NETHERRACK;
    public static Block NETHER_BRISTLE;
    public static Block MOSSY_NETHERRACK;

    public static Block OVERGROWN_CRIMSON_BLACKSTONE;
    public static Block TALL_CRIMSON_ROOTS;
    public static Block CRIMSON_BERRY_BUSH;

    public static Block WARPED_CACTUS;
    public static Block WARPED_BUSH;
    public static Block WARPED_CORAL_BLOCK;
    public static Block WARPED_CORAL;
    public static Block WARPED_CORAL_FAN;
    public static Block WARPED_CORAL_WALL_FAN;
    public static Block NYLIUM_SOUL_SAND;
    public static Block NYLIUM_SOUL_SOIL;

    public static Block EMBUR_NYLIUM;
    public static Block EMBUR_PEDU;
    public static Block EMBUR_SPROUTS;
    public static Block EMBUR_ROOTS;
    public static Block TALL_EMBUR_ROOTS;
    public static Block EMBUR_WART;
    public static Block EMBUR_GEL_BLOCK;
    public static Block EMBUR_GEL_VINES;
    public static Block EMBUR_LILY;

    public static Block BLUE_NETHERRACK;
    public static Block BLUE_NETHERRACK_BRICKS;

    public static Block SYTHIAN_SPROUT;
    public static Block SYTHIAN_ROOTS;
    public static Block SYTHIAN_STALK_BLOCK;
    public static Block SYTHIAN_SCAFFOLDING;
    public static Block SYTHIAN_SAPLING;
    public static Block SYTHIAN_NYLIUM;
    public static Block SYTHIAN_FUNGUS;
    public static Block HANGING_SYTHIAN_ROOTS;
    public static Block HANGING_SYTHIAN_ROOTS_PLANT;

    public static Block IVIS_PHYLIUM;
    public static Block IVIS_ROOTS;
    public static Block IVIS_SPROUT;


    //Glowcane BLocks

    public static Block BLUE_GLOWCANE_BLOCK;
    public static Block RED_GLOWCANE_BLOCK;
    public static Block PINK_GLOWCANE_BLOCK;
    public static Block PURPLE_GLOWCANE_BLOCK;

    //Decorations
    public static Block GLOWSTONE_LAMP;
    public static Block GLOWSTONE_LANTERN;
    public static Block PINK_CHERRY_FOLIAGE;
    public static Block WHITE_CHERRY_FOLIAGE;

    //SaplingBlocks
    public static Block ARAUCARIA_SAPLING;
    public static Block ASPEN_SAPLING;
    public static Block BAOBAB_SAPLING;
    public static Block BLUE_ENCHANTED_SAPLING;
    public static Block BLUE_SPRUCE_SAPLING;
    public static Block BROWN_BIRCH_SAPLING;
    public static Block BROWN_OAK_SAPLING;
    public static Block BROWN_ZELKOVA_SAPLING;
    public static Block CIKA_SAPLING;
    public static Block CYPRESS_SAPLING;
    public static Block EBONY_SAPLING;
    public static Block FIR_SAPLING;
    public static Block GREEN_ENCHANTED_SAPLING;
    public static Block HOLLY_SAPLING;
    public static Block JACARANDA_SAPLING;
    public static Block INDIGO_JACARANDA_SAPLING;
    public static Block JOSHUA_SAPLING;
    public static Block MAHOGANY_SAPLING;
    public static Block MANGROVE_SAPLING;
    public static Block MAPLE_SAPLING;
    public static Block ORANGE_BIRCH_SAPLING;
    public static Block ORANGE_OAK_SAPLING;
    public static Block ORANGE_SPRUCE_SAPLING;
    public static Block ORCHARD_SAPLING;
    public static Block PALO_VERDE_SAPLING;
    public static Block PINE_SAPLING;
    public static Block PINK_CHERRY_SAPLING;
    public static Block RAINBOW_EUCALYPTUS_SAPLING;
    public static Block RED_BIRCH_SAPLING;
    public static Block RED_MAPLE_SAPLING;
    public static Block RED_OAK_SAPLING;
    public static Block RED_SPRUCE_SAPLING;
    public static Block REDWOOD_SAPLING;
    public static Block SILVER_MAPLE_SAPLING;
    public static Block SKYRIS_SAPLING;
    public static Block WHITE_CHERRY_SAPLING;
    public static Block WILLOW_SAPLING;
    public static Block WITCH_HAZEL_SAPLING;
    public static Block YELLOW_BIRCH_SAPLING;
    public static Block YELLOW_SPRUCE_SAPLING;
    public static Block ZELKOVA_SAPLING;
    public static Block PALM_SAPLING;
    public static Block LAMENT_SAPLING;
    public static Block WITHERING_OAK_SAPLING;

    //SlabBlocks
    public static Block ASPEN_SLAB;
    public static Block BAOBAB_SLAB;
    public static Block BLUE_ENCHANTED_SLAB;
    public static Block CHERRY_SLAB;
    public static Block CIKA_SLAB;
    public static Block CYPRESS_SLAB;
    public static Block EBONY_SLAB;
    public static Block FIR_SLAB;
    public static Block GREEN_ENCHANTED_SLAB;
    public static Block HOLLY_SLAB;
    public static Block JACARANDA_SLAB;
    public static Block MAHOGANY_SLAB;
    public static Block MANGROVE_SLAB;
    public static Block MAPLE_SLAB;
    public static Block PINE_SLAB;
    public static Block RAINBOW_EUCALYPTUS_SLAB;
    public static Block REDWOOD_SLAB;
    public static Block SKYRIS_SLAB;
    public static Block WILLOW_SLAB;
    public static Block WITCH_HAZEL_SLAB;
    public static Block ZELKOVA_SLAB;
    public static Block SYTHIAN_SLAB;
    public static Block EMBUR_SLAB;
    public static Block PALM_SLAB;
    public static Block LAMENT_SLAB;
    //StairBlocks
    public static Block ASPEN_STAIRS;
    public static Block BAOBAB_STAIRS;
    public static Block BLUE_ENCHANTED_STAIRS;
    public static Block CHERRY_STAIRS;
    public static Block CIKA_STAIRS;
    public static Block CYPRESS_STAIRS;
    public static Block EBONY_STAIRS;
    public static Block FIR_STAIRS;
    public static Block GREEN_ENCHANTED_STAIRS;
    public static Block HOLLY_STAIRS;
    public static Block JACARANDA_STAIRS;
    public static Block MAHOGANY_STAIRS;
    public static Block MANGROVE_STAIRS;
    public static Block MAPLE_STAIRS;
    public static Block PINE_STAIRS;
    public static Block RAINBOW_EUCALYPTUS_STAIRS;
    public static Block REDWOOD_STAIRS;
    public static Block SKYRIS_STAIRS;
    public static Block WILLOW_STAIRS;
    public static Block WITCH_HAZEL_STAIRS;
    public static Block ZELKOVA_STAIRS;
    public static Block SYTHIAN_STAIRS;
    public static Block EMBUR_STAIRS;
    public static Block PALM_STAIRS;
    public static Block LAMENT_STAIRS;

    //StoneBlocks
    public static Block DACITE;
    public static Block DACITE_SLAB;
    public static Block DACITE_STAIRS;
    public static Block DACITE_WALL;
    public static Block DACITE_COBBLESTONE;
    public static Block DACITE_COBBLESTONE_SLAB;
    public static Block DACITE_COBBLESTONE_STAIRS;
    public static Block DACITE_COBBLESTONE_WALL;
    public static Block DACITE_PILLAR;
    public static Block DACITE_TILE;
    public static Block DACITE_TILE_SLAB;
    public static Block DACITE_TILE_STAIRS;
    public static Block DACITE_TILE_WALL;
    public static Block DACITE_BRICKS;
    public static Block DACITE_BRICK_SLAB;
    public static Block DACITE_BRICK_STAIRS;
    public static Block DACITE_BRICK_WALL;

    public static Block RED_ROCK;
    public static Block RED_ROCK_SLAB;
    public static Block RED_ROCK_STAIRS;
    public static Block RED_ROCK_WALL;
    public static Block RED_ROCK_BRICKS;
    public static Block RED_ROCK_BRICK_SLAB;
    public static Block RED_ROCK_BRICK_STAIRS;
    public static Block RED_ROCK_BRICK_WALL;
    public static Block CRACKED_RED_ROCK_BRICKS;
    public static Block CRACKED_RED_ROCK_BRICK_SLAB;
    public static Block CRACKED_RED_ROCK_BRICK_STAIRS;
    public static Block CRACKED_RED_ROCK_BRICK_WALL;
    public static Block CHISELED_RED_ROCK_BRICKS;
    public static Block CHISELED_RED_ROCK_BRICK_SLAB;
    public static Block CHISELED_RED_ROCK_BRICK_STAIRS;
    public static Block CHISELED_RED_ROCK_BRICK_WALL;
    public static Block MOSSY_RED_ROCK_BRICKS;
    public static Block MOSSY_RED_ROCK_BRICK_SLAB;
    public static Block MOSSY_RED_ROCK_BRICK_STAIRS;
    public static Block MOSSY_RED_ROCK_BRICK_WALL;

    public static Block SOAPSTONE;
    public static Block SOAPSTONE_SLAB;
    public static Block SOAPSTONE_STAIRS;
    public static Block SOAPSTONE_WALL;
    public static Block POLISHED_SOAPSTONE;
    public static Block POLISHED_SOAPSTONE_SLAB;
    public static Block POLISHED_SOAPSTONE_STAIRS;
    public static Block POLISHED_SOAPSTONE_WALL;
    public static Block SOAPSTONE_PILLAR;
    public static Block SOAPSTONE_TILE;
    public static Block SOAPSTONE_TILE_SLAB;
    public static Block SOAPSTONE_TILE_STAIRS;
    public static Block SOAPSTONE_TILE_WALL;
    public static Block SOAPSTONE_BRICKS;
    public static Block SOAPSTONE_BRICK_SLAB;
    public static Block SOAPSTONE_BRICK_STAIRS;
    public static Block SOAPSTONE_BRICK_WALL;

    public static Block SCORIA_STONE;
    public static Block SCORIA_SLAB;
    public static Block SCORIA_STAIRS;
    public static Block SCORIA_WALL;
    public static Block SCORIA_COBBLESTONE;
    public static Block SCORIA_COBBLESTONE_SLAB;
    public static Block SCORIA_COBBLESTONE_STAIRS;
    public static Block SCORIA_COBBLESTONE_WALL;
    public static Block SCORIA_PILLAR;
    public static Block SCORIA_STONEBRICKS;
    public static Block SCORIA_STONEBRICK_SLAB;
    public static Block SCORIA_STONEBRICK_STAIRS;
    public static Block SCORIA_STONEBRICK_WALL;

    public static Block MOSSY_STONE;
    public static Block MOSSY_STONE_SLAB;
    public static Block MOSSY_STONE_STAIRS;
    public static Block MOSSY_STONE_WALL;
    public static Block ROCKY_STONE;
    public static Block ROCKY_SLAB;
    public static Block ROCKY_STAIRS;
    public static Block ROCKY_WALL;
    public static Block OVERGROWN_STONE;
    public static Block STONE_FARMLAND;
    public static Block OVERGROWN_DACITE;
    public static Block DACITE_FARMLAND;
    public static Block PODZOL_DACITE;

    //StrippedLogBlocks
    public static Block STRIPPED_BAOBAB_LOG;
    public static Block STRIPPED_ASPEN_LOG;
    public static Block STRIPPED_BLUE_ENCHANTED_LOG;
    public static Block STRIPPED_CHERRY_LOG;
    public static Block STRIPPED_CIKA_LOG;
    public static Block STRIPPED_CYPRESS_LOG;
    public static Block STRIPPED_EBONY_LOG;
    public static Block STRIPPED_FIR_LOG;
    public static Block STRIPPED_GREEN_ENCHANTED_LOG;
    public static Block STRIPPED_HOLLY_LOG;
    public static Block STRIPPED_JACARANDA_LOG;
    public static Block STRIPPED_MAHOGANY_LOG;
    public static Block STRIPPED_MANGROVE_LOG;
    public static Block STRIPPED_MAPLE_LOG;
    public static Block STRIPPED_PALO_VERDE_LOG;
    public static Block STRIPPED_PINE_LOG;
    public static Block STRIPPED_RAINBOW_EUCALYPTUS_LOG;
    public static Block STRIPPED_SKYRIS_LOG;
    public static Block STRIPPED_WILLOW_LOG;
    public static Block STRIPPED_REDWOOD_LOG;
    public static Block STRIPPED_WITCH_HAZEL_LOG;
    public static Block STRIPPED_ZELKOVA_LOG;
    public static Block STRIPPED_SYTHIAN_STEM;
    public static Block STRIPPED_EMBUR_PEDU;
    public static Block STRIPPED_PALM_LOG;
    public static Block STRIPPED_LAMENT_LOG;

    //StrippedWoodBlocks
    public static Block STRIPPED_BAOBAB_WOOD;
    public static Block STRIPPED_ASPEN_WOOD;
    public static Block STRIPPED_BLUE_ENCHANTED_WOOD;
    public static Block STRIPPED_CHERRY_WOOD;
    public static Block STRIPPED_CIKA_WOOD;
    public static Block STRIPPED_CYPRESS_WOOD;
    public static Block STRIPPED_EBONY_WOOD;
    public static Block STRIPPED_FIR_WOOD;
    public static Block STRIPPED_GREEN_ENCHANTED_WOOD;
    public static Block STRIPPED_HOLLY_WOOD;
    public static Block STRIPPED_JACARANDA_WOOD;
    public static Block STRIPPED_MAHOGANY_WOOD;
    public static Block STRIPPED_MANGROVE_WOOD;
    public static Block STRIPPED_MAPLE_WOOD;
    public static Block STRIPPED_PALO_VERDE_WOOD;
    public static Block STRIPPED_PINE_WOOD;
    public static Block STRIPPED_RAINBOW_EUCALYPTUS_WOOD;
    public static Block STRIPPED_SKYRIS_WOOD;
    public static Block STRIPPED_WILLOW_WOOD;
    public static Block STRIPPED_REDWOOD_WOOD;
    public static Block STRIPPED_WITCH_HAZEL_WOOD;
    public static Block STRIPPED_ZELKOVA_WOOD;
    public static Block STRIPPED_SYTHIAN_HYPHAE;
    public static Block STRIPPED_EMBUR_HYPHAE;
    public static Block STRIPPED_PALM_WOOD;
    public static Block STRIPPED_LAMENT_WOOD;

    public static void registerBlocks(IForgeRegistry<Block> registry) {
        BYG.LOGGER.debug("BYG: Registering blocks...");
        registry.registerAll(
                //Plank BYGBlockRenders
                BYGBlocks.ASPEN_PLANKS = new BYGBlockProperties.BYGPlanks("aspen_planks"),
                BYGBlocks.BAOBAB_PLANKS = new BYGBlockProperties.BYGPlanks("baobab_planks"),
                BYGBlocks.BLUE_ENCHANTED_PLANKS = new BYGBlockProperties.BYGPlanks("blue_enchanted_planks"),
                BYGBlocks.CHERRY_PLANKS = new BYGBlockProperties.BYGPlanks("cherry_planks"),
                BYGBlocks.CIKA_PLANKS = new BYGBlockProperties.BYGPlanks("cika_planks"),
                BYGBlocks.CYPRESS_PLANKS = new BYGBlockProperties.BYGPlanks("cypress_planks"),
                BYGBlocks.EBONY_PLANKS = new BYGBlockProperties.BYGPlanks("ebony_planks"),
                BYGBlocks.FIR_PLANKS = new BYGBlockProperties.BYGPlanks("fir_planks"),
                BYGBlocks.GREEN_ENCHANTED_PLANKS = new BYGBlockProperties.BYGPlanks("green_enchanted_planks"),
                BYGBlocks.HOLLY_PLANKS = new BYGBlockProperties.BYGPlanks("holly_planks"),
                BYGBlocks.JACARANDA_PLANKS = new BYGBlockProperties.BYGPlanks("jacaranda_planks"),
                BYGBlocks.MAHOGANY_PLANKS = new BYGBlockProperties.BYGPlanks("mahogany_planks"),
                BYGBlocks.MANGROVE_PLANKS = new BYGBlockProperties.BYGPlanks("mangrove_planks"),
                BYGBlocks.MAPLE_PLANKS = new BYGBlockProperties.BYGPlanks("maple_planks"),
                BYGBlocks.PINE_PLANKS = new BYGBlockProperties.BYGPlanks("pine_planks"),
                BYGBlocks.RAINBOW_EUCALYPTUS_PLANKS = new BYGBlockProperties.BYGPlanks("rainbow_eucalyptus_planks"),
                BYGBlocks.REDWOOD_PLANKS = new BYGBlockProperties.BYGPlanks("redwood_planks"),
                BYGBlocks.SKYRIS_PLANKS = new BYGBlockProperties.BYGPlanks("skyris_planks"),
                BYGBlocks.WILLOW_PLANKS = new BYGBlockProperties.BYGPlanks("willow_planks"),
                BYGBlocks.WITCH_HAZEL_PLANKS = new BYGBlockProperties.BYGPlanks("witch_hazel_planks"),
                BYGBlocks.ZELKOVA_PLANKS = new BYGBlockProperties.BYGPlanks("zelkova_planks"),
                BYGBlocks.SYTHIAN_PLANKS = new BYGBlockProperties.BYGPlanks("sythian_planks"),
                BYGBlocks.EMBUR_PLANKS = new BYGBlockProperties.BYGPlanks("embur_planks"),
                BYGBlocks.PALM_PLANKS = new BYGBlockProperties.BYGPlanks("palm_planks"),
                BYGBlocks.LAMENT_PLANKS = new BYGBlockProperties.BYGPlanks("lament_planks"),

                //Bookshelf Blocks
                BYGBlocks.ASPEN_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("aspen_bookshelf"),
                BYGBlocks.BAOBAB_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("baobab_bookshelf"),
                BYGBlocks.BLUE_ENCHANTED_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("blue_enchanted_bookshelf"),
                BYGBlocks.CHERRY_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("cherry_bookshelf"),
                BYGBlocks.CIKA_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("cika_bookshelf"),
                BYGBlocks.CYPRESS_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("cypress_bookshelf"),
                BYGBlocks.EBONY_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("ebony_bookshelf"),
                BYGBlocks.FIR_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("fir_bookshelf"),
                BYGBlocks.GREEN_ENCHANTED_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("green_enchanted_bookshelf"),
                BYGBlocks.HOLLY_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("holly_bookshelf"),
                BYGBlocks.JACARANDA_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("jacaranda_bookshelf"),
                BYGBlocks.MAHOGANY_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("mahogany_bookshelf"),
                BYGBlocks.MANGROVE_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("mangrove_bookshelf"),
                BYGBlocks.MAPLE_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("maple_bookshelf"),
                BYGBlocks.PINE_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("pine_bookshelf"),
                BYGBlocks.RAINBOW_EUCALYPTUS_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("rainbow_eucalyptus_bookshelf"),
                BYGBlocks.REDWOOD_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("redwood_bookshelf"),
                BYGBlocks.SKYRIS_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("skyris_bookshelf"),
                BYGBlocks.WILLOW_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("willow_bookshelf"),
                BYGBlocks.WITCH_HAZEL_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("witch_hazel_bookshelf"),
                BYGBlocks.ZELKOVA_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("zelkova_bookshelf"),
                BYGBlocks.SYTHIAN_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("sythian_bookshelf"),
                BYGBlocks.EMBUR_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("embur_bookshelf"),
                BYGBlocks.PALM_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("palm_bookshelf"),
                BYGBlocks.LAMENT_BOOKSHELF = new BYGBlockProperties.BlockBookshelf("lament_bookshelf"),

                //Doors
                BYGBlocks.ASPEN_DOOR = new BYGBlockProperties.BYGDoors("aspen_door"),
                BYGBlocks.BAOBAB_DOOR = new BYGBlockProperties.BYGDoors("baobab_door"),
                BYGBlocks.BLUE_ENCHANTED_DOOR = new BYGBlockProperties.BYGDoors("blue_enchanted_door"),
                BYGBlocks.CHERRY_DOOR = new BYGBlockProperties.BYGDoors("cherry_door"),
                BYGBlocks.CIKA_DOOR = new BYGBlockProperties.BYGDoors("cika_door"),
                BYGBlocks.CYPRESS_DOOR = new BYGBlockProperties.BYGDoors("cypress_door"),
                BYGBlocks.EBONY_DOOR = new BYGBlockProperties.BYGDoors("ebony_door"),
                BYGBlocks.FIR_DOOR = new BYGBlockProperties.BYGDoors("fir_door"),
                BYGBlocks.GREEN_ENCHANTED_DOOR = new BYGBlockProperties.BYGDoors("green_enchanted_door"),
                BYGBlocks.HOLLY_DOOR = new BYGBlockProperties.BYGDoors("holly_door"),
                BYGBlocks.JACARANDA_DOOR = new BYGBlockProperties.BYGDoors("jacaranda_door"),
                BYGBlocks.MAHOGANY_DOOR = new BYGBlockProperties.BYGDoors("mahogany_door"),
                BYGBlocks.MANGROVE_DOOR = new BYGBlockProperties.BYGDoors("mangrove_door"),
                BYGBlocks.MAPLE_DOOR = new BYGBlockProperties.BYGDoors("maple_door"),
                BYGBlocks.PINE_DOOR = new BYGBlockProperties.BYGDoors("pine_door"),
                BYGBlocks.RAINBOW_EUCALYPTUS_DOOR = new BYGBlockProperties.BYGDoors("rainbow_eucalyptus_door"),
                BYGBlocks.REDWOOD_DOOR = new BYGBlockProperties.BYGDoors("redwood_door"),
                BYGBlocks.SKYRIS_DOOR = new BYGBlockProperties.BYGDoors("skyris_door"),
                BYGBlocks.WILLOW_DOOR = new BYGBlockProperties.BYGDoors("willow_door"),
                BYGBlocks.WITCH_HAZEL_DOOR = new BYGBlockProperties.BYGDoors("witch_hazel_door"),
                BYGBlocks.ZELKOVA_DOOR = new BYGBlockProperties.BYGDoors("zelkova_door"),
                BYGBlocks.SYTHIAN_DOOR = new BYGBlockProperties.BYGDoors("sythian_door"),
                BYGBlocks.EMBUR_DOOR = new BYGBlockProperties.BYGDoors("embur_door"),
                BYGBlocks.PALM_DOOR = new BYGBlockProperties.BYGDoors("palm_door"),
                BYGBlocks.LAMENT_DOOR = new BYGBlockProperties.BYGDoors("lament_door"),

                //Pressure Plate Blocks
                BYGBlocks.ASPEN_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("aspen_pressure_plate"),
                BYGBlocks.BAOBAB_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("baobab_pressure_plate"),
                BYGBlocks.BLUE_ENCHANTED_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("blue_enchanted_pressure_plate"),
                BYGBlocks.CHERRY_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("cherry_pressure_plate"),
                BYGBlocks.CIKA_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("cika_pressure_plate"),
                BYGBlocks.CYPRESS_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("cypress_pressure_plate"),
                BYGBlocks.EBONY_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("ebony_pressure_plate"),
                BYGBlocks.FIR_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("fir_pressure_plate"),
                BYGBlocks.GREEN_ENCHANTED_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("green_enchanted_pressure_plate"),
                BYGBlocks.HOLLY_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("holly_pressure_plate"),
                BYGBlocks.JACARANDA_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("jacaranda_pressure_plate"),
                BYGBlocks.MAHOGANY_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("mahogany_pressure_plate"),
                BYGBlocks.MANGROVE_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("mangrove_pressure_plate"),
                BYGBlocks.MAPLE_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("maple_pressure_plate"),
                BYGBlocks.PINE_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("pine_pressure_plate"),
                BYGBlocks.RAINBOW_EUCALYPTUS_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("rainbow_eucalyptus_pressure_plate"),
                BYGBlocks.REDWOOD_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("redwood_pressure_plate"),
                BYGBlocks.SKYRIS_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("skyris_pressure_plate"),
                BYGBlocks.WILLOW_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("willow_pressure_plate"),
                BYGBlocks.WITCH_HAZEL_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("witch_hazel_pressure_plate"),
                BYGBlocks.ZELKOVA_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("zelkova_pressure_plate"),
                BYGBlocks.SYTHIAN_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("sythian_pressure_plate"),
                BYGBlocks.EMBUR_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("embur_pressure_plate"),
                BYGBlocks.PALM_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("palm_pressure_plate"),
                BYGBlocks.LAMENT_PRESSURE_PLATE = new BYGBlockProperties.BYGPressurePlate("lament_pressure_plate"),

                //Button Blocks
                BYGBlocks.ASPEN_BUTTON = new BYGBlockProperties.BYGButtons("aspen_button"),
                BYGBlocks.BAOBAB_BUTTON = new BYGBlockProperties.BYGButtons("baobab_button"),
                BYGBlocks.BLUE_ENCHANTED_BUTTON = new BYGBlockProperties.BYGButtons("blue_enchanted_button"),
                BYGBlocks.CHERRY_BUTTON = new BYGBlockProperties.BYGButtons("cherry_button"),
                BYGBlocks.CIKA_BUTTON = new BYGBlockProperties.BYGButtons("cika_button"),
                BYGBlocks.CYPRESS_BUTTON = new BYGBlockProperties.BYGButtons("cypress_button"),
                BYGBlocks.EBONY_BUTTON = new BYGBlockProperties.BYGButtons("ebony_button"),
                BYGBlocks.FIR_BUTTON = new BYGBlockProperties.BYGButtons("fir_button"),
                BYGBlocks.GREEN_ENCHANTED_BUTTON = new BYGBlockProperties.BYGButtons("green_enchanted_button"),
                BYGBlocks.HOLLY_BUTTON = new BYGBlockProperties.BYGButtons("holly_button"),
                BYGBlocks.JACARANDA_BUTTON = new BYGBlockProperties.BYGButtons("jacaranda_button"),
                BYGBlocks.MAHOGANY_BUTTON = new BYGBlockProperties.BYGButtons("mahogany_button"),
                BYGBlocks.MANGROVE_BUTTON = new BYGBlockProperties.BYGButtons("mangrove_button"),
                BYGBlocks.MAPLE_BUTTON = new BYGBlockProperties.BYGButtons("maple_button"),
                BYGBlocks.PINE_BUTTON = new BYGBlockProperties.BYGButtons("pine_button"),
                BYGBlocks.RAINBOW_EUCALYPTUS_BUTTON = new BYGBlockProperties.BYGButtons("rainbow_eucalyptus_button"),
                BYGBlocks.REDWOOD_BUTTON = new BYGBlockProperties.BYGButtons("redwood_button"),
                BYGBlocks.SKYRIS_BUTTON = new BYGBlockProperties.BYGButtons("skyris_button"),
                BYGBlocks.WILLOW_BUTTON = new BYGBlockProperties.BYGButtons("willow_button"),
                BYGBlocks.WITCH_HAZEL_BUTTON = new BYGBlockProperties.BYGButtons("witch_hazel_button"),
                BYGBlocks.ZELKOVA_BUTTON = new BYGBlockProperties.BYGButtons("zelkova_button"),
                BYGBlocks.SYTHIAN_BUTTON = new BYGBlockProperties.BYGButtons("sythian_button"),
                BYGBlocks.EMBUR_BUTTON = new BYGBlockProperties.BYGButtons("embur_button"),
                BYGBlocks.PALM_BUTTON = new BYGBlockProperties.BYGButtons("palm_button"),
                BYGBlocks.LAMENT_BUTTON = new BYGBlockProperties.BYGButtons("lament_button"),

                //Trapdoor Blocks
                BYGBlocks.ASPEN_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("aspen_trapdoor"),
                BYGBlocks.BAOBAB_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("baobab_trapdoor"),
                BYGBlocks.BLUE_ENCHANTED_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("blue_enchanted_trapdoor"),
                BYGBlocks.CHERRY_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("cherry_trapdoor"),
                BYGBlocks.CIKA_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("cika_trapdoor"),
                BYGBlocks.CYPRESS_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("cypress_trapdoor"),
                BYGBlocks.EBONY_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("ebony_trapdoor"),
                BYGBlocks.FIR_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("fir_trapdoor"),
                BYGBlocks.GREEN_ENCHANTED_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("green_enchanted_trapdoor"),
                BYGBlocks.HOLLY_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("holly_trapdoor"),
                BYGBlocks.JACARANDA_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("jacaranda_trapdoor"),
                BYGBlocks.MAHOGANY_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("mahogany_trapdoor"),
                BYGBlocks.MANGROVE_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("mangrove_trapdoor"),
                BYGBlocks.MAPLE_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("maple_trapdoor"),
                BYGBlocks.PINE_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("pine_trapdoor"),
                BYGBlocks.RAINBOW_EUCALYPTUS_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("rainbow_eucalyptus_trapdoor"),
                BYGBlocks.REDWOOD_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("redwood_trapdoor"),
                BYGBlocks.SKYRIS_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("skyris_trapdoor"),
                BYGBlocks.WILLOW_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("willow_trapdoor"),
                BYGBlocks.WITCH_HAZEL_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("witch_hazel_trapdoor"),
                BYGBlocks.ZELKOVA_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("zelkova_trapdoor"),
                BYGBlocks.SYTHIAN_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("sythian_trapdoor"),
                BYGBlocks.EMBUR_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("embur_trapdoor"),
                BYGBlocks.PALM_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("palm_trapdoor"),
                BYGBlocks.LAMENT_TRAPDOOR = new BYGBlockProperties.BYGTrapdoors("lament_trapdoor"),

                //Crafting Table Blocks
                BYGBlocks.ASPEN_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("aspen_crafting_table"),
                BYGBlocks.BAOBAB_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("baobab_crafting_table"),
                BYGBlocks.BLUE_ENCHANTED_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("blue_enchanted_crafting_table"),
                BYGBlocks.CHERRY_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("cherry_crafting_table"),
                BYGBlocks.CIKA_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("cika_crafting_table"),
                BYGBlocks.CYPRESS_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("cypress_crafting_table"),
                BYGBlocks.EBONY_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("ebony_crafting_table"),
                BYGBlocks.FIR_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("fir_crafting_table"),
                BYGBlocks.GREEN_ENCHANTED_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("green_enchanted_crafting_table"),
                BYGBlocks.HOLLY_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("holly_crafting_table"),
                BYGBlocks.JACARANDA_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("jacaranda_crafting_table"),
                BYGBlocks.MAHOGANY_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("mahogany_crafting_table"),
                BYGBlocks.MANGROVE_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("mangrove_crafting_table"),
                BYGBlocks.MAPLE_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("maple_crafting_table"),
                BYGBlocks.PINE_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("pine_crafting_table"),
                BYGBlocks.RAINBOW_EUCALYPTUS_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("rainbow_eucalyptus_crafting_table"),
                BYGBlocks.REDWOOD_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("redwood_crafting_table"),
                BYGBlocks.SKYRIS_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("skyris_crafting_table"),
                BYGBlocks.WILLOW_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("willow_crafting_table"),
                BYGBlocks.WITCH_HAZEL_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("witch_hazel_crafting_table"),
                BYGBlocks.ZELKOVA_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("zelkova_crafting_table"),
                BYGBlocks.SYTHIAN_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("sythian_crafting_table"),
                BYGBlocks.EMBUR_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("embur_crafting_table"),
                BYGBlocks.PALM_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("palm_crafting_table"),
                BYGBlocks.LAMENT_CRAFTING_TABLE = new BYGBlockProperties.BYGCraftingTable("lament_crafting_table"),

                //Fence Gate Blocks
                BYGBlocks.ASPEN_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("aspen_fence_gate"),
                BYGBlocks.BAOBAB_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("baobab_fence_gate"),
                BYGBlocks.BLUE_ENCHANTED_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("blue_enchanted_fence_gate"),
                BYGBlocks.CHERRY_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("cherry_fence_gate"),
                BYGBlocks.CIKA_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("cika_fence_gate"),
                BYGBlocks.CYPRESS_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("cypress_fence_gate"),
                BYGBlocks.EBONY_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("ebony_fence_gate"),
                BYGBlocks.FIR_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("fir_fence_gate"),
                BYGBlocks.GREEN_ENCHANTED_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("green_enchanted_fence_gate"),
                BYGBlocks.HOLLY_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("holly_fence_gate"),
                BYGBlocks.JACARANDA_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("jacaranda_fence_gate"),
                BYGBlocks.MAHOGANY_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("mahogany_fence_gate"),
                BYGBlocks.MANGROVE_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("mangrove_fence_gate"),
                BYGBlocks.MAPLE_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("maple_fence_gate"),
                BYGBlocks.PINE_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("pine_fence_gate"),
                BYGBlocks.RAINBOW_EUCALYPTUS_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("rainbow_eucalyptus_fence_gate"),
                BYGBlocks.REDWOOD_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("redwood_fence_gate"),
                BYGBlocks.SKYRIS_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("skyris_fence_gate"),
                BYGBlocks.WILLOW_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("willow_fence_gate"),
                BYGBlocks.WITCH_HAZEL_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("witch_hazel_fence_gate"),
                BYGBlocks.ZELKOVA_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("zelkova_fence_gate"),
                BYGBlocks.SYTHIAN_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("sythian_fence_gate"),
                BYGBlocks.EMBUR_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("embur_fence_gate"),
                BYGBlocks.PALM_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("palm_fence_gate"),
                BYGBlocks.LAMENT_FENCE_GATE = new BYGBlockProperties.BYGFenceGate("lament_fence_gate"),

                //Slabs
                BYGBlocks.ASPEN_SLAB = new BYGBlockProperties.BYGWoodSlab("aspen_slab"),
                BYGBlocks.BAOBAB_SLAB = new BYGBlockProperties.BYGWoodSlab("baobab_slab"),
                BYGBlocks.BLUE_ENCHANTED_SLAB = new BYGBlockProperties.BYGWoodSlab("blue_enchanted_slab"),
                BYGBlocks.CHERRY_SLAB = new BYGBlockProperties.BYGWoodSlab("cherry_slab"),
                BYGBlocks.CIKA_SLAB = new BYGBlockProperties.BYGWoodSlab("cika_slab"),
                BYGBlocks.CYPRESS_SLAB = new BYGBlockProperties.BYGWoodSlab("cypress_slab"),
                BYGBlocks.EBONY_SLAB = new BYGBlockProperties.BYGWoodSlab("ebony_slab"),
                BYGBlocks.FIR_SLAB = new BYGBlockProperties.BYGWoodSlab("fir_slab"),
                BYGBlocks.GREEN_ENCHANTED_SLAB = new BYGBlockProperties.BYGWoodSlab("green_enchanted_slab"),
                BYGBlocks.HOLLY_SLAB = new BYGBlockProperties.BYGWoodSlab("holly_slab"),
                BYGBlocks.JACARANDA_SLAB = new BYGBlockProperties.BYGWoodSlab("jacaranda_slab"),
                BYGBlocks.MAHOGANY_SLAB = new BYGBlockProperties.BYGWoodSlab("mahogany_slab"),
                BYGBlocks.MANGROVE_SLAB = new BYGBlockProperties.BYGWoodSlab("mangrove_slab"),
                BYGBlocks.MAPLE_SLAB = new BYGBlockProperties.BYGWoodSlab("maple_slab"),
                BYGBlocks.PINE_SLAB = new BYGBlockProperties.BYGWoodSlab("pine_slab"),
                BYGBlocks.RAINBOW_EUCALYPTUS_SLAB = new BYGBlockProperties.BYGWoodSlab("rainbow_eucalyptus_slab"),
                BYGBlocks.REDWOOD_SLAB = new BYGBlockProperties.BYGWoodSlab("redwood_slab"),
                BYGBlocks.SKYRIS_SLAB = new BYGBlockProperties.BYGWoodSlab("skyris_slab"),
                BYGBlocks.WILLOW_SLAB = new BYGBlockProperties.BYGWoodSlab("willow_slab"),
                BYGBlocks.WITCH_HAZEL_SLAB = new BYGBlockProperties.BYGWoodSlab("witch_hazel_slab"),
                BYGBlocks.ZELKOVA_SLAB = new BYGBlockProperties.BYGWoodSlab("zelkova_slab"),
                BYGBlocks.SYTHIAN_SLAB = new BYGBlockProperties.BYGWoodSlab("sythian_slab"),
                BYGBlocks.EMBUR_SLAB = new BYGBlockProperties.BYGWoodSlab("embur_slab"),
                BYGBlocks.PALM_SLAB = new BYGBlockProperties.BYGWoodSlab("palm_slab"),
                BYGBlocks.LAMENT_SLAB = new BYGBlockProperties.BYGWoodSlab("lament_slab"),

                //Stairs Blocks
                BYGBlocks.ASPEN_STAIRS = new BYGBlockProperties.BYGWoodStairs("aspen_stairs"),
                BYGBlocks.BAOBAB_STAIRS = new BYGBlockProperties.BYGWoodStairs("baobab_stairs"),
                BYGBlocks.BLUE_ENCHANTED_STAIRS = new BYGBlockProperties.BYGWoodStairs("blue_enchanted_stairs"),
                BYGBlocks.CHERRY_STAIRS = new BYGBlockProperties.BYGWoodStairs("cherry_stairs"),
                BYGBlocks.CIKA_STAIRS = new BYGBlockProperties.BYGWoodStairs("cika_stairs"),
                BYGBlocks.CYPRESS_STAIRS = new BYGBlockProperties.BYGWoodStairs("cypress_stairs"),
                BYGBlocks.EBONY_STAIRS = new BYGBlockProperties.BYGWoodStairs("ebony_stairs"),
                BYGBlocks.FIR_STAIRS = new BYGBlockProperties.BYGWoodStairs("fir_stairs"),
                BYGBlocks.GREEN_ENCHANTED_STAIRS = new BYGBlockProperties.BYGWoodStairs("green_enchanted_stairs"),
                BYGBlocks.HOLLY_STAIRS = new BYGBlockProperties.BYGWoodStairs("holly_stairs"),
                BYGBlocks.JACARANDA_STAIRS = new BYGBlockProperties.BYGWoodStairs("jacaranda_stairs"),
                BYGBlocks.MAHOGANY_STAIRS = new BYGBlockProperties.BYGWoodStairs("mahogany_stairs"),
                BYGBlocks.MANGROVE_STAIRS = new BYGBlockProperties.BYGWoodStairs("mangrove_stairs"),
                BYGBlocks.MAPLE_STAIRS = new BYGBlockProperties.BYGWoodStairs("maple_stairs"),
                BYGBlocks.PINE_STAIRS = new BYGBlockProperties.BYGWoodStairs("pine_stairs"),
                BYGBlocks.RAINBOW_EUCALYPTUS_STAIRS = new BYGBlockProperties.BYGWoodStairs("rainbow_eucalyptus_stairs"),
                BYGBlocks.REDWOOD_STAIRS = new BYGBlockProperties.BYGWoodStairs("redwood_stairs"),
                BYGBlocks.SKYRIS_STAIRS = new BYGBlockProperties.BYGWoodStairs("skyris_stairs"),
                BYGBlocks.WILLOW_STAIRS = new BYGBlockProperties.BYGWoodStairs("willow_stairs"),
                BYGBlocks.WITCH_HAZEL_STAIRS = new BYGBlockProperties.BYGWoodStairs("witch_hazel_stairs"),
                BYGBlocks.ZELKOVA_STAIRS = new BYGBlockProperties.BYGWoodStairs("zelkova_stairs"),
                BYGBlocks.SYTHIAN_STAIRS = new BYGBlockProperties.BYGWoodStairs("sythian_stairs"),
                BYGBlocks.EMBUR_STAIRS = new BYGBlockProperties.BYGWoodStairs("embur_stairs"),
                BYGBlocks.PALM_STAIRS = new BYGBlockProperties.BYGWoodStairs("palm_stairs"),
                BYGBlocks.LAMENT_STAIRS = new BYGBlockProperties.BYGWoodStairs("lament_stairs"),

                //Fence Blocks
                BYGBlocks.ASPEN_FENCE = new BYGBlockProperties.BYGFence("aspen_fence"),
                BYGBlocks.BAOBAB_FENCE = new BYGBlockProperties.BYGFence("baobab_fence"),
                BYGBlocks.BLUE_ENCHANTED_FENCE = new BYGBlockProperties.BYGFence("blue_enchanted_fence"),
                BYGBlocks.CHERRY_FENCE = new BYGBlockProperties.BYGFence("cherry_fence"),
                BYGBlocks.CIKA_FENCE = new BYGBlockProperties.BYGFence("cika_fence"),
                BYGBlocks.CYPRESS_FENCE = new BYGBlockProperties.BYGFence("cypress_fence"),
                BYGBlocks.EBONY_FENCE = new BYGBlockProperties.BYGFence("ebony_fence"),
                BYGBlocks.FIR_FENCE = new BYGBlockProperties.BYGFence("fir_fence"),
                BYGBlocks.GREEN_ENCHANTED_FENCE = new BYGBlockProperties.BYGFence("green_enchanted_fence"),
                BYGBlocks.HOLLY_FENCE = new BYGBlockProperties.BYGFence("holly_fence"),
                BYGBlocks.JACARANDA_FENCE = new BYGBlockProperties.BYGFence("jacaranda_fence"),
                BYGBlocks.MAHOGANY_FENCE = new BYGBlockProperties.BYGFence("mahogany_fence"),
                BYGBlocks.MANGROVE_FENCE = new BYGBlockProperties.BYGFence("mangrove_fence"),
                BYGBlocks.MAPLE_FENCE = new BYGBlockProperties.BYGFence("maple_fence"),
                BYGBlocks.PINE_FENCE = new BYGBlockProperties.BYGFence("pine_fence"),
                BYGBlocks.RAINBOW_EUCALYPTUS_FENCE = new BYGBlockProperties.BYGFence("rainbow_eucalyptus_fence"),
                BYGBlocks.REDWOOD_FENCE = new BYGBlockProperties.BYGFence("redwood_fence"),
                BYGBlocks.SKYRIS_FENCE = new BYGBlockProperties.BYGFence("skyris_fence"),
                BYGBlocks.WILLOW_FENCE = new BYGBlockProperties.BYGFence("willow_fence"),
                BYGBlocks.WITCH_HAZEL_FENCE = new BYGBlockProperties.BYGFence("witch_hazel_fence"),
                BYGBlocks.ZELKOVA_FENCE = new BYGBlockProperties.BYGFence("zelkova_fence"),
                BYGBlocks.SYTHIAN_FENCE = new BYGBlockProperties.BYGFence("sythian_fence"),
                BYGBlocks.EMBUR_FENCE = new BYGBlockProperties.BYGFence("embur_fence"),
                BYGBlocks.PALM_FENCE = new BYGBlockProperties.BYGFence("palm_fence"),
                BYGBlocks.LAMENT_FENCE = new BYGBlockProperties.BYGFence("lament_fence"),

                //Ground Blocks
                BYGBlocks.PEAT = new BYGBlockProperties.BYGDirt("peat"),
                BYGBlocks.GLOWCELIUM = new BYGBlockProperties.BYGGlowcelium("glowcelium_block"),
                BYGBlocks.MEADOW_DIRT = new BYGBlockProperties.BYGDirt("meadow_dirt"),
                BYGBlocks.MUD_BLOCK = new BYGBlockProperties.BYGMud("mud_block"),
                BYGBlocks.MUD_BRICKS = new BYGBlockProperties.BYGDirt("mud_bricks"),

                //Sapling Blocks
                BYGBlocks.ARAUCARIA_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.AraucariaSaplingToTree(), "araucaria_sapling"),
                BYGBlocks.ASPEN_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.AspenSaplingToTree(), "aspen_sapling"),
                BYGBlocks.BAOBAB_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.BaobabSaplingToTree(), "baobab_sapling"),
                BYGBlocks.BLUE_ENCHANTED_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.BlueEnchantedSaplingToTree(), "blue_enchanted_sapling"),
                BYGBlocks.BLUE_SPRUCE_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.BlueSpruceSaplingToTree(), "blue_spruce_sapling"),
                BYGBlocks.BROWN_BIRCH_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.BrownBirchSaplingToTree(), "brown_birch_sapling"),
                BYGBlocks.BROWN_OAK_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.BrownOakSaplingToTree(), "brown_oak_sapling"),
                BYGBlocks.BROWN_ZELKOVA_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.BrownZelkovaSaplingToTree(), "brown_zelkova_sapling"),
                BYGBlocks.CIKA_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.CikaSaplingToTree(), "cika_sapling"),
                BYGBlocks.CYPRESS_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.CypressSaplingToTree(), "cypress_sapling"),
                BYGBlocks.EBONY_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.EbonySaplingToTree(), "ebony_sapling"),
                BYGBlocks.FIR_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.FirSaplingToTree(), "fir_sapling"),
                BYGBlocks.GREEN_ENCHANTED_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.GreenEnchantedSaplingToTree(), "green_enchanted_sapling"),
                BYGBlocks.HOLLY_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.HollySaplingToTree(), "holly_sapling"),
                BYGBlocks.JACARANDA_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.JacarandaSaplingToTree(), "jacaranda_sapling"),
                BYGBlocks.INDIGO_JACARANDA_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.IndigoJacarandaSaplingToTree(), "indigo_jacaranda_sapling"),
                BYGBlocks.JOSHUA_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.JoshuaSaplingToTree(), "joshua_sapling"),
                BYGBlocks.MAHOGANY_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.MahogonySaplingToTree(), "mahogany_sapling"),
                BYGBlocks.MANGROVE_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.MangroveSaplingToTree(), "mangrove_sapling"),
                BYGBlocks.MAPLE_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.MapleSaplingToTree(), "maple_sapling"),
                BYGBlocks.ORANGE_BIRCH_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.OrangeBirchSaplingToTree(), "orange_birch_sapling"),
                BYGBlocks.ORANGE_OAK_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.OrangeOakSaplingToTree(), "orange_oak_sapling"),
                BYGBlocks.ORANGE_SPRUCE_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.OrangeSpruceSaplingToTree(), "orange_spruce_sapling"),
                BYGBlocks.ORCHARD_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.OrchardSaplingToTree(), "orchard_sapling"),
                BYGBlocks.PALO_VERDE_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.PaloVerdeSaplingToTree(), "palo_verde_sapling"),
                BYGBlocks.PINE_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.PineSaplingToTree(), "pine_sapling"),
                BYGBlocks.PINK_CHERRY_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.PinkCherrySaplingToTree(), "pink_cherry_sapling"),
                BYGBlocks.RAINBOW_EUCALYPTUS_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.RainbowEucalyptusSaplingToTree(), "rainbow_eucalyptus_sapling"),
                BYGBlocks.RED_BIRCH_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.RedBirchSaplingToTree(), "red_birch_sapling"),
                BYGBlocks.RED_MAPLE_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.RedMapleSaplingToTree(), "red_maple_sapling"),
                BYGBlocks.RED_OAK_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.RedOakSaplingToTree(), "red_oak_sapling"),
                BYGBlocks.RED_SPRUCE_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.RedSpruceSaplingToTree(), "red_spruce_sapling"),
                BYGBlocks.REDWOOD_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.RedwoodSaplingToTree(), "redwood_sapling"),
                BYGBlocks.SILVER_MAPLE_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.SilverMapleSaplingToTree(), "silver_maple_sapling"),
                BYGBlocks.SKYRIS_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.SkyrisSaplingToTree(), "skyris_sapling"),
                BYGBlocks.WHITE_CHERRY_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.WhiteCherrySaplingToTree(), "white_cherry_sapling"),
                BYGBlocks.WILLOW_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.WillowSaplingToTree(), "willow_sapling"),
                BYGBlocks.WITCH_HAZEL_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.WitchHazelSaplingToTree(), "witch_hazel_sapling"),
                BYGBlocks.YELLOW_BIRCH_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.YellowBirchSaplingToTree(), "yellow_birch_sapling"),
                BYGBlocks.YELLOW_SPRUCE_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.YellowSpruceSaplingToTree(), "yellow_spruce_sapling"),
                BYGBlocks.ZELKOVA_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.ZelkovaSaplingToTree(), "zelkova_sapling"),
                BYGBlocks.PALM_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.PalmSaplingToTree(), "palm_sapling"),
                BYGBlocks.LAMENT_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.LamentSaplingToTree(), "lament_sapling"),
                BYGBlocks.WITHERING_OAK_SAPLING = new BYGSaplingProperties(new BYGSaplingToTree.WitheringOakSaplingToTree(), "withering_oak_sapling"),

                //Leaf Blocks
                BYGBlocks.ARAUCARIA_LEAVES = new BYGBlockProperties.BYGLeaves("araucaria_leaves"),
                BYGBlocks.ASPEN_LEAVES = new BYGBlockProperties.BYGLeaves("aspen_leaves"),
                BYGBlocks.BAOBAB_LEAVES = new BYGBlockProperties.BYGLeaves("baobab_leaves"),
                BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES = new BYGBlockProperties.BYGBloomingWitchhazelLeaves("blooming_witch_hazel_leaves"),
                BYGBlocks.BLUE_ENCHANTED_LEAVES = new BYGBlockProperties.BYGBloomingWitchhazelLeaves("blue_enchanted_leaves"),
                BYGBlocks.BLUE_SPRUCE_LEAVES = new BYGBlockProperties.BYGLeaves("blue_spruce_leaves"),
                BYGBlocks.BROWN_BIRCH_LEAVES = new BYGBlockProperties.BYGLeaves("brown_birch_leaves"),
                BYGBlocks.BROWN_OAK_LEAVES = new BYGBlockProperties.BYGLeaves("brown_oak_leaves"),
                BYGBlocks.BROWN_ZELKOVA_LEAVES = new BYGBlockProperties.BYGLeaves("brown_zelkova_leaves"),
                BYGBlocks.CIKA_LEAVES = new BYGBlockProperties.BYGLeaves("cika_leaves"),
                BYGBlocks.CYPRESS_LEAVES = new BYGBlockProperties.BYGLeaves("cypress_leaves"),
                BYGBlocks.EBONY_LEAVES = new BYGBlockProperties.BYGLeaves("ebony_leaves"),
                BYGBlocks.FIR_LEAVES = new BYGBlockProperties.BYGLeaves("fir_leaves"),
                BYGBlocks.FLOWERING_ORCHARD_LEAVES = new BYGBlockProperties.BYGLeaves("flowering_orchard_leaves"),
                BYGBlocks.FLOWERING_PALO_VERDE_LEAVES = new BYGBlockProperties.BYGLeaves("flowering_palo_verde_leaves"),
                BYGBlocks.GREEN_ENCHANTED_LEAVES = new BYGBlockProperties.BYGBloomingWitchhazelLeaves("green_enchanted_leaves"),
                BYGBlocks.HOLLY_BERRY_LEAVES = new BYGBlockProperties.BYGLeaves("holly_berry_leaves"),
                BYGBlocks.HOLLY_LEAVES = new BYGBlockProperties.BYGLeaves("holly_leaves"),
                BYGBlocks.JACARANDA_LEAVES = new BYGBlockProperties.BYGLeaves("jacaranda_leaves"),
                BYGBlocks.INDIGO_JACARANDA_LEAVES = new BYGBlockProperties.BYGLeaves("indigo_jacaranda_leaves"),
                BYGBlocks.JOSHUA_LEAVES = new BYGBlockProperties.BYGLeaves("joshua_leaves"),
                BYGBlocks.RIPE_JOSHUA_LEAVES = new BYGBlockProperties.BYGLeaves("ripe_joshua_leaves"),
                BYGBlocks.MAHOGANY_LEAVES = new BYGBlockProperties.BYGLeaves("mahogany_leaves"),
                BYGBlocks.MANGROVE_LEAVES = new BYGBlockProperties.BYGLeaves("mangrove_leaves"),
                BYGBlocks.MAPLE_LEAVES = new BYGBlockProperties.BYGLeaves("maple_leaves"),
                BYGBlocks.ORANGE_BIRCH_LEAVES = new BYGBlockProperties.BYGLeaves("orange_birch_leaves"),
                BYGBlocks.ORANGE_OAK_LEAVES = new BYGBlockProperties.BYGLeaves("orange_oak_leaves"),
                BYGBlocks.ORANGE_SPRUCE_LEAVES = new BYGBlockProperties.BYGLeaves("orange_spruce_leaves"),
                BYGBlocks.ORCHARD_LEAVES = new BYGBlockProperties.BYGLeaves("orchard_leaves"),
                BYGBlocks.PALO_VERDE_LEAVES = new BYGBlockProperties.BYGLeaves("palo_verde_leaves"),
                BYGBlocks.PINE_LEAVES = new BYGBlockProperties.BYGLeaves("pine_leaves"),
                BYGBlocks.PINK_CHERRY_LEAVES = new BYGBlockProperties.BYGLeaves("pink_cherry_leaves"),
                BYGBlocks.RAINBOW_EUCALYPTUS_LEAVES = new BYGBlockProperties.BYGLeaves("rainbow_eucalyptus_leaves"),
                BYGBlocks.RED_BIRCH_LEAVES = new BYGBlockProperties.BYGLeaves("red_birch_leaves"),
                BYGBlocks.RED_MAPLE_LEAVES = new BYGBlockProperties.BYGLeaves("red_maple_leaves"),
                BYGBlocks.RED_OAK_LEAVES = new BYGBlockProperties.BYGLeaves("red_oak_leaves"),
                BYGBlocks.RED_SPRUCE_LEAVES = new BYGBlockProperties.BYGLeaves("red_spruce_leaves"),
                BYGBlocks.REDWOOD_LEAVES = new BYGBlockProperties.BYGLeaves("redwood_leaves"),
                BYGBlocks.RIPE_ORCHARD_LEAVES = new BYGBlockProperties.BYGLeaves("ripe_orchard_leaves"),
                BYGBlocks.SILVER_MAPLE_LEAVES = new BYGBlockProperties.BYGLeaves("silver_maple_leaves"),
                BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE = new BYGBlockProperties.BYGLeaves("green_apple_skyris_leaves"),
                BYGBlocks.SKYRIS_LEAVES = new BYGBlockProperties.BYGLeaves("skyris_leaves"),
                BYGBlocks.WHITE_CHERRY_LEAVES = new BYGBlockProperties.BYGLeaves("white_cherry_leaves"),
                BYGBlocks.WILLOW_LEAVES = new BYGBlockProperties.BYGLeaves("willow_leaves"),
                BYGBlocks.WITCH_HAZEL_LEAVES = new BYGBlockProperties.BYGLeaves("witch_hazel_leaves"),
                BYGBlocks.YELLOW_BIRCH_LEAVES = new BYGBlockProperties.BYGLeaves("yellow_birch_leaves"),
                BYGBlocks.YELLOW_SPRUCE_LEAVES = new BYGBlockProperties.BYGLeaves("yellow_spruce_leaves"),
                BYGBlocks.ZELKOVA_LEAVES = new BYGBlockProperties.BYGLeaves("zelkova_leaves"),
                BYGBlocks.PALM_LEAVES = new BYGBlockProperties.BYGLeaves("palm_leaves"),
                BYGBlocks.LAMENT_LEAVES = new BYGBlockProperties.BYGLeaves("lament_leaves"),
                BYGBlocks.WITHERING_OAK_LEAVES = new BYGBlockProperties.BYGLeaves("withering_oak_leaves"),

                //Plant Blocks
                BYGBlocks.GREEN_MUSHROOM_BLOCK = new BYGBlockProperties.BlockHugeMushroom("green_mushroom_block"),
                BYGBlocks.MILKCAP_MUSHROOM_BLOCK = new BYGBlockProperties.BlockHugeMushroom("weeping_milkcap_mushroom_block"),
                BYGBlocks.BLEWIT_MUSHROOM_BLOCK = new BYGBlockProperties.BlockHugeMushroom("wood_blewit_mushroom_block"),
                BYGBlocks.PUFF_MUSHROOM_BLOCK = new BYGBlockProperties.BlockHugeMushroom("black_puff_mushroom_block"),
                BYGBlocks.WHITE_MUSHROOM_STEM = new BYGBlockProperties.BlockHugeMushroom("white_mushroom_stem"),
                BYGBlocks.BROWN_MUSHROOM_STEM = new BYGBlockProperties.BlockHugeMushroom("brown_mushroom_stem"),
                BYGBlocks.BLUE_GLOWSHROOM_BLOCK = new BYGBlockProperties.BlockHugeGlowshroom("blue_glowshroom_block"),
                BYGBlocks.PURPLE_GLOWSHROOM_BLOCK = new BYGBlockProperties.BlockHugeGlowshroom("purple_glowshroom_block"),
                BYGBlocks.RED_GLOWSHROOM_STEM = new BYGBlockProperties.BlockHugeGlowshroomStem("red_glowshroom_stem"),
                BYGBlocks.YELLOW_GLOWSHROOM_STEM = new BYGBlockProperties.BlockHugeGlowshroomStem("yellow_glowshroom_stem"),
                BYGBlocks.SOUL_SHROOM_STEM = new BYGBlockProperties.BlockHugeNetherMushroomStem("soul_shroom_stem"),
                BYGBlocks.SOUL_SHROOM_BLOCK = new BYGBlockProperties.BlockHugeNetherMushroom("soul_shroom_block"),
                BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK = new BYGBlockProperties.BlockHugeNetherMushroom("death_cap_mushroom_block"),


                BYGBlocks.CATTAIL = new BYGBlockProperties.BlockCattail("cattail"),
                BYGBlocks.REEDS = new BYGBlockProperties.BlockCattail("reeds"),
                BYGBlocks.REED_THATCH = new BYGBlockProperties.BYGThatch("reed_thatch"),
                BYGBlocks.REED_THATCH_CARPET = new BYGBlockProperties.ThatchCarpet("reed_thatch_carpet"),
                BYGBlocks.REED_THATCH_STAIRS = new BYGBlockProperties.ThatchStairs("reed_thatch_stairs"),
                BYGBlocks.REED_THATCH_SLAB = new BYGBlockProperties.ThatchSlab("reed_thatch_slab"),
                BYGBlocks.HORSEWEED = new BYGBlockProperties.BYGFlower("horseweed"),
                BYGBlocks.MINI_CACTUS = new BYGBlockProperties.BYGDesertPlant("mini_cactus"),
                BYGBlocks.PRICKLY_PEAR_CACTUS = new BYGBlockProperties.BYGDesertPlant("prickly_pear_cactus"),
                BYGBlocks.WINTER_SUCCULENT = new BYGBlockProperties.BYGFlower("winter_succulent"),
                BYGBlocks.SHORT_GRASS = new BYGBlockProperties.BYGTallGrass("short_grass"),
                BYGBlocks.TALL_PRAIRIE_GRASS = new BYGBlockProperties.BYGDoublePlant("tall_prairie_grass"),
                BYGBlocks.BLUE_GLOWCANE = new BYGBlockProperties.BYGBLUEGlowCane("blue_glowcane"),
                BYGBlocks.RED_GLOWCANE = new BYGBlockProperties.BYGREDGlowCane("red_glowcane"),
                BYGBlocks.PURPLE_GLOWCANE = new BYGBlockProperties.BYGPURPLEGlowCane("purple_glowcane"),
                BYGBlocks.PINK_GLOWCANE = new BYGBlockProperties.BYGPINKGlowCane("pink_glowcane"),
                BYGBlocks.POISON_IVY = new BYGBlockProperties.BYGPoisonIvy("poison_ivy"),
                BYGBlocks.SKYRIS_VINE = new BYGBlockProperties.BYGSkyrisVine("skyris_vine"),
                BYGBlocks.BLUEBERRY_BUSH = new BYGBlockProperties.BYGBerryBush("blueberry_bush"),
                BYGBlocks.TINY_LILYPADS = new BYGBlockProperties.BYGLily("tiny_lilypads"),
                BYGBlocks.WATER_SILK = new BYGBlockProperties.BYGWaterSilk("water_silk"),
                BYGBlocks.WEEPING_ROOTS = new BYGBlockProperties.BYGHangingVine("weeping_roots"),
                BYGBlocks.WEEPING_ROOTS_PLANT = new BYGBlockProperties.BYGHangingVinePlant("weeping_roots_plant"),
                BYGBlocks.WINTER_GRASS = new BYGBlockProperties.BYGWinterTallGrass("winter_grass"),
                BYGBlocks.WEED_GRASS = new BYGBlockProperties.BYGTallGrass("weed_grass"),
                BYGBlocks.WILTED_GRASS = new BYGBlockProperties.BYGTallGrass("wilted_grass"),
                BYGBlocks.SHORT_BEACH_GRASS = new BYGBlockProperties.BYGBeachGrass("short_beach_grass"),
                BYGBlocks.BEACH_GRASS = new BYGBlockProperties.BYGBeachGrass("beach_grass"),
                BYGBlocks.LEAF_PILE = new BYGBlockProperties.BYGLeafPile("leaf_pile"),
                BYGBlocks.CLOVER_PATCH = new BYGBlockProperties.BYGLeafPile("clover_patch"),
                BYGBlocks.FLOWER_PATCH = new BYGBlockProperties.BYGLeafPile("flower_patch"),


                //Nether Blocks
                BYGBlocks.ANTHRACITE_BLOCK = new BYGBlockProperties.AnthraciteOre("anthracite_block"),
                BYGBlocks.ANTHRACITE_ORE = new BYGBlockProperties.AnthraciteOre("anthracite_ore"),

                BYGBlocks.MYCELIUM_NETHERRACK = new BYGBlockProperties.OvergrownNetherrack("mycelium_netherrack"),
                BYGBlocks.NETHER_BRISTLE = new BYGBlockProperties.BYGDoubleDamagePlant("nether_bristle"),
                BYGBlocks.MOSSY_NETHERRACK = new BYGBlockProperties.BYGNetherrack("mossy_netherrack"),

                BYGBlocks.CRIMSON_BERRY_BUSH = new BYGBlockProperties.CrimsonBerryBush("crimson_berry_bush"),
                BYGBlocks.TALL_CRIMSON_ROOTS = new BYGBlockProperties.BYGDoubleNetherPlant("tall_crimson_roots"),


                BYGBlocks.BRIMSTONE = new BYGBlockProperties.BYGNetherrack("brimstone"),
                BYGBlocks.YELLOW_NETHER_BRICKS = new BYGBlockProperties.BYGNetherrack("yellow_nether_bricks"),
                BYGBlocks.BORIC_CAMPFIRE = new BYGBlockProperties.BoricCampfire("boric_campfire"),
                BYGBlocks.BORIC_FIRE = new BYGBlockProperties.BoricFire("boric_fire"),

                BYGBlocks.HANGING_BONE = new BYGBlockProperties.HangingBones("hanging_bones"),
                BYGBlocks.QUARTZ_CRYSTAL = new BYGBlockProperties.BYGQuartzCrystal("quartz_crystal"),
                BYGBlocks.QUARTZITE_SAND = new BYGBlockProperties.BYGQuartziteSand("quartzite_sand"),
                BYGBlocks.RAW_QUARTZ_BLOCK = new BYGBlockProperties.BYGStone("raw_quartz_block"),

                BYGBlocks.WAILING_VINES = new BYGBlockProperties.WailingVines("whaling_vine"),
                BYGBlocks.WHALING_GRASS = new BYGBlockProperties.WhalingGrass("whaling_grass"),
                BYGBlocks.MAGMATIC_STONE = new BYGBlockProperties.BYGNetherrack("magmatic_stone"),
                BYGBlocks.SCORCHED_BUSH = new BYGBlockProperties.ScorchedPlant("scorched_bush"),
                BYGBlocks.SCORCHED_GRASS = new BYGBlockProperties.ScorchedPlant("scorched_grass"),

                BYGBlocks.WARPED_CACTUS = new BYGBlockProperties.BYGWarpedCacti("warped_cactus"),
                BYGBlocks.WARPED_BUSH = new BYGBlockProperties.BYGWarpedBush("warped_bush"),
                BYGBlocks.WARPED_CORAL_BLOCK = new BYGBlockProperties.BYGWarpedCoralBlock("warped_coral_block"),
                BYGBlocks.WARPED_CORAL = new BYGBlockProperties.BYGWarpedCoral("warped_coral"),
                BYGBlocks.WARPED_CORAL_FAN = new BYGBlockProperties.BYGWarpedFanCoral("warped_coral_fan"),
                BYGBlocks.WARPED_CORAL_WALL_FAN = new BYGBlockProperties.BYGWarpedWallFanCoral("warped_coral_wall_fan"),
                BYGBlocks.NYLIUM_SOUL_SAND = new BYGBlockProperties.BYGNyliumSoulSand("nylium_soul_sand"),
                BYGBlocks.NYLIUM_SOUL_SOIL = new BYGBlockProperties.BYGNyliumSoulSoil("nylium_soul_soil"),

                BYGBlocks.SYTHIAN_WART_BLOCK = new BYGBlockProperties.BYGWartBlock("sythian_wart_block"),
                BYGBlocks.SYTHIAN_ROOTS = new BYGBlockProperties.SythianPlant("sythian_roots"),
                BYGBlocks.SYTHIAN_SPROUT = new BYGBlockProperties.SythianPlant("sythian_sprout"),
                BYGBlocks.SYTHIAN_STALK_BLOCK = new BYGBlockProperties.SythianStalk("sythian_stalk_block"),
                BYGBlocks.SYTHIAN_SCAFFOLDING = new BYGBlockProperties.BYGScaffolding("sythian_scaffolding"),
                BYGBlocks.SYTHIAN_SAPLING = new BYGBlockProperties.SythianSapling("sythian_sapling"),
                BYGBlocks.HANGING_SYTHIAN_ROOTS = new BYGBlockProperties.BYGSythianHangingRoots("hanging_sythian_roots"),
                BYGBlocks.HANGING_SYTHIAN_ROOTS_PLANT = new BYGBlockProperties.BYGSythianHangingRootsPlant("hanging_sythian_roots_plant"),

                BYGBlocks.EMBUR_LILY = new BYGBlockProperties.BYGEmburLily("embur_lily"),
                BYGBlocks.EMBUR_GEL_BLOCK = new BYGBlockProperties.BYGEmburGelBlock("embur_gel_block"),
                BYGBlocks.EMBUR_GEL_VINES = new BYGBlockProperties.BYGEmburGelVine("embur_gel_vines"),
                BYGBlocks.EMBUR_SPROUTS = new BYGBlockProperties.BYGEmburPlant("embur_sprouts"),
                BYGBlocks.EMBUR_ROOTS = new BYGBlockProperties.BYGEmburPlant("embur_roots"),
                BYGBlocks.EMBUR_WART = new BYGMushroomBlock(new BYGMushroomToHugeMushroom.EmburWart(), "embur_wart"),
                BYGBlocks.TALL_EMBUR_ROOTS = new BYGBlockProperties.BYGDoubleNetherPlant("tall_embur_roots"),

                BYGBlocks.BLUE_NETHERRACK = new BYGBlockProperties.BYGBlueNetherrack("blue_netherrack"),
                BYGBlocks.BLUE_NETHERRACK_BRICKS = new BYGBlockProperties.BYGNetherrack("blue_nether_bricks"),

                //End Blocks
                BYGBlocks.IVIS_ROOTS = new BYGBlockProperties.BYGIvisPlant("ivis_roots"),
                BYGBlocks.IVIS_SPROUT = new BYGBlockProperties.BYGIvisPlant("ivis_sprout"),


                //Glowcane Blocks
                BYGBlocks.BLUE_GLOWCANE_BLOCK = new BYGBlockProperties.BYGGlowCaneBlock("blue_glowcane_block"),
                BYGBlocks.RED_GLOWCANE_BLOCK = new BYGBlockProperties.BYGGlowCaneBlock("red_glowcane_block"),
                BYGBlocks.PINK_GLOWCANE_BLOCK = new BYGBlockProperties.BYGGlowCaneBlock("pink_glowcane_block"),
                BYGBlocks.PURPLE_GLOWCANE_BLOCK = new BYGBlockProperties.BYGGlowCaneBlock("purple_glowcane_block"),

                //Decoration Blocks
                BYGBlocks.GLOWSTONE_LAMP = new BYGBlockProperties.BYGGlowCaneBlock("glowstone_lamp"),
                BYGBlocks.PERVADED_NETHERRACK = new BYGBlockProperties.BYGPervadedNetherrack("pervaded_netherrack"),
                BYGBlocks.GLOWSTONE_LANTERN = new BYGBlockProperties.BYGLantern("glowstone_lantern"),
                BYGBlocks.PACKED_BLACK_ICE = new BYGBlockProperties.BYGPackedIceBlock("packed_black_ice"),
                BYGBlocks.BLACK_ICE = new BYGBlockProperties.BYGIceBlock("black_ice"),
                BYGBlocks.FROST_MAGMA = new BYGBlockProperties.BYGFrostMagma("frost_magma"),
                BYGBlocks.SUBZERO_ASH = new BYGBlockProperties.BYGSubzeroAsh("subzero_ash"),
                BYGBlocks.SUBZERO_ASH_BLOCK = new BYGBlockProperties.BYGSubzeroAshBlock("subzero_ash_block"),
                BYGBlocks.LAMENT_SPROUTS = new BYGBlockProperties.BYGLamentPlant("lament_sprouts"),
                BYGBlocks.LAMENT_VINE = new BYGBlockProperties.BYGLamentVine("lament_vine"),
                BYGBlocks.LAMENT_VINE_PLANT = new BYGBlockProperties.BYGLamentVinePlant("lament_vine_plant"),

                BYGBlocks.PINK_CHERRY_FOLIAGE = new BYGBlockProperties.BYGLeafFoilage("pink_cherry_foliage"),
                BYGBlocks.WHITE_CHERRY_FOLIAGE = new BYGBlockProperties.BYGLeafFoilage("white_cherry_foliage"),

                //Petal Blocks
                BYGBlocks.WHITE_PETAL = new BYGBlockProperties.BYGPetal("white_petal_block"),
                BYGBlocks.RED_PETAL = new BYGBlockProperties.BYGPetal("red_petal_block"),
                BYGBlocks.PURPLE_PETAL = new BYGBlockProperties.BYGPetal("purple_petal_block"),
                BYGBlocks.BLUE_PETAL = new BYGBlockProperties.BYGPetal("blue_petal_block"),
                BYGBlocks.LIGHT_BLUE_PETAL = new BYGBlockProperties.BYGPetal("light_blue_petal_block"),
                BYGBlocks.YELLOW_PETAL = new BYGBlockProperties.BYGPetal("yellow_petal_block"),
                BYGBlocks.PLANT_STEM = new BYGBlockProperties.BYGLog("plant_stem"),
                BYGBlocks.POLLEN_BLOCK = new BYGBlockProperties.BYGPollen("pollen_block"),

                //Sand Blocks
                BYGBlocks.BLACK_SAND = new BYGBlockProperties.BYGSand(5197647, "black_sand"),
                BYGBlocks.BLACK_SANDSTONE = new BYGBlockProperties.BYGStone("black_sandstone"),
                BYGBlocks.BLACK_CHISELED_SANDSTONE = new BYGBlockProperties.BYGStone("black_chiseled_sandstone"),
                BYGBlocks.BLACK_CUT_SANDSTONE = new BYGBlockProperties.BYGStone("black_cut_sandstone"),
                BYGBlocks.BLACK_SMOOTH_SANDSTONE = new BYGBlockProperties.BYGStone("black_smooth_sandstone"),

                BYGBlocks.WHITE_SAND = new BYGBlockProperties.BYGSand(15395562, "white_sand"),
                BYGBlocks.WHITE_SANDSTONE = new BYGBlockProperties.BYGStone("white_sandstone"),
                BYGBlocks.WHITE_CHISELED_SANDSTONE = new BYGBlockProperties.BYGStone("white_chiseled_sandstone"),
                BYGBlocks.WHITE_CUT_SANDSTONE = new BYGBlockProperties.BYGStone("white_cut_sandstone"),
                BYGBlocks.WHITE_SMOOTH_SANDSTONE = new BYGBlockProperties.BYGStone("white_smooth_sandstone"),

                BYGBlocks.BLUE_SAND = new BYGBlockProperties.BYGSand(13559021, "blue_sand"),
                BYGBlocks.BLUE_SANDSTONE = new BYGBlockProperties.BYGStone("blue_sandstone"),
                BYGBlocks.BLUE_CHISELED_SANDSTONE = new BYGBlockProperties.BYGStone("blue_chiseled_sandstone"),
                BYGBlocks.BLUE_CUT_SANDSTONE = new BYGBlockProperties.BYGStone("blue_cut_sandstone"),
                BYGBlocks.BLUE_SMOOTH_SANDSTONE = new BYGBlockProperties.BYGStone("blue_smooth_sandstone"),

                BYGBlocks.PURPLE_SAND = new BYGBlockProperties.BYGSand(12887002, "purple_sand"),
                BYGBlocks.PURPLE_SANDSTONE = new BYGBlockProperties.BYGStone("purple_sandstone"),
                BYGBlocks.PURPLE_CHISELED_SANDSTONE = new BYGBlockProperties.BYGStone("purple_chiseled_sandstone"),
                BYGBlocks.PURPLE_CUT_SANDSTONE = new BYGBlockProperties.BYGStone("purple_cut_sandstone"),
                BYGBlocks.PURPLE_SMOOTH_SANDSTONE = new BYGBlockProperties.BYGStone("purple_smooth_sandstone"),

                BYGBlocks.PINK_SAND = new BYGBlockProperties.BYGSand(15585004, "pink_sand"),
                BYGBlocks.PINK_SANDSTONE = new BYGBlockProperties.BYGStone("pink_sandstone"),
                BYGBlocks.PINK_CHISELED_SANDSTONE = new BYGBlockProperties.BYGStone("pink_chiseled_sandstone"),
                BYGBlocks.PINK_CUT_SANDSTONE = new BYGBlockProperties.BYGStone("pink_cut_sandstone"),
                BYGBlocks.PINK_SMOOTH_SANDSTONE = new BYGBlockProperties.BYGStone("pink_smooth_sandstone"),

                //Log Blocks
                BYGBlocks.ASPEN_LOG = new BYGBlockProperties.BYGLog("aspen_log"),
                BYGBlocks.BAOBAB_LOG = new BYGBlockProperties.BYGLog("baobab_log"),
                BYGBlocks.BLUE_ENCHANTED_LOG = new BYGBlockProperties.BYGLog("blue_enchanted_log"),
                BYGBlocks.CHERRY_LOG = new BYGBlockProperties.BYGLog("cherry_log"),
                BYGBlocks.CIKA_LOG = new BYGBlockProperties.BYGLog("cika_log"),
                BYGBlocks.CYPRESS_LOG = new BYGBlockProperties.BYGLog("cypress_log"),
                BYGBlocks.EBONY_LOG = new BYGBlockProperties.BYGLog("ebony_log"),
                BYGBlocks.FIR_LOG = new BYGBlockProperties.BYGLog("fir_log"),
                BYGBlocks.GREEN_ENCHANTED_LOG = new BYGBlockProperties.BYGLog("green_enchanted_log"),
                BYGBlocks.HOLLY_LOG = new BYGBlockProperties.BYGLog("holly_log"),
                BYGBlocks.JACARANDA_LOG = new BYGBlockProperties.BYGLog("jacaranda_log"),
                BYGBlocks.MAHOGANY_LOG = new BYGBlockProperties.BYGLog("mahogany_log"),
                BYGBlocks.MANGROVE_LOG = new BYGBlockProperties.BYGLog("mangrove_log"),
                BYGBlocks.MAPLE_LOG = new BYGBlockProperties.BYGLog("maple_log"),
                BYGBlocks.PALO_VERDE_LOG = new BYGBlockProperties.BYGLog("palo_verde_log"),
                BYGBlocks.PINE_LOG = new BYGBlockProperties.BYGLog("pine_log"),
                BYGBlocks.RAINBOW_EUCALYPTUS_LOG = new BYGBlockProperties.BYGLog("rainbow_eucalyptus_log"),
                BYGBlocks.REDWOOD_LOG = new BYGBlockProperties.BYGLog("redwood_log"),
                BYGBlocks.SKYRIS_LOG = new BYGBlockProperties.BYGLog("skyris_log"),
                BYGBlocks.WILLOW_LOG = new BYGBlockProperties.BYGLog("willow_log"),
                BYGBlocks.WITCH_HAZEL_LOG = new BYGBlockProperties.BYGLog("witch_hazel_log"),
                BYGBlocks.ZELKOVA_LOG = new BYGBlockProperties.BYGLog("zelkova_log"),
                BYGBlocks.SYTHIAN_STEM = new BYGBlockProperties.BYGNetherLog("sythian_stem"),
                BYGBlocks.EMBUR_PEDU = new BYGBlockProperties.BYGNetherLog("embur_pedu"),
                BYGBlocks.PALM_LOG = new BYGBlockProperties.BYGLog("palm_log"),
                BYGBlocks.LAMENT_LOG = new BYGBlockProperties.BYGLog("lament_log"),
                BYGBlocks.WITHERING_OAK_LOG = new BYGBlockProperties.BYGLog("withering_oak_log"),

                BYGBlocks.ASPEN_WOOD = new BYGBlockProperties.BYGWood("aspen_wood"),
                BYGBlocks.BAOBAB_WOOD = new BYGBlockProperties.BYGWood("baobab_wood"),
                BYGBlocks.BLUE_ENCHANTED_WOOD = new BYGBlockProperties.BYGWood("blue_enchanted_wood"),
                BYGBlocks.CHERRY_WOOD = new BYGBlockProperties.BYGWood("cherry_wood"),
                BYGBlocks.CIKA_WOOD = new BYGBlockProperties.BYGWood("cika_wood"),
                BYGBlocks.CYPRESS_WOOD = new BYGBlockProperties.BYGWood("cypress_wood"),
                BYGBlocks.EBONY_WOOD = new BYGBlockProperties.BYGWood("ebony_wood"),
                BYGBlocks.FIR_WOOD = new BYGBlockProperties.BYGWood("fir_wood"),
                BYGBlocks.GREEN_ENCHANTED_WOOD = new BYGBlockProperties.BYGWood("green_enchanted_wood"),
                BYGBlocks.HOLLY_WOOD = new BYGBlockProperties.BYGWood("holly_wood"),
                BYGBlocks.JACARANDA_WOOD = new BYGBlockProperties.BYGWood("jacaranda_wood"),
                BYGBlocks.MAHOGANY_WOOD = new BYGBlockProperties.BYGWood("mahogany_wood"),
                BYGBlocks.MANGROVE_WOOD = new BYGBlockProperties.BYGWood("mangrove_wood"),
                BYGBlocks.MAPLE_WOOD = new BYGBlockProperties.BYGWood("maple_wood"),
                BYGBlocks.PALO_VERDE_WOOD = new BYGBlockProperties.BYGWood("palo_verde_wood"),
                BYGBlocks.PINE_WOOD = new BYGBlockProperties.BYGWood("pine_wood"),
                BYGBlocks.RAINBOW_EUCALYPTUS_WOOD = new BYGBlockProperties.BYGWood("rainbow_eucalyptus_wood"),
                BYGBlocks.REDWOOD_WOOD = new BYGBlockProperties.BYGWood("redwood_wood"),
                BYGBlocks.SKYRIS_WOOD = new BYGBlockProperties.BYGWood("skyris_wood"),
                BYGBlocks.WILLOW_WOOD = new BYGBlockProperties.BYGWood("willow_wood"),
                BYGBlocks.WITCH_HAZEL_WOOD = new BYGBlockProperties.BYGWood("witch_hazel_wood"),
                BYGBlocks.ZELKOVA_WOOD = new BYGBlockProperties.BYGWood("zelkova_wood"),
                BYGBlocks.SYTHIAN_HYPHAE = new BYGBlockProperties.BYGNetherWood("sythian_hyphae"),
                BYGBlocks.EMBUR_HYPHAE = new BYGBlockProperties.BYGNetherWood("embur_hyphae"),
                BYGBlocks.PALM_WOOD = new BYGBlockProperties.BYGWood("palm_wood"),
                BYGBlocks.LAMENT_WOOD = new BYGBlockProperties.BYGWood("lament_wood"),
                BYGBlocks.WITHERING_OAK_WOOD = new BYGBlockProperties.BYGWood("withering_oak_wood"),

                //Mushroom Blocks
                BYGBlocks.BLACK_PUFF = new BYGMushroomBlock(new BYGMushroomToHugeMushroom.BlackPuff(), "black_puff"),
                BYGBlocks.WEEPING_MILKCAP = new BYGMushroomBlock(new BYGMushroomToHugeMushroom.WeepingMilkCap(), "weeping_milkcap"),
                BYGBlocks.WOOD_BLEWIT = new BYGMushroomBlock(new BYGMushroomToHugeMushroom.WoodBlewit(), "wood_blewit"),
                BYGBlocks.GREEN_MUSHROOM = new BYGMushroomBlock(new BYGMushroomToHugeMushroom.GreenMushroom(), "green_mushroom"),
                BYGBlocks.BLUE_GLOWSHROOM = new BYGMushroomBlock(new BYGMushroomToHugeMushroom.BlueGlowshroom(), "blue_glowshroom"),
                BYGBlocks.PURPLE_GLOWSHROOM = new BYGMushroomBlock(new BYGMushroomToHugeMushroom.PurpleGlowshroom(), "purple_glowshroom"),

                BYGBlocks.SYTHIAN_FUNGUS = new BYGMushroomBlock(new BYGMushroomToHugeMushroom.SythianFungus(), "sythian_fungus"),
                BYGBlocks.SOUL_SHROOM = new BYGMushroomBlock(new BYGMushroomToHugeMushroom.SoulShroom(), "soul_shroom"),
                BYGBlocks.DEATH_CAP = new BYGMushroomBlock(new BYGMushroomToHugeMushroom.DeathCap(), "death_cap"),


                BYGBlocks.SOUL_SHROOM_SPORE = new BYGBlockProperties.BYGSoulShroomSpore("soul_shroom_spore"),
                BYGBlocks.SOUL_SHROOM_SPORE_END = new BYGBlockProperties.BYGSoulShroomSporeEnd("soul_shroom_spore_end"),

                //Ore Blocks
                BYGBlocks.PENDORITE_ORE = new BYGBlockProperties.BYGOrePendorite("pendorite_ore"),
                BYGBlocks.AMETRINE_ORE = new BYGBlockProperties.BYGOreAmetrine("ametrine_ore"),
                BYGBlocks.PENDORITE_BLOCK = new BYGBlockProperties.BYGOrePendorite("pendorite_block"),
                BYGBlocks.AMETRINE_BLOCK = new BYGBlockProperties.BYGOreAmetrine("ametrine_block"),

                //StoneBlocks
                BYGBlocks.DACITE = new BYGBlockProperties.BYGStone("dacite"),
                BYGBlocks.DACITE_SLAB = new BYGBlockProperties.BYGStoneSlab("dacite_slab"),
                BYGBlocks.DACITE_STAIRS = new BYGBlockProperties.BYGStoneStairs("dacite_stairs"),
                BYGBlocks.DACITE_WALL = new BYGBlockProperties.BYGStoneWall("dacite_wall"),
                BYGBlocks.DACITE_BRICKS = new BYGBlockProperties.BYGStone("dacite_bricks"),
                BYGBlocks.DACITE_BRICK_SLAB = new BYGBlockProperties.BYGStoneSlab("dacite_brick_slab"),
                BYGBlocks.DACITE_BRICK_STAIRS = new BYGBlockProperties.BYGStoneStairs("dacite_brick_stairs"),
                BYGBlocks.DACITE_BRICK_WALL = new BYGBlockProperties.BYGStoneWall("dacite_brick_wall"),
                BYGBlocks.DACITE_COBBLESTONE = new BYGBlockProperties.BYGStone("dacite_cobblestone"),
                BYGBlocks.DACITE_COBBLESTONE_SLAB = new BYGBlockProperties.BYGStoneSlab("dacite_cobblestone_slab"),
                BYGBlocks.DACITE_COBBLESTONE_STAIRS = new BYGBlockProperties.BYGStoneStairs("dacite_cobblestone_stairs"),
                BYGBlocks.DACITE_COBBLESTONE_WALL = new BYGBlockProperties.BYGStoneWall("dacite_cobblestone_wall"),
                BYGBlocks.DACITE_PILLAR = new BYGBlockProperties.BYGPillar("dacite_pillar"),
                BYGBlocks.DACITE_TILE = new BYGBlockProperties.BYGStone("dacite_tile"),
                BYGBlocks.DACITE_TILE_SLAB = new BYGBlockProperties.BYGStoneSlab("dacite_tile_slab"),
                BYGBlocks.DACITE_TILE_STAIRS = new BYGBlockProperties.BYGStoneStairs("dacite_tile_stairs"),
                BYGBlocks.DACITE_TILE_WALL = new BYGBlockProperties.BYGStoneWall("dacite_tile_wall"),

                BYGBlocks.RED_ROCK = new BYGBlockProperties.BYGStone("red_rock"),
                BYGBlocks.RED_ROCK_SLAB = new BYGBlockProperties.BYGStoneSlab("red_rock_slab"),
                BYGBlocks.RED_ROCK_STAIRS = new BYGBlockProperties.BYGStoneStairs("red_rock_stairs"),
                BYGBlocks.RED_ROCK_WALL = new BYGBlockProperties.BYGStoneWall("red_rock_wall"),
                BYGBlocks.RED_ROCK_BRICKS = new BYGBlockProperties.BYGStone("red_rock_bricks"),
                BYGBlocks.RED_ROCK_BRICK_SLAB = new BYGBlockProperties.BYGStoneSlab("red_rock_brick_slab"),
                BYGBlocks.RED_ROCK_BRICK_STAIRS = new BYGBlockProperties.BYGStoneStairs("red_rock_brick_stairs"),
                BYGBlocks.RED_ROCK_BRICK_WALL = new BYGBlockProperties.BYGStoneWall("red_rock_brick_wall"),
                BYGBlocks.CRACKED_RED_ROCK_BRICKS = new BYGBlockProperties.BYGStone("cracked_red_rock_bricks"),
                BYGBlocks.CRACKED_RED_ROCK_BRICK_SLAB = new BYGBlockProperties.BYGStoneSlab("cracked_red_rock_brick_slab"),
                BYGBlocks.CRACKED_RED_ROCK_BRICK_STAIRS = new BYGBlockProperties.BYGStoneStairs("cracked_red_rock_brick_stairs"),
                BYGBlocks.CRACKED_RED_ROCK_BRICK_WALL = new BYGBlockProperties.BYGStoneWall("cracked_red_rock_brick_wall"),
                BYGBlocks.CHISELED_RED_ROCK_BRICKS = new BYGBlockProperties.BYGStone("chiseled_red_rock_bricks"),
                BYGBlocks.CHISELED_RED_ROCK_BRICK_SLAB = new BYGBlockProperties.BYGStoneSlab("chiseled_red_rock_brick_slab"),
                BYGBlocks.CHISELED_RED_ROCK_BRICK_STAIRS = new BYGBlockProperties.BYGStoneStairs("chiseled_red_rock_brick_stairs"),
                BYGBlocks.CHISELED_RED_ROCK_BRICK_WALL = new BYGBlockProperties.BYGStoneWall("chiseled_red_rock_brick_wall"),
                BYGBlocks.MOSSY_RED_ROCK_BRICKS = new BYGBlockProperties.BYGStone("mossy_red_rock_bricks"),
                BYGBlocks.MOSSY_RED_ROCK_BRICK_SLAB = new BYGBlockProperties.BYGStoneSlab("mossy_red_rock_brick_slab"),
                BYGBlocks.MOSSY_RED_ROCK_BRICK_STAIRS = new BYGBlockProperties.BYGStoneStairs("mossy_red_rock_brick_stairs"),
                BYGBlocks.MOSSY_RED_ROCK_BRICK_WALL = new BYGBlockProperties.BYGStoneWall("mossy_red_rock_brick_wall"),

                BYGBlocks.MOSSY_STONE = new BYGBlockProperties.BYGStone("mossy_stone"),
                BYGBlocks.MOSSY_STONE_SLAB = new BYGBlockProperties.BYGStoneSlab("mossy_stone_slab"),
                BYGBlocks.MOSSY_STONE_STAIRS = new BYGBlockProperties.BYGStoneStairs("mossy_stone_stairs"),
                BYGBlocks.MOSSY_STONE_WALL = new BYGBlockProperties.BYGStoneWall("mossy_stone_wall"),

                BYGBlocks.PODZOL_DACITE = new BYGBlockProperties.BlockOvergrownDaciteBlock("podzol_dacite"),
//                BYGBlocks.DACITE_FARMLAND = new BYGBlockProperties.BYGDaciteFarmland("dacite_farmland"),
//                BYGBlocks.STONE_FARMLAND = new BYGBlockProperties.BYGStoneFarmland("stone_farmland"),
                BYGBlocks.ROCKY_STONE = new BYGBlockProperties.BYGStone("rocky_stone"),
                BYGBlocks.ROCKY_SLAB = new BYGBlockProperties.BYGStoneSlab("rocky_stone_slab"),
                BYGBlocks.ROCKY_STAIRS = new BYGBlockProperties.BYGStoneStairs("rocky_stone_stairs"),
                BYGBlocks.ROCKY_WALL = new BYGBlockProperties.BYGStoneWall("rocky_stone_wall"),

                BYGBlocks.SCORIA_STONE = new BYGBlockProperties.BYGStone("scoria_stone"),
                BYGBlocks.SCORIA_SLAB = new BYGBlockProperties.BYGStoneSlab("scoria_stone_slab"),
                BYGBlocks.SCORIA_STAIRS = new BYGBlockProperties.BYGStoneStairs("scoria_stone_stairs"),
                BYGBlocks.SCORIA_WALL = new BYGBlockProperties.BYGStoneWall("scoria_stone_wall"),
                BYGBlocks.SCORIA_COBBLESTONE = new BYGBlockProperties.BYGStone("scoria_cobblestone"),
                BYGBlocks.SCORIA_COBBLESTONE_SLAB = new BYGBlockProperties.BYGStoneSlab("scoria_cobblestone_slab"),
                BYGBlocks.SCORIA_COBBLESTONE_STAIRS = new BYGBlockProperties.BYGStoneStairs("scoria_cobblestone_stairs"),
                BYGBlocks.SCORIA_COBBLESTONE_WALL = new BYGBlockProperties.BYGStoneWall("scoria_cobblestone_wall"),
                BYGBlocks.SCORIA_PILLAR = new BYGBlockProperties.BYGPillar("scoria_pillar"),
                BYGBlocks.SCORIA_STONEBRICKS = new BYGBlockProperties.BYGStone("scoria_stonebricks"),
                BYGBlocks.SCORIA_STONEBRICK_SLAB = new BYGBlockProperties.BYGStoneSlab("scoria_stonebrick_slab"),
                BYGBlocks.SCORIA_STONEBRICK_STAIRS = new BYGBlockProperties.BYGStoneStairs("scoria_stonebrick_stairs"),
                BYGBlocks.SCORIA_STONEBRICK_WALL = new BYGBlockProperties.BYGStoneWall("scoria_stonebrick_wall"),

                BYGBlocks.SOAPSTONE = new BYGBlockProperties.BYGStone("soapstone"),
                BYGBlocks.SOAPSTONE_SLAB = new BYGBlockProperties.BYGStoneSlab("soapstone_slab"),
                BYGBlocks.SOAPSTONE_STAIRS = new BYGBlockProperties.BYGStoneStairs("soapstone_stairs"),
                BYGBlocks.SOAPSTONE_WALL = new BYGBlockProperties.BYGStoneWall("soapstone_wall"),
                BYGBlocks.POLISHED_SOAPSTONE = new BYGBlockProperties.BYGStone("polished_soapstone"),
                BYGBlocks.POLISHED_SOAPSTONE_SLAB = new BYGBlockProperties.BYGStoneSlab("polished_soapstone_slab"),
                BYGBlocks.POLISHED_SOAPSTONE_STAIRS = new BYGBlockProperties.BYGStoneStairs("polished_soapstone_stairs"),
                BYGBlocks.POLISHED_SOAPSTONE_WALL = new BYGBlockProperties.BYGStoneWall("polished_soapstone_wall"),
                BYGBlocks.SOAPSTONE_BRICKS = new BYGBlockProperties.BYGStone("soapstone_bricks"),
                BYGBlocks.SOAPSTONE_BRICK_SLAB = new BYGBlockProperties.BYGStoneSlab("soapstone_brick_slab"),
                BYGBlocks.SOAPSTONE_BRICK_STAIRS = new BYGBlockProperties.BYGStoneStairs("soapstone_brick_stairs"),
                BYGBlocks.SOAPSTONE_BRICK_WALL = new BYGBlockProperties.BYGStoneWall("soapstone_brick_wall"),
                BYGBlocks.SOAPSTONE_PILLAR = new BYGBlockProperties.BYGPillar("soapstone_pillar"),
                BYGBlocks.SOAPSTONE_TILE = new BYGBlockProperties.BYGStone("soapstone_tile"),
                BYGBlocks.SOAPSTONE_TILE_SLAB = new BYGBlockProperties.BYGStoneSlab("soapstone_tile_slab"),
                BYGBlocks.SOAPSTONE_TILE_STAIRS = new BYGBlockProperties.BYGStoneStairs("soapstone_tile_stairs"),
                BYGBlocks.SOAPSTONE_TILE_WALL = new BYGBlockProperties.BYGStoneWall("soapstone_tile_wall"),

                //Stripped Log Blocks
                BYGBlocks.STRIPPED_ASPEN_LOG = new BYGBlockProperties.BYGStrippedLog("stripped_aspen_log"),
                BYGBlocks.STRIPPED_BAOBAB_LOG = new BYGBlockProperties.BYGStrippedLog("stripped_baobab_log"),
                BYGBlocks.STRIPPED_BLUE_ENCHANTED_LOG = new BYGBlockProperties.BYGStrippedLog("stripped_blue_enchanted_log"),
                BYGBlocks.STRIPPED_CHERRY_LOG = new BYGBlockProperties.BYGStrippedLog("stripped_cherry_log"),
                BYGBlocks.STRIPPED_CIKA_LOG = new BYGBlockProperties.BYGStrippedLog("stripped_cika_log"),
                BYGBlocks.STRIPPED_CYPRESS_LOG = new BYGBlockProperties.BYGStrippedLog("stripped_cypress_log"),
                BYGBlocks.STRIPPED_EBONY_LOG = new BYGBlockProperties.BYGStrippedLog("stripped_ebony_log"),
                BYGBlocks.STRIPPED_FIR_LOG = new BYGBlockProperties.BYGStrippedLog("stripped_fir_log"),
                BYGBlocks.STRIPPED_GREEN_ENCHANTED_LOG = new BYGBlockProperties.BYGStrippedLog("stripped_green_enchanted_log"),
                BYGBlocks.STRIPPED_HOLLY_LOG = new BYGBlockProperties.BYGStrippedLog("stripped_holly_log"),
                BYGBlocks.STRIPPED_JACARANDA_LOG = new BYGBlockProperties.BYGStrippedLog("stripped_jacaranda_log"),
                BYGBlocks.STRIPPED_MAHOGANY_LOG = new BYGBlockProperties.BYGStrippedLog("stripped_mahogany_log"),
                BYGBlocks.STRIPPED_MANGROVE_LOG = new BYGBlockProperties.BYGStrippedLog("stripped_mangrove_log"),
                BYGBlocks.STRIPPED_MAPLE_LOG = new BYGBlockProperties.BYGStrippedLog("stripped_maple_log"),
                BYGBlocks.STRIPPED_PALO_VERDE_LOG = new BYGBlockProperties.BYGStrippedLog("stripped_palo_verde_log"),
                BYGBlocks.STRIPPED_PINE_LOG = new BYGBlockProperties.BYGStrippedLog("stripped_pine_log"),
                BYGBlocks.STRIPPED_RAINBOW_EUCALYPTUS_LOG = new BYGBlockProperties.BYGStrippedLog("stripped_rainbow_eucalyptus_log"),
                BYGBlocks.STRIPPED_SKYRIS_LOG = new BYGBlockProperties.BYGStrippedLog("stripped_skyris_log"),
                BYGBlocks.STRIPPED_WILLOW_LOG = new BYGBlockProperties.BYGStrippedLog("stripped_willow_log"),
                BYGBlocks.STRIPPED_REDWOOD_LOG = new BYGBlockProperties.BYGStrippedLog("stripped_redwood_log"),
                BYGBlocks.STRIPPED_WITCH_HAZEL_LOG = new BYGBlockProperties.BYGStrippedLog("stripped_witch_hazel_log"),
                BYGBlocks.STRIPPED_ZELKOVA_LOG = new BYGBlockProperties.BYGStrippedLog("stripped_zelkova_log"),
                BYGBlocks.STRIPPED_SYTHIAN_STEM = new BYGBlockProperties.BYGNetherLog("stripped_sythian_stem"),
                BYGBlocks.STRIPPED_EMBUR_PEDU = new BYGBlockProperties.BYGNetherLog("stripped_embur_pedu"),
                BYGBlocks.STRIPPED_PALM_LOG = new BYGBlockProperties.BYGStrippedLog("stripped_palm_log"),
                BYGBlocks.STRIPPED_LAMENT_LOG = new BYGBlockProperties.BYGStrippedLog("stripped_lament_log"),

                //Stripped Wood Blocks
                BYGBlocks.STRIPPED_ASPEN_WOOD = new BYGBlockProperties.BYGWood("stripped_aspen_wood"),
                BYGBlocks.STRIPPED_BAOBAB_WOOD = new BYGBlockProperties.BYGWood("stripped_baobab_wood"),
                BYGBlocks.STRIPPED_BLUE_ENCHANTED_WOOD = new BYGBlockProperties.BYGWood("stripped_blue_enchanted_wood"),
                BYGBlocks.STRIPPED_CHERRY_WOOD = new BYGBlockProperties.BYGWood("stripped_cherry_wood"),
                BYGBlocks.STRIPPED_CIKA_WOOD = new BYGBlockProperties.BYGWood("stripped_cika_wood"),
                BYGBlocks.STRIPPED_CYPRESS_WOOD = new BYGBlockProperties.BYGWood("stripped_cypress_wood"),
                BYGBlocks.STRIPPED_EBONY_WOOD = new BYGBlockProperties.BYGWood("stripped_ebony_wood"),
                BYGBlocks.STRIPPED_FIR_WOOD = new BYGBlockProperties.BYGWood("stripped_fir_wood"),
                BYGBlocks.STRIPPED_GREEN_ENCHANTED_WOOD = new BYGBlockProperties.BYGWood("stripped_green_enchanted_wood"),
                BYGBlocks.STRIPPED_HOLLY_WOOD = new BYGBlockProperties.BYGWood("stripped_holly_wood"),
                BYGBlocks.STRIPPED_JACARANDA_WOOD = new BYGBlockProperties.BYGWood("stripped_jacaranda_wood"),
                BYGBlocks.STRIPPED_MAHOGANY_WOOD = new BYGBlockProperties.BYGWood("stripped_mahogany_wood"),
                BYGBlocks.STRIPPED_MANGROVE_WOOD = new BYGBlockProperties.BYGWood("stripped_mangrove_wood"),
                BYGBlocks.STRIPPED_MAPLE_WOOD = new BYGBlockProperties.BYGWood("stripped_maple_wood"),
                BYGBlocks.STRIPPED_PALO_VERDE_WOOD = new BYGBlockProperties.BYGWood("stripped_palo_verde_wood"),
                BYGBlocks.STRIPPED_PINE_WOOD = new BYGBlockProperties.BYGWood("stripped_pine_wood"),
                BYGBlocks.STRIPPED_RAINBOW_EUCALYPTUS_WOOD = new BYGBlockProperties.BYGWood("stripped_rainbow_eucalyptus_wood"),
                BYGBlocks.STRIPPED_SKYRIS_WOOD = new BYGBlockProperties.BYGWood("stripped_skyris_wood"),
                BYGBlocks.STRIPPED_WILLOW_WOOD = new BYGBlockProperties.BYGWood("stripped_willow_wood"),
                BYGBlocks.STRIPPED_REDWOOD_WOOD = new BYGBlockProperties.BYGWood("stripped_redwood_wood"),
                BYGBlocks.STRIPPED_WITCH_HAZEL_WOOD = new BYGBlockProperties.BYGWood("stripped_witch_hazel_wood"),
                BYGBlocks.STRIPPED_ZELKOVA_WOOD = new BYGBlockProperties.BYGWood("stripped_zelkova_wood"),
                BYGBlocks.STRIPPED_SYTHIAN_HYPHAE = new BYGBlockProperties.BYGNetherWood("stripped_sythian_hyphae"),
                BYGBlocks.STRIPPED_EMBUR_HYPHAE = new BYGBlockProperties.BYGNetherWood("stripped_embur_hyphae"),
                BYGBlocks.STRIPPED_PALM_WOOD = new BYGBlockProperties.BYGWood("stripped_palm_wood"),
                BYGBlocks.STRIPPED_LAMENT_WOOD = new BYGBlockProperties.BYGWood("stripped_lament_wood"),

                //Flower Blocks
                BYGBlocks.TALL_ALLIUM = new BYGBlockProperties.BYGDoublePlant("tall_allium"),
                BYGBlocks.TALL_PINK_ALLIUM = new BYGBlockProperties.BYGDoublePlant("tall_pink_allium"),
                BYGBlocks.ALLIUM_FLOWER_BUSH = new BYGBlockProperties.BYGAllium("allium_flower_bush"),
                BYGBlocks.ALPINE_BELLFLOWER = new BYGBlockProperties.BYGFlower("alpine_bellflower"),
                BYGBlocks.AMARANTH = new BYGBlockProperties.BYGAmaranth("amaranth"),
                BYGBlocks.ANGELICA = new BYGBlockProperties.BYGFlower("angelica"),
                BYGBlocks.AZALEA = new BYGBlockProperties.BYGDoublePlant("azalea"),
                BYGBlocks.BEGONIA = new BYGBlockProperties.BYGFlower("begonia"),
                BYGBlocks.BISTORT = new BYGBlockProperties.BYGFlower("bistort"),
                BYGBlocks.BLUE_SAGE = new BYGBlockProperties.BYGFlower("blue_sage"),
                BYGBlocks.CALIFORNIA_POPPY = new BYGBlockProperties.BYGFlower("california_poppy"),
                BYGBlocks.CROCUS = new BYGBlockProperties.BYGFlower("crocus"),
                BYGBlocks.BLACK_ROSE = new BYGBlockProperties.BYGFlower("black_rose"),
                BYGBlocks.CYAN_AMARANTH = new BYGBlockProperties.BYGAmaranth("cyan_amaranth"),
                BYGBlocks.CYAN_ROSE = new BYGBlockProperties.BYGFlower("cyan_rose"),
                BYGBlocks.CYAN_TULIP = new BYGBlockProperties.BYGFlower("cyan_tulip"),
                BYGBlocks.DAFFODIL = new BYGBlockProperties.BYGFlower("daffodil"),
                BYGBlocks.DELPHINIUM = new BYGBlockProperties.BYGDoublePlant("delphinium"),
                BYGBlocks.FAIRY_SLIPPER = new BYGBlockProperties.BYGFairySlipperFlower("fairy_slipper"),
                BYGBlocks.FIRECRACKER_FLOWER_BUSH = new BYGBlockProperties.BYGFlower("firecracker_flower_bush"),
                BYGBlocks.FOXGLOVE = new BYGBlockProperties.BYGDoublePlant("foxglove"),
                BYGBlocks.GOLDEN_SPINED_CACTUS = new BYGBlockProperties.BYGDesertPlant("golden_spined_cactus"),
                BYGBlocks.GREEN_TULIP = new BYGBlockProperties.BYGFlower("green_tulip"),
                BYGBlocks.GUZMANIA = new BYGBlockProperties.BYGFlower("guzmania"),
                BYGBlocks.INCAN_LILY = new BYGBlockProperties.BYGFlower("incan_lily"),
                BYGBlocks.IRIS = new BYGBlockProperties.BYGFlower("iris"),
                BYGBlocks.JAPANESE_ORCHID = new BYGBlockProperties.BYGDoublePlant("japanese_orchid"),
                BYGBlocks.KOVAN_FLOWER = new BYGBlockProperties.BYGFlower("kovan_flower"),
                BYGBlocks.LAZARUS_BELLFLOWER = new BYGBlockProperties.BYGFlower("lazarus_bellflower"),
                BYGBlocks.LOLIPOP_FLOWER = new BYGBlockProperties.BYGFlower("lolipop_flower"),
                BYGBlocks.MAGENTA_AMARANTH = new BYGBlockProperties.BYGAmaranth("magenta_amaranth"),
                BYGBlocks.MAGENTA_TULIP = new BYGBlockProperties.BYGFlower("magenta_tulip"),
                BYGBlocks.ORANGE_AMARANTH = new BYGBlockProperties.BYGAmaranth("orange_amaranth"),
                BYGBlocks.ORANGE_DAISY = new BYGBlockProperties.BYGFlower("orange_daisy"),
                BYGBlocks.ORSIRIA_ROSE = new BYGBlockProperties.BYGFlower("osiria_rose"),
                BYGBlocks.PEACH_LEATHER_FLOWER = new BYGBlockProperties.BYGFlower("peach_leather_flower"),
                BYGBlocks.PINK_ALLIUM = new BYGBlockProperties.BYGFlower("pink_allium"),
                BYGBlocks.PINK_ALLIUM_FLOWER_BUSH = new BYGBlockProperties.BYGPinkAllium("pink_allium_flower_bush"),
                BYGBlocks.PINK_ANEMONE = new BYGBlockProperties.BYGFlower("pink_anemone"),
                BYGBlocks.PINK_DAFFODIL = new BYGBlockProperties.BYGFlower("pink_daffodil"),
                BYGBlocks.PINK_ORCHID = new BYGBlockProperties.BYGFlower("pink_orchid"),
                BYGBlocks.PRAIRIE_GRASS = new BYGBlockProperties.BYGPrairieGrass("prairie_grass"),
                BYGBlocks.PROTEA_FLOWER = new BYGBlockProperties.BYGFlower("protea_flower"),
                BYGBlocks.PURPLE_AMARANTH = new BYGBlockProperties.BYGAmaranth("purple_amaranth"),
                BYGBlocks.PURPLE_ORCHID = new BYGBlockProperties.BYGFlower("purple_orchid"),
                BYGBlocks.PURPLE_SAGE = new BYGBlockProperties.BYGFlower("purple_sage"),
                BYGBlocks.PURPLE_TULIP = new BYGBlockProperties.BYGFlower("purple_tulip"),
                BYGBlocks.RED_CORNFLOWER = new BYGBlockProperties.BYGFlower("red_cornflower"),
                BYGBlocks.RED_ORCHID = new BYGBlockProperties.BYGFlower("red_orchid"),
                BYGBlocks.RICHEA = new BYGBlockProperties.BYGFlower("richea"),
                BYGBlocks.ROSE = new BYGBlockProperties.BYGFlower("rose"),
                BYGBlocks.SNOWDROPS = new BYGBlockProperties.BYGSnowyPlant("snowdrops"),
                BYGBlocks.SILVER_VASE_FLOWER = new BYGBlockProperties.BYGFlower("silver_vase_flower"),
                BYGBlocks.TORCH_GINGER = new BYGBlockProperties.BYGFlower("torch_ginger"),
                BYGBlocks.VIOLET_LEATHER_FLOWER = new BYGBlockProperties.BYGFlower("violet_leather_flower"),
                BYGBlocks.WHITE_ANEMONE = new BYGBlockProperties.BYGFlower("white_anemone"),
                BYGBlocks.WHITE_SAGE = new BYGBlockProperties.BYGFlower("white_sage"),
                BYGBlocks.WINTER_CYCLAMEN = new BYGBlockProperties.BYGSnowyPlant("winter_cyclamen"),
                BYGBlocks.WINTER_ROSE = new BYGBlockProperties.BYGSnowyPlant("winter_rose"),
                BYGBlocks.WINTER_SCILLA = new BYGBlockProperties.BYGSnowyPlant("winter_scilla"),
                BYGBlocks.YELLOW_DAFFODIL = new BYGBlockProperties.BYGFlower("yellow_daffodil"),
                BYGBlocks.YELLOW_TULIP = new BYGBlockProperties.BYGFlower("yellow_tulip"),

                //Register Spreadable blocks last.
                BYGBlocks.OVERGROWN_DACITE = new BYGBlockProperties.BlockOvergrownDaciteBlock("overgrown_dacite"),
                BYGBlocks.OVERGROWN_STONE = new BYGBlockProperties.BlockOvergrownStoneBlock("overgrown_stone"),
                BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE = new BYGBlockProperties.OvergrownCrimsonBlackstone("overgrown_crimson_blackstone"),
                BYGBlocks.OVERGROWN_NETHERRACK = new BYGBlockProperties.OvergrownNetherrack("overgrown_netherrack"),
                BYGBlocks.IVIS_PHYLIUM = new BYGBlockProperties.BYGIvisPhylium("ivis_phylium"),
                BYGBlocks.EMBUR_NYLIUM = new BYGBlockProperties.BYGEmberNylium("embur_nylium"),
                BYGBlocks.SYTHIAN_NYLIUM = new BYGBlockProperties.BYGSythianNylium("sythian_nylium"),
                BYGBlocks.MEADOW_GRASSBLOCK = new BYGBlockProperties.BYGMeadowGrass("meadow_grass_block")
        );

        BYG.LOGGER.info("BYG: Blocks Registered!");
    }
}
