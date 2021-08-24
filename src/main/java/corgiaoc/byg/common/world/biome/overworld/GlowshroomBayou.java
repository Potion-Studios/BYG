package corgiaoc.byg.common.world.biome.overworld;

import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.common.world.biome.BiomeUtil;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import corgiaoc.byg.mixin.access.BiomeClimateSettingsAccess;
import corgiaoc.byg.util.MLClimate;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Features;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;

public class GlowshroomBayou extends BYGBiome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("glowshroom_bayou", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.GLOWSHROOM_BAYOU, SurfaceBuilder.CONFIG_GRASS));
    static final Biome.Precipitation PRECIPATATION = Biome.Precipitation.RAIN;
    static final Biome.BiomeCategory CATEGORY = Biome.BiomeCategory.SWAMP;
    static final float DEPTH = -0.2F;
    static final float SCALE = 0.01F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4815438;
    static final int WATER_FOG_COLOR = 6717479;
    static final int GRASS_COLOR = 7375928;
    static final int FOLIAGE_COLOR = 6337104;

    static final Biome.ClimateSettings WEATHER = BiomeClimateSettingsAccess.create(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnSettings.Builder SPAWN_SETTINGS = new MobSpawnSettings.Builder().setPlayerCanSpawn();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public GlowshroomBayou() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeSpecialEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).grassColorOverride(GRASS_COLOR).foliageColorOverride(FOLIAGE_COLOR).skyColor(BiomeUtil.calcSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
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
    public String[] getBiomeDictionary() {
        return new String[]{"SWAMP", "FOREST", "WET", "MAGICAL", "RARE", "OVERWORLD"};
    }

    @Override
    public MLClimate getClimate() {
        return MLClimate.WARM;
    }

    @Override
    public int getWeight() {
        return 1;
    }

    static {
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.SWAMP_HUT); //Swamp Hut
        BiomeDefaultFeatures.addDefaultOverworldLandStructures(GENERATION_SETTINGS);
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.RUINED_PORTAL_SWAMP); //Ruined Portal Swamp
        BYGDefaultBiomeFeatures.addGlowshroomBayouVegetation(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultCarvers(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultMonsterRoom(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultOres(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addSwampClayDisk(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultMushrooms(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addSwampExtraVegetation(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultSprings(GENERATION_SETTINGS);
        GENERATION_SETTINGS.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_NORMAL);
//        GENERATION_SETTINGS.addFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.GLOWSHROOM_CAVES);
        BYGDefaultBiomeFeatures.addBYGSwampVegetation(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addGrass(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addGlowcane(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addCattails(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addMudDisks(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addSurfaceFreezing(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addPeachleatherflower(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addVioletleatherflower(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addRedorchid(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addPurpleOrchid(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addPinkOrchid(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addGlowshrooms(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addHugeGlowshrooms(GENERATION_SETTINGS);
    }
}
