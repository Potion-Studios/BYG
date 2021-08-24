package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

import java.util.Random;

public class BasaltBarreraSB extends SurfaceBuilder<SurfaceBuilderBaseConfiguration> {

    public static FastNoise noiseGen = null;
    public static FastNoise simplexGen = null;

    public BasaltBarreraSB(Codec<SurfaceBuilderBaseConfiguration> codec) {
        super(codec);
    }

    public void apply(Random random, ChunkAccess chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderBaseConfiguration config) {
        initNoise(seed);
        int xPos = x & 15;
        int zPos = z & 15;
        int topHeight;
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos(xPos, 0, zPos);

        float sampleNoise = noiseGen.GetNoise(x, z);
        float simplexNoise = simplexGen.GetNoise(x, z);

        int groundLevel = chunkIn.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, x, z);

        if (simplexNoise > 0) {
            topHeight = Math.abs((int) (sampleNoise * 2) * 2) + groundLevel;
        } else {
            topHeight = Math.abs((int) (sampleNoise * 2)) + groundLevel;
        }


        mutable.move(Direction.UP, topHeight);

        for (int y = Math.abs(topHeight); y >= groundLevel - 2; y--) {
            chunkIn.setBlockState(mutable, Blocks.BASALT.defaultBlockState(), false);
            mutable.move(Direction.DOWN);
        }
    }

    @Override
    public void initNoise(long seed) {
        if (noiseGen == null) {
            noiseGen = new FastNoise((int) seed);
            noiseGen.SetNoiseType(FastNoise.NoiseType.WhiteNoise);
            noiseGen.SetFractalOctaves(1);
            noiseGen.SetFrequency(0.002f);
        }

        if (simplexGen == null) {
            simplexGen = new FastNoise((int) seed);
            simplexGen.SetNoiseType(FastNoise.NoiseType.SimplexFractal);
            simplexGen.SetFractalOctaves(3);
            simplexGen.SetFrequency(0.009f);
        }
    }
}