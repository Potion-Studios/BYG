package corgiaoc.byg.common.world.biome.overworld;

import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.common.world.biome.BiomeUtil;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import corgiaoc.byg.mixin.access.BiomeClimateSettingsAccess;
import corgiaoc.byg.util.MLClimate;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.behavior.WeightedList;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.minecraft.world.level.newbiome.context.Context;

public class SnowyEvergreenTaiga extends BYGBiome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("snowy_evergreen_taiga", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, new SurfaceBuilderBaseConfiguration(Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.DIRT.defaultBlockState())));
    static final Biome.Precipitation PRECIPATATION = Biome.Precipitation.RAIN;
    static final Biome.BiomeCategory CATEGORY = Biome.BiomeCategory.TAIGA;
    static final float DEPTH = 0.35F;
    static final float SCALE = 0.01F;
    static final float TEMPERATURE = -0.5F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final int GRASS_COLOR = 5011004;
    static final int FOLIAGE_COLOR = 2263842;

    static final Biome.ClimateSettings WEATHER = BiomeClimateSettingsAccess.create(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnSettings.Builder SPAWN_SETTINGS = new MobSpawnSettings.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public SnowyEvergreenTaiga() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeSpecialEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).grassColorOverride(GRASS_COLOR).foliageColorOverride(FOLIAGE_COLOR).skyColor(BiomeUtil.calcSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }

    @Nullable
    @Override
    public Biome getBeach() {
        return BYGBiomes.SNOWY_ROCKY_BLACK_BEACH;
    }


    @Override
    public Biome getRiver() {
        return BuiltinRegistries.BIOME.getOrThrow(Biomes.FROZEN_RIVER);
    }

    public Biome randomSubBiome(Context random) {
        int randomPicker = random.nextRandom(4);
        if (randomPicker == 0)
            return BYGBiomes.SNOWY_EVERGREEN_HILLS;
        else if (randomPicker == 1)
            return BYGBiomes.SNOWY_EVERGREEN_CLEARING;
        else if (randomPicker == 2)
            return BYGBiomes.SNOWY_EVERGREEN_CLEARING;
        else
            return BYGBiomes.FRESH_WATER_LAKE;
    }

    @Nullable
    @Override
    public WeightedList<Biome> getHills() {
        WeightedList<Biome> biomeWeightedList = new WeightedList<>();
        biomeWeightedList.add(BYGBiomes.SNOWY_EVERGREEN_CLEARING, 4);
        biomeWeightedList.add(BYGBiomes.SNOWY_EVERGREEN_HILLS, 3);
        biomeWeightedList.add(BYGBiomes.FROZEN_LAKE, 3);
        return biomeWeightedList;
    }

    @Override
    public String[] getBiomeDictionary() {
        return new String[]{"FOREST", "SNOWY", "CONIFEROUS", "OVERWORLD"};
    }

    @Override
    public MLClimate getClimate() {
        return MLClimate.COLD;
    }

    @Override
    public int getWeight() {
        return 6;
    }

    static {
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.PILLAGER_OUTPOST); //Pillager Outpost
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD); //Ruined Portal Standard
        BiomeDefaultFeatures.addDefaultOverworldLandStructures(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultCarvers(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultMonsterRoom(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addMossyStoneBlock(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addFerns(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultOres(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultSoftDisks(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultFlowers(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addGiantTaigaVegetation(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultMushrooms(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultExtraVegetation(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addDefaultSprings(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addSparseBerryBushes(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addHollyTrees(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addLushBlueberries(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addMossyStoneBoulder(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addRockyStoneBoulder(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addCrocus(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addIris(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addBYGMushrooms(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addGrass(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addWinterSucculent(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addSurfaceFreezing(GENERATION_SETTINGS);

        SPAWN_SETTINGS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
        SPAWN_SETTINGS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 25, 1, 1));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
    }
}
