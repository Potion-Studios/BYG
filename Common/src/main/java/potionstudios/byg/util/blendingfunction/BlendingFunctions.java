package potionstudios.byg.util.blendingfunction;

import static java.lang.Math.*;

public class BlendingFunctions {

    public static double easeInOutCirc(double x) {
        return x < 0.5
            ? (1 - sqrt(1 - pow(2 * x, 2))) / 2
            : (sqrt(1 - pow(-2 * x + 2, 2)) + 1) / 2;

    }

    public static double easeOutCubic(double x) {
        return 1 - pow(1 - x, 3);
    }

    public static double easeOutBounce(double x) {
        double n1 = 7.5625;
        double d1 = 2.75;

        if (x < 1 / d1) {
            return n1 * x * x;
        } else if (x < 2 / d1) {
            return n1 * (x -= 1.5 / d1) * x + 0.75;
        } else if (x < 2.5 / d1) {
            return n1 * (x -= 2.25 / d1) * x + 0.9375;
        } else {
            return n1 * (x -= 2.625 / d1) * x + 0.984375;
        }
    }

    public static double easeOutElastic(double x) {
        double c4 = (2 * Math.PI) / 3;

        return x == 0
            ? 0
            : x == 1
            ? 1
            : pow(2, -10 * x) * sin((x * 10 - 0.75) * c4) + 1;

    }

    public static double easeInCirc(double x) {
        return 1 - sqrt(1 - pow(x, 2));
    }

    public static double easeOutQuint(double x) {
        return 1 - pow(1 - x, 5);
    }
}
