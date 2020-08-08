package voronoiaoc.byg.common.biomes.netherbiome;

import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import voronoiaoc.byg.common.biomes.BiomeHelper;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.core.byglists.BYGConfiguredTreeFeatures;
import voronoiaoc.byg.core.byglists.BYGSBList;

public class EmburBog extends Biome {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = BiomeHelper.newConfiguredSurfaceBuilder("embur_bog", new ConfiguredSurfaceBuilder<>(BYGSBList.EMBURBOG, BYGSBList.BYGSBConfigList.EMBURNYLIUM));
    static final Precipitation PRECIPATATION = Precipitation.RAIN;
    static final Category CATEGORY = Category.NETHER;
    static final float DEPTH = 0.125F;
    static final float SCALE = 0.05F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.4F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;
    static final Weather WEATHER = new Weather(PRECIPATATION, TEMPERATURE, TemperatureModifier.NONE, DOWNFALL);
    static final SpawnSettings.Builder SPAWN_SETTINGS = new SpawnSettings.Builder();
    static final GenerationSettings.Builder GENERATION_SETTINGS = (new GenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public EmburBog() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR)
                .fogColor(15110510)
                .skyColor(BiomeHelper.calcSkyColor(2.0F))
                .particleConfig(new BiomeParticleConfig(ParticleTypes.FLAME, 0.01428F))
                .loopSound(SoundEvents.AMBIENT_BASALT_DELTAS_LOOP)
                .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D))
                .additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D))
                .music(MusicType.createIngameMusic(SoundEvents.MUSIC_NETHER_BASALT_DELTAS)).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }

    @Override
    public int getGrassColorAt(double posX, double posZ) {
        return 10855786;

    }

    @Override
    public int getFoliageColor() {
        return 10855786;
    }

    static {
        //TODO: Reenable Embur Bog lake.
//        GENERATION_SETTINGS.feature(GenerationStep.Feature.RAW_GENERATION, BYGFeatureList.EMBURLAKE.configure(DefaultFeatureConfig.DEFAULT).decorate(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(8, 0, 4, 128))));
        GENERATION_SETTINGS.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE);
        GENERATION_SETTINGS.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.SPRING_CLOSED);
        GENERATION_SETTINGS.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.SPRING_LAVA);
        GENERATION_SETTINGS.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.PATCH_FIRE);
        GENERATION_SETTINGS.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.GLOWSTONE_EXTRA);
        GENERATION_SETTINGS.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.GLOWSTONE);
        GENERATION_SETTINGS.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.BROWN_MUSHROOM_NETHER);
        GENERATION_SETTINGS.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.RED_MUSHROOM_NETHER);
        GENERATION_SETTINGS.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.ORE_MAGMA);
        GENERATION_SETTINGS.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, BYGConfiguredTreeFeatures.RANDOM_EMBUR_MUSHROOM);

        BYGFeatures.addEmburBogVegetation(GENERATION_SETTINGS);

        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.BLAZE, 40, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIFIED_PIGLIN, 80, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.MAGMA_CUBE, 100, 2, 5));

    }
}
