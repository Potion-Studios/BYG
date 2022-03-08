package potionstudios.byg.common.world.feature.gen.overworld;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.NoisySphereConfig;
import potionstudios.byg.common.world.feature.config.SimpleBlockProviderConfig;
import potionstudios.byg.common.world.math.noise.fastnoise.FastNoise;
import potionstudios.byg.util.blendingfunction.BlendingFunctions;

import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import static net.minecraft.util.Mth.lerp;

public class ArchFeature extends Feature<SimpleBlockProviderConfig> {

    public ArchFeature(Codec<SimpleBlockProviderConfig> configCodec) {
        super(configCodec);
    }

    protected long seed;
    protected static FastNoise fastNoise;


    @Override
    public boolean place(FeaturePlaceContext<SimpleBlockProviderConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator chunkGenerator, Random random, BlockPos center, SimpleBlockProviderConfig config) {
        setSeed(world.getSeed());
        double angle = random.nextDouble(Math.PI);

        ChunkPos chunkPos = new ChunkPos(center);
        center = chunkPos.getMiddleBlockPosition(center.getY());

        int distance = 40 + random.nextInt(6);
        int archHeight = 25 + random.nextInt(10);
        center = center.offset(0, archHeight, 0);

        double xOffset = Math.sin(angle) * distance;
        double zOffset = Math.cos(angle) * distance;

        WeightedStateProvider blockProvider = new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(BYGBlocks.RED_ROCK.defaultBlockState(), 4)
            .add(Blocks.TERRACOTTA.defaultBlockState(), 1)
        );
        NoisySphereConfig build = new NoisySphereConfig.Builder()
            .withRadiusSettings(
                new NoisySphereConfig.RadiusSettings(UniformInt.of(10, 15), UniformInt.of(10, 15), 0, UniformInt.of(10, 15))
            ).withBlockProvider(
                blockProvider
            ).withNoiseFrequency(0.02F)
            .withTopBlockProvider(
                blockProvider
            )
            .build();

        BlockPos start = center.offset(-xOffset, 0, -zOffset);
        start = new BlockPos(start.getX(), world.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, start.getX(), start.getZ()) - 5, start.getZ());
        BlockPos end = center.offset(xOffset, 0, zOffset);
        end = new BlockPos(end.getX(), world.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, end.getX(), end.getZ()) - 5, end.getZ());


        Set<BlockPos> spherePositions = new HashSet<>();

        int points = 1000;
        for (int pointCount = points; pointCount >= 1; pointCount--) {
            double factor = (double) pointCount / points;
            spherePositions.add(new BlockPos(lerp(factor, start.getX(), center.getX()), easeOutCubic(factor, start.getY(), center.getY()), lerp(factor, start.getZ(), center.getZ())));
            spherePositions.add(new BlockPos(lerp(factor, end.getX(), center.getX()), easeOutCubic(factor, end.getY(), center.getY()), lerp(factor, end.getZ(), center.getZ())));
        }

        for (BlockPos spherePosition : spherePositions) {
            int size = 1;
            BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
            BYGFeatures.BOULDER.place(new FeaturePlaceContext<>(Optional.empty(), world, chunkGenerator, random, spherePosition, build));

            for (int x = -size; x <= size; x++) {
                for (int y = -size; y <= size; y++) {
                    for (int z = -size; z <= size; z++) {
                        mutableBlockPos.set(spherePosition).move(x, y, z);

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

    public static double easeOutCubic(double factor, double min, double max) {
        double range = max - min;
        return min + (range * BlendingFunctions.easeOutCubic(factor));
    }
}
