package corgiaoc.byg.common.world.feature.overworld;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.PointyRockConfig;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class PointyRockFeature extends Feature<PointyRockConfig> {
    protected long seed;
    protected FastNoise noiseGen;
    protected FastNoise noiseGen2;

    public PointyRockFeature(Codec<PointyRockConfig> config) {
        super(config);
    }

    @Override
    public boolean func_241855_a(ISeedReader world, ChunkGenerator changedBlock, Random rand, BlockPos position, PointyRockConfig config) {
        long randomLong = rand.nextLong();
        setSeed(world.getSeed() + 215465128 + randomLong);
        double noise;
        double noise2;

        int maximumHeight;
        int terrainHeight;
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                mutable.setPos(position.getX() + x, 0, position.getZ() + z);

                noise2 = (noiseGen.GetSimplex(mutable.getX() * 0.04F, mutable.getY() * 0.04F, mutable.getZ() * 0.04F) + 1D) * 5D;
                noise = Math.pow(Math.abs(noiseGen.GetSimplex(mutable.getX() * 0.013F, mutable.getZ() * 0.013F)) + noise2 * 0.005D, 7);

                maximumHeight = (int) (noise * config.getSeed());
                terrainHeight = world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, mutable.getX(), mutable.getZ());

                mutable.move(Direction.UP, maximumHeight);
                for (int y = maximumHeight; y >= terrainHeight; y--) {
                    world.setBlockState(mutable, config.getBlockProvider().getBlockState(rand, mutable), 2);

                    mutable.move(Direction.DOWN);
                }
            }
        }
        return true;
    }

    public void setSeed(long seed) {
        if (this.noiseGen == null) {
            this.noiseGen = new FastNoise((int) (seed + 193895856));
        }

        if (this.noiseGen2 == null) {
            this.noiseGen2 = new FastNoise((int) (seed + 294856869));
        }
    }
}