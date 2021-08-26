package corgiaoc.byg.core.world;

import corgiaoc.byg.BYG;
import corgiaoc.byg.client.gui.HypogealImperiumContainer;
import corgiaoc.byg.mixin.access.MenuTypeAccess;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

import java.util.ArrayList;
import java.util.List;

public class BYGContainerTypes {

    public static final List<MenuType<?>> CONTAINER_TYPES = new ArrayList<>();

    public static final MenuType<HypogealImperiumContainer> HYPOGEAL_CONTAINER = register("hypogeal", HypogealImperiumContainer::new);


    private static <T extends AbstractContainerMenu> MenuType<T> register(String key, MenuType.MenuSupplier<T> builder) {
        MenuType<T> containerType = MenuTypeAccess.create(builder);
        Registry.register(Registry.MENU, new ResourceLocation(BYG.MOD_ID, key), containerType);
        CONTAINER_TYPES.add(containerType);
        return containerType;
    }
}
