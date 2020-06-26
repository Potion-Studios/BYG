//package voronoiaoc.byg.common.world.worldtype.layers;
//
//import net.minecraft.util.registry.Registry;
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.biome.Biomes;
//import net.minecraft.world.gen.INoiseRandom;
//import net.minecraft.world.gen.area.IArea;
//import net.minecraft.world.gen.layer.LayerUtil;
//import net.minecraft.world.gen.layer.traits.IDimOffset1Transformer;
//import voronoiaoc.byg.common.world.worldtype.layers.traits.mergelayerswmanager.InitMerge1;
//import voronoiaoc.byg.common.world.worldtype.math.BYGBiomeGroup;
//import voronoiaoc.byg.common.world.worldtype.math.BiomeGroupManager;
//
//@SuppressWarnings("deprecation")
//public class BYGAddHillsLayer extends InitMerge1 implements IDimOffset1Transformer {
//
//    public static final int DEEP_WARM_OCEAN = Registry.BIOME.getId(Biomes.DEEP_WARM_OCEAN);
//    public static final int DEEP_LUKEWARM_OCEAN = Registry.BIOME.getId(Biomes.DEEP_LUKEWARM_OCEAN);
//    public static final int DEEP_FROZEN_OCEAN = Registry.BIOME.getId(Biomes.DEEP_FROZEN_OCEAN);
//
//    public BYGAddHillsLayer(BiomeGroupManager manager) {
//        super(manager);
//    }
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
//    static int hillChance = 3;
//
//
//    @Override
//    public int apply(INoiseRandom context, IArea iArea, int x, int z) {
//        int area1Value = iArea.getValue(this.getOffsetX(x + 1), this.getOffsetZ(z + 1));
//
//        if (context.random(hillChance) == 0) {
//            int l = area1Value;
//            Biome biome = Registry.BIOME.getByValue(area1Value);
//            Biome hill = biome == null ? null : biome.getHill(context);
//            if (hill != null) l = Registry.BIOME.getId(hill);
//
//            if (l != area1Value) {
//                int i1 = 0;
//                if (LayerUtil.areBiomesSimilar(iArea.getValue(this.getOffsetX(x + 1), this.getOffsetZ(z)), area1Value)) {
//                    ++i1;
//                }
//
//                if (LayerUtil.areBiomesSimilar(iArea.getValue(this.getOffsetX(x + 2), this.getOffsetZ(z + 1)), area1Value)) {
//                    ++i1;
//                }
//
//                if (LayerUtil.areBiomesSimilar(iArea.getValue(this.getOffsetX(x + 0), this.getOffsetZ(z + 1)), area1Value)) {
//                    ++i1;
//                }
//
//                if (LayerUtil.areBiomesSimilar(iArea.getValue(this.getOffsetX(x + 1), this.getOffsetZ(z + 2)), area1Value)) {
//                    ++i1;
//                }
//
//                if (i1 >= 3) {
//                    return l;
//                }
//            }
//        }
//        return area1Value;
//    }
//}
