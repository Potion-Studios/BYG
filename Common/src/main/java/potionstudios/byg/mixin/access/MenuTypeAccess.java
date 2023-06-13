package potionstudios.byg.mixin.access;

import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(MenuType.class)
public interface MenuTypeAccess {

    @Invoker("<init>")
    static <T extends AbstractContainerMenu> MenuType<T> byg_create(MenuType.MenuSupplier<T> menuSupplier, FeatureFlagSet featureFlagSet) {
        throw new Error("Mixin did not apply!");
    }
}
