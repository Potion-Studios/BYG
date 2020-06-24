package voronoiaoc.byg.common.world.worldtype.math;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import voronoiaoc.byg.common.world.worldtype.BYGWorldType;
import voronoiaoc.byg.config.biomeweight.ConfigWeightManager;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents a list of weighted biome entries.
 */
public class BYGBiomeGroup {
    public static final BYGBiomeGroup INLAND_TROPICAL_DESERT = new BYGBiomeGroup();
    public static final BYGBiomeGroup INLAND_TROPICAL_STEPPE = new BYGBiomeGroup();
    public static final BYGBiomeGroup INLAND_TROPICAL_RAINFOREST = new BYGBiomeGroup();
    public static final BYGBiomeGroup INLAND_TEMPERATE_DRY = new BYGBiomeGroup();
    public static final BYGBiomeGroup INLAND_TEMPERATE_HUMID = new BYGBiomeGroup();
    public static final DummyBYGBiomeGroup INLAND_TEMPERATE_ALL = new DummyBYGBiomeGroup(INLAND_TEMPERATE_DRY, INLAND_TEMPERATE_HUMID);
    public static final BYGBiomeGroup INLAND_COOL_DRY = new BYGBiomeGroup();
    public static final BYGBiomeGroup INLAND_COOL_HUMID = new BYGBiomeGroup();
    public static final DummyBYGBiomeGroup INLAND_COOL_ALL = new DummyBYGBiomeGroup(INLAND_COOL_DRY, INLAND_COOL_HUMID);
    public static final BYGBiomeGroup INLAND_COLD = new BYGBiomeGroup();

    public static final BYGBiomeGroup COASTAL_TROPICAL_DRY = new BYGBiomeGroup();
    public static final BYGBiomeGroup COASTAL_TROPICAL_HUMID = new BYGBiomeGroup();
    public static final BYGBiomeGroup COASTAL_TEMPERATE_DRY = new BYGBiomeGroup();
    public static final BYGBiomeGroup COASTAL_TEMPERATE_LUSH = new BYGBiomeGroup();
    public static final DummyBYGBiomeGroup COASTAL_TEMPERATE_ALL = new DummyBYGBiomeGroup(COASTAL_TEMPERATE_DRY, COASTAL_TEMPERATE_LUSH);
    public static final BYGBiomeGroup COASTAL_COOL = new BYGBiomeGroup();
    public static final BYGBiomeGroup COASTAL_COLD = new BYGBiomeGroup();

    public static final BYGBiomeGroup OCEAN_ISLANDS_TROPICAL = new BYGBiomeGroup();
    public static final BYGBiomeGroup OCEAN_ISLANDS_TEMPERATE = new BYGBiomeGroup();
    public static final BYGBiomeGroup OCEAN_ISLANDS_SNOWY = new BYGBiomeGroup();

    public static final BYGBiomeGroup HOT_OCEAN = new BYGBiomeGroup();
    public static final BYGBiomeGroup TEMPERATE_OCEAN = new BYGBiomeGroup();
    public static final BYGBiomeGroup COOL_OCEAN = new BYGBiomeGroup();
    public static final BYGBiomeGroup FROZEN_OCEAN = new BYGBiomeGroup();

    public static final BYGBiomeGroup DEEP_HOT_OCEAN = new BYGBiomeGroup();
    public static final BYGBiomeGroup DEEP_TEMPERATE_OCEAN = new BYGBiomeGroup();
    public static final BYGBiomeGroup DEEP_COOL_OCEAN = new BYGBiomeGroup();
    public static final BYGBiomeGroup DEEP_FROZEN_OCEAN = new BYGBiomeGroup();

    public static final BYGBiomeGroup TROPICAL_DESERT = new BYGBiomeGroup();
    public static final BYGBiomeGroup TROPICAL_STEPPE = new BYGBiomeGroup();
    public static final BYGBiomeGroup TROPICAL_RAINFOREST = new BYGBiomeGroup();
    public static final BYGBiomeGroup TEMPERATE_DRY = new BYGBiomeGroup();
    public static final BYGBiomeGroup TEMPERATE_HUMID = new BYGBiomeGroup();
    public static final BYGBiomeGroup COOL_DRY = new BYGBiomeGroup();
    public static final BYGBiomeGroup COOL_HUMID = new BYGBiomeGroup();
    public static final BYGBiomeGroup COLD = new BYGBiomeGroup();


