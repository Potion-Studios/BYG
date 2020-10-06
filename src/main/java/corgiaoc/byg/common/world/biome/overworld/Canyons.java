package corgiaoc.byg.common.world.biome.overworld;

import net.minecraft.world.biome.*;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import corgiaoc.byg.common.world.biome.BiomeHelper;
import corgiaoc.byg.common.world.biome.BiomeTools;
import corgiaoc.byg.common.world.feature.biomefeatures.BYGTreeFeatures;
import corgiaoc.byg.core.byglists.BYGSBList;

public class Canyons extends Biome implements BiomeTools {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = BiomeHelper.newConfiguredSurfaceBuilder("canyons", new ConfiguredSurfaceBuilder<>(BYGSBList.CANYONS, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG));
    static final RainType PRECIPATATION = RainType.NONE;
    static final Category CATEGORY = Category.DESERT;
    static final float DEPTH = 3.5F;
    static final float SCALE = 0.05F;
    static final float TEMPERATURE = 1.5F;
    static final float DOWNFALL = 0.9F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;
    static final Climate WEATHER = new Climate(PRECIPATATION, TEMPERATURE, TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

    public Canyons() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).setFogColor(12638463).withSkyColor(BiomeHelper.calcSkyColor(0.8F)).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.copy());
    }

    @Override
    public Biome getRiver() {
        return null;
    }

    static {
        BYGTreeFeatures.addRedRockCanyonVegetation(GENERATION_SETTINGS);
    }
}

