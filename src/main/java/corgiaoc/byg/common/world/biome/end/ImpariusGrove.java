package corgiaoc.byg.common.world.biome.end;

import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.common.world.biome.BYGEndBiome;
import corgiaoc.byg.core.BYGSounds;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import corgiaoc.byg.mixin.access.BiomeClimateSettingsAccess;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.Features;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.behavior.WeightedList;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;

public class ImpariusGrove extends BYGEndBiome {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("imparius_grove", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, BYGSurfaceBuilders.Configs.IMPARIUS));
    static final Biome.Precipitation PRECIPATATION = Biome.Precipitation.NONE;
    static final Biome.BiomeCategory CATEGORY = Biome.BiomeCategory.THEEND;
    static final float DEPTH = 0.125F;
    static final float SCALE = 0.05F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.4F;
    static final int WATER_COLOR = 3722412;
    static final int WATER_FOG_COLOR = 3722412;

    static final Biome.ClimateSettings WEATHER = BiomeClimateSettingsAccess.create(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnSettings.Builder SPAWN_SETTINGS = new MobSpawnSettings.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public ImpariusGrove() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeSpecialEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR)
                .waterColor(WATER_COLOR)
                .waterFogColor(WATER_FOG_COLOR)
                .fogColor(10518688)
                .skyColor(0)
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.WARPED_SPORE, 0.00428F))
                .ambientLoopSound(BYGSounds.AMBIENT_END_FOREST_LOOP)
                .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_NETHER_WASTES_MOOD, 6000, 8, 2.0D))
                .ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111D))
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_END)).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }

    @Nullable
    @Override
    public Biome getEdge() {
        return BYGBiomes.IMPARIUS_CLEARING;
    }

    @SuppressWarnings("ConstantConditions")
    @Nullable
    @Override
    public WeightedList<ResourceLocation> getHills() {
        WeightedList<ResourceLocation> hillsList = new WeightedList<>();
        hillsList.add(BuiltinRegistries.BIOME.getKey(BYGBiomes.IMPARIUS_CLEARING), 10);
        return hillsList;
    }

    @Override
    public String[] getBiomeDictionary() {
        return new String[]{"END"};
    }


    static {
        BYGDefaultBiomeFeatures.addImpariusPlants(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addFungalImparius(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addImpariusMushrooms(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addEndLake(GENERATION_SETTINGS);
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.END_CITY).addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, Features.END_GATEWAY);
        BYGDefaultBiomeFeatures.addTheriumDeposit(GENERATION_SETTINGS);
//        BYGDefaultBiomeFeatures.addEnderLily(GENERATION_SETTINGS);

        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 2, 1, 2));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
    }
}
