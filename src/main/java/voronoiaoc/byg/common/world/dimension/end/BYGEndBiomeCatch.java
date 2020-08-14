package voronoiaoc.byg.common.world.dimension.end;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraftforge.fml.ModList;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.config.BYGWorldConfig;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("deprecation")
public class BYGEndBiomeCatch {

    public static final int IVISFIELDS = WorldGenRegistries.field_243657_i.getId(BYGBiomeList.IVISFIELDS);
    public static final int SMALLENDISLANDS = WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.func_243576_d(Biomes.SMALL_END_ISLANDS));
    public static final int ENDBARRENS = WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.func_243576_d(Biomes.END_BARRENS));
    public static final int ENDHIGHLANDS = WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.func_243576_d(Biomes.END_HIGHLANDS));
    public static final int ENDMIDLANDS = WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.func_243576_d(Biomes.END_MIDLANDS));
    public static final int POISEFOREST = WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.func_241873_b(new ResourceLocation("endergetic:poise_forest")).orElse(WorldGenRegistries.field_243657_i.getByValue(SMALLENDISLANDS)));

    static String biomeRegistries = BYGWorldConfig.externalEndBiomes.get();
    public static String configBiomes = biomeRegistries.trim().replace(" ", "");
    public static List<String> biomeList = Arrays.asList(configBiomes.split(","));
    public static ArrayList<Integer> endBiomeIDs = new ArrayList<>();


    public static void endBiomeConfigCollection() {
        BYG.LOGGER.debug("BYG: End Biome Config Collection starting...");

        if (biomeList.size() > 0) {
            int[] getConfigArray = new int[biomeList.size()];
            for (int index = 0; index < biomeList.size(); ++index) {
                final Biome configResource = WorldGenRegistries.field_243657_i.func_241873_b(new ResourceLocation(biomeList.get(index))).orElse(WorldGenRegistries.field_243657_i.func_243576_d(Biomes.THE_END));
                if (configResource == null) {
                    BYG.LOGGER.warn("Illegal registry name! You put: " + biomeList.get(index));
                } else if (configResource != null) {
                    getConfigArray[index] = WorldGenRegistries.field_243657_i.getId(configResource);
                    Biome biome = WorldGenRegistries.field_243657_i.getByValue(getConfigArray[index]);
                    if (biome == null) {
                    } else {
                        BYGEndBiomeProvider.bygEndBiomeList.add(biome);
                        endBiomeIDs.add(WorldGenRegistries.field_243657_i.getId(biome));
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



