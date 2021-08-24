package corgiaoc.byg.common.world.biome.overworld;

import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.common.world.biome.BiomeUtil;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import corgiaoc.byg.util.MLClimate;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class MojaveDesert extends BYGBiome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("mojave", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.MOJAVE, new SurfaceBuilderConfig(Blocks.SAND.defaultBlockState(), Blocks.SAND.defaultBlockState(), Blocks.SANDSTONE.defaultBlockState())));
    static final Biome.RainType PRECIPATATION = Biome.RainType.NONE;
    static final Biome.Category CATEGORY = Biome.Category.DESERT;
    static final float DEPTH = 0.125F;
    static final float SCALE = 0.05F;
    static final float TEMPERATURE = 2.0F;
    static final float DOWNFALL = 0.0F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    
    static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder().setPlayerCanSpawn();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public MojaveDesert() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).skyColor(BiomeUtil.calcSkyColor(0.8F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }

    @Nullable
    @Override
    public WeightedList<Biome> getHills() {
        WeightedList<Biome> biomeWeightedList = new WeightedList<>();
        biomeWeightedList.add(WorldGenRegistries.BIOME.getOrThrow(Biomes.DESERT), 10);
        return biomeWeightedList;
    }

    @Override
    public String[] getBiomeDictionary() {
        return new String[]{"DRY", "HOT", "SANDY", "OVERWORLD"};
    }

    @Override
    public MLClimate getClimate() {
        return MLClimate.HOT;
    }

    @Override
    public int getWeight() {
        return 3;
    }

    static {
        DefaultBiomeFeatures.addFossilDecoration(GENERATION_SETTINGS);
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.DESERT_PYRAMID); //Desert Temple
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.VILLAGE_DESERT); //Desert Village
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.PILLAGER_OUTPOST); //Pillager Outpost
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.RUINED_PORTAL_DESERT); //Ruined Portal Desert
        DefaultBiomeFeatures.addDefaultOverworldLandStructures(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultCarvers(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultMonsterRoom(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultUndergroundVariety(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultOres(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultSoftDisks(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultFlowers(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultGrass(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDesertVegetation(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultMushrooms(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDesertExtraVegetation(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultSprings(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDesertExtraDecoration(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addSurfaceFreezing(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addMiniCactus(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addJoshuaTrees(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addBYGDesertPlants(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addFirecracker(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDesertExtraVegetation(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addBYGMushrooms(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addGrass(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addBadlandGrass(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addBushes(GENERATION_SETTINGS);

        SPAWN_SETTINGS.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SKELETON, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.CREEPER, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SLIME, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 10, 1, 4));
        SPAWN_SETTINGS.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.WITCH, 5, 1, 1));
        SPAWN_SETTINGS.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 19, 4, 4));
        SPAWN_SETTINGS.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 1, 1, 1));
        SPAWN_SETTINGS.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.HUSK, 80, 4, 4));

    }
}
