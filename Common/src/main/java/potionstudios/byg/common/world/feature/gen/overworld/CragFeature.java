package potionstudios.byg.common.world.feature.gen.overworld;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.material.Fluids;
import potionstudios.byg.common.world.feature.config.CragFeatureConfig;
import potionstudios.byg.common.world.math.AsymptoticFadeCurve;
import potionstudios.byg.common.world.math.FloatToFloatFunction;
import potionstudios.byg.common.world.math.LinearFunction1F;
import potionstudios.byg.common.world.math.noise.nodes.FrequencyScaledNoise3D;
import potionstudios.byg.common.world.math.noise.nodes.MappedNoise3D;
import potionstudios.byg.common.world.math.noise.nodes.Noise3D;
import potionstudios.byg.common.world.math.noise.nodes.NoiseFractal3D;
import potionstudios.byg.common.world.math.noise.simplex.OpenSimplex2;

import java.util.ArrayList;

public class CragFeature extends Feature<CragFeatureConfig> {

    private static final float RIM_RADIUS_MIN = 8.0f;
    private static final float RIM_RADIUS_MAX = 12.0f;

    private static final int ASYMPTOTIC_BASE_RADIUS = 16;

    private static final float SLOPE_AT_RIM_EDGE = 1.5f;

    private static final float CALDERA_RADIUS_RATIO_MIN = 0.65f;
    private static final float CALDERA_RADIUS_RATIO_MAX = 0.75f;
    private static final float CALDERA_DEPTH_RELATIVE_TO_RADIUS = 1.65f;
    private static final float CALDERA_FLOOR_FLATNESS = 0.7f;

    private static final int FLUID_SURFACE_RECESSION_MIN = 0;
    private static final int FLUID_SURFACE_RECESSION_MAX = 3;

    private static final int PLACEMENT_OFFSET_Y_MIN = 7;
    private static final int PLACEMENT_OFFSET_Y_MAX = 14;

    private static final int GENERATION_DEPTH_BELOW_SURFACE = 2;

    private static final float MAX_NOISE_DENSITY_THRESHOLD = 3f;
    private static final float CRAG_NOISE_AGGRESSIVENESS = 2.25f;
    private static final FloatToFloatFunction CRAG_NOISE_AGGRESSIVENESS_CURVE = AsymptoticFadeCurve.createAsUnitRangeMap(CRAG_NOISE_AGGRESSIVENESS);
    private static final FloatToFloatFunction CRAG_NOISE_TO_THRESHOLD_MAP = LinearFunction1F.createAsMap(-1, 1, 1, MAX_NOISE_DENSITY_THRESHOLD);
    private static final Noise3D CRAG_THRESHOLD_NOISE = MappedNoise3D.create(
            FrequencyScaledNoise3D.create(
                NoiseFractal3D.create(OpenSimplex2::noise3_ImproveXZ, 3, 1.0f, true),
                0.075, 0.00625
            ),
            (t) -> CRAG_NOISE_TO_THRESHOLD_MAP.evaluate(CRAG_NOISE_AGGRESSIVENESS_CURVE.evaluate(t))
    );
    private static final long NOISE_SEED_FLIP_MASK = -0x74414F5C4212BDFCL;

    private enum BlockPlacementType {
        SOLID,
        FLUID
    }
    private record BlockPlacement(int x, int y, int z, BlockPlacementType type) { }
    private static final ThreadLocal<ArrayList<BlockPlacement>> deferredBlockPlacementsThreadLocal = ThreadLocal.withInitial(ArrayList::new);

