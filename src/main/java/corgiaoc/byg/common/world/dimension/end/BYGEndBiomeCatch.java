package corgiaoc.byg.common.world.dimension.end;

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
public class BYGEndBiomeCatch {

    public static String biomeRegistries = BYGWorldConfig.EXTERNAL_END_BIOMES.get();
    public static String configBiomes = biomeRegistries.trim().replace(" ", "");
    public static List<String> biomeList = Arrays.asList(configBiomes.split(","));

    public static boolean useAllEndBiomes = false;

    public static void collectEndBiomes() {
        if (biomeRegistries.equals("all")) {
            useAllEndBiomes = true;
            return;
        }

        BYG.LOGGER.debug("BYG: End Biome Config Collection starting...");
        if (biomeList.size() > 0) {
            int[] getConfigArray = new int[biomeList.size()];
            for (int index = 0; index < biomeList.size(); ++index) {
                final Biome configResource = WorldGenRegistries.BIOME.getOptional(new ResourceLocation(biomeList.get(index))).orElse(WorldGenRegistries.BIOME.getOrThrow(Biomes.THE_VOID));
                if (configResource == null) {
                    BYG.LOGGER.warn("Illegal registry name! You put: " + biomeList.get(index));
                } else if (configResource != null) {
                    getConfigArray[index] = WorldGenRegistries.BIOME.getId(configResource);
                    Biome biome = WorldGenRegistries.BIOME.getByValue(getConfigArray[index]);
                    if (biome == null) {
                    } else {
                        BYGEndBiomeProvider.END_BIOMES.add(biome);
                    }
                }
            }
        }
        BYG.LOGGER.debug("BYG: End Biome Config Collection complete!");
    }

    public static int getRandomEndBiomes(Registry<Biome> biomeRegistry, INoiseRandom rand) {
        return WorldGenRegistries.BIOME.getId(BYGEndBiomeProvider.END_BIOMES.get(rand.random(BYGEndBiomeProvider.END_BIOMES.size())));
    }
}



