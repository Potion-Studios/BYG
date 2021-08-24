package corgiaoc.byg.config.json.biomedata;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverworldSubBiomeData extends BiomeData {
    public static final Codec<OverworldSubBiomeData> CODEC = RecordCodecBuilder.create((builder) -> {
        return builder.group(Codec.STRING.listOf().optionalFieldOf("dictionary", new ArrayList<>()).forGetter((subBiomeData) -> {
            return Arrays.asList(subBiomeData.getDictionaryTypes());
        }), ResourceLocation.CODEC.optionalFieldOf("edge", new ResourceLocation("")).forGetter((subBiomeData) -> {
            return subBiomeData.getEdgeBiome();
        }), ResourceLocation.CODEC.optionalFieldOf("beach", new ResourceLocation("")).forGetter((subBiomeData) -> {
            return subBiomeData.getBeach();
        }), ResourceLocation.CODEC.optionalFieldOf("river", new ResourceLocation("")).forGetter((subBiomeData) -> {
            return subBiomeData.getRiver();
        })).apply(builder, OverworldSubBiomeData::new);
    });


    private final ResourceLocation beach;
    private final ResourceLocation river;

    public OverworldSubBiomeData(List<String> dictionary, ResourceLocation edgeBiome, ResourceLocation beach, ResourceLocation river) {
        super(dictionary, edgeBiome);
        this.beach = beach;
        this.river = river;
    }

    public ResourceLocation getBeach() {
        return beach;
    }

    public ResourceLocation getRiver() {
        return river;
    }
}
