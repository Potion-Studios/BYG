package voronoiaoc.byg.common.world.surfacebuilders;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import voronoiaoc.byg.common.world.worldtype.noise.simplex.chunkgen.ChunkFastSimplexStyleNoise;
import voronoiaoc.byg.core.byglists.BYGBlockList;
import voronoiaoc.byg.core.byglists.BYGSBList;

import java.util.Random;

public class CanyonSB extends SurfaceBuilder<SurfaceBuilderConfig> {
    public CanyonSB(Codec<SurfaceBuilderConfig> config) {
        super(config);
    }

    protected long seed;
    protected ChunkFastSimplexStyleNoise simplex;

    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        BlockPos.Mutable block = new BlockPos.Mutable();
        int xPos = x & 15;
        int zPos = z & 15;
        double rawSimplexNoiseSample = this.octavedSimplex(x, z, 1, 0.001F, 2, 0.5f);
        double simplexNoiseSample = rawSimplexNoiseSample * 65;
        double ridgedNoiseSample = 1 - (2 * Math.abs(simplexNoiseSample));

        if (ridgedNoiseSample > -24) {
            if (ridgedNoiseSample > -10) {
                for (int yPos = startHeight; yPos >= startHeight - 80; --yPos) {
                    block.setPos(xPos, yPos, zPos);
                    if (yPos > seaLevel) {
                        chunkIn.setBlockState(block, Blocks.AIR.getDefaultState(), false);
                    }
                }
                if (noise < 1)
                    SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG);
                else
                    SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.COARSE);
            }
            //Edge 1(Outwardest Edge)
            int noiseAdded = 135;

            if (ridgedNoiseSample > -24 && ridgedNoiseSample < -20) {
                for (int yPos = startHeight; yPos >= noiseAdded; --yPos) {
                    block.setPos(xPos, yPos, zPos);
                    if (yPos > seaLevel) {
                        chunkIn.setBlockState(block, Blocks.AIR.getDefaultState(), false);
                    }
                }
                if (noise < 1)
                    SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.REDSAND_CF);
                else
                    SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, randomSurfaceConfig(random));
            }
            //Edge 2(Middle Edge)
            if (ridgedNoiseSample > -20 && ridgedNoiseSample < -16) {
                for (int yPos = startHeight; yPos >= noiseAdded - 9; --yPos) {
                    block.setPos(xPos, yPos, zPos);
                    if (yPos > seaLevel) {
                        chunkIn.setBlockState(block, Blocks.AIR.getDefaultState(), false);
                    }
                }
                if (noise < 1)
                    SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.REDSAND_CF);
                else
                    SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, randomSurfaceConfig(random));
            }
            //Edge 3(Inner Edge)
            if (ridgedNoiseSample > -16 && ridgedNoiseSample < -10) {
                for (int yPos = startHeight; yPos >= noiseAdded - 18; --yPos) {
                    block.setPos(xPos, yPos, zPos);
                    if (yPos > seaLevel) {
                        chunkIn.setBlockState(block, Blocks.AIR.getDefaultState(), false);
                    }
                }
                if (noise < 1)
                    SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.REDSAND_CF);
                else
                    SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, randomSurfaceConfig(random));
            }
        }

        for (int yPos = startHeight - 3; yPos >= seaLevel; --yPos) {
            block.setPos(xPos, yPos, zPos);
            BlockState currentBlockToReplace = chunkIn.getBlockState(block);
            if (currentBlockToReplace == Blocks.STONE.getDefaultState()) {
                chunkIn.setBlockState(block, BYGBlockList.RED_ROCK.getDefaultState(), false);

            }
        }

        if (noise < 1)
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.REDSAND_CF);
        else
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, randomSurfaceConfig(random));
    }


    public void setSeed(long seed) {
        if (this.seed != seed || this.simplex == null) {
            SharedSeedRandom sharedseedrandom = new SharedSeedRandom(seed);
            this.simplex = new ChunkFastSimplexStyleNoise(sharedseedrandom);
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

    public static SurfaceBuilderConfig randomSurfaceConfig(Random random) {
        int randomizer = random.nextInt(3);

        if (randomizer == 1) {
            return SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG;
        } else
            return BYGSBList.BYGSBConfigList.COARSE;

    }
}