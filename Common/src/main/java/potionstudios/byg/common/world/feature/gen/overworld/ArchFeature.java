package potionstudios.byg.common.world.feature.gen.overworld;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.NoisySphereConfig;
import potionstudios.byg.common.world.feature.config.SimpleBlockProviderConfig;
import potionstudios.byg.common.world.math.noise.fastnoise.FastNoise;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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

    public boolean place(WorldGenLevel world, ChunkGenerator chunkGenerator, Random random, BlockPos pos, SimpleBlockProviderConfig config) {
        setSeed(world.getSeed());
        double angle = random.nextDouble(Math.PI);

        int distance = 12;
        int archHeight = 20;
        pos = pos.offset(0, archHeight, 0);

        double xOffset = Math.sin(angle + Math.PI) * distance;
        double zOffset = Math.cos(angle + Math.PI) * distance;

        NoisySphereConfig build = new NoisySphereConfig.Builder()
            .withRadiusSettings(
                new NoisySphereConfig.RadiusSettings(UniformInt.of(5, 10), UniformInt.of(5, 10), 0, UniformInt.of(5, 10))
            ).withBlockProvider(
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(Blocks.GRANITE.defaultBlockState(), 4)
                    .add(Blocks.POLISHED_GRANITE.defaultBlockState(), 1)
                )
            ).withNoiseFrequency(0.02F)
            .withTopBlockProvider(
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(Blocks.GRANITE.defaultBlockState(), 4)
                    .add(Blocks.POLISHED_GRANITE.defaultBlockState(), 1)
                )
            )
            .build();

        BlockPos start = pos.offset(-xOffset, 0, -zOffset);
        start = new BlockPos(start.getX(), world.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, start.getX(), start.getZ()), start.getZ());
        BlockPos end = pos.offset(xOffset, 0, zOffset);
        end = new BlockPos(end.getX(), world.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, end.getX(), end.getZ()), end.getZ());


        List<BlockPos> spherePositions = new ArrayList<>();

        int points = 10;
        for (int pointCount = points; pointCount >= 1; pointCount--) {
            double lerpStrength = (double) pointCount / points;
            spherePositions.add(new BlockPos(Mth.lerp(lerpStrength, start.getX(), pos.getX()), Mth.lerp(lerpStrength, start.getY(), pos.getY()), Mth.lerp(lerpStrength, start.getZ(), pos.getZ())));
            spherePositions.add(new BlockPos(Mth.lerp(lerpStrength, pos.getX(), end.getX()), Mth.lerp(lerpStrength, pos.getY(), end.getY()), Mth.lerp(lerpStrength, pos.getZ(), end.getZ())));
        }

        for (BlockPos spherePosition : spherePositions) {
            BYGFeatures.BOULDER.place(new FeaturePlaceContext<>(Optional.empty(), world, chunkGenerator, random, spherePosition, build));
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
}