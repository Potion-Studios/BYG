package voronoiaoc.byg.common.world.surfacebuilders;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import voronoiaoc.byg.common.noise.simplex.chunkgen.ChunkFastSimplexStyleNoise;
import voronoiaoc.byg.core.byglists.BYGBlockList;
import voronoiaoc.byg.core.byglists.BYGSBList;

import java.util.Random;

public class CanyonSB extends SurfaceBuilder<TernarySurfaceConfig> {
    public CanyonSB(Codec<TernarySurfaceConfig> config) {
        super(config);
    }

    protected long seed;
    protected ChunkFastSimplexStyleNoise simplex;
    protected ChunkFastSimplexStyleNoise simplex2;

    public void generate(Random random, Chunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, TernarySurfaceConfig config) {
        BlockPos.Mutable block = new BlockPos.Mutable();
        int xPos = x & 15;
        int zPos = z & 15;
        double rawSimplexNoiseSample = this.octavedSimplex(x, z, 1, 0.001F, 2, 0.5f);
        double simplexNoiseSample = rawSimplexNoiseSample * 65;
        double ridgedNoiseSample = 1 - (2 * Math.abs(simplexNoiseSample));

        if (ridgedNoiseSample > -24) {
            if (ridgedNoiseSample > -10) {
                for (int yPos = startHeight; yPos >= startHeight - 80; --yPos) {
                    block.set(xPos, yPos, zPos);
                    if (yPos > seaLevel) {
                        chunkIn.setBlockState(block, Blocks.AIR.getDefaultState(), false);
                    }
                }
                if (noise < 1)
                    SurfaceBuilder.DEFAULT.generate
                            (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, SurfaceBuilder.GRASS_CONFIG);
                else
                    SurfaceBuilder.DEFAULT.generate
                            (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.COARSE);
            }
            //Edge 1(Outwardest Edge)
            int noiseAdded = 135;

            if (ridgedNoiseSample > -24 && ridgedNoiseSample < -20) {
                for (int yPos = startHeight; yPos >= noiseAdded; --yPos) {
                    block.set(xPos, yPos, zPos);
                    if (yPos > seaLevel) {
                        chunkIn.setBlockState(block, Blocks.AIR.getDefaultState(), false);
                    }
                }
                if (noise < 1)
                    SurfaceBuilder.DEFAULT.generate
                            (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.REDSAND_CF);
                else
                    SurfaceBuilder.DEFAULT.generate
                            (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, randomSurfaceConfig(random));
            }
            //Edge 2(Middle Edge)
            if (ridgedNoiseSample > -20 && ridgedNoiseSample < -16) {
                for (int yPos = startHeight; yPos >= noiseAdded - 9; --yPos) {
                    block.set(xPos, yPos, zPos);
                    if (yPos > seaLevel) {
                        chunkIn.setBlockState(block, Blocks.AIR.getDefaultState(), false);
                    }
                }
                if (noise < 1)
                    SurfaceBuilder.DEFAULT.generate
                            (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.REDSAND_CF);
                else
                    SurfaceBuilder.DEFAULT.generate
                            (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, randomSurfaceConfig(random));
            }
            //Edge 3(Inner Edge)
            if (ridgedNoiseSample > -16 && ridgedNoiseSample < -10) {
                for (int yPos = startHeight; yPos >= noiseAdded - 18; --yPos) {
                    block.set(xPos, yPos, zPos);
                    if (yPos > seaLevel) {
                        chunkIn.setBlockState(block, Blocks.AIR.getDefaultState(), false);
                    }
                }
                if (noise < 1)
                    SurfaceBuilder.DEFAULT.generate
                            (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.REDSAND_CF);
                else
                    SurfaceBuilder.DEFAULT.generate
                            (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, randomSurfaceConfig(random));
            }
        }

        for (int yPos = startHeight - 3; yPos >= seaLevel; --yPos) {
            block.set(xPos, yPos, zPos);
            BlockState currentBlockToReplace = chunkIn.getBlockState(block);
            if (currentBlockToReplace == Blocks.STONE.getDefaultState()) {
                chunkIn.setBlockState(block, BYGBlockList.RED_ROCK.getDefaultState(), false);

            }
        }

        if (noise < 1)
            SurfaceBuilder.DEFAULT.generate
                    (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.REDSAND_CF);
        else
            SurfaceBuilder.DEFAULT.generate
                    (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, randomSurfaceConfig(random));
    }

    @Override
    public void initSeed(long seed) {
        if (this.seed != seed || this.simplex == null) {
            ChunkRandom sharedseedrandom = new ChunkRandom(seed);
            this.simplex = new ChunkFastSimplexStyleNoise(sharedseedrandom);
        }
        if (this.seed != seed || this.simplex2 == null) {
            ChunkRandom sharedseedrandom = new ChunkRandom(1999L + seed);
            this.simplex2 = new ChunkFastSimplexStyleNoise(sharedseedrandom);
        }

        this.seed = seed;
    }

    public double octavedSimplex(int x, int y, float amp, float scale, int octaves, float change) {
        double height = 0;
        for (int i = 0; i < octaves; i++) {
            height += amp * simplex.sample2D(x * scale, y * scale);
            scale /= change;
            amp *= change;
        }
        return height;
    }

    public static TernarySurfaceConfig randomSurfaceConfig(Random random) {
        int randomizer = random.nextInt(3);

        if (randomizer == 1) {
            return SurfaceBuilder.GRASS_CONFIG;
        } else
            return BYGSBList.BYGSBConfigList.COARSE;

    }
}