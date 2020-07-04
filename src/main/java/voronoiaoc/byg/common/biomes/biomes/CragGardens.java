package voronoiaoc.byg.common.biomes.biomes;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SeagrassFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import voronoiaoc.byg.common.biomes.BiomeFog;
import voronoiaoc.byg.common.biomes.BiomeTools;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGTreeFeatures;
import voronoiaoc.byg.core.byglists.BYGBiomeList;
import voronoiaoc.byg.core.byglists.BYGSBList;

public class CragGardens extends Biome implements BiomeTools, BiomeFog {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(BYGSBList.SLUICE_SB, BYGSBList.BYGSBConfigList.GREEN_CONCRETE_POWDER_CF);
    static final Precipitation PRECIPATATION = Precipitation.RAIN;
    static final Category CATEGORY = Category.JUNGLE;
    static final double DEPTH = -1.5F;
    static final double SCALE = 0.0F;
    static final float TEMPERATURE = 1.0F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 8170451;
    static final int WATER_FOG_COLOR = 6200521;
    static final String PARENT = null;

    public CragGardens() {
        super(new Settings().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPATATION).category(CATEGORY).depth((float) DEPTH).scale((float) SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).parent(PARENT).effects((new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).moodSound(BiomeMoodSound.CAVE).build()));
        this.addStructureFeature(DefaultBiomeFeatures.JUNGLE_PYRAMID);
        this.addStructureFeature(DefaultBiomeFeatures.JUNGLE_RUINED_PORTAL);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(this);
        BYGFeatures.addLargeLake(this);
        BYGFeatures.addCattails(this);
        BYGFeatures.addBYGLilyPad(this);
        BYGFeatures.addMarshGrass(this);
        BYGFeatures.addBYGMushrooms(this);
        BYGFeatures.addBYGGlowcane(this);
        DefaultBiomeFeatures.addLandCarvers(this);
        DefaultBiomeFeatures.addDungeons(this);
        DefaultBiomeFeatures.addMineables(this);
        DefaultBiomeFeatures.addDefaultOres(this);
        DefaultBiomeFeatures.addDefaultDisks(this);
        DefaultBiomeFeatures.addDefaultMushrooms(this);
        DefaultBiomeFeatures.addFrozenTopLayer(this);
        BYGTreeFeatures.addTropJungleTrees(this);
        BYGTreeFeatures.addCragRainbowTrees(this);
        BYGFeatures.addBYGTropicFlowers(this);
        DefaultBiomeFeatures.addJungleVegetation(this);
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.SEAGRASS.configure(new SeagrassFeatureConfig(64, 0.6D)).createDecoratedFeature(Decorator.TOP_SOLID_HEIGHTMAP.configure(DecoratorConfig.DEFAULT)));

        this.addSpawn(SpawnGroup.WATER_AMBIENT, new SpawnEntry(EntityType.COD, 2, 1, 4));
        this.addSpawn(SpawnGroup.WATER_AMBIENT, new SpawnEntry(EntityType.SALMON, 5, 1, 5));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.COW, 8, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.HORSE, 5, 2, 6));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.DONKEY, 1, 1, 3));
        this.addSpawn(SpawnGroup.AMBIENT, new SpawnEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.WITCH, 5, 1, 1));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SLIME, 100, 4, 4));
    }

    @Override
    public int getSkyColor() {
        return 12632256;
    }

    @Override
    public float fogDistance(int x, int z, float originalDistanceChunks) {
        return 10;
    }

    @Override
    public Biome getRiver() {
        return this;
    }

    @Override
    public Biome getHill() {
        return BYGBiomeList.CRAGGARDENS;
    }

    @Override
    public Biome getEdge() {
        return null;
    }

    @Override
    public Biome getBeach() {
        return BYGBiomeList.CRAGGARDENS;
    }

    @Override
    public Biome getMutation() {
        return null;
    }

}