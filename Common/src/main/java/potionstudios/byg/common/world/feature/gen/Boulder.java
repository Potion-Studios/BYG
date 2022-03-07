package potionstudios.byg.common.world.feature.gen;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import potionstudios.byg.common.world.feature.config.NoisySphereConfig;
import potionstudios.byg.common.world.math.noise.fastnoise.FastNoise;

import java.util.Random;

public class Boulder extends Feature<NoisySphereConfig> {
    protected static FastNoise fastNoise;
    protected long seed;

    public Boulder(Codec<NoisySphereConfig> configCodec) {
        super(configCodec);
    }


    @Override
    public boolean place(FeaturePlaceContext<NoisySphereConfig> featurePlaceContext) {
        BlockPos origin = featurePlaceContext.origin();
        Random random = featurePlaceContext.random();
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

    public void fillList(Long2ObjectMap<BlockState> positions, long seed, Random random, BlockPos origin, NoisySphereConfig config) {
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


    public boolean place(Application application, long seed, Random random, BlockPos origin, NoisySphereConfig config) {
        setSeed(seed);

        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(origin);
        BlockPos.MutableBlockPos mutable2 = new BlockPos.MutableBlockPos().set(mutable);
        int stackHeight = config.stackHeight().sample(random);
        NoisySphereConfig.RadiusSettings radiusSettings = config.radiusSettings();
        int xRadius = radiusSettings.xRadius().sample(random) / 2;
        int yRadius = radiusSettings.yRadius().sample(random) / 2;
        int zRadius = radiusSettings.zRadius().sample(random) / 2;
        fastNoise.SetFrequency(config.noiseFrequency());

        double xRadiusSquared = xRadius * xRadius;
        double yRadiusSquared = yRadius * yRadius;
        double zRadiusSquared = zRadius * zRadius;

        for (int stackIDX = 0; stackIDX < stackHeight; stackIDX++) {
            for (int x = -xRadius; x <= xRadius; x++) {
                for (int z = -zRadius; z <= zRadius; z++) {
                    for (int y = yRadius; y >= -yRadius; y--) {
                        mutable2.set(mutable).move(x, y, z);

                        if (application.isOccupied(mutable2)) {
                            continue;
                        }
                        //Credits to Hex_26 for this equation!
                        double equationResult = (x * x) / xRadiusSquared + (y * y) / yRadiusSquared + (z * z) / zRadiusSquared;
                        double threshold = 1 + 0.7 * fastNoise.GetNoise(mutable2.getX(), mutable2.getY(), mutable2.getZ());
                        if (equationResult >= threshold)
                            continue;

                        BlockState state = config.blockProvider().getState(random, mutable2);
                        application.apply(mutable2, state);
                    }
                }
            }


        }
        return true;
    }


    public void setSeed(long seed) {
        if (this.seed != seed || fastNoise == null) {
            fastNoise = new FastNoise((int) seed);
            fastNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
            this.seed = seed;
        }
    }

    public interface Application {
        void apply(BlockPos pos, BlockState state);

        boolean isOccupied(BlockPos blockPos);
    }


}