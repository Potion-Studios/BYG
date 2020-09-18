package voronoiaoc.byg.common.biomes.biomes;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import voronoiaoc.byg.common.biomes.BiomeHelper;
import voronoiaoc.byg.common.biomes.BiomeTools;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGTreeFeatures;

public class TropicalIslands extends Biome implements BiomeTools {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = BiomeHelper.newConfiguredSurfaceBuilder("tropical_islands", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())));
    static final RainType PRECIPATATION = RainType.RAIN;
    static final Category CATEGORY = Category.OCEAN;
    static final float DEPTH = 0.05F;
    static final float SCALE = 0.35F;
    static final float TEMPERATURE = 0.95F;
    static final float DOWNFALL = 0.9F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;
    static final Climate WEATHER = new Climate(PRECIPATATION, TEMPERATURE, TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

    public TropicalIslands() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).setFogColor(12638463).withSkyColor(BiomeHelper.calcSkyColor(0.8F)).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.copy());
    }

    @Override
    public int getFoliageColor() {
        return 10145074;
    }


    static {
        //this.add//StructureFeature(DefaultBiomeFeatures.JUNGLE_PYRAMID);
        DefaultBiomeFeatures.withStrongholdAndMineshaft(GENERATION_SETTINGS);
        BYGTreeFeatures.addIslandRainbowTrees(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withCavesAndCanyons(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withCommonOverworldBlocks(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withOverworldOres(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withDisks(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withWarmFlowers(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withNormalMushroomGeneration(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withSugarCaneAndPumpkins(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withLavaAndWaterSprings(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withMelonPatchesAndVines(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withFrozenTopLayer(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withSavannaGrass(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withForestGrass(GENERATION_SETTINGS);
        BYGFeatures.addBYGTropicFlowers(GENERATION_SETTINGS);
        BYGFeatures.addBYGMushrooms(GENERATION_SETTINGS);
//        GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(Feature.TREE.configure(DefaultBiomeFeatures.JUNGLE_GROUND_BUSH_CONFIG).withChance(0.2F), Feature.TREE.configure(DefaultBiomeFeatures.FANCY_TREE_CONFIG).withChance(0.1F)), Feature.TREE.configure(DefaultBiomeFeatures.JUNGLE_TREE_CONFIG))).decorate(Decorator.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(6, 0.1F, 1))));
//        GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.configure(DefaultBiomeFeatures.FOREST_FLOWER_CONFIG).decorate(Decorator.COUNT_HEIGHTMAP_32.configure(new CountDecoratorConfig(100))));
//        GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_RANDOM_SELECTOR.configure(new RandomRandomFeatureConfig(ImmutableList.of(Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.LILAC_CONFIG), Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.ROSE_BUSH_CONFIG), Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.PEONY_CONFIG), Feature.FLOWER.configure(DefaultBiomeFeatures.LILY_OF_THE_VALLEY_CONFIG)), 2)).decorate(Decorator.COUNT_HEIGHTMAP_32.configure(new CountDecoratorConfig(5))));

        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SHEEP, 12, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.PIG, 10, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.CHICKEN, 10, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.COW, 8, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.PARROT, 40, 1, 2));
        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.CHICKEN, 10, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8));

    }
}
