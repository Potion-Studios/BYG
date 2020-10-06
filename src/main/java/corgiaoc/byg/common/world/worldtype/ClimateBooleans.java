//package voronoiaoc.byg.common.world.worldtype;
//
//import net.minecraft.util.registry.Registry;
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.biome.Biomes;
//import net.minecraft.world.gen.INoiseRandom;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.ForgeRegistry;
//import voronoiaoc.byg.common.world.worldtype.math.BYGBiomeGroup;
//import voronoiaoc.byg.core.byglists.BYGBiomes;
//
//public class ClimateBooleans {
//    public static final int WARM_OCEAN = Registry.BIOME.getOrThrowId(Biomes.WARM_OCEAN);
//    public static final int LUKEWARM_OCEAN = Registry.BIOME.getOrThrowId(Biomes.LUKEWARM_OCEAN);
//    public static final int OCEAN = Registry.BIOME.getOrThrowId(Biomes.OCEAN);
//    public static final int COLD_OCEAN = Registry.BIOME.getOrThrowId(Biomes.COLD_OCEAN);
//    public static final int FROZEN_OCEAN = Registry.BIOME.getOrThrowId(Biomes.FROZEN_OCEAN);
//    public static final int DEEP_WARM_OCEAN = Registry.BIOME.getOrThrowId(Biomes.DEEP_WARM_OCEAN);
//    public static final int DEEP_LUKEWARM_OCEAN = Registry.BIOME.getOrThrowId(Biomes.DEEP_LUKEWARM_OCEAN);
//    public static final int DEEP_OCEAN = Registry.BIOME.getOrThrowId(Biomes.DEEP_OCEAN);
//    public static final int DEEP_COLD_OCEAN = Registry.BIOME.getOrThrowId(Biomes.DEEP_COLD_OCEAN);
//    public static final int DEEP_FROZEN_OCEAN = Registry.BIOME.getOrThrowId(Biomes.DEEP_FROZEN_OCEAN);
//    public static ForgeRegistry<Biome> biomeRegistry = ((ForgeRegistry<Biome>) ForgeRegistries.BIOMES);
//    //BYG
//    public static final int ALLIUMFIELDS = biomeRegistry.getID(BYGBiomes.ALLIUMFIELDS);
//    public static final int ALPS = biomeRegistry.getID(BYGBiomes.ALPS);
//    public static final int AMARANTHFIELDS = biomeRegistry.getID(BYGBiomes.AMARANTHFIELDS);
//    public static final int BLUEGIANTTAIGA = biomeRegistry.getID(BYGBiomes.BLUEGIANTTAIGA);
//    public static final int BLUETAIGA = biomeRegistry.getID(BYGBiomes.BLUETAIGA);
//    public static final int BOREALFOREST = biomeRegistry.getID(BYGBiomes.BOREALFOREST);
//    public static final int CONIFEROUSFOREST = biomeRegistry.getID(BYGBiomes.CONIFEROUSFOREST);
//    public static final int DECIDUOUSFOREST = biomeRegistry.getID(BYGBiomes.DECIDUOUSFOREST);
//    public static final int DOVERMOUNTAINS = biomeRegistry.getID(BYGBiomes.DOVERMOUNTAINS);
//    public static final int DUNES = biomeRegistry.getID(BYGBiomes.DUNES);
//    public static final int GRASSLANDPLATEAU = biomeRegistry.getID(BYGBiomes.GRASSLANDPLATEAU);
//    public static final int GUIANASHIELD = biomeRegistry.getID(BYGBiomes.GUIANASHIELD);
//    public static final int JACARANDAFOREST = biomeRegistry.getID(BYGBiomes.JACARANDAFOREST);
//    public static final int PRAIRIE = biomeRegistry.getID(BYGBiomes.PRAIRIE);
//    public static final int REDDESERT = biomeRegistry.getID(BYGBiomes.REDDESERT);
//    public static final int REDDESERTDUNES = biomeRegistry.getID(BYGBiomes.REDDESERTDUNES);
//    public static final int REDOAKFOREST = biomeRegistry.getID(BYGBiomes.REDOAKFOREST);
//    public static final int SEASONALBIRCHFOREST = biomeRegistry.getID(BYGBiomes.SEASONALBIRCHFOREST);
//    public static final int SEASONALDECIDUOUSFOREST = biomeRegistry.getID(BYGBiomes.SEASONALDECIDUOUSFOREST);
//    public static final int SEASONALFOREST = biomeRegistry.getID(BYGBiomes.SEASONALFOREST);
//    public static final int SEASONALGIANTTAIGA = biomeRegistry.getID(BYGBiomes.SEASONALGIANTTAIGA);
//    public static final int SEASONALTAIGA = biomeRegistry.getID(BYGBiomes.SEASONALTAIGA);
//    public static final int SHRUBLANDS = biomeRegistry.getID(BYGBiomes.SHRUBLANDS);
//    public static final int SNOWYBLUEGIANTTAIGA = biomeRegistry.getID(BYGBiomes.SNOWYBLUEGIANTTAIGA);
//    public static final int SNOWYBLUETAIGA = biomeRegistry.getID(BYGBiomes.SNOWYBLUETAIGA);
//    public static final int SNOWYCONIFEROUSFOREST = biomeRegistry.getID(BYGBiomes.SNOWYCONIFEROUSFOREST);
//    public static final int TROPICALFUNGALRAINFOREST = biomeRegistry.getID(BYGBiomes.TROPICALFUNGALRAINFOREST);
//    public static final int TROPICALRAINFOREST = biomeRegistry.getID(BYGBiomes.TROPICALRAINFOREST);
//    public static final int CRAGGARDENS = biomeRegistry.getID(BYGBiomes.CRAGGARDENS);
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
//        return biome == Registry.BIOME.getOrThrowId(getTropIslandBiome().pickBiome(random)) || biome == Registry.BIOME.getOrThrowId(getTemperateIslandBiome().pickBiome(random)) || biome == Registry.BIOME.getOrThrowId(getSnowyIslandBiome().pickBiome(random));
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
