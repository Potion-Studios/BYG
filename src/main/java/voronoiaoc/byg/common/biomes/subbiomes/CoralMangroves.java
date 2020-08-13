package voronoiaoc.byg.common.biomes.subbiomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import voronoiaoc.byg.common.biomes.BiomeHelper;
import voronoiaoc.byg.common.biomes.BiomeTools;import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGTreeFeatures;

public class CoralMangroves extends Biome implements BiomeTools {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = BiomeHelper.newConfiguredSurfaceBuilder("coral_mangroves", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.SWAMP, SurfaceBuilder.SAND_CONFIG));
    static final RainType PRECIPATATION = RainType.RAIN;
    static final Category CATEGORY = Category.SWAMP;
    static final float DEPTH = -0.5F;
    static final float SCALE = 0.01F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final int GRASS_COLOR = 6337104;
    static final int FOLIAGE_COLOR = 6337104;
    static final String PARENT = null;
    static final Climate WEATHER = new Climate(PRECIPATATION, TEMPERATURE, TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).func_242517_a(SURFACE_BUILDER);

    public CoralMangroves() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).setFogColor(12638463).func_242541_f(GRASS_COLOR).func_242540_e(FOLIAGE_COLOR).func_242539_d(BiomeHelper.calcSkyColor(0.8F)).setMoodSound(MoodSoundAmbience.field_235027_b_).build(), GENERATION_SETTINGS.func_242508_a(), SPAWN_SETTINGS.func_242577_b());
    }

    public int getGrassColorAt(double posX, double posZ) {
        double d0 = FOLIAGE_NOISE.sample(posX * 0.0225D, posZ * 0.0225D, false);
        return d0 < -0.1D ? 6337104 : 6337104;
    }

    public int getFoliageColor() {
        return 6337104;
    }

//    @Override
//    public Biome getRiver() {
//        return this;
//    }

    static {
        BYGTreeFeatures.addSparseMangroveMarshes(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243738_d(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243746_h(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243748_i(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243750_j(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243755_o(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243712_Z(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243717_aa(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243727_ak(GENERATION_SETTINGS);
        //GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS.configure(new SeagrassFeatureConfig(64, 0.6D)).decorate(Decorator.TOP_SOLID_HEIGHTMAP.configure(NopeDecoratorConfig.field_24892)));
        BYGFeatures.addGrass(GENERATION_SETTINGS);
        BYGFeatures.addCattails(GENERATION_SETTINGS);
        BYGFeatures.addPeachleatherflower(GENERATION_SETTINGS);
        BYGFeatures.addVioletleatherflower(GENERATION_SETTINGS);
        BYGFeatures.addRedorchid(GENERATION_SETTINGS);
        BYGFeatures.addPurpleOrchid(GENERATION_SETTINGS);
        BYGFeatures.addPinkOrchid(GENERATION_SETTINGS);
        BYGFeatures.addMudDisks(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243730_an(GENERATION_SETTINGS);
//        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SIMPLE_RANDOM_SELECTOR.configure(new SimpleRandomFeatureConfig(ImmutableList.of(
//                Feature.CORAL_TREE.configure(NoFeatureConfig.DEFAULT),
//                Feature.CORAL_CLAW.configure(NoFeatureConfig.DEFAULT),
//                Feature.CORAL_MUSHROOM.configure(NoFeatureConfig.DEFAULT))))
//                .decorate(AtOceanFloorWithExtra.OCEANFLOOR.configure(new AtSurfaceWithExtraConfig(7, 0.1F, 3))));
//
//        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION,
//                Feature.SEA_PICKLE.configure(new SeaPickleFeatureConfig(20)).decorate(Decorator.CHANCE_TOP_SOLID_HEIGHTMAP.configure(new ChanceDecoratorConfig(20))));

        DefaultBiomeFeatures.addSavannaTallGrass(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243730_an(GENERATION_SETTINGS);

//         SPAWN_SETTINGS.func_242575_a(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(EntityType.TROPICAL_FISH, 25, 8, 8));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SHEEP, 12, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.PIG, 10, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.CHICKEN, 10, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.COW, 8, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 95, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SKELETON, 100, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.CREEPER, 100, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SLIME, 100, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 10, 1, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.WITCH, 5, 1, 1));

    }
}
