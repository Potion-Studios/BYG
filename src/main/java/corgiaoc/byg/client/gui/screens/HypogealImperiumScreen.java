package corgiaoc.byg.client.gui.screens;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import corgiaoc.byg.BYG;
import corgiaoc.byg.client.gui.HypogealImperiumContainer;
import corgiaoc.byg.common.entity.tileentities.HypogealImperiumTE;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;

public class HypogealImperiumScreen extends ContainerScreen<HypogealImperiumContainer> {

    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(BYG.MOD_ID, "textures/gui/container/hypogeal_imperium.png");
    private static final int[] BUBBLELENGTHS = new int[]{29, 24, 20, 16, 11, 6, 0};


    public HypogealImperiumScreen(HypogealImperiumContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    protected void init() {
        super.init();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    @Override
    public void render(MatrixStack matrixStack, final int mouseX, final int mouseY, final float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void renderBg(MatrixStack p_230450_1_, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(BACKGROUND_TEXTURE);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(p_230450_1_, i, j, 0, 0, this.imageWidth, this.imageHeight);
        int k = 20;
        int l = MathHelper.clamp((18 * k + 20 - 1) / 20, 0, 18);
        if (l > 0) {
            this.blit(p_230450_1_, i + 60, j + 44, 176, 29, l, 4);
        }

        int i1 = HypogealImperiumTE.getLoadTime();
        if (i1 > 0) {
            int j1 = (int)(28.0F * (1.0F - (float)i1 / 400.0F));

            j1 = BUBBLELENGTHS[i1 / 2 % 7];
            if (j1 > 0) {
                this.blit(p_230450_1_, i + 63, j + 14 + 29 - j1, 185, 29 - j1, 12, j1);
            }
        }
    }
}