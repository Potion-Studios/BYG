package voronoiaoc.byg.common.biomes.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SeaGrassConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGTreeFeatures;
import voronoiaoc.byg.core.byglists.BYGSBList;

public class GlowShroomBayou extends Biome  {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(BYGSBList.GLOWSHROOM_BAYOU_SB, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG);
    static final RainType PRECIPATATION = RainType.RAIN;
    static final Category CATEGORY = Category.SWAMP;
    static final double DEPTH = -0.2F;
    static final double SCALE = 0.01F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4815438;
    static final int WATER_FOG_COLOR = 6717479;
    static final String PARENT = null;

    public GlowShroomBayou() {
        super(new Builder().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPATATION).category(CATEGORY).depth((float) DEPTH).waterColor(WATER_COLOR).scale((float) SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).waterFogColor(WATER_FOG_COLOR).parent(PARENT));
        BYGTreeFeatures.addBayouVegetation(this);
        DefaultBiomeFeatures.addCarvers(this);
        DefaultBiomeFeatures.addStructures(this);
        DefaultBiomeFeatures.addMonsterRooms(this);
        DefaultBiomeFeatures.addStoneVariants(this);
        DefaultBiomeFeatures.addOres(this);
        DefaultBiomeFeatures.addSwampClayDisks(this);
        DefaultBiomeFeatures.addMushrooms(this);
        DefaultBiomeFeatures.addExtraReedsAndPumpkins(this);
        DefaultBiomeFeatures.addSprings(this);
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS.withConfiguration(new SeaGrassConfig(64, 0.6D)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
        BYGFeatures.addBYGSwampVegetation(this);
        BYGFeatures.addMarshGrass(this);
        BYGFeatures.addBYGGlowcane(this);
        BYGFeatures.addCattails(this);
        BYGFeatures.addMudDisks(this);
        DefaultBiomeFeatures.addFreezeTopLayer(this);
    }

    @Override
    public Biome getRiver() {
        return this;
    }

    @OnlyIn(Dist.CLIENT)
    public int getGrassColor(double posX, double posZ) {
        double d0 = INFO_NOISE.noiseAt(posX * 0.0225D, posZ * 0.0225D, false);
        return d0 < -0.1D ? 7375928 : 6981433;
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor() {
        return 6337104;
    }
}
