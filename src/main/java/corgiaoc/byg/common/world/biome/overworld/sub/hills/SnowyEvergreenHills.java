package corgiaoc.byg.common.world.biome.overworld.sub.hills;

import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.common.world.biome.BYGSubBiome;
import corgiaoc.byg.common.world.biome.BiomeUtil;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class SnowyEvergreenHills extends BYGSubBiome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("snowy_evergreen_hills", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, new TernarySurfaceConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())));
    static final Biome.Precipitation PRECIPATATION = Biome.Precipitation.SNOW;
    static final Biome.Category CATEGORY = Biome.Category.TAIGA;
    static final float DEPTH = 0.25F;
    static final float SCALE = 0.1F;
    static final float TEMPERATURE = -0.5F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final int GRASS_COLOR = 5011004;
    static final int FOLIAGE_COLOR = 2263842;

    static final Biome.Weather WEATHER = new Biome.Weather(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final SpawnSettings.Builder SPAWN_SETTINGS = new SpawnSettings.Builder();
    static final GenerationSettings.Builder GENERATION_SETTINGS = (new GenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public SnowyEvergreenHills() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).grassColor(GRASS_COLOR).foliageColor(FOLIAGE_COLOR).skyColor(BiomeUtil.calcSkyColor(0.8F)).moodSound(BiomeMoodSound.CAVE).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }

    @Override
    public Biome getRiver() {
        return BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.FROZEN_RIVER);
    }

    @Override
    public Biome getBeach() {
        return BYGBiomes.SNOWY_BLACK_BEACH;
    }


    @Override
    public Object getBiomeDictionary() {
        return null; //new BiomeDictionary.Type[]{BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD};
    }

    static {
        DefaultBiomeFeatures.addDefaultUndergroundStructures(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addLandCarvers(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDungeons(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addMossyRocks(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addLargeFerns(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addMineables(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultOres(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultDisks(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultFlowers(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addGiantTaigaGrass(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultMushrooms(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultVegetation(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addSprings(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addSweetBerryBushes(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addHollyTrees(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addLushBlueberries(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addMossyStoneBoulder(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addRockyStoneBoulder(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addCrocus(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addIris(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addBYGMushrooms(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addGrass(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addWinterSucculent(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addFrozenTopLayer(GENERATION_SETTINGS);

        SPAWN_SETTINGS.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.SHEEP, 12, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.PIG, 10, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.CHICKEN, 10, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.COW, 8, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 8, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.RABBIT, 4, 2, 3));
        SPAWN_SETTINGS.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FOX, 8, 2, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.BAT, 10, 8, 8));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SPIDER, 100, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE, 100, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SKELETON, 100, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE_VILLAGER, 25, 1, 1));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.CREEPER, 100, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SLIME, 100, 4, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
        SPAWN_SETTINGS.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.WITCH, 5, 1, 1));

    }

}
