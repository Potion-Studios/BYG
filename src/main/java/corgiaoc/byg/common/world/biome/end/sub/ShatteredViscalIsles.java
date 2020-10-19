package corgiaoc.byg.common.world.biome.end.sub;

import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
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

public class ShatteredViscalIsles extends BYGBiome {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("viscal_isles", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.ETHEREAL, BYGSurfaceBuilders.Configs.SCULK));
    static final Biome.RainType PRECIPATATION = Biome.RainType.NONE;
    static final Biome.Category CATEGORY = Biome.Category.THEEND;
    static final float DEPTH = 0.125F;
    static final float SCALE = 0.05F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.4F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;

    static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

    public ShatteredViscalIsles() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR)
                .setWaterColor(WATER_COLOR)
                .setWaterFogColor(WATER_FOG_COLOR)
                .setFogColor(8339307)
                .withSkyColor(0)
                .setParticle(new ParticleEffectAmbience(ParticleTypes.CRIMSON_SPORE, 0.00428F))
                .setAmbientSound(SoundEvents.AMBIENT_BASALT_DELTAS_LOOP)
                .setMoodSound(new MoodSoundAmbience(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D))
                .setAdditionsSound(new SoundAdditionsAmbience(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D))
                .setMusic(BackgroundMusicTracks.getDefaultBackgroundMusicSelector(SoundEvents.MUSIC_END)).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.copy());
    }

    static {
        GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.RANDOM_SHATTERED_ISLAND);
        BYGDefaultBiomeFeatures.addVermilionSculkGrowth(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addTheriumCrystals(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addHangingTheriumLanterns(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addDeadEtherTrees(GENERATION_SETTINGS);
        GENERATION_SETTINGS.withStructure(StructureFeatures.field_244151_q).withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.END_GATEWAY);

        SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMITE, 5, 1, 2));
        SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 60, 1, 3));
    }
}
