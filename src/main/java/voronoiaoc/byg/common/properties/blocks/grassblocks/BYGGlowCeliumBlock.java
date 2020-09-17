package voronoiaoc.byg.common.properties.blocks.grassblocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SpreadableSnowyDirtBlock;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FlowersFeature;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;
import java.util.Random;

public class BYGGlowCeliumBlock extends SpreadableSnowyDirtBlock implements IGrowable {
    public BYGGlowCeliumBlock(Properties properties) {
        super(properties);
    }

    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return worldIn.getBlockState(pos.up()).isAir();
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState blockState, World world, BlockPos blockPos, Random rand) {
        super.animateTick(blockState, world, blockPos, rand);
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
                        ((IGrowable) blockstate.getBlock()).grow(world, rand, blockpos1, blockstate2);
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
                        FlowersFeature flowersfeature = (FlowersFeature)configuredfeature.feature;
                        blockstate1 = flowersfeature.getFlowerToPlace(rand, blockpos1, configuredfeature.func_242767_c());
                    } else {
                        blockstate1 = blockstate;
                    }

                    if (blockstate1.isValidPosition(world, blockpos1)) {
                        world.setBlockState(blockpos1, blockstate1, 3);
                    }
                    break;
                }

                blockpos1 = blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);
                if (world.getBlockState(blockpos1.down()).getBlock() != this || world.getBlockState(blockpos1).isOpaqueCube(world, blockpos1)) {
                    break;
                }

                ++j;
            }
        }

    }
}