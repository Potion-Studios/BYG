package potionstudios.byg.common.world.util;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.WorldGenSettings;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.end.BYGEndBiomeSource;
import potionstudios.byg.common.world.biome.end.EndBiomesConfig;
import potionstudios.byg.common.world.biome.nether.BYGNetherBiomeSource;
import potionstudios.byg.common.world.biome.nether.NetherBiomesConfig;
import potionstudios.byg.mixin.access.BiomeSourceAccess;
import potionstudios.byg.mixin.access.ChunkGeneratorAccess;
import potionstudios.byg.util.ModPlatform;

import java.util.function.Supplier;

public class BiomeSourceRepairUtils {
    public static void repairBiomeSources(Registry<Biome> biomeRegistry, WorldGenSettings worldGenSettings) {
        NetherBiomesConfig netherBiomesConfig = NetherBiomesConfig.getConfig(true, false, biomeRegistry);

        if (netherBiomesConfig.forceBYGNetherBiomeSource()) {
            Supplier<BiomeSource> netherBiomeSource = () ->
                    ModPlatform.INSTANCE.createNetherBiomeSource(biomeRegistry, worldGenSettings.seed());

            LevelStem levelStem = worldGenSettings.dimensions().get(LevelStem.NETHER);
            if (levelStem == null) {
                BYG.LOGGER.error(String.format("Unable to find level stem/dimension \"%s\", this is most likely due to a world being moved across minecraft versions, Oh The Biomes You'll Go cannot support this operation.\nSkipping biome source repair....", LevelStem.NETHER));
            } else {
                repair(levelStem, BYGNetherBiomeSource.LOCATION, netherBiomeSource);
            }
        }
        EndBiomesConfig endBiomesConfig = EndBiomesConfig.getConfig(true, false, biomeRegistry);

        if (endBiomesConfig.forceBYGEndBiomeSource()) {
            Supplier<BiomeSource> endBiomeSource = () ->
                    ModPlatform.INSTANCE.createEndBiomeSource(biomeRegistry, worldGenSettings.seed());

            LevelStem levelStem = worldGenSettings.dimensions().get(LevelStem.END);
            if (levelStem == null) {
                BYG.LOGGER.error(String.format("Unable to find level stem/dimension \"%s\", this is most likely due to a world being moved across minecraft versions, Oh The Biomes You'll Go cannot support this operation.\nSkipping biome source repair....", LevelStem.END));
            } else {
                repair(levelStem, BYGEndBiomeSource.LOCATION, endBiomeSource);
            }
        }
    }

    private static boolean repair(LevelStem dimension, ResourceLocation targetBiomeSourceID, Supplier<BiomeSource> replacement) {
        ChunkGenerator generator = dimension.generator();
        Codec<? extends BiomeSource> codec = ((BiomeSourceAccess) generator.getBiomeSource()).byg_invokeCodec();
        if (!Registry.BIOME_SOURCE.getKey(codec).equals(targetBiomeSourceID)) {
            BiomeSource replacementBiomeSource = replacement.get();
            ((ChunkGeneratorAccess) generator).byg_setBiomeSource(replacementBiomeSource);
            ((ChunkGeneratorAccess) generator).byg_setRuntimeBiomeSource(replacementBiomeSource);
            return true;
        }
        return false;
    }
}
