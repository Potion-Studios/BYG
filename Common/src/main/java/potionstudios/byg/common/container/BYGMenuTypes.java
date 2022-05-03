package potionstudios.byg.common.container;

import net.minecraft.core.Registry;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import potionstudios.byg.BYG;
import potionstudios.byg.client.gui.HypogealImperiumContainer;
import potionstudios.byg.mixin.access.MenuTypeAccess;
import potionstudios.byg.registration.RegistrationProvider;
import potionstudios.byg.registration.RegistryObject;

public class BYGMenuTypes {

    private static final RegistrationProvider<MenuType<?>> PROVIDER = RegistrationProvider.get(Registry.MENU_REGISTRY, BYG.MOD_ID);

    public static final RegistryObject<MenuType<HypogealImperiumContainer>> HYPOGEAL_CONTAINER = register("hypogeal", HypogealImperiumContainer::new);

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> register(String key, MenuType.MenuSupplier<T> builder) {
        return PROVIDER.register(key, () -> MenuTypeAccess.byg_create(builder));
    }

    public static void loadClass() {}
}
