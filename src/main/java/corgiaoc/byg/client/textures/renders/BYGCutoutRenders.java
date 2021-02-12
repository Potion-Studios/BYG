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
        RenderTypeLookup.setRenderLayer(BYGBlocks.HORSEWEED, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUE_SAGE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MINI_CACTUS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PRICKLY_PEAR_CACTUS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WINTER_SUCCULENT, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GLOWSTONE_LANTERN, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.NETHER_BRISTLE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WEEPING_ROOTS_PLANT, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WEEPING_ROOTS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINK_CHERRY_FOLIAGE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WHITE_CHERRY_FOLIAGE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.TALL_PINK_ALLIUM, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.TALL_ALLIUM, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_ROOTS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.TALL_EMBUR_ROOTS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_WART, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_GEL_BLOCK, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_GEL_VINES, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_SPROUTS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_LILY, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.HANGING_BONE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.QUARTZ_CRYSTAL, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WAILING_GRASS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WAILING_VINES, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SCORCHED_BUSH, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SCORCHED_GRASS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BORIC_CAMPFIRE, RenderType.getCutoutMipped());
        //Nether
        RenderTypeLookup.setRenderLayer(BYGBlocks.OVERGROWN_NETHERRACK, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MOSSY_NETHERRACK, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SOUL_SHROOM_SPORE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SOUL_SHROOM_SPORE_END, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SOUL_SHROOM, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.DEATH_CAP, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LAMENT_VINE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LAMENT_VINE_PLANT, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LAMENT_SPROUTS, RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(BYGBlocks.TALL_CRIMSON_ROOTS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CRIMSON_BERRY_BUSH, RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(BYGBlocks.WARPED_BUSH, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WARPED_CACTUS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WARPED_CORAL_FAN, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WARPED_CORAL, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WARPED_CORAL_WALL_FAN, RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_ROOTS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_SPROUT, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_STALK_BLOCK, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_NYLIUM, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.HANGING_SYTHIAN_ROOTS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.HANGING_SYTHIAN_ROOTS_PLANT, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_FUNGUS, RenderType.getCutoutMipped());

        //End
        RenderTypeLookup.setRenderLayer(BYGBlocks.IVIS_ROOTS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.IVIS_SPROUT, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.NIGHTSHADE_SPROUTS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ETHER_BUSH, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ETHER_GRASS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.THEREAL_BELLFLOWER, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ETHER_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.NIGHTSHADE_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_BULBIS_ODDITY, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_BULBIS_SHELL, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BULBIS_ODDITY, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BULBIS_SHELL, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.NIGHTSHADE_BERRY_BUSH, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.NIGHTSHADE_ROOTS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.VERMILION_SCULK_GROWTH, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.THERIUM_LANTERN, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ODDITY_CACTUS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ODDITY_BUSH, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.THERIUM_CRYSTAL, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SHULKREN_MOSS_BLANKET, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SHULKREN_FUNGUS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SHULKREN_VINE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SHULKREN_VINE_PLANT, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CRYPTIC_CAMPFIRE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ENDER_LILY, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CRYPTIC_BRAMBLE, RenderType.getCutoutMipped());

        //Sea Plants
        RenderTypeLookup.setRenderLayer(BYGBlocks.CATTAIL, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.REEDS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.TINY_LILYPADS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WATER_SILK, RenderType.getTranslucent());

        //GlowCane
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUE_GLOWCANE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINK_GLOWCANE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_GLOWCANE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RED_GLOWCANE, RenderType.getCutoutMipped());

        //Doors
        RenderTypeLookup.setRenderLayer(BYGBlocks.ASPEN_DOOR, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BAOBAB_DOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUE_ENCHANTED_DOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CHERRY_DOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CIKA_DOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CYPRESS_DOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EBONY_DOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FIR_DOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GREEN_ENCHANTED_DOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.HOLLY_DOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.JACARANDA_DOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MAHOGANY_DOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MANGROVE_DOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MAPLE_DOOR, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PALM_DOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINE_DOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RAINBOW_EUCALYPTUS_DOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.REDWOOD_DOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SKYRIS_DOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WILLOW_DOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WITCH_HAZEL_DOOR, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ZELKOVA_DOOR, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_DOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_DOOR, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LAMENT_DOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BULBIS_DOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ETHER_DOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.NIGHTSHADE_DOOR, RenderType.getCutoutMipped());

        //Trapdoors
        RenderTypeLookup.setRenderLayer(BYGBlocks.ASPEN_TRAPDOOR, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BAOBAB_TRAPDOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUE_ENCHANTED_TRAPDOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CHERRY_TRAPDOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CIKA_TRAPDOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CYPRESS_TRAPDOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EBONY_TRAPDOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FIR_TRAPDOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GREEN_ENCHANTED_TRAPDOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.HOLLY_TRAPDOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.JACARANDA_TRAPDOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MAHOGANY_TRAPDOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MANGROVE_TRAPDOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MAPLE_TRAPDOOR, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PALM_TRAPDOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINE_TRAPDOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RAINBOW_EUCALYPTUS_TRAPDOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.REDWOOD_TRAPDOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SKYRIS_TRAPDOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WILLOW_TRAPDOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WITCH_HAZEL_TRAPDOOR, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ZELKOVA_TRAPDOOR, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_TRAPDOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_TRAPDOOR, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LAMENT_TRAPDOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BULBIS_TRAPDOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ETHER_TRAPDOOR, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.NIGHTSHADE_TRAPDOOR, RenderType.getCutoutMipped());

        //Grass
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.TALL_PRAIRIE_GRASS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PRAIRIE_GRASS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SHORT_GRASS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WINTER_GRASS, RenderType.getTranslucent());

        RenderTypeLookup.setRenderLayer(BYGBlocks.SHORT_BEACH_GRASS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BEACH_GRASS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WILTED_GRASS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WEED_GRASS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LEAF_PILE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CLOVER_PATCH, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FLOWER_PATCH, RenderType.getCutoutMipped());


        //Saplings
        RenderTypeLookup.setRenderLayer(BYGBlocks.ASPEN_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BAOBAB_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUE_ENCHANTED_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUE_SPRUCE_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BROWN_BIRCH_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BROWN_OAK_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CYPRESS_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CIKA_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EBONY_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FIR_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GREEN_ENCHANTED_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.HOLLY_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.JACARANDA_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.INDIGO_JACARANDA_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.JOSHUA_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MAHOGANY_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MANGROVE_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MAPLE_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.HOLLY_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ORANGE_BIRCH_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ORANGE_OAK_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ORANGE_SPRUCE_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ORCHARD_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PALM_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PALO_VERDE_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINE_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINK_CHERRY_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RAINBOW_EUCALYPTUS_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RED_BIRCH_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RED_MAPLE_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RED_OAK_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RED_SPRUCE_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.REDWOOD_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SILVER_MAPLE_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SKYRIS_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WHITE_CHERRY_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WILLOW_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WITCH_HAZEL_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ZELKOVA_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.YELLOW_BIRCH_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.YELLOW_SPRUCE_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BROWN_ZELKOVA_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ARAUCARIA_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LAMENT_SAPLING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WITHERING_OAK_SAPLING, RenderType.getCutoutMipped());

        //Mushrooms
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLACK_PUFF, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WEEPING_MILKCAP, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WOOD_BLEWIT, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GREEN_MUSHROOM, RenderType.getCutoutMipped());


        //FlowerBlocks
        RenderTypeLookup.setRenderLayer(BYGBlocks.ALLIUM_FLOWER_BUSH, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ALPINE_BELLFLOWER, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.AMARANTH, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ANGELICA, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.AZALEA, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BEGONIA, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BISTORT, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CALIFORNIA_POPPY, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CROCUS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLACK_ROSE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CYAN_AMARANTH, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CYAN_ROSE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CYAN_TULIP, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.DAFFODIL, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.DELPHINIUM, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FAIRY_SLIPPER, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FIRECRACKER_FLOWER_BUSH, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FOXGLOVE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GOLDEN_SPINED_CACTUS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GREEN_TULIP, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GUZMANIA, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.INCAN_LILY, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.IRIS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.JAPANESE_ORCHID, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.KOVAN_FLOWER, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LAZARUS_BELLFLOWER, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LOLIPOP_FLOWER, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MAGENTA_AMARANTH, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MAGENTA_TULIP, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ORANGE_AMARANTH, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ORANGE_DAISY, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ORSIRIA_ROSE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PEACH_LEATHER_FLOWER, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINK_ALLIUM, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINK_ALLIUM_FLOWER_BUSH, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINK_ANEMONE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINK_DAFFODIL, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINK_ORCHID, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PROTEA_FLOWER, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_AMARANTH, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_ORCHID, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_SAGE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_TULIP, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RED_CORNFLOWER, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RED_ORCHID, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RICHEA, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ROSE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SNOWDROPS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SILVER_VASE_FLOWER, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.TORCH_GINGER, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.VIOLET_LEATHER_FLOWER, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WHITE_ANEMONE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WHITE_SAGE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WINTER_CYCLAMEN, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WINTER_ROSE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WINTER_SCILLA, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.YELLOW_DAFFODIL, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.YELLOW_TULIP, RenderType.getCutoutMipped());

        //Other renders
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_GLOWSHROOM, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_GLOWSHROOM_BLOCK, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUE_GLOWSHROOM, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUE_GLOWSHROOM_BLOCK, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BORIC_FIRE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CRYPTIC_FIRE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.THERIUM_GLASS, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.THERIUM_GLASS_PANE, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ETHER_FOLIAGE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.VERMILION_SCULK_TENDRILS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.TALL_ETHER_GRASS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BULBIS_SPROUTS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BULBIS_ANOMALY, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_BULBIS_ANOMALY, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ETHER_BULB, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BAOBAB_FRUIT_BLOCK, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLACK_ICE, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUEBERRY_BUSH, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_SCAFFOLDING, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.OVERGROWN_STONE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.OVERGROWN_DACITE, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PRAIRIE_GRASS, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MEADOW_GRASSBLOCK, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GLOWCELIUM, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.POISON_IVY, RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SKYRIS_VINE, RenderType.getCutoutMipped());

        for (Block potBlock : BYGBlocks.flowerPotBlocks)
            RenderTypeLookup.setRenderLayer(potBlock, RenderType.getCutoutMipped());

        BYG.LOGGER.debug("BYG: Texture Cutouts Rendered!");
    }
}
