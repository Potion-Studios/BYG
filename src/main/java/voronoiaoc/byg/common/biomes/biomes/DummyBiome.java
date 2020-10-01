package voronoiaoc.byg.common.biomes.biomes;

import net.minecraft.world.biome.*;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import voronoiaoc.byg.common.biomes.BiomeHelper;
import voronoiaoc.byg.common.biomes.BiomeTools;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGTreeFeatures;

public class DummyBiome extends Biome implements BiomeTools {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = BiomeHelper.newConfiguredSurfaceBuilder("dummy_biome", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG));
    static final RainType PRECIPATATION = RainType.RAIN;
    static final Category CATEGORY = Category.PLAINS;
    static final float DEPTH = 2.2F;
    static final float SCALE = 0.0F;
    static final float TEMPERATURE = 0.7F;
    static final float DOWNFALL = 0.4F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;
    static final Climate WEATHER = new Climate(PRECIPATATION, TEMPERATURE, TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

    public DummyBiome() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).setFogColor(12638463).withSkyColor(BiomeHelper.calcSkyColor(0.8F)).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.copy());
    }

    static {
        DefaultBiomeFeatures.withStrongholdAndMineshaft(GENERATION_SETTINGS);
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
        BYGTreeFeatures.addDummyTree(GENERATION_SETTINGS);
    }
}