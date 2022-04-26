package potionstudios.byg.client.gui.biomepedia1;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class BlockItemAboutScreen extends Screen {
    private final Item item;
    int imageWidth = 288;
    int imageHeight = 208;
    int leftPos;
    int bottomPos;
    int rightPos;
    int topPos;
    int toolTipMaxWidth;
    int textStartHeight;
    int stateSwitchTimer;
    int lastIndex;
    private float rotationDegrees;
    private BlockState currentlyRendered;
    private final List<BlockState> possibleStates;
    private final Component description;

    protected BlockItemAboutScreen(BlockItem item) {
        super(new ItemStack(item).getHoverName());
        this.item = item;
        this.possibleStates = item.getBlock().getStateDefinition().getPossibleStates();
        this.currentlyRendered = possibleStates.get(0);
        this.description = new TranslatableComponent("biomepedia.desc." + item.getDescriptionId(new ItemStack(item)));
    }

    @Override
    public void tick() {
        super.tick();
        if (rotationDegrees > 360) {
            rotationDegrees = 0;
        }
        rotationDegrees += 2.5;

        if (stateSwitchTimer < 25) {
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
        this.leftPos = ((this.width - this.imageWidth) / 2);
        this.bottomPos = (this.height - this.imageHeight) / 2 - 15;
        this.rightPos = this.leftPos + this.imageWidth;
        this.topPos = this.bottomPos + this.imageHeight;
        this.toolTipMaxWidth = (this.imageWidth / 2) - 16;
        this.textStartHeight = this.bottomPos + this.imageHeight / 2;
        int y1 = this.topPos - 4;
        ScrollableText scrollableText = new ScrollableText(this.description, this.toolTipMaxWidth + 15, this.textStartHeight, this.textStartHeight + 16, y1);
        scrollableText.setLeftPos(this.leftPos);
        this.addRenderableWidget(scrollableText);
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        GuiComponent.fill(poseStack, this.leftPos, this.bottomPos, rightPos, topPos, FastColor.ARGB32.color(255, 220, 220, 220));
        GuiComponent.fill(poseStack, (this.leftPos + (this.imageWidth) / 2) - 2, this.bottomPos, (this.leftPos + (this.imageWidth) / 2) + 2, topPos, FastColor.ARGB32.color(255, 255, 0, 0));
        super.render(poseStack, mouseX, mouseY, partialTick);
        poseStack.pushPose();
        int scale = 75;
        poseStack.scale(scale, scale, 30);
        float scaledX = (float) this.leftPos / scale + ((float) ((this.imageWidth / 4) + 2) / scale);
        float scaledZ = (float) this.textStartHeight / scale;

        MultiBufferSource.BufferSource bufferSource = MultiBufferSource.immediate(Tesselator.getInstance().getBuilder());

        poseStack.translate(scaledX, scaledZ, 30);
        poseStack.mulPose(Vector3f.ZN.rotationDegrees(180));
        poseStack.mulPose(Vector3f.YN.rotationDegrees(45));
        Minecraft.getInstance().getBlockRenderer().renderSingleBlock(this.currentlyRendered, poseStack, bufferSource, 15728880, OverlayTexture.NO_OVERLAY);
        bufferSource.endBatch();
        poseStack.popPose();
        Minecraft.getInstance().font.draw(poseStack, this.getTitle(), this.leftPos + ((this.imageWidth / 4)) - (Minecraft.getInstance().font.width(this.getTitle()) / 2) + 2, this.bottomPos + 10, 0);
    }
}
