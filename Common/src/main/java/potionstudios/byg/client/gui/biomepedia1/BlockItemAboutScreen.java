package potionstudios.byg.client.gui.biomepedia1;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class BlockItemAboutScreen extends Screen {
    private final Screen parent;
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

    protected BlockItemAboutScreen(Screen parent, BlockItem item) {
        super(new ItemStack(item).getHoverName());
        this.parent = parent;
        this.item = item;
        this.possibleStates = item.getBlock().getStateDefinition().getPossibleStates();
        this.currentlyRendered = possibleStates.get(0);

        String translationKey = "biomepedia.desc." + item.getDescriptionId(new ItemStack(item));
        boolean useTranslation = !I18n.get(translationKey).equals(translationKey);

        this.description = new TranslatableComponent(useTranslation ? translationKey : "biomepedia.desc.block.byg.none");
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
        this.leftPos = ((this.width - this.imageWidth) / 2);
        this.bottomPos = (this.height - this.imageHeight) / 2 - 15;
        this.rightPos = this.leftPos + this.imageWidth;
        this.topPos = this.bottomPos + this.imageHeight;
        this.toolTipMaxWidth = (this.imageWidth / 2) - 25;
        this.textStartHeight = (this.bottomPos + this.imageHeight / 2) - 5;
        int y1 = this.topPos - 12;
        ScrollableText scrollableText = new ScrollableText(this.description, this.toolTipMaxWidth, this.textStartHeight, this.textStartHeight + 16, y1);
        scrollableText.setLeftPos(this.leftPos + 13);
        this.addRenderableWidget(scrollableText);
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        RenderSystem.setShaderTexture(0, BiomepediaScreen.BIOMEPEDIA_LOCATION);

        blit(poseStack, this.leftPos, this.bottomPos, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);
        super.render(poseStack, mouseX, mouseY, partialTick);
        poseStack.pushPose();
        int scale = 75;
        poseStack.scale(scale, scale, 30);
        float scaledX = (float) this.leftPos / scale + ((float) ((this.imageWidth / 4) + 4) / scale);
        float scaledZ = (float) (this.textStartHeight) / scale;

        MultiBufferSource.BufferSource bufferSource = MultiBufferSource.immediate(Tesselator.getInstance().getBuilder());

        poseStack.translate(scaledX, scaledZ, 30);
        poseStack.mulPose(Vector3f.ZN.rotationDegrees(180));
        poseStack.mulPose(Vector3f.YN.rotationDegrees(45));
        Minecraft.getInstance().getBlockRenderer().renderSingleBlock(this.currentlyRendered, poseStack, bufferSource, 15728880, OverlayTexture.NO_OVERLAY);
        bufferSource.endBatch();
        poseStack.popPose();
        Minecraft.getInstance().font.draw(poseStack, this.getTitle(), this.leftPos + ((this.imageWidth / 4)) - (Minecraft.getInstance().font.width(this.getTitle()) / 2) + 4, this.bottomPos + 13, 0);
    }
}
