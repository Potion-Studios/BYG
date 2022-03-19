package potionstudios.byg.client.gui.biomepedia.widgets;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Widget;
import net.minecraft.client.gui.components.events.AbstractContainerEventHandler;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.narration.NarrationElementOutput;

import java.util.List;

public abstract class NestedWidget extends AbstractContainerEventHandler implements Widget, NarratableEntry {

	protected List<GuiEventListener> listeners = Lists.newArrayList();
	protected List<Widget> renderers = Lists.newArrayList();

	protected int posX, posY;
	protected int width, height;

	public NestedWidget(int x, int y, int width, int height){
		this.posX = x;
		this.posY = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public List<? extends GuiEventListener> children() {
		return listeners;
	}

	@Override
	public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		for(Widget child : renderers){
			child.render(matrixStack, mouseX, mouseY, partialTicks);
		}
	}

	public <T extends Widget & GuiEventListener> void addChild(T child){
		this.listeners.add(child);
		this.renderers.add(child);
	}

	public <T extends Widget & GuiEventListener> void removeChild(T child){
		this.listeners.remove(child);
		this.renderers.remove(child);
	}

	@Override
	public boolean isMouseOver(double mouseX, double mouseY) {
		return mouseX > this.posX && mouseY > this.posY && mouseX < this.posX + this.width && mouseY < this.posY + this.height;
	}

	@Override
	public NarrationPriority narrationPriority() {
		return NarrationPriority.NONE;
	}

	@Override
	public void updateNarration(NarrationElementOutput narrationOutput) {}
}