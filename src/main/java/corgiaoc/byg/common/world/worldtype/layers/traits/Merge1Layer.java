//package voronoiaoc.byg.common.world.worldtype.layers.traits;
//
//import net.minecraft.world.gen.IExtendedNoiseRandom;
//import net.minecraft.world.gen.INoiseRandom;
//import net.minecraft.world.gen.area.IArea;
//import net.minecraft.world.gen.area.IAreaFactory;
//import net.minecraft.world.gen.layer.traits.IDimTransformer;
//
//// Definitely not IAreaTransformer1 with a different noise in Apply.
//public interface Merge1Layer extends IDimTransformer {
//    default <R extends IArea> IAreaFactory<R> apply(IExtendedNoiseRandom<R> context, IAreaFactory<R> areaFactory) {
//        return () -> {
//            R r = areaFactory.make();
//            return context.pickRandom((x, z) -> {
//                context.setPosition(x, z);
//                return this.apply(context, r, x, z);
//            }, r);
//        };
//    }
//
//    int apply(INoiseRandom context, IArea iArea, int x, int z);
//}