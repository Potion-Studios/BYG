package potionstudios.byg.common.container;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import potionstudios.byg.BYG;
import potionstudios.byg.client.gui.HypogealImperiumContainer;
import potionstudios.byg.mixin.access.MenuTypeAccess;
import potionstudios.byg.util.RegistryObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BYGMenuTypes {

    public static final List<RegistryObject<MenuType<?>>> MENU_TYPES = new ArrayList<>();

    public static final MenuType<HypogealImperiumContainer> HYPOGEAL_CONTAINER = register("hypogeal", HypogealImperiumContainer::new);


    private static <T extends AbstractContainerMenu> MenuType<T> register(String key, MenuType.MenuSupplier<T> builder) {
        MenuType<T> containerType = MenuTypeAccess.byg_create(builder);
        MENU_TYPES.add(new RegistryObject<>(containerType, key));
        return containerType;
    }

    public static Collection<RegistryObject<MenuType<?>>> bootStrap() {
        return MENU_TYPES;
    }

    static {
        BYG.LOGGER.info("BYG Menu Types class loaded.");
    }
}
