package corgiaoc.byg.common.properties.blocks.nether.sythian;

import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.BYGItems;
import net.minecraft.block.BambooBlock;
import net.minecraft.block.BambooSaplingBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.BambooLeaves;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import java.util.Random;

public class SythianSaplingBlock extends BambooSaplingBlock {
    public SythianSaplingBlock(Settings properties) {
        super(properties);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.down()).getBlock() == BYGBlocks.SYTHIAN_NYLIUM;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.canPlaceAt(worldIn, currentPos)) {
            return Blocks.AIR.getDefaultState();
        } else {
            if (facing == Direction.UP && facingState.getBlock() == BYGBlocks.SYTHIAN_STALK_BLOCK) {
                worldIn.setBlockState(currentPos, BYGBlocks.SYTHIAN_STALK_BLOCK.getDefaultState(), 2);
            }

            return super.getStateForNeighborUpdate(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (rand.nextInt(3) == 0 && worldIn.isAir(pos.up()) && worldIn.getBaseLightLevel(pos.up(), 0) <= 12) {
            this.func_220087_a(worldIn, pos);
        }

    }

    @Override
    public ItemStack getPickStack(BlockView worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(BYGItems.SYTHIAN_STALK_BLOCK);
    }

    protected void func_220087_a(World world, BlockPos pos) {
        world.setBlockState(pos.up(), BYGBlocks.SYTHIAN_STALK_BLOCK.getDefaultState().with(BambooBlock.LEAVES, BambooLeaves.SMALL), 3);
    }
}
