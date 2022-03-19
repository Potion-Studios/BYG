package potionstudios.byg.client.gui.biomepedia.widgets.pages;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.util.FormattedCharSequence;
import potionstudios.byg.client.gui.biomepedia.widgets.BookBackgroundWidget;

import java.util.List;

public class BPHomePageWidget extends BookBackgroundWidget {

	public BPHomePageWidget(int x, int y) {
		super(x, y);
	}

	@Override
	public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		super.render(matrixStack, mouseX, mouseY, partialTicks);

		//Title
		Component title = new TextComponent("BYG BiomePedia");
		int titleXOffset = (148 - Minecraft.getInstance().font.width(title)) / 2;

		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderTexture(0, BACKGROUND);
		blit(matrixStack, this.posX + titleXOffset - 2, this.posY + 13, 20, 224, 32, 32);
		Minecraft.getInstance().font.draw(matrixStack, title, this.posX + titleXOffset + 32, this.posY + 25, 0x000000);

		//Info
		List<FormattedCharSequence> text = Minecraft.getInstance().font.split(new TextComponent("The biome pedia informs users on different biomes and their contents."), 158);
		int offset = 0;
		for(FormattedCharSequence comp : text){
			Minecraft.getInstance().font.draw(matrixStack, comp, this.posX + 13, this.posY + 47 + offset, 0x000000);
			offset += 8;
		}

	}

	@Override
	public void renderBackground(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {

	}
}
