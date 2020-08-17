package voronoiaoc.byg.common.biomes.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import voronoiaoc.byg.common.biomes.BiomeHelper;
import voronoiaoc.byg.common.biomes.BiomeTools;
import voronoiaoc.byg.core.byglists.BYGConfiguredFeatures;
import voronoiaoc.byg.core.byglists.BYGSBList;

public class Volcano extends Biome implements BiomeTools {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = BiomeHelper.newConfiguredSurfaceBuilder("volcano", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, BYGSBList.BYGSBConfigList.BLACKSAND));
    static final RainType PRECIPATATION = RainType.RAIN;
    static final Biome.Category CATEGORY = Category.DESERT;
    static final float DEPTH = 0.2F;
    static final float SCALE = 0.2F;
    static final float TEMPERATURE = 1.7F;
    static final float DOWNFALL = 0.8F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final int GRASS_COLOR = 12032353;
    static final int FOLIAGE_COLOR = 12215394;
    static final String PARENT = null;
    static final Climate WEATHER = new Climate(PRECIPATATION, TEMPERATURE, TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).func_242517_a(SURFACE_BUILDER);

    public Volcano() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR).setFogColor(12638463).func_242541_f(GRASS_COLOR).func_242540_e(FOLIAGE_COLOR).func_242539_d(BiomeHelper.calcSkyColor(0.8F)).setMoodSound(MoodSoundAmbience.field_235027_b_).build(), GENERATION_SETTINGS.func_242508_a(), SPAWN_SETTINGS.func_242577_b());
    }

    @Override
    public Biome getRiver() {
        return this;
    }

//    @Override
//    public HashMap<Biome, Integer> getHills() {
//        HashMap<Biome, Integer> map = new HashMap<>();
//        map.put(BYGBiomeList.SNOWYDECIDUOUSFORESTHILLS, 1);
//        map.put(BYGBiomeList.SNOWY_DECIDUOUS_CLEARING, 2);
//        map.put(BYGBiomeList.FROZENLAKE, 1);
//        return map;
//    }

//    @Override
//    public Biome getHill(INoiseRandom rand) {
//        return randomSubBiome(rand);
//    }
//
//    public Biome randomSubBiome(INoiseRandom random) {
//        int randomPicker = random.random(4);
//        if (randomPicker == 0)
//            return BYGBiomeList.SNOWYDECIDUOUSFORESTHILLS;
//        else if (randomPicker == 1)
//            return BYGBiomeList.SNOWY_DECIDUOUS_CLEARING;
//        else if (randomPicker == 2)
//            return BYGBiomeList.SNOWY_DECIDUOUS_CLEARING;
//        else
//            return BYGBiomeList.FROZENLAKE;
//    }

    static {
        DefaultBiomeFeatures.func_243738_d(GENERATION_SETTINGS);
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.VOLCANO);
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SHEEP, 12, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.PIG, 10, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.CHICKEN, 10, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.COW, 8, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.WOLF, 5, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 95, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SKELETON, 100, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.CREEPER, 100, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SLIME, 100, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 10, 1, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.WITCH, 5, 1, 1));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.STRAY, 80, 4, 4));

    }
}
