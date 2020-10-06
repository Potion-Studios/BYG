package corgiaoc.byg.client.textures.renders;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import corgiaoc.byg.BYG;

public class BYGCutoutRenders {
    public static void renderCutOuts() {
        BYG.LOGGER.debug("BYG: Rendering Texture Cutouts...");

        //Plants
        RenderTypeLookup.setRenderLayer(BYGBlocks.HORSEWEED.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MINI_CACTUS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PRICKLY_PEAR_CACTUS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WINTER_SUCCULENT.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GLOWSTONE_LANTERN.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.NETHER_BRISTLE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WEEPING_ROOTS_PLANT.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WEEPING_ROOTS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINK_CHERRY_FOLIAGE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WHITE_CHERRY_FOLIAGE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.TALL_PINK_ALLIUM.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.TALL_ALLIUM.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_ROOTS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.TALL_EMBUR_ROOTS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_WART.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_GEL_BLOCK.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_GEL_VINES.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_SPROUTS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_LILY.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.HANGING_BONE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.QUARTZ_CRYSTAL.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WHALING_GRASS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WAILING_VINES.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SCORCHED_BUSH.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SCORCHED_GRASS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BORIC_CAMPFIRE.getBlock(), RenderType.getCutoutMipped());
        //Nether
        RenderTypeLookup.setRenderLayer(BYGBlocks.OVERGROWN_NETHERRACK.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MOSSY_NETHERRACK.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SOUL_SHROOM_SPORE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SOUL_SHROOM_SPORE_END.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SOUL_SHROOM.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.DEATH_CAP.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LAMENT_VINE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LAMENT_VINE_PLANT.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LAMENT_SPROUTS.getBlock(), RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(BYGBlocks.TALL_CRIMSON_ROOTS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CRIMSON_BERRY_BUSH.getBlock(), RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(BYGBlocks.WARPED_BUSH.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WARPED_CACTUS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WARPED_CORAL_FAN.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WARPED_CORAL.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WARPED_CORAL_WALL_FAN.getBlock(), RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_ROOTS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_SPROUT.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_STALK_BLOCK.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_NYLIUM.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.HANGING_SYTHIAN_ROOTS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.HANGING_SYTHIAN_ROOTS_PLANT.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_FUNGUS.getBlock(), RenderType.getCutoutMipped());

        //End
        RenderTypeLookup.setRenderLayer(BYGBlocks.IVIS_ROOTS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.IVIS_SPROUT.getBlock(), RenderType.getCutoutMipped());


        //Sea Plants
        RenderTypeLookup.setRenderLayer(BYGBlocks.CATTAIL.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.REEDS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.TINY_LILYPADS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WATER_SILK.getBlock(), RenderType.getTranslucent());

        //GlowCane
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUE_GLOWCANE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINK_GLOWCANE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_GLOWCANE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RED_GLOWCANE.getBlock(), RenderType.getCutoutMipped());

        //Doors
        RenderTypeLookup.setRenderLayer(BYGBlocks.ASPEN_DOOR.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BAOBAB_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUE_ENCHANTED_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CHERRY_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CIKA_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CYPRESS_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EBONY_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FIR_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GREEN_ENCHANTED_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.HOLLY_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.JACARANDA_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MAHOGANY_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MANGROVE_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MAPLE_DOOR.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PALM_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINE_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RAINBOW_EUCALYPTUS_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.REDWOOD_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SKYRIS_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WILLOW_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WITCH_HAZEL_DOOR.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ZELKOVA_DOOR.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_DOOR.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LAMENT_DOOR.getBlock(), RenderType.getCutoutMipped());

        //Trapdoors
        RenderTypeLookup.setRenderLayer(BYGBlocks.ASPEN_TRAPDOOR.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BAOBAB_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUE_ENCHANTED_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CHERRY_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CIKA_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CYPRESS_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EBONY_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FIR_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GREEN_ENCHANTED_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.HOLLY_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.JACARANDA_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MAHOGANY_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MANGROVE_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MAPLE_TRAPDOOR.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PALM_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINE_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RAINBOW_EUCALYPTUS_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.REDWOOD_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SKYRIS_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WILLOW_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WITCH_HAZEL_TRAPDOOR.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ZELKOVA_TRAPDOOR.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EMBUR_TRAPDOOR.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LAMENT_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());

        //Grass
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.TALL_PRAIRIE_GRASS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PRAIRIE_GRASS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SHORT_GRASS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WINTER_GRASS.getBlock(), RenderType.getTranslucent());

        RenderTypeLookup.setRenderLayer(BYGBlocks.SHORT_BEACH_GRASS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BEACH_GRASS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WILTED_GRASS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WEED_GRASS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LEAF_PILE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CLOVER_PATCH.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FLOWER_PATCH.getBlock(), RenderType.getCutoutMipped());


        //Saplings
        RenderTypeLookup.setRenderLayer(BYGBlocks.ASPEN_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BAOBAB_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUE_ENCHANTED_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUE_SPRUCE_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BROWN_BIRCH_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BROWN_OAK_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CYPRESS_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CIKA_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.EBONY_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FIR_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GREEN_ENCHANTED_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.HOLLY_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.JACARANDA_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.INDIGO_JACARANDA_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.JOSHUA_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MAHOGANY_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MANGROVE_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MAPLE_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.HOLLY_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ORANGE_BIRCH_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ORANGE_OAK_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ORANGE_SPRUCE_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ORCHARD_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PALM_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PALO_VERDE_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINE_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINK_CHERRY_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RAINBOW_EUCALYPTUS_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RED_BIRCH_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RED_MAPLE_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RED_OAK_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RED_SPRUCE_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.REDWOOD_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SILVER_MAPLE_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SKYRIS_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WHITE_CHERRY_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WILLOW_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WITCH_HAZEL_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ZELKOVA_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.YELLOW_BIRCH_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.YELLOW_SPRUCE_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BROWN_ZELKOVA_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ARAUCARIA_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LAMENT_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WITHERING_OAK_SAPLING.getBlock(), RenderType.getCutoutMipped());

        //Mushrooms
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLACK_PUFF.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WEEPING_MILKCAP.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WOOD_BLEWIT.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GREEN_MUSHROOM.getBlock(), RenderType.getCutoutMipped());


