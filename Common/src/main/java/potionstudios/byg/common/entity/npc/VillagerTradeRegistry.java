package potionstudios.byg.common.entity.npc;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.npc.VillagerTrades;
import potionstudios.byg.BYG;
import potionstudios.byg.core.BYGRegistry;
import potionstudios.byg.mixin.access.world.entity.npc.villagertrades.EmeraldForItemsAccess;
import potionstudios.byg.mixin.access.world.entity.npc.villagertrades.ItemsForEmeraldsAccess;
import potionstudios.byg.mixin.access.world.entity.npc.villagertrades.SuspiciousStewForEmeraldAccess;
import potionstudios.byg.util.codec.CodecUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class VillagerTradeRegistry {

    private final static Codec<VillagerTrades.EmeraldForItems> EMERALD_FOR_ITEMS_CODEC = RecordCodecBuilder.create(builder ->
        builder.group(
            CodecUtil.ITEM_CODEC.fieldOf("item").forGetter(listing -> ((EmeraldForItemsAccess) listing).byg_getItem()),
            Codec.INT.fieldOf("cost").forGetter(listing -> ((EmeraldForItemsAccess) listing).byg_getCost()),
            Codec.INT.fieldOf("max_uses").forGetter(listing -> ((EmeraldForItemsAccess) listing).byg_getMaxUses()),
            Codec.INT.fieldOf("villager_xp").forGetter(listing -> ((EmeraldForItemsAccess) listing).byg_getVillagerXp())
        ).apply(builder, VillagerTrades.EmeraldForItems::new)
    );

    private final static Codec<VillagerTrades.ItemsForEmeralds> ITEMS_FOR_EMERALDS_CODEC = RecordCodecBuilder.create(builder ->
        builder.group(
            CodecUtil.ITEM_CODEC.fieldOf("item").forGetter(listing -> ((ItemsForEmeraldsAccess) listing).byg_getItemStack().getItem()),
            Codec.INT.fieldOf("emerald_cost").forGetter(listing -> ((ItemsForEmeraldsAccess) listing).byg_getEmeraldCost()),
            Codec.INT.fieldOf("number_of_items").forGetter(listing -> ((ItemsForEmeraldsAccess) listing).byg_getNumberOfItems()),
            Codec.INT.fieldOf("max_uses").forGetter(listing -> ((ItemsForEmeraldsAccess) listing).byg_getMaxUses()),
            Codec.INT.fieldOf("villager_xp").forGetter(listing -> ((ItemsForEmeraldsAccess) listing).byg_getVillagerXp())
        ).apply(builder, VillagerTrades.ItemsForEmeralds::new)
    );

    private final static Codec<VillagerTrades.SuspiciousStewForEmerald> SUSPICIOUS_STEW_FOR_EMERALD_CODEC = RecordCodecBuilder.create(builder ->
        builder.group(
            CodecUtil.MOB_EFFECT_CODEC.fieldOf("mobEffect").forGetter(listing -> ((SuspiciousStewForEmeraldAccess) listing).byg_getEffect()),
            Codec.INT.fieldOf("duration").forGetter(listing -> ((SuspiciousStewForEmeraldAccess) listing).byg_getDuration()),
            Codec.INT.fieldOf("xp").forGetter(listing -> ((SuspiciousStewForEmeraldAccess) listing).byg_getXp())
        ).apply(builder, VillagerTrades.SuspiciousStewForEmerald::new)
    );

    private static final Map<Class<? extends VillagerTrades.ItemListing>, Codec<? extends VillagerTrades.ItemListing>> ITEM_LISTING_CLASS_BY_CODEC = Util.make(new HashMap<>(), map -> {
        map.put(VillagerTrades.EmeraldForItems.class, EMERALD_FOR_ITEMS_CODEC);
        map.put(VillagerTrades.ItemsForEmeralds.class, ITEMS_FOR_EMERALDS_CODEC);
        map.put(VillagerTrades.SuspiciousStewForEmerald.class, SUSPICIOUS_STEW_FOR_EMERALD_CODEC);
    });


    public static final Codec<VillagerTrades.ItemListing> ITEM_LISTING_CODEC = BYGRegistry.VILLAGER_TRADES_ITEM_LISTING.byNameCodec()
        .dispatchStable(itemListing -> ITEM_LISTING_CLASS_BY_CODEC.get(itemListing.getClass()), Function.identity());

    public static void register() {
        Registry.register(BYGRegistry.VILLAGER_TRADES_ITEM_LISTING, BYG.createLocation("emerald_for_items"), EMERALD_FOR_ITEMS_CODEC);
        Registry.register(BYGRegistry.VILLAGER_TRADES_ITEM_LISTING, BYG.createLocation("items_for_emeralds"), ITEMS_FOR_EMERALDS_CODEC);
        Registry.register(BYGRegistry.VILLAGER_TRADES_ITEM_LISTING, BYG.createLocation("suspicious_stew_for_emerald"), SUSPICIOUS_STEW_FOR_EMERALD_CODEC);
    }
}
