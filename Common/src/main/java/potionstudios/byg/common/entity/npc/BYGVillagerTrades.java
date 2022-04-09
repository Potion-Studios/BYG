package potionstudios.byg.common.entity.npc;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.util.BYGUtil;
import potionstudios.byg.util.codec.CodecUtil;

import java.util.*;

public class BYGVillagerTrades {

    public static final Codec<Map<VillagerProfession, Int2ObjectMap<VillagerTrades.ItemListing[]>>> VILLAGER_TRADES_CODEC = Codec.unboundedMap(CodecUtil.VILLAGER_PROFESSION_CODEC, Codec.unboundedMap(CodecUtil.INTEGER_KEY_CODEC, VillagerTradeRegistry.ITEM_LISTING_CODEC.listOf())).xmap(map -> BYGUtil.convertMapValueType(map, HashMap::new,
        int2ObjectMap -> BYGUtil.convertMapValueType(int2ObjectMap, Int2ObjectOpenHashMap::new,
            itemListings -> itemListings.toArray(VillagerTrades.ItemListing[]::new)
        )
    ), map -> BYGUtil.convertMapValueType(map, HashMap::new,
        int2ObjectMap -> BYGUtil.convertMapValueType(int2ObjectMap, Int2ObjectOpenHashMap::new, Arrays::asList)));


    protected static final Map<VillagerProfession, Int2ObjectMap<VillagerTrades.ItemListing[]>> TRADES = Util.make(new HashMap<>(), map -> {
        map.put(VillagerProfession.FARMER, toIntMap(ImmutableMap.of(
            1, new VillagerTrades.ItemListing[]{new VillagerTrades.EmeraldForItems(BYGItems.CRIMSON_BERRY_PIE, 20, 16, 2)},
            2, new VillagerTrades.ItemListing[]{new VillagerTrades.EmeraldForItems(Items.WHEAT, 20, 16, 2)}
        )));
        map.put(VillagerProfession.FISHERMAN, toIntMap(ImmutableMap.of()));
        map.put(VillagerProfession.SHEPHERD, toIntMap(ImmutableMap.of()));
        map.put(VillagerProfession.FLETCHER, toIntMap(ImmutableMap.of()));
        map.put(VillagerProfession.LIBRARIAN, toIntMap(ImmutableMap.of()));
        map.put(VillagerProfession.CARTOGRAPHER, toIntMap(ImmutableMap.of()));
        map.put(VillagerProfession.CLERIC, toIntMap(ImmutableMap.of()));
        map.put(VillagerProfession.ARMORER, toIntMap(ImmutableMap.of()));
        map.put(VillagerProfession.WEAPONSMITH, toIntMap(ImmutableMap.of()));
        map.put(VillagerProfession.TOOLSMITH, toIntMap(ImmutableMap.of()));
        map.put(VillagerProfession.BUTCHER, toIntMap(ImmutableMap.of()));
        map.put(VillagerProfession.LEATHERWORKER, toIntMap(ImmutableMap.of()));
        map.put(VillagerProfession.MASON, toIntMap(ImmutableMap.of()));

        for (VillagerProfession villagerProfession : Registry.VILLAGER_PROFESSION) {
            map.computeIfAbsent(villagerProfession, villagerProfession1 -> new Int2ObjectOpenHashMap<>());
        }
    });

    private static final Int2ObjectMap<VillagerTrades.ItemListing[]> WANDERING_TRADER_TRADES = toIntMap(ImmutableMap.of());

    private static void appendTradesArray(Int2ObjectMap<VillagerTrades.ItemListing[]> newTrades, Int2ObjectMap<VillagerTrades.ItemListing[]> originalTrades) {
        newTrades.forEach((level, itemListings) -> {
            if (originalTrades.containsKey(level)) {
                List<VillagerTrades.ItemListing> combined = new ArrayList<>(Arrays.asList(originalTrades.get(level)));
                combined.addAll(Arrays.asList(itemListings));
                originalTrades.put(level, combined.toArray(VillagerTrades.ItemListing[]::new));
            } else {
                originalTrades.put(level, itemListings);
            }
        });
    }

    public static void appendTradesList(Int2ObjectMap<VillagerTrades.ItemListing[]> newTrades, Int2ObjectMap<List<VillagerTrades.ItemListing>> originalTrades) {
        newTrades.forEach((level, itemListings) -> originalTrades.computeIfAbsent(level, level1 -> new ArrayList<>()).addAll(Arrays.asList(itemListings)));
    }

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> map) {
        return new Int2ObjectOpenHashMap<>(map);
    }
}