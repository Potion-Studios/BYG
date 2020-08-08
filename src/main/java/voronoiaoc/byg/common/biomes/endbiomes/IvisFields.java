package voronoiaoc.byg.common.biomes.endbiomes;

import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import voronoiaoc.byg.common.biomes.BiomeHelper;
import voronoiaoc.byg.core.byglists.BYGSBList;

public class IvisFields extends Biome {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = BiomeHelper.newConfiguredSurfaceBuilder("ivis_fields", new ConfiguredSurfaceBuilder<>(BYGSBList.IVISFIELDS_SB, BYGSBList.BYGSBConfigList.END));
    static final Precipitation PRECIPATATION = Precipitation.RAIN;
    static final Category CATEGORY = Category.THEEND;
    static final float DEPTH = 0.55F;
    static final float SCALE = 0.15F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;
    static final Weather WEATHER = new Weather(PRECIPATATION, TEMPERATURE, TemperatureModifier.NONE, DOWNFALL);
    static final SpawnSettings.Builder SPAWN_SETTINGS = new SpawnSettings.Builder();
    static final GenerationSettings.Builder GENERATION_SETTINGS = (new GenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public IvisFields() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).skyColor(BiomeHelper.calcSkyColor(0.8F)).moodSound(BiomeMoodSound.CAVE).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
        //BYGFeatures.addEndCity(this);
//        this.addFeature(GenerationStep.Feature.LOCAL_MODIFICATIONS, BYGFeatureList.OBBYSPIKES.configure(FeatureConfig.DEFAULT).createDecoratedFeature(ObsidianSpikePlacer.OBBY_SPIKE.configure(new CountDecoratorConfig(2000))));
//        this.addFeature(GenerationStep.Feature.LOCAL_MODIFICATIONS, BYGFeatureList.OBBYSPIKES.configure(FeatureConfig.DEFAULT).createDecoratedFeature(ObsidianSpikePlacer.OBBY_SPIKE.configure(new CountDecoratorConfig(2000))));
//        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.CHORUS_PLANT.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.CHORUS_PLANT.configure(DecoratorConfig.DEFAULT)));
//        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.CHORUS_PLANT.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.CHORUS_PLANT.configure(DecoratorConfig.DEFAULT)));
//        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.CHORUS_PLANT.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.CHORUS_PLANT.configure(DecoratorConfig.DEFAULT)));
    }
}
