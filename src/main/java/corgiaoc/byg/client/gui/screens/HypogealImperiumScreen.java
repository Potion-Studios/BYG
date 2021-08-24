package corgiaoc.byg.client.gui.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import corgiaoc.byg.BYG;
import corgiaoc.byg.client.gui.HypogealImperiumContainer;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;

public class HypogealImperiumScreen extends AbstractContainerScreen<HypogealImperiumContainer> {

    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(BYG.MOD_ID, "textures/gui/container/hypogeal_imperium.png");
    public int k;


    public HypogealImperiumScreen(HypogealImperiumContainer screenContainer, Inventory inv, Component titleIn) {
        super(screenContainer, inv, titleIn);
    }

    protected void init() {
        super.init();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    @Override
    public void render(PoseStack matrixStack, final int mouseX, final int mouseY, final float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void renderBg(PoseStack p_230450_1_, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(BACKGROUND_TEXTURE);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(p_230450_1_, i, j, 0, 0, this.imageWidth, this.imageHeight);
        if (this.menu.getFuelTime().get(0) > 0){
            k = 20;
        } else {
            k = 0;
        }
        int l = Mth.clamp((18 * k + 20 - 1) / 20, 0, 18);
        if (l > 0) {
            this.blit(p_230450_1_, i + 60, j + 44, 176, 29, l, 4);
        }
    }
}