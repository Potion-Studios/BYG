package corgiaoc.byg.common.world.dimension.layers;

import corgiaoc.byg.util.LayerRandomWeightedListUtil;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.newbiome.context.Context;
import net.minecraft.world.level.newbiome.layer.traits.AreaTransformer0;

public class WeightedMasterLayer implements AreaTransformer0 {

    private final Registry<Biome> biomeRegistry;
    private final WeightedRandomList<WeightedEntry.Wrapper<ResourceLocation>> weightedBiomesList;

    public WeightedMasterLayer(Registry<Biome> biomeRegistry, WeightedRandomList<WeightedEntry.Wrapper<ResourceLocation>> weightedBiomesList) {
        this.biomeRegistry = biomeRegistry;
        this.weightedBiomesList = weightedBiomesList;
    }

    @Override
    public int applyPixel(Context rand, int x, int y) {
        return getRandomBiome(this.biomeRegistry, rand);
    }

    private int getRandomBiome(Registry<Biome> biomeRegistry, Context rand) {
        return biomeRegistry.getId(biomeRegistry.getOptional(LayerRandomWeightedListUtil.getBiomeFromID(this.weightedBiomesList, rand)).orElseThrow(RuntimeException::new));
    }
}