package corgiaoc.byg.config.json.biomedata;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("deprecation")
public class BiomeDataHolders {

    public static class EndSubBiomeDataHolder extends BiomeDataListHolder<BiomeData> {
        public static final Codec<EndSubBiomeDataHolder> CODEC = RecordCodecBuilder.create((builder) -> {
            return builder.group(Codec.unboundedMap(ResourceLocation.CODEC, BiomeData.CODEC).fieldOf("biomes").forGetter((endSubBiomeDataHolder) -> {
                return endSubBiomeDataHolder.getEndSubBiomeData();
            }), Codec.unboundedMap(ResourceLocation.CODEC, BiomeData.CODEC).fieldOf("void-biomes").forGetter((endSubBiomeDataHolder) -> {
                return endSubBiomeDataHolder.voidSubBiomeData;
            })).apply(builder, EndSubBiomeDataHolder::new);
        });

        private final Map<ResourceLocation, BiomeData> voidSubBiomeData;

        public EndSubBiomeDataHolder(Map<ResourceLocation, BiomeData>  endSubBiomeData, Map<ResourceLocation, BiomeData>  voidSubBiomeData) {
            super(endSubBiomeData);
            this.voidSubBiomeData = new HashMap<>(voidSubBiomeData);
        }

        public Map<ResourceLocation, BiomeData> getEndSubBiomeData() {
            return getBiomeData();
        }

        public Map<ResourceLocation, BiomeData> getVoidSubBiomeData() {
            return voidSubBiomeData;
        }
    }

    public static class EndBiomeDataHolder extends BiomeDataListHolder<WeightedBiomeData> {
        public static final Codec<EndBiomeDataHolder> CODEC = RecordCodecBuilder.create((builder) -> {
            return builder.group(Codec.unboundedMap(ResourceLocation.CODEC, WeightedBiomeData.CODEC).fieldOf("biomes").forGetter((endSubBiomeDataHolder) -> {
                return endSubBiomeDataHolder.getEndBiomeData();
            }), Codec.unboundedMap(ResourceLocation.CODEC, WeightedBiomeData.CODEC).fieldOf("void-biomes").forGetter((endSubBiomeDataHolder) -> {
                return endSubBiomeDataHolder.voidSubBiomeData;
            })).apply(builder, EndBiomeDataHolder::new);
        });

        private final Map<ResourceLocation, WeightedBiomeData> voidSubBiomeData;

        public EndBiomeDataHolder(Map<ResourceLocation, WeightedBiomeData> endBiomeData, Map<ResourceLocation, WeightedBiomeData> voidBiomeData) {
            super(endBiomeData);
            this.voidSubBiomeData = new HashMap<>(voidBiomeData);
        }

        public Map<ResourceLocation, WeightedBiomeData> getEndBiomeData() {
            return getBiomeData();
        }

        public Map<ResourceLocation, WeightedBiomeData> getVoidBiomeData() {
            return voidSubBiomeData;
        }
    }

    public static class WeightedBiomeDataHolder extends BiomeDataListHolder<WeightedBiomeData> {
        public static final Codec<WeightedBiomeDataHolder> CODEC = RecordCodecBuilder.create((builder) -> {
            return builder.group(Codec.unboundedMap(ResourceLocation.CODEC, WeightedBiomeData.CODEC).fieldOf("biomes").forGetter((endSubWeightedBiomeDataHolder) -> {
                return endSubWeightedBiomeDataHolder.getBiomeData();
            })).apply(builder, WeightedBiomeDataHolder::new);
        });

        public WeightedBiomeDataHolder(Map<ResourceLocation, WeightedBiomeData> endBiomeData) {
            super(endBiomeData);
        }
    }

    public static class OverworldPrimaryBiomeDataHolder extends BiomeDataListHolder<OverworldPrimaryBiomeData> {
        public static final Codec<OverworldPrimaryBiomeDataHolder> CODEC = RecordCodecBuilder.create((builder) -> {
            return builder.group(Codec.unboundedMap(ResourceLocation.CODEC, OverworldPrimaryBiomeData.CODEC).fieldOf("biomes").forGetter((endSubBiomeDataHolder) -> {
                return endSubBiomeDataHolder.getBiomeData();
            })).apply(builder, OverworldPrimaryBiomeDataHolder::new);
        });

        public OverworldPrimaryBiomeDataHolder(Map<ResourceLocation, OverworldPrimaryBiomeData> biomeData) {
            super(biomeData);
        }
    }

    public static class OverworldSubBiomeDataHolder extends BiomeDataListHolder<OverworldSubBiomeData> {
        public static final Codec<OverworldSubBiomeDataHolder> CODEC = RecordCodecBuilder.create((builder) -> {
            return builder.group(Codec.unboundedMap(ResourceLocation.CODEC, OverworldSubBiomeData.CODEC).fieldOf("biomes").forGetter((endSubBiomeDataHolder) -> {
                return endSubBiomeDataHolder.getBiomeData();
            })).apply(builder, OverworldSubBiomeDataHolder::new);
        });

        public OverworldSubBiomeDataHolder(Map<ResourceLocation, OverworldSubBiomeData> biomeData) {
            super(biomeData);
        }
    }
}