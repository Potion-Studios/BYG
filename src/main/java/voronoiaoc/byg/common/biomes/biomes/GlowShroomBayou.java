package voronoiaoc.byg.common.biomes.biomes;

import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import voronoiaoc.byg.common.biomes.BiomeTools;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGTreeFeatures;
import voronoiaoc.byg.core.byglists.BYGSBList;

public class GlowShroomBayou extends Biome implements BiomeTools {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(BYGSBList.GLOWSHROOM_BAYOU_SB, SurfaceBuilder.GRASS_CONFIG);
    static final Precipitation PRECIPATATION = Precipitation.RAIN;
    static final Category CATEGORY = Category.SWAMP;
    static final double DEPTH = -0.2F;
    static final double SCALE = 0.01F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4815438;
    static final int WATER_FOG_COLOR = 6717479;
    static final String PARENT = null;

    public GlowShroomBayou() {
        super(new Settings().configureSurfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPATATION).category(CATEGORY).depth((float) DEPTH).scale((float) SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).parent(PARENT).effects((new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).moodSound(BiomeMoodSound.CAVE).build()));
        BYGTreeFeatures.addGlowshroomBayouVegetation(this);
        DefaultBiomeFeatures.addLandCarvers(this);
        DefaultBiomeFeatures.addDungeons(this);
        DefaultBiomeFeatures.addMineables(this);
        DefaultBiomeFeatures.addDefaultOres(this);
        DefaultBiomeFeatures.addClay(this);
        DefaultBiomeFeatures.addDefaultMushrooms(this);
        DefaultBiomeFeatures.addSwampVegetation(this);
        DefaultBiomeFeatures.addSprings(this);
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SEAGRASS_NORMAL);
        BYGFeatures.addBYGSwampVegetation(this);
        BYGFeatures.addMarshGrass(this);
        BYGFeatures.addBYGGlowcane(this);
        BYGFeatures.addCattails(this);
        BYGFeatures.addMudDisks(this);
        DefaultBiomeFeatures.addFrozenTopLayer(this);
        BYGFeatures.addPeachleatherflower(this);
        BYGFeatures.addVioletleatherflower(this);
        BYGFeatures.addRedorchid(this);
        BYGFeatures.addPurpleOrchid(this);
        BYGFeatures.addPinkOrchid(this);
        BYGFeatures.addGlowshrooms(this);
        BYGTreeFeatures.addHugeGlowshrooms(this);

    }

    @Override
    public int getGrassColorAt(double x, double z) {
        double d0 = FOLIAGE_NOISE.sample(x * 0.0225D, z * 0.0225D, false);
        return d0 < -0.1D ? 7375928 : 6981433;
    }

    @Override
    public int getFoliageColor() {
        return 6337104;
    }

    @Override
    public Biome getRiver() {
        return this;
    }

    @Override
    public Biome getHill() {
        return null;
    }

    @Override
    public Biome getEdge() {
        return null;
    }

    @Override
    public Biome getBeach() {
        return null;
    }

    @Override
    public Biome getMutation() {
        return null;
    }
}
