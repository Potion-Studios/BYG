package corgiaoc.byg.common.world.dimension.layers;

import corgiaoc.byg.mixin.access.WeightedRandomListAccess;
import corgiaoc.byg.util.LayerRandomWeightedListUtil;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.newbiome.area.Area;
import net.minecraft.world.level.newbiome.context.Context;
import net.minecraft.world.level.newbiome.layer.traits.AreaTransformer2;
import net.minecraft.world.level.newbiome.layer.traits.DimensionOffset1Transformer;

import java.util.Map;

@SuppressWarnings("unchecked")
public class BYGHillsLayer implements AreaTransformer2, DimensionOffset1Transformer {

    private final Map<ResourceKey<Biome>, WeightedRandomList<WeightedEntry.Wrapper<ResourceKey<Biome>>>> hillMap;
    private final Registry<Biome> biomeRegistry;
    private final int hillReplacementChance;

    public BYGHillsLayer(Registry<Biome> biomeRegistry, Map<ResourceKey<Biome>, WeightedRandomList<WeightedEntry.Wrapper<ResourceKey<Biome>>>> hillMap, int hillReplacementChance) {
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
                if (hillMap.containsKey(biomeRegistry.getResourceKey(biomeRegistry.byId(i)).get())) {
                    Biome hill = getHillBiomeValue(hillMap.get(biomeRegistry.getResourceKey(biomeRegistry.byId(i)).get()), rand);
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
    private Biome getHillBiomeValue(WeightedRandomList<WeightedEntry.Wrapper<ResourceKey<Biome>>> biomeHolder, Context layerRandom) {
        if ((((WeightedRandomListAccess<WeightedEntry.Wrapper<ResourceLocation>>) biomeHolder).getItems().size() > 0)) {
            return biomeRegistry.get(LayerRandomWeightedListUtil.getBiomeFromID(biomeHolder, layerRandom));
        }
        else {
            return null;
        }
    }
}