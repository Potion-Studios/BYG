package voronoiaoc.byg.common.properties.blocks.warped;

import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;

public class BYGWarpedCactusBlock extends CactusBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_15;

    protected BYGWarpedCactusBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
        BlockPos blockPos = pos.above();
        if (world.isEmptyBlock(blockPos)) {
            int i;
            for (i = 1; world.getBlockState(pos.below(i)).is(this); ++i) {
            }

            if (i < 3) {
                int j = state.getValue(AGE);
                if (j == 15) {
                    world.setBlockAndUpdate(blockPos, this.defaultBlockState());
                    BlockState blockState = state.setValue(AGE, 0);
                    world.setBlock(pos, blockState, 4);
                    blockState.neighborChanged(world, blockPos, this, pos, false);
                } else {
                    world.setBlock(pos, state.setValue(AGE, j + 1), 4);
                }

            }
        }
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState newState, LevelAccessor world, BlockPos pos, BlockPos posFrom) {
        if (!state.canSurvive(world, pos)) {
            world.getBlockTicks().scheduleTick(pos, this, 1);
        }

        return super.updateShape(state, direction, newState, world, pos, posFrom);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockState blockstate = worldIn.getBlockState(pos.relative(direction));
            Material material = blockstate.getMaterial();
            if (material.isSolid() || worldIn.getFluidState(pos.relative(direction)).is(FluidTags.LAVA)) {
                return false;
            }
        }
        return worldIn.getBlockState(pos.below()).getBlock() == BYGBlockList.NYLIUM_SOUL_SAND || worldIn.getBlockState(pos.below()).getBlock() == BYGBlockList.NYLIUM_SOUL_SOIL || worldIn.getBlockState(pos.below()).getBlock() == BYGBlockList.WARPED_CACTUS && !worldIn.getBlockState(pos.above()).getMaterial().isLiquid() && worldIn.dimensionType().ultraWarm();
    }

    public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entityIn) {
        entityIn.hurt(DamageSource.CACTUS, 1.0F);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }


    protected boolean canPlantOnTop(BlockState state, BlockGetter worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block == BYGBlockList.NYLIUM_SOUL_SAND || block == BYGBlockList.WARPED_CACTUS;
    }
}


