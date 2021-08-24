package corgiaoc.byg.common.world.feature.overworld;

import com.mojang.serialization.Codec;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.feature.config.BoulderConfig;
import corgiaoc.byg.util.MLBlockTags;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class StackableBoulders extends Feature<BoulderConfig> {

    public StackableBoulders(Codec<BoulderConfig> configCodec) {
        super(configCodec);
    }

    protected long seed;
    protected static FastNoise fastNoise;

    public static int stopSpamInt = 0;

    @Override
    public boolean place(ISeedReader world, ChunkGenerator chunkGenerator, Random random, BlockPos position, BoulderConfig config) {
        setSeed(world.getSeed());

        BlockPos.Mutable mutable = new BlockPos.Mutable().set(position.below(2 + random.nextInt(10)));
        BlockPos.Mutable mutable2 = new BlockPos.Mutable().set(mutable);
        int stackHeight = random.nextInt(config.getMaxPossibleHeight()) + config.getMinHeight();
        int radius = random.nextInt(config.getMaxPossibleRadius()) + config.getMinRadius();

        BlockState blockStateDown = world.getBlockState(position.below());
        BlockState blockStateAtPosition = world.getBlockState(position);


        if (blockStateDown.is(BlockTags.LEAVES) || blockStateDown.is(BlockTags.LOGS) || blockStateAtPosition.is(BlockTags.LEAVES) || blockStateAtPosition.is(BlockTags.LOGS) || blockStateAtPosition.getMaterial() == Material.AIR)
            return false;

        for (int boulderIDX = 0; boulderIDX < stackHeight; boulderIDX++) {
            //Randomize the movement.
            int moveOnX = random.nextInt(4);

            if (random.nextInt(2) == 0)
                moveOnX = -moveOnX;

            int moveOnZ = random.nextInt(4);

            if (random.nextInt(2) == 1)
                moveOnZ = -moveOnZ;

            mutable.move(moveOnX, (int) (random.nextInt(Math.abs(radius) + 1) * 0.2f + radius * 0.8f) - 3 + -random.nextInt(5), moveOnZ);


            int yPositiveRadius = (config.isTopBoulderFlat() && boulderIDX + 1 == stackHeight) ? 0 : radius;

            for (int x = -radius; x <= radius; x++) {
                for (int y = -radius; y <= yPositiveRadius; y++) {
                    for (int z = -radius; z <= radius; z++) {

                        int squaredDistance = x * x + y * y + z * z;
                        if (squaredDistance <= radius * radius) {

                            mutable2.set(mutable).move(x, y, z);

                            // Rough the surface of the boulders a bit
                            double boulderRoughnessNoise = fastNoise.GetNoise(mutable2.getX() * 0.04F, mutable2.getY() * 0.01F, mutable2.getZ() * 0.04F);

                            if (squaredDistance > radius * radius * 0.8f && boulderRoughnessNoise > -0.3D && boulderRoughnessNoise < 0.3D)
                                continue;


                            BlockState blockState = world.getBlockState(mutable2);
                            if (this.canBlockPlaceHere(blockState))
                                world.setBlock(mutable2, config.getBlockProvider().getState(random, mutable2), 3);
                        }
                    }
                }
            }

            while (mutable.getY() < world.getMaxBuildHeight() && !world.getBlockState(mutable).isAir()) {
                mutable.move(Direction.UP);
            }

//            if (random.nextInt(9) == 0)
//                radius = (int) (radius * 1.75);
//            else
            radius = (int) (radius / config.getRadiusDivisorPerStack());

            if (3 > radius) {
                if (stopSpamInt == 0) {
                    BYG.LOGGER.debug("BYG: Boulder Radius is too small to continue stacking! Stack stopping at stack height: " + boulderIDX + "\nPlease lower the stack height or increase the boulder radius.");
                    stopSpamInt++;
                }
                break;
            }
        }
        return true;
    }


    public void setSeed(long seed) {
        if (this.seed != seed || fastNoise == null) {
            fastNoise = new FastNoise((int) seed);
            fastNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
            this.seed = seed;
        }
    }

    private boolean canBlockPlaceHere(BlockState state) {
        return state.isAir() || state.getMaterial() == Material.DIRT || state.getMaterial() == Material.PLANT ||
                state.getMaterial() == Material.REPLACEABLE_PLANT || state.getMaterial() == Material.LEAVES ||
                state.getMaterial() == Material.SAND || state.getMaterial() == Material.BAMBOO || state.getMaterial() == Material.CACTUS
                || state.getMaterial() == Material.WATER || state.getMaterial() == Material.LAVA || state.is(MLBlockTags.DIRT);
    }
}