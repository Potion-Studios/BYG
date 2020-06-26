//package voronoiaoc.byg.common.world.worldtype.layers;
//
//import net.minecraft.world.gen.INoiseRandom;
//import net.minecraft.world.gen.layer.traits.ICastleTransformer;
//import voronoiaoc.byg.common.world.worldtype.ClimateBooleans;
//
//public enum BYGAddDeepOceanLayer implements ICastleTransformer {
//    INSTANCE;
//
//    public int apply(INoiseRandom context, int n, int w, int s, int e, int c) {
//        if (ClimateBooleans.isShallowOcean(c)) {
//            if (ClimateBooleans.isOcean(n) || ClimateBooleans.isOcean(w) || ClimateBooleans.isOcean(s) || ClimateBooleans.isOcean(e)) {
//                int i = 0;
//                if (ClimateBooleans.isShallowOcean(n)) {
//                    ++i;
//                }
//
//                if (ClimateBooleans.isShallowOcean(w)) {
//                    ++i;
//                }
//
//                if (ClimateBooleans.isShallowOcean(e)) {
//                    ++i;
//                }
//
//                if (ClimateBooleans.isShallowOcean(s)) {
//                    ++i;
//                }
//                if (i > 2) {
//                    if (c == ClimateBooleans.WARM_OCEAN) {
//                        return ClimateBooleans.DEEP_WARM_OCEAN;
//                    }
//
//                    if (c == ClimateBooleans.LUKEWARM_OCEAN) {
//                        return ClimateBooleans.DEEP_LUKEWARM_OCEAN;
//                    }
//
//                    if (c == ClimateBooleans.OCEAN) {
//                        return ClimateBooleans.DEEP_OCEAN;
//                    }
//
//                    if (c == ClimateBooleans.COLD_OCEAN) {
//                        return ClimateBooleans.DEEP_COLD_OCEAN;
//                    }
//
//                    if (c == ClimateBooleans.FROZEN_OCEAN) {
//                        return ClimateBooleans.DEEP_FROZEN_OCEAN;
//                    }
//
//                    return ClimateBooleans.DEEP_OCEAN;
//                }
//            }
//        }
//        return c;
//    }
//}