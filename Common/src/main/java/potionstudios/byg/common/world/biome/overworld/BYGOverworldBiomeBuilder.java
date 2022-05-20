package potionstudios.byg.common.world.biome.overworld;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import potionstudios.byg.mixin.access.OverworldBiomeBuilderAccess;

public class BYGOverworldBiomeBuilder extends OverworldBiomeBuilder {

    private final ResourceKey<Biome>[][] beachBiomes;
    private final ResourceKey<Biome>[][] peakBiomes;
    private final ResourceKey<Biome>[][] peakBiomesVariant;
    private final ResourceKey<Biome>[][] slopeBiomes;
    private final ResourceKey<Biome>[][] slopeBiomesVariant;
    private final ResourceKey<Biome>[][] plateauEdgeBiomes;
    private final ResourceKey<Biome>[][] plateauEdgeBiomesVariant;
    private final ResourceKey<Biome>[][] mountainEdgeBiomes;
    private final ResourceKey<Biome>[][] mountainEdgeBiomesVariant;

    public BYGOverworldBiomeBuilder(ResourceKey<Biome>[][] oceans, ResourceKey<Biome>[][] middleBiomes,
                                    ResourceKey<Biome>[][] middleBiomesVariant, ResourceKey<Biome>[][] plateauBiomes,
                                    ResourceKey<Biome>[][] plateauBiomesVariant, ResourceKey<Biome>[][] shatteredBiomes,
                                    ResourceKey<Biome>[][] beachBiomes,
                                    ResourceKey<Biome>[][] peakBiomes, ResourceKey<Biome>[][] peakBiomesVariant,
                                    ResourceKey<Biome>[][] slopeBiomes, ResourceKey<Biome>[][] slopeBiomesVariant,
                                    ResourceKey<Biome>[][] plateauEdgeBiomes, ResourceKey<Biome>[][] plateauEdgeBiomesVariant,
                                    ResourceKey<Biome>[][] mountainEdgeBiomes, ResourceKey<Biome>[][] mountainEdgeBiomesVariant) {
        OverworldBiomeBuilderAccess overworldBiomeBuilderAccess = (OverworldBiomeBuilderAccess) this;
        overworldBiomeBuilderAccess.byg_setOCEANS(oceans);
        overworldBiomeBuilderAccess.byg_setMIDDLE_BIOMES(middleBiomes);
        overworldBiomeBuilderAccess.byg_setMIDDLE_BIOMES_VARIANT(middleBiomesVariant);
        overworldBiomeBuilderAccess.byg_setPLATEAU_BIOMES(plateauBiomes);
        overworldBiomeBuilderAccess.byg_setPLATEAU_BIOMES_VARIANT(plateauBiomesVariant);
        overworldBiomeBuilderAccess.byg_setSHATTERED_BIOMES(shatteredBiomes);
        this.beachBiomes = beachBiomes;
        this.peakBiomes = peakBiomes;
        this.peakBiomesVariant = peakBiomesVariant;
        this.slopeBiomes = slopeBiomes;
        this.slopeBiomesVariant = slopeBiomesVariant;
        this.plateauEdgeBiomes = plateauEdgeBiomes;
        this.plateauEdgeBiomesVariant = plateauEdgeBiomesVariant;
        this.mountainEdgeBiomes = mountainEdgeBiomes;
        this.mountainEdgeBiomesVariant = mountainEdgeBiomesVariant;
    }

    @Override
    public ResourceKey<Biome> pickBeachBiome(int temp, int humidity) {
        return beachBiomes[temp][humidity];
    }

    @Override
    public ResourceKey<Biome> pickPeakBiome(int temp, int humidity, Climate.Parameter weirdness) {
        ResourceKey<Biome> peakBiome = this.peakBiomes[temp][humidity];
        if (weirdness.max() < 0L) {
            return peakBiome;
        } else {
            ResourceKey<Biome> peakVariant = peakBiomesVariant[temp][humidity];
            return peakVariant == null ? peakBiome : peakVariant;
        }
    }

    @Override
    public ResourceKey<Biome> pickSlopeBiome(int temp, int humidity, Climate.Parameter weirdness) {
        ResourceKey<Biome> slopeBiome = this.slopeBiomes[temp][humidity];
        if (weirdness.max() < 0L) {
            return slopeBiome;
        } else {
            ResourceKey<Biome> slopeVariant = slopeBiomesVariant[temp][humidity];
            return slopeVariant == null ? slopeBiome : slopeVariant;
        }
    }

    @Override
    public ResourceKey<Biome> pickMiddleBiomeOrBadlandsIfHot(int temp, int humidity, Climate.Parameter weirdness) {
        ResourceKey<Biome> platEdgeBiome = this.plateauEdgeBiomes[temp][humidity];
        if(platEdgeBiome == null)
            platEdgeBiome = pickMiddleBiome(temp, humidity, weirdness);
        if (weirdness.max() < 0L) {
            return platEdgeBiome;
        } else {
            ResourceKey<Biome> platEdgeVariant = this.plateauEdgeBiomesVariant[temp][humidity];
            return platEdgeVariant == null ? platEdgeBiome : platEdgeVariant;
        }
    }

    @Override
    public ResourceKey<Biome> pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(int temp, int humidity, Climate.Parameter weirdness) {
        ResourceKey<Biome> mountEdgeBiome = this.mountainEdgeBiomes[temp][humidity];
        if(mountEdgeBiome == null)
            mountEdgeBiome = pickMiddleBiomeOrBadlandsIfHot(temp, humidity, weirdness);
        if(weirdness.max() < 0L)
            return mountEdgeBiome;
        else {
            ResourceKey<Biome> mountEdgeVariant = this.mountainEdgeBiomesVariant[temp][humidity];
            return mountEdgeVariant == null ? mountEdgeBiome : mountEdgeVariant;
        }
    }


}