package voronoiaoc.byg.common.properties.sythian;

import javax.annotation.Nullable;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BambooBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.BambooLeaves;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class SythianStalkBlock extends BambooBlock {

    public SythianStalkBlock(AbstractBlock.Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, 0).with(LEAVES, BambooLeaves.NONE).with(STAGE, 0));
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        if (!fluidState.isEmpty()) {
            return null;
        } else {
            BlockState blockStateDOWN = ctx.getWorld().getBlockState(ctx.getBlockPos().down());
            if (blockStateDOWN.getBlock() == BYGBlockList.SYTHIAN_NYLIUM) {
                Block blockDOWN = blockStateDOWN.getBlock();
                if (blockDOWN == BYGBlockList.SYTHIAN_SAPLING) {
                    return this.getDefaultState().with(AGE, 0);
                } else if (blockDOWN == this) {
                    int getPropertyAge = blockStateDOWN.get(AGE) > 0 ? 1 : 0;
                    return this.getDefaultState().with(AGE, getPropertyAge);
                } else {
                    return BYGBlockList.SYTHIAN_SAPLING.getDefaultState();
                }
            } else {
                BYG.LOGGER.info("NULL");
                return null;
            }
        }
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(STAGE) == 0) {
            if (random.nextInt(3) == 0 && world.isAir(pos.up()) && world.getBaseLightLevel(pos.up(), 0) <= 12) {
                int i = this.countBambooBelow(world, pos) + 1;
                if (i < 16) {
                    this.updateLeaves(state, world, pos, random, i);
                }
            }

        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        if (!state.canPlaceAt(world, pos)) {
            world.getBlockTickScheduler().schedule(pos, this, 1);
        }

        if (direction == Direction.UP && newState.getBlock() == this && newState.get(AGE) > state.get(AGE)) {
            world.setBlockState(pos, state.cycle(AGE), 2);
        }

        return super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }

    @Override
    protected void updateLeaves(BlockState state, World world, BlockPos pos, Random random, int height) {
        BlockState stateDOWN = world.getBlockState(pos.down());
        BlockPos posDOWN2 = pos.down(2);
        BlockState blockStateDOWN2 = world.getBlockState(posDOWN2);
        BambooLeaves bambooLeavesNONE = BambooLeaves.NONE;
        if (height >= 1) {
            if (stateDOWN.getBlock() == this && stateDOWN.get(LEAVES) != BambooLeaves.NONE) {
                if (stateDOWN.getBlock() == this && stateDOWN.get(LEAVES) != BambooLeaves.NONE) {
                    bambooLeavesNONE = BambooLeaves.LARGE;
                    if (blockStateDOWN2.getBlock() == this) {
                        world.setBlockState(pos.down(), stateDOWN.with(LEAVES, BambooLeaves.SMALL), 3);
                        world.setBlockState(posDOWN2, blockStateDOWN2.with(LEAVES, BambooLeaves.NONE), 3);
                    }
                }
            }

            else {
                bambooLeavesNONE = BambooLeaves.SMALL;
            }
        }

        int j = state.get(AGE) != 1 && blockStateDOWN2.getBlock() != this ? 0 : 1;
        int k = (height < 11 || random.nextFloat() >= 0.25F) && height != 15 ? 0 : 1;
        world.setBlockState(pos.up(), this.getDefaultState().with(AGE, j).with(LEAVES, bambooLeavesNONE).with(STAGE, k), 3);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.down()).getBlock() == BYGBlockList.SYTHIAN_NYLIUM || worldIn.getBlockState(pos.down()).getBlock() == BYGBlockList.SYTHIAN_STALK_BLOCK;
    }

}
