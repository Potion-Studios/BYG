package corgiaoc.byg.common.world.feature.overworld.volcano;

import com.mojang.serialization.Codec;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class NoiseVolcano extends Feature<NoFeatureConfig> {

    private FastNoise noiseGen = null;

    public void setSeed(long seed) {
        if (noiseGen == null) {
            noiseGen = new FastNoise((int) seed);
            noiseGen.SetFractalType(FastNoise.FractalType.RigidMulti);
            noiseGen.SetNoiseType(FastNoise.NoiseType.SimplexFractal);
            noiseGen.SetFractalOctaves(1);
            noiseGen.SetFractalGain(0.1f);
            noiseGen.SetFrequency(0.004f);
        }
    }


    public NoiseVolcano(Codec<NoFeatureConfig> config) {
        super(config);
    }

    @Override
    public boolean func_241855_a(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        setSeed(world.getSeed());
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                mutable.setPos(pos.getX() + x, 0, pos.getZ() + z);
                double noise = noiseGen.GetNoise(mutable.getX(), mutable.getZ()) * 2;
                int terrainHeight = world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, mutable.getX(), mutable.getZ()) - 5;
                ///teleport 312 127 -187
                if (noise <= 0.045) {
                    int topHeight = world.getSeaLevel() + 25;
                    mutable.move(Direction.UP, topHeight);
                    for (int y = topHeight; y >= terrainHeight; y--) {
                        world.setBlockState(mutable, Blocks.LAVA.getDefaultState(), 2);
                        world.getPendingFluidTicks().scheduleTick(mutable, Fluids.LAVA, 0);
                        mutable.move(Direction.DOWN);
                    }
                } else if (noise <= 0.34) {
                    int valueToReverse = (int) (Math.abs((int) (noise * 55D) * 1.4));
                    int topHeight = (int) ((valueToReverse - Math.abs(((-noise * 55D) * 1.4 - valueToReverse))) + (world.getSeaLevel() * 1.8));

                    mutable.move(Direction.UP, topHeight);

                    for (int y = topHeight; y >= terrainHeight; y--) {
                        if (y >= topHeight - 7)
                            world.setBlockState(mutable, Blocks.BASALT.getDefaultState(), 2);
                        else if (y <= world.getSeaLevel() + 25) {
                            world.setBlockState(mutable, Blocks.LAVA.getDefaultState(), 2);
                            world.getPendingFluidTicks().scheduleTick(mutable, Fluids.LAVA, 0);
                        }
                        mutable.move(Direction.DOWN);
                    }
                } else if (noise <= 0.63) {
                    int valueToReverse = (int) (Math.abs((int) (noise * 55D) * 1.4));
                    int topHeight = (int) ((valueToReverse - Math.abs(((-noise * 55D) * 1.4 - valueToReverse))) + (world.getSeaLevel() * 1.8));

                    mutable.move(Direction.UP, topHeight);
                    for (int y = topHeight; y >= terrainHeight; y--) {
                        world.setBlockState(mutable, Blocks.BASALT.getDefaultState(), 2);
                        mutable.move(Direction.DOWN);
                    }
                }
            }
        }
        return true;
    }
}