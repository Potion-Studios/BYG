package voronoiaoc.byg.common.biomes.biomes;

import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import voronoiaoc.byg.common.biomes.BiomeHelper;
import voronoiaoc.byg.common.biomes.BiomeTools;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGTreeFeatures;
import voronoiaoc.byg.core.byglists.BYGSBList;

public class GlowShroomBayou extends Biome implements BiomeTools  {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = BiomeHelper.newConfiguredSurfaceBuilder("glowshroom_bayou", new ConfiguredSurfaceBuilder<>(BYGSBList.GLOWSHROOM_BAYOU_SB, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG));
    static final RainType PRECIPATATION = RainType.RAIN;
    static final Category CATEGORY = Category.SWAMP;
    static final float DEPTH = -0.2F;
    static final float SCALE = 0.01F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4815438;
    static final int WATER_FOG_COLOR = 6717479;
    static final int GRASS_COLOR = 7375928;
    static final int FOLIAGE_COLOR = 6337104;
    static final String PARENT = null;
    static final Climate WEATHER = new Climate(PRECIPATATION, TEMPERATURE, TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).func_242517_a(SURFACE_BUILDER);

    public GlowShroomBayou() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).setFogColor(12638463).func_242541_f(GRASS_COLOR).func_242540_e(FOLIAGE_COLOR).func_242539_d(BiomeHelper.calcSkyColor(0.8F)).setMoodSound(MoodSoundAmbience.field_235027_b_).build(), GENERATION_SETTINGS.func_242508_a(), SPAWN_SETTINGS.func_242577_b());

    }

    @Override
    public int getFoliageColor() {
        return 6337104;
    }

    @Override
    public Biome getRiver() {
        return this;
    }


    static {
        BYGTreeFeatures.addGlowshroomBayouVegetation(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243738_d(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243746_h(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243748_i(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243750_j(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243755_o(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243712_Z(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243721_ae(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243727_ak(GENERATION_SETTINGS);
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243962_v);
        BYGFeatures.addBYGSwampVegetation(GENERATION_SETTINGS);
        BYGFeatures.addGrass(GENERATION_SETTINGS);
        BYGFeatures.addGlowcane(GENERATION_SETTINGS);
        BYGFeatures.addCattails(GENERATION_SETTINGS);
        BYGFeatures.addMudDisks(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243730_an(GENERATION_SETTINGS);
        BYGFeatures.addPeachleatherflower(GENERATION_SETTINGS);
        BYGFeatures.addVioletleatherflower(GENERATION_SETTINGS);
        BYGFeatures.addRedorchid(GENERATION_SETTINGS);
        BYGFeatures.addPurpleOrchid(GENERATION_SETTINGS);
        BYGFeatures.addPinkOrchid(GENERATION_SETTINGS);
        BYGFeatures.addGlowshrooms(GENERATION_SETTINGS);
        BYGTreeFeatures.addHugeGlowshrooms(GENERATION_SETTINGS);

    }
}
