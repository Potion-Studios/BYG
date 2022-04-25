package potionstudios.byg.client.gui.biomepedia1;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import potionstudios.byg.BYG;
import potionstudios.byg.util.BYGUtil;

import java.util.function.Supplier;

public class ItemViewsScreen extends Screen {

    int imageWidth = 288;
    int imageHeight = 208;
    int leftPos;
    int bottomPos;
    int rightPos;
    int topPos;

    RenderableItem[][][] renderableItems;

    protected ItemViewsScreen(Component $$0) {
        super($$0);
    }

    @Override
    protected void init() {
        super.init();
        this.leftPos = ((this.width - this.imageWidth) / 2);
        this.bottomPos = (this.height - this.imageHeight) / 2 - 15;
        this.rightPos = this.leftPos + this.imageWidth;
        this.topPos = this.bottomPos + this.imageHeight;
        Item[] bygItems = Registry.ITEM.stream().filter(key -> Registry.ITEM.getKey(key).getNamespace().equals(BYG.MOD_ID)).toArray(Item[]::new);
        int columnLength = 10;
        int rowLength = 7;
        renderableItems = new RenderableItem[(bygItems.length / (rowLength * columnLength)) + 1][columnLength][rowLength];
        int registryIdx = 0;
        int increment = 17;
        for (int pageIdx = 0; pageIdx < renderableItems.length; pageIdx++) {
            RenderableItem[][] page = renderableItems[pageIdx];
            int yOffset = this.bottomPos + 10;
            for (int rowIdx = 0; rowIdx < page.length; rowIdx++) {
                RenderableItem[] row = this.renderableItems[pageIdx][rowIdx];
                int xOffset = this.leftPos + 10;
                for (int columnIdx = 0; columnIdx < row.length; columnIdx++) {
                    row[columnIdx] = new RenderableItem(bygItems[Math.min(registryIdx, bygItems.length - 1)], xOffset, yOffset, () -> new BiomepediaScreen(new TextComponent("")));
                    registryIdx++;
                    xOffset += increment;
                }
                yOffset += increment;
            }
        }
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(poseStack);
        GuiComponent.fill(poseStack, this.leftPos, this.bottomPos, rightPos, topPos, FastColor.ARGB32.color(255, 220, 220, 220));
        GuiComponent.fill(poseStack, (this.leftPos + (this.imageWidth) / 2) - 2, this.bottomPos, (this.leftPos + (this.imageWidth) / 2) + 2, topPos, FastColor.ARGB32.color(255, 255, 0, 0));

        this.itemRenderer.blitOffset = 100.0F;

        for (RenderableItem[] items : this.renderableItems[0]) {
            for (RenderableItem item : items) {
                ItemStack itemStack = new ItemStack(item.item());
                itemRenderer.renderAndDecorateItem(itemStack, item.x, item.y);
                if (item.hovering(mouseX, mouseY)) {
                    this.renderTooltip(poseStack, itemStack.getDisplayName(), mouseX, mouseY);
                }
            }
        }
        super.render(poseStack, mouseX, mouseY, partialTick);
    }

    public record RenderableItem(Item item, int x, int y, Supplier<Screen> onClick) {

        public boolean hovering(double mouseX, double mouseY) {
           return BYGUtil.isInside(x - 8, y - 8, x + 8, y + 8, (int) mouseX, (int) mouseY);
        }
    }
}
