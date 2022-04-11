package potionstudios.byg.common.world;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.WorldGenSettings;
import potionstudios.byg.common.world.biome.end.BYGEndBiomeSource;
import potionstudios.byg.common.world.biome.end.EndBiomesConfig;
import potionstudios.byg.common.world.biome.nether.BYGNetherBiomeSource;
import potionstudios.byg.common.world.biome.nether.NetherBiomesConfig;
import potionstudios.byg.mixin.access.BiomeSourceAccess;
import potionstudios.byg.mixin.access.ChunkGeneratorAccess;
import potionstudios.byg.util.ModLoaderContext;

import java.util.function.Supplier;

public class BiomeSourceRepairUtils {
    public static void repairBiomeSources(Registry<Biome> biomeRegistry, WorldGenSettings worldGenSettings) {
        NetherBiomesConfig netherBiomesConfig = NetherBiomesConfig.getConfig(true, biomeRegistry);

        if(netherBiomesConfig.useBYGNetherBiomeSourceInNewWorlds()) {
            Supplier<BiomeSource> netherBiomeSource = () -> {
                return ModLoaderContext.getInstance().createNetherBiomeSource(biomeRegistry, worldGenSettings.seed(),
                    netherBiomesConfig.upperLayer(), netherBiomesConfig.middleLayer(), netherBiomesConfig.bottomLayer(), netherBiomesConfig.layerSize());
            };
            repair(worldGenSettings.dimensions().getOrThrow(LevelStem.NETHER), BYGNetherBiomeSource.LOCATION, netherBiomeSource);
        }
        EndBiomesConfig endBiomesConfig = EndBiomesConfig.getConfig(true, biomeRegistry);

        if (endBiomesConfig.forceBYGEndBiomeSource()) {
            Supplier<BiomeSource> endBiomeSource = () -> {
                return ModLoaderContext.getInstance().createEndBiomeSource(biomeRegistry, worldGenSettings.seed(),
                    endBiomesConfig.islandLayers(), endBiomesConfig.voidLayers(), endBiomesConfig.skyLayers());
            };
            repair(worldGenSettings.dimensions().getOrThrow(LevelStem.END), BYGEndBiomeSource.LOCATION, endBiomeSource);
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
