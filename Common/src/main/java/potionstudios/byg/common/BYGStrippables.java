package potionstudios.byg.common;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;

import java.util.function.BiConsumer;

public class BYGStrippables {

    public static void strippableLogsBYG(BiConsumer<Block, Block> handler) {
        BYG.LOGGER.debug("BYG: Adding strippable Blocks...");

        handler.accept(BYGBlocks.ASPEN_LOG.get(), BYGBlocks.STRIPPED_ASPEN_LOG.get());
        handler.accept(BYGBlocks.BAOBAB_LOG.get(), BYGBlocks.STRIPPED_BAOBAB_LOG.get());
        handler.accept(BYGBlocks.BLUE_ENCHANTED_LOG.get(), BYGBlocks.STRIPPED_BLUE_ENCHANTED_LOG.get());
        handler.accept(BYGBlocks.CHERRY_LOG.get(), BYGBlocks.STRIPPED_CHERRY_LOG.get());
        handler.accept(BYGBlocks.CIKA_LOG.get(), BYGBlocks.STRIPPED_CIKA_LOG.get());
        handler.accept(BYGBlocks.CYPRESS_LOG.get(), BYGBlocks.STRIPPED_CYPRESS_LOG.get());
        handler.accept(BYGBlocks.EBONY_LOG.get(), BYGBlocks.STRIPPED_EBONY_LOG.get());
        handler.accept(BYGBlocks.FIR_LOG.get(), BYGBlocks.STRIPPED_FIR_LOG.get());
        handler.accept(BYGBlocks.GREEN_ENCHANTED_LOG.get(), BYGBlocks.STRIPPED_GREEN_ENCHANTED_LOG.get());
        handler.accept(BYGBlocks.HOLLY_LOG.get(), BYGBlocks.STRIPPED_HOLLY_LOG.get());
        handler.accept(BYGBlocks.JACARANDA_LOG.get(), BYGBlocks.STRIPPED_JACARANDA_LOG.get());
        handler.accept(BYGBlocks.MAHOGANY_LOG.get(), BYGBlocks.STRIPPED_MAHOGANY_LOG.get());
        handler.accept(BYGBlocks.MANGROVE_LOG.get(), BYGBlocks.STRIPPED_MANGROVE_LOG.get());
        handler.accept(BYGBlocks.MAPLE_LOG.get(), BYGBlocks.STRIPPED_MAPLE_LOG.get());
        handler.accept(BYGBlocks.PALO_VERDE_LOG.get(), BYGBlocks.STRIPPED_PALO_VERDE_LOG.get());
        handler.accept(BYGBlocks.PINE_LOG.get(), BYGBlocks.STRIPPED_PINE_LOG.get());
        handler.accept(BYGBlocks.RAINBOW_EUCALYPTUS_LOG.get(), BYGBlocks.STRIPPED_RAINBOW_EUCALYPTUS_LOG.get());
        handler.accept(BYGBlocks.REDWOOD_LOG.get(), BYGBlocks.STRIPPED_REDWOOD_LOG.get());
        handler.accept(BYGBlocks.SKYRIS_LOG.get(), BYGBlocks.STRIPPED_SKYRIS_LOG.get());
        handler.accept(BYGBlocks.WILLOW_LOG.get(), BYGBlocks.STRIPPED_WILLOW_LOG.get());
        handler.accept(BYGBlocks.WITCH_HAZEL_LOG.get(), BYGBlocks.STRIPPED_WITCH_HAZEL_LOG.get());
        handler.accept(BYGBlocks.ZELKOVA_LOG.get(), BYGBlocks.STRIPPED_ZELKOVA_LOG.get());
        handler.accept(BYGBlocks.SYTHIAN_STEM.get(), BYGBlocks.STRIPPED_SYTHIAN_STEM.get());
        handler.accept(BYGBlocks.PALM_LOG.get(), BYGBlocks.STRIPPED_PALM_LOG.get());
        handler.accept(BYGBlocks.LAMENT_LOG.get(), BYGBlocks.STRIPPED_LAMENT_LOG.get());
        handler.accept(BYGBlocks.WITHERING_OAK_LOG.get(), Blocks.STRIPPED_OAK_LOG);
        handler.accept(BYGBlocks.ETHER_LOG.get(), BYGBlocks.STRIPPED_ETHER_LOG.get());
        handler.accept(BYGBlocks.NIGHTSHADE_LOG.get(), BYGBlocks.STRIPPED_NIGHTSHADE_LOG.get());
        handler.accept(BYGBlocks.BULBIS_STEM.get(), BYGBlocks.STRIPPED_BULBIS_LOG.get());
        handler.accept(BYGBlocks.EMBUR_PEDU.get(), BYGBlocks.STRIPPED_EMBUR_PEDU.get());
        handler.accept(BYGBlocks.FUNGAL_IMPARIUS_STEM.get(), BYGBlocks.IMPARIUS_STEM.get());

        handler.accept(BYGBlocks.ASPEN_WOOD.get(), BYGBlocks.STRIPPED_ASPEN_WOOD.get());
        handler.accept(BYGBlocks.BAOBAB_WOOD.get(), BYGBlocks.STRIPPED_BAOBAB_WOOD.get());
        handler.accept(BYGBlocks.BLUE_ENCHANTED_WOOD.get(), BYGBlocks.STRIPPED_BLUE_ENCHANTED_WOOD.get());
        handler.accept(BYGBlocks.CHERRY_WOOD.get(), BYGBlocks.STRIPPED_CHERRY_WOOD.get());
        handler.accept(BYGBlocks.CIKA_WOOD.get(), BYGBlocks.STRIPPED_CIKA_WOOD.get());
        handler.accept(BYGBlocks.CYPRESS_WOOD.get(), BYGBlocks.STRIPPED_CYPRESS_WOOD.get());
        handler.accept(BYGBlocks.EBONY_WOOD.get(), BYGBlocks.STRIPPED_EBONY_WOOD.get());
        handler.accept(BYGBlocks.FIR_WOOD.get(), BYGBlocks.STRIPPED_FIR_WOOD.get());
        handler.accept(BYGBlocks.GREEN_ENCHANTED_WOOD.get(), BYGBlocks.STRIPPED_GREEN_ENCHANTED_WOOD.get());
        handler.accept(BYGBlocks.HOLLY_WOOD.get(), BYGBlocks.STRIPPED_HOLLY_WOOD.get());
        handler.accept(BYGBlocks.JACARANDA_WOOD.get(), BYGBlocks.STRIPPED_JACARANDA_WOOD.get());
        handler.accept(BYGBlocks.MAHOGANY_WOOD.get(), BYGBlocks.STRIPPED_MAHOGANY_WOOD.get());
        handler.accept(BYGBlocks.MANGROVE_WOOD.get(), BYGBlocks.STRIPPED_MANGROVE_WOOD.get());
        handler.accept(BYGBlocks.MAPLE_WOOD.get(), BYGBlocks.STRIPPED_MAPLE_WOOD.get());
        handler.accept(BYGBlocks.PALO_VERDE_WOOD.get(), BYGBlocks.STRIPPED_PALO_VERDE_WOOD.get());
        handler.accept(BYGBlocks.PINE_WOOD.get(), BYGBlocks.STRIPPED_PINE_WOOD.get());
        handler.accept(BYGBlocks.RAINBOW_EUCALYPTUS_WOOD.get(), BYGBlocks.STRIPPED_RAINBOW_EUCALYPTUS_WOOD.get());
        handler.accept(BYGBlocks.REDWOOD_WOOD.get(), BYGBlocks.STRIPPED_REDWOOD_WOOD.get());
        handler.accept(BYGBlocks.SKYRIS_WOOD.get(), BYGBlocks.STRIPPED_SKYRIS_WOOD.get());
        handler.accept(BYGBlocks.WILLOW_WOOD.get(), BYGBlocks.STRIPPED_WILLOW_WOOD.get());
        handler.accept(BYGBlocks.WITCH_HAZEL_WOOD.get(), BYGBlocks.STRIPPED_WITCH_HAZEL_WOOD.get());
        handler.accept(BYGBlocks.ZELKOVA_WOOD.get(), BYGBlocks.STRIPPED_ZELKOVA_WOOD.get());
        handler.accept(BYGBlocks.SYTHIAN_HYPHAE.get(), BYGBlocks.STRIPPED_SYTHIAN_HYPHAE.get());
        handler.accept(BYGBlocks.PALM_WOOD.get(), BYGBlocks.STRIPPED_PALM_WOOD.get());
        handler.accept(BYGBlocks.LAMENT_WOOD.get(), BYGBlocks.STRIPPED_LAMENT_WOOD.get());
        handler.accept(BYGBlocks.WITHERING_OAK_WOOD.get(), Blocks.STRIPPED_OAK_WOOD);
        handler.accept(BYGBlocks.ETHER_WOOD.get(), BYGBlocks.STRIPPED_ETHER_WOOD.get());
        handler.accept(BYGBlocks.NIGHTSHADE_WOOD.get(), BYGBlocks.STRIPPED_NIGHTSHADE_WOOD.get());
        handler.accept(BYGBlocks.BULBIS_WOOD.get(), BYGBlocks.STRIPPED_BULBIS_WOOD.get());
        handler.accept(BYGBlocks.EMBUR_HYPHAE.get(), BYGBlocks.STRIPPED_EMBUR_HYPHAE.get());
        handler.accept(BYGBlocks.FUNGAL_IMPARIUS_HYPHAE.get(), BYGBlocks.IMPARIUS_HYPHAE.get());

        BYG.LOGGER.info("BYG: Added strippable Blocks...");
    }
}
