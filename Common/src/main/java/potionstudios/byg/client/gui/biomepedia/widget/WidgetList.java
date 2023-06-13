package potionstudios.byg.client.gui.biomepedia.widget;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.ContainerObjectSelectionList;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import potionstudios.byg.client.gui.screen.BYGContainerObjectSelectionList;

import java.util.List;

public class WidgetList extends BYGContainerObjectSelectionList<WidgetList.Entry> {

    public WidgetList(List<AbstractWidget> widgets, int width, int height, int y0, int y1, int itemHeight) {
        super(width, height, y0, y1, itemHeight);
        this.setRenderBackground(false);
        this.setRenderTopAndBottom(false);
        if (widgets.isEmpty()) {
            throw new IllegalArgumentException("Must have at least 1 widget.");
        }

        for (AbstractWidget widget : widgets) {
            this.addEntry(new Entry(widget));
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        super.renderList(guiGraphics, mouseX, mouseY, partialTick);
    }

    @Override
    protected void renderList(GuiGraphics guiGraphics, int $$1, int $$2, float $$3) {
    }

    @Override
    protected int addEntry(Entry $$0) {
        return super.addEntry($$0);
    }

    public static class Entry extends ContainerObjectSelectionList.Entry<Entry> {

        private final AbstractWidget widget;

        public Entry(AbstractWidget text) {
            this.widget = text;
        }

        @Override
        public void render(GuiGraphics guiGraphics, int pIndex, int pTop, int pLeft, int rowWidth, int pHeight, int pMouseX, int pMouseY, boolean pIsMouseOver, float pPartialTick) {
            this.widget.setX(pLeft);
            this.widget.setY(pTop);
            this.widget.render(guiGraphics, pMouseX, pMouseY, pPartialTick);
        }

        @Override
        public List<? extends GuiEventListener> children() {
            return ImmutableList.of(this.widget);
        }

        @Override
        public List<? extends NarratableEntry> narratables() {
            return ImmutableList.of(this.widget);
        }
    }
}