package voronoiaoc.byg.common.properties.blocks;

import net.minecraft.block.BambooBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.properties.BambooLeaves;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import javax.annotation.Nullable;
import java.util.Random;

public class SythianStalkBlock extends BambooBlock {

    public SythianStalkBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(PROPERTY_AGE, Integer.valueOf(0)).with(PROPERTY_BAMBOO_LEAVES, BambooLeaves.NONE).with(PROPERTY_STAGE, Integer.valueOf(0)));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getPos());
        if (!fluidState.isEmpty()) {
            return null;
        } else {
            BlockState blockStateDOWN = ctx.getWorld().getBlockState(ctx.getPos().down());
            if (blockStateDOWN.getBlock() == BYGBlockList.SYTHIAN_NYLIUM) {
                Block blockDOWN = blockStateDOWN.getBlock();
                if (blockDOWN == BYGBlockList.SYTHIAN_SAPLING) {
                    return this.getDefaultState().with(PROPERTY_AGE, 0);
                } else if (blockDOWN == this) {
                    int getPropertyAge = blockStateDOWN.get(PROPERTY_AGE) > 0 ? 1 : 0;
                    return this.getDefaultState().with(PROPERTY_AGE, getPropertyAge);
                } else {
                    return BYGBlockList.SYTHIAN_SAPLING.getDefaultState();
                }
            } else {
                return null;
            }
        }
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (!state.isValidPosition(worldIn, pos)) {
            worldIn.destroyBlock(pos, true);
        } else if (state.get(PROPERTY_STAGE) == 0) {
            if (true) {
                int i = this.getNumBambooBlocksBelow(worldIn, pos) + 1;
                if (i < 16 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(3) == 0 && worldIn.isAirBlock(pos.up()) && worldIn.getLightSubtracted(pos.up(), 0) <= 12)) {
                    this.grow(state, worldIn, pos, rand, i);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
                }
            }

        }
    }

    @Override
    public BlockState updatePostPlacement(BlockState state, Direction direction, BlockState state2, IWorld world, BlockPos pos, BlockPos posFrom) {
        if (!state.isValidPosition(world, pos)) {
            world.getPendingBlockTicks().scheduleTick(pos, this, 1);
        }

        if (direction == Direction.UP && state2.getBlock() == this && state2.get(PROPERTY_AGE) > state.get(PROPERTY_AGE)) {
            world.setBlockState(pos, state.func_235896_a_(PROPERTY_AGE), 2);
        }

        return super.updatePostPlacement(state, direction, state2, world, pos, posFrom);
    }

    @Override
    protected void grow(BlockState state, World world, BlockPos pos, Random rand, int i) {
        BlockState stateDOWN = world.getBlockState(pos.down());
        BlockPos posDOWN2 = pos.down(2);
        BlockState blockStateDOWN2 = world.getBlockState(posDOWN2);
        BambooLeaves bambooLeavesNONE = BambooLeaves.NONE;
        if (i >= 1) {
            if (stateDOWN.getBlock() == this && stateDOWN.get(PROPERTY_BAMBOO_LEAVES) != BambooLeaves.NONE) {
                if (stateDOWN.getBlock() == this && stateDOWN.get(PROPERTY_BAMBOO_LEAVES) != BambooLeaves.NONE) {
                    bambooLeavesNONE = BambooLeaves.LARGE;
                    if (blockStateDOWN2.getBlock() == this) {
                        world.setBlockState(pos.down(), stateDOWN.with(PROPERTY_BAMBOO_LEAVES, BambooLeaves.SMALL), 3);
                        world.setBlockState(posDOWN2, blockStateDOWN2.with(PROPERTY_BAMBOO_LEAVES, BambooLeaves.NONE), 3);
                    }
                }
            } else {
                bambooLeavesNONE = BambooLeaves.SMALL;
            }
        }

        int j = state.get(PROPERTY_AGE) != 1 && blockStateDOWN2.getBlock() != this ? 0 : 1;
        int k = (i < 11 || rand.nextFloat() >= 0.25F) && i != 15 ? 0 : 1;
        world.setBlockState(pos.up(), this.getDefaultState().with(PROPERTY_AGE, j).with(PROPERTY_BAMBOO_LEAVES, bambooLeavesNONE).with(PROPERTY_STAGE, k), 3);
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.down()).getBlock() == BYGBlockList.SYTHIAN_NYLIUM || worldIn.getBlockState(pos.down()).getBlock() == BYGBlockList.SYTHIAN_STALK_BLOCK;
    }

}
