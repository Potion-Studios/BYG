package potionstudios.byg.client.gui.biomepedia.widgets;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.components.Widget;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import potionstudios.byg.BYG;

import java.util.function.Consumer;

public class BookTabButton extends GuiComponent implements Widget, GuiEventListener, NarratableEntry {
	private static final ResourceLocation TEXTURE = new ResourceLocation(BYG.MOD_ID, "textures/gui/biomepedia.png");

	private int posX, posY;
	private int width = 21, height = 18, activeWidth = 23, currentWidth = width;
	private int u, v;
	private Consumer<BookTabButton> pressAction;
	private boolean isActive = false, isVisible = true, isBiomeSpecific;

	public BookTabButton(int posX, int posY, int u, int v, boolean isBiomeSpecific, Consumer<BookTabButton> pressAction) {
		this.posX = posX;
		this.posY = posY;
		this.u = u;
		this.v = v;
		this.pressAction = pressAction;
		this.isVisible = isBiomeSpecific;
		this.isBiomeSpecific = isBiomeSpecific;
	}

	public boolean isActive() {
		return isActive;
	}

	public void activate(){
		this.isActive = true;
	}

	public void toggleVisibility(boolean isBiomeSpecificAllowed) {
		this.isActive = false;
		this.isVisible = !isBiomeSpecific || isBiomeSpecific && isBiomeSpecificAllowed;
	}

	@Override
	public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
		if(!isVisible) return;
		boolean hovered = mouseX > this.posX - currentWidth && mouseX <= this.posX && mouseY > this.posY && mouseY <= this.posY + height;
		boolean extend = isActive || hovered;
		currentWidth = extend ? activeWidth : width;

		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderTexture(0, TEXTURE);
		blit(poseStack, this.posX - currentWidth, this.posY, 0, extend ? 202 : 184, currentWidth, height);
		blit(poseStack, this.posX - currentWidth + 2, this.posY + 2, u, v, 14, 14);

		if(hovered) {
			//TODO Tooltip
		}

	}

	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int button) {
		if(!isVisible) return false;
		boolean hovered = mouseX > this.posX - currentWidth && mouseX <= this.posX && mouseY > this.posY && mouseY <= this.posY + height;

		if(hovered) {
			this.pressAction.accept(this);
			Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.BOOK_PAGE_TURN, 1.0F, 1.5F));
		}

		return hovered;
	}

	@Override
	public NarrationPriority narrationPriority() {
		return NarrationPriority.NONE;
	}

	@Override
	public void updateNarration(NarrationElementOutput narrationOutput) {}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
}
