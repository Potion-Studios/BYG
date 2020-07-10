package voronoiaoc.byg.common.biomes.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.SeaGrassConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.feature.structure.OceanRuinConfig;
import net.minecraft.world.gen.feature.structure.OceanRuinStructure;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import voronoiaoc.byg.common.biomes.BiomeFog;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGTreeFeatures;
import voronoiaoc.byg.common.world.feature.biomefeatures.EntitySpawns;
import voronoiaoc.byg.core.byglists.BYGSBList;

public class CragGardens extends Biome implements BiomeFog {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(BYGSBList.SLUICE_SB, BYGSBList.BYGSBConfigList.GREEN_CONCRETE_POWDER_CF);
    static final RainType PRECIPATATION = RainType.RAIN;
    static final Category CATEGORY = Category.JUNGLE;
    static final double DEPTH = -1.5F;
    static final double SCALE = 0.0F;
    static final float TEMPERATURE = 1.0F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 8170451;
    static final int WATER_FOG_COLOR = 6200521;
    static final String PARENT = null;

    public CragGardens() {
        super(new Builder().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPATATION).category(CATEGORY).depth((float) DEPTH).waterColor(WATER_COLOR).scale((float) SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).waterFogColor(WATER_FOG_COLOR).parent(PARENT));
        this.addStructure(Feature.OCEAN_RUIN.withConfiguration(new OceanRuinConfig(OceanRuinStructure.Type.WARM, 0.9F, 0.9F)));
        this.addStructure(Feature.JUNGLE_TEMPLE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        this.addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
        this.addStructure(Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        BYGFeatures.addLargeLake(this);
        BYGFeatures.addCattails(this);
        BYGFeatures.addBYGLilyPad(this);
        BYGFeatures.addMarshGrass(this);
        BYGFeatures.addTallGrass(this);
        BYGFeatures.addBYGMushrooms(this);
        DefaultBiomeFeatures.addCarvers(this);
        DefaultBiomeFeatures.addStructures(this);
        DefaultBiomeFeatures.addMonsterRooms(this);
        DefaultBiomeFeatures.addStoneVariants(this);
        DefaultBiomeFeatures.addOres(this);
        DefaultBiomeFeatures.addSedimentDisks(this);
        DefaultBiomeFeatures.addMushrooms(this);
        DefaultBiomeFeatures.addFreezeTopLayer(this);
        BYGTreeFeatures.addCragRainbowTrees(this);
        BYGFeatures.addBYGTropicFlowers(this);
        DefaultBiomeFeatures.addJunglePlants(this);
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS.withConfiguration(new SeaGrassConfig(64, 0.6D)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));


        this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.COD, 2, 1, 4));
        this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.SALMON, 5, 1, 5));
        EntitySpawns.addCreatures(this);
        EntitySpawns.addMonsters(this);
    }

    @Override
    public Biome getRiver() {
        return this;
    }

    @Override
    public Vec3d getBiomeFogColor(int x, int z, Vec3d originalValue) {
        return color;
    }

    Vec3d color = new Vec3d(192, 192, 192);


    @Override
    public Boolean doesBiomeXZShowFog(int x, int z) {
        return false;
    }

    @Override
    public double getBiomeVoidFogYFactor(int x, int y, double originalValue) {
        return 0.6;
    }

    @Override
    public float fogDistance(int x, int z, float originalDistanceChunks) {
        return 10;
    }
}