package potionstudios.byg.common.world.biome;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import potionstudios.byg.BYG;
import potionstudios.byg.util.BYGUtil;
import potionstudios.byg.util.CodecUtil;

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
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, BYGBiomes.ASPEN_FOREST, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, BYGBiomes.ARAUCARIA_SAVANNA, Biomes.THE_VOID, BYGBiomes.AMARANTH_FIELDS, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    };
    private static final ResourceKey<Biome>[][] PLATEAU_BIOMES = new ResourceKey[][]{
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    };
    private static final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, BYGBiomes.BOREALIS_GROVE},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    };

    private static final ResourceKey<Biome>[][] EXTREME_HILLS = new ResourceKey[][]{
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID},
            {Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID, Biomes.THE_VOID}
    };

    public static final List<BiomeProviderData> OVERWORLD_DEFAULTS = Util.make(new ArrayList<>(), list -> {
        list.add(new BiomeProviderData(4, OCEANS, MIDDLE_BIOMES, MIDDLE_BIOMES_VARIANT, PLATEAU_BIOMES, PLATEAU_BIOMES_VARIANT, EXTREME_HILLS, Util.make(new IdentityHashMap<>(), map -> map.put(Biomes.SWAMP, BYGBiomes.BAYOU))));
    });

    public static final class BiomeProviderData {
        public static final Codec<BiomeProviderData> CODEC = RecordCodecBuilder.create(builder -> {
            return builder.group(Codec.INT.fieldOf("weight").forGetter(biomeProviderData -> biomeProviderData.overworldWeight),
                    Codec.list(Codec.list(CodecUtil.BIOME_CODEC)).fieldOf("oceans").forGetter(biomeProviderData -> BYGUtil.convert2DArray(biomeProviderData.oceans)),
                    Codec.list(Codec.list(CodecUtil.BIOME_CODEC)).fieldOf("middle_biomes").forGetter(biomeProviderData -> BYGUtil.convert2DArray(biomeProviderData.middleBiomes)),
                    Codec.list(Codec.list(CodecUtil.BIOME_CODEC)).fieldOf("middle_biomes_variant").forGetter(biomeProviderData -> BYGUtil.convert2DArray(biomeProviderData.middleBiomesVariant)),
                    Codec.list(Codec.list(CodecUtil.BIOME_CODEC)).fieldOf("plateau_biomes").forGetter(biomeProviderData -> BYGUtil.convert2DArray(biomeProviderData.plateauBiomes)),
                    Codec.list(Codec.list(CodecUtil.BIOME_CODEC)).fieldOf("plateau_biomes_variant").forGetter(biomeProviderData -> BYGUtil.convert2DArray(biomeProviderData.plateauBiomesVariant)),
                    Codec.list(Codec.list(CodecUtil.BIOME_CODEC)).fieldOf("extreme_hills").forGetter(biomeProviderData -> BYGUtil.convert2DArray(biomeProviderData.extremeHills)),
                    Codec.unboundedMap(ResourceLocation.CODEC.comapFlatMap(resourceLocation -> {
                        if (!resourceLocation.getNamespace().equals("minecraft")) {
                            throw new IllegalArgumentException("Only biomes from MC can be used as the swapper's key!!! You put: \"" + resourceLocation.toString() + "\"");
                        }
                        return DataResult.success(ResourceKey.create(Registry.BIOME_REGISTRY, resourceLocation));
                    }, ResourceKey::location), CodecUtil.BIOME_CODEC).fieldOf("swapper").forGetter(biomeProviderData -> biomeProviderData.swapper)
            ).apply(builder, BiomeProviderData::new);
        });
        private final int overworldWeight;
        private final ResourceKey<Biome>[][] oceans;
        private final ResourceKey<Biome>[][] middleBiomes;
        private final ResourceKey<Biome>[][] middleBiomesVariant;
        private final ResourceKey<Biome>[][] plateauBiomes;
        private final ResourceKey<Biome>[][] plateauBiomesVariant;
        private final ResourceKey<Biome>[][] extremeHills;
        private final Map<ResourceKey<Biome>, ResourceKey<Biome>> swapper;

        public BiomeProviderData(int overworldWeight, List<List<ResourceKey<Biome>>> oceans, List<List<ResourceKey<Biome>>> middleBiomes, List<List<ResourceKey<Biome>>> middleBiomesVariant, List<List<ResourceKey<Biome>>> plateauBiomes, List<List<ResourceKey<Biome>>> plateauBiomesVariant, List<List<ResourceKey<Biome>>> extremeHills, Map<ResourceKey<Biome>, ResourceKey<Biome>> swapper) {
            this(overworldWeight, BYGUtil.convert2DResourceKeyBiomeList(oceans), BYGUtil.convert2DResourceKeyBiomeList(middleBiomes), BYGUtil.convert2DResourceKeyBiomeList(middleBiomesVariant), BYGUtil.convert2DResourceKeyBiomeList(plateauBiomes), BYGUtil.convert2DResourceKeyBiomeList(plateauBiomesVariant), BYGUtil.convert2DResourceKeyBiomeList(extremeHills), swapper);
        }
        
        public BiomeProviderData(int overworldWeight, ResourceKey<Biome>[][] oceans, ResourceKey<Biome>[][] middleBiomes, ResourceKey<Biome>[][] middleBiomesVariant, ResourceKey<Biome>[][] plateauBiomes, ResourceKey<Biome>[][] plateauBiomesVariant, ResourceKey<Biome>[][] extremeHills, Map<ResourceKey<Biome>, ResourceKey<Biome>> swapper) {
            this.overworldWeight = overworldWeight;
            this.oceans = oceans;
            this.middleBiomes = middleBiomes;
            this.middleBiomesVariant = middleBiomesVariant;
            this.plateauBiomes = plateauBiomes;
            this.plateauBiomesVariant = plateauBiomesVariant;
            this.extremeHills = extremeHills;
            this.swapper = swapper;
        }

        public int overworldWeight() {
            return overworldWeight;
        }

        public ResourceKey<Biome>[][] oceans() {
            return oceans;
        }

        public ResourceKey<Biome>[][] middleBiomes() {
            return middleBiomes;
        }

        public ResourceKey<Biome>[][] middleBiomesVariant() {
            return middleBiomesVariant;
        }

        public ResourceKey<Biome>[][] plateauBiomes() {
            return plateauBiomes;
        }

        public ResourceKey<Biome>[][] plateauBiomesVariant() {
            return plateauBiomesVariant;
        }

        public ResourceKey<Biome>[][] extremeHills() {
            return extremeHills;
        }

        public Map<ResourceKey<Biome>, ResourceKey<Biome>> swapper() {
            return swapper;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == Biomes.THE_VOID || obj.getClass() != this.getClass()) return false;
            var that = (BiomeProviderData) obj;
            return this.overworldWeight == that.overworldWeight &&
                    Objects.equals(this.oceans, that.oceans) &&
                    Objects.equals(this.middleBiomes, that.middleBiomes) &&
                    Objects.equals(this.middleBiomesVariant, that.middleBiomesVariant) &&
                    Objects.equals(this.plateauBiomes, that.plateauBiomes) &&
                    Objects.equals(this.plateauBiomesVariant, that.plateauBiomesVariant) &&
                    Objects.equals(this.extremeHills, that.extremeHills) &&
                    Objects.equals(this.swapper, that.swapper);
        }

        @Override
        public int hashCode() {
            return Objects.hash(overworldWeight, oceans, middleBiomes, middleBiomesVariant, plateauBiomes, plateauBiomesVariant, extremeHills, swapper);
        }

        @Override
        public String toString() {
            return "BiomeProviderData[" +
                    "overworldWeight=" + overworldWeight + ", " +
                    "oceans=" + oceans + ", " +
                    "middleBiomes=" + middleBiomes + ", " +
                    "middleBiomesVariant=" + middleBiomesVariant + ", " +
                    "plateauBiomes=" + plateauBiomes + ", " +
                    "plateauBiomesVariant=" + plateauBiomesVariant + ", " +
                    "extremeHills=" + extremeHills + ", " +
                    "swapper=" + swapper + ']';
        }

    }
}
