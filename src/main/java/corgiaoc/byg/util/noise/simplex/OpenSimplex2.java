package corgiaoc.byg.util.noise.simplex;

/**
 * K.jpg's OpenSimplex2 noise
 */

public class OpenSimplex2 {
    private static final long PRIME_X = 0x5205402B9270C86FL;
    private static final long PRIME_Y = 0x598CD327003817B5L;
    private static final long PRIME_Z = 0x5BCC226E9FA0BACBL;
    private static final long HASH_UNIQUIFIER = 0x53A3F72DEEC546F5L;
    private static final long PAIR_SEED_FLIP_BITS = -0x52D547B2E96ED629L;

    private static final double SKEW2 = 0.366025403784439;
    private static final double UNSKEW2 = -0.21132486540518713;

    private static final double ROOT3OVER3 = 0.577350269189626;
    private static final double ROTATE3_ORTHOGONALIZER = UNSKEW2;

    /*
     * Noise Evaluators
     */

    /**
     * 2D Simplex noise, standard lattice orientation.
     */
    public static float noise2(long seed, double x, double y) {

        // Get points for A2* lattice
        double s = SKEW2 * (x + y);
        double xs = x + s, ys = y + s;

        return noise2_UnskewedBase(seed, xs, ys);
    }

    /**
     * 2D Simplex noise base.
     */
    private static float noise2_UnskewedBase(long seed, double xs, double ys) {
        float value = 0;
        // 2D OpenSimplex2S case is a modified 2D simplex noise.

        int xsb = fastFloor(xs);
        int ysb = fastFloor(ys);
        float xi = (float)(xs - xsb);
        float yi = (float)(ys - ysb);

        long xsbp = xsb * PRIME_X;
        long ysbp = ysb * PRIME_Y;

        float t = (xi + yi) * (float)UNSKEW2;
        float dx0 = xi + t;
        float dy0 = yi + t;

        float a0 = 0.5f - dx0 * dx0 - dy0 * dy0;
        if (a0 > 0) {
            value = (a0 * a0) * (a0 * a0) * grad(seed, xsbp, ysbp, dx0, dy0);
        }

        float a1 = (float)(2 * (1 + 2 * UNSKEW2) * (1 / UNSKEW2 + 2)) * t + ((float)(-2 * (1 + 2 * UNSKEW2) * (1 + 2 * UNSKEW2)) + a0);
        if (a1 > 0) {
            float dx1 = dx0 - (float)(1 + 2 * UNSKEW2);
            float dy1 = dy0 - (float)(1 + 2 * UNSKEW2);
            value += (a1 * a1) * (a1 * a1) * grad(seed, xsbp + PRIME_X, ysbp + PRIME_Y, dx1, dy1);
        }

        if (dy0 > dx0) {
            float dx2 = dx0 - (float)UNSKEW2;
            float dy2 = dy0 - (float)(UNSKEW2 + 1);
            float a2 = 0.5f - dx2 * dx2 - dy2 * dy2;
            if (a2 > 0) {
                value += (a2 * a2) * (a2 * a2) * grad(seed, xsbp, ysbp + PRIME_Y, dx2, dy2);
            }
        } else {
            float dx2 = dx0 - (float)(UNSKEW2 + 1);
            float dy2 = dy0 - (float)UNSKEW2;
            float a2 = 0.5f - dx2 * dx2 - dy2 * dy2;
            if (a2 > 0) {
                value += (a2 * a2) * (a2 * a2) * grad(seed, xsbp + PRIME_X, ysbp, dx2, dy2);
            }
        }

        return value;
    }

