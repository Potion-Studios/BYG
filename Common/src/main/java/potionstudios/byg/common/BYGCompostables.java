package potionstudios.byg.common;

import com.google.common.base.Suppliers;
import it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.reg.BlockRegistryObject;

import java.util.function.Supplier;

public class BYGCompostables {

    public static final Supplier<Object2FloatOpenHashMap<Item>> COMPOSTABLES = Suppliers.memoize(() -> {
        Object2FloatOpenHashMap<Item> map = new Object2FloatOpenHashMap<>();
        for (BYGWoodTypes type : BYGWoodTypes.values()) {
            BlockRegistryObject<Block> leaves = type.leaves();
            if (leaves != null) {
                map.put(leaves.asItem(), 0.3f);
            }
            BlockRegistryObject<Block> growerItem = type.growerItem();
            if (growerItem != null) {
                map.put(growerItem.asItem(), 0.3f);
            }
        }

        //Leaves
        map.put(BYGItems.BLOOMING_WITCH_HAZEL_LEAVES.get(), 0.3f);
        map.put(BYGItems.BLUE_SPRUCE_LEAVES.get(), 0.3f);
        map.put(BYGItems.BROWN_BIRCH_LEAVES.get(), 0.3f);
        map.put(BYGItems.BROWN_OAK_LEAVES.get(), 0.3f);
        map.put(BYGItems.FLOWERING_ORCHARD_LEAVES.get(), 0.3f);
        map.put(BYGItems.FLOWERING_PALO_VERDE_LEAVES.get(), 0.3f);
        map.put(BYGItems.FLOWERING_JOSHUA_LEAVES.get(), 0.3f);
        map.put(BYGItems.FLOWERING_SKYRIS_LEAVES.get(), 0.3f);
        map.put(BYGItems.FLOWERING_BAOBAB_LEAVES.get(), 0.3f);
        map.put(BYGItems.RIPE_BAOBAB_LEAVES.get(), 0.6f);
        map.put(BYGItems.HOLLY_BERRY_LEAVES.get(), 0.3f);
        map.put(BYGItems.INDIGO_JACARANDA_LEAVES.get(), 0.3f);
        map.put(BYGItems.FLOWERING_INDIGO_JACARANDA_LEAVES.get(), 0.3f);
        map.put(BYGItems.FLOWERING_JACARANDA_LEAVES.get(), 0.3f);
        map.put(BYGItems.ORANGE_BIRCH_LEAVES.get(), 0.3f);
        map.put(BYGItems.ORANGE_OAK_LEAVES.get(), 0.3f);
        map.put(BYGItems.ORANGE_SPRUCE_LEAVES.get(), 0.3f);
        map.put(BYGItems.ORCHARD_LEAVES.get(), 0.3f);
        map.put(BYGItems.PALO_VERDE_LEAVES.get(), 0.3f);
        map.put(BYGItems.RED_MAPLE_LEAVES.get(), 0.3f);
        map.put(BYGItems.RIPE_ORCHARD_LEAVES.get(), 0.6f);
        map.put(BYGItems.SILVER_MAPLE_LEAVES.get(), 0.3f);
        map.put(BYGItems.SKYRIS_LEAVES_GREEN_APPLE.get(), 0.6f);
        map.put(BYGItems.WHITE_CHERRY_LEAVES.get(), 0.3f);
        map.put(BYGItems.YELLOW_BIRCH_LEAVES.get(), 0.3f);
        map.put(BYGItems.YELLOW_SPRUCE_LEAVES.get(), 0.3f);
        map.put(BYGItems.RED_SPRUCE_LEAVES.get(), 0.3f);
        map.put(BYGItems.BROWN_ZELKOVA_LEAVES.get(), 0.3f);
        map.put(BYGItems.FIRECRACKER_LEAVES.get(), 0.3f);
        map.put(BYGItems.JOSHUA_LEAVES.get(), 0.3f);
        map.put(BYGItems.RIPE_JOSHUA_LEAVES.get(), 0.6f);
        map.put(BYGItems.ARAUCARIA_LEAVES.get(), 0.3f);
        map.put(BYGItems.FLOWERING_NIGHTSHADE_LEAVES.get(), 0.3f);
        map.put(BYGItems.RED_OAK_LEAVES.get(), 0.3f);
        map.put(BYGItems.RED_BIRCH_LEAVES.get(), 0.3f);


        //Saplings
        map.put(BYGItems.BLUE_SPRUCE_SAPLING.get(), 0.3f);
        map.put(BYGItems.BROWN_BIRCH_SAPLING.get(), 0.3f);
        map.put(BYGItems.BROWN_OAK_SAPLING.get(), 0.3f);
        map.put(BYGItems.JACARANDA_BUSH.get(), 0.3f);
        map.put(BYGItems.FLOWERING_JACARANDA_BUSH.get(), 0.3f);
        map.put(BYGItems.INDIGO_JACARANDA_SAPLING.get(), 0.3f);
        map.put(BYGItems.INDIGO_JACARANDA_BUSH.get(), 0.3f);
        map.put(BYGItems.FLOWERING_INDIGO_JACARANDA_BUSH.get(), 0.3f);
        map.put(BYGItems.ORANGE_BIRCH_SAPLING.get(), 0.3f);
        map.put(BYGItems.ORANGE_OAK_SAPLING.get(), 0.3f);
        map.put(BYGItems.ORANGE_SPRUCE_SAPLING.get(), 0.3f);
        map.put(BYGItems.ORCHARD_SAPLING.get(), 0.3f);
        map.put(BYGItems.PALO_VERDE_SAPLING.get(), 0.3f);
        map.put(BYGItems.RED_MAPLE_SAPLING.get(), 0.3f);
        map.put(BYGItems.RED_OAK_SAPLING.get(), 0.3f);
        map.put(BYGItems.SILVER_MAPLE_SAPLING.get(), 0.3f);
        map.put(BYGItems.WHITE_CHERRY_SAPLING.get(), 0.3f);
        map.put(BYGItems.YELLOW_BIRCH_SAPLING.get(), 0.3f);
        map.put(BYGItems.YELLOW_SPRUCE_SAPLING.get(), 0.3f);
        map.put(BYGItems.RED_SPRUCE_SAPLING.get(), 0.3f);
        map.put(BYGItems.BROWN_ZELKOVA_SAPLING.get(), 0.3f);
        map.put(BYGItems.RED_BIRCH_SAPLING.get(), 0.3f);
        map.put(BYGItems.RED_OAK_SAPLING.get(), 0.3f);
        map.put(BYGItems.JOSHUA_SAPLING.get(), 0.3f);
        map.put(BYGItems.ARAUCARIA_SAPLING.get(), 0.3f);

        //Flowers
        map.put(BYGItems.ALLIUM_FLOWER_BUSH.get(), 0.65f);
        map.put(BYGItems.TALL_ALLIUM.get(), 0.85f);
        map.put(BYGItems.ALPINE_BELLFLOWER.get(), 0.65f);
        map.put(BYGItems.AMARANTH.get(), 0.65f);
        map.put(BYGItems.ANGELICA.get(), 0.65f);
        map.put(BYGItems.HYDRANGEA_BUSH.get(), 0.85f);
        map.put(BYGItems.HYDRANGEA_HEDGE.get(), 0.85f);
        map.put(BYGItems.BEGONIA.get(), 0.65f);
        map.put(BYGItems.BISTORT.get(), 0.65f);
        map.put(BYGItems.BLACK_ROSE.get(), 0.65f);
        map.put(BYGItems.BLUE_ROSE_BUSH.get(), 0.85f);
        map.put(BYGItems.BLUE_SAGE.get(), 0.65f);
        map.put(BYGItems.CALIFORNIA_POPPY.get(), 0.65f);
        map.put(BYGItems.CROCUS.get(), 0.65f);
        map.put(BYGItems.CYAN_AMARANTH.get(), 0.65f);
        map.put(BYGItems.CYAN_ROSE.get(), 0.65f);
        map.put(BYGItems.CYAN_TULIP.get(), 0.65f);
        map.put(BYGItems.DAFFODIL.get(), 0.65f);
        map.put(BYGItems.DELPHINIUM.get(), 0.65f);
        map.put(BYGItems.FAIRY_SLIPPER.get(), 0.65f);
        map.put(BYGItems.FIRECRACKER_FLOWER_BUSH.get(), 0.65f);
        map.put(BYGItems.FOXGLOVE.get(), 0.85f);
        map.put(BYGItems.GOLDEN_SPINED_CACTUS.get(), 0.65f);
        map.put(BYGItems.GREEN_TULIP.get(), 0.65f);
        map.put(BYGItems.GUZMANIA.get(), 0.65f);
        map.put(BYGItems.INCAN_LILY.get(), 0.65f);
        map.put(BYGItems.IRIS.get(), 0.65f);
        map.put(BYGItems.JAPANESE_ORCHID.get(), 0.85f);
        map.put(BYGItems.KOVAN_FLOWER.get(), 0.65f);
        map.put(BYGItems.LAZARUS_BELLFLOWER.get(), 0.65f);
        map.put(BYGItems.LOLLIPOP_FLOWER.get(), 0.65f);
        map.put(BYGItems.MAGENTA_AMARANTH.get(), 0.65f);
        map.put(BYGItems.MAGENTA_TULIP.get(), 0.65f);
        map.put(BYGItems.ORANGE_AMARANTH.get(), 0.65f);
        map.put(BYGItems.ORANGE_DAISY.get(), 0.65f);
        map.put(BYGItems.ORSIRIA_ROSE.get(), 0.65f);
        map.put(BYGItems.PEACH_LEATHER_FLOWER.get(), 0.65f);
        map.put(BYGItems.PINK_ALLIUM.get(), 0.65f);
        map.put(BYGItems.TALL_PINK_ALLIUM.get(), 0.85f);
        map.put(BYGItems.PINK_ALLIUM_FLOWER_BUSH.get(), 0.65f);
        map.put(BYGItems.PINK_ANEMONE.get(), 0.65f);
        map.put(BYGItems.PINK_DAFFODIL.get(), 0.65f);
        map.put(BYGItems.PRAIRIE_GRASS.get(), 0.65f);
        map.put(BYGItems.SHRUB.get(), 0.65f);
        map.put(BYGItems.PROTEA_FLOWER.get(), 0.65f);
        map.put(BYGItems.PURPLE_AMARANTH.get(), 0.65f);
        map.put(BYGItems.PURPLE_SAGE.get(), 0.65f);
        map.put(BYGItems.PURPLE_TULIP.get(), 0.65f);
        map.put(BYGItems.RICHEA.get(), 0.65f);
        map.put(BYGItems.ROSE.get(), 0.65f);
        map.put(BYGItems.SILVER_VASE_FLOWER.get(), 0.65f);
        map.put(BYGItems.SNOWDROPS.get(), 0.65f);
        map.put(BYGItems.VIOLET_LEATHER_FLOWER.get(), 0.65f);
        map.put(BYGItems.WHITE_ANEMONE.get(), 0.65f);
        map.put(BYGItems.WHITE_SAGE.get(), 0.65f);
        map.put(BYGItems.WINTER_CYCLAMEN.get(), 0.65f);
        map.put(BYGItems.WINTER_ROSE.get(), 0.65f);
        map.put(BYGItems.WINTER_SCILLA.get(), 0.65f);
        map.put(BYGItems.YELLOW_DAFFODIL.get(), 0.65f);
        map.put(BYGItems.YELLOW_TULIP.get(), 0.65f);
        map.put(BYGItems.THEREAL_BELLFLOWER.get(), 0.65f);
        map.put(BYGItems.VERMILION_SCULK_GROWTH.get(), 0.65f);
        map.put(BYGItems.SKYRIS_VINE.get(), 0.65f);
        map.put(BYGItems.WAILING_VINES.get(), 0.65f);

        //Mushroom Blocks
        map.put(BYGItems.GREEN_MUSHROOM_BLOCK.get(), 0.85f);
        map.put(BYGItems.MILKCAP_MUSHROOM_BLOCK.get(), 0.85f);
        map.put(BYGItems.BLEWIT_MUSHROOM_BLOCK.get(), 0.85f);
        map.put(BYGItems.WHITE_MUSHROOM_STEM.get(), 0.85f);
        map.put(BYGItems.BROWN_MUSHROOM_STEM.get(), 0.85f);
        map.put(BYGItems.SOUL_SHROOM_STEM.get(), 0.85f);
        map.put(BYGItems.SOUL_SHROOM_BLOCK.get(), 0.85f);
        map.put(BYGItems.DEATH_CAP_MUSHROOM_BLOCK.get(), 0.85f);
        map.put(BYGItems.PURPLE_SHROOMLIGHT.get(), 0.85f);
        map.put(BYGItems.PURPLE_BULBIS_SHELL.get(), 0.85f);
        map.put(BYGItems.BULBIS_SHELL.get(), 0.85f);

        //Foods
        map.put(BYGItems.JOSHUA_FRUIT.get(), 0.65f);
        map.put(BYGItems.COOKED_JOSHUA_FRUIT.get(), 0.65f);
        map.put(BYGItems.GREEN_APPLE.get(), 0.65f);
        map.put(BYGItems.GREEN_APPLE_PIE.get(), 0.65f);
        map.put(BYGItems.GREEN_MUSHROOM.get(), 0.65f);
        map.put(BYGItems.WHITE_PUFFBALL_CAP.get(), 0.65f);
        map.put(BYGItems.SHELF_FUNGI.get(), 0.65f);
        map.put(BYGItems.WEEPING_MILKCAP.get(), 0.65f);
        map.put(BYGItems.WOOD_BLEWIT.get(), 0.65f);
        map.put(BYGItems.NIGHTSHADE_BERRIES.get(), 0.65f);
        map.put(BYGItems.NIGHTSHADE_BERRY_PIE.get(), 0.65f);
        map.put(BYGItems.BLUE_BERRY.get(), 0.65f);
        map.put(BYGItems.BLUEBERRY_PIE.get(), 0.65f);
        map.put(BYGItems.DEATH_CAP.get(), 0.65f);
        map.put(BYGItems.SOUL_SHROOM.get(), 0.65f);
        map.put(BYGItems.BAOBAB_FRUIT.get(), 0.65f);
        map.put(BYGItems.PURPLE_BULBIS_ODDITY.get(), 0.65f);

        //Plants
        map.put(BYGItems.FLOWER_PATCH.get(), 0.65f);
        map.put(BYGItems.CLOVER_PATCH.get(), 0.65f);
        map.put(BYGItems.LEAF_PILE.get(), 0.65f);
        map.put(BYGItems.SYTHIAN_STALK_BLOCK.get(), 0.65f);
        map.put(BYGItems.CATTAIL_SPROUT.get(), 0.65f);
        map.put(BYGItems.HORSEWEED.get(), 0.65f);
        map.put(BYGItems.MINI_CACTUS.get(), 0.65f);
        map.put(BYGItems.PRICKLY_PEAR_CACTUS.get(), 0.65f);
        map.put(BYGItems.WINTER_SUCCULENT.get(), 0.65f);
        map.put(BYGItems.POISON_IVY.get(), 0.75f);
        map.put(BYGItems.TINY_LILYPADS.get(), 0.65f);
        map.put(BYGItems.ENDER_LILY.get(), 0.65f);

        return map;
    });
}
