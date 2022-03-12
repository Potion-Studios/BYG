package potionstudios.byg.util;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.storage.WorldData;
import potionstudios.byg.config.json.OverworldBiomeConfig;
import potionstudios.byg.mixin.access.NoiseBasedChunkGeneratorAccess;
import potionstudios.byg.mixin.access.NoiseGeneratorSettingsAccess;

public class AddSurfaceRulesUtil {

    public static void appendSurfaceRule(WorldData worldData, ResourceKey<LevelStem> levelStemKey, SurfaceRules.RuleSource ruleSource) {
        if (worldData == null) { // For some reason mods can make world data null as seen in some user crash logs, this makes that issue clearer for us.
            throw new NullPointerException("Minecraft server's world data is null, this should be impossible...");
        }
        LevelStem levelStem = worldData.worldGenSettings().dimensions().get(levelStemKey);
        if (OverworldBiomeConfig.getConfig(false).generateOverworld()) {
            ChunkGenerator chunkGenerator = levelStem.generator();
            if (chunkGenerator != null && chunkGenerator instanceof NoiseBasedChunkGenerator) {
                Object noiseGeneratorSettings = ((NoiseBasedChunkGeneratorAccess) chunkGenerator).byg_getSettings().value();
                ((NoiseGeneratorSettingsAccess) noiseGeneratorSettings).byg_setSurfaceRule(SurfaceRules.sequence(ruleSource, ((NoiseGeneratorSettings) noiseGeneratorSettings).surfaceRule()));
            }
        }
    }
}
