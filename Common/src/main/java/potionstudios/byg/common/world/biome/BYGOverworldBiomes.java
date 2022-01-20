package potionstudios.byg.common.world.biome;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import potionstudios.byg.mixin.access.VanillaBiomeAccess;

import static potionstudios.byg.mixin.access.OverworldBiomesAccess.invokeGlobalOverworldGeneration;

public class BYGOverworldBiomes {

    public static void addDefaultOverworldGeneration(BiomeGenerationSettings.Builder generationSettings) {
        invokeGlobalOverworldGeneration(generationSettings);
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
    }

    public static Biome alliumFields() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();

        addDefaultOverworldGeneration(generationSettings);
        BiomeDefaultFeatures.addPlainGrass(generationSettings);
        BiomeDefaultFeatures.addDefaultGrass(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addAlliumFieldFlowers(generationSettings);
        BYGDefaultBiomeFeatures.addSparseRedOakForestTrees(generationSettings);
        BYGDefaultBiomeFeatures.addBeeHive(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 5, 2, 6));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 3));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.PLAINS).temperature(0.8F).downfall(0.4F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome amaranthFields() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        addDefaultOverworldGeneration(generationSettings);
        BiomeDefaultFeatures.addPlainGrass(generationSettings);
        BiomeDefaultFeatures.addDefaultGrass(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);

        BYGDefaultBiomeFeatures.addAmaranthFieldFlowers(generationSettings);
        BYGDefaultBiomeFeatures.addSparseJacarandaTrees(generationSettings);
        BYGDefaultBiomeFeatures.addBeeHive(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 5, 2, 6));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 3));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.PLAINS).temperature(0.8F).downfall(0.4F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome araucariaSavanna(boolean forest) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();

        addDefaultOverworldGeneration(generationSettings);
        BiomeDefaultFeatures.addDefaultGrass(generationSettings);
        BiomeDefaultFeatures.addSavannaTrees(generationSettings);
        BiomeDefaultFeatures.addWarmFlowers(generationSettings);
        BiomeDefaultFeatures.addSavannaExtraGrass(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);

        if (forest) {
            BYGDefaultBiomeFeatures.addAraucariaTrees(generationSettings);
        } else {
            BYGDefaultBiomeFeatures.addSparseAraucariaTrees(generationSettings);
        }
        BYGDefaultBiomeFeatures.addFirecracker(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 1, 2, 6));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 1));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));


        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.SAVANNA).temperature(1.2F).downfall(0.0F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(10860373).foliageColorOverride(10860373).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome aspenForest() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        addDefaultOverworldGeneration(generationSettings);

        BiomeDefaultFeatures.addForestFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultGrass(generationSettings);
        BiomeDefaultFeatures.addForestGrass(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);

        BYGDefaultBiomeFeatures.addAspenTrees(generationSettings);
        BYGDefaultBiomeFeatures.addLeafPile(generationSettings);
        BYGDefaultBiomeFeatures.addRose(generationSettings);
        BYGDefaultBiomeFeatures.addYellowDaffodil(generationSettings);
        BYGDefaultBiomeFeatures.addOrangeDaisy(generationSettings);
        BYGDefaultBiomeFeatures.addBeeHive(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(0.7F).downfall(0.6F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(11909994).foliageColorOverride(5406551).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome autumnalValley() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        addDefaultOverworldGeneration(generationSettings);
        BiomeDefaultFeatures.addDefaultGrass(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);

        BYGDefaultBiomeFeatures.addMeadowShrubs(generationSettings);
        BYGDefaultBiomeFeatures.addLargePumpkins(generationSettings);
        BYGDefaultBiomeFeatures.addCloverFlowerPatch(generationSettings);
        BYGDefaultBiomeFeatures.addAnemones(generationSettings);
        BYGDefaultBiomeFeatures.addCrocus(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.PLAINS).temperature(0.35F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(11513689).foliageColorOverride(12435265).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome baobabSavanna() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);
        BiomeDefaultFeatures.addSavannaGrass(generationSettings);
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addSavannaTrees(generationSettings);
        BiomeDefaultFeatures.addWarmFlowers(generationSettings);
        BiomeDefaultFeatures.addSavannaExtraGrass(generationSettings);

        BYGDefaultBiomeFeatures.addBaobabTrees(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 1, 2, 6));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 1));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.SAVANNA).temperature(1.2F).downfall(0.0F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(10860373).foliageColorOverride(10860373).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome basaltBarrera() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultGrass(generationSettings);
        BiomeDefaultFeatures.addDefaultGrass(generationSettings);
        
        BYGDefaultBiomeFeatures.addBasaltFeatures(generationSettings);

        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.BEACH).temperature(0.85F).downfall(0.75F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome bayou() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addSwampClayDisk(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addSwampExtraVegetation(generationSettings);

        BYGDefaultBiomeFeatures.addBayouVegetation(generationSettings);
        BYGDefaultBiomeFeatures.addBYGSwampVegetation(generationSettings);
        BYGDefaultBiomeFeatures.addCattails(generationSettings);
        BYGDefaultBiomeFeatures.addLeatherFlowers(generationSettings);
        BYGDefaultBiomeFeatures.addMudDisks(generationSettings);
        

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 1, 2, 6));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 1));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.SWAMP).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4815438).waterFogColor(6717479).grassColorOverride(7375928).foliageColorOverride(6337104).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome blackForest() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();

        invokeGlobalOverworldGeneration(generationSettings);
        
        BiomeDefaultFeatures.addMossyStoneBlock(generationSettings);
        BiomeDefaultFeatures.addFerns(generationSettings);
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addGiantTaigaVegetation(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        BiomeDefaultFeatures.addRareBerryBushes(generationSettings);

        BYGDefaultBiomeFeatures.addBlackForestTrees(generationSettings);
        BYGDefaultBiomeFeatures.addLushBlueberries(generationSettings);
        BYGDefaultBiomeFeatures.addMossyStoneBoulder(generationSettings);
        BYGDefaultBiomeFeatures.addRockyStoneBoulder(generationSettings);
        BYGDefaultBiomeFeatures.addAnemones(generationSettings);
        BYGDefaultBiomeFeatures.addSages(generationSettings);
        BYGDefaultBiomeFeatures.addWinterSucculent(generationSettings);
        BYGDefaultBiomeFeatures.addBlackRose(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 25, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.TAIGA).temperature(0.25F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(5011004).foliageColorOverride(2263842).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome borealisGrove() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);

        BiomeDefaultFeatures.addForestFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addForestGrass(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);

        BYGDefaultBiomeFeatures.addBorealTrees(generationSettings);
        BYGDefaultBiomeFeatures.addBlueberries(generationSettings);
        BYGDefaultBiomeFeatures.addCrocus(generationSettings);
        BYGDefaultBiomeFeatures.addIris(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(0.25F).downfall(0.5F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(5011004).foliageColorOverride(6589494).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome canadianShield() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);

        BiomeDefaultFeatures.addMossyStoneBlock(generationSettings);
        BiomeDefaultFeatures.addFerns(generationSettings);

        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addGiantTaigaVegetation(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);


        BYGDefaultBiomeFeatures.addCanadianShieldTrees(generationSettings);
        BYGDefaultBiomeFeatures.addScarceSpruceTrees(generationSettings);
        BYGDefaultBiomeFeatures.addSparseAspenTrees(generationSettings);
        BYGDefaultBiomeFeatures.addAnemones(generationSettings);
        BYGDefaultBiomeFeatures.addSages(generationSettings);
        BYGDefaultBiomeFeatures.addBlueberries(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.SNOW).biomeCategory(Biome.BiomeCategory.EXTREME_HILLS).temperature(0.25F).downfall(0.5F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome cherryBlossomForest() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();

        invokeGlobalOverworldGeneration(generationSettings);
        
        BiomeDefaultFeatures.addForestFlowers(generationSettings);
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultGrass(generationSettings);
        BiomeDefaultFeatures.addForestGrass(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);

        BYGDefaultBiomeFeatures.addCherryTrees(generationSettings);
        BYGDefaultBiomeFeatures.addJapaneseOrchid(generationSettings);
        BYGDefaultBiomeFeatures.addLeafPile(generationSettings);
        BYGDefaultBiomeFeatures.addCherryFoliage(generationSettings);
        BYGDefaultBiomeFeatures.addCloverFlowerPatch(generationSettings);
        BYGDefaultBiomeFeatures.addBeeHive(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(0.7F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(10999916).foliageColorOverride(10999916).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome cikaWoods() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();

        invokeGlobalOverworldGeneration(generationSettings);
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultGrass(generationSettings);
        BiomeDefaultFeatures.addForestGrass(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        BiomeDefaultFeatures.addRareBerryBushes(generationSettings);

        BYGDefaultBiomeFeatures.addCikaTrees(generationSettings);
        BYGDefaultBiomeFeatures.addLargePumpkins(generationSettings);
        BYGDefaultBiomeFeatures.addAnemones(generationSettings);
        BYGDefaultBiomeFeatures.addCrocus(generationSettings);
        BYGDefaultBiomeFeatures.addIris(generationSettings);
        BYGDefaultBiomeFeatures.addWinterSucculent(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(0.35F).downfall(0.5F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(13414235).foliageColorOverride(13414235).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome coniferousForest(boolean snowy) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();

        invokeGlobalOverworldGeneration(generationSettings);
        
        BiomeDefaultFeatures.addMossyStoneBlock(generationSettings);
        BiomeDefaultFeatures.addFerns(generationSettings);
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addTaigaGrass(generationSettings);
        BiomeDefaultFeatures.addGiantTaigaVegetation(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        BiomeDefaultFeatures.addRareBerryBushes(generationSettings);

        BYGDefaultBiomeFeatures.addConiferousTrees(generationSettings);
        BYGDefaultBiomeFeatures.addBlueberries(generationSettings);
        BYGDefaultBiomeFeatures.addCrocus(generationSettings);
        BYGDefaultBiomeFeatures.addIris(generationSettings);
        BYGDefaultBiomeFeatures.addWinterSucculent(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        if (snowy) {
            
        }


        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(snowy ? EntityType.HUSK : EntityType.ZOMBIE, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 25, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(snowy ? Biome.Precipitation.SNOW : Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.TAIGA).temperature(snowy ? -0.5F : 0.25F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(5011004).foliageColorOverride(2263842).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome cragGardens() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();

        BYGDefaultBiomeFeatures.addLargeLake(generationSettings);
        BYGDefaultBiomeFeatures.addCattails(generationSettings);
        BYGDefaultBiomeFeatures.addBYGLilyPad(generationSettings);
        BYGDefaultBiomeFeatures.addMarshGrass(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        
        BYGDefaultBiomeFeatures.addCragRainbowTrees(generationSettings);
        BYGDefaultBiomeFeatures.addBYGTropicFlowers(generationSettings);
        BiomeDefaultFeatures.addJungleTrees(generationSettings);
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_NORMAL);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 5, 2, 6));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 3));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.JUNGLE).temperature(1.0F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(8170451).waterFogColor(6200521).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome cypressSwamplands() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addSwampClayDisk(generationSettings);
        BiomeDefaultFeatures.addDefaultGrass(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addSwampExtraVegetation(generationSettings);
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);

        BYGDefaultBiomeFeatures.addCypressTrees(generationSettings);
        BYGDefaultBiomeFeatures.addBYGSwampVegetation(generationSettings);
        BYGDefaultBiomeFeatures.addCattails(generationSettings);
        BYGDefaultBiomeFeatures.addLeatherFlowers(generationSettings);
        BYGDefaultBiomeFeatures.addMudDisks(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.SWAMP).temperature(0.25F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(6337104).foliageColorOverride(6337104).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome deadSea() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);

        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_NORMAL);

        BYGDefaultBiomeFeatures.addDeadSeaSpires(generationSettings);

        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 15, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.OCEAN).temperature(2.0F).downfall(0.0F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(9230578).waterFogColor(2835532).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome deciduousForest(boolean snowy) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);
        
        BiomeDefaultFeatures.addForestFlowers(generationSettings);
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        BYGDefaultBiomeFeatures.addDeciduousTrees(generationSettings);
        BYGDefaultBiomeFeatures.addLeafPile(generationSettings);
        BYGDefaultBiomeFeatures.addHorseweed(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addAzalea(generationSettings);
        BYGDefaultBiomeFeatures.addBeeHive(generationSettings);
        BYGDefaultBiomeFeatures.addBYGWhitePuffball(generationSettings);

        if (snowy) {
            
        }

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(snowy ? Biome.Precipitation.SNOW : Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(snowy ? -0.5F : 0.7F).downfall(0.5F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(9230578).waterFogColor(2835532).grassColorOverride(snowy ? 12032353 : 8627537).foliageColorOverride(snowy ? 12215394 : 6589494).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome daciteRidges() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();

        //Ruined Portal Mountain
        invokeGlobalOverworldGeneration(generationSettings);
        BiomeDefaultFeatures.addFerns(generationSettings);
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addGiantTaigaVegetation(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        BiomeDefaultFeatures.addMossyStoneBlock(generationSettings);

        BYGDefaultBiomeFeatures.addDaciteRidgeTrees(generationSettings);
        BYGDefaultBiomeFeatures.addCrocus(generationSettings);
        BYGDefaultBiomeFeatures.addIris(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addWinterSucculent(generationSettings);
        BYGDefaultBiomeFeatures.addHollyTrees(generationSettings);
        BYGDefaultBiomeFeatures.addLushBlueberries(generationSettings);
        BYGDefaultBiomeFeatures.addMossyStoneBoulder(generationSettings);
        BYGDefaultBiomeFeatures.addRockyStoneBoulder(generationSettings);
        

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.EXTREME_HILLS).temperature(0.25F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(9230578).waterFogColor(2835532).grassColorOverride(5011004).foliageColorOverride(2263842).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome windsweptDunes() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addFossilDecoration(generationSettings);
        invokeGlobalOverworldGeneration(generationSettings);
        BYGDefaultBiomeFeatures.addBYGDesertPlants(generationSettings);
//        generationSettings.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGConfiguredFeatures.WINDSWEPT_ARCH);
        BYGDefaultBiomeFeatures.addWindsweptBoulders(generationSettings);
        BYGDefaultBiomeFeatures.addPalmTree(generationSettings);
        BiomeDefaultFeatures.addDefaultCrystalFormations(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultGrass(generationSettings);

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.DESERT).temperature(2.0F).downfall(0.0F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(6200521).waterFogColor(6200521).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome ebonyWoods() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();


        BYGDefaultBiomeFeatures.addEbonyTrees(generationSettings);
        BYGDefaultBiomeFeatures.addHugeMushrooms(generationSettings);
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);

        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addAnemones(generationSettings);
        BYGDefaultBiomeFeatures.addHorseweed(generationSettings);
        BYGDefaultBiomeFeatures.addLeafPile(generationSettings);
        BYGDefaultBiomeFeatures.addBeeHive(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(5406551).foliageColorOverride(6589494).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome enchantedForest() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();

        BYGDefaultBiomeFeatures.addEnchantedTrees(generationSettings);
        BYGDefaultBiomeFeatures.addHugeMushrooms(generationSettings);
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);

        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addCloverFlowerPatch(generationSettings);
        BYGDefaultBiomeFeatures.addFairyslipper(generationSettings);
        BYGDefaultBiomeFeatures.addCyanRose(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(8560845).foliageColorOverride(11898572).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome enchantedGrove(boolean flowering) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();

        BYGDefaultBiomeFeatures.addEnchantedGroveTrees(generationSettings);
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);

        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addCloverFlowerPatch(generationSettings);
        BYGDefaultBiomeFeatures.addAnemones(generationSettings);
        BYGDefaultBiomeFeatures.addSages(generationSettings);

        if (flowering) {
            BYGDefaultBiomeFeatures.addTulips(generationSettings);
            BYGDefaultBiomeFeatures.addGiantFlowerFeatures(generationSettings);
            BYGDefaultBiomeFeatures.addSunFlowers(generationSettings);
        }

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.PLAINS).temperature(0.75F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(8560845).foliageColorOverride(11898572).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome forestFault() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();

        invokeGlobalOverworldGeneration(generationSettings);
        
        BiomeDefaultFeatures.addMossyStoneBlock(generationSettings);
        BiomeDefaultFeatures.addFerns(generationSettings);
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addGiantTaigaVegetation(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        
        BiomeDefaultFeatures.addRareBerryBushes(generationSettings);
        BYGDefaultBiomeFeatures.addSparseBlackForestTrees(generationSettings);
        BYGDefaultBiomeFeatures.addLushBlueberries(generationSettings);
        BYGDefaultBiomeFeatures.addMossyStoneBoulder(generationSettings);
        BYGDefaultBiomeFeatures.addRockyStoneBoulder(generationSettings);
        BYGDefaultBiomeFeatures.addAnemones(generationSettings);
        BYGDefaultBiomeFeatures.addSages(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addWinterSucculent(generationSettings);
        BYGDefaultBiomeFeatures.addBlackRose(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.TAIGA).temperature(0.25F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(5011004).foliageColorOverride(2263842).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome forgottenForest() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();

        BYGDefaultBiomeFeatures.addAncientTrees(generationSettings);
        BYGDefaultBiomeFeatures.addMeadowTrees(generationSettings);
        BYGDefaultBiomeFeatures.addShrub(generationSettings);
        BYGDefaultBiomeFeatures.addHugeMushrooms(generationSettings);
        invokeGlobalOverworldGeneration(generationSettings);


        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);

        BYGDefaultBiomeFeatures.addLolliPop(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addFairyslipper(generationSettings);
        BYGDefaultBiomeFeatures.addFairyslipper(generationSettings);
        BYGDefaultBiomeFeatures.addBlackRose(generationSettings);
        BYGDefaultBiomeFeatures.addRose(generationSettings);
        BYGDefaultBiomeFeatures.addLushBlueberries(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(5406551).foliageColorOverride(6589494).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }


    public static Biome frostedTaiga(boolean snowy, boolean giant) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();

        invokeGlobalOverworldGeneration(generationSettings);
        BiomeDefaultFeatures.addFerns(generationSettings);
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        BiomeDefaultFeatures.addTaigaGrass(generationSettings);
        BiomeDefaultFeatures.addRareBerryBushes(generationSettings);


        if (giant) {
            BYGDefaultBiomeFeatures.addGiantBlueTaigaTrees(generationSettings);
        } else {
            BYGDefaultBiomeFeatures.addBlueTaigaTrees(generationSettings);
        }
        BYGDefaultBiomeFeatures.addBlueberries(generationSettings);
        BYGDefaultBiomeFeatures.addCrocus(generationSettings);
        BYGDefaultBiomeFeatures.addIris(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);


        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(snowy ? Biome.Precipitation.SNOW : Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.TAIGA).temperature(snowy ? -0.5F : 0.25F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome fungalPatch() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addWarmFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        
        BiomeDefaultFeatures.addJungleTrees(generationSettings);
        
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addTropFungalMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addBYGTropicFlowers(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, 40, 1, 2));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 2, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.JUNGLE).temperature(0.95F).downfall(0.9F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(10145074).foliageColorOverride(10145074).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome greatLakes() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addSwampClayDisk(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultGrass(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        
        
        BiomeDefaultFeatures.addMountainTrees(generationSettings);
        BiomeDefaultFeatures.addMountainTrees(generationSettings);
        BYGDefaultBiomeFeatures.addBYGLilyPad(generationSettings);
        BYGDefaultBiomeFeatures.addCattails(generationSettings);
        BYGDefaultBiomeFeatures.addBYGWhitePuffball(generationSettings);

        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 100, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.TAIGA).temperature(0.25F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(10662752).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome greatLakeIsles() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addSwampClayDisk(generationSettings);
        BiomeDefaultFeatures.addWaterTrees(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultGrass(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        
        
        BYGDefaultBiomeFeatures.addScarceSpruceTrees(generationSettings);
        BYGDefaultBiomeFeatures.addBlueberries(generationSettings);
        BYGDefaultBiomeFeatures.addCrocus(generationSettings);
        BYGDefaultBiomeFeatures.addOsiria(generationSettings);
        BYGDefaultBiomeFeatures.addIris(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addCattails(generationSettings);
        BYGDefaultBiomeFeatures.addCattails(generationSettings);

        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 100, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.TAIGA).temperature(0.8F).downfall(0.2F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(10662752).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }


    public static Biome grove(boolean flowering) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        BYGDefaultBiomeFeatures.addGroveTrees(generationSettings);
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);

        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addCloverFlowerPatch(generationSettings);
        BYGDefaultBiomeFeatures.addAnemones(generationSettings);
        BYGDefaultBiomeFeatures.addSages(generationSettings);
        BYGDefaultBiomeFeatures.addBeeHive(generationSettings);
        BYGDefaultBiomeFeatures.addBYGWhitePuffball(generationSettings);

        if (flowering) {
            BYGDefaultBiomeFeatures.addTulips(generationSettings);
            BYGDefaultBiomeFeatures.addSunFlowers(generationSettings);
        }

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.PLAINS).temperature(0.75F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(11190111).foliageColorOverride(11190111).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome guianaShield() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addWarmFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        
        BYGDefaultBiomeFeatures.addRainForestTrees(generationSettings);
        BYGDefaultBiomeFeatures.addWeedGrass(generationSettings);
        BYGDefaultBiomeFeatures.addBYGTropicFlowers(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, 40, 1, 2));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 2, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.JUNGLE).temperature(0.95F).downfall(0.9F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(6208527).foliageColorOverride(6208527).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome jacarandaForest() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);
        
        BiomeDefaultFeatures.addForestFlowers(generationSettings);
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        BYGDefaultBiomeFeatures.addJacarandaTrees(generationSettings);
        BYGDefaultBiomeFeatures.addBYGBambooJungleVegetation(generationSettings);
        BYGDefaultBiomeFeatures.addBYGTropicFlowers(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addDelphinium(generationSettings);
        BYGDefaultBiomeFeatures.addJacarandaBushes(generationSettings);
        BYGDefaultBiomeFeatures.addLeafPile(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.JUNGLE).temperature(0.95F).downfall(0.5F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(10145074).foliageColorOverride(14180771).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome lushTundra() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addWinterScilla(generationSettings);
        BYGDefaultBiomeFeatures.addRockyStoneBoulder(generationSettings);
        

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 10, 2, 3));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.POLAR_BEAR, 1, 1, 2));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 20, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.STRAY, 80, 4, 4));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.SNOW).biomeCategory(Biome.BiomeCategory.ICY).temperature(0.35F).downfall(0.4F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(10044989).foliageColorOverride(10044989).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome mangroveMarshes() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        BYGDefaultBiomeFeatures.addMangroveTrees(generationSettings);
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addSwampClayDisk(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addSwampExtraVegetation(generationSettings);
        
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_NORMAL);
        BYGDefaultBiomeFeatures.addBYGSwampVegetation(generationSettings);
        BYGDefaultBiomeFeatures.addCattails(generationSettings);
        BYGDefaultBiomeFeatures.addLeatherFlowers(generationSettings);
        BYGDefaultBiomeFeatures.addMudDisks(generationSettings);
        

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.SWAMP).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(6337104).foliageColorOverride(6337104).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome mapleTaiga() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();


        BYGDefaultBiomeFeatures.addMapleTrees(generationSettings);
        BYGDefaultBiomeFeatures.addSmallSpruceTrees(generationSettings);
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);

        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addAnemones(generationSettings);
        BYGDefaultBiomeFeatures.addSages(generationSettings);
        BYGDefaultBiomeFeatures.addRose(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.TAIGA).temperature(0.25F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(5406551).foliageColorOverride(6589494).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome marshlands() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addSwampClayDisk(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addSwampExtraVegetation(generationSettings);
        
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_NORMAL);
        BiomeDefaultFeatures.addFossilDecoration(generationSettings);
        BYGDefaultBiomeFeatures.addBYGSwampVegetation(generationSettings);
        BYGDefaultBiomeFeatures.addMarshGrass(generationSettings);
        BYGDefaultBiomeFeatures.addWiltedGrass(generationSettings);
        BYGDefaultBiomeFeatures.addWiltedGrass(generationSettings);
        BYGDefaultBiomeFeatures.addCattails(generationSettings);
        

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1));
        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.SWAMP).temperature(0.25F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(6388580).waterFogColor(2302743).grassColorOverride(6337104).foliageColorOverride(6337104).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome coconinoMeadow(boolean flowering, boolean wooded) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        if (wooded) {
            BYGDefaultBiomeFeatures.addMeadowTrees(generationSettings);
            spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
        }
        BYGDefaultBiomeFeatures.addMeadowShrubs(generationSettings);
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);

        BYGDefaultBiomeFeatures.addShrub(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addBYGWhitePuffball(generationSettings);
        BYGDefaultBiomeFeatures.addCloverFlowerPatch(generationSettings);
        BYGDefaultBiomeFeatures.addAnemones(generationSettings);
        BYGDefaultBiomeFeatures.addAzalea(generationSettings);
        BYGDefaultBiomeFeatures.addAlpineBellflower(generationSettings);
        if (flowering) {
            BYGDefaultBiomeFeatures.addTulips(generationSettings);
            BYGDefaultBiomeFeatures.addSunFlowers(generationSettings);
            BiomeDefaultFeatures.addForestFlowers(generationSettings);
        }

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.PLAINS).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(6530407).foliageColorOverride(5999709).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome mojaveDesert() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addFossilDecoration(generationSettings);
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultGrass(generationSettings);
        BiomeDefaultFeatures.addDesertVegetation(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDesertExtraVegetation(generationSettings);
        
        BiomeDefaultFeatures.addDesertExtraDecoration(generationSettings);
        
        BYGDefaultBiomeFeatures.addMiniCactus(generationSettings);
        BYGDefaultBiomeFeatures.addJoshuaTrees(generationSettings);
        BYGDefaultBiomeFeatures.addBYGDesertPlants(generationSettings);
        BYGDefaultBiomeFeatures.addFirecracker(generationSettings);
        BiomeDefaultFeatures.addDesertExtraVegetation(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BiomeDefaultFeatures.addBadlandGrass(generationSettings);
        BYGDefaultBiomeFeatures.addBushes(generationSettings);

        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 19, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 1, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.HUSK, 80, 4, 4));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.DESERT).temperature(2.0F).downfall(0.0F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome northernForest() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addWinterScilla(generationSettings);
        BYGDefaultBiomeFeatures.addWinterRose(generationSettings);
        BYGDefaultBiomeFeatures.addSnowdrops(generationSettings);
        BYGDefaultBiomeFeatures.addRockyStoneBoulder(generationSettings);
        BYGDefaultBiomeFeatures.addNorthernForestTrees(generationSettings);
        

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SNOW_GOLEM, 1, 1, 2));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 10, 2, 3));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.POLAR_BEAR, 1, 1, 2));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 20, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.STRAY, 80, 4, 4));


        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.SNOW).biomeCategory(Biome.BiomeCategory.ICY).temperature(-0.15F).downfall(0.4F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(10044989).foliageColorOverride(10044989).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();

    }

    public static Biome orchard() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        BYGDefaultBiomeFeatures.addOrchardTrees(generationSettings);
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);

        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addCloverFlowerPatch(generationSettings);
        BYGDefaultBiomeFeatures.addLolliPop(generationSettings);
        BYGDefaultBiomeFeatures.addYellowDaffodil(generationSettings);
        BYGDefaultBiomeFeatures.addPinkAllium(generationSettings);
        BYGDefaultBiomeFeatures.addBeeHive(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.PLAINS).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(10210365).foliageColorOverride(10210365).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome prairie() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        BYGDefaultBiomeFeatures.addPrairieTree(generationSettings);
        BYGDefaultBiomeFeatures.addSparseOakForestTrees(generationSettings);
        BYGDefaultBiomeFeatures.addPrairieGrass(generationSettings);
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        
        BYGDefaultBiomeFeatures.addCaliforniaPoppy(generationSettings);
        BYGDefaultBiomeFeatures.addBeeHive(generationSettings);
        BYGDefaultBiomeFeatures.addBYGWhitePuffball(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 5, 2, 6));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 3));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.PLAINS).temperature(0.8F).downfall(0.2F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(10003745).foliageColorOverride(10003745).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome pumpkinForest() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        BYGDefaultBiomeFeatures.addDeadHazelTrees(generationSettings);
        BYGDefaultBiomeFeatures.addWitchPumpkins(generationSettings);
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);

        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addAnemones(generationSettings);
        BYGDefaultBiomeFeatures.addAzalea(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(0.25F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(5406551).foliageColorOverride(6589494).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();

    }

    public static Biome rainbowBeach() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultGrass(generationSettings);
        
        BYGDefaultBiomeFeatures.addBeachGrass(generationSettings);

        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.BEACH).temperature(0.85F).downfall(0.75F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4566514).waterFogColor(267827).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome redDesert(boolean lush) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addFossilDecoration(generationSettings);
        invokeGlobalOverworldGeneration(generationSettings);