    /**
     * 3D OpenSimplex2 noise, with better visual isotropy in (X, Z).
     * Recommended for 3D terrain and time-varied animations.
     * The Y coordinate should always be the "different" coordinate in whatever your use case is.
     * If Y is vertical in world coordinates, call Noise3_ImproveXZ(x, Y, z).
     * If Z is vertical in world coordinates, call Noise3_ImproveXZ(x, Z, y).
     * For a time varied animation, call Noise3_ImproveXZ(x, T, y).
     */
    public static float noise3_ImproveXZ(long seed, double x, double y, double z) {

        // Re-orient the cubic lattices without skewing, so Y points up the main lattice diagonal,
        // and the planes formed by XZ are moved far out of alignment with the cube faces.
        // Orthonormal rotation. Not a skew transform.
        double xz = x + z;
        double s2 = xz * ROTATE3_ORTHOGONALIZER;
        double yy = y * ROOT3OVER3;
        double xr = x + s2 + yy;
        double zr = z + s2 + yy;
        double yr = xz * -ROOT3OVER3 + yy;

        // Evaluate both lattices to form a BCC lattice.
        return noise3_UnrotatedBase(seed, xr, yr, zr);
    }

    /**
     * Generate overlapping cubic lattices for 3D OpenSimplex2 noise.
     */
    private static float noise3_UnrotatedBase(long seed, double xr, double yr, double zr) {
        int xrb = fastRound(xr);
        int yrb = fastRound(yr);
        int zrb = fastRound(zr);
        float xri = (float)(xr - xrb);
        float yri = (float)(yr - yrb);
        float zri = (float)(zr - zrb);

        int xNSign = (int)(-1.0f - xri) | 1;
        int yNSign = (int)(-1.0f - yri) | 1;
        int zNSign = (int)(-1.0f - zri) | 1;

        float ax0 = xNSign * -xri;
        float ay0 = yNSign * -yri;
        float az0 = zNSign * -zri;

        long xrbp = xrb * PRIME_X;
        long yrbp = yrb * PRIME_Y;
        long zrbp = zrb * PRIME_Z;

        float value = 0;
        float a = (0.6f - xri * xri) - (yri * yri + zri * zri);

        for (int l = 0; ; l++) {
            if (a > 0) {
                value += (a * a) * (a * a) * grad(seed, xrbp, yrbp, zrbp, xri, yri, zri);
            }

            if (ax0 >= ay0 && ax0 >= az0) {
                float b = a + ax0 + ax0;
                if (b > 1) {
                    b -= 1;
                    value += (b * b) * (b * b) * grad(seed, xrbp - xNSign * PRIME_X, yrbp, zrbp, xri + xNSign, yri, zri);
                }
            } else if (ay0 > ax0 && ay0 >= az0) {
                float b = a + ay0 + ay0;
                if (b > 1) {
                    b -= 1;
                    value += (b * b) * (b * b) * grad(seed, xrbp, yrbp - yNSign * PRIME_Y, zrbp, xri, yri + yNSign, zri);
                }
            } else {
                float b = a + az0 + az0;
                if (b > 1) {
                    b -= 1;
                    value += (b * b) * (b * b) * grad(seed, xrbp, yrbp, zrbp - zNSign * PRIME_Z, xri, yri, zri + zNSign);
                }
            }

            if (l == 1) break;

            ax0 = 0.5f - ax0;
            ay0 = 0.5f - ay0;
            az0 = 0.5f - az0;

            xri = xNSign * ax0;
            yri = yNSign * ay0;
            zri = zNSign * az0;

            a += (0.75f - ax0) - (ay0 + az0);

            xrbp += (xNSign >> 1) & PRIME_X;
            yrbp += (yNSign >> 1) & PRIME_Y;
            zrbp += (zNSign >> 1) & PRIME_Z;

            xNSign = -xNSign;
            yNSign = -yNSign;
            zNSign = -zNSign;

            seed ^= PAIR_SEED_FLIP_BITS;
        }

        return value;
    }

    /*
     * Utility
     */

    private static float grad(long seed, long xrvp, long yrvp, float dx, float dy) {
        long hash = seed ^ xrvp ^ yrvp;
        hash *= HASH_UNIQUIFIER;
        hash ^= hash >> 56;
        int gi = (int)hash & 0xFE;
        return GRADIENTS_2D[gi | 0] * dx + GRADIENTS_2D[gi | 1] * dy;
    }

    private static float grad(long seed, long xrvp, long yrvp, long zrvp, float dx, float dy, float dz) {
        long hash = (seed ^ xrvp) ^ (yrvp ^ zrvp);
        hash *= HASH_UNIQUIFIER;
        hash ^= hash >> 54;
        int gi = (int)hash & 0x3FC;
        return GRADIENTS_3D[gi | 0] * dx + GRADIENTS_3D[gi | 1] * dy + GRADIENTS_3D[gi | 2] * dz;
    }

