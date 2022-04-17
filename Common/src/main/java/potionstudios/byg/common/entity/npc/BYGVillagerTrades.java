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

    protected static final Map<VillagerProfession, Int2ObjectMap<VillagerTrades.ItemListing[]>> TRADES = Util.make(new HashMap<>(), map -> {
        map.put(BYGVillagerProfessions.FORAGER, toIntMap(ImmutableMap.of(
            1, new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsForEmeralds(Items.RED_MUSHROOM, 1, 10, 12, 2),
                new VillagerTrades.ItemsForEmeralds(Items.BROWN_MUSHROOM, 1, 10, 12, 2),
                new VillagerTrades.ItemsForEmeralds(BYGItems.GREEN_MUSHROOM, 1, 10, 12, 2)
            },
            2, new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsForEmeralds(BYGItems.WOOD_BLEWIT, 1, 8, 12, 2),
                new VillagerTrades.ItemsForEmeralds(BYGItems.WHITE_PUFFBALL_CAP, 1, 8, 12, 2)
            },
            3, new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(BYGItems.WHITE_PUFFBALL_SPORES, 5, 4, 2),
                new VillagerTrades.ItemsForEmeralds(Items.CRIMSON_FUNGUS, 1, 10, 12, 2),
                new VillagerTrades.ItemsForEmeralds(Items.WARPED_FUNGUS, 1, 10, 12, 2),
                new VillagerTrades.ItemsForEmeralds(BYGItems.SYTHIAN_FUNGUS, 1, 10, 12, 2),
                new VillagerTrades.EmeraldForItems(BYGItems.WITCH_HAZEL_BRANCH, 9, 4, 2)
            },
            4, new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(BYGItems.WITCH_HAZEL_BRANCH, 9, 4, 2),
                new VillagerTrades.EmeraldForItems(BYGItems.WITCH_HAZEL_BLOSSOM, 1, 10, 2),
            },
            5, new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsForEmeralds(BYGItems.IMPARIUS_MUSHROOM, 2, 10, 12, 2),
                new VillagerTrades.ItemsForEmeralds(BYGItems.SHULKREN_FUNGUS, 2, 10, 12, 2),
                new VillagerTrades.ItemsForEmeralds(BYGItems.FUNGAL_IMPARIUS, 2, 10, 12, 2),
            }
        )));

        map.put(VillagerProfession.ARMORER, toIntMap(ImmutableMap.of(
            4, new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(BYGItems.CHAIN_PLATING, 7, 12, 2)
            }
        )));
        map.put(VillagerProfession.BUTCHER, toIntMap(ImmutableMap.of(
            2, new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsForEmeralds(BYGItems.BLUE_BERRY, 1, 10, 12, 2)
            }
        )));
        map.put(VillagerProfession.FARMER, toIntMap(ImmutableMap.of(
            1, new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsForEmeralds(BYGItems.CATTAIL_SPROUT, 1, 24, 12, 2)
            },
            2, new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsForEmeralds(BYGItems.BAOBAB_FRUIT, 1, 10, 12, 2),
                new VillagerTrades.ItemsForEmeralds(BYGItems.ALOE_VERA, 1, 16, 12, 2),
                new VillagerTrades.ItemsForEmeralds(BYGItems.GREEN_APPLE, 1, 24, 12, 2)
            },
            3, new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsForEmeralds(BYGItems.JOSHUA_FRUIT, 1, 10, 12, 2)
            },
            4, new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsAndEmeraldsToItems(Items.DIRT, 16, 2, BYGItems.LUSH_DIRT, 16, 4, 4)
            }
        )));
        map.put(VillagerProfession.MASON, toIntMap(ImmutableMap.of(
            3, new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsForEmeralds(BYGItems.ROCKY_STONE, 1, 12, 12, 2),
                new VillagerTrades.EmeraldForItems(BYGItems.ROCKY_STONE, 1, 12, 12),
                new VillagerTrades.ItemsForEmeralds(BYGItems.MOSSY_STONE, 1, 12, 12, 2),
                new VillagerTrades.EmeraldForItems(BYGItems.MOSSY_STONE, 1, 12, 12)
            },
            4, new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsForEmeralds(BYGItems.DACITE, 1, 12, 12, 2),
                new VillagerTrades.EmeraldForItems(BYGItems.DACITE, 1, 12, 12),
                new VillagerTrades.ItemsForEmeralds(BYGItems.SOAPSTONE, 1, 12, 12, 2),
                new VillagerTrades.EmeraldForItems(BYGItems.SOAPSTONE, 1, 12, 12),
                new VillagerTrades.ItemsForEmeralds(BYGItems.RED_ROCK, 1, 12, 12, 2),
                new VillagerTrades.EmeraldForItems(BYGItems.RED_ROCK, 1, 12, 12)
            }
        )));

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