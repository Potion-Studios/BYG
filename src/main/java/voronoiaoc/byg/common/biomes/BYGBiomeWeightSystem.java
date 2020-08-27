package voronoiaoc.byg.common.biomes;

import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.BiomeLayer;
import net.minecraftforge.fml.loading.FMLPaths;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.config.biomeweight.ConfigWeightManager;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BYGBiomeWeightSystem {
    public static List<Integer> HOT = new ArrayList<>();
    public static List<Integer> COOL = new ArrayList<>();
    public static List<Integer> WARM = new ArrayList<>();
    public static List<Integer> ICY = new ArrayList<>();

    public static void addBiomesToWeightSystem() {
        ConfigWeightManager.loadConfig(ConfigWeightManager.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(BYG.MOD_ID + "-weights-common.toml"));
//        if (BYGWorldConfig.vanillaBiomes.get()) {
//            HOT.add(WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.getValueForKey(Biomes.DESERT)));
//            HOT.add(WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.getValueForKey(Biomes.DESERT)));
//            HOT.add(WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.getValueForKey(Biomes.SAVANNA)));
//            HOT.add(WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.getValueForKey(Biomes.SAVANNA)));
//            HOT.add(WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.getValueForKey(Biomes.PLAINS)));
//            WARM.add(WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.getValueForKey(Biomes.FOREST)));
//            WARM.add(WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.getValueForKey(Biomes.DARK_FOREST)));
//            WARM.add(WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.getValueForKey(Biomes.MOUNTAINS)));
//            WARM.add(WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.getValueForKey(Biomes.PLAINS)));
//            WARM.add(WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.getValueForKey(Biomes.BIRCH_FOREST)));
//            WARM.add(WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.getValueForKey(Biomes.SWAMP)));
//            COOL.add(WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.getValueForKey(Biomes.FOREST)));
//            COOL.add(WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.getValueForKey(Biomes.MOUNTAINS)));
//            COOL.add(WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.getValueForKey(Biomes.TAIGA)));
//            COOL.add(WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.getValueForKey(Biomes.PLAINS)));
//            ICY.add(WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.getValueForKey(Biomes.SNOWY_TUNDRA)));
//            ICY.add(WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.getValueForKey(Biomes.SNOWY_TUNDRA)));
//            ICY.add(WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.getValueForKey(Biomes.SNOWY_TUNDRA)));
//            ICY.add(WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.getValueForKey(Biomes.SNOWY_TUNDRA)));
//            ICY.add(WorldGenRegistries.field_243657_i.getId(WorldGenRegistries.field_243657_i.getValueForKey(Biomes.SNOWY_TAIGA)));
//        }

        BYG.LOGGER.debug("BYG: Adding biome entries with their respective weights...");
        addBiomeEntry(BYGBiomeList.ALLIUMFIELDS, ConfigWeightManager.ALLIUMFIELDS.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.ALPS, ConfigWeightManager.ALPS.getWeight(), OverworldBiomeClimate.ICY);
        addBiomeEntry(BYGBiomeList.AMARANTHFIELDS, ConfigWeightManager.AMARANTHFIELDS.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.AUTUMNAL_VALLEY, ConfigWeightManager.AUTUMNALVALLEY.getWeight(), OverworldBiomeClimate.COOL);
        addBiomeEntry(BYGBiomeList.ANCIENTFOREST, ConfigWeightManager.ANCIENTFOREST.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.ASPENFOREST, ConfigWeightManager.ASPENFOREST.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.BAOBABSAVANNA, ConfigWeightManager.BAOBABSAVANNA.getWeight(), OverworldBiomeClimate.DESERT);
        addBiomeEntry(BYGBiomeList.BAYOU, ConfigWeightManager.BAYOU.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.BLUETAIGA, ConfigWeightManager.BLUETAIGA.getWeight(), OverworldBiomeClimate.COOL);
        addBiomeEntry(BYGBiomeList.BLUFFSTEEPS, ConfigWeightManager.BLUFFSTEEPS.getWeight(), OverworldBiomeClimate.COOL);
        addBiomeEntry(BYGBiomeList.BOREALFOREST, ConfigWeightManager.BOREALFOREST.getWeight(), OverworldBiomeClimate.COOL);
        addBiomeEntry(BYGBiomeList.COLDSWAMPLANDS, ConfigWeightManager.COLDSWAMPLANDS.getWeight(), OverworldBiomeClimate.COOL);
        addBiomeEntry(BYGBiomeList.CIKA_WOODS, ConfigWeightManager.CIKA_WOODS.getWeight(), OverworldBiomeClimate.COOL);
//        addBiomeEntry(BYGBiomeList.REDROCKCANYON, ConfigWeightManager.CANYONS.getWeight(), OverworldBiomeClimate.DESERT);
        addBiomeEntry(BYGBiomeList.CYPRESSSWAMPLANDS, ConfigWeightManager.CYPRESS_SWAMPLAND.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.CHERRYBLOSSOMFOREST, ConfigWeightManager.CHERRY_BLOSSOM_FOREST.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.CONIFEROUSFOREST, ConfigWeightManager.CONIFEROUSFOREST.getWeight(), OverworldBiomeClimate.COOL);
        addBiomeEntry(BYGBiomeList.DOVERMOUNTAINS, ConfigWeightManager.DOVERMOUNTAINS.getWeight(), OverworldBiomeClimate.COOL);
        addBiomeEntry(BYGBiomeList.DEADSEA, ConfigWeightManager.DEADSEA.getWeight(), OverworldBiomeClimate.DESERT);
        addBiomeEntry(BYGBiomeList.DECIDUOUSFOREST, ConfigWeightManager.DECIDUOUSFOREST.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.DUNES, ConfigWeightManager.DUNES.getWeight(), OverworldBiomeClimate.DESERT);
        addBiomeEntry(BYGBiomeList.EBONYWOODS, ConfigWeightManager.EBONY_WOODS.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.ENCHANTEDFOREST, ConfigWeightManager.ENCHANTED_FOREST.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.EVERGREENTAIGA, ConfigWeightManager.EVERGREEN_TAIGA.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.GLOWSHROOMBAYOU, ConfigWeightManager.GLOWSHROOMBAYOU.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.GRASSLANDPLATEAU, ConfigWeightManager.GRASSLANDPLATEAU.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.GREATLAKES, ConfigWeightManager.GREATLAKES.getWeight(), OverworldBiomeClimate.COOL);
        addBiomeEntry(BYGBiomeList.GUIANASHIELD, ConfigWeightManager.GUIANASHIELD.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.GROVE, ConfigWeightManager.GROVE.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.ENCHANTED_GROVE, ConfigWeightManager.ENCHANTED_GROVE.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.JACARANDAFOREST, ConfigWeightManager.JACARANDAFOREST.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.CRAGGARDENS, ConfigWeightManager.CRAGGARDENS.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.MANGROVEMARSHES, ConfigWeightManager.MANGROVE_MARSHES.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.MAPLETAIGA, ConfigWeightManager.MAPLE_TAIGA.getWeight(), OverworldBiomeClimate.COOL);
        addBiomeEntry(BYGBiomeList.MEADOW, ConfigWeightManager.MEADOW.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.MOJAVE_DESERT, ConfigWeightManager.MOJAVEDESERT.getWeight(), OverworldBiomeClimate.DESERT);
        addBiomeEntry(BYGBiomeList.LUSH_TUNDRA, ConfigWeightManager.LUSH_TUNDRA.getWeight(), OverworldBiomeClimate.ICY);
        addBiomeEntry(BYGBiomeList.ORCHARD, ConfigWeightManager.ORCHARD.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.PRAIRIE, ConfigWeightManager.PRAIRIE.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.REDDESERT, ConfigWeightManager.REDDESERT.getWeight(), OverworldBiomeClimate.DESERT);
        addBiomeEntry(BYGBiomeList.REDOAKFOREST, ConfigWeightManager.REDOAKFOREST.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.RED_ROCK_MOUNTAINS, ConfigWeightManager.REDROCKMOUNTAINS.getWeight(), OverworldBiomeClimate.DESERT);
        addBiomeEntry(BYGBiomeList.REDWOOD_TROPICS, ConfigWeightManager.REDWOOD_TROPICS.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.SEASONALBIRCHFOREST, ConfigWeightManager.SEASONALBIRCHFOREST.getWeight(), OverworldBiomeClimate.COOL);
        addBiomeEntry(BYGBiomeList.SEASONALDECIDUOUSFOREST, ConfigWeightManager.SEASONALDECIDUOUSFOREST.getWeight(), OverworldBiomeClimate.COOL);
        addBiomeEntry(BYGBiomeList.SEASONALFOREST, ConfigWeightManager.SEASONALFOREST.getWeight(), OverworldBiomeClimate.COOL);
        addBiomeEntry(BYGBiomeList.SEASONALTAIGA, ConfigWeightManager.SEASONALTAIGA.getWeight(), OverworldBiomeClimate.COOL);
        addBiomeEntry(BYGBiomeList.SHATTEREDGLACIER, ConfigWeightManager.SHATTEREDGLACIER.getWeight(), OverworldBiomeClimate.ICY);
        addBiomeEntry(BYGBiomeList.SHRUBLANDS, ConfigWeightManager.SHRUBLANDS.getWeight(), OverworldBiomeClimate.DESERT);
        addBiomeEntry(BYGBiomeList.SKYRISHIGHLANDS, ConfigWeightManager.SKYRISHIGHLANDS.getWeight(), OverworldBiomeClimate.COOL);
        addBiomeEntry(BYGBiomeList.SNOWYBLUETAIGA, ConfigWeightManager.SNOWYBLUETAIGA.getWeight(), OverworldBiomeClimate.ICY);
        addBiomeEntry(BYGBiomeList.SNOWYCONIFEROUSFOREST, ConfigWeightManager.SNOWYCONIFEROUSFOREST.getWeight(), OverworldBiomeClimate.ICY);
        addBiomeEntry(BYGBiomeList.SNOWYDECIDUOUSFOREST, ConfigWeightManager.SNOWYDECIDUOUSFOREST.getWeight(), OverworldBiomeClimate.ICY);
        addBiomeEntry(BYGBiomeList.SNOWYEVERGREENTAIGA, ConfigWeightManager.SNOWY_EVERGREEN_TAIGA.getWeight(), OverworldBiomeClimate.ICY);
//        addBiomeEntry(BYGBiomeList.SONORANDESERT, ConfigWeightManager.amaranthFields.getWeight(), OverworldBiomeClimate.WARM);
//        addBiomeEntry(BYGBiomeList.STONEBRUSHLANDS, ConfigWeightManager.amaranthFields.getWeight(), OverworldBiomeClimate.WARM);
//        addBiomeEntry(BYGBiomeList.STONEFOREST, ConfigWeightManager.amaranthFields.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.THE_BLACK_FOREST, ConfigWeightManager.THE_BLACK_FOREST.getWeight(), OverworldBiomeClimate.COOL);
        addBiomeEntry(BYGBiomeList.TROPICALFUNGALRAINFOREST, ConfigWeightManager.TROPICALFUNGALFOREST.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.TROPICALRAINFOREST, ConfigWeightManager.TROPICALRAINFOREST.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.VIBRANTSWAMPLANDS, ConfigWeightManager.VIBRANTSWAMPLANDS.getWeight(), OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.SIERRAVALLEY, ConfigWeightManager.SIERRAVALLEY.getWeight(), OverworldBiomeClimate.DESERT);
        addBiomeEntry(BYGBiomeList.WEEPINGWITCHFOREST, ConfigWeightManager.WEEPING_WITCH_FOREST.getWeight(), OverworldBiomeClimate.COOL);
        addBiomeEntry(BYGBiomeList.WOODLANDS, ConfigWeightManager.WOODLANDS.getWeight(), OverworldBiomeClimate.WARM);
//        addBiomeEntry(BYGBiomeList.VOLCANO, 1, OverworldBiomeClimate.WARM);
        addBiomeEntry(BYGBiomeList.ZELKOVAFOREST, ConfigWeightManager.ZELKOVAFOREST.getWeight(), OverworldBiomeClimate.COOL);

        BYG.LOGGER.debug("BYG: Added biome entries with their respective weights!");
    }

    public enum OverworldBiomeClimate {
        ICY,
        COOL,
        WARM,
        DESERT
    }

    public static void addBiomeEntry(Biome biome, int weight, OverworldBiomeClimate type) {
        if (weight > 0) {
            if (type == OverworldBiomeClimate.WARM)
                WARM.add(WorldGenRegistries.field_243657_i.getId(biome));
            if (type == OverworldBiomeClimate.COOL)
                COOL.add(WorldGenRegistries.field_243657_i.getId(biome));
            if (type == OverworldBiomeClimate.DESERT)
                HOT.add(WorldGenRegistries.field_243657_i.getId(biome));
            if (type == OverworldBiomeClimate.ICY)
                ICY.add(WorldGenRegistries.field_243657_i.getId(biome));
        }
    }

    public static void addBYGBiomesToVanillaOverworld() {
        for (int integer : HOT)
            BiomeLayer.field_202744_r = addElement(BiomeLayer.field_202744_r, integer);
        for (int integer : WARM)
            BiomeLayer.field_202745_s = addElement(BiomeLayer.field_202745_s, integer);
        for (int integer : COOL)
            BiomeLayer.field_202746_t = addElement(BiomeLayer.field_202746_t, integer);
        for (int integer : ICY)
            BiomeLayer.field_202747_u = addElement(BiomeLayer.field_202747_u, integer);
    }


    static int[] addElement(int[] a, int e) {
        a = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = e;
        return a;
    }

}
