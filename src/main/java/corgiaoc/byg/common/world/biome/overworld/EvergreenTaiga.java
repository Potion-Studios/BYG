package corgiaoc.byg.common.world.biome.overworld;

import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.common.world.biome.BiomeUtil;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.block.Blocks;
import net.minecraft.util.WeightedList;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import corgiaoc.byg.util.MLClimate;

public class EvergreenTaiga extends BYGBiome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("evergreen_taiga", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.DIRT.defaultBlockState())));
    static final Biome.RainType PRECIPATATION = Biome.RainType.RAIN;
    static final Biome.Category CATEGORY = Biome.Category.TAIGA;
    static final float DEPTH = 0.75F;
    static final float SCALE = 0.1F;
    static final float TEMPERATURE = 0.25F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final int GRASS_COLOR = 5011004;
    static final int FOLIAGE_COLOR = 2263842;

    static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder().setPlayerCanSpawn();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public EvergreenTaiga() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).grassColorOverride(GRASS_COLOR).foliageColorOverride(FOLIAGE_COLOR).skyColor(BiomeUtil.calcSkyColor(0.8F)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }

    @Nullable
    @Override
    public WeightedList<Biome> getHills() {
        WeightedList<Biome> biomeWeightedList = new WeightedList<>();
        biomeWeightedList.add(BYGBiomes.EVERGREEN_HILLS, 4);
        biomeWeightedList.add(BYGBiomes.EVERGREEN_CLEARING, 3);
        biomeWeightedList.add(BYGBiomes.EVERGREEN_CLEARING, 3);
        return biomeWeightedList;
    }

    @Override
    public String[] getBiomeDictionary() {
        return new String[]{"CONIFEROUS", "FOREST", "COLD", "OVERWORLD"};
    }

    @Override
    public MLClimate getClimate() {
        return MLClimate.ICY;
    }

    @Override
    public int getWeight() {
        return 6;
    }

    static {
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.PILLAGER_OUTPOST); //Pillager Outpost
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD); //Ruined Portal Standard
        DefaultBiomeFeatures.addDefaultOverworldLandStructures(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultCarvers(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultMonsterRoom(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addMossyStoneBlock(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addFerns(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultUndergroundVariety(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultOres(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultSoftDisks(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultFlowers(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addGiantTaigaVegetation(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultMushrooms(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultExtraVegetation(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultSprings(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addSparseBerryBushes(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addHollyTrees(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addLushBlueberries(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addMossyStoneBoulder(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addRockyStoneBoulder(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addCrocus(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addIris(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addBYGMushrooms(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addGrass(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addWinterSucculent(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addSurfaceFreezing(GENERATION_SETTINGS);

    }
}
