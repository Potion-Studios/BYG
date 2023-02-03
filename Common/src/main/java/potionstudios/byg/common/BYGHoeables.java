package potionstudios.byg.common;

import com.mojang.datafixers.util.Pair;
import net.minecraft.Util;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.mixin.access.HoeItemAccess;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class BYGHoeables {
    public static final Map<Block, Pair<Predicate<UseOnContext>, Consumer<UseOnContext>>> TILLABLES = Util.make(new IdentityHashMap<>(), map -> {
        map.put(BYGBlocks.LUSH_GRASS_BLOCK.get(), Pair.of(HoeItem::onlyIfAirAbove, HoeItem.changeIntoState(BYGBlocks.LUSH_FARMLAND.defaultBlockState())));
        map.put(BYGBlocks.LUSH_DIRT.get(), Pair.of(HoeItem::onlyIfAirAbove, HoeItem.changeIntoState(BYGBlocks.LUSH_FARMLAND.defaultBlockState())));
        map.put(BYGBlocks.PEAT.get(), Pair.of(HoeItem::onlyIfAirAbove, HoeItem.changeIntoState(Blocks.FARMLAND.defaultBlockState())));
    });

    public static final Map<Block, Pair<Predicate<UseOnContext>, BlockState>> TILLABLES_FORGE = Util.make(new IdentityHashMap<>(), map -> {
        map.put(BYGBlocks.LUSH_GRASS_BLOCK.get(), Pair.of(HoeItem::onlyIfAirAbove,BYGBlocks.LUSH_FARMLAND.defaultBlockState()));
        map.put(BYGBlocks.LUSH_DIRT.get(), Pair.of(HoeItem::onlyIfAirAbove, BYGBlocks.LUSH_FARMLAND.defaultBlockState()));
        map.put(BYGBlocks.PEAT.get(), Pair.of(HoeItem::onlyIfAirAbove, Blocks.FARMLAND.defaultBlockState()));
    });

    public static void tillablesBYG() {
        BYG.logDebug("BYG: Adding tillables...");
        Map<Block, Pair<Predicate<UseOnContext>, Consumer<UseOnContext>>> tillables = new IdentityHashMap<>(HoeItemAccess.byg_getTILLABLES());
        tillables.putAll(TILLABLES);
        HoeItemAccess.byg_setTILLABLES(tillables);
        BYG.logInfo("BYG: Added tillables!");
    }
}

