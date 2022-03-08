package potionstudios.byg.common;

import com.mojang.datafixers.util.Pair;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.mixin.access.HoeItemAccess;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class BYGHoeables {
    public static void tillablesBYG() {
        BYG.LOGGER.debug("BYG: Adding tillables...");
        Map<Block, Pair<Predicate<UseOnContext>, Consumer<UseOnContext>>> tillables = new IdentityHashMap<>(HoeItemAccess.byg_getTILLABLES());
        tillables.put(BYGBlocks.LUSH_GRASS_BLOCK, Pair.of(HoeItem::onlyIfAirAbove, HoeItem.changeIntoState(BYGBlocks.LUSH_FARMLAND.defaultBlockState())));
        tillables.put(BYGBlocks.LUSH_DIRT, Pair.of(HoeItem::onlyIfAirAbove, HoeItem.changeIntoState(BYGBlocks.LUSH_FARMLAND.defaultBlockState())));
        tillables.put(BYGBlocks.PEAT, Pair.of(HoeItem::onlyIfAirAbove, HoeItem.changeIntoState(Blocks.FARMLAND.defaultBlockState())));
        HoeItemAccess.byg_setTILLABLES(tillables);
        BYG.LOGGER.info("BYG: Added tillables!");
    }
}

