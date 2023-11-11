package potionstudios.byg.client.gui.biomepedia.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.PageButton;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.BYG;
import potionstudios.byg.client.gui.biomepedia.widget.BiomeWidget;
import potionstudios.byg.client.gui.biomepedia.widget.ScrollableText;
import potionstudios.byg.common.world.LevelBiomeTracker;
import potionstudios.byg.mixin.access.BiomeAccess;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Map;

public class BiomeAboutScreen extends AbstractBiomepediaScreen {
    protected int toolTipMaxWidth;
    protected int textStartHeight;
    protected final Component description;
    @Nullable
    protected final ResourceLocation previewImageLocation;
    private ResourceKey<Biome> biomeKey;
    private final Screen parent;
    private final Component dimensionsText;
    private final Component climateText;

    protected BiomeAboutScreen(ResourceKey<Biome> biomeKey, Screen parent) {
        super(Component.translatable("biome." + biomeKey.location().getNamespace() + "." + biomeKey.location().getPath()).withStyle(ChatFormatting.BOLD));
        this.biomeKey = biomeKey;
        this.parent = parent;
        String translationKey = String.format("biomepedia.biome.%s.%s.desc", biomeKey.location().getNamespace(), biomeKey.location().getPath());
        boolean useTranslation = !I18n.get(translationKey).equals(translationKey);

        this.description = Component.translatable(useTranslation ? translationKey : "biomepedia.desc.block.byg.none");

        ResourceLocation resourceLocation = new ResourceLocation(biomeKey.location().getNamespace(), "/textures/biome_previews/" + biomeKey.location().getPath() + ".png");
        this.previewImageLocation = Minecraft.getInstance().getResourceManager().getResource(resourceLocation).isPresent() ? resourceLocation : null;
        if (previewImageLocation == null) {
            BYG.logWarning("No image preview available for: " + resourceLocation);
        }

        MutableComponent dimensionsText = Component.literal("").append(Component.translatable("biomepedia.biomeabout.dimensions").withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD));
        Map<ResourceKey<Biome>, Collection<ResourceKey<Level>>> biomeDimensions = LevelBiomeTracker.client_instance.biomeDimensions();

        if (biomeDimensions.containsKey(biomeKey)) {

            Collection<ResourceKey<Level>> dimensions = biomeDimensions.get(biomeKey);
            for (ResourceKey<Level> levelResourceKey : dimensions) {
                String dimensionTranslationKey = "dimension." + levelResourceKey.location().getNamespace() + "." + levelResourceKey.location().getPath();
                MutableComponent dimensionComponent = Component.translatable(dimensionTranslationKey).withStyle(ChatFormatting.RESET);
                dimensionsText.append("\n").append(!I18n.get(translationKey).equals(dimensionTranslationKey) ? dimensionComponent : Component.literal(levelResourceKey.location().toString()).withStyle(ChatFormatting.RESET));
            }
        } else {
            dimensionsText.append("\n").append(Component.translatable("biomepedia.biomeabout.dimensions.none"));
        }
        this.dimensionsText = dimensionsText;

        MutableComponent climateText = Component.literal("").append(Component.translatable("biomepedia.biomeabout.climate").withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD));
        Registry<Biome> biomeRegistry = Minecraft.getInstance().level.registryAccess().registryOrThrow(Registries.BIOME);
        Biome biome = biomeRegistry.get(biomeKey);

        climateText.append("\n").append(Component.translatable("biomepedia.biomeabout.climate.basetemperature", biome.getBaseTemperature()).withStyle(ChatFormatting.RESET));
        climateText.append("\n").append(Component.translatable("biomepedia.biomeabout.climate.downfall", ((BiomeAccess) (Object) biome).byg_getClimateSettings().downfall()).withStyle(ChatFormatting.RESET));
        climateText.append("\n").append(Component.translatable("biomepedia.biomeabout.climate.precipitation", Component.translatable("biomepedia.biomeabout.climate.precipitation." + biome.getPrecipitationAt(new BlockPos(0, 64, 0)))).withStyle(ChatFormatting.RESET));
        this.climateText = climateText;
    }

    @Override
    protected void init() {
        super.init();
        this.toolTipMaxWidth = (IMAGE_WIDTH / 2) - 22;
        this.textStartHeight = (this.bottomPos + IMAGE_HEIGHT / 2) - 5;

        this.addRenderableWidget(new PageButton(pageButtonForwardX, pageButtonY, true, button -> this.minecraft.setScreen(new BiomeAboutScreen2(this.biomeKey, this.parent)), true));


        int dimensionTextTop = this.bottomPos + 15;
        int size = 80;
        int dimensionTextBottom = dimensionTextTop + size;
        ScrollableText dimensions = new ScrollableText(this.dimensionsText, this.toolTipMaxWidth, dimensionTextTop, dimensionTextTop, dimensionTextBottom);
        dimensions.setLeftPos(startXRightPage);

        int distanceBetween = 10;
        int climateTextTop = dimensionTextBottom + distanceBetween;
        int climateTextBottom = climateTextTop + size;
        ScrollableText climateInfo = new ScrollableText(this.climateText, dimensions.getRowWidth(), climateTextTop, climateTextTop, climateTextBottom);
        climateInfo.setLeftPos(startXRightPage);

        ScrollableText description = new ScrollableText(this.description, this.toolTipMaxWidth, climateTextTop, climateTextTop, climateTextBottom);
        description.setLeftPos(this.startXLeftPage);

        this.addRenderableWidget(description);
        this.addRenderableWidget(dimensions);
        this.addRenderableWidget(climateInfo);
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        super.render(poseStack, mouseX, mouseY, partialTick);
        BiomeWidget.renderBiomePicture(poseStack, 0.09F, this.startXLeftPage + 3, this.bottomPos + 25, this.previewImageLocation);

        int leftPageCenter = this.leftPos + ((IMAGE_WIDTH / 4)) + 4;
        int startX = leftPageCenter - (Minecraft.getInstance().font.width(this.getTitle()) / 2);
        Minecraft.getInstance().font.draw(poseStack, this.getTitle(), startX, this.bottomPos + 13, 0);
    }

    @Override
    public void onClose() {
        this.minecraft.setScreen(this.parent);
    }
}
