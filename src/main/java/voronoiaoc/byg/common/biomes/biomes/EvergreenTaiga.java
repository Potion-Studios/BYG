package voronoiaoc.byg.common.biomes.biomes;

import com.google.common.collect.Maps;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import voronoiaoc.byg.common.biomes.BiomeHelper;
import voronoiaoc.byg.common.biomes.BiomeTools;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGTreeFeatures;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

import java.util.HashMap;
import java.util.Random;

public class EvergreenTaiga extends Biome implements BiomeTools {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = BiomeHelper.newConfiguredSurfaceBuilder("evergreen_taiga", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, new SurfaceBuilderBaseConfiguration(Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.DIRT.defaultBlockState())));
    static final Precipitation PRECIPATATION = Precipitation.RAIN;
    static final BiomeCategory CATEGORY = BiomeCategory.TAIGA;
    static final float DEPTH = 0.75F;
    static final float SCALE = 0.1F;
    static final float TEMPERATURE = 0.25F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final int GRASS_COLOR = 5011004;
    static final int FOLIAGE_COLOR = 2263842;
    static final String PARENT = null;
    static final ClimateSettings WEATHER = new ClimateSettings(PRECIPATATION, TEMPERATURE, TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnSettings.Builder SPAWN_SETTINGS = new MobSpawnSettings.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public EvergreenTaiga() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeSpecialEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).grassColorOverride(GRASS_COLOR).foliageColorOverride(FOLIAGE_COLOR).skyColor(BiomeHelper.calcSkyColor(0.8F)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }

    @Override
    public Biome getRiver() {
        return BuiltinRegistries.BIOME.get(Biomes.FROZEN_RIVER);
    }

    @Override
    public HashMap<Biome, Integer> getHills() {
        HashMap<Biome, Integer> map = Maps.newHashMap();
        map.put(BYGBiomeList.EVERGREEN_HILLS, 1);
        map.put(BYGBiomeList.EVERGREEN_CLEARING, 2);
        map.put(BYGBiomeList.FRESHWATERLAKE, 1);
        return map;
    }


    public Biome randomSubBiome(Random random) {
        int randomPicker = random.nextInt(4);
        if (randomPicker == 0)
            return BYGBiomeList.EVERGREEN_HILLS;
        else if (randomPicker == 1)
            return BYGBiomeList.EVERGREEN_CLEARING;
        else if (randomPicker == 2)
            return BYGBiomeList.EVERGREEN_CLEARING;
        else
            return BYGBiomeList.FRESHWATERLAKE;
    }

    static {
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.WOODLAND_MANSION);
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
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
        BYGTreeFeatures.addHollyTrees(GENERATION_SETTINGS);
        BYGFeatures.addLushBlueberries(GENERATION_SETTINGS);
        BYGFeatures.addMossyStoneBoulder(GENERATION_SETTINGS);
        BYGFeatures.addRockyStoneBoulder(GENERATION_SETTINGS);
        BYGFeatures.addCrocus(GENERATION_SETTINGS);
        BYGFeatures.addIris(GENERATION_SETTINGS);
        BYGFeatures.addBYGMushrooms(GENERATION_SETTINGS);
        BYGFeatures.addGrass(GENERATION_SETTINGS);
        BYGFeatures.addWinterSucculent(GENERATION_SETTINGS);
        BiomeDefaultFeatures.addSurfaceFreezing(GENERATION_SETTINGS);

    }
}
