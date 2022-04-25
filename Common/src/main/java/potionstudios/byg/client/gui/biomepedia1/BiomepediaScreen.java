package potionstudios.byg.client.gui.biomepedia1;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.ConfirmLinkScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.util.FastColor;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.client.gui.biomepedia.widgets.BookBackgroundWidget;
import potionstudios.byg.mixin.access.client.ScreenAccess;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class BiomepediaScreen extends Screen {
    public static final String PATREON_URL = "https://www.patreon.com/biomesyougo";
    public static final String GITHUB_ISSUES_URL = "https://github.com/AOCAWOL/BYG/issues";

    int imageWidth = 288;
    int imageHeight = 208;
    int leftPos;
    int bottomPos;
    int toolTipMaxWidth;
    int rightPos;
    int topPos;
    int textStartHeight;
    private ScrollableText scrollableText;
    private WidgetList widgets;

    public BiomepediaScreen(Component $$0) {
        super($$0);
    }

    protected void init() {
        super.init();
        this.leftPos = ((this.width - this.imageWidth) / 2);
        this.bottomPos = (this.height - this.imageHeight) / 2 - 15;
        this.toolTipMaxWidth = (this.imageWidth / 2) - 16;
        TextComponent textComponent = new TextComponent("Hi and welcome to the Oh The Biomes You'll Go biomepedia! Here you'll find information in regards to our biomes, blocks, items, tools, and more! On the right hand page, select the item you're looking for.");
        this.rightPos = this.leftPos + this.imageWidth;
        this.topPos = this.bottomPos + this.imageHeight;
        this.textStartHeight = this.bottomPos + this.imageHeight / 2;

        int y1 = this.topPos - 4;
        this.scrollableText = new ScrollableText(textComponent, this.toolTipMaxWidth + 9, this.textStartHeight, this.textStartHeight + 16, y1);
        this.scrollableText.setLeftPos(this.leftPos);
        this.addWidget(scrollableText);

        int buttonWidth = this.imageWidth / 3;
        int buttonHeight = 20;
        Button blocksAndItems = new Button(0, this.topPos, buttonWidth, buttonHeight, new TextComponent("Blocks & items"), button -> {
            this.minecraft.setScreen(new ItemViewsScreen(new TextComponent("")));
        });

        Button biomes = new Button(0, this.topPos, buttonWidth, buttonHeight, new TextComponent("Biomes"), button -> {

        });

        Button ores = new Button(0, this.topPos, buttonWidth, buttonHeight, new TextComponent("Ores"), button -> {
        });

        Button issueReports = new Button(0, this.topPos, buttonWidth, buttonHeight, new TextComponent("Issue Reports"), consumeLink(GITHUB_ISSUES_URL));

        Button donate = new Button(0, this.topPos, buttonWidth, buttonHeight, new TextComponent("Donate"), consumeLink(PATREON_URL));

        List<AbstractWidget> buttons = ImmutableList.of(biomes, blocksAndItems, ores, issueReports, donate);

        int listRenderedHeight = this.imageHeight + this.bottomPos;
        this.widgets = new WidgetList(buttons, buttonWidth + 9, listRenderedHeight + 20, this.bottomPos + 20, listRenderedHeight - 20, buttonHeight + 4);
        this.widgets.setLeftPos(this.leftPos + (this.imageWidth / 4) + buttonWidth);
        this.addWidget(this.widgets);
    }

    @NotNull
    private Button.OnPress consumeLink(String url) {
        return button -> {
            this.minecraft.setScreen(new ConfirmLinkScreen(confirmed -> {
                if (confirmed) {
                    try {
                        ((ScreenAccess) this).byg_invokeOpenLink(new URI(url));
                        this.minecraft.setScreen(this);
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                } else {
                    this.minecraft.setScreen(this);
                }
            }, url, false));
        };
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(poseStack);
        GuiComponent.fill(poseStack, this.leftPos, this.bottomPos, rightPos, topPos, FastColor.ARGB32.color(255, 220, 220, 220));
        GuiComponent.fill(poseStack, (this.leftPos + (this.imageWidth) / 2) - 2, this.bottomPos, (this.leftPos + (this.imageWidth) / 2) + 2, topPos, FastColor.ARGB32.color(255, 255, 0, 0));
        this.scrollableText.render(poseStack, mouseX, mouseY, partialTick);
        this.widgets.render(poseStack, mouseX, mouseY, partialTick);
        super.render(poseStack, mouseX, mouseY, partialTick);
        renderBYGLogo(poseStack);
    }

    private void renderBYGLogo(PoseStack poseStack) {
        poseStack.pushPose();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.setShaderTexture(0, BookBackgroundWidget.BACKGROUND);
        float scale = 3.5F;
        poseStack.scale(scale, scale, 0);

        // We need to scale the position by the scale of the matrix to match the coordinates.
        float toolTipMaxWidthScaled = (this.toolTipMaxWidth) / scale;
        blit(poseStack, Math.round((this.leftPos + (toolTipMaxWidthScaled / 2)) / scale) - 2, (int) (this.bottomPos / scale), 20, 224, 32, 32);
        poseStack.popPose();
    }
}