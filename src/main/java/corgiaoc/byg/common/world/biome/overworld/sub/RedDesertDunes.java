package corgiaoc.byg.common.world.biome.overworld.sub;

import corgiaoc.byg.common.world.biome.BYGSubBiome;
import corgiaoc.byg.common.world.biome.BiomeUtil;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;

public class RedDesertDunes extends BYGSubBiome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("red_desert_dunes", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.RED_DUNES, BYGSurfaceBuilders.Configs.REDSAND_CF));
    static final Biome.RainType PRECIPATATION = Biome.RainType.NONE;
    static final Biome.Category CATEGORY = Biome.Category.DESERT;
    static final float DEPTH = 1.3F;
    static final float SCALE = 0.5F;
    static final float TEMPERATURE = 2.00F;
    static final float DOWNFALL = 0.0F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    
    static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder().setPlayerCanSpawn();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public RedDesertDunes() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).skyColor(BiomeUtil.calcSkyColor(0.8F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }

    @Nullable
    @Override
    public Biome getRiver() {
        return this.getBiome();
    }

    @Override
    public String[] getBiomeDictionary() {
        return new String[]{"SANDY", "WASTELAND", "HOT", "OVERWORLD", "HILLS"};
    }

    static {
        DefaultBiomeFeatures.addDefaultCarvers(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultOverworldLandStructures(GENERATION_SETTINGS);
        SPAWN_SETTINGS.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.HUSK, 160, 10, 10));
    }
}
