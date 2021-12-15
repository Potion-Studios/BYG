package potionstudios.byg.config.biome;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.BYGBiomes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class BiomeSourceGenerationWorldProperties {

    public static final BiomeSourceGenerationWorldProperties INSTANCE = new BiomeSourceGenerationWorldProperties(Util.make(new Object2ObjectOpenHashMap<>(), (map) -> {
        map.put(Biomes.SAVANNA, Util.make(new ArrayList<>(), (list) -> {
            list.add(new BiomeGenerationWorldProperties(BYGBiomes.ARAUCARIA_SAVANNA, 10));
            list.add(new BiomeGenerationWorldProperties(Biomes.SAVANNA, 10));
        }));
    }));

    private final Map<ResourceKey<Biome>, List<BiomeGenerationWorldProperties>> generationWorldProperties;

    public BiomeSourceGenerationWorldProperties(Map<ResourceKey<Biome>, List<BiomeGenerationWorldProperties>> generationWorldProperties) {
        this.generationWorldProperties = generationWorldProperties;
    }



    public Climate.ParameterList<Supplier<Biome>> createWeightedPointParameterList(Climate.ParameterList<Supplier<Biome>> oldList) {
        ImmutableList.Builder<Pair<Climate.ParameterPoint, Supplier<Biome>>> builder = ImmutableList.builder();
        for (Pair<Climate.ParameterPoint, Supplier<Biome>> pointToBiome : oldList.values()) {
            Climate.ParameterPoint parameterPoint = pointToBiome.getFirst();
            Biome biome = pointToBiome.getSecond().get();
            ResourceKey<Biome> biomeResourceKey = ResourceKey.create(Registry.BIOME_REGISTRY, BYG.biomeRegistryAccess.getKey(biome));
            if (!generationWorldProperties.containsKey(biomeResourceKey)) {
                builder.add(pointToBiome);
                continue;
            }

            int totalWeight = 0;
            final List<BiomeGenerationWorldProperties> climateParameters = generationWorldProperties.get(biomeResourceKey);
            for (BiomeGenerationWorldProperties resourceKeyIntegerPair : climateParameters) {
                totalWeight += resourceKeyIntegerPair.getWeight();
            }

            long offset[] = new long[6];

            for (BiomeGenerationWorldProperties resourceKeyIntegerPair : climateParameters) {
                Climate.Parameter[] parameters = new Climate.Parameter[6];
                parameters[0] = createParameter(offset[0], resourceKeyIntegerPair, totalWeight, parameterPoint.temperature());
                offset[0] = parameters[0].max() - parameters[0].min();

                parameters[1] = createParameter(offset[1], resourceKeyIntegerPair, totalWeight, parameterPoint.humidity());
                offset[1] = parameters[1].max() - parameters[1].min();

                parameters[2] = createParameter(offset[2], resourceKeyIntegerPair, totalWeight, parameterPoint.continentalness());
                offset[2] = parameters[2].max() - parameters[2].min();

                parameters[3] = createParameter(offset[3], resourceKeyIntegerPair, totalWeight, parameterPoint.erosion());
                offset[3] = parameters[3].max() - parameters[3].min();

                parameters[4] = createParameter(offset[4], resourceKeyIntegerPair, totalWeight, parameterPoint.depth());
                offset[4] = parameters[4].max() - parameters[4].min();

                parameters[5] = createParameter(offset[5], resourceKeyIntegerPair, totalWeight, parameterPoint.weirdness());
                offset[5] = parameters[5].max() - parameters[5].min();

                builder.add(new Pair<>(new Climate.ParameterPoint(parameters[0], parameters[1], parameters[2], parameters[3], parameters[4], parameters[5], 0), () -> BYG.biomeRegistryAccess.get(resourceKeyIntegerPair.getSpawnsLike())));
            }
        }
        return new Climate.ParameterList<>(builder.build());
    }

    public static Climate.Parameter createParameter(long offset, BiomeGenerationWorldProperties resourceKeyIntegerPair, int totalWeight, Climate.Parameter parameter) {
        double percentage = (double) resourceKeyIntegerPair.getWeight() / totalWeight;
        long pointSpan = parameter.max() - parameter.min();
        long size = (long) (pointSpan * percentage);
        long min = parameter.min() + offset;
        return new Climate.Parameter(min, min + size);
    }
}
