package corgiaoc.byg.common.properties.blocks;

import net.minecraft.block.*;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.BlockStateProvidingFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FlowersFeature;
import net.minecraft.world.gen.feature.NetherVegetationFeature;
import net.minecraft.world.lighting.LightEngine;
import net.minecraft.world.server.ServerWorld;
import corgiaoc.byg.core.byglists.BYGBlockList;

import java.util.List;
import java.util.Random;

public class SpreadableBlock extends SnowyDirtBlock implements IGrowable {

    private final Block blockToSpreadToo;
    private final boolean isNetherSpreadable;
    private final BlockStateProvidingFeatureConfig netherFeatureConfig;

    public SpreadableBlock(Properties properties, Block blockToSpreadToo, BlockStateProvidingFeatureConfig netherFeatureConfig) {
        super(properties);
        this.blockToSpreadToo = blockToSpreadToo;
        this.isNetherSpreadable = true;
        this.netherFeatureConfig = netherFeatureConfig;
    }

    public SpreadableBlock(Properties properties, Block blockToSpreadToo) {
        super(properties);
        this.blockToSpreadToo = blockToSpreadToo;
        this.isNetherSpreadable = false;
        netherFeatureConfig = null;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (isNetherSpreadable) {
            if (!areConditionsGood(state, worldIn, pos))
                worldIn.setBlockState(pos, blockToSpreadToo.getDefaultState());
        }
        else {
            if (!areConditionsGood(state, worldIn, pos)) {
                if (!worldIn.isAreaLoaded(pos, 3))
                    return;
                worldIn.setBlockState(pos, blockToSpreadToo.getDefaultState());
            } else {
                if (worldIn.getLight(pos.up()) >= 9) {
                    BlockState blockstate = this.getDefaultState();

                    for (int i = 0; i < 4; ++i) {
                        BlockPos blockpos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                        if (worldIn.getBlockState(blockpos).isIn(blockToSpreadToo) && areConditionsGoodAndNotUnderWater(blockstate, worldIn, blockpos)) {
                            worldIn.setBlockState(blockpos, blockstate.with(SNOWY, worldIn.getBlockState(blockpos.up()).isIn(Blocks.SNOW)));
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return worldIn.getBlockState(pos.up()).isAir();
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random rand, BlockPos blockPos, BlockState state) {
        BlockPos blockpos = blockPos.up();
        BlockState thisBlockState = (rand.nextInt(2) == 0) ? Blocks.GRASS.getDefaultState() : BYGBlockList.SHORT_GRASS.getDefaultState();


        for (int i = 0; i < world.getHeight(); ++i) {
            BlockPos blockpos1 = blockpos;
            int j = 0;

            while (true) {
                if (j >= i / 16) {
                    BlockState blockstate2 = world.getBlockState(blockpos1);
                    if (!isNetherSpreadable) {
                        if (blockstate2 == thisBlockState && rand.nextInt(10) == 0) {
                            ((IGrowable) thisBlockState.getBlock()).grow(world, rand, blockpos1, blockstate2);
                        }
                    }

                    if (!blockstate2.isAir()) {
                        break;
                    }

                    if (isNetherSpreadable) {
                        NetherVegetationFeature.func_236325_a_(world, rand, blockpos1, this.netherFeatureConfig, 3, 1);
                        break;
                    }

                    BlockState flowerState;
                    if (rand.nextInt(8) == 0) {
                        List<ConfiguredFeature<?, ?>> flowerListForBiome = world.getBiome(blockpos1).getGenerationSettings().getFlowerFeatures();
                        if (flowerListForBiome.isEmpty()) {
                            continue;
                        }

                        ConfiguredFeature<?, ?> configuredfeature = flowerListForBiome.get(0);
                        FlowersFeature flowersfeature = (FlowersFeature)configuredfeature.feature;
                        flowerState = flowersfeature.getFlowerToPlace(rand, blockpos1, configuredfeature.func_242767_c());
                    } else {
                        flowerState = thisBlockState;
                    }

                    if (flowerState.isValidPosition(world, blockpos1)) {
                        world.setBlockState(blockpos1, flowerState, 3);
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

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        if (!isNetherSpreadable)
            super.fillStateContainer(builder);
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!isNetherSpreadable)
            return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        else
            return this.getDefaultState();
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        if (!isNetherSpreadable)
            return super.getStateForPlacement(context);
        else
            return this.getDefaultState();
    }



    private boolean areConditionsGood(BlockState state, IWorldReader worldReader, BlockPos pos) {
        BlockPos blockpos = pos.up();
        BlockState blockstate = worldReader.getBlockState(blockpos);
        if (!this.isNetherSpreadable) {
            if (blockstate.isIn(Blocks.SNOW) && blockstate.get(SnowBlock.LAYERS) == 1) {
                return true;
            } else if (blockstate.getFluidState().getLevel() == 8) {
                return false;
            }
        }

        int i = LightEngine.func_215613_a(worldReader, state, pos, blockstate, blockpos, Direction.UP, blockstate.getOpacity(worldReader, blockpos));
        return i < worldReader.getMaxLightLevel();
    }

    private boolean areConditionsGoodAndNotUnderWater(BlockState state, IWorldReader worldReader, BlockPos pos) {
        BlockPos blockpos = pos.up();
        return areConditionsGood(state, worldReader, pos) && !worldReader.getFluidState(blockpos).isTagged(FluidTags.WATER);
    }
}
