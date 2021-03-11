package corgiaoc.byg.common.world.biome.overworld;

import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class ValleDeLuna extends BYGBiome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("valle_de_luna", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, BYGSurfaceBuilders.Configs.WHITE_SAND));
    static final Biome.RainType PRECIPATATION = Biome.RainType.NONE;
    static final Biome.Category CATEGORY = Biome.Category.DESERT;
    static final float DEPTH = 0.0F;
    static final float SCALE = 0.0F;
    static final float TEMPERATURE = 2.0F;
    static final float DOWNFALL = 0.0F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final int GRASS_COLOR = 10855786;
    static final int FOLIAGE_COLOR = 10855786;
    
    static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder().setPlayerCanSpawn();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public ValleDeLuna() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder())
                .waterColor(WATER_COLOR)
                .waterFogColor(WATER_FOG_COLOR)
                .fogColor(12665870)
                .grassColorOverride(GRASS_COLOR)
                .foliageColorOverride(FOLIAGE_COLOR)
                .skyColor(12665870)
                .ambientParticle(new ParticleEffectAmbience(ParticleTypes.WHITE_ASH, 0.00528F))
                .ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS)
                .build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }

    static {
        DefaultBiomeFeatures.addFossilDecoration(GENERATION_SETTINGS);
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.DESERT_PYRAMID); //Desert Temple
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.RUINED_PORTAL_DESERT); //Ruined Portal Desert
        DefaultBiomeFeatures.addDefaultOverworldLandStructures(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultCarvers(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultMonsterRoom(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultUndergroundVariety(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultOres(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addExtraGold(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addExtraEmeralds(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultSoftDisks(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultMushrooms(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultExtraVegetation(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addSurfaceFreezing(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addFossilDecoration(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDesertExtraDecoration(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addPaloVerdeTrees(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addBYGMushrooms(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addGiantLunaRocks(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addTerracottaBoulder(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addGrass(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addBYGDesertPlants(GENERATION_SETTINGS);
//        GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.VOLCANO);

        SPAWN_SETTINGS.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.RABBIT, 4, 2, 3));
        SPAWN_SETTINGS.addSpawn(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8));
        SPAWN_SETTINGS.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.HUSK, 95, 4, 4));
        SPAWN_SETTINGS.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        SPAWN_SETTINGS.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SKELETON, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.CREEPER, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SLIME, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 10, 1, 4));
        SPAWN_SETTINGS.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.WITCH, 5, 1, 1));

    }
}

