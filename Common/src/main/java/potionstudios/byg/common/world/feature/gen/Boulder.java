package potionstudios.byg.common.world.feature.gen;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import potionstudios.byg.common.world.feature.config.NoisySphereConfig;
import potionstudios.byg.common.world.math.EllipsoidWithHorizontalRotation;
import potionstudios.byg.common.world.math.noise.simplex.OpenSimplex2;

public class Boulder extends Feature<NoisySphereConfig> {
    private static final float NOISE_MODULATION_THRESHOLD_LOWER_BOUND = 0.35f;
    private static final long SEED_FLIP_MASK = 0x686BF60CDB362A13L;

    public Boulder(Codec<NoisySphereConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoisySphereConfig> featurePlaceContext) {
        BlockPos origin = featurePlaceContext.origin();
        RandomSource random = featurePlaceContext.random();
        ChunkGenerator chunkGenerator = featurePlaceContext.chunkGenerator();
        WorldGenLevel level = featurePlaceContext.level();
        boolean place = place(new Application() {
            @Override
            public void apply(BlockPos pos, BlockState state) {
                level.setBlock(pos, state, 2);
            }

            @Override
            public boolean isOccupied(BlockPos blockPos) {
                return false;
            }
        }, level.getSeed(), random, origin, featurePlaceContext.config());

        for (Holder<PlacedFeature> spawningFeature : featurePlaceContext.config().spawningFeatures()) {
            spawningFeature.value().place(level, chunkGenerator, random, origin);
        }
        return place;
    }

    public void fillList(Long2ObjectMap<BlockState> positions, long seed, RandomSource random, BlockPos origin, NoisySphereConfig config) {
        place(new Application() {
            @Override
            public void apply(BlockPos pos, BlockState state) {
                 positions.put(pos.asLong(), state);
            }

            @Override
            public boolean isOccupied(BlockPos blockPos) {
                return positions.containsKey(blockPos.asLong());
            }
        }, seed, random, origin, config);
    }


    public boolean place(Application application, long worldSeed, RandomSource random, BlockPos origin, NoisySphereConfig config) {
        long noiseSeed = worldSeed ^ SEED_FLIP_MASK;

        BlockPos.MutableBlockPos originMutable = new BlockPos.MutableBlockPos().set(origin);
        BlockPos.MutableBlockPos positionBeingEvaluatedMutable = new BlockPos.MutableBlockPos().set(originMutable);

        // All configs.
        NoisySphereConfig.RadiusSettings radiusSettings = config.radiusSettings();
        int stackHeight = config.stackHeight().sample(random);
        float uRadius = radiusSettings.xRadius().sample(random);
        float vRadius = radiusSettings.zRadius().sample(random);
        float yRadius = radiusSettings.yRadius().sample(random);
        double noiseFrequency = config.noiseFrequency();

        // Isotropy as a design principle: enable all possible XZ rotations,
        // rather than just two axis-aligned scalings.
        float angle = random.nextFloat() * Mth.TWO_PI;

        // Set up for ellipsoid.
        EllipsoidWithHorizontalRotation ellipsoid = EllipsoidWithHorizontalRotation.create(
                uRadius, vRadius, yRadius, angle
        );
        int xzRadiusLoopBound = Mth.floor(Math.max(uRadius, vRadius));
        int yRadiusLoopBound = Mth.floor(yRadius);

        for (int indexInStack = 0; indexInStack < stackHeight; indexInStack++) {
            for (int x = -xzRadiusLoopBound; x <= xzRadiusLoopBound; x++) {
                for (int z = -xzRadiusLoopBound; z <= xzRadiusLoopBound; z++) {
                    for (int y = yRadiusLoopBound; y >= -yRadiusLoopBound; y--) {
                        positionBeingEvaluatedMutable.set(originMutable).move(x, y, z);

                        if (application.isOccupied(positionBeingEvaluatedMutable)) {
                            continue;
                        }

                        // 1 marks the ellipsoid boundary. No placing outside regardless of noise value.
                        float ellipsoidValue = ellipsoid.getValue(x, y, z);
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

                            // If the noise has us skip this block, don't place.
                            if (noisyEllipsoidValue > 1) {
                                continue;
                            }
                        }

                        // Place the block.
                        BlockState state = config.blockProvider().getState(random, positionBeingEvaluatedMutable);
                        application.apply(positionBeingEvaluatedMutable, state);
                    }
                }
            }
        }
        return true;
    }

    public interface Application {
        void apply(BlockPos pos, BlockState state);
        boolean isOccupied(BlockPos blockPos);
    }

}
