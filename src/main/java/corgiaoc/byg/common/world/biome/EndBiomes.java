package corgiaoc.byg.common.world.biome;

import corgiaoc.byg.core.BYGSounds;
import corgiaoc.byg.core.world.BYGConfiguredFeatures;
import corgiaoc.byg.core.world.BYGConfiguredSurfaceBuilders;
import corgiaoc.byg.mixin.access.VanillaBiomeAccess;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.Features;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class EndBiomes {

    public static Biome bulbisGardens() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.BULBIS_GARDENS);
        generationSettings.addStructureStart(StructureFeatures.END_CITY).addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, Features.END_GATEWAY);
        BYGDefaultBiomeFeatures.addBulbisTrees(generationSettings);
        BYGDefaultBiomeFeatures.addPurpleBulbisTrees(generationSettings);
        BYGDefaultBiomeFeatures.addBulbisOddity(generationSettings);
        BYGDefaultBiomeFeatures.addBulbisAnomaly(generationSettings);
        BYGDefaultBiomeFeatures.addTheriumDeposit(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.THEEND).depth(0.55F).scale(0.15F).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(10040012).waterFogColor(10040012).fogColor(8339307).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.WITCH, 0.00428F)).ambientLoopSound(BYGSounds.AMBIENT_END_FOREST_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_CRIMSON_FOREST_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome bulbisGardensEdge() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.BULBIS_GARDENS_EDGE);
        generationSettings.addStructureStart(StructureFeatures.END_CITY).addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, Features.END_GATEWAY);
        BYGDefaultBiomeFeatures.addSparseBulbisTrees(generationSettings);
        BYGDefaultBiomeFeatures.addBulbisOddity(generationSettings);
        BYGDefaultBiomeFeatures.addBulbisAnomaly(generationSettings);
        BYGDefaultBiomeFeatures.addEnderLily(generationSettings);
        BYGDefaultBiomeFeatures.addIvisPlants(generationSettings);
        BYGDefaultBiomeFeatures.addTheriumDeposit(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.THEEND).depth(0.55F).scale(0.15F).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(10040012).waterFogColor(10040012).fogColor(8339307).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.WITCH, 0.00428F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.WITCH, 0.00428F)).ambientLoopSound(BYGSounds.AMBIENT_END_FOREST_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_CRIMSON_FOREST_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome crypticWastes() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.CRYPTIC_WASTES);
        generationSettings.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGConfiguredFeatures.CRYPTIC_CAVES);
        BYGDefaultBiomeFeatures.addCrypticVents(generationSettings);
        BYGDefaultBiomeFeatures.addCrypticBramble(generationSettings);
        BYGDefaultBiomeFeatures.addCrypticFire(generationSettings);
        generationSettings.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGConfiguredFeatures.CRYPTIC_SPIKE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.ORE_CRYPTIC_REDSTONE);
        BYGDefaultBiomeFeatures.addTheriumDeposit(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.THEEND).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(8339307).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.CRIMSON_SPORE, 0.00428F)).ambientLoopSound(BYGSounds.AMBIENT_END_OMINOUS_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome etherealIslands() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.ETHEREAL_ISLANDS);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.ORE_LIGNITE);
        BYGDefaultBiomeFeatures.addEtherPlants(generationSettings);
        BYGDefaultBiomeFeatures.addSparseEtherTrees(generationSettings);
        BYGDefaultBiomeFeatures.addTheriumDeposit(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.THEEND).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(3905655).waterFogColor(3905655).fogColor(8339307).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.CRIMSON_SPORE, 0.00428F)).ambientLoopSound(BYGSounds.AMBIENT_END_OMINOUS_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome etherealClearing() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.ETHEREAL_CLEARING);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.ORE_LIGNITE);
        BYGDefaultBiomeFeatures.addEtherPlants(generationSettings);
        BYGDefaultBiomeFeatures.addEtherBushes(generationSettings);
        BYGDefaultBiomeFeatures.addTheriumDeposit(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.THEEND).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(3905655).waterFogColor(3905655).fogColor(8339307).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.REVERSE_PORTAL, 0.00128F)).ambientLoopSound(BYGSounds.AMBIENT_END_FOREST_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_CRIMSON_FOREST_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome etherealForest() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.ETHEREAL_FOREST);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.ORE_LIGNITE);
        BYGDefaultBiomeFeatures.addEtherPlants(generationSettings);
        BYGDefaultBiomeFeatures.addEtherTrees(generationSettings);
        BYGDefaultBiomeFeatures.addEtherFoliage(generationSettings);
        BYGDefaultBiomeFeatures.addTheriumDeposit(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.THEEND).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(3905655).waterFogColor(3905655).fogColor(8339307).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.REVERSE_PORTAL, 0.00128F)).ambientLoopSound(BYGSounds.AMBIENT_END_FOREST_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_CRIMSON_FOREST_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

        public static Biome impariusGrove() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.IMPARIUS_GROVE);
        BYGDefaultBiomeFeatures.addImpariusPlants(generationSettings);
        BYGDefaultBiomeFeatures.addFungalImparius(generationSettings);
        BYGDefaultBiomeFeatures.addImpariusMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addEndLake(generationSettings);
        generationSettings.addStructureStart(StructureFeatures.END_CITY).addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, Features.END_GATEWAY);
        BYGDefaultBiomeFeatures.addTheriumDeposit(generationSettings);
