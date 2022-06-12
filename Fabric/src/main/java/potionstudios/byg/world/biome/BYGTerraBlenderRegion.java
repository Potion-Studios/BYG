package potionstudios.byg.world.biome;

import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import org.apache.commons.lang3.mutable.MutableInt;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.overworld.BYGOverworldBiomeBuilder;
import potionstudios.byg.common.world.biome.overworld.OverworldRegion;
import potionstudios.byg.mixin.access.OverworldBiomeBuilderAccess;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static potionstudios.byg.util.BYGRegionUtils.dumpArrays;
import static potionstudios.byg.util.BYGRegionUtils.filter;
import static potionstudios.byg.util.BYGUtil._2DResourceKeyArrayTo2DList;
import static potionstudios.byg.util.BYGUtil.mapOfWrappedListToMapOf2DArray;

public class BYGTerraBlenderRegion extends Region {
    private static int count = 0;

    private final Set<ResourceKey<Biome>> bygKeys = new ObjectOpenHashSet<>();
    private final Map<ResourceKey<Biome>, ResourceKey<Biome>> swapper;
    private final Map<ResourceKey<Biome>, ResourceKey<Biome>[][]> splitter;

    private final BYGOverworldBiomeBuilder bygOverworldBiomeBuilder;

    public BYGTerraBlenderRegion(OverworldRegion overworldRegion) {
        this(overworldRegion.overworldWeight(),
                _2DResourceKeyArrayTo2DList(overworldRegion.oceans().value()),
                _2DResourceKeyArrayTo2DList(overworldRegion.middleBiomes().value()),
                _2DResourceKeyArrayTo2DList(overworldRegion.middleBiomesVariant().value()),
                _2DResourceKeyArrayTo2DList(overworldRegion.plateauBiomes().value()),
                _2DResourceKeyArrayTo2DList(overworldRegion.plateauBiomesVariant().value()),
                _2DResourceKeyArrayTo2DList(overworldRegion.extremeHills().value()),
                _2DResourceKeyArrayTo2DList(overworldRegion.beachBiomes().value()),
                _2DResourceKeyArrayTo2DList(overworldRegion.peakBiomes().value()),
                _2DResourceKeyArrayTo2DList(overworldRegion.peakBiomesVariant().value()),
                _2DResourceKeyArrayTo2DList(overworldRegion.slopeBiomes().value()),
                _2DResourceKeyArrayTo2DList(overworldRegion.slopeBiomesVariant().value()),
                overworldRegion.swapper(),
                mapOfWrappedListToMapOf2DArray(overworldRegion.splitter()));
    }

