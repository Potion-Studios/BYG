package potionstudios.byg.common.world.math.noise.nodes;

public record FrequencyScaledNoise3D(Noise3D noise, double xzFrequency, double yFrequency) implements Noise3D {

    public static Noise3D create(Noise3D noise, double xzFrequency, double yFrequency) {
        return new FrequencyScaledNoise3D(noise, xzFrequency, yFrequency);
    }

    public float evaluate(long seed, double x, double y, double z) {
        return noise.evaluate(seed, x * xzFrequency, y * yFrequency, z * xzFrequency);
    }

}
