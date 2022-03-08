package potionstudios.byg.common.world.feature.gen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.util.Mth;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import potionstudios.byg.common.world.feature.config.NoisySphereConfig;
import potionstudios.byg.common.world.feature.config.RadiusMatcher;
import potionstudios.byg.common.world.math.noise.fastnoise.FastNoise;

import java.util.Random;

public class Spike extends Feature<NoisySphereConfig> {
    protected static FastNoise fastNoise;
    protected long seed;

    public Spike(Codec<NoisySphereConfig> configCodec) {
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
        int xRadius = (int) ((double) radiusSettings.xRadius().sample(random) / 2);
        int yRadius = radiusMatcher == RadiusMatcher.ALL ? xRadius : (int) (double) (radiusSettings.yRadius().sample(random) / 2);
        int zRadius = radiusMatcher == RadiusMatcher.ALL || radiusMatcher == RadiusMatcher.XZ ? xRadius : (int) (double) (radiusSettings.zRadius().sample(random) / 2);

        int lowestX = position.getX();
        int lowestY = position.getY();
        int lowestZ = position.getZ();

        boolean verifiedHeight = !config.verfiesHeight();
        float perlin = fastNoise.GetPerlin((float) position.getX(), (float) position.getY(), (float) position.getZ());
        double scaledNoise = (perlin) * 8;


        double centerHeight = Mth.lerp(scaledNoise, 2, 7) + 10;

        int stackHeight = config.stackHeight().sample(random);

        int[][] built = new int[xRadius * 2 + 1][zRadius * 2 + 1];
        for (int stackIDX = 0; stackIDX <= stackHeight; ) {
            for (int x = -xRadius; x <= xRadius; x++) {
                mutable2.setX(mutable.getX() + x);
                double xFract = (double) x / xRadius;
                for (int z = -zRadius; z <= zRadius; z++) {
                    mutable2.setZ(mutable.getZ() + z);
                    double zFract = (double) z / zRadius;

                    if (verifiedHeight) {
                        double addedHeight = config.useScaledNoiseHeight() ? getScaledNoiseExtensionHeight(mutable2, centerHeight) : 1;
                        if (addedHeight > built[x + xRadius][z + zRadius]) {

                            for (double y = -yRadius; y <= yRadius; y++) {
                                double yFract = y / yRadius;
                                mutable2.setY((int) (mutable.getY() + y));

                                //Credits to Hex_26 for this equation!
                                double distanceSquaredFromCenter = xFract * xFract + yFract * yFract + zFract * zFract;
                                double yDistSquared = yFract * yFract;
                                float noise = use2D ? fastNoise.GetNoise(mutable2.getX(), mutable2.getZ()) : fastNoise.GetNoise(mutable2.getX(), mutable2.getY(), mutable2.getZ());
                                float threshold = 1 + 0.7f * noise;

                                // check whether the center of this column at this Y would be empty
                                double factor = yDistSquared / threshold;
                                if (factor >= 1) {
                                    // make sure it's not empty
                                    distanceSquaredFromCenter /= factor;
                                    // add some extra noise back to make it not just a thin one block column
                                    // the magnitude of the noise can be configurable
                                    // this should probably be using its own noise for best effect
                                    distanceSquaredFromCenter -= Math.copySign(noise * 0.2, distanceSquaredFromCenter);
                                }
//                            if (distanceSquaredFromCenter >= threshold) {
//                                continue;
//                            }


                                double density = stackIDX == stackHeight && config.pointed() ? (y + yRadius + 1) / ((yRadius * 2) + 1) : 0;

                                double squaredDistance = ((x * x) + (z * z)) / Mth.clampedLerp(0.1, 1, 1 - density);
                                if (config.checkSquareDistance() && squaredDistance >= xRadius * zRadius) {
                                    continue;
                                }

                                BlockPos.MutableBlockPos mutable3 = new BlockPos.MutableBlockPos().set(mutable2);

                                for (int noiseExtensionY = 0; noiseExtensionY < addedHeight; noiseExtensionY++) {
                                    int minY = Math.min(position.getY(), world.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, mutable3.getX(), mutable3.getZ()));
                                    boolean belowSurfaceDepth = minY - mutable3.getY() < config.belowSurfaceDepth().sample(random);
//                                    if (!config.verfiesHeight() || belowSurfaceDepth) {
                                    world.setBlock(mutable3, config.topBlockProvider().getState(random, mutable3), 2);
                                    world.setBlock(mutable3.relative(Direction.DOWN), config.blockProvider().getState(random, mutable3), 2);
//                                    }
                                    mutable3.move(Direction.UP);
                                }

                                built[x + xRadius][z + zRadius] = Math.max(mutable3.getY(), built[x + xRadius][z + zRadius]);

                                lowestX = Math.min(lowestX, mutable2.getX());
                                lowestY = Math.min(lowestY, mutable2.getY());
                                lowestZ = Math.min(lowestZ, mutable2.getZ());
                            }
                        }
                    } else {
                        int oceanFloor = world.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, mutable2.getX(), mutable2.getZ());

                        if (world.isOutsideBuildHeight(oceanFloor - 1) || position.getY() - oceanFloor > 15) {
                            return false;
                        }
                    }
                }
            }
            if (verifiedHeight) {
//                xRadius = Math.max(xRadius / config.radiusDivisorPerStack(), 1);
//                yRadius = Math.max(yRadius * 0.1F, 1);
                mutable.setY((int) (mutable.getY() + yRadius));
//                zRadius = Math.max(zRadius / config.radiusDivisorPerStack(), 1);
                stackIDX++;
            }
            verifiedHeight = true;
        }
        for (Holder<PlacedFeature> spawningFeature : config.spawningFeatures()) {
            spawningFeature.value().place(world, chunkGenerator, random, new BlockPos(lowestX, lowestY, lowestZ));
        }

        return true;
    }

    private double getScaledNoiseExtensionHeight(BlockPos.MutableBlockPos mutable2, double centerHeight) {
        float perlin1 = Math.abs(fastNoise.GetPerlin((float) mutable2.getX(), (float) mutable2.getZ()));
        double height = Mth.lerp(perlin1, 2, 5);
        return Mth.lerp(perlin1, height, centerHeight + 25);
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