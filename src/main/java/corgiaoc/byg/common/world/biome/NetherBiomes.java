package corgiaoc.byg.common.world.biome;

import corgiaoc.byg.core.world.BYGConfiguredFeatures;
import corgiaoc.byg.core.world.BYGConfiguredSurfaceBuilders;
import corgiaoc.byg.mixin.access.VanillaBiomeAccess;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.*;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class NetherBiomes {

    public static Biome brimstoneCaverns() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.BRIMSTONE_CAVERNS);
        generationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_CLOSED);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_LAVA);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.PATCH_FIRE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE_EXTRA);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.BROWN_MUSHROOM_NETHER);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.RED_MUSHROOM_NETHER);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA);
        generationSettings.addStructureStart(StructureFeatures.RUINED_PORTAL_NETHER); //NetherPortal
        generationSettings.addStructureStart(StructureFeatures.NETHER_BRIDGE); //Fortress
        generationSettings.addStructureStart(StructureFeatures.BASTION_REMNANT); //BastionRemnant
        BYGDefaultBiomeFeatures.addBrimstoneOres(generationSettings);
        BYGDefaultBiomeFeatures.addBoricFire(generationSettings);
        BYGDefaultBiomeFeatures.addBrimstonePillars(generationSettings);
        BYGDefaultBiomeFeatures.addBrimstoneVents(generationSettings);
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIFIED_PIGLIN, 80, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 100, 2, 5));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 15, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 60, 1, 2));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NETHER).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.0F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(4738078).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(2.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.ASH, 0.01428F)).ambientLoopSound(SoundEvents.AMBIENT_BASALT_DELTAS_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_BASALT_DELTAS)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome crimsonGardens() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.CRIMSON_GARDENS);
        generationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_CLOSED);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_LAVA);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.PATCH_FIRE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE_EXTRA);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.BROWN_MUSHROOM_NETHER);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.RED_MUSHROOM_NETHER);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA);
        BiomeDefaultFeatures.addNetherDefaultOres(generationSettings); //Ores
        generationSettings.addStructureStart(StructureFeatures.RUINED_PORTAL_NETHER); //NetherPortal
        generationSettings.addStructureStart(StructureFeatures.NETHER_BRIDGE); //Fortress
        generationSettings.addStructureStart(StructureFeatures.BASTION_REMNANT); //BastionRemnant
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.WEEPING_VINES);//Weeping Vines
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.CRIMSON_FUNGI); //Crimson Fungi
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.CRIMSON_FOREST_VEGETATION); //Crimson Forest Vegetation
//        generationSettings.withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.LARGE_BASALT_COLUMNS); //Basalt Columns Large

        BYGDefaultBiomeFeatures.addCrimsonGardensVegetation(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.HOGLIN, 9, 3, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIFIED_PIGLIN, 80, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 100, 2, 5));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 15, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 60, 1, 2));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NETHER).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.0F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(4738078).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(2.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.CRIMSON_SPORE, 0.01428F)).ambientLoopSound(SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_CRIMSON_FOREST_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_CRIMSON_FOREST)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();

    }

    public static Biome emburBog() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.EMBUR_BOG);
        generationSettings.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, Features.DELTA);
        generationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_CLOSED);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_LAVA);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.PATCH_FIRE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE_EXTRA);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.BROWN_MUSHROOM_NETHER);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.RED_MUSHROOM_NETHER);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA);
        generationSettings.addStructureStart(StructureFeatures.RUINED_PORTAL_NETHER); //NetherPortal
        generationSettings.addStructureStart(StructureFeatures.NETHER_BRIDGE); //Fortress
        generationSettings.addStructureStart(StructureFeatures.BASTION_REMNANT); //BastionRemnant
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_EMBUR_MUSHROOM);
        BYGDefaultBiomeFeatures.addEmburBogVegetation(generationSettings);
        BYGDefaultBiomeFeatures.addBeeHive(generationSettings);
        BYGDefaultBiomeFeatures.addBlueNetherOres(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.BLAZE, 20, 2, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIFIED_PIGLIN, 80, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 100, 2, 5));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 15, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 60, 1, 2));
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NETHER).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.0F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(4738078).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(2.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.FLAME, 0.00228F)).ambientLoopSound(SoundEvents.AMBIENT_BASALT_DELTAS_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_BASALT_DELTAS)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome glowstoneGardens() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.GLOWSTONE_GARDENS);
        generationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_CLOSED);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_LAVA);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.PATCH_FIRE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE_EXTRA);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.BROWN_MUSHROOM_NETHER);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.RED_MUSHROOM_NETHER);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA);
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.TWISTING_VINES); //Twisting Vines
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.NETHER_SPROUTS); //Nether Sprouts
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.NETHER_SPROUTS); //Nether Sprouts
        generationSettings.addStructureStart(StructureFeatures.RUINED_PORTAL_NETHER); //NetherPortal
        generationSettings.addStructureStart(StructureFeatures.NETHER_BRIDGE); //Fortress
        generationSettings.addStructureStart(StructureFeatures.BASTION_REMNANT); //BastionRemnant

        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.ORE_PERVADED_NETHERRACK);
        BiomeDefaultFeatures.addNetherDefaultOres(generationSettings); //Ores
        BYGDefaultBiomeFeatures.addHugeNetherMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addGlowstoneGardenVegetation(generationSettings);
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.GHAST, 50, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIFIED_PIGLIN, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 2, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 15, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 60, 1, 2));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NETHER).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.0F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(4738078).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(2.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.MYCELIUM, 0.01428F)).ambientLoopSound(SoundEvents.AMBIENT_BASALT_DELTAS_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_BASALT_DELTAS)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();

    }

    public static Biome magmaWastes() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.GLOWSTONE_GARDENS);
        generationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_CLOSED);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_LAVA);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.PATCH_FIRE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE_EXTRA);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.BROWN_MUSHROOM_NETHER);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.RED_MUSHROOM_NETHER);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA);
        BiomeDefaultFeatures.addNetherDefaultOres(generationSettings); //Ores
        generationSettings.addStructureStart(StructureFeatures.RUINED_PORTAL_NETHER); //NetherPortal
        generationSettings.addStructureStart(StructureFeatures.NETHER_BRIDGE); //Fortress
        generationSettings.addStructureStart(StructureFeatures.BASTION_REMNANT); //BastionRemnant
        generationSettings.addStructureStart(StructureFeatures.NETHER_FOSSIL); //Nether Fossils

        BYGDefaultBiomeFeatures.addSparseWitheringOakTrees(generationSettings);
        BYGDefaultBiomeFeatures.addMagmaFire(generationSettings);
        BYGDefaultBiomeFeatures.addMagmaPillars(generationSettings);
        BYGDefaultBiomeFeatures.addScorchedPlants(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.GHAST, 50, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIFIED_PIGLIN, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 100, 2, 5));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 15, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 60, 1, 2));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NETHER).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.0F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(4738078).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(2.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.ASH, 0.01428F)).ambientLoopSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SOUL_SAND_VALLEY)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome quartzDesert() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.QUARTZ_DESERT);
        generationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_CLOSED);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_LAVA);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.PATCH_FIRE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE_EXTRA);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.BROWN_MUSHROOM_NETHER);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.RED_MUSHROOM_NETHER);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA);
        BiomeDefaultFeatures.addNetherDefaultOres(generationSettings); //Ores
        generationSettings.addStructureStart(StructureFeatures.RUINED_PORTAL_NETHER); //NetherPortal
        generationSettings.addStructureStart(StructureFeatures.NETHER_BRIDGE); //Fortress
        generationSettings.addStructureStart(StructureFeatures.BASTION_REMNANT); //BastionRemnant
        generationSettings.addStructureStart(StructureFeatures.NETHER_FOSSIL); //Nether Fossils
        BYGDefaultBiomeFeatures.addQuartzDesertVegetations(generationSettings);
        BYGDefaultBiomeFeatures.addMagmaFire(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.GHAST, 50, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIFIED_PIGLIN, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 2, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 15, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 60, 1, 2));
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NETHER).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.0F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(4738078).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(2.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.01428F)).ambientLoopSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SOUL_SAND_VALLEY)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();

    }

    public static Biome subzeroHypogeal() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.SUBZERO_HYPOGEAL);
        generationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_CLOSED);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_LAVA);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.PATCH_FIRE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE_EXTRA);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.BROWN_MUSHROOM_NETHER);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.RED_MUSHROOM_NETHER);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA);
        generationSettings.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, BYGConfiguredFeatures.SUBZERO_CRYSTAL);
        BiomeDefaultFeatures.addNetherDefaultOres(generationSettings); //Ores
        generationSettings.addStructureStart(StructureFeatures.RUINED_PORTAL_NETHER); //NetherPortal
        generationSettings.addStructureStart(StructureFeatures.NETHER_BRIDGE); //Fortress
        generationSettings.addStructureStart(StructureFeatures.BASTION_REMNANT); //BastionRemnant
        generationSettings.addStructureStart(StructureFeatures.NETHER_FOSSIL); //Nether Fossils

        BYGDefaultBiomeFeatures.addSoulFireWarped(generationSettings);
        BYGDefaultBiomeFeatures.addFrostMagmaPillars(generationSettings);
        BYGDefaultBiomeFeatures.addSubzeroAsh(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.GHAST, 50, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIFIED_PIGLIN, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 2, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 15, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 60, 1, 2));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NETHER).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.0F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(4738078).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(2.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.12428F)).ambientLoopSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SOUL_SAND_VALLEY)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();

    }

    public static Biome sythianTorrids() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.SYTHIAN_TORRIDS);
        generationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_CLOSED);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_LAVA);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.PATCH_FIRE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE_EXTRA);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.BROWN_MUSHROOM_NETHER);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.RED_MUSHROOM_NETHER);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA);
        BYGDefaultBiomeFeatures.addSythianVegetation(generationSettings);
        BiomeDefaultFeatures.addNetherDefaultOres(generationSettings); //Ores
        generationSettings.addStructureStart(StructureFeatures.RUINED_PORTAL_NETHER); //NetherPortal
        generationSettings.addStructureStart(StructureFeatures.NETHER_BRIDGE); //Fortress
        generationSettings.addStructureStart(StructureFeatures.BASTION_REMNANT); //BastionRemnant

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.GHAST, 50, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIFIED_PIGLIN, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 2, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 15, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 60, 1, 2));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NETHER).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.0F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(4738078).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(2.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.CRIMSON_SPORE, 0.01428F)).ambientLoopSound(SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_CRIMSON_FOREST_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_CRIMSON_FOREST)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();

    }

    public static Biome warpedDesert() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.WARPED_DESERT);
        generationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_CLOSED);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_LAVA);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.PATCH_FIRE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE_EXTRA);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.BROWN_MUSHROOM_NETHER);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.RED_MUSHROOM_NETHER);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA);
        BiomeDefaultFeatures.addNetherDefaultOres(generationSettings); //Ores
        generationSettings.addStructureStart(StructureFeatures.RUINED_PORTAL_NETHER); //NetherPortal
        generationSettings.addStructureStart(StructureFeatures.NETHER_BRIDGE); //Fortress
        generationSettings.addStructureStart(StructureFeatures.BASTION_REMNANT); //BastionRemnant

        BYGDefaultBiomeFeatures.addWarpedVegetation(generationSettings);
        BYGDefaultBiomeFeatures.addSoulFireWarped(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.GHAST, 50, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIFIED_PIGLIN, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 2, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 15, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 60, 1, 2));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NETHER).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.0F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(4738078).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(2.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.WARPED_SPORE, 0.01428F)).ambientLoopSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SOUL_SAND_VALLEY)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome wailingGarth() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.WAILING_GARTH);

        generationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_CLOSED);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_LAVA);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.PATCH_FIRE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE_EXTRA);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.BROWN_MUSHROOM_NETHER);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.RED_MUSHROOM_NETHER);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA);
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.NETHER_SPROUTS); //Nether Sprouts
        BiomeDefaultFeatures.addNetherDefaultOres(generationSettings); //Ores
        generationSettings.addStructureStart(StructureFeatures.RUINED_PORTAL_NETHER); //NetherPortal
        generationSettings.addStructureStart(StructureFeatures.NETHER_BRIDGE); //Fortress
        generationSettings.addStructureStart(StructureFeatures.BASTION_REMNANT); //BastionRemnant
        generationSettings.addStructureStart(StructureFeatures.NETHER_FOSSIL); //Nether Fossils
        BYGDefaultBiomeFeatures.addMiniNetherMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addWailingVegetation(generationSettings);
        BYGDefaultBiomeFeatures.addHangingChains(generationSettings);
        BYGDefaultBiomeFeatures.addHangingLanterns(generationSettings);
        BYGDefaultBiomeFeatures.addWailingPillars(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.GHAST, 50, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIFIED_PIGLIN, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 2, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 15, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 60, 1, 2));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HOGLIN, 60, 1, 2));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NETHER).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.0F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(4738078).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(2.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.WARPED_SPORE, 0.01428F)).ambientLoopSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SOUL_SAND_VALLEY)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome witheringWoods() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.WITHERING_WOODS);
        generationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_CLOSED);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_LAVA);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.PATCH_FIRE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE_EXTRA);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.BROWN_MUSHROOM_NETHER);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.RED_MUSHROOM_NETHER);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA);
        BiomeDefaultFeatures.addNetherDefaultOres(generationSettings); //Ores
        generationSettings.addStructureStart(StructureFeatures.RUINED_PORTAL_NETHER); //NetherPortal
        generationSettings.addStructureStart(StructureFeatures.NETHER_BRIDGE); //Fortress
        generationSettings.addStructureStart(StructureFeatures.BASTION_REMNANT); //BastionRemnant
        BYGDefaultBiomeFeatures.addWitheringOakTrees(generationSettings);
        BYGDefaultBiomeFeatures.addMagmaFire(generationSettings);
        BYGDefaultBiomeFeatures.addScorchedPlants(generationSettings);
        BYGDefaultBiomeFeatures.addBlackRose(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.GHAST, 50, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIFIED_PIGLIN, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 100, 2, 5));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 15, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 60, 1, 2));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NETHER).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.0F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(4738078).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(2.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.ASH, 0.01428F)).ambientLoopSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SOUL_SAND_VALLEY)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();

    }

    public static Biome weepingMire() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().surfaceBuilder(BYGConfiguredSurfaceBuilders.WEEPING_MIRE);
        generationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_CLOSED);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_LAVA);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.PATCH_FIRE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE_EXTRA);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.BROWN_MUSHROOM_NETHER);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.RED_MUSHROOM_NETHER);
        generationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA);
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.NETHER_SPROUTS); //Nether Sprouts
        BiomeDefaultFeatures.addNetherDefaultOres(generationSettings); //Ores
        generationSettings.addStructureStart(StructureFeatures.RUINED_PORTAL_NETHER); //NetherPortal
        generationSettings.addStructureStart(StructureFeatures.NETHER_BRIDGE); //Fortress
        generationSettings.addStructureStart(StructureFeatures.BASTION_REMNANT); //BastionRemnant
        BYGDefaultBiomeFeatures.addLamentTrees(generationSettings);
        BYGDefaultBiomeFeatures.addMiniNetherMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addWeepigMireVegetation(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.GHAST, 50, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIFIED_PIGLIN, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 2, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 15, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 60, 1, 2));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HOGLIN, 60, 1, 2));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NETHER).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.0F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(4738078).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(2.0F)).ambientParticle(new AmbientParticleSettings(ParticleTypes.WARPED_SPORE, 0.01428F)).ambientLoopSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D)).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SOUL_SAND_VALLEY)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();

    }
}