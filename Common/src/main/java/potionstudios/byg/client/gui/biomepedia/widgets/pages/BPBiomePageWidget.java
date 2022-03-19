package potionstudios.byg.client.gui.biomepedia.widgets.pages;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.client.gui.biomepedia.widgets.BookBackgroundWidget;

public abstract class BPBiomePageWidget extends BookBackgroundWidget {

	protected ResourceKey<Biome> biome;

	public BPBiomePageWidget(int x, int y) {
		super(x, y);
	}

	public ResourceKey<Biome>  getBiome() {
		return biome;
	}

	public void setBiome(ResourceKey<Biome>  biome) {
		this.biome = biome;
	}
}
