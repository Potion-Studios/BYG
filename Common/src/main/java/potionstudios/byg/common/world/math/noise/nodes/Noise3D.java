package potionstudios.byg.common.world.math.noise.nodes;

@FunctionalInterface
public interface Noise3D {
    float evaluate(long seed, double x, double y, double z);
}