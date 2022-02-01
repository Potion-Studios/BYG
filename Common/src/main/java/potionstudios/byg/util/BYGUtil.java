package potionstudios.byg.util;


import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
