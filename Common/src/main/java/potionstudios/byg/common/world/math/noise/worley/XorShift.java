package potionstudios.byg.common.world.math.noise.worley;

import java.util.Objects;
import java.util.Random;

/**
 * Random number generator for voxel-based fractals based on the XorShift
 * pseudo-random number generator described by George Marsaglia in his paper
 * <i>XorShift RNGs</i> (<a href="http://www.jstatsoft.org/v08/i14/paper"
 * >http://www.jstatsoft.org/v08/i14/paper</a>).
 * This particular implementation has a period of <code>2 ^ 96 - 1</code> and
 * uses Marsaglia's triple of [13, 19, 3]. For use in cellular noise functions,
 * it has a method for resetting the generator state via
 * for <code>x, y, z</code> voxel
 * coordinates, which will wrap on [0, 1024) for each of <code>x, y, z</code>.
 * Objects of <code>XorShift.Instance</code> <i>are not</i> threadsafe.
 * Concurrent access should be externally synchronized or use separate
 * instances. <code>XorShift</code> itself is threadsafe.
 *
 * @author saybur
 */
public class XorShift {
    /**
     * The space for each of x, y, and z in the seeds table.
     */
    private static final int SEED_TABLE_SPACE = 1024;
    /**
     * The final size of the seeds table.
     */
    private static final int SEED_TABLE_SIZE = SEED_TABLE_SPACE * 3;
    static Random random;
    private final long[] seeds;

    private XorShift(Random seed) {
        seeds = new long[SEED_TABLE_SIZE];
        for (int i = 0; i < SEED_TABLE_SIZE; i++) {
            seeds[i] = seed.nextLong();
        }
    }

    /**
     * Creates a new random number generator factory with a random seed value.
     *
     * @return the random number generator factory.
     */
    public static XorShift create() {
        return new XorShift(random);
    }

    /**
     * Creates a new random number generator factory with the given seed value.
     *
     * @param seed the seed value.
     * @return the random number generator factory.
     */
    public static XorShift create(Random seed) {
        return new XorShift(seed);
    }

    public static long fastAbs(long n) {
        long mask = n >> (8 * 8 - 1);
        return ((n + mask) ^ mask);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof XorShift) {
            XorShift o = (XorShift) obj;
            return Objects.equals(seeds, o.seeds);
        } else {
            return false;
        }
    }

    /**
     * Creates a new random number generator instance.
     * Each instance should be used by a single thread only. See the class
     * documentation for information about the generator itself.
     *
     * @return a new random number generator instance.
     */
    public Instance getInstance() {
        return new Instance();
    }

    @Override
    public int hashCode() {
        return Objects.hash(seeds);
    }

    /**
     * Random number generator instance for <code>XorShift</code>. See the class
     * documentation for details.
     * A reminder: this is <i>not</i> threadsafe.
     *
     * @author saybur
     */
    public final class Instance {
        private long x, z;

        private Instance() {
            setSeed(0, 0);
        }

        /**
         * Provides a pseudo-random <code>double</code> value on [0.0, 1.0).
         *
         * @return the next double value.
         */
        public double nextDouble() {
            // get out of signed range, then divide in the remaining space
            // of the shifted long value.  i hope this works...
            return (nextLong() >>> 2) * (1.0 / (1L << 62));
        }

        /**
         * Provides a pseudo-random <code>long</code> value.
         *
         * @return the next <code>long</code> value.
         */
        public long nextLong() {
            long t;
            t = (x ^ (x << 13));
            x = z;
            z = (z ^ (z >>> 3)) ^ (t ^ t >>> 19);
            return z;
        }

        /**
         * Sets the seed for this number generator to the given values.
         * This is for the cellular noise functions and may be ignored by other
         * users, as the constructor will initialize the generator with random
         * starting values.
         *
         * @param x the X component.
         * @param z the Z component.
         */
        public void setSeed(long x, long z) {
            this.x = seeds[(int) (fastAbs(x) % SEED_TABLE_SPACE)];
            this.z = seeds[(int) (fastAbs(z) % SEED_TABLE_SPACE)
                    + SEED_TABLE_SPACE + SEED_TABLE_SPACE];
        }
    }
}