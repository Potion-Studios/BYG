package voronoiaoc.byg.common.world.surfacebuilders;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.common.noise.simplex.chunkgen.ChunkFastSimplexStyleNoise;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.minecraft.world.level.levelgen.synth.PerlinSimplexNoise;

public class DeadSeaSB extends SurfaceBuilder<SurfaceBuilderBaseConfiguration> {
    protected ChunkFastSimplexStyleNoise noiseGen;
    protected long seed;
    protected PerlinSimplexNoise perlin1;
    BlockState[] blockStateArray = {BYGBlockList.ROCKY_STONE.defaultBlockState(), Blocks.STONE.defaultBlockState(), BYGBlockList.MOSSY_STONE.defaultBlockState()};

    public DeadSeaSB(Codec<SurfaceBuilderBaseConfiguration> config) {
        super(config);
    }

    @Override
    public void initNoise(long seed) {
        if (this.seed != seed || this.noiseGen == null) {
            this.noiseGen = new ChunkFastSimplexStyleNoise(seed);
            this.seed = seed;
        }
    }

    @Override
    public void apply(Random random, ChunkAccess chunk, Biome biome, int x, int z, int height, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderBaseConfiguration surfaceBlocks) {
        this.noiseGen = new ChunkFastSimplexStyleNoise(seed);
        boolean flag = Math.cos(noise / 3.0D * Math.PI) > 0.0D;
        double noise2D;
        double noise3D;
        int maximumHeight;
        BlockPos blockPos = new BlockPos(x * 4, 0, z * 4);
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

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
                    if (chunk.getBlockState(mutable).isAir() || chunk.getBlockState(mutable).getFluidState().is(FluidTags.WATER) || chunk.getBlockState(mutable).getBlock() == Blocks.WATER) {
                        chunk.setBlockState(mutable, BYGBlockList.ROCKY_STONE.defaultBlockState(), false);
                    }
                    mutable.move(Direction.DOWN);
                }

            }
        }
    }
}