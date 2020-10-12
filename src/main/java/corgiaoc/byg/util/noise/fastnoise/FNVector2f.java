package corgiaoc.byg.util.noise.fastnoise;

public class FNVector2f {
    public float x, y;

    public FNVector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public FNVector2f(float[] v) {
        this(v[0], v[1]);
    }

    public FNVector2f(FNVector2f v1) {
        this(v1.x, v1.y);
    }

    public final float dot(FNVector2f v1) {
        return this.x * v1.x + this.y * v1.y;
    }

    public final float length() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public final float lengthSquared() {
        return (this.x * this.x + this.y * this.y);
    }
}
