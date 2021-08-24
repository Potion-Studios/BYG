package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.util.MLBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BYGLeafPileBlock extends BushBlock {
    protected static final VoxelShape LEAF_PILE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 1.5D, 15.0D);

    protected BYGLeafPileBlock(Properties builder) {
        super(builder);
    }

    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos blockPos, CollisionContext context) {
        return LEAF_PILE;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return state.is(MLBlockTags.DIRT) || state.is(MLBlockTags.END_STONES) || state.is(BlockTags.NYLIUM) || state.is(MLBlockTags.NETHERRACK) || super.mayPlaceOn(state, worldIn, pos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return this.mayPlaceOn(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }
}
