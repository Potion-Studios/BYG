package corgiaoc.byg.common.world.feature.nether.spike;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.SimpleBlockProviderConfig;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;

import java.util.Random;

public class SpikeFeature extends Feature<SimpleBlockProviderConfig> {

    FastNoise fnPerlin = null;

    public SpikeFeature(Codec<SimpleBlockProviderConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random rand, BlockPos pos, SimpleBlockProviderConfig config) {
        setSeed(world.getSeed());


        if (world.getBlockState(pos.below()).getMaterial() == Material.AIR || world.getBlockState(pos.below()).getMaterial() == Material.WATER || world.getBlockState(pos.below()).getMaterial() == Material.LAVA || world.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, pos.getX(), pos.getZ()) < 4)
            return false;


        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

        double baseRadius = 4;
        int height = 45;
        int startHeight = height - 5;

        for (double y = -height; y <= -1; y++) {
            for (double x = -height; x <= height; x++) {
                for (double z = -height; z <= height; z++) {
                    mutable.set(pos).move((int) x, (int) y + startHeight, (int) z);
                    double noise = fnPerlin.GetNoise((float) mutable.getX(), (float) mutable.getZ()) * 12;
                    double scaledNoise = (noise / 11) * (-(y * baseRadius) / ((x * x) + (z * z)));
                    double threshold = 0.5;

                    if (y == -height) {
                        if (scaledNoise >= threshold)
                            if (world.getBlockState(mutable.relative(Direction.DOWN)).getMaterial() == Material.AIR)
                                return false;
                    }

                    if (scaledNoise >= threshold) {
                        if (world.getBlockState(mutable).getMaterial() == Material.AIR) {
                            BlockState blockState = config.getBlockProvider().getState(rand, mutable);
                            world.setBlock(mutable, blockState, 2);

                            if (blockState.getBlock() == Blocks.LAVA)
                                world.getLiquidTicks().scheduleTick(mutable, Fluids.LAVA, 0);
                        }
                    }
                }
            }
        }
        return true;
    }


    public void setSeed(long seed) {
        if (fnPerlin == null) {
            fnPerlin = new FastNoise((int) seed);
            fnPerlin.SetNoiseType(FastNoise.NoiseType.PerlinFractal);
            fnPerlin.SetFractalType(FastNoise.FractalType.FBM);
            fnPerlin.SetFrequency(0.2F);
        }
    }
}