//        BiomeDefaultFeatures.addDesertLakes(generationSettings); // TODO: Lava lakes?
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultGrass(generationSettings);
        BiomeDefaultFeatures.addDesertVegetation(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDesertExtraVegetation(generationSettings);
        
        BiomeDefaultFeatures.addDesertExtraDecoration(generationSettings);
        
        BYGDefaultBiomeFeatures.addMiniCactus(generationSettings);
        if (lush) {
            BYGDefaultBiomeFeatures.addPaloVerdeTrees(generationSettings);
        }

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 19, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 1, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.HUSK, 80, 4, 4));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.DESERT).temperature(2.0F).downfall(0.0F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome redOakForest() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();

        invokeGlobalOverworldGeneration(generationSettings);
        
        BiomeDefaultFeatures.addForestFlowers(generationSettings);
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addForestGrass(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        BYGDefaultBiomeFeatures.addRedOakForestTrees(generationSettings);
        BYGDefaultBiomeFeatures.addShortGrass(generationSettings);
        BYGDefaultBiomeFeatures.addLeafPile(generationSettings);
        BYGDefaultBiomeFeatures.addAzalea(generationSettings);
        BYGDefaultBiomeFeatures.addHorseweed(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addBeeHive(generationSettings);
        BYGDefaultBiomeFeatures.addBYGWhitePuffball(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(0.8F).downfall(0.9F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome redRockValley() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addExtraGold(generationSettings);
        BiomeDefaultFeatures.addExtraEmeralds(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        
        BYGDefaultBiomeFeatures.addTerracottaBoulder(generationSettings);
        BYGDefaultBiomeFeatures.addPaloVerdeTrees(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addFirecracker(generationSettings);
//        generationSettings.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGConfiguredFeatures.ARCH);
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.HUSK, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.DESERT).temperature(1.2F).downfall(0.1F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(10855786).foliageColorOverride(10855786).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome redwoodThicket() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);
        
        BiomeDefaultFeatures.addForestFlowers(generationSettings);
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        BiomeDefaultFeatures.addFerns(generationSettings);
        BYGDefaultBiomeFeatures.addRockyStoneBoulder(generationSettings);
        BYGDefaultBiomeFeatures.addMossyStoneBoulder(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addLeafPile(generationSettings);
        BYGDefaultBiomeFeatures.addRedwoodTrees(generationSettings);
        BYGDefaultBiomeFeatures.addGrasslandBoulders(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(0.9F).downfall(0.9F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(8896351).foliageColorOverride(8896351).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome redTaiga() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        BYGDefaultBiomeFeatures.addBlueberries(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        
        BYGDefaultBiomeFeatures.addCrocus(generationSettings);
        BYGDefaultBiomeFeatures.addIris(generationSettings);
        BiomeDefaultFeatures.addFerns(generationSettings);
        BYGDefaultBiomeFeatures.addScarceSpruceTrees(generationSettings);
        BYGDefaultBiomeFeatures.addRedSpruceTrees(generationSettings);
        BYGDefaultBiomeFeatures.addRedSpruceTrees(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 5, 2, 6));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 3));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));


        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.TAIGA).temperature(0.8F).downfall(0.4F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome rockyBeach() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultGrass(generationSettings);
        
        BYGDefaultBiomeFeatures.addBeachGrass(generationSettings);
        BYGDefaultBiomeFeatures.addRockyStoneBoulder(generationSettings);

        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.BEACH).temperature(0.25F).downfall(0.4F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome roseFields() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        BYGDefaultBiomeFeatures.addRoseFieldFlowers(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 5, 2, 6));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 3));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.PLAINS).temperature(0.8F).downfall(0.4F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(8231780).foliageColorOverride(8231780).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome autumnalForest() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();

        invokeGlobalOverworldGeneration(generationSettings);
        
        BiomeDefaultFeatures.addForestFlowers(generationSettings);
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        BYGDefaultBiomeFeatures.addSeasonalForestTrees(generationSettings);
        BiomeDefaultFeatures.addOtherBirchTrees(generationSettings);
        BYGDefaultBiomeFeatures.addLeafPile(generationSettings);
        BYGDefaultBiomeFeatures.addAnemones(generationSettings);
        BYGDefaultBiomeFeatures.addCrocus(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addBeeHive(generationSettings);
        BYGDefaultBiomeFeatures.addBYGWhitePuffball(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));


        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(0.25F).downfall(0.9F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(12435265).foliageColorOverride(12435265).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome autumnalTaiga(boolean giant) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();

        invokeGlobalOverworldGeneration(generationSettings);
        BiomeDefaultFeatures.addFerns(generationSettings);
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addGiantTaigaVegetation(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        BiomeDefaultFeatures.addCommonBerryBushes(generationSettings);

        if (giant) {
            BYGDefaultBiomeFeatures.addGiantSeasonalTaigaTrees(generationSettings);
        } else {
            BYGDefaultBiomeFeatures.addSeasonalTaigaTrees(generationSettings);
        }

        BYGDefaultBiomeFeatures.addBlueberries(generationSettings);
        BYGDefaultBiomeFeatures.addLeafPile(generationSettings);
        BYGDefaultBiomeFeatures.addAnemones(generationSettings);
        BYGDefaultBiomeFeatures.addCrocus(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addWinterSucculent(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.TAIGA).temperature(0.25F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(11513689).foliageColorOverride(12435265).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome shatteredGlacier() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);
        BiomeDefaultFeatures.addFerns(generationSettings);
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        BiomeDefaultFeatures.addTaigaGrass(generationSettings);
        BYGDefaultBiomeFeatures.addWinterGrass(generationSettings);
        BYGDefaultBiomeFeatures.addWinterRose(generationSettings);
        BYGDefaultBiomeFeatures.addFrostMagmaLakes(generationSettings);
//        generationSettings.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, BYGConfiguredFeatures.BLACK_ICE_SNOW);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 10, 2, 3));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.POLAR_BEAR, 1, 1, 2));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SNOW_GOLEM, 1, 1, 2));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 20, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.STRAY, 80, 4, 4));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.SNOW).biomeCategory(Biome.BiomeCategory.ICY).temperature(-0.5F).downfall(0.9F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome firecrackerShrublands() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        BYGDefaultBiomeFeatures.addSparseOakForestTrees(generationSettings);
        BYGDefaultBiomeFeatures.addShrub(generationSettings);
        BYGDefaultBiomeFeatures.addFirecrackerShrubs(generationSettings);
        BYGDefaultBiomeFeatures.addFirecracker(generationSettings);
        invokeGlobalOverworldGeneration(generationSettings);


        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        
        BiomeDefaultFeatures.addDesertVegetation(generationSettings);
        BYGDefaultBiomeFeatures.addDefaultLilyPad(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 5, 2, 6));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 3));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.DESERT).temperature(2.0F).downfall(0.4F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(9874031).foliageColorOverride(7048739).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome sierraValley() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();


        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addExtraGold(generationSettings);
        BiomeDefaultFeatures.addExtraEmeralds(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        
        BYGDefaultBiomeFeatures.addTerracottaBoulder(generationSettings);
        BiomeDefaultFeatures.addBadlandGrass(generationSettings);
        BYGDefaultBiomeFeatures.addPaloVerdeTrees(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addFirecracker(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.HUSK, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.PLAINS).temperature(1.2F).downfall(0.1F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(10855786).foliageColorOverride(10855786).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome skyrisVale() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        BYGDefaultBiomeFeatures.addSkyrisTrees(generationSettings);
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        BiomeDefaultFeatures.addExtraEmeralds(generationSettings);
        BYGDefaultBiomeFeatures.addRockyStoneBoulder(generationSettings);
        BYGDefaultBiomeFeatures.addMossyStoneBoulder(generationSettings);
        BYGDefaultBiomeFeatures.addFoxgloves(generationSettings);
        BYGDefaultBiomeFeatures.addCrocus(generationSettings);
        BYGDefaultBiomeFeatures.addFairyslipper(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.EXTREME_HILLS).temperature(0.25F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(6409356).foliageColorOverride(7135854).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome snowyBlackBeach(boolean rocky) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultGrass(generationSettings);
        
        
        if (rocky) {
            BYGDefaultBiomeFeatures.addRockyStoneBoulder(generationSettings);
        }

        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.SNOW).biomeCategory(Biome.BiomeCategory.BEACH).temperature(0.0F).downfall(0.4F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome fragmentForest(boolean pointed) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();


        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addWarmFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        BYGDefaultBiomeFeatures.addStoneForestTrees(generationSettings);
        BYGDefaultBiomeFeatures.addBYGTropicFlowers(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addRockyStoneBoulder(generationSettings);
        BYGDefaultBiomeFeatures.addMossyStoneBoulder(generationSettings);
        BYGDefaultBiomeFeatures.addBeeHive(generationSettings);
//        generationSettings.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGConfiguredFeatures.STONE_FOREST_COLUMN);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, 40, 1, 2));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 2, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(0.25F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(10145074).foliageColorOverride(10145074).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome tropicalForest() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addWarmFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        
        BiomeDefaultFeatures.addJungleTrees(generationSettings);
        
        BYGDefaultBiomeFeatures.addFungalRainForestTrees(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addTropFungalMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addWeedGrass(generationSettings);
        BYGDefaultBiomeFeatures.addBYGTropicFlowers(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addBeeHive(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, 40, 1, 2));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 2, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.JUNGLE).temperature(0.95F).downfall(0.9F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(10145074).foliageColorOverride(10145074).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome tropicalIslands() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        
        BYGDefaultBiomeFeatures.addCragRainbowTrees(generationSettings);
        BYGDefaultBiomeFeatures.addBYGTropicFlowers(generationSettings);
        invokeGlobalOverworldGeneration(generationSettings);
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addWarmFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        
        BiomeDefaultFeatures.addJungleTrees(generationSettings);

        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addMGCoral(generationSettings);
        BYGDefaultBiomeFeatures.addBeeHive(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, 40, 1, 2));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.JUNGLE).temperature(0.95F).downfall(0.9F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(10145074).foliageColorOverride(10145074).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome twilightValley() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addForestFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        BYGDefaultBiomeFeatures.addBrownZelkovaTrees(generationSettings);
        BYGDefaultBiomeFeatures.addBlueberries(generationSettings);
        BYGDefaultBiomeFeatures.addAzalea(generationSettings);
        BYGDefaultBiomeFeatures.addAnemones(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addMossyStoneBoulder(generationSettings);
        BYGDefaultBiomeFeatures.addRockyStoneBoulder(generationSettings);
        BYGDefaultBiomeFeatures.addGraniteBoulder(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(0.25F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(9470285).foliageColorOverride(9470285).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_CRIMSON_FOREST_MOOD, 6000, 8, 2.0D)).ambientParticle(new AmbientParticleSettings(ParticleTypes.END_ROD, 0.00028F)).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome weepingWitchForest() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();

        invokeGlobalOverworldGeneration(generationSettings);
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);

        BYGDefaultBiomeFeatures.addDeadHazelTrees(generationSettings);
        BYGDefaultBiomeFeatures.addHugeMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addSmallSpruceTrees(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addAnemones(generationSettings);
        BYGDefaultBiomeFeatures.addAzalea(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(0.25F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(5406551).foliageColorOverride(6589494).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome whiteBeach() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultGrass(generationSettings);
        
        BYGDefaultBiomeFeatures.addBeachGrass(generationSettings);

        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.BEACH).temperature(0.25F).downfall(0.4F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome temperateRainForest() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        BYGDefaultBiomeFeatures.addWoodlandTrees(generationSettings);
        BYGDefaultBiomeFeatures.addMeadowTrees(generationSettings);
        BYGDefaultBiomeFeatures.addHugeMushrooms(generationSettings);
        invokeGlobalOverworldGeneration(generationSettings);
        
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);

        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addAnemones(generationSettings);
        BYGDefaultBiomeFeatures.addAzalea(generationSettings);
        BYGDefaultBiomeFeatures.addRose(generationSettings);
        BYGDefaultBiomeFeatures.addFairyslipper(generationSettings);
        BYGDefaultBiomeFeatures.addLushBlueberries(generationSettings);
        BYGDefaultBiomeFeatures.addBeeHive(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).temperature(0.8F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(8034667).foliageColorOverride(8034667).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome zelkovaForest() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        
        invokeGlobalOverworldGeneration(generationSettings);
        
        BiomeDefaultFeatures.addFerns(generationSettings);
        
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addTaigaGrass(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        BYGDefaultBiomeFeatures.addKovanFlower(generationSettings);
        BYGDefaultBiomeFeatures.addAnemones(generationSettings);
        BYGDefaultBiomeFeatures.addCrocus(generationSettings);
        BYGDefaultBiomeFeatures.addBYGMushrooms(generationSettings);
        BYGDefaultBiomeFeatures.addZelkovaTrees(generationSettings);

        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));
        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.TAIGA).temperature(0.25F).downfall(0.8F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).grassColorOverride(5416309).foliageColorOverride(5416309).fogColor(12638463).skyColor(VanillaBiomeAccess.invokeCalculateSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }
}