package potionstudios.byg.config.json.biomedata;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import potionstudios.byg.util.BYGUtil;
import potionstudios.byg.util.MLClimate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverworldPrimaryBiomeData extends PrimaryBiomeData {

    public static final Codec<OverworldPrimaryBiomeData> CODEC = RecordCodecBuilder.create((builder) -> {
        return builder.group(Codec.STRING.listOf().optionalFieldOf("dictionary", new ArrayList<>()).forGetter((subBiomeData) -> {
            return Arrays.asList(subBiomeData.getDictionaryTypes());
        })).apply(builder, OverworldPrimaryBiomeData::new);
    });

    private final MLClimate climate;
    private final int weight;
    private final ResourceKey<Biome> beachBiome;
    private final ResourceKey<Biome> riverBiome;

    public OverworldPrimaryBiomeData(List<String> dictionary) {
        this(null, 0, dictionary, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build());
    }

    public OverworldPrimaryBiomeData(MLClimate climate, int weight, List<String> dictionary, WeightedRandomList<WeightedEntry.Wrapper<ResourceKey<Biome>>> subBiomes) {
        this(climate, weight, dictionary, subBiomes, BYGUtil.EMPTY);
    }

    public OverworldPrimaryBiomeData(MLClimate climate, int weight, List<String> dictionary, WeightedRandomList<WeightedEntry.Wrapper<ResourceKey<Biome>>> subBiomes, ResourceKey<Biome> edgeBiome) {
        this(climate, weight, dictionary, subBiomes, edgeBiome, Biomes.BEACH, Biomes.RIVER);
    }

    public OverworldPrimaryBiomeData(MLClimate climate, int weight, List<String> dictionary, WeightedRandomList<WeightedEntry.Wrapper<ResourceKey<Biome>>> subBiomes, ResourceKey<Biome> edgeBiome, ResourceKey<Biome> beachBiome, ResourceKey<Biome> riverBiome) {
        super(dictionary, subBiomes, edgeBiome);
        this.climate = climate;
        this.weight = weight;
        this.beachBiome = beachBiome;
        this.riverBiome = riverBiome;
    }

    public MLClimate getClimate() {
        return climate;
    }

    public int getWeight() {
        return weight;
    }

    public ResourceKey<Biome> getBeach() {
        return beachBiome;
    }

    public ResourceKey<Biome> getRiver() {
        return riverBiome;
    }
}
