package potionstudios.byg.common.world.math.noise.nodes;

public record NoiseFractal3D(Noise3D noise, int octaveCount, float persistence, double lacunarity, float baseAmplitude) implements Noise3D {

    private static final long SEED_DELTA_PRIME = 0x7AF6CE9B7C8371BFL;

    public static Noise3D create(Noise3D noise, int octaveCount, float persistence, double lacunarity, float baseAmplitude, boolean rescaleAmplitude) {
        return new NoiseFractal3D(noise, octaveCount, persistence, lacunarity,
                rescaleAmplitude ? computeRescaledAmplitude(octaveCount, persistence, baseAmplitude) : baseAmplitude);
    }

    public static Noise3D create(Noise3D noise, int octaveCount, float baseAmplitude, boolean rescaleAmplitude) {
        return create(noise, octaveCount, 0.5f, 2.0, baseAmplitude, rescaleAmplitude);
    }

    private static float computeRescaledAmplitude(int octaveCount, float persistence, float baseAmplitude) {
        double totalAmplitude = 0;
        double currentAmplitude = 1;
        for (int i = 0; i < octaveCount; i++) {
            totalAmplitude += currentAmplitude;
            currentAmplitude *= persistence;
        }
        return (float)(baseAmplitude / totalAmplitude);
    }

    public float evaluate(long seed, double x, double y, double z) {
        float value = 0;
        float amplitude = baseAmplitude;
        for (int i = 0; i < octaveCount; i++) {
            value += noise.evaluate(seed, x, y, z) * amplitude;
            x *= lacunarity;
            y *= lacunarity;
            z *= lacunarity;
            amplitude *= persistence;
            seed += SEED_DELTA_PRIME;
        }
        return value;
    }

}
