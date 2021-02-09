package corgiaoc.byg.common.world.biome.end;

import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.common.world.biome.BYGEndBiome;
import corgiaoc.byg.core.BYGSounds;
import corgiaoc.byg.core.world.BYGBiomes;
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
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.WeightedList;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;

import javax.annotation.Nullable;

public class EtherealIslands extends BYGEndBiome {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("ethereal_islands", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.ETHEREAL, BYGSurfaceBuilders.Configs.ETHER));
    static final Biome.Precipitation PRECIPATATION = Biome.Precipitation.NONE;
    static final Biome.Category CATEGORY = Biome.Category.THEEND;
    static final float DEPTH = 0.125F;
    static final float SCALE = 0.05F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.4F;
    static final int WATER_COLOR = 3905655;
    static final int WATER_FOG_COLOR = 3905655;

    static final Biome.Weather WEATHER = new Biome.Weather(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final SpawnSettings.Builder SPAWN_SETTINGS = new SpawnSettings.Builder();
    static final GenerationSettings.Builder GENERATION_SETTINGS = (new GenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    static {
        GENERATION_SETTINGS.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, BYGConfiguredFeatures.ORE_LIGNITE);
        BYGDefaultBiomeFeatures.addEtherPlants(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addSparseEtherTrees(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addTheriumDeposit(GENERATION_SETTINGS);

        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMITE, 5, 1, 2));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 60, 1, 3));
    }

    public EtherealIslands() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR)
                .waterColor(WATER_COLOR)
                .waterFogColor(WATER_FOG_COLOR)
                .fogColor(8339307)
                .skyColor(0)
                .particleConfig(new BiomeParticleConfig(ParticleTypes.REVERSE_PORTAL, 0.00128F))
                .loopSound(BYGSounds.AMBIENT_END_FOREST_LOOP)
                .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_CRIMSON_FOREST_MOOD, 6000, 8, 2.0D))
                .additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, 0.0111D))
                .music(MusicType.createIngameMusic(SoundEvents.MUSIC_END)).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }

    @Override
    public Object getBiomeDictionary() {
        return null; //new BiomeDictionary.Type[]{BiomeDictionary.Type.END};
    }

    @SuppressWarnings("ConstantConditions")
    @Nullable
    @Override
    public WeightedList<Identifier> getHills() {
        WeightedList<Identifier> hillsList = new WeightedList<>();
        hillsList.add(BuiltinRegistries.BIOME.getId(BYGBiomes.ETHEREAL_FOREST), 10);
        hillsList.add(BuiltinRegistries.BIOME.getId(BYGBiomes.ETHEREAL_CLEARING), 5);
        return hillsList;
    }

    @Nullable
    @Override
    public Biome getEdge() {
        return BYGBiomes.ETHEREAL_CLEARING;
    }
}
