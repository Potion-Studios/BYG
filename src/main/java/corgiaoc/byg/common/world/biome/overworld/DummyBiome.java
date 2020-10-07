package corgiaoc.byg.common.world.biome.overworld;

import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.biome.BiomeUtil;
import corgiaoc.byg.core.RegistrationHelper;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class DummyBiome extends BYGBiome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = RegistrationHelper.createConfiguredSurfaceBuilder("dummy_biome", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG));
    static final Biome.RainType PRECIPATATION = Biome.RainType.RAIN;
    static final Biome.Category CATEGORY = Biome.Category.PLAINS;
    static final float DEPTH = 2.2F;
    static final float SCALE = 0.0F;
    static final float TEMPERATURE = 0.7F;
    static final float DOWNFALL = 0.4F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;
    static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

    public DummyBiome() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).setFogColor(12638463).withSkyColor(BiomeUtil.calcSkyColor(0.8F)).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.copy());
    }

    static {
//        DefaultBiomeFeatures.withStrongholdAndMineshaft(GENERATION_SETTINGS);
//        BYGFeatures.addRockyStoneBoulder(GENERATION_SETTINGS);
//        BYGFeatures.addMossyStoneBoulder(GENERATION_SETTINGS);
//        DefaultBiomeFeatures.withNormalGrassPatch(GENERATION_SETTINGS);
//        DefaultBiomeFeatures.withCavesAndCanyons(GENERATION_SETTINGS);
//        DefaultBiomeFeatures.withMonsterRoom(GENERATION_SETTINGS);
//        DefaultBiomeFeatures.withCommonOverworldBlocks(GENERATION_SETTINGS);
//        DefaultBiomeFeatures.withOverworldOres(GENERATION_SETTINGS);
//        DefaultBiomeFeatures.withDisks(GENERATION_SETTINGS);
//        DefaultBiomeFeatures.withNormalMushroomGeneration(GENERATION_SETTINGS);
//        DefaultBiomeFeatures.withFrozenTopLayer(GENERATION_SETTINGS);
//        DefaultBiomeFeatures.withPlainGrassVegetation(GENERATION_SETTINGS);
//        BYGTreeFeatures.addDummyTree(GENERATION_SETTINGS);
    }
}