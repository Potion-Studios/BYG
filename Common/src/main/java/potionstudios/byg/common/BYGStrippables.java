package potionstudios.byg.common;

import net.minecraft.world.level.block.Block;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.common.registration.BYGBlockFamilies;
import potionstudios.byg.common.registration.BYGBlockFamily;

import java.util.function.BiConsumer;

public class BYGStrippables {

    public static void strippableLogsBYG(BiConsumer<Block, Block> handler) {
        BYG.logDebug("BYG: Adding strippable Blocks...");

        for(BYGBlockFamily family: BYGBlockFamilies.woodFamilyMap.values()) {
            Block log = family.get(BYGBlockFamily.BlockVariant.LOG);
            Block strippedLog = family.get(BYGBlockFamily.BlockVariant.STRIPPED_LOG);
            Block wood = family.get(BYGBlockFamily.BlockVariant.WOOD);
            Block strippedWood = family.get(BYGBlockFamily.BlockVariant.STRIPPED_WOOD);
            if(log != null && strippedLog != null) {
                handler.accept(log, strippedLog);
            }
            if(wood != null && strippedWood != null) {
                handler.accept(wood, strippedWood);
            }
            BiConsumer<BiConsumer<Block, Block>, BYGBlockFamily> consumer = family.getStrippables();
            if(consumer != null) {
                consumer.accept(handler, family);
            }
        }

        handler.accept(BYGBlocks.PALO_VERDE_LOG.get(), BYGBlocks.STRIPPED_PALO_VERDE_LOG.get());
        handler.accept(BYGBlocks.FUNGAL_IMPARIUS_STEM.get(), BYGWoodTypes.IMPARIUS.log().get());

        handler.accept(BYGBlocks.PALO_VERDE_WOOD.get(), BYGBlocks.STRIPPED_PALO_VERDE_WOOD.get());
        handler.accept(BYGBlocks.FUNGAL_IMPARIUS_HYPHAE.get(), BYGWoodTypes.IMPARIUS.wood().get());
        BYG.logInfo("BYG: Added strippable Blocks...");

    }
}
