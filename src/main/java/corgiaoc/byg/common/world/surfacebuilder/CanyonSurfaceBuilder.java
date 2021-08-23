package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.util.SurfaceContext;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.block.BlockState;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class CanyonSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

    private static long seed;
    public static FastNoise noise;
    public static FastNoise noise2;
    private static FastNoise noiseGrid;
    private static FastNoise octaveSimplexNoise;
    private static double max = -1000;
    private static double min = 10000;

    static int searchRange = 2;


    private static final float[] CELL_WEIGHTS = (float[]) Util.make(new float[25], (array) -> {
        for (int i = -2; i < 2; ++i) {
            for (int j = -2; j < 2; ++j) {
                float f = 10.0F / MathHelper.sqrt((float) (i * i + j * j) + 0.2F);
                array[i + 2 + (j + 2) * 5] = f;
            }
        }
    });


    private static void getMinAndMax(double noiseVal) {
        if (noiseVal > max) {
            max = noiseVal;
            BYG.LOGGER.info("BYG: Max Noise: " + max);
        }
        if (noiseVal < min) {
            min = noiseVal;
            BYG.LOGGER.info("BYG: Min noise: " + min);
        }
    }


    public CanyonSurfaceBuilder(Codec<SurfaceBuilderConfig> codec) {
        super(codec);
    }

    SurfaceContext context = null;


    @SuppressWarnings("ConstantConditions")
    @Override
    public void apply(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double surfaceNoise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        setupNoise(seed);
        // A null SurfaceContext indicates we're not the SURFACE stage of ChunkStatus so exit early.
        BlockPos.Mutable localPos = new BlockPos.Mutable().set(x & 15, 0, z & 15);
        boolean isFinalIteration = localPos.getX() == 15 && localPos.getZ() == 15;
        boolean isFirstIteration = localPos.getX() == 0 && localPos.getZ() == 0;

        if (isFirstIteration) {
            context = SurfaceContext.peek();
        }
        if (context == null) {
            return;
        }

//        ChunkGenerator generator = context.getWorld().getChunkSource().getGenerator();
//
//        double density = 0;
//        for (int neighborXSearch = -searchRange; neighborXSearch < searchRange; neighborXSearch++) {
//            for (int neighborZSearch = -searchRange; neighborZSearch < searchRange; neighborZSearch++) {
//                int neighborX = neighborXSearch;
//                int neighborZ = neighborZSearch;
//                Biome neighborBiome = generator.getBiomeSource().getNoiseBiome(((x + neighborX) << 2) + 2, startHeight, ((x + neighborZ) << 2) + 2);
//                if (neighborBiome != biomeIn) {
//                    int neighborHeight = 63; //generator.getHeight(x + neighborX, z + neighborZ, Heightmap.Type.OCEAN_FLOOR_WG);
//                    density += neighborHeight * 0.1F;
//                }
//            }
//        }
//

//        double height = 120 + density;
//        for (int i = 0; i <= height; i++) {
////            if (height <= 180) {
//                chunkIn.setBlockState(localPos, defaultBlock, false);
//                localPos.move(Direction.UP);
////            }
//        }

        localPos.setY(chunkIn.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, localPos.getX(), localPos.getZ()));
        chunkIn.setBlockState(localPos, BYGBlocks.OVERGROWN_STONE.defaultBlockState(), false);

        if (isFinalIteration) {
            SurfaceContext.pop();
        }
    }

    public static void setupNoise(long serverSeed) {
        if (seed != serverSeed || noise == null || noise2 == null) {
            seed = serverSeed;
            noise = new FastNoise((int) seed);
            noise.SetFractalType(FastNoise.FractalType.RigidMulti);
            noise.SetNoiseType(FastNoise.NoiseType.CubicFractal);
            noise.SetGradientPerturbAmp(1);
            noise.SetFractalOctaves(5);
            noise.SetFractalGain(0.3f);
            noise.SetFrequency(0.002F);

            noise2 = new FastNoise((int) seed);
            noise2.SetFractalType(FastNoise.FractalType.Billow);
            noise2.SetNoiseType(FastNoise.NoiseType.SimplexFractal);
            noise2.SetGradientPerturbAmp(1);
            noise2.SetFractalOctaves(5);
            noise2.SetFractalGain(0.3f);
            noise2.SetFrequency(0.002F);

            noiseGrid = new FastNoise((int) seed);
            noiseGrid.SetNoiseType(FastNoise.NoiseType.Cellular);
            noiseGrid.SetFrequency(0.02F);
            noiseGrid.SetCellularReturnType(FastNoise.CellularReturnType.CellValue);

            octaveSimplexNoise = new FastNoise((int) seed);
            octaveSimplexNoise.SetNoiseType(FastNoise.NoiseType.SimplexFractal);
            octaveSimplexNoise.SetFrequency(0.02F);
            octaveSimplexNoise.SetFractalOctaves(4);
        }
    }

    public static boolean checkForFlip(double min, double max) {
        return Math.abs(min) > Math.abs(max);
    }

    static int minColor = Integer.MAX_VALUE;
    static int maxColor = Integer.MIN_VALUE;
    static File file = new File("C:\\coding\\BYG\\src\\main\\resources\\assets\\byg\\canyon.jpg");

    static BufferedImage heightmapimage = null;

    public static int readHeightmapData(int x, int z, int minY, int maxY) throws IOException {
        if (heightmapimage == null) {
            heightmapimage = ImageIO.read(file);
        }
        if (minColor == Integer.MAX_VALUE || maxColor == Integer.MIN_VALUE) {
            for (int xMove = 0; xMove < heightmapimage.getWidth(); xMove++) {
                for (int zMove = 0; zMove < heightmapimage.getHeight(); zMove++) {
                    int rgb = new Color(heightmapimage.getRGB(xMove, zMove)).getRed();
                    minColor = Math.min(minColor, rgb);
                    maxColor = Math.max(maxColor, rgb);
                }
            }
        }

        x = x % (heightmapimage.getWidth() - 1);
        z = z % (heightmapimage.getHeight() - 1);

        int rgb = heightmapimage.getRGB(Math.abs(x), Math.abs(z));

        rgb = new Color(rgb).getRed();

        return (((rgb - minColor) * (maxY - minY)) / (maxColor - minColor)) + minY;
    }
}