    private final List<BiomeEntry> entries = new ArrayList<>();
    private double weightTotal = 0.0;

    private static double nextDouble(INoiseRandom random) {
        return (double) random.random(Integer.MAX_VALUE) / Integer.MAX_VALUE;
    }

    public static void initBYGBiomes() {

        // inland tropical
        TROPICAL_DESERT.addBiome(BYGBiomeList.DUNES, ConfigWeightManager.DUNES.getWeight());
        TROPICAL_DESERT.addBiome(BYGBiomeList.REDDESERT, ConfigWeightManager.REDDESERT.getWeight());
        TROPICAL_STEPPE.addBiome(BYGBiomeList.AMARANTHFIELDS, ConfigWeightManager.AMARANTHFIELDS.getWeight());
        TROPICAL_STEPPE.addBiome(BYGBiomeList.SHRUBLANDS, ConfigWeightManager.SHRUBLANDS.getWeight());

        TROPICAL_RAINFOREST.addBiome(BYGBiomeList.GUIANASHIELD, ConfigWeightManager.GUIANASHIELD.getWeight());
        TROPICAL_RAINFOREST.addBiome(BYGBiomeList.TROPICALRAINFOREST, ConfigWeightManager.TROPICALRAINFOREST.getWeight());
        TROPICAL_RAINFOREST.addBiome(BYGBiomeList.TROPICALFUNGALRAINFOREST, ConfigWeightManager.TROPICALFUNGALFOREST.getWeight());
        TROPICAL_RAINFOREST.addBiome(BYGBiomeList.JACARANDAFOREST, ConfigWeightManager.JACARANDAFOREST.getWeight());

        // inland temperate
        TEMPERATE_DRY.addBiome(BYGBiomeList.PRAIRIE, ConfigWeightManager.PRAIRIE.getWeight());
        TEMPERATE_DRY.addBiome(BYGBiomeList.DECIDUOUSFOREST, ConfigWeightManager.DECIDUOUSFOREST.getWeight());
        TEMPERATE_DRY.addBiome(BYGBiomeList.BAOBABSAVANNA, ConfigWeightManager.BAOBABSAVANNA.getWeight());

        //TEMPERATE_LUSH.addBiome(BYGBiomeList.WOODLANDS, 10);
        //TEMPERATE_LUSH.addBiome(BYGBiomeList.ASPENFOREST, 10);
        //TEMPERATE_LUSH.addBiome(BYGBiomeList.FLOWERINGPLAINS, 10);
        TEMPERATE_HUMID.addBiome(BYGBiomeList.VIBRANTSWAMPLANDS, ConfigWeightManager.VIBRANTSWAMPLANDS.getWeight());
        TEMPERATE_HUMID.addBiome(BYGBiomeList.ALLIUMFIELDS, ConfigWeightManager.ALLIUMFIELDS.getWeight());
        //TEMPERATE_LUSH.addBiome(BYGBiomeList.ANCIENTFOREST, 10);
        TEMPERATE_HUMID.addBiome(BYGBiomeList.REDOAKFOREST, ConfigWeightManager.REDOAKFOREST.getWeight());
        //TEMPERATE_LUSH.addBiome(BYGBiomeList.BAYOU, 10);
        //TEMPERATE_LUSH.addBiome(BYGBiomeList.MANGROVEMARSHES, 10);
        //TEMPERATE_LUSH.addBiome(BYGBiomeList.GLOWSHROOMBAYOU, 10);
        //TEMPERATE_LUSH.addBiome(BYGBiomeList.ORCHARD, 10);
        TEMPERATE_HUMID.addBiome(BYGBiomeList.MEADOW, ConfigWeightManager.MEADOW.getWeight());
        //TEMPERATE_LUSH.addBiome(BYGBiomeList.ENCHANTEDFOREST, 10);
        //TEMPERATE_LUSH.addBiome(BYGBiomeList.QUAGMIRE, 10);


        //INLAND_COOL_DRY.addBiome(BYGBiomeList.ZELKOVAFOREST, 10);
        COOL_DRY.addBiome(BYGBiomeList.BLUETAIGA, ConfigWeightManager.BLUETAIGA.getWeight());
        COOL_DRY.addBiome(BYGBiomeList.SEASONALTAIGA, ConfigWeightManager.SEASONALTAIGA.getWeight());
        COOL_DRY.addBiome(BYGBiomeList.SEASONALFOREST, ConfigWeightManager.SEASONALFOREST.getWeight());
        COOL_DRY.addBiome(BYGBiomeList.SEASONALDECIDUOUSFOREST, ConfigWeightManager.SEASONALDECIDUOUSFOREST.getWeight());
        COOL_DRY.addBiome(BYGBiomeList.SEASONALBIRCHFOREST, ConfigWeightManager.SEASONALBIRCHFOREST.getWeight());
        COOL_DRY.addBiome(BYGBiomeList.BLUEGIANTTAIGA, ConfigWeightManager.GIANTBLUETAIGA.getWeight());
        COOL_DRY.addBiome(BYGBiomeList.SEASONALGIANTTAIGA, ConfigWeightManager.SEASONALGIANTTAIGA.getWeight());

        COOL_HUMID.addBiome(BYGBiomeList.SKYRISHIGHLANDS, ConfigWeightManager.SKYRISHIGHLANDS.getWeight());
        COOL_HUMID.addBiome(BYGBiomeList.BOREALFOREST, ConfigWeightManager.BOREALFOREST.getWeight());
        //COOL_LUSH.addBiome(BYGBiomeList.MAPLETAIGA, 10);
        //COOL_LUSH.addBiome(BYGBiomeList.PINEMOUNTAINS, 10);
        COOL_HUMID.addBiome(BYGBiomeList.CONIFEROUSFOREST, ConfigWeightManager.CONIFEROUSFOREST.getWeight());
        //COOL_LUSH.addBiome(BYGBiomeList.EVERGREENTAIGA, 10);
        //COOL_LUSH.addBiome(BYGBiomeList.WEEPINGWITCHFOREST, 10);
        COOL_HUMID.addBiome(BYGBiomeList.COLDSWAMPLANDS, ConfigWeightManager.COLDSWAMPLANDS.getWeight());
        //COOL_LUSH.addBiome(BYGBiomeList.GREATLAKES, 10);
        COOL_HUMID.addBiome(BYGBiomeList.CRAGGARDENS, ConfigWeightManager.CRAGGARDENS.getWeight());

        COLD.addBiome(BYGBiomeList.ALPS, ConfigWeightManager.ALPS.getWeight());
        COLD.addBiome(BYGBiomeList.SNOWYCONIFEROUSFOREST, ConfigWeightManager.SNOWYCONIFEROUSFOREST.getWeight());
        COLD.addBiome(BYGBiomeList.SNOWYDECIDUOUSFOREST, ConfigWeightManager.SNOWYDECIDUOUSFOREST.getWeight());
        //COLD.addBiome(BYGBiomeList.SNOWYEVERGREENTAIGA, 10);
        //COLD.addBiome(BYGBiomeList.SNOWYPINEMOUNTAINS, 10);
        //COLD.addBiome(BYGBiomeList.SNOWYDECIDUOUSFOREST, 10);
        //COLD.addBiome(BYGBiomeList.EVERGREENTAIGA, 10);
        COLD.addBiome(BYGBiomeList.SHATTEREDGLACIER, ConfigWeightManager.SHATTEREDGLACIER.getWeight());
        COLD.addBiome(BYGBiomeList.SNOWYBLUETAIGA, ConfigWeightManager.SNOWYBLUETAIGA.getWeight());
        COLD.addBiome(BYGBiomeList.SNOWYBLUEGIANTTAIGA, ConfigWeightManager.SNOWYGIANTBLUETAIGA.getWeight());

        // islands
        OCEAN_ISLANDS_TROPICAL.addBiome(BYGBiomeList.TROPICALISLAND, 5);
        OCEAN_ISLANDS_TROPICAL.addBiome(BYGBiomeList.DEADSEA, 1);
        OCEAN_ISLANDS_TEMPERATE.addBiome(BYGBiomeList.DECIDUOUSFOREST, ConfigWeightManager.DECIDUOUSFOREST.getWeight());
        OCEAN_ISLANDS_SNOWY.addBiome(BYGBiomeList.SNOWYCONIFEROUSFOREST, ConfigWeightManager.SNOWYCONIFEROUSFOREST.getWeight());

        HOT_OCEAN.addBiome(Biomes.WARM_OCEAN, 10);
        TEMPERATE_OCEAN.addBiome(Biomes.LUKEWARM_OCEAN, 10);
        COOL_OCEAN.addBiome(Biomes.COLD_OCEAN, 10);
        FROZEN_OCEAN.addBiome(Biomes.FROZEN_OCEAN, 10);

        DEEP_HOT_OCEAN.addBiome(Biomes.DEEP_WARM_OCEAN, 10);
        DEEP_TEMPERATE_OCEAN.addBiome(Biomes.DEEP_LUKEWARM_OCEAN, 10);
        DEEP_COOL_OCEAN.addBiome(Biomes.DEEP_COLD_OCEAN, 10);
        DEEP_FROZEN_OCEAN.addBiome(Biomes.DEEP_FROZEN_OCEAN, 10);

    }

