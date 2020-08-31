package voronoiaoc.byg.common.world.surfacebuilders;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.common.noise.simplex.chunkgen.ChunkFastSimplexStyleNoise;
import voronoiaoc.byg.core.byglists.BYGBlockList;
import voronoiaoc.byg.core.byglists.BYGSBList;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

public class CanyonSB extends SurfaceBuilder<SurfaceBuilderBaseConfiguration> {
    public CanyonSB(Codec<SurfaceBuilderBaseConfiguration> config) {
        super(config);
    }

    protected long seed;
    protected ChunkFastSimplexStyleNoise simplex;
    protected ChunkFastSimplexStyleNoise simplex2;

    public void apply(Random random, ChunkAccess chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderBaseConfiguration config) {
        BlockPos.MutableBlockPos block = new BlockPos.MutableBlockPos();
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
                        chunkIn.setBlockState(block, Blocks.AIR.defaultBlockState(), false);
                    }
                }
                if (noise < 1)
                    SurfaceBuilder.DEFAULT.apply
                            (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, SurfaceBuilder.CONFIG_GRASS);
                else
                    SurfaceBuilder.DEFAULT.apply
                            (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.COARSE);
            }
            //Edge 1(Outwardest Edge)
            int noiseAdded = 135;

            if (ridgedNoiseSample > -24 && ridgedNoiseSample < -20) {
                for (int yPos = startHeight; yPos >= noiseAdded; --yPos) {
                    block.set(xPos, yPos, zPos);
                    if (yPos > seaLevel) {
                        chunkIn.setBlockState(block, Blocks.AIR.defaultBlockState(), false);
                    }
                }
                if (noise < 1)
                    SurfaceBuilder.DEFAULT.apply
                            (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.REDSAND_CF);
                else
                    SurfaceBuilder.DEFAULT.apply
                            (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, randomSurfaceConfig(random));
            }
            //Edge 2(Middle Edge)
            if (ridgedNoiseSample > -20 && ridgedNoiseSample < -16) {
                for (int yPos = startHeight; yPos >= noiseAdded - 9; --yPos) {
                    block.set(xPos, yPos, zPos);
                    if (yPos > seaLevel) {
                        chunkIn.setBlockState(block, Blocks.AIR.defaultBlockState(), false);
                    }
                }
                if (noise < 1)
                    SurfaceBuilder.DEFAULT.apply
                            (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.REDSAND_CF);
                else
                    SurfaceBuilder.DEFAULT.apply
                            (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, randomSurfaceConfig(random));
            }
            //Edge 3(Inner Edge)
            if (ridgedNoiseSample > -16 && ridgedNoiseSample < -10) {
                for (int yPos = startHeight; yPos >= noiseAdded - 18; --yPos) {
                    block.set(xPos, yPos, zPos);
                    if (yPos > seaLevel) {
                        chunkIn.setBlockState(block, Blocks.AIR.defaultBlockState(), false);
                    }
                }
                if (noise < 1)
                    SurfaceBuilder.DEFAULT.apply
                            (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.REDSAND_CF);
                else
                    SurfaceBuilder.DEFAULT.apply
                            (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, randomSurfaceConfig(random));
            }
        }

        for (int yPos = startHeight - 3; yPos >= seaLevel; --yPos) {
            block.set(xPos, yPos, zPos);
            BlockState currentBlockToReplace = chunkIn.getBlockState(block);
            if (currentBlockToReplace == Blocks.STONE.defaultBlockState()) {
                chunkIn.setBlockState(block, BYGBlockList.RED_ROCK.defaultBlockState(), false);

            }
        }

        if (noise < 1)
            SurfaceBuilder.DEFAULT.apply
                    (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BYGSBList.BYGSBConfigList.REDSAND_CF);
        else
            SurfaceBuilder.DEFAULT.apply
                    (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, randomSurfaceConfig(random));
    }

    @Override
    public void initNoise(long seed) {
        if (this.seed != seed || this.simplex == null) {
            WorldgenRandom sharedseedrandom = new WorldgenRandom(seed);
            this.simplex = new ChunkFastSimplexStyleNoise(sharedseedrandom);
        }
        if (this.seed != seed || this.simplex2 == null) {
            WorldgenRandom sharedseedrandom = new WorldgenRandom(1999L + seed);
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

    public static SurfaceBuilderBaseConfiguration randomSurfaceConfig(Random random) {
        int randomizer = random.nextInt(3);

        if (randomizer == 1) {
            return SurfaceBuilder.CONFIG_GRASS;
        } else
            return BYGSBList.BYGSBConfigList.COARSE;

    }
}