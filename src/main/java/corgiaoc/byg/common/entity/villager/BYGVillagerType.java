package corgiaoc.byg.common.entity.villager;

import com.google.common.collect.Maps;
import corgiaoc.byg.core.world.BYGBiomes;
import net.minecraft.entity.villager.VillagerType;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;

import java.util.Map;

import static net.minecraft.entity.villager.VillagerType.*;

@SuppressWarnings("deprecation")
public class BYGVillagerType {

    private static final Map<RegistryKey<Biome>, VillagerType> BY_BYG_BIOME = Util.make(Maps.newHashMap(), (map) -> {
        map.put(getBiomeKey(BYGBiomes.MOJAVE_DESERT), DESERT);
        map.put(getBiomeKey(BYGBiomes.RED_DESERT), DESERT);
        map.put(getBiomeKey(BYGBiomes.RED_ROCK_MOUNTAINS), DESERT);
        map.put(getBiomeKey(BYGBiomes.TROPICAL_RAINFOREST), JUNGLE);
    });

    public static void setVillagerForBYGBiomes() {
        VillagerType.BY_BIOME.putAll(BY_BYG_BIOME);
    }

    public static RegistryKey<Biome> getBiomeKey(Biome biome) {
        return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, WorldGenRegistries.BIOME.getKey(biome));
    }
}
