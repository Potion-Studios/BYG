package potionstudios.byg.common.entity.npc;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import potionstudios.byg.util.BYGUtil;
import potionstudios.byg.util.codec.CodecUtil;

import java.util.*;

public class BYGVillagerTrades {

    protected static final Map<VillagerProfession, Int2ObjectMap<VillagerTrades.ItemListing[]>> TRADES = Util.make(new HashMap<>(), map -> {
        for (VillagerProfession villagerProfession : Registry.VILLAGER_PROFESSION) {
            if (villagerProfession != VillagerProfession.NITWIT && villagerProfession != VillagerProfession.NONE) {
                Int2ObjectMap<VillagerTrades.ItemListing[]> tradesByLevel = map.computeIfAbsent(villagerProfession, villagerProfession1 -> new Int2ObjectOpenHashMap<>());
                for (int i = 1; i <= 5; i++) {
                    tradesByLevel.putIfAbsent(i, new VillagerTrades.ItemListing[]{});
                }
            }
        }
    });

    protected static final Int2ObjectMap<VillagerTrades.ItemListing[]> WANDERING_TRADER_TRADES = toIntMap(ImmutableMap.of(
        1, new VillagerTrades.ItemListing[]{},
        2, new VillagerTrades.ItemListing[]{}
    ));

    public static void appendTradesList(Int2ObjectMap<VillagerTrades.ItemListing[]> newTrades, Int2ObjectMap<List<VillagerTrades.ItemListing>> originalTrades) {
        newTrades.forEach((level, itemListings) -> originalTrades.computeIfAbsent(level, level1 -> new ArrayList<>()).addAll(Arrays.asList(itemListings)));
    }

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> map) {
        return new Int2ObjectOpenHashMap<>(map);
    }

    public static Codec<Int2ObjectMap<VillagerTrades.ItemListing[]>> createRangeCheckedKeyMap(int min, int max) {
        return Codec.unboundedMap(
            CodecUtil.intKeyRangeCodec(min, max), VillagerTradeRegistry.ITEM_LISTING_CODEC.listOf()).xmap(
            map -> BYGUtil.convertMapValueType(map, Int2ObjectOpenHashMap::new,
                itemListings -> itemListings.toArray(VillagerTrades.ItemListing[]::new)
            ), int2ObjectMap -> BYGUtil.convertMapValueType(int2ObjectMap, HashMap::new, Arrays::asList)
        );
    }
}