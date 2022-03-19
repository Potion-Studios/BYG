package potionstudios.byg.client.gui.biomepedia.widgets.pages;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.Biome;

import java.util.List;

public class BPBiomeInfoPageWidget extends BPBiomePageWidget {

	private int scrollOffset = 0;
	private boolean hasPreviewImage = false;
	private ResourceLocation previewImageLocation;
	private Component name, desc;
	private List<FormattedCharSequence> descriptionComponents;

	public BPBiomeInfoPageWidget(int x, int y) {
		super(x, y);
	}

	@Override
	public void setBiome(ResourceKey<Biome> biome) {
		this.biome = biome;
		if (biome != null) {
			this.previewImageLocation = new ResourceLocation(biome.location().getNamespace(), "/textures/biome_previews/" + biome.location().getPath() + ".png");
			this.hasPreviewImage = biome != null && Minecraft.getInstance().getResourceManager().hasResource(this.previewImageLocation);
			this.name = new TranslatableComponent("biome." + biome.location().getNamespace() + "." + biome.location().getPath());
			this.desc = new TranslatableComponent("biome." + biome.location().getNamespace() + "." + biome.location().getPath() + ".desc");
			this.descriptionComponents = Minecraft.getInstance().font.split(this.desc, 156);
		}else{
			this.previewImageLocation = null;
			this.hasPreviewImage = false;
			this.name = null;
			this.desc = null;
			this.descriptionComponents = null;
		}
	}

	@Override
	public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		super.render(matrixStack, mouseX, mouseY, partialTicks);

		if (this.biome == null) {
			Minecraft.getInstance().font.draw(matrixStack, "Error no biome specified", this.posX + (this.width - Minecraft.getInstance().font.width("Error no biome specified")) / 2, this.posY + this.height / 2 - 4, 0);

			return;
		}

		Font font = Minecraft.getInstance().font;

		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderTexture(0, BACKGROUND);
		blit(matrixStack, this.posX + 12, this.posY + 16, 0, 0, 156, 11);

		if (this.hasPreviewImage) {
			RenderSystem.setShaderTexture(0, this.previewImageLocation);
			blit(matrixStack, this.posX + 13, this.posY + 28, 0, 0, 154, 33, 154, 33);
		}

		font.draw(matrixStack, this.name, this.posX + 14 + (156 - font.width(this.name)) / 2, this.posY + 18, 0x000000);

		int offset = hasPreviewImage ? 0 : -32;
		for (int i = 0; i < (hasPreviewImage ? 8 : 12) && i + scrollOffset < descriptionComponents.size(); i++) {
			FormattedCharSequence comp = descriptionComponents.get(scrollOffset + i);
			Minecraft.getInstance().font.draw(matrixStack, comp, this.posX + 14, this.posY + 63 + offset, 0x000000);
			offset += 8;
		}
	}

	@Override
	public void renderBackground(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
	}

	@Override
	public boolean mouseScrolled(double mouseX, double mouseY, double scroll) {
		int maxScroll = descriptionComponents.size() - (hasPreviewImage ? 8 : 12);
		this.scrollOffset = Mth.clamp(this.scrollOffset + (scroll > 0 ? -1 : 1), 0, maxScroll);
		return true;
	}
}
