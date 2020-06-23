package voronoiaoc.byg.common.biomes;

public interface BiomeFog {

    default float fogDistance(int x, int z, float originalDistanceChunks) {
        return originalDistanceChunks;
    }
}