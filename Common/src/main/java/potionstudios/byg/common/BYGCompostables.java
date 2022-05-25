package potionstudios.byg.common;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.common.item.BYGItems;

import javax.annotation.Nullable;

public class BYGCompostables {
    public static void compostibleBlocks(float chance, @Nullable ItemLike item) {
        if (item != null)
            ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
    }

    public static void compostablesBYG() {
        BYG.LOGGER.debug("BYG: Adding Compostible Blocks...");

        for (BYGWoodTypes type : BYGWoodTypes.values()) {
            compostibleBlocks(0.3f, type.leaves());
            compostibleBlocks(0.3f, type.growerItem());
        }

        //Leaves
        compostibleBlocks(0.3f, BYGItems.BLOOMING_WITCH_HAZEL_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.BLUE_SPRUCE_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.BROWN_BIRCH_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.BROWN_OAK_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.FLOWERING_ORCHARD_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.FLOWERING_PALO_VERDE_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.HOLLY_BERRY_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.JACARANDA_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.INDIGO_JACARANDA_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.FLOWERING_INDIGO_JACARANDA_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.FLOWERING_JACARANDA_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.ORANGE_BIRCH_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.ORANGE_OAK_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.ORANGE_SPRUCE_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.ORCHARD_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.PALO_VERDE_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.PINK_CHERRY_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.RED_MAPLE_LEAVES.get());
        compostibleBlocks(0.6f, BYGItems.RIPE_ORCHARD_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.SILVER_MAPLE_LEAVES.get());
        compostibleBlocks(0.6f, BYGItems.SKYRIS_LEAVES_GREEN_APPLE.get());
        compostibleBlocks(0.3f, BYGItems.SKYRIS_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.WHITE_CHERRY_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.YELLOW_BIRCH_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.YELLOW_SPRUCE_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.RED_SPRUCE_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.BROWN_ZELKOVA_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.NIGHTSHADE_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.LAMENT_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.WITHERING_OAK_LEAVES.get());
        compostibleBlocks(0.3f, BYGItems.FIRECRACKER_LEAVES.get());

        //Saplings
        compostibleBlocks(0.3f, BYGItems.BLUE_SPRUCE_SAPLING.get());
        compostibleBlocks(0.3f, BYGItems.BROWN_BIRCH_SAPLING.get());
        compostibleBlocks(0.3f, BYGItems.BROWN_OAK_SAPLING.get());
        compostibleBlocks(0.3f, BYGItems.JACARANDA_SAPLING.get());
        compostibleBlocks(0.3f, BYGItems.JACARANDA_BUSH.get());
        compostibleBlocks(0.3f, BYGItems.FLOWERING_JACARANDA_BUSH.get());
        compostibleBlocks(0.3f, BYGItems.INDIGO_JACARANDA_SAPLING.get());
        compostibleBlocks(0.3f, BYGItems.INDIGO_JACARANDA_BUSH.get());
        compostibleBlocks(0.3f, BYGItems.FLOWERING_INDIGO_JACARANDA_BUSH.get());
        compostibleBlocks(0.3f, BYGItems.ORANGE_BIRCH_SAPLING.get());
        compostibleBlocks(0.3f, BYGItems.ORANGE_OAK_SAPLING.get());
        compostibleBlocks(0.3f, BYGItems.ORANGE_SPRUCE_SAPLING.get());
        compostibleBlocks(0.3f, BYGItems.ORCHARD_SAPLING.get());
        compostibleBlocks(0.3f, BYGItems.PALO_VERDE_SAPLING.get());
        compostibleBlocks(0.3f, BYGItems.PINK_CHERRY_SAPLING.get());
        compostibleBlocks(0.3f, BYGItems.RED_MAPLE_SAPLING.get());
        compostibleBlocks(0.3f, BYGItems.RED_OAK_SAPLING.get());
        compostibleBlocks(0.3f, BYGItems.SILVER_MAPLE_SAPLING.get());
        compostibleBlocks(0.3f, BYGItems.SKYRIS_SAPLING.get());
        compostibleBlocks(0.3f, BYGItems.WHITE_CHERRY_SAPLING.get());
        compostibleBlocks(0.3f, BYGItems.YELLOW_BIRCH_SAPLING.get());
        compostibleBlocks(0.3f, BYGItems.YELLOW_SPRUCE_SAPLING.get());
        compostibleBlocks(0.3f, BYGItems.RED_SPRUCE_SAPLING.get());
        compostibleBlocks(0.3f, BYGItems.BROWN_ZELKOVA_SAPLING.get());
        compostibleBlocks(0.3f, BYGItems.NIGHTSHADE_SAPLING.get());
        compostibleBlocks(0.3f, BYGItems.LAMENT_SAPLING.get());
        compostibleBlocks(0.3f, BYGItems.WITHERING_OAK_SAPLING.get());

        //Flowers
        compostibleBlocks(0.65f, BYGItems.ALLIUM_FLOWER_BUSH.get());
        compostibleBlocks(0.85f, BYGItems.TALL_ALLIUM.get());
        compostibleBlocks(0.65f, BYGItems.ALPINE_BELLFLOWER.get());
        compostibleBlocks(0.65f, BYGItems.AMARANTH.get());
        compostibleBlocks(0.65f, BYGItems.ANGELICA.get());
        compostibleBlocks(0.85f, BYGItems.HYDRANGEA_BUSH.get());
        compostibleBlocks(0.85f, BYGItems.HYDRANGEA_HEDGE.get());
        compostibleBlocks(0.65f, BYGItems.BEGONIA.get());
        compostibleBlocks(0.65f, BYGItems.BISTORT.get());
        compostibleBlocks(0.65f, BYGItems.BLACK_ROSE.get());
        compostibleBlocks(0.65f, BYGItems.BLUE_SAGE.get());
        compostibleBlocks(0.65f, BYGItems.CALIFORNIA_POPPY.get());
        compostibleBlocks(0.65f, BYGItems.CROCUS.get());
        compostibleBlocks(0.65f, BYGItems.CYAN_AMARANTH.get());
        compostibleBlocks(0.65f, BYGItems.CYAN_ROSE.get());
        compostibleBlocks(0.65f, BYGItems.CYAN_TULIP.get());
        compostibleBlocks(0.65f, BYGItems.DAFFODIL.get());
        compostibleBlocks(0.65f, BYGItems.DELPHINIUM.get());
        compostibleBlocks(0.65f, BYGItems.FAIRY_SLIPPER.get());
        compostibleBlocks(0.65f, BYGItems.FIRECRACKER_FLOWER_BUSH.get());
        compostibleBlocks(0.85f, BYGItems.FOXGLOVE.get());
        compostibleBlocks(0.65f, BYGItems.GOLDEN_SPINED_CACTUS.get());
        compostibleBlocks(0.65f, BYGItems.GREEN_TULIP.get());
        compostibleBlocks(0.65f, BYGItems.GUZMANIA.get());
        compostibleBlocks(0.65f, BYGItems.INCAN_LILY.get());
        compostibleBlocks(0.65f, BYGItems.IRIS.get());
        compostibleBlocks(0.85f, BYGItems.JAPANESE_ORCHID.get());
        compostibleBlocks(0.65f, BYGItems.KOVAN_FLOWER.get());
        compostibleBlocks(0.65f, BYGItems.LAZARUS_BELLFLOWER.get());
        compostibleBlocks(0.65f, BYGItems.LOLLIPOP_FLOWER.get());
        compostibleBlocks(0.65f, BYGItems.MAGENTA_AMARANTH.get());
        compostibleBlocks(0.65f, BYGItems.MAGENTA_TULIP.get());
        compostibleBlocks(0.65f, BYGItems.ORANGE_DAISY.get());
        compostibleBlocks(0.65f, BYGItems.ORSIRIA_ROSE.get());
        compostibleBlocks(0.65f, BYGItems.PEACH_LEATHER_FLOWER.get());
        compostibleBlocks(0.65f, BYGItems.PINK_ALLIUM.get());
        compostibleBlocks(0.85f, BYGItems.TALL_PINK_ALLIUM.get());
        compostibleBlocks(0.65f, BYGItems.PINK_ALLIUM_FLOWER_BUSH.get());
        compostibleBlocks(0.65f, BYGItems.PINK_ANEMONE.get());
        compostibleBlocks(0.65f, BYGItems.PINK_DAFFODIL.get());
        compostibleBlocks(0.65f, BYGItems.PRAIRIE_GRASS.get());
        compostibleBlocks(0.65f, BYGItems.SHRUB.get());
        compostibleBlocks(0.65f, BYGItems.PROTEA_FLOWER.get());
        compostibleBlocks(0.65f, BYGItems.PURPLE_AMARANTH.get());
        compostibleBlocks(0.65f, BYGItems.PURPLE_SAGE.get());
        compostibleBlocks(0.65f, BYGItems.PURPLE_TULIP.get());
        compostibleBlocks(0.65f, BYGItems.RICHEA.get());
        compostibleBlocks(0.65f, BYGItems.ROSE.get());
        compostibleBlocks(0.65f, BYGItems.SILVER_VASE_FLOWER.get());
        compostibleBlocks(0.65f, BYGItems.SNOWDROPS.get());
        compostibleBlocks(0.65f, BYGItems.TORCH_GINGER.get());
        compostibleBlocks(0.65f, BYGItems.VIOLET_LEATHER_FLOWER.get());
        compostibleBlocks(0.65f, BYGItems.WHITE_ANEMONE.get());
        compostibleBlocks(0.65f, BYGItems.WHITE_SAGE.get());
        compostibleBlocks(0.65f, BYGItems.WINTER_CYCLAMEN.get());
        compostibleBlocks(0.65f, BYGItems.WINTER_ROSE.get());
        compostibleBlocks(0.65f, BYGItems.WINTER_SCILLA.get());
        compostibleBlocks(0.65f, BYGItems.YELLOW_DAFFODIL.get());
        compostibleBlocks(0.65f, BYGItems.YELLOW_TULIP.get());
        compostibleBlocks(0.65f, BYGItems.THEREAL_BELLFLOWER.get());
        compostibleBlocks(0.65f, BYGItems.VERMILION_SCULK_GROWTH.get());
        compostibleBlocks(0.65f, BYGItems.SHULKREN_MOSS_BLANKET.get());
        compostibleBlocks(0.65f, BYGItems.SHULKREN_VINE.get());
        compostibleBlocks(0.65f, BYGItems.LAMENT_VINE.get());
        compostibleBlocks(0.65f, BYGItems.SKYRIS_VINE.get());
        compostibleBlocks(0.65f, BYGItems.WAILING_VINES.get());
        compostibleBlocks(0.65f, BYGItems.EMBUR_GEL_VINES.get());

        //Mushroom Blocks
        compostibleBlocks(0.85f, BYGItems.GREEN_MUSHROOM_BLOCK.get());
        compostibleBlocks(0.85f, BYGItems.MILKCAP_MUSHROOM_BLOCK.get());
        compostibleBlocks(0.85f, BYGItems.BLEWIT_MUSHROOM_BLOCK.get());
        compostibleBlocks(0.85f, BYGItems.WHITE_MUSHROOM_STEM.get());
        compostibleBlocks(0.85f, BYGItems.BROWN_MUSHROOM_STEM.get());
        compostibleBlocks(0.85f, BYGItems.SOUL_SHROOM_STEM.get());
        compostibleBlocks(0.85f, BYGItems.SOUL_SHROOM_BLOCK.get());
        compostibleBlocks(0.85f, BYGItems.DEATH_CAP_MUSHROOM_BLOCK.get());
        compostibleBlocks(0.85f, BYGItems.SHULKREN_WART_BLOCK.get());
        compostibleBlocks(0.85f, BYGItems.PURPLE_SHROOMLIGHT.get());
        compostibleBlocks(0.85f, BYGItems.PURPLE_BULBIS_SHELL.get());
        compostibleBlocks(0.85f, BYGItems.BULBIS_SHELL.get());

        //Foods
        compostibleBlocks(0.65f, BYGItems.CRIMSON_BERRIES.get());
        compostibleBlocks(0.65f, BYGItems.CRIMSON_BERRY_PIE.get());
        compostibleBlocks(0.65f, BYGItems.GREEN_APPLE.get());
        compostibleBlocks(0.65f, BYGItems.GREEN_APPLE_PIE.get());
        compostibleBlocks(0.65f, BYGItems.GREEN_MUSHROOM.get());
        compostibleBlocks(0.65f, BYGItems.WHITE_PUFFBALL_CAP.get());
        compostibleBlocks(0.65f, BYGItems.WEEPING_MILKCAP.get());
        compostibleBlocks(0.65f, BYGItems.WOOD_BLEWIT.get());
        compostibleBlocks(0.65f, BYGItems.NIGHTSHADE_BERRIES.get());
        compostibleBlocks(0.65f, BYGItems.NIGHTSHADE_BERRY_PIE.get());
        compostibleBlocks(0.65f, BYGItems.BLUE_BERRY.get());
        compostibleBlocks(0.65f, BYGItems.BLUEBERRY_PIE.get());
        compostibleBlocks(0.65f, BYGItems.SHULKREN_FUNGUS.get());
        compostibleBlocks(0.65f, BYGItems.DEATH_CAP.get());
        compostibleBlocks(0.65f, BYGItems.SOUL_SHROOM.get());
        compostibleBlocks(0.65f, BYGItems.BAOBAB_FRUIT.get());
        compostibleBlocks(0.65f, BYGItems.PURPLE_BULBIS_ODDITY.get());

        //Plants
        compostibleBlocks(0.65f, BYGItems.FLOWER_PATCH.get());
        compostibleBlocks(0.65f, BYGItems.CLOVER_PATCH.get());
        compostibleBlocks(0.65f, BYGItems.LEAF_PILE.get());
        compostibleBlocks(0.65f, BYGItems.SYTHIAN_STALK_BLOCK.get());
        compostibleBlocks(0.65f, BYGItems.CATTAIL_SPROUT.get());
        compostibleBlocks(0.65f, BYGItems.HORSEWEED.get());
        compostibleBlocks(0.65f, BYGItems.MINI_CACTUS.get());
        compostibleBlocks(0.65f, BYGItems.PRICKLY_PEAR_CACTUS.get());
        compostibleBlocks(0.65f, BYGItems.WINTER_SUCCULENT.get());
        compostibleBlocks(0.75f, BYGItems.POISON_IVY.get());
        compostibleBlocks(0.65f, BYGItems.TINY_LILYPADS.get());
        compostibleBlocks(0.65f, BYGItems.ENDER_LILY.get());
        compostibleBlocks(0.65f, BYGItems.EMBUR_LILY.get());

        BYG.LOGGER.info("BYG: Compostible Blocks Added!");
    }
}
