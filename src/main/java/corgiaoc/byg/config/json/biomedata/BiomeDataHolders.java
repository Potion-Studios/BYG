package corgiaoc.byg.config.json.biomedata;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.ResourceLocation;

import java.util.List;
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
            this.voidSubBiomeData = voidSubBiomeData;
        }

        public Map<ResourceLocation, BiomeData> getEndSubBiomeData() {
            return getBiomeData();
        }

        public Map<ResourceLocation, BiomeData> getVoidSubBiomeData() {
            return voidSubBiomeData;
        }
    }

    public static class EndBiomeDataHolder extends BiomeDataListHolder<EndBiomeData> {
        public static final Codec<EndBiomeDataHolder> CODEC = RecordCodecBuilder.create((builder) -> {
            return builder.group(Codec.unboundedMap(ResourceLocation.CODEC, EndBiomeData.CODEC).fieldOf("biomes").forGetter((endSubBiomeDataHolder) -> {
                return endSubBiomeDataHolder.getEndBiomeData();
            }), Codec.unboundedMap(ResourceLocation.CODEC, EndBiomeData.CODEC).fieldOf("void-biomes").forGetter((endSubBiomeDataHolder) -> {
                return endSubBiomeDataHolder.voidSubBiomeData;
            })).apply(builder, EndBiomeDataHolder::new);
        });

        private final Map<ResourceLocation, EndBiomeData> voidSubBiomeData;

        public EndBiomeDataHolder(Map<ResourceLocation, EndBiomeData> endBiomeData, Map<ResourceLocation, EndBiomeData> voidBiomeData) {
            super(endBiomeData);
            this.voidSubBiomeData = voidBiomeData;
        }

        public Map<ResourceLocation, EndBiomeData> getEndBiomeData() {
            return getBiomeData();
        }

        public Map<ResourceLocation, EndBiomeData> getVoidBiomeData() {
            return voidSubBiomeData;
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