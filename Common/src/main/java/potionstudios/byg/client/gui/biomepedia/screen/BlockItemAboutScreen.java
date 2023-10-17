package potionstudios.byg.client.gui.biomepedia.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import potionstudios.byg.client.gui.biomepedia.widget.ScrollableText;

import java.util.List;

public class BlockItemAboutScreen extends AbstractBiomepediaScreen {
    private final Screen parent;
    private final Item item;
    int toolTipMaxWidth;
    int textStartHeight;
    int stateSwitchTimer;
    int lastIndex;
    private float rotationDegrees;
    private BlockState currentlyRendered;
    private final List<BlockState> possibleStates;
    private final Component description;

    protected BlockItemAboutScreen(Screen parent, BlockItem item) {
        super(new ItemStack(item).getHoverName());
        this.parent = parent;
        this.item = item;
        this.possibleStates = item.getBlock().getStateDefinition().getPossibleStates();
        this.currentlyRendered = possibleStates.get(0);

        String translationKey = "biomepedia.desc." + item.getDescriptionId(new ItemStack(item));
        boolean useTranslation = !I18n.get(translationKey).equals(translationKey);

        this.description = Component.translatable(useTranslation ? translationKey : "biomepedia.desc.block.byg.none");
    }

    @Override
    public void onClose() {
        super.onClose();
        this.minecraft.setScreen(this.parent);
    }

    @Override
    public void tick() {
        super.tick();
        if (rotationDegrees > 360) {
            rotationDegrees = 0;
        }
        rotationDegrees += 2.5;

        if (stateSwitchTimer < 15) {
            this.stateSwitchTimer++;
        } else {
            stateSwitchTimer = 0;
            this.lastIndex = this.lastIndex + 1 > possibleStates.size() - 1 ? 0 : this.lastIndex + 1;
            this.currentlyRendered = this.possibleStates.get(this.lastIndex);
        }
    }

    @Override
    protected void init() {
        super.init();
        this.toolTipMaxWidth = (IMAGE_WIDTH / 2) - 25;
        this.textStartHeight = (this.bottomPos + IMAGE_HEIGHT / 2) - 5;
        int y1 = this.topPos - 12;
        ScrollableText scrollableText = new ScrollableText(this.description, this.toolTipMaxWidth, this.textStartHeight, this.textStartHeight + 16, y1);
        scrollableText.setLeftPos(this.leftPos + 13);
        this.addRenderableWidget(scrollableText);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);

        PoseStack poseStack = guiGraphics.pose();
        poseStack.pushPose();
        int scale = 75;
        poseStack.scale(scale, scale, 30);
        float scaledX = (float) this.leftPos / scale + ((float) ((IMAGE_WIDTH / 4) + 4) / scale);
        float scaledZ = (float) (this.textStartHeight) / scale;

        MultiBufferSource.BufferSource bufferSource = MultiBufferSource.immediate(Tesselator.getInstance().getBuilder());

        poseStack.translate(scaledX, scaledZ, 30);
        poseStack.mulPose(Axis.XN.rotationDegrees(180));
        poseStack.mulPose(Axis.YN.rotationDegrees(45));
        Minecraft.getInstance().getBlockRenderer().renderSingleBlock(this.currentlyRendered, poseStack, bufferSource, 15728880, OverlayTexture.NO_OVERLAY);
        bufferSource.endBatch();
        poseStack.popPose();
        int startX = this.leftPos + ((IMAGE_WIDTH / 4)) - (Minecraft.getInstance().font.width(this.getTitle()) / 2) + 4;

        guiGraphics.drawString(Minecraft.getInstance().font, this.getTitle(), startX, this.bottomPos + 13, 0, false);
    }
}
