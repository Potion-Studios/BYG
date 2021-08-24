package corgiaoc.byg.common.world.dimension.layers;

import corgiaoc.byg.mixin.access.WeightedListAccess;
import corgiaoc.byg.util.LayerRandomWeightedListUtil;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.behavior.WeightedList;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.newbiome.area.Area;
import net.minecraft.world.level.newbiome.context.Context;
import net.minecraft.world.level.newbiome.layer.traits.AreaTransformer2;
import net.minecraft.world.level.newbiome.layer.traits.DimensionOffset1Transformer;

import java.util.Map;

public class BYGHillsLayer implements AreaTransformer2, DimensionOffset1Transformer {

    private final Map<ResourceLocation, WeightedList<ResourceLocation>> hillMap;
    private final Registry<Biome> biomeRegistry;
    private final int hillReplacementChance;

    public BYGHillsLayer(Registry<Biome> biomeRegistry, Map<ResourceLocation, WeightedList<ResourceLocation>> hillMap, int hillReplacementChance) {
        this.hillMap = hillMap;
        this.biomeRegistry = biomeRegistry;
        this.hillReplacementChance = hillReplacementChance;
    }


    @SuppressWarnings("ConstantConditions")
    public int applyPixel(Context rand, Area area1, Area area2, int x, int z) {
        int i = area1.get(this.getParentX(x + 1), this.getParentY(z + 1));

        if (hillMap.size() > 0) {
            if (rand.nextRandom(hillReplacementChance) == 0) {
                int l = i;
                if (hillMap.containsKey(biomeRegistry.getKey(biomeRegistry.byId(i)))) {
                    Biome hill = getHillBiomeValue(hillMap.get(biomeRegistry.getKey(biomeRegistry.byId(i))), rand);
                    if (hill != null) {
                        l = biomeRegistry.getId(hill);
                    }
                }
                return l;
            }
        }
        return i;
    }

    @Nullable
    private Biome getHillBiomeValue(WeightedList<ResourceLocation> biomeHolder, Context layerRandom) {
        if (((WeightedListAccess<ResourceLocation>) biomeHolder).getEntries().size() > 0) {
            return biomeRegistry.get(LayerRandomWeightedListUtil.getBiomeFromID(biomeHolder, layerRandom));
        }
        else {
            return null;
        }
    }
}