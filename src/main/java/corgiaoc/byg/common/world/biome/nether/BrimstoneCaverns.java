package corgiaoc.byg.common.world.biome.nether;

import corgiaoc.byg.common.world.biome.BYGDefaultBiomeFeatures;
import corgiaoc.byg.common.world.biome.BYGNetherBiome;
import corgiaoc.byg.common.world.biome.BiomeUtil;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.core.world.util.WorldGenRegistrationHelper;
import corgiaoc.byg.mixin.access.BiomeClimateSettingsAccess;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.Features;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;

public class BrimstoneCaverns extends BYGNetherBiome {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistrationHelper.createConfiguredSurfaceBuilder("brimstone_caverns", new ConfiguredSurfaceBuilder<>(BYGSurfaceBuilders.BRIMSTONE_CAVERNS, BYGSurfaceBuilders.Configs.BRIMSTONE));
    static final Biome.Precipitation PRECIPATATION = Biome.Precipitation.NONE;
    static final Biome.BiomeCategory CATEGORY = Biome.BiomeCategory.NETHER;
    static final float DEPTH = 0.125F;
    static final float SCALE = 0.05F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.4F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;

    static final Biome.ClimateSettings WEATHER = BiomeClimateSettingsAccess.create(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final MobSpawnSettings.Builder SPAWN_SETTINGS = new MobSpawnSettings.Builder();
    static final BiomeGenerationSettings.Builder GENERATION_SETTINGS = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public BrimstoneCaverns() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeSpecialEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR)
                .fogColor(4738078)
                .skyColor(BiomeUtil.calcSkyColor(2.0F))
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.ASH, 0.01428F))
                .ambientLoopSound(SoundEvents.AMBIENT_BASALT_DELTAS_LOOP)
                .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D))
                .ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D))
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_BASALT_DELTAS)).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }

    static {
        GENERATION_SETTINGS.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);
        GENERATION_SETTINGS.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_CLOSED);
        GENERATION_SETTINGS.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.SPRING_LAVA);
        GENERATION_SETTINGS.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.PATCH_FIRE);
        GENERATION_SETTINGS.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE_EXTRA);
        GENERATION_SETTINGS.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE);
        GENERATION_SETTINGS.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.BROWN_MUSHROOM_NETHER);
        GENERATION_SETTINGS.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.RED_MUSHROOM_NETHER);
        GENERATION_SETTINGS.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA);
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.RUINED_PORTAL_NETHER); //NetherPortal
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.NETHER_BRIDGE); //Fortress
        GENERATION_SETTINGS.addStructureStart(StructureFeatures.BASTION_REMNANT); //BastionRemnant
        BYGDefaultBiomeFeatures.addBrimstoneOres(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addBoricFire(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addBrimstonePillars(GENERATION_SETTINGS);
        BYGDefaultBiomeFeatures.addBrimstoneVents(GENERATION_SETTINGS);


        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIFIED_PIGLIN, 80, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 100, 2, 5));
        SPAWN_SETTINGS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 15, 4, 4));
        SPAWN_SETTINGS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 60, 1, 2));

    }
}
