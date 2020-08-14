package voronoiaoc.byg.common.biomes.endbiomes;

import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import voronoiaoc.byg.common.biomes.BiomeHelper;
import voronoiaoc.byg.common.biomes.BiomeTools;
import voronoiaoc.byg.core.byglists.BYGConfiguredFeatures;
import voronoiaoc.byg.core.byglists.BYGSBList;

public class IvisFields extends Biome implements BiomeTools {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = BiomeHelper.newConfiguredSurfaceBuilder("ivis_fields", new ConfiguredSurfaceBuilder<>(BYGSBList.IVISFIELDS_SB, BYGSBList.BYGSBConfigList.END));
    static final RainType PRECIPATATION = RainType.NONE;
    static final Category CATEGORY = Category.THEEND;
    static final float DEPTH = 0.55F;
    static final float SCALE = 0.15F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;
    static final Climate WEATHER = new Climate(PRECIPATATION, TEMPERATURE, TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).func_242517_a(SURFACE_BUILDER);

    public IvisFields() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).setFogColor(12638463).func_242539_d(BiomeHelper.calcSkyColor(0.8F)).setMoodSound(MoodSoundAmbience.field_235027_b_).build(), GENERATION_SETTINGS.func_242508_a(), SPAWN_SETTINGS.func_242577_b());
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.LOCAL_MODIFICATIONS, BYGConfiguredFeatures.OBBY_SPIKE);
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.LOCAL_MODIFICATIONS, BYGConfiguredFeatures.OBBY_SPIKE);
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243944_d);
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243944_d);
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.VEGETAL_DECORATION, Features.field_243944_d);
    }
}
