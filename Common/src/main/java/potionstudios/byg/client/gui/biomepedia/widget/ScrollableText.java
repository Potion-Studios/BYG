package potionstudios.byg.client.gui.biomepedia.widget;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ContainerObjectSelectionList;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FastColor;
import net.minecraft.util.FormattedCharSequence;
import potionstudios.byg.client.gui.screen.BYGContainerObjectSelectionList;

import java.util.List;

public class ScrollableText extends BYGContainerObjectSelectionList<ScrollableText.ScrollableTextEntry> {

    public static final boolean DEBUG = false;

    public ScrollableText(Component text, int width, int height, int y0, int y1) {
        this(text, width, height, y0, y1, 0, false, false);
    }

    public ScrollableText(Component text, int width, int height, int y0, int y1, int textColor, boolean renderBackground, boolean renderTopAndBottom) {
        super(width, height, y0, y1, Minecraft.getInstance().font.lineHeight + 1);
        this.setRenderBackground(renderBackground);
        this.setRenderTopAndBottom(renderTopAndBottom);

        for (FormattedCharSequence formattedCharSequence : Minecraft.getInstance().font.split(text, width - 6)) {
            this.addEntry(new ScrollableTextEntry(formattedCharSequence, width, textColor));
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);

        if (DEBUG) {
            guiGraphics.fill(this.x0, this.y0, this.x1, this.y1, FastColor.ARGB32.color(50, 0, 255, 0));
        }
    }

    public static class ScrollableTextEntry extends ContainerObjectSelectionList.Entry<ScrollableTextEntry> {

        private final FormattedCharSequence text;
        private final int textMaxWidth;
        private final int textColor;

        public ScrollableTextEntry(FormattedCharSequence text, int textMaxWidth, int textColor) {
            this.text = text;
            this.textMaxWidth = textMaxWidth;
            this.textColor = textColor;
        }

        @Override
        public List<? extends GuiEventListener> children() {
            return ImmutableList.of();
        }

        @Override
        public List<? extends NarratableEntry> narratables() {
            return ImmutableList.of();
        }

        @Override
        public void render(GuiGraphics guiGraphics, int pIndex, int pTop, int pLeft, int rowWidth, int pHeight, int pMouseX, int pMouseY, boolean pIsMouseOver, float pPartialTick) {
            int textHeightOffset =  (pTop + pHeight - Minecraft.getInstance().font.lineHeight);
            guiGraphics.drawString(Minecraft.getInstance().font, this.text, (pLeft) + rowWidth - this.textMaxWidth, textHeightOffset, this.textColor);
        }
    }
}