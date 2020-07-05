package voronoiaoc.byg.common.world.dimension.end;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.config.BYGWorldConfig;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("deprecation")
public class BYGEndBiomeCatch {
    public static ForgeRegistry<Biome> BiomeRegistry = ((ForgeRegistry<Biome>) ForgeRegistries.BIOMES);

    public static final int IVISFIELDS = BiomeRegistry.getID(BYGBiomeList.IVISFIELDS);
    public static final int SMALLENDISLANDS = BiomeRegistry.getID(Biomes.SMALL_END_ISLANDS);
    public static final int ENDBARRENS = BiomeRegistry.getID(Biomes.END_BARRENS);
    public static final int ENDHIGHLANDS = BiomeRegistry.getID(Biomes.END_HIGHLANDS);
    public static final int ENDMIDLANDS = BiomeRegistry.getID(Biomes.END_MIDLANDS);
    public static final int POISEFOREST = BiomeRegistry.getID(new ResourceLocation("endergetic:poise_forest"));

    static String biomeRegistries = BYGWorldConfig.externalEndBiomes.get();
    public static String configBiomes = biomeRegistries.trim().replace(" ", "");
    public static List<String> biomeList = Arrays.asList(configBiomes.split(","));
    public static ArrayList<Integer> endBiomeIDs = new ArrayList<>();


    public static void endBiomeConfigCollection() {
        BYG.LOGGER.debug("BYG: End Biome Config Collection starting...");

        if (biomeList.size() > 0) {
            int[] getConfigArray = new int[biomeList.size()];
            for (int index = 0; index < biomeList.size(); ++index) {
                final Biome configResource = BiomeRegistry.getValue(new ResourceLocation(biomeList.get(index)));
                if (configResource == null) {
                    BYG.LOGGER.warn("Illegal registry name! You put: " + configResource);
                } else if (configResource != null) {
                    getConfigArray[index] = BiomeRegistry.getID(configResource);
                    Biome biome = Registry.BIOME.getByValue(getConfigArray[index]);
                    if (biome == null) {
                    } else {
                        BYGEndBiomeProvider.bygEndBiomeList.add(biome);
                        endBiomeIDs.add(Registry.BIOME.getId(biome));
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



