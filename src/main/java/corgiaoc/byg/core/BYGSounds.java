package corgiaoc.byg.core;

import corgiaoc.byg.BYG;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

import java.util.ArrayList;
import java.util.List;

public class BYGSounds {

    public static final List<SoundEvent> SOUNDS = new ArrayList<>();
    public static SoundEvent AMBIENT_VISCAL_ISLES_LOOP = createSound("ambient_viscal_isles_loop");
    public static SoundEvent AMBIENT_VISCAL_ISLES_ADDITIONS = createSound("ambient_viscal_isles_additions");
    public static SoundEvent AMBIENT_WAILING_GARTH_ADDITIONS = createSound("ambient_wailing_garth_additions");
    public static SoundEvent AMBIENT_END_FOREST_LOOP = createSound("ambient_end_forest");
    public static SoundEvent AMBIENT_END_OMINOUS_LOOP = createSound("ambient_end_ominous");


    public static SoundEvent createSound(String location) {
        ResourceLocation soundLocation = new ResourceLocation(BYG.MOD_ID, location);
        SoundEvent soundEvent = new SoundEvent(soundLocation);
        soundEvent.setRegistryName(soundLocation);
        SOUNDS.add(soundEvent);
        return soundEvent;
    }
}
