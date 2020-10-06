package corgiaoc.byg.common.world.biome.overworld;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import corgiaoc.byg.common.world.biome.BiomeHelper;
import corgiaoc.byg.common.world.biome.BiomeTools;
import corgiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import corgiaoc.byg.common.world.feature.biomefeatures.BYGTreeFeatures;
import corgiaoc.byg.core.byglists.BYGBiomeList;

import java.util.HashMap;

public class TropicalIslands extends Biome implements BiomeTools {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = BiomeHelper.newConfiguredSurfaceBuilder("tropical_islands", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())));
    static final RainType PRECIPATATION = RainType.RAIN;
    static final Category CATEGORY = Category.OCEAN;
    static final float DEPTH = 0.05F;
    static final float SCALE = 0.35F;
    static final float TEMPERATURE = 0.95F;
    static final float DOWNFALL = 0.9F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;
    static final Climate WEATHER = new Climate(PRECIPATATION, TEMPERATURE, TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

    public TropicalIslands() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).setFogColor(12638463).withSkyColor(BiomeHelper.calcSkyColor(0.8F)).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.copy());
    }

    @Override
    public int getFoliageColor() {
        return 10145074;
    }

    @Override
    public HashMap<Biome, Integer> getHills() {
        HashMap<Biome, Integer> map = new HashMap<>();
        map.put(BYGBiomeList.TROPICAL_ISLAND_MOUNTAINS, 1);
        map.put(BYGBiomeList.TROPICAL_ISLAND_CLEARING, 1);
        return map;
    }

    @Override
    public Biome getRiver() {
        return this;
    }

    @Override
    public Biome getHill(INoiseRandom rand) {
        return randomSubBiome(rand);
    }

    public Biome randomSubBiome(INoiseRandom random) {
        int randomPicker = random.random(4);
        if (randomPicker == 0)
            return BYGBiomeList.TROPICAL_ISLAND_MOUNTAINS;
        else if (randomPicker == 1)
            return BYGBiomeList.TROPICAL_ISLAND_MOUNTAINS;
        else if (randomPicker == 2)
            return BYGBiomeList.TROPICAL_ISLAND_CLEARING;
        else
            return BYGBiomeList.TROPICAL_ISLAND_CLEARING;
    }

    static {
        GENERATION_SETTINGS.withStructure(StructureFeatures.field_244147_m); //Ocean Ruin Cold
        GENERATION_SETTINGS.withStructure(StructureFeatures.field_244139_e); //Jungle Temple
        GENERATION_SETTINGS.withStructure(StructureFeatures.field_244130_A); //Ruined Portal Jungle
        DefaultBiomeFeatures.withMonsterRoom(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withStrongholdAndMineshaft(GENERATION_SETTINGS);
        BYGTreeFeatures.addCragRainbowTrees(GENERATION_SETTINGS);
        BYGFeatures.addBYGTropicFlowers(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withCavesAndCanyons(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withCommonOverworldBlocks(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withOverworldOres(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withDisks(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withWarmFlowers(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withNormalMushroomGeneration(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withSugarCaneAndPumpkins(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withLavaAndWaterSprings(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withMelonPatchesAndVines(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withFrozenTopLayer(GENERATION_SETTINGS);
        BYGFeatures.addGrass(GENERATION_SETTINGS);
        BYGFeatures.addBYGMushrooms(GENERATION_SETTINGS);
        BYGFeatures.addMGCoral(GENERATION_SETTINGS);


        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SHEEP, 12, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.PIG, 10, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.CHICKEN, 10, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.COW, 8, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.PARROT, 40, 1, 2));
        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.CHICKEN, 10, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8));

    }
}
