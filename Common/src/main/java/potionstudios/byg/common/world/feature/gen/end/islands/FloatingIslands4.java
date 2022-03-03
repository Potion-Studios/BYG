package potionstudios.byg.common.world.feature.gen.end.islands;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.material.Fluids;
import potionstudios.byg.common.world.feature.config.FloatingIslandConfig;
import potionstudios.byg.common.world.math.noise.fastnoise.lite.FastNoiseLite;

import java.util.Random;

public class FloatingIslands4 extends Feature<FloatingIslandConfig> {

    FastNoiseLite perlin = null;

    public FloatingIslands4(Codec<FloatingIslandConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<FloatingIslandConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }
    
    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random rand, BlockPos pos, FloatingIslandConfig config) {
        setSeed(world.getSeed());


        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(pos);

        double radius = 11;
        double size = radius / 3;
        double radiusHalved = radius / 2;

        //The actual island!
        for (double x = -radius - 5; x <= radius + 5; x++) {
            for (double y = 1; y <= radius + 5; y++) {
                for (double z = -radius - 5; z <= radius + 5; z++) {
                    mutable.set(pos).move((int) x, (int) y, (int) z);
                    double noise = FastNoiseLite.getSpongePerlinValue(perlin.GetNoise(mutable.getX(), mutable.getY(), mutable.getZ()));
                    double distanceSqt1 = x * x + y * y + z * z + noise * noise;
                    if (distanceSqt1 <= radius * radius) {
                        if (y == 1)
                            world.setBlock(mutable, config.getTopBlockProvider().getState(rand, mutable), 2);
                        else
                            world.setBlock(mutable, config.getBlockProvider().getState(rand, mutable), 2);

                    }
                }
            }
        }

        //Pool of water in the middle of the island!
        for (double x = -radiusHalved; x <= radiusHalved; x++) {
            for (double y = 2; y <= size; y++) {
                for (double z = -radiusHalved; z <= radiusHalved; z++) {
                    mutable.set(pos).move((int) x, (int) y, (int) z);
                    double distanceSqt1 = x * x + y * y + z * z;
                    if (distanceSqt1 <= radiusHalved * radiusHalved) {
                        world.setBlock(mutable, Blocks.WATER.defaultBlockState(), 2);
                        world.scheduleTick(mutable, Fluids.WATER, 0);
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
