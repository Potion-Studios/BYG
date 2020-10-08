package corgiaoc.byg.common.world.biome.end;

import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.biome.BiomeUtil;
import corgiaoc.byg.core.world.BYGConfiguredFeatures;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;

public class IvisFields extends BYGBiome {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("ivis_fields", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.IVIS_FIELDS, BYGSurfaceBuilders.Configs.END));
    static final Biome.RainType PRECIPATATION = Biome.RainType.NONE;
    static final Biome.Category CATEGORY = Biome.Category.THEEND;
    static final float DEPTH = 0.55F;
    static final float SCALE = 0.15F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;
    static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

    public IvisFields() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).setFogColor(12638463).withSkyColor(BiomeUtil.calcSkyColor(0.8F)).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.copy());
    }


    static {
        GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.IVIS_SPIKES);
        GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.IVIS_SPIKES);
        GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.CHORUS_PLANT);
        GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.CHORUS_PLANT);
        GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.CHORUS_PLANT);
    }
}
