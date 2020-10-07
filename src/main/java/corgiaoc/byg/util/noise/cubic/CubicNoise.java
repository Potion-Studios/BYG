package corgiaoc.byg.util.noise.cubic;

public class CubicNoise {
    private static final int RND_A = 134775813;
    private static final int RND_B = 1103515245;

    // random seed
    private final int seed;
    // how random it is
    private final int period;

    public CubicNoise(int seed) {
        this.seed = seed;
        this.period = Integer.MAX_VALUE;
    }

    private static double randomize(final int seed, final int x, final int y) {
        return (double) ((((x ^ y) * RND_A) ^ (seed + x)) * (((RND_B * x) << 16) ^ (RND_B * y) - RND_A)) / Integer.MAX_VALUE;
    }

    private static int tile(final int coordinate, final int period) {
        return coordinate % period;
    }

    public static double cerp(final double a, final double b, final double c, final double d, final double x) {
        final double p = (d - c) - (a - b);

        return x * (x * (x * p + ((a - b) - p)) + (c - a)) + b;
    }

    public double sample2D(final double x) {
        final int xi = (int) Math.floor(x);
        final double lerp = x - xi;

        return cerp(
                randomize(seed, tile(xi - 1, this.period), 0),
                randomize(seed, tile(xi, this.period), 0),
                randomize(seed, tile(xi + 1, this.period), 0),
                randomize(seed, tile(xi + 2, this.period), 0),
                lerp) * 0.5f + 0.25f;
    }

    public double sample2D(double x, double y) {
        final int xi = (int) Math.floor(x);
        final double lerpx = x - xi;
        final int yi = (int) Math.floor(y);
        final double lerpy = y - yi;

        double[] xSamples = new double[4];

        for (int i = 0; i < 4; ++i)
            xSamples[i] = cerp(
                    randomize(this.seed, tile(xi - 1, this.period), tile(yi - 1 + i, this.period)),
                    randomize(this.seed, tile(xi, this.period), tile(yi - 1 + i, this.period)),
                    randomize(this.seed, tile(xi + 1, this.period), tile(yi - 1 + i, this.period)),
                    randomize(this.seed, tile(xi + 2, this.period), tile(yi - 1 + i, this.period)),
                    lerpx);

        return cerp(xSamples[0], xSamples[1], xSamples[2], xSamples[3], lerpy) * 0.5f + 0.25f;
    }
}
