package voronoiaoc.byg.common.properties.blocks;

import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import voronoiaoc.byg.core.byglists.BYGBlockList;
import voronoiaoc.byg.core.byglists.BYGItemList;

import java.util.Random;

public class HangingVinesBlock extends Block {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 12.0D, 12.0D);

    protected HangingVinesBlock(AbstractBlock.Settings builder) {
        super(builder);

    }

    public Block.OffsetType getOffsetType() {
        return Block.OffsetType.XZ;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(worldIn, pos);
        return SHAPE.offset(vec3d.x, vec3d.y, vec3d.z);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.up()).getBlock() == Blocks.NETHERRACK || world.getBlockState(pos.up()).getMaterial() == Material.STONE;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.canPlaceAt(worldIn, currentPos)) {
            return Blocks.AIR.getDefaultState();
        } else {
            if (facing == Direction.DOWN && facingState.getBlock() == BYGBlockList.WEEPING_ROOTS_PLANT) {
                worldIn.setBlockState(currentPos, BYGBlockList.WEEPING_ROOTS_PLANT.getDefaultState(), 2);
            }

            return super.getStateForNeighborUpdate(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }
    }

    @Override
    public void randomDisplayTick(BlockState state, World worldIn, BlockPos pos, Random random) {
        if (random.nextInt(3) == 0 && worldIn.isAir(pos.down()) && worldIn.getBaseLightLevel(pos.down(), 0) <= 12) {
            this.isBlock(worldIn, pos);
        }
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(BYGItemList.WEEPING_ROOTS_PLANT);
    }

    public boolean canGrow(BlockView worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return worldIn.getBlockState(pos.down()).isAir();
    }


    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        this.isBlock(worldIn, pos);
    }

    protected void isBlock(World world, BlockPos pos) {
        world.setBlockState(pos.down(), BYGBlockList.WEEPING_ROOTS_PLANT.getDefaultState(), 3);
    }
}
