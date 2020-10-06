package corgiaoc.byg.common.properties.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Map;
import java.util.Random;

@SuppressWarnings("deprecation")
public class SonoranCactusBlock extends Block {

    public static final BooleanProperty NORTH = SixWayBlock.NORTH;
    public static final BooleanProperty EAST = SixWayBlock.EAST;
    public static final BooleanProperty SOUTH = SixWayBlock.SOUTH;
    public static final BooleanProperty WEST = SixWayBlock.WEST;
    public static final BooleanProperty UP = SixWayBlock.UP;
    public static final BooleanProperty DOWN = SixWayBlock.DOWN;
    public static final Map<Direction, BooleanProperty> FACING_TO_PROPERTY_MAP = SixWayBlock.FACING_TO_PROPERTY_MAP;

    protected static final VoxelShape collisionShape = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D);
    protected static final VoxelShape shape = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public SonoranCactusBlock(String registryName) {
        super(Block.Properties.create(Material.CACTUS).tickRandomly().hardnessAndResistance(0.4F).sound(SoundType.CLOTH));
        setRegistryName(registryName);
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.makeConnections(context.getWorld(), context.getPos());
    }

    public BlockState makeConnections(IBlockReader reader, BlockPos pos) {
        Block blockDown = reader.getBlockState(pos.down()).getBlock();
        Block blockUp = reader.getBlockState(pos.up()).getBlock();
        Block blockNorth = reader.getBlockState(pos.north()).getBlock();
        Block blockEast = reader.getBlockState(pos.east()).getBlock();
        Block blockSouth = reader.getBlockState(pos.south()).getBlock();
        Block blockWest = reader.getBlockState(pos.west()).getBlock();
        return this.getDefaultState().with(DOWN, Boolean.valueOf(blockDown == this || blockDown == Blocks.SAND)).with(UP, Boolean.valueOf(blockUp == this)).with(NORTH, Boolean.valueOf(blockNorth == this)).with(EAST, Boolean.valueOf(blockEast == this)).with(SOUTH, Boolean.valueOf(blockSouth == this)).with(WEST, Boolean.valueOf(blockWest == this));
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.isValidPosition(worldIn, currentPos)) {
            worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 1);
        }

        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (!state.isValidPosition(worldIn, pos)) {
            worldIn.destroyBlock(pos, true);
        }
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        int connectionsNorth = 0;
        int connectionsSouth = 0;
        int connectionsEast = 0;
        int connectionsWest = 0;
        boolean checkStemFlag = true;
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            if (worldIn.getBlockState(pos.offset(Direction.UP)).getBlock() == this
                    && worldIn.getBlockState(pos.offset(direction)).getBlock() == this
                    && worldIn.getBlockState(pos.offset(Direction.DOWN)).getBlock() == Blocks.SAND)
                return false;


            if (worldIn.getBlockState(pos.offset(Direction.DOWN)).getBlock() == this)
                for (int idx = 0; idx < 3; idx++)
                    if (worldIn.getBlockState(pos.offset(Direction.DOWN).offset(Direction.DOWN).offset(direction, idx)).getBlock() == this)
                        checkStemFlag = false;
        }

        for (int idx = 1; idx <= 5; idx++) {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                if (worldIn.getBlockState(pos.offset(direction, idx)).getBlock() == this) {
                    if (direction == Direction.NORTH)
                        connectionsNorth++;
                    if (direction == Direction.SOUTH)
                        connectionsSouth++;
                    if (direction == Direction.EAST)
                        connectionsEast++;
                    if (direction == Direction.WEST)
                        connectionsWest++;

                }
            }
        }

        int connectionsTotal = connectionsNorth + connectionsSouth + connectionsEast + connectionsWest;
        if (connectionsNorth > 3 || connectionsSouth > 3 || connectionsEast > 3 || connectionsWest > 3 /*&& connectionsTotal > 5*/) {
            return false;
        }

        if (!checkStemFlag)
            return false;

        return (
                worldIn.getBlockState(pos.offset(Direction.NORTH)).getBlock() == this
                        || worldIn.getBlockState(pos.offset(Direction.WEST)).getBlock() == this
                        || worldIn.getBlockState(pos.offset(Direction.SOUTH)).getBlock() == this
                        || worldIn.getBlockState(pos.offset(Direction.EAST)).getBlock() == this
                        || worldIn.getBlockState(pos.offset(Direction.DOWN)).getBlock() == this
                        || worldIn.getBlockState(pos.offset(Direction.WEST).offset(Direction.DOWN)).getBlock() == this
                        || worldIn.getBlockState(pos.offset(Direction.SOUTH).offset(Direction.DOWN)).getBlock() == this
                        || worldIn.getBlockState(pos.offset(Direction.EAST).offset(Direction.DOWN)).getBlock() == this
                        || worldIn.getBlockState(pos.offset(Direction.NORTH).offset(Direction.DOWN)).getBlock() == this
                        || worldIn.getBlockState(pos.offset(Direction.DOWN)).getBlock() == Blocks.SAND
        );
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
    }

    @Override
    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return false;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return collisionShape;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return shape;
    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.attackEntityFrom(DamageSource.CACTUS, 1.0F);
    }
}
