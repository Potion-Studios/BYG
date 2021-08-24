package corgiaoc.byg.common.world.biome.overworld;

import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import corgiaoc.byg.mixin.access.BiomeClimateSettingsAccess;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;

public class ValleDeLuna extends BYGBiome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("valle_de_luna", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, BYGSurfaceBuilders.Configs.WHITE_SAND));
    static final Biome.Precipitation PRECIPATATION = Biome.Precipitation.NONE;
    static final Biome.BiomeCategory CATEGORY = Biome.BiomeCategory.DESERT;
    static final float DEPTH = 0.0F;
    static final float SCALE = 0.0F;
    static final float TEMPERATURE = 2.0F;
    static final float DOWNFALL = 0.0F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final int GRASS_COLOR = 10855786;
    static final int FOLIAGE_COLOR = 10855786;

    static final Biome.ClimateSettings WEATHER = BiomeClimateSettingsAccess.create(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnSettings.Builder SPAWN_SETTINGS = new MobSpawnSettings.Builder().setPlayerCanSpawn();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public ValleDeLuna() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeSpecialEffects.Builder())
                .waterColor(WATER_COLOR)
                .waterFogColor(WATER_FOG_COLOR)
                .fogColor(12665870)
                .grassColorOverride(GRASS_COLOR)
                .foliageColorOverride(FOLIAGE_COLOR)
                .skyColor(12665870)
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.00528F))
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }

    static {
        BiomeDefaultFeatures.addFossilDecoration(GENERATION_SETTINGS);
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.DESERT_PYRAMID); //Desert Temple
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.RUINED_PORTAL_DESERT); //Ruined Portal Desert
        BiomeDefaultFeatures.addDefaultOverworldLandStructures(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultCarvers(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultMonsterRoom(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultOres(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addExtraGold(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addExtraEmeralds(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultSoftDisks(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultMushrooms(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultExtraVegetation(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addSurfaceFreezing(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addFossilDecoration(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDesertExtraDecoration(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addPaloVerdeTrees(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addBYGMushrooms(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addGiantLunaRocks(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addTerracottaBoulder(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addGrass(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addBYGDesertPlants(GENERATION_SETTINGS);
//        GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.VOLCANO);

        SPAWN_SETTINGS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
        SPAWN_SETTINGS.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.HUSK, 95, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

    }
}

