package potionstudios.byg.client.gui.biomepedia.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.BYG;
import potionstudios.byg.client.gui.biomepedia.widget.BiomeWidget;
import potionstudios.byg.client.gui.biomepedia.widget.ScrollableText;
import potionstudios.byg.common.world.LevelBiomeTracker;

import javax.annotation.Nullable;

public class BiomeAboutScreen extends AbstractBiomepediaScreen {
    protected int toolTipMaxWidth;
    protected int textStartHeight;
    protected final Component description;
    @Nullable
    protected final ResourceLocation previewImageLocation;
    private final Screen parent;
    private final Component dimensionsText;


    protected BiomeAboutScreen(ResourceKey<Biome> biome, Screen parent) {
        super(new TranslatableComponent("biome." + biome.location().getNamespace() + "." + biome.location().getPath()));
        this.parent = parent;
        String translationKey = String.format("biomepedia.biome.%s.%s.desc", biome.location().getNamespace(), biome.location().getPath());
        boolean useTranslation = !I18n.get(translationKey).equals(translationKey);

        this.description = new TranslatableComponent(useTranslation ? translationKey : "biomepedia.desc.block.byg.none");

        ResourceLocation resourceLocation = new ResourceLocation(biome.location().getNamespace(), "/textures/biome_previews/" + biome.location().getPath() + ".png");
        this.previewImageLocation = Minecraft.getInstance().getResourceManager().hasResource(resourceLocation) ? resourceLocation : null;
        if (previewImageLocation == null) {
            BYG.LOGGER.warn("No image preview available for: " + resourceLocation.toString());
        }

        MutableComponent component = new TextComponent("Dimensions:").withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD);
        for (ResourceKey<Level> levelResourceKey : LevelBiomeTracker.client_instance.biomeDimensions().get(biome)) {
            component.append("\n").append(new TextComponent(levelResourceKey.location().toString()));
        }
        this.dimensionsText = component;
    }

    @Override
    protected void init() {
        super.init();
        this.toolTipMaxWidth = (IMAGE_WIDTH / 2) - 19;
        this.textStartHeight = (this.bottomPos + IMAGE_HEIGHT / 2) - 5;

        int y1 = this.topPos - 12;
        ScrollableText description = new ScrollableText(this.description, this.toolTipMaxWidth, this.textStartHeight, this.textStartHeight + 16, y1);
        description.setLeftPos(this.leftPos + 15);
        this.addRenderableWidget(description);
        int startXRightPage = (this.leftPos + (IMAGE_WIDTH / 4) + ((IMAGE_WIDTH) / 3)) - 18;

        int dimensionTestStartHeight = this.bottomPos + 15;
        ScrollableText dimensions = new ScrollableText(this.dimensionsText, this.toolTipMaxWidth, dimensionTestStartHeight, dimensionTestStartHeight, dimensionTestStartHeight + 35);
        dimensions.setLeftPos(startXRightPage);
        this.addRenderableWidget(description);
        this.addRenderableWidget(dimensions);
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        super.render(poseStack, mouseX, mouseY, partialTick);
        BiomeWidget.renderBiomePicture(poseStack, 0.09F, this.leftPos + 18, this.bottomPos + 25, this.previewImageLocation);

        int leftPageCenter = this.leftPos + ((IMAGE_WIDTH / 4)) + 4;
        int startX = leftPageCenter - (Minecraft.getInstance().font.width(this.getTitle()) / 2);
        Minecraft.getInstance().font.draw(poseStack, this.getTitle(), startX, this.bottomPos + 13, 0);
    }

    @Override
    public void onClose() {
        this.minecraft.setScreen(this.parent);
    }
}
