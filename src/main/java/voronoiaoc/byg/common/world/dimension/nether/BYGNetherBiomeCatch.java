package voronoiaoc.byg.common.world.dimension.nether;

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
public class BYGNetherBiomeCatch {
    public static ForgeRegistry<Biome> BiomeRegistry = ((ForgeRegistry<Biome>) ForgeRegistries.BIOMES);

    public static final int NETHER = BiomeRegistry.getID(Biomes.field_235254_j_);
    public static final int WARPEDDESERT = BiomeRegistry.getID(BYGBiomeList.WARPEDDESERT);
    public static final int SYTHIANTORRIDS = BiomeRegistry.getID(BYGBiomeList.SYTHIANTORRIDS);
    public static final int GLOWSTONEGARDENS = BiomeRegistry.getID(BYGBiomeList.GLOWSTONEGARDENS);
    public static final int BASALTDELTAS = BiomeRegistry.getID(Biomes.field_235251_aB_);
    public static final int SOULSANDVALLEY = BiomeRegistry.getID(Biomes.field_235252_ay_);
    public static final int CRIMSONFOREST = BiomeRegistry.getID(Biomes.field_235250_aA_);
    public static final int WARPEDFOREST = BiomeRegistry.getID(Biomes.field_235250_aA_);
    public static final int EMBURBOG = BiomeRegistry.getID(BYGBiomeList.EMBURBOG);
    public static final int WITHEREDABYSS = BiomeRegistry.getID(new ResourceLocation("biomesoplenty:withered_abyss"));
    public static final int UNDERGROWTH = BiomeRegistry.getID(new ResourceLocation("biomesoplenty:undergrowth"));
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
                    BYG.LOGGER.warn("Illegal registry name! You put: " + biomeList.get(index));
                } else if (configResource != null) {
                    getConfigArray[index] = BiomeRegistry.getID(configResource);
                    Biome biome = Registry.BIOME.getByValue(getConfigArray[index]);

                    if (biome == null) {
                        BYG.LOGGER.warn("Illegal registry name! You put: " + biomeList.get(index));
                    } else {
                        BYGNetherBiomeProvider.biomeList.add(biome);
                        netherBiomeIDS.add(Registry.BIOME.getId(biome));
                    }
                }
            }
        }

        BYG.LOGGER.info(biomeList.size());
        BYG.LOGGER.debug("BYG: Nether Biome Config Collection completed!");
    }

   public static void addNetherBiomeIDs() {
        netherBiomeIDS.add(NETHER);
        netherBiomeIDS.add(WARPEDDESERT);
        netherBiomeIDS.add(SYTHIANTORRIDS);
        netherBiomeIDS.add(GLOWSTONEGARDENS);
        netherBiomeIDS.add(EMBURBOG);
        netherBiomeIDS.add(WARPEDFOREST);
        netherBiomeIDS.add(BASALTDELTAS);
        netherBiomeIDS.add(SOULSANDVALLEY);
        netherBiomeIDS.add(CRIMSONFOREST);

        if (ModList.get().isLoaded("biomesoplenty")) {
            netherBiomeIDS.add(WITHEREDABYSS);
            netherBiomeIDS.add(UNDERGROWTH);
            netherBiomeIDS.add(VISCERALHEAP);
        }
    }


    public static int getRandomNetherBiomes(INoiseRandom rand) {
        return netherBiomeIDS.get(rand.random(netherBiomeIDS.size()));
    }

}



