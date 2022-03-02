package potionstudios.byg.util;


import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.common.world.biome.LayersBiomeData;
import potionstudios.byg.mixin.access.WeightedEntryWrapperAccess;
import potionstudios.byg.mixin.access.WeightedListAccess;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class BYGUtil {

    /*
     * Part of the Cyanide mod.
     * Licensed under MIT. See the project LICENSE.txt for details.
     */
    public static final ThreadLocal<RegistryAccess> CAPTURED_REGISTRY_ACCESS = ThreadLocal.withInitial(() -> null);

    public static void captureRegistryAccess(RegistryAccess registryAccess) {
        CAPTURED_REGISTRY_ACCESS.set(registryAccess);
    }

    public static <V> List<List<V>> convert2DArray(V[][] arrayToConvert) {
        List<List<V>> convertedArrays = new ArrayList<>();
        for (V[] vs : arrayToConvert) {
            convertedArrays.add(Arrays.asList(vs));
        }
        return convertedArrays;
    }

    @SuppressWarnings("unchecked")
    public static <T> ResourceKey<T>[][] convert2DResourceKeyArrayTo2DList(List<List<ResourceKey<T>>> listToConvert) {
        List<ResourceKey<T>[]> resultList = new ArrayList<>(listToConvert.size());
        for (List<ResourceKey<T>> vs : listToConvert) {
            resultList.add(vs.toArray(ResourceKey[]::new));
        }

        return resultList.toArray(ResourceKey[][]::new);
    }

    public static <T> String dumpRegistry(Registry<T> registry) {
        StringBuilder registryElements = new StringBuilder();
        for (int i = 0; i < registry.entrySet().size(); i++) {
            final T object = registry.byId(i);
            registryElements.append(i).append(". \"").append(registry.getKey(object).toString()).append("\"\n");
        }
        return registryElements.toString();
    }

    public static boolean createMarkerFile(Path path, String markerText) {
        if (path.toFile().exists()) {
            return false;
        } else {
            try {
                Files.createDirectories(path.getParent());
                Files.write(path, markerText.getBytes());
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public static boolean isNearby(LevelReader levelReader, BlockPos origin, int searchRange, BiPredicate<LevelReader, BlockPos> passes) {
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos().set(origin);
        for (int xOffset = -searchRange; xOffset < searchRange; xOffset++) {
            for (int yOffset = -searchRange; yOffset < searchRange; yOffset++) {
                for (int zOffset = -searchRange; zOffset < searchRange; zOffset++) {
                    mutableBlockPos.set(origin).move(xOffset, yOffset, zOffset);
                    if (passes.test(levelReader, mutableBlockPos)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static IOException configFileFailureException(Path path) {
        return new IOException(String.format("BYG config found at: \"%s\" could not be read. The fastest solution is to rename this failed file and let a new file generate from BYG and replace the fields in the new file with the broken file's fields.", path.toFile()));
    }

    @SuppressWarnings("unchecked")
    public static <T> SimpleWeightedRandomList<T> combineWeightedRandomListsWithoutDuplicatesFilter(SimpleWeightedRandomList<T>... builders) {
        SimpleWeightedRandomList.Builder<T> combinedBuilder = new SimpleWeightedRandomList.Builder<>();
        for (SimpleWeightedRandomList<T> build : builders) {
            for (WeightedEntry.Wrapper<T> item : ((WeightedListAccess<WeightedEntry.Wrapper<T>>) build).getItems()) {
                Set<T> collection = ((WeightedListAccess<WeightedEntry.Wrapper<T>>) combinedBuilder.build()).getItems().stream().map(item1 -> ((WeightedEntryWrapperAccess<T>) item1).getData()).collect(Collectors.toSet());
                T data = ((WeightedEntryWrapperAccess<T>) item).getData();

                if (!collection.contains(data)) {
                    combinedBuilder.add(data, ((WeightedEntryWrapperAccess<T>) item).getWeight().asInt());
                }
            }
        }
        return combinedBuilder.build();
    }

    @SuppressWarnings("unchecked")
    public static List<Biome> createBiomesFromBiomeData(Registry<Biome> biomeRegistry, Path configPath, LayersBiomeData... layersBiomeDatas) {
        List<Biome> biomes = new ArrayList<>();
        for (LayersBiomeData layersBiomeData : layersBiomeDatas) {
            ImmutableList<WeightedEntry.Wrapper<ResourceKey<Biome>>> items = ((WeightedListAccess<WeightedEntry.Wrapper<ResourceKey<Biome>>>) layersBiomeData.biomeWeights()).getItems();

            for (WeightedEntry.Wrapper<ResourceKey<Biome>> key : items) {
                ResourceKey<Biome> resourceKey = key.getData();
                Biome biome = biomeRegistry.get(resourceKey);
                if (biome != null) {
                    biomes.add(biome);
                } else {
                    throw new IllegalArgumentException(String.format("\"%s\" is not a valid biome in the registry, fix the ID or remove the json entry from the config: \"%s\" and relaunch Minecraft...", resourceKey, configPath.toString()));
                }
            }
        }
        return biomes;
    }
}
