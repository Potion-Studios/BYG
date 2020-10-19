package corgiaoc.byg.config.biomeweight;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ConfigWeightManager {

    public static final List<ConfigWeight> CONFIG_WEIGHTS = new ArrayList<>();
    public static final ConfigWeight ALLIUM_FIELDS = new ConfigWeight("Allium_Fields", 2);
    public static final ConfigWeight ALPS = new ConfigWeight("Alps", 5);
    public static final ConfigWeight ANCIENT_FOREST = new ConfigWeight("ancientForest", 1);
    public static final ConfigWeight AMARANTH_FIELDS = new ConfigWeight("Amaranth_Fields", 2);
    public static final ConfigWeight ARAUCARIA_SAVANNA = new ConfigWeight("Araucaria_Savanna", 5);
    public static final ConfigWeight ASPEN_FOREST = new ConfigWeight("Aspen_Forest", 6);
    public static final ConfigWeight AUTUMNAL_VALLEY = new ConfigWeight("Autumnal_Valley", 5);
    public static final ConfigWeight BAOBAB_SAVANNA = new ConfigWeight("Baobab_Savanna", 6);
    public static final ConfigWeight BAYOU = new ConfigWeight("Bayou", 5);
    public static final ConfigWeight BLUE_TAIGA = new ConfigWeight("Blue_Taiga", 6);
    public static final ConfigWeight BLUFF_STEEPS = new ConfigWeight("Bluff_Steeps", 6);
    public static final ConfigWeight BOREAL_FOREST = new ConfigWeight("Boreal_Forest", 6);
    public static final ConfigWeight CANYONS = new ConfigWeight("Canyons", 0);
    public static final ConfigWeight COLD_SWAMPLANDS = new ConfigWeight("Cold_Swamplands", 6);
    public static final ConfigWeight CIKA_WOODS = new ConfigWeight("Cika_Woods", 4);
    public static final ConfigWeight CHERRY_BLOSSOM_FOREST = new ConfigWeight("Cherry_Blossom_Forest", 6);
    public static final ConfigWeight CRAG_GARDENS = new ConfigWeight("Crag_Gardens", 1);
    public static final ConfigWeight CONIFEROUS_FOREST = new ConfigWeight("Coniferous_Forest", 5);
    public static final ConfigWeight CYPRESS_SWAMPLAND = new ConfigWeight("Cypress_Swampland", 5);
    public static final ConfigWeight DEAD_SEA = new ConfigWeight("Dead_Sea", 2);
    public static final ConfigWeight DECIDUOUS_FOREST = new ConfigWeight("Deciduous_Forest", 6);
    public static final ConfigWeight DOVER_MOUNTAINS = new ConfigWeight("Dover_Mountains", 5);
    public static final ConfigWeight DUNES = new ConfigWeight("Dunes", 6);
    public static final ConfigWeight EBONY_WOODS = new ConfigWeight("Ebony_Woods", 5);
    public static final ConfigWeight ENCHANTED_FOREST = new ConfigWeight("Enchanted_Forest", 1);
    public static final ConfigWeight EVERGREEN_TAIGA = new ConfigWeight("Evergreen_Taiga", 6);
    public static final ConfigWeight GLOWSHROOM_BAYOU = new ConfigWeight("Glowshroom_Bayou", 1);
    public static final ConfigWeight GRASSLAND_PLATEAU = new ConfigWeight("Grassland_Plateau", 5);
    public static final ConfigWeight GREAT_LAKE = new ConfigWeight("Great_Lake", 6);
    public static final ConfigWeight GUIANA_SHIELD = new ConfigWeight("Guiana_Shield", 5);
    public static final ConfigWeight GROVE = new ConfigWeight("Grove", 5);
    public static final ConfigWeight ENCHANTED_GROVE = new ConfigWeight("Enchanted_Grove", 1);
    public static final ConfigWeight ICEBURG_OCEAN = new ConfigWeight("Iceburg_Ocean", 4);
    public static final ConfigWeight JACARANDA_FOREST = new ConfigWeight("Jacaranda_Forest", 6);
    public static final ConfigWeight MANGROVE_MARSHES = new ConfigWeight("Mangrove_Marshes", 5);
    public static final ConfigWeight MAPLE_TAIGA = new ConfigWeight("Maple_Taiga", 6);
    public static final ConfigWeight MEADOW = new ConfigWeight("Meadow", 6);
    public static final ConfigWeight MOJAVE_DESERT = new ConfigWeight("Mojave_Desert", 6);
    public static final ConfigWeight LUSH_TUNDRA = new ConfigWeight("Lush_Tundra", 6);
    public static final ConfigWeight ORCHARD = new ConfigWeight("Orchard", 5);
    public static final ConfigWeight PRAIRIE = new ConfigWeight("Prairie", 6);
    public static final ConfigWeight REDWOOD_TROPICS = new ConfigWeight("Redwood_Tropics", 4);
    public static final ConfigWeight RED_DESERT = new ConfigWeight("Red_Desert", 6);
    public static final ConfigWeight RED_OAK_FOREST = new ConfigWeight("Red_Oak_Forest", 6);
    public static final ConfigWeight RED_ROCK_MOUNTAINS = new ConfigWeight("Red_Rock_Mountains", 5);
    public static final ConfigWeight ROSE_FIELDS = new ConfigWeight("Rose_Fields", 2);
    public static final ConfigWeight SEASONAL_DECIDUOUS_FOREST = new ConfigWeight("Seasonal_Deciduous_Forest", 6);
    public static final ConfigWeight SEASONAL_FOREST = new ConfigWeight("Seasonal_Forest", 6);
    public static final ConfigWeight SEASONAL_BIRCH_FOREST = new ConfigWeight("Seasonal_Birch_Forest", 6);
    public static final ConfigWeight SHATTERED_GLACIER = new ConfigWeight("Shattered_Glacier", 4);
    public static final ConfigWeight SHRUBLANDS = new ConfigWeight("Shrublands", 5);
    public static final ConfigWeight SEASONAL_TAIGA = new ConfigWeight("Seasonal_Taiga", 6);
    public static final ConfigWeight SKYRIS_HIGHLANDS = new ConfigWeight("Skyris_Highlands", 2);
    public static final ConfigWeight SIERRA_VALLEY = new ConfigWeight("Sierra_Valley", 6);
    public static final ConfigWeight SNOWY_CONIFEROUS_FOREST = new ConfigWeight("Snowy_Coniferous_Forest", 6);
    public static final ConfigWeight SNOWY_DECIDUOUS_FOREST = new ConfigWeight("Snowy_Deciduous_Forest", 6);
    public static final ConfigWeight SNOWY_EVERGREEN_TAIGA = new ConfigWeight("Snowy_Evergreen_Taiga", 6);
    public static final ConfigWeight SNOWY_BLUE_TAIGA = new ConfigWeight("Snowy_Blue_Taiga", 6);
    public static final ConfigWeight STONE_FOREST = new ConfigWeight("Stone_Forest", 2);
    public static final ConfigWeight THE_BLACK_FOREST = new ConfigWeight("The_Black_Forest", 5);
    public static final ConfigWeight TROPICAL_FUNGAL_FOREST = new ConfigWeight("Tropical_Fungal_Forest", 5);
    public static final ConfigWeight TROPICAL_RAIN_FOREST = new ConfigWeight("Tropical_Rain_Forest", 6);
    public static final ConfigWeight TWILIGHT_VALLEY = new ConfigWeight("Twilight_Valley", 2);
    public static final ConfigWeight VIBRANT_SWAMPLANDS = new ConfigWeight("Vibrant_Swamplands", 6);
    public static final ConfigWeight WEEPING_WITCH_FOREST = new ConfigWeight("Weeping_Witch_Forest", 1);
    public static final ConfigWeight WOODLANDS = new ConfigWeight("Woodlands", 4);
    public static final ConfigWeight ZELKOVA_FOREST = new ConfigWeight("Zelkova_Forest", 6);


    public static ForgeConfigSpec COMMON_CONFIG;
    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

    public static void buildConfig() {
        CONFIG_WEIGHTS.forEach(o -> {
            o.apply(COMMON_BUILDER);
            COMMON_CONFIG = COMMON_BUILDER.build();
        });
    }

    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
        configData.load();
        spec.setConfig(configData);
    }
}
