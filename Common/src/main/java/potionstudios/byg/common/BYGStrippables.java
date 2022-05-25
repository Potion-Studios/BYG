package potionstudios.byg.common;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.mixin.access.AxeItemAccess;

import java.util.IdentityHashMap;
import java.util.Map;

public class BYGStrippables {

    public static void strippableLogsBYG() {
        BYG.LOGGER.debug("BYG: Adding strippable Blocks...");

        Map<Block, Block> stripables = new IdentityHashMap<>(AxeItemAccess.byg_getStrippables());

        for (final BYGWoodTypes type : BYGWoodTypes.values()) {
            if (type.strippedLog() != null && type.log() != null)
                stripables.put(type.log().get(), type.strippedLog().get());
            if (type.wood() != null && type.strippedWood() != null)
                stripables.put(type.wood().get(), type.strippedWood().get());
        }

        stripables.put(BYGBlocks.JACARANDA_LOG.get(), BYGBlocks.STRIPPED_JACARANDA_LOG.get());
        stripables.put(BYGBlocks.MAPLE_LOG.get(), BYGBlocks.STRIPPED_MAPLE_LOG.get());
        stripables.put(BYGBlocks.PALO_VERDE_LOG.get(), BYGBlocks.STRIPPED_PALO_VERDE_LOG.get());
        stripables.put(BYGBlocks.SKYRIS_LOG.get(), BYGBlocks.STRIPPED_SKYRIS_LOG.get());
        stripables.put(BYGBlocks.SYTHIAN_STEM.get(), BYGBlocks.STRIPPED_SYTHIAN_STEM.get());
        stripables.put(BYGBlocks.LAMENT_LOG.get(), BYGBlocks.STRIPPED_LAMENT_LOG.get());
        stripables.put(BYGBlocks.WITHERING_OAK_LOG.get(), Blocks.STRIPPED_OAK_LOG);
        stripables.put(BYGBlocks.NIGHTSHADE_LOG.get(), BYGBlocks.STRIPPED_NIGHTSHADE_LOG.get());
        stripables.put(BYGBlocks.EMBUR_PEDU.get(), BYGBlocks.STRIPPED_EMBUR_PEDU.get());
        stripables.put(BYGBlocks.FUNGAL_IMPARIUS_STEM.get(), BYGWoodTypes.IMPARIUS.log().get());

        stripables.put(BYGBlocks.JACARANDA_WOOD.get(), BYGBlocks.STRIPPED_JACARANDA_WOOD.get());
        stripables.put(BYGBlocks.MAPLE_WOOD.get(), BYGBlocks.STRIPPED_MAPLE_WOOD.get());
        stripables.put(BYGBlocks.PALO_VERDE_WOOD.get(), BYGBlocks.STRIPPED_PALO_VERDE_WOOD.get());
        stripables.put(BYGBlocks.SKYRIS_WOOD.get(), BYGBlocks.STRIPPED_SKYRIS_WOOD.get());
        stripables.put(BYGBlocks.SYTHIAN_HYPHAE.get(), BYGBlocks.STRIPPED_SYTHIAN_HYPHAE.get());
        stripables.put(BYGBlocks.LAMENT_WOOD.get(), BYGBlocks.STRIPPED_LAMENT_WOOD.get());
        stripables.put(BYGBlocks.WITHERING_OAK_WOOD.get(), Blocks.STRIPPED_OAK_WOOD);
        stripables.put(BYGBlocks.NIGHTSHADE_WOOD.get(), BYGBlocks.STRIPPED_NIGHTSHADE_WOOD.get());
        stripables.put(BYGBlocks.EMBUR_HYPHAE.get(), BYGBlocks.STRIPPED_EMBUR_HYPHAE.get());
        stripables.put(BYGBlocks.FUNGAL_IMPARIUS_HYPHAE.get(), BYGWoodTypes.IMPARIUS.wood().get());

        AxeItemAccess.byg_setStripables(stripables);
        BYG.LOGGER.info("BYG: Added strippable Blocks...");

    }
}
