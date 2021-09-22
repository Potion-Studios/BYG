package corgiaoc.byg.config.json.biomedata;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.util.random.WeightedRandomList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeightedBiomeData extends BiomeData {

    public static final Codec<WeightedBiomeData> CODEC = RecordCodecBuilder.create((builder) -> {
        return builder.group(Codec.INT.optionalFieldOf("weight", 0).forGetter((subBiomeData) -> {
            return subBiomeData.getWeight();
        }), Codec.STRING.listOf().optionalFieldOf("dictionary", new ArrayList<>()).forGetter((subBiomeData) -> {
            return Arrays.asList(subBiomeData.getDictionaryTypes());
        }), ResourceLocation.CODEC.optionalFieldOf("edge", new ResourceLocation("")).forGetter((subBiomeData) -> {
            return subBiomeData.getEdgeBiome();
        }), SimpleWeightedRandomList.codec(WeightedEntry.Wrapper.codec(ResourceLocation.CODEC)).optionalFieldOf("hills", SimpleWeightedRandomList.create()).forGetter((subBiomeData) -> {
            return subBiomeData.getSubBiomes();
        })).apply(builder, WeightedBiomeData::new);
    });

    private final int weight;
    private final WeightedRandomList<WeightedEntry.Wrapper<ResourceLocation>> subBiomes;

    public WeightedBiomeData(int weight, List<String> dictionary, ResourceLocation edgeBiome, WeightedRandomList<WeightedEntry.Wrapper<ResourceLocation>> subBiomes) {
        super(dictionary, edgeBiome);
        this.weight = weight;
        this.subBiomes = subBiomes;
    }

    public WeightedRandomList<WeightedEntry.Wrapper<ResourceLocation>> getSubBiomes() {
        return subBiomes;
    }

    public int getWeight() {
        return weight;
    }
}
