package voronoiaoc.byg.common.world.dimension.nether;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.config.BYGWorldConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("deprecation")
public class BYGNetherBiomeCatch {
    public static final ForgeRegistry<Biome> BIOME_REGISTRY = ((ForgeRegistry<Biome>) ForgeRegistries.BIOMES);

    static String biomeRegistries = BYGWorldConfig.netherBiomes.get();
    public static String configBiomes = biomeRegistries.trim();
    public static List<String> biomeList = Arrays.asList(configBiomes.split(","));

    public static ArrayList<Integer> netherBiomeIDS = new ArrayList<>();


    public static void netherBiomeConfigCollection() {
        BYG.LOGGER.debug("BYG: Nether Biome Config Collection starting...");
        if (biomeList.size() > 0) {
            int[] getConfigArray = new int[biomeList.size()];
            for (int index = 0; index < biomeList.size(); ++index) {
                final Biome configResource = WorldGenRegistries.field_243657_i.func_241873_b(new ResourceLocation(biomeList.get(index))).orElse(BIOME_REGISTRY.getValue(Biomes.NETHER_WASTES.func_240901_a_()));
                if (configResource == null) {
                    BYG.LOGGER.error("Illegal registry name! You put: " + biomeList.get(index));
                } else if (configResource != null) {
                    getConfigArray[index] = WorldGenRegistries.field_243657_i.getId(configResource);
                    Biome biome = WorldGenRegistries.field_243657_i.getByValue(getConfigArray[index]);

                    if (biome == null) {
                        BYG.LOGGER.error("Illegal registry name! You put: " + biomeList.get(index));
                    } else {
                        BYGNetherBiomeProvider.biomeList.add(biome);
                        netherBiomeIDS.add(WorldGenRegistries.field_243657_i.getId(biome));
                    }
                }
            }
        }

        BYG.LOGGER.info(biomeList.size());
        BYG.LOGGER.debug("BYG: Nether Biome Config Collection completed!");
    }

    public static int getRandomNetherBiomes(INoiseRandom rand) {
        return netherBiomeIDS.get(rand.random(netherBiomeIDS.size()));
    }

}



