package potionstudios.byg.config.json.biomedata;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import potionstudios.byg.util.BiomeKeyUtil;
import potionstudios.byg.util.MLClimate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverworldPrimaryBiomeData extends PrimaryBiomeData {

    public static final Codec<OverworldPrimaryBiomeData> CODEC = RecordCodecBuilder.create((builder) -> {
        return builder.group(MLClimate.CODEC.fieldOf("climate").forGetter((subBiomeData) -> {
            return subBiomeData.getClimate();
        }), Codec.INT.optionalFieldOf("weight", 0).forGetter((subBiomeData) -> {
            return subBiomeData.getWeight();
        }), Codec.STRING.listOf().optionalFieldOf("dictionary", new ArrayList<>()).forGetter((subBiomeData) -> {
            return Arrays.asList(subBiomeData.getDictionaryTypes());
        }), SimpleWeightedRandomList.codec(WeightedEntry.Wrapper.codec(BiomeKeyUtil.BIOME_KEY)).optionalFieldOf("hills", SimpleWeightedRandomList.create()).forGetter((subBiomeData) -> {
            return subBiomeData.getSubBiomes();
        }), BiomeKeyUtil.BIOME_KEY.optionalFieldOf("edge", BiomeKeyUtil.EMPTY).forGetter((subBiomeData) -> {
            return subBiomeData.getEdgeBiome();
        }), BiomeKeyUtil.BIOME_KEY.optionalFieldOf("beach", BiomeKeyUtil.EMPTY).forGetter((subBiomeData) -> {
            return subBiomeData.getBeach();
        }), BiomeKeyUtil.BIOME_KEY.optionalFieldOf("river", BiomeKeyUtil.EMPTY).forGetter((subBiomeData) -> {
            return subBiomeData.getRiver();
        })).apply(builder, OverworldPrimaryBiomeData::new);
    });

    private final MLClimate climate;
    private final int weight;
    private final ResourceKey<Biome> beachBiome;
    private final ResourceKey<Biome> riverBiome;

    public OverworldPrimaryBiomeData(MLClimate climate, int weight, List<String> dictionary) {
        this(climate, weight, dictionary, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build());
    }

    public OverworldPrimaryBiomeData(MLClimate climate, int weight, List<String> dictionary, WeightedRandomList<WeightedEntry.Wrapper<ResourceKey<Biome>>> subBiomes) {
        this(climate, weight, dictionary, subBiomes, BiomeKeyUtil.EMPTY);
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
