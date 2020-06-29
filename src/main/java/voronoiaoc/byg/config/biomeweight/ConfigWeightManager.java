package voronoiaoc.byg.config.biomeweight;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ConfigWeightManager {

    public static final List<ConfigWeight> biomeWeights = new ArrayList<>();
    public static final ConfigWeight ALLIUMFIELDS = new ConfigWeight("Allium_Fields", 2);
    public static final ConfigWeight ALPS = new ConfigWeight("Alps", 5);
//    public static final ConfigWeight ancientForest = new ConfigWeight("ancientForest", 10);
    public static final ConfigWeight AMARANTHFIELDS = new ConfigWeight("Amaranth_Fields", 2);
    public static final ConfigWeight ASPENFOREST = new ConfigWeight("Aspen_Forest", 6);
    public static final ConfigWeight AUTUMNALVALLEY = new ConfigWeight("Alps", 5);
    public static final ConfigWeight BAOBABSAVANNA = new ConfigWeight("Baobab_Savanna", 6);
    public static final ConfigWeight BAYOU = new ConfigWeight("Bayou", 5);
    public static final ConfigWeight BLUETAIGA = new ConfigWeight("Blue_Taiga", 6);
    public static final ConfigWeight BLUFFSTEEPS = new ConfigWeight("Bluff_Steeps", 6);
    public static final ConfigWeight BOREALFOREST = new ConfigWeight("Boreal_Forest", 6);
    public static final ConfigWeight COLDSWAMPLANDS = new ConfigWeight("Cold_Swamplands", 6);
//    public static final ConfigWeight CANYONS = new ConfigWeight("canyons", 10);
    public static final ConfigWeight CIKA_WOODS = new ConfigWeight("Cika_Woods", 4);
    public static final ConfigWeight CHERRY_BLOSSOM_FOREST = new ConfigWeight("Cherry_Blossom_Forest", 6);
    public static final ConfigWeight REDWOOD_TROPICS = new ConfigWeight("Redwood_Tropics", 4);
    public static final ConfigWeight CYPRESS_SWAMPLAND = new ConfigWeight("Cypress_Swampland", 5);
    public static final ConfigWeight CONIFEROUSFOREST = new ConfigWeight("Coniferous_Forest", 5);
    public static final ConfigWeight DEADSEA = new ConfigWeight("Dead_Sea", 2);
    public static final ConfigWeight DECIDUOUSFOREST = new ConfigWeight("Deciduous_Forest", 6);
    public static final ConfigWeight DOVERMOUNTAINS = new ConfigWeight("Dover_Mountains", 5);
    public static final ConfigWeight DUNES = new ConfigWeight("Dunes", 6);
    public static final ConfigWeight EBONY_WOODS = new ConfigWeight("Ebony_Woods", 5);
    public static final ConfigWeight ENCHANTED_FOREST = new ConfigWeight("Enchanted_Forest", 1);
    public static final ConfigWeight EVERGREEN_TAIGA = new ConfigWeight("Evergreen_Taiga", 6);
    public static final ConfigWeight GIANTBLUETAIGA = new ConfigWeight("Blue_Giant_Taiga", 6);
    public static final ConfigWeight GLOWSHROOMBAYOU = new ConfigWeight("Glowshroom_Bayou", 1);
    public static final ConfigWeight GRASSLANDPLATEAU = new ConfigWeight("Grassland_Plateau", 5);
    public static final ConfigWeight GREATLAKES = new ConfigWeight("Great_Lake", 6);
    public static final ConfigWeight GUIANASHIELD = new ConfigWeight("Guiana_Shield", 5);
    public static final ConfigWeight GROVE = new ConfigWeight("Grove", 5);
    public static final ConfigWeight ENCHANTED_GROVE = new ConfigWeight("Enchanted_Grove", 1);
    public static final ConfigWeight JACARANDAFOREST = new ConfigWeight("Jacaranda_Forest", 6);
    public static final ConfigWeight MANGROVE_MARSHES = new ConfigWeight("Mangrove_Marshes", 5);
    public static final ConfigWeight MAPLE_TAIGA = new ConfigWeight("Maple_Taiga", 6);
    public static final ConfigWeight MEADOW = new ConfigWeight("Meadow", 6);
    public static final ConfigWeight MOJAVEDESERT = new ConfigWeight("Mojave_Desert", 6);
    public static final ConfigWeight LUSH_TUNDRA = new ConfigWeight("Lush_Tundra", 6);
    public static final ConfigWeight ORCHARD = new ConfigWeight("Orchard", 5);
    public static final ConfigWeight PRAIRIE = new ConfigWeight("Prairie", 6);
    public static final ConfigWeight REDDESERT = new ConfigWeight("Red_Desert", 6);
    public static final ConfigWeight REDOAKFOREST = new ConfigWeight("Red_Oak_Forest", 6);
    public static final ConfigWeight REDROCKMOUNTAINS = new ConfigWeight("Red_Rock_Mountains", 5);
    public static final ConfigWeight SEASONALDECIDUOUSFOREST = new ConfigWeight("Seasonal_Deciduous_Forest", 6);
    public static final ConfigWeight SEASONALFOREST = new ConfigWeight("Seasonal_Forest", 6);
    public static final ConfigWeight SEASONALBIRCHFOREST = new ConfigWeight("Seasonal_Birch_Forest", 6);
    public static final ConfigWeight SHATTEREDGLACIER = new ConfigWeight("Shattered_Glacier", 4);
    public static final ConfigWeight SHRUBLANDS = new ConfigWeight("Shrublands", 5);
    public static final ConfigWeight SEASONALGIANTTAIGA = new ConfigWeight("Seasonal_Giant_Taiga", 6);
    public static final ConfigWeight SEASONALTAIGA = new ConfigWeight("Seasonal_Taiga", 6);
    public static final ConfigWeight SKYRISHIGHLANDS = new ConfigWeight("Skyris_Highlands", 2);
    public static final ConfigWeight SIERRAVALLEY = new ConfigWeight("Sierra_Valley", 6);
    public static final ConfigWeight SNOWYCONIFEROUSFOREST = new ConfigWeight("Snowy_Coniferous_Forest", 6);
    public static final ConfigWeight SNOWYDECIDUOUSFOREST = new ConfigWeight("Snowy_Deciduous_Forest", 6);
    public static final ConfigWeight SNOWY_EVERGREEN_TAIGA = new ConfigWeight("Snowy_Evergreen_Taiga", 6);
    public static final ConfigWeight SNOWYBLUETAIGA = new ConfigWeight("Snowy_Blue_Taiga", 6);
    public static final ConfigWeight SNOWYGIANTBLUETAIGA = new ConfigWeight("Snowy_Blue_Giant_Taiga", 6);
//    public static final ConfigWeight sonorandesert = new ConfigWeight("sonorandesert", 10);
//    public static final ConfigWeight stonebrushlands = new ConfigWeight("stonebrushlands", 10);
//    public static final ConfigWeight stoneforest = new ConfigWeight("stoneforest", 10);
    public static final ConfigWeight THE_BLACK_FOREST = new ConfigWeight("The_Black_Forest", 5);
    public static final ConfigWeight TROPICALFUNGALFOREST = new ConfigWeight("Tropical_Fungal_Forest", 5);
    public static final ConfigWeight TROPICALRAINFOREST = new ConfigWeight("Tropical_Rain_Forest", 6);
    public static final ConfigWeight CRAGGARDENS = new ConfigWeight("Crag_Gardens", 1);
    public static final ConfigWeight VIBRANTSWAMPLANDS = new ConfigWeight("Vibrant_Swamplands", 6);
//    public static final ConfigWeight VOLCANO = new ConfigWeight("Volcano", 1);
    public static final ConfigWeight WEEPING_WITCH_FOREST = new ConfigWeight("Weeping_Witch_Forest", 1);
    public static final ConfigWeight WOODLANDS = new ConfigWeight("Woodlands", 4);
    public static final ConfigWeight ZELKOVAFOREST = new ConfigWeight("Zelkova_Forest", 6);


    public static final ForgeConfigSpec COMMON_CONFIG;
    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

    static  {
        biomeWeights.forEach(o -> o.apply(COMMON_BUILDER));
        COMMON_CONFIG = COMMON_BUILDER.build();
    }

    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
        configData.load();
        spec.setConfig(configData);
    }
}
