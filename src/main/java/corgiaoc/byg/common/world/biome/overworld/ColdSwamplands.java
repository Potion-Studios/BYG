package corgiaoc.byg.common.world.biome.overworld;

import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.common.world.biome.BiomeUtil;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import corgiaoc.byg.mixin.access.BiomeClimateSettingsAccess;
import corgiaoc.byg.util.MLClimate;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Features;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.behavior.WeightedList;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

public class ColdSwamplands extends BYGBiome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("cold_swamplands", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.MARSHLAND, new SurfaceBuilderBaseConfiguration(Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(), BYGBlocks.MUD_BLOCK.defaultBlockState())));
    static final Biome.Precipitation PRECIPATATION = Biome.Precipitation.RAIN;
    static final Biome.BiomeCategory CATEGORY = Biome.BiomeCategory.SWAMP;
    static final float DEPTH = -0.22F;
    static final float SCALE = 0.1F;
    static final float TEMPERATURE = 0.25F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 9202509;
    static final int WATER_FOG_COLOR = 9202509;
    static final int GRASS_COLOR = 7365696;
    static final int FOLIAGE_COLOR = 7365696;

    static final Biome.ClimateSettings WEATHER = BiomeClimateSettingsAccess.create(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnSettings.Builder SPAWN_SETTINGS = new MobSpawnSettings.Builder().setPlayerCanSpawn();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public ColdSwamplands() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeSpecialEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).grassColorOverride(GRASS_COLOR).foliageColorOverride(FOLIAGE_COLOR).skyColor(BiomeUtil.calcSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }

    @Override
    public Biome getRiver() {
        return this.getBiome();
    }


    @Nullable
    @Override
    public WeightedList<Biome> getHills() {
        WeightedList<Biome> biomeWeightedList = new WeightedList<>();
        biomeWeightedList.add(this.getBiome(), 10);
        return biomeWeightedList;
    }

    @Override
    public int getWeight() {
        return 6;
    }

    @Nullable
    @Override
    public Biome getBeach() {
        return this.getBiome();
    }

    @Override
    public String[] getBiomeDictionary() {
        return new String[]{"SWAMP", "OVERWORLD"};
    }

    @Override
    public MLClimate getClimate() {
        return MLClimate.COOL;
    }

    static {
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.SWAMP_HUT); //Swamp Hut
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.PILLAGER_OUTPOST); //Pillager Outpost
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.RUINED_PORTAL_SWAMP); //Ruined Portal Swamp
        BiomeDefaultFeatures.addDefaultOverworldLandStructures(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultCarvers(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultLakes(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultMonsterRoom(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultOres(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addSwampClayDisk(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultMushrooms(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addSwampExtraVegetation(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultSprings(GENERATION_SETTINGS);
        GENERATION_SETTINGS.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_NORMAL);
        BiomeDefaultFeatures.addSwampVegetation(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addMarshGrass(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addWiltedGrass(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addWiltedGrass(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addReeds(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addMudDisks(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addSurfaceFreezing(GENERATION_SETTINGS);

        SPAWN_SETTINGS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1));

    }
}
