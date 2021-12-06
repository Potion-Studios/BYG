package potionstudios.byg.core;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import potionstudios.byg.BYG;
import potionstudios.byg.util.RegistryObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

public class BYGSounds {

    public static final List<RegistryObject<SoundEvent>> SOUNDS = new ArrayList<>();
    public static SoundEvent AMBIENT_VISCAL_ISLES_LOOP = createSound("ambient_viscal_isles_loop");
    public static SoundEvent AMBIENT_VISCAL_ISLES_ADDITIONS = createSound("ambient_viscal_isles_additions");
    public static SoundEvent AMBIENT_WAILING_GARTH_ADDITIONS = createSound("ambient_wailing_garth_additions");
    public static SoundEvent AMBIENT_END_FOREST_LOOP = createSound("ambient_end_forest");
    public static SoundEvent AMBIENT_END_OMINOUS_LOOP = createSound("ambient_end_ominous");


    public static SoundEvent createSound(String location) {
        ResourceLocation soundLocation = new ResourceLocation(BYG.MOD_ID, location);
        SoundEvent soundEvent = new SoundEvent(soundLocation);
        SOUNDS.add(new RegistryObject<>(soundEvent, location));
        return soundEvent;
    }

    public static void bootStrap(Consumer<Collection<RegistryObject<SoundEvent>>> registryStrategy) {
        registryStrategy.accept(SOUNDS);
    }
}
