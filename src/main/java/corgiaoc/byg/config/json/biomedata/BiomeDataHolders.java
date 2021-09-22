package corgiaoc.byg.config.json.biomedata;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.util.BiomeKeyUtil;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("deprecation")
public class BiomeDataHolders {

    public static class EndSubBiomeDataHolder extends BiomeDataListHolder<BiomeData> {
        public static final Codec<EndSubBiomeDataHolder> CODEC = RecordCodecBuilder.create((builder) -> {
            return builder.group(Codec.unboundedMap(BiomeKeyUtil.BIOME_KEY, BiomeData.CODEC).fieldOf("biomes").forGetter((endSubBiomeDataHolder) -> {
                return endSubBiomeDataHolder.getEndSubBiomeData();
            }), Codec.unboundedMap(BiomeKeyUtil.BIOME_KEY, BiomeData.CODEC).fieldOf("void-biomes").forGetter((endSubBiomeDataHolder) -> {
                return endSubBiomeDataHolder.voidSubBiomeData;
            })).apply(builder, EndSubBiomeDataHolder::new);
        });

        private final Map<ResourceKey<Biome>, BiomeData> voidSubBiomeData;

        public EndSubBiomeDataHolder(Map<ResourceKey<Biome>, BiomeData> endSubBiomeData, Map<ResourceKey<Biome>, BiomeData> voidSubBiomeData) {
            super(endSubBiomeData);
            this.voidSubBiomeData = new HashMap<>(voidSubBiomeData);
            this.voidSubBiomeData.forEach((key, biomeData) -> {
                this.getBiomeDictionary().add(Pair.of(key, biomeData.getDictionaryTypes()));
            });
        }

        public Map<ResourceKey<Biome>, BiomeData> getEndSubBiomeData() {
            return getBiomeData();
        }

        public Map<ResourceKey<Biome>, BiomeData> getVoidSubBiomeData() {
            return voidSubBiomeData;
        }

    }

    public static class EndBiomeDataHolder extends BiomeDataListHolder<WeightedBiomeData> {
        public static final Codec<EndBiomeDataHolder> CODEC = RecordCodecBuilder.create((builder) -> {
            return builder.group(Codec.unboundedMap(BiomeKeyUtil.BIOME_KEY, WeightedBiomeData.CODEC).fieldOf("biomes").forGetter((endSubBiomeDataHolder) -> {
                return endSubBiomeDataHolder.getEndBiomeData();
            }), Codec.unboundedMap(BiomeKeyUtil.BIOME_KEY, WeightedBiomeData.CODEC).fieldOf("void-biomes").forGetter((endSubBiomeDataHolder) -> {
                return endSubBiomeDataHolder.voidBiomeData;
            })).apply(builder, EndBiomeDataHolder::new);
        });

        private final Map<ResourceKey<Biome>, WeightedBiomeData> voidBiomeData;

        public EndBiomeDataHolder(Map<ResourceKey<Biome>, WeightedBiomeData> endBiomeData, Map<ResourceKey<Biome>, WeightedBiomeData> voidBiomeData) {
            super(endBiomeData);
            this.voidBiomeData = new HashMap<>(voidBiomeData);

            this.voidBiomeData.forEach((key, biomeData) -> {
                this.getBiomeDictionary().add(Pair.of(key, biomeData.getDictionaryTypes()));
            });
        }

        public Map<ResourceKey<Biome>, WeightedBiomeData> getEndBiomeData() {
            return getBiomeData();
        }

        public Map<ResourceKey<Biome>, WeightedBiomeData> getVoidBiomeData() {
            return voidBiomeData;
        }
    }

    public static class WeightedBiomeDataHolder extends BiomeDataListHolder<WeightedBiomeData> {
        public static final Codec<WeightedBiomeDataHolder> CODEC = RecordCodecBuilder.create((builder) -> {
            return builder.group(Codec.unboundedMap(BiomeKeyUtil.BIOME_KEY, WeightedBiomeData.CODEC).fieldOf("biomes").forGetter((endSubWeightedBiomeDataHolder) -> {
                return endSubWeightedBiomeDataHolder.getBiomeData();
            })).apply(builder, WeightedBiomeDataHolder::new);
        });

        public WeightedBiomeDataHolder(Map<ResourceKey<Biome>, WeightedBiomeData> endBiomeData) {
            super(endBiomeData);
        }
    }

    public static class OverworldPrimaryBiomeDataHolder extends BiomeDataListHolder<OverworldPrimaryBiomeData> {
        public static final Codec<OverworldPrimaryBiomeDataHolder> CODEC = RecordCodecBuilder.create((builder) -> {
            return builder.group(Codec.unboundedMap(BiomeKeyUtil.BIOME_KEY, OverworldPrimaryBiomeData.CODEC).fieldOf("biomes").forGetter((endSubBiomeDataHolder) -> {
                return endSubBiomeDataHolder.getBiomeData();
            })).apply(builder, OverworldPrimaryBiomeDataHolder::new);
        });

        public OverworldPrimaryBiomeDataHolder(Map<ResourceKey<Biome>, OverworldPrimaryBiomeData> biomeData) {
            super(biomeData);
        }
    }

    public static class OverworldSubBiomeDataHolder extends BiomeDataListHolder<OverworldSubBiomeData> {
        public static final Codec<OverworldSubBiomeDataHolder> CODEC = RecordCodecBuilder.create((builder) -> {
            return builder.group(Codec.unboundedMap(BiomeKeyUtil.BIOME_KEY, OverworldSubBiomeData.CODEC).fieldOf("biomes").forGetter((endSubBiomeDataHolder) -> {
                return endSubBiomeDataHolder.getBiomeData();
            })).apply(builder, OverworldSubBiomeDataHolder::new);
        });

        public OverworldSubBiomeDataHolder(Map<ResourceKey<Biome>, OverworldSubBiomeData> biomeData) {
            super(biomeData);
        }
    }
}