package corgiaoc.byg.common.properties.blocks.grassblocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.SpreadableBlock;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FlowerFeature;

import java.util.List;
import java.util.Random;

public class BYGGlowCeliumBlock extends SpreadableBlock implements Fertilizable {
    public BYGGlowCeliumBlock(Settings properties) {
        super(properties);
    }

    public boolean isFertilizable(BlockView worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return worldIn.getBlockState(pos.up()).isAir();
    }

    public boolean canGrow(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState blockState, World world, BlockPos blockPos, Random rand) {
        super.randomDisplayTick(blockState, world, blockPos, rand);
        if (rand.nextInt(10) == 0) {
            world.addParticle(ParticleTypes.MYCELIUM, (double) blockPos.getX() + (double) rand.nextFloat(), (double) blockPos.getY() + 1.1D, (double) blockPos.getZ() + (double) rand.nextFloat(), 0.0D, 0.0D, 0.0D);
        }

    }

    public void grow(ServerWorld world, Random rand, BlockPos blockPos, BlockState state) {
        BlockPos blockpos = blockPos.up();
        BlockState blockstate = Blocks.GRASS.getDefaultState();

        for (int i = 0; i < 128; ++i) {
            BlockPos blockpos1 = blockpos;
            int j = 0;

            while (true) {
                if (j >= i / 16) {
                    BlockState blockstate2 = world.getBlockState(blockpos1);
                    if (blockstate2.getBlock() == blockstate.getBlock() && rand.nextInt(10) == 0) {
                        ((Fertilizable) blockstate.getBlock()).grow(world, rand, blockpos1, blockstate2);
                    }

                    if (!blockstate2.isAir()) {
                        break;
                    }

                    BlockState blockstate1;
                    if (rand.nextInt(8) == 0) {
                        List<ConfiguredFeature<?, ?>> list = world.getBiome(blockpos1).getGenerationSettings().getFlowerFeatures();
                        if (list.isEmpty()) {
                            continue;
                        }

                        ConfiguredFeature<?, ?> configuredfeature = list.get(0);
                        FlowerFeature flowersfeature = (FlowerFeature) configuredfeature.feature;
                        blockstate1 = flowersfeature.getFlowerState(rand, blockpos1, configuredfeature.getConfig());
                    } else {
                        blockstate1 = blockstate;
                    }

                    if (blockstate1.canPlaceAt(world, blockpos1)) {
                        world.setBlockState(blockpos1, blockstate1, 3);
                    }
                    break;
                }

                blockpos1 = blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);
                if (world.getBlockState(blockpos1.down()).getBlock() != this || world.getBlockState(blockpos1).isOpaqueFullCube(world, blockpos1)) {
                    break;
                }

                ++j;
            }
        }

    }
}