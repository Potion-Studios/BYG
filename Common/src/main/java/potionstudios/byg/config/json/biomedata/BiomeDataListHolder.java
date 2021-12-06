package potionstudios.byg.config.json.biomedata;

import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

import java.util.*;

public abstract class BiomeDataListHolder<T extends BiomeData> {
    private final Map<ResourceKey<Biome>, T> biomeData;
    private final List<Pair<ResourceKey<Biome>, String[]>> dictionaryEntries;

    public BiomeDataListHolder(Map<ResourceKey<Biome>, T> biomeData) {
        this.biomeData = new HashMap<>(biomeData);
        List<Pair<ResourceKey<Biome>, String[]>> dictionaryEntries = new ArrayList<>();
        this.biomeData.forEach((key, biomeData1) -> {
            dictionaryEntries.add(Pair.of(key, biomeData1.getDictionaryTypes()));
        });
        this.dictionaryEntries = dictionaryEntries;
    }

    public Map<ResourceKey<Biome>, T> getBiomeData() {
        return biomeData;
    }

    public Collection<Pair<ResourceKey<Biome>, String[]>> getBiomeDictionary() {
      return this.dictionaryEntries;
    }
}
