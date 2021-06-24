package corgiaoc.byg.common.world.feature.end.islands;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.FloatingIslandConfig;
import corgiaoc.byg.util.noise.fastnoise.lite.FastNoiseLite;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class FloatingIslands1 extends Feature<FloatingIslandConfig> {

    FastNoiseLite perlin = null;


    public FloatingIslands1(Codec<FloatingIslandConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<FloatingIslandConfig> context) {
        setSeed(context.getWorld().getSeed());

        double radius = 15; /*rand.nextInt(config.getMaxPossibleRadius()) + config.getMinRadius() - 5;*/

        if (context.getWorld().getTopY(Heightmap.Type.OCEAN_FLOOR_WG, context.getOrigin().getX(), context.getOrigin().getZ()) > 4)
            return false;

        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (double x = -radius; x <= radius; x++) {
            for (double y = 1; y <= radius; y++) {
                for (double z = -radius; z <= radius; z++) {
                    mutable.set(context.getOrigin()).move((int) x, (int) (y - radius), (int) z);
                    double noise = FastNoiseLite.getSpongePerlinValue(perlin.GetNoise(mutable.getX(), mutable.getY(), mutable.getZ()));
                    double scaledNoise = (noise) * ((y * 3) / ((x * x) + (z * z)));
                    if (scaledNoise >= 0.5) {
                        if (y == radius)
                            context.getWorld().setBlockState(mutable, context.getConfig().getTopBlockProvider().getBlockState(context.getRandom(), mutable), 2);
                        else
                            context.getWorld().setBlockState(mutable, context.getConfig().getBlockProvider().getBlockState(context.getRandom(), mutable), 2);
                    }
                }
            }
        }
        return true;
    }


    public void setSeed(long seed) {
        if (perlin == null) {
            perlin = FastNoiseLite.createSpongePerlin((int) seed);
            perlin.SetFrequency(0.2F);
        }
    }
}