package corgiaoc.byg.common.world.biome;

import corgiaoc.byg.BYG;
import corgiaoc.byg.config.biomeweight.ConfigWeightManager;
import corgiaoc.byg.core.byglists.BYGBiomes;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BYGBiomeWeightSystem {
    public static List<Integer> HOT = new ArrayList<>();
    public static List<Integer> COOL = new ArrayList<>();
    public static List<Integer> WARM = new ArrayList<>();
    public static List<Integer> ICY = new ArrayList<>();

    public static void addBiomesToWeightSystem() {
        ConfigWeightManager.loadConfig(ConfigWeightManager.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(BYG.MOD_ID + "-weights-common.toml"));
        BYG.LOGGER.debug("BYG: Adding biome entries with their respective weights...");
        addBiomeEntry(BYGBiomes.ALLIUMFIELDS, ConfigWeightManager.ALLIUMFIELDS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.ALPS, ConfigWeightManager.ALPS.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(BYGBiomes.AMARANTHFIELDS, ConfigWeightManager.AMARANTHFIELDS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.AUTUMNAL_VALLEY, ConfigWeightManager.AUTUMNALVALLEY.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.ANCIENTFOREST, ConfigWeightManager.ANCIENTFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.ASPENFOREST, ConfigWeightManager.ASPENFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.BAOBABSAVANNA, ConfigWeightManager.BAOBABSAVANNA.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomes.BAYOU, ConfigWeightManager.BAYOU.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.BLUETAIGA, ConfigWeightManager.BLUETAIGA.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.BLUFFSTEEPS, ConfigWeightManager.BLUFFSTEEPS.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.BOREALFOREST, ConfigWeightManager.BOREALFOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.COLDSWAMPLANDS, ConfigWeightManager.COLDSWAMPLANDS.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.CIKA_WOODS, ConfigWeightManager.CIKA_WOODS.getWeight(), BiomeManager.BiomeType.COOL);
//        addBiomeEntry(BYGBiomes.REDROCKCANYON, ConfigWeightManager.CANYONS.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomes.CYPRESSSWAMPLANDS, ConfigWeightManager.CYPRESS_SWAMPLAND.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.CHERRYBLOSSOMFOREST, ConfigWeightManager.CHERRY_BLOSSOM_FOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.CONIFEROUSFOREST, ConfigWeightManager.CONIFEROUSFOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.DOVERMOUNTAINS, ConfigWeightManager.DOVERMOUNTAINS.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.DEADSEA, ConfigWeightManager.DEADSEA.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomes.DECIDUOUSFOREST, ConfigWeightManager.DECIDUOUSFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.DUNES, ConfigWeightManager.DUNES.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomes.EBONYWOODS, ConfigWeightManager.EBONY_WOODS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.ENCHANTEDFOREST, ConfigWeightManager.ENCHANTED_FOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.EVERGREENTAIGA, ConfigWeightManager.EVERGREEN_TAIGA.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.GLOWSHROOMBAYOU, ConfigWeightManager.GLOWSHROOMBAYOU.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.GRASSLANDPLATEAU, ConfigWeightManager.GRASSLANDPLATEAU.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.GREATLAKES, ConfigWeightManager.GREATLAKES.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.GUIANASHIELD, ConfigWeightManager.GUIANASHIELD.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.GROVE, ConfigWeightManager.GROVE.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.ENCHANTED_GROVE, ConfigWeightManager.ENCHANTED_GROVE.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.JACARANDAFOREST, ConfigWeightManager.JACARANDAFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.CRAGGARDENS, ConfigWeightManager.CRAGGARDENS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.MANGROVEMARSHES, ConfigWeightManager.MANGROVE_MARSHES.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.MAPLETAIGA, ConfigWeightManager.MAPLE_TAIGA.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.MEADOW, ConfigWeightManager.MEADOW.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.MOJAVE_DESERT, ConfigWeightManager.MOJAVEDESERT.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomes.LUSH_TUNDRA, ConfigWeightManager.LUSH_TUNDRA.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(BYGBiomes.ORCHARD, ConfigWeightManager.ORCHARD.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.PRAIRIE, ConfigWeightManager.PRAIRIE.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.REDDESERT, ConfigWeightManager.REDDESERT.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomes.REDOAKFOREST, ConfigWeightManager.REDOAKFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.RED_ROCK_MOUNTAINS, ConfigWeightManager.REDROCKMOUNTAINS.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomes.REDWOOD_TROPICS, ConfigWeightManager.REDWOOD_TROPICS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.SEASONALBIRCHFOREST, ConfigWeightManager.SEASONALBIRCHFOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.SEASONALDECIDUOUSFOREST, ConfigWeightManager.SEASONALDECIDUOUSFOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.SEASONALFOREST, ConfigWeightManager.SEASONALFOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.SEASONALTAIGA, ConfigWeightManager.SEASONALTAIGA.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.SHATTEREDGLACIER, ConfigWeightManager.SHATTEREDGLACIER.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(BYGBiomes.SHRUBLANDS, ConfigWeightManager.SHRUBLANDS.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomes.SKYRISHIGHLANDS, ConfigWeightManager.SKYRISHIGHLANDS.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.SNOWYBLUETAIGA, ConfigWeightManager.SNOWYBLUETAIGA.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(BYGBiomes.SNOWYCONIFEROUSFOREST, ConfigWeightManager.SNOWYCONIFEROUSFOREST.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(BYGBiomes.SNOWYDECIDUOUSFOREST, ConfigWeightManager.SNOWYDECIDUOUSFOREST.getWeight(), BiomeManager.BiomeType.ICY);
        addBiomeEntry(BYGBiomes.SNOWYEVERGREENTAIGA, ConfigWeightManager.SNOWY_EVERGREEN_TAIGA.getWeight(), BiomeManager.BiomeType.ICY);
//        addBiomeEntry(BYGBiomes.SONORANDESERT, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
//        addBiomeEntry(BYGBiomes.STONEBRUSHLANDS, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
//        addBiomeEntry(BYGBiomes.STONEFOREST, ConfigWeightManager.amaranthFields.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.THE_BLACK_FOREST, ConfigWeightManager.THE_BLACK_FOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.TROPICALFUNGALRAINFOREST, ConfigWeightManager.TROPICALFUNGALFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.TROPICALRAINFOREST, ConfigWeightManager.TROPICALRAINFOREST.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.VIBRANTSWAMPLANDS, ConfigWeightManager.VIBRANTSWAMPLANDS.getWeight(), BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.SIERRAVALLEY, ConfigWeightManager.SIERRAVALLEY.getWeight(), BiomeManager.BiomeType.DESERT);
        addBiomeEntry(BYGBiomes.WEEPINGWITCHFOREST, ConfigWeightManager.WEEPING_WITCH_FOREST.getWeight(), BiomeManager.BiomeType.COOL);
        addBiomeEntry(BYGBiomes.WOODLANDS, ConfigWeightManager.WOODLANDS.getWeight(), BiomeManager.BiomeType.WARM);
//        addBiomeEntry(BYGBiomes.VOLCANO, 1, BiomeManager.BiomeType.WARM);
        addBiomeEntry(BYGBiomes.ZELKOVAFOREST, ConfigWeightManager.ZELKOVAFOREST.getWeight(), BiomeManager.BiomeType.COOL);

        BYG.LOGGER.debug("BYG: Added biome entries with their respective weights!");
    }

    public static void addBiomeEntry(Biome biome, int weight, BiomeManager.BiomeType type) {
        if (weight > 0) {
            BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome))), weight));
        }
    }
}
