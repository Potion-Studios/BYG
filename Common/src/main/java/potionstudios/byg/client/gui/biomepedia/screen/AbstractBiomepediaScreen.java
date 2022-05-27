package potionstudios.byg.client.gui.biomepedia.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class AbstractBiomepediaScreen extends Screen {

    protected static final int IMAGE_WIDTH = 288;
    protected static final int IMAGE_HEIGHT = 208;
    protected int leftPos;
    protected int bottomPos;
    protected int rightPos;
    protected int topPos;

    protected AbstractBiomepediaScreen(Component $$0) {
        super($$0);
    }

    @Override
    protected void init() {
        super.init();
        this.leftPos = ((this.width - IMAGE_WIDTH) / 2);
        this.bottomPos = (this.height - IMAGE_HEIGHT) / 2 - 15;
        this.rightPos = this.leftPos + IMAGE_WIDTH;
        this.topPos = this.bottomPos + IMAGE_HEIGHT;
    }


    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        renderBackgroundAndBiomepedia(poseStack);

        super.render(poseStack, mouseX, mouseY, partialTick);
    }

    private void renderBackgroundAndBiomepedia(PoseStack poseStack) {
        this.renderBackground(poseStack);
        renderBiomepedia(poseStack, this.leftPos, this.bottomPos);
    }

    private static void renderBiomepedia(PoseStack poseStack, int minX, int minY) {
        RenderSystem.setShaderTexture(0, BiomepediaHomeScreen.BIOMEPEDIA_LOCATION);
        blit(poseStack, minX, minY, 0, 0, IMAGE_WIDTH, IMAGE_HEIGHT, IMAGE_WIDTH, IMAGE_HEIGHT);
    }
}
