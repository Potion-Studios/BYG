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
import potionstudios.byg.common.world.biome.overworld.BYGOverworldBiomeBuilders;
import potionstudios.byg.mixin.access.OverworldBiomeBuilderAccess;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static potionstudios.byg.util.BYGRegionUtils.dumpArrays;
import static potionstudios.byg.util.BYGRegionUtils.filter;
import static potionstudios.byg.util.BYGUtil.convert2DResourceKeyArrayTo2DList;

public class BYGRegion extends Region {
    private static int count = 0;

    private final Set<ResourceKey<Biome>> bygKeys = new ObjectOpenHashSet<>();
    private final Map<ResourceKey<Biome>, ResourceKey<Biome>> swapper;

    private final BYGOverworldBiomeBuilder bygOverworldBiomeBuilder;

    public BYGRegion(BYGOverworldBiomeBuilders.BiomeProviderData biomeProviderData) {
        this(biomeProviderData.overworldWeight(),
            convert2DResourceKeyArrayTo2DList(biomeProviderData.oceans().value()),
            convert2DResourceKeyArrayTo2DList(biomeProviderData.middleBiomes().value()),
            convert2DResourceKeyArrayTo2DList(biomeProviderData.middleBiomesVariant().value()),
            convert2DResourceKeyArrayTo2DList(biomeProviderData.plateauBiomes().value()),
            convert2DResourceKeyArrayTo2DList(biomeProviderData.plateauBiomesVariant().value()),
            convert2DResourceKeyArrayTo2DList(biomeProviderData.extremeHills().value()),
            convert2DResourceKeyArrayTo2DList(biomeProviderData.beachBiomes().value()),
            convert2DResourceKeyArrayTo2DList(biomeProviderData.peakBiomes().value()),
            convert2DResourceKeyArrayTo2DList(biomeProviderData.peakBiomesVariant().value()),
            biomeProviderData.swapper());
    }

    public BYGRegion(int overworldWeight,
                     ResourceKey<Biome>[][] oceans, ResourceKey<Biome>[][] middleBiomes,
                     ResourceKey<Biome>[][] middleBiomesVariant, ResourceKey<Biome>[][] plateauBiomes,
                     ResourceKey<Biome>[][] plateauBiomesVariant, ResourceKey<Biome>[][] shatteredBiomes,
                     ResourceKey<Biome>[][] beachBiomes, ResourceKey<Biome>[][] peakBiomes,
                     ResourceKey<Biome>[][] peakBiomesVariant,
                     Map<ResourceKey<Biome>, ResourceKey<Biome>> swapper) {
        super(BYG.createLocation("region_" + count++), RegionType.OVERWORLD, overworldWeight);
        this.swapper = swapper;
        Predicate<ResourceKey<Biome>> noVoidBiomes = biomeResourceKey -> biomeResourceKey != Biomes.THE_VOID;
        oceans = filter("oceans", this.getName(), count, oceans, noVoidBiomes, true);
        middleBiomes = filter("middle_biomes", this.getName(), count, middleBiomes, noVoidBiomes, true);
        middleBiomesVariant = filter("middle_biomes_variant", this.getName(), count, middleBiomesVariant, noVoidBiomes, false);
        plateauBiomes = filter("plateau_biomes", this.getName(), count, plateauBiomes, noVoidBiomes, true);
        plateauBiomesVariant = filter("plateau_biomes_variant", this.getName(), count, plateauBiomesVariant, noVoidBiomes, false);
        shatteredBiomes = filter("shattered_biomes", this.getName(), count, shatteredBiomes, noVoidBiomes, false);
        beachBiomes = filter("beach_biomes", this.getName(), count, beachBiomes, noVoidBiomes, true);
        peakBiomes = filter("peak_biomes", this.getName(), count, peakBiomes, noVoidBiomes, true);
        peakBiomesVariant = filter("peak_biomes_variant", this.getName(), count, peakBiomesVariant, noVoidBiomes, true);

        this.bygOverworldBiomeBuilder = new BYGOverworldBiomeBuilder(
            oceans, middleBiomes, middleBiomesVariant,
            plateauBiomes, plateauBiomesVariant, shatteredBiomes,
            beachBiomes, peakBiomes, peakBiomesVariant
        );

        dumpArrays((biomeResourceKey -> {
            if (biomeResourceKey != null) {
                bygKeys.add(biomeResourceKey);
                if (swapper.containsValue(biomeResourceKey)) {
                    throw new IllegalArgumentException("Swapper cannot contain elements found in the temperature arrays.");
                }
            }
        }), oceans, middleBiomes, middleBiomesVariant, plateauBiomes, plateauBiomesVariant, shatteredBiomes, beachBiomes, peakBiomes);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        MutableInt totalPairs = new MutableInt();
        MutableInt bygMapperAccepted = new MutableInt(0);
        ((OverworldBiomeBuilderAccess) this.bygOverworldBiomeBuilder).byg_invokeAddBiomes((parameterPointResourceKeyPair -> {
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
}
