package voronoiaoc.byg.common.world.feature.features.overworld;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import voronoiaoc.byg.common.world.feature.config.BYGBoulderFeatureConfig;
import voronoiaoc.byg.common.world.worldtype.noise.fastnoise.FastNoise;

import java.util.Random;

public class StackableBoulders extends Feature<BYGBoulderFeatureConfig> {

    public StackableBoulders(Codec<BYGBoulderFeatureConfig> configCodec) {
        super(configCodec);
    }

    protected long seed;
    protected static FastNoise noiseGen;

    @Override
    public boolean func_241855_a(ISeedReader world, ChunkGenerator chunkGenerator, Random random, BlockPos position, BYGBoulderFeatureConfig config) {
        setSeed(world.getSeed());

        BlockPos.Mutable blockpos$Mutable = new BlockPos.Mutable().setPos(position.down(2 + random.nextInt(10)));
        BlockPos.Mutable blockpos$Mutable2 = new BlockPos.Mutable().setPos(blockpos$Mutable);
        int stackHeight = random.nextInt(config.getMaxPossibleHeight()) + config.getMinHeight();
        int radius = random.nextInt(config.getMaxPossibleRadius()) + config.getMinHeight();

        for (int rockNum = 0; rockNum < stackHeight; rockNum++) {
            blockpos$Mutable.move(
                    random.nextInt(3) - 1,
                    (int) (random.nextInt(radius) * 0.2f + radius * 0.8f) - 1,
                    random.nextInt(3) - 1);

            for (int x = -radius; x <= radius; x++) {
                for (int y = -radius; y <= radius; y++) {
                    for (int z = -radius; z <= radius; z++) {

                        int squaredDistance = x * x + y * y + z * z;
                        if (squaredDistance <= radius * radius) {

                            blockpos$Mutable2.setPos(blockpos$Mutable).move(x, y, z);

                            // Rough the surface of the boulders a bit
                            double noiseValue = noiseGen.GetNoise(blockpos$Mutable2.getX() * 0.04F, blockpos$Mutable2.getY() * 0.01F, blockpos$Mutable2.getZ() * 0.04F);
                            if (squaredDistance > radius * radius * 0.8f &&
                                    noiseValue > -0.3D && noiseValue < 0.3D) {
                                continue;
                            }

                            BlockState blockState = world.getBlockState(blockpos$Mutable2);
                            if (this.canBlockPlaceHere(blockState))
                                world.setBlockState(blockpos$Mutable2, Blocks.ANDESITE.getDefaultState(), 3);
                        }
                    }
                }
            }

            while (blockpos$Mutable.getY() < world.getHeight() && !world.getBlockState(blockpos$Mutable).isAir()) {
                blockpos$Mutable.move(Direction.UP);
            }

            radius = (int) (radius * (0.5f + ((1 - stackHeight / 6f) * 0.5f)) + 1);
        }

        return true;
    }


    public void setSeed(long seed) {
        if (this.seed != seed || noiseGen == null) {
            noiseGen = new FastNoise((int) seed);
            noiseGen.SetNoiseType(FastNoise.NoiseType.Simplex);
            this.seed = seed;
        }
    }

    private boolean canBlockPlaceHere(BlockState blockState) {
        return blockState.isAir() || blockState.getMaterial() == Material.EARTH || blockState.getMaterial() == Material.PLANTS ||
                blockState.getMaterial() == Material.TALL_PLANTS || blockState.getMaterial() == Material.LEAVES ||
                blockState.getMaterial() == Material.SAND || blockState.getMaterial() == Material.BAMBOO || blockState.getMaterial() == Material.CACTUS
                || blockState.getMaterial() == Material.WATER || blockState.getMaterial() == Material.LAVA;
    }
}