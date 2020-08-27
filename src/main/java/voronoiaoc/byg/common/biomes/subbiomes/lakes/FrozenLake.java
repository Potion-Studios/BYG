package voronoiaoc.byg.common.biomes.subbiomes.lakes;

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

public class FrozenLake extends BYGBiomeBuilder implements BiomeTools {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = BiomeHelper.newConfiguredSurfaceBuilder("frozen_lake", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.SWAMP, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())));
    static final Biome.RainType PRECIPATATION = Biome.RainType.RAIN;
    static final Biome.Category CATEGORY = Biome.Category.SWAMP;
    static final float DEPTH = -0.8F;
    static final float SCALE = 0.00F;
    static final float TEMPERATURE = 0.0F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;
    static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).func_242517_a(SURFACE_BUILDER);

    public FrozenLake() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).setFogColor(12638463).func_242539_d(BiomeHelper.calcSkyColor(0.8F)).setMoodSound(MoodSoundAmbience.field_235027_b_).build(), GENERATION_SETTINGS.func_242508_a(), SPAWN_SETTINGS.func_242577_b());
    }

    static {
        DefaultBiomeFeatures.func_243730_an(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243738_d(GENERATION_SETTINGS);

        DefaultBiomeFeatures.func_243746_h(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243748_i(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243750_j(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243754_n(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243763_w(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243707_U(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243709_W(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243712_Z(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243717_aa(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243727_ak(GENERATION_SETTINGS);
        BYGFeatures.addCattails(GENERATION_SETTINGS);
//        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.SURFACE_STRUCTURES, Feature.ICE_SPIKE.configure(FeatureConfig.DEFAULT).decorate(Decorator.COUNT_HEIGHTMAP.configure(new CountDecoratorConfig(2))));
        //GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS.configure(new SeagrassFeatureConfig(48, 0.4D)).decorate(Decorator.TOP_SOLID_HEIGHTMAP.configure(DecoratorConfig.DEFAULT)));
        DefaultBiomeFeatures.func_243730_an(GENERATION_SETTINGS);

//         SPAWN_SETTINGS.tree(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(EntityType.COD, 2, 1, 4));
//         SPAWN_SETTINGS.tree(EntityClassification.WATER_AMBIENT, new MobSpawnInfo.Spawners(EntityType.SALMON, 5, 1, 5));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 95, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.DROWNED, 100, 1, 1));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SKELETON, 100, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.CREEPER, 100, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SLIME, 100, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 10, 1, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.WITCH, 5, 1, 1));
    }
}
