package corgiaoc.byg.common.world.biome.overworld.sub;

import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.common.world.biome.BYGSubBiome;
import corgiaoc.byg.common.world.biome.BiomeUtil;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class RedRockLowlands extends BYGSubBiome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("red_rock_lowlands", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.RED_ROCK_LOWLANDS, SurfaceBuilder.GRASS_CONFIG));
    static final Biome.Precipitation PRECIPATATION = Biome.Precipitation.RAIN;
    static final Biome.Category CATEGORY = Biome.Category.PLAINS;
    static final float DEPTH = 0.2F;
    static final float SCALE = 0.15F;
    static final float TEMPERATURE = 1.2F;
    static final float DOWNFALL = 0.1F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final int GRASS_COLOR = 10855786;
    static final int FOLIAGE_COLOR = 10855786;

    static final Biome.Weather WEATHER = new Biome.Weather(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final SpawnSettings.Builder SPAWN_SETTINGS = new SpawnSettings.Builder().playerSpawnFriendly();
    static final GenerationSettings.Builder GENERATION_SETTINGS = (new GenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public RedRockLowlands() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).grassColor(GRASS_COLOR).foliageColor(FOLIAGE_COLOR).skyColor(BiomeUtil.calcSkyColor(0.8F)).moodSound(BiomeMoodSound.CAVE).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }

    @Override
    public Object getBiomeDictionary() {
        return null; //new BiomeDictionary.Type[]{BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.HOT};
    }

    static {
        DefaultBiomeFeatures.addDefaultUndergroundStructures(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addLandCarvers(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDungeons(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addMineables(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultOres(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addExtraGoldOre(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addEmeraldOre(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultDisks(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultMushrooms(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultVegetation(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addFrozenTopLayer(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addTerracottaBoulder(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addForestGrass(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addPaloVerdeTrees(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addBYGMushrooms(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addGrass(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addFirecracker(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDesertVegetation(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addBYGDesertPlants(GENERATION_SETTINGS);

        SPAWN_SETTINGS.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.RABBIT, 4, 2, 3));
        SPAWN_SETTINGS.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.BAT, 10, 8, 8));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SPIDER, 100, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.HUSK, 95, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SKELETON, 100, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.CREEPER, 100, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SLIME, 100, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.WITCH, 5, 1, 1));

    }
}
