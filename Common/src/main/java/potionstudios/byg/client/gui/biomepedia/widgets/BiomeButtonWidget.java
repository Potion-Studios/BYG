package potionstudios.byg.client.gui.biomepedia.widgets;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.components.Widget;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.BYG;

import java.util.function.Consumer;

public class BiomeButtonWidget extends GuiComponent implements Widget, GuiEventListener, NarratableEntry {

	private static final ResourceLocation TEXTURE = new ResourceLocation(BYG.MOD_ID, "textures/gui/biomepedia.png");

	private ResourceLocation previewIcon;
	private boolean hasIcon = false;
	private int posX, posY;
	private int width = 145, height = 18;

	private ResourceKey<Biome> biome;
	private Consumer<ResourceKey<Biome>> biomeSetter;

	public BiomeButtonWidget(int posX, int posY, Consumer<ResourceKey<Biome>> biomeSetter) {
		this.posX = posX;
		this.posY = posY;
		this.biomeSetter = biomeSetter;
	}

	public void setBiome(ResourceKey<Biome> biome){
		this.biome = biome;
		if (biome != null) {
			this.previewIcon = new ResourceLocation(biome.location().getNamespace(), "/textures/icons/biome/" + biome.location().getPath() + ".png");
			this.hasIcon = Minecraft.getInstance().getResourceManager().hasResource(this.previewIcon);;
		}else{
			this.previewIcon = null;
			this.hasIcon = false;
		}
	}

	@Override
	public void render(PoseStack poseStack, int mouseX, int mouseY, float v) {
		if(this.biome == null) return;

		boolean hovered = mouseX > this.posX && mouseX <= this.posX + this.width && mouseY > this.posY && mouseY <= this.posY + height;

		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderTexture(0, TEXTURE);
		blit(poseStack, this.posX, this.posY, 0, hovered ? 137 : 119, width, height);

		if(this.hasIcon){
			RenderSystem.setShaderTexture(0, this.previewIcon);
			blit(poseStack, this.posX + 1, this.posY + 1, 0, 0, 16, 16, 16, 16);
		}

		Minecraft.getInstance().font.drawShadow(poseStack, new TranslatableComponent("biome." + biome.location().getNamespace() + "." + biome.location().getPath()), this.posX + 18, this.posY + 5, 0xFFFFFF);
	}

	@Override
	public NarrationPriority narrationPriority() {
		return NarrationPriority.NONE;
	}

	@Override
	public void updateNarration(NarrationElementOutput narrationElementOutput) {}

	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int button) {
		if(this.biome == null) return false;
		boolean hovered = mouseX > this.posX && mouseX <= this.posX + this.width && mouseY > this.posY && mouseY <= this.posY + height;

		if(hovered && button == 0){
			biomeSetter.accept(this.biome);
			Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK, 1.0F));
		}

		return hovered && button == 0;
	}
}
