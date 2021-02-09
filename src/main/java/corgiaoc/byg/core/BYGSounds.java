package corgiaoc.byg.core;

import corgiaoc.byg.BYG;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BYGSounds {
    public static SoundEvent AMBIENT_VISCAL_ISLES_LOOP = createSound(new SoundEvent(new Identifier(BYG.MOD_ID, "ambient_viscal_isles_loop")), "ambient_viscal_isles_loop");
    public static SoundEvent AMBIENT_VISCAL_ISLES_ADDITIONS = createSound(new SoundEvent(new Identifier(BYG.MOD_ID, "ambient_viscal_isles_additions")), "ambient_viscal_isles_additions");
    public static SoundEvent AMBIENT_WAILING_GARTH_ADDITIONS = createSound(new SoundEvent(new Identifier(BYG.MOD_ID, "ambient_wailing_garth_additions")), "ambient_wailing_garth_additions");
    public static SoundEvent AMBIENT_END_FOREST_LOOP = createSound(new SoundEvent(new Identifier(BYG.MOD_ID, "ambient_end_forest")), "ambient_end_forest");
    public static SoundEvent AMBIENT_END_OMINOUS_LOOP = createSound(new SoundEvent(new Identifier(BYG.MOD_ID, "ambient_end_ominous")), "ambient_end_ominous");

    public static SoundEvent createSound(SoundEvent event, String id) {
        Registry.register(Registry.SOUND_EVENT, new Identifier(BYG.MOD_ID, id), event);
        return event;
    }
}
