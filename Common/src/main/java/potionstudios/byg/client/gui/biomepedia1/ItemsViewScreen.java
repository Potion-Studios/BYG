package potionstudios.byg.client.gui.biomepedia1;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.PageButton;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import potionstudios.byg.BYG;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class ItemsViewScreen extends Screen {

    int imageWidth = 288;
    int imageHeight = 208;
    int leftPos;
    int bottomPos;
    int rightPos;
    int topPos;
    int page;
    int maxPageCount;

    ItemWidget[][][][] items;

    protected ItemsViewScreen(Component $$0) {
        super($$0);
    }

    @Override
    protected void init() {
        super.init();
        this.leftPos = ((this.width - this.imageWidth) / 2);
        this.bottomPos = (this.height - this.imageHeight) / 2 - 15;
        this.rightPos = this.leftPos + this.imageWidth;
        this.topPos = this.bottomPos + this.imageHeight;
        createMenu();
        load(this.page);

        PageButton pageBack = new PageButton(this.leftPos + 5, this.topPos - 10, false, button -> {
            unload(page);
            this.page = page == 0 ? maxPageCount - 1 : (page - 1) % maxPageCount;
            load(this.page);
        }, true);
        this.addRenderableWidget(pageBack);
        pageBack.x = this.leftPos;
        pageBack.y = this.topPos - pageBack.getHeight() - 10;

        PageButton pageForward = new PageButton(this.rightPos - 5, this.topPos - 10, true, button -> {
            unload(page);
            this.page = (page + 1) % maxPageCount;
            load(this.page);
        }, true);
        this.addRenderableWidget(pageForward);
        pageForward.x = this.rightPos - pageBack.getWidth();
        pageForward.y = this.topPos - pageBack.getHeight() - 10;
    }

    private void createMenu() {
        createMenu(key -> Registry.ITEM.getKey(key).getNamespace().equals(BYG.MOD_ID), 7, 10);
    }

    private void createMenu(Predicate<Item> filter, int rowLength, int columnLength) {
        Item[] bygItems = Registry.ITEM.stream().filter(filter).toArray(Item[]::new);

        this.maxPageCount = (bygItems.length / (rowLength * columnLength)) / 2 + 1;
        items = new ItemWidget[maxPageCount][2][columnLength][rowLength];
        int registryIdx = 0;
        int width = 17;
        int buttonSize = width - 2;
        int offsetFromEdge = 13;

        for (ItemWidget[][][] pagePair : items) {
            for (int pageSide = 0; pageSide < pagePair.length; pageSide++) {
                ItemWidget[][] page = pagePair[pageSide];
                int yOffset = this.bottomPos + offsetFromEdge;
                for (ItemWidget[] row : page) {
                    int xOffset = this.leftPos + offsetFromEdge;
                    for (int columnIdx = 0; columnIdx < row.length; columnIdx++) {
                        int startX = (this.imageWidth / 2) * pageSide;
                        if (registryIdx > bygItems.length - 1) {
                            break;
                        }
                        ItemWidget itemWidget = new ItemWidget(new ItemStack(bygItems[registryIdx]), this.itemRenderer, xOffset + startX, yOffset, buttonSize, buttonSize, button -> {
                            Item item = button.stack.getItem();
                            if (item instanceof BlockItem blockItem) {
                                this.minecraft.setScreen(new BlockItemAboutScreen(this, blockItem));
                            }
                        });
                        row[columnIdx] = this.addRenderableWidget(itemWidget);
                        registryIdx++;
                        xOffset += width;
                    }
                    yOffset += width;
                }
            }
        }
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(poseStack);
        GuiComponent.fill(poseStack, this.leftPos, this.bottomPos, rightPos, topPos, FastColor.ARGB32.color(255, 220, 220, 220));
        GuiComponent.fill(poseStack, (this.leftPos + (this.imageWidth) / 2) - 2, this.bottomPos, (this.leftPos + (this.imageWidth) / 2) + 2, topPos, FastColor.ARGB32.color(255, 255, 0, 0));
        super.render(poseStack, mouseX, mouseY, partialTick);
        forEach(items, itemWidget -> {
            if (itemWidget.isMouseOver(mouseX, mouseY)) {
                this.renderTooltip(poseStack, itemWidget.stack.getHoverName(), mouseX, mouseY);
            }
        });
    }

    private static void forEach(ItemWidget[][][][] widgets, Consumer<ItemWidget> widget) {
        for (ItemWidget[][][] itemWidgetsPage : widgets) {
            for (ItemWidget[][] itemWidgetsLeftRight : itemWidgetsPage) {
                for (ItemWidget[] itemWidgets : itemWidgetsLeftRight) {
                    for (ItemWidget itemWidget : itemWidgets) {
                        if (itemWidget != null) {
                            widget.accept(itemWidget);
                        }
                    }
                }
            }
        }
    }


    private void unload(int page) {
        ItemWidget[][][] renderableItem = this.items[page];
        for (ItemWidget[][] itemWidgetsByPage : renderableItem) {
            for (ItemWidget[] itemWidgets : itemWidgetsByPage) {
                for (ItemWidget itemWidget : itemWidgets) {
                    if (itemWidget != null) {
                        itemWidget.visible = false;
                        itemWidget.active = false;
                    }
                }
            }
        }
    }

    private void load(int page) {
        ItemWidget[][][] renderableItem = this.items[page];
        for (ItemWidget[][] itemWidgetsByPage : renderableItem) {
            for (ItemWidget[] itemWidgets : itemWidgetsByPage) {
                for (ItemWidget itemWidget : itemWidgets) {
                    if (itemWidget != null) {
                        itemWidget.visible = true;
                        itemWidget.active = true;
                    }
                }
            }
        }
    }
}