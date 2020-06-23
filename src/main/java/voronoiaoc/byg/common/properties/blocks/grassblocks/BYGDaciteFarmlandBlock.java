package voronoiaoc.byg.common.properties.blocks.grassblocks;//package voronoiaoc.byg.common.properties.blocks.grassblocks;
//
//import com.google.common.jimfs.PathType;
//import net.minecraft.block.*;
//import net.minecraft.entity.Entity;
//import net.minecraft.server.world.ServerWorld;
//import net.minecraft.state.property.IntProperty;
//import net.minecraft.tag.FluidTags;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.Direction;
//import net.minecraft.util.shape.VoxelShape;
//import net.minecraft.world.World;
//import net.minecraft.world.WorldAccess;
//import net.minecraft.world.WorldView;
////
//import java.util.Iterator;
//import java.util.Random;
//
//public class BYGDaciteFarmlandBlock extends FarmlandBlock {
//    public static IntProperty MOISTURE;
//    protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);
//
//    protected BYGDaciteFarmlandBlock(AbstractBlock.Settings builder) {
//        super(builder);
//        this.setDefaultState(this.stateManager.getDefaultState().with(MOISTURE, Integer.valueOf(0)));
//    }
//
//    public static void setToDirt(BlockState state, World worldIn, BlockPos pos) {
//        worldIn.setBlockState(pos, pushEntitiesUpBeforeBlockChange(state, BYGBlockList.DACITE.getDefaultState(), worldIn, pos));
//    }
//
//    private static boolean isWaterNearby(WorldView worldView, BlockPos pos) {
//        Iterator var2 = BlockPos.iterate(pos.add(-4, 0, -4), pos.add(4, 1, 4)).iterator();
//
//        BlockPos blockPos;
//        do {
//            if (!var2.hasNext()) {
//                return false;
//            }
//
//            blockPos = (BlockPos)var2.next();
//        } while(!worldView.getFluidState(blockPos).isIn(FluidTags.WATER));
//
//        return true;
//    }
//
//    /**
//     * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
//     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
//     * returns its solidified counterpart.
//     * Note that this method should ideally consider only the specific face passed in.
//     */
//    public BlockState updatePostDecorator(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
//        if (facing == Direction.UP && !stateIn.canPlaceAt(worldIn, currentPos)) {
//            worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 1);
//        }
//
//        return super.updatePostDecorator(stateIn, facing, facingState, worldIn, currentPos, facingPos);
//    }
//
//    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
//        BlockState blockstate = worldIn.getBlockState(pos.up());
//        return !blockstate.getMaterial().isSolid() || blockstate.getBlock() instanceof FenceGateBlock || blockstate.getBlock() instanceof MovingPistonBlock;
//    }
//
//    public BlockState getStateForDecorator(BlockItemUseContext context) {
//        return !this.getDefaultState().canPlaceAt(context.getWorld(), context.getPos()) ? BYGBlockList.DACITE.getDefaultState() : super.getStateForDecorator(context);
//    }
//
//    public boolean isTransparent(BlockState state) {
//        return true;
//    }
//
//    public VoxelShape getShape(BlockState state, BlockView worldIn, BlockPos pos, ISelectionContext context) {
//        return SHAPE;
//    }
//
//    public void randomDisplayTick(BlockState state, World worldIn, BlockPos pos, Random rand {
//        if (!state.canPlaceAt(worldIn, pos)) {
//            setToDirt(state, worldIn, pos);
//        } else {
//            int i = state.get(MOISTURE);
//            if (!isWaterNearby(worldIn, pos) && !worldIn.isRainingAt(pos.up())) {
//                if (i > 0) {
//                    worldIn.setBlockState(pos, state.with(MOISTURE, Integer.valueOf(i - 1)), 2);
//                } else if (!hasCrops(worldIn, pos)) {
//                    setToDirt(state, worldIn, pos);
//                }
//            } else if (i < 7) {
//                worldIn.setBlockState(pos, state.with(MOISTURE, Integer.valueOf(7)), 2);
//            }
//
//        }
//    }
//
//    /**
//     * Block's chance to react to a living entity falling on it.
//     */
//    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
//        if (!worldIn.isRemote && net.minecraftforge.common.ForgeHooks.onFarmlandTrample(worldIn, pos, BYGBlockList.DACITE.getDefaultState(), fallDistance, entityIn)) { // Forge: Move logic to Entity#canTrample
//            setToDirt(worldIn.getBlockState(pos), worldIn, pos);
//        }
//
//        super.onFallenUpon(worldIn, pos, entityIn, fallDistance);
//    }
//
//    private boolean hasCrops(BlockView worldIn, BlockPos pos) {
//        BlockState state = worldIn.getBlockState(pos.up());
//        return state.getBlock() instanceof net.minecraftforge.common.IPlantable && canSustainPlant(state, worldIn, pos, Direction.UP, (net.minecraftforge.common.IPlantable) state.getBlock());
//    }
//
//    protected void fillstateManager(stateManager.Builder<Block, BlockState> builder) {
//        builder.add(MOISTURE);
//    }
//
//    public boolean allowsMovement(BlockState state, BlockView worldIn, BlockPos pos, PathType type) {
//        return false;
//    }
//
////    public boolean isViewBlocking(BlockState state, BlockView worldIn, BlockPos pos) {
//        return true;
//    }
//}
