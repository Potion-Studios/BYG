package corgiaoc.byg.common.world.feature.overworld.volcano;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.SimpleBlockProviderConfig;
import corgiaoc.byg.util.noise.fastnoise.lite.FastNoiseLite;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;

import java.util.Random;

public class VolcanoFeature extends Feature<SimpleBlockProviderConfig> {

    FastNoiseLite fnlPerlin = null;

    public VolcanoFeature(Codec<SimpleBlockProviderConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random rand, BlockPos pos, SimpleBlockProviderConfig config) {
        setSeed(world.getSeed());


        if (world.getBlockState(pos.below()).getMaterial() == Material.AIR || world.getBlockState(pos.below()).getMaterial() == Material.WATER || world.getBlockState(pos.below()).getMaterial() == Material.LAVA || world.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, pos.getX(), pos.getZ()) < 4)
            return false;


        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

        double baseRadius = 15;
        double lavaLeakage = 0.7;
        int volcanoConeSize = 75;
        int volcanoStartHeight = volcanoConeSize - 5;
        double threshold = 0.5;

        for (double x = -volcanoConeSize; x <= volcanoConeSize; x++) {
            for (double y = -volcanoConeSize; y <= -15; y++) {
                for (double z = -volcanoConeSize; z <= volcanoConeSize; z++) {
                    mutable.set(pos).move((int)x, (int)y + volcanoStartHeight, (int)z);
                    float noise3 = FastNoiseLite.getSpongePerlinValue(fnlPerlin.GetNoise(mutable.getX(), mutable.getZ()));

                    double scaledNoise = (noise3 / 11) * (-(y * baseRadius) / ((x * x) + (z * z)));
                    if (scaledNoise - lavaLeakage >= threshold) {
                        if (mutable.getY() <= pos.getY() + (volcanoStartHeight - 19)) {
                            world.setBlock(mutable, Blocks.LAVA.defaultBlockState(), 2);
                            world.getLiquidTicks().scheduleTick(mutable, Fluids.LAVA, 0);
                        }
                    }
                    else if (scaledNoise >= threshold) {
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
