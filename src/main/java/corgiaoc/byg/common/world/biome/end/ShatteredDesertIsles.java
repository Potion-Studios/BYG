package corgiaoc.byg.common.world.biome.end;

import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.common.world.biome.BYGEndBiome;
import corgiaoc.byg.core.BYGSounds;
import corgiaoc.byg.core.world.BYGConfiguredFeatures;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import corgiaoc.byg.mixin.access.BiomeClimateSettingsAccess;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.Features;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;

public class ShatteredDesertIsles extends BYGEndBiome {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("shattered_desert_isles", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.SHATTERED_DESERT, BYGSurfaceBuilders.Configs.END));
    static final Biome.Precipitation PRECIPATATION = Biome.Precipitation.NONE;
    static final Biome.BiomeCategory CATEGORY = Biome.BiomeCategory.THEEND;
    static final float DEPTH = 0.125F;
    static final float SCALE = 0.05F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.4F;
    static final int WATER_COLOR = 10040012;
    static final int WATER_FOG_COLOR = 10040012;

    static final Biome.ClimateSettings WEATHER = BiomeClimateSettingsAccess.create(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnSettings.Builder SPAWN_SETTINGS = new MobSpawnSettings.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public ShatteredDesertIsles() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeSpecialEffects.Builder())
                .waterColor(WATER_COLOR)
                .waterFogColor(WATER_FOG_COLOR)
                .fogColor(8339307)
                .skyColor(0)
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.00428F))
                .ambientLoopSound(BYGSounds.AMBIENT_END_OMINOUS_LOOP)
                .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D))
                .ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D))
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }

    @Override
    public String[] getBiomeDictionary() {
        return new String[]{"END", "VOID"};
    }

    static {
        GENERATION_SETTINGS.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGConfiguredFeatures.RANDOM_DESERT_END_ISLAND);
        GENERATION_SETTINGS.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGConfiguredFeatures.END_STONE_BRICK_SPIKE);
        GENERATION_SETTINGS.addFeature(GenerationStep.Decoration.RAW_GENERATION, BYGConfiguredFeatures.END_STONE_BRICK_SPIKE2);
        BYGDefaultBiomeFeatures.addShatteredDesertPlants(GENERATION_SETTINGS);
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.END_CITY).addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, Features.END_GATEWAY);
        BYGDefaultBiomeFeatures.addTheriumDeposit(GENERATION_SETTINGS);
        GENERATION_SETTINGS.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.CHORUS_PLANT);
        GENERATION_SETTINGS.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Features.CHORUS_PLANT);

        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
    }
}
