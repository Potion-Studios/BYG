package corgiaoc.byg.common.world.biome.overworld.sub;

import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.common.world.biome.BiomeUtil;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class CoralMangroves extends BYGBiome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("coral_mangroves", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.SWAMP, SurfaceBuilder.SAND_CONFIG));
    static final Biome.RainType PRECIPATATION = Biome.RainType.RAIN;
    static final Biome.Category CATEGORY = Biome.Category.SWAMP;
    static final float DEPTH = -0.5F;
    static final float SCALE = 0.01F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final int GRASS_COLOR = 6337104;
    static final int FOLIAGE_COLOR = 6337104;

    static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

    public CoralMangroves() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).setFogColor(12638463).withGrassColor(GRASS_COLOR).withFoliageColor(FOLIAGE_COLOR).withSkyColor(BiomeUtil.calcSkyColor(0.8F)).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.copy());
    }

    public int getFoliageColor() {
        return 6337104;
    }

    static {
        BYGDefaultBiomeFeatures.addSparseMangroveMarshes(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withCavesAndCanyons(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withMonsterRoom(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withCommonOverworldBlocks(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withOverworldOres(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withClayDisks(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withNormalMushroomGeneration(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withSugarCaneAndPumpkins(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withLavaAndWaterSprings(GENERATION_SETTINGS);
        //GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS.configure(new SeagrassFeatureConfig(64, 0.6D)).decorate(Decorator.TOP_SOLID_HEIGHTMAP.configure(NopeDecoratorConfig.field_24892)));
        BYGDefaultBiomeFeatures.addGrass(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addCattails(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addPeachleatherflower(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addVioletleatherflower(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addRedorchid(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addPurpleOrchid(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addPinkOrchid(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addMudDisks(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addMGCoral(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withFrozenTopLayer(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withTallGrass(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withFrozenTopLayer(GENERATION_SETTINGS);

//         SPAWN_SETTINGS.spawnTree(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(EntityType.TROPICAL_FISH, 25, 8, 8));
        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SHEEP, 12, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.PIG, 10, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.CHICKEN, 10, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.COW, 8, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8));
        SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 95, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SKELETON, 100, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.CREEPER, 100, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SLIME, 100, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 10, 1, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.WITCH, 5, 1, 1));

    }
}
