package corgiaoc.byg.common.entity.villager;

import com.google.common.collect.Maps;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.mixin.access.VillagerTypeAccess;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.biome.Biome;

import java.util.Map;

@SuppressWarnings("deprecation")
public class BYGVillagerType {

    private static final Map<ResourceKey<Biome>, VillagerType> BY_BYG_BIOME = Util.make(Maps.newHashMap(), (map) -> {
        map.put(getBiomeKey(BYGBiomes.MOJAVE_DESERT), VillagerType.DESERT);
        map.put(getBiomeKey(BYGBiomes.RED_DESERT), VillagerType.DESERT);
        map.put(getBiomeKey(BYGBiomes.RED_ROCK_MOUNTAINS), VillagerType.DESERT);
        map.put(getBiomeKey(BYGBiomes.RED_ROCK_HIGHLANDS), VillagerType.DESERT);
        map.put(getBiomeKey(BYGBiomes.RED_ROCK_LOWLANDS), VillagerType.DESERT);
        map.put(getBiomeKey(BYGBiomes.WOODED_RED_ROCK_MOUNTAINS), VillagerType.DESERT);
        map.put(getBiomeKey(BYGBiomes.TROPICAL_RAINFOREST), VillagerType.JUNGLE);
        map.put(getBiomeKey(BYGBiomes.GUIANA_CLEARING), VillagerType.JUNGLE);
        map.put(getBiomeKey(BYGBiomes.GUIANA_SHIELD), VillagerType.JUNGLE);
        map.put(getBiomeKey(BYGBiomes.TROPICAL_FUNGAL_RAINFOREST), VillagerType.JUNGLE);
    });

    public static void setVillagerForBYGBiomes() {
        VillagerTypeAccess.getVillagerByBiome().putAll(BY_BYG_BIOME);
    }

    public static ResourceKey<Biome> getBiomeKey(Biome biome) {
        return ResourceKey.create(Registry.BIOME_REGISTRY, BuiltinRegistries.BIOME.getKey(biome));
    }
}
