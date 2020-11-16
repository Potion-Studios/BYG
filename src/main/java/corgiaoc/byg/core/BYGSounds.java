package corgiaoc.byg.core;

import corgiaoc.byg.BYG;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class BYGSounds {

    @Mod.EventBusSubscriber(modid = BYG.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class SoundRegistry {
        public static SoundEvent AMBIENT_VISCAL_ISLES_LOOP = new SoundEvent(new ResourceLocation(BYG.MOD_ID, "ambient_viscal_isles_loop"));
        public static SoundEvent AMBIENT_VISCAL_ISLES_ADDITIONS = new SoundEvent(new ResourceLocation(BYG.MOD_ID, "ambient_viscal_isles_additions"));
        public static SoundEvent AMBIENT_WAILING_GARTH_ADDITIONS = new SoundEvent(new ResourceLocation(BYG.MOD_ID, "ambient_wailing_garth_additions"));


        @SubscribeEvent
        public static void bygRegisterSounds(RegistryEvent.Register<SoundEvent> event) {
            event.getRegistry().registerAll(
                    AMBIENT_VISCAL_ISLES_LOOP.setRegistryName(new ResourceLocation(BYG.MOD_ID, "ambient_viscal_isles_loop")),
                    AMBIENT_VISCAL_ISLES_ADDITIONS.setRegistryName(new ResourceLocation(BYG.MOD_ID, "ambient_viscal_isles_additions")),
                    AMBIENT_WAILING_GARTH_ADDITIONS.setRegistryName(new ResourceLocation(BYG.MOD_ID, "ambient_wailing_garth_additions"))
            );
        }
    }
}
