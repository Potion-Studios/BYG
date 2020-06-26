//package voronoiaoc.byg.common.world.worldtype;
//
//import net.minecraft.util.registry.Registry;
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.biome.Biomes;
//import net.minecraft.world.gen.INoiseRandom;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.ForgeRegistry;
//import voronoiaoc.byg.common.world.worldtype.math.BYGBiomeGroup;
//import voronoiaoc.byg.core.byglists.BYGBiomeList;
//
//public class ClimateBooleans {
//    public static final int WARM_OCEAN = Registry.BIOME.getId(Biomes.WARM_OCEAN);
//    public static final int LUKEWARM_OCEAN = Registry.BIOME.getId(Biomes.LUKEWARM_OCEAN);
//    public static final int OCEAN = Registry.BIOME.getId(Biomes.OCEAN);
//    public static final int COLD_OCEAN = Registry.BIOME.getId(Biomes.COLD_OCEAN);
//    public static final int FROZEN_OCEAN = Registry.BIOME.getId(Biomes.FROZEN_OCEAN);
//    public static final int DEEP_WARM_OCEAN = Registry.BIOME.getId(Biomes.DEEP_WARM_OCEAN);
//    public static final int DEEP_LUKEWARM_OCEAN = Registry.BIOME.getId(Biomes.DEEP_LUKEWARM_OCEAN);
//    public static final int DEEP_OCEAN = Registry.BIOME.getId(Biomes.DEEP_OCEAN);
//    public static final int DEEP_COLD_OCEAN = Registry.BIOME.getId(Biomes.DEEP_COLD_OCEAN);
//    public static final int DEEP_FROZEN_OCEAN = Registry.BIOME.getId(Biomes.DEEP_FROZEN_OCEAN);
//    public static ForgeRegistry<Biome> biomeRegistry = ((ForgeRegistry<Biome>) ForgeRegistries.BIOMES);
//    //BYG
//    public static final int ALLIUMFIELDS = biomeRegistry.getID(BYGBiomeList.ALLIUMFIELDS);
//    public static final int ALPS = biomeRegistry.getID(BYGBiomeList.ALPS);
//    public static final int AMARANTHFIELDS = biomeRegistry.getID(BYGBiomeList.AMARANTHFIELDS);
//    public static final int BLUEGIANTTAIGA = biomeRegistry.getID(BYGBiomeList.BLUEGIANTTAIGA);
//    public static final int BLUETAIGA = biomeRegistry.getID(BYGBiomeList.BLUETAIGA);
//    public static final int BOREALFOREST = biomeRegistry.getID(BYGBiomeList.BOREALFOREST);
//    public static final int CONIFEROUSFOREST = biomeRegistry.getID(BYGBiomeList.CONIFEROUSFOREST);
//    public static final int DECIDUOUSFOREST = biomeRegistry.getID(BYGBiomeList.DECIDUOUSFOREST);
//    public static final int DOVERMOUNTAINS = biomeRegistry.getID(BYGBiomeList.DOVERMOUNTAINS);
//    public static final int DUNES = biomeRegistry.getID(BYGBiomeList.DUNES);
//    public static final int GRASSLANDPLATEAU = biomeRegistry.getID(BYGBiomeList.GRASSLANDPLATEAU);
//    public static final int GUIANASHIELD = biomeRegistry.getID(BYGBiomeList.GUIANASHIELD);
//    public static final int JACARANDAFOREST = biomeRegistry.getID(BYGBiomeList.JACARANDAFOREST);
//    public static final int PRAIRIE = biomeRegistry.getID(BYGBiomeList.PRAIRIE);
//    public static final int REDDESERT = biomeRegistry.getID(BYGBiomeList.REDDESERT);
//    public static final int REDDESERTDUNES = biomeRegistry.getID(BYGBiomeList.REDDESERTDUNES);
//    public static final int REDOAKFOREST = biomeRegistry.getID(BYGBiomeList.REDOAKFOREST);
//    public static final int SEASONALBIRCHFOREST = biomeRegistry.getID(BYGBiomeList.SEASONALBIRCHFOREST);
//    public static final int SEASONALDECIDUOUSFOREST = biomeRegistry.getID(BYGBiomeList.SEASONALDECIDUOUSFOREST);
//    public static final int SEASONALFOREST = biomeRegistry.getID(BYGBiomeList.SEASONALFOREST);
//    public static final int SEASONALGIANTTAIGA = biomeRegistry.getID(BYGBiomeList.SEASONALGIANTTAIGA);
//    public static final int SEASONALTAIGA = biomeRegistry.getID(BYGBiomeList.SEASONALTAIGA);
//    public static final int SHRUBLANDS = biomeRegistry.getID(BYGBiomeList.SHRUBLANDS);
//    public static final int SNOWYBLUEGIANTTAIGA = biomeRegistry.getID(BYGBiomeList.SNOWYBLUEGIANTTAIGA);
//    public static final int SNOWYBLUETAIGA = biomeRegistry.getID(BYGBiomeList.SNOWYBLUETAIGA);
//    public static final int SNOWYCONIFEROUSFOREST = biomeRegistry.getID(BYGBiomeList.SNOWYCONIFEROUSFOREST);
//    public static final int TROPICALFUNGALRAINFOREST = biomeRegistry.getID(BYGBiomeList.TROPICALFUNGALRAINFOREST);
//    public static final int TROPICALRAINFOREST = biomeRegistry.getID(BYGBiomeList.TROPICALRAINFOREST);
//    public static final int CRAGGARDENS = biomeRegistry.getID(BYGBiomeList.CRAGGARDENS);
//
//    public static boolean isBaseBiome(int biome) {
//        return biome == ALLIUMFIELDS || biome == AMARANTHFIELDS || biome == BLUEGIANTTAIGA || biome == BLUETAIGA || biome == BOREALFOREST || biome == CONIFEROUSFOREST || biome == DECIDUOUSFOREST || biome == DOVERMOUNTAINS || biome == GRASSLANDPLATEAU || biome == REDOAKFOREST || biome == SEASONALBIRCHFOREST || biome == SEASONALDECIDUOUSFOREST || biome == SEASONALFOREST || biome == SEASONALGIANTTAIGA || biome == SEASONALTAIGA;
//    }
//
//    public static boolean isOcean(int biome) {
//        return biome == WARM_OCEAN || biome == LUKEWARM_OCEAN || biome == OCEAN || biome == COLD_OCEAN || biome == FROZEN_OCEAN || biome == DEEP_WARM_OCEAN || biome == DEEP_LUKEWARM_OCEAN || biome == DEEP_OCEAN || biome == DEEP_COLD_OCEAN || biome == DEEP_FROZEN_OCEAN;
//    }
//
//    public static boolean isDeepOcean(int biome) {
//        return biome == DEEP_WARM_OCEAN || biome == DEEP_LUKEWARM_OCEAN || biome == DEEP_OCEAN || biome == DEEP_COLD_OCEAN || biome == DEEP_FROZEN_OCEAN;
//    }
//
//    public static boolean isShallowOcean(int biome) {
//        return biome == WARM_OCEAN || biome == LUKEWARM_OCEAN || biome == OCEAN || biome == COLD_OCEAN || biome == FROZEN_OCEAN;
//    }
//
//    public static boolean isTropical(int biome) {
//        return biome == TROPICALFUNGALRAINFOREST || biome == TROPICALRAINFOREST || biome == GUIANASHIELD;
//    }
//
//    public static boolean isSnowyFrozenBiome(int biome) {
//        return biome == SNOWYBLUEGIANTTAIGA || biome == SNOWYBLUETAIGA || biome == SNOWYCONIFEROUSFOREST || biome == ALPS;
//    }
//
//    public static boolean isHot(int biome) {
//        return biome == DUNES || biome == REDDESERTDUNES || biome == REDDESERT || biome == SHRUBLANDS || biome == PRAIRIE;
//    }
//
//    public static boolean isPlains(int biome) {
//        return biome == ALLIUMFIELDS || biome == AMARANTHFIELDS || biome == PRAIRIE;
//    }
//
//    public static boolean isAlps(int biome) {
//        return biome == ALPS;
//    }
//
//    public static boolean isTropicalMountain(int biome) {
//        return biome == GUIANASHIELD;
//    }
//
//    public static boolean isColdOcean(int biome) {
//        return biome == COLD_OCEAN || biome == DEEP_COLD_OCEAN;
//    }
//
//    public static boolean isWarmOcean(int biome) {
//        return biome == WARM_OCEAN;
//    }
//
//    public static boolean isLukeWarmOcean(int biome) {
//        return biome == LUKEWARM_OCEAN || biome == DEEP_LUKEWARM_OCEAN;
//    }
//
//    public static boolean isFrozenOcean(int biome) {
//        return biome == FROZEN_OCEAN || biome == DEEP_FROZEN_OCEAN;
//    }
//
//    public static boolean isBaseOcean(int biome) {
//        return biome == OCEAN || biome == DEEP_OCEAN;
//    }
//
//    public static boolean isDeepWarmOcean(int biome) {
//        return biome == DEEP_WARM_OCEAN;
//    }
//
//    public static boolean isDeepLukeWarmOcean(int biome) {
//        return biome == DEEP_LUKEWARM_OCEAN;
//    }
//
//    public static boolean isDeepFrozenOcean(int biome) {
//        return biome == DEEP_FROZEN_OCEAN;
//    }
//
//    public static boolean isDeepBaseOcean(int biome) {
//        return biome == DEEP_OCEAN;
//    }
//
//    public static boolean isIslandBiome(int biome, INoiseRandom random) {
//        return biome == Registry.BIOME.getId(getTropIslandBiome().pickBiome(random)) || biome == Registry.BIOME.getId(getTemperateIslandBiome().pickBiome(random)) || biome == Registry.BIOME.getId(getSnowyIslandBiome().pickBiome(random));
//    }
//
//    public static BYGBiomeGroup getTropIslandBiome() {
//        return BYGBiomeGroup.OCEAN_ISLANDS_TROPICAL;
//    }
//
//    public static BYGBiomeGroup getTemperateIslandBiome() {
//        return BYGBiomeGroup.OCEAN_ISLANDS_TEMPERATE;
//    }
//
//    public static BYGBiomeGroup getSnowyIslandBiome() {
//        return BYGBiomeGroup.OCEAN_ISLANDS_SNOWY;
//    }
//}
