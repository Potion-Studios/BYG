package potionstudios.byg.common.world.util;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.LevelStem;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.BYGDebugBiomeSource;
import potionstudios.byg.common.world.biome.LazyLoadSeed;
import potionstudios.byg.common.world.biome.end.BYGEndBiomeSource;
import potionstudios.byg.common.world.biome.end.EndBiomesConfig;
import potionstudios.byg.common.world.biome.nether.BYGNetherBiomeSource;
import potionstudios.byg.common.world.biome.nether.NetherBiomesConfig;
import potionstudios.byg.mixin.access.BiomeSourceAccess;
import potionstudios.byg.mixin.access.ChunkGeneratorAccess;

import java.util.Optional;
import java.util.function.Supplier;

public class BiomeSourceRepairUtils {
    public static void repairBiomeSources(Registry<Biome> biomeRegistry, MinecraftServer server) {
        NetherBiomesConfig netherBiomesConfig = NetherBiomesConfig.getConfig(true, false, biomeRegistry);

        Registry<LevelStem> levelStems = server.registryAccess().registryOrThrow(Registries.LEVEL_STEM);


        if (netherBiomesConfig.forceBYGNetherBiomeSource()) {
            Supplier<BiomeSource> netherBiomeSource = BYGNetherBiomeSource::new;

            Optional<LevelStem> levelStem = levelStems.getOptional(LevelStem.NETHER);
            if (levelStem.isEmpty()) {
                BYG.logError(String.format("Unable to find level stem/dimension \"%s\", this is most likely due to a world being moved across minecraft versions, Oh The Biomes You'll Go cannot support this operation.\nSkipping biome source repair....", LevelStem.NETHER));
            } else {
                repair(levelStem.get(), BYGNetherBiomeSource.LOCATION, netherBiomeSource);
            }
        }
        EndBiomesConfig endBiomesConfig = EndBiomesConfig.getConfig(true, false, biomeRegistry);

        if (endBiomesConfig.forceBYGEndBiomeSource()) {
            Supplier<BiomeSource> endBiomeSource = BYGEndBiomeSource::new;

            Optional<LevelStem> levelStem = levelStems.getOptional(LevelStem.END);
            if (levelStem.isEmpty()) {
                BYG.logError(String.format("Unable to find level stem/dimension \"%s\", this is most likely due to a world being moved across minecraft versions, Oh The Biomes You'll Go cannot support this operation.\nSkipping biome source repair....", LevelStem.END));
            } else {
                repair(levelStem.get(), BYGEndBiomeSource.LOCATION, endBiomeSource);
            }
        }

        levelStems.forEach(dimension -> {
            BiomeSource biomeSource = dimension.generator().getBiomeSource();
            if (biomeSource instanceof LazyLoadSeed lazyLoadSeed) {
                lazyLoadSeed.lazyLoad(server.getWorldData().worldGenOptions().seed(), biomeRegistry);
            }
        });
    }

    private static boolean repair(LevelStem dimension, ResourceLocation targetBiomeSourceID, Supplier<BiomeSource> replacement) {
        ChunkGenerator generator = dimension.generator();
        Codec<? extends BiomeSource> codec = ((BiomeSourceAccess) generator.getBiomeSource()).byg_invokeCodec();
        if (!BuiltInRegistries.BIOME_SOURCE.getKey(codec).equals(targetBiomeSourceID) && !(generator.getBiomeSource() instanceof BYGDebugBiomeSource)) {
            BiomeSource replacementBiomeSource = replacement.get();
            ((ChunkGeneratorAccess) generator).byg_setBiomeSource(replacementBiomeSource);
            return true;
        }
        return false;
    }
}
