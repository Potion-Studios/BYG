package potionstudios.byg.world.biome;

import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import org.apache.commons.lang3.mutable.MutableInt;
import potionstudios.byg.BYG;
import potionstudios.byg.mixin.access.OverworldBiomeBuilderAccess;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static potionstudios.byg.util.BYGUtil.print2DResourceKeyArray;

public class BYGRegion extends Region {
    private static int count = 0;

    private final OverworldBiomeBuilder overworldBiomeBuilder = new OverworldBiomeBuilder();
    private final Set<ResourceKey<Biome>> bygKeys = new ObjectOpenHashSet<>();
    private final Map<ResourceKey<Biome>, ResourceKey<Biome>> swapper;
    private final int configIDX;

    public BYGRegion(int overworldWeight, ResourceKey<Biome>[][] oceans, ResourceKey<Biome>[][] middleBiomes, ResourceKey<Biome>[][] middleBiomesVariant, ResourceKey<Biome>[][] plateauBiomes, ResourceKey<Biome>[][] plateauBiomesVariant, ResourceKey<Biome>[][] shatteredBiomes, Map<ResourceKey<Biome>, ResourceKey<Biome>> swapper) {
        super(BYG.createLocation("region_" + count++), RegionType.OVERWORLD, overworldWeight);
        this.swapper = swapper;
        this.configIDX = count;
        Predicate<ResourceKey<Biome>> noVoidBiomes = biomeResourceKey -> biomeResourceKey != Biomes.THE_VOID;
        oceans = filter("oceans", oceans, noVoidBiomes, true);
        middleBiomes = filter("middle_biomes", middleBiomes, noVoidBiomes, true);
        middleBiomesVariant = filter("middle_biomes_variant", middleBiomesVariant, noVoidBiomes, false);
        plateauBiomes = filter("plateau_biomes", plateauBiomes, noVoidBiomes, true);
        plateauBiomesVariant = filter("plateau_biomes_variant", plateauBiomesVariant, noVoidBiomes, false);
        shatteredBiomes = filter("shattered_biomes", shatteredBiomes, noVoidBiomes, false);

        OverworldBiomeBuilderAccess overworldBiomeBuilderAccess = (OverworldBiomeBuilderAccess) (Object) overworldBiomeBuilder;
        overworldBiomeBuilderAccess.byg_setOCEANS(oceans);
        overworldBiomeBuilderAccess.byg_setMIDDLE_BIOMES(middleBiomes);
        overworldBiomeBuilderAccess.byg_setMIDDLE_BIOMES_VARIANT(middleBiomesVariant);
        overworldBiomeBuilderAccess.byg_setPLATEAU_BIOMES(plateauBiomes);
        overworldBiomeBuilderAccess.byg_setPLATEAU_BIOMES_VARIANT(plateauBiomesVariant);
        overworldBiomeBuilderAccess.byg_setSHATTERED_BIOMES(shatteredBiomes);
        dumpArrays((biomeResourceKey -> {
            if (biomeResourceKey != null && biomeResourceKey != Biomes.THE_VOID) {
                bygKeys.add(biomeResourceKey);
                if (swapper.containsValue(biomeResourceKey)) {
                    throw new IllegalArgumentException("Swapper cannot contain elements found in the temperature arrays.");
                }
            }
        }), oceans, middleBiomes, middleBiomesVariant, plateauBiomes, plateauBiomesVariant, shatteredBiomes);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        MutableInt totalPairs = new MutableInt();
        MutableInt bygMapperAccepted = new MutableInt(0);
        ((OverworldBiomeBuilderAccess) (Object) this.overworldBiomeBuilder).byg_invokeAddBiomes((parameterPointResourceKeyPair -> {
            ResourceKey<Biome> biomeKey = parameterPointResourceKeyPair.getSecond();
            if (!registry.containsKey(biomeKey)) {
                throw new IllegalArgumentException(String.format("\"%s\" is not a valid biome in the world registry!", biomeKey.location().toString()));
            }
            totalPairs.increment();
            boolean mapped = false;
            boolean alreadyMappedOutsideSwapper = false;
            if (this.bygKeys.contains(biomeKey)) {
                mapper.accept(new Pair<>(parameterPointResourceKeyPair.getFirst(), biomeKey));
                bygMapperAccepted.increment();
                alreadyMappedOutsideSwapper = true;
                mapped = true;
            }

            if (this.swapper.containsKey(biomeKey)) {
                if (alreadyMappedOutsideSwapper) {
                    throw new UnsupportedOperationException("Attempting to assign a biome resource key in both the swapper and byg keys");
                }
                mapper.accept(new Pair<>(parameterPointResourceKeyPair.getFirst(), this.swapper.get(biomeKey)));
                bygMapperAccepted.increment();
                mapped = true;
            }

            if (!mapped) {
                mapper.accept(parameterPointResourceKeyPair);
                bygMapperAccepted.increment();
            }
        }));
        int totalPairsValue = totalPairs.intValue();
        int mapperAcceptValue = bygMapperAccepted.intValue();
        boolean sanityCheck = totalPairsValue != mapperAcceptValue;
        if (sanityCheck) {
            throw new UnsupportedOperationException(String.format("Not all biome parameter points were accepted for BYG biome region: %s. %s/%s were accepted.", this.getName().toString(), totalPairsValue, mapperAcceptValue));
        }

        BYG.LOGGER.info(bygMapperAccepted.getValue() + " biome parameter points were mapped for BYG region: " + this.getName().toString());
    }

    @SafeVarargs
    private static void dumpArrays(Consumer<ResourceKey<Biome>> biomeConsumer, ResourceKey<Biome>[][]... resourceKeys) {
        for (ResourceKey<Biome>[][] resourceKey : resourceKeys) {
            for (ResourceKey<Biome>[] keys : resourceKey) {
                for (ResourceKey<Biome> key : keys) {
                    biomeConsumer.accept(key);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public ResourceKey<Biome>[][] filter(String configKey, ResourceKey<Biome>[][] biomeArray, Predicate<ResourceKey<Biome>> filter, boolean throwsException) {
        return Arrays.stream(biomeArray).map(resourceKeys -> Arrays.stream(resourceKeys).map(key -> !filter.test(key) ? null : key).peek(biomeResourceKey -> {
            if (biomeResourceKey == null && throwsException) {
                String error = String.format("\"%s\" is not an allowed entry, specify a valid biome key!\nBYG Region: \"%s\" failed in biome array: \"%s\" in region %s.\nCurrent value:\n%s", Biomes.THE_VOID.location().toString(), this.getName().toString(), configKey, this.configIDX, print2DResourceKeyArray(biomeArray));
                throw new IllegalArgumentException(error);
            }
        }).toList().toArray(ResourceKey[]::new)).toArray(ResourceKey[][]::new);
    }
}
