package corgiaoc.byg.common.world.dimension.layers;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.newbiome.context.Context;
import net.minecraft.world.level.newbiome.layer.traits.CastleTransformer;

import java.util.Map;

public class BYGEdgeLayer implements CastleTransformer {

    private final Map<ResourceLocation, ResourceLocation> edgeMap;
    private final Registry<Biome> biomeRegistry;

    public BYGEdgeLayer(Registry<Biome> biomeRegistry, Map<ResourceLocation, ResourceLocation> edgeMap) {
        this.edgeMap = edgeMap;
        this.biomeRegistry = biomeRegistry;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public int apply(Context context, int n, int w, int s, int e, int centre) {
        final int[] ArrayNESW = {n, w, s, e};

        for (int idx : ArrayNESW) {
            ResourceLocation centreKey = biomeRegistry.getKey(biomeRegistry.byId(centre));
            ResourceLocation idxKey = biomeRegistry.getKey(biomeRegistry.byId(idx));

            if (edgeMap.containsKey(centreKey) && idxKey != centreKey) {
                int id = biomeRegistry.getId(biomeRegistry.get(edgeMap.get(centreKey)));
                return id;
            }
        }
        return centre;
    }
}