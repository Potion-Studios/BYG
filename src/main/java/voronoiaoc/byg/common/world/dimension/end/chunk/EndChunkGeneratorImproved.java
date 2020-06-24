package voronoiaoc.byg.common.world.dimension.end.chunk;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.EndGenerationSettings;
import net.minecraft.world.gen.WorldGenRegion;
import voronoiaoc.byg.common.world.worldtype.chunk.simplex.Simplex3DNoiseChunkGenerator;

public class EndChunkGeneratorImproved extends Simplex3DNoiseChunkGenerator<EndGenerationSettings> {
    private final double[] constHeightThresholdModifiers = this.generateConstHeightThresholdModifiers();
    private final BlockPos spawnPoint;

    public EndChunkGeneratorImproved(IWorld world, BiomeProvider provider, EndGenerationSettings settings) {
        super(world, provider, 8, 256, settings, 3, 2, 1368.824D, 684.412 * 2, 17.110300000000002D, 4.277575000000001D * 2);
        this.spawnPoint = settings.getSpawnPos();
    }

    @Override
    public void generateSurface(WorldGenRegion p_225551_1_, IChunk p_225551_2_) {

    }

    protected double[] getColumnBiomeParams(int xc, int yc) {
        return new double[]{(double) this.biomeProvider.func_222365_c(xc, yc), 0};
    }

    protected double getHeightThreshold(double biomeParam1, double biomeParam2, int y) {
        return 8 - biomeParam1 + constHeightThresholdModifiers[y];
    }

    // The Y-dependent modifiers from func_222546_a can be equivalently applied using the existing height threshold.
    // All we care about is the sign of the final value, so we can do some math to turn it into a threshold modifier.
    // TODO these could be made smoother. But with The End's extreme modifier, it needs to be changed to do that.
    private double[] generateConstHeightThresholdModifiers() {
        double[] thresholds = new double[256];

        double g = 7.0;
        double gd = 64.0;
        double gg = -3000.0;

        double h = 7.0;
        double hd = h - 1;
        double hg = -30.0;

        for (int y = 0; y < 256; y++) {
            double yc = y / 8.0;
            if (yc > g) {
                double t = (yc - g) / gd;
                if (t > 1) t = 1;
                //else t = t * t * (3 - 2 * t);
                thresholds[y] = -(t * gg) / (1 - t);
            } else if (yc < h) {
                double t = (h - yc) / hd;
                if (t > 1) t = 1;
                    //else t = t * t * (3 - 2 * t);
                else t = t * t; // At least do this smoothing.
                thresholds[y] = -(t * hg) / (1 - t);
            } else
                thresholds[y] = 0;
        }

        return thresholds;
    }

    public int getGroundHeight() {
        return 50;
    }

    public int getSeaLevel() {
        return 0;
    }
}
