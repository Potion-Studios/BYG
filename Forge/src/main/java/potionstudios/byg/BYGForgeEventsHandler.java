package potionstudios.byg;

import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import potionstudios.byg.common.BYGHoeables;
import potionstudios.byg.common.entity.npc.BYGVillagerTrades;
import potionstudios.byg.common.entity.npc.TradesConfig;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BYGForgeEventsHandler {
    static final Object2IntMap<Item> BURN_TIMES = new Object2IntOpenHashMap<>();

    public static final Set<ResourceLocation> REGISTERED_PROFESSIONS = new HashSet<>();

    @SubscribeEvent
    public static void appendBYGVillagerTrades(VillagerTradesEvent event) {
        TradesConfig tradesConfig = TradesConfig.getConfig();
        if (tradesConfig.enabled()) {
            Map<ResourceLocation, Int2ObjectMap<VillagerTrades.ItemListing[]>> tradesByProfession = tradesConfig.tradesByProfession();
            ResourceLocation professionKey = Registry.VILLAGER_PROFESSION.getKey(event.getType());
            if (tradesByProfession.containsKey(professionKey)) {
                REGISTERED_PROFESSIONS.add(professionKey);
                Int2ObjectMap<VillagerTrades.ItemListing[]> int2ObjectMap = tradesByProfession.get(professionKey);
                BYGVillagerTrades.appendTradesList(int2ObjectMap, event.getTrades());
            } else {
                BYG.LOGGER.warn("\"%s\" is not a registered villager profession, skipping trade entry...".formatted(professionKey.toString()));
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
    public static void appendBYGHoeTillables(BlockEvent.BlockToolModificationEvent event) {
        if (event.getToolAction() == ToolActions.HOE_TILL) {
            if (event.getHeldItemStack().getItem() instanceof HoeItem) {
                Pair<Predicate<UseOnContext>, BlockState> pair = BYGHoeables.TILLABLES_FORGE.get(event.getFinalState().getBlock());
                if (pair != null) {
                    if (pair.getFirst().test(event.getContext())) {
                        event.setFinalState(pair.getSecond());
                    }
                }

            }
        }
    }


    @SubscribeEvent
    public static void registerCommands(final RegisterCommandsEvent event) {
        BYG.attachCommands(event.getDispatcher(), event.getCommandSelection());
    }
}