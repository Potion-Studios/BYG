package corgiaoc.byg.util;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

import java.util.Random;
//Credits to BetterEnd & Pauelevs
 public class ModMathHelper
{
    public static final Random RANDOM = new Random();

    public static final float PI2 = (float) (Math.PI * 2);

    private static final int ALPHA = 255 << 24;

    public static final float PHI = (float) (Math.PI * (3 - Math.sqrt(5)));

    private static final float RAD_TO_DEG = 57.295779513082320876798154814105F;

    public static int color(int r, int g, int b)
    {
        return ALPHA | (r << 16) | (g << 8) | b;
    }

    public static int getColor(int r, int g, int b)
    {
        r = MathHelper.clamp(r, 0, 255);
        g = MathHelper.clamp(g, 0, 255);
        b = MathHelper.clamp(b, 0, 255);
        return color(r, g, b);
    }

    public static int getRandom(int x, int z)
    {
        int h = x * 374761393 + z * 668265263;
        h = (h ^ (h >> 13)) * 1274126177;
        return h ^ (h >> 16);
    }

    public static int getSeed(int seed, int x, int y)
    {
        int h = seed + x * 374761393 + y * 668265263;
        h = (h ^ (h >> 13)) * 1274126177;
        return h ^ (h >> 16);
    }

    public static int getSeed(int seed, int x, int y, int z)
    {
        int h = seed + x * 374761393 + y * 668265263 + z;
        h = (h ^ (h >> 13)) * 1274126177;
        return h ^ (h >> 16);
    }

    public static int fromHSBtoRGB(float hue, float saturation, float brightness)
    {
        int red = 0;
        int green = 0;
        int blue = 0;
        if (saturation == 0.0F)
        {
            red = green = blue = (int) (brightness * 255.0F + 0.5F);
        }
        else
        {
            float var6 = (hue - (float) Math.floor((double) hue)) * 6.0F;
            float var7 = var6 - (float) Math.floor((double) var6);
            float var8 = brightness * (1.0F - saturation);
            float var9 = brightness * (1.0F - saturation * var7);
            float var10 = brightness * (1.0F - saturation * (1.0F - var7));
            switch ((int) var6)
            {
                case 0 :
                    red = (int) (brightness * 255.0F + 0.5F);
                    green = (int) (var10 * 255.0F + 0.5F);
                    blue = (int) (var8 * 255.0F + 0.5F);
                    break;
                case 1 :
                    red = (int) (var9 * 255.0F + 0.5F);
                    green = (int) (brightness * 255.0F + 0.5F);
                    blue = (int) (var8 * 255.0F + 0.5F);
                    break;
                case 2 :
                    red = (int) (var8 * 255.0F + 0.5F);
                    green = (int) (brightness * 255.0F + 0.5F);
                    blue = (int) (var10 * 255.0F + 0.5F);
                    break;
                case 3 :
                    red = (int) (var8 * 255.0F + 0.5F);
                    green = (int) (var9 * 255.0F + 0.5F);
                    blue = (int) (brightness * 255.0F + 0.5F);
                    break;
                case 4 :
                    red = (int) (var10 * 255.0F + 0.5F);
                    green = (int) (var8 * 255.0F + 0.5F);
                    blue = (int) (brightness * 255.0F + 0.5F);
                    break;
                case 5 :
                    red = (int) (brightness * 255.0F + 0.5F);
                    green = (int) (var8 * 255.0F + 0.5F);
                    blue = (int) (var9 * 255.0F + 0.5F);
            }
        }

        return ALPHA | red << 16 | green << 8 | blue;
    }

    public static float[] fromRGBtoHSB(int r, int g, int b)
    {
        float[] values = new float[3];

        int max = max(r, g, b);
        int min = min(r, g, b);

        float brightness = (float) max / 255.0F;
        float saturation;
        if (max != 0) {
            saturation = (float) (max - min) / (float) max;
        } else {
            saturation = 0.0F;
        }

        float hue;
        if (saturation == 0.0F) {
            hue = 0.0F;
        }
        else {
            float var9 = (float) (max - r) / (float) (max - min);
            float var10 = (float) (max - g) / (float) (max - min);
            float var11 = (float) (max - b) / (float) (max - min);
            if (r == max) {
                hue = var11 - var10;
            } else if (g == max) {
                hue = 2.0F + var9 - var11;
            } else {
                hue = 4.0F + var10 - var9;
            }

            hue /= 6.0F;
            if (hue < 0.0F) {
                ++hue;
            }
        }

        values[0] = hue;
        values[1] = saturation;
        values[2] = brightness;

        return values;
    }

