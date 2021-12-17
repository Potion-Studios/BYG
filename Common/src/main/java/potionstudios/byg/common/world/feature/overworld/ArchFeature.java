package potionstudios.byg.common.world.feature.overworld;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.random.SimpleWeightedRandomList;
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
import potionstudios.byg.util.noise.fastnoise.FastNoise;

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
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(pos);
        int curveLength = 10;
        boolean zAxis = random.nextInt(2) == 0;

        BlockPos.MutableBlockPos mutable2 = new BlockPos.MutableBlockPos();
        float curviness = Mth.lerp(random.nextFloat(), 0.05F, 0.4F);
        for (int z = -curveLength; z <= curveLength; z++) {
            mutable2.set(mutable.getX() + (!zAxis ? z : 0), 0, mutable.getZ() + (zAxis ? z : 0));
            int height = getArchHeight(z, curviness);
            mutable2.move(Direction.UP, height + pos.getY() + 15);

            int worldHeight = world.getHeight(Heightmap.Types.WORLD_SURFACE_WG, mutable2.getX(), mutable2.getZ());
            if(worldHeight - 5 < mutable2.getY()) {
                FeaturePlaceContext<NoisySphereConfig> featurePlaceContext = new FeaturePlaceContext<>(Optional.empty(), world, chunkGenerator, random, mutable2, new NoisySphereConfig.Builder().setBlock(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.TERRACOTTA.defaultBlockState(), 5).add(BYGBlocks.RED_ROCK.defaultBlockState(), 5))).setMinXRadius(4).setMaxXRadius(7).setMinZRadius(4).setMaxZRadius(7).setMinYRadius(7).setMaxYRadius(10).build());
                BYGFeatures.NOISY_SPHERE.place(featurePlaceContext);
                // Make sure we find a floor and connect it.
                if (z == -curveLength || z == curveLength) {
                    while (mutable2.getY() > worldHeight - 5) {
                        BYGFeatures.NOISY_SPHERE.place(featurePlaceContext);
                        mutable2.move(Direction.DOWN, 3);
                    }
                }
            }
        }
        return true;
    }

    public static int getArchHeight(int z, float curviness) {
        return (int) ((-z * z) * curviness);
    }


    public void setSeed(long seed) {
        if (this.seed != seed || fastNoise == null) {
            fastNoise = new FastNoise((int) seed);
            fastNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
            this.seed = seed;
        }
    }
}