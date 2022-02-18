package potionstudios.byg.world.biome;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.util.random.WeightedRandom;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import potionstudios.byg.mixin.access.WeightedListAccess;
import terrablender.worldgen.noise.*;

import java.util.List;
import java.util.function.LongFunction;

import static terrablender.worldgen.noise.LayeredNoiseUtil.zoom;

public class LayerUtil {

    public static Area createLayers(Registry<Biome> biomeRegistry, long worldSeed, SimpleWeightedRandomList<ResourceKey<Biome>> biomes, int regionSize) {
        LongFunction<AreaContext> contextFactory = (seedModifier) -> new AreaContext(25, worldSeed, seedModifier);
        AreaFactory factory = new InitLayer(biomes, biomeRegistry).run(contextFactory.apply(1L));
        factory = ZoomLayer.FUZZY.run(contextFactory.apply(2000L), factory);
        factory = zoom(2001L, ZoomLayer.NORMAL, factory, 1, contextFactory);
        factory = zoom(1001L, ZoomLayer.NORMAL, factory, regionSize, contextFactory);
        return factory.make();
    }

    @SuppressWarnings("unchecked")
    private static class InitLayer implements AreaTransformer0 {

        private final SimpleWeightedRandomList<ResourceKey<Biome>> biomes;
        private final Registry<Biome> biomeRegistry;
        private final int totalWeight;
        private final List<WeightedEntry> entries;

        public InitLayer(SimpleWeightedRandomList<ResourceKey<Biome>> biomes, Registry<Biome> biomeRegistry) {
            this.biomes = biomes;
            this.biomeRegistry = biomeRegistry;
            this.totalWeight = ((WeightedListAccess<?>) this.biomes).getTotalWeight();
            this.entries = ((WeightedListAccess<WeightedEntry>) this.biomes).getItems();
        }

        @Override
        public int apply(AreaContext areaContext, int x, int z) {
            if (totalWeight == 0) {
                return biomeRegistry.getId(biomeRegistry.get(Biomes.OCEAN));
            }
            return biomeRegistry.getId(biomeRegistry.get((ResourceKey<Biome>) WeightedRandom.getWeightedItem(this.entries, areaContext.nextRandom(this.totalWeight)).get()));
        }
    }
}