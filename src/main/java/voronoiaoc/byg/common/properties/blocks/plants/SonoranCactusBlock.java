package voronoiaoc.byg.common.properties.blocks.plants;//package voronoiaoc.byg.common.properties.blocks;
//
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.BYGBlockRenders;
//import net.minecraft.block.Material;
//import net.minecraft.entity.Entity;
//import net.minecraft.state.BooleanProperty;
//import net.minecraft.util.DamageSource;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.World;
//
//import java.util.Map;
//import java.util.Random;
//
//@SuppressWarnings("deprecation")
//public class SonoranCactusBlock extends Block {
//
//    public static final BooleanProperty NORTH = SixWayBlock.NORTH;
//    public static final BooleanProperty EAST = SixWayBlock.EAST;
//    public static final BooleanProperty SOUTH = SixWayBlock.SOUTH;
//    public static final BooleanProperty WEST = SixWayBlock.WEST;
//    public static final BooleanProperty UP = SixWayBlock.UP;
//    public static final BooleanProperty DOWN = SixWayBlock.DOWN;
//    public static final Map<Direction, BooleanProperty> FACING_TO_PROPERTY_MAP = SixWayBlock.FACING_TO_PROPERTY_MAP;
//
//    protected static final VoxelShape collisionShape = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D);
//    protected static final VoxelShape shape = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
//
//    public SonoranCactusBlock(String registryName) {
//        super(Block.properties.create(Material.CACTUS).tickRandomly().strength(0.4F).sound(SoundType.CLOTH));
//        setRegistryName(registryName);
//    }
//
//    public BlockState getStateForDecorator(BlockItemUseContext context) {
//        return this.makeConnections(context.getWorld(), context.getPos());
//    }
//
//    public BlockState makeConnections(BlockView reader, BlockPos pos) {
//        Block blockDown = reader.getBlockState(pos.down()).getBlock();
//        Block blockUp = reader.getBlockState(pos.up()).getBlock();
//        Block blockNorth = reader.getBlockState(pos.north()).getBlock();
//        Block blockEast = reader.getBlockState(pos.east()).getBlock();
//        Block blockSouth = reader.getBlockState(pos.south()).getBlock();
//        Block blockWest = reader.getBlockState(pos.west()).getBlock();
//        return this.getDefaultState().with(Direction.DOWN, Boolean.valueOf(blockDown == this || blockDown == Blocks.SAND)).with(Direction.UP, Boolean.valueOf(blockUp == this)).with(Direction.NORTH, Boolean.valueOf(blockNorth == this)).with(Direction.EAST, Boolean.valueOf(blockEast == this)).with(Direction.SOUTH, Boolean.valueOf(blockSouth == this)).with(Direction.WEST, Boolean.valueOf(blockWest == this));
//    }
//
//    @Override
//    public BlockState updatePostDecorator(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
//        if (!stateIn.canPlaceAt(worldIn, currentPos)) {
//            worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 1);
//        }
//
//        return super.updatePostDecorator(stateIn, facing, facingState, worldIn, currentPos, facingPos);
//    }
//
//    @Override
//    public void randomDisplayTick(BlockState state, World worldIn, BlockPos pos, Random rand {
//        if (!state.canPlaceAt(worldIn, pos)) {
//            worldIn.destroyBlock(pos, true);
//        }
//    }
//
//    @Override
//    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
//        int connectionsNorth = 0;
//        int connectionsSouth = 0;
//        int connectionsEast = 0;
//        int connectionsWest = 0;
//        boolean checkStemFlag = true;
//        for (Direction direction : Direction.Type.HORIZONTAL) {
//            if (worldIn.getBlockState(pos.offset(Direction.UP)).getBlock() == this
//                    && worldIn.getBlockState(pos.offset(direction)).getBlock() == this
//                    && worldIn.getBlockState(pos.offset(Direction.DOWN)).getBlock() == Blocks.SAND)
//                return false;
//
//
//            if (worldIn.getBlockState(pos.offset(Direction.DOWN)).getBlock() == this)
//                for (int idx = 0; idx < 3; idx++)
//                    if (worldIn.getBlockState(pos.offset(Direction.DOWN).offset(Direction.DOWN).offset(direction, idx)).getBlock() == this)
//                        checkStemFlag = false;
//        }
//
//        for (int idx = 1; idx <= 5; idx++) {
//            for (Direction direction : Direction.Type.HORIZONTAL) {
//                if (worldIn.getBlockState(pos.offset(direction, idx)).getBlock() == this) {
//                    if (direction == Direction.NORTH)
//                        connectionsNorth++;
//                    if (direction == Direction.SOUTH)
//                        connectionsSouth++;
//                    if (direction == Direction.EAST)
//                        connectionsEast++;
//                    if (direction == Direction.WEST)
//                        connectionsWest++;
//
//                }
//            }
//        }
//
//        int connectionsTotal = connectionsNorth + connectionsSouth + connectionsEast + connectionsWest;
//        if (connectionsNorth > 3 || connectionsSouth > 3 || connectionsEast > 3 || connectionsWest > 3 /*&& connectionsTotal > 5*/) {
//            return false;
//        }
//
//        if (!checkStemFlag)
//            return false;
//
//        return (
//                worldIn.getBlockState(pos.offset(Direction.NORTH)).getBlock() == this
//                        || worldIn.getBlockState(pos.offset(Direction.WEST)).getBlock() == this
//                        || worldIn.getBlockState(pos.offset(Direction.SOUTH)).getBlock() == this
//                        || worldIn.getBlockState(pos.offset(Direction.EAST)).getBlock() == this
//                        || worldIn.getBlockState(pos.offset(Direction.DOWN)).getBlock() == this
//                        || worldIn.getBlockState(pos.offset(Direction.WEST).offset(Direction.DOWN)).getBlock() == this
//                        || worldIn.getBlockState(pos.offset(Direction.SOUTH).offset(Direction.DOWN)).getBlock() == this
//                        || worldIn.getBlockState(pos.offset(Direction.EAST).offset(Direction.DOWN)).getBlock() == this
//                        || worldIn.getBlockState(pos.offset(Direction.NORTH).offset(Direction.DOWN)).getBlock() == this
//                        || worldIn.getBlockState(pos.offset(Direction.DOWN)).getBlock() == Blocks.SAND
//        );
//    }
//
//    @Override
//    protected void fillstateManager(stateManager.Builder<Block, BlockState> builder) {
//        builder.add(Direction.NORTH, EAST, SOUTH, WEST, UP, DOWN);
//    }
//
//    @Override
//    public boolean allowsMovement(BlockState state, BlockView worldIn, BlockPos pos, PathType type) {
//        return false;
//    }
//
//    @Override
//    public VoxelShape getCollisionShape(BlockState state, BlockView worldIn, BlockPos pos, ISelectionContext context) {
//        return collisionShape;
//    }
//
//    @Override
//    public VoxelShape getShape(BlockState state, BlockView worldIn, BlockPos pos, ISelectionContext context) {
//        return shape;
//    }
//
//    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
//        entityIn.attackEntityFrom(DamageSource.CACTUS, 1.0F);
//    }
//}
