package voronoiaoc.byg.common.world.dimension.nether.biome;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.config.BYGWorldConfig;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

import java.util.*;

@SuppressWarnings("deprecation")
public class BYGNetherBiomeCatch {
    public static ForgeRegistry<Biome> BiomeRegistry = ((ForgeRegistry<Biome>) ForgeRegistries.BIOMES);
    public static ForgeRegistry<ModDimension> DimRegistry = ((ForgeRegistry<ModDimension>) ForgeRegistries.MOD_DIMENSIONS);

    public static final int NETHER = BiomeRegistry.getID(Biomes.NETHER);
    public static final int WARPEDDESERT = BiomeRegistry.getID(BYGBiomeList.WARPEDDESERT);
    public static final int SYTHIANTORRIDS = BiomeRegistry.getID(BYGBiomeList.SYTHIANTORRIDS);
    public static final int GLOWSTONEGARDENS = BiomeRegistry.getID(BYGBiomeList.GLOWSTONEGARDENS);
    public static final int EMBURBOG = BiomeRegistry.getID(BYGBiomeList.EMBURBOG);
    public static final int ASHENINFERNO = BiomeRegistry.getID(new ResourceLocation("biomesoplenty:ashen_inferno"));
    public static final int UNDERGARDEN = BiomeRegistry.getID(new ResourceLocation("biomesoplenty:undergarden"));
    public static final int VISCERALHEAP = BiomeRegistry.getID(new ResourceLocation("biomesoplenty:visceral_heap"));


    static String biomeRegistries = BYGWorldConfig.externalNetherBiomes.get();
    public static String configBiomes = biomeRegistries.trim();
    public static List<String> biomeList = Arrays.asList(configBiomes.split(","));

    public static ArrayList<Integer> netherBiomeIDS = new ArrayList<>();


    public static void netherBiomeConfigCollection() {
        BYG.LOGGER.debug("BYG: Nether Biome Config Collection starting...");
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
                        BYG.LOGGER.warn("Illegal registry name! You put: " + configResource);
                    } else {
                        netherBiomeIDS.add(Registry.BIOME.getId(biome));
                    }
                }
            }
        }
        BYG.LOGGER.debug("BYG: Nether Biome Config Collection completed!");
    }

    static {
        netherBiomeIDS.add(NETHER);
        netherBiomeIDS.add(WARPEDDESERT);
        netherBiomeIDS.add(SYTHIANTORRIDS);
        netherBiomeIDS.add(GLOWSTONEGARDENS);
        netherBiomeIDS.add(EMBURBOG);

        if (ModList.get().isLoaded("biomesoplenty")) {
            netherBiomeIDS.add(ASHENINFERNO);
            netherBiomeIDS.add(UNDERGARDEN);
            netherBiomeIDS.add(VISCERALHEAP);
        }
    }


    public static int getRandomNetherBiomes(INoiseRandom rand) {
        return netherBiomeIDS.get(rand.random(netherBiomeIDS.size()));
    }

    public static Set<Biome> getBiomeSet() {
        return new HashSet<>(ForgeRegistries.BIOMES.getValues());
    }
}



