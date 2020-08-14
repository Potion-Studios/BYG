package voronoiaoc.byg.common.biomes;

import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.BiomeLayer;
import net.minecraftforge.fml.loading.FMLPaths;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.world.worldtype116.BYGBiomeCatch;
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

        BYGBiomeCatch.biomeCollection();

        BYG.LOGGER.debug("BYG: Adding biome entries with their respective weights...");
        addBiomeEntry(BYGBiomeList.ALLIUMFIELDS, ConfigWeightManager.ALLIUMFIELDS.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.ALPS, ConfigWeightManager.ALPS.getWeight(), OverworldClimate.ICY);
        addBiomeEntry(BYGBiomeList.AMARANTHFIELDS, ConfigWeightManager.AMARANTHFIELDS.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.AUTUMNAL_VALLEY, ConfigWeightManager.AUTUMNALVALLEY.getWeight(), OverworldClimate.COOL);
        addBiomeEntry(BYGBiomeList.ANCIENTFOREST, ConfigWeightManager.ANCIENTFOREST.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.ASPENFOREST, ConfigWeightManager.ASPENFOREST.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.BAOBABSAVANNA, ConfigWeightManager.BAOBABSAVANNA.getWeight(), OverworldClimate.DESERT);
        addBiomeEntry(BYGBiomeList.BAYOU, ConfigWeightManager.BAYOU.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.BLUETAIGA, ConfigWeightManager.BLUETAIGA.getWeight(), OverworldClimate.COOL);
        addBiomeEntry(BYGBiomeList.BLUFFSTEEPS, ConfigWeightManager.BLUFFSTEEPS.getWeight(), OverworldClimate.COOL);
        addBiomeEntry(BYGBiomeList.BOREALFOREST, ConfigWeightManager.BOREALFOREST.getWeight(), OverworldClimate.COOL);
        addBiomeEntry(BYGBiomeList.COLDSWAMPLANDS, ConfigWeightManager.COLDSWAMPLANDS.getWeight(), OverworldClimate.COOL);
        addBiomeEntry(BYGBiomeList.CIKA_WOODS, ConfigWeightManager.CIKA_WOODS.getWeight(), OverworldClimate.COOL);
//        addBiomeEntry(BYGBiomeList.REDROCKCANYON, ConfigWeightManager.CANYONS.getWeight(), OverworldClimate.DESERT);
        addBiomeEntry(BYGBiomeList.CYPRESSSWAMPLANDS, ConfigWeightManager.CYPRESS_SWAMPLAND.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.CHERRYBLOSSOMFOREST, ConfigWeightManager.CHERRY_BLOSSOM_FOREST.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.CONIFEROUSFOREST, ConfigWeightManager.CONIFEROUSFOREST.getWeight(), OverworldClimate.COOL);
        addBiomeEntry(BYGBiomeList.DOVERMOUNTAINS, ConfigWeightManager.DOVERMOUNTAINS.getWeight(), OverworldClimate.COOL);
        addBiomeEntry(BYGBiomeList.DEADSEA, ConfigWeightManager.DEADSEA.getWeight(), OverworldClimate.DESERT);
        addBiomeEntry(BYGBiomeList.DECIDUOUSFOREST, ConfigWeightManager.DECIDUOUSFOREST.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.DUNES, ConfigWeightManager.DUNES.getWeight(), OverworldClimate.DESERT);
        addBiomeEntry(BYGBiomeList.EBONYWOODS, ConfigWeightManager.EBONY_WOODS.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.ENCHANTEDFOREST, ConfigWeightManager.ENCHANTED_FOREST.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.EVERGREENTAIGA, ConfigWeightManager.EVERGREEN_TAIGA.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.GLOWSHROOMBAYOU, ConfigWeightManager.GLOWSHROOMBAYOU.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.GRASSLANDPLATEAU, ConfigWeightManager.GRASSLANDPLATEAU.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.GREATLAKES, ConfigWeightManager.GREATLAKES.getWeight(), OverworldClimate.COOL);
        addBiomeEntry(BYGBiomeList.GUIANASHIELD, ConfigWeightManager.GUIANASHIELD.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.GROVE, ConfigWeightManager.GROVE.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.ENCHANTED_GROVE, ConfigWeightManager.ENCHANTED_GROVE.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.JACARANDAFOREST, ConfigWeightManager.JACARANDAFOREST.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.CRAGGARDENS, ConfigWeightManager.CRAGGARDENS.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.MANGROVEMARSHES, ConfigWeightManager.MANGROVE_MARSHES.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.MAPLETAIGA, ConfigWeightManager.MAPLE_TAIGA.getWeight(), OverworldClimate.COOL);
        addBiomeEntry(BYGBiomeList.MEADOW, ConfigWeightManager.MEADOW.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.MOJAVE_DESERT, ConfigWeightManager.MOJAVEDESERT.getWeight(), OverworldClimate.DESERT);
        addBiomeEntry(BYGBiomeList.LUSH_TUNDRA, ConfigWeightManager.LUSH_TUNDRA.getWeight(), OverworldClimate.ICY);
        addBiomeEntry(BYGBiomeList.ORCHARD, ConfigWeightManager.ORCHARD.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.PRAIRIE, ConfigWeightManager.PRAIRIE.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.REDDESERT, ConfigWeightManager.REDDESERT.getWeight(), OverworldClimate.DESERT);
        addBiomeEntry(BYGBiomeList.REDOAKFOREST, ConfigWeightManager.REDOAKFOREST.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.RED_ROCK_MOUNTAINS, ConfigWeightManager.REDROCKMOUNTAINS.getWeight(), OverworldClimate.DESERT);
        addBiomeEntry(BYGBiomeList.REDWOOD_TROPICS, ConfigWeightManager.REDWOOD_TROPICS.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.SEASONALBIRCHFOREST, ConfigWeightManager.SEASONALBIRCHFOREST.getWeight(), OverworldClimate.COOL);
        addBiomeEntry(BYGBiomeList.SEASONALDECIDUOUSFOREST, ConfigWeightManager.SEASONALDECIDUOUSFOREST.getWeight(), OverworldClimate.COOL);
        addBiomeEntry(BYGBiomeList.SEASONALFOREST, ConfigWeightManager.SEASONALFOREST.getWeight(), OverworldClimate.COOL);
        addBiomeEntry(BYGBiomeList.SEASONALTAIGA, ConfigWeightManager.SEASONALTAIGA.getWeight(), OverworldClimate.COOL);
        addBiomeEntry(BYGBiomeList.SHATTEREDGLACIER, ConfigWeightManager.SHATTEREDGLACIER.getWeight(), OverworldClimate.ICY);
        addBiomeEntry(BYGBiomeList.SHRUBLANDS, ConfigWeightManager.SHRUBLANDS.getWeight(), OverworldClimate.DESERT);
        addBiomeEntry(BYGBiomeList.SKYRISHIGHLANDS, ConfigWeightManager.SKYRISHIGHLANDS.getWeight(), OverworldClimate.COOL);
        addBiomeEntry(BYGBiomeList.SNOWYBLUETAIGA, ConfigWeightManager.SNOWYBLUETAIGA.getWeight(), OverworldClimate.ICY);
        addBiomeEntry(BYGBiomeList.SNOWYCONIFEROUSFOREST, ConfigWeightManager.SNOWYCONIFEROUSFOREST.getWeight(), OverworldClimate.ICY);
        addBiomeEntry(BYGBiomeList.SNOWYDECIDUOUSFOREST, ConfigWeightManager.SNOWYDECIDUOUSFOREST.getWeight(), OverworldClimate.ICY);
        addBiomeEntry(BYGBiomeList.SNOWYEVERGREENTAIGA, ConfigWeightManager.SNOWY_EVERGREEN_TAIGA.getWeight(), OverworldClimate.ICY);
