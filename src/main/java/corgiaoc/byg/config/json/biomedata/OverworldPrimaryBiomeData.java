package corgiaoc.byg.config.json.biomedata;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.util.MLClimate;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;

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
        }), WeightedList.codec(ResourceLocation.CODEC).optionalFieldOf("hills", new WeightedList<>()).forGetter((subBiomeData) -> {
            return subBiomeData.getSubBiomes();
        }), ResourceLocation.CODEC.optionalFieldOf("edge", new ResourceLocation("")).forGetter((subBiomeData) -> {
            return subBiomeData.getEdgeBiome();
        }), ResourceLocation.CODEC.optionalFieldOf("beach", new ResourceLocation("")).forGetter((subBiomeData) -> {
            return subBiomeData.getBeach();
        }), ResourceLocation.CODEC.optionalFieldOf("river", new ResourceLocation("")).forGetter((subBiomeData) -> {
            return subBiomeData.getRiver();
        })).apply(builder, OverworldPrimaryBiomeData::new);
    });

    private final MLClimate climate;
    private final int weight;
    private final ResourceLocation beachBiome;
    private final ResourceLocation riverBiome;

    public OverworldPrimaryBiomeData(MLClimate climate, int weight, List<String> dictionary, WeightedList<ResourceLocation> subBiomes, ResourceLocation edgeBiome, ResourceLocation beachBiome, ResourceLocation riverBiome) {
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

    public ResourceLocation getBeach() {
        return beachBiome;
    }

    public ResourceLocation getRiver() {
        return riverBiome;
    }
}
