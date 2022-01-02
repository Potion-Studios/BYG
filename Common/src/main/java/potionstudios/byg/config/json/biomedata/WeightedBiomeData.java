package potionstudios.byg.config.json.biomedata;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.util.BYGUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeightedBiomeData extends BiomeData {

    public static final Codec<WeightedBiomeData> CODEC = RecordCodecBuilder.create((builder) -> {
        return builder.group(Codec.INT.optionalFieldOf("weight", 0).forGetter((subBiomeData) -> {
            return subBiomeData.getWeight();
        }), Codec.STRING.listOf().optionalFieldOf("dictionary", new ArrayList<>()).forGetter((subBiomeData) -> {
            return Arrays.asList(subBiomeData.getDictionaryTypes());
        }), BYGUtil.BIOME_KEY.optionalFieldOf("edge", BYGUtil.EMPTY).forGetter((subBiomeData) -> {
            return subBiomeData.getEdgeBiome();
        }), SimpleWeightedRandomList.codec(WeightedEntry.Wrapper.codec(BYGUtil.BIOME_KEY)).optionalFieldOf("hills", SimpleWeightedRandomList.create()).forGetter((subBiomeData) -> {
            return subBiomeData.getSubBiomes();
        })).apply(builder, WeightedBiomeData::new);
    });

    private final int weight;
    private final WeightedRandomList<WeightedEntry.Wrapper<ResourceKey<Biome>>> subBiomes;

    public WeightedBiomeData(int weight, List<String> dictionary, ResourceKey<Biome> edgeBiome) {
        this(weight, dictionary, edgeBiome, new SimpleWeightedRandomList.Builder<ResourceKey<Biome>>().build());
    }

    public WeightedBiomeData(int weight, List<String> dictionary, ResourceKey<Biome> edgeBiome, WeightedRandomList<WeightedEntry.Wrapper<ResourceKey<Biome>>> subBiomes) {
        super(dictionary, edgeBiome);
        this.weight = weight;
        this.subBiomes = subBiomes;
    }

    public WeightedRandomList<WeightedEntry.Wrapper<ResourceKey<Biome>>> getSubBiomes() {
        return subBiomes;
    }

    public int getWeight() {
        return weight;
    }
}
