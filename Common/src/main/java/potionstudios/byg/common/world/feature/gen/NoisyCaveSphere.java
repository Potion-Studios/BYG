package potionstudios.byg.common.world.feature.gen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.material.FluidState;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.config.NoisySphereConfig;
import potionstudios.byg.common.world.math.EllipsoidWithHorizontalRotation;
import potionstudios.byg.common.world.math.noise.simplex.OpenSimplex2;

import java.util.ArrayList;

public class NoisyCaveSphere extends Feature<NoisySphereConfig> {
    private static final float NOISE_MODULATION_THRESHOLD_LOWER_BOUND = 0.375f;
    private static final long SEED_FLIP_MASK = 0x3DFC83EA17C8A6F0L;
    private static final int FIXED_LIQUID_LEVEL = 30;

    public NoisyCaveSphere(Codec<NoisySphereConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoisySphereConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator chunkGenerator, RandomSource random, BlockPos position, NoisySphereConfig config) {
        long noiseSeed = world.getSeed() ^ SEED_FLIP_MASK;

        BlockPos.MutableBlockPos displacedOriginMutable = new BlockPos.MutableBlockPos().set(position.below(2 + random.nextInt(10)));
        BlockPos.MutableBlockPos positionBeingEvaluatedMutable = new BlockPos.MutableBlockPos().set(displacedOriginMutable);

        // All configs.
        NoisySphereConfig.RadiusSettings radiusSettings = config.radiusSettings();
        int stackHeight = config.stackHeight().sample(random);
        float uRadius = radiusSettings.xRadius().sample(random);
        float vRadius = radiusSettings.zRadius().sample(random);
        float yRadius = radiusSettings.yRadius().sample(random);
        double noiseFrequency = config.noiseFrequency();
        float thresholdMultiplierPerStack = (float)(config.radiusDivisorPerStack() * config.radiusDivisorPerStack());

        // Isotropy as a design principle: enable all possible XZ rotations,
        // rather than just two axis-aligned scalings.
        float angle = random.nextFloat() * Mth.TWO_PI;

        // Set up for ellipsoid.
        EllipsoidWithHorizontalRotation ellipsoid = EllipsoidWithHorizontalRotation.create(
                uRadius, vRadius, yRadius, angle
        );
        int xzRadiusLoopBound = Mth.floor(Math.max(uRadius, vRadius));
        int yRadiusLoopBound = Mth.floor(yRadius);

        ArrayList<BlockPos> caveAirPositions = new ArrayList<>();

        float cumulativeThresholdMultiplier = 1;
        for (int indexInStack = 0; indexInStack < stackHeight; indexInStack++) {

            for (int x = -xzRadiusLoopBound; x <= xzRadiusLoopBound; x++) {
                for (int z = -xzRadiusLoopBound; z <= xzRadiusLoopBound; z++) {
                    for (int y = -yRadiusLoopBound; y <= yRadiusLoopBound; y++) {
                        positionBeingEvaluatedMutable.set(displacedOriginMutable).move(x, y, z);

                        // 1 marks the ellipsoid boundary. No carving outside regardless of noise value.
                        // cumulativeThresholdMultiplier applies config.radiusDivisorPerStack's intended effect here.
                        float ellipsoidValue = ellipsoid.getValue(x, y, z) * cumulativeThresholdMultiplier;
                        if (ellipsoidValue > 1) {
                            continue;
                        }

                        // NOISE_MODULATION_THRESHOLD_LOWER_BOUND marks the soonest boundary with max noise modulation.
                        if (ellipsoidValue > NOISE_MODULATION_THRESHOLD_LOWER_BOUND) {
                            float noiseValue = OpenSimplex2.noise3_ImproveXZ(noiseSeed,
                                    positionBeingEvaluatedMutable.getX() * noiseFrequency,
                                    positionBeingEvaluatedMutable.getY() * noiseFrequency,
                                    positionBeingEvaluatedMutable.getZ() * noiseFrequency
                            );
                            noiseValue = noiseValue * 0.5f + 0.5f;
                            float noisyEllipsoidValue = ellipsoidValue + noiseValue * (1 - NOISE_MODULATION_THRESHOLD_LOWER_BOUND);

                            // If the noise has us skip this block, don't carve.
                            if (noisyEllipsoidValue > 1) {
                                continue;
                            }
                        }

                        if (world.getBlockState(positionBeingEvaluatedMutable).canOcclude()) {
                            if (positionBeingEvaluatedMutable.getY() <= FIXED_LIQUID_LEVEL) {
                                placeFluid(world, config.fluidState(), positionBeingEvaluatedMutable);
                            } else {
                                BlockState state = config.blockProvider().getState(random, positionBeingEvaluatedMutable);
                                if (state.isAir()) {
                                    caveAirPositions.add(positionBeingEvaluatedMutable.immutable());
                                }
                                world.setBlock(positionBeingEvaluatedMutable, state, 2);

                                // Remove non-solids
                                for (int i = 0; i < 8; i++) {
                                    BlockState blockState = world.getBlockState(positionBeingEvaluatedMutable);
                                    if ((!blockState.canOcclude() && !blockState.isAir()) || blockState.is(BYGBlocks.CRYPTIC_VENT.get()) || blockState.is(BYGBlocks.TALL_CRYPTIC_VENT.get()) || blockState.is(BYGBlocks.CRYPTIC_FIRE.get())) {
                                        world.removeBlock(positionBeingEvaluatedMutable, false);
                                    }
                                    positionBeingEvaluatedMutable.move(Direction.UP);
                                }
                            }
                        }
                    }
                }
            }

            for (BlockPos blockPos : caveAirPositions) {
                for (Holder<PlacedFeature> spawningFeature : config.spawningFeatures()) {
                    spawningFeature.value().place(world, chunkGenerator, random, blockPos);
                }
            }

            cumulativeThresholdMultiplier *= thresholdMultiplierPerStack;
        }
        return true;
    }

    private static void placeFluid(WorldGenLevel world, FluidState fluidState, BlockPos.MutableBlockPos mutable2) {
        boolean isSolidAllAround = true;
        for (Direction direction : Direction.values()) {
            if (direction != Direction.UP) {
                BlockState blockState = world.getBlockState(mutable2.relative(direction));
                if (blockState.getFluidState().getType() == fluidState.getType())
                    continue;

                if (!blockState.canOcclude()) {
                    isSolidAllAround = false;
                    break;
                }
            }
        }

        if (isSolidAllAround) {
            world.setBlock(mutable2, fluidState.createLegacyBlock().getBlock().defaultBlockState(), 2);
            world.scheduleTick(mutable2, fluidState.getType(), 0);
        }
    }
}
