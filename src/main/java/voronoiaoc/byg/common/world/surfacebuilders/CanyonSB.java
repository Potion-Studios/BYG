package voronoiaoc.byg.common.world.surfacebuilders;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.Tags;
import voronoiaoc.byg.common.world.worldtype.noise.fastnoise.FNVector3f;
import voronoiaoc.byg.common.world.worldtype.noise.fastnoise.FastNoise;
import voronoiaoc.byg.core.byglists.BYGSBList;

import java.util.Random;

public class CanyonSB extends SurfaceBuilder<SurfaceBuilderConfig> {
    public CanyonSB(Codec<SurfaceBuilderConfig> config) {
        super(config);
    }

    protected long seed;
    protected FastNoise noiseGen = null;
    protected FastNoise noiseGen2 = null;
    protected FastNoise noiseGen3 = null;
    protected FastNoise noiseGen4 = null;
    protected FastNoise noiseGen5 = null;

    FastNoise selectorNoise = null;
    FastNoise cellNoise1 = null;
    FastNoise cellNoise2 = null;
    FastNoise perturb1 = null;
    FastNoise perturb2 = null;
    FastNoise perturbSmall1 = null;
    FastNoise perturbSmall2 = null;

    double storedNoiseHigh = 0;
    double storedNoiseLow = 0;


    public BlockState layerBlock = Blocks.TERRACOTTA.getDefaultState();

    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int groundHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        setSeed(seed);
        int xPos = x & 15;
        int zPos = z & 15;
        BlockPos.Mutable mutable = new BlockPos.Mutable(xPos, 0, zPos);

        FNVector3f perturb3f = new FNVector3f(mutable.getX(), mutable.getY(), mutable.getZ());
        perturb1.GradientPerturb(perturb3f);
        perturbSmall1.GradientPerturb(perturb3f);

        FNVector3f perturb3f2 = new FNVector3f(mutable.getX(), mutable.getY(), mutable.getZ());
        perturb2.GradientPerturb(perturb3f2);
        perturbSmall2.GradientPerturb(perturb3f2);

        double cellNoise1 = this.cellNoise1.GetNoise(perturb3f.x, perturb3f.z);
        double cellNoise2 = this.cellNoise2.GetNoise(perturb3f2.x, perturb3f2.z);

        double selectorNoiseValue = selectorNoise.GetValue(mutable.getX(), mutable.getZ()) * 12 + 0.5;

        double canyonCarverNoise = noiseGen.GetNoise(x, z) * 10;
        double noiseSample2 = noiseGen2.GetNoise(x, z);
        double noiseSample3 = noiseGen3.GetNoise(x, z);
        double noiseSample4 = noiseGen4.GetNoise(x, z) * 15;


        double simulateErosion1 = MathHelper.clampedLerp(cellNoise1, cellNoise2, selectorNoiseValue) * 1.4;

        double simulateErosion = MathHelper.clampedLerp(simulateErosion1, noiseSample2, noiseSample3) * 2;


        noiseSample4 = simulateErosion1 + noiseSample4;


//        double totalNoiseSample = (noiseSample2 * 15) + (noiseSample3 * 9) * noiseSample3;

//        double simulateErosion = Math.abs((noiseSample2) * 8 + (noiseSample4 * (4 + (noiseSample2 * 3))));

