package corgiaoc.byg.config.json.biomedata;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.EitherCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BiomeData {

    public static final Codec<BiomeData> CODEC = RecordCodecBuilder.create((builder) -> {
        return builder.group(new EitherCodec<>(Codec.STRING,  Codec.STRING.listOf()).xmap(e -> e.map((string) -> Arrays.asList(string.split(",")), list -> list), Either::right).optionalFieldOf("dictionary", new ArrayList<>()).forGetter((subBiomeData) -> {
            return Arrays.asList(subBiomeData.getDictionaryTypes());
        }), ResourceLocation.CODEC.optionalFieldOf("edge", new ResourceLocation("")).forGetter((subBiomeData) -> {
            return subBiomeData.getEdgeBiome();
        })).apply(builder, BiomeData::new);
    });

    private final ResourceLocation edgeBiome;
    private final String[] dictionary;

    public BiomeData(List<String> dictionary, ResourceLocation edgeBiome) {
        this(dictionary.toArray(new String[0]), edgeBiome);
    }

    public BiomeData(String[] dictionary, ResourceLocation edgeBiome) {
        this.dictionary = dictionary;
        this.edgeBiome = edgeBiome;
    }

    public ResourceLocation getEdgeBiome() {
        return edgeBiome;
    }

    public String[] getDictionaryTypes() {
        return dictionary;
    }
}
