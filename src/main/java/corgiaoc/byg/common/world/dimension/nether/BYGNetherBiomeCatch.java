package corgiaoc.byg.common.world.dimension.nether;

import corgiaoc.byg.BYG;
import corgiaoc.byg.config.BYGWorldConfig;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("deprecation")
public class BYGNetherBiomeCatch {
    public static String biomeRegistries = BYGWorldConfig.netherBiomes.get();
    public static String configBiomes = biomeRegistries.trim();
    public static List<String> biomeList = Arrays.asList(configBiomes.split(","));
    public static boolean useAllNetherBiomes = false;

    public static void collectNetherBiomes() {
        if (biomeRegistries.equals("all")) {
            useAllNetherBiomes = true;
            return;
        }

        BYG.LOGGER.debug("BYG: Nether Biome Config Collection starting...");
        if (biomeList.size() > 0) {
            int[] getConfigArray = new int[biomeList.size()];
            for (int index = 0; index < biomeList.size(); ++index) {
                final Biome configResource = WorldGenRegistries.BIOME.getOptional(new ResourceLocation(biomeList.get(index))).orElse(WorldGenRegistries.BIOME.getOrThrow(Biomes.THE_END));
                if (configResource == null) {
                    BYG.LOGGER.error("Illegal registry name! You put: " + biomeList.get(index));
                } else if (configResource != null) {
                    getConfigArray[index] = WorldGenRegistries.BIOME.getId(configResource);
                    Biome biome = WorldGenRegistries.BIOME.getByValue(getConfigArray[index]);

                    if (biome == null) {
                        BYG.LOGGER.error("Illegal registry name! You put: " + biomeList.get(index));
                    } else {
                        BYGNetherBiomeProvider.NETHER_BIOMES.add(biome);
                    }
                }
            }
        }
        BYG.LOGGER.debug("BYG: Nether Biome Config Collection completed!");
    }

    public static int getRandomNetherBiomes(Registry<Biome> biomeRegistry, INoiseRandom rand) {
        return biomeRegistry.getId(BYGNetherBiomeProvider.NETHER_BIOMES.get(rand.random(BYGNetherBiomeProvider.NETHER_BIOMES.size())));
    }
}