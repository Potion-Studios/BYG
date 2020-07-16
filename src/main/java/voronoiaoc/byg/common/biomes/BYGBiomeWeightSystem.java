package voronoiaoc.byg.common.biomes;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.loading.FMLPaths;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.world.worldtype116.BYGBiomeCatch;
import voronoiaoc.byg.config.BYGWorldConfig;
import voronoiaoc.byg.config.biomeweight.ConfigWeightManager;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

import java.util.ArrayList;
import java.util.List;

public class BYGBiomeWeightSystem {
    public static List<Integer> HOT = new ArrayList<>();
    public static List<Integer> COOL = new ArrayList<>();
    public static List<Integer> WARM = new ArrayList<>();
    public static List<Integer> ICY = new ArrayList<>();

    public static void addBiomesToWeightSystem() {
        ConfigWeightManager.loadConfig(ConfigWeightManager.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(BYG.MOD_ID + "-weights-common.toml"));
        if (BYGWorldConfig.vanillaBiomes.get()) {
            HOT.add(Registry.BIOME.getId(Biomes.DESERT));
            HOT.add(Registry.BIOME.getId(Biomes.DESERT));
            HOT.add(Registry.BIOME.getId(Biomes.SAVANNA));
            HOT.add(Registry.BIOME.getId(Biomes.SAVANNA));
            HOT.add(Registry.BIOME.getId(Biomes.PLAINS));
            WARM.add(Registry.BIOME.getId(Biomes.FOREST));
            WARM.add(Registry.BIOME.getId(Biomes.DARK_FOREST));
            WARM.add(Registry.BIOME.getId(Biomes.MOUNTAINS));
            WARM.add(Registry.BIOME.getId(Biomes.PLAINS));
            WARM.add(Registry.BIOME.getId(Biomes.BIRCH_FOREST));
            WARM.add(Registry.BIOME.getId(Biomes.SWAMP));
            COOL.add(Registry.BIOME.getId(Biomes.FOREST));
            COOL.add(Registry.BIOME.getId(Biomes.MOUNTAINS));
            COOL.add(Registry.BIOME.getId(Biomes.TAIGA));
            COOL.add(Registry.BIOME.getId(Biomes.PLAINS));
            ICY.add(Registry.BIOME.getId(Biomes.SNOWY_TUNDRA));
            ICY.add(Registry.BIOME.getId(Biomes.SNOWY_TUNDRA));
            ICY.add(Registry.BIOME.getId(Biomes.SNOWY_TUNDRA));
            ICY.add(Registry.BIOME.getId(Biomes.SNOWY_TUNDRA));
            ICY.add(Registry.BIOME.getId(Biomes.SNOWY_TAIGA));
        }

        BYGBiomeCatch.biomeCollection();

        BYG.LOGGER.debug("BYG: Adding biome entries with their respective weights...");
        addBiomeEntry(BYGBiomeList.ALLIUMFIELDS, ConfigWeightManager.ALLIUMFIELDS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.ALPS, ConfigWeightManager.ALPS.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(BYGBiomeList.AMARANTHFIELDS, ConfigWeightManager.AMARANTHFIELDS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.AUTUMNAL_VALLEY, ConfigWeightManager.AUTUMNALVALLEY.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomeList.ANCIENTFOREST, ConfigWeightManager.ANCIENTFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.ASPENFOREST, ConfigWeightManager.ASPENFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.BAOBABSAVANNA, ConfigWeightManager.BAOBABSAVANNA.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomeList.BAYOU, ConfigWeightManager.BAYOU.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.BLUETAIGA, ConfigWeightManager.BLUETAIGA.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomeList.BLUFFSTEEPS, ConfigWeightManager.BLUFFSTEEPS.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomeList.BOREALFOREST, ConfigWeightManager.BOREALFOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomeList.COLDSWAMPLANDS, ConfigWeightManager.COLDSWAMPLANDS.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomeList.CIKA_WOODS, ConfigWeightManager.CIKA_WOODS.getWeight(), BiomeManager.BiomeType.COOL);
//        addBiomeEntry(BYGBiomeList.REDROCKCANYON, ConfigWeightManager.CANYONS.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomeList.CYPRESSSWAMPLANDS, ConfigWeightManager.CYPRESS_SWAMPLAND.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.CHERRYBLOSSOMFOREST, ConfigWeightManager.CHERRY_BLOSSOM_FOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.CONIFEROUSFOREST, ConfigWeightManager.CONIFEROUSFOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomeList.DOVERMOUNTAINS, ConfigWeightManager.DOVERMOUNTAINS.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomeList.DEADSEA, ConfigWeightManager.DEADSEA.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomeList.DECIDUOUSFOREST, ConfigWeightManager.DECIDUOUSFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.DUNES, ConfigWeightManager.DUNES.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomeList.EBONYWOODS, ConfigWeightManager.EBONY_WOODS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.ENCHANTEDFOREST, ConfigWeightManager.ENCHANTED_FOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.EVERGREENTAIGA, ConfigWeightManager.EVERGREEN_TAIGA.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.GLOWSHROOMBAYOU, ConfigWeightManager.GLOWSHROOMBAYOU.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.GRASSLANDPLATEAU, ConfigWeightManager.GRASSLANDPLATEAU.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.GREATLAKES, ConfigWeightManager.GREATLAKES.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomeList.GUIANASHIELD, ConfigWeightManager.GUIANASHIELD.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.GROVE, ConfigWeightManager.GROVE.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.ENCHANTED_GROVE, ConfigWeightManager.ENCHANTED_GROVE.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.JACARANDAFOREST, ConfigWeightManager.JACARANDAFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.CRAGGARDENS, ConfigWeightManager.CRAGGARDENS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.MANGROVEMARSHES, ConfigWeightManager.MANGROVE_MARSHES.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.MAPLETAIGA, ConfigWeightManager.MAPLE_TAIGA.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomeList.MEADOW, ConfigWeightManager.MEADOW.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.MOJAVE_DESERT, ConfigWeightManager.MOJAVEDESERT.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomeList.LUSH_TUNDRA, ConfigWeightManager.LUSH_TUNDRA.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(BYGBiomeList.ORCHARD, ConfigWeightManager.ORCHARD.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.PRAIRIE, ConfigWeightManager.PRAIRIE.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.REDDESERT, ConfigWeightManager.REDDESERT.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomeList.REDOAKFOREST, ConfigWeightManager.REDOAKFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.RED_ROCK_MOUNTAINS, ConfigWeightManager.REDROCKMOUNTAINS.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomeList.REDWOOD_TROPICS, ConfigWeightManager.REDWOOD_TROPICS.getWeight(), BiomeManager.BiomeType.WARM);
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
        addBiomeEntry(BYGBiomeList.SNOWYEVERGREENTAIGA, ConfigWeightManager.SNOWY_EVERGREEN_TAIGA.getWeight(), BiomeManager.BiomeType.ICY);
//        addBiomeEntry(BYGBiomeList.SONORANDESERT, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
//        addBiomeEntry(BYGBiomeList.STONEBRUSHLANDS, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
//        addBiomeEntry(BYGBiomeList.STONEFOREST, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.THE_BLACK_FOREST, ConfigWeightManager.THE_BLACK_FOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomeList.TROPICALFUNGALRAINFOREST, ConfigWeightManager.TROPICALFUNGALFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.TROPICALRAINFOREST, ConfigWeightManager.TROPICALRAINFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.VIBRANTSWAMPLANDS, ConfigWeightManager.VIBRANTSWAMPLANDS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.SIERRAVALLEY, ConfigWeightManager.SIERRAVALLEY.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomeList.WEEPINGWITCHFOREST, ConfigWeightManager.WEEPING_WITCH_FOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomeList.WOODLANDS, ConfigWeightManager.WOODLANDS.getWeight(), BiomeManager.BiomeType.WARM);
//        addBiomeEntry(BYGBiomeList.VOLCANO, 1, BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomeList.ZELKOVAFOREST, ConfigWeightManager.ZELKOVAFOREST.getWeight(), BiomeManager.BiomeType.COOL);

        BYG.LOGGER.debug("BYG: Added biome entries with their respective weights!");
    }

    public static void addBiomeEntry(Biome biome, int weight, BiomeManager.BiomeType type) {
        if (weight > 0) {
            BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(biome, weight));
            if (type == BiomeManager.BiomeType.WARM)
                WARM.add(Registry.BIOME.getId(biome));
            if (type == BiomeManager.BiomeType.COOL)
                COOL.add(Registry.BIOME.getId(biome));
            if (type == BiomeManager.BiomeType.DESERT)
                HOT.add(Registry.BIOME.getId(biome));
            if (type == BiomeManager.BiomeType.ICY)
                ICY.add(Registry.BIOME.getId(biome));
        }
    }
}
