package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.common.world.feature.FeatureUtil;
import corgiaoc.byg.common.world.feature.end.EndVegetationFeature;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.feature.BlockPileFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FlowerFeature;
import net.minecraft.world.gen.feature.NetherForestVegetationFeature;

import java.util.List;
import java.util.Random;

public class SpreadableBlock extends SnowyBlock implements Fertilizable {

    private final Block blockToSpreadToo;
    private final BlockPileFeatureConfig featureConfig;
    private final ForDimension forDimension;


    private final boolean isNotOverworld;

    public SpreadableBlock(Settings properties, Block blockToSpreadToo, ForDimension type, BlockPileFeatureConfig featureConfig) {
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
                worldIn.setBlockState(pos, blockToSpreadToo.getDefaultState());
        } else {
            if (!areConditionsGood(state, worldIn, pos)) {
                if (!FeatureUtil.isAreaLoaded(worldIn, pos, 3))
                    return;
                worldIn.setBlockState(pos, blockToSpreadToo.getDefaultState());
            } else {
                if (worldIn.getLightLevel(pos.up()) >= 9) {
                    BlockState blockstate = this.getDefaultState();

                    for (int i = 0; i < 4; ++i) {
                        BlockPos blockpos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                        if (worldIn.getBlockState(blockpos).isOf(blockToSpreadToo) && areConditionsGoodAndNotUnderWater(blockstate, worldIn, blockpos)) {
                            worldIn.setBlockState(blockpos, blockstate.with(SNOWY, worldIn.getBlockState(blockpos.up()).isOf(Blocks.SNOW)));
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean isFertilizable(BlockView worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return worldIn.getBlockState(pos.up()).isAir();
    }

    @Override
    public boolean canGrow(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random rand, BlockPos blockPos, BlockState state) {
        BlockPos blockpos = blockPos.up();
        BlockState thisBlockState = (rand.nextInt(2) == 0) ? Blocks.GRASS.getDefaultState() : BYGBlocks.SHORT_GRASS.getDefaultState();


        for (int i = 0; i < world.getTopHeightLimit(); ++i) {
            BlockPos blockpos1 = blockpos;
            int j = 0;

            while (true) {
                if (j >= i / 16) {
                    BlockState blockstate2 = world.getBlockState(blockpos1);
                    if (isNotOverworld) {
                        if (blockstate2 == thisBlockState && rand.nextInt(10) == 0) {
                            ((Fertilizable) thisBlockState.getBlock()).grow(world, rand, blockpos1, blockstate2);
                        }
                    }

                    if (!blockstate2.isAir()) {
                        break;
                    }

                    if (forDimension == ForDimension.NETHER) {
                        NetherForestVegetationFeature.generate(world, rand, blockpos1, this.featureConfig, 3, 1);
                        break;
                    }

                    if (forDimension == ForDimension.END) {
                        EndVegetationFeature.placeBonemeal(world, rand, blockpos1, this.featureConfig, 3, 1);
                        break;
                    }

                    BlockState flowerState;
                    if (rand.nextInt(8) == 0) {
                        List<ConfiguredFeature<?, ?>> flowerListForBiome = world.getBiome(blockpos1).getGenerationSettings().getFlowerFeatures();
                        if (flowerListForBiome.isEmpty()) {
                            continue;
                        }

                        ConfiguredFeature<?, ?> configuredfeature = flowerListForBiome.get(0);
                        FlowerFeature flowersfeature = (FlowerFeature) configuredfeature.feature;
                        flowerState = flowersfeature.getFlowerState(rand, blockpos1, configuredfeature.getConfig());
                    } else {
                        flowerState = thisBlockState;
                    }

                    if (flowerState.canPlaceAt(world, blockpos1)) {
                        world.setBlockState(blockpos1, flowerState, 3);
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

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        if (!isNotOverworld)
            super.appendProperties(builder);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!isNotOverworld)
            return super.getStateForNeighborUpdate(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        else
            return this.getDefaultState();
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        if (!isNotOverworld)
            return super.getPlacementState(context);
        else
            return this.getDefaultState();
    }


    private boolean areConditionsGood(BlockState state, WorldView worldReader, BlockPos pos) {
        BlockPos blockpos = pos.up();
        BlockState blockstate = worldReader.getBlockState(blockpos);
        if (!isNotOverworld) {
            if (blockstate.isOf(Blocks.SNOW) && blockstate.get(SnowBlock.LAYERS) == 1) {
                return true;
            } else if (blockstate.getFluidState().getLevel() == 8) {
                return false;
            }
        }

        int i = ChunkLightProvider.getRealisticOpacity(worldReader, state, pos, blockstate, blockpos, Direction.UP, blockstate.getOpacity(worldReader, blockpos));
        return i < worldReader.getMaxLightLevel();
    }

    private boolean areConditionsGoodAndNotUnderWater(BlockState state, WorldView worldReader, BlockPos pos) {
        BlockPos blockpos = pos.up();
        return areConditionsGood(state, worldReader, pos) && !worldReader.getFluidState(blockpos).isIn(FluidTags.WATER);
    }

    public static void addGrassBlocksForConsumption() {


    }


    public enum ForDimension {
        OVERWORLD(DimensionType.OVERWORLD),
        NETHER(DimensionType.THE_NETHER),
        END(DimensionType.THE_END);

        final DimensionType dimensionType;

        ForDimension(DimensionType dimensionType) {
            this.dimensionType = dimensionType;
        }

        public DimensionType getDimType() {
            return this.dimensionType;
        }
    }
}
