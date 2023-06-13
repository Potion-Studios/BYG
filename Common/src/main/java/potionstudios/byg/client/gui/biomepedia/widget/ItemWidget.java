package potionstudios.byg.client.gui.biomepedia.widget;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public class ItemWidget extends AbstractWidget {
    public final ItemStack stack;
    private final ItemRenderer itemRenderer;
    private final OnClick onClick;
    public final boolean hasAdditonalInfo;

    public ItemWidget(ItemStack stack, ItemRenderer itemRenderer, int pX, int pY, int pWidth, int pHeight, OnClick onClick) {
        super(pX, pY, pWidth, pHeight, Component.literal(""));
        this.stack = stack;
        this.itemRenderer = itemRenderer;
        this.onClick = onClick;
        this.visible = false;
        this.active = false;
        this.hasAdditonalInfo = false; //stack.getItem() instanceof BlockItem;
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {

    }

    @Override
    public void onClick(double $$0, double $$1) {
        this.onClick.click(this);
        super.onClick($$0, $$1);
    }

    @Override
    public void renderWidget(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        this.itemRenderer.renderAndDecorateItem(poseStack, this.stack, this.getX(), this.getY());
    }

    public interface OnClick {

        void click(ItemWidget button);
    }
}
