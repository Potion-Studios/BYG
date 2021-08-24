package corgiaoc.byg.common.world.biome.end;

import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.common.world.biome.BYGEndBiome;
import corgiaoc.byg.core.BYGSounds;
import corgiaoc.byg.core.world.BYGConfiguredFeatures;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;

public class PurpurPeaks extends BYGEndBiome {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("purpur_peaks", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.PURPUR_PEAKS, BYGSurfaceBuilders.Configs.END));
    static final Biome.RainType PRECIPATATION = Biome.RainType.NONE;
    static final Biome.Category CATEGORY = Biome.Category.THEEND;
    static final float DEPTH = 0.55F;
    static final float SCALE = 0.15F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;

    static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public PurpurPeaks() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder())
                .waterColor(WATER_COLOR)
                .waterFogColor(WATER_FOG_COLOR)
                .fogColor(8339307)
                .skyColor(0)
                .ambientParticle(new ParticleEffectAmbience(ParticleTypes.ASH, 0.00128F))
                .ambientLoopSound(BYGSounds.AMBIENT_END_OMINOUS_LOOP)
                .ambientMoodSound(new MoodSoundAmbience(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D))
                .ambientAdditionsSound(new SoundAdditionsAmbience(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D))
                .backgroundMusic(BackgroundMusicTracks.createGameMusic(SoundEvents.MUSIC_BIOME_SOUL_SAND_VALLEY)).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }


    static {
        GENERATION_SETTINGS.addFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.PURPUR_PEAK);
        BYGDefaultBiomeFeatures.addTheriumDeposit(GENERATION_SETTINGS);
        GENERATION_SETTINGS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.CHORUS_PLANT);
        GENERATION_SETTINGS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.CHORUS_PLANT);
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.END_CITY).addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.END_GATEWAY);

        SPAWN_SETTINGS.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 60, 1, 3));
    }
}
