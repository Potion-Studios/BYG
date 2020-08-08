package voronoiaoc.byg.common.biomes.subbiomes;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import voronoiaoc.byg.common.biomes.BiomeHelper;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGTreeFeatures;

public class CoralMangroves extends Biome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = BiomeHelper.newConfiguredSurfaceBuilder("coral_mangroves", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.SWAMP, SurfaceBuilder.SAND_CONFIG));
    static final Precipitation PRECIPATATION = Precipitation.RAIN;
    static final Category CATEGORY = Category.SWAMP;
    static final float DEPTH = -0.5F;
    static final float SCALE = 0.01F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;
    static final Weather WEATHER = new Weather(PRECIPATATION, TEMPERATURE, TemperatureModifier.NONE, DOWNFALL);
    static final SpawnSettings.Builder SPAWN_SETTINGS = new SpawnSettings.Builder();
    static final GenerationSettings.Builder GENERATION_SETTINGS = (new GenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public CoralMangroves() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).skyColor(BiomeHelper.calcSkyColor(0.8F)).moodSound(BiomeMoodSound.CAVE).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
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
        DefaultBiomeFeatures.addLandCarvers(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDungeons(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addMineables(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultOres(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addClay(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultMushrooms(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultVegetation(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addSprings(GENERATION_SETTINGS);
        //GENERATION_SETTINGS.feature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.SEAGRASS.configure(new SeagrassFeatureConfig(64, 0.6D)).decorate(Decorator.TOP_SOLID_HEIGHTMAP.configure(NopeDecoratorConfig.field_24892)));
        BYGFeatures.addGrass(GENERATION_SETTINGS);
        BYGFeatures.addCattails(GENERATION_SETTINGS);
        BYGFeatures.addPeachleatherflower(GENERATION_SETTINGS);
        BYGFeatures.addVioletleatherflower(GENERATION_SETTINGS);
        BYGFeatures.addRedorchid(GENERATION_SETTINGS);
        BYGFeatures.addPurpleOrchid(GENERATION_SETTINGS);
        BYGFeatures.addPinkOrchid(GENERATION_SETTINGS);
        BYGFeatures.addMudDisks(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addFrozenTopLayer(GENERATION_SETTINGS);
//        GENERATION_SETTINGS.feature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.SIMPLE_RANDOM_SELECTOR.configure(new SimpleRandomFeatureConfig(ImmutableList.of(
//                Feature.CORAL_TREE.configure(DefaultFeatureConfig.DEFAULT),
//                Feature.CORAL_CLAW.configure(DefaultFeatureConfig.DEFAULT),
//                Feature.CORAL_MUSHROOM.configure(DefaultFeatureConfig.DEFAULT))))
//                .decorate(AtOceanFloorWithExtra.OCEANFLOOR.configure(new CountExtraDecoratorConfig(7, 0.1F, 3))));
//
//        GENERATION_SETTINGS.feature(GenerationStep.Feature.VEGETAL_DECORATION,
//                Feature.SEA_PICKLE.configure(new SeaPickleFeatureConfig(20)).decorate(Decorator.CHANCE_TOP_SOLID_HEIGHTMAP.configure(new ChanceDecoratorConfig(20))));

        DefaultBiomeFeatures.addSavannaTallGrass(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addFrozenTopLayer(GENERATION_SETTINGS);

        SPAWN_SETTINGS.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(EntityType.TROPICAL_FISH, 25, 8, 8));
        SPAWN_SETTINGS.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.SHEEP, 12, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.PIG, 10, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.CHICKEN, 10, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.COW, 8, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.BAT, 10, 8, 8));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SPIDER, 100, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE, 95, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SKELETON, 100, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.CREEPER, 100, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SLIME, 100, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.WITCH, 5, 1, 1));

    }
}
