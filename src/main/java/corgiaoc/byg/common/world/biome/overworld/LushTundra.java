package corgiaoc.byg.common.world.biome.overworld;

import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.common.world.biome.BiomeUtil;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class LushTundra extends BYGBiome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("lush_tundra", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.LUSH_TUNDRA, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG));
    static final Biome.RainType PRECIPATATION = Biome.RainType.SNOW;
    static final Biome.Category CATEGORY = Biome.Category.ICY;
    static final float DEPTH = 0.15F;
    static final float SCALE = 0.1F;
    static final float TEMPERATURE = 0.35F;
    static final float DOWNFALL = 0.4F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final int GRASS_COLOR = 10044989;
    static final int FOLIAGE_COLOR = 10044989;
    
    static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

    public LushTundra() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).setFogColor(12638463).withGrassColor(GRASS_COLOR).withFoliageColor(FOLIAGE_COLOR).withSkyColor(BiomeUtil.calcSkyColor(0.8F)).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.copy());
    }

    public Biome getHills(INoiseRandom rand) {
        return (rand.random(5) == 0) ? BYGBiomes.FROZEN_LAKE : BYGBiomes.NORTHERN_FOREST;
    }

    static {
        //this.addStructure(Feature.VILLAGE.configure(new VillageConfig("village/snowy/town_centers"), 6));
        //this.addStructure(Feature.PILLAGER_OUTPOST.configure(IFeatureConfig.NO_FEATURE_CONFIG));
        //this.addStructure(Feature.MINESHAFT.configure(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
        //this.addStructure(Feature.STRONGHOLD.configure(IFeatureConfig.NO_FEATURE_CONFIG));
        DefaultBiomeFeatures.withCavesAndCanyons(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withMonsterRoom(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withCommonOverworldBlocks(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withOverworldOres(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withDisks(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withNormalMushroomGeneration(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withSugarCaneAndPumpkins(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addGrass(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addBYGMushrooms(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addWinterScilla(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addRockyStoneBoulder(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withFrozenTopLayer(GENERATION_SETTINGS);

        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.RABBIT, 10, 2, 3));
        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.POLAR_BEAR, 1, 1, 2));
        SPAWN_SETTINGS.withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8));
        SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 95, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.CREEPER, 100, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SLIME, 100, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 10, 1, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.WITCH, 5, 1, 1));
        SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SKELETON, 20, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.STRAY, 80, 4, 4));

    }
}
