package potionstudios.byg.util;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.storage.WorldData;
import potionstudios.byg.mixin.access.NoiseBasedChunkGeneratorAccess;
import potionstudios.byg.mixin.access.NoiseGeneratorSettingsAccess;

public class AddSurfaceRulesUtil {

    public static void appendSurfaceRule(WorldData worldData, ResourceKey<LevelStem> levelStemKey, SurfaceRules.RuleSource ruleSource) {
        if (worldData == null) { // For some reason mods can make world data null as seen in some user crash logs, this makes that issue clearer for us.
            throw new NullPointerException("Minecraft server's world data is null, this should be impossible...");
        }
        LevelStem levelStem = worldData.worldGenSettings().dimensions().get(levelStemKey);
        if (levelStem == null) {
            throw new NullPointerException(String.format("\"%s\" is not a valid level stem key as it doesn't exist in this world's settings. This is more than likely the result of a broken level.dat and most often occurs when moving a world between MC versions.", levelStemKey.location()));
        }
        ChunkGenerator chunkGenerator = levelStem.generator();
        if (chunkGenerator != null && chunkGenerator instanceof NoiseBasedChunkGenerator) {
            Object noiseGeneratorSettings = ((NoiseBasedChunkGeneratorAccess) chunkGenerator).byg_getSettings().value();
            ((NoiseGeneratorSettingsAccess) noiseGeneratorSettings).byg_setSurfaceRule(SurfaceRules.sequence(ruleSource, ((NoiseGeneratorSettings) noiseGeneratorSettings).surfaceRule()));
        }
    }
}
