package corgiaoc.byg.common.world.dimension.end;

import corgiaoc.byg.BYG;
import corgiaoc.byg.config.BYGWorldConfig;
import corgiaoc.byg.core.world.BYGBiomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraftforge.fml.ModList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("deprecation")
public class BYGEndBiomeCatch {

    public static final int IVISFIELDS = WorldGenRegistries.BIOME.getId(BYGBiomes.IVISFIELDS);
    public static final int SMALLENDISLANDS = WorldGenRegistries.BIOME.getId(WorldGenRegistries.BIOME.getOrThrow(Biomes.SMALL_END_ISLANDS));
    public static final int ENDBARRENS = WorldGenRegistries.BIOME.getId(WorldGenRegistries.BIOME.getOrThrow(Biomes.END_BARRENS));
    public static final int ENDHIGHLANDS = WorldGenRegistries.BIOME.getId(WorldGenRegistries.BIOME.getOrThrow(Biomes.END_HIGHLANDS));
    public static final int ENDMIDLANDS = WorldGenRegistries.BIOME.getId(WorldGenRegistries.BIOME.getOrThrow(Biomes.END_MIDLANDS));
    public static final int POISEFOREST = WorldGenRegistries.BIOME.getId(WorldGenRegistries.BIOME.getOptional(new ResourceLocation("endergetic:poise_forest")).orElse(WorldGenRegistries.BIOME.getByValue(SMALLENDISLANDS)));

    static String biomeRegistries = BYGWorldConfig.externalEndBiomes.get();
    public static String configBiomes = biomeRegistries.trim().replace(" ", "");
    public static List<String> biomeList = Arrays.asList(configBiomes.split(","));
    public static ArrayList<Integer> endBiomeIDs = new ArrayList<>();


    public static void endBiomeConfigCollection() {
        BYG.LOGGER.debug("BYG: End Biome Config Collection starting...");

        if (biomeList.size() > 0) {
            int[] getConfigArray = new int[biomeList.size()];
            for (int index = 0; index < biomeList.size(); ++index) {
                final Biome configResource = WorldGenRegistries.BIOME.getOptional(new ResourceLocation(biomeList.get(index))).orElse(WorldGenRegistries.BIOME.getOrThrow(Biomes.THE_END));
                if (configResource == null) {
                    BYG.LOGGER.warn("Illegal registry name! You put: " + biomeList.get(index));
                } else if (configResource != null) {
                    getConfigArray[index] = WorldGenRegistries.BIOME.getId(configResource);
                    Biome biome = WorldGenRegistries.BIOME.getByValue(getConfigArray[index]);
                    if (biome == null) {
                    } else {
                        BYGEndBiomeProvider.bygEndBiomeList.add(biome);
                        endBiomeIDs.add(WorldGenRegistries.BIOME.getId(biome));
                    }
                }
            }
        }
        BYG.LOGGER.debug("BYG: End Biome Config Collection complete!");
    }

    static {
        endBiomeIDs.add(SMALLENDISLANDS);
        endBiomeIDs.add(ENDBARRENS);
        endBiomeIDs.add(ENDHIGHLANDS);
        endBiomeIDs.add(ENDMIDLANDS);
        endBiomeIDs.add(IVISFIELDS);


        if (ModList.get().isLoaded("endergetic")) {
            endBiomeIDs.add(POISEFOREST);
        }
    }

    public static int getRandomEndBiomes(INoiseRandom rand) {
        return endBiomeIDs.get(rand.random(endBiomeIDs.size()));
    }

}



