package potionstudios.byg.mixin.client;

import net.minecraft.client.gui.screens.OptionsScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OptionsScreen.class)
public abstract class MixinOptionsScreen extends Screen {

    protected MixinOptionsScreen(Component $$0) {
        super($$0);
    }

    @Inject(method = "init", at = @At("RETURN"))
    private void addConfigsButton(CallbackInfo ci) {
//        this.addRenderableWidget(new Button(this.width / 2 - 155, this.height / 6 + 144 - 6, 150, 20, Component.translatable("Configurations..."), (p_96268_) -> {
//            this.minecraft.setScreen(new FileBrowserScreen(this, BYG.CONFIG_PATH, Component.literal("")));
//        }));
    }
}
