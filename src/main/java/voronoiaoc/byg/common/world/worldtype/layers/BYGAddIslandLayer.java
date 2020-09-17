//package voronoiaoc.byg.common.world.worldtype.layers;
//
//import net.minecraft.util.registry.Registry;
//import net.minecraft.world.biome.Biomes;
//import net.minecraft.world.gen.INoiseRandom;
//import net.minecraft.world.gen.area.IArea;
//import net.minecraft.world.gen.layer.LayerUtil;
//import net.minecraft.world.gen.layer.traits.IDimOffset1Transformer;
//import voronoiaoc.byg.common.world.worldtype.ClimateBooleans;
//import voronoiaoc.byg.common.world.worldtype.layers.traits.Merge1Layer;
//import voronoiaoc.byg.common.world.worldtype.math.BYGBiomeGroup;
//
//@SuppressWarnings("deprecation")
//public enum BYGAddIslandLayer implements Merge1Layer, IDimOffset1Transformer {
//    INSTANCE;
//
//    public static final int DEEP_WARM_OCEAN = Registry.BIOME.getOrThrowId(Biomes.DEEP_WARM_OCEAN);
//    public static final int DEEP_LUKEWARM_OCEAN = Registry.BIOME.getOrThrowId(Biomes.DEEP_LUKEWARM_OCEAN);
//    public static final int DEEP_FROZEN_OCEAN = Registry.BIOME.getOrThrowId(Biomes.DEEP_FROZEN_OCEAN);
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
//    static int islandChance = 25;
//
//
//    @Override
//    public int apply(INoiseRandom context, IArea iArea, int x, int z) {
//        int area1Value = iArea.getValue(this.getXOffset(x + 1), this.getZOffset(z + 1));
//
//        if (context.random(islandChance + 2) == 0) {
//            int l = area1Value;
//            if (!ClimateBooleans.isShallowOcean(area1Value + 1) || !ClimateBooleans.isShallowOcean(area1Value - 1)) {
//                if (area1Value == DEEP_WARM_OCEAN) {
//                    l = Registry.BIOME.getOrThrowId(getTropIslandBiome().pickBiome(context));
//                } else if (area1Value == DEEP_FROZEN_OCEAN) {
//                    l = Registry.BIOME.getOrThrowId(getSnowyIslandBiome().pickBiome(context));
//                } else if (area1Value == DEEP_LUKEWARM_OCEAN) {
//                    l = Registry.BIOME.getOrThrowId(getTemperateIslandBiome().pickBiome(context));
//                }
//
//                if (l != area1Value) {
//                    int i1 = 0;
//                    if (LayerUtil.areBiomesSimilar(iArea.getValue(this.getXOffset(x + 1), this.getZOffset(z)), area1Value)) {
//                        ++i1;
//                    }
//
//                    if (LayerUtil.areBiomesSimilar(iArea.getValue(this.getXOffset(x + 2), this.getZOffset(z + 1)), area1Value)) {
//                        ++i1;
//                    }
//
//                    if (LayerUtil.areBiomesSimilar(iArea.getValue(this.getXOffset(x + 0), this.getZOffset(z + 1)), area1Value)) {
//                        ++i1;
//                    }
//
//                    if (LayerUtil.areBiomesSimilar(iArea.getValue(this.getXOffset(x + 1), this.getZOffset(z + 2)), area1Value)) {
//                        ++i1;
//                    }
//
//                    if (i1 >= 3) {
//                        return l;
//                    }
//                }
//            }
//        }
//        return area1Value;
//    }
//}
