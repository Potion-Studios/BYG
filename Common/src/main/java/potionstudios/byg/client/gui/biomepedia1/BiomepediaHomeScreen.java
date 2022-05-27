package potionstudios.byg.client.gui.biomepedia1;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.ConfirmLinkScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.BYG;
import potionstudios.byg.mixin.access.client.ScreenAccess;
import potionstudios.byg.util.ModPlatform;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.function.Predicate;

public class BiomepediaHomeScreen extends AbstractBiomepediaScreen {
    public static final String PATREON_URL = "https://www.patreon.com/biomesyougo";
    public static final String GITHUB_ISSUES_URL = "https://github.com/AOCAWOL/BYG/issues";
    public static final String TRANSLATIONS_URL = "https://crowdin.com/project/oh-the-biomes-youll-go";
    public static final ResourceLocation BIOMEPEDIA_LOCATION = BYG.createLocation("textures/gui/biomepedia_book_gui.png");
    public static final String DOWNLOAD_URL = ModPlatform.INSTANCE.curseForgeURL();
    public static final ResourceLocation BOOK_TEXTURES = new ResourceLocation("byg", "textures/gui/biomepedia.png");

    int toolTipMaxWidth;
    int textStartHeight;
    private ScrollableText scrollableText;
    private WidgetList widgets;

    public BiomepediaHomeScreen(Component $$0) {
        super($$0);
    }

    protected void init() {
        super.init();
        this.toolTipMaxWidth = (IMAGE_WIDTH / 2) - 25;
        TranslatableComponent textComponent = new TranslatableComponent("biomepedia.intro");
        this.textStartHeight = (this.bottomPos + IMAGE_HEIGHT / 2) - 5;

        int y1 = this.topPos - 12;
        this.scrollableText = new ScrollableText(textComponent, this.toolTipMaxWidth, this.textStartHeight, this.textStartHeight + 16, y1);
        this.scrollableText.setLeftPos(this.leftPos + 13);
        this.addWidget(scrollableText);

        int buttonWidth = (IMAGE_WIDTH - 10) / 3;
        int buttonHeight = 20;
        Button blocksAndItems = new Button(0, this.topPos, buttonWidth, buttonHeight, new TranslatableComponent("biomepedia.intro.options.blocksanditems"),
                button -> this.minecraft.setScreen(new ItemsViewScreen(this)), makeButtonToolTip(new TranslatableComponent("biomepedia.intro.options.blocksanditems.hover"), this));

        Button biomes = new Button(0, this.topPos, buttonWidth, buttonHeight, new TranslatableComponent("biomepedia.intro.options.biomes"), button -> {
            this.minecraft.setScreen(new BiomeListScreen(this));
        }, getToolTip(new TranslatableComponent("biomepedia.intro.options.biomes.hover"), this));

        Button ores = new Button(0, this.topPos, buttonWidth, buttonHeight, new TranslatableComponent("biomepedia.intro.options.ores"), button -> {
        }, getToolTip(new TranslatableComponent("biomepedia.intro.options.ores.hover"), this));

        Button translations = new Button(0, this.topPos, buttonWidth, buttonHeight, new TranslatableComponent("biomepedia.intro.options.translate"), consumeLink(TRANSLATIONS_URL), getToolTip(new TranslatableComponent("biomepedia.intro.options.translate.hover"), this));

        ores.active = false;

        Button issues = new Button(0, this.topPos, buttonWidth, buttonHeight, new TranslatableComponent("biomepedia.intro.options.issues"), consumeLink(GITHUB_ISSUES_URL), makeButtonToolTip(new TranslatableComponent("biomepedia.intro.options.issues.hover"), this));

        Button donate = new Button(0, this.topPos, buttonWidth, buttonHeight, new TranslatableComponent("biomepedia.intro.options.donate"), consumeLink(PATREON_URL), makeButtonToolTip(new TranslatableComponent("biomepedia.intro.options.donate.hover"), this));
        Button download = new Button(0, this.topPos, buttonWidth, buttonHeight, new TranslatableComponent("biomepedia.intro.options.download"), consumeLink(DOWNLOAD_URL), makeButtonToolTip(new TranslatableComponent("biomepedia.intro.options.download.hover"), this));

        List<AbstractWidget> buttons = ImmutableList.of(blocksAndItems, biomes, ores, download, translations, issues, donate);

        int listRenderedHeight = IMAGE_HEIGHT + this.bottomPos;
        this.widgets = new WidgetList(buttons, buttonWidth + 9, listRenderedHeight + 20, this.bottomPos + 20, listRenderedHeight - 20, buttonHeight + 4);
        this.widgets.setLeftPos(this.leftPos + (IMAGE_WIDTH / 4) + buttonWidth);
        this.addWidget(this.widgets);
    }

    @NotNull
    private static Button.OnTooltip getToolTip(Component component, Screen screen) {
        return (button, poseStack, mouseX, mouseZ) -> {
            if (!button.active) {
                screen.renderTooltip(poseStack, new TranslatableComponent("biomepedia.intro.options.disabled.hover"), mouseX, mouseZ);
            } else {
                screen.renderTooltip(poseStack, component, mouseX, mouseZ);
            }
        };
    }

    @NotNull
    public static Button.OnTooltip makeButtonToolTip(Component component, Screen screen) {
        return makeButtonToolTip(component, screen, button -> button.active);
    }

    @NotNull
    public static Button.OnTooltip makeButtonToolTip(Component component, Screen screen, Predicate<Button> buttonPredicate) {
        return (button, poseStack, mouseX, mouseZ) -> {
            if (buttonPredicate.test(button)) {
                screen.renderTooltip(poseStack, component, mouseX, mouseZ);
            }
        };
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
        super.render(poseStack, mouseX, mouseY, partialTick);
        renderBYGLogo(poseStack);
        this.scrollableText.render(poseStack, mouseX, mouseY, partialTick);
        this.widgets.render(poseStack, mouseX, mouseY, partialTick);
    }

    private void renderBYGLogo(PoseStack poseStack) {
        poseStack.pushPose();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.setShaderTexture(0, BOOK_TEXTURES);
        float scale = 3.35F;
        poseStack.scale(scale, scale, 0);

        // We need to scale the position by the scale of the matrix to match the coordinates.
        float toolTipMaxWidthScaled = (this.toolTipMaxWidth) / scale;
        blit(poseStack, Math.round((this.leftPos + (toolTipMaxWidthScaled / 2)) / scale) + 1, Math.round((this.bottomPos / scale) + (4 / scale)), 20, 224, 32, 32);
        poseStack.popPose();
    }
}