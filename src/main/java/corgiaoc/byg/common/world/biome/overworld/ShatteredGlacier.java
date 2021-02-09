package corgiaoc.byg.common.world.biome.overworld;

import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.common.world.biome.BiomeUtil;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.core.world.BYGConfiguredFeatures;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import javax.annotation.Nullable;

public class ShatteredGlacier extends BYGBiome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("shattered_glacier", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.SHATTERED_GLACIER, new TernarySurfaceConfig(Blocks.SNOW_BLOCK.getDefaultState(), Blocks.SNOW_BLOCK.getDefaultState(), Blocks.SNOW_BLOCK.getDefaultState())));
    static final Biome.Precipitation PRECIPATATION = Biome.Precipitation.SNOW;
    static final Biome.Category CATEGORY = Biome.Category.ICY;
    static final float DEPTH = 0.14F;
    static final float SCALE = 0.36F;
    static final float TEMPERATURE = -0.5F;
    static final float DOWNFALL = 0.9F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;

    static final Biome.Weather WEATHER = new Biome.Weather(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final SpawnSettings.Builder SPAWN_SETTINGS = new SpawnSettings.Builder();
    static final GenerationSettings.Builder GENERATION_SETTINGS = (new GenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public ShatteredGlacier() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).skyColor(BiomeUtil.calcSkyColor(0.8F)).moodSound(BiomeMoodSound.CAVE).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }

    @Nullable
    @Override
    public Biome getBeach() {
        return BYGBiomes.BASALT_BARRERA;
    }

    @Override
    public Biome getRiver() {
        return this.getBiome();
    }

    @Override
    public Object getBiomeDictionary() {
        return null; //new BiomeDictionary.Type[]{BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.RARE};
    }

    @Override
    public OverworldClimate getBiomeType() {
        return OverworldClimate.SNOWY;
    }

    @Override
    public int getWeight() {
        return 2;
    }

    static {
        GENERATION_SETTINGS.structureFeature(ConfiguredStructureFeatures.VILLAGE_SNOWY); //Snowy Village
        GENERATION_SETTINGS.structureFeature(ConfiguredStructureFeatures.PILLAGER_OUTPOST); //Pillager Outpost
        GENERATION_SETTINGS.structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL); //Ruined Portal Standard
        DefaultBiomeFeatures.addDefaultUndergroundStructures(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addLandCarvers(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addFrozenTopLayer(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDungeons(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addLargeFerns(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addMineables(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultOres(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultDisks(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultFlowers(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addTaigaGrass(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultMushrooms(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultVegetation(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addWinterGrass(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addWinterRose(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addFrostMagmaLakes(GENERATION_SETTINGS);
        GENERATION_SETTINGS.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, BYGConfiguredFeatures.BLACK_ICE_SNOW);

        SPAWN_SETTINGS.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.RABBIT, 10, 2, 3));
        SPAWN_SETTINGS.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.POLAR_BEAR, 1, 1, 2));
        SPAWN_SETTINGS.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.SNOW_GOLEM, 1, 1, 2));
        SPAWN_SETTINGS.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.BAT, 10, 8, 8));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SPIDER, 100, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE, 95, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.CREEPER, 100, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SLIME, 100, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.WITCH, 5, 1, 1));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SKELETON, 20, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.STRAY, 80, 4, 4));
    }
}
