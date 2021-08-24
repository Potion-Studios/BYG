package corgiaoc.byg.common.world.biome.overworld;

import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.common.world.biome.BiomeUtil;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import corgiaoc.byg.mixin.access.BiomeClimateSettingsAccess;
import corgiaoc.byg.util.MLClimate;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.behavior.WeightedList;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;

public class LushTundra extends BYGBiome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("lush_tundra", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.LUSH_TUNDRA, SurfaceBuilder.CONFIG_GRASS));
    static final Biome.Precipitation PRECIPATATION = Biome.Precipitation.SNOW;
    static final Biome.BiomeCategory CATEGORY = Biome.BiomeCategory.ICY;
    static final float DEPTH = 0.15F;
    static final float SCALE = 0.1F;
    static final float TEMPERATURE = 0.35F;
    static final float DOWNFALL = 0.4F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final int GRASS_COLOR = 10044989;
    static final int FOLIAGE_COLOR = 10044989;

    static final Biome.ClimateSettings WEATHER = BiomeClimateSettingsAccess.create(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnSettings.Builder SPAWN_SETTINGS = new MobSpawnSettings.Builder().setPlayerCanSpawn();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public LushTundra() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeSpecialEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).grassColorOverride(GRASS_COLOR).foliageColorOverride(FOLIAGE_COLOR).skyColor(BiomeUtil.calcSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }

    @Nullable
    @Override
    public Biome getBeach() {
        return BYGBiomes.BASALT_BARRERA;
    }

    @Nullable
    @Override
    public WeightedList<Biome> getHills() {
        WeightedList<Biome> biomeWeightedList = new WeightedList<>();
        biomeWeightedList.add(BYGBiomes.FROZEN_LAKE, 4);
        biomeWeightedList.add(BYGBiomes.NORTHERN_FOREST, 6);
        return biomeWeightedList;
    }

    @Override
    public String[] getBiomeDictionary() {
        return new String[]{"PLAINS", "COLD", "LUSH", "OVERWORLD"};
    }

    @Override
    public MLClimate getClimate() {
        return MLClimate.COLD;
    }

    @Override
    public int getWeight() {
        return 6;
    }

    static {
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.VILLAGE_SNOWY); //Snowy Village
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.PILLAGER_OUTPOST); //Pillager Outpost
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD); //Ruined Portal Standard
        BiomeDefaultFeatures.addDefaultCarvers(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultMonsterRoom(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultOres(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultSoftDisks(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultMushrooms(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultExtraVegetation(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addGrass(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addBYGMushrooms(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addWinterScilla(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addRockyStoneBoulder(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addSurfaceFreezing(GENERATION_SETTINGS);

        SPAWN_SETTINGS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 10, 2, 3));
        SPAWN_SETTINGS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.POLAR_BEAR, 1, 1, 2));
        SPAWN_SETTINGS.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 20, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.STRAY, 80, 4, 4));

    }
}
