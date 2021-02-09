package corgiaoc.byg.common.world.biome.end;

import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.common.world.biome.BYGEndBiome;
import corgiaoc.byg.core.BYGSounds;
import corgiaoc.byg.core.world.BYGConfiguredFeatures;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;

public class ShatteredDesert extends BYGEndBiome {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("shattered_desert", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.SHATTERED_DESERT, BYGSurfaceBuilders.Configs.END));
    static final Biome.Precipitation PRECIPATATION = Biome.Precipitation.NONE;
    static final Biome.Category CATEGORY = Biome.Category.THEEND;
    static final float DEPTH = 0.55F;
    static final float SCALE = 0.15F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;

    static final Biome.Weather WEATHER = new Biome.Weather(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final SpawnSettings.Builder SPAWN_SETTINGS = new SpawnSettings.Builder();
    static final GenerationSettings.Builder GENERATION_SETTINGS = (new GenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    static {
        GENERATION_SETTINGS.feature(GenerationStep.Feature.RAW_GENERATION, BYGConfiguredFeatures.BLACK_SANDSTONE_SPIKE);
        GENERATION_SETTINGS.feature(GenerationStep.Feature.RAW_GENERATION, BYGConfiguredFeatures.BLACK_SANDSTONE_SPIKE2);
        BYGDefaultBiomeFeatures.addShatteredDesertPlants(GENERATION_SETTINGS);
        GENERATION_SETTINGS.structureFeature(ConfiguredStructureFeatures.END_CITY).feature(GenerationStep.Feature.SURFACE_STRUCTURES, ConfiguredFeatures.END_GATEWAY);
        BYGDefaultBiomeFeatures.addTheriumDeposit(GENERATION_SETTINGS);

        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMITE, 5, 1, 2));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 60, 1, 3));
    }

    public ShatteredDesert() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeEffects.Builder())
                .waterColor(WATER_COLOR)
                .waterFogColor(WATER_FOG_COLOR)
                .fogColor(8339307)
                .skyColor(0)
                .particleConfig(new BiomeParticleConfig(ParticleTypes.WHITE_ASH, 0.00428F))
                .loopSound(BYGSounds.AMBIENT_END_OMINOUS_LOOP)
                .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D))
                .additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D))
                .music(MusicType.createIngameMusic(SoundEvents.MUSIC_END)).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }
}
