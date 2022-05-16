package potionstudios.byg.client.gui.biomepedia1;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.PageButton;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import potionstudios.byg.BYG;

import java.util.List;
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
    int maxPagePairCount;

    ItemWidget[][][][] items;
    private Screen parent;

    protected ItemsViewScreen(Screen parent) {
        super(new TextComponent(""));
        this.parent = parent;
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
            this.page = page == 0 ? maxPagePairCount - 1 : (page - 1) % maxPagePairCount;
            load(this.page);
        }, true);
        this.addRenderableWidget(pageBack);
        pageBack.x = this.leftPos + 15;
        pageBack.y = this.topPos - pageBack.getHeight() - 13;

        PageButton pageForward = new PageButton(this.rightPos - 5, this.topPos - 10, true, button -> {
            unload(page);
            this.page = (page + 1) % maxPagePairCount;
            load(this.page);
        }, true);
        this.addRenderableWidget(pageForward);
        pageForward.x = this.rightPos - pageBack.getWidth() - 22;
        pageForward.y = this.topPos - pageBack.getHeight() - 13;
    }

    private void createMenu() {
        createMenu(key -> Registry.ITEM.getKey(key).getNamespace().equals(BYG.MOD_ID), 7, 10);
    }

    private void createMenu(Predicate<Item> filter, int rowLength, int columnLength) {
        Item[] bygItems = Registry.ITEM.stream().filter(filter).toArray(Item[]::new);

        this.maxPagePairCount = (bygItems.length / (rowLength * columnLength)) / 2 + 1;
        items = new ItemWidget[maxPagePairCount][2][columnLength][rowLength];
        int registryIdx = 0;
        int width = 17;
        int buttonSize = width - 2;
        int offsetFromEdge = 13;

        for (ItemWidget[][][] pagePair : items) {
            for (int pageSide = 0; pageSide < pagePair.length; pageSide++) {
                ItemWidget[][] page = pagePair[pageSide];
                int yOffset = this.bottomPos + offsetFromEdge;
                for (ItemWidget[] row : page) {
                    int xOffset = this.leftPos + offsetFromEdge + 4;
                    for (int columnIdx = 0; columnIdx < row.length; columnIdx++) {
                        int startX = ((this.imageWidth / 2) - 8) * pageSide;
                        if (registryIdx > bygItems.length - 1) {
                            break;
                        }
                        ItemWidget itemWidget = new ItemWidget(new ItemStack(bygItems[registryIdx]), this.itemRenderer, xOffset + startX, yOffset, buttonSize, buttonSize, button -> {
                            Item item = button.stack.getItem();
                            if (button.hasAdditonalInfo) {
                                if (item instanceof BlockItem blockItem) {
                                    this.minecraft.setScreen(new BlockItemAboutScreen(this, blockItem));
                                }
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
        RenderSystem.setShaderTexture(0, BiomepediaScreen.BIOMEPEDIA_LOCATION);

        blit(poseStack, this.leftPos, this.bottomPos, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);
        super.render(poseStack, mouseX, mouseY, partialTick);
        forEach(items, itemWidget -> {
            if (itemWidget.isMouseOver(mouseX, mouseY)) {
                List<Component> tooltipLines = itemWidget.stack.getTooltipLines(Minecraft.getInstance().player, this.minecraft.options.advancedItemTooltips ? TooltipFlag.Default.ADVANCED : TooltipFlag.Default.NORMAL);
                if (itemWidget.hasAdditonalInfo) {
                    tooltipLines.add(1, new TextComponent("Click for more info"));
                }
                this.renderTooltip(poseStack, tooltipLines, itemWidget.stack.getTooltipImage(), mouseX, mouseY);
            }
        });
    }

    @Override
    public void onClose() {
        this.minecraft.setScreen(this.parent);
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