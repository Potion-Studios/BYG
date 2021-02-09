//package corgiaoc.byg.common.properties.blocks;
//
//import net.minecraft.block.*;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.ai.pathing.NavigationType;
//import net.minecraft.entity.damage.DamageSource;
//import net.minecraft.item.ItemPlacementContext;
//import net.minecraft.server.world.ServerWorld;
//import net.minecraft.sound.BlockSoundGroup;
//import net.minecraft.state.StateManager;
//import net.minecraft.state.property.BooleanProperty;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.Direction;
//import net.minecraft.util.shape.VoxelShape;
//import net.minecraft.world.BlockView;
//import net.minecraft.world.World;
//import net.minecraft.world.WorldAccess;
//import net.minecraft.world.WorldView;
//import java.util.Map;
//import java.util.Random;
//
//@SuppressWarnings("deprecation")
//public class SonoranCactusBlock extends Block {
//
//    public static final BooleanProperty NORTH = ConnectingBlock.NORTH;
//    public static final BooleanProperty EAST = ConnectingBlock.EAST;
//    public static final BooleanProperty SOUTH = ConnectingBlock.SOUTH;
//    public static final BooleanProperty WEST = ConnectingBlock.WEST;
//    public static final BooleanProperty UP = ConnectingBlock.UP;
//    public static final BooleanProperty DOWN = ConnectingBlock.DOWN;
//    public static final Map<Direction, BooleanProperty> FACING_TO_PROPERTY_MAP = ConnectingBlock.FACING_PROPERTIES;
//
//    protected static final VoxelShape collisionShape = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D);
//    protected static final VoxelShape shape = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
//
//    public SonoranCactusBlock(String registryName) {
//        super(FabricBlockSettings.of(Material.CACTUS).ticksRandomly().strength(0.4F).sounds(BlockSoundGroup.WOOL));
//        setRegistryName(registryName);
//    }
//
//    public BlockState getPlacementState(ItemPlacementContext context) {
//        return this.makeConnections(context.getWorld(), context.getBlockPos());
//    }
//
//    public BlockState makeConnections(BlockView reader, BlockPos pos) {
//        Block blockDown = reader.getBlockState(pos.down()).getBlock();
//        Block blockUp = reader.getBlockState(pos.up()).getBlock();
//        Block blockNorth = reader.getBlockState(pos.north()).getBlock();
//        Block blockEast = reader.getBlockState(pos.east()).getBlock();
//        Block blockSouth = reader.getBlockState(pos.south()).getBlock();
//        Block blockWest = reader.getBlockState(pos.west()).getBlock();
//        return this.getDefaultState().with(DOWN, Boolean.valueOf(blockDown == this || blockDown == Blocks.SAND)).with(UP, Boolean.valueOf(blockUp == this)).with(NORTH, Boolean.valueOf(blockNorth == this)).with(EAST, Boolean.valueOf(blockEast == this)).with(SOUTH, Boolean.valueOf(blockSouth == this)).with(WEST, Boolean.valueOf(blockWest == this));
//    }
//
//    @Override
//    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
//        if (!stateIn.canPlaceAt(worldIn, currentPos)) {
//            worldIn.getBlockTickScheduler().schedule(currentPos, this, 1);
//        }
//
//        return super.getStateForNeighborUpdate(stateIn, facing, facingState, worldIn, currentPos, facingPos);
//    }
//
//    @Override
//    public void scheduledTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
//        if (!state.canPlaceAt(worldIn, pos)) {
//            worldIn.breakBlock(pos, true);
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
//    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
//        builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
//    }
//
//    @Override
//    public boolean canPathfindThrough(BlockState state, BlockView worldIn, BlockPos pos, NavigationType type) {
//        return false;
//    }
//
//    @Override
//    public VoxelShape getCollisionShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
//        return collisionShape;
//    }
//
//    @Override
//    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
//        return shape;
//    }
//
//    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
//        entityIn.damage(DamageSource.CACTUS, 1.0F);
//    }
//}
