package corgiaoc.byg.config.json.biomedata;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.EitherCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.BYG;
import corgiaoc.byg.util.BiomeKeyUtil;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BiomeData {

    public static final Codec<BiomeData> CODEC = RecordCodecBuilder.create((builder) -> {
        return builder.group(new EitherCodec<>(Codec.STRING,  Codec.STRING.listOf()).xmap(e -> e.map((string) -> Arrays.asList(string.split(",")), list -> list), Either::right).optionalFieldOf("dictionary", new ArrayList<>()).forGetter((subBiomeData) -> {
            return Arrays.asList(subBiomeData.getDictionaryTypes());
        }), BiomeKeyUtil.BIOME_KEY.optionalFieldOf("edge", BiomeKeyUtil.EMPTY).forGetter((subBiomeData) -> {
            return subBiomeData.getEdgeBiome();
        })).apply(builder, BiomeData::new);
    });

    private final ResourceKey<Biome> edgeBiome;
    private final String[] dictionary;

    public BiomeData(List<String> dictionary, ResourceKey<Biome> edgeBiome) {
        this(dictionary.toArray(new String[0]), edgeBiome);
    }

    public BiomeData(String[] dictionary, ResourceKey<Biome> edgeBiome) {
        this.dictionary = dictionary;
        this.edgeBiome = edgeBiome;
    }


    public ResourceKey<Biome> getEdgeBiome() {
        return edgeBiome;
    }

    public String[] getDictionaryTypes() {
        return dictionary;
    }
}
