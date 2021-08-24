package corgiaoc.byg.common.world.feature.overworld;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.SimpleBlockProviderConfig;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;

import java.util.Random;

public class ArchFeature extends Feature<SimpleBlockProviderConfig> {

    public ArchFeature(Codec<SimpleBlockProviderConfig> configCodec) {
        super(configCodec);
    }

    protected long seed;
    protected static FastNoise fastNoise;

    @Override
    public boolean place(WorldGenLevel world, ChunkGenerator chunkGenerator, Random random, BlockPos pos, SimpleBlockProviderConfig config) {
        setSeed(world.getSeed());
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(pos);
        int curveLength = 35;

        BlockPos.MutableBlockPos mutable2 = new BlockPos.MutableBlockPos();

            for (int z = -curveLength; z <= curveLength; z++) {
                mutable2.set(mutable.getX(), 0, mutable.getZ() + z);
                int height = getArchHeight(z);
                mutable2.move(Direction.UP, height + pos.getY() + 15);

                BlockPos.MutableBlockPos thicknessPos = new BlockPos.MutableBlockPos().set(mutable2);


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