package potionstudios.byg.client.gui.biomepedia.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import org.apache.commons.lang3.mutable.MutableInt;
import potionstudios.byg.BYG;
import potionstudios.byg.client.gui.biomepedia.widget.BiomeWidget;
import potionstudios.byg.client.gui.biomepedia.widget.ScrollableText;
import potionstudios.byg.common.world.LevelBiomeTracker;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

public class BiomeAboutScreen extends AbstractBiomepediaScreen {
    protected int toolTipMaxWidth;
    protected int textStartHeight;
    protected final Component description;
    @Nullable
    protected final ResourceLocation previewImageLocation;
    private final Screen parent;
    private final Component dimensionsText;
    private final Component climateText;
    private final Component biomeTags;


    protected BiomeAboutScreen(ResourceKey<Biome> biomeKey, Screen parent) {
        super(new TranslatableComponent("biome." + biomeKey.location().getNamespace() + "." + biomeKey.location().getPath()));
        this.parent = parent;
        String translationKey = String.format("biomepedia.biome.%s.%s.desc", biomeKey.location().getNamespace(), biomeKey.location().getPath());
        boolean useTranslation = !I18n.get(translationKey).equals(translationKey);

        this.description = new TranslatableComponent(useTranslation ? translationKey : "biomepedia.desc.block.byg.none");

        ResourceLocation resourceLocation = new ResourceLocation(biomeKey.location().getNamespace(), "/textures/biome_previews/" + biomeKey.location().getPath() + ".png");
        this.previewImageLocation = Minecraft.getInstance().getResourceManager().hasResource(resourceLocation) ? resourceLocation : null;
        if (previewImageLocation == null) {
            BYG.LOGGER.warn("No image preview available for: " + resourceLocation.toString());
        }

        MutableComponent dimensionsText = new TranslatableComponent("biomepedia.biomeabout.dimensions").withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD);
        Map<ResourceKey<Biome>, Collection<ResourceKey<Level>>> biomeDimensions = LevelBiomeTracker.client_instance.biomeDimensions();

        if (biomeDimensions.containsKey(biomeKey)) {
            for (ResourceKey<Level> levelResourceKey : biomeDimensions.get(biomeKey)) {
                dimensionsText.append("\n").append(new TextComponent(levelResourceKey.location().toString()));
            }
        } else {
            dimensionsText.append("\n").append(new TranslatableComponent("biomepedia.biomeabout.nodimensions"));
        }
        this.dimensionsText = dimensionsText;

        MutableComponent climateText = new TranslatableComponent("biomepedia.biomeabout.climate").withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD);
        Registry<Biome> biomeRegistry = Minecraft.getInstance().level.registryAccess().registryOrThrow(Registry.BIOME_REGISTRY);
        Biome biome = biomeRegistry.get(biomeKey);

        climateText.append("\n").append(new TranslatableComponent("biomepedia.biomeabout.climate.basetemperature", biome.getBaseTemperature()));
        climateText.append("\n").append(new TranslatableComponent("biomepedia.biomeabout.climate.downfall", biome.getDownfall()));
        climateText.append("\n").append(new TranslatableComponent("biomepedia.biomeabout.climate.precipitation", new TranslatableComponent("biomepedia.biomeabout.climate.precipitation." + biome.getPrecipitation().getSerializedName())));
        this.climateText = climateText;

        MutableComponent biomeTagsText = new TranslatableComponent("biomepedia.biomeabout.biometags").withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD);
        MutableInt count = new MutableInt(0);
        biomeRegistry.getHolder(biomeKey).orElseThrow().tags()
                .sorted(Comparator.comparing(biomeTagKey -> biomeTagKey.location().toString()))
                .forEach(biomeTagKey -> biomeTagsText.append(String.format("\n%s. ", count.incrementAndGet())).append(new TextComponent(biomeTagKey.location().toString())));

        this.biomeTags = biomeTagsText;
    }

    @Override
    protected void init() {
        super.init();
        this.toolTipMaxWidth = (IMAGE_WIDTH / 2) - 22;
        this.textStartHeight = (this.bottomPos + IMAGE_HEIGHT / 2) - 5;

        int y1 = this.topPos - 12;
        ScrollableText description = new ScrollableText(this.description, this.toolTipMaxWidth, this.textStartHeight, this.textStartHeight + 16, y1);
        description.setLeftPos(this.leftPos + 15);
        this.addRenderableWidget(description);
        this.addRenderableWidget(description);
        int dimensionTextTop = this.bottomPos + 15;
        int size = 50;
        int dimensionTextBottom = dimensionTextTop + size;
        ScrollableText dimensions = new ScrollableText(this.dimensionsText, this.toolTipMaxWidth, dimensionTextTop, dimensionTextTop, dimensionTextBottom);
        dimensions.setLeftPos(startXRightPage);

        int distanceBetween = 10;
        int climateTextTop = dimensionTextBottom + distanceBetween;
        int climateTextBottom = climateTextTop + size;
        ScrollableText climateInfo = new ScrollableText(this.climateText, dimensions.getRowWidth(), climateTextTop, climateTextTop, climateTextBottom);
        climateInfo.setLeftPos(startXRightPage);

        int biomeTagsTop = climateTextBottom + distanceBetween;
        int biomeTagsBottom = biomeTagsTop + size;
        ScrollableText biomeTags = new ScrollableText(this.biomeTags, dimensions.getRowWidth(), biomeTagsTop, biomeTagsTop, biomeTagsBottom);
        biomeTags.setLeftPos(startXRightPage);

        this.addRenderableWidget(description);
        this.addRenderableWidget(dimensions);
        this.addRenderableWidget(climateInfo);
        this.addRenderableWidget(biomeTags);
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