    public static <T> void shuffle(T[] array, Random random)
    {
        for (int i = 0; i < array.length; i++)
        {
            int i2 = random.nextInt(array.length);
            T element = array[i];
            array[i] = array[i2];
            array[i2] = element;
        }
    }

    public static int pow2(int i)
    {
        return i * i;
    }

    public static float pow2(float f)
    {
        return f * f;
    }

    public static double pow2(double d)
    {
        return d * d;
    }

    public static int randRange(int min, int max, Random random)
    {
        return min + random.nextInt(max - min + 1);
    }

    public static double randRange(double min, double max, Random random)
    {
        return min + random.nextDouble() * (max - min);
    }

    public static float randRange(float min, float max, Random random)
    {
        return min + random.nextFloat() * (max - min);
    }

    public static float lengthSqr(float x, float y, float z)
    {
        return x * x + y * y + z * z;
    }

    public static float length(float x, float y, float z)
    {
        return (float) Math.sqrt(lengthSqr(x, y, z));
    }

    public static float lengthSqr(float x, float y)
    {
        return x * x + y * y;
    }

    public static double lengthSqr(double x, double y)
    {
        return x * x + y * y;
    }

    public static float length(float x, float y)
    {
        return (float) Math.sqrt(lengthSqr(x, y));
    }

    public static double length(double x, double y)
    {
        return Math.sqrt(lengthSqr(x, y));
    }

    public static float dot(float x1, float y1, float z1, float x2, float y2, float z2)
    {
        return x1 * x2 + y1 * y2 + z1 * z2;
    }

    public static float dot(float x1, float y1, float x2, float y2)
    {
        return x1 * x2 + y1 * y2;
    }

    public static int floor(double x)
    {
        return x < 0 ? (int) (x - 1) : (int) x;
    }

    public static int min(int a, int b)
    {
        return a < b ? a : b;
    }

    public static int max(int a, int b)
    {
        return a > b ? a : b;
    }

    public static int min(int a, int b, int c)
    {
        return min(a, min(b, c));
    }

    public static int max(int a, int b, int c)
    {
        return max(a, max(b, c));
    }

    public static float min(float a, float b)
    {
        return a < b ? a : b;
    }

    public static float max(float a, float b)
    {
        return a > b ? a : b;
    }

    public static float max(float a, float b, float c)
    {
        return max(a, max(b, c));
    }

    public static final float radiansToDegrees(float value) {
        return value * RAD_TO_DEG;
    }

    public static final float degreesToRadians(float value) {
        return value / RAD_TO_DEG;
    }

    public static Vector3f cross(Vector3f vec1, Vector3f vec2)
    {
        float cx = vec1.getY() * vec2.getZ() - vec1.getZ() * vec2.getY();
        float cy = vec1.getZ() * vec2.getX() - vec1.getX() * vec2.getZ();
        float cz = vec1.getX() * vec2.getY() - vec1.getY() * vec2.getX();
        return new Vector3f(cx, cy, cz);
    }

    public static Vector3f normalize(Vector3f vec)
    {
        float length = lengthSqr(vec.getX(), vec.getY(), vec.getZ());
        if (length > 0)
        {
            length = (float) Math.sqrt(length);
            float x = vec.getX() / length;
            float y = vec.getY() / length;
            float z = vec.getZ() / length;
            vec.set(x, y, z);
        }
        return vec;
    }

    public static float angle(Vector3f vec1, Vector3f vec2)
    {
        float dot = vec1.getX() * vec2.getX() + vec1.getY() * vec2.getY() + vec1.getZ() * vec2.getZ();
        float length1 = lengthSqr(vec1.getX(), vec1.getY(), vec1.getZ());
        float length2 = lengthSqr(vec2.getX(), vec2.getY(), vec2.getZ());
        return (float) Math.acos(dot / Math.sqrt(length1 * length2));
    }
}
