package voronoiaoc.byg.common.properties.blocks.sythian;

import net.minecraft.block.BambooBlock;
import net.minecraft.block.BambooSaplingBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.BambooLeaves;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import voronoiaoc.byg.core.byglists.BYGBlockList;
import voronoiaoc.byg.core.byglists.BYGItemList;

import java.util.Random;

public class SythianSaplingBlock extends BambooSaplingBlock {
    public SythianSaplingBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.down()).getBlock() == BYGBlockList.SYTHIAN_NYLIUM;
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.isValidPosition(worldIn, currentPos)) {
            return Blocks.AIR.getDefaultState();
        } else {
            if (facing == Direction.UP && facingState.getBlock() == BYGBlockList.SYTHIAN_STALK_BLOCK) {
                worldIn.setBlockState(currentPos, BYGBlockList.SYTHIAN_STALK_BLOCK.getDefaultState(), 2);
            }

            return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (rand.nextInt(3) == 0 && worldIn.isAirBlock(pos.up()) && worldIn.getLightSubtracted(pos.up(), 0) <= 12) {
            this.func_220087_a(worldIn, pos);
        }

    }

    @Override
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(BYGItemList.SYTHIAN_STALK);
    }

    @Override
    protected void func_220087_a(World world, BlockPos pos) {
        world.setBlockState(pos.up(), BYGBlockList.SYTHIAN_STALK_BLOCK.getDefaultState().with(BambooBlock.PROPERTY_BAMBOO_LEAVES, BambooLeaves.SMALL), 3);
    }
}
