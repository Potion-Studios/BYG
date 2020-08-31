package voronoiaoc.byg.common.world.surfacebuilders;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.minecraft.world.level.levelgen.synth.PerlinSimplexNoise;


public class CragGardens extends SurfaceBuilder<SurfaceBuilderBaseConfiguration> {
    public CragGardens(Codec<SurfaceBuilderBaseConfiguration> p_i51310_1_) {
        super(p_i51310_1_);
    }

    protected long noiseSeed;
    protected PerlinSimplexNoise noiseGen;

    @Override
    public void initNoise(long seed) {
        WorldgenRandom sharedseedrandom = new WorldgenRandom(seed);
        if (this.noiseSeed != seed || this.noiseGen == null) {
            this.noiseGen = new PerlinSimplexNoise(sharedseedrandom, ImmutableList.of(0));
        }

        this.noiseSeed = seed;
    }

    @Override
    public void apply(Random random, ChunkAccess chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderBaseConfiguration config) {
        this.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, config.getTopMaterial(), config.getUnderMaterial(), config.getUnderwaterMaterial(), seaLevel);
    }


    protected void buildSurface(Random random, ChunkAccess chunkIn, Biome biomeIn, int xStart, int zStart, int landHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, BlockState topBlock, BlockState middleBlock, BlockState bottomBlock, int seaLevel) {
        int x = xStart & 15;
        int z = zStart & 15;
        BlockPos.MutableBlockPos blockpos$Mutable = new BlockPos.MutableBlockPos();
        double baseRangeHeightMultiplier = 5.0D;
        double samplePerlin1 = (this.noiseGen.getValue((double) xStart * 0.01D, (double) zStart * 0.01D, true) + 1) * baseRangeHeightMultiplier;
        double samplePerlin2 = (this.noiseGen.getValue((double) xStart * 0.007D, (double) zStart * 0.007D, true) + 1) * baseRangeHeightMultiplier;

        int noise1 = ((int) (samplePerlin1)) * 5;
        int noise2 = ((int) (samplePerlin2)) * 3;
        int startHeight = noise1 + noise2 + 40;

        for (int y = landHeight - 30; y <= startHeight; ++y) {
            blockpos$Mutable.set(x, y, z);

            if (y <= landHeight - 3 - random.nextInt(3)) {
                chunkIn.setBlockState(blockpos$Mutable, bottomBlock, false);
            } else if (y == startHeight && random.nextInt(3) == 0) {
                chunkIn.setBlockState(blockpos$Mutable, topBlock, false);
            } else {
                chunkIn.setBlockState(blockpos$Mutable, middleBlock, false);
            }
        }
    }
}