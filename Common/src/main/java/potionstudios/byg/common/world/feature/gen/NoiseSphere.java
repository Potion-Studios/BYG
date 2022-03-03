package potionstudios.byg.common.world.feature.gen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import potionstudios.byg.common.world.feature.config.NoisySphereConfig;
import potionstudios.byg.common.world.feature.config.RadiusMatcher;
import potionstudios.byg.common.world.math.noise.fastnoise.FastNoise;

import java.util.Random;

public class NoiseSphere extends Feature<NoisySphereConfig> {
    protected static FastNoise fastNoise;
    protected long seed;

    public NoiseSphere(Codec<NoisySphereConfig> configCodec) {
        super(configCodec);
    }


    @Override
    public boolean place(FeaturePlaceContext<NoisySphereConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator chunkGenerator, Random random, BlockPos position, NoisySphereConfig config) {
        setSeed(world.getSeed(), config.noiseFrequency());

        boolean use2D = random.nextDouble() < config.noise2DChance();
        RadiusMatcher radiusMatcher = config.radiusMatcher();

        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(position);
        BlockPos.MutableBlockPos mutable2 = new BlockPos.MutableBlockPos().set(mutable);
        NoisySphereConfig.RadiusSettings radiusSettings = config.radiusSettings();
        int xRadius = radiusSettings.xRadius().sample(random) / 2;
        int yRadius = radiusMatcher == RadiusMatcher.ALL ? xRadius : radiusSettings.yRadius().sample(random);
        int zRadius = radiusMatcher == RadiusMatcher.ALL || radiusMatcher == RadiusMatcher.XZ ? xRadius : (radiusSettings.zRadius().sample(random) / 2);

        int lowestX = position.getX();
        int lowestY = position.getY();
        int lowestZ = position.getZ();

        int stackHeight = config.stackHeight().sample(random);
        for (int stackIDX = 0; stackIDX < stackHeight; stackIDX++) {
            for (int x = -xRadius; x <= xRadius; x++) {
                float xFract = x / (float) xRadius;
                for (int z = -zRadius; z <= zRadius; z++) {
                    float zFract = z / (float) zRadius;
                    for (int y = -yRadius; y <= yRadius + radiusSettings.upperHalfAdditional(); y++) {
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


                        int squaredDistance = (x * x) + (y * y) + (z * z);
                        if (config.checkSquareDistance() && squaredDistance >= xRadius * zRadius) {
                            continue;
                        }

                        world.setBlock(mutable2, config.topBlockProvider().getState(random, mutable2), 2);
                        world.setBlock(mutable2.move(Direction.DOWN), config.blockProvider().getState(random, mutable2), 2);
                        lowestX = Math.min(lowestX, mutable2.getX());
                        lowestY = Math.min(lowestY, mutable2.getY());
                        lowestZ = Math.min(lowestZ, mutable2.getZ());
                    }
                }
            }
            xRadius = (int) (xRadius / config.radiusDivisorPerStack());
            yRadius = (int) (yRadius * 0.1F);
            mutable.setY(mutable.getY() + yRadius);
            zRadius = (int) (zRadius / config.radiusDivisorPerStack());
        }
        for (Holder<PlacedFeature> spawningFeature : config.spawningFeatures()) {
            spawningFeature.value().place(world, chunkGenerator, random, new BlockPos(lowestX, lowestY, lowestZ));
        }

        return true;
    }


    public void setSeed(long seed, float noiseFreq) {
        if (this.seed != seed || fastNoise == null) {
            fastNoise = new FastNoise((int) seed);
            fastNoise.SetNoiseType(FastNoise.NoiseType.Cellular);
            this.seed = seed;
        }
        fastNoise.SetFrequency(noiseFreq);
    }
}