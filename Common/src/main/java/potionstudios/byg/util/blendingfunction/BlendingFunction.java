package potionstudios.byg.util.blendingfunction;

import com.mojang.serialization.Codec;
import potionstudios.byg.BYG;
import potionstudios.byg.core.BYGRegistry;
import potionstudios.byg.registration.RegistrationProvider;

import java.util.function.Function;

public interface BlendingFunction {
    Codec<BlendingFunction> CODEC = BYGRegistry.BLENDING_FUNCTION.byNameCodec().dispatchStable(BlendingFunction::codec, Function.identity());
    RegistrationProvider<Codec<? extends BlendingFunction>> PROVIDER = RegistrationProvider.get(BYGRegistry.BLENDING_FUNCTION, BYG.MOD_ID);

    Codec<? extends BlendingFunction> codec();

    double apply(double factor);

    default double apply(double factor, double min, double max) {
        double range = max - min;
        return min + (range * apply(factor));
    }

    static void register() {
        register("ease_in_out_circ", EaseInOutCirc.CODEC);
        register("ease_out_bounce", EaseOutBounce.CODEC);
        register("ease_out_cubic", EaseOutCubic.CODEC);
        register("ease_out_elastic", EaseOutElastic.CODEC);
        register("ease_in_circ", EaseInCirc.CODEC);
        register("ease_out_quint", EaseOutQuint.CODEC);
    }

    private static void register(String name, Codec<? extends BlendingFunction> function) {
        PROVIDER.register(name, () -> function);
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
