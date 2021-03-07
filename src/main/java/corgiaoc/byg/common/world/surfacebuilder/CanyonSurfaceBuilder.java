package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.biome.overworld.Canyons;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.Direction;
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

    @Override
    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double surfaceNoise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        setupNoise(seed);
        BlockPos.Mutable localPos = new BlockPos.Mutable().setPos(x & 15, 0, z & 15);
        for (int i = 0; i <= 180; i++) {
            chunkIn.setBlockState(localPos, defaultBlock, false);
            localPos.move(Direction.UP);
        }

        localPos.setY(chunkIn.getTopBlockY(Heightmap.Type.OCEAN_FLOOR_WG, localPos.getX(), localPos.getZ()));
        chunkIn.setBlockState(localPos, BYGBlocks.OVERGROWN_STONE.getDefaultState(), false);

        startHeight = 180;
//        int localX = x & 15;
//        int localZ = z & 15;
//        BlockPos.Mutable localPos = new BlockPos.Mutable(localX, 100, localZ);
//
//        try {
//            int centerMaxY = readHeightmapData(x, z, 100, 205);
//
//
////            double totalDensity = 0;
////            for (int xSearch = -searchRange; xSearch < searchRange; xSearch++) {
////                for (int zSearch = -searchRange; zSearch < searchRange; zSearch++) {
////                    int offsetMaxY = readHeightmapData(x + xSearch, z + zSearch, 100, 205);
////
////                    totalDensity += offsetMaxY * 0.01;
////                }
////            }
//
//
//
//
//            for (int i = 100; i < centerMaxY; i++) {
//                chunkIn.setBlockState(localPos, Blocks.STONE.getDefaultState(), false);
//                localPos.move(Direction.UP);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        int localX = x & 15;
//        int localZ = z & 15;
//
//
//        BlockPos.Mutable localPos = new BlockPos.Mutable(localX, startHeight, localZ);
//
//
//        double curvingMultiplier = 0.4;
//
//        double noiseVal = noise.GetNoise(x, z) * 10;
//        double reversedNoiseVal = noiseVal - Math.abs(noiseVal + noiseVal);
//        float noise2Val = noise2.GetNoise(x, z);
//        double curviness = Math.abs(noise2Val * curvingMultiplier);
//        double minThreshold = 5.65 + curviness;
//        double maxThreshold = 5.8 + curviness;
//
//        double offset3 = 0.65;
//        double offset2 = 0.2;
//        double offset = 0.45;
//
//        boolean check = noiseVal > minThreshold && noiseVal < maxThreshold;
//        float simplexNoise = octaveSimplexNoise.GetNoise(x, z) * 7;
//
//        if (check) {
//
//            float totalCellDensity = 0;
//
//            for (int xSearch = -searchRange; xSearch < searchRange; xSearch++) {
//                for (int zSearch = -searchRange; zSearch < searchRange; zSearch++) {
//                    float rawOffsetNoiseGridNoise = noiseGrid.GetNoise(x + xSearch + 25, z + zSearch + 25);
//                    float rawOffsetCellWeight = cellWeight(rawOffsetNoiseGridNoise).getFirst();
//                    float cellWeight = CELL_WEIGHTS[xSearch + 2 + (zSearch + 2) * 5] / (rawOffsetNoiseGridNoise + 7.5F);
//                    totalCellDensity += cellWeight * rawOffsetCellWeight * 0.2;
//                }
//            }
//
//
//            double minThresholdNoiseValDif = noiseVal - minThreshold;
//            double maxThresholdNoiseValDif = noiseVal - maxThreshold;
//
//            float lowestY = (float) (100 - (noiseVal * 25) + seaLevel + 40) - totalCellDensity + ((simplexNoise * 1.2F) * 0.5F);
//            if (checkForFlip(minThresholdNoiseValDif, maxThresholdNoiseValDif)) {
//                lowestY = (float) (100 + (reversedNoiseVal * 25) - seaLevel + 54) - totalCellDensity + ((simplexNoise * 1.2F) * 0.5F);
//                lowestY = Math.abs(lowestY);
//            }
//
//            for (int y = startHeight; y >= lowestY; y--) {
//                if (y < seaLevel) {
//                    chunkIn.setBlockState(localPos, Blocks.WATER.getDefaultState(), false);
//                    chunkIn.getFluidsToBeTicked().scheduleTick(localPos, Fluids.WATER, 0);
//                } else {
//                    chunkIn.setBlockState(localPos, Blocks.AIR.getDefaultState(), false);
//                }
//                localPos.move(Direction.DOWN);
//            }
//        } else if (noiseVal > minThreshold - offset2 && noiseVal < maxThreshold + offset2) {
//            float totalCellDensity = 0;
//
//            for (int xSearch = -searchRange; xSearch < searchRange; xSearch++) {
//                for (int zSearch = -searchRange; zSearch < searchRange; zSearch++) {
//                    float rawOffsetNoiseGridNoise = noiseGrid.GetNoise(x + xSearch, z + zSearch);
//                    float rawOffsetCellWeight = cellWeight(rawOffsetNoiseGridNoise).getFirst();
//                    float cellWeight = CELL_WEIGHTS[xSearch + 2 + (zSearch + 2) * 5] / (rawOffsetNoiseGridNoise + 7.5F);
//                    totalCellDensity += cellWeight * rawOffsetCellWeight * 0.2;
//                }
//            }
//
//            float lowestY = (float) (100 - (noiseVal * 25) + 188) - totalCellDensity + (simplexNoise * 0.5F);
//
//            double minThresholdNoiseValDif = noiseVal - minThreshold;
//            double maxThresholdNoiseValDif = noiseVal - maxThreshold;
//
//            if (checkForFlip(minThresholdNoiseValDif, maxThresholdNoiseValDif)) {
//                lowestY = (float) (100 + (reversedNoiseVal * 24) - 96) - totalCellDensity + (simplexNoise * 0.5F);
//                lowestY = Math.abs(lowestY);
//            }
//
//            for (int y = startHeight; y >= lowestY; y--) {
//                if (chunkIn.getBlockState(localPos).getMaterial() == Material.ROCK) {
//                    if (y < seaLevel) {
//                        chunkIn.setBlockState(localPos, Blocks.WATER.getDefaultState(), false);
//                        chunkIn.getFluidsToBeTicked().scheduleTick(localPos, Fluids.WATER, 0);
//                    } else {
//                        chunkIn.setBlockState(localPos, Blocks.AIR.getDefaultState(), false);
//                    }
//                }
//
//                localPos.move(Direction.DOWN);
//            }
//            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, surfaceNoise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Blocks.RED_SAND.getDefaultState(), Blocks.RED_SAND.getDefaultState(), Blocks.RED_SAND.getDefaultState()));
//        } else if (noiseVal > minThreshold - offset && noiseVal < maxThreshold + offset) {
//            float totalCellDensity = 0;
//
//            for (int xSearch = -searchRange; xSearch < searchRange; xSearch++) {
//                for (int zSearch = -searchRange; zSearch < searchRange; zSearch++) {
//                    float rawOffsetNoiseGridNoise = noiseGrid.GetNoise(x + xSearch, z + zSearch);
//                    float rawOffsetCellWeight = cellWeight(rawOffsetNoiseGridNoise).getFirst();
//                    float cellWeight = CELL_WEIGHTS[xSearch + 2 + (zSearch + 2) * 5] / (rawOffsetNoiseGridNoise + 7.5F);
//                    totalCellDensity += cellWeight * rawOffsetCellWeight * 0.5;
//                }
//            }
//
//            float lowestY = (float) (100 - (noiseVal * 25) + 205) - totalCellDensity + simplexNoise;
//
//            double minThresholdNoiseValDif = noiseVal - minThreshold;
//            double maxThresholdNoiseValDif = noiseVal - maxThreshold;
//
//            if (checkForFlip(minThresholdNoiseValDif, maxThresholdNoiseValDif)) {
//                lowestY = (float) (100 + (reversedNoiseVal * 24) - 110) - totalCellDensity + simplexNoise;
//                lowestY = Math.abs(lowestY);
//            }
//
//            for (int y = startHeight + 5; y >= lowestY; y--) {
//                if (chunkIn.getBlockState(localPos).getMaterial() == Material.ROCK) {
//                    chunkIn.setBlockState(localPos, Blocks.AIR.getDefaultState(), false);
//                }
//                localPos.move(Direction.DOWN);
//            }
//        } else if (noiseVal > minThreshold - offset3 && noiseVal < maxThreshold + offset3) {
//            float totalCellDensity = 0;
//
//            for (int xSearch = -searchRange; xSearch < searchRange; xSearch++) {
//                for (int zSearch = -searchRange; zSearch < searchRange; zSearch++) {
//                    float rawOffsetNoiseGridNoise = noiseGrid.GetNoise(x + xSearch, z + zSearch);
//                    float rawOffsetCellWeight = cellWeight(rawOffsetNoiseGridNoise).getFirst();
//                    float cellWeight = CELL_WEIGHTS[xSearch + 2 + (zSearch + 2) * 5] / (rawOffsetNoiseGridNoise + 7.5F);
//                    totalCellDensity += cellWeight * rawOffsetCellWeight * 0.5;
//                }
//            }
//
//            float lowestY = (float) (100 - (noiseVal * 25) + 215) - totalCellDensity + simplexNoise;
//
//            double minThresholdNoiseValDif = noiseVal - minThreshold;
//            double maxThresholdNoiseValDif = noiseVal - maxThreshold;
//
//            if (checkForFlip(minThresholdNoiseValDif, maxThresholdNoiseValDif)) {
//                lowestY = (float) (100 + (reversedNoiseVal * 24) - 120) - totalCellDensity + simplexNoise;
//                lowestY = Math.abs(lowestY);
//            }
//
//            for (int y = startHeight + 5; y >= lowestY; y--) {
//                if (chunkIn.getBlockState(localPos).getMaterial() == Material.ROCK) {
//                    chunkIn.setBlockState(localPos, Blocks.AIR.getDefaultState(), false);
//                }
//                localPos.move(Direction.DOWN);
//            }
//        }
//
//        localPos.setPos(localX, startHeight, localZ);
//        for (int height = startHeight; height > 0; height--) {
//            if (chunkIn.getBlockState(localPos).getMaterial() == Material.ROCK) {
//
//                int blockY = localPos.getY();
//                if (blockY % 6 == 0) {
//                    chunkIn.setBlockState(localPos, Blocks.TERRACOTTA.getDefaultState(), false);
//                } else if (blockY % 8 == 0) {
//                    chunkIn.setBlockState(localPos, Blocks.RED_TERRACOTTA.getDefaultState(), false);
//                } else {
//                    chunkIn.setBlockState(localPos, BYGBlocks.RED_ROCK.getDefaultState(), false);
//                }
//            }
//            localPos.move(Direction.DOWN);
//        }
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


    public static Pair<Float, BlockState> cellWeight(double cellNoiseVal) {
        if (cellNoiseVal > 0.8) { //Eroded region
            return new Pair<>(0.4F, Blocks.ANDESITE.getDefaultState());
        } else if (cellNoiseVal > 0.2) {
            return new Pair<>(0.75F, Blocks.CRYING_OBSIDIAN.getDefaultState());
        } else if (cellNoiseVal > -0.4) {
            return new Pair<>(0.65F, Blocks.JACK_O_LANTERN.getDefaultState());
        } else {
            return new Pair<>(0.55F, Blocks.DIORITE.getDefaultState());
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
