package potionstudios.byg.common.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import potionstudios.byg.BYG;
import potionstudios.byg.reg.RegistrationProvider;
import potionstudios.byg.reg.RegistryObject;
import potionstudios.byg.util.ModPlatform;

import java.util.function.Supplier;

public class BYGCreativeModeTabs {

    public static final RegistrationProvider<CreativeModeTab> PROVIDER = RegistrationProvider.get(Registries.CREATIVE_MODE_TAB, BYG.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BYG_TAB = createCreativeTab(() -> ModPlatform.INSTANCE.creativeModeTab(), "byg");

    public static <T extends CreativeModeTab> RegistryObject<T> createCreativeTab(Supplier<T> creativeModeTab, String id) {
        return PROVIDER.register(id, creativeModeTab);
    }

    public static void loadClass() {}

}
