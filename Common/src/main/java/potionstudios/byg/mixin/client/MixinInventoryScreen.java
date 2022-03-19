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
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.client.gui.biomepedia.BiomePediaScreen;

@Mixin(InventoryScreen.class)
public abstract class MixinInventoryScreen<T extends AbstractContainerMenu> extends AbstractContainerScreen {

	private ImageButton biomePedia;

	public MixinInventoryScreen(AbstractContainerMenu menu, Inventory inventory, Component narrationTitle) {
		super(menu, inventory, narrationTitle);
	}

	@Inject(method = "init", at = @At("RETURN"))
	protected void init(CallbackInfo ci) {
		addRenderableWidget(biomePedia = new ImageButton(
				this.leftPos + 126, this.height / 2 - 22,
				20, 18,
				0, 220,
				18,
				new ResourceLocation("byg", "textures/gui/biomepedia.png"),
				256, 256,
				(btn) -> Minecraft.getInstance().setScreen(new BiomePediaScreen()),
				new TextComponent("Lorem Ipsum")
		));
	}

	@Inject(method = "lambda$init$0", at = @At("RETURN"))
	protected void updateGuiSize(CallbackInfo ci){
		biomePedia.setPosition(this.leftPos + 126, this.height / 2 - 22);
	}
}
