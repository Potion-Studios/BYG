package potionstudios.byg.common;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.mixin.access.FireBlockAccess;
import potionstudios.byg.reg.RegistryObject;

import javax.annotation.Nullable;

public class BYGFlammables {
    public static void flammableBlock(@Nullable Block block, int flameOdds, int burnOdds) {
        if (block != null) {
            FireBlock fire = (FireBlock) Blocks.FIRE;
            ((FireBlockAccess) fire).byg_setFlammable(block, flameOdds, burnOdds);
        }
    }
    public static void flammableBlock(@Nullable RegistryObject<? extends Block> block, int flameOdds, int burnOdds) {
        flammableBlock(block == null ? null : block.get(), flameOdds, burnOdds);
    }

    public static void flammablesBYG() {
        BYG.LOGGER.debug("BYG: Adding Flammables...");

        for (BYGWoodTypes type : BYGWoodTypes.values()) {
            flammableBlock(type.log(), 5, 5);
            flammableBlock(type.strippedLog(), 5, 5);
            flammableBlock(type.wood(), 5, 5);
            flammableBlock(type.strippedWood(), 5, 5);
            flammableBlock(type.bookshelf(), 5, 20);
            flammableBlock(type.slab(), 5, 20);
            flammableBlock(type.stairs(), 5, 20);
            flammableBlock(type.planks(), 5, 20);
            flammableBlock(type.fence(), 5, 20);
            flammableBlock(type.leaves(), 30, 60);
        }

        //Logs
        flammableBlock(BYGBlocks.EBONY_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.FIR_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.GREEN_ENCHANTED_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.HOLLY_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.JACARANDA_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.MAHOGANY_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.MANGROVE_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.MAPLE_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.PALO_VERDE_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.PINE_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.RAINBOW_EUCALYPTUS_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.REDWOOD_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.WILLOW_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.WITCH_HAZEL_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.ZELKOVA_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.PALM_LOG.get(), 5, 5);

        //Stripped Logs
        flammableBlock(BYGBlocks.STRIPPED_EBONY_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_FIR_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_GREEN_ENCHANTED_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_HOLLY_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_JACARANDA_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_MAHOGANY_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_MANGROVE_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_MAPLE_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_PALO_VERDE_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_RAINBOW_EUCALYPTUS_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_SKYRIS_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_WILLOW_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_WITCH_HAZEL_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_ZELKOVA_LOG.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_PALM_LOG.get(), 5, 5);

        //Wood
        flammableBlock(BYGBlocks.EBONY_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.FIR_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.GREEN_ENCHANTED_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.HOLLY_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.JACARANDA_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.MAHOGANY_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.MANGROVE_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.MAPLE_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.PALO_VERDE_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.PINE_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.RAINBOW_EUCALYPTUS_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.REDWOOD_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.WILLOW_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.WITCH_HAZEL_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.ZELKOVA_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.PALM_WOOD.get(), 5, 5);

        //Stripped Wood
        flammableBlock(BYGBlocks.STRIPPED_EBONY_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_FIR_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_GREEN_ENCHANTED_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_HOLLY_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_JACARANDA_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_MAHOGANY_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_MANGROVE_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_MAPLE_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_PALO_VERDE_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_RAINBOW_EUCALYPTUS_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_SKYRIS_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_WILLOW_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_WITCH_HAZEL_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_ZELKOVA_WOOD.get(), 5, 5);
        flammableBlock(BYGBlocks.STRIPPED_PALM_WOOD.get(), 5, 5);

        //BookShelves
        flammableBlock(BYGBlocks.EBONY_BOOKSHELF.get(), 5, 20);
        flammableBlock(BYGBlocks.FIR_BOOKSHELF.get(), 5, 20);
        flammableBlock(BYGBlocks.GREEN_ENCHANTED_BOOKSHELF.get(), 5, 20);
        flammableBlock(BYGBlocks.HOLLY_BOOKSHELF.get(), 5, 20);
        flammableBlock(BYGBlocks.JACARANDA_BOOKSHELF.get(), 5, 20);
        flammableBlock(BYGBlocks.MAHOGANY_BOOKSHELF.get(), 5, 20);
        flammableBlock(BYGBlocks.MANGROVE_BOOKSHELF.get(), 5, 20);
        flammableBlock(BYGBlocks.MAPLE_BOOKSHELF.get(), 5, 20);
        flammableBlock(BYGBlocks.PINE_BOOKSHELF.get(), 5, 20);
        flammableBlock(BYGBlocks.RAINBOW_EUCALYPTUS_BOOKSHELF.get(), 5, 20);
        flammableBlock(BYGBlocks.REDWOOD_BOOKSHELF.get(), 5, 20);
        flammableBlock(BYGBlocks.SKYRIS_BOOKSHELF.get(), 5, 20);
        flammableBlock(BYGBlocks.WILLOW_BOOKSHELF.get(), 5, 20);
        flammableBlock(BYGBlocks.WITCH_HAZEL_BOOKSHELF.get(), 5, 20);
        flammableBlock(BYGBlocks.ZELKOVA_BOOKSHELF.get(), 5, 20);
        flammableBlock(BYGBlocks.PALM_BOOKSHELF.get(), 5, 20);

        //Slabs
        flammableBlock(BYGBlocks.EBONY_SLAB.get(), 5, 20);
        flammableBlock(BYGBlocks.FIR_SLAB.get(), 5, 20);
        flammableBlock(BYGBlocks.GREEN_ENCHANTED_SLAB.get(), 5, 20);
        flammableBlock(BYGBlocks.HOLLY_SLAB.get(), 5, 20);
        flammableBlock(BYGBlocks.JACARANDA_SLAB.get(), 5, 20);
        flammableBlock(BYGBlocks.MAHOGANY_SLAB.get(), 5, 20);
        flammableBlock(BYGBlocks.MANGROVE_SLAB.get(), 5, 20);
        flammableBlock(BYGBlocks.MAPLE_SLAB.get(), 5, 20);
        flammableBlock(BYGBlocks.PINE_SLAB.get(), 5, 20);
        flammableBlock(BYGBlocks.RAINBOW_EUCALYPTUS_SLAB.get(), 5, 20);
        flammableBlock(BYGBlocks.REDWOOD_SLAB.get(), 5, 20);
        flammableBlock(BYGBlocks.SKYRIS_SLAB.get(), 5, 20);
        flammableBlock(BYGBlocks.WILLOW_SLAB.get(), 5, 20);
        flammableBlock(BYGBlocks.WITCH_HAZEL_SLAB.get(), 5, 20);
        flammableBlock(BYGBlocks.ZELKOVA_SLAB.get(), 5, 20);
        flammableBlock(BYGBlocks.PALM_SLAB.get(), 5, 20);

        //Stairs
        flammableBlock(BYGBlocks.EBONY_STAIRS.get(), 5, 20);
        flammableBlock(BYGBlocks.FIR_STAIRS.get(), 5, 20);
        flammableBlock(BYGBlocks.GREEN_ENCHANTED_STAIRS.get(), 5, 20);
        flammableBlock(BYGBlocks.HOLLY_STAIRS.get(), 5, 20);
        flammableBlock(BYGBlocks.JACARANDA_STAIRS.get(), 5, 20);
        flammableBlock(BYGBlocks.MAHOGANY_STAIRS.get(), 5, 20);
        flammableBlock(BYGBlocks.MANGROVE_STAIRS.get(), 5, 20);
        flammableBlock(BYGBlocks.MAPLE_STAIRS.get(), 5, 20);
        flammableBlock(BYGBlocks.PINE_STAIRS.get(), 5, 20);
        flammableBlock(BYGBlocks.RAINBOW_EUCALYPTUS_STAIRS.get(), 5, 20);
        flammableBlock(BYGBlocks.REDWOOD_STAIRS.get(), 5, 20);
        flammableBlock(BYGBlocks.SKYRIS_STAIRS.get(), 5, 20);
        flammableBlock(BYGBlocks.WILLOW_STAIRS.get(), 5, 20);
        flammableBlock(BYGBlocks.WITCH_HAZEL_STAIRS.get(), 5, 20);
        flammableBlock(BYGBlocks.ZELKOVA_STAIRS.get(), 5, 20);
        flammableBlock(BYGBlocks.ZELKOVA_STAIRS.get(), 5, 20);

        //Planks
        flammableBlock(BYGBlocks.EBONY_PLANKS.get(), 5, 20);
        flammableBlock(BYGBlocks.FIR_PLANKS.get(), 5, 20);
        flammableBlock(BYGBlocks.GREEN_ENCHANTED_PLANKS.get(), 5, 20);
        flammableBlock(BYGBlocks.HOLLY_PLANKS.get(), 5, 20);
        flammableBlock(BYGBlocks.JACARANDA_PLANKS.get(), 5, 20);
        flammableBlock(BYGBlocks.MAHOGANY_PLANKS.get(), 5, 20);
        flammableBlock(BYGBlocks.MANGROVE_PLANKS.get(), 5, 20);
        flammableBlock(BYGBlocks.MAPLE_PLANKS.get(), 5, 20);
        flammableBlock(BYGBlocks.PINE_PLANKS.get(), 5, 20);
        flammableBlock(BYGBlocks.RAINBOW_EUCALYPTUS_PLANKS.get(), 5, 20);
        flammableBlock(BYGBlocks.REDWOOD_PLANKS.get(), 5, 20);
        flammableBlock(BYGBlocks.SKYRIS_PLANKS.get(), 5, 20);
        flammableBlock(BYGBlocks.WILLOW_PLANKS.get(), 5, 20);
        flammableBlock(BYGBlocks.WITCH_HAZEL_PLANKS.get(), 5, 20);
        flammableBlock(BYGBlocks.ZELKOVA_PLANKS.get(), 5, 20);
        flammableBlock(BYGBlocks.PALM_PLANKS.get(), 5, 20);

        //Fences
        flammableBlock(BYGBlocks.EBONY_FENCE.get(), 5, 20);
        flammableBlock(BYGBlocks.FIR_FENCE.get(), 5, 20);
        flammableBlock(BYGBlocks.GREEN_ENCHANTED_FENCE.get(), 5, 20);
        flammableBlock(BYGBlocks.HOLLY_FENCE.get(), 5, 20);
        flammableBlock(BYGBlocks.JACARANDA_FENCE.get(), 5, 20);
        flammableBlock(BYGBlocks.MAHOGANY_FENCE.get(), 5, 20);
        flammableBlock(BYGBlocks.MANGROVE_FENCE.get(), 5, 20);
        flammableBlock(BYGBlocks.MAPLE_FENCE.get(), 5, 20);
        flammableBlock(BYGBlocks.PINE_FENCE.get(), 5, 20);
        flammableBlock(BYGBlocks.RAINBOW_EUCALYPTUS_FENCE.get(), 5, 20);
        flammableBlock(BYGBlocks.REDWOOD_FENCE.get(), 5, 20);
        flammableBlock(BYGBlocks.SKYRIS_FENCE.get(), 5, 20);
        flammableBlock(BYGBlocks.WILLOW_FENCE.get(), 5, 20);
        flammableBlock(BYGBlocks.WITCH_HAZEL_FENCE.get(), 5, 20);
        flammableBlock(BYGBlocks.ZELKOVA_FENCE.get(), 5, 20);
        flammableBlock(BYGBlocks.ZELKOVA_FENCE.get(), 5, 20);

        //Leaves
        flammableBlock(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.BLUE_SPRUCE_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.BROWN_BIRCH_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.BROWN_OAK_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.EBONY_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.FIR_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.FLOWERING_ORCHARD_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.FLOWERING_PALO_VERDE_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.GREEN_ENCHANTED_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.HOLLY_BERRY_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.HOLLY_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.JACARANDA_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.MAHOGANY_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.MANGROVE_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.ORANGE_BIRCH_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.ORANGE_OAK_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.ORCHARD_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.PALO_VERDE_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.PINE_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.PINK_CHERRY_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.RAINBOW_EUCALYPTUS_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.REDWOOD_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.RED_OAK_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.RIPE_ORCHARD_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.SILVER_MAPLE_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.MAPLE_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.RED_MAPLE_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE.get(), 30, 60);
        flammableBlock(BYGBlocks.SKYRIS_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.WHITE_CHERRY_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.WILLOW_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.WITCH_HAZEL_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.YELLOW_BIRCH_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.PALM_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.FIRECRACKER_LEAVES.get(), 60, 30);
        flammableBlock(BYGBlocks.ZELKOVA_LEAVES.get(), 60, 30);
        flammableBlock(BYGBlocks.RED_BIRCH_LEAVES.get(), 60, 30);
        flammableBlock(BYGBlocks.RED_SPRUCE_LEAVES.get(), 60, 30);

        //Flowers
        flammableBlock(BYGBlocks.ALLIUM_FLOWER_BUSH.get(), 60, 100);
        flammableBlock(BYGBlocks.ALPINE_BELLFLOWER.get(), 60, 100);
        flammableBlock(BYGBlocks.AMARANTH.get(), 60, 100);
        flammableBlock(BYGBlocks.ANGELICA.get(), 60, 100);
        flammableBlock(BYGBlocks.HYDRANGEA_BUSH.get(), 60, 100);
        flammableBlock(BYGBlocks.HYDRANGEA_HEDGE.get(), 60, 100);
        flammableBlock(BYGBlocks.BEGONIA.get(), 60, 100);
        flammableBlock(BYGBlocks.BISTORT.get(), 60, 100);
        flammableBlock(BYGBlocks.BLACK_ROSE.get(), 60, 100);
        flammableBlock(BYGBlocks.BLUE_SAGE.get(), 60, 100);
        flammableBlock(BYGBlocks.CALIFORNIA_POPPY.get(), 60, 100);
        flammableBlock(BYGBlocks.CROCUS.get(), 60, 100);
        flammableBlock(BYGBlocks.CYAN_AMARANTH.get(), 60, 100);
        flammableBlock(BYGBlocks.CYAN_ROSE.get(), 60, 100);
        flammableBlock(BYGBlocks.CYAN_TULIP.get(), 60, 100);
        flammableBlock(BYGBlocks.DAFFODIL.get(), 60, 100);
        flammableBlock(BYGBlocks.DELPHINIUM.get(), 60, 100);
        flammableBlock(BYGBlocks.FAIRY_SLIPPER.get(), 60, 100);
        flammableBlock(BYGBlocks.FIRECRACKER_FLOWER_BUSH.get(), 60, 100);
        flammableBlock(BYGBlocks.FOXGLOVE.get(), 60, 100);
        flammableBlock(BYGBlocks.GOLDEN_SPINED_CACTUS.get(), 60, 100);
        flammableBlock(BYGBlocks.GREEN_TULIP.get(), 60, 100);
        flammableBlock(BYGBlocks.GUZMANIA.get(), 60, 100);
        flammableBlock(BYGBlocks.INCAN_LILY.get(), 60, 100);
        flammableBlock(BYGBlocks.IRIS.get(), 60, 100);
        flammableBlock(BYGBlocks.JAPANESE_ORCHID.get(), 60, 100);
        flammableBlock(BYGBlocks.KOVAN_FLOWER.get(), 60, 100);
        flammableBlock(BYGBlocks.LAZARUS_BELLFLOWER.get(), 60, 100);
        flammableBlock(BYGBlocks.LOLLIPOP_FLOWER.get(), 60, 100);
        flammableBlock(BYGBlocks.MAGENTA_AMARANTH.get(), 60, 100);
        flammableBlock(BYGBlocks.MAGENTA_TULIP.get(), 60, 100);
        flammableBlock(BYGBlocks.ORANGE_DAISY.get(), 60, 100);
        flammableBlock(BYGBlocks.ORSIRIA_ROSE.get(), 60, 100);
        flammableBlock(BYGBlocks.PEACH_LEATHER_FLOWER.get(), 60, 100);
        flammableBlock(BYGBlocks.PINK_ALLIUM.get(), 60, 100);
        flammableBlock(BYGBlocks.PINK_ALLIUM_FLOWER_BUSH.get(), 60, 100);
        flammableBlock(BYGBlocks.PINK_ANEMONE.get(), 60, 100);
        flammableBlock(BYGBlocks.PINK_DAFFODIL.get(), 60, 100);
        flammableBlock(BYGBlocks.PRAIRIE_GRASS.get(), 60, 100);
        flammableBlock(BYGBlocks.PROTEA_FLOWER.get(), 60, 100);
        flammableBlock(BYGBlocks.PURPLE_AMARANTH.get(), 60, 100);
        flammableBlock(BYGBlocks.PURPLE_SAGE.get(), 60, 100);
        flammableBlock(BYGBlocks.PURPLE_TULIP.get(), 60, 100);
        flammableBlock(BYGBlocks.RICHEA.get(), 60, 100);
        flammableBlock(BYGBlocks.ROSE.get(), 60, 100);
        flammableBlock(BYGBlocks.SILVER_VASE_FLOWER.get(), 60, 100);
        flammableBlock(BYGBlocks.SNOWDROPS.get(), 60, 100);
        flammableBlock(BYGBlocks.TORCH_GINGER.get(), 60, 100);
        flammableBlock(BYGBlocks.VIOLET_LEATHER_FLOWER.get(), 60, 100);
        flammableBlock(BYGBlocks.WHITE_ANEMONE.get(), 60, 100);
        flammableBlock(BYGBlocks.WHITE_SAGE.get(), 60, 100);
        flammableBlock(BYGBlocks.WINTER_CYCLAMEN.get(), 60, 100);
        flammableBlock(BYGBlocks.WINTER_ROSE.get(), 60, 100);
        flammableBlock(BYGBlocks.WINTER_SCILLA.get(), 60, 100);
        flammableBlock(BYGBlocks.YELLOW_DAFFODIL.get(), 60, 100);
        flammableBlock(BYGBlocks.YELLOW_TULIP.get(), 60, 100);

        //Plants
        flammableBlock(BYGBlocks.FLOWER_PATCH.get(), 60, 100);
        flammableBlock(BYGBlocks.CLOVER_PATCH.get(), 60, 100);
        flammableBlock(BYGBlocks.HORSEWEED.get(), 60, 100);
        flammableBlock(BYGBlocks.WINTER_SUCCULENT.get(), 60, 100);
        flammableBlock(BYGBlocks.POISON_IVY.get(), 15, 100);
        flammableBlock(BYGBlocks.SHRUB.get(), 15, 100);
        flammableBlock(BYGBlocks.JACARANDA_BUSH.get(), 15, 100);
        flammableBlock(BYGBlocks.FLOWERING_JACARANDA_BUSH.get(), 15, 100);
        flammableBlock(BYGBlocks.INDIGO_JACARANDA_BUSH.get(), 15, 100);
        flammableBlock(BYGBlocks.FLOWERING_INDIGO_JACARANDA_BUSH.get(), 15, 100);

        BYG.LOGGER.info("BYG: Added Flammables!");
    }
}
