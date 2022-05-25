package potionstudios.byg.client.gui.biomepedia1;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.util.BYGUtil;

import javax.annotation.Nullable;

public class BiomeWidget extends AbstractWidget {
    private final ItemWidget.OnClick onClick;
    @Nullable
    private final ResourceLocation previewImageLocation;
    private final Component name;
    private final int borderColor;
    private static final int IMAGE_WIDTH = 1280;
    private static final int IMAGE_HEIGHT = 720;

    public BiomeWidget(ResourceKey<Biome> biome, int pX, int pY, int pWidth, int pHeight, ItemWidget.OnClick onClick) {
        super(pX, pY, pWidth, pHeight, new TextComponent(""));
        this.onClick = onClick;
        ResourceLocation resourceLocation = new ResourceLocation(biome.location().getNamespace(), "/textures/biome_previews/" + biome.location().getPath() + ".png");
        this.previewImageLocation = Minecraft.getInstance().getResourceManager().hasResource(resourceLocation) ? resourceLocation : null;
        this.name = new TranslatableComponent("biome." + biome.location().getNamespace() + "." + biome.location().getPath());
        this.borderColor = FastColor.ARGB32.color(255, 0, 0, 0);
        this.visible = false;
        this.active = false;
    }


    @Override
    public void updateNarration(NarrationElementOutput narrationElementOutput) {
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        if (this.visible) {
            if (previewImageLocation != null) {
                poseStack.pushPose();
                RenderSystem.setShaderTexture(0, previewImageLocation);
                float scale = 0.09F;
                poseStack.scale(scale, scale, 1);
                int scaledY = (int) (this.y / scale);
                int scaledX = (int) (this.x / scale);
                blit(poseStack, scaledX, scaledY, 0, 0, IMAGE_WIDTH, IMAGE_HEIGHT, IMAGE_WIDTH, IMAGE_HEIGHT);
                poseStack.popPose();
            }

            int textWidth = Minecraft.getInstance().font.width(this.name) / 2;
            int textX = (this.x + (this.width / 2)) - textWidth;
            int textY = this.y + height - 10;
            Minecraft.getInstance().font.draw(poseStack, this.name, textX, textY, FastColor.ARGB32.color(255, 0, 0, 0));

            if (BYGUtil.isInside(this.x, this.y, this.x + this.width, this.y + this.height, mouseX, mouseY)) {
                drawWidgetBorder(poseStack);
            }
        }
    }

    private void drawWidgetBorder(PoseStack poseStack) {
        vLine(poseStack, this.x, this.y, this.y + this.height, this.borderColor);
        vLine(poseStack, this.x + this.width, this.y, this.y + this.height, this.borderColor);
        hLine(poseStack, this.x, this.x + this.width, this.y, this.borderColor);
        hLine(poseStack, this.x, this.x + this.width, this.y + this.height, this.borderColor);
    }
}
