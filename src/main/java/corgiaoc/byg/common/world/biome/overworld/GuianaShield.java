package corgiaoc.byg.common.world.biome.overworld;

import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.common.world.biome.BiomeUtil;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.core.world.BYGConfiguredStructures;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

public class GuianaShield extends BYGBiome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("guiana_shield", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, new SurfaceBuilderBaseConfiguration(BYGBlocks.OVERGROWN_STONE.defaultBlockState(), Blocks.STONE.defaultBlockState(), Blocks.STONE.defaultBlockState())));
    static final Biome.Precipitation PRECIPATATION = Biome.Precipitation.RAIN;
    static final Biome.BiomeCategory CATEGORY = Biome.BiomeCategory.JUNGLE;
    static final float DEPTH = 6.0F;
    static final float SCALE = 0.25F;
    static final float TEMPERATURE = 0.95F;
    static final float DOWNFALL = 0.9F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final int GRASS_COLOR = 6208527;
    static final int FOLIAGE_COLOR = 6208527;

    static final Biome.ClimateSettings WEATHER = BiomeClimateSettingsAccess.create(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnSettings.Builder SPAWN_SETTINGS = new MobSpawnSettings.Builder().setPlayerCanSpawn();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public GuianaShield() {
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
        biomeWeightedList.add(BYGBiomes.GUIANA_CLEARING, 8);
        biomeWeightedList.add(BYGBiomes.GUIANA_SPRINGS, 2);
        return biomeWeightedList;
    }

    @Nullable
    @Override
    public Biome getEdge() {
        return BYGBiomes.GUIANA_CLEARING;
    }


    @Override
    public String[] getBiomeDictionary() {
        return new String[]{"JUNGLE", "HOT", "DENSE", "FOREST", "MOUNTAIN", "OVERWORLD"};
    }

    @Override
    public MLClimate getClimate() {
        return MLClimate.WARM;
    }

    @Override
    public int getWeight() {
        return 3;
    }

    static {
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.JUNGLE_TEMPLE); //Jungle Temple
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.PILLAGER_OUTPOST); //Pillager Outpost
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.RUINED_PORTAL_JUNGLE); //Ruined Portal Jungle
        GENERATION_SETTINGS.addStructureStart(BYGConfiguredStructures.VILLAGE_TROPICAL);
        BiomeDefaultFeatures.addDefaultOverworldLandStructures(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultCarvers(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultMonsterRoom(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultOres(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultSoftDisks(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addWarmFlowers(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultMushrooms(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultExtraVegetation(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultSprings(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addRainForestTrees(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addWeedGrass(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addGrass(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addBYGTropicFlowers(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addBYGMushrooms(GENERATION_SETTINGS);

        SPAWN_SETTINGS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, 40, 1, 2));
        SPAWN_SETTINGS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 2, 1, 1));

    }
}
