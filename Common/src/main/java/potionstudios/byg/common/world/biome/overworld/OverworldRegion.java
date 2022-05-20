package potionstudios.byg.common.world.biome.overworld;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import org.lwjgl.system.CallbackI;
import potionstudios.byg.common.world.biome.BYGBiomes;
import potionstudios.byg.util.codec.CodecUtil;
import potionstudios.byg.util.codec.FromFileCodec;
import potionstudios.byg.util.codec.Wrapped;
import potionstudios.byg.util.jankson.JanksonUtil;

import java.util.*;
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
                              Wrapped<List<List<ResourceKey<Biome>>>> plateauEdgeBiomes,
                              Wrapped<List<List<ResourceKey<Biome>>>> plateauEdgeBiomesVariant,
                              Wrapped<List<List<ResourceKey<Biome>>>> mountainEdgeBiomes,
                              Wrapped<List<List<ResourceKey<Biome>>>> mountainEdgeBiomesVariant,
                              Map<ResourceKey<Biome>, ResourceKey<Biome>> swapper) {
    // encoded as array
    private record BiomeListPair(Wrapped<List<List<ResourceKey<Biome>>>> primary,
                                 Wrapped<List<List<ResourceKey<Biome>>>> variant) {
        private static final Codec<BiomeListPair> CODEC = RecordCodecBuilder.create(builder ->
                builder.group(
                        BIOME_LAYOUT_CODEC.fieldOf("primary").forGetter(BiomeListPair::primary),
                        BIOME_LAYOUT_CODEC.fieldOf("variant").forGetter(BiomeListPair::variant)
                ).apply(builder, BiomeListPair::new));
    }

    public OverworldRegion(int overworldWeight,
                           Wrapped<List<List<ResourceKey<Biome>>>> oceans,
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
        this(overworldWeight, oceans, middleBiomes, middleBiomesVariant, plateauBiomes,
                plateauBiomesVariant, extremeHills, beachBiomes, peakBiomes,
                peakBiomesVariant, slopeBiomes, slopeBiomesVariant,
                PLATEAU_EDGE_BIOMES_VANILLA, PLATEAU_EDGE_BIOMES_VARIANT_VANILLA,
                MOUNTAIN_EDGE_BIOMES_VANILLA, MOUNTAIN_EDGE_BIOMES_VARIANT_VANILLA,
                swapper);
    }

    private OverworldRegion(int overworldWeight,
                            Wrapped<List<List<ResourceKey<Biome>>>> oceans,
                            BiomeListPair middleBiomes, BiomeListPair plateauBiomes,
                            Wrapped<List<List<ResourceKey<Biome>>>> extremeHills,
                            Wrapped<List<List<ResourceKey<Biome>>>> beachBiomes,
                            BiomeListPair peakBiomes, BiomeListPair slopeBiomes,
                            BiomeListPair plateauEdgeBiomes, BiomeListPair mountainEdgeBiomes,
                            Map<ResourceKey<Biome>, ResourceKey<Biome>> swapper) {
        this(overworldWeight, oceans, middleBiomes.primary, middleBiomes.variant,
                plateauBiomes.primary, plateauBiomes.variant, extremeHills, beachBiomes,
                peakBiomes.primary, peakBiomes.variant, slopeBiomes.primary,
                slopeBiomes.variant, plateauEdgeBiomes.primary, plateauEdgeBiomes.variant,
                mountainEdgeBiomes.primary, mountainEdgeBiomes.variant, swapper);
    }

    private static final Function<ResourceLocation, DataResult<ResourceKey<Biome>>> swapperFunc =
            resourceLocation -> {
                if (!resourceLocation.getNamespace().equals("minecraft")) {
                    throw new IllegalArgumentException("Only biomes from MC can be used as the swapper's key!!! You put: \"" + resourceLocation.toString() + "\"");
                }
                return DataResult.success(ResourceKey.create(Registry.BIOME_REGISTRY, resourceLocation));
            };
    public static final Codec<OverworldRegion> CODEC_V2 = RecordCodecBuilder.create(builder ->
            builder.group(Codec.INT.fieldOf("weight").forGetter(OverworldRegion::overworldWeight),
                    BIOME_LAYOUT_CODEC.fieldOf("oceans").forGetter(OverworldRegion::oceans),
                    BiomeListPair.CODEC.fieldOf("middle_biomes").forGetter(reg ->
                            new BiomeListPair(reg.middleBiomes, reg.middleBiomesVariant)),
                    BiomeListPair.CODEC.fieldOf("plateau_biomes").forGetter(reg ->
                            new BiomeListPair(reg.plateauBiomes, reg.plateauBiomesVariant)),
                    BIOME_LAYOUT_CODEC.fieldOf("shattered_biomes").forGetter(OverworldRegion::extremeHills),
                    BIOME_LAYOUT_CODEC.fieldOf("beach_biomes").forGetter(OverworldRegion::beachBiomes),
                    BiomeListPair.CODEC.fieldOf("peak_biomes").forGetter(reg ->
                            new BiomeListPair(reg.peakBiomes, reg.peakBiomesVariant)),
                    BiomeListPair.CODEC.fieldOf("slope_biomes").forGetter(reg ->
                            new BiomeListPair(reg.slopeBiomes, reg.slopeBiomesVariant)),
                    BiomeListPair.CODEC.fieldOf("plateau_edge_biomes").forGetter(reg ->
                            new BiomeListPair(reg.plateauEdgeBiomes, reg.plateauEdgeBiomesVariant)),
                    BiomeListPair.CODEC.fieldOf("mountain_edge_biomes").forGetter(reg ->
                            new BiomeListPair(reg.mountainEdgeBiomes, reg.mountainEdgeBiomesVariant)),
                    Codec.unboundedMap(ResourceLocation.CODEC.comapFlatMap(swapperFunc, ResourceKey::location),
                            CodecUtil.BIOME_CODEC).fieldOf("swapper").forGetter(OverworldRegion::swapper)
            ).apply(builder, OverworldRegion::new));

    public static final Codec<OverworldRegion> CODEC_V1 = RecordCodecBuilder.create(builder ->
            builder.group(Codec.INT.fieldOf("weight").forGetter(OverworldRegion::overworldWeight),
                    BIOME_LAYOUT_CODEC.fieldOf("oceans").forGetter(OverworldRegion::oceans),
                    BIOME_LAYOUT_CODEC.fieldOf("middle_biomes").forGetter(OverworldRegion::middleBiomes),
                    BIOME_LAYOUT_CODEC.fieldOf("middle_biomes_variant").forGetter(OverworldRegion::middleBiomesVariant),
                    BIOME_LAYOUT_CODEC.fieldOf("plateau_biomes").forGetter(OverworldRegion::plateauBiomes),
                    BIOME_LAYOUT_CODEC.fieldOf("plateau_biomes_variant").forGetter(OverworldRegion::plateauBiomesVariant),
                    BIOME_LAYOUT_CODEC.fieldOf("shattered_biomes").forGetter(OverworldRegion::extremeHills),
                    BIOME_LAYOUT_CODEC.fieldOf("beach_biomes").orElse(BEACH_BIOMES_VANILLA).forGetter(OverworldRegion::beachBiomes),
                    BIOME_LAYOUT_CODEC.fieldOf("peak_biomes").orElse(PEAK_BIOMES_VANILLA).forGetter(OverworldRegion::peakBiomes),
                    BIOME_LAYOUT_CODEC.fieldOf("peak_biomes_variant").orElse(PEAK_BIOMES_VARIANT_VANILLA).forGetter(OverworldRegion::peakBiomesVariant),
                    BIOME_LAYOUT_CODEC.fieldOf("slope_biomes").orElse(SLOPE_BIOMES_VANILLA).forGetter(OverworldRegion::slopeBiomes),
                    BIOME_LAYOUT_CODEC.fieldOf("slope_biomes_variant").orElse(SLOPE_BIOMES_VARIANT_VANILLA).forGetter(OverworldRegion::slopeBiomesVariant),
                    Codec.unboundedMap(ResourceLocation.CODEC.comapFlatMap(swapperFunc, ResourceKey::location),
                            CodecUtil.BIOME_CODEC).fieldOf("swapper").forGetter(OverworldRegion::swapper)
            ).apply(builder, OverworldRegion::new));

    public static final Codec<OverworldRegion> OLD_CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(Codec.INT.fieldOf("weight").forGetter(OverworldRegion::overworldWeight),
                OLD_BIOME_LAYOUT_CODEC.fieldOf("oceans").forGetter(overworldRegion -> overworldRegion.oceans.value()),
                OLD_BIOME_LAYOUT_CODEC.fieldOf("middle_biomes").forGetter(overworldRegion -> overworldRegion.middleBiomes.value()),
                OLD_BIOME_LAYOUT_CODEC.fieldOf("middle_biomes_variant").forGetter(overworldRegion -> overworldRegion.middleBiomesVariant.value()),
                OLD_BIOME_LAYOUT_CODEC.fieldOf("plateau_biomes").forGetter(overworldRegion -> overworldRegion.plateauBiomes.value()),
                OLD_BIOME_LAYOUT_CODEC.fieldOf("plateau_biomes_variant").forGetter(overworldRegion -> overworldRegion.plateauBiomesVariant.value()),
                OLD_BIOME_LAYOUT_CODEC.fieldOf("shattered_biomes").forGetter(overworldRegion -> overworldRegion.extremeHills.value()),
                OLD_BIOME_LAYOUT_CODEC.fieldOf("beach_biomes").orElse(BEACH_BIOMES_VANILLA.value()).forGetter(overworldRegion -> overworldRegion.beachBiomes.value()),
                OLD_BIOME_LAYOUT_CODEC.fieldOf("peak_biomes").orElse(PEAK_BIOMES_VANILLA.value()).forGetter(overworldRegion -> (overworldRegion.peakBiomes.value())),
                OLD_BIOME_LAYOUT_CODEC.fieldOf("peak_biomes_variant").orElse(PEAK_BIOMES_VARIANT_VANILLA.value()).forGetter(overworldRegion -> (overworldRegion.peakBiomesVariant.value())),
                OLD_BIOME_LAYOUT_CODEC.fieldOf("slope_biomes").orElse(SLOPE_BIOMES_VANILLA.value()).forGetter(overworldRegion -> (overworldRegion.slopeBiomes.value())),
                OLD_BIOME_LAYOUT_CODEC.fieldOf("slope_biomes_variant").orElse(SLOPE_BIOMES_VARIANT_VANILLA.value()).forGetter(overworldRegion -> (overworldRegion.slopeBiomesVariant.value())),
                Codec.unboundedMap(ResourceLocation.CODEC.comapFlatMap(resourceLocation -> {
                    if (!resourceLocation.getNamespace().equals("minecraft")) {
                        throw new IllegalArgumentException("Only biomes from MC can be used as the swapper's key!!! You put: \"" + resourceLocation.toString() + "\"");
                    }
                    return DataResult.success(ResourceKey.create(Registry.BIOME_REGISTRY, resourceLocation));
                }, ResourceKey::location), CodecUtil.BIOME_CODEC).fieldOf("swapper").forGetter(overworldRegion -> overworldRegion.swapper)
        ).apply(builder, OverworldRegion::fromOldCodec);
    });

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
                checkForMatching(PLATEAU_EDGE_BIOMES_VANILLA.value()),
                checkForMatching(PLATEAU_EDGE_BIOMES_VARIANT_VANILLA.value()),
                checkForMatching(MOUNTAIN_EDGE_BIOMES_VANILLA.value()),
                checkForMatching(MOUNTAIN_EDGE_BIOMES_VARIANT_VANILLA.value()),
                swapper
        );
    }

    private static Wrapped<List<List<ResourceKey<Biome>>>> checkForMatching(List<List<ResourceKey<Biome>>> val) {
        return checkForMatching(val, BIOME_LAYOUTS);
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


    public static final FromFileCodec<OverworldRegion> BIOME_PROVIDER_DATA_FROM_FILE_CODEC = FromFileCodec.create(CODEC_V2, "regions");

    public static final Map<String, Pair<Map<String, String>, Wrapped<OverworldRegion>>> BIOME_REGIONS = new HashMap<>();


    private static final int OVERWORLD_WEIGHT = 6;

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
                    OCEANS, MIDDLE_BIOMES_1, MIDDLE_BIOMES_VARIANT_VANILLA,
                    PLATEAU_BIOMES_1, PLATEAU_BIOMES_VARIANT_VANILLA, SHATTERED_BIOMES_VANILLA,
                    BEACH_BIOMES_1, PEAK_BIOMES_1, PEAK_BIOMES_VARIANT_VANILLA, SLOPE_BIOMES_VANILLA, SLOPE_BIOMES_VARIANT_VANILLA,
                    PLATEAU_EDGE_BIOMES_VANILLA, PLATEAU_EDGE_BIOMES_VARIANT_VANILLA,
                    MOUNTAIN_EDGE_BIOMES_VANILLA, MOUNTAIN_EDGE_BIOMES_VARIANT_VANILLA,
                    Util.make(new IdentityHashMap<>(), map -> map.put(Biomes.SWAMP, BYGBiomes.CYPRESS_SWAMPLANDS)))
    );
    public static final Wrapped<OverworldRegion> REGION_2 = create("region_2",
            new OverworldRegion(OVERWORLD_WEIGHT,
                    OCEANS_VANILLA, MIDDLE_BIOMES_2, MIDDLE_BIOMES_VARIANT_VANILLA,
                    PLATEAU_BIOMES_2, PLATEAU_BIOMES_VARIANT_VANILLA, SHATTERED_BIOMES_VANILLA,
                    BEACH_BIOMES_1, PEAK_BIOMES_1, PEAK_BIOMES_VARIANT_VANILLA, SLOPE_BIOMES_VANILLA, SLOPE_BIOMES_VARIANT_VANILLA,
                    PLATEAU_EDGE_BIOMES_VANILLA, PLATEAU_EDGE_BIOMES_VARIANT_VANILLA,
                    MOUNTAIN_EDGE_BIOMES_VANILLA, MOUNTAIN_EDGE_BIOMES_VARIANT_VANILLA,
                    Util.make(new IdentityHashMap<>(), map -> map.put(Biomes.SWAMP, BYGBiomes.WHITE_MANGROVE_MARSHES)))
    );
    public static final Wrapped<OverworldRegion> REGION_3 = create("region_3",
            new OverworldRegion(OVERWORLD_WEIGHT,
                    OCEANS_VANILLA, MIDDLE_BIOMES_3, MIDDLE_BIOMES_VARIANT_VANILLA,
                    PLATEAU_BIOMES_3, PLATEAU_BIOMES_VARIANT_VANILLA, SHATTERED_BIOMES_VANILLA,
                    BEACH_BIOMES_1, PEAK_BIOMES_1, PEAK_BIOMES_VARIANT_VANILLA, SLOPE_BIOMES_VANILLA, SLOPE_BIOMES_VARIANT_VANILLA,
                    PLATEAU_EDGE_BIOMES_VANILLA, PLATEAU_EDGE_BIOMES_VARIANT_VANILLA,
                    MOUNTAIN_EDGE_BIOMES_VANILLA, MOUNTAIN_EDGE_BIOMES_VARIANT_VANILLA,
                    Util.make(new IdentityHashMap<>(), map -> map.put(Biomes.SWAMP, BYGBiomes.BAYOU)))
    );

    public static final List<Wrapped<OverworldRegion>> OVERWORLD_DEFAULTS =
            ImmutableList.of(
                    REGION_1, REGION_2, REGION_3
            );

    private static Wrapped<OverworldRegion> create(String id, OverworldRegion overworldRegion) {
        return create(id, overworldRegion, COMMENTS);
    }

    private static Wrapped<OverworldRegion> create(String id, OverworldRegion overworldRegion, Map<String, String> comments) {
        Wrapped<OverworldRegion> result = new Wrapped<>(Optional.of(id), overworldRegion);
        BIOME_REGIONS.put(id, Pair.of(comments, result));
        return result;
    }
}