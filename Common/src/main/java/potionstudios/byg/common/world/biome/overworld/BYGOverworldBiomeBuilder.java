package potionstudios.byg.common.world.biome.overworld;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.mixin.access.OverworldBiomeBuilderAccess;

public class BYGOverworldBiomeBuilder extends OverworldBiomeBuilder {

    private final ResourceKey<Biome>[][] beachBiomes;
    private final ResourceKey<Biome>[][] peakBiomes;
    private final ResourceKey<Biome>[][] peakBiomesVariant;
    private final ResourceKey<Biome>[][] slopeBiomes;
    private final ResourceKey<Biome>[][] slopeBiomesVariant;

    public BYGOverworldBiomeBuilder(ResourceKey<Biome>[][] oceans, ResourceKey<Biome>[][] middleBiomes,
                                    ResourceKey<Biome>[][] middleBiomesVariant, ResourceKey<Biome>[][] plateauBiomes,
                                    ResourceKey<Biome>[][] plateauBiomesVariant, ResourceKey<Biome>[][] shatteredBiomes,
                                    ResourceKey<Biome>[][] beachBiomes,
                                    ResourceKey<Biome>[][] peakBiomes, ResourceKey<Biome>[][] peakBiomesVariant,
                                    ResourceKey<Biome>[][] slopeBiomes, ResourceKey<Biome>[][] slopeBiomesVariant) {
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
    }

    @Override
    public @NotNull ResourceKey<Biome> pickBeachBiome(int temp, int humidity) {
        return beachBiomes[temp][humidity];
    }

    @Override
    public @NotNull ResourceKey<Biome> pickPeakBiome(int temp, int humidity, Climate.Parameter weirdness) {
        ResourceKey<Biome> peakBiome = this.peakBiomes[temp][humidity];
        if (weirdness.max() < 0L) {
            return peakBiome;
        } else {
            ResourceKey<Biome> peakVariant = peakBiomesVariant[temp][humidity];
            return peakVariant == null ? peakBiome : peakVariant;
        }
    }

    @Override
    public @NotNull ResourceKey<Biome> pickSlopeBiome(int temp, int humidity, Climate.Parameter weirdness) {
        ResourceKey<Biome> slopeBiome = this.slopeBiomes[temp][humidity];
        if (weirdness.max() < 0L) {
            return slopeBiome;
        } else {
            ResourceKey<Biome> slopeVariant = slopeBiomesVariant[temp][humidity];
            return slopeVariant == null ? slopeBiome : slopeVariant;
        }
    }
}