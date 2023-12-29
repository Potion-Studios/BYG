package potionstudios.byg.common.world.math;

import net.minecraft.util.Mth;

public record AsymptoticFadeCurve(float outputMultiplier, float internalCoefficient) implements FloatToFloatFunction {

    /**
     * Creates a curve where f(t)=t for t=-1,0,1 and which has the specified slope at t=0.
     * @param slopeAtZero the slope at t=0. Must be positive.
     * @return a function that matches the above description.
     */
    public static FloatToFloatFunction createAsUnitRangeMap(float slopeAtZero) {
        return new AsymptoticFadeCurve(slopeAtZero, slopeAtZero * slopeAtZero - 1);
    }

    public float evaluate(float t) {
        return outputMultiplier * t / Mth.sqrt(t * t * internalCoefficient + 1);
    }
}
