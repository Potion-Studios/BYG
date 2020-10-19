package corgiaoc.byg.common.world.feature.nether.spike;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.SimpleBlockProviderConfig;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import org.spongepowered.noise.module.source.Perlin;

import java.util.Random;

public class SpikeFeature extends Feature<SimpleBlockProviderConfig> {

    FastNoise fnPerlin = null;
    Perlin spongePerlin = null;

    public SpikeFeature(Codec<SimpleBlockProviderConfig> codec) {
        super(codec);
    }


    static double perlinMax = 0;
    static double perlinMin = 100;

    static double perlin2Max = 0;
    static double perlin2Min = 1000;


    public static void getMinAndMax(double perlin1, double perlin2) {
        if (perlin1 > perlinMax) {
            System.out.println("Fast Max: " + perlinMax);
            perlinMax = perlin1;
        }
        if (perlin1 < perlinMin) {
            System.out.println("Fast Min: " + perlinMin);
            perlinMin = perlin1;
        }

        if (perlin2 > perlin2Max) {
            System.out.println("Sponge Max: " + perlin2Max);
            perlin2Max = perlin2;
        }
        if (perlin2 < perlin2Min) {
            System.out.println("Sponge min: " + perlin2Min);
            perlin2Min = perlin2;
        }
    }

    @Override
    public boolean func_241855_a(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, SimpleBlockProviderConfig config) {
        setSeed(world.getSeed());


        if (world.getBlockState(pos.down()).getMaterial() == Material.AIR || world.getBlockState(pos.down()).getMaterial() == Material.WATER || world.getBlockState(pos.down()).getMaterial() == Material.LAVA || world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, pos.getX(), pos.getZ()) < 4)
            return false;


        BlockPos.Mutable mutable = new BlockPos.Mutable();

        double baseRadius = 4;
        int lavaLeakage = 2;
        int volcanoConeSize = 45;
        int volcanoStartHeight = volcanoConeSize - 5;

        for (double x = -volcanoConeSize; x <= volcanoConeSize; x++) {
            for (double y = -volcanoConeSize; y <= -1; y++) {
                for (double z = -volcanoConeSize; z <= volcanoConeSize; z++) {
                    mutable.setPos(pos).move((int)x, (int)y + volcanoStartHeight, (int)z);
                    double noise = fnPerlin.GetNoise((float) x, (float)z) * 12;
                    double noise2 = spongePerlin.getValue(x, y, z) * 12;
                    getMinAndMax(noise, noise2);
                    double scaledNoise = (noise / 11) * (-(y * baseRadius) / ((x * x) + (z * z)));
                    if (scaledNoise >= 0.5) {
                        if (world.getBlockState(mutable).getMaterial() == Material.AIR) {
                            world.setBlockState(mutable, config.getBlockProvider().getBlockState(rand, mutable), 2);
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

        if (spongePerlin == null) {
            spongePerlin = new Perlin();
            spongePerlin.setSeed((int) seed);
            spongePerlin.setFrequency(0.2F);
        }
    }
}
