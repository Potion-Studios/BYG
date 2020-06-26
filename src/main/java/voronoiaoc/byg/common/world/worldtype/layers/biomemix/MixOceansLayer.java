//package voronoiaoc.byg.common.world.worldtype.layers.biomemix;
//
//import net.minecraft.util.registry.Registry;
//import net.minecraft.world.gen.INoiseRandom;
//import voronoiaoc.byg.common.world.worldtype.layers.InitLayer;
//import voronoiaoc.byg.common.world.worldtype.math.BiomeGroupManager;
//
//@SuppressWarnings("deprecation")
//public class MixOceansLayer extends InitLayer {
//    public MixOceansLayer(BiomeGroupManager manager) {
//        super(manager);
//    }
//
//    @Override
//    public int apply(INoiseRandom rand, int genX, int genZ) {
//        return Registry.BIOME.getId(this.manager.getCoastalOceanBiome(genX, genZ).pickBiome(rand));
//    }
//}
