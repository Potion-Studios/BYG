package potionstudios.byg.config.json.biomedata;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.util.BYGUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverworldSubBiomeData extends BiomeData {
    public static final Codec<OverworldSubBiomeData> CODEC = RecordCodecBuilder.create((builder) -> {
        return builder.group(Codec.STRING.listOf().optionalFieldOf("dictionary", new ArrayList<>()).forGetter((subBiomeData) -> {
            return Arrays.asList(subBiomeData.getDictionaryTypes());
        }), BYGUtil.BIOME_KEY.optionalFieldOf("edge", BYGUtil.EMPTY).forGetter((subBiomeData) -> {
            return subBiomeData.getEdgeBiome();
        }), BYGUtil.BIOME_KEY.optionalFieldOf("beach", BYGUtil.EMPTY).forGetter((subBiomeData) -> {
            return subBiomeData.getBeach();
        }), BYGUtil.BIOME_KEY.optionalFieldOf("river", BYGUtil.EMPTY).forGetter((subBiomeData) -> {
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
