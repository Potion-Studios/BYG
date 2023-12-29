package potionstudios.byg.common.world.math.noise.nodes;

import potionstudios.byg.common.world.math.FloatToFloatFunction;

public record MappedNoise3D(Noise3D noise, FloatToFloatFunction map) implements Noise3D {

    public static Noise3D create(Noise3D noise, FloatToFloatFunction map) {
        return new MappedNoise3D(noise, map);
    }

    public float evaluate(long seed, double x, double y, double z) {
        return map.evaluate(noise.evaluate(seed, x, y, z));
    }

}
