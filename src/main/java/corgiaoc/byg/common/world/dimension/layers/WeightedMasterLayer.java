package corgiaoc.byg.common.world.dimension.layers;

import corgiaoc.byg.util.LayerRandomWeightedListUtil;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.WeightedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.type.InitLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;

public class WeightedMasterLayer implements InitLayer {

    private final Registry<Biome> biomeRegistry;
    private final WeightedList<Identifier> weightedBiomesList;

    public WeightedMasterLayer(Registry<Biome> biomeRegistry, WeightedList<Identifier> weightedBiomesList) {
        this.biomeRegistry = biomeRegistry;
        this.weightedBiomesList = weightedBiomesList;
    }

    @Override
    public int sample(LayerRandomnessSource rand, int x, int y) {
        return getRandomBiome(this.biomeRegistry, rand);
    }

    private int getRandomBiome(Registry<Biome> biomeRegistry, LayerRandomnessSource rand) {
        return biomeRegistry.getRawId(biomeRegistry.getOrEmpty(LayerRandomWeightedListUtil.getBiomeFromID(this.weightedBiomesList, rand)).orElseThrow(RuntimeException::new));
    }
}