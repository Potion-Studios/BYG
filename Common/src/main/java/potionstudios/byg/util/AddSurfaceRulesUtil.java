package potionstudios.byg.util;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.storage.WorldData;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.surfacerules.SurfaceRulesConfig;
import potionstudios.byg.mixin.access.BiomeSourceAccess;
import potionstudios.byg.mixin.access.NoiseBasedChunkGeneratorAccess;
import potionstudios.byg.mixin.access.NoiseGeneratorSettingsAccess;

import java.nio.file.Path;
import java.util.Map;

public class AddSurfaceRulesUtil {

    public static void appendSurfaceRule(WorldData worldData, ResourceKey<LevelStem> levelStemKey, SurfaceRules.RuleSource ruleSource) {
        if (worldData == null) { // For some reason mods can make world data null as seen in some user crash logs, this makes that issue clearer for us.
            throw new NullPointerException("Minecraft server's world data is null, this should be impossible...");
        }
        LevelStem levelStem = worldData.worldGenSettings().dimensions().get(levelStemKey);
        if (levelStem == null) {
            BYG.LOGGER.error(String.format("Unable to find level stem/dimension \"%s\", this is most likely due to a world being moved across minecraft versions, Oh The Biomes You'll Go cannot support this operation.\nNot adding surface rules....", levelStemKey));
            return;
        }
        ChunkGenerator chunkGenerator = levelStem.generator();

        boolean hasBYGBiome = chunkGenerator.getBiomeSource().possibleBiomes().stream().anyMatch(biomeHolder -> biomeHolder.unwrapKey().orElseThrow().location().getNamespace().equals(BYG.MOD_ID));
        if (hasBYGBiome) {
            Path path = SurfaceRulesConfig.CONFIG_PATHS.get().get(levelStemKey);
            Map<ResourceKey<LevelStem>, SurfaceRules.RuleSource> surfaceRulesConfig = SurfaceRulesConfig.getConfig(true, false);

            if (surfaceRulesConfig.containsKey(levelStemKey) && surfaceRulesConfig.get(levelStemKey) != null) {
                if (chunkGenerator instanceof NoiseBasedChunkGenerator) {
                    NoiseGeneratorSettings noiseGeneratorSettings = ((NoiseBasedChunkGeneratorAccess) chunkGenerator).byg_getSettings().value();
                    if (levelStemKey == LevelStem.NETHER) {
                        ((NoiseGeneratorSettingsAccess) (Object) noiseGeneratorSettings).byg_setSurfaceRule(SurfaceRules.sequence(surfaceRulesConfig.get(levelStemKey), ModPlatform.INSTANCE.getTerraBlenderNetherSurfaceRules(noiseGeneratorSettings.surfaceRule())));
                    } else {
                        ((NoiseGeneratorSettingsAccess) (Object) noiseGeneratorSettings).byg_setSurfaceRule(SurfaceRules.sequence(ruleSource, noiseGeneratorSettings.surfaceRule()));
                    }
                } else {
                    BYG.LOGGER.warn(String.format("Ignoring BYG's appended surface rule \"%s\" for dimension: \"%s\" because the chunk generator was not an instance of \"NoiseBasedChunkGenerator\".\nThe chunk generator was an instanceof \"%s\".", path.toString(), levelStemKey.location(), chunkGenerator.getClass().getName()));
                }
            } else {
                throw new IllegalStateException(String.format("Surface rules for \"%s\" are required to load. Fix the Surface Rule config file found at: \"%s\"", levelStemKey.location().toString(), path));
            }
        }

        Codec<? extends BiomeSource> biomeSourceCodec = ((BiomeSourceAccess) chunkGenerator.getBiomeSource()).byg_invokeCodec();
        BYG.LOGGER.info(String.format("Loading dimension \"%s\" with biome source: \"%s\".", levelStemKey.location().toString(), Registry.BIOME_SOURCE.getKey(biomeSourceCodec).toString()));
    }
}
