package voronoiaoc.byg.common.properties.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.properties.BambooLeaves;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.Tags;
import voronoiaoc.byg.core.byglists.BYGBlockList;
import voronoiaoc.byg.core.byglists.BYGItemList;

import java.util.Random;

public class HangingVinesBlock extends Block implements IGrowable {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 12.0D, 12.0D);

    protected HangingVinesBlock(Properties builder) {
        super(builder);

    }

    public Block.OffsetType getOffsetType() {
        return Block.OffsetType.XZ;
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Vec3d vec3d = state.getOffset(worldIn, pos);
        return SHAPE.withOffset(vec3d.x, vec3d.y, vec3d.z);
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return  worldIn.getBlockState(pos.up()).isIn(Tags.Blocks.NETHERRACK) || worldIn.getBlockState(pos.up()).isIn(Tags.Blocks.STONE);
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.isValidPosition(worldIn, currentPos)) {
            return Blocks.AIR.getDefaultState();
        } else {
            if (facing == Direction.DOWN && facingState.getBlock() == BYGBlockList.WEEPING_ROOTS_PLANT) {
                worldIn.setBlockState(currentPos, BYGBlockList.WEEPING_ROOTS_PLANT.getDefaultState(), 2);
            }

            return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (rand.nextInt(3) == 0 && worldIn.isAirBlock(pos.down()) && worldIn.getLightSubtracted(pos.down(), 0) <= 12) {
            this.func_220087_a(worldIn, pos);
        }
    }

    @Override
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(BYGItemList.WEEPING_ROOTS_PLANT);
    }

    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return worldIn.getBlockState(pos.down()).isAir();
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        this.func_220087_a(worldIn, pos);
    }

    protected void func_220087_a(World world, BlockPos pos) {
        world.setBlockState(pos.down(), BYGBlockList.WEEPING_ROOTS_PLANT.getDefaultState(), 3);
    }
}
