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

public class PrimaryBiomeData extends BiomeData {

    public static final Codec<PrimaryBiomeData> CODEC = RecordCodecBuilder.create((builder) -> {
        return builder.group(Codec.STRING.listOf().optionalFieldOf("dictionary", new ArrayList<>()).forGetter((subBiomeData) -> {
            return Arrays.asList(subBiomeData.getDictionaryTypes());
        }), SimpleWeightedRandomList.codec(WeightedEntry.Wrapper.codec(ResourceLocation.CODEC)).optionalFieldOf("hills", SimpleWeightedRandomList.create()).forGetter((subBiomeData) -> {
            return subBiomeData.getSubBiomes();
        }), ResourceLocation.CODEC.optionalFieldOf("edge", new ResourceLocation("")).forGetter((subBiomeData) -> {
            return subBiomeData.getEdgeBiome();
        })).apply(builder, PrimaryBiomeData::new);
    });

    private final WeightedRandomList<WeightedEntry.Wrapper<ResourceLocation>> subBiomes;

    public PrimaryBiomeData(List<String> dictionary, WeightedRandomList<WeightedEntry.Wrapper<ResourceLocation>> subBiomes, ResourceLocation edgeBiome) {
        super(dictionary, edgeBiome);
        this.subBiomes = subBiomes;
    }

    public WeightedRandomList<WeightedEntry.Wrapper<ResourceLocation>> getSubBiomes() {
        return subBiomes;
    }
}
