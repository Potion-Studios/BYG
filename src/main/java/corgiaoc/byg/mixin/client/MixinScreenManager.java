package corgiaoc.byg.mixin.client;

import corgiaoc.byg.client.gui.screens.HypogealImperiumScreen;
import corgiaoc.byg.core.world.BYGContainerTypes;
import net.minecraft.client.gui.IHasContainer;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("UnresolvedMixinReference")
@Mixin(ScreenManager.class)
public abstract class MixinScreenManager {


    @Shadow
    public static <M extends Container, U extends Screen & IHasContainer<M>> void register(ContainerType<? extends M> p_216911_0_, ScreenManager.IScreenFactory<M, U> p_216911_1_) {
        throw new Error("Mixin did not apply!");
    }

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void registerScreen(CallbackInfo ci) {
        register(BYGContainerTypes.HYPOGEAL_CONTAINER, HypogealImperiumScreen::new);
    }
}