        //0.03 is effectively one block w/ the ridged noise sample.
        if (canyonCarverNoise > 9.0) {
            for (int yPos = groundHeight; yPos >= seaLevel - simulateErosion - noiseSample4; --yPos) {
                mutable.setPos(xPos, yPos, zPos);

                if (canyonCarverNoise < 9.06) {
                    if (yPos < groundHeight - 10 - simulateErosion)
                        chunkIn.setBlockState(mutable, Blocks.STONE.getDefaultState(), false);
                    else
                        chunkIn.setBlockState(mutable, Blocks.AIR.getDefaultState(), false);
                } else if (canyonCarverNoise < 9.12) {
                    if (yPos < groundHeight - 13 - simulateErosion)
                        chunkIn.setBlockState(mutable, Blocks.STONE.getDefaultState(), false);
                    else
                        chunkIn.setBlockState(mutable, Blocks.AIR.getDefaultState(), false);
                } else if (canyonCarverNoise < 9.18) {
                    if (yPos < groundHeight - 16 - simulateErosion)
                        chunkIn.setBlockState(mutable, Blocks.STONE.getDefaultState(), false);
                    else
                        chunkIn.setBlockState(mutable, Blocks.AIR.getDefaultState(), false);
                } else if (canyonCarverNoise < 9.24) {
                    if (yPos < groundHeight - 19 - simulateErosion)
                        chunkIn.setBlockState(mutable, Blocks.STONE.getDefaultState(), false);
                    else
                        chunkIn.setBlockState(mutable, Blocks.AIR.getDefaultState(), false);
                } else if (canyonCarverNoise < 9.45) {
                    if (yPos < groundHeight - 22 - simulateErosion)
                        chunkIn.setBlockState(mutable, Blocks.STONE.getDefaultState(), false);
                    else
                        chunkIn.setBlockState(mutable, Blocks.AIR.getDefaultState(), false);
                } else if (canyonCarverNoise < 9.51) {
                    if (yPos < groundHeight - 32 - simulateErosion)
                        chunkIn.setBlockState(mutable, Blocks.STONE.getDefaultState(), false);
                    else
                        chunkIn.setBlockState(mutable, Blocks.AIR.getDefaultState(), false);
                } else if (canyonCarverNoise < 9.57) {
                    if (yPos < groundHeight - 35 - simulateErosion)
                        chunkIn.setBlockState(mutable, Blocks.STONE.getDefaultState(), false);
                    else
                        chunkIn.setBlockState(mutable, Blocks.AIR.getDefaultState(), false);
                } else if (canyonCarverNoise < 9.63) {
                    if (yPos < groundHeight - 38 - simulateErosion)
                        chunkIn.setBlockState(mutable, Blocks.STONE.getDefaultState(), false);
                    else
                        chunkIn.setBlockState(mutable, Blocks.AIR.getDefaultState(), false);
                } else if (canyonCarverNoise < 9.69) {
                    if (yPos < groundHeight - 41 - simulateErosion)
                        chunkIn.setBlockState(mutable, Blocks.STONE.getDefaultState(), false);
                    else
                        chunkIn.setBlockState(mutable, Blocks.AIR.getDefaultState(), false);
                } else {
                    if (yPos > seaLevel) {
                        chunkIn.setBlockState(mutable, Blocks.AIR.getDefaultState(), false);
                    } else
                        chunkIn.setBlockState(mutable, Blocks.WATER.getDefaultState(), false);
                }
            }
        }
        if (canyonCarverNoise > 8.8F && canyonCarverNoise <= 9.0F)
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, groundHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.SNOW_CF);

        if (canyonCarverNoise < 8.8F) {
            if (noise < 1)
                SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, groundHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.SNOW_CF);
            else
                SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, groundHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, randomSurfaceConfig(random));
        }

        BlockPos.Mutable mutable1 = new BlockPos.Mutable();
        for (int yPos = groundHeight - 3; yPos >= seaLevel - 15; yPos--) {
            setStrataLayerBlock(yPos);
            mutable1.setPos(xPos, yPos, zPos);

            if (chunkIn.getBlockState(mutable1).isIn(Tags.Blocks.STONE))
                chunkIn.setBlockState(mutable1, layerBlock, false);
        }
    }


    public void setSeed(long seed) {
        if (noiseGen == null) {
            noiseGen = new FastNoise((int) seed);
            noiseGen.SetFractalType(FastNoise.FractalType.RigidMulti);
            noiseGen.SetNoiseType(FastNoise.NoiseType.SimplexFractal);
            noiseGen.SetGradientPerturbAmp(1);
            noiseGen.SetFractalOctaves(1);
            noiseGen.SetFractalGain(0.3f);
            noiseGen.SetFrequency(0.0012F);
        }
        if (noiseGen2 == null) {
            noiseGen2 = new FastNoise((int) seed + 20);
            noiseGen2.SetNoiseType(FastNoise.NoiseType.Simplex);
            noiseGen2.SetFractalOctaves(2);
            noiseGen2.SetFractalGain(0.3f);
            noiseGen2.SetFrequency(0.01F);
        }
        if (noiseGen3 == null) {
            noiseGen3 = new FastNoise((int) seed + 277);
            noiseGen3.SetNoiseType(FastNoise.NoiseType.PerlinFractal);
            noiseGen3.SetFractalOctaves(1);
            noiseGen3.SetFractalGain(0.3f);
            noiseGen3.SetFrequency(0.004F);
        }

        if (noiseGen4 == null) {
            noiseGen4 = new FastNoise((int) seed + 234233);
            noiseGen4.SetNoiseType(FastNoise.NoiseType.PerlinFractal);
            noiseGen4.SetFractalOctaves(1);
            noiseGen4.SetFractalGain(0.3f);
            noiseGen4.SetFrequency(0.001F);
        }
        if (noiseGen5 == null) {
            noiseGen5 = new FastNoise((int) seed + 234233);
            noiseGen5.SetNoiseType(FastNoise.NoiseType.Simplex);
            noiseGen5.SetFractalOctaves(1);
            noiseGen5.SetFractalGain(0.3f);
            noiseGen5.SetFrequency(0.001F);
        }

        float scaleFactor = (float) 4.5;
        float perturbAmpStrength = (float) 95;
        float smallPerturbAmpStrength = (float) 5;
        int perturbOctaves = 8;
        int smallPerturbOctaves = 3;

        if (selectorNoise == null) {
            selectorNoise = new FastNoise((int) seed);
            selectorNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
            selectorNoise.SetFrequency(0.0008F * scaleFactor);
        }

        if (cellNoise1 == null) {
            cellNoise1 = new FastNoise((int) seed + 19495485);
            cellNoise1.SetNoiseType(FastNoise.NoiseType.Cellular);
            cellNoise1.SetFrequency(0.004F * scaleFactor);
        }

        if (cellNoise2 == null) {
            cellNoise2 = new FastNoise((int) seed + 9484585);
            cellNoise2.SetNoiseType(FastNoise.NoiseType.Cellular);
            cellNoise2.SetFrequency(0.004F * scaleFactor);
        }

        if (perturb1 == null) {
            perturb1 = new FastNoise((int) seed + 2838495);
            perturb1.SetNoiseType(FastNoise.NoiseType.SimplexFractal);
            perturb1.SetFractalOctaves(perturbOctaves);
            perturb1.SetGradientPerturbAmp(perturbAmpStrength);
            perturb1.SetFrequency(0.008F * scaleFactor);
        }

        if (perturb2 == null) {
            perturb2 = new FastNoise((int) seed + 100);
            perturb2.SetNoiseType(FastNoise.NoiseType.SimplexFractal);
            perturb2.SetFractalOctaves(perturbOctaves);
            perturb2.SetGradientPerturbAmp(perturbAmpStrength);
            perturb2.SetFrequency(0.008F * scaleFactor);
        }

        if (perturbSmall1 == null) {
            perturbSmall1 = new FastNoise((int) seed + 9475);
            perturbSmall1.SetNoiseType(FastNoise.NoiseType.SimplexFractal);
            perturbSmall1.SetFractalOctaves(smallPerturbOctaves);
            perturbSmall1.SetGradientPerturbAmp(smallPerturbAmpStrength);
            perturbSmall1.SetFrequency(0.06F * scaleFactor);
        }

        if (perturbSmall2 == null) {
            perturbSmall2 = new FastNoise((int) seed + 948556);
            perturbSmall2.SetNoiseType(FastNoise.NoiseType.SimplexFractal);
            perturbSmall2.SetFractalOctaves(smallPerturbOctaves);
            perturbSmall2.SetGradientPerturbAmp(smallPerturbAmpStrength);
            perturbSmall2.SetFrequency(0.06F * scaleFactor);
        }

    }

    public static SurfaceBuilderConfig randomSurfaceConfig(Random random) {
        int randomizer = random.nextInt(7);
        if (randomizer == 1) {
            return BYGSBList.BYGSBConfigList.BLUE_ICE_CF;
        } else if (randomizer == 2 || randomizer == 3)
            return BYGSBList.BYGSBConfigList.PACKED_ICE_CF;

        else
            return BYGSBList.BYGSBConfigList.SNOW_CF;
    }

    public void setStrataLayerBlock(int yPos) {
        if (yPos % 5 == 0)
            layerBlock = Blocks.SNOW_BLOCK.getDefaultState();
        else if (yPos % 2 == 0)
            layerBlock = Blocks.PACKED_ICE.getDefaultState();
        else if (yPos % 7 == 0)
            layerBlock = Blocks.BLUE_ICE.getDefaultState();


    }
}