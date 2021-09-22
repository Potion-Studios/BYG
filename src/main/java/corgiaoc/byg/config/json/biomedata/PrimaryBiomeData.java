package corgiaoc.byg.config.json.biomedata;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.util.BiomeKeyUtil;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.level.biome.Biome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimaryBiomeData extends BiomeData {

    public static final Codec<PrimaryBiomeData> CODEC = RecordCodecBuilder.create((builder) -> {
        return builder.group(Codec.STRING.listOf().optionalFieldOf("dictionary", new ArrayList<>()).forGetter((subBiomeData) -> {
            return Arrays.asList(subBiomeData.getDictionaryTypes());
        }), SimpleWeightedRandomList.codec(WeightedEntry.Wrapper.codec(BiomeKeyUtil.BIOME_KEY)).optionalFieldOf("hills", SimpleWeightedRandomList.create()).forGetter((subBiomeData) -> {
            return subBiomeData.getSubBiomes();
        }), BiomeKeyUtil.BIOME_KEY.optionalFieldOf("edge", BiomeKeyUtil.EMPTY).forGetter((subBiomeData) -> {
            return subBiomeData.getEdgeBiome();
        })).apply(builder, PrimaryBiomeData::new);
    });

    private final WeightedRandomList<WeightedEntry.Wrapper<ResourceKey<Biome>>> subBiomes;

    public PrimaryBiomeData(List<String> dictionary, WeightedRandomList<WeightedEntry.Wrapper<ResourceKey<Biome>>> subBiomes, ResourceKey<Biome> edgeBiome) {
        super(dictionary, edgeBiome);
        this.subBiomes = subBiomes;
    }

    public WeightedRandomList<WeightedEntry.Wrapper<ResourceKey<Biome>>> getSubBiomes() {
        return subBiomes;
    }
}