//        addBiomeEntry(BYGBiomeList.SONORANDESERT, ConfigWeightManager.amaranthFields.getWeight(), OverworldClimate.WARM);
//        addBiomeEntry(BYGBiomeList.STONEBRUSHLANDS, ConfigWeightManager.amaranthFields.getWeight(), OverworldClimate.WARM);
//        addBiomeEntry(BYGBiomeList.STONEFOREST, ConfigWeightManager.amaranthFields.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.THE_BLACK_FOREST, ConfigWeightManager.THE_BLACK_FOREST.getWeight(), OverworldClimate.COOL);
        addBiomeEntry(BYGBiomeList.TROPICALFUNGALRAINFOREST, ConfigWeightManager.TROPICALFUNGALFOREST.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.TROPICALRAINFOREST, ConfigWeightManager.TROPICALRAINFOREST.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.VIBRANTSWAMPLANDS, ConfigWeightManager.VIBRANTSWAMPLANDS.getWeight(), OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.SIERRAVALLEY, ConfigWeightManager.SIERRAVALLEY.getWeight(), OverworldClimate.DESERT);
        addBiomeEntry(BYGBiomeList.WEEPINGWITCHFOREST, ConfigWeightManager.WEEPING_WITCH_FOREST.getWeight(), OverworldClimate.COOL);
        addBiomeEntry(BYGBiomeList.WOODLANDS, ConfigWeightManager.WOODLANDS.getWeight(), OverworldClimate.WARM);
//        addBiomeEntry(BYGBiomeList.VOLCANO, 1, OverworldClimate.WARM);
        addBiomeEntry(BYGBiomeList.ZELKOVAFOREST, ConfigWeightManager.ZELKOVAFOREST.getWeight(), OverworldClimate.COOL);

        BYG.LOGGER.debug("BYG: Added biome entries with their respective weights!");
    }

    public enum OverworldClimate {
        ICY,
        COOL,
        WARM,
        DESERT
    }

    public static void addBiomeEntry(Biome biome, int weight, OverworldClimate type) {
        if (weight > 0) {
            if (type == OverworldClimate.WARM)
                WARM.add(WorldGenRegistries.field_243657_i.getId(biome));
            if (type == OverworldClimate.COOL)
                COOL.add(WorldGenRegistries.field_243657_i.getId(biome));
            if (type == OverworldClimate.DESERT)
                HOT.add(WorldGenRegistries.field_243657_i.getId(biome));
            if (type == OverworldClimate.ICY)
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
