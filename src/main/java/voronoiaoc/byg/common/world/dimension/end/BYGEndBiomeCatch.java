package voronoiaoc.byg.common.world.dimension.end;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
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

    public static final ForgeRegistry<Biome> BIOME_REGISTRY = ((ForgeRegistry<Biome>) ForgeRegistries.BIOMES);

    public static final int IVISFIELDS = BIOME_REGISTRY.getID(BYGBiomeList.IVISFIELDS);
    public static final int SMALLENDISLANDS = BIOME_REGISTRY.getID(BIOME_REGISTRY.getValue(Biomes.SMALL_END_ISLANDS.func_240901_a_()));
    public static final int ENDBARRENS = BIOME_REGISTRY.getID(BIOME_REGISTRY.getValue(Biomes.END_BARRENS.func_240901_a_()));
    public static final int ENDHIGHLANDS = BIOME_REGISTRY.getID(BIOME_REGISTRY.getValue(Biomes.END_HIGHLANDS.func_240901_a_()));
    public static final int ENDMIDLANDS = BIOME_REGISTRY.getID(BIOME_REGISTRY.getValue(Biomes.END_MIDLANDS.func_240901_a_()));
    public static final int POISEFOREST = BIOME_REGISTRY.getID(BIOME_REGISTRY.getValue(new ResourceLocation("endergetic:poise_forest")));

    static String biomeRegistries = BYGWorldConfig.externalEndBiomes.get();
    public static String configBiomes = biomeRegistries.trim().replace(" ", "");
    public static List<String> biomeList = Arrays.asList(configBiomes.split(","));
    public static ArrayList<Integer> endBiomeIDs = new ArrayList<>();


    public static void endBiomeConfigCollection() {
        BYG.LOGGER.debug("BYG: End Biome Config Collection starting...");

        if (biomeList.size() > 0) {
            int[] getConfigArray = new int[biomeList.size()];
            for (int index = 0; index < biomeList.size(); ++index) {
                final Biome configResource = WorldGenRegistries.field_243657_i.func_241873_b(new ResourceLocation(biomeList.get(index))).orElse(BIOME_REGISTRY.getValue(Biomes.THE_END.func_240901_a_()));
                if (configResource == null) {
                    BYG.LOGGER.warn("Illegal registry name! You put: " + biomeList.get(index));
                } else if (configResource != null) {
                    getConfigArray[index] = WorldGenRegistries.field_243657_i.getId(configResource);
                    Biome biome = WorldGenRegistries.field_243657_i.getByValue(getConfigArray[index]);
                    if (biome == null) {
                    } else {
                        BYGEndBiomeProvider.bygEndBiomeList.add(biome);
                        endBiomeIDs.add(BIOME_REGISTRY.getID(biome));
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



