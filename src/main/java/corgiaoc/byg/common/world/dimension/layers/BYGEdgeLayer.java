package corgiaoc.byg.common.world.dimension.layers;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.type.CrossSamplingLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;

import java.util.Map;

public class BYGEdgeLayer implements CrossSamplingLayer {

    private final Map<Identifier, Identifier> edgeMap;
    private final Registry<Biome> biomeRegistry;

    public BYGEdgeLayer(Registry<Biome> biomeRegistry, Map<Identifier, Identifier> edgeMap) {
        this.edgeMap = edgeMap;
        this.biomeRegistry = biomeRegistry;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public int sample(LayerRandomnessSource context, int n, int w, int s, int e, int centre) {
        final int[] ArrayNESW = {n, w, s, e};

        for (int idx : ArrayNESW) {
            Identifier centreKey = biomeRegistry.getId(biomeRegistry.get(centre));
            Identifier idxKey = biomeRegistry.getId(biomeRegistry.get(idx));

            if (edgeMap.containsKey(centreKey) && idxKey != centreKey) {
                return biomeRegistry.getRawId(biomeRegistry.get(edgeMap.get(centreKey)));
            }
        }
        return centre;
    }
}