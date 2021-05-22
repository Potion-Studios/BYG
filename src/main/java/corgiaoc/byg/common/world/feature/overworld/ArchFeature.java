package corgiaoc.byg.common.world.feature.overworld;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.SimpleBlockProviderConfig;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class ArchFeature extends Feature<SimpleBlockProviderConfig> {

    public ArchFeature(Codec<SimpleBlockProviderConfig> configCodec) {
        super(configCodec);
    }

    protected long seed;
    protected static FastNoise fastNoise;

    @Override
    public boolean place(ISeedReader world, ChunkGenerator chunkGenerator, Random random, BlockPos pos, SimpleBlockProviderConfig config) {
        setSeed(world.getSeed());
        BlockPos.Mutable mutable = new BlockPos.Mutable().set(pos);
        int curveLength = 35;

        BlockPos.Mutable mutable2 = new BlockPos.Mutable();

            for (int z = -curveLength; z <= curveLength; z++) {
                mutable2.set(mutable.getX(), 0, mutable.getZ() + z);
                int height = getArchHeight(z);
                mutable2.move(Direction.UP, height + pos.getY() + 15);

                BlockPos.Mutable thicknessPos = new BlockPos.Mutable().set(mutable2);


                int horizontalThicknessTotal = 4;
                for (int archHorizontalThickness = -horizontalThicknessTotal; archHorizontalThickness <= horizontalThicknessTotal; archHorizontalThickness++) {
                    thicknessPos.setX(mutable2.getX() + archHorizontalThickness);

                    for (int archVerticalThickness = 0; archVerticalThickness <= 4; archVerticalThickness++) {
                        world.setBlock(thicknessPos, config.getBlockProvider().getState(random, thicknessPos), 2);
                        thicknessPos.move(Direction.DOWN);
                    }
                    thicknessPos.setY(mutable2.getY() + Math.abs(archHorizontalThickness) * 2);
                }
            }
        return true;
    }

    public static int getArchHeight(int z) {
        return (int) ((-z * z) * 0.2);
    }


    public void setSeed(long seed) {
        if (this.seed != seed || fastNoise == null) {
            fastNoise = new FastNoise((int) seed);
            fastNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
            this.seed = seed;
        }
    }
}