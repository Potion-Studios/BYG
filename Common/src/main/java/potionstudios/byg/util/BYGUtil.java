package potionstudios.byg.util;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.LevelReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

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
}
