package potionstudios.byg.common.world.feature.gen.overworld;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.material.Fluids;
import potionstudios.byg.common.world.feature.config.LargeLakeFeatureConfig;
import potionstudios.byg.common.world.math.EllipsoidWithHorizontalRotation;
import potionstudios.byg.common.world.math.noise.simplex.OpenSimplex2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LargeLakeFeature extends Feature<LargeLakeFeatureConfig> {

    public static final boolean DEBUG = false;

    private static final int NOISE_RADIUS_MODULATION_RANGE = 4;
    private static final int SURROUNDING_FEATURE_BUFFER = 1;
    private static final float NOISE_FREQUENCY = 0.08f;
    private static final float NOISE_VERTICAL_RELATIVE_FREQUENCY = 2.0f;
    private static final long SEED_FLIP_MASK = 0x5CFB46994DBD1E27L;

    public static Direction[] DIRECTIONS = new Direction[]{ Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.DOWN };

    public LargeLakeFeature(Codec<LargeLakeFeatureConfig> $$0) {
        super($$0);
    }

    @Override
    public boolean place(FeaturePlaceContext<LargeLakeFeatureConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator chunkGenerator, RandomSource random, BlockPos origin, LargeLakeFeatureConfig config) {
        long noiseSeed = world.getSeed() ^ SEED_FLIP_MASK;

        BlockPos.MutableBlockPos originMutable = new BlockPos.MutableBlockPos().set(origin);
        BlockPos.MutableBlockPos positionBeingEvaluatedMutable = new BlockPos.MutableBlockPos().set(originMutable);

        // Sample ellipse parameters.
        int uRadius = config.getRandomRadius(random);
        int vRadius = config.getRandomRadius(random);
        int yRadius = config.getRandomDepth(random);

        // Isotropy as a design principle: enable all possible XZ rotations,
        // rather than just two axis-aligned scalings.
        float angle = random.nextFloat() * Mth.TWO_PI;

        // Pre-computations for ellipse formula.
        EllipsoidWithHorizontalRotation ellipsoid = EllipsoidWithHorizontalRotation.create(uRadius, vRadius, yRadius, angle);

        // To modulate the radius by at most NOISE_RADIUS_MODULATION_RANGE, by basing off of the larger horizontal component.
        float equationResultAtNoiseMinimumRadius = ellipsoid.getHorizontalComponentForMaximumRadiusVariation(-NOISE_RADIUS_MODULATION_RANGE);
        float equationResultAtNoiseMinimumRadiusDifference = 1 - equationResultAtNoiseMinimumRadius;

        // Place edge features outward by approximately at most SURROUNDING_FEATURE_BUFFER, using a similar calculation to the above.
        float equationResultAtSurroundingFeatureBufferBoundary = ellipsoid.getHorizontalComponentForMaximumRadiusVariation(SURROUNDING_FEATURE_BUFFER);
        float equationResultAtSurroundingFeatureBufferBoundaryDifference = equationResultAtSurroundingFeatureBufferBoundary - 1;

        List<BlockPos> carvePositions = new ArrayList<>();
        List<BlockPos> lakeEdgePositions = new ArrayList<>();
        Function<BlockPos, BlockState> lakeBorderStateFunction = (targetBlockPos) -> config.borderStateProvider().getState(random, targetBlockPos);
        Function<BlockPos, BlockState> lakeFloorStateFunction = (targetBlockPos) -> config.lakeFloorStateProvider().getState(random, targetBlockPos);

        // Bounds.
        int radiusUVBound = Math.max(uRadius, vRadius) + SURROUNDING_FEATURE_BUFFER;

        // Initial horizontal loop to decide water level.
        int waterLevel = origin.getY();
        for (int x = -radiusUVBound; x <= radiusUVBound; x++) {
            for (int z = -radiusUVBound; z <= radiusUVBound; z++) {

                // Check if within the widest part of the ellipsoid.
                float ellipsoidDensityXZComponent = ellipsoid.getAdditiveHorizontalComponent(x, z);
                if (ellipsoidDensityXZComponent > 1) continue;

                // Update water level to not be higher than the terrain height here.
                int worldHeightHere = world.getHeight(Heightmap.Types.WORLD_SURFACE, x + origin.getX(), z + origin.getZ());
                waterLevel = Math.min(waterLevel, worldHeightHere - 1);
            }
        }

        // Bounding box loop to choose carve locations.
        int lowestCarve = Integer.MAX_VALUE;
        for (int x = -radiusUVBound; x <= radiusUVBound; x++) {
            for (int z = -radiusUVBound; z <= radiusUVBound; z++) {
                int worldHeightHere = world.getHeight(Heightmap.Types.WORLD_SURFACE, x + origin.getX(), z + origin.getZ());

                // This value applies to the whole column.
                float ellipsoidDensityXZComponent = ellipsoid.getAdditiveHorizontalComponent(x, z);

                // Y loop must be innermost, and it must run in increasing order,
                // so that the consumer of the list this produces can easily check if the block below was carved.
                for (int y = -yRadius; y <= yRadius; y++) {
                    positionBeingEvaluatedMutable.set(originMutable).move(x, y, z);

                    // Y component to complete the ellipsoid formula,
                    // with a modification to the top half to create steeper vertical sloping on the sides.
                    float ellipsoidDensityYComponent = ellipsoid.getAdditiveVerticalComponent(y);
                    if (y > 0) {
                        ellipsoidDensityYComponent *= ellipsoidDensityYComponent;
                    }
                    float ellipsoidDensity = ellipsoidDensityXZComponent + ellipsoidDensityYComponent;

                    // No block modifications or features outside this range at all.
                    if (ellipsoidDensity >= equationResultAtSurroundingFeatureBufferBoundary) {
                        continue;
                    }

                    // Definitely block modifications inside this range.
                    boolean isInLakeRange = (ellipsoidDensity <= equationResultAtNoiseMinimumRadius);

                    // Noise-involved lake shaping
                    // (or start the calculation for the boundary feature placement range)
                    float noisedTargetFormulaResult = 0;
                    if ((!isInLakeRange && ellipsoidDensity < 1) || y >= 0) {
                        float noiseValue = OpenSimplex2.noise3_ImproveXZ(noiseSeed,
                                positionBeingEvaluatedMutable.getX() * NOISE_FREQUENCY,
                                positionBeingEvaluatedMutable.getY() * (NOISE_FREQUENCY * NOISE_VERTICAL_RELATIVE_FREQUENCY),
                                positionBeingEvaluatedMutable.getZ() * NOISE_FREQUENCY
                        );
                        noiseValue = noiseValue * 0.5f + 0.5f; // [-1, 1] to [0, 1]
                        noisedTargetFormulaResult = equationResultAtNoiseMinimumRadius + noiseValue * equationResultAtNoiseMinimumRadiusDifference;
                        isInLakeRange = (ellipsoidDensity <= noisedTargetFormulaResult);
                    }

                    // Queue for lake modification if that's what we're here for.
                    if (isInLakeRange) {
                        carvePositions.add(positionBeingEvaluatedMutable.immutable());
                        lowestCarve = Math.min(lowestCarve, positionBeingEvaluatedMutable.getY());
                        continue;
                    }

                    // Otherwise queue for surrounding feature placement if inside that range.
                    if (positionBeingEvaluatedMutable.getY() == worldHeightHere && worldHeightHere > waterLevel) {
                        noisedTargetFormulaResult += equationResultAtSurroundingFeatureBufferBoundaryDifference;
                        if (ellipsoidDensity <= noisedTargetFormulaResult) {
                            lakeEdgePositions.add(positionBeingEvaluatedMutable.immutable());
                        }
                    }
                }
            }
        }

        // If the water level is lower than the lowest carved block, skip placement.
        if (waterLevel < lowestCarve) return false;

        // Carve lake.
        ArrayList<BlockPos> lakeSurfacePositions = new ArrayList<>();
        BlockPos carvePositionPrevious = null;
        for (BlockPos carvePosition : carvePositions) {
            if (canReplace(world.getBlockState(carvePosition))) {
                if (carvePosition.getY() <= waterLevel) {
                    setLakeBlocks(world, carvePosition.getY() == waterLevel ? lakeBorderStateFunction : lakeFloorStateFunction, carvePosition);
                } else {
                    world.removeBlock(carvePosition, false);
                    if (carvePosition.getY() == waterLevel + 1 && carvePosition.below().equals(carvePositionPrevious)) {
                        lakeSurfacePositions.add(carvePosition);
                    }
                }
            }
            carvePositionPrevious = carvePosition;
        }

        // Place surface features.
        for (BlockPos lakeSurfacePosition : lakeSurfacePositions) {
            for (Holder<PlacedFeature> lakeSurfaceFeature : config.lakeSurfaceFeatures()) {
                lakeSurfaceFeature.value().place(world, chunkGenerator, random, lakeSurfacePosition);
            }
        }

        // Place surrounding features.
        for (BlockPos lakeEdgePosition : lakeEdgePositions) {
            for (Holder<PlacedFeature> lakeEdgeFeature : config.lakeEdgeFeatures()) {
                lakeEdgeFeature.value().place(world, chunkGenerator, random, lakeEdgePosition);
            }

            if (DEBUG) {
                world.setBlock(lakeEdgePosition.offset(0, 6, 0), Blocks.GLOWSTONE.defaultBlockState(), 2);
            }
        }
        return true;
    }

    private void setLakeBlocks(WorldGenLevel world, Function<BlockPos, BlockState> stateFunction, BlockPos blockPos) {
        world.setBlock(blockPos, Blocks.WATER.defaultBlockState(), 2);
        world.scheduleTick(blockPos, Fluids.WATER, 0);

        BlockPos.MutableBlockPos neighborBlockPos = new BlockPos.MutableBlockPos().set(blockPos);
        for (Direction value : DIRECTIONS) {
            neighborBlockPos.setWithOffset(blockPos, value);
            if (world.getBlockState(neighborBlockPos).getBlock() != Blocks.WATER) {
                world.setBlock(neighborBlockPos, stateFunction.apply(neighborBlockPos), 2);
            }
        }
    }

    private static boolean canReplace(BlockState state) {
        return !state.is(BlockTags.FEATURES_CANNOT_REPLACE);
    }
}
