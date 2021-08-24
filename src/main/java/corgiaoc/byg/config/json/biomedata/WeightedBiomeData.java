package corgiaoc.byg.config.json.biomedata;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.behavior.WeightedList;

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
        }), WeightedList.codec(ResourceLocation.CODEC).optionalFieldOf("hills", new WeightedList<>()).forGetter((subBiomeData) -> {
            return subBiomeData.getSubBiomes();
        })).apply(builder, WeightedBiomeData::new);
    });

    private final int weight;
    private final WeightedList<ResourceLocation> subBiomes;

    public WeightedBiomeData(int weight, List<String> dictionary, ResourceLocation edgeBiome, WeightedList<ResourceLocation> subBiomes) {
        super(dictionary, edgeBiome);
        this.weight = weight;
        this.subBiomes = subBiomes;
    }

    public WeightedList<ResourceLocation> getSubBiomes() {
        return subBiomes;
    }

    public int getWeight() {
        return weight;
    }
}
