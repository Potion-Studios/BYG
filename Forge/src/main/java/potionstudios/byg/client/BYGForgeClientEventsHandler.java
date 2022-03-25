package potionstudios.byg.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import potionstudios.byg.client.textures.ColorManager;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BYGForgeClientEventsHandler {


    @SubscribeEvent
    public static void onColorHandlerEvent$Block(ColorHandlerEvent.Block event) {
        ColorManager.onBlockColorsInit(event.getBlockColors());
    }


    @SubscribeEvent
    public static void onColorHandlerEvent$Item(ColorHandlerEvent.Item event) {
        ColorManager.onItemColorsInit(event.getBlockColors(), event.getItemColors());
    }
}