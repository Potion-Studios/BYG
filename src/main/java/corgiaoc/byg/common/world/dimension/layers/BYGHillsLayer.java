package corgiaoc.byg.common.world.dimension.layers;

import corgiaoc.byg.util.LayerRandomWeightedListUtil;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.WeightedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.type.MergingLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;
import net.minecraft.world.biome.layer.util.LayerSampler;
import net.minecraft.world.biome.layer.util.NorthWestCoordinateTransformer;

import javax.annotation.Nullable;
import java.util.Map;

public class BYGHillsLayer implements MergingLayer, NorthWestCoordinateTransformer {

    private final Map<Identifier, WeightedList<Identifier>> hillMap;
    private final Registry<Biome> biomeRegistry;
    private final int hillReplacementChance;

    public BYGHillsLayer(Registry<Biome> biomeRegistry, Map<Identifier, WeightedList<Identifier>> hillMap, int hillReplacementChance) {
        this.hillMap = hillMap;
        this.biomeRegistry = biomeRegistry;
        this.hillReplacementChance = hillReplacementChance;
    }


    @SuppressWarnings("ConstantConditions")
    public int sample(LayerRandomnessSource rand, LayerSampler area1, LayerSampler area2, int x, int z) {
        int i = area1.sample(this.transformX(x + 1), this.transformZ(z + 1));
        int j = area2.sample(this.transformX(x + 1), this.transformZ(z + 1));

        if (hillMap.size() > 0) {
            if (rand.nextInt(hillReplacementChance) == 0) {
                int l = i;
                if (hillMap.containsKey(biomeRegistry.getId(biomeRegistry.get(i)))) {
                    Biome hill = getHillBiomeValue(hillMap.get(biomeRegistry.getId(biomeRegistry.get(i))), rand);
                    if (hill != null) {
                        l = biomeRegistry.getRawId(hill);
                    }
                }
                return l;
            }
        }
        return i;
    }

    @Nullable
    private Biome getHillBiomeValue(WeightedList<Identifier> biomeHolder, LayerRandomnessSource layerRandom) {
        if (biomeHolder.entries.size() > 0) {
            return biomeRegistry.get(LayerRandomWeightedListUtil.getBiomeFromID(biomeHolder, layerRandom));
        } else {
            return null;
        }
    }
}