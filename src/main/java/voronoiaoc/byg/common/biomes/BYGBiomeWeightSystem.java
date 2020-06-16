package voronoiaoc.byg.common.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.loading.FMLPaths;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.config.biomeweight.ConfigWeightManager;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

public class BYGBiomeWeightSystem {

    public static void addBiomesToWeightSystem() {
        ConfigWeightManager.loadConfig(ConfigWeightManager.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(BYG.MOD_ID + "-weights-common.toml"));
        BYG.LOGGER.debug("BYG: Adding biome entries with their respective weights...");
        addBiomeEntry(BYGBiomeList.ALLIUMFIELDS, ConfigWeightManager.ALLIUMFIELDS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.ALPS, ConfigWeightManager.ALPS.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(BYGBiomeList.AMARANTHFIELDS, ConfigWeightManager.AMARANTHFIELDS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.AUTUMNAL_VALLEY, ConfigWeightManager.AUTUMNALVALLEY.getWeight(), BiomeManager.BiomeType.COOL);
//        addBiomeEntry(BYGBiomeList.ANCIENTFOREST, ConfigWeightManager.ancientforest.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.ASPENFOREST, ConfigWeightManager.ASPENFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.BAOBABSAVANNA, ConfigWeightManager.BAOBABSAVANNA.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomeList.BAYOU, ConfigWeightManager.BAYOU.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.BLUETAIGA, ConfigWeightManager.BLUETAIGA.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomeList.BLUFFSTEEPS, ConfigWeightManager.BLUFFSTEEPS.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomeList.BOREALFOREST, ConfigWeightManager.BOREALFOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomeList.COLDSWAMPLANDS, ConfigWeightManager.COLDSWAMPLANDS.getWeight(), BiomeManager.BiomeType.COOL);
//        addBiomeEntry(BYGBiomeList.REDROCKCANYON, ConfigWeightManager.CANYONS.getWeight(), BiomeManager.BiomeType.DESERT);
//        addBiomeEntry(BYGBiomeList.COASTALREDWOODTROPICS, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.CONIFEROUSFOREST, ConfigWeightManager.CONIFEROUSFOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomeList.DOVERMOUNTAINS, ConfigWeightManager.DOVERMOUNTAINS.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomeList.DEADSEA, ConfigWeightManager.DEADSEA.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomeList.DECIDUOUSFOREST, ConfigWeightManager.DECIDUOUSFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.DUNES, ConfigWeightManager.DUNES.getWeight(), BiomeManager.BiomeType.DESERT);
//        addBiomeEntry(BYGBiomeList.EBONYWOODS, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
//        addBiomeEntry(BYGBiomeList.ENCHANTEDFOREST, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
//        addBiomeEntry(BYGBiomeList.EVERGREENTAIGA, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
//        addBiomeEntry(BYGBiomeList.FLOWERINGPLAINS, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.GLOWSHROOMBAYOU, ConfigWeightManager.GLOWSHROOMBAYOU.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.GRASSLANDPLATEAU, ConfigWeightManager.GRASSLANDPLATEAU.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.GREATLAKES, ConfigWeightManager.GREATLAKES.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomeList.GUIANASHIELD, ConfigWeightManager.GUIANASHIELD.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.JACARANDAFOREST, ConfigWeightManager.JACARANDAFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.CRAGGARDENS, ConfigWeightManager.CRAGGARDENS.getWeight(), BiomeManager.BiomeType.WARM);
//        addBiomeEntry(BYGBiomeList.MANGROVEMARSHES, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
//        addBiomeEntry(BYGBiomeList.MAPLETAIGA, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.MEADOW, ConfigWeightManager.MEADOW.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.MOJAVE_DESERT, ConfigWeightManager.MOJAVEDESERT.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomeList.LUSH_TUNDRA, ConfigWeightManager.LUSH_TUNDRA.getWeight(), BiomeManager.BiomeType.ICY);
//        addBiomeEntry(BYGBiomeList.ORCHARD, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
//        addBiomeEntry(BYGBiomeList.PINELOWANDS, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.PRAIRIE, ConfigWeightManager.PRAIRIE.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.REDDESERT, ConfigWeightManager.REDDESERT.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomeList.REDOAKFOREST, ConfigWeightManager.REDOAKFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.RED_ROCK_MOUNTAINS, ConfigWeightManager.REDROCKMOUNTAINS.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomeList.SEASONALBIRCHFOREST, ConfigWeightManager.SEASONALBIRCHFOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomeList.SEASONALDECIDUOUSFOREST, ConfigWeightManager.SEASONALDECIDUOUSFOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomeList.SEASONALFOREST, ConfigWeightManager.SEASONALFOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomeList.SEASONALTAIGA, ConfigWeightManager.SEASONALTAIGA.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomeList.SHATTEREDGLACIER, ConfigWeightManager.SHATTEREDGLACIER.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(BYGBiomeList.SHRUBLANDS, ConfigWeightManager.SHRUBLANDS.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomeList.SKYRISHIGHLANDS, ConfigWeightManager.SKYRISHIGHLANDS.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomeList.SNOWYBLUETAIGA, ConfigWeightManager.SNOWYBLUETAIGA.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(BYGBiomeList.SNOWYCONIFEROUSFOREST, ConfigWeightManager.SNOWYCONIFEROUSFOREST.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(BYGBiomeList.SNOWYDECIDUOUSFOREST, ConfigWeightManager.SNOWYDECIDUOUSFOREST.getWeight(), BiomeManager.BiomeType.ICY);
//        addBiomeEntry(BYGBiomeList.SNOWYEVERGREENTAIGA, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
//        addBiomeEntry(BYGBiomeList.SNOWYPINEMOUNTAINS, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
//        addBiomeEntry(BYGBiomeList.SONORANDESERT, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
//        addBiomeEntry(BYGBiomeList.STONEBRUSHLANDS, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
//        addBiomeEntry(BYGBiomeList.STONEFOREST, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.TROPICALFUNGALRAINFOREST, ConfigWeightManager.TROPICALFUNGALFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.TROPICALRAINFOREST, ConfigWeightManager.TROPICALRAINFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.VIBRANTSWAMPLANDS, ConfigWeightManager.VIBRANTSWAMPLANDS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.SIERRAVALLEY, ConfigWeightManager.SIERRAVALLEY.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomeList.VOLCANO, ConfigWeightManager.VOLCANO.getWeight(), BiomeManager.BiomeType.DESERT);
//        addBiomeEntry(BYGBiomeList.WEEPINGWITCHFOREST, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
//        addBiomeEntry(BYGBiomeList.WOODLANDS, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.ZELKOVAFOREST, ConfigWeightManager.ZELKOVAFOREST.getWeight(), BiomeManager.BiomeType.COOL);

        BYG.LOGGER.debug("BYG: Added biome entries with their respective weights!");
    }

    public static void addBiomeEntry(Biome biome, int weight, BiomeManager.BiomeType type) {
        if (weight > 0) {
            BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(biome, weight));
        }
    }
}
