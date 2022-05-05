package potionstudios.byg.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import potionstudios.byg.client.textures.ColorManager;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BYGForgeClientEventsHandler {

    @SubscribeEvent
    public static void byg_onColorHandlerEvent$Block(ColorHandlerEvent.Block event) {
        ColorManager.onBlockColorsInit(event.getBlockColors());
    }

    @SubscribeEvent
    public static void byg_onColorHandlerEvent$Item(ColorHandlerEvent.Item event) {
        ColorManager.onItemColorsInit(event.getBlockColors(), event.getItemColors());
    }

    @SubscribeEvent
    public static void byg_onEntityRenderersEvent$RegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        BYGEntityRenderers.register(event::registerEntityRenderer);
    }

    @SubscribeEvent
    public static void byg_registerParticleFactories(ParticleFactoryRegisterEvent event) {
        BYGClient.registerParticles(Minecraft.getInstance().particleEngine::register);
    }
}