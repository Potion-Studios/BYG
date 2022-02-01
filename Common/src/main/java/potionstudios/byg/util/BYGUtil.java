package potionstudios.byg.util;


import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

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

    public static ResourceKey<Biome>[][] convert2DResourceKeyBiomeList(List<List<ResourceKey<Biome>>> listToConvert) {
        List<ResourceKey<Biome>[]> resultList = new ArrayList<>(listToConvert.size());
        for (List<ResourceKey<Biome>> vs : listToConvert) {
            resultList.add(vs.toArray(new ResourceKey[0]));
        }

        return resultList.toArray(new ResourceKey[0][0]);
    }
}
