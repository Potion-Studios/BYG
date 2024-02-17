package potionstudios.byg.common.world.math;

public record LinearFunction1F(float m, float b) implements FloatToFloatFunction {

    public static LinearFunction1F createAsMap(float inputA, float inputB, float outputA, float outputB) {
        float m = (outputB - outputA) / (inputB - inputA);
        float b = outputA - m * inputA;
        return new LinearFunction1F(m, b);
    }

    public float evaluate(float t) {
        return m * t + b;
    }

}
