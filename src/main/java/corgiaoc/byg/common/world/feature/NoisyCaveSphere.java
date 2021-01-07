package corgiaoc.byg.common.world.feature;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.NoisyCaveSphereConfig;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.Tags;

import java.util.BitSet;
import java.util.Random;

public class NoisyCaveSphere extends Feature<NoisyCaveSphereConfig> {
    protected static FastNoise fastNoise;
    protected long seed;

    public NoisyCaveSphere(Codec<NoisyCaveSphereConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(ISeedReader world, ChunkGenerator chunkGenerator, Random random, BlockPos position, NoisyCaveSphereConfig config) {
        setSeed(world.getSeed());
        IChunk chunk = world.getChunk(position);

        BitSet airCarvingMask = ((ChunkPrimer) chunk).getOrAddCarvingMask(GenerationStage.Carving.AIR);


        BlockPos.Mutable mutable = new BlockPos.Mutable().setPos(position.down(2 + random.nextInt(10)));
        BlockPos.Mutable mutable2 = new BlockPos.Mutable().setPos(mutable);
        int stackHeight = random.nextInt(config.getMaxPossibleHeight()) + config.getMinHeight();
        int xRadius = config.getRandomXRadius(random);
        int yRadius = config.getRandomYRadius(random);
        int zRadius = config.getRandomZRadius(random);

        for (int stackIDX = 0; stackIDX < stackHeight; stackIDX++) {
            for (int x = -xRadius; x <= xRadius; x++) {
                for (int z = -zRadius; z <= zRadius; z++) {
                    for (int y = -yRadius; y <= yRadius; y++) {
                        mutable2.setPos(mutable).move(x, y, z);
                        //Credits to Hex_26 for this equation!
                        double equationResult = Math.pow(x, 2) / Math.pow(xRadius, 2) + Math.pow(y, 2) / Math.pow(yRadius, 2) + Math.pow(z, 2) / Math.pow(zRadius, 2);
                        double threshold = 1 + 0.7 * fastNoise.GetNoise(mutable2.getX(), mutable2.getY(), mutable2.getZ());
                        if (equationResult >= threshold)
                            continue;

                        if (world.getBlockState(mutable2).isSolid()) {
                            int bitIndex = (mutable2.getX() & 0xF) | ((mutable2.getZ() & 0xF) << 4) | (mutable2.getY() << 8);
                            airCarvingMask.set(bitIndex);
                            if (mutable2.getY() <= 25) {
                                boolean isSolidAllAround = true;
                                for (Direction direction : Direction.values()) {
                                    if (direction != Direction.UP) {
                                        BlockState blockState = world.getBlockState(mutable2.offset(direction));
                                        if (blockState.getMaterial() == Material.LAVA)
                                            continue;

                                        if (!blockState.isSolid()) {
                                            isSolidAllAround = false;
                                            break;
                                        }
                                    }
                                }

                                if (isSolidAllAround) {
                                    world.setBlockState(mutable2, Blocks.LAVA.getDefaultState(), 2);
                                    world.getPendingFluidTicks().scheduleTick(mutable2, Fluids.LAVA, 0);
                                }
                            } else
                                world.setBlockState(mutable2, config.getBlockProvider().getBlockState(random, mutable2), 2);
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

    private boolean canCaveCarveHere(BlockState state) {
        return state.getMaterial() == Material.EARTH || state.getMaterial() == Material.PLANTS || state.getMaterial() == Material.TALL_PLANTS ||
                state.getMaterial() == Material.SAND || state.getMaterial() == Material.BAMBOO || state.getMaterial() == Material.CACTUS
                || state.getMaterial() == Material.WATER || state.getMaterial() == Material.LAVA || state.isIn(Tags.Blocks.DIRT) || state.isIn(Tags.Blocks.END_STONES)
                || state.getBlock() == BYGBlocks.CRYPTIC_STONE || state.getBlock() == BYGBlocks.CRYPTIC_MAGMA_BLOCK || state.getMaterial() == Material.ROCK;
    }
}