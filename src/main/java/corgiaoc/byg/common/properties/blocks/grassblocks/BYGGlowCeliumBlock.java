package corgiaoc.byg.common.properties.blocks.grassblocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SpreadingSnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.AbstractFlowerFeature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.List;
import java.util.Random;

public class BYGGlowCeliumBlock extends SpreadingSnowyDirtBlock implements BonemealableBlock {
    public BYGGlowCeliumBlock(Properties properties) {
        super(properties);
    }

    public boolean isValidBonemealTarget(BlockGetter worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return worldIn.getBlockState(pos.above()).isAir();
    }

    public boolean isBonemealSuccess(Level worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    @Environment(EnvType.CLIENT)
    public void animateTick(BlockState blockState, Level world, BlockPos blockPos, Random rand) {
        super.animateTick(blockState, world, blockPos, rand);
        if (rand.nextInt(10) == 0) {
            world.addParticle(ParticleTypes.MYCELIUM, (double) blockPos.getX() + (double) rand.nextFloat(), (double) blockPos.getY() + 1.1D, (double) blockPos.getZ() + (double) rand.nextFloat(), 0.0D, 0.0D, 0.0D);
        }

    }

    public void performBonemeal(ServerLevel world, Random rand, BlockPos blockPos, BlockState state) {
        BlockPos blockpos = blockPos.above();
        BlockState blockstate = Blocks.GRASS.defaultBlockState();

        for (int i = 0; i < 128; ++i) {
            BlockPos blockpos1 = blockpos;
            int j = 0;

            while (true) {
                if (j >= i / 16) {
                    BlockState blockstate2 = world.getBlockState(blockpos1);
                    if (blockstate2.getBlock() == blockstate.getBlock() && rand.nextInt(10) == 0) {
                        ((BonemealableBlock) blockstate.getBlock()).performBonemeal(world, rand, blockpos1, blockstate2);
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
                        AbstractFlowerFeature flowersfeature = (AbstractFlowerFeature) configuredfeature.feature;
                        blockstate1 = flowersfeature.getRandomFlower(rand, blockpos1, configuredfeature.config());
                    } else {
                        blockstate1 = blockstate;
                    }

                    if (blockstate1.canSurvive(world, blockpos1)) {
                        world.setBlock(blockpos1, blockstate1, 3);
                    }
                    break;
                }

                blockpos1 = blockpos1.offset(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);
                if (world.getBlockState(blockpos1.below()).getBlock() != this || world.getBlockState(blockpos1).isSolidRender(world, blockpos1)) {
                    break;
                }

                ++j;
            }
        }

    }
}