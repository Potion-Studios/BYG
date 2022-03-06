package potionstudios.byg.util.blendingfunction;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import potionstudios.byg.BYG;
import potionstudios.byg.core.BYGRegistry;

import java.util.function.Function;

public interface BlendingFunction {
    Codec<BlendingFunction> CODEC = BYGRegistry.BLENDING_FUNCTION.byNameCodec().dispatchStable(BlendingFunction::codec, Function.identity());

    Codec<? extends BlendingFunction> codec();

    double apply(double factor);

    default double apply(double factor, double min, double max) {
        double range = max - min;
        return min + (range * apply(factor));
    }

    static void bootStrap() {
        Registry.register(BYGRegistry.BLENDING_FUNCTION, BYG.createLocation("ease_in_out_circ"), EaseInOutCirc.CODEC);
        Registry.register(BYGRegistry.BLENDING_FUNCTION, BYG.createLocation("ease_out_bounce"), EaseOutBounce.CODEC);
        Registry.register(BYGRegistry.BLENDING_FUNCTION, BYG.createLocation("ease_out_cubic"), EaseOutCubic.CODEC);
        Registry.register(BYGRegistry.BLENDING_FUNCTION, BYG.createLocation("ease_out_elastic"), EaseOutElastic.CODEC);
        Registry.register(BYGRegistry.BLENDING_FUNCTION, BYG.createLocation("ease_in_circ"), EaseInCirc.CODEC);
        Registry.register(BYGRegistry.BLENDING_FUNCTION, BYG.createLocation("ease_out_quint"), EaseOutQuint.CODEC);
    }

    record EaseInOutCirc() implements BlendingFunction {
        public static final EaseInOutCirc INSTANCE = new EaseInOutCirc();
        public static final Codec<EaseInOutCirc> CODEC = Codec.unit(() -> INSTANCE);

        @Override
        public double apply(double factor) {
            return BlendingFunctions.easeInOutCirc(factor);
        }

        @Override
        public Codec<? extends BlendingFunction> codec() {
            return CODEC;
        }
    }

    record EaseOutCubic() implements BlendingFunction {
        public static final EaseOutCubic INSTANCE = new EaseOutCubic();
        public static final Codec<EaseOutCubic> CODEC = Codec.unit(() -> INSTANCE);

        @Override
        public double apply(double factor) {
            return BlendingFunctions.easeOutCubic(factor);
        }

        @Override
        public Codec<? extends BlendingFunction> codec() {
            return CODEC;
        }

    }

    record EaseOutBounce() implements BlendingFunction {
        public static final EaseOutBounce INSTANCE = new EaseOutBounce();
        public static final Codec<EaseOutBounce> CODEC = Codec.unit(() -> INSTANCE);

        @Override
        public double apply(double factor) {
            return BlendingFunctions.easeOutBounce(factor);
        }

        @Override
        public Codec<? extends BlendingFunction> codec() {
            return CODEC;
        }
    }

    record EaseOutElastic() implements BlendingFunction {
        public static final EaseOutElastic INSTANCE = new EaseOutElastic();
        public static final Codec<EaseOutElastic> CODEC = Codec.unit(() -> INSTANCE);

        @Override
        public double apply(double factor) {
            return BlendingFunctions.easeOutElastic(factor);
        }

        @Override
        public Codec<? extends BlendingFunction> codec() {
            return CODEC;
        }
    }

    record EaseInCirc() implements BlendingFunction {
        public static final EaseInCirc INSTANCE = new EaseInCirc();
        public static final Codec<EaseInCirc> CODEC = Codec.unit(() -> INSTANCE);

        @Override
        public double apply(double factor) {
            return BlendingFunctions.easeInCirc(factor);
        }

        @Override
        public Codec<? extends BlendingFunction> codec() {
            return CODEC;
        }
    }

    record EaseOutQuint() implements BlendingFunction {
        public static final EaseOutQuint INSTANCE = new EaseOutQuint();
        public static final Codec<EaseOutQuint> CODEC = Codec.unit(() -> INSTANCE);

        @Override
        public double apply(double factor) {
            return BlendingFunctions.easeOutQuint(factor);
        }

        @Override
        public Codec<? extends BlendingFunction> codec() {
            return CODEC;
        }
    }
}
