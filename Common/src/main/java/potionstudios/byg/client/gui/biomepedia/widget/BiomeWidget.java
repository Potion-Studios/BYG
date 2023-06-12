package potionstudios.byg.client.gui.biomepedia.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.BYG;
import potionstudios.byg.util.BYGUtil;

import javax.annotation.Nullable;

public class BiomeWidget extends AbstractWidget {
    private final OnClick onClick;
    @Nullable
    private final ResourceLocation previewImageLocation;
    private final Component name;
    private final int borderColor;
    public static final int IMAGE_WIDTH = 1280;
    public static final int IMAGE_HEIGHT = 720;

    public BiomeWidget(ResourceKey<Biome> biome, int pX, int pY, int pWidth, int pHeight, OnClick onClick) {
        super(pX, pY, pWidth, pHeight, Component.literal(""));
        this.onClick = onClick;
        ResourceLocation resourceLocation = new ResourceLocation(biome.location().getNamespace(), "/textures/biome_previews/" + biome.location().getPath() + ".png");
        this.previewImageLocation = Minecraft.getInstance().getResourceManager().getResource(resourceLocation).isPresent() ? resourceLocation : null;
        if (previewImageLocation == null) {
            BYG.logWarning("No image preview available for: " + resourceLocation.toString());
        }
        this.name = Component.translatable("biome." + biome.location().getNamespace() + "." + biome.location().getPath());
        this.borderColor = FastColor.ARGB32.color(255, 0, 0, 0);
        this.visible = false;
        this.active = false;
    }

    @Override
    public void onClick(double $$0, double $$1) {
        if (this.active) {
            this.onClick.click(this);
            super.onClick($$0, $$1);
        }
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {

    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        if (this.visible) {
            if (previewImageLocation != null) {
                float scale = 0.09F;
                renderBiomePicture(poseStack, scale, this.getX(), this.getY(), this.previewImageLocation);
            }

            int textWidth = Minecraft.getInstance().font.width(this.name) / 2;
            int textX = (this.getX() + (this.width / 2)) - textWidth;
            int textY = this.getY() + height - 10;
            Minecraft.getInstance().font.draw(poseStack, this.name, textX, textY, FastColor.ARGB32.color(255, 0, 0, 0));

            if (BYGUtil.isInside(this.getX(), this.getY(), this.getX() + this.width, this.getY() + this.height, mouseX, mouseY)) {
                drawWidgetBorder(poseStack);
            }
        }
    }

    public static void renderBiomePicture(PoseStack poseStack, float scale, int x, int y, ResourceLocation location) {
        poseStack.pushPose();
        poseStack.scale(scale, scale, 1);
        RenderSystem.setShaderTexture(0, location);
        int scaledX = (int) (x / scale);
        int scaledY = (int) (y / scale);
        blit(poseStack, scaledX, scaledY, 0, 0, IMAGE_WIDTH, IMAGE_HEIGHT, IMAGE_WIDTH, IMAGE_HEIGHT);
        poseStack.popPose();
    }

    private void drawWidgetBorder(PoseStack poseStack) {
        vLine(poseStack, this.getX(), this.getY(), this.getY() + this.height, this.borderColor);
        vLine(poseStack, this.getX() + this.width, this.getY(), this.getY() + this.height, this.borderColor);
        hLine(poseStack, this.getX(), this.getX() + this.width, this.getY(), this.borderColor);
        hLine(poseStack, this.getX(), this.getX() + this.width, this.getY() + this.height, this.borderColor);
    }

    public interface OnClick {

        void click(BiomeWidget button);
    }
}
