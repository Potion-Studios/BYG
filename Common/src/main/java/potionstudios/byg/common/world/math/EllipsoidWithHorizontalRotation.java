package potionstudios.byg.common.world.math;

import net.minecraft.util.Mth;

import java.util.Objects;

// Credits to Hex_26 for the underlying formula!
// Modified to use XZ rotation (isotropy as a design principle)
// and moved to a dedicated class.
public final class EllipsoidWithHorizontalRotation {
    private final float uRadius, vRadius, yRadius;
    private final float uRadiusInverseSquared;
    private final float vRadiusInverseSquared;
    private final float yRadiusInverseSquared;
    private final float sin, cos;

    private EllipsoidWithHorizontalRotation(
            float uRadius, float vRadius, float yRadius,
            float uRadiusInverseSquared, float vRadiusInverseSquared, float yRadiusInverseSquared,
            float sin, float cos) {
        this.uRadius = uRadius;
        this.vRadius = vRadius;
        this.yRadius = yRadius;
        this.uRadiusInverseSquared = uRadiusInverseSquared;
        this.vRadiusInverseSquared = vRadiusInverseSquared;
        this.yRadiusInverseSquared = yRadiusInverseSquared;
        this.sin = sin;
        this.cos = cos;
    }

    public static EllipsoidWithHorizontalRotation create(float uRadius, float vRadius, float yRadius, float angleInRadians) {
        return new EllipsoidWithHorizontalRotation(
                uRadius, vRadius, yRadius,
                1.0f / Mth.square(uRadius),
                1.0f / Mth.square(vRadius),
                1.0f / Mth.square(yRadius),
                Mth.sin(angleInRadians),
                Mth.cos(angleInRadians)
        );
    }

    public float getAdditiveHorizontalComponent(float x, float z) {

        // Get the rotated UV coordinate basis, to take the place of XZ in computations.
        float u = this.sin * z + this.cos * x;
        float v = this.cos * z - this.sin * x;

        return Mth.square(u) * this.uRadiusInverseSquared + Mth.square(v) * this.vRadiusInverseSquared;
    }

    public float getHorizontalComponentForMaximumRadiusVariation(float maximumRadiusVariation) {
        float uvRadiusMax = Math.max(this.uRadius, this.vRadius);
        float uvRadiusMaxInverseSquared = uRadius >= vRadius ? this.uRadiusInverseSquared : this.vRadiusInverseSquared;
        return Mth.square(uvRadiusMax + maximumRadiusVariation) * uvRadiusMaxInverseSquared;
    }

    public float getAdditiveVerticalComponent(float y) {
        return Mth.square(y) * this.yRadiusInverseSquared;
    }

    public float getValue(float x, float y, float z) {
        return this.getAdditiveHorizontalComponent(x, z) + this.getAdditiveVerticalComponent(y);
    }

    public float uRadius() {
        return uRadius;
    }

    public float vRadius() {
        return vRadius;
    }

    public float yRadius() {
        return yRadius;
    }

    public float uRadiusInverseSquared() {
        return uRadiusInverseSquared;
    }

    public float vRadiusInverseSquared() {
        return vRadiusInverseSquared;
    }

    public float yRadiusInverseSquared() {
        return yRadiusInverseSquared;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        EllipsoidWithHorizontalRotation that = (EllipsoidWithHorizontalRotation) o;
        return Float.compare(that.uRadiusInverseSquared, this.uRadiusInverseSquared) == 0
                && Float.compare(that.vRadiusInverseSquared, this.vRadiusInverseSquared) == 0
                && Float.compare(that.yRadiusInverseSquared, this.yRadiusInverseSquared) == 0
                && Float.compare(that.sin, this.sin) == 0 && Float.compare(that.cos, this.cos) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.uRadiusInverseSquared, this.vRadiusInverseSquared, this.yRadiusInverseSquared,
                this.sin, this.cos
        );
    }
}
