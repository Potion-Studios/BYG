package voronoiaoc.byg.common.biomes.biomes;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import voronoiaoc.byg.common.biomes.BiomeHelper;

import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import voronoiaoc.byg.common.biomes.BiomeTools;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGTreeFeatures;
import voronoiaoc.byg.core.byglists.BYGBiomeList;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import javax.annotation.Nullable;

public class GuianaShield extends Biome implements BiomeTools {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, new TernarySurfaceConfig(BYGBlockList.OVERGROWN_STONE.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState()));
    static final Precipitation PRECIPATATION = Precipitation.RAIN;
    static final Category CATEGORY = Category.JUNGLE;
    static final double DEPTH = 6.0F;
    static final double SCALE = 0.25F;
    static final float TEMPERATURE = 0.95F;
    static final float DOWNFALL = 0.9F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;

    public GuianaShield() {
        super(new Settings().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPATATION).category(CATEGORY).depth((float) DEPTH).scale((float) SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).parent(PARENT).effects((new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).skyColor(BiomeHelper.calcSkyColor(0.8F)).moodSound(BiomeMoodSound.CAVE).build()));
        DefaultBiomeFeatures.addDefaultUndergroundStructures(this);
        //this.add//StructureFeature(DefaultBiomeFeatures.JUNGLE_PYRAMID);
        //this.add//StructureFeature(DefaultBiomeFeatures.JUNGLE_RUINED_PORTAL);
        DefaultBiomeFeatures.addLandCarvers(this);
        DefaultBiomeFeatures.addDungeons(this);
        DefaultBiomeFeatures.addMineables(this);
        DefaultBiomeFeatures.addDefaultOres(this);
        DefaultBiomeFeatures.addDefaultDisks(this);
        DefaultBiomeFeatures.addExtraDefaultFlowers(this);
        DefaultBiomeFeatures.addDefaultMushrooms(this);
        DefaultBiomeFeatures.addDefaultVegetation(this);
        DefaultBiomeFeatures.addSprings(this);
        BYGTreeFeatures.addRainForestTrees(this);
        BYGFeatures.addWeedGrass(this);
        BYGFeatures.addGrass(this);
        BYGFeatures.addBYGTropicFlowers(this);
        BYGFeatures.addBYGMushrooms(this);

//        this.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, BYGBlockList.AMETRINE_ORE.getDefaultState(), 4)).decorate(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 56))));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.COW, 8, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.PARROT, 40, 1, 2));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(SpawnGroup.AMBIENT, new SpawnEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.WITCH, 5, 1, 1));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.OCELOT, 2, 1, 1));
    }

    @Override
    public int getGrassColorAt(double x, double z) {
        return 6208527;
    }

    @Override
    public int getFoliageColor() {
        return 6208527;
    }

    @Nullable
    @Override
    public Biome getRiver() {
        return this;
    }

    @Nullable
    @Override
    public Biome getHill() {
        return BYGBiomeList.GUIANA_CLEARING;
    }

    @Nullable
    @Override
    public Biome getEdge() {
        return null;
    }

    @Nullable
    @Override
    public Biome getBeach() {
        return null;
    }

    @Nullable
    @Override
    public Biome getMutation() {
        return null;
    }
}
