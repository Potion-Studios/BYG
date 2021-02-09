package corgiaoc.byg.client.textures.renders;

import corgiaoc.byg.BYG;
import corgiaoc.byg.core.BYGBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

public class BYGCutoutRenders {
    public static void renderCutOuts() {
     BYG.LOGGER.debug("BYG: Rendering Texture Cutouts...");

     //Plants
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.HORSEWEED, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BLUE_SAGE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.MINI_CACTUS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PRICKLY_PEAR_CACTUS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WINTER_SUCCULENT, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.GLOWSTONE_LANTERN, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.NETHER_BRISTLE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WEEPING_ROOTS_PLANT, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WEEPING_ROOTS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PINK_CHERRY_FOLIAGE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WHITE_CHERRY_FOLIAGE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.TALL_PINK_ALLIUM, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.TALL_ALLIUM, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.EMBUR_ROOTS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.TALL_EMBUR_ROOTS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.EMBUR_WART, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.EMBUR_GEL_BLOCK, RenderLayer.getTranslucent());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.EMBUR_GEL_VINES, RenderLayer.getTranslucent());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.EMBUR_SPROUTS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.EMBUR_LILY, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.HANGING_BONE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.QUARTZ_CRYSTAL, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WAILING_GRASS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WAILING_VINES, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SCORCHED_BUSH, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SCORCHED_GRASS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BORIC_CAMPFIRE, RenderLayer.getCutoutMipped());
     //Nether
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.OVERGROWN_NETHERRACK, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.MOSSY_NETHERRACK, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SOUL_SHROOM_SPORE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SOUL_SHROOM_SPORE_END, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SOUL_SHROOM, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.DEATH_CAP, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.LAMENT_VINE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.LAMENT_VINE_PLANT, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.LAMENT_SPROUTS, RenderLayer.getCutoutMipped());

     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.TALL_CRIMSON_ROOTS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.CRIMSON_BERRY_BUSH, RenderLayer.getCutoutMipped());

     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WARPED_BUSH, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WARPED_CACTUS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WARPED_CORAL_FAN, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WARPED_CORAL, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WARPED_CORAL_WALL_FAN, RenderLayer.getCutoutMipped());

     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SYTHIAN_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SYTHIAN_ROOTS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SYTHIAN_SPROUT, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SYTHIAN_STALK_BLOCK, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SYTHIAN_NYLIUM, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.HANGING_SYTHIAN_ROOTS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.HANGING_SYTHIAN_ROOTS_PLANT, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SYTHIAN_FUNGUS, RenderLayer.getCutoutMipped());

     //End
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.IVIS_ROOTS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.IVIS_SPROUT, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.NIGHTSHADE_SPROUTS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ETHER_BUSH, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ETHER_GRASS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.THEREAL_BELLFLOWER, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ETHER_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.NIGHTSHADE_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PURPLE_BULBIS_ODDITY, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PURPLE_BULBIS_SHELL, RenderLayer.getTranslucent());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BULBIS_ODDITY, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BULBIS_SHELL, RenderLayer.getTranslucent());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.NIGHTSHADE_BERRY_BUSH, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.NIGHTSHADE_ROOTS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.VERMILION_SCULK_GROWTH, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.THERIUM_LANTERN, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ODDITY_CACTUS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ODDITY_BUSH, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.THERIUM_CRYSTAL, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SHULKREN_MOSS_BLANKET, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SHULKREN_FUNGUS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SHULKREN_VINE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SHULKREN_VINE_PLANT, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.CRYPTIC_CAMPFIRE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ENDER_LILY, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.CRYPTIC_BRAMBLE, RenderLayer.getCutoutMipped());

     //Sea Plants
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.CATTAIL, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.REEDS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.TINY_LILYPADS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WATER_SILK, RenderLayer.getTranslucent());

     //GlowCane
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BLUE_GLOWCANE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PINK_GLOWCANE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PURPLE_GLOWCANE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.RED_GLOWCANE, RenderLayer.getCutoutMipped());

     //Doors
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ASPEN_DOOR, RenderLayer.getTranslucent());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BAOBAB_DOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BLUE_ENCHANTED_DOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.CHERRY_DOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.CIKA_DOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.CYPRESS_DOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.EBONY_DOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.FIR_DOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.GREEN_ENCHANTED_DOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.HOLLY_DOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.JACARANDA_DOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.MAHOGANY_DOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.MANGROVE_DOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.MAPLE_DOOR, RenderLayer.getTranslucent());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PALM_DOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PINE_DOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.RAINBOW_EUCALYPTUS_DOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.REDWOOD_DOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SKYRIS_DOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WILLOW_DOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WITCH_HAZEL_DOOR, RenderLayer.getTranslucent());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ZELKOVA_DOOR, RenderLayer.getTranslucent());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SYTHIAN_DOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.EMBUR_DOOR, RenderLayer.getTranslucent());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.LAMENT_DOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BULBIS_DOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ETHER_DOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.NIGHTSHADE_DOOR, RenderLayer.getCutoutMipped());

     //Trapdoors
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ASPEN_TRAPDOOR, RenderLayer.getTranslucent());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BAOBAB_TRAPDOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BLUE_ENCHANTED_TRAPDOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.CHERRY_TRAPDOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.CIKA_TRAPDOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.CYPRESS_TRAPDOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.EBONY_TRAPDOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.FIR_TRAPDOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.GREEN_ENCHANTED_TRAPDOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.HOLLY_TRAPDOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.JACARANDA_TRAPDOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.MAHOGANY_TRAPDOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.MANGROVE_TRAPDOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.MAPLE_TRAPDOOR, RenderLayer.getTranslucent());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PALM_TRAPDOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PINE_TRAPDOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.RAINBOW_EUCALYPTUS_TRAPDOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.REDWOOD_TRAPDOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SKYRIS_TRAPDOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WILLOW_TRAPDOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WITCH_HAZEL_TRAPDOOR, RenderLayer.getTranslucent());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ZELKOVA_TRAPDOOR, RenderLayer.getTranslucent());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SYTHIAN_TRAPDOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.EMBUR_TRAPDOOR, RenderLayer.getTranslucent());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.LAMENT_TRAPDOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BULBIS_TRAPDOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ETHER_TRAPDOOR, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.NIGHTSHADE_TRAPDOOR, RenderLayer.getCutoutMipped());

     //Grass
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES, RenderLayer.getTranslucent());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.TALL_PRAIRIE_GRASS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PRAIRIE_GRASS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SHORT_GRASS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WINTER_GRASS, RenderLayer.getTranslucent());

     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SHORT_BEACH_GRASS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BEACH_GRASS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WILTED_GRASS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WEED_GRASS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.LEAF_PILE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.CLOVER_PATCH, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.FLOWER_PATCH, RenderLayer.getCutoutMipped());


     //Saplings
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ASPEN_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BAOBAB_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BLUE_ENCHANTED_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BLUE_SPRUCE_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BROWN_BIRCH_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BROWN_OAK_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.CYPRESS_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.CIKA_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.EBONY_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.FIR_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.GREEN_ENCHANTED_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.HOLLY_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.JACARANDA_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.INDIGO_JACARANDA_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.JOSHUA_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.MAHOGANY_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.MANGROVE_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.MAPLE_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.HOLLY_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ORANGE_BIRCH_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ORANGE_OAK_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ORANGE_SPRUCE_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ORCHARD_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PALM_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PALO_VERDE_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PINE_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PINK_CHERRY_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.RAINBOW_EUCALYPTUS_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.RED_BIRCH_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.RED_MAPLE_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.RED_OAK_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.RED_SPRUCE_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.REDWOOD_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SILVER_MAPLE_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SKYRIS_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WHITE_CHERRY_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WILLOW_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WITCH_HAZEL_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ZELKOVA_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.YELLOW_BIRCH_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.YELLOW_SPRUCE_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BROWN_ZELKOVA_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ARAUCARIA_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.LAMENT_SAPLING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WITHERING_OAK_SAPLING, RenderLayer.getCutoutMipped());

     //Mushrooms
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BLACK_PUFF, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WEEPING_MILKCAP, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WOOD_BLEWIT, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.GREEN_MUSHROOM, RenderLayer.getCutoutMipped());


     //FlowerBlocks
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ALLIUM_FLOWER_BUSH, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ALPINE_BELLFLOWER, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.AMARANTH, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ANGELICA, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.AZALEA, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BEGONIA, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BISTORT, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.CALIFORNIA_POPPY, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.CROCUS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BLACK_ROSE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.CYAN_AMARANTH, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.CYAN_ROSE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.CYAN_TULIP, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.DAFFODIL, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.DELPHINIUM, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.FAIRY_SLIPPER, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.FIRECRACKER_FLOWER_BUSH, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.FOXGLOVE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.GOLDEN_SPINED_CACTUS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.GREEN_TULIP, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.GUZMANIA, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.INCAN_LILY, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.IRIS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.JAPANESE_ORCHID, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.KOVAN_FLOWER, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.LAZARUS_BELLFLOWER, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.LOLIPOP_FLOWER, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.MAGENTA_AMARANTH, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.MAGENTA_TULIP, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ORANGE_AMARANTH, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ORANGE_DAISY, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ORSIRIA_ROSE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PEACH_LEATHER_FLOWER, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PINK_ALLIUM, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PINK_ALLIUM_FLOWER_BUSH, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PINK_ANEMONE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PINK_DAFFODIL, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PINK_ORCHID, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PROTEA_FLOWER, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PURPLE_AMARANTH, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PURPLE_ORCHID, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PURPLE_SAGE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PURPLE_TULIP, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.RED_CORNFLOWER, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.RED_ORCHID, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.RICHEA, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ROSE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SNOWDROPS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SILVER_VASE_FLOWER, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.TORCH_GINGER, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.VIOLET_LEATHER_FLOWER, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WHITE_ANEMONE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WHITE_SAGE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WINTER_CYCLAMEN, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WINTER_ROSE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.WINTER_SCILLA, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.YELLOW_DAFFODIL, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.YELLOW_TULIP, RenderLayer.getCutoutMipped());

     //Other renders
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PURPLE_GLOWSHROOM, RenderLayer.getTranslucent());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PURPLE_GLOWSHROOM_BLOCK, RenderLayer.getTranslucent());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BLUE_GLOWSHROOM, RenderLayer.getTranslucent());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BLUE_GLOWSHROOM_BLOCK, RenderLayer.getTranslucent());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BORIC_FIRE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.CRYPTIC_FIRE, RenderLayer.getCutoutMipped());

     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ETHER_FOLIAGE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.VERMILION_SCULK_TENDRILS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.TALL_ETHER_GRASS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BULBIS_SPROUTS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BULBIS_ANOMALY, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PURPLE_BULBIS_ANOMALY, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.ETHER_BULB, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BAOBAB_FRUIT_BLOCK, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BLACK_ICE, RenderLayer.getTranslucent());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.BLUEBERRY_BUSH, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SYTHIAN_SCAFFOLDING, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.OVERGROWN_STONE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.OVERGROWN_DACITE, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.PRAIRIE_GRASS, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.MEADOW_GRASSBLOCK, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.GLOWCELIUM, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.POISON_IVY, RenderLayer.getCutoutMipped());
     BlockRenderLayerMap.INSTANCE.putBlock(BYGBlocks.SKYRIS_VINE, RenderLayer.getCutoutMipped());

     for (Block potBlock : BYGBlocks.flowerPotBlocks)
      BlockRenderLayerMap.INSTANCE.putBlock(potBlock, RenderLayer.getCutoutMipped());

     BYG.LOGGER.debug("BYG: Texture Cutouts Rendered!");
    }
}
