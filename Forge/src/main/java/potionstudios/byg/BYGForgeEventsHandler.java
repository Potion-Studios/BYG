package potionstudios.byg;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import potionstudios.byg.common.entity.npc.BYGVillagerTrades;
import potionstudios.byg.common.entity.npc.TradesConfig;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BYGForgeEventsHandler {
    static final Object2IntMap<Item> BURN_TIMES = new Object2IntOpenHashMap<>();

    public static final Set<ResourceKey<VillagerProfession>> REGISTERED_PROFESSIONS = new ObjectOpenHashSet<>();

    @SubscribeEvent
    public static void appendBYGVillagerTrades(VillagerTradesEvent event) {
        TradesConfig tradesConfig = TradesConfig.getConfig();
        if (tradesConfig.enabled()) {
            Map<ResourceKey<VillagerProfession>, Int2ObjectMap<VillagerTrades.ItemListing[]>> tradesByProfession = tradesConfig.tradesByProfession();
            ResourceKey<VillagerProfession> professionKey = Registry.VILLAGER_PROFESSION.getResourceKey(event.getType()).orElseThrow();
            if (tradesByProfession.containsKey(professionKey)) {
                REGISTERED_PROFESSIONS.add(professionKey);
                Int2ObjectMap<VillagerTrades.ItemListing[]> int2ObjectMap = tradesByProfession.get(professionKey);
                BYGVillagerTrades.appendTradesList(int2ObjectMap, event.getTrades());
            }
        }
    }

    @SubscribeEvent
    public static void appendBYGWanderingTraderTrades(WandererTradesEvent event) {
        TradesConfig tradesConfig = TradesConfig.getConfig();
        Int2ObjectMap<VillagerTrades.ItemListing[]> wanderingTraderTrades = tradesConfig.wanderingTraderTrades();
        if (tradesConfig.enabled()) {
            if (wanderingTraderTrades.containsKey(1)) {
                event.getGenericTrades().addAll(Arrays.asList(wanderingTraderTrades.get(1)));
            }
            if (wanderingTraderTrades.containsKey(2)) {
                event.getRareTrades().addAll(Arrays.asList(wanderingTraderTrades.get(2)));
            }
        } else {
            BYG.LOGGER.warn("Ignoring villager/wandering trader trades added by BYG.");
        }
    }

    @SubscribeEvent
    public static void onBurnTime(final FurnaceFuelBurnTimeEvent event) {
        Item item = event.getItemStack().getItem();
        if (BURN_TIMES.containsKey(item)) {
            event.setBurnTime(BURN_TIMES.getInt(item));
        }
    }

    @SubscribeEvent
    public static void registerCommands(final RegisterCommandsEvent event) {
        BYG.attachCommands(event.getDispatcher(), event.getCommandSelection());
    }
}