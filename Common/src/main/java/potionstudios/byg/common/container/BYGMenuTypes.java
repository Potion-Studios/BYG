package potionstudios.byg.common.container;

import net.minecraft.core.Registry;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import potionstudios.byg.BYG;
import potionstudios.byg.client.gui.HypogealImperiumContainer;
import potionstudios.byg.mixin.access.MenuTypeAccess;
import potionstudios.byg.registration.BygRegistrationProvider;
import potionstudios.byg.registration.BygRegistryObject;
import potionstudios.byg.util.RegistryObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BYGMenuTypes {

    public static final BygRegistryObject<MenuType<HypogealImperiumContainer>> HYPOGEAL_CONTAINER = register("hypogeal", HypogealImperiumContainer::new);

    @SuppressWarnings("unchecked")
    private static <T extends AbstractContainerMenu> BygRegistryObject<MenuType<T>> register(String key, MenuType.MenuSupplier<T> builder) {
        return (BygRegistryObject<MenuType<T>>) (Object) BygRegistrationProvider.INSTANCE.register(Registry.MENU_REGISTRY, key, () -> MenuTypeAccess.byg_create(builder));
    }

    public static void loadClass() {}
}
