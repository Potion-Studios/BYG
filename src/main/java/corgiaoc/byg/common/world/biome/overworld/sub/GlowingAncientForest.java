package corgiaoc.byg.common.world.biome.overworld.sub;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import corgiaoc.byg.common.world.biome.BiomeHelper;
import corgiaoc.byg.common.world.biome.BiomeTools;
import corgiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import corgiaoc.byg.common.world.feature.biomefeatures.BYGTreeFeatures;
import corgiaoc.byg.core.byglists.BYGSBList;

public class GlowingAncientForest extends Biome implements BiomeTools {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = BiomeHelper.newConfiguredSurfaceBuilder("glowing_ancient_forest", new ConfiguredSurfaceBuilder<>(BYGSBList.GLOWING_ANCIENT_FOREST_SB, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG));
    static final RainType PRECIPATATION = RainType.RAIN;
    static final Category CATEGORY = Category.FOREST;
    static final float DEPTH = 0.2F;
    static final float SCALE = 0.05F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final int GRASS_COLOR = 5406551;
    static final int FOLIAGE_COLOR = 6589494;

    static final String PARENT = null;
    static final Climate WEATHER = new Climate(PRECIPATATION, TEMPERATURE, TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

    public GlowingAncientForest() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).setFogColor(12638463).withGrassColor(GRASS_COLOR).withFoliageColor(FOLIAGE_COLOR).withSkyColor(BiomeHelper.calcSkyColor(0.8F)).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.copy());
    }

    @Override
    public int getFoliageColor() {
        return 6589494;
    }

    static {
        DefaultBiomeFeatures.withStrongholdAndMineshaft(GENERATION_SETTINGS);
        BYGTreeFeatures.addAncientTrees(GENERATION_SETTINGS);
        BYGTreeFeatures.addHugeGlowshrooms(GENERATION_SETTINGS);
        BYGTreeFeatures.addHugeMushrooms(GENERATION_SETTINGS);
        BYGTreeFeatures.addMeadowTrees(GENERATION_SETTINGS);
        BYGTreeFeatures.addShrubs(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withCavesAndCanyons(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withMonsterRoom(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withCommonOverworldBlocks(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withOverworldOres(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withDisks(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withNormalMushroomGeneration(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withSugarCaneAndPumpkins(GENERATION_SETTINGS);
        DefaultBiomeFeatures.withFrozenTopLayer(GENERATION_SETTINGS);
        BYGFeatures.addGrass(GENERATION_SETTINGS);
        BYGFeatures.addBYGMushrooms(GENERATION_SETTINGS);
        BYGFeatures.addGlowcane(GENERATION_SETTINGS);
        BYGFeatures.addFairyslipper(GENERATION_SETTINGS);
        BYGFeatures.addBlackRose(GENERATION_SETTINGS);
        BYGFeatures.addGlowshrooms(GENERATION_SETTINGS);
        BYGFeatures.addRose(GENERATION_SETTINGS);
        BYGFeatures.addLushBlueberries(GENERATION_SETTINGS);

        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SHEEP, 12, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.MOOSHROOM, 8, 4, 8));
        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.WOLF, 8, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.RABBIT, 4, 2, 3));
        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.FOX, 8, 2, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8));

    }
}