    private static int fastFloor(double x) {
        int xi = (int)x;
        return x < xi ? xi - 1 : xi;
    }

    private static int fastRound(double x) {
        return x < 0 ? (int)(x - 0.5) : (int)(x + 0.5);
    }

    /*
     * Lookup Tables & Gradients
     */

    private static final double NORMALIZER2 = 0.01001634121365712;
    private static final double NORMALIZER3 = 0.07969837668935331;

    private static final int N_GRADS_2D = 128;
    private static final int N_GRADS_3D = 256;

    private static float[] GRADIENTS_2D;
    private static float[] GRADIENTS_3D;

    static {

        int[] grad2FillIndices = new int[] { 1, 4, 7, 10, 13, 16, 19, 22 };
        GRADIENTS_2D = new float[N_GRADS_2D * 2];
        float[] grad2 = {
             0.130526192220052f,  0.99144486137381f,
             0.38268343236509f,   0.923879532511287f,
             0.608761429008721f,  0.793353340291235f,
             0.793353340291235f,  0.608761429008721f,
             0.923879532511287f,  0.38268343236509f,
             0.99144486137381f,   0.130526192220051f,
             0.99144486137381f,  -0.130526192220051f,
             0.923879532511287f, -0.38268343236509f,
             0.793353340291235f, -0.60876142900872f,
             0.608761429008721f, -0.793353340291235f,
             0.38268343236509f,  -0.923879532511287f,
             0.130526192220052f, -0.99144486137381f,
            -0.130526192220052f, -0.99144486137381f,
            -0.38268343236509f,  -0.923879532511287f,
            -0.608761429008721f, -0.793353340291235f,
            -0.793353340291235f, -0.608761429008721f,
            -0.923879532511287f, -0.38268343236509f,
            -0.99144486137381f,  -0.130526192220052f,
            -0.99144486137381f,   0.130526192220051f,
            -0.923879532511287f,  0.38268343236509f,
            -0.793353340291235f,  0.608761429008721f,
            -0.608761429008721f,  0.793353340291235f,
            -0.38268343236509f,   0.923879532511287f,
            -0.130526192220052f,  0.99144486137381f
        };
        for (int i = 0; i < grad2.length; i++) {
            grad2[i] = (float)(grad2[i] / NORMALIZER2);
        }
        {
            int i = 0;
            while (i < GRADIENTS_2D.length - grad2.length + 1) {
                for (int j = 0; j < grad2.length; j++) {
                    GRADIENTS_2D[i + j] = grad2[j];
                }
                i += grad2.length;
            }
            for (int f = 0; f < grad2FillIndices.length; f++) {
                int gi = grad2FillIndices[f] * 2;
                GRADIENTS_2D[i | 0] = grad2[gi | 0];
                GRADIENTS_2D[i | 1] = grad2[gi | 1];
                i += 2;
            }
        }

        int[] grad3FillIndices = new int[] { 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 44, 45, 46, 47 };
        GRADIENTS_3D = new float[N_GRADS_3D * 4];
        float[] grad3 = {
            -2.22474487139f,      -2.22474487139f,      -1.0f,                 0.0f,
            -2.22474487139f,      -2.22474487139f,       1.0f,                 0.0f,
            -3.0862664687972017f, -1.1721513422464978f,  0.0f,                 0.0f,
            -1.1721513422464978f, -3.0862664687972017f,  0.0f,                 0.0f,
            -2.22474487139f,      -1.0f,                -2.22474487139f,       0.0f,
            -2.22474487139f,       1.0f,                -2.22474487139f,       0.0f,
            -1.1721513422464978f,  0.0f,                -3.0862664687972017f,  0.0f,
            -3.0862664687972017f,  0.0f,                -1.1721513422464978f,  0.0f,
            -2.22474487139f,      -1.0f,                 2.22474487139f,       0.0f,
            -2.22474487139f,       1.0f,                 2.22474487139f,       0.0f,
            -3.0862664687972017f,  0.0f,                 1.1721513422464978f,  0.0f,
            -1.1721513422464978f,  0.0f,                 3.0862664687972017f,  0.0f,
            -2.22474487139f,       2.22474487139f,      -1.0f,                 0.0f,
            -2.22474487139f,       2.22474487139f,       1.0f,                 0.0f,
            -1.1721513422464978f,  3.0862664687972017f,  0.0f,                 0.0f,
            -3.0862664687972017f,  1.1721513422464978f,  0.0f,                 0.0f,
            -1.0f,                -2.22474487139f,      -2.22474487139f,       0.0f,
             1.0f,                -2.22474487139f,      -2.22474487139f,       0.0f,
             0.0f,                -3.0862664687972017f, -1.1721513422464978f,  0.0f,
             0.0f,                -1.1721513422464978f, -3.0862664687972017f,  0.0f,
            -1.0f,                -2.22474487139f,       2.22474487139f,       0.0f,
             1.0f,                -2.22474487139f,       2.22474487139f,       0.0f,
             0.0f,                -1.1721513422464978f,  3.0862664687972017f,  0.0f,
             0.0f,                -3.0862664687972017f,  1.1721513422464978f,  0.0f,
            -1.0f,                 2.22474487139f,      -2.22474487139f,       0.0f,
             1.0f,                 2.22474487139f,      -2.22474487139f,       0.0f,
             0.0f,                 1.1721513422464978f, -3.0862664687972017f,  0.0f,
             0.0f,                 3.0862664687972017f, -1.1721513422464978f,  0.0f,
            -1.0f,                 2.22474487139f,       2.22474487139f,       0.0f,
             1.0f,                 2.22474487139f,       2.22474487139f,       0.0f,
             0.0f,                 3.0862664687972017f,  1.1721513422464978f,  0.0f,
             0.0f,                 1.1721513422464978f,  3.0862664687972017f,  0.0f,
             2.22474487139f,      -2.22474487139f,      -1.0f,                 0.0f,
             2.22474487139f,      -2.22474487139f,       1.0f,                 0.0f,
             1.1721513422464978f, -3.0862664687972017f,  0.0f,                 0.0f,
             3.0862664687972017f, -1.1721513422464978f,  0.0f,                 0.0f,
             2.22474487139f,      -1.0f,                -2.22474487139f,       0.0f,
             2.22474487139f,       1.0f,                -2.22474487139f,       0.0f,
             3.0862664687972017f,  0.0f,                -1.1721513422464978f,  0.0f,
             1.1721513422464978f,  0.0f,                -3.0862664687972017f,  0.0f,
             2.22474487139f,      -1.0f,                 2.22474487139f,       0.0f,
             2.22474487139f,       1.0f,                 2.22474487139f,       0.0f,
             1.1721513422464978f,  0.0f,                 3.0862664687972017f,  0.0f,
             3.0862664687972017f,  0.0f,                 1.1721513422464978f,  0.0f,
             2.22474487139f,       2.22474487139f,      -1.0f,                 0.0f,
             2.22474487139f,       2.22474487139f,       1.0f,                 0.0f,
             3.0862664687972017f,  1.1721513422464978f,  0.0f,                 0.0f,
             1.1721513422464978f,  3.0862664687972017f,  0.0f,                 0.0f
        };
        for (int i = 0; i < grad3.length; i++) {
            grad3[i] = (float)(grad3[i] / NORMALIZER3);
        }
        {
            int i = 0;
            while (i < GRADIENTS_3D.length - grad3.length + 1) {
                for (int j = 0; j < grad3.length; j++) {
                    GRADIENTS_3D[i + j] = grad3[j];
                }
                i += grad3.length;
            }
            for (int f = 0; f < grad3FillIndices.length; f++) {
                int gi = grad3FillIndices[f] * 4;
                GRADIENTS_3D[i | 0] = grad3[gi | 0];
                GRADIENTS_3D[i | 1] = grad3[gi | 1];
                GRADIENTS_3D[i | 2] = grad3[gi | 2];
                i += 4;
            }
        }
    }

}
