package voronoiaoc.byg.common.biomes.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import voronoiaoc.byg.common.biomes.BYGBiomeBuilder;
import voronoiaoc.byg.common.biomes.BiomeHelper;
import voronoiaoc.byg.common.biomes.BiomeTools;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGTreeFeatures;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

import java.util.HashMap;

public class BlueTaiga extends BYGBiomeBuilder implements BiomeTools  {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = BiomeHelper.newConfiguredSurfaceBuilder("blue_taiga", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG));
    static final Biome.RainType PRECIPATATION = Biome.RainType.RAIN;
    static final Biome.Category CATEGORY = Biome.Category.TAIGA;
    static final float DEPTH = 0.2F;
    static final float SCALE = 0.2F;
    static final float TEMPERATURE = 0.25F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;
    static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).func_242517_a(SURFACE_BUILDER);

    public BlueTaiga() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).setFogColor(12638463).func_242539_d(BiomeHelper.calcSkyColor(0.8F)).setMoodSound(MoodSoundAmbience.field_235027_b_).build(), GENERATION_SETTINGS.func_242508_a(), SPAWN_SETTINGS.func_242577_b());
    }

    @Override
    public HashMap<Biome, Integer> getHills() {
        HashMap<Biome, Integer> map = new HashMap<>();
        map.put(BYGBiomeList.FRESHWATERLAKE, 1);
        map.put(BYGBiomeList.BLUEGIANTTAIGA, 2);
        map.put(BYGBiomeList.BLUETAIGAHILLS, 2);
        return map;
    }

    @Override
    public Biome getRiver() {
        return WorldGenRegistries.field_243657_i.getValueForKey(Biomes.RIVER);
    }

    @Override
    public Biome getHill(INoiseRandom rand) {
        return (rand.random(5) == 0) ? BYGBiomeList.FRESHWATERLAKE : pickRandomSubBiome(rand);
    }

    public Biome pickRandomSubBiome(INoiseRandom rand) {
        return (rand.random(2) == 0) ? BYGBiomeList.BLUEGIANTTAIGA : BYGBiomeList.BLUETAIGAHILLS;
    }

    static {
        //StructureFeature.VILLAGE.configure(new StructurePoolFeatureConfig(new Identifier("village/taiga/town_centers"), 6));
        //this.add//StructureFeature(DefaultBiomeFeatures.PILLAGER_OUTPOST);
        DefaultBiomeFeatures.func_243733_b(GENERATION_SETTINGS);
        BYGTreeFeatures.addBlueTaigaTrees(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243757_q(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243738_d(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243746_h(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243748_i(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243750_j(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243754_n(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243707_U(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243710_X(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243712_Z(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243717_aa(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243727_ak(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243759_s(GENERATION_SETTINGS);
        DefaultBiomeFeatures.func_243730_an(GENERATION_SETTINGS);
        BYGFeatures.addBlueberries(GENERATION_SETTINGS);
        BYGFeatures.addCrocus(GENERATION_SETTINGS);
        BYGFeatures.addIris(GENERATION_SETTINGS);
        BYGFeatures.addBYGMushrooms(GENERATION_SETTINGS);
        BYGFeatures.addGrass(GENERATION_SETTINGS);


        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SHEEP, 12, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.PIG, 10, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.CHICKEN, 10, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.COW, 8, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.WOLF, 8, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.RABBIT, 4, 2, 3));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.FOX, 8, 2, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 95, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SKELETON, 100, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.CREEPER, 100, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SLIME, 100, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 10, 1, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.WITCH, 5, 1, 1));
    }
}