package potionstudios.byg.mixin.access.client;

import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.net.URI;

@Mixin(Screen.class)
public interface ScreenAccess {

    @Invoker("openLink")
    void byg_invokeOpenLink(URI uri);
}