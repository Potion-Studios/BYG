package voronoiaoc.byg.common.world.surfacebuilders;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.noise.OctaveSimplexNoiseSampler;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import voronoiaoc.byg.common.noise.simplex.chunkgen.ChunkFastSimplexStyleNoise;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class DeadSeaSB extends SurfaceBuilder<TernarySurfaceConfig> {
    protected ChunkFastSimplexStyleNoise noiseGen;
    protected long seed;
    protected OctaveSimplexNoiseSampler perlin1;
    BlockState[] blockStateArray = {BYGBlockList.ROCKY_STONE.getDefaultState(), Blocks.STONE.getDefaultState(), BYGBlockList.MOSSY_STONE.getDefaultState()};

    public DeadSeaSB(Codec<TernarySurfaceConfig> config) {
        super(config);
    }

    @Override
    public void initSeed(long seed) {
        if (this.seed != seed || this.noiseGen == null) {
            this.noiseGen = new ChunkFastSimplexStyleNoise(seed);
            this.seed = seed;
        }
    }

    @Override
    public void generate(Random random, Chunk chunk, Biome biome, int x, int z, int height, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, TernarySurfaceConfig surfaceBlocks) {
        this.noiseGen = new ChunkFastSimplexStyleNoise(seed);
        boolean flag = Math.cos(noise / 3.0D * Math.PI) > 0.0D;
        double noise2D;
        double noise3D;
        int maximumHeight;
        BlockPos blockPos = new BlockPos(x * 4, 0, z * 4);
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (int xCoord = 0; xCoord < 16; xCoord++) {
            for (int zCoord = 0; zCoord < 16; zCoord++) {
                mutable.set(blockPos.getX() + (xCoord), blockPos.getY(), blockPos.getZ() + (zCoord));
                noise3D = noiseGen.sample2D(mutable.getX() * 0.009D, mutable.getZ() * 0.009D);
                noise2D = 1 - Math.sqrt(noise3D * noise3D) * 0.707;
                noise2D = noise3D * noise3D;
                noise2D += noiseGen.sample2D(x * 0.004 + 2398408, z * 0.004) * 0.003;
                maximumHeight = (int) (noise2D * 75D);

                mutable.move(Direction.UP, maximumHeight);
                for (int y = maximumHeight; y >= 0; y--) {
                    if (chunk.getBlockState(mutable).isAir() || chunk.getBlockState(mutable).getFluidState().matches(FluidTags.WATER) || chunk.getBlockState(mutable).getBlock() == Blocks.WATER) {
                        chunk.setBlockState(mutable, BYGBlockList.ROCKY_STONE.getDefaultState(), false);
                    }
                    mutable.move(Direction.DOWN);
                }

            }
        }
    }
}