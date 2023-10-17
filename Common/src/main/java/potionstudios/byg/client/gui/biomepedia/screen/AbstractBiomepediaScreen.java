package potionstudios.byg.client.gui.biomepedia.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

public class AbstractBiomepediaScreen extends Screen {

    protected static final int IMAGE_WIDTH = 288;
    protected static final int IMAGE_HEIGHT = 208;
    protected int leftPos;
    protected int bottomPos;
    protected int rightPos;
    protected int topPos;
    protected int startXRightPage;
    protected int startXLeftPage;
    protected int pageBackButtonX = this.leftPos + 5;
    protected int pageButtonY = this.topPos - 10;
    protected int pageButtonForwardX = this.rightPos - 5;

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
        this.startXRightPage = (this.leftPos + (IMAGE_WIDTH / 4) + ((IMAGE_WIDTH) / 3)) - 18;
        this.startXLeftPage = this.leftPos + 15;
        this.pageBackButtonX = this.leftPos + 15;
        this.pageButtonY = this.topPos - 13 - 13;
        this.pageButtonForwardX = this.rightPos - 23 - 22;
    }


    @Override
    public void render(@NotNull GuiGraphics poseStack, int mouseX, int mouseY, float partialTick) {
        renderBackgroundAndBiomepedia(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTick);
    }

    private void renderBackgroundAndBiomepedia(GuiGraphics guiGraphics) {
        this.renderBackground(guiGraphics);
        renderBiomepedia(guiGraphics, this.leftPos, this.bottomPos);
    }

    private static void renderBiomepedia(GuiGraphics guiGraphics, int minX, int minY) {
         guiGraphics.blit(BiomepediaHomeScreen.BIOMEPEDIA_LOCATION, minX, minY, 0, 0, IMAGE_WIDTH, IMAGE_HEIGHT, IMAGE_WIDTH, IMAGE_HEIGHT);
    }
}
