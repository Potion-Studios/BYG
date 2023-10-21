package potionstudios.byg.common.entity.npc;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import corgitaco.corgilib.entity.npc.VillagerTradeRegistry;
import corgitaco.corgilib.serialization.codec.CodecUtil;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.Util;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.StructureTags;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.util.BYGUtil;
import potionstudios.byg.util.lazy.LazySupplier;

import java.util.*;
import java.util.function.Supplier;

public class BYGVillagerTrades {

    protected static final Supplier<Map<ResourceKey<VillagerProfession>, Int2ObjectMap<VillagerTrades.ItemListing[]>>> TRADES = () ->
            Util.make(new HashMap<ResourceKey<VillagerProfession>, Int2ObjectMap<VillagerTrades.ItemListing[]>>(), map -> {
        map.put(BYGVillagerProfessions.FORAGER.getResourceKey(), toIntMap(ImmutableMap.of(
            1, new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(Items.RED_MUSHROOM, 10, 12, 2),
                new VillagerTrades.EmeraldForItems(Items.BROWN_MUSHROOM, 10, 12, 2),
                new VillagerTrades.EmeraldForItems(BYGItems.GREEN_MUSHROOM.get(), 10, 12, 2)
            },
            2, new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(BYGItems.WOOD_BLEWIT.get(), 8, 12, 3),
                new VillagerTrades.EmeraldForItems(BYGItems.WHITE_PUFFBALL_CAP.get(), 8, 12, 3)
            },
            3, new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsForEmeralds(BYGItems.WHITE_PUFFBALL_SPORES.get(), 4, 5, 4, 2),
                new VillagerTrades.EmeraldForItems(Items.CRIMSON_FUNGUS, 10, 12, 2),
                new VillagerTrades.EmeraldForItems(Items.WARPED_FUNGUS, 10, 12, 2),
                new VillagerTrades.EmeraldForItems(BYGWoodTypes.SYTHIAN.growerItem().get(), 10, 12, 2),
            },
            4, new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsForEmeralds(BYGItems.WITCH_HAZEL_BRANCH.get(), 4, 9, 4, 3),
                new VillagerTrades.ItemsForEmeralds(BYGItems.WITCH_HAZEL_BLOSSOM.get(), 10, 1, 10, 3),
            },
            5, new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(BYGWoodTypes.IMPARIUS.growerItem().asItem(), 10, 12, 2),
                new VillagerTrades.EmeraldForItems(BYGItems.FUNGAL_IMPARIUS.get(), 10, 12, 2),
            }
        )));

        map.put(getKeyOrThrow(VillagerProfession.BUTCHER), toIntMap(ImmutableMap.of(
            2, new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(BYGItems.BLUE_BERRY.get(), 10, 12, 2)
            }
        )));
        map.put(getKeyOrThrow(VillagerProfession.FARMER), toIntMap(ImmutableMap.of(
            1, new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(BYGItems.CATTAIL_SPROUT.get(), 24, 12, 2)
            },
            2, new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(BYGItems.BAOBAB_FRUIT.get(), 10, 12, 2),
                new VillagerTrades.EmeraldForItems(BYGItems.ALOE_VERA.get(), 16, 12, 2),
                new VillagerTrades.EmeraldForItems(BYGItems.GREEN_APPLE.get(), 24, 12, 2)
            },
            3, new VillagerTrades.ItemListing[]{
                new VillagerTrades.EmeraldForItems(BYGItems.JOSHUA_FRUIT.get(), 10, 12, 2)
            },
            4, new VillagerTrades.ItemListing[]{
                new VillagerTrades.ItemsAndEmeraldsToItems(Items.DIRT, 16, 2, BYGItems.LUSH_DIRT.get(), 16, 4, 4)
            }
        )));
        map.put(getKeyOrThrow(VillagerProfession.MASON), toIntMap(ImmutableMap.of(
            3, new VillagerTrades.ItemListing[]{
                   new VillagerTrades.EmeraldForItems(BYGItems.ROCKY_STONE.get(), 12, 12, 20),
                   new VillagerTrades.ItemsForEmeralds(BYGItems.ROCKY_STONE.get(), 1, 1, 12, 10),
                   new VillagerTrades.EmeraldForItems(BYGItems.MOSSY_STONE.get(), 12, 12, 20),
                   new VillagerTrades.ItemsForEmeralds(BYGItems.MOSSY_STONE.get(), 1, 1, 12, 10)
            },
            4, new VillagerTrades.ItemListing[]{
                   new VillagerTrades.EmeraldForItems(BYGItems.DACITE.get(), 12, 12, 30),
                   new VillagerTrades.ItemsForEmeralds(BYGItems.DACITE.get(), 1, 1, 12, 15),
                   new VillagerTrades.EmeraldForItems(BYGItems.SOAPSTONE.get(), 12, 12, 30),
                   new VillagerTrades.ItemsForEmeralds(BYGItems.SOAPSTONE.get(), 1, 1, 12, 15),
                   new VillagerTrades.EmeraldForItems(BYGItems.RED_ROCK.get(), 12, 12, 30),
                   new VillagerTrades.ItemsForEmeralds(BYGItems.RED_ROCK.get(), 1, 1, 12, 15)
            }
        )));

        map.put(getKeyOrThrow(VillagerProfession.CARTOGRAPHER), toIntMap(ImmutableMap.of(
                2, new VillagerTrades.ItemListing[]{
                        new VillagerTrades.TreasureMapForEmeralds(14, StructureTags.ON_WOODLAND_EXPLORER_MAPS, "filled_map.ancient_sequoia", MapDecoration.Type.MONUMENT, 12, 10),
                }
                )));

        for (VillagerProfession villagerProfession : BuiltInRegistries.VILLAGER_PROFESSION.stream().filter(villagerProfession -> villagerProfession != VillagerProfession.NITWIT && villagerProfession != VillagerProfession.NONE).toList()) {
            if (villagerProfession != VillagerProfession.NITWIT && villagerProfession != VillagerProfession.NONE) {
                Int2ObjectMap<VillagerTrades.ItemListing[]> tradesByLevel = map.computeIfAbsent(getKeyOrThrow(villagerProfession), villagerProfession1 -> new Int2ObjectOpenHashMap<>());
                for (int i = 1; i <= 5; i++) {
                    tradesByLevel.computeIfAbsent(i, key ->  new VillagerTrades.ItemListing[]{});
                }
            }
        }
    });

    private static ResourceKey<VillagerProfession> getKeyOrThrow(VillagerProfession profession) {
        return BuiltInRegistries.VILLAGER_PROFESSION.getResourceKey(profession).orElseThrow();
    }

    protected static final LazySupplier<Int2ObjectMap<VillagerTrades.ItemListing[]>> WANDERING_TRADER_TRADES = new LazySupplier<>(() ->
            toIntMap(ImmutableMap.of(
                    1, Util.make(new ArrayList<VillagerTrades.ItemListing>(), list -> {
                        for (final var sapling : BYGItems.SAPLINGS) {
                            list.add(new VillagerTrades.ItemsForEmeralds(sapling.get(), 5, 1, 2));
                        }
                        list.add(new VillagerTrades.ItemsForEmeralds(BYGItems.SKYRIS_VINE.get(), 5, 2, 2));
                        list.add(new VillagerTrades.ItemsForEmeralds(BYGItems.POISON_IVY.get(), 5, 2, 2));
                    }).toArray(VillagerTrades.ItemListing[]::new),
                    2, new VillagerTrades.ItemListing[]{}
            )));

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
            ), int2ObjectMap -> BYGUtil.convertMapValueType(int2ObjectMap, Int2ObjectOpenHashMap::new, Arrays::asList)
        );
    }
}