    public static void initDefaultBiomes() {
        INLAND_TROPICAL_DESERT.addBiome(Biomes.DESERT, 5);

        INLAND_TROPICAL_RAINFOREST.addBiome(Biomes.JUNGLE, 5);
        INLAND_TROPICAL_RAINFOREST.addBiome(Biomes.BAMBOO_JUNGLE, 5);

        INLAND_TEMPERATE_DRY.addBiome(Biomes.PLAINS, 3);
        INLAND_TROPICAL_DESERT.addBiome(Biomes.ERODED_BADLANDS, 5);
        INLAND_TEMPERATE_DRY.addBiome(Biomes.SAVANNA, 5);

//        INLAND_TEMPERATE_HUMID.addBiome(BiomeSounds.SWAMP, 3);
        INLAND_TEMPERATE_HUMID.addBiome(Biomes.DARK_FOREST, 5);
        INLAND_TEMPERATE_HUMID.addBiome(Biomes.FLOWER_FOREST, 5);

        INLAND_COOL_DRY.addBiome(Biomes.TAIGA, 5);

        INLAND_COLD.addBiome(Biomes.SNOWY_TUNDRA, 5);
        INLAND_COLD.addBiome(Biomes.ICE_SPIKES, 5);
        INLAND_COLD.addBiome(Biomes.SNOWY_TAIGA, 5);

        COASTAL_TEMPERATE_DRY.addBiome(Biomes.PLAINS, 5);
        COASTAL_TEMPERATE_LUSH.addBiome(Biomes.SWAMP, 5);
        COASTAL_TROPICAL_DRY.addBiome(Biomes.DESERT, 3);

        OCEAN_ISLANDS_TROPICAL.addBiome(Biomes.MUSHROOM_FIELDS, 5);

        OCEAN_ISLANDS_TEMPERATE.addBiome(Biomes.SUNFLOWER_PLAINS, 5);
    }

    public Biome pickBiome(INoiseRandom random) {
        double randVal = nextDouble(random) * weightTotal;
        int i = -1;

        while (randVal >= 0) {
            ++i;
            randVal -= entries.get(i).weight;
        }

        return entries.get(i).biome;
    }

    public void addBiome(Biome biome, double weight) {
        this.entries.add(new BiomeEntry(biome, weight * 0.1D));
        this.weightTotal += weight * 0.1D;
        BYGWorldType.BIOMES.add(biome);
    }

    private static class BiomeEntry {
        Biome biome;
        double weight;

        BiomeEntry(Biome biome, double weight) {
            this.biome = biome;
            this.weight = weight;
        }
    }
}

class DummyBYGBiomeGroup extends BYGBiomeGroup {
    final BYGBiomeGroup[] parents;

    DummyBYGBiomeGroup(BYGBiomeGroup... parents) {
        this.parents = parents;
    }

    @Override
    public void addBiome(Biome biome, double weight) {
        for (BYGBiomeGroup b : this.parents) {
            b.addBiome(biome, weight);
        }
    }
}