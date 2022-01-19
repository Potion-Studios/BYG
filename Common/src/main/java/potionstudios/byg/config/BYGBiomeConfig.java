package potionstudios.byg.config;

import net.minecraft.Util;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import potionstudios.byg.common.world.biome.BYGBiomes;

import java.util.*;

public record BYGBiomeConfig(Map<ResourceKey<Biome>, BiomeProperties> biomeProperties) {

    public static final BYGBiomeConfig DEFAULT = new BYGBiomeConfig(Util.make(new LinkedHashMap<>(), map -> {
        map.put(BYGBiomes.ALLIUM_FIELDS, new BiomeProperties(List.of("PLAINS", "RARE", "LUSH", "OVERWORLD"), List.of(Biomes.PLAINS, Biomes.MEADOW), List.of(), 2));
        map.put(BYGBiomes.AMARANTH_FIELDS, new BiomeProperties(List.of("PLAINS", "RARE", "LUSH", "OVERWORLD"), List.of(Biomes.PLAINS, Biomes.MEADOW), List.of(), 2));
        map.put(BYGBiomes.ARAUCARIA_SAVANNA, new BiomeProperties(List.of("FOREST", "SAVANNA", "HOT", "OVERWORLD"), List.of(Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU), List.of(), 2));
        map.put(BYGBiomes.ASPEN_FOREST, new BiomeProperties(List.of("FOREST", "OVERWORLD"), List.of(Biomes.FOREST), List.of(), 4));
        map.put(BYGBiomes.AUTUMNAL_VALLEY, new BiomeProperties(List.of("FOREST", "OVERWORLD"), List.of(Biomes.FOREST), List.of(), 4));
        map.put(BYGBiomes.BAOBAB_SAVANNA, new BiomeProperties(List.of("SAVANNA", "OVERWORLD"), List.of(Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU), List.of(), 8));
        map.put(BYGBiomes.BAYOU, new BiomeProperties(List.of("SWAMP", "OVERWORLD"), List.of(Biomes.SWAMP), List.of(), 15));
        map.put(BYGBiomes.BOREALIS_GROVE, new BiomeProperties(List.of("FOREST", "OVERWORLD"), List.of(Biomes.TAIGA), List.of(), 4));
    }));

    public record BiomeProperties(Collection<String> biomeDictionary, Collection<ResourceKey<Biome>> spawnsLike, Collection<Climate.ParameterPoint> additonalPoints, int weight) {
    }
}
