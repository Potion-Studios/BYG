package voronoiaoc.byg.common.properties.blocks.warped;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CactusBlock;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class BYGWarpedCactusBlock extends CactusBlock {
    public static final IntProperty AGE = Properties.AGE_15;

    protected BYGWarpedCactusBlock(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, 0));
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockPos blockPos = pos.up();
        if (world.isAir(blockPos)) {
            int i;
            for (i = 1; world.getBlockState(pos.down(i)).isOf(this); ++i) {
            }

            if (i < 3) {
                int j = state.get(AGE);
                if (j == 15) {
                    world.setBlockState(blockPos, this.getDefaultState());
                    BlockState blockState = state.with(AGE, 0);
                    world.setBlockState(pos, blockState, 4);
                    blockState.neighborUpdate(world, blockPos, this, pos, false);
                } else {
                    world.setBlockState(pos, state.with(AGE, j + 1), 4);
                }

            }
        }
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        if (!state.canPlaceAt(world, pos)) {
            world.getBlockTickScheduler().schedule(pos, this, 1);
        }

        return super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        for (Direction direction : Direction.Type.HORIZONTAL) {
            BlockState blockstate = worldIn.getBlockState(pos.offset(direction));
            Material material = blockstate.getMaterial();
            if (material.isSolid() || worldIn.getFluidState(pos.offset(direction)).isIn(FluidTags.LAVA)) {
                return false;
            }
        }
        return worldIn.getBlockState(pos.down()).getBlock() == BYGBlockList.NYLIUM_SOUL_SAND || worldIn.getBlockState(pos.down()).getBlock() == BYGBlockList.NYLIUM_SOUL_SOIL || worldIn.getBlockState(pos.down()).getBlock() == BYGBlockList.WARPED_CACTUS && !worldIn.getBlockState(pos.up()).getMaterial().isLiquid() && worldIn.getDimension().isUltrawarm();
    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.damage(DamageSource.CACTUS, 1.0F);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }


    protected boolean canPlantOnTop(BlockState state, BlockView worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block == BYGBlockList.NYLIUM_SOUL_SAND || block == BYGBlockList.WARPED_CACTUS;
    }
}


