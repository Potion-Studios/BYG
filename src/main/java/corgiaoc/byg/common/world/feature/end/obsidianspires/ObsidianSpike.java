package corgiaoc.byg.common.world.feature.end.obsidianspires;

import com.mojang.serialization.Codec;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class ObsidianSpike extends Feature<NoFeatureConfig> {
    protected FastNoise noiseGen;
    protected FastNoise noiseGen2;

    public ObsidianSpike(Codec<NoFeatureConfig> config) {
        super(config);
    }

    public void setSeed(long seed) {
        if (this.noiseGen == null) {
            this.noiseGen = new FastNoise((int) seed);
        }
        if (this.noiseGen2 == null) {
            this.noiseGen2 = new FastNoise((int) (seed + 13838344));

        }
    }

    @Override
    public boolean func_241855_a(ISeedReader world, ChunkGenerator changedBlock, Random rand, BlockPos position, NoFeatureConfig config) {
        setSeed(world.getSeed());
        double noise;
        double noise2;

        int maximumHeight;
        int terrainHeight;
        BlockPos.Mutable mutable = new BlockPos.Mutable();

            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    mutable.setPos(position.getX() + x, 0, position.getZ() + z);

                    noise2 = (noiseGen.GetSimplex(mutable.getX() * 0.04F, mutable.getY() * 0.04F, mutable.getZ() * 0.04F) + 1D) * 5D;
                    noise = Math.pow(Math.abs(noiseGen.GetSimplex(mutable.getX() * 0.018F, mutable.getZ() * 0.015F)) + noise2 * 0.005D, 7);

                    maximumHeight = (int) (noise * 100D);
                    terrainHeight = world.getHeight(Heightmap.Type.MOTION_BLOCKING, mutable.getX(), mutable.getZ());

                    if (terrainHeight >= 55) {
                        mutable.move(Direction.UP, maximumHeight);
                        for (int y = maximumHeight; y >= terrainHeight; y--) {
                            world.setBlockState(mutable, Blocks.OBSIDIAN.getDefaultState(), 2);
                            mutable.move(Direction.DOWN);
                        }
                    }
                }
            }
        return true;
    }
}