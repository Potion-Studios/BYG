package voronoiaoc.byg.common.world.worldtype116;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.biomes.BYGBiomeWeightSystem;
import voronoiaoc.byg.config.BYGWorldConfig;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("deprecation")
public class BYGBiomeCatch {
    public static ForgeRegistry<Biome> BiomeRegistry = ((ForgeRegistry<Biome>) ForgeRegistries.BIOMES);

    static String biomeICYRegistries = BYGWorldConfig.externalICYBiomes.get();
    static String biomeCOOLRegistries = BYGWorldConfig.externalCOOLBiomes.get();
    static String biomeWARMRegistries = BYGWorldConfig.externalWARMBiomes.get();
    static String biomeHOTRegistries = BYGWorldConfig.externalHOTBiomes.get();


    public static String configICYBiomes = biomeICYRegistries.trim().replace(" ", "");
    public static String configCOOLBiomes = biomeCOOLRegistries.trim().replace(" ", "");
    public static String configWARMBiomes = biomeWARMRegistries.trim().replace(" ", "");
    public static String configHOTBiomes = biomeHOTRegistries.trim().replace(" ", "");
    public static List<String> biomeICYList = Arrays.asList(configICYBiomes.split(","));
    public static List<String> biomeWARMList = Arrays.asList(configWARMBiomes.split(","));
    public static List<String> biomeCOOLList = Arrays.asList(configCOOLBiomes.split(","));
    public static List<String> biomeHOTList = Arrays.asList(configHOTBiomes.split(","));


    public static void biomeCollection() {
        BYG.LOGGER.debug("BYG: Biome Config Collection starting...");
        if (biomeICYList.size() > 0) {
            int[] getConfigArray = new int[biomeICYList.size()];
            for (int index = 0; index < biomeICYList.size(); ++index) {
                final Biome configResource = BiomeRegistry.getValue(new ResourceLocation(biomeICYList.get(index)));
                if (configResource == null) {
                    BYG.LOGGER.warn("Illegal registry name! You put: " + biomeICYList.get(index));
                } else if (configResource != null) {
                    getConfigArray[index] = BiomeRegistry.getID(configResource);
                    Biome biome = Registry.BIOME.getByValue(getConfigArray[index]);
                    if (biome == null) {
                    } else {
                        BYGBiomeWeightSystem.ICY.add(Registry.BIOME.getId(biome));
                    }
                }
            }
        }

        if (biomeCOOLList.size() > 0) {
            int[] getConfigArray = new int[biomeCOOLList.size()];
            for (int index = 0; index < biomeCOOLList.size(); ++index) {
                final Biome configResource = BiomeRegistry.getValue(new ResourceLocation(biomeCOOLList.get(index)));
                if (configResource == null) {
                    BYG.LOGGER.warn("Illegal registry name! You put: " + biomeCOOLList.get(index));
                } else if (configResource != null) {
                    getConfigArray[index] = BiomeRegistry.getID(configResource);
                    Biome biome = Registry.BIOME.getByValue(getConfigArray[index]);
                    if (biome == null) {
                    } else {
                        BYGBiomeWeightSystem.COOL.add(Registry.BIOME.getId(biome));
                    }
                }
            }
        }

        if (biomeWARMList.size() > 0) {
            int[] getConfigArray = new int[biomeWARMList.size()];
            for (int index = 0; index < biomeWARMList.size(); ++index) {
                final Biome configResource = BiomeRegistry.getValue(new ResourceLocation(biomeWARMList.get(index)));
                if (configResource == null) {
                    BYG.LOGGER.warn("Illegal registry name! You put: " + biomeWARMList.get(index));
                } else if (configResource != null) {
                    getConfigArray[index] = BiomeRegistry.getID(configResource);
                    Biome biome = Registry.BIOME.getByValue(getConfigArray[index]);
                    if (biome == null) {
                    } else {
                        BYGBiomeWeightSystem.WARM.add(Registry.BIOME.getId(biome));
                    }
                }
            }
        }

        if (biomeHOTList.size() > 0) {
            int[] getConfigArray = new int[biomeHOTList.size()];
            for (int index = 0; index < biomeHOTList.size(); ++index) {
                final Biome configResource = BiomeRegistry.getValue(new ResourceLocation(biomeHOTList.get(index)));
                if (configResource == null) {
                    BYG.LOGGER.warn("Illegal registry name! You put: " + biomeHOTList.get(index));
                } else if (configResource != null) {
                    getConfigArray[index] = BiomeRegistry.getID(configResource);
                    Biome biome = Registry.BIOME.getByValue(getConfigArray[index]);
                    if (biome == null) {
                    } else {
                        BYGBiomeWeightSystem.HOT.add(Registry.BIOME.getId(biome));
                    }
                }
            }
        }
    }
}