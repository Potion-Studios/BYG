package voronoiaoc.byg.common.world.worldtype.chunk.worley;

import net.minecraft.entity.EntityClassification;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.village.VillageSiege;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.OverworldGenSettings;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.spawner.CatSpawner;
import net.minecraft.world.spawner.PatrolSpawner;
import net.minecraft.world.spawner.PhantomSpawner;
import net.minecraft.world.spawner.WorldEntitySpawner;

import java.util.List;

public class Worley2DOverworldChunkGenerator extends Worley2DNoiseChunkGenerator<OverworldGenSettings> {
    private final double[] constHeightThresholdModifiers = this.generateConstHeightThresholdModifiers();
    private static final float[] field_222576_h = (float[]) Util.make(new float[25], (p_222575_0_) -> {
        for(int i = -2; i <= 2; ++i) {
            for(int j = -2; j <= 2; ++j) {
                float f = 10.0F / MathHelper.sqrt((float)(i * i + j * j) + 0.2F);
                p_222575_0_[i + 2 + (j + 2) * 5] = f;
            }
        }

    });



    //private final OctavesNoiseGenerator depthNoise;
    private final PhantomSpawner phantomSpawner = new PhantomSpawner();
    private final PatrolSpawner patrolSpawner = new PatrolSpawner();
    private final CatSpawner catSpawner = new CatSpawner();
    private final VillageSiege field_225495_n = new VillageSiege();

    public Worley2DOverworldChunkGenerator(IWorld world, BiomeProvider provider, OverworldGenSettings settings) {
        super(world, provider, 4,256, settings, 5, 2, 684.4119873046875D, 684.4119873046875D * 1.414218, 8.555149841308594D, 4.277574920654297D * 1.414218);
        this.randomSeed.skip(2620);
        //this.depthNoise = new OctavesNoiseGenerator(this.randomSeed, 15, 0); // See commented-out method below, modulateBiomeParameter
    }

    public void spawnMobs(WorldGenRegion region) {
        int i = region.getMainChunkX();
        int j = region.getMainChunkZ();
        Biome biome = region.getBiome((new ChunkPos(i, j)).asBlockPos());
        SharedSeedRandom sharedseedrandom = new SharedSeedRandom();
        sharedseedrandom.setDecorationSeed(region.getSeed(), i << 4, j << 4);
        WorldEntitySpawner.performWorldGenSpawning(region, biome, i, j, sharedseedrandom);
    }

    protected double getHeightThreshold(double biomeParam1, double biomeParam2, int y) {
        double d0 = 8.5D;
        double d1 = ((double)(y / 8.0) - (8.5D + biomeParam1 * 8.5D / 8.0D * 4.0D)) * 12.0D * 128.0D / 256.0D / biomeParam2;
        if(d1 < 0.0D) {
            d1 *= 4.0D;
        }

        return d1 + constHeightThresholdModifiers[y];
    }

    // In place of top fade from Vanilla NoiseChunkGenerator
    private double[] generateConstHeightThresholdModifiers() {
        double[] thresholds = new double[256];

        // Parameters for top fade, previously defined in the super-constructor or overridden methods.
        double g = 29.0;
        double gd = 3.0;
        double gg = -10.0;

        for (int y = 0; y < 256; y++) {
            double yc = y / 8.0;

            // Mimic the effect of the Vanilla top fade, by moving it to the threshold side of the equation.
            // An infinity is involved at the end of the interpolation, which is correct.
            if (yc > g) {
                double t = (yc - g) / gd;
                if (t > 1) t = 1; // clamp
                    //else t = t * t * (3 - 2 * t); // Not from Vanilla originally. But might as well make it smooth.
                else t = t * t; // Only the beginning matters to be smooth, actually.
                thresholds[y] = - (t * gg) / (1 - t);
            }
            else thresholds[y] = 0;

        }

        return thresholds;
    }


