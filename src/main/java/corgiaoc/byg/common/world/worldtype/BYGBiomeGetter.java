//package voronoiaoc.byg.common.world.worldtype;
//
//import net.minecraft.util.registry.Registry;
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.biome.Biomes;
//import net.minecraft.world.gen.INoiseRandom;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.ForgeRegistry;
//import voronoiaoc.byg.core.byglists.BYGBiomes;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@SuppressWarnings("deprecation")
//public class BYGBiomeGetter {
//    //OceanBiomes
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
//    //BeachBiomes
//    public static final int SNOWYROCKYBLACKBEACH = biomeRegistry.getID(BYGBiomes.SNOWYROCKYBLACKBEACH);
//    public static final int WHITEBEACH = biomeRegistry.getID(BYGBiomes.WHITEBEACH);
//    public static final int SNOWYBLACKBEACH = biomeRegistry.getID(BYGBiomes.SNOWYBLACKBEACH);
//    public static final int VANILLABEACH = biomeRegistry.getID(Biomes.BEACH);
//    public static final int RAINBOWBEACH = biomeRegistry.getID(BYGBiomes.RAINBOWBEACH);
//    public static final int ROCKYBEACH = biomeRegistry.getID(BYGBiomes.ROCKYBEACH);
//    public static final int MUSHROOMBEACH = biomeRegistry.getID(Biomes.MUSHROOM_FIELD_SHORE);
//
//
//    public static int[] deepOceanArray = {
//            DEEP_WARM_OCEAN,
//            DEEP_COLD_OCEAN,
//            DEEP_LUKEWARM_OCEAN,
//            DEEP_FROZEN_OCEAN,
//    };
//    public static int[] bygBiomeArray = {
//            ALLIUMFIELDS,
//            ALPS,
//            AMARANTHFIELDS,
//            BLUEGIANTTAIGA,
//            BLUETAIGA,
//            BOREALFOREST,
//            CONIFEROUSFOREST,
//            DECIDUOUSFOREST,
//            DOVERMOUNTAINS,
//            DUNES,
//            GRASSLANDPLATEAU,
//            GUIANASHIELD,
//            JACARANDAFOREST,
//            PRAIRIE,
//            REDDESERT,
//            REDDESERTDUNES,
//            REDOAKFOREST,
//            SEASONALBIRCHFOREST,
//            SEASONALDECIDUOUSFOREST,
//            SEASONALFOREST,
//            SEASONALGIANTTAIGA,
//            SEASONALTAIGA,
//            SHRUBLANDS,
//            SNOWYBLUEGIANTTAIGA,
//            SNOWYBLUETAIGA,
//            SNOWYCONIFEROUSFOREST,
//            TROPICALFUNGALRAINFOREST,
//            TROPICALRAINFOREST
//    };
//    public static int[] bygHotArray = {
//            DUNES,
//            PRAIRIE,
//            REDDESERT,
//            REDDESERTDUNES,
//            SHRUBLANDS,
//    };
//    public static int[] bygTropicalArray = {
//            GUIANASHIELD,
//            TROPICALFUNGALRAINFOREST,
//            TROPICALRAINFOREST
//    };
//    public static int[] bygSnowyArray = {
//            ALPS,
//            SNOWYBLUEGIANTTAIGA,
//            SNOWYBLUETAIGA,
//            SNOWYCONIFEROUSFOREST,
//    };
//    public static int[] bygWarmArray = {
//            ALLIUMFIELDS,
//            AMARANTHFIELDS,
//            CONIFEROUSFOREST,
//            DECIDUOUSFOREST,
//            GRASSLANDPLATEAU,
//            REDOAKFOREST,
//    };
//    public static int[] bygCoolArray = {
//            BLUEGIANTTAIGA,
//            BLUETAIGA,
//            BOREALFOREST,
//            DOVERMOUNTAINS,
//            SEASONALBIRCHFOREST,
//            SEASONALDECIDUOUSFOREST,
//            SEASONALFOREST,
//            SEASONALGIANTTAIGA,
//            SEASONALTAIGA,
//    };
//    public static int[] getDeepOceanArray;
//    public static int[] getBYGBiomeArray;
//    public static int[] getBYGHotArray;
//    public static int[] getBYGTropArray;
//    public static int[] getBYGSnowyArray;
//    public static int[] getBYGWarmArray;
//    public static int[] getBYGCoolArray;
//
//    static {
//        getBYGBiomeArray = new int[bygBiomeArray.length];
//        for (int index = 0; index < bygBiomeArray.length; ++index) {
//            getBYGBiomeArray[index] = bygBiomeArray[index];
//        }
//    }
//
//    static {
//        getBYGHotArray = new int[bygHotArray.length];
//        for (int index = 0; index < bygHotArray.length; ++index) {
//            getBYGHotArray[index] = bygHotArray[index];
//        }
//    }
//
//    static {
//        getBYGTropArray = new int[bygTropicalArray.length];
//        for (int index = 0; index < bygTropicalArray.length; ++index) {
//            getBYGTropArray[index] = bygTropicalArray[index];
//        }
//    }
//
//    static {
//        getBYGSnowyArray = new int[bygSnowyArray.length];
//        for (int index = 0; index < bygSnowyArray.length; ++index) {
//            getBYGSnowyArray[index] = bygSnowyArray[index];
//        }
//    }
//
//    static {
//        getBYGWarmArray = new int[bygWarmArray.length];
//        for (int index = 0; index < bygWarmArray.length; ++index) {
//            getBYGWarmArray[index] = bygWarmArray[index];
//        }
//    }
//
//    static {
//        getDeepOceanArray = new int[deepOceanArray.length];
//        for (int index = 0; index < deepOceanArray.length; ++index) {
//            getDeepOceanArray[index] = deepOceanArray[index];
//        }
//    }
//
//    static {
//        getBYGCoolArray = new int[bygCoolArray.length];
//        for (int index = 0; index < bygCoolArray.length; ++index) {
//            getBYGCoolArray[index] = bygCoolArray[index];
//        }
//    }
//
//    public static Set<Biome> getBiomeSet() {
//        return new HashSet<>(ForgeRegistries.BIOMES.getValues());
//    }
//
//    public static int getBYGBiome(INoiseRandom rand) {
//        return getBYGBiomeArray[rand.random(getBYGBiomeArray.length)];
//    }
//
//    public static int getHotBiome(INoiseRandom rand) {
//        return getBYGHotArray[rand.random(getBYGHotArray.length)];
//    }
//
//    public static int getTropBiome(INoiseRandom rand) {
//        return getBYGTropArray[rand.random(getBYGTropArray.length)];
//    }
//
//    public static int getSnowyBiome(INoiseRandom rand) {
//        return getBYGSnowyArray[rand.random(getBYGSnowyArray.length)];
//    }
//
//    public static int getWarmBiome(INoiseRandom rand) {
//        return getBYGWarmArray[rand.random(getBYGWarmArray.length)];
//    }
//
//    public static int getCoolBiome(INoiseRandom rand) {
//        return getBYGCoolArray[rand.random(getBYGCoolArray.length)];
//    }
//
//    public static int getDeepOcean(INoiseRandom rand) {
//        return getDeepOceanArray[rand.random(deepOceanArray.length)];
//    }
//
//}
//
//
//
//
//
