package voronoiaoc.byg.common.biomes;

import net.minecraft.util.math.vector.Vector3d;

public interface BiomeFog {

    default Vector3d getBiomeFogColor(int x, int z, Vector3d originalValue) {
        return originalValue;
    }

    default Boolean doesBiomeXZShowFog(int x, int z) {
        return false;
    }

    default double getBiomeVoidFogYFactor(int x, int y, double originalValueForDimension) {
        return originalValueForDimension;
    }

    default float fogDistance(int x, int z, float originalDistanceChunks) {
        return originalDistanceChunks;
    }
}