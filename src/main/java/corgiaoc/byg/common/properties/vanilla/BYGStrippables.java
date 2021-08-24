package corgiaoc.byg.common.properties.vanilla;

import corgiaoc.byg.BYG;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.mixin.access.AxeItemAccess;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

import java.util.IdentityHashMap;
import java.util.Map;

public class BYGStrippables {

    public static void strippableLogsBYG() {
        BYG.LOGGER.debug("BYG: Adding strippable Blocks...");

        Map<Block, BlockState> stripables = new IdentityHashMap<>(AxeItemAccess.getStripables());

        stripables.put(BYGBlocks.ASPEN_LOG, BYGBlocks.STRIPPED_ASPEN_LOG.defaultBlockState());
        stripables.put(BYGBlocks.BAOBAB_LOG, BYGBlocks.STRIPPED_BAOBAB_LOG.defaultBlockState());
        stripables.put(BYGBlocks.BLUE_ENCHANTED_LOG, BYGBlocks.STRIPPED_BLUE_ENCHANTED_LOG.defaultBlockState());
        stripables.put(BYGBlocks.CHERRY_LOG, BYGBlocks.STRIPPED_CHERRY_LOG.defaultBlockState());
        stripables.put(BYGBlocks.CIKA_LOG, BYGBlocks.STRIPPED_CIKA_LOG.defaultBlockState());
        stripables.put(BYGBlocks.CYPRESS_LOG, BYGBlocks.STRIPPED_CYPRESS_LOG.defaultBlockState());
        stripables.put(BYGBlocks.EBONY_LOG, BYGBlocks.STRIPPED_EBONY_LOG.defaultBlockState());
        stripables.put(BYGBlocks.FIR_LOG, BYGBlocks.STRIPPED_FIR_LOG.defaultBlockState());
        stripables.put(BYGBlocks.GREEN_ENCHANTED_LOG, BYGBlocks.STRIPPED_GREEN_ENCHANTED_LOG.defaultBlockState());
        stripables.put(BYGBlocks.HOLLY_LOG, BYGBlocks.STRIPPED_HOLLY_LOG.defaultBlockState());
        stripables.put(BYGBlocks.JACARANDA_LOG, BYGBlocks.STRIPPED_JACARANDA_LOG.defaultBlockState());
        stripables.put(BYGBlocks.MAHOGANY_LOG, BYGBlocks.STRIPPED_MAHOGANY_LOG.defaultBlockState());
        stripables.put(BYGBlocks.MANGROVE_LOG, BYGBlocks.STRIPPED_MANGROVE_LOG.defaultBlockState());
        stripables.put(BYGBlocks.MAPLE_LOG, BYGBlocks.STRIPPED_MAPLE_LOG.defaultBlockState());
        stripables.put(BYGBlocks.PALO_VERDE_LOG, BYGBlocks.STRIPPED_PALO_VERDE_LOG.defaultBlockState());
        stripables.put(BYGBlocks.PINE_LOG, BYGBlocks.STRIPPED_PINE_LOG.defaultBlockState());
        stripables.put(BYGBlocks.RAINBOW_EUCALYPTUS_LOG, BYGBlocks.STRIPPED_RAINBOW_EUCALYPTUS_LOG.defaultBlockState());
        stripables.put(BYGBlocks.REDWOOD_LOG, BYGBlocks.STRIPPED_REDWOOD_LOG.defaultBlockState());
        stripables.put(BYGBlocks.SKYRIS_LOG, BYGBlocks.STRIPPED_SKYRIS_LOG.defaultBlockState());
        stripables.put(BYGBlocks.WILLOW_LOG, BYGBlocks.STRIPPED_WILLOW_LOG.defaultBlockState());
        stripables.put(BYGBlocks.WITCH_HAZEL_LOG, BYGBlocks.STRIPPED_WITCH_HAZEL_LOG.defaultBlockState());
        stripables.put(BYGBlocks.ZELKOVA_LOG, BYGBlocks.STRIPPED_ZELKOVA_LOG.defaultBlockState());
        stripables.put(BYGBlocks.SYTHIAN_STEM, BYGBlocks.STRIPPED_SYTHIAN_STEM.defaultBlockState());
        stripables.put(BYGBlocks.PALM_LOG, BYGBlocks.STRIPPED_PALM_LOG.defaultBlockState());
        stripables.put(BYGBlocks.LAMENT_LOG, BYGBlocks.STRIPPED_LAMENT_LOG.defaultBlockState());
        stripables.put(BYGBlocks.WITHERING_OAK_LOG, Blocks.STRIPPED_OAK_LOG.defaultBlockState());
        stripables.put(BYGBlocks.ETHER_LOG, BYGBlocks.STRIPPED_ETHER_LOG.defaultBlockState());
        stripables.put(BYGBlocks.NIGHTSHADE_LOG, BYGBlocks.STRIPPED_NIGHTSHADE_LOG.defaultBlockState());
        stripables.put(BYGBlocks.BULBIS_STEM, BYGBlocks.STRIPPED_BULBIS_LOG.defaultBlockState());
        stripables.put(BYGBlocks.EMBUR_PEDU, BYGBlocks.STRIPPED_EMBUR_PEDU.defaultBlockState());
        stripables.put(BYGBlocks.FUNGAL_IMPARIUS_STEM, BYGBlocks.IMPARIUS_STEM.defaultBlockState());

        stripables.put(BYGBlocks.ASPEN_WOOD, BYGBlocks.STRIPPED_ASPEN_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.BAOBAB_WOOD, BYGBlocks.STRIPPED_BAOBAB_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.BLUE_ENCHANTED_WOOD, BYGBlocks.STRIPPED_BLUE_ENCHANTED_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.CHERRY_WOOD, BYGBlocks.STRIPPED_CHERRY_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.CIKA_WOOD, BYGBlocks.STRIPPED_CIKA_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.CYPRESS_WOOD, BYGBlocks.STRIPPED_CYPRESS_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.EBONY_WOOD, BYGBlocks.STRIPPED_EBONY_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.FIR_WOOD, BYGBlocks.STRIPPED_FIR_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.GREEN_ENCHANTED_WOOD, BYGBlocks.STRIPPED_GREEN_ENCHANTED_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.HOLLY_WOOD, BYGBlocks.STRIPPED_HOLLY_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.JACARANDA_WOOD, BYGBlocks.STRIPPED_JACARANDA_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.MAHOGANY_WOOD, BYGBlocks.STRIPPED_MAHOGANY_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.MANGROVE_WOOD, BYGBlocks.STRIPPED_MANGROVE_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.MAPLE_WOOD, BYGBlocks.STRIPPED_MAPLE_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.PALO_VERDE_WOOD, BYGBlocks.STRIPPED_PALO_VERDE_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.PINE_WOOD, BYGBlocks.STRIPPED_PINE_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.RAINBOW_EUCALYPTUS_WOOD, BYGBlocks.STRIPPED_RAINBOW_EUCALYPTUS_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.REDWOOD_WOOD, BYGBlocks.STRIPPED_REDWOOD_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.SKYRIS_WOOD, BYGBlocks.STRIPPED_SKYRIS_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.WILLOW_WOOD, BYGBlocks.STRIPPED_WILLOW_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.WITCH_HAZEL_WOOD, BYGBlocks.STRIPPED_WITCH_HAZEL_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.ZELKOVA_WOOD, BYGBlocks.STRIPPED_ZELKOVA_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.SYTHIAN_HYPHAE, BYGBlocks.STRIPPED_SYTHIAN_HYPHAE.defaultBlockState());
        stripables.put(BYGBlocks.PALM_WOOD, BYGBlocks.STRIPPED_PALM_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.LAMENT_WOOD, BYGBlocks.STRIPPED_LAMENT_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.WITHERING_OAK_WOOD, Blocks.STRIPPED_OAK_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.ETHER_WOOD, BYGBlocks.STRIPPED_ETHER_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.NIGHTSHADE_WOOD, BYGBlocks.STRIPPED_NIGHTSHADE_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.BULBIS_WOOD, BYGBlocks.STRIPPED_BULBIS_WOOD.defaultBlockState());
        stripables.put(BYGBlocks.EMBUR_HYPHAE, BYGBlocks.STRIPPED_EMBUR_HYPHAE.defaultBlockState());
        stripables.put(BYGBlocks.FUNGAL_IMPARIUS_HYPHAE, BYGBlocks.IMPARIUS_HYPHAE.defaultBlockState());


        AxeItemAccess.setStripables(stripables);
        BYG.LOGGER.info("BYG: Added strippable Blocks...");

    }
}
