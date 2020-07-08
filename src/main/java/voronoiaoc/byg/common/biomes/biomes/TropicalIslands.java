package voronoiaoc.byg.common.biomes.biomes;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomFeatureConfig;
import net.minecraft.world.gen.feature.RandomRandomFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import voronoiaoc.byg.common.biomes.BiomeTools;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGTreeFeatures;

import javax.annotation.Nullable;

public class TropicalIslands extends Biome implements BiomeTools {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, new TernarySurfaceConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState()));
    static final Precipitation PRECIPATATION = Precipitation.RAIN;
    static final Category CATEGORY = Category.OCEAN;
    static final double DEPTH = 0.05F;
    static final double SCALE = 0.35F;
    static final float TEMPERATURE = 0.95F;
    static final float DOWNFALL = 0.9F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;

    public TropicalIslands() {
        super(new Settings().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPATATION).category(CATEGORY).depth((float) DEPTH).scale((float) SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).parent(PARENT).effects((new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).moodSound(BiomeMoodSound.CAVE).build()));
        this.addStructureFeature(DefaultBiomeFeatures.JUNGLE_PYRAMID);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(this);
        BYGTreeFeatures.addIslandRainbowTrees(this);
        DefaultBiomeFeatures.addLandCarvers(this);
        DefaultBiomeFeatures.addMineables(this);
        DefaultBiomeFeatures.addDefaultOres(this);
        DefaultBiomeFeatures.addDefaultDisks(this);
        DefaultBiomeFeatures.addExtraDefaultFlowers(this);
        DefaultBiomeFeatures.addDefaultMushrooms(this);
        DefaultBiomeFeatures.addDefaultVegetation(this);
        DefaultBiomeFeatures.addSprings(this);
        DefaultBiomeFeatures.addJungleVegetation(this);
        DefaultBiomeFeatures.addFrozenTopLayer(this);
        DefaultBiomeFeatures.addSavannaGrass(this);
        DefaultBiomeFeatures.addForestGrass(this);
        BYGFeatures.addBYGTropicFlowers(this);
        BYGFeatures.addBYGMushrooms(this);
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(Feature.TREE.configure(DefaultBiomeFeatures.JUNGLE_GROUND_BUSH_CONFIG).withChance(0.2F), Feature.TREE.configure(DefaultBiomeFeatures.FANCY_TREE_CONFIG).withChance(0.1F)), Feature.TREE.configure(DefaultBiomeFeatures.JUNGLE_TREE_CONFIG))).method_30374(Decorator.COUNT_EXTRA.configure(new CountExtraChanceDecoratorConfig(6, 0.1F, 1))));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.FLOWER.configure(DefaultBiomeFeatures.FOREST_FLOWER_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_32.configure(new CountDecoratorConfig(100))));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_RANDOM_SELECTOR.configure(new RandomRandomFeatureConfig(ImmutableList.of(Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.LILAC_CONFIG), Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.ROSE_BUSH_CONFIG), Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.PEONY_CONFIG), Feature.FLOWER.configure(DefaultBiomeFeatures.LILY_OF_THE_VALLEY_CONFIG)), 2)).method_30374(Decorator.COUNT_HEIGHTMAP_32.configure(new CountDecoratorConfig(5))));

        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.COW, 8, 4, 4));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.PARROT, 40, 1, 2));
        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(SpawnGroup.AMBIENT, new SpawnEntry(EntityType.BAT, 10, 8, 8));


    }

    @Override
    public int getGrassColorAt(double x, double z) {
        return 10145074;
    }

    @Override
    public int getFoliageColor() {
        return 10145074;
    }

    @Nullable
    @Override
    public Biome getRiver() {
        return Biomes.RIVER;
    }

    @Nullable
    @Override
    public Biome getHill() {
        return null;
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
