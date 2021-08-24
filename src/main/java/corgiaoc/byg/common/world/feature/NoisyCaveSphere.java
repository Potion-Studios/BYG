package corgiaoc.byg.common.world.feature;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.NoisySphereConfig;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;

import java.util.Random;

public class NoisyCaveSphere extends Feature<NoisySphereConfig> {
    protected static FastNoise fastNoise;
    protected long seed;

    public NoisyCaveSphere(Codec<NoisySphereConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(WorldGenLevel world, ChunkGenerator chunkGenerator, Random random, BlockPos position, NoisySphereConfig config) {
        setSeed(world.getSeed());

        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(position.below(2 + random.nextInt(10)));
        BlockPos.MutableBlockPos mutable2 = new BlockPos.MutableBlockPos().set(mutable);
        int stackHeight = random.nextInt(config.getMaxPossibleHeight()) + config.getMinHeight();
        int xRadius = config.getRandomXRadius(random);
        int yRadius = config.getRandomYRadius(random);
        int zRadius = config.getRandomZRadius(random);

        for (int stackIDX = 0; stackIDX < stackHeight; stackIDX++) {
            for (int x = -xRadius; x <= xRadius; x++) {
                for (int z = -zRadius; z <= zRadius; z++) {
                    for (int y = -yRadius; y <= yRadius; y++) {
                        mutable2.set(mutable).move(x, y, z);
                        //Credits to Hex_26 for this equation!
                        double equationResult = Math.pow(x, 2) / Math.pow(xRadius, 2) + Math.pow(y, 2) / Math.pow(yRadius, 2) + Math.pow(z, 2) / Math.pow(zRadius, 2);
                        double threshold = 1 + 0.7 * fastNoise.GetNoise(mutable2.getX(), mutable2.getY(), mutable2.getZ());
                        if (equationResult >= threshold)
                            continue;

                        if (world.getBlockState(mutable2).canOcclude()) {
                            if (mutable2.getY() <= config.getFluidStartY()) {
                                boolean isSolidAllAround = true;
                                for (Direction direction : Direction.values()) {
                                    if (direction != Direction.UP) {
                                        BlockState blockState = world.getBlockState(mutable2.relative(direction));
                                        if (blockState.getMaterial() == Material.WATER)
                                            continue;

                                        if (!blockState.canOcclude()) {
                                            isSolidAllAround = false;
                                            break;
                                        }
                                    }
                                }

                                if (isSolidAllAround) {
                                    world.setBlock(mutable2, Blocks.WATER.defaultBlockState(), 2);
                                    world.getLiquidTicks().scheduleTick(mutable2, Fluids.WATER, 0);
                                }
                            } else
                                world.setBlock(mutable2, config.getBlockProvider().getState(random, mutable2), 2);
                        }
                    }
                    xRadius = (int) (xRadius / config.getRadiusDivisorPerStack());
                    yRadius = (int) (yRadius / config.getRadiusDivisorPerStack());
                    zRadius = (int) (zRadius / config.getRadiusDivisorPerStack());
                }
            }
        }
        return true;
    }


    public void setSeed(long seed) {
        if (this.seed != seed || fastNoise == null) {
            fastNoise = new FastNoise((int) seed);
            fastNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
            fastNoise.SetFrequency(0.09f);
            this.seed = seed;
        }
    }
}