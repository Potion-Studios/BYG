package corgiaoc.byg.common.entity.villager;

import com.google.common.collect.Maps;
import corgiaoc.byg.core.world.BYGBiomes;
import net.minecraft.util.Util;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.VillagerType;
import net.minecraft.world.biome.Biome;

import java.util.Map;

import static net.minecraft.village.VillagerType.DESERT;
import static net.minecraft.village.VillagerType.JUNGLE;


@SuppressWarnings("deprecation")
public class BYGVillagerType {

    private static final Map<RegistryKey<Biome>, VillagerType> BY_BYG_BIOME = Util.make(Maps.newHashMap(), (map) -> {
        map.put(getBiomeKey(BYGBiomes.MOJAVE_DESERT), DESERT);
        map.put(getBiomeKey(BYGBiomes.RED_DESERT), DESERT);
        map.put(getBiomeKey(BYGBiomes.RED_ROCK_MOUNTAINS), DESERT);
        map.put(getBiomeKey(BYGBiomes.TROPICAL_RAINFOREST), JUNGLE);
    });

    public static void setVillagerForBYGBiomes() {
        VillagerType.BIOME_TO_TYPE.putAll(BY_BYG_BIOME);
    }

    public static RegistryKey<Biome> getBiomeKey(Biome biome) {
        return RegistryKey.of(Registry.BIOME_KEY, BuiltinRegistries.BIOME.getId(biome));
    }
}
