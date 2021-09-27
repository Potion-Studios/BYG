package corgiaoc.byg.common.world.feature;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.NoisySphereConfig;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import java.util.Random;

public class Column extends Feature<NoisySphereConfig> {
    protected static FastNoise fastNoise;
    protected long seed;

    public Column(Codec<NoisySphereConfig> configCodec) {
        super(configCodec);
    }


    @Override
    public boolean place(FeaturePlaceContext<NoisySphereConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator chunkGenerator, Random random, BlockPos position, NoisySphereConfig config) {
        setSeed(world.getSeed());
//        if (random.nextInt(2) != 0) {
//            return true;
//        }
        boolean use2D = random.nextInt(5) == 0;

        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(position.below(2 + random.nextInt(10)));
        BlockPos.MutableBlockPos mutable2 = new BlockPos.MutableBlockPos().set(mutable);
        int stackHeight = random.nextInt(config.getMaxPossibleHeight()) + config.getMinHeight();
        int xRadius = config.getRandomXRadius(random);
        int yRadius = config.getRandomYRadius(random) * 2 + 10;
        int zRadius = config.getRandomZRadius(random);

        for (int stackIDX = 0; stackIDX < 2; stackIDX++) {
            for (int x = -xRadius; x <= xRadius; x++) {
                float xFract = x / (float) xRadius;
                for (int z = -zRadius; z <= zRadius; z++) {
                    float zFract = z / (float) zRadius;
                    for (int y = -yRadius; y <= yRadius + 15; y++) {
                        float yFract = y / (float) yRadius;

                        mutable2.set(mutable).move(x, y, z);
                        //Credits to Hex_26 for this equation!
                        float distanceSquaredFromCenter = xFract * xFract + yFract * yFract + zFract * zFract;
                        float yDistSquared = yFract * yFract;
                        float noise = use2D ? fastNoise.GetNoise(mutable2.getX(), mutable2.getZ()) : fastNoise.GetNoise(mutable2.getX(), mutable2.getY(), mutable2.getZ());
                        float threshold = 1 + 0.7f * noise;

                        // check whether the center of this column at this Y would be empty
                        float factor = yDistSquared / threshold;
                        if (factor >= 1) {
                            // make sure it's not empty
                            distanceSquaredFromCenter /= factor;
                            // add some extra noise back to make it not just a thin one block column
                            // the magnitude of the noise can be configurable
                            // this should probably be using its own noise for best effect
                            distanceSquaredFromCenter -= Math.copySign(noise * 0.2, distanceSquaredFromCenter);
                        }
                        if (distanceSquaredFromCenter >= threshold) {
                            continue;
                        }

                        world.setBlock(mutable2, config.getTopBlockProvider().getState(random, mutable2), 2);
                        world.setBlock(mutable2.move(Direction.DOWN), config.getBlockProvider().getState(random, mutable2), 2);
                    }
                }
            }
                xRadius = (int) (xRadius / config.getRadiusDivisorPerStack());
                yRadius = (int) (yRadius  * 0.1F);
                mutable.setY(mutable.getY() + yRadius);
                zRadius = (int) (zRadius / config.getRadiusDivisorPerStack());
        }
        return true;
    }


    public void setSeed(long seed) {
        if (this.seed != seed || fastNoise == null) {
            fastNoise = new FastNoise((int) seed);
            fastNoise.SetNoiseType(FastNoise.NoiseType.Cellular);
            fastNoise.SetFrequency(0.09f);
            this.seed = seed;
        }
    }
}