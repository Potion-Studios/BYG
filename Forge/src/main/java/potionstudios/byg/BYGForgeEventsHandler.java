package potionstudios.byg;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import potionstudios.byg.common.entity.npc.BYGVillagerTrades;
import potionstudios.byg.common.entity.npc.VillagerTradesConfig;

import java.util.Map;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BYGForgeEventsHandler {

    @SubscribeEvent
    public static void setupVillagerTrades(VillagerTradesEvent event) {
        Map<VillagerProfession, Int2ObjectMap<VillagerTrades.ItemListing[]>> tradesByProfession = VillagerTradesConfig.getConfig(true).tradesByProfession();
        if (tradesByProfession.containsKey(event.getType())) {
            Int2ObjectMap<VillagerTrades.ItemListing[]> int2ObjectMap = tradesByProfession.get(event.getType());
            BYGVillagerTrades.appendTradesList(int2ObjectMap,  event.getTrades());
        }
    }
}