    public CragFeature(Codec<CragFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<CragFeatureConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator generator, RandomSource random, BlockPos origin, CragFeatureConfig config) {
        long noiseSeed = world.getSeed() ^ NOISE_SEED_FLIP_MASK;

        origin = origin.above(Mth.randomBetweenInclusive(random, PLACEMENT_OFFSET_Y_MIN, PLACEMENT_OFFSET_Y_MAX));

        float rimRadius = Mth.randomBetween(random, RIM_RADIUS_MIN, RIM_RADIUS_MAX);
        float calderaRadiusRatio = Mth.randomBetween(random, CALDERA_RADIUS_RATIO_MIN, CALDERA_RADIUS_RATIO_MAX);
        float calderaRadiusRatioSquaredReciprocal = 1.0f / (calderaRadiusRatio * calderaRadiusRatio);
        float calderaRadius = rimRadius * calderaRadiusRatio;

        float calderaDepth = calderaRadius * CALDERA_DEPTH_RELATIVE_TO_RADIUS;
        float calderaDepthReciprocal = 1.0f / calderaDepth;

        int fluidSurfaceGap = Mth.randomBetweenInclusive(random, FLUID_SURFACE_RECESSION_MIN, FLUID_SURFACE_RECESSION_MAX);

        CragShape cragShape = new CragShape(rimRadius, ASYMPTOTIC_BASE_RADIUS, SLOPE_AT_RIM_EDGE);

        ArrayList<BlockPlacement> deferredBlockPlacements = deferredBlockPlacementsThreadLocal.get();
        deferredBlockPlacements.clear();
        BlockPos.MutableBlockPos currentPositionMutable = new BlockPos.MutableBlockPos();
        for (int dz = -ASYMPTOTIC_BASE_RADIUS; dz <= ASYMPTOTIC_BASE_RADIUS; dz++) {
            for (int dx = -ASYMPTOTIC_BASE_RADIUS; dx <= ASYMPTOTIC_BASE_RADIUS; dx++) {

                int deltaSquared = dx * dx + dz * dz;
                if (deltaSquared >= cragShape.asymptoticRadiusSquaredBound) continue;
                float deltaSquaredUnscaled = cragShape.computeDeltaSquaredUnscaled(deltaSquared);

                int blockX = dx + origin.getX();
                int blockZ = dz + origin.getZ();

                int worldHeightStartBound = origin.getY() + (int)cragShape.computeHeightBound(deltaSquaredUnscaled);
                int worldHeightStop = world.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, blockX, blockZ) - GENERATION_DEPTH_BELOW_SURFACE;

                currentPositionMutable.set(blockX, 0, blockZ);
                for (int y = worldHeightStartBound; y >= worldHeightStop; y--) {
                    int yRelative = y - origin.getY();

                    float cragDensity = cragShape.computeDensity(yRelative, deltaSquaredUnscaled);

                    boolean insideCone = (cragDensity >= MAX_NOISE_DENSITY_THRESHOLD);
                    float noisyThreshold = Float.NaN;
                    if (!insideCone) {
                        noisyThreshold = CRAG_THRESHOLD_NOISE.evaluate(noiseSeed, blockX, y, blockZ);
                        insideCone = (cragDensity >= noisyThreshold);
                    }

                    boolean insideCaldera = false;
                    if (insideCone) {
                        if (yRelative > -calderaDepth) {
                            float yDeltaUnscaled = yRelative * calderaDepthReciprocal;
                            float yDeltaSquaredCurvedUnscaled = (yDeltaUnscaled * yDeltaUnscaled) / (
                                    (CALDERA_FLOOR_FLATNESS / (1 - CALDERA_FLOOR_FLATNESS)) * (1 + yDeltaUnscaled) + 1
                            );
                            float deltaSquaredUnscaledAdjusted = deltaSquaredUnscaled * calderaRadiusRatioSquaredReciprocal;
                            float calderaDensity = cragShape.computeDensity(yRelative, deltaSquaredUnscaledAdjusted + yDeltaSquaredCurvedUnscaled);

                            insideCaldera = (calderaDensity >= MAX_NOISE_DENSITY_THRESHOLD);
                            if (!insideCaldera) {
                                if (Float.isNaN(noisyThreshold)) noisyThreshold = CRAG_THRESHOLD_NOISE.evaluate(noiseSeed, blockX, y, blockZ);
                                insideCaldera = (calderaDensity >= noisyThreshold);
                            }
                        }

                        if (insideCaldera && yRelative <= -fluidSurfaceGap) {
                            currentPositionMutable.setY(y);
                            BlockState blockStateHere = world.getBlockState(currentPositionMutable);
                            if (blockStateHere.is(BlockTags.LAVA_POOL_STONE_CANNOT_REPLACE)) {
                                // Cancel the entire feature generation.
                                // Skipping stone formations in response to vegetation is a bit naturalistically backwards,
                                // but Minecraft's feature generation pipeline does not guarantee placement order.
                                return false;
                            }
                            if (blockStateHere.canBeReplaced(Fluids.WATER)) {
                                deferredBlockPlacements.add(new BlockPlacement(blockX, y, blockZ, BlockPlacementType.FLUID));
                            }
                        } else if (!insideCaldera) {
                            deferredBlockPlacements.add(new BlockPlacement(blockX, y, blockZ, BlockPlacementType.SOLID));
                        }
                    }
                }

            }
        }

