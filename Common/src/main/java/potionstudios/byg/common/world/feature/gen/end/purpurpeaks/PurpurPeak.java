package potionstudios.byg.common.world.feature.gen.end.purpurpeaks;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.material.Material;
import potionstudios.byg.common.world.feature.config.SimpleBlockProviderConfig;
import potionstudios.byg.common.world.math.noise.fastnoise.lite.FastNoiseLite;

import java.util.Random;

public class PurpurPeak extends Feature<SimpleBlockProviderConfig> {

    FastNoiseLite fnlPerlin = null;

    public PurpurPeak(Codec<SimpleBlockProviderConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<SimpleBlockProviderConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random rand, BlockPos pos, SimpleBlockProviderConfig config) {
        setSeed(world.getSeed());


        if (world.getBlockState(pos.below()).getMaterial() == Material.AIR || world.getBlockState(pos.below()).getMaterial() == Material.WATER || world.getBlockState(pos.below()).getMaterial() == Material.LAVA || world.getHeight(Heightmap.Types.MOTION_BLOCKING, pos.getX(), pos.getZ()) < 4)
            return false;


        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

        double baseRadius = 15;
        int peakHeight = 125;
        int peakStartHeight = peakHeight - 5;
        double threshold = 0.5;

        for (double y = -peakHeight; y <= peakHeight; y++) {
            for (double x = -peakHeight; x <= peakHeight; x++) {
                for (double z = -peakHeight; z <= peakHeight; z++) {
                    mutable.set(pos).move((int) x, (int) y + peakStartHeight, (int)z);
                    float noise3 = FastNoiseLite.getSpongePerlinValue(fnlPerlin.GetNoise(mutable.getX(), mutable.getZ()));
                    double scaledNoise = (noise3 / 11) * (-(y * baseRadius) / ((x * x) + (z * z)));
                    if (y == -peakHeight) {
                        if (scaledNoise >= threshold)
                            if (world.getBlockState(mutable.relative(Direction.DOWN)).getMaterial() == Material.AIR)
                                return false;
                    }

                    if (scaledNoise >= threshold) {
                        if (world.isEmptyBlock(mutable))
                            world.setBlock(mutable, config.getBlockProvider().getState(rand, mutable), 2);
                    }
                }
            }
        }
        return true;
    }


    public void setSeed(long seed) {
        if (fnlPerlin == null) {
            fnlPerlin = FastNoiseLite.createSpongePerlin((int) seed);
            fnlPerlin.SetFrequency(0.2F);
        }
    }
}
