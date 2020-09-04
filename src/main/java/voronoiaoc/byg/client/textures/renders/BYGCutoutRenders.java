package voronoiaoc.byg.client.textures.renders;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.core.byglists.BYGBlockList;

public class BYGCutoutRenders {
    public static void renderCutOuts() {
        BYG.LOGGER.debug("BYG: Rendering Texture Cutouts...");

        //Plants
        RenderTypeLookup.setRenderLayer(BYGBlockList.HORSEWEED.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.MINI_CACTUS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.PRICKLY_PEAR_CACTUS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WINTER_SUCCULENT.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.GLOWSTONE_LANTERN.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.NETHER_BRISTLE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WEEPING_ROOTS_PLANT.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WEEPING_ROOTS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.PINK_CHERRY_FOLIAGE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WHITE_CHERRY_FOLIAGE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.TALL_PINK_ALLIUM.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.TALL_ALLIUM.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.EMBUR_ROOTS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.TALL_EMBUR_ROOTS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.EMBUR_WART.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.EMBUR_GEL_BLOCK.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlockList.EMBUR_GEL_VINES.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlockList.EMBUR_SPROUTS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.EMBUR_LILY.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.HANGING_BONE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WHALING_GRASS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WAILING_VINES.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.SCORCHED_BUSH.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.SCORCHED_GRASS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.BORIC_CAMPFIRE.getBlock(), RenderType.getCutoutMipped());
        //Nether
        RenderTypeLookup.setRenderLayer(BYGBlockList.OVERGROWN_NETHERRACK.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.MOSSY_NETHERRACK.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.SOUL_SHROOM_SPORE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.SOUL_SHROOM_SPORE_END.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.SOUL_SHROOM.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.DEATH_CAP.getBlock(), RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(BYGBlockList.TALL_CRIMSON_ROOTS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.CRIMSON_BERRY_BUSH.getBlock(), RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(BYGBlockList.WARPED_BUSH.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WARPED_CACTUS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WARPED_CORAL_FAN.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WARPED_CORAL.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WARPED_CORAL_WALL_FAN.getBlock(), RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(BYGBlockList.SYTHIAN_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.SYTHIAN_ROOTS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.SYTHIAN_SPROUT.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.SYTHIAN_STALK_BLOCK.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.SYTHIAN_NYLIUM.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.HANGING_SYTHIAN_ROOTS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.HANGING_SYTHIAN_ROOTS_PLANT.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.SYTHIAN_FUNGUS.getBlock(), RenderType.getCutoutMipped());

        //End
        RenderTypeLookup.setRenderLayer(BYGBlockList.IVIS_ROOTS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.IVIS_SPROUT.getBlock(), RenderType.getCutoutMipped());


        //Sea Plants
        RenderTypeLookup.setRenderLayer(BYGBlockList.CATTAIL.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.REEDS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.TINY_LILYPADS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WATER_SILK.getBlock(), RenderType.getTranslucent());

        //GlowCane
        RenderTypeLookup.setRenderLayer(BYGBlockList.BLUE_GLOWCANE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.PINK_GLOWCANE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.PURPLE_GLOWCANE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.RED_GLOWCANE.getBlock(), RenderType.getCutoutMipped());

        //Doors
        RenderTypeLookup.setRenderLayer(BYGBlockList.ASPEN_DOOR.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlockList.BAOBAB_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.BLUE_ENCHANTED_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.CHERRY_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.CIKA_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.CYPRESS_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.EBONY_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.FIR_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.GREEN_ENCHANTED_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.HOLLY_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.JACARANDA_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.MAHOGANY_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.MANGROVE_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.MAPLE_DOOR.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlockList.PINE_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.RAINBOW_EUCALYPTUS_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.REDWOOD_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.SKYRIS_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WILLOW_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WITCH_HAZEL_DOOR.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlockList.ZELKOVA_DOOR.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlockList.SYTHIAN_DOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.EMBUR_DOOR.getBlock(), RenderType.getTranslucent());
        //Trapdoors
        RenderTypeLookup.setRenderLayer(BYGBlockList.ASPEN_TRAPDOOR.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlockList.BAOBAB_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.BLUE_ENCHANTED_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.CHERRY_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.CIKA_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.CYPRESS_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.EBONY_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.FIR_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.GREEN_ENCHANTED_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.HOLLY_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.JACARANDA_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.MAHOGANY_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.MANGROVE_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.MAPLE_TRAPDOOR.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlockList.PINE_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.RAINBOW_EUCALYPTUS_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.REDWOOD_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.SKYRIS_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WILLOW_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WITCH_HAZEL_TRAPDOOR.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlockList.ZELKOVA_TRAPDOOR.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlockList.SYTHIAN_TRAPDOOR.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.EMBUR_TRAPDOOR.getBlock(), RenderType.getTranslucent());

        //Grass
        RenderTypeLookup.setRenderLayer(BYGBlockList.BLOOMING_WITCH_HAZEL_LEAVES.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlockList.TALL_PRAIRIE_GRASS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.PRAIRIE_GRASS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.SHORT_GRASS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WINTER_GRASS.getBlock(), RenderType.getTranslucent());

        RenderTypeLookup.setRenderLayer(BYGBlockList.SHORT_BEACH_GRASS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.BEACH_GRASS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WILTED_GRASS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WEED_GRASS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.LEAF_PILE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.CLOVER_PATCH.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.FLOWER_PATCH.getBlock(), RenderType.getCutoutMipped());


        //Saplings
        RenderTypeLookup.setRenderLayer(BYGBlockList.ASPEN_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.BAOBAB_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.BLUE_ENCHANTED_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.BLUE_SPRUCE_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.BROWN_BIRCH_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.BROWN_OAK_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.CYPRESS_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.CIKA_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.EBONY_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.FIR_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.GREEN_ENCHANTED_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.HOLLY_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.JACARANDA_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.INDIGO_JACARANDA_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.JOSHUA_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.MAHOGANY_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.MANGROVE_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.MAPLE_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.HOLLY_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.ORANGE_BIRCH_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.ORANGE_OAK_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.ORANGE_SPRUCE_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.ORCHARD_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.PALO_VERDE_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.PINE_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.PINK_CHERRY_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.RAINBOW_EUCALYPTUS_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.RED_BIRCH_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.RED_MAPLE_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.RED_OAK_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.RED_SPRUCE_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.REDWOOD_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.SILVER_MAPLE_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.SKYRIS_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WHITE_CHERRY_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WILLOW_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WITCH_HAZEL_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.ZELKOVA_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.YELLOW_BIRCH_SAPLING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.YELLOW_SPRUCE_SAPLING.getBlock(), RenderType.getCutoutMipped());

        //Mushrooms
        RenderTypeLookup.setRenderLayer(BYGBlockList.BLACK_PUFF.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WEEPING_MILKCAP.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WOOD_BLEWIT.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.GREEN_MUSHSHROOM.getBlock(), RenderType.getCutoutMipped());


        //FlowerBlocks
        RenderTypeLookup.setRenderLayer(BYGBlockList.ALLIUM_FLOWER_BUSH.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.ALPINE_BELLFLOWER.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.AMARANTH.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.ANGELICA.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.AZALEA.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.BEGONIA.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.BISTORT.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.CALIFORNIA_POPPY.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.CROCUS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.BLACK_ROSE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.CYAN_AMARANTH.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.CYAN_ROSE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.CYAN_TULIP.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.DAFFODIL.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.DELPHINIUM.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.FAIRY_SLIPPER.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.FIRECRACKER_FLOWER_BUSH.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.FOXGLOVE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.GOLDEN_SPINED_CACTUS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.GREEN_TULIP.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.GUZMANIA.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.INCAN_LILY.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.IRIS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.JAPANESE_ORCHID.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.KOVAN_FLOWER.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.LAZARUS_BELLFLOWER.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.LOLIPOP_FLOWER.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.MAGENTA_AMARANTH.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.MAGENTA_TULIP.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.ORANGE_AMARANTH.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.ORANGE_DAISY.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.ORSIRIA_ROSE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.PEACH_LEATHER_FLOWER.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.PINK_ALLIUM.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.PINK_ALLIUM_FLOWER_BUSH.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.PINK_ANEMONE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.PINK_DAFFODIL.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.PINK_ORCHID.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.PROTEA_FLOWER.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.PURPLE_AMARANTH.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.PURPLE_ORCHID.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.PURPLE_SAGE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.PURPLE_TULIP.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.RED_CORNFLOWER.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.RED_ORCHID.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.RICHEA.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.ROSE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.SNOWDROPS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.SILVER_VASE_FLOWER.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.TORCH_GINGER.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.VIOLET_LEATHER_FLOWER.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WHITE_ANEMONE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WHITE_SAGE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WINTER_CYCLAMEN.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WINTER_ROSE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.WINTER_SCILLA.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.YELLOW_DAFFODIL.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.YELLOW_TULIP.getBlock(), RenderType.getCutoutMipped());

        //Other renders
        RenderTypeLookup.setRenderLayer(BYGBlockList.PURPLE_GLOWSHROOM.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlockList.PURPLE_GLOWSHROOM_BLOCK.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlockList.BLUE_GLOWSHROOM.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlockList.BLUE_GLOWSHROOM_BLOCK.getBlock(), RenderType.getTranslucent());

        RenderTypeLookup.setRenderLayer(BYGBlockList.BLACK_ICE.getBlock(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BYGBlockList.BLUEBERRY_BUSH.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.SYTHIAN_SCAFFOLDING.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.OVERGROWN_STONE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.OVERGROWN_DACITE.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.PRAIRIE_GRASS.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.MEADOW_GRASSBLOCK.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.GLOWCELIUM.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.POISON_IVY.getBlock(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(BYGBlockList.SKYRIS_VINE.getBlock(), RenderType.getCutoutMipped());

        BYG.LOGGER.debug("BYG: Texture Cutouts Rendered!");
    }
}
