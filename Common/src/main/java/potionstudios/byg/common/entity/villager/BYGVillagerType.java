package potionstudios.byg.common.entity.villager;

import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.common.world.biome.BYGBiomes;
import potionstudios.byg.mixin.access.VillagerTypeAccess;

import java.util.Map;

@SuppressWarnings("deprecation")
public class BYGVillagerType {

    private static final Map<ResourceKey<Biome>, VillagerType> BY_BYG_BIOME = Util.make(Maps.newHashMap(), (map) -> {
        map.put(BYGBiomes.MOJAVE_DESERT, VillagerType.DESERT);
        map.put(BYGBiomes.WINDSWEPT_DESERT, VillagerType.DESERT);
        map.put(BYGBiomes.TROPICAL_RAINFOREST, VillagerType.JUNGLE);
        map.put(BYGBiomes.GUIANA_SHIELD, VillagerType.JUNGLE);
        map.put(BYGBiomes.WEEPING_WITCH_FOREST, VillagerType.TAIGA);
    });

    public static void setVillagerForBYGBiomes() {
        VillagerTypeAccess.byg_getBY_BIOME().putAll(BY_BYG_BIOME);
    }
}