//        BYGDefaultBiomeFeatures.addEnderLily(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 2, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.THEEND).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(3722412).waterFogColor(3722412).fogColor(8339307).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.WARPED_SPORE, 0.00428F)).ambientLoopSound(BYGSounds.AMBIENT_END_FOREST_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_NETHER_WASTES_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome impariusClearing() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.IMPARIUS_CLEARING);
        BYGDefaultBiomeFeatures.addImpariusPlants(generationSettings);
        BYGDefaultBiomeFeatures.addImpariusMushroomShrubs(generationSettings);
        BYGDefaultBiomeFeatures.addEndLake(generationSettings);
        generationSettings.addStructureStart(StructureFeatures.END_CITY).addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, Features.END_GATEWAY);
        BYGDefaultBiomeFeatures.addTheriumDeposit(generationSettings);
//        BYGDefaultBiomeFeatures.addEnderLily(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 2, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.THEEND).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(3722412).waterFogColor(3722412).fogColor(8339307).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.WARPED_SPORE, 0.00428F)).ambientLoopSound(BYGSounds.AMBIENT_END_FOREST_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_NETHER_WASTES_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }
    
    public static Biome ivisFields() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.IVIS_FIELDS);
        generationSettings.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGConfiguredFeatures.IVIS_SPIKES);
        generationSettings.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGConfiguredFeatures.IVIS_SPIKES2);
        BYGDefaultBiomeFeatures.addIvisPlants(generationSettings);
        BYGDefaultBiomeFeatures.addBulbisAnomaly(generationSettings);
        generationSettings.addStructureStart(StructureFeatures.END_CITY).addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, Features.END_GATEWAY);
        BYGDefaultBiomeFeatures.addSparsePurpleBulbisTrees(generationSettings);
        BYGDefaultBiomeFeatures.addTheriumDeposit(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.THEEND).depth(0.55F).scale(0.15F).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(8339307).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.WITCH, 0.00428F)).ambientLoopSound(BYGSounds.AMBIENT_END_OMINOUS_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome nightshadeForest() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.NIGHTSHADE_FOREST);
        BYGDefaultBiomeFeatures.addNightshadePlants(generationSettings);
        BYGDefaultBiomeFeatures.addNightShadeTrees(generationSettings);
        generationSettings.addStructureStart(StructureFeatures.END_CITY).addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, Features.END_GATEWAY);
        BYGDefaultBiomeFeatures.addTheriumDeposit(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 2, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PHANTOM, 1, 1, 2));
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.THEEND).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.4F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(8339307).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.ASH, 0.00428F)).ambientLoopSound(BYGSounds.AMBIENT_END_FOREST_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_NETHER_WASTES_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome purpurPeaks() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.PURPUR_PEAKS);
        generationSettings.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGConfiguredFeatures.PURPUR_PEAK);
        BYGDefaultBiomeFeatures.addTheriumDeposit(generationSettings);
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.CHORUS_PLANT);
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.CHORUS_PLANT);
        generationSettings.addStructureStart(StructureFeatures.END_CITY).addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, Features.END_GATEWAY);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.THEEND).depth(0.55F).scale(0.15F).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(8339307).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.ASH, 0.00128F)).ambientLoopSound(BYGSounds.AMBIENT_END_OMINOUS_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SOUL_SAND_VALLEY)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome shatteredDesert() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.SHATTERED_DESERT);
        generationSettings.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGConfiguredFeatures.END_STONE_BRICK_SPIKE);
        generationSettings.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGConfiguredFeatures.END_STONE_BRICK_SPIKE2);
        BYGDefaultBiomeFeatures.addShatteredDesertPlants(generationSettings);
        generationSettings.addStructureStart(StructureFeatures.END_CITY).addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, Features.END_GATEWAY);
        BYGDefaultBiomeFeatures.addTheriumDeposit(generationSettings);
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.CHORUS_PLANT);
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.CHORUS_PLANT);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.THEEND).depth(0.55F).scale(0.15F).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(8339307).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.00428F)).ambientLoopSound(BYGSounds.AMBIENT_END_OMINOUS_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome shatteredDesertIsles() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.SHATTERED_DESERT_ISLES);
        generationSettings.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGConfiguredFeatures.RANDOM_DESERT_END_ISLAND);
        generationSettings.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGConfiguredFeatures.END_STONE_BRICK_SPIKE);
        generationSettings.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGConfiguredFeatures.END_STONE_BRICK_SPIKE2);
        BYGDefaultBiomeFeatures.addShatteredDesertPlants(generationSettings);
        generationSettings.addStructureStart(StructureFeatures.END_CITY).addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, Features.END_GATEWAY);
        BYGDefaultBiomeFeatures.addTheriumDeposit(generationSettings);
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.CHORUS_PLANT);
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.CHORUS_PLANT);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.THEEND).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.4F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(10040012).waterFogColor(10040012).fogColor(8339307).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.00428F)).ambientLoopSound(BYGSounds.AMBIENT_END_OMINOUS_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome shulkrenForest() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.SHULKREN_FOREST);
        BYGDefaultBiomeFeatures.addShulkrenTrees(generationSettings);
        BYGDefaultBiomeFeatures.addShulkrenPlants(generationSettings);
        generationSettings.addStructureStart(StructureFeatures.END_CITY).addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, Features.END_GATEWAY);
        BYGDefaultBiomeFeatures.addTheriumDeposit(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SHULKER, 1, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.THEEND).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.4F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(1415511).waterFogColor(2005339).fogColor(8339307).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.WARPED_SPORE, 0.00128F)).ambientLoopSound(BYGSounds.AMBIENT_END_FOREST_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_CRIMSON_FOREST_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome viscalIsles() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.VISCALISLES);
        generationSettings.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGConfiguredFeatures.RANDOM_ISLAND);
        BYGDefaultBiomeFeatures.addVermilionSculkGrowth(generationSettings);
        BYGDefaultBiomeFeatures.addVermilionSculkTendrils(generationSettings);
        BYGDefaultBiomeFeatures.addHangingTheriumLanterns(generationSettings);
        BYGDefaultBiomeFeatures.addDeadEtherTrees(generationSettings);
        generationSettings.addStructureStart(StructureFeatures.END_CITY).addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, Features.END_GATEWAY);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.THEEND).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.4F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(1415511).waterFogColor(2005339).fogColor(8339307).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.CRIMSON_SPORE, 0.00428F)).ambientLoopSound(BYGSounds.AMBIENT_VISCAL_ISLES_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0010D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome shatteredViscalIsles() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.SHATTERED_VISCAL_ISLES);
        generationSettings.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGConfiguredFeatures.RANDOM_SHATTERED_ISLAND);
        BYGDefaultBiomeFeatures.addVermilionSculkGrowth(generationSettings);
        BYGDefaultBiomeFeatures.addVermilionSculkTendrils(generationSettings);
        BYGDefaultBiomeFeatures.addHangingTheriumLanterns(generationSettings);
        BYGDefaultBiomeFeatures.addDeadEtherTrees(generationSettings);
        generationSettings.addStructureStart(StructureFeatures.END_CITY).addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, Features.END_GATEWAY);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.THEEND).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.4F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(1415511).waterFogColor(2005339).fogColor(8339307).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.CRIMSON_SPORE, 0.00428F)).ambientLoopSound(BYGSounds.AMBIENT_VISCAL_ISLES_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }
}