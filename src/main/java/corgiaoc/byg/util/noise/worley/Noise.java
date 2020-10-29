package corgiaoc.byg.util.noise.worley;

import java.util.Random;

public abstract class Noise {

    private static final int CHAR_BIT = 8;
    //Helper noise functions =======================
    private static final int SIZE_INT = 8;

    public Noise(Random seed) {
    }

    //Helper noise functions =======================

    /**
     * A bit hack that computes a rough estimation of a square root for the given number
     * Don't use this in places that need accuracy-- You'll regret it!
     *
     * @param d the input for the fastSqrt algorithm
     * @return a **rough** approximation of square root
     */
    public static double fastSqrt(double d) {
        return Double.longBitsToDouble(((Double.doubleToLongBits(d) - (1L << 52)) >> 1) + (1L << 61));
    }

    /**
     * A fast implementation of Math.abs() that avoids branching
     *
     * @param n the number to get the absolute value of
     * @return the absolute value
     */
    public static int fastAbs(int n) {
        int mask = n >> (SIZE_INT * CHAR_BIT - 1);
        return ((n + mask) ^ mask);
    }

    public static long fastAbs(long n) {
        long mask = n >> (SIZE_INT * CHAR_BIT - 1);
        return ((n + mask) ^ mask);
    }

    protected static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    protected static double lerp(double progress, double start, double end) {
        return start + progress * (end - start);
    }

    protected static double sigmoid(double x) {
        return (1 / (1 + Math.exp(-x)));
    }

    public abstract double sample2D(double x, double z);

    public abstract double sample3D(double x, double y, double z);

    //ensures that the returned value is in [-1, 1]
    protected double clamp(double value) {
        return (value > 1) ? 1 : (value < -1) ? -1 : value;
    }

    //ensures that the returned value is in [0, 1]
    protected double clampPositive(double value) {
        return (value < 0) ? 0 : value;
    }
}