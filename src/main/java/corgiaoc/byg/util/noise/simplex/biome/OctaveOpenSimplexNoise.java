package corgiaoc.byg.util.noise.simplex.biome;

import java.util.Random;

public final class OctaveOpenSimplexNoise {
    protected OpenSimplexNoise[] samplers;
    protected double clamp;
    private double inverseFrequency;

    public OctaveOpenSimplexNoise(Random rand, int octaves, double spread) {
        samplers = new OpenSimplexNoise[octaves];
        clamp = 1D / (1D - (1D / Math.pow(2, octaves)));

        for (int i = 0; i < octaves; ++i) {
            samplers[i] = new OpenSimplexNoise(rand);
        }

        this.setSpread(spread);
    }

    private void setSpread(double stretch) {
        // scale spread up so a visual 1 octave octave-open-simplex sample3D matches that of OpenSimplexNoise
        this.inverseFrequency = stretch * 2;
    }

    public double sample(double x) {
        double amplFreq = 0.5D;
        double result = 0;

        for (OpenSimplexNoise sampler : this.samplers) {
            result += (amplFreq * sampler.sample(x / (amplFreq * this.inverseFrequency)));
            amplFreq *= 0.5D;
        }

        return result * this.clamp;
    }

    public double sample(double x, double y) {
        double amplFreq = 0.5D;
        double result = 0;

        for (OpenSimplexNoise sampler : this.samplers) {
            result += (amplFreq * sampler.sample(x / (amplFreq * this.inverseFrequency), y / (amplFreq * this.inverseFrequency)));
            amplFreq *= 0.5D;
        }
        return result / 2 * this.clamp;
    }
}
