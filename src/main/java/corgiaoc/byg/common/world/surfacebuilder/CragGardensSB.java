package corgiaoc.byg.common.world.surfacebuilder;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.PerlinNoiseGenerator;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;


public class CragGardensSB extends SurfaceBuilder<SurfaceBuilderConfig> {
    public CragGardensSB(Codec<SurfaceBuilderConfig> p_i51310_1_) {
        super(p_i51310_1_);
    }

    protected long noiseSeed;
    protected PerlinNoiseGenerator noiseGen;

    @Override
    public void initNoise(long seed) {
        SharedSeedRandom sharedseedrandom = new SharedSeedRandom(seed);
        if (this.noiseSeed != seed || this.noiseGen == null) {
            this.noiseGen = new PerlinNoiseGenerator(sharedseedrandom, ImmutableList.of(0));
        }

        this.noiseSeed = seed;
    }


    @Override
    public void apply(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        this.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, config.getTopMaterial(), config.getUnderMaterial(), config.getUnderwaterMaterial(), seaLevel);
    }


    protected void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int xStart, int zStart, int landHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, BlockState topBlock, BlockState middleBlock, BlockState bottomBlock, int seaLevel) {
        int x = xStart & 15;
        int z = zStart & 15;
        BlockPos.Mutable blockpos$Mutable = new BlockPos.Mutable();
        double baseRangeHeightMultiplier = 5.0D;
        double samplePerlin1 = (this.noiseGen.getValue((double) xStart * 0.01D, (double) zStart * 0.01D, true) + 1) * baseRangeHeightMultiplier;
        double samplePerlin2 = (this.noiseGen.getValue((double) xStart * 0.007D, (double) zStart * 0.007D, true) + 1) * baseRangeHeightMultiplier;

        int noise1 = ((int) (samplePerlin1)) * 5;
        int noise2 = ((int) (samplePerlin2)) * 3;
        int noise3 = ((int) Math.abs(noise));
        int startHeight = noise1 + noise2 + 40;

        int biomeFloor = (int) (biomeIn.getDepth() * biomeIn.getScale());
        int surfaceFloorDiff = landHeight - biomeFloor;
        int maxNoise = surfaceFloorDiff - 18;

        if (noise > 4) noise3 = maxNoise;

        int heightSnapshot = landHeight - 18 - noise3;

        if (landHeight > 0) {
            if (heightSnapshot < 0) heightSnapshot = 0;
            for (int y = heightSnapshot; y <= startHeight; ++y) {
                blockpos$Mutable.set(x, y, z);

                if (y <= landHeight - 3 - random.nextInt(6)) {
                    chunkIn.setBlockState(blockpos$Mutable, bottomBlock, false);
                } else if (y == startHeight && random.nextInt(3) == 0) {
                    chunkIn.setBlockState(blockpos$Mutable, topBlock, false);
                } else {
                    chunkIn.setBlockState(blockpos$Mutable, middleBlock, false);
                }
            }
        }
    }
}