package voronoiaoc.byg.common.biomes.netherbiome;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import voronoiaoc.byg.common.biomes.BiomeFog;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.core.byglists.BYGBlockList;
import voronoiaoc.byg.core.byglists.BYGSBList;

public class GlowstoneGardens extends Biome implements BiomeFog {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, BYGSBList.BYGSBConfigList.GLOWSTONEGARDENS);
    static final Precipitation PRECIPATATION = Precipitation.RAIN;
    static final Category CATEGORY = Category.NETHER;
    static final double DEPTH = 0.125F;
    static final double SCALE = 0.05F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.4F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;

    public GlowstoneGardens() {
        super(new Settings().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPATATION).category(CATEGORY).depth((float) DEPTH).scale((float) SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).parent(PARENT).effects((new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).moodSound(BiomeMoodSound.CAVE).build()));
        this.addCarver(GenerationStage.Carving.AIR, createCarver(WorldCarver.HELL_CAVE, new ProbabilityConfig(0.2F)));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING_FEATURE.configure(DefaultBiomeFeatures.LAVA_SPRING_CONFIG).withPlacement(Placement.COUNT_VERY_BIASED_RANGE.configure(new CountRangeConfig(20, 8, 16, 256))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.SPRING_FEATURE.configure(DefaultBiomeFeatures.NETHER_SPRING_CONFIG).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 4, 8, 128))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.NETHER_FIRE_CONFIG).withPlacement(Placement.HELL_FIRE.configure(new FrequencyConfig(10))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.GLOWSTONE_BLOB.configure(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.LIGHT_GEM_CHANCE.configure(new FrequencyConfig(80))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.GLOWSTONE_BLOB.configure(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(80, -20, 0, 128))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).withPlacement(Placement.CHANCE_RANGE.configure(new ChanceRangeConfig(0.5F, 0, 0, 128))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.RED_MUSHROOM_CONFIG).withPlacement(Placement.CHANCE_RANGE.configure(new ChanceRangeConfig(0.5F, 0, 0, 128))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BYGBlockList.PERVADED_NETHERRACK.getDefaultState(), 14)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(16, 10, 20, 128))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, Blocks.MAGMA_BLOCK.getDefaultState(), 33)).withPlacement(Placement.MAGMA.configure(new FrequencyConfig(8))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.SPRING_FEATURE.configure(DefaultBiomeFeatures.ENCLOSED_NETHER_SPRING_CONFIG).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(16, 10, 20, 128))));
        BYGFeatures.addNetherFortress(this);
        BYGFeatures.addHugeNetherMushrooms(this);
        BYGFeatures.addGlowstoneGardenVegetation(this);


        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.GHAST, 40, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ZOMBIE_PIGMAN, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.MAGMA_CUBE, 2, 4, 4));
    }

    @Override
    public Vec3d getBiomeFogColor(int x, int z, Vec3d originalValue) {
        return WARPEDDESERTVEC3D;
    }
    private static final Vec3d WARPEDDESERTVEC3D = new Vec3d(0.724F, 0.69F, 0.47F);


    @Override
    @OnlyIn(Dist.CLIENT)
    public int getGrassColorAt(double posX, double posZ) {
        return 10855786;

    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor() {
        return 10855786;
    }
}
