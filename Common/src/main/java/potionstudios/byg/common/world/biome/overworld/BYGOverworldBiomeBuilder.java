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

    public BYGOverworldBiomeBuilder(ResourceKey<Biome>[][] oceans, ResourceKey<Biome>[][] middleBiomes,
                                    ResourceKey<Biome>[][] middleBiomesVariant, ResourceKey<Biome>[][] plateauBiomes,
                                    ResourceKey<Biome>[][] plateauBiomesVariant, ResourceKey<Biome>[][] shatteredBiomes,
                                    ResourceKey<Biome>[][] beachBiomes, ResourceKey<Biome>[][] peakBiomes,
                                    ResourceKey<Biome>[][] peakBiomesVariant) {
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
    }

    @Override
    public ResourceKey<Biome> pickBeachBiome(int temp, int humidity) {
        return beachBiomes[temp][humidity];
    }

    @Override
    protected ResourceKey<Biome> pickPeakBiome(int temp, int humidity, Climate.Parameter weirdness) {
        return weirdness.max() < 0L ? peakBiomes[temp][humidity] : peakBiomesVariant[temp][humidity];
    }
}