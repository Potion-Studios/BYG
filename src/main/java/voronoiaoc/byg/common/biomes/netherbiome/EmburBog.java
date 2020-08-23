package voronoiaoc.byg.common.biomes.netherbiome;

import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import voronoiaoc.byg.common.biomes.BiomeHelper;
import voronoiaoc.byg.common.biomes.BiomeTools;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.core.byglists.BYGConfiguredFeatures;
import voronoiaoc.byg.core.byglists.BYGConfiguredTreeFeatures;
import voronoiaoc.byg.core.byglists.BYGSBList;

public class EmburBog extends Biome implements BiomeTools {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = BiomeHelper.newConfiguredSurfaceBuilder("embur_bog", new ConfiguredSurfaceBuilder<>(BYGSBList.EMBURBOG, BYGSBList.BYGSBConfigList.EMBURNYLIUM));
    static final RainType PRECIPATATION = RainType.RAIN;
    static final Category CATEGORY = Category.NETHER;
    static final float DEPTH = 0.125F;
    static final float SCALE = 0.05F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.4F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;
    static final Climate WEATHER = new Climate(PRECIPATATION, TEMPERATURE, TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).func_242517_a(SURFACE_BUILDER);

    public EmburBog() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR)
                .setFogColor(15110510)
                .func_242539_d(BiomeHelper.calcSkyColor(2.0F))
                .setParticle(new ParticleEffectAmbience(ParticleTypes.FLAME, 0.01428F))
                .setAmbientSound(SoundEvents.AMBIENT_BASALT_DELTAS_LOOP)
                .setMoodSound(new MoodSoundAmbience(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D))
                .setAdditionsSound(new SoundAdditionsAmbience(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D))
                .setMusic(BackgroundMusicTracks.getDefaultBackgroundMusicSelector(SoundEvents.MUSIC_NETHER_BASALT_DELTAS)).build(), GENERATION_SETTINGS.func_242508_a(), SPAWN_SETTINGS.func_242577_b());
    }

    @Override
    public int getFoliageColor() {
        return 10855786;
    }

    static {
        //TODO: Reenable Embur Bog lake.
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.RAW_GENERATION, BYGConfiguredFeatures.EMBUR_LAKE);
        GENERATION_SETTINGS.func_242512_a(GenerationStage.Carving.AIR, ConfiguredCarvers.field_243772_f);
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.field_243830_ac);
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.field_243828_aa);
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.field_243839_al);
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.field_243952_l);
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.field_243953_m);
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.field_243821_aT);
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.field_243822_aU);
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.field_243884_bd);
        GENERATION_SETTINGS.func_242513_a(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredTreeFeatures.RANDOM_EMBUR_MUSHROOM);
        BYGFeatures.addEmburBogVines(GENERATION_SETTINGS);
        BYGFeatures.addEmburBogVegetation(GENERATION_SETTINGS);

        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.BLAZE, 40, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIFIED_PIGLIN, 80, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.MAGMA_CUBE, 100, 2, 5));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.PIGLIN, 15, 4, 4));
        SPAWN_SETTINGS.func_242575_a(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.STRIDER, 60, 1, 2));

    }
}