    public BYGTerraBlenderRegion(int overworldWeight,
                                 ResourceKey<Biome>[][] oceans, ResourceKey<Biome>[][] middleBiomes,
                                 ResourceKey<Biome>[][] middleBiomesVariant, ResourceKey<Biome>[][] plateauBiomes,
                                 ResourceKey<Biome>[][] plateauBiomesVariant, ResourceKey<Biome>[][] shatteredBiomes,
                                 ResourceKey<Biome>[][] beachBiomes, ResourceKey<Biome>[][] peakBiomes,
                                 ResourceKey<Biome>[][] peakBiomesVariant, ResourceKey<Biome>[][] slopeBiomes, ResourceKey<Biome>[][] slopeBiomesVariant,
                                 Map<ResourceKey<Biome>, ResourceKey<Biome>> swapper,
                                 Map<ResourceKey<Biome>, ResourceKey<Biome>[][]> splitter) {
        super(BYG.createLocation("region_" + count++), RegionType.OVERWORLD, overworldWeight);
        this.swapper = swapper;
        this.splitter = splitter;
        Predicate<ResourceKey<Biome>> noVoidBiomes = biomeResourceKey -> biomeResourceKey != Biomes.THE_VOID;
        oceans = filter("oceans", this.getName(), count, oceans, noVoidBiomes, true);
        middleBiomes = filter("middle_biomes", this.getName(), count, middleBiomes, noVoidBiomes, true);
        middleBiomesVariant = filter("middle_biomes_variant", this.getName(), count, middleBiomesVariant, noVoidBiomes, false);
        plateauBiomes = filter("plateau_biomes", this.getName(), count, plateauBiomes, noVoidBiomes, true);
        plateauBiomesVariant = filter("plateau_biomes_variant", this.getName(), count, plateauBiomesVariant, noVoidBiomes, false);
        shatteredBiomes = filter("shattered_biomes", this.getName(), count, shatteredBiomes, noVoidBiomes, false);
        beachBiomes = filter("beach_biomes", this.getName(), count, beachBiomes, noVoidBiomes, true);
        peakBiomes = filter("peak_biomes", this.getName(), count, peakBiomes, noVoidBiomes, true);
        peakBiomesVariant = filter("peak_biomes_variant", this.getName(), count, peakBiomesVariant, noVoidBiomes, false);
        slopeBiomes = filter("slope_biomes", this.getName(), count, slopeBiomes, noVoidBiomes, true);
        slopeBiomesVariant = filter("slope_biomes_variant", this.getName(), count, slopeBiomesVariant, noVoidBiomes, false);

        this.bygOverworldBiomeBuilder = new BYGOverworldBiomeBuilder(
                oceans, middleBiomes, middleBiomesVariant,
                plateauBiomes, plateauBiomesVariant, shatteredBiomes,
                beachBiomes, peakBiomes, peakBiomesVariant, slopeBiomes, slopeBiomesVariant
        );

        dumpArrays((biomeResourceKey -> {
            if (biomeResourceKey != null) {
                bygKeys.add(biomeResourceKey);
                if (swapper.containsKey(biomeResourceKey)) {
                    throw new IllegalArgumentException("Swapper cannot swap elements found in the temperature arrays.");
                }
                if (splitter.containsKey(biomeResourceKey)) {
                    throw new IllegalArgumentException("Splitter cannot split elements found in the temperature arrays.");
                }
            }
        }), oceans, middleBiomes, middleBiomesVariant, plateauBiomes, plateauBiomesVariant, shatteredBiomes, beachBiomes, 
                peakBiomes, peakBiomesVariant, slopeBiomes, slopeBiomesVariant);
        for(ResourceKey<Biome>[][] array : splitter.values())
        {
            dumpArrays(biomeResourceKey -> {
                bygKeys.add(biomeResourceKey);
                if(swapper.containsKey(biomeResourceKey)) {
                    throw new IllegalArgumentException("Swapper cannot swap elements found in splitters.");
                }
                if(splitter.containsKey(biomeResourceKey)) {
                    throw new IllegalArgumentException("Splitter cannot split biomes from its own temperature arrays.");
                }
            });
        }
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        MutableInt totalPairs = new MutableInt();
        MutableInt bygMapperAccepted = new MutableInt(0);
        OverworldBiomeBuilderAccess access = (OverworldBiomeBuilderAccess) this.bygOverworldBiomeBuilder;
        ((OverworldBiomeBuilderAccess) this.bygOverworldBiomeBuilder).byg_invokeAddBiomes((parameterPointResourceKeyPair -> {
            ResourceKey<Biome> biomeKey = parameterPointResourceKeyPair.getSecond();
            if (!registry.containsKey(biomeKey)) {
                throw new IllegalArgumentException(String.format("\"%s\" is not a valid biome in the world registry!", biomeKey.location().toString()));
            }
            totalPairs.increment();
            boolean mapped = false;
            boolean alreadyMappedOutsideSwapper = false;
            boolean alreadyMappedInSplitter = false;
            if (this.bygKeys.contains(biomeKey)) {
                mapper.accept(new Pair<>(parameterPointResourceKeyPair.getFirst(), biomeKey));
                bygMapperAccepted.increment();
                alreadyMappedOutsideSwapper = true;
                mapped = true;
            }
            if (this.splitter.containsKey(biomeKey)) {
                if (alreadyMappedOutsideSwapper) {
                    throw new UnsupportedOperationException(String.format("Attempting to assign a biome resource key in both the splitter and biome selectors. We're crashing your game to let you know that \"%s\" was put in the biome selectors but will always be swapped by \"%s\" due to the swapper. In region \"%s\".", biomeKey.location().toString(), this.swapper.get(biomeKey).location().toString(), this.getName().toString()));
                }
                ResourceKey<Biome>[][] array = splitter.get(biomeKey);
                Climate.ParameterPoint sourceParam = parameterPointResourceKeyPair.getFirst();
                if(!sourceParam.temperature().equals(access.getFullRange()) &&
                !sourceParam.humidity().equals(access.getFullRange())) {
                    throw new IllegalArgumentException(String.format("Biome \"%s\" doesn't cover the full temperature/humidity range and therefore cannot be put in the splitter.\n" +
                            "Temperature range: %s, Humidity range: %s", biomeKey.location().toString(), sourceParam.temperature().toString(), sourceParam.humidity().toString()));
                }
                for(int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array[i].length; j++)
                    {
                        ResourceKey<Biome> resultKey = array[i][j];
                        if(resultKey.equals(Biomes.THE_VOID))
                            resultKey = biomeKey;
                        mapper.accept(new Pair<>(new Climate.ParameterPoint(
                                access.getTemperatures()[i],
                                access.getHumidities()[j],
                                sourceParam.continentalness(),
                                sourceParam.erosion(),
                                sourceParam.depth(),
                                sourceParam.weirdness(),
                                sourceParam.offset()
                        ), resultKey));
                    }
                }
                bygMapperAccepted.increment();
                alreadyMappedInSplitter = true;
                mapped = true;
            }
            if (this.swapper.containsKey(biomeKey)) {
                if (alreadyMappedOutsideSwapper) {
                    throw new UnsupportedOperationException(String.format("Attempting to assign a biome resource key in both the swapper and biome selectors. We're crashing your game to let you know that \"%s\" was put in the biome selectors but will always be swapped by \"%s\" due to the swapper. In region \"%s\".", biomeKey.location().toString(), this.swapper.get(biomeKey).location().toString(), this.getName().toString()));
                }
                if (alreadyMappedInSplitter) {
                    throw new UnsupportedOperationException(String.format("Attempting to assign a biome resource key in both the swapper and the splitter. We're crashing your game to let you know that \"%s\" was put in the splitter. In region \"%s\".", biomeKey.location().toString(), this.getName().toString()));
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
            throw new UnsupportedOperationException(String.format("Not all biome parameter points were accepted for BYG Terrablender biome region: %s. %s/%s were accepted.", this.getName().toString(), totalPairsValue, mapperAcceptValue));
        }

        BYG.LOGGER.info(bygMapperAccepted.getValue() + " biome parameter points were mapped for BYG region: " + this.getName().toString());
    }
}
