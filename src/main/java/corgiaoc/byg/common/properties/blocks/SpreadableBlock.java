package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.common.world.feature.end.EndVegetationFeature;
import corgiaoc.byg.common.world.feature.overworld.OverworldVegetationFeature;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.*;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;
import net.minecraft.world.gen.feature.BlockStateProvidingFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FlowersFeature;
import net.minecraft.world.gen.feature.NetherVegetationFeature;
import net.minecraft.world.lighting.LightEngine;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.AbstractBlock.Properties;

public class SpreadableBlock extends SnowyDirtBlock implements IGrowable {

    private final Block blockToSpreadToo;
    private final BlockStateProvidingFeatureConfig featureConfig;
    private final ForDimension forDimension;



    private final boolean isNotOverworld;

    public SpreadableBlock(Properties properties, Block blockToSpreadToo, ForDimension type, BlockStateProvidingFeatureConfig featureConfig) {
        super(properties);
        this.blockToSpreadToo = blockToSpreadToo;
        this.featureConfig = featureConfig;
        this.forDimension = type;

        isNotOverworld = forDimension != ForDimension.OVERWORLD;

    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (isNotOverworld) {
            if (!areConditionsGood(state, worldIn, pos))
                worldIn.setBlockAndUpdate(pos, blockToSpreadToo.defaultBlockState());
        } else {
            if (!areConditionsGood(state, worldIn, pos)) {
                if (!worldIn.isAreaLoaded(pos, 3))
                    return;
                worldIn.setBlockAndUpdate(pos, blockToSpreadToo.defaultBlockState());
            } else {
                if (worldIn.getMaxLocalRawBrightness(pos.above()) >= 9) {
                    BlockState blockstate = this.defaultBlockState();

                    for (int i = 0; i < 4; ++i) {
                        BlockPos blockpos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                        if (worldIn.getBlockState(blockpos).is(blockToSpreadToo) && areConditionsGoodAndNotUnderWater(blockstate, worldIn, blockpos)) {
                            worldIn.setBlockAndUpdate(blockpos, blockstate.setValue(SNOWY, worldIn.getBlockState(blockpos.above()).is(Blocks.SNOW)));
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean isValidBonemealTarget(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return worldIn.getBlockState(pos.above()).isAir();
    }

    @Override
    public boolean isBonemealSuccess(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerWorld world, Random rand, BlockPos blockPos, BlockState state) {
        BlockPos blockpos = blockPos.above();
        BlockState thisBlockState = (rand.nextInt(2) == 0) ? Blocks.GRASS.defaultBlockState() : BYGBlocks.SHORT_GRASS.defaultBlockState();


        for (int i = 0; i < world.getMaxBuildHeight(); ++i) {
            BlockPos blockpos1 = blockpos;
            int j = 0;

            while (true) {
                if (j >= i / 16) {
                    BlockState blockstate2 = world.getBlockState(blockpos1);
                    if (isNotOverworld) {
                        if (blockstate2 == thisBlockState && rand.nextInt(10) == 0) {
                            ((IGrowable) thisBlockState.getBlock()).performBonemeal(world, rand, blockpos1, blockstate2);
                        }
                    }

                    if (!blockstate2.isAir()) {
                        break;
                    }

                    if (forDimension == ForDimension.NETHER) {
                        NetherVegetationFeature.place(world, rand, blockpos1, this.featureConfig, 3, 1);
                        break;
                    }

                    if (forDimension == ForDimension.END) {
                        EndVegetationFeature.placeBonemeal(world, rand, blockpos1, this.featureConfig, 3, 1);
                        break;
                    }

                    if (forDimension == ForDimension.OVERWORLD && this.featureConfig != null) {
                        OverworldVegetationFeature.placeBonemeal(world, rand, blockpos1, this.featureConfig, 3, 1, this);
                        break;
                    }

                    BlockState flowerState;
                    if (rand.nextInt(8) == 0) {
                        List<ConfiguredFeature<?, ?>> flowerListForBiome = world.getBiome(blockpos1).getGenerationSettings().getFlowerFeatures();
                        if (flowerListForBiome.isEmpty()) {
                            continue;
                        }

                        ConfiguredFeature<?, ?> configuredfeature = flowerListForBiome.get(0);
                        FlowersFeature flowersfeature = (FlowersFeature) configuredfeature.feature;
                        flowerState = flowersfeature.getRandomFlower(rand, blockpos1, configuredfeature.config());
                    } else {
                        flowerState = thisBlockState;
                    }

                    if (flowerState.canSurvive(world, blockpos1)) {
                        world.setBlock(blockpos1, flowerState, 3);
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

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        if (!isNotOverworld)
            super.createBlockStateDefinition(builder);
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!isNotOverworld)
            return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        else
            return this.defaultBlockState();
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        if (!isNotOverworld)
            return super.getStateForPlacement(context);
        else
            return this.defaultBlockState();
    }


    private boolean areConditionsGood(BlockState state, IWorldReader worldReader, BlockPos pos) {
        BlockPos blockpos = pos.above();
        BlockState blockstate = worldReader.getBlockState(blockpos);
        if (!isNotOverworld) {
            if (blockstate.is(Blocks.SNOW) && blockstate.getValue(SnowBlock.LAYERS) == 1) {
                return true;
            } else if (blockstate.getFluidState().getAmount() == 8) {
                return false;
            }
        }

        int i = LightEngine.getLightBlockInto(worldReader, state, pos, blockstate, blockpos, Direction.UP, blockstate.getLightBlock(worldReader, blockpos));
        return i < worldReader.getMaxLightLevel();
    }

    private boolean areConditionsGoodAndNotUnderWater(BlockState state, IWorldReader worldReader, BlockPos pos) {
        BlockPos blockpos = pos.above();
        return areConditionsGood(state, worldReader, pos) && !worldReader.getFluidState(blockpos).is(FluidTags.WATER);
    }

    public static void addGrassBlocksForConsumption() {



    }


    public enum ForDimension {
        OVERWORLD(DimensionType.DEFAULT_OVERWORLD),
        NETHER(DimensionType.DEFAULT_NETHER),
        END(DimensionType.DEFAULT_END);

        final DimensionType dimensionType;

        ForDimension(DimensionType dimensionType) {
            this.dimensionType = dimensionType;
        }

        public DimensionType getDimType() {
            return this.dimensionType;
        }
    }
}
