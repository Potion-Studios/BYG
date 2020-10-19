package corgiaoc.byg.common.world.biome.overworld;

import com.google.common.collect.Maps;
import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.biome.BiomeUtil;
import corgiaoc.byg.common.world.surfacebuilder.config.FillSurfaceBuilderConfig;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;

import java.util.Collections;
import java.util.HashMap;

public class Dunes extends BYGBiome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("dunes", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.FILL, new FillSurfaceBuilderConfig.Builder().setFillBlock(Blocks.SAND).setTopBlock(Blocks.SAND).setUnderBlock(Blocks.SAND).setFillDownToY(63).build()));
    static final Biome.RainType PRECIPATATION = Biome.RainType.NONE;
    static final Biome.Category CATEGORY = Biome.Category.DESERT;
    static final float DEPTH = 1.3F;
    static final float SCALE = 0.5F;
    static final float TEMPERATURE = 2.00F;
    static final float DOWNFALL = 0.0F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;

    static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

    public Dunes() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).setFogColor(12638463).withSkyColor(BiomeUtil.calcSkyColor(0.8F)).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.copy());
    }


    public HashMap<Biome, Integer> getHills() {
        return Maps.newHashMap(Collections.singletonMap(BYGBiomes.OASIS, 1));
    }

    public Biome getHills(INoiseRandom rand) {
        return BYGBiomes.OASIS;
    }

    static {
        DefaultBiomeFeatures.withStrongholdAndMineshaft(GENERATION_SETTINGS);
    }
}
