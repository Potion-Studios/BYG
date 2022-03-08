package potionstudios.byg.common.world.feature.gen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.material.FluidState;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.config.NoisySphereConfig;
import potionstudios.byg.common.world.math.noise.fastnoise.FastNoise;

import java.util.ArrayList;
import java.util.Random;

public class NoisyCaveSphere extends Feature<NoisySphereConfig> {
    protected static FastNoise fastNoise;
    protected long seed;

    public NoisyCaveSphere(Codec<NoisySphereConfig> configCodec) {
        super(configCodec);
    }


    @Override
    public boolean place(FeaturePlaceContext<NoisySphereConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator chunkGenerator, Random random, BlockPos position, NoisySphereConfig config) {
        setSeed(world.getSeed());

        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(position.below(2 + random.nextInt(10)));
        BlockPos.MutableBlockPos mutable2 = new BlockPos.MutableBlockPos().set(mutable);
        int stackHeight = config.stackHeight().sample(random);
        NoisySphereConfig.RadiusSettings radiusSettings = config.radiusSettings();
        int xRadius = radiusSettings.xRadius().sample(random) / 2;
        int yRadius = radiusSettings.yRadius().sample(random) / 2;
        int zRadius = radiusSettings.zRadius().sample(random) / 2;
        fastNoise.SetFrequency(config.noiseFrequency());
        double radiusDivisorPerStack = config.radiusDivisorPerStack();

        ArrayList<BlockPos> caveAir = new ArrayList<>();

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
                            if (mutable2.getY() <= 30) {
                                placeFluid(world, config.fluidState(), mutable2);
                            } else {
                                BlockState state = config.blockProvider().getState(random, mutable2);
                                if (state.isAir()) {
                                    caveAir.add(mutable2.immutable());
                                }
                                world.setBlock(mutable2, state, 2);

                                // Remove non solids
                                for (int i = 0; i < 8; i++) {
                                    BlockState blockState = world.getBlockState(mutable2);
                                    if ((!blockState.canOcclude() && !blockState.isAir()) || blockState.is(BYGBlocks.CRYPTIC_VENT) || blockState.is(BYGBlocks.TALL_CRYPTIC_VENT) || blockState.is(BYGBlocks.CRYPTIC_FIRE)) {
                                        world.removeBlock(mutable2, false);
                                    }
                                    mutable2.move(Direction.UP);
                                }
                            }
                        }
                    }
                    xRadius = (int) (xRadius / radiusDivisorPerStack);
                    yRadius = (int) (yRadius / radiusDivisorPerStack);
                    zRadius = (int) (zRadius / radiusDivisorPerStack);
                }
            }

            for (BlockPos blockPos : caveAir) {
                for (Holder<PlacedFeature> spawningFeature : config.spawningFeatures()) {
                    spawningFeature.value().place(world, chunkGenerator, random, blockPos);
                }
            }

        }
        return true;
    }

    public static void placeFluid(WorldGenLevel world, FluidState fluidState, BlockPos.MutableBlockPos mutable2) {
        boolean isSolidAllAround = true;
        for (Direction direction : Direction.values()) {
            if (direction != Direction.UP) {
                BlockState blockState = world.getBlockState(mutable2.relative(direction));
                if (blockState.getFluidState().getType() == fluidState.getType())
                    continue;

                if (!blockState.canOcclude()) {
                    isSolidAllAround = false;
                    break;
                }
            }
        }

        if (isSolidAllAround) {
            world.setBlock(mutable2, fluidState.createLegacyBlock().getBlock().defaultBlockState(), 2);
            world.scheduleTick(mutable2, fluidState.getType(), 0);
        }
    }


    public void setSeed(long seed) {
        if (this.seed != seed || fastNoise == null) {
            fastNoise = new FastNoise((int) seed);
            fastNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
            this.seed = seed;
        }
    }
}