        for (BlockPlacement placement : deferredBlockPlacements) {
            currentPositionMutable.set(placement.x(), placement.y(), placement.z());
            switch (placement.type()) {
                case FLUID:
                    world.setBlock(currentPositionMutable, config.fluid().defaultFluidState().createLegacyBlock(), Block.UPDATE_CLIENTS);
                    world.scheduleTick(currentPositionMutable, config.fluid(), 0);
                    break;
                case SOLID:
                    currentPositionMutable.setY(placement.y() + 1);
                    BlockState blockStateAbove = world.getBlockState(currentPositionMutable);
                    boolean openAbove = !blockStateAbove.canOcclude() && blockStateAbove.getFluidState().isEmpty();
                    currentPositionMutable.setY(placement.y());
                    BlockStateProvider stateProvider = openAbove ? config.topBlockProvider() : config.mainBlockProvider();
                    world.setBlock(currentPositionMutable, stateProvider.getState(random, currentPositionMutable), Block.UPDATE_CLIENTS);
                    break;
            }
        }

        return true;
    }

    private static class CragShape {
        public final int asymptoticRadiusSquaredBound;
        private final float asymptoticRadiusSquaredReciprocal;
        private final float yUnmappedAtRimRadius;
        private final float yMultiplier;
        private final float yMultiplierReciprocal;
        private final float yUnmappedAtRimRadiusOverYMultiplier;

        public CragShape(float rimRadius, float asymptoticRadius, float slopeAtRim) {
            this.asymptoticRadiusSquaredBound = (int)(asymptoticRadius * asymptoticRadius);
            this.asymptoticRadiusSquaredReciprocal = 1.0f / (asymptoticRadius * asymptoticRadius);
            float rimRadiusSquaredUnscaled = (rimRadius * rimRadius) * this.asymptoticRadiusSquaredReciprocal;
            this.yUnmappedAtRimRadius = sampleHillBaseShapeAsHeightmapBelowZero(rimRadiusSquaredUnscaled);
            this.yMultiplier = computeHillSlopeRescaleMultiplier(rimRadiusSquaredUnscaled, slopeAtRim * asymptoticRadius);
            this.yMultiplierReciprocal = 1.0f / this.yMultiplier;
            this.yUnmappedAtRimRadiusOverYMultiplier = this.yUnmappedAtRimRadius * this.yMultiplierReciprocal;
        }

        private float computeDeltaSquaredUnscaled(float deltaSquared) {
            return deltaSquared * asymptoticRadiusSquaredReciprocal;
        }

        private float computeHeightBound(float deltaSquaredUnscaled) {
            return Math.min(0,
                    sampleHillBaseShapeAsHeightmapBelowZero(deltaSquaredUnscaled) * yMultiplierReciprocal -
                            yUnmappedAtRimRadiusOverYMultiplier
            );
        }

        private float computeDensity(float yRelativeToTop, float deltaSquaredUnscaled) {
            float yUnmapped = yRelativeToTop * yMultiplier + yUnmappedAtRimRadius;
            return computeHillRadiusSquaredUnscaledWithDivisor(yUnmapped, deltaSquaredUnscaled);
        }

        private static float sampleHillBaseShapeAsHeightmapBelowZero(float deltaSquaredUnscaled) {
            return -1.0f / (1.0f - Math.min(deltaSquaredUnscaled, 1)) + 1;
        }

        private static float computeHillRadiusSquaredUnscaledWithDivisor(float yUnmapped, float divisor) {
            return yUnmapped / ((yUnmapped - 1) * divisor);
        }

        private static float computeHillSlopeRescaleMultiplier(float deltaSquaredRelative, float targetSlopeUnscaled) {
            return Mth.sqrt(deltaSquaredRelative) / Mth.square(deltaSquaredRelative - 1) * (2.0f / targetSlopeUnscaled);
        }
    }
}
