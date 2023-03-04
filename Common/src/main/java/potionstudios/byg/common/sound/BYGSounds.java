package potionstudios.byg.common.sound;

import net.minecraft.core.Registry;
import net.minecraft.sounds.SoundEvent;
import potionstudios.byg.BYG;
import potionstudios.byg.reg.RegistrationProvider;
import potionstudios.byg.reg.RegistryObject;

public class BYGSounds {
    private static final RegistrationProvider<SoundEvent> PROVIDER = RegistrationProvider.get(Registry.SOUND_EVENT_REGISTRY, BYG.MOD_ID);

    public static final RegistryObject<SoundEvent> AMBIENT_VISCAL_ISLES_LOOP = createSound("ambient_viscal_isles_loop");
    public static final RegistryObject<SoundEvent> AMBIENT_VISCAL_ISLES_ADDITIONS = createSound("ambient_viscal_isles_additions");
    public static final RegistryObject<SoundEvent> AMBIENT_WAILING_GARTH_ADDITIONS = createSound("ambient_wailing_garth_additions");
    public static final RegistryObject<SoundEvent> AMBIENT_END_FOREST_LOOP = createSound("ambient_end_forest");
    public static final RegistryObject<SoundEvent> AMBIENT_END_OMINOUS_LOOP = createSound("ambient_end_ominous");
    public static final RegistryObject<SoundEvent> AMBIENT_OVERWORLD_FOREST_LOOP = createSound("ambient_overworld_forest_loop");
    public static final RegistryObject<SoundEvent> AMBIENT_OVERWORLD_FOREST_ADDITIONS = createSound("ambient_overworld_forest_additions");

    public static RegistryObject<SoundEvent> createSound(String location) {
        final var soundLocation = BYG.createLocation(location);
        return PROVIDER.register(location, () -> new SoundEvent(soundLocation));
    }

    public static void loadClass() {}
}
