package potionstudios.byg.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.BYGConstants;
import potionstudios.byg.client.BiomepediaInventoryConfig;
import potionstudios.byg.client.gui.biomepedia.screen.BiomepediaHomeScreen;

@Mixin(InventoryScreen.class)
public abstract class MixinInventoryScreen<T extends AbstractContainerMenu> extends AbstractContainerScreen<T> {

    @Unique
    private ImageButton byg$biomePedia;

    MixinInventoryScreen(T menu, Inventory inventory, Component narrationTitle) {
        super(menu, inventory, narrationTitle);
    }

    @Inject(method = "init", at = @At("RETURN"))
    protected void init(CallbackInfo ci) {
        if (BYGConstants.BIOMEPEDIA) {
            BiomepediaInventoryConfig biomepediaInventoryConfig = BiomepediaInventoryConfig.getConfig(true);
            if (biomepediaInventoryConfig.visible()) {
                ImageButton biomePedia = new ImageButton(
                        this.leftPos + biomepediaInventoryConfig.settings().widthOffset(), this.height / 2 - biomepediaInventoryConfig.settings().heightOffset(),
                        20, 18,
                        0, 220,
                        18,
                        new ResourceLocation("byg", "textures/gui/biomepedia.png"),
                        256, 256,
                        (button) -> Minecraft.getInstance().setScreen(new BiomepediaHomeScreen(new TextComponent(""))), BiomepediaHomeScreen.makeButtonToolTip(new TextComponent("BYG Biomepedia"), this),
                        new TextComponent("Lorem Ipsum")
                );

                biomePedia.visible = BiomepediaInventoryConfig.server_value;
                biomePedia.active = BiomepediaInventoryConfig.server_value;
                this.byg$biomePedia = biomePedia;
                addRenderableWidget(biomePedia);
            }
        }
    }

    @Inject(method = "init", at = @At(value = "INVOKE", shift = At.Shift.BEFORE, target = "Lnet/minecraft/client/gui/screens/inventory/InventoryScreen;addWidget(Lnet/minecraft/client/gui/components/events/GuiEventListener;)Lnet/minecraft/client/gui/components/events/GuiEventListener;"))
    private void initUpdateGuiSizeInjector(CallbackInfo ci) {
        if (BYGConstants.BIOMEPEDIA && byg$biomePedia != null) {
            BiomepediaInventoryConfig biomepediaInventoryConfig = BiomepediaInventoryConfig.getConfig();
            byg$biomePedia.setPosition(this.leftPos + biomepediaInventoryConfig.settings().widthOffset(), this.height / 2 - biomepediaInventoryConfig.settings().heightOffset());
        }
    }
}
