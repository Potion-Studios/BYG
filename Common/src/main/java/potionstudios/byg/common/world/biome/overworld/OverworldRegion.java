package potionstudios.byg.common.world.biome.overworld;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgitaco.corgilib.serialization.codec.CodecUtil;
import corgitaco.corgilib.serialization.codec.FromFileCodec;
import corgitaco.corgilib.serialization.codec.Wrapped;
import corgitaco.corgilib.serialization.jankson.JanksonUtil;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import potionstudios.byg.common.world.biome.BYGBiomes;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

import static potionstudios.byg.common.world.biome.overworld.BYGOverworldBiomeSelectors.*;

public record OverworldRegion(int overworldWeight, Wrapped<List<List<ResourceKey<Biome>>>> oceans,
                              Wrapped<List<List<ResourceKey<Biome>>>> middleBiomes,
                              Wrapped<List<List<ResourceKey<Biome>>>> middleBiomesVariant,
                              Wrapped<List<List<ResourceKey<Biome>>>> plateauBiomes,
                              Wrapped<List<List<ResourceKey<Biome>>>> plateauBiomesVariant,
                              Wrapped<List<List<ResourceKey<Biome>>>> extremeHills,
                              Wrapped<List<List<ResourceKey<Biome>>>> beachBiomes,
                              Wrapped<List<List<ResourceKey<Biome>>>> peakBiomes,
                              Wrapped<List<List<ResourceKey<Biome>>>> peakBiomesVariant,
                              Wrapped<List<List<ResourceKey<Biome>>>> slopeBiomes,
                              Wrapped<List<List<ResourceKey<Biome>>>> slopeBiomesVariant,
                              Map<ResourceKey<Biome>, ResourceKey<Biome>> swapper) {
    public static final Codec<OverworldRegion> CODEC = RecordCodecBuilder.create(builder -> builder.group(Codec.INT.fieldOf("weight").forGetter(overworldRegion -> overworldRegion.overworldWeight),
            BIOME_LAYOUT_CODEC.fieldOf("ocean_biomes").forGetter(overworldRegion -> overworldRegion.oceans),
            BIOME_LAYOUT_CODEC.fieldOf("middle_biomes").forGetter(overworldRegion -> overworldRegion.middleBiomes),
            BIOME_LAYOUT_CODEC.fieldOf("middle_biomes_variant").forGetter(overworldRegion -> overworldRegion.middleBiomesVariant),
            BIOME_LAYOUT_CODEC.fieldOf("plateau_biomes").forGetter(overworldRegion -> overworldRegion.plateauBiomes),
            BIOME_LAYOUT_CODEC.fieldOf("plateau_biomes_variant").forGetter(overworldRegion -> overworldRegion.plateauBiomesVariant),
            BIOME_LAYOUT_CODEC.fieldOf("shattered_biomes").forGetter(overworldRegion -> overworldRegion.extremeHills),
            BIOME_LAYOUT_CODEC.fieldOf("beach_biomes").orElse(BEACH_BIOMES_VANILLA).forGetter(overworldRegion -> overworldRegion.beachBiomes),
            BIOME_LAYOUT_CODEC.fieldOf("peak_biomes").orElse(PEAK_BIOMES_VANILLA).forGetter(overworldRegion -> overworldRegion.peakBiomes),
            BIOME_LAYOUT_CODEC.fieldOf("peak_biomes_variant").orElse(PEAK_BIOMES_VARIANT_VANILLA).forGetter(overworldRegion -> overworldRegion.peakBiomesVariant),
            BIOME_LAYOUT_CODEC.fieldOf("slope_biomes").orElse(SLOPE_BIOMES_VANILLA).forGetter(overworldRegion -> overworldRegion.slopeBiomes),
            BIOME_LAYOUT_CODEC.fieldOf("slope_biomes_variant").orElse(SLOPE_BIOMES_VARIANT_VANILLA).forGetter(overworldRegion -> overworldRegion.slopeBiomesVariant),
            Codec.unboundedMap(ResourceLocation.CODEC.comapFlatMap(resourceLocation -> {
                if (!resourceLocation.getNamespace().equals("minecraft")) {
                    throw new IllegalArgumentException("Only biomes from MC can be used as the swapper's key!!! You put: \"" + resourceLocation.toString() + "\"");
                }
                return DataResult.success(ResourceKey.create(Registries.BIOME, resourceLocation));
            }, ResourceKey::location), CodecUtil.BIOME_CODEC).fieldOf("swapper").forGetter(overworldRegion -> overworldRegion.swapper)
    ).apply(builder, OverworldRegion::new));

    public static final Codec<OverworldRegion> VERIFYING_CODEC = CODEC.flatXmap(verifyRegion(), verifyRegion());

    public static final Codec<OverworldRegion> OLD_CODEC = RecordCodecBuilder.create(builder -> builder.group(Codec.INT.fieldOf("weight").forGetter(overworldRegion -> overworldRegion.overworldWeight),
            OLD_BIOME_LAYOUT_CODEC.fieldOf("oceans").forGetter(overworldRegion -> overworldRegion.oceans.value()),
            OLD_BIOME_LAYOUT_CODEC.fieldOf("middle_biomes").forGetter(overworldRegion -> overworldRegion.middleBiomes.value()),
            OLD_BIOME_LAYOUT_CODEC.fieldOf("middle_biomes_variant").forGetter(overworldRegion -> overworldRegion.middleBiomesVariant.value()),
            OLD_BIOME_LAYOUT_CODEC.fieldOf("plateau_biomes").forGetter(overworldRegion -> overworldRegion.plateauBiomes.value()),
            OLD_BIOME_LAYOUT_CODEC.fieldOf("plateau_biomes_variant").forGetter(overworldRegion -> overworldRegion.plateauBiomesVariant.value()),
            OLD_BIOME_LAYOUT_CODEC.fieldOf("shattered_biomes").forGetter(overworldRegion -> overworldRegion.extremeHills.value()),
            OLD_BIOME_LAYOUT_CODEC.fieldOf("beach_biomes").orElse(BEACH_BIOMES_VANILLA.value()).forGetter(overworldRegion -> overworldRegion.beachBiomes.value()),
            OLD_BIOME_LAYOUT_CODEC.fieldOf("peak_biomes").orElse(PEAK_BIOMES_VANILLA.value()).forGetter(overworldRegion -> overworldRegion.peakBiomes.value()),
            OLD_BIOME_LAYOUT_CODEC.fieldOf("peak_biomes_variant").orElse(PEAK_BIOMES_VARIANT_VANILLA.value()).forGetter(overworldRegion -> overworldRegion.peakBiomesVariant.value()),
            OLD_BIOME_LAYOUT_CODEC.fieldOf("slope_biomes").orElse(SLOPE_BIOMES_VANILLA.value()).forGetter(overworldRegion -> overworldRegion.slopeBiomes.value()),
            OLD_BIOME_LAYOUT_CODEC.fieldOf("slope_biomes_variant").orElse(SLOPE_BIOMES_VARIANT_VANILLA.value()).forGetter(overworldRegion -> overworldRegion.slopeBiomesVariant.value()),
            Codec.unboundedMap(ResourceLocation.CODEC.comapFlatMap(resourceLocation -> {
                if (!resourceLocation.getNamespace().equals("minecraft")) {
                    throw new IllegalArgumentException("Only biomes from MC can be used as the swapper's key!!! You put: \"" + resourceLocation.toString() + "\"");
                }
                return DataResult.success(ResourceKey.create(Registries.BIOME, resourceLocation));
            }, ResourceKey::location), CodecUtil.BIOME_CODEC).fieldOf("swapper").forGetter(overworldRegion -> overworldRegion.swapper)
    ).apply(builder, OverworldRegion::fromOldCodec));

    private static OverworldRegion fromOldCodec(int overworldWeight, List<List<ResourceKey<Biome>>> oceans,
                                                List<List<ResourceKey<Biome>>> middleBiomes,
                                                List<List<ResourceKey<Biome>>> middleBiomesVariant,
                                                List<List<ResourceKey<Biome>>> plateauBiomes,
                                                List<List<ResourceKey<Biome>>> plateauBiomesVariant,
                                                List<List<ResourceKey<Biome>>> extremeHills,
                                                List<List<ResourceKey<Biome>>> beachBiomes,
                                                List<List<ResourceKey<Biome>>> peakBiomes,
                                                List<List<ResourceKey<Biome>>> peakBiomesVariant,
                                                List<List<ResourceKey<Biome>>> slopeBiomes,
                                                List<List<ResourceKey<Biome>>> slopeBiomesVariant,
                                                Map<ResourceKey<Biome>, ResourceKey<Biome>> swapper) {
        return new OverworldRegion(overworldWeight,
                checkForMatching(oceans),
                checkForMatching(middleBiomes),
                checkForMatching(middleBiomesVariant),
                checkForMatching(plateauBiomes),
                checkForMatching(plateauBiomesVariant),
                checkForMatching(extremeHills),
                checkForMatching(beachBiomes),
                checkForMatching(peakBiomes),
                checkForMatching(peakBiomesVariant),
                checkForMatching(slopeBiomes),
                checkForMatching(slopeBiomesVariant),
                swapper
        );
    }

    private static Wrapped<List<List<ResourceKey<Biome>>>> checkForMatching(List<List<ResourceKey<Biome>>> val) {
        return checkForMatching(val, BIOME_LAYOUTS);
    }

    private static Function<OverworldRegion, DataResult<OverworldRegion>> verifyRegion() {
        return region1 -> {
            StringBuilder errors = new StringBuilder();

            region1.forEachBiomeSelector(biomeResourceKey -> {
                if (region1.swapper().containsKey(biomeResourceKey)) {
                    errors.append(biomeResourceKey.location()).append(",");
                }
            });

            if (!errors.isEmpty()) {
                return DataResult.error(String.format("Attempting to assign a biome resource key in both the swapper and biome selectors! \n%s", errors.toString()));
            }
            return DataResult.success(region1);
        };
    }

    public static <T> Wrapped<T> checkForMatching(T val, Map<String, Pair<Map<String, String>, Wrapped<T>>> registry) {
        for (Map.Entry<String, Pair<Map<String, String>, Wrapped<T>>> entry : registry.entrySet()) {
            Wrapped<T> second = entry.getValue().getSecond();
            if (second.value().equals(val)) {
                return second;
            }
        }
        return new Wrapped<>(Optional.empty(), val);
    }


    public static final FromFileCodec<OverworldRegion> BIOME_PROVIDER_DATA_FROM_FILE_CODEC = FromFileCodec.create(VERIFYING_CODEC, "regions");


    public static final Map<String, Pair<Map<String, String>, Wrapped<OverworldRegion>>> BIOME_REGIONS = new HashMap<>();


    private static final int OVERWORLD_WEIGHT = 3;

    public static final Map<String, String> COMMENTS = Util.make(new HashMap<>(), map -> {
        map.put("", JanksonUtil.HEADER_OPEN + """
                                
                                
                A region is a unique biome layout comprised of numerous biome selectors for a given type of terrain in an MC world.
                Biome selectors may be inlined or may call a file from "this_file_parent_directory/biome_selectors"
                */""");
        map.put("peak_biomes", PEAK_BIOMES_LAYOUT);
        map.put("peak_biomes_variant", PEAK_BIOMES_VARIANT_LAYOUT);
        map.put("ocean_biomes", OCEANS_BIOMES_LAYOUT_COMMENT);
        map.put("plateau_biomes", PLATEAU_BIOMES_LAYOUT);
        map.put("plateau_biomes_variant", PLATEAU_BIOMES_VARIANT_LAYOUT);
        map.put("middle_biomes", MIDDLE_BIOMES_LAYOUT);
        map.put("middle_biomes_variant", MIDDLE_BIOMES_VARIANT_LAYOUT);
        map.put("shattered_biomes", SHATTERED_BIOMES_LAYOUT);

        map.put("beach_biomes", BEACH_BIOMES_LAYOUT);
        map.put("swapper",
                """
                        Used to swap biomes not found in the biome selectors.
                        Biomes found within the biome selectors, may not be used as the swapped "value" and biomes only from Minecraft may be used as the "key".
                                    
                        "key" = "minecraft:biome_registry_path"
                        "value" = "modid:new_biome_registry_path"
                                        
                        For example:
                        {
                        "key1":"value1",
                        "key2":"value2",
                        "key3":"value3"
                        }
                        """);
        map.put("weight",
                """
                        The weight of this provider/region against all other providers.
                        Higher numbers do NOT increase the provider's size.
                        Weight "0" disables this provider and all its entries.
                        """
        );
    });


    public static final Wrapped<OverworldRegion> REGION_1 = create("region_1",
            new OverworldRegion(OVERWORLD_WEIGHT,
                    OCEANS_VANILLA, MIDDLE_BIOMES_1, MIDDLE_BIOMES_VARIANT_VANILLA,
                    PLATEAU_BIOMES_1, PLATEAU_BIOMES_VARIANT_VANILLA, SHATTERED_BIOMES_VANILLA,
                    BEACH_BIOMES_1, PEAK_BIOMES_1, PEAK_BIOMES_VARIANT_VANILLA, SLOPE_BIOMES_1, SLOPE_BIOMES_VARIANT_VANILLA,
                    Util.make(new IdentityHashMap<>(), map -> {
                        map.put(Biomes.MANGROVE_SWAMP, BYGBiomes.WHITE_MANGROVE_MARSHES);
                        map.put(Biomes.SWAMP, BYGBiomes.CYPRESS_SWAMPLANDS);
                        map.put(Biomes.STONY_SHORE, BYGBiomes.DACITE_SHORE);
                    }))
    );
    public static final Wrapped<OverworldRegion> REGION_2 = create("region_2",
            new OverworldRegion(OVERWORLD_WEIGHT,
                    OCEANS_VANILLA, MIDDLE_BIOMES_2, MIDDLE_BIOMES_VARIANT_VANILLA,
                    PLATEAU_BIOMES_2, PLATEAU_BIOMES_VARIANT_VANILLA, SHATTERED_BIOMES_VANILLA,
                    BEACH_BIOMES_1, PEAK_BIOMES_1, PEAK_BIOMES_VARIANT_VANILLA, SLOPE_BIOMES_1, SLOPE_BIOMES_VARIANT_VANILLA,
                    Util.make(new IdentityHashMap<>(), map -> {
                        map.put(Biomes.SWAMP, BYGBiomes.WHITE_MANGROVE_MARSHES);
                        map.put(Biomes.STONY_SHORE, BYGBiomes.DACITE_SHORE);
                    })));
    public static final Wrapped<OverworldRegion> REGION_3 = create("region_3",
            new OverworldRegion(OVERWORLD_WEIGHT,
                    OCEANS_VANILLA, MIDDLE_BIOMES_3, MIDDLE_BIOMES_VARIANT_VANILLA,
                    PLATEAU_BIOMES_3, PLATEAU_BIOMES_VARIANT_VANILLA, SHATTERED_BIOMES_VANILLA,
                    BEACH_BIOMES_1, PEAK_BIOMES_1, PEAK_BIOMES_VARIANT_VANILLA, SLOPE_BIOMES_1, SLOPE_BIOMES_VARIANT_VANILLA,
                    Util.make(new IdentityHashMap<>(), map -> {
                        map.put(Biomes.MANGROVE_SWAMP, BYGBiomes.WHITE_MANGROVE_MARSHES);
                        map.put(Biomes.SWAMP, BYGBiomes.BAYOU);
                    } ))
    );

    public static final Wrapped<OverworldRegion> RARE_REGION_1 = create("rare_region_1",
            new OverworldRegion(1,
                    OCEANS, MIDDLE_BIOMES_3, MIDDLE_BIOMES_VARIANT_VANILLA,
                    PLATEAU_BIOMES_3, PLATEAU_BIOMES_VARIANT_VANILLA, SHATTERED_BIOMES_VANILLA,
                    BEACH_BIOMES_1, PEAK_BIOMES_1, PEAK_BIOMES_VARIANT_VANILLA, SLOPE_BIOMES_1, SLOPE_BIOMES_VARIANT_VANILLA,
                    Util.make(new IdentityHashMap<>(), map -> {
                        map.put(Biomes.SWAMP, BYGBiomes.CYPRESS_SWAMPLANDS);
                        map.put(Biomes.MANGROVE_SWAMP, BYGBiomes.BAYOU);
                    }))
    );

    public static final List<Wrapped<OverworldRegion>> OVERWORLD_DEFAULTS =
            ImmutableList.of(
                    REGION_1, REGION_2, REGION_3, RARE_REGION_1
            );

    private static Wrapped<OverworldRegion> create(String id, OverworldRegion overworldRegion) {
        return create(id, overworldRegion, COMMENTS);
    }

    private static Wrapped<OverworldRegion> create(String id, OverworldRegion overworldRegion, Map<String, String> comments) {
        Wrapped<OverworldRegion> result = new Wrapped<>(Optional.of(id), overworldRegion);
        BIOME_REGIONS.put(id, Pair.of(comments, result));
        return result;
    }

    public Collection<List<List<ResourceKey<Biome>>>> allBiomeSelectors() {
        return Set.of(this.beachBiomes.value(), this.peakBiomes.value(), this.peakBiomesVariant.value(), this.middleBiomes.value(), this.middleBiomesVariant.value(), this.plateauBiomes.value(), this.plateauBiomesVariant.value(), this.slopeBiomes.value(), this.slopeBiomesVariant.value(), this.oceans.value());
    }

    public void forEachBiomeSelector(Consumer<ResourceKey<Biome>> biome) {
        for (List<List<ResourceKey<Biome>>> biomeSelector : allBiomeSelectors()) {
            for (List<ResourceKey<Biome>> resourceKeys : biomeSelector) {
                for (ResourceKey<Biome> resourceKey : resourceKeys) {
                    biome.accept(resourceKey);
                }
            }
        }
    }
}