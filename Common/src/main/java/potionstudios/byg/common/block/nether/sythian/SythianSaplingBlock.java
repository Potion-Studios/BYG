package potionstudios.byg.common.block.nether.sythian;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BambooSaplingBlock;
import net.minecraft.world.level.block.BambooStalkBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BambooLeaves;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.item.BYGItems;

public class SythianSaplingBlock extends BambooSaplingBlock {
    public SythianSaplingBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.below()).getBlock() == BYGBlocks.SYTHIAN_NYLIUM.get();
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.canSurvive(worldIn, currentPos)) {
            return Blocks.AIR.defaultBlockState();
        } else {
            if (facing == Direction.UP && facingState.getBlock() == BYGBlocks.SYTHIAN_STALK_BLOCK.get()) {
                worldIn.setBlock(currentPos, BYGBlocks.SYTHIAN_STALK_BLOCK.defaultBlockState(), 2);
            }

            return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
        if (rand.nextInt(3) == 0 && worldIn.isEmptyBlock(pos.above()) && worldIn.getRawBrightness(pos.above(), 0) <= 12) {
            this.growBamboo(worldIn, pos);
        }

    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(BYGItems.SYTHIAN_STALK_BLOCK.get());
    }

    protected void growBamboo(Level world, BlockPos pos) {
        world.setBlock(pos.above(), BYGBlocks.SYTHIAN_STALK_BLOCK.defaultBlockState().setValue(BambooStalkBlock.LEAVES, BambooLeaves.SMALL), 3);
    }
}
