package potionstudios.byg.client.gui.biomepedia1;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.util.FastColor;

import java.util.ArrayList;
import java.util.List;

public class BiomepediaScreen extends Screen {

    int imageWidth = 288;
    int imageHeight = 208;
    int leftPos;
    int topPos;
    int toolTipMaxWidth;
    int rightPos;
    int bottomPos;
    int textStartHeight;
    int leftPageCenter;
    int rightPageCenter;
    private ScrollableText scrollableText;
    private WidgetList widgets;

    public BiomepediaScreen(Component $$0) {
        super($$0);
    }

    protected void init() {
        super.init();
        this.leftPos = ((this.width - this.imageWidth) / 2);
        this.topPos = (this.height - this.imageHeight) / 2 - 15;
        this.toolTipMaxWidth = (this.imageWidth / 2) - 16;
        TextComponent textComponent = new TextComponent("Hi and welcome to the Oh The Biomes You'll Go biomepedia! Here you'll find information in regards to our biomes, blocks, items, tools, and more! On the right hand page, select the item you're looking for.");
        this.rightPos = this.leftPos + this.imageWidth;
        this.bottomPos = this.topPos + this.imageHeight;
        this.textStartHeight = this.topPos + this.imageHeight / 2;

        this.leftPageCenter = (this.leftPos + (this.leftPos + (this.imageWidth) / 2)) - 8;
        this.rightPageCenter = this.leftPageCenter + imageWidth;
        int y1 = this.bottomPos - 4;
        this.scrollableText = new ScrollableText(textComponent, this.toolTipMaxWidth, this.leftPageCenter, this.textStartHeight, this.textStartHeight + 16, y1);
        this.addWidget(scrollableText);

        int buttonWidth = this.imageWidth / 3;
        int buttonHeight = 20;
        Button blocks = new Button(this.rightPageCenter, this.bottomPos, buttonWidth, buttonHeight, new TextComponent("Blocks"), button -> {

        });
        Button items = new Button(this.rightPageCenter, this.bottomPos, buttonWidth, buttonHeight, new TextComponent("Items"), button -> {

        });

        Button biomes = new Button(this.rightPageCenter, this.bottomPos, buttonWidth, buttonHeight, new TextComponent("Biomes"), button -> {

        });

        Button ores = new Button(this.rightPageCenter, this.bottomPos, buttonWidth, buttonHeight, new TextComponent("Ores"), button -> {
        });

        List<AbstractWidget> buttons = new ArrayList<>(ImmutableList.of(biomes, blocks, items, ores));

        for (int i = 0; i < 25; i++) {
            buttons.add(new Button(this.rightPageCenter, this.bottomPos, buttonWidth, buttonHeight, new TextComponent(Integer.toString(i)), button -> {
            }));
        }

        int listRenderedHeight = this.imageHeight + this.topPos;
        this.widgets = new WidgetList(buttons, buttonWidth + 20, listRenderedHeight, this.topPos, listRenderedHeight, buttonHeight + 4);
        this.widgets.setLeftPos(this.rightPageCenter / 2);
        this.addWidget(this.widgets);
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(poseStack);
        GuiComponent.fill(poseStack, this.leftPos, this.topPos, rightPos, bottomPos, FastColor.ARGB32.color(255, 220, 220, 220));
        GuiComponent.fill(poseStack, (this.leftPos + (this.imageWidth) / 2) - 2, this.topPos, (this.leftPos + (this.imageWidth) / 2) + 2, bottomPos, FastColor.ARGB32.color(255, 255, 0, 0));
        this.scrollableText.render(poseStack, mouseX, mouseY, partialTick);
        this.widgets.render(poseStack, mouseX, mouseY, partialTick);
        super.render(poseStack, mouseX, mouseY, partialTick);
    }
}
