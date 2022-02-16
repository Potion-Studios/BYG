package potionstudios.byg.common.world.feature.overworld;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Mth;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.biome.BYGBiomes;
import potionstudios.byg.common.world.math.noise.fastnoise.FastNoise;

public class DuneFeature extends Feature<NoneFeatureConfiguration> {
    protected static FastNoise fastNoise;
    protected static FastNoise fastNoise1;
    protected static FastNoise dunePeakNoise1;
    protected static FastNoise dunePeakNoise2;
    protected long seed;

    public DuneFeature(Codec<NoneFeatureConfiguration> $$0) {
        super($$0);
    }

    public static final double FREQUENCY = 1.0 / 145.0;
    public static final double FREQUENCY_1 = 1.0 / 250.0;

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {
        WorldGenLevel level = featurePlaceContext.level();
        setSeed(level.getSeed(), (float) FREQUENCY);
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

        for (int xMove = 0; xMove < 16; xMove++) {
            for (int zMove = 0; zMove < 16; zMove++) {
                mutableBlockPos.set(featurePlaceContext.origin()).move(xMove, 0, zMove);
                float duneHeight = peakNoise(dunePeakNoise1, mutableBlockPos);
                duneHeight *= Mth.lerp(5, 15, 0.3F);

                float duneHeight1 = peakNoise(dunePeakNoise2, mutableBlockPos);
                duneHeight1 *= Mth.lerp(5, 15, 0.3F);

                double height = 180 + Math.max(duneHeight, duneHeight1);

                BlockPos.MutableBlockPos blendingPos = new BlockPos.MutableBlockPos().set(mutableBlockPos);

                double density = getBlendDensity(level, mutableBlockPos, height, 10, blendingPos);

                int oceanFloor = level.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, mutableBlockPos.getX(), mutableBlockPos.getZ());
                mutableBlockPos.setY((int) Mth.clampedLerp(oceanFloor - 3, height, 1.0 - density));
                for (int y = mutableBlockPos.getY(); y >= oceanFloor; y--) {
                    BlockState generatingState = BYGBlocks.WINDSWEPT_SAND.defaultBlockState();
                    ChunkAccess chunk = level.getChunk(mutableBlockPos);
                    int localX = mutableBlockPos.getX() & 15;
                    int localZ = mutableBlockPos.getZ() & 15;
                    chunk.getOrCreateHeightmapUnprimed(Heightmap.Types.OCEAN_FLOOR_WG).update(localX, mutableBlockPos.getY(), localZ, generatingState);
                    chunk.getOrCreateHeightmapUnprimed(Heightmap.Types.WORLD_SURFACE_WG).update(localX, mutableBlockPos.getY(), localZ, generatingState);
                    level.setBlock(mutableBlockPos, generatingState, 2);
                    mutableBlockPos.move(Direction.DOWN);
                }
            }
        }

        return false;
    }

    private double getBlendDensity(WorldGenLevel level, BlockPos.MutableBlockPos mutableBlockPos, double height, int blendRange, BlockPos.MutableBlockPos blendingPos) {
        double density = 0;
        for (int x = -blendRange; x <= blendRange; x++) {
            for (int z = -blendRange; z <= blendRange; z++) {
                blendingPos.set(mutableBlockPos).move(x, 0, z);
                int height1 = level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, blendingPos.getX(), blendingPos.getZ());
                blendingPos.setY(height1);
                ResourceKey<Biome> biomeResourceKey = level.getBiomeName(blendingPos).get();
                if (biomeResourceKey != BYGBiomes.WINDSWEPT_DUNES && height1 < height) {
                    density += 1.0 / (blendRange * blendRange) * 2;
                }
            }
        }
        return density;
    }

    private float peakNoise(FastNoise noise, BlockPos.MutableBlockPos mutableBlockPos) {
        noise.SetFrequency(0.023F);
        noise.SetNoiseType(FastNoise.NoiseType.Cellular);
        noise.SetCellularDistanceFunction(FastNoise.CellularDistanceFunction.Euclidean);
        noise.SetCellularReturnType(FastNoise.CellularReturnType.Distance2Mul);
        noise.SetGradientPerturbAmp(1.5F);

        return 1 - noise.GetNoise((float) (mutableBlockPos.getX()), 0, (float) (mutableBlockPos.getZ()));
    }

    public void setSeed(long seed, float noiseFreq) {
        if (this.seed != seed || fastNoise == null) {
            fastNoise = new FastNoise((int) seed);
            fastNoise.SetNoiseType(FastNoise.NoiseType.SimplexFractal);
            fastNoise.SetFractalType(FastNoise.FractalType.RigidMulti);
            fastNoise.SetFractalOctaves(2);
            this.seed = seed;

            fastNoise1 = new FastNoise((int) seed);
            dunePeakNoise1 = new FastNoise((int) seed);
            dunePeakNoise2 = new FastNoise((int) seed + 76457567);
        }
    }
}
