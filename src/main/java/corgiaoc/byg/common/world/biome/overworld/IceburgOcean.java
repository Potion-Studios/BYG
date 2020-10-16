package corgiaoc.byg.common.world.biome.overworld;

import com.google.common.collect.Maps;
import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.common.world.biome.BiomeUtil;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.world.BYGConfiguredFeatures;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Collections;
import java.util.HashMap;

public class IceburgOcean extends BYGBiome {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("iceburg_ocean", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.ICEBURG_OCEAN, new SurfaceBuilderConfig(Blocks.ICE.getDefaultState(), Blocks.WATER.getDefaultState(), Blocks.SAND.getDefaultState())));
    static final Biome.RainType PRECIPATATION = Biome.RainType.RAIN;
    static final Biome.Category CATEGORY = Biome.Category.OCEAN;
    static final float DEPTH = -4.0F;
    static final float SCALE = 0.01F;
    static final float TEMPERATURE = 0.40F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 13819647;

    static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

    public IceburgOcean() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).setFogColor(12638463).withSkyColor(BiomeUtil.calcSkyColor(0.8F)).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.copy());
    }

    @Override
    public HashMap<Biome, Integer> getEdges() {
        return Maps.newHashMap(Collections.singletonMap(this.getBiome(), 1));
    }


    static {
        DefaultBiomeFeatures.withFrozenTopLayer(GENERATION_SETTINGS);
        GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.ICEBURG);

        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.COD, 12, 4, 8));
        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SALMON, 10, 4, 7));
        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SQUID, 10, 4, 6));
        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.DROWNED, 8, 4, 4));
    }
}
