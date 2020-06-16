package voronoiaoc.byg.client.textures.renders;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.core.byglists.BYGBlockList;

@Environment(EnvType.CLIENT)
public class BYGBlockRenders {
    public static void renderCutOuts() {
        BYG.LOGGER.debug("BYG: Rendering Texture Cutouts...");

        //Plants
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.HORSEWEED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MINI_CACTUS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PRICKLY_PEAR_CACTUS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WINTER_SUCCULENT, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.GLOWSTONE_LANTERN, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.NETHER_BRISTLE, RenderLayer.getCutout());

        //Nether
//        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.OVERGROWN_NETHERRACK, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WARPED_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WARPED_CACTUS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WARPED_CORAL_FAN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WARPED_CORAL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WARPED_CORAL_WALL_FAN, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SYTHIAN_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SYTHIAN_ROOTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SYTHIAN_SPROUT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SYTHIAN_STALK_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SYTHIAN_NYLIUM, RenderLayer.getCutout());

        //End
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.IVIS_ROOTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.IVIS_SPROUT, RenderLayer.getCutout());


        //Sea Plants
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CATTAIL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.REEDS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.TINY_LILYPADS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WATER_SILK, RenderLayer.getTranslucent());

        //GlowCane
//        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BLUE_GLOWCANE, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PINK_GLOWCANE, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PURPLE_GLOWCANE, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.RED_GLOWCANE, RenderLayer.getCutout());

        //Doors
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ASPEN_DOOR, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BAOBAB_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BLUE_ENCHANTED_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CHERRY_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CIKA_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CYPRESS_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.EBONY_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.FIR_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.GREEN_ENCHANTED_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.HOLLY_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.JACARANDA_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MAHOGANY_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MANGROVE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MAPLE_DOOR, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PINE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.RAINBOW_EUCALYPTUS_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.REDWOOD_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SKYRIS_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WILLOW_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WITCH_HAZEL_DOOR, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ZELKOVA_DOOR, RenderLayer.getTranslucent());

        //Trapdoors
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ASPEN_TRAPDOOR, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BAOBAB_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BLUE_ENCHANTED_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CHERRY_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CIKA_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CYPRESS_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.EBONY_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.FIR_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.GREEN_ENCHANTED_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.HOLLY_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.JACARANDA_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MAHOGANY_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MANGROVE_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MAPLE_TRAPDOOR, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PINE_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.RAINBOW_EUCALYPTUS_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.REDWOOD_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SKYRIS_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WILLOW_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WITCH_HAZEL_TRAPDOOR, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ZELKOVA_TRAPDOOR, RenderLayer.getTranslucent());

        //Grass
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BLOOMING_WITCH_HAZEL_LEAVES, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.TALL_PRAIRIE_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PRAIRIE_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SHORT_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WINTER_GRASS, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SHORT_BEACH_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BEACH_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WILTED_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WEED_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.LEAF_PILE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CLOVER_PATCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.FLOWER_PATCH, RenderLayer.getCutout());


        //Saplings
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ASPEN_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BAOBAB_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BLUE_ENCHANTED_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BLUE_SPRUCE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BROWN_BIRCH_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BROWN_OAK_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CYPRESS_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CIKA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.EBONY_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.FIR_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.GREEN_ENCHANTED_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.HOLLY_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.JACARANDA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.INDIGO_JACARANDA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.JOSHUA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MAHOGANY_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MANGROVE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MAPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.HOLLY_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ORANGE_BIRCH_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ORANGE_OAK_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ORANGE_SPRUCE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ORCHARD_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PALO_VERDE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PINE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PINK_CHERRY_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.RAINBOW_EUCALYPTUS_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.RED_BIRCH_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.RED_MAPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.RED_OAK_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.RED_SPRUCE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.REDWOOD_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SILVER_MAPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SKYRIS_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WHITE_CHERRY_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WILLOW_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WITCH_HAZEL_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ZELKOVA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.YELLOW_BIRCH_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.YELLOW_SPRUCE_SAPLING, RenderLayer.getCutout());

        //Mushrooms
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BLACK_PUFF, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WEEPING_MILKCAP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WOOD_BLEWIT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.GREEN_MUSHSHROOM, RenderLayer.getCutout());


        //FlowerBlocks
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ALLIUM_FLOWER_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ALPINE_BELLFLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.AMARANTH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ANGELICA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.AZALEA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BEGONIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BISTORT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CALIFORNIA_POPPY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CROCUS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BLACK_ROSE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CYAN_AMARANTH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CYAN_ROSE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CYAN_TULIP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.DAFFODIL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.DELPHINIUM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.FAIRY_SLIPPER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.FIRECRACKER_FLOWER_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.FOXGLOVE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.GOLDEN_SPINED_CACTUS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.GREEN_TULIP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.GUZMANIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.INCAN_LILY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.IRIS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.JAPANESE_ORCHID, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.KOVAN_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.LAZARUS_BELLFLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.LOLIPOP_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MAGENTA_AMARANTH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MAGENTA_TULIP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ORANGE_AMARANTH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ORANGE_DAISY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ORSIRIA_ROSE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PEACH_LEATHER_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PINK_ALLIUM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PINK_ALLIUM_FLOWER_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PINK_ANEMONE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PINK_DAFFODIL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PINK_ORCHID, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PROTEA_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PURPLE_AMARANTH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PURPLE_ORCHID, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PURPLE_SAGE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PURPLE_TULIP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.RED_CORNFLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.RED_ORCHID, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.RICHEA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ROSE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SNOWDROPS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SILVER_VASE_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.TORCH_GINGER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.VIOLET_LEATHER_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WHITE_ANEMONE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WHITE_SAGE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WINTER_CYCLAMEN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WINTER_ROSE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WINTER_SCILLA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.YELLOW_DAFFODIL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.YELLOW_TULIP, RenderLayer.getCutout());

        //Other renders
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PURPLE_GLOWSHROOM, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PURPLE_GLOWSHROOM_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BLUE_GLOWSHROOM, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BLUE_GLOWSHROOM_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.RED_GLOWSHROOM_STEM, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.YELLOW_GLOWSHROOM_STEM, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BLACK_ICE, RenderLayer.getTranslucent());
//        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BLUEBERRY_BUSH, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SYTHIAN_SCAFFOLDING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.OVERGROWN_STONE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.OVERGROWN_DACITE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PRAIRIE_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MEADOW_GRASSBLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.GLOWCELIUM, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.POISON_IVY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SKYRIS_VINE, RenderLayer.getCutout());

        BYG.LOGGER.debug("BYG: Texture Cutouts Rendered!");
    }
}
