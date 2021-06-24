package corgiaoc.byg.common.world.feature.overworld;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.SimpleBlockProviderConfig;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;

public class ArchFeature extends Feature<SimpleBlockProviderConfig> {

    public ArchFeature(Codec<SimpleBlockProviderConfig> configCodec) {
        super(configCodec);
    }

    protected long seed;
    protected static FastNoise fastNoise;

    @Override
    public boolean generate(FeatureContext<SimpleBlockProviderConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();
        Random random = context.getRandom();
        SimpleBlockProviderConfig config = context.getConfig();

        setSeed(world.getSeed());
        BlockPos.Mutable mutable = new BlockPos.Mutable().set(pos);
        int curveLength = 35;

        BlockPos.Mutable mutable2 = new BlockPos.Mutable();

//        for (int x = -curveLength; x <= curveLength; x++) {
        for (int z = -curveLength; z <= curveLength; z++) {
            mutable2.set(mutable.getX(), 0, mutable.getZ() + z);
            int height = -getArchHeight(z);
            mutable2.move(Direction.UP, height);
            world.setBlockState(mutable2, config.getBlockProvider().getBlockState(random, mutable2), 2);
            mutable2.move(Direction.DOWN);
        }
//        }
        return true;
    }

    public static int getArchHeight(int z) {
        return (int) ((-z * z) * 0.15);
    }


    public void setSeed(long seed) {
        if (this.seed != seed || fastNoise == null) {
            fastNoise = new FastNoise((int) seed);
            fastNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
            this.seed = seed;
        }
    }
}