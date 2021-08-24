package corgiaoc.byg.common.world.biome.end;

import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.common.world.biome.BYGEndBiome;
import corgiaoc.byg.core.BYGSounds;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class ImpariusGrove extends BYGEndBiome {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("imparius_grove", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, BYGSurfaceBuilders.Configs.IMPARIUS));
    static final Biome.RainType PRECIPATATION = Biome.RainType.NONE;
    static final Biome.Category CATEGORY = Biome.Category.THEEND;
    static final float DEPTH = 0.125F;
    static final float SCALE = 0.05F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.4F;
    static final int WATER_COLOR = 3722412;
    static final int WATER_FOG_COLOR = 3722412;

    static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public ImpariusGrove() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR)
                .waterColor(WATER_COLOR)
                .waterFogColor(WATER_FOG_COLOR)
                .fogColor(10518688)
                .skyColor(0)
                .ambientParticle(new ParticleEffectAmbience(ParticleTypes.WARPED_SPORE, 0.00428F))
                .ambientLoopSound(BYGSounds.AMBIENT_END_FOREST_LOOP)
                .ambientMoodSound(new MoodSoundAmbience(SoundEvents.AMBIENT_NETHER_WASTES_MOOD, 6000, 8, 2.0D))
                .ambientAdditionsSound(new SoundAdditionsAmbience(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111D))
                .backgroundMusic(BackgroundMusicTracks.createGameMusic(SoundEvents.MUSIC_END)).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
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
        hillsList.add(WorldGenRegistries.BIOME.getKey(BYGBiomes.IMPARIUS_CLEARING), 10);
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
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.END_CITY).addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.END_GATEWAY);
        BYGDefaultBiomeFeatures.addTheriumDeposit(GENERATION_SETTINGS);
//        BYGDefaultBiomeFeatures.addEnderLily(GENERATION_SETTINGS);

        SPAWN_SETTINGS.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMITE, 2, 1, 2));
        SPAWN_SETTINGS.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 60, 1, 3));
    }
}
