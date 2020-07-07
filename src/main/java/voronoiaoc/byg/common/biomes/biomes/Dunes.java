package voronoiaoc.byg.common.biomes.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import voronoiaoc.byg.core.byglists.BYGBiomeList;
import voronoiaoc.byg.core.byglists.BYGSBList;

import javax.annotation.Nullable;

public class Dunes extends Biome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(BYGSBList.DUNES_SB, BYGSBList.BYGSBConfigList.SAND_CF);
    static final RainType PRECIPATATION = RainType.NONE;
    static final Category CATEGORY = Category.DESERT;
    static final double DEPTH = 1.3F;
    static final double SCALE = 0.5F;
    static final float TEMPERATURE = 2.00F;
    static final float DOWNFALL = 0.0F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;

    public Dunes() {
        super(new Builder().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPATATION).category(CATEGORY).depth((float) DEPTH).func_235097_a_((new BiomeAmbience.Builder()).func_235246_b_(WATER_COLOR).func_235248_c_(WATER_FOG_COLOR).func_235239_a_(12638463).func_235243_a_(MoodSoundAmbience.field_235027_b_).func_235238_a_()).scale((float) SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).parent(PARENT));//this.addStructure(Feature.VILLAGE.withConfiguration(new VillageConfig("village/desert/town_centers", 6)));
        this.func_235063_a_(DefaultBiomeFeatures.field_235134_a_);
        //this.addStructure(Feature.DESERT_PYRAMID.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        DefaultBiomeFeatures.func_235196_b_(this);
    }

    @Nullable
    @Override
    public Biome getHill(INoiseRandom rand) {
        return BYGBiomeList.OASIS;
    }
}
