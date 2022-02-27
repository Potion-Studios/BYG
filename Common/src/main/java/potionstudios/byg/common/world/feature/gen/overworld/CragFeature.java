package potionstudios.byg.common.world.feature.gen.overworld;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.material.Fluids;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.config.SimpleBlockProviderConfig;
import potionstudios.byg.common.world.math.noise.fastnoise.lite.FastNoiseLite;

import java.util.Random;

public class CragFeature extends Feature<SimpleBlockProviderConfig> {

    FastNoiseLite fnlPerlin = null;

    public CragFeature(Codec<SimpleBlockProviderConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<SimpleBlockProviderConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random rand, BlockPos pos, SimpleBlockProviderConfig config) {
        setSeed(world.getSeed());


        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        SimpleBlockProviderConfig simpleBlockProviderConfig = new SimpleBlockProviderConfig(
//            new BetweenNoiseThresholdProvider(123, new NormalNoise.NoiseParameters(-9, 1.0D, 1.0D, 1.0D, 1.0D), 1,
//                BetweenNoiseThresholdProvider.createThresholds(0.0125F, -0.5F, 0.5F),
//                SimpleStateProvider.simple(Blocks.STONE), SimpleStateProvider.simple(BYGBlocks.DACITE), false)
            SimpleStateProvider.simple(Blocks.STONE)
        );


        SimpleBlockProviderConfig topBlockProviderConfig = new SimpleBlockProviderConfig(
//            new BetweenNoiseThresholdProvider(123, new NormalNoise.NoiseParameters(-9, 1.0D, 1.0D, 1.0D, 1.0D), 1,
//                BetweenNoiseThresholdProvider.createThresholds(0.0125F, -0.5F, 0.5F),
//                SimpleStateProvider.simple(BYGBlocks.OVERGROWN_STONE), SimpleStateProvider.simple(BYGBlocks.OVERGROWN_DACITE), false)
            SimpleStateProvider.simple(BYGBlocks.OVERGROWN_STONE)

        );

        double baseRadius = 10;
        double leakage = 0.5;
        int volcanoConeSize = 30;
        int volcanoStartHeight = volcanoConeSize - 5;
        double threshold = 0.4;
        int fluidY = -20 + rand.nextInt(9);

        for (double x = -volcanoConeSize; x <= volcanoConeSize; x++) {
            mutable.setX((int) (pos.getX() + x));
            for (double z = -volcanoConeSize; z <= volcanoConeSize; z++) {
                mutable.setZ((int) (pos.getZ() + z));
                float noise3 = FastNoiseLite.getSpongePerlinValue(fnlPerlin.GetNoise(mutable.getX(), mutable.getZ()));
                int topY = pos.getY();
                int oceanFloorHeight = world.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, mutable.getX(), mutable.getZ()) - 2;
                for (double y = -volcanoConeSize; y <= -15; y++) {
                    mutable.setY((int) (pos.getY() + y + volcanoStartHeight));

                    double scaledNoise = (noise3 / 11) * (-(y * baseRadius) / ((x * x) + (z * z)));
                    if (scaledNoise - leakage >= threshold) {
                        if (y <= fluidY) {
                            while (mutable.getY() > oceanFloorHeight) {
                                if (mutable.getY() > pos.getY()) {
                                    world.setBlock(mutable, Blocks.WATER.defaultBlockState(), 2);
                                    world.scheduleTick(mutable, Fluids.WATER, 0);
                                } else {
                                    world.setBlock(mutable, Blocks.STONE.defaultBlockState(), 2);
                                }
                                mutable.move(Direction.DOWN);
                            }
                        }
                    } else if (scaledNoise >= threshold) {
                        int startY = mutable.getY();
                        BlockState movingState = world.getBlockState(mutable);

                        for (int worldY = startY; worldY > oceanFloorHeight; worldY--) {
                            if (!movingState.canOcclude()) {
                                topY = Math.max(mutable.getY(), topY);
                                world.setBlock(mutable, simpleBlockProviderConfig.getBlockProvider().getState(rand, mutable), 2);
                            } else {
                                break;
                            }
                            mutable.move(Direction.DOWN);
                        }
                    }
                }
                if (topY != pos.getY()) {
                    mutable.setY(topY);
                    if (world.getFluidState(mutable.immutable().above()).isEmpty()) {
                        world.setBlock(mutable, topBlockProviderConfig.getBlockProvider().getState(rand, mutable), 2);
                    }
                }
            }
        }
        return true;
    }


    public void setSeed(long seed) {
        if (fnlPerlin == null) {
            fnlPerlin = FastNoiseLite.createSpongePerlin((int) seed);
            fnlPerlin.SetFrequency(0.2F);
        }
    }
}
