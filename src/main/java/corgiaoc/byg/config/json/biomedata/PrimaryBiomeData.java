package corgiaoc.byg.config.json.biomedata;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.behavior.WeightedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimaryBiomeData extends BiomeData {

    public static final Codec<PrimaryBiomeData> CODEC = RecordCodecBuilder.create((builder) -> {
        return builder.group(Codec.STRING.listOf().optionalFieldOf("dictionary", new ArrayList<>()).forGetter((subBiomeData) -> {
            return Arrays.asList(subBiomeData.getDictionaryTypes());
        }), WeightedList.codec(ResourceLocation.CODEC).optionalFieldOf("hills", new WeightedList<>()).forGetter((subBiomeData) -> {
            return subBiomeData.getSubBiomes();
        }), ResourceLocation.CODEC.optionalFieldOf("edge", new ResourceLocation("")).forGetter((subBiomeData) -> {
            return subBiomeData.getEdgeBiome();
        })).apply(builder, PrimaryBiomeData::new);
    });

    private final WeightedList<ResourceLocation> subBiomes;

    public PrimaryBiomeData(List<String> dictionary, WeightedList<ResourceLocation> subBiomes, ResourceLocation edgeBiome) {
        super(dictionary, edgeBiome);
        this.subBiomes = subBiomes;
    }

    public WeightedList<ResourceLocation> getSubBiomes() {
        return subBiomes;
    }
}
