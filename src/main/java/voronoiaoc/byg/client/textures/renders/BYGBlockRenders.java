package voronoiaoc.byg.client.textures.renders;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.core.byglists.BYGBlockList;

@Environment(EnvType.CLIENT)
public class BYGBlockRenders {
    public static void renderCutOuts() {
        BYG.LOGGER.debug("BYG: Rendering Texture Cutouts...");

        //Plants
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.HORSEWEED, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MINI_CACTUS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PRICKLY_PEAR_CACTUS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WINTER_SUCCULENT, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.GLOWSTONE_LANTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.NETHER_BRISTLE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.TALL_ALLIUM, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.TALL_PINK_ALLIUM, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PINK_CHERRY_FOLIAGE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WHITE_CHERRY_FOLIAGE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.EMBUR_ROOTS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.TALL_EMBUR_ROOTS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.EMBUR_WART, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.EMBUR_GEL_BLOCK, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.EMBUR_GEL_VINES, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.EMBUR_LILY, RenderType.cutout());


        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WEEPING_ROOTS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WEEPING_ROOTS_PLANT, RenderType.cutout());
        //Nether
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.OVERGROWN_NETHERRACK, RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WARPED_BUSH, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WARPED_CACTUS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WARPED_CORAL_FAN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WARPED_CORAL, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WARPED_CORAL_WALL_FAN, RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SYTHIAN_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SYTHIAN_ROOTS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SYTHIAN_SPROUT, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SYTHIAN_STALK_BLOCK, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SYTHIAN_NYLIUM, RenderType.cutout());

        //End
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.IVIS_ROOTS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.IVIS_SPROUT, RenderType.cutout());


        //Sea Plants
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CATTAIL, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.REEDS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.TINY_LILYPADS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WATER_SILK, RenderType.translucent());

        //GlowCane
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BLUE_GLOWCANE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PINK_GLOWCANE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PURPLE_GLOWCANE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.RED_GLOWCANE, RenderType.cutout());

        //Doors
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ASPEN_DOOR, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BAOBAB_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BLUE_ENCHANTED_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CHERRY_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CIKA_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CYPRESS_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.EBONY_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.FIR_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.GREEN_ENCHANTED_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.HOLLY_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.JACARANDA_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MAHOGANY_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MANGROVE_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MAPLE_DOOR, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PINE_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.RAINBOW_EUCALYPTUS_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.REDWOOD_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SKYRIS_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WILLOW_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WITCH_HAZEL_DOOR, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ZELKOVA_DOOR, RenderType.translucent());

        //Trapdoors
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ASPEN_TRAPDOOR, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BAOBAB_TRAPDOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BLUE_ENCHANTED_TRAPDOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CHERRY_TRAPDOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CIKA_TRAPDOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CYPRESS_TRAPDOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.EBONY_TRAPDOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.FIR_TRAPDOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.GREEN_ENCHANTED_TRAPDOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.HOLLY_TRAPDOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.JACARANDA_TRAPDOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MAHOGANY_TRAPDOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MANGROVE_TRAPDOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MAPLE_TRAPDOOR, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PINE_TRAPDOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.RAINBOW_EUCALYPTUS_TRAPDOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.REDWOOD_TRAPDOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SKYRIS_TRAPDOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WILLOW_TRAPDOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WITCH_HAZEL_TRAPDOOR, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ZELKOVA_TRAPDOOR, RenderType.translucent());

        //Grass
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BLOOMING_WITCH_HAZEL_LEAVES, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.TALL_PRAIRIE_GRASS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PRAIRIE_GRASS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SHORT_GRASS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WINTER_GRASS, RenderType.translucent());

        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SHORT_BEACH_GRASS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BEACH_GRASS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WILTED_GRASS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WEED_GRASS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.LEAF_PILE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CLOVER_PATCH, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.FLOWER_PATCH, RenderType.cutout());


        //Saplings
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ASPEN_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BAOBAB_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BLUE_ENCHANTED_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BLUE_SPRUCE_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BROWN_BIRCH_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BROWN_OAK_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CYPRESS_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CIKA_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.EBONY_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.FIR_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.GREEN_ENCHANTED_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.HOLLY_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.JACARANDA_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.INDIGO_JACARANDA_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.JOSHUA_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MAHOGANY_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MANGROVE_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MAPLE_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.HOLLY_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ORANGE_BIRCH_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ORANGE_OAK_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ORANGE_SPRUCE_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ORCHARD_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PALO_VERDE_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PINE_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PINK_CHERRY_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.RAINBOW_EUCALYPTUS_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.RED_BIRCH_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.RED_MAPLE_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.RED_OAK_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.RED_SPRUCE_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.REDWOOD_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SILVER_MAPLE_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SKYRIS_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WHITE_CHERRY_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WILLOW_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WITCH_HAZEL_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ZELKOVA_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.YELLOW_BIRCH_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.YELLOW_SPRUCE_SAPLING, RenderType.cutout());

        //Mushrooms
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BLACK_PUFF, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WEEPING_MILKCAP, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WOOD_BLEWIT, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.GREEN_MUSHSHROOM, RenderType.cutout());


        //FlowerBlocks
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ALLIUM_FLOWER_BUSH, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ALPINE_BELLFLOWER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.AMARANTH, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ANGELICA, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.AZALEA, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BEGONIA, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BISTORT, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CALIFORNIA_POPPY, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CROCUS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BLACK_ROSE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CYAN_AMARANTH, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CYAN_ROSE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.CYAN_TULIP, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.DAFFODIL, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.DELPHINIUM, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.FAIRY_SLIPPER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.FIRECRACKER_FLOWER_BUSH, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.FOXGLOVE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.GOLDEN_SPINED_CACTUS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.GREEN_TULIP, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.GUZMANIA, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.INCAN_LILY, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.IRIS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.JAPANESE_ORCHID, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.KOVAN_FLOWER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.LAZARUS_BELLFLOWER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.LOLIPOP_FLOWER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MAGENTA_AMARANTH, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MAGENTA_TULIP, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ORANGE_AMARANTH, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ORANGE_DAISY, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ORSIRIA_ROSE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PEACH_LEATHER_FLOWER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PINK_ALLIUM, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PINK_ALLIUM_FLOWER_BUSH, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PINK_ANEMONE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PINK_DAFFODIL, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PINK_ORCHID, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PROTEA_FLOWER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PURPLE_AMARANTH, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PURPLE_ORCHID, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PURPLE_SAGE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PURPLE_TULIP, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.RED_CORNFLOWER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.RED_ORCHID, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.RICHEA, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.ROSE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SNOWDROPS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SILVER_VASE_FLOWER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.TORCH_GINGER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.VIOLET_LEATHER_FLOWER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WHITE_ANEMONE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WHITE_SAGE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WINTER_CYCLAMEN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WINTER_ROSE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.WINTER_SCILLA, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.YELLOW_DAFFODIL, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.YELLOW_TULIP, RenderType.cutout());

        //Other renders
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PURPLE_GLOWSHROOM, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PURPLE_GLOWSHROOM_BLOCK, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BLUE_GLOWSHROOM, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BLUE_GLOWSHROOM_BLOCK, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.RED_GLOWSHROOM_STEM, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.YELLOW_GLOWSHROOM_STEM, RenderType.translucent());

        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BLACK_ICE, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.BLUEBERRY_BUSH, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SYTHIAN_SCAFFOLDING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.OVERGROWN_STONE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.OVERGROWN_DACITE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.PRAIRIE_GRASS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.MEADOW_GRASSBLOCK, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.GLOWCELIUM, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.POISON_IVY, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BYGBlockList.SKYRIS_VINE, RenderType.cutout());

        BYG.LOGGER.debug("BYG: Texture Cutouts Rendered!");
    }
}
