package corgiaoc.byg.common.world.feature;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.NoisySphereConfig;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class MineralDeposit extends Feature<NoisySphereConfig> {
    protected static FastNoise fastNoise;
    protected long seed;

    public MineralDeposit(Codec<NoisySphereConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(ISeedReader world, ChunkGenerator chunkGenerator, Random random, BlockPos position, NoisySphereConfig config) {
        setSeed(world.getSeed());

        BlockPos.Mutable mutable = new BlockPos.Mutable().set(position.below(random.nextInt(3)));
        BlockPos.Mutable mutable2 = new BlockPos.Mutable().set(mutable);
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

                        world.setBlock(mutable2, config.getBlockProvider().getState(random, mutable2), 2);
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