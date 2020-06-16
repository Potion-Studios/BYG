package voronoiaoc.byg.common.properties.blocks.plants;//package voronoiaoc.byg.common.properties.blocks;
//
//import com.google.common.jimfs.PathType;
//import net.minecraft.block.AbstractBlock;
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.BYGBlockRenders;
//import net.minecraft.entity.ai.pathing.NavigationType;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.Direction;
//import net.minecraft.world.BlockView;
//import net.minecraft.world.WorldAccess;
//import net.minecraft.world.WorldView;
//
//public class BYGSnowBushBlock extends Block  {
//    protected BYGSnowBushBlock(AbstractBlock.Settings properties) {
//        super(properties);
//    }
//
//    @Override
//    protected boolean canPlantOnTop(BlockState state, BlockView worldIn, BlockPos pos) {
//        Block block = state.getBlock();
//        return block == Blocks.SNOW_BLOCK;
//    }
//
//
//
//    /**
//     * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
//     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
//     * returns its solidified counterpart.
//     * Note that this method should ideally consider only the specific face passed in.
//     */
//    public BlockState updatePostDecorator(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
//        return !stateIn.canPlaceAt(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostDecorator(stateIn, facing, facingState, worldIn, currentPos, facingPos);
//    }
//
//    @Override
//    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
//        BlockPos blockpos = pos.down();
//        if (state.getBlock() == this)
//            return worldIn.getBlockState(blockpos).ca(worldIn, blockpos, Direction.UP, this);
//        return this.canPlantOnTop(worldIn.getBlockState(blockpos), worldIn, blockpos);
//    }
//
//    @Override
//    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
//        return type == NavigationType.AIR && !this.blocksMovement || super.canPathfindThrough(state, world, pos, type);
//    }
//
//    @Override
//    public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos) {
//        return true;
//    }
//
//    @Override
//    public BlockState getPlant(BlockView world, BlockPos pos) {
//        BlockState state = world.getBlockState(pos);
//        if (state.getBlock() != this) return getDefaultState();
//        return state;
//    }
//
//
//}
