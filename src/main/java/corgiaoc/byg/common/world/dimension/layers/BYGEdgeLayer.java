package corgiaoc.byg.common.world.dimension.layers;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.newbiome.context.Context;
import net.minecraft.world.level.newbiome.layer.traits.CastleTransformer;

import java.util.Map;

public class BYGEdgeLayer implements CastleTransformer {

    private final Map<ResourceKey<Biome>, ResourceKey<Biome>> edgeMap;
    private final Registry<Biome> biomeRegistry;

    public BYGEdgeLayer(Registry<Biome> biomeRegistry, Map<ResourceKey<Biome>, ResourceKey<Biome>> edgeMap) {
        this.edgeMap = edgeMap;
        this.biomeRegistry = biomeRegistry;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public int apply(Context context, int n, int w, int s, int e, int centre) {
        final int[] ArrayNESW = {n, w, s, e};

        for (int idx : ArrayNESW) {
            ResourceKey<Biome> centreKey = biomeRegistry.getResourceKey(biomeRegistry.byId(centre)).get();
            ResourceKey<Biome> idxKey = biomeRegistry.getResourceKey(biomeRegistry.byId(idx)).get();

            if (edgeMap.containsKey(centreKey) && idxKey != centreKey) {
                return biomeRegistry.getId(biomeRegistry.get(edgeMap.get(centreKey)));
            }
        }
        return centre;
    }
}