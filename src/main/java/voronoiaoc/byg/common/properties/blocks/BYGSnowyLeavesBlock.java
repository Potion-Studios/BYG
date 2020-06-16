package voronoiaoc.byg.common.properties.blocks;//package sporeaoc.byg.common.bygAbstractBlock.Settings.blocks;
//
//import net.minecraft.block.*;
//import net.minecraft.block.material.Material;
////import net.minecraft.state.BooleanProperty;
////////import net.minecraft.util.math.BlockPos;
////import net.minecraftforge.common.IShearable;
//
//public class BYGSnowyLeavesBlock extends LeavesBlock implements IShearable {
//    public static final BooleanProperty SNOWY = Properties.SNOWY;
//    Block block;
//
//    public BYGSnowyLeavesBlock(String registryName) {
//        super(Block.properties.create(Material.LEAVES)
//                .strength(0.2F)
//                .tickRandomly()
//                .sound(SoundType.PLANT)
//                .notSolid());
//        setRegistryName(registryName);
//        this.setDefaultState(this.stateManager.getDefaultState().with(SNOWY, Boolean.valueOf(false)));
//        this.setDefaultState(this.stateManager.getDefaultState().with(DISTANCE, Integer.valueOf(7)).with(PERSISTENT, Boolean.valueOf(false)));
//    }
//    @Overrider
//    public BlockState updatePostDecorator(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
//        stateIn.with(SNOWY, Boolean.valueOf(true));
//        if (facing != Direction.UP) {
//            return super.updatePostDecorator(stateIn, facing, facingState, worldIn, currentPos, facingPos);
//        } else {
//            Block block = facingState.getBlock();
//            return stateIn.with(SNOWY, Boolean.valueOf(block == Blocks.SNOW_BLOCK || block == Blocks.SNOW));
//        }
//    }
//
//    public BlockState getStateForDecorator(BlockItemUseContext context) {
//        Block block = context.getWorld().getBlockState(context.getPos().up()).getBlock();
//        return this.getDefaultState().with(SNOWY, Boolean.valueOf(block == Blocks.SNOW_BLOCK || block == Blocks.SNOW));
//    }
//
//    protected void fillstateManager(stateManager.Builder<Block, BlockState> builder) {
//        builder.add(SNOWY);
//        builder.add(DISTANCE, PERSISTENT);
//
//    }
//}
