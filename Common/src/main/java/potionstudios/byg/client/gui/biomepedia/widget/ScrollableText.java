package potionstudios.byg.client.gui.biomepedia.widget;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.components.ContainerObjectSelectionList;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FastColor;
import org.apache.commons.lang3.mutable.MutableInt;
import potionstudios.byg.client.GuiUtil;

import java.util.ArrayList;
import java.util.List;

public class ScrollableText extends ContainerObjectSelectionList<ScrollableText.ScrollableTextEntry> {

    public static final boolean DEBUG = false;

    public ScrollableText(Component text, int width, int height, int y0, int y1) {
        this(text, width, height, y0, y1, 0, false, false);
    }

    public ScrollableText(Component text, int width, int height, int y0, int y1, int textColor, boolean renderBackground, boolean renderTopAndBottom) {
        super(Minecraft.getInstance(), width, height, y0, y1, Minecraft.getInstance().font.lineHeight + 1);
        this.setRenderBackground(renderBackground);
        this.setRenderTopAndBottom(renderTopAndBottom);
        ArrayList<Component> toolTip = new ArrayList<>();
        GuiUtil.makeAndCacheConfigCommentWrappedToolTip(width - 6, text.getString(), new MutableInt(), toolTip);
        for (Component component : toolTip) {
            this.addEntry(new ScrollableTextEntry(component, width, textColor));
        }
    }

    @Override
    protected int getScrollbarPosition() {
        return this.x1 - 5;
    }

    @Override
    public int getRowWidth() {
        return this.width;
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        super.render(poseStack, mouseX, mouseY, partialTick);
        if (DEBUG) {
            GuiComponent.fill(poseStack, this.x0, this.y0, this.x1, this.y1, FastColor.ARGB32.color(50, 0, 255, 0));
        }
    }

    @Override
    protected int addEntry(ScrollableTextEntry $$0) {
        return super.addEntry($$0);
    }

    public static class ScrollableTextEntry extends ContainerObjectSelectionList.Entry<ScrollableTextEntry> {

        private final Component text;
        private final int textMaxWidth;
        private int textColor;

        public ScrollableTextEntry(Component text, int textMaxWidth, int textColor) {
            this.text = text;
            this.textMaxWidth = textMaxWidth;
            this.textColor = textColor;
        }

        @Override
        public void render(PoseStack pPoseStack, int pIndex, int pTop, int pLeft, int rowWidth, int pHeight, int pMouseX, int pMouseY, boolean pIsMouseOver, float pPartialTick) {
            float textHeightOffset = (float) (pTop + pHeight - Minecraft.getInstance().font.lineHeight);
            Minecraft.getInstance().font.draw(pPoseStack, this.text, (pLeft) + rowWidth - this.textMaxWidth, textHeightOffset, this.textColor);
        }

        @Override
        public List<? extends GuiEventListener> children() {
            return ImmutableList.of();
        }

        @Override
        public List<? extends NarratableEntry> narratables() {
            return ImmutableList.of();
        }
    }
}