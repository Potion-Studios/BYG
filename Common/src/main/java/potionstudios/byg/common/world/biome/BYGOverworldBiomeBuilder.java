package potionstudios.byg.common.world.biome;

import net.minecraft.Util;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

import java.util.*;

public class BYGOverworldBiomeBuilder {

    private static final ResourceKey<Biome>[][] OCEANS = new ResourceKey[][]{
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    };
    private static final ResourceKey<Biome>[][] MIDDLE_BIOMES = new ResourceKey[][]{
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, BYGBiomes.AUTUMNAL_VALLEY, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, BYGBiomes.ALLIUM_FIELDS, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, BYGBiomes.BAOBAB_SAVANNA, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    };
    private static final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{
            {null, null, null, null, null},
            {null, null, BYGBiomes.ASPEN_FOREST, null, null},
            {null, null, null, null, null},
            {null, BYGBiomes.ARAUCARIA_SAVANNA, null, BYGBiomes.AMARANTH_FIELDS, null},
            {null, null, null, null, null}
    };
    private static final ResourceKey<Biome>[][] PLATEAU_BIOMES = new ResourceKey[][]{
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    };
    private static final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null}
    };

    private static final ResourceKey<Biome>[][] EXTREME_HILLS = new ResourceKey[][]{
            {null, null, null, null, null},
            {null, null, null, null, BYGBiomes.BOREAL_FOREST},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null}
    };

    public static final Collection<BiomeProviderData> DEFAULTS = Util.make(new ArrayList<>(), list -> {
        list.add(new BiomeProviderData(4, OCEANS, MIDDLE_BIOMES, MIDDLE_BIOMES_VARIANT, PLATEAU_BIOMES, PLATEAU_BIOMES_VARIANT, EXTREME_HILLS, Util.make(new IdentityHashMap<>(), map -> map.put(Biomes.SWAMP, BYGBiomes.BAYOU))));
    });

    public record BiomeProviderData(int overworldWeight, ResourceKey<Biome>[][] oceans, ResourceKey<Biome>[][] middleBiomes, ResourceKey<Biome>[][] middleBiomesVariant, ResourceKey<Biome>[][] plateauBiomes, ResourceKey<Biome>[][] plateauBiomesVariant, ResourceKey<Biome>[][] extremeHills, Map<ResourceKey<Biome>, ResourceKey<Biome>> swapper) {}
}
