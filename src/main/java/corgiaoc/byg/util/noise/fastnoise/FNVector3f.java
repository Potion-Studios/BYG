package corgiaoc.byg.util.noise.fastnoise;

public class FNVector3f {
    public float x, y, z;

    public FNVector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public FNVector3f(float[] v) {
        this(v[0], v[1], v[2]);
    }

    public FNVector3f(FNVector3f v1) {
        this(v1.x, v1.y, v1.z);
    }

    public final float dot(FNVector3f v1) {
        return this.x * v1.x + this.y * v1.y + this.z * v1.z;
    }

    public final float length() {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    public final float lengthSquared() {
        return (x * x + y * y + z * z);
    }
}
