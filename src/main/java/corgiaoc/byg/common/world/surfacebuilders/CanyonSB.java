package corgiaoc.byg.common.world.surfacebuilders;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.Tags;
import corgiaoc.byg.common.world.worldtype.noise.fastnoise.FastNoise;
import corgiaoc.byg.core.byglists.BYGSBList;

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

    public BlockState layerBlock = Blocks.TERRACOTTA.getDefaultState();

    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int groundHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        setSeed(seed);
        BlockPos.Mutable block = new BlockPos.Mutable();
        int xPos = x & 15;
        int zPos = z & 15;



        double noiseSample = noiseGen.GetNoise(x, z) * 10;
        double noiseSample2 = noiseGen2.GetNoise(x, z);
        double noiseSample3 = noiseGen3.GetNoise(x, z);
        double noiseSample4 = noiseGen4.GetNoise(x * 1.1F, z * 1.34F);

        double totalNoiseSample = (noiseSample2 * 15) + (noiseSample3 * 9) * noiseSample3;

        double simulateErosion = Math.abs((noiseSample2) * 8 + (noiseSample4 * (4 + (noiseSample2 * 3))));

        //0.03 is effectively one block w/ the ridged noise sample.
        if (noiseSample > 9.0) {
            for (int yPos = groundHeight; yPos >= seaLevel - totalNoiseSample; --yPos) {
                block.setPos(xPos, yPos, zPos);
                double noiseSample5 = noiseGen5.GetNoise(x * 1.1F, yPos,  z * 1.34F);

                if (noiseSample < 9.06) {
                    if (yPos < groundHeight - 10 - simulateErosion - (noiseSample5 * 6))
                        chunkIn.setBlockState(block, Blocks.STONE.getDefaultState(), false);
                    else
                        chunkIn.setBlockState(block, Blocks.AIR.getDefaultState(), false);
                }
                else if (noiseSample < 9.12) {
                    if (yPos < groundHeight - 13 - simulateErosion - (noiseSample5 * 6))
                        chunkIn.setBlockState(block, Blocks.STONE.getDefaultState(), false);
                    else
                        chunkIn.setBlockState(block, Blocks.AIR.getDefaultState(), false);
                }
                else if (noiseSample < 9.18) {
                    if (yPos < groundHeight - 16 - simulateErosion - (noiseSample5 * 6))
                        chunkIn.setBlockState(block, Blocks.STONE.getDefaultState(), false);
                    else
                        chunkIn.setBlockState(block, Blocks.AIR.getDefaultState(), false);
                }
                else if (noiseSample < 9.24) {
                    if (yPos < groundHeight - 19 - simulateErosion - (noiseSample5 * 6))
                        chunkIn.setBlockState(block, Blocks.STONE.getDefaultState(), false);
                    else
                        chunkIn.setBlockState(block, Blocks.AIR.getDefaultState(), false);
                }
                else if (noiseSample < 9.45) {
                    if (yPos < groundHeight - 22 - simulateErosion - (noiseSample5 * 6))
                        chunkIn.setBlockState(block, Blocks.STONE.getDefaultState(), false);
                    else
                        chunkIn.setBlockState(block, Blocks.AIR.getDefaultState(), false);
                }
                else if (noiseSample < 9.51) {
                    if (yPos < groundHeight - 32 - simulateErosion - (noiseSample5 * 6))
                        chunkIn.setBlockState(block, Blocks.STONE.getDefaultState(), false);
                    else
                        chunkIn.setBlockState(block, Blocks.AIR.getDefaultState(), false);
                }
                else if (noiseSample < 9.57) {
                    if (yPos < groundHeight - 35 - simulateErosion - (noiseSample5 * 6))
                        chunkIn.setBlockState(block, Blocks.STONE.getDefaultState(), false);
                    else
                        chunkIn.setBlockState(block, Blocks.AIR.getDefaultState(), false);
                }
                else if (noiseSample < 9.63) {
                    if (yPos < groundHeight - 38 - simulateErosion - (noiseSample5 * 6))
                        chunkIn.setBlockState(block, Blocks.STONE.getDefaultState(), false);
                    else
                        chunkIn.setBlockState(block, Blocks.AIR.getDefaultState(), false);
                }
                else if (noiseSample < 9.69) {
                    if (yPos < groundHeight - 41 - simulateErosion - (noiseSample5 * 6))
                        chunkIn.setBlockState(block, Blocks.STONE.getDefaultState(), false);
                    else
                        chunkIn.setBlockState(block, Blocks.AIR.getDefaultState(), false);
                }
                else {
                    if (yPos > seaLevel) {
                        chunkIn.setBlockState(block, Blocks.AIR.getDefaultState(), false);
                    }
                    else
                        chunkIn.setBlockState(block, Blocks.WATER.getDefaultState(), false);
                }
            }
        }
        if (noiseSample > 8.8F && noiseSample <= 9.0F)
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, groundHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.GRASSMOUNTAIN_CF);

        if (noiseSample < 8.8F) {
            if (noise < 1)
                SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, groundHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.GRASSMOUNTAIN_CF);
            else
                SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, groundHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, randomSurfaceConfig(random));
        }

        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int yPos = groundHeight - 3; yPos >= seaLevel - 15; yPos--) {
            setStrataLayerBlock(yPos);
            mutable.setPos(xPos, yPos, zPos);

            if (chunkIn.getBlockState(mutable).isIn(Tags.Blocks.STONE))
                chunkIn.setBlockState(mutable, layerBlock, false);
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
            noiseGen3.SetNoiseType(FastNoise.NoiseType.ValueFractal);
            noiseGen3.SetFractalOctaves(1);
            noiseGen3.SetFractalGain(0.3f);
            noiseGen3.SetFrequency(0.004F);
        }

        if (noiseGen4 == null) {
            noiseGen4 = new FastNoise((int) seed + 234233);
            noiseGen4.SetNoiseType(FastNoise.NoiseType.ValueFractal);
            noiseGen4.SetFractalOctaves(1);
            noiseGen4.SetFractalGain(0.3f);
            noiseGen4.SetFrequency(0.01F);
        }
        if (noiseGen5 == null) {
            noiseGen5 = new FastNoise((int) seed + 234233);
            noiseGen5.SetNoiseType(FastNoise.NoiseType.Simplex);
            noiseGen5.SetFractalOctaves(1);
            noiseGen5.SetFractalGain(0.3f);
            noiseGen5.SetFrequency(0.001F);
        }
    }

    public static SurfaceBuilderConfig randomSurfaceConfig(Random random) {
        int randomizer = random.nextInt(7);
        if (randomizer == 1) {
            return BYGSBList.BYGSBConfigList.GRASSMOUNTAIN_CF;
        } else if(randomizer == 2 || randomizer == 3)
            return BYGSBList.BYGSBConfigList.GRASSMOUNTAIN_CF;

        else
            return BYGSBList.BYGSBConfigList.GRASSMOUNTAIN_CF;
    }

    public void setStrataLayerBlock(int yPos) {
        if (yPos % 5 == 0)
            layerBlock = Blocks.SNOW_BLOCK.getDefaultState();
        else if(yPos % 2 == 0)
            layerBlock = Blocks.PACKED_ICE.getDefaultState();
        else if (yPos % 7 == 0)
            layerBlock = Blocks.BLUE_ICE.getDefaultState();
    }
}