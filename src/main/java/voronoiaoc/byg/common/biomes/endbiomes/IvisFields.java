package voronoiaoc.byg.common.biomes.endbiomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.common.world.feature.placements.ObsidianSpikePlacer;
import voronoiaoc.byg.core.byglists.BYGFeatureList;
import voronoiaoc.byg.core.byglists.BYGSBList;

public class IvisFields extends Biome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(BYGSBList.IVISFIELDS_SB, BYGSBList.BYGSBConfigList.END);
    static final RainType PRECIPATATION = RainType.NONE;
    static final Category CATEGORY = Category.THEEND;
    static final double DEPTH = 0.55F;
    static final double SCALE = 0.15F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;

    public IvisFields() {
        super(new Builder().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPATATION).category(CATEGORY).depth((float) DEPTH).waterColor(WATER_COLOR).scale((float) SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).waterFogColor(WATER_FOG_COLOR).parent(PARENT));
        BYGFeatures.addEndCity(this);
        this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, BYGFeatureList.OBBYSPIKES.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(ObsidianSpikePlacer.OBBY_SPIKE.configure(new FrequencyConfig(2000))));
        this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, BYGFeatureList.OBBYSPIKES.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(ObsidianSpikePlacer.OBBY_SPIKE.configure(new FrequencyConfig(2000))));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.CHORUS_PLANT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.CHORUS_PLANT.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.CHORUS_PLANT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.CHORUS_PLANT.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.CHORUS_PLANT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.CHORUS_PLANT.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
        BYGFeatures.addIvisPlants(this);
    }
}
