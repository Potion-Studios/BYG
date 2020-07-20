package voronoiaoc.byg.common.biomes.netherbiome;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.ChanceRangeConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import voronoiaoc.byg.common.biomes.BiomeFog;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.core.byglists.BYGSBList;

public class WarpedDesert extends Biome implements BiomeFog {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(BYGSBList.WARPEDDESERT_SB, BYGSBList.BYGSBConfigList.WARPEDDESERT);
    static final RainType PRECIPATATION = RainType.RAIN;
    static final Category CATEGORY = Category.NETHER;
    static final double DEPTH = 0.125F;
    static final double SCALE = 0.05F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.4F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;

    public WarpedDesert() {
        super(new Builder().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPATATION).category(CATEGORY).depth((float) DEPTH)
                .func_235097_a_((new BiomeAmbience.Builder()).func_235246_b_(WATER_COLOR).func_235248_c_(WATER_FOG_COLOR)
                        .func_235239_a_(1705242)
                        .func_235244_a_(new ParticleEffectAmbience(ParticleTypes.WARPED_SPORE, 0.01428F))
                        .func_235241_a_(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP)
                        .func_235243_a_(new MoodSoundAmbience(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP, 6000, 8, 2.0D))
                        .func_235242_a_(new SoundAdditionsAmbience(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D))
                        .func_235240_a_(BackgroundMusicTracks.func_232677_a_(SoundEvents.MUSIC_NETHER_SOUL_SAND_VALLEY)).func_235238_a_())
                .func_235098_a_(ImmutableList.of(new Biome.Attributes(0.32F, 0.0F, 0.0F, 0.0F, 0.0F)))

                .scale((float) SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).parent(PARENT));
        this.addCarver(GenerationStage.Carving.AIR, createCarver(WorldCarver.field_236240_b_, new ProbabilityConfig(0.2F)));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING_FEATURE.withConfiguration(DefaultBiomeFeatures.LAVA_SPRING_CONFIG).withPlacement(Placement.COUNT_VERY_BIASED_RANGE.configure(new CountRangeConfig(20, 8, 16, 256))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.SPRING_FEATURE.withConfiguration(DefaultBiomeFeatures.NETHER_SPRING_CONFIG).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 4, 8, 128))));
//        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.field_235147_ap_).withPlacement(Placement.field_236960_A_.configure(new FrequencyConfig(10))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.field_235148_aq_).withPlacement(Placement.field_236960_A_.configure(new FrequencyConfig(10))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.GLOWSTONE_BLOB.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.LIGHT_GEM_CHANCE.configure(new FrequencyConfig(10))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.GLOWSTONE_BLOB.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 128))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).withPlacement(Placement.CHANCE_RANGE.configure(new ChanceRangeConfig(0.5F, 0, 0, 128))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.RED_MUSHROOM_CONFIG).withPlacement(Placement.CHANCE_RANGE.configure(new ChanceRangeConfig(0.5F, 0, 0, 128))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.SPRING_FEATURE.withConfiguration(DefaultBiomeFeatures.ENCLOSED_NETHER_SPRING_CONFIG).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(16, 10, 20, 128))));
//        BYGFeatures.addNetherFortress(this);
        BYGFeatures.addWarpedVegetation(this);
        DefaultBiomeFeatures.func_235192_as_(this);

        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.GHAST, 60, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.PIGLIN, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.MAGMA_CUBE, 2, 4, 4));
    }

    @Override
    public Vector3d getBiomeFogColor(int x, int z, Vector3d originalValue) {
        return WARPEDDESERTVector3d;
    }

    private static final Vector3d WARPEDDESERTVector3d = new Vector3d(0.53F, 0.812F, 0.941F);
}
