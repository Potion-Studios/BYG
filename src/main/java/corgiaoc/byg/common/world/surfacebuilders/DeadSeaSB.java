package corgiaoc.byg.common.world.surfacebuilders;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.PerlinNoiseGenerator;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import corgiaoc.byg.common.world.worldtype.noise.simplex.chunkgen.ChunkFastSimplexStyleNoise;
import corgiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class DeadSeaSB extends SurfaceBuilder<SurfaceBuilderConfig> {
    protected ChunkFastSimplexStyleNoise noiseGen;
    protected long seed;
    protected PerlinNoiseGenerator perlin1;
    BlockState[] blockStateArray = {BYGBlockList.ROCKY_STONE.getDefaultState(), Blocks.STONE.getDefaultState(), BYGBlockList.MOSSY_STONE.getDefaultState()};

    public DeadSeaSB(Codec<SurfaceBuilderConfig> config) {
        super(config);
    }

    public void setSeed(long seed) {
        if (this.seed != seed || this.noiseGen == null) {
            this.noiseGen = new ChunkFastSimplexStyleNoise(seed);
            this.seed = seed;
        }
    }

    public void buildSurface(Random random, IChunk chunk, Biome biome, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        this.noiseGen = new ChunkFastSimplexStyleNoise(seed);
        boolean flag = Math.cos(noise / 3.0D * Math.PI) > 0.0D;
        double noise2D;
        double noise3D;
        int maximumHeight;
        BlockPos blockPos = new BlockPos(x * 4, 0, z * 4);
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (int xCoord = 0; xCoord < 16; xCoord++) {
            for (int zCoord = 0; zCoord < 16; zCoord++) {
                mutable.setPos(blockPos.getX() + (xCoord), blockPos.getY(), blockPos.getZ() + (zCoord));
                noise3D = noiseGen.sample2D(mutable.getX() * 0.009D, mutable.getZ() * 0.009D);
                noise2D = 1 - Math.sqrt(noise3D * noise3D) * 0.707;
                noise2D = noise3D * noise3D;
                noise2D += noiseGen.sample2D(x * 0.004 + 2398408, z * 0.004) * 0.003;
                maximumHeight = (int) (noise2D * 75D);

                mutable.move(Direction.UP, maximumHeight);
                for (int y = maximumHeight; y >= 0; y--) {
                    if (chunk.getBlockState(mutable).isAir() || chunk.getBlockState(mutable).getFluidState().isTagged(FluidTags.WATER) || chunk.getBlockState(mutable).getBlock() == Blocks.WATER) {
                        chunk.setBlockState(mutable, BYGBlockList.ROCKY_STONE.getDefaultState(), false);
                    }
                    mutable.move(Direction.DOWN);
                }

            }
        }
    }
}