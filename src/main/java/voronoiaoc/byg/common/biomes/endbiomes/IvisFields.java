package voronoiaoc.byg.common.biomes.endbiomes;

import net.fabricmc.fabric.api.biomes.v1.FabricBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldClimate;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import voronoiaoc.byg.core.byglists.BYGBiomeList;
import voronoiaoc.byg.core.byglists.BYGSBList;

public class IvisFields extends Biome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(BYGSBList.IVISFIELDS_SB, BYGSBList.BYGSBConfigList.END);
    static final Precipitation PRECIPATATION = Precipitation.RAIN;
    static final Category CATEGORY = Category.THEEND;
    static final double DEPTH = 0.55F;
    static final double SCALE = 0.15F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;

    public IvisFields() {
        super(new Settings().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPATATION).category(CATEGORY).depth((float) DEPTH).scale((float) SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).parent(PARENT).effects((new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).moodSound(BiomeMoodSound.CAVE).build()));
        //BYGFeatures.addEndCity(this);
//        this.addFeature(GenerationStep.Feature.LOCAL_MODIFICATIONS, BYGFeatureList.OBBYSPIKES.configure(FeatureConfig.DEFAULT).createDecoratedFeature(ObsidianSpikePlacer.OBBY_SPIKE.configure(new CountDecoratorConfig(2000))));
//        this.addFeature(GenerationStep.Feature.LOCAL_MODIFICATIONS, BYGFeatureList.OBBYSPIKES.configure(FeatureConfig.DEFAULT).createDecoratedFeature(ObsidianSpikePlacer.OBBY_SPIKE.configure(new CountDecoratorConfig(2000))));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.CHORUS_PLANT.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.CHORUS_PLANT.configure(DecoratorConfig.DEFAULT)));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.CHORUS_PLANT.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.CHORUS_PLANT.configure(DecoratorConfig.DEFAULT)));
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.CHORUS_PLANT.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.CHORUS_PLANT.configure(DecoratorConfig.DEFAULT)));
        //BYGFeatures.addivisPlants(this);

        OverworldBiomes.addEdgeBiome(this, BYGBiomeList.ALLIUMFIELDS, 1);
        OverworldBiomes.addBiomeVariant(this, this, 1);
        OverworldBiomes.addShoreBiome(this, BYGBiomeList.ALLIUMFIELDS, 1);
        OverworldBiomes.addContinentalBiome(this, OverworldClimate.TEMPERATE, 1);
        FabricBiomes.addSpawnBiome(this);
    }
}
