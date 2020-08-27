package voronoiaoc.byg.common.biomes.biomes;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import voronoiaoc.byg.common.biomes.BYGBiomeBuilder;
import voronoiaoc.byg.common.biomes.BiomeHelper;
import voronoiaoc.byg.common.biomes.BiomeTools;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGTreeFeatures;

public class TropicalIslands extends BYGBiomeBuilder implements BiomeTools  {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = BiomeHelper.newConfiguredSurfaceBuilder("tropical_islands", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())));
    static final Biome.RainType PRECIPATATION = Biome.RainType.RAIN;
    static final Biome.Category CATEGORY = Biome.Category.OCEAN;
    static final float DEPTH = 0.05F;
    static final float SCALE = 0.35F;
    static final float TEMPERATURE = 0.95F;
    static final float DOWNFALL = 0.9F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;
    static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).func_242517_a(SURFACE_BUILDER);

    public TropicalIslands() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).setFogColor(12638463).func_242539_d(BiomeHelper.calcSkyColor(0.8F)).setMoodSound(MoodSoundAmbience.field_235027_b_).build(), GENERATION_SETTINGS.func_242508_a(), SPAWN_SETTINGS.func_242577_b());
    }

    static {
        //this.add//StructureFeature(DefaultBiomeFeatures.JUNGLE_PYRAMID);
        DefaultBiomeFeatures.func_243733_b(GENERATION_SETTINGS);
        BYGTreeFeatures.addIslandRainbowTrees(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243738_d(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243748_i(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243750_j(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243754_n(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243708_V(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243712_Z(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243717_aa(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243727_ak(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243719_ac(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243730_an(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243698_L(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243701_O(GENERATION_SETTINGS);
        BYGFeatures.addBYGTropicFlowers(GENERATION_SETTINGS);
        BYGFeatures.addBYGMushrooms(GENERATION_SETTINGS);
//        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(Feature.TREE.configure(DefaultBiomeFeatures.JUNGLE_GROUND_BUSH_CONFIG).withChance(0.2F), Feature.TREE.configure(DefaultBiomeFeatures.FANCY_TREE_CONFIG).withChance(0.1F)), Feature.TREE.configure(DefaultBiomeFeatures.JUNGLE_TREE_CONFIG))).decorate(Decorator.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(6, 0.1F, 1))));
//        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.configure(DefaultBiomeFeatures.FOREST_FLOWER_CONFIG).decorate(Decorator.COUNT_HEIGHTMAP_32.configure(new CountDecoratorConfig(100))));
//        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_RANDOM_SELECTOR.configure(new RandomRandomFeatureConfig(ImmutableList.of(Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.LILAC_CONFIG), Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.ROSE_BUSH_CONFIG), Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.PEONY_CONFIG), Feature.FLOWER.configure(DefaultBiomeFeatures.LILY_OF_THE_VALLEY_CONFIG)), 2)).decorate(Decorator.COUNT_HEIGHTMAP_32.configure(new CountDecoratorConfig(5))));

        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SHEEP, 12, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.PIG, 10, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.CHICKEN, 10, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.COW, 8, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.PARROT, 40, 1, 2));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.CHICKEN, 10, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8));

    }
}
