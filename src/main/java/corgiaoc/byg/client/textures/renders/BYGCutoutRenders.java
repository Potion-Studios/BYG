package corgiaoc.byg.client.textures.renders;

import corgiaoc.byg.BYG;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class BYGCutoutRenders {
    public static void renderCutOuts() {
        BYG.LOGGER.debug("BYG: Rendering Texture Cutouts...");

        //Plants
        RenderTypeLookup.setRenderLayer(BYGBlocks.HORSEWEED, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUE_SAGE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MINI_CACTUS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PRICKLY_PEAR_CACTUS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WINTER_SUCCULENT, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GLOWSTONE_LANTERN, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.NETHER_BRISTLE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WEEPING_ROOTS_PLANT, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WEEPING_ROOTS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINK_CHERRY_FOLIAGE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WHITE_CHERRY_FOLIAGE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.TALL_PINK_ALLIUM, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.TALL_ALLIUM, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_ROOTS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.TALL_EMBUR_ROOTS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_WART, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_GEL_BLOCK, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_GEL_VINES, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_GEL_VINES_PLANT, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_GEL_BRANCH, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_SPROUTS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_LILY, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.HANGING_BONE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.QUARTZ_CRYSTAL, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WAILING_BELL_BLOSSOM, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WAILING_GRASS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WAILING_VINES, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SCORCHED_BUSH, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SCORCHED_GRASS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BORIC_CAMPFIRE, RenderType.cutoutMipped());
        //Nether
        RenderTypeLookup.setRenderLayer(BYGBlocks.OVERGROWN_NETHERRACK, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MOSSY_NETHERRACK, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SOUL_SHROOM_SPORE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SOUL_SHROOM_SPORE_END, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SOUL_SHROOM, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.DEATH_CAP, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LAMENT_VINE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LAMENT_VINE_PLANT, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LAMENT_SPROUTS, RenderType.cutoutMipped());

        RenderTypeLookup.setRenderLayer(BYGBlocks.SUBZERO_CRYSTAL_CLUSTER, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LARGE_SUBZERO_CRYSTAL_BUD, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MEDIUM_SUBZERO_CRYSTAL_BUD, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SMALL_SUBZERO_CRYSTAL_BUD, RenderType.cutoutMipped());

        RenderTypeLookup.setRenderLayer(BYGBlocks.ARISIAN_BLOOM_BRANCH, RenderType.cutoutMipped());

        RenderTypeLookup.setRenderLayer(BYGBlocks.TALL_CRIMSON_ROOTS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CRIMSON_BERRY_BUSH, RenderType.cutoutMipped());

        RenderTypeLookup.setRenderLayer(BYGBlocks.WARPED_BUSH, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WARPED_CACTUS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WARPED_CORAL_FAN, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WARPED_CORAL, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WARPED_CORAL_WALL_FAN, RenderType.cutoutMipped());

        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_ROOTS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_SPROUT, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_STALK_BLOCK, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_NYLIUM, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.HANGING_SYTHIAN_ROOTS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.HANGING_SYTHIAN_ROOTS_PLANT, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_FUNGUS, RenderType.cutoutMipped());

        //End
        RenderTypeLookup.setRenderLayer(BYGBlocks.IVIS_ROOTS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.IVIS_SPROUT, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.NIGHTSHADE_SPROUTS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ETHER_BUSH, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ETHER_GRASS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.THEREAL_BELLFLOWER, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ETHER_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.NIGHTSHADE_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_BULBIS_ODDITY, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_BULBIS_SHELL, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BULBIS_ODDITY, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BULBIS_SHELL, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.NIGHTSHADE_BERRY_BUSH, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.NIGHTSHADE_ROOTS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.VERMILION_SCULK_GROWTH, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.THERIUM_LANTERN, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ODDITY_CACTUS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ODDITY_BUSH, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.THERIUM_CRYSTAL, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SHULKREN_MOSS_BLANKET, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SHULKREN_FUNGUS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SHULKREN_VINE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SHULKREN_VINE_PLANT, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CRYPTIC_CAMPFIRE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ENDER_LILY, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CRYPTIC_BRAMBLE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FUNGAL_IMPARIUS_FILAMENT, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.IMPARIUS_MUSHROOM, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FUNGAL_IMPARIUS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.IMPARIUS_VINE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.IMPARIUS_VINE_PLANT, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.IMPARIUS_MUSHROOM_BRANCH, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.IMPARIUS_BUSH, RenderType.cutoutMipped());

        //Sea Plants
        RenderTypeLookup.setRenderLayer(BYGBlocks.CATTAIL, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.REEDS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.TINY_LILYPADS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WATER_SILK, RenderType.translucent());

        //GlowCane
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUE_GLOWCANE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINK_GLOWCANE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_GLOWCANE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RED_GLOWCANE, RenderType.cutoutMipped());

        //Doors
        RenderTypeLookup.setRenderLayer(BYGBlocks.ASPEN_DOOR, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BAOBAB_DOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUE_ENCHANTED_DOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CHERRY_DOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CIKA_DOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CYPRESS_DOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EBONY_DOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FIR_DOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GREEN_ENCHANTED_DOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.HOLLY_DOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.JACARANDA_DOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MAHOGANY_DOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MANGROVE_DOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MAPLE_DOOR, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PALM_DOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINE_DOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RAINBOW_EUCALYPTUS_DOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.REDWOOD_DOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SKYRIS_DOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WILLOW_DOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WITCH_HAZEL_DOOR, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ZELKOVA_DOOR, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_DOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_DOOR, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LAMENT_DOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BULBIS_DOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ETHER_DOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.NIGHTSHADE_DOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.IMPARIUS_DOOR, RenderType.cutoutMipped());

        //Trapdoors
        RenderTypeLookup.setRenderLayer(BYGBlocks.ASPEN_TRAPDOOR, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BAOBAB_TRAPDOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUE_ENCHANTED_TRAPDOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CHERRY_TRAPDOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CIKA_TRAPDOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CYPRESS_TRAPDOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EBONY_TRAPDOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FIR_TRAPDOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GREEN_ENCHANTED_TRAPDOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.HOLLY_TRAPDOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.JACARANDA_TRAPDOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MAHOGANY_TRAPDOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MANGROVE_TRAPDOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MAPLE_TRAPDOOR, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PALM_TRAPDOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINE_TRAPDOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RAINBOW_EUCALYPTUS_TRAPDOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.REDWOOD_TRAPDOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SKYRIS_TRAPDOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WILLOW_TRAPDOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WITCH_HAZEL_TRAPDOOR, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ZELKOVA_TRAPDOOR, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_TRAPDOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_TRAPDOOR, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LAMENT_TRAPDOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BULBIS_TRAPDOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ETHER_TRAPDOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.NIGHTSHADE_TRAPDOOR, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.IMPARIUS_TRAPDOOR, RenderType.cutoutMipped());

        //Grass
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.TALL_PRAIRIE_GRASS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PRAIRIE_GRASS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SHORT_GRASS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WINTER_GRASS, RenderType.translucent());

        RenderTypeLookup.setRenderLayer(BYGBlocks.SHORT_BEACH_GRASS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BEACH_GRASS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WILTED_GRASS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WEED_GRASS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LEAF_PILE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CLOVER_PATCH, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FLOWER_PATCH, RenderType.cutoutMipped());


        //Saplings
        RenderTypeLookup.setRenderLayer(BYGBlocks.ASPEN_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BAOBAB_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUE_ENCHANTED_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUE_SPRUCE_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BROWN_BIRCH_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BROWN_OAK_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CYPRESS_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CIKA_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EBONY_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FIR_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GREEN_ENCHANTED_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.HOLLY_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.JACARANDA_BUSH, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.INDIGO_JACARANDA_BUSH, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FLOWERING_JACARANDA_BUSH, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FLOWERING_INDIGO_JACARANDA_BUSH, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.JACARANDA_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.INDIGO_JACARANDA_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.JOSHUA_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MAHOGANY_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MANGROVE_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MAPLE_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.HOLLY_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ORANGE_BIRCH_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ORANGE_OAK_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ORANGE_SPRUCE_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ORCHARD_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PALM_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PALO_VERDE_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINE_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINK_CHERRY_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RAINBOW_EUCALYPTUS_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RED_BIRCH_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RED_MAPLE_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RED_OAK_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RED_SPRUCE_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.REDWOOD_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SILVER_MAPLE_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SKYRIS_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WHITE_CHERRY_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WILLOW_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WITCH_HAZEL_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ZELKOVA_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.YELLOW_BIRCH_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.YELLOW_SPRUCE_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BROWN_ZELKOVA_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ARAUCARIA_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LAMENT_SAPLING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WITHERING_OAK_SAPLING, RenderType.cutoutMipped());

        //Mushrooms
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLACK_PUFF, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WEEPING_MILKCAP, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WOOD_BLEWIT, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GREEN_MUSHROOM, RenderType.cutoutMipped());


        //FlowerBlocks
        RenderTypeLookup.setRenderLayer(BYGBlocks.ALLIUM_FLOWER_BUSH, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ALPINE_BELLFLOWER, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.AMARANTH, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ANGELICA, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.AZALEA, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BEGONIA, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BISTORT, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CALIFORNIA_POPPY, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CROCUS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLACK_ROSE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CYAN_AMARANTH, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CYAN_ROSE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CYAN_TULIP, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.DAFFODIL, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.DELPHINIUM, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FAIRY_SLIPPER, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FIRECRACKER_FLOWER_BUSH, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FOXGLOVE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GOLDEN_SPINED_CACTUS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GREEN_TULIP, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GUZMANIA, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.INCAN_LILY, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.IRIS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.JAPANESE_ORCHID, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.KOVAN_FLOWER, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LAZARUS_BELLFLOWER, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LOLIPOP_FLOWER, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MAGENTA_AMARANTH, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MAGENTA_TULIP, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ORANGE_AMARANTH, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ORANGE_DAISY, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ORSIRIA_ROSE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PEACH_LEATHER_FLOWER, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINK_ALLIUM, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINK_ALLIUM_FLOWER_BUSH, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINK_ANEMONE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINK_DAFFODIL, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINK_ORCHID, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PROTEA_FLOWER, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_AMARANTH, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_ORCHID, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_SAGE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_TULIP, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RED_CORNFLOWER, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RED_ORCHID, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RICHEA, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ROSE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SNOWDROPS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SILVER_VASE_FLOWER, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.TORCH_GINGER, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.VIOLET_LEATHER_FLOWER, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WHITE_ANEMONE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WHITE_SAGE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WINTER_CYCLAMEN, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WINTER_ROSE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WINTER_SCILLA, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.YELLOW_DAFFODIL, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.YELLOW_TULIP, RenderType.cutoutMipped());

        //Other renders
        RenderTypeLookup.setRenderLayer(BYGBlocks.AMETRINE_CLUSTER, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_GLOWSHROOM, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_GLOWSHROOM_BLOCK, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUE_GLOWSHROOM, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUE_GLOWSHROOM_BLOCK, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BORIC_FIRE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CRYPTIC_FIRE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.THERIUM_GLASS, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.THERIUM_GLASS_PANE, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ETHER_FOLIAGE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.VERMILION_SCULK_TENDRILS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.TALL_ETHER_GRASS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BULBIS_SPROUTS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BULBIS_ANOMALY, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_BULBIS_ANOMALY, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ETHER_BULB, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BAOBAB_FRUIT_BLOCK, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLACK_ICE, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.AMETRINE_BLOCK, RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUEBERRY_BUSH, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_SCAFFOLDING, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.OVERGROWN_STONE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.OVERGROWN_DACITE, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PRAIRIE_GRASS, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MEADOW_GRASSBLOCK, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GLOWCELIUM, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.POISON_IVY, RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SKYRIS_VINE, RenderType.cutoutMipped());

        for (Block potBlock : BYGBlocks.flowerPotBlocks)
            RenderTypeLookup.setRenderLayer(potBlock, RenderType.cutoutMipped());

        BYG.LOGGER.debug("BYG: Texture Cutouts Rendered!");
    }
}
