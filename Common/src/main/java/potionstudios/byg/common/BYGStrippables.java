package potionstudios.byg.common;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.BYGWoodTypes;

import java.util.function.BiConsumer;

public class BYGStrippables {

    public static void strippableLogsBYG(BiConsumer<Block, Block> handler) {
        BYG.logDebug("BYG: Adding strippable Blocks...");

        for (final BYGWoodTypes type : BYGWoodTypes.values()) {
            if (type.strippedLog() != null && type.log() != null)
                handler.accept(type.log().get(), type.strippedLog().get());
            if (type.wood() != null && type.strippedWood() != null)
                handler.accept(type.wood().get(), type.strippedWood().get());
        }

        handler.accept(BYGBlocks.PALO_VERDE_LOG.get(), BYGBlocks.STRIPPED_PALO_VERDE_LOG.get());
        handler.accept(BYGBlocks.FUNGAL_IMPARIUS_STEM.get(), BYGWoodTypes.IMPARIUS.log().get());
        handler.accept(BYGBlocks.IMBUED_GREEN_ENCHANTED_LOG.get(), BYGWoodTypes.GREEN_ENCHANTED.log().get());
        handler.accept(BYGBlocks.IMBUED_BLUE_ENCHANTED_LOG.get(), BYGWoodTypes.BLUE_ENCHANTED.log().get());

        handler.accept(BYGBlocks.PALO_VERDE_WOOD.get(), BYGBlocks.STRIPPED_PALO_VERDE_WOOD.get());
        handler.accept(BYGBlocks.FUNGAL_IMPARIUS_HYPHAE.get(), BYGWoodTypes.IMPARIUS.wood().get());
        BYG.logInfo("BYG: Added strippable Blocks...");

    }
}
