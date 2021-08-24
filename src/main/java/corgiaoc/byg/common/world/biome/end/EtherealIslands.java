package corgiaoc.byg.common.world.biome.end;

import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.common.world.biome.BYGEndBiome;
import corgiaoc.byg.core.BYGSounds;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.core.world.BYGConfiguredFeatures;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import corgiaoc.byg.mixin.access.BiomeClimateSettingsAccess;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.behavior.WeightedList;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;

public class EtherealIslands extends BYGEndBiome {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("ethereal_islands", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.ETHEREAL, BYGSurfaceBuilders.Configs.ETHER));
    static final Biome.Precipitation PRECIPATATION = Biome.Precipitation.NONE;
    static final Biome.BiomeCategory CATEGORY = Biome.BiomeCategory.THEEND;
    static final float DEPTH = 0.125F;
    static final float SCALE = 0.05F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.4F;
    static final int WATER_COLOR = 3905655;
    static final int WATER_FOG_COLOR = 3905655;

    static final Biome.ClimateSettings WEATHER = BiomeClimateSettingsAccess.create(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnSettings.Builder SPAWN_SETTINGS = new MobSpawnSettings.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public EtherealIslands() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeSpecialEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR)
                .waterColor(WATER_COLOR)
                .waterFogColor(WATER_FOG_COLOR)
                .fogColor(8339307)
                .skyColor(0)
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.REVERSE_PORTAL, 0.00128F))
                .ambientLoopSound(BYGSounds.AMBIENT_END_FOREST_LOOP)
                .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_CRIMSON_FOREST_MOOD, 6000, 8, 2.0D))
                .ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, 0.0111D))
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }

    @Override
    public String[] getBiomeDictionary() {
        return new String[]{"END"};
    }

    @SuppressWarnings("ConstantConditions")
    @Nullable
    @Override
    public WeightedList<ResourceLocation> getHills() {
        WeightedList<ResourceLocation> hillsList = new WeightedList<>();
        hillsList.add(BuiltinRegistries.BIOME.getKey(BYGBiomes.ETHEREAL_FOREST), 10);
        hillsList.add(BuiltinRegistries.BIOME.getKey(BYGBiomes.ETHEREAL_CLEARING), 5);
        return hillsList;
    }

    @Nullable
    @Override
    public Biome getEdge() {
        return BYGBiomes.ETHEREAL_CLEARING;
    }


    static {
        GENERATION_SETTINGS.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.ORE_LIGNITE);
        BYGDefaultBiomeFeatures.addEtherPlants(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addSparseEtherTrees(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addTheriumDeposit(GENERATION_SETTINGS);

        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
    }
}
