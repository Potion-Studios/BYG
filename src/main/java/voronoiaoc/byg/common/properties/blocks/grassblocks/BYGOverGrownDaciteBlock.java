package voronoiaoc.byg.common.properties.blocks.grassblocks;


import voronoiaoc.byg.common.properties.blocks.spreadablesnowyblocks.SpreadableSnowyOvergrownDaciteBlock;

import java.util.List;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.AbstractFlowerFeature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.DecoratedFeatureConfiguration;

public class BYGOverGrownDaciteBlock extends SpreadableSnowyOvergrownDaciteBlock implements BonemealableBlock {
    public BYGOverGrownDaciteBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level world, Random random, BlockPos pos, BlockState state) {
        return world.getBlockState(pos.above()).isAir();
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
                            break;
                        }

                        ConfiguredFeature<?, ?> configuredFeature = ((DecoratedFeatureConfiguration) list.get(0).config).feature.get();
                        blockstate1 = ((AbstractFlowerFeature) configuredFeature.feature).getRandomFlower(rand, blockpos1, configuredFeature.config);
                    } else {
                        blockstate1 = blockstate;
                    }

                    if (blockstate1.canSurvive(world, blockpos1)) {
                        world.setBlock(blockpos1, blockstate1, 3);
                    }
                    break;
                }

                blockpos1 = blockpos1.offset(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);
                if (world.getBlockState(blockpos1.below()).getBlock() != this || world.getBlockState(blockpos1).isCollisionShapeFullBlock(world, blockpos1)) {
                    break;
                }

                ++j;
            }
        }

    }
}