        //FlowerBlocks
        RenderTypeLookup.setRenderLayer(BYGBlocks.ALLIUM_FLOWER_BUSH.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ALPINE_BELLFLOWER.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.AMARANTH.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ANGELICA.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.AZALEA.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BEGONIA.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BISTORT.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CALIFORNIA_POPPY.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CROCUS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLACK_ROSE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CYAN_AMARANTH.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CYAN_ROSE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.CYAN_TULIP.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.DAFFODIL.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.DELPHINIUM.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FAIRY_SLIPPER.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FIRECRACKER_FLOWER_BUSH.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.FOXGLOVE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GOLDEN_SPINED_CACTUS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GREEN_TULIP.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GUZMANIA.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.INCAN_LILY.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.IRIS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.JAPANESE_ORCHID.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.KOVAN_FLOWER.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LAZARUS_BELLFLOWER.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.LOLIPOP_FLOWER.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MAGENTA_AMARANTH.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MAGENTA_TULIP.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ORANGE_AMARANTH.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ORANGE_DAISY.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ORSIRIA_ROSE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PEACH_LEATHER_FLOWER.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINK_ALLIUM.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINK_ALLIUM_FLOWER_BUSH.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINK_ANEMONE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINK_DAFFODIL.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PINK_ORCHID.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PROTEA_FLOWER.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_AMARANTH.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_ORCHID.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_SAGE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_TULIP.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RED_CORNFLOWER.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RED_ORCHID.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.RICHEA.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.ROSE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SNOWDROPS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SILVER_VASE_FLOWER.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.TORCH_GINGER.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.VIOLET_LEATHER_FLOWER.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WHITE_ANEMONE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WHITE_SAGE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WINTER_CYCLAMEN.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WINTER_ROSE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.WINTER_SCILLA.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.YELLOW_DAFFODIL.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.YELLOW_TULIP.getBlock(), RenderType.getCutoutMipped());

        //Other renders
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_GLOWSHROOM.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PURPLE_GLOWSHROOM_BLOCK.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUE_GLOWSHROOM.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUE_GLOWSHROOM_BLOCK.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BORIC_FIRE.getBlock(), RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(BYGBlocks.BLACK_ICE.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlocks.BLUEBERRY_BUSH.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SYTHIAN_SCAFFOLDING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.OVERGROWN_STONE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.OVERGROWN_DACITE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.PRAIRIE_GRASS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.MEADOW_GRASSBLOCK.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.GLOWCELIUM.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.POISON_IVY.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlocks.SKYRIS_VINE.getBlock(), RenderType.getCutoutMipped());

        BYG.LOGGER.debug("BYG: Texture Cutouts Rendered!");
    }
}
