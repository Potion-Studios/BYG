package potionstudios.byg.common;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.mixin.access.AxeItemAccess;

import java.util.IdentityHashMap;
import java.util.Map;

public class BYGStrippables {

    public static void strippableLogsBYG() {
        BYG.LOGGER.debug("BYG: Adding strippable Blocks...");

        Map<Block, Block> stripables = new IdentityHashMap<>(AxeItemAccess.byg_getStrippables());

        stripables.put(BYGBlocks.ASPEN_LOG, BYGBlocks.STRIPPED_ASPEN_LOG);
        stripables.put(BYGBlocks.BAOBAB_LOG, BYGBlocks.STRIPPED_BAOBAB_LOG);
        stripables.put(BYGBlocks.BLUE_ENCHANTED_LOG, BYGBlocks.STRIPPED_BLUE_ENCHANTED_LOG);
        stripables.put(BYGBlocks.CHERRY_LOG, BYGBlocks.STRIPPED_CHERRY_LOG);
        stripables.put(BYGBlocks.CIKA_LOG, BYGBlocks.STRIPPED_CIKA_LOG);
        stripables.put(BYGBlocks.CYPRESS_LOG, BYGBlocks.STRIPPED_CYPRESS_LOG);
        stripables.put(BYGBlocks.EBONY_LOG, BYGBlocks.STRIPPED_EBONY_LOG);
        stripables.put(BYGBlocks.FIR_LOG, BYGBlocks.STRIPPED_FIR_LOG);
        stripables.put(BYGBlocks.GREEN_ENCHANTED_LOG, BYGBlocks.STRIPPED_GREEN_ENCHANTED_LOG);
        stripables.put(BYGBlocks.HOLLY_LOG, BYGBlocks.STRIPPED_HOLLY_LOG);
        stripables.put(BYGBlocks.JACARANDA_LOG, BYGBlocks.STRIPPED_JACARANDA_LOG);
        stripables.put(BYGBlocks.MAHOGANY_LOG, BYGBlocks.STRIPPED_MAHOGANY_LOG);
        stripables.put(BYGBlocks.MANGROVE_LOG, BYGBlocks.STRIPPED_MANGROVE_LOG);
        stripables.put(BYGBlocks.MAPLE_LOG, BYGBlocks.STRIPPED_MAPLE_LOG);
        stripables.put(BYGBlocks.PALO_VERDE_LOG, BYGBlocks.STRIPPED_PALO_VERDE_LOG);
        stripables.put(BYGBlocks.PINE_LOG, BYGBlocks.STRIPPED_PINE_LOG);
        stripables.put(BYGBlocks.RAINBOW_EUCALYPTUS_LOG, BYGBlocks.STRIPPED_RAINBOW_EUCALYPTUS_LOG);
        stripables.put(BYGBlocks.REDWOOD_LOG, BYGBlocks.STRIPPED_REDWOOD_LOG);
        stripables.put(BYGBlocks.SKYRIS_LOG, BYGBlocks.STRIPPED_SKYRIS_LOG);
        stripables.put(BYGBlocks.WILLOW_LOG, BYGBlocks.STRIPPED_WILLOW_LOG);
        stripables.put(BYGBlocks.WITCH_HAZEL_LOG, BYGBlocks.STRIPPED_WITCH_HAZEL_LOG);
        stripables.put(BYGBlocks.ZELKOVA_LOG, BYGBlocks.STRIPPED_ZELKOVA_LOG);
        stripables.put(BYGBlocks.SYTHIAN_STEM, BYGBlocks.STRIPPED_SYTHIAN_STEM);
        stripables.put(BYGBlocks.PALM_LOG, BYGBlocks.STRIPPED_PALM_LOG);
        stripables.put(BYGBlocks.LAMENT_LOG, BYGBlocks.STRIPPED_LAMENT_LOG);
        stripables.put(BYGBlocks.WITHERING_OAK_LOG, Blocks.STRIPPED_OAK_LOG);
        stripables.put(BYGBlocks.ETHER_LOG, BYGBlocks.STRIPPED_ETHER_LOG);
        stripables.put(BYGBlocks.NIGHTSHADE_LOG, BYGBlocks.STRIPPED_NIGHTSHADE_LOG);
        stripables.put(BYGBlocks.BULBIS_STEM, BYGBlocks.STRIPPED_BULBIS_LOG);
        stripables.put(BYGBlocks.EMBUR_PEDU, BYGBlocks.STRIPPED_EMBUR_PEDU);
        stripables.put(BYGBlocks.FUNGAL_IMPARIUS_STEM, BYGBlocks.IMPARIUS_STEM);

        stripables.put(BYGBlocks.ASPEN_WOOD, BYGBlocks.STRIPPED_ASPEN_WOOD);
        stripables.put(BYGBlocks.BAOBAB_WOOD, BYGBlocks.STRIPPED_BAOBAB_WOOD);
        stripables.put(BYGBlocks.BLUE_ENCHANTED_WOOD, BYGBlocks.STRIPPED_BLUE_ENCHANTED_WOOD);
        stripables.put(BYGBlocks.CHERRY_WOOD, BYGBlocks.STRIPPED_CHERRY_WOOD);
        stripables.put(BYGBlocks.CIKA_WOOD, BYGBlocks.STRIPPED_CIKA_WOOD);
        stripables.put(BYGBlocks.CYPRESS_WOOD, BYGBlocks.STRIPPED_CYPRESS_WOOD);
        stripables.put(BYGBlocks.EBONY_WOOD, BYGBlocks.STRIPPED_EBONY_WOOD);
        stripables.put(BYGBlocks.FIR_WOOD, BYGBlocks.STRIPPED_FIR_WOOD);
        stripables.put(BYGBlocks.GREEN_ENCHANTED_WOOD, BYGBlocks.STRIPPED_GREEN_ENCHANTED_WOOD);
        stripables.put(BYGBlocks.HOLLY_WOOD, BYGBlocks.STRIPPED_HOLLY_WOOD);
        stripables.put(BYGBlocks.JACARANDA_WOOD, BYGBlocks.STRIPPED_JACARANDA_WOOD);
        stripables.put(BYGBlocks.MAHOGANY_WOOD, BYGBlocks.STRIPPED_MAHOGANY_WOOD);
        stripables.put(BYGBlocks.MANGROVE_WOOD, BYGBlocks.STRIPPED_MANGROVE_WOOD);
        stripables.put(BYGBlocks.MAPLE_WOOD, BYGBlocks.STRIPPED_MAPLE_WOOD);
        stripables.put(BYGBlocks.PALO_VERDE_WOOD, BYGBlocks.STRIPPED_PALO_VERDE_WOOD);
        stripables.put(BYGBlocks.PINE_WOOD, BYGBlocks.STRIPPED_PINE_WOOD);
        stripables.put(BYGBlocks.RAINBOW_EUCALYPTUS_WOOD, BYGBlocks.STRIPPED_RAINBOW_EUCALYPTUS_WOOD);
        stripables.put(BYGBlocks.REDWOOD_WOOD, BYGBlocks.STRIPPED_REDWOOD_WOOD);
        stripables.put(BYGBlocks.SKYRIS_WOOD, BYGBlocks.STRIPPED_SKYRIS_WOOD);
        stripables.put(BYGBlocks.WILLOW_WOOD, BYGBlocks.STRIPPED_WILLOW_WOOD);
        stripables.put(BYGBlocks.WITCH_HAZEL_WOOD, BYGBlocks.STRIPPED_WITCH_HAZEL_WOOD);
        stripables.put(BYGBlocks.ZELKOVA_WOOD, BYGBlocks.STRIPPED_ZELKOVA_WOOD);
        stripables.put(BYGBlocks.SYTHIAN_HYPHAE, BYGBlocks.STRIPPED_SYTHIAN_HYPHAE);
        stripables.put(BYGBlocks.PALM_WOOD, BYGBlocks.STRIPPED_PALM_WOOD);
        stripables.put(BYGBlocks.LAMENT_WOOD, BYGBlocks.STRIPPED_LAMENT_WOOD);
        stripables.put(BYGBlocks.WITHERING_OAK_WOOD, Blocks.STRIPPED_OAK_WOOD);
        stripables.put(BYGBlocks.ETHER_WOOD, BYGBlocks.STRIPPED_ETHER_WOOD);
        stripables.put(BYGBlocks.NIGHTSHADE_WOOD, BYGBlocks.STRIPPED_NIGHTSHADE_WOOD);
        stripables.put(BYGBlocks.BULBIS_WOOD, BYGBlocks.STRIPPED_BULBIS_WOOD);
        stripables.put(BYGBlocks.EMBUR_HYPHAE, BYGBlocks.STRIPPED_EMBUR_HYPHAE);
        stripables.put(BYGBlocks.FUNGAL_IMPARIUS_HYPHAE, BYGBlocks.IMPARIUS_HYPHAE);


        AxeItemAccess.byg_setStripables(stripables);
        BYG.LOGGER.info("BYG: Added strippable Blocks...");

    }
}
