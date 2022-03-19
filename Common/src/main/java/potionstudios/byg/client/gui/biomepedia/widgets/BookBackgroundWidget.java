package potionstudios.byg.client.gui.biomepedia.widgets;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Quaternion;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;

public abstract class BookBackgroundWidget extends NestedWidget{

	private static final ResourceLocation BOOK_BACKGROUND = new ResourceLocation("minecraft", "textures/gui/book.png");
	private static final Quaternion ROT_QUATERNION = Quaternion.fromXYZ(0, 0, (float) Math.toRadians(90));
	protected static final ResourceLocation BACKGROUND = new ResourceLocation("byg", "textures/gui/biomepedia.png");


	public BookBackgroundWidget(int x, int y) {
		super(x, y, 180, 146);
	}

	@Override
	public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderTexture(0, BOOK_BACKGROUND);

		matrixStack.pushPose();
		matrixStack.translate(this.posX + this.width, this.posY, 0);
		matrixStack.mulPose(ROT_QUATERNION);

		blit(matrixStack, 0, 0, 20, 1, this.height, this.width);

		matrixStack.popPose();

		renderBackground(matrixStack, mouseX, mouseY, partialTicks);

		super.render(matrixStack, mouseX, mouseY, partialTicks);
	}

	public abstract void renderBackground(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks);

	//Disable for Narration as this is only an image
	@Override
	public boolean isActive() {
		return false;
	}
}
