package corgiaoc.byg.common.world.feature.overworld;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.PointyRockConfig;
import corgiaoc.byg.util.noise.simplex.chunkgen.ChunkFastSimplexStyleNoise;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class PointyRockFeature extends Feature<PointyRockConfig> {

    protected long seed;
    protected ChunkFastSimplexStyleNoise noiseGen;
    protected ChunkFastSimplexStyleNoise noiseGen2;

    public PointyRockFeature(Codec<PointyRockConfig> config) {
        super(config);
    }

    public void setSeed(long seed) {
        if (this.seed != seed || this.noiseGen == null) {
            this.noiseGen = new ChunkFastSimplexStyleNoise(seed + 193895856);
            this.noiseGen2 = new ChunkFastSimplexStyleNoise(seed + 294856869);
            this.seed = seed;
        }
    }

    @Override
    public boolean generate(StructureWorldAccess world,  ChunkGenerator changedBlock, Random rand, BlockPos position, PointyRockConfig config) {
        long randomLong = rand.nextLong();
        setSeed(world.getSeed() + 215465128 + randomLong);
        double noise;
        double noise2;

        int maximumHeight;
        int terrainHeight;
        BlockPos.Mutable mutable = new BlockPos.Mutable();


        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                mutable.set(position.getX() + x, 0, position.getZ() + z);

                noise2 = (noiseGen.noise3_Classic(mutable.getX() * 0.04D, mutable.getY() * 0.04D, mutable.getZ() * 0.04D) + 1D) * 5D;
                noise = Math.pow(Math.abs(noiseGen.sample2D(mutable.getX() * 0.013D, mutable.getZ() * 0.013D)) + noise2 * 0.005D, 7);

                maximumHeight = (int) (noise * 65D);
                maximumHeight = (int) (maximumHeight * config.getHeightMultiplier());
                terrainHeight = world.getTopY(Heightmap.Type.OCEAN_FLOOR_WG, mutable.getX(), mutable.getZ());

                mutable.move(Direction.UP, maximumHeight);
                for (int y = maximumHeight; y >= terrainHeight; y--) {
                    world.setBlockState(mutable, config.getBlockProvider().getBlockState(rand, mutable), 2);
                    mutable.move(Direction.DOWN);
                }
            }
        }
        return true;
    }
}