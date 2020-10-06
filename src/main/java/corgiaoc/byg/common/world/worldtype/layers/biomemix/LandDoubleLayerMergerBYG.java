//package voronoiaoc.byg.common.world.worldtype.layers.biomemix;
//
//import net.minecraft.world.gen.IExtendedNoiseRandom;
//import net.minecraft.world.gen.area.IArea;
//import net.minecraft.world.gen.layer.traits.IDimOffset1Transformer;
//import voronoiaoc.byg.common.world.worldtype.layers.traits.mergelayerswmanager.InitMerge2;
//import voronoiaoc.byg.common.world.worldtype.math.BiomeGroupManager;
//
//@SuppressWarnings("deprecation")
//public class LandDoubleLayerMergerBYG extends InitMerge2 implements IDimOffset1Transformer {
//    public LandDoubleLayerMergerBYG(BiomeGroupManager manager) {
//        super(manager);
//    }
//
//    @Override
//    public int apply(IExtendedNoiseRandom<?> rand, IArea masterInitLayer, IArea biomeMix, int x, int z) {
//        int landCheck = masterInitLayer.getValue(x, z);
//        int biomeMixValue = biomeMix.getValue(x, z);
//
//        return (landCheck) == 1 ? biomeMixValue : landCheck;
//    }
//}