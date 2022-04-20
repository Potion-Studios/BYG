package potionstudios.byg.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.OptionsScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.client.config.ConfigurationFilesScreen;

@Mixin(OptionsScreen.class)
public abstract class MixinOptionsScreen extends Screen {

    protected MixinOptionsScreen(Component $$0) {
        super($$0);
    }

    @Inject(method = "render", at = @At("RETURN"))
    private void addConfigsButton(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick, CallbackInfo info) {
        this.addRenderableWidget(new Button(this.width / 2 + 5 + 160, this.height / 6 + 96 - 6, 150, 20, new TranslatableComponent("Configurations"), (p_96268_) -> {
            this.minecraft.setScreen(new ConfigurationFilesScreen());
        }));
    }
}
