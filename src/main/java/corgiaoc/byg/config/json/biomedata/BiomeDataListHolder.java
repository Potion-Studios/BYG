package corgiaoc.byg.config.json.biomedata;

import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public abstract class BiomeDataListHolder<T extends BiomeData>{

    private final Map<ResourceLocation, T> biomeData;

    public BiomeDataListHolder(Map<ResourceLocation, T> biomeData) {
        this.biomeData = new HashMap<>(biomeData);
    }

    public Map<ResourceLocation, T> getBiomeData() {
        return biomeData;
    }
}
