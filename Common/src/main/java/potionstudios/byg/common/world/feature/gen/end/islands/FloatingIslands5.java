package potionstudios.byg.common.world.feature.gen.end.islands;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import potionstudios.byg.common.world.feature.config.FloatingIslandConfig;
import potionstudios.byg.common.world.math.noise.fastnoise.lite.FastNoiseLite;

import java.util.Random;

public class FloatingIslands5 extends Feature<FloatingIslandConfig> {

    FastNoiseLite perlin = null;

    public FloatingIslands5(Codec<FloatingIslandConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<FloatingIslandConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }
    
    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random rand, BlockPos pos, FloatingIslandConfig config) {
        setSeed(world.getSeed());

        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(pos);
        double radius = (double) (rand.nextInt(Math.max(1, config.getMaxPossibleRadius() - config.getMinRadius())) + config.getMinRadius()) / 2;

        //The island itself
        for (double x = -radius - 2; x <= radius + 2; x++) {
            for (double y = 1; y <= radius + 11; y++) {
                for (double z = -radius - 2; z <= radius + 2; z++) {
                    mutable.set(pos).move((int) x, (int) y - 22, (int) z);
                    double noise = FastNoiseLite.getSpongePerlinValue(perlin.GetNoise(mutable.getX(), mutable.getY(), mutable.getZ()));
                    double scaledNoise = (noise) * ((Math.pow((y / 4), 2)) / ((Math.pow(x, 2)) + (Math.pow(z, 2))));
                    if (scaledNoise >= 0.5) {
                        if (y == 36) {
                            world.setBlock(mutable, config.getTopBlockProvider().getState(rand, mutable), 2);
                        } else
                            world.setBlock(mutable, config.getBlockProvider().getState(rand, mutable), 2);
                    }
                }
            }
        }
        for (Holder<PlacedFeature> feature : config.getPlacedFeatures()) {
            feature.value().place(world, generator, rand, pos.above(2));
        }

        return true;
    }


    public void setSeed(long seed) {
        if (perlin == null) {
            perlin = FastNoiseLite.createSpongePerlin((int) seed);
            perlin.SetFrequency(0.2F);
        }
    }
}

