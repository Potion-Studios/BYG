package corgiaoc.byg.config.json.biomedata;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.util.BiomeKeyUtil;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverworldSubBiomeData extends BiomeData {
    public static final Codec<OverworldSubBiomeData> CODEC = RecordCodecBuilder.create((builder) -> {
        return builder.group(Codec.STRING.listOf().optionalFieldOf("dictionary", new ArrayList<>()).forGetter((subBiomeData) -> {
            return Arrays.asList(subBiomeData.getDictionaryTypes());
        }), BiomeKeyUtil.BIOME_KEY.optionalFieldOf("edge", BiomeKeyUtil.EMPTY).forGetter((subBiomeData) -> {
            return subBiomeData.getEdgeBiome();
        }), BiomeKeyUtil.BIOME_KEY.optionalFieldOf("beach", BiomeKeyUtil.EMPTY).forGetter((subBiomeData) -> {
            return subBiomeData.getBeach();
        }), BiomeKeyUtil.BIOME_KEY.optionalFieldOf("river", BiomeKeyUtil.EMPTY).forGetter((subBiomeData) -> {
            return subBiomeData.getRiver();
        })).apply(builder, OverworldSubBiomeData::new);
    });


    private final ResourceKey<Biome> beach;
    private final ResourceKey<Biome> river;

    public OverworldSubBiomeData(List<String> dictionary, ResourceKey<Biome> edgeBiome, ResourceKey<Biome> beach, ResourceKey<Biome> river) {
        super(dictionary, edgeBiome);
        this.beach = beach;
        this.river = river;
    }

    public ResourceKey<Biome> getBeach() {
        return beach;
    }

    public ResourceKey<Biome> getRiver() {
        return river;
    }
}
