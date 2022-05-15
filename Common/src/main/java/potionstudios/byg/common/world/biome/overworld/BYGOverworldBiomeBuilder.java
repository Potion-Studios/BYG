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
    private final ResourceKey<Biome>[][] badlandsBiomes;
    private final ResourceKey<Biome>[][] badlandsBiomesVariant;

    public BYGOverworldBiomeBuilder(ResourceKey<Biome>[][] oceans, ResourceKey<Biome>[][] middleBiomes,
                                    ResourceKey<Biome>[][] middleBiomesVariant, ResourceKey<Biome>[][] plateauBiomes,
                                    ResourceKey<Biome>[][] plateauBiomesVariant, ResourceKey<Biome>[][] shatteredBiomes,
                                    ResourceKey<Biome>[][] beachBiomes,
                                    ResourceKey<Biome>[][] peakBiomes, ResourceKey<Biome>[][] peakBiomesVariant,
                                    ResourceKey<Biome>[][] slopeBiomes, ResourceKey<Biome>[][] slopeBiomesVariant,
                                    ResourceKey<Biome>[][] badlandsBiomes, ResourceKey<Biome>[][] badlandsBiomesVariant) {
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
        this.badlandsBiomes = badlandsBiomes;
        this.badlandsBiomesVariant = badlandsBiomesVariant;
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
    public ResourceKey<Biome> pickBadlandsBiome(int humidity, Climate.Parameter weirdness) {
        ResourceKey<Biome> badlandsBiome = this.badlandsBiomes[0][humidity];
        if (weirdness.max() < 0L) {
            return badlandsBiome;
        } else {
            ResourceKey<Biome> badlandsVariant = badlandsBiomesVariant[0][humidity];
            return badlandsVariant == null ? badlandsBiome : badlandsVariant;
        }
    }


}