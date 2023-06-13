package potionstudios.byg.client.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import potionstudios.byg.BYG;
import potionstudios.byg.client.gui.HypogealImperiumContainer;

public class HypogealImperiumScreen extends AbstractContainerScreen<HypogealImperiumContainer> {

    private static final ResourceLocation BACKGROUND_TEXTURE = BYG.createLocation("textures/gui/container/hypogeal_imperium.png");
    public int k;


    public HypogealImperiumScreen(HypogealImperiumContainer screenContainer, Inventory inv, Component titleIn) {
        super(screenContainer, inv, titleIn);
    }



    protected void init() {
        super.init();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    @Override
    public void render(GuiGraphics guiGraphics, final int mouseX, final int mouseY, final float partialTicks) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        guiGraphics.blit(BACKGROUND_TEXTURE, i, j, 0, 0, this.imageWidth, this.imageHeight);
        if (this.menu.getFuelTime().get(0) > 0){
            k = 20;
        } else {
            k = 0;
        }
        int l = Mth.clamp((18 * k + 20 - 1) / 20, 0, 18);
        if (l > 0) {
            guiGraphics.blit(BACKGROUND_TEXTURE, i + 60, j + 44, 176, 29, l, 4);
        }
    }
}