package potionstudios.byg.client.gui.biomepedia.widgets.pages;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.BYG;
import potionstudios.byg.client.gui.biomepedia.widgets.BiomeButtonWidget;
import potionstudios.byg.client.gui.biomepedia.widgets.BookBackgroundWidget;
import potionstudios.byg.server.level.BYGPlayerTrackedData;

import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class BPSearchPageWidget extends BookBackgroundWidget {

	private Map<String, ResourceKey<Biome>> discoveredBiomes = new TreeMap<>();
	private TreeMap<String, ResourceKey<Biome>> filteredBiomes = new TreeMap<>();
	private String prevFilterText = "";
	private int offset = 0;

	private BiomeButtonWidget[] biomeButtons = new BiomeButtonWidget[10];

	public BPSearchPageWidget(int x, int y, Consumer<ResourceKey<Biome>> biomeSetter) {
		super(x, y);

		//Namespace is currently hardocded
		Set<ResourceKey<Biome>> discoveredBiomes = false ? //change to true to display all registered biomes
				(Set<ResourceKey<Biome>>) Minecraft.getInstance().level.registryAccess().registry(Registry.BIOME_REGISTRY).get().entrySet().stream().map(entry -> entry.getKey()).collect(Collectors.toSet()) :
				((BYGPlayerTrackedData.Access) Minecraft.getInstance().player).getPlayerTrackedData().discoveredBiomesByNameSpace().get(BYG.MOD_ID);

		if (discoveredBiomes != null)
			for (ResourceKey<Biome> biome : discoveredBiomes)
				this.discoveredBiomes.put(I18n.get("biome." + biome.location().getNamespace() + "." + biome.location().getPath()).toLowerCase(Locale.ROOT), biome);

		EditBox searchBox;
		this.addChild(searchBox = new EditBox(Minecraft.getInstance().font, this.posX + 30, this.posY + 21, 139, 15, new TextComponent("Search")));
		searchBox.setBordered(false);
		searchBox.setResponder(this::updateFilteredBiomes);

		for(int i = 0; i < 5; i++){
			this.addChild(biomeButtons[i] = new BiomeButtonWidget(this.posX + 14, this.posY + 35 + i*18, biomeSetter));

		}

		updateFilteredBiomes("");
	}

	@Override
	public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		super.render(matrixStack, mouseX, mouseY, partialTicks);
	}

	@Override
	public void renderBackground(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderTexture(0, BACKGROUND);
		blit(matrixStack, this.posX + 13, this.posY + 17, 0, 11, 156, 16);
		blit(matrixStack, this.posX + 13, this.posY + 34, 0, 27, 156, 92);

		int scrollbarHeight = (int) (88 * 5F/filteredBiomes.size());
		int offset = (int) (88 * (((float)this.offset)/filteredBiomes.size()));

		if(scrollbarHeight != 88){
			blit(matrixStack, this.posX + 160, this.posY + offset + 36, 124, 168, 7, scrollbarHeight-2);
			blit(matrixStack, this.posX + 160, this.posY + offset + 34 + scrollbarHeight, 124, 254, 7, 2);
		}
	}

	private void updateFilteredBiomes(String filterText) {
		TreeMap<String, ResourceKey<Biome>> filteredBiomesCopy = new TreeMap<>();
		if (filterText.length() > prevFilterText.length()) {
			this.filteredBiomes.entrySet().parallelStream()
					.filter(entry -> entry.getKey().contains(filterText.toLowerCase(Locale.ROOT)))
					.forEachOrdered(entry -> filteredBiomesCopy.put(entry.getKey(), entry.getValue()));
			this.filteredBiomes = filteredBiomesCopy;
		} else {
			this.filteredBiomes.clear();
			if (!filterText.isEmpty())
				this.discoveredBiomes.entrySet().parallelStream()
						.filter(entry -> entry.getKey().contains(filterText.toLowerCase(Locale.ROOT)))
						.forEachOrdered(entry -> this.filteredBiomes.put(entry.getKey(), entry.getValue()));
			else
				this.filteredBiomes.putAll(this.discoveredBiomes);
		}

		this.prevFilterText = filterText;
		this.offset = 0;

		updateBiomeButtons();
	}

	private void updateBiomeButtons(){
		for(int i = 0; i < 5; i++)
			this.biomeButtons[i].setBiome(null);

		int index = 0;
		int buttonIndex = 0;
		for(ResourceKey<Biome> key : this.filteredBiomes.values()){
			if(index >= offset){
				this.biomeButtons[buttonIndex].setBiome(key);
				buttonIndex++;
				if(buttonIndex == 5)
					break;
			}

			index++;
		}
	}


	@Override
	public boolean mouseScrolled(double mouseX, double mouseY, double scroll) {
		int maxScroll = this.filteredBiomes.size() - 5;
		this.offset = Mth.clamp(this.offset + (scroll > 0 ? -1 : 1), 0, maxScroll);
		this.updateBiomeButtons();
		return true;
	}
}
