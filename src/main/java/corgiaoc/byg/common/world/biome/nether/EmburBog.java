package corgiaoc.byg.common.world.biome.nether;

import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.common.world.biome.BiomeUtil;
import corgiaoc.byg.core.world.BYGConfiguredFeatures;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;

public class EmburBog extends BYGBiome {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("embur_bog", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.EMBUR_BOG, BYGSurfaceBuilders.Configs.EMBURNYLIUM));
    static final Biome.RainType PRECIPATATION = Biome.RainType.RAIN;
    static final Biome.Category CATEGORY = Biome.Category.NETHER;
    static final float DEPTH = 0.125F;
    static final float SCALE = 0.05F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.4F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;

    static final Biome.Climate WEATHER = new Biome.Climate(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnInfo.Builder SPAWN_SETTINGS = new MobSpawnInfo.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(SURFACE_BUILDER);

    public EmburBog() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeAmbience.Builder()).setWaterColor(WATER_COLOR).setWaterFogColor(WATER_FOG_COLOR)
                .setFogColor(15110510)
                .withSkyColor(BiomeUtil.calcSkyColor(2.0F))
                .setParticle(new ParticleEffectAmbience(ParticleTypes.FLAME, 0.00228F))
                .setAmbientSound(SoundEvents.AMBIENT_BASALT_DELTAS_LOOP)
                .setMoodSound(new MoodSoundAmbience(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D))
                .setAdditionsSound(new SoundAdditionsAmbience(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D))
                .setMusic(BackgroundMusicTracks.getDefaultBackgroundMusicSelector(SoundEvents.MUSIC_NETHER_BASALT_DELTAS)).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.copy());
    }

    static {
        //TODO: Reenable Embur Bog lake.
        GENERATION_SETTINGS.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.field_243772_f);
        GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.SPRING_CLOSED);
        GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.SPRING_LAVA);
        GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.PATCH_FIRE);
        GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE_EXTRA);
        GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE);
        GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.BROWN_MUSHROOM_NETHER);
        GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.RED_MUSHROOM_NETHER);
        GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA);
        DefaultBiomeFeatures.withCommonNetherBlocks(GENERATION_SETTINGS); //Ores
        GENERATION_SETTINGS.withStructure(StructureFeatures.field_244134_E); //NetherPortal
        GENERATION_SETTINGS.withStructure(StructureFeatures.field_244149_o); //Fortress
        GENERATION_SETTINGS.withStructure(StructureFeatures.field_244153_s); //BastionRemnant
        GENERATION_SETTINGS.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, BYGConfiguredFeatures.RANDOM_EMBUR_MUSHROOM);
        BYGDefaultBiomeFeatures.addEmburBogVines(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addEmburBogVegetation(GENERATION_SETTINGS);

        SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.BLAZE, 20, 2, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIFIED_PIGLIN, 80, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.MAGMA_CUBE, 100, 2, 5));
        SPAWN_SETTINGS.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.PIGLIN, 15, 4, 4));
        SPAWN_SETTINGS.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.STRIDER, 60, 1, 2));

    }
}
