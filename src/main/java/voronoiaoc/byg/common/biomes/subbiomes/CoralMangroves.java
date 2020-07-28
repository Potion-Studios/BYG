package voronoiaoc.byg.common.biomes.subbiomes;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import voronoiaoc.byg.common.biomes.BiomeHelper;

import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGTreeFeatures;

public class CoralMangroves extends Biome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(SurfaceBuilder.SWAMP, SurfaceBuilder.SAND_CONFIG);
    static final Precipitation PRECIPATATION = Precipitation.RAIN;
    static final Category CATEGORY = Category.SWAMP;
    static final double DEPTH = -0.5F;
    static final double SCALE = 0.01F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;

    public CoralMangroves() {
        super(new Settings().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPATATION).category(CATEGORY).depth((float) DEPTH).scale((float) SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).parent(PARENT).effects((new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).skyColor(BiomeHelper.calcSkyColor(0.8F)).moodSound(BiomeMoodSound.CAVE).build()));
        BYGTreeFeatures.addSparseMangroveMarshes(this);
        DefaultBiomeFeatures.addLandCarvers(this);
        DefaultBiomeFeatures.addDungeons(this);
        DefaultBiomeFeatures.addMineables(this);
        DefaultBiomeFeatures.addDefaultOres(this);
        DefaultBiomeFeatures.addClay(this);
        DefaultBiomeFeatures.addDefaultMushrooms(this);
        DefaultBiomeFeatures.addDefaultVegetation(this);
        DefaultBiomeFeatures.addSprings(this);
        //this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.SEAGRASS.configure(new SeagrassFeatureConfig(64, 0.6D)).decorate(Decorator.TOP_SOLID_HEIGHTMAP.configure(NopeDecoratorConfig.field_24892)));
        BYGFeatures.addGrass(this);
        BYGFeatures.addCattails(this);
        BYGFeatures.addPeachleatherflower(this);
        BYGFeatures.addVioletleatherflower(this);
        BYGFeatures.addRedorchid(this);
        BYGFeatures.addPurpleOrchid(this);
        BYGFeatures.addPinkOrchid(this);
        BYGFeatures.addMudDisks(this);
        DefaultBiomeFeatures.addFrozenTopLayer(this);
//        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.SIMPLE_RANDOM_SELECTOR.configure(new SimpleRandomFeatureConfig(ImmutableList.of(
//                Feature.CORAL_TREE.configure(DefaultFeatureConfig.DEFAULT),
//                Feature.CORAL_CLAW.configure(DefaultFeatureConfig.DEFAULT),
//                Feature.CORAL_MUSHROOM.configure(DefaultFeatureConfig.DEFAULT))))
//                .decorate(AtOceanFloorWithExtra.OCEANFLOOR.configure(new CountExtraDecoratorConfig(7, 0.1F, 3))));
//
//        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION,
//                Feature.SEA_PICKLE.configure(new SeaPickleFeatureConfig(20)).decorate(Decorator.CHANCE_TOP_SOLID_HEIGHTMAP.configure(new ChanceDecoratorConfig(20))));

        DefaultBiomeFeatures.addSavannaTallGrass(this);
        DefaultBiomeFeatures.addFrozenTopLayer(this);

        this.addSpawn(SpawnGroup.WATER_CREATURE, new Biome.SpawnEntry(EntityType.TROPICAL_FISH, 25, 8, 8));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.COW, 8, 4, 4));
        this.addSpawn(SpawnGroup.AMBIENT, new SpawnEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.WITCH, 5, 1, 1));
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
}
