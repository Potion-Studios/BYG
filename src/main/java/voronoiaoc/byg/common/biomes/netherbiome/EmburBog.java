package voronoiaoc.byg.common.biomes.netherbiome;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Blocks;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeParticleConfig;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.carver.Carver;
import net.minecraft.world.gen.decorator.ChanceRangeDecoratorConfig;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import voronoiaoc.byg.common.biomes.BiomeFog;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.core.byglists.BYGFeatureList;
import voronoiaoc.byg.core.byglists.BYGSBList;

public class EmburBog extends Biome {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(BYGSBList.EMBURBOG, BYGSBList.BYGSBConfigList.EMBURNYLIUM);
    static final Precipitation PRECIPATATION = Precipitation.RAIN;
    static final Category CATEGORY = Category.NETHER;
    static final double DEPTH = 0.125F;
    static final double SCALE = 0.05F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.4F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;

    public EmburBog() {
        super(new Settings().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPATATION).category(CATEGORY).depth((float) DEPTH).scale((float) SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).parent(PARENT)
                .effects((new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR)
                        .fogColor(15110510)
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.FLAME, 0.01428F))
                        .loopSound(SoundEvents.AMBIENT_BASALT_DELTAS_LOOP)
                        .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D))
                        .additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D))
                        .music(MusicType.method_27283(SoundEvents.MUSIC_NETHER_BASALT_DELTAS)).build())
                .noises(ImmutableList.of(new MixedNoisePoint(0.65F, 0.0F, -0.43F, 0.0F, 0.0F))));


        this.addFeature(GenerationStep.Feature.RAW_GENERATION, BYGFeatureList.EMBURLAKE.configure(DefaultFeatureConfig.DEFAULT).method_30374(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(8, 0, 4, 128))));
        this.addCarver(GenerationStep.Carver.AIR, configureCarver(Carver.NETHER_CAVE, new ProbabilityConfig(0.2F)));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.SPRING_FEATURE.configure(DefaultBiomeFeatures.NETHER_SPRING_CONFIG).method_30374(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(8, 4, 8, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.NETHER_FIRE_CONFIG).method_30374(Decorator.FIRE.configure(new CountDecoratorConfig(10))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.GLOWSTONE_BLOB.configure(DefaultFeatureConfig.DEFAULT).method_30374(Decorator.LIGHT_GEM_CHANCE.configure(new CountDecoratorConfig(10))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.GLOWSTONE_BLOB.configure(DefaultFeatureConfig.DEFAULT).method_30374(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).method_30374(Decorator.CHANCE_RANGE.configure(new ChanceRangeDecoratorConfig(0.5F, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.RED_MUSHROOM_CONFIG).method_30374(Decorator.CHANCE_RANGE.configure(new ChanceRangeDecoratorConfig(0.5F, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NETHERRACK, Blocks.MAGMA_BLOCK.getDefaultState(), 33)).method_30374(Decorator.MAGMA.configure(new CountDecoratorConfig(4))));
        BYGFeatures.addEmburBogVegetation(this);

        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.BLAZE, 40, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ZOMBIFIED_PIGLIN, 80, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.MAGMA_CUBE, 100, 2, 5));
    }

    @Override
    public int getGrassColorAt(double posX, double posZ) {
        return 10855786;

    }

    @Override
    public int getFoliageColor() {
        return 10855786;
    }
}
