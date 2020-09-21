package voronoiaoc.byg.common.world.feature.features.overworld;

import com.mojang.serialization.Codec;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import voronoiaoc.byg.common.world.feature.featureconfig.PointyRockFeatureConfig;
import voronoiaoc.byg.common.world.worldtype.noise.simplex.chunkgen.ChunkFastSimplexStyleNoise;

import java.util.Random;

public class PointyRockFeature extends Feature<PointyRockFeatureConfig> {
    protected long seed;
    protected ChunkFastSimplexStyleNoise noiseGen;
    protected ChunkFastSimplexStyleNoise noiseGen2;

    public PointyRockFeature(Codec<PointyRockFeatureConfig> config) {
        super(config);
    }

    @Override
    public boolean func_241855_a(ISeedReader world, ChunkGenerator changedBlock, Random rand, BlockPos position, PointyRockFeatureConfig config) {
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

                noise2 = (noiseGen.noise3_Classic(mutable.getX() * 0.04D, mutable.getY() * 0.04D, mutable.getZ() * 0.04D) + 1D) * 5D;
                noise = Math.pow(Math.abs(noiseGen.sample2D(mutable.getX() * 0.013D, mutable.getZ() * 0.013D)) + noise2 * 0.005D, 7);

                maximumHeight = (int) (noise * config.getHeight());
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
        if (this.seed != seed || this.noiseGen == null) {
            this.noiseGen = new ChunkFastSimplexStyleNoise(seed + 193895856);
            this.noiseGen2 = new ChunkFastSimplexStyleNoise(seed + 294856869);
            this.seed = seed;
        }
    }
}