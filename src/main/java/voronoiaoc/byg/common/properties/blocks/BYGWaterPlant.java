package voronoiaoc.byg.common.properties.blocks;//package voronoiaoc.byg.common.properties.blocks;
//
//import net.minecraft.block.AbstractBlock;
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.BYGBlockRenders;
//import net.minecraft.fluid.Fluid;
//import net.minecraft.fluid.Fluids;
//import net.minecraft.fluid.IFluidState;
//import net.minecraft.item.ItemStack;
//import net.minecraft.state.EnumProperty;
//import net.minecraft.state.properties.DoubleBlockHalf;
//import net.minecraft.util.math.BlockPos;
////
//public class BYGWaterPlant extends ShearableTallPlantBlock implements ILiquidContainer {
//    public static final EnumProperty<DoubleBlockHalf> field_208065_c = ShearableTallPlantBlock.PLANT_HALF;
//    protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
//
//    protected BYGWaterPlant(AbstractBlock.Settings p_i49970_1_) {
//        super(p_i49970_1_);
//    }
//
//    public VoxelShape getShape(BlockState state, BlockView worldIn, BlockPos pos, ISelectionContext context) {
//        return SHAPE;
//    }
//
//    protected boolean canPlantOnTop(BlockState state, BlockView worldIn, BlockPos pos) {
//        return state.isSolidSide(worldIn, pos, Direction.UP) && state.getBlock() != Blocks.MAGMA_BLOCK;
//    }
//
//    public ItemStack getItem(BlockView worldIn, BlockPos pos, BlockState state) {
//        return new ItemStack(BYGBlockList.CATTAIL);
//    }
//
//    //@Nullable
//    public BlockState getStateForDecorator(BlockItemUseContext context) {
//        BlockState blockstate = super.getStateForDecorator(context);
//        if (blockstate != null) {
//            IFluidState ifluidstate = context.getWorld().getFluidState(context.getPos().up());
//            if (ifluidstate.isIn(FluidTags.WATER) && ifluidstate.getLevel() == 8) {
//                return blockstate;
//            }
//        }
//
//        return null;
//    }
//
//    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
//        if (state.get(field_208065_c) == DoubleBlockHalf.LOWER) {
//            BlockState blockstate = worldIn.getBlockState(pos.down());
//            return blockstate.getBlock() == this && blockstate.get(field_208065_c) == DoubleBlockHalf.LOWER;
//        } else {
//            IFluidState ifluidstate = worldIn.getFluidState(pos);
//            return super.canPlaceAt(state, worldIn, pos) && ifluidstate.isIn(FluidTags.WATER) && ifluidstate.getLevel() == 8;
//        }
//    }
//
//    public IFluidState getFluidState(BlockState state) {
//        return Fluids.WATER.getStillFluidState(false);
//    }
//
//    public boolean canContainFluid(BlockView worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
//        return false;
//    }
//
//    public boolean receiveFluid(WorldAccess worldIn, BlockPos pos, BlockState state, IFluidState fluidStateIn) {
//        return false;
//    }
//
//}
