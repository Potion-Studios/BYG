package corgiaoc.byg.common.world.biome.overworld;

import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.common.world.biome.BiomeUtil;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import javax.annotation.Nullable;

public class GlowshroomBayou extends BYGBiome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("glowshroom_bayou", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.GLOWSHROOM_BAYOU, SurfaceBuilder.GRASS_CONFIG));
    static final Biome.Precipitation PRECIPATATION = Biome.Precipitation.RAIN;
    static final Biome.Category CATEGORY = Biome.Category.SWAMP;
    static final float DEPTH = -0.2F;
    static final float SCALE = 0.01F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4815438;
    static final int WATER_FOG_COLOR = 6717479;
    static final int GRASS_COLOR = 7375928;
    static final int FOLIAGE_COLOR = 6337104;

    static final Biome.Weather WEATHER = new Biome.Weather(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final SpawnSettings.Builder SPAWN_SETTINGS = new SpawnSettings.Builder().playerSpawnFriendly();
    static final GenerationSettings.Builder GENERATION_SETTINGS = (new GenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public GlowshroomBayou() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).grassColor(GRASS_COLOR).foliageColor(FOLIAGE_COLOR).skyColor(BiomeUtil.calcSkyColor(0.8F)).moodSound(BiomeMoodSound.CAVE).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }

    @Override
    public Biome getRiver() {
        return this.getBiome();
    }

    @Nullable
    @Override
    public Biome getBeach() {
        return this.getBiome();
    }

    @Override
    public Object getBiomeDictionary() {
        return null; //{BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WET,BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OVERWORLD};
    }

    @Override
    public OverworldClimate getBiomeType() {
        return OverworldClimate.TEMPERATE;
    }

    @Override
    public int getWeight() {
        return 1;
    }

    static {
        GENERATION_SETTINGS.structureFeature(ConfiguredStructureFeatures.SWAMP_HUT); //Swamp Hut
        DefaultBiomeFeatures.addDefaultUndergroundStructures(GENERATION_SETTINGS);
        GENERATION_SETTINGS.structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_SWAMP); //Ruined Portal Swamp
        BYGDefaultBiomeFeatures.addGlowshroomBayouVegetation(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addLandCarvers(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDungeons(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addMineables(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultOres(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addClay(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultMushrooms(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addSwampVegetation(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addSprings(GENERATION_SETTINGS);
        GENERATION_SETTINGS.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SEAGRASS_NORMAL);
        BYGDefaultBiomeFeatures.addBYGSwampVegetation(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addGrass(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addGlowcane(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addCattails(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addMudDisks(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addFrozenTopLayer(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addPeachleatherflower(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addVioletleatherflower(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addRedorchid(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addPurpleOrchid(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addPinkOrchid(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addGlowshrooms(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addHugeGlowshrooms(GENERATION_SETTINGS);
    }
}
