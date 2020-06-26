//package voronoiaoc.byg.common.world.worldtype.layers;
//
//import net.minecraft.util.registry.Registry;
//import net.minecraft.world.gen.INoiseRandom;
//import net.minecraft.world.gen.layer.traits.ICastleTransformer;
//import voronoiaoc.byg.common.world.worldtype.ClimateBooleans;
//import voronoiaoc.byg.common.world.worldtype.math.BYGBiomeGroup;
//
//@SuppressWarnings("deprecation")
//public enum OceanIslandsLayer implements ICastleTransformer {
//    INSTANCE;
//
//    static int islandChance = 14;
//
//    @Override
//    public int apply(INoiseRandom rand, int n, int e, int s, int w, int centre) {
//        if (ClimateBooleans.isDeepWarmOcean(centre)) {
//            return (rand.random(islandChance + 2) == 0) ? Registry.BIOME.getId(getTropIslandBiome().pickBiome(rand)) : centre;
//        }
//        if (ClimateBooleans.isDeepFrozenOcean(centre)) {
//            return (rand.random(islandChance + 2) == 0) ? Registry.BIOME.getId(getSnowyIslandBiome().pickBiome(rand)) : centre;
//        }
//        if (ClimateBooleans.isDeepLukeWarmOcean(centre)) {
//            return (rand.random(islandChance + 2) == 0) ? Registry.BIOME.getId(getTemperateIslandBiome().pickBiome(rand)) : centre;
//        }
//        return centre;
//    }
//
//
//    public BYGBiomeGroup getTropIslandBiome() {
//        return BYGBiomeGroup.OCEAN_ISLANDS_TROPICAL;
//    }
//
//    public BYGBiomeGroup getTemperateIslandBiome() {
//        return BYGBiomeGroup.OCEAN_ISLANDS_TEMPERATE;
//    }
//
//    public BYGBiomeGroup getSnowyIslandBiome() {
//        return BYGBiomeGroup.OCEAN_ISLANDS_SNOWY;
//    }
//
//    public BYGBiomeGroup getFrozenOceanBiome() {
//        return BYGBiomeGroup.FROZEN_OCEAN;
//    }
//
//    public BYGBiomeGroup getTemperateOceanBiome() {
//        return BYGBiomeGroup.TEMPERATE_OCEAN;
//    }
//
//    public BYGBiomeGroup getHotOceanBiome() {
//        return BYGBiomeGroup.HOT_OCEAN;
//    }
//}
//
//