    protected double[] getColumnBiomeParams(int xc, int zc) {
        double[] adouble = new double[2];
        float f = 0.0F;
        float f1 = 0.0F;
        float f2 = 0.0F;
        boolean i = true;
        int j = this.getSeaLevel() - 5;
        float f3 = this.biomeProvider.getNoiseBiome(xc, j, zc).getDepth();

        for (int k = -2; k <= 2; ++k) {
            for (int l = -2; l <= 2; ++l) {
                Biome biome = this.biomeProvider.getNoiseBiome(xc + k, j, zc + l);
                float biomeDepth = biome.getDepth();
                float biomeScale = biome.getScale();

                float f6 = field_222576_h[k + 2 + (l + 2) * 5] / (biomeDepth + 2.0F);
                if (biome.getDepth() > f3) {
                    f6 /= 2.0F;
                }

                f += biomeScale * f6;
                f1 += biomeDepth * f6;
                f2 += f6;
            }
        }

        f /= f2;
        f1 /= f2;
        f = f * 0.9F + 0.1F;
        f1 = (f1 * 4.0F - 1.0F) / 8.0F;
        adouble[0] = f1;// + this.modulateBiomeParameter(xc, zc);
        adouble[1] = f;
        return adouble;
    }

    // The terrain seems to be just fine without this.
    // And including this prevents optimizations where the spline interpolator can be skipped.
    // Note: those optimizations are not implemented yet. They would be implemented in NoiseChunkGeneratorImproved.java
    // If this noise *is* needed, it should be performed as follows:
    // * every column, not interpolated
    // * one octave
    // * simplex noise, not oldperlin
    // * after biome interpolation
    /*private double modulateBiomeParameter(int xc, int zc) {
        // You don't need this.
        double d0 = this.depthNoise.func_215462_a((double)(xc * 200), 10.0D, (double)(zc * 200), 1.0D, 0.0D, true) * 65535.0D / 8000.0D;
        if(d0 < 0.0D) {
            d0 = -d0 * 0.3D;
        }
        d0 = d0 * 3.0D - 2.0D;
        if(d0 < 0.0D) {
            d0 /= 28.0D;
        } else {
            if(d0 > 1.0D) {
                d0 = 1.0D;
            }
            d0 /= 40.0D;
        }
        return d0;
    }*/

    public List<Biome.SpawnListEntry> getPossibleCreatures(EntityClassification creatureType, BlockPos pos) {
        if(Feature.SWAMP_HUT.func_202383_b(this.world, pos)) {
            if(creatureType == EntityClassification.MONSTER) {
                return Feature.SWAMP_HUT.getSpawnList();
            }

            if(creatureType == EntityClassification.CREATURE) {
                return Feature.SWAMP_HUT.getCreatureSpawnList();
            }
        } else if(creatureType == EntityClassification.MONSTER) {
            if(Feature.PILLAGER_OUTPOST.isPositionInStructure(this.world, pos)) {
                return Feature.PILLAGER_OUTPOST.getSpawnList();
            }

            if(Feature.OCEAN_MONUMENT.isPositionInStructure(this.world, pos)) {
                return Feature.OCEAN_MONUMENT.getSpawnList();
            }
        }

        return super.getPossibleCreatures(creatureType, pos);
    }

    public void spawnMobs(ServerWorld worldIn, boolean spawnHostileMobs, boolean spawnPeacefulMobs) {
        this.phantomSpawner.tick(worldIn, spawnHostileMobs, spawnPeacefulMobs);
        this.patrolSpawner.tick(worldIn, spawnHostileMobs, spawnPeacefulMobs);
        this.catSpawner.tick(worldIn, spawnHostileMobs, spawnPeacefulMobs);
        this.field_225495_n.tick(worldIn, spawnHostileMobs, spawnPeacefulMobs);
    }

    public int getGroundHeight() {
        return this.world.getSeaLevel() + 1;
    }

    public int getSeaLevel() {
        return 68;
